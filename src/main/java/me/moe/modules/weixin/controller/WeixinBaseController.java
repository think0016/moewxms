package me.moe.modules.weixin.controller;

import com.jfinal.weixin.sdk.api.ApiConfig;
import com.jfinal.weixin.sdk.jfinal.ApiController;

import me.moe.modules.weixin.service.PublicService;

/**
 * 微信控制器基类
 * @author liu
 *
 */
public class WeixinBaseController extends ApiController {

	@Override
	public ApiConfig getApiConfig() {
		// TODO Auto-generated method stub
		String id = "96d0628b4a1844c58ab2b6baedf77be6";
		PublicService ps = new PublicService();
		return ps.getApiConfig(id);
	}

	
}
