package me.moe.common.route;

import com.jfinal.config.Routes;

import me.moe.modules.sys.controller.DepartmentController;
import me.moe.modules.sys.controller.IndexController;
import me.moe.modules.sys.controller.MenuController;
import me.moe.modules.sys.controller.RoleController;
import me.moe.modules.sys.controller.TestController;
import me.moe.modules.sys.controller.UserController;

public class SystemRoutes extends Routes {

	@Override
	public void config() {
		// TODO Auto-generated method stub
		setBaseViewPath("/views/modules/sys");
		add("/", IndexController.class, "/index");	// 第三个参数为该Controller的视图存放路径
		add("/sys", IndexController.class, "/index");	// 第三个参数为该Controller的视图存放路径
		add("/sys/user", UserController.class, "/user");
		add("/sys/department", DepartmentController.class, "/department");
		add("/sys/role", RoleController.class, "/role");
		add("/sys/menu", MenuController.class, "/menu");
		add("/sys/test", TestController.class, "/test");
		
	}

}
