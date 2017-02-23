package me.moe.modules.weixin.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

import com.google.gson.Gson;
import com.jfinal.plugin.ehcache.CacheKit;

import me.moe.common.utils.UUIDGenerator;
import me.moe.model.User;
import me.moe.modules.weixin.model.Public;
import me.moe.modules.weixin.service.PublicService;

public class WeixinIndexController extends WeixinBaseController {
	private PublicService publicService = new PublicService();

	public void index() {
		User cuser = (User) getSession().getAttribute("cache_user");
		String publicappid = getPara(0);
		Public publicapp =new Public();
		if(StringUtils.isNotEmpty(publicappid)){
			publicapp = publicService.findPublicById(publicappid);
			getSession().setAttribute("cache_wxpublic", publicapp);
			String key = "cache_wxpublic_"+cuser.getUid();
			CacheKit.put("session", key, publicapp);
			setAttr("cache_wxPublicName", publicapp.getPublicName());
		}
		render("index.html");
	}

	public void list() {
		User cuser = (User) getSession().getAttribute("cache_user");

		List<Public> publiclist = publicService.findPublicByUid(cuser.getUid());
		setAttr("plist", publiclist);
		render("list.html");
	}

	public void form() {
		// setAttr("path", getRequest().getScheme() + "://"+
		// getRequest().getServerName() + getRequest().getContextPath());
		String publicappid = getPara(0);
		
		String update = "0";
		Public publicapp = new Public();
		if(StringUtils.isNotEmpty(publicappid)){
			update = "1";
			publicapp = publicService.findPublicById(publicappid);			
			setAttr("subtitle", "修改公众号");
		}else{
			setAttr("subtitle", "新增公众号");
		}
		setAttr("publicapp", publicapp);
		setAttr("update", update);
		render("addform.html");
	}

	public void savepiblic() {
		boolean flag = false;
		User cuser = (User) getSession().getAttribute("cache_user");
		String pid = getPara("pid");
		String appid = getPara("appid");
		String appsecret = getPara("appsecret");
		String encodingaeskey = getPara("encodingaeskey");
		String publicname = getPara("publicname");
		String publicid = getPara("publicid");
		String wechat = getPara("wechat");
		String update = getPara("update");
		String interfaceUrl = getPara("interfaceUrl");

		Public publicapp = new Public();
		publicapp.setId(pid);
		publicapp.setUid(cuser.getUid());
		publicapp.setPublicName(publicname);
		publicapp.setPublicId(publicid);
		publicapp.setWechat(wechat);
		publicapp.setAppid(appid);
		publicapp.setSecret(appsecret);
		publicapp.setInterfaceUrl(interfaceUrl);
		publicapp.setCreatedate(new Date());
		if (StringUtils.isNotEmpty(encodingaeskey)) {
			publicapp.setIsencryptMessage(1);
			publicapp.setEncodingaeskey(encodingaeskey);
		}
		
		if("0".equals(update)){
			flag = publicapp.save();
		}else{
			flag = publicapp.update();
		}		
		
		if (flag) {
			renderText("1");
		} else {
			renderText("0");
		}

	}

	/**
	 * 验证原始ID是否已经使用
	 */
	public void yzpublicid() {
		String publicid = getPara("publicid");
		Public publicapp = publicService.findPublicByPublicid(publicid);
		if (publicapp == null) {
			renderText("0");
		} else {
			renderText("1");
		}
	}

	public void deletepublic() {
		String id = getPara("id");
		if (publicService.deletepublic(id)) {
			renderText("1");
		} else {
			renderText("0");
		}
	}

	/**
	 * 获取一个uuid同时生成msgurl
	 */
	public void getpid() {
		String uuid = UUIDGenerator.getUUID();
		HttpServletRequest request = getRequest();
		String msgurl = request.getScheme() + "://" + request.getServerName() + request.getContextPath() + "/weixin/msg/"
				+ uuid;
		HashMap<String, String> rs = new HashMap<String, String>();
		rs.put("id", uuid);
		rs.put("msgurl", msgurl);

		Gson gson = new Gson();
		String json = gson.toJson(rs);
		renderText(json);
	}

}
