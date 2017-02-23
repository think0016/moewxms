package me.moe.common.route;

import com.jfinal.config.Routes;

import me.moe.modules.weixin.controller.WeixinIndexController;
import me.moe.modules.weixin.controller.WeixinMaterialController;
import me.moe.modules.weixin.controller.WeixinMsgController;

public class WeiXinRoutes extends Routes {

	@Override
	public void config() {
		// TODO Auto-generated method stub
		setBaseViewPath("/views/modules/weixin");
		add("/weixin/msg", WeixinMsgController.class, "/msg");
		add("/weixin/index", WeixinIndexController.class, "/index");
		add("/weixin/material", WeixinMaterialController.class, "/material");
		// add("/api1",WeixinApi1Controller.class,"/api1");
		// add("/api2",WeixinApi2Controller.class,"/api2");
		
	}

}
