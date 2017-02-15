package me.moe.common.route;

import com.jfinal.config.Routes;

public class WeiXinRoutes extends Routes {

	@Override
	public void config() {
		// TODO Auto-generated method stub
		setBaseViewPath("/views/modules/weixin");
		//add("/msg", IndexController.class, "/msg");
//		add("/sys/user", UserController.class, "/user");
//		add("/sys/department", DepartmentController.class, "/department");
//		add("/sys/role", RoleController.class, "/role");
//		add("/sys/menu", MenuController.class, "/menu");
//		add("/sys/test", TestController.class, "/test");
		
	}

}
