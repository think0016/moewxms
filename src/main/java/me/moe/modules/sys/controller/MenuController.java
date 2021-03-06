package me.moe.modules.sys.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.google.gson.Gson;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.plugin.ehcache.CacheKit;

import me.moe.common.utils.UrlEncoderUtils;
import me.moe.model.Menu;
import me.moe.model.User;
import me.moe.model.common.TreeNode;
import me.moe.modules.sys.interceptor.AuthenticationValidator;
import me.moe.modules.sys.service.MenuService;

public class MenuController extends Controller {

	public static final MenuService menuService = new MenuService();

	public void index() {
		redirect("/sys/menu/list");
	}

	@Before({ AuthenticationValidator.class })
	public void list() {

		String msgtype = getPara(0);

		if (!StringUtils.isEmpty(msgtype)) {
			String msg = UrlEncoderUtils.decode(getPara(1), "utf-8");
			if ("1".equals(msgtype)) {// 正常信息
				setAttr("infomsg", msg);
			} else {
				setAttr("errormsg", msg);
			}
		}

		// 菜单树信息
		List<Menu> list = new ArrayList<Menu>();
		MenuService.sortList(list, menuService.findAllMenu(), 0, true);

		// List<TreeNode> nodes = menuService.gettreedata(mlist);
		// Gson gson = new Gson();
		// String json = gson.toJson(nodes);

		// setAttr("treejson", json);
		setAttr("menulist", list);
		render("list.html");
	}

	@Before({ AuthenticationValidator.class })
	public void form() {
		String menuid = getPara(0);
		String type = getPara(1);// 是否在下级添加
		String subtitle = "菜单添加";

		Menu menu = new Menu();
		if (!StringUtils.isEmpty(menuid)) {
			menu = menuService.findMenuById(menuid);
			if ("0".equals(type)) {
				setAttr("pmenuname", menuService.findMenuById(menu.getParentId().toString()).getMname());
				setAttr("pmenuid", menuService.findMenuById(menu.getParentId().toString()).getMenuid());
				subtitle = "菜单修改";
			} else {
				setAttr("pmenuname", menu.getMname());
				setAttr("pmenuid", menu.getMenuid());
				menu = new Menu();
			}

		}
		// 菜单树信息
		List<Menu> mlist = menuService.findAllMenu();
		List<TreeNode> nodes = menuService.gettreedata(mlist);
		Gson gson = new Gson();
		String json = gson.toJson(nodes);

		setAttr("menu", menu);
		setAttr("treejson", json);
		setAttr("subtitle", subtitle);
		render("form.html");
	}

	public void savemenu() {
		User cuser = (User) getSession().getAttribute("cache_user");

		String menuid = getPara("menuid");
		String pmenuid = getPara("pmenuid");
		String mname = getPara("mname");
		String href = getPara("href");
		String sort = getPara("sort");
		String mtype = getPara("mtype");
		String remarks = getPara("remarks");

		if (StringUtils.isEmpty(sort)) {
			sort = "30";
		}
		boolean update = false;
		Menu menu = new Menu();
		if (!StringUtils.isEmpty(menuid)) {
			menu = menuService.findMenuById(menuid);
			update = true;
		}

		// 获取pidpath
		Menu p_menu = menuService.findMenuById(pmenuid);
		String pidpath = p_menu.getParentIds() + "," + pmenuid;

		menu.setMname(mname);
		menu.setHref(href);
		menu.setParentId(new Integer(pmenuid));
		menu.setParentIds(pidpath);
		menu.setSort(new Integer(sort));
		menu.setMtype(new Integer(mtype));
		menu.setRemarks(remarks);
		if (!update) {
			menu.setCreateBy(cuser.getUid());
			menu.setCreateDate(new Date());
		}

		boolean flag = menuService.save(menu, update);

		// 清除缓存
		CacheKit.removeAll("menulist");

		if (flag) {
			// setAttr("infomsg", "添加成功");
			// forwardAction("/sys/menu/list");
			String url = "/sys/menu/list/1-";
			if (update) {
				url = url + UrlEncoderUtils.encode("修改成功", "utf-8");
			} else {
				url = url + UrlEncoderUtils.encode("添加成功", "utf-8");
			}
			redirect(url);
		} else {
			keepPara();
			if (update) {
				setAttr("errormsg", "修改失败");
			} else {
				setAttr("errormsg", "添加失败");
			}
			
			forwardAction("/sys/menu/form");
		}
	}

	public void delete() {
		String menuid = getPara("menuid");
		if(StringUtils.isEmpty(menuid)){
			renderText("2");
		}else{
			boolean flag = menuService.delete(menuid);
			// 清除缓存
			CacheKit.removeAll("menulist");
			if (flag) {
				renderText("1");
			} else {
				renderText("2");
			}
		}

	}
}
