package me.moe.modules.sys.controller;

import java.util.Date;

import com.jfinal.aop.Before;
import com.jfinal.aop.Clear;
import com.jfinal.core.Controller;
import com.jfinal.plugin.ehcache.CacheKit;

import me.moe.model.User;
import me.moe.modules.sys.interceptor.LoginValidator;
import me.moe.modules.sys.service.SystemService;
import me.moe.modules.sys.service.UserService;

public class IndexController extends Controller {
	public static final UserService userService = new UserService();

	public void index() {
		
		render("index.html");
	}

	@Clear
	public void login() {
		render("login.html");
	}

	@Clear
	@Before(LoginValidator.class)
	public void login1() {
		String loginname = getPara("loginname");
		String password = getPara("password");

		User user = userService.findByloginname(loginname);
		if (user == null || !SystemService.validatePassword(password, user.getPassword())) {
			setAttr("msg1", "用户名或密码不正确");
			// setAttr("msg1", "用户名或密码不正确");
			keepPara();
			// forwardAction("/login");
			render("login.html");
		} else {
			// renderText(user.getTurename()+"登陆成功");
			if(user.getStatus().intValue() == 1){
				user.setLogindate(new Date());
				user.update();
				getSession().setAttribute("cache_user", user);
				getSession().setAttribute("cache_cusername", user.getTurename());
				getSession().setAttribute("isAdmin", userService.isAdmin(user));
				CacheKit.put("userlist", user.getUid().toString(), user);
				// forwardAction("/");
				redirect("/");
			}else{
				//已冻结或者不存在
				setAttr("msg1", "该账号已冻结！");
				keepPara();
				// forwardAction("/login");
				render("login.html");
			}

		}

	}

	@Clear
	public void logout() {
		getSession().removeAttribute("cache_user");
		getSession().removeAttribute("cache_cusername");
		getSession().removeAttribute("isAdmin");
		// redirect("/login");
		setAttr("msg1", "您已经安全退出系统");
		render("login.html");
	}

	/**
	 * 权限不足页面
	 */
	public void forbidpage() {
		render("forbidpage.html");
	}
}
