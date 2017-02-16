package me.moe.common.route;

import com.jfinal.config.Routes;

import me.moe.modules.weixin.controller.WeixinApi1Controller;
import me.moe.modules.weixin.controller.WeixinApi2Controller;
import me.moe.modules.weixin.controller.WeixinMsgController;

public class WeiXinRoutes extends Routes {

	@Override
	public void config() {
		// TODO Auto-generated method stub
		setBaseViewPath("/views/modules/weixin");
		add("/msg", WeixinMsgController.class, "/msg");
		add("/api1",WeixinApi1Controller.class,"/api1");
		add("/api2",WeixinApi2Controller.class,"/api2");
//		add("/sys/user", UserController.class, "/user");
//		add("/sys/department", DepartmentController.class, "/department");
//		add("/sys/role", RoleController.class, "/role");
//		add("/sys/menu", MenuController.class, "/menu");
//		add("/sys/test", TestController.class, "/test");
		
	}

}
