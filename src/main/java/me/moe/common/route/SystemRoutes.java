package me.moe.common.route;

import com.jfinal.config.Routes;

import me.moe.modules.sys.controller.DepartmentController;
import me.moe.modules.sys.controller.IndexController;
import me.moe.modules.sys.controller.MenuController;
import me.moe.modules.sys.controller.RoleController;
import me.moe.modules.sys.controller.UserController;

public class SystemRoutes extends Routes {

	@Override
	public void config() {
		// TODO Auto-generated method stub
		setBaseViewPath("/views/modules/sys");
		add("/", IndexController.class, "/index");	// 第三个参数为该Controller的视图存放路径
		add("/user", UserController.class, "/user");
		add("/department", DepartmentController.class, "/department");
		add("/role", RoleController.class, "/role");
		add("/menu", MenuController.class, "/menu");
		
	}

}
