package me.moe.modules.weixin.controller;

import com.jfinal.weixin.sdk.api.ApiConfig;
import com.jfinal.weixin.sdk.jfinal.ApiController;

import me.moe.modules.weixin.model.Public;
import me.moe.modules.weixin.service.PublicService;

/**
 * 微信控制器基类
 * @author liu
 *
 */
public class WeixinBaseController extends ApiController {
	private PublicService publicService = new PublicService();
	protected String current_token = "";
	
	
	@Override
	public ApiConfig getApiConfig() {
		// TODO Auto-generated method stub
		Public publicapp = (Public)getSession().getAttribute("cache_wxpublic");
		if(publicapp != null){
			this.current_token = publicapp.getToken();
		}
		
//		String id = "96d0628b4a1844c58ab2b6baedf77be6";
//		PublicService ps = new PublicService();
		return publicService.getApiConfig(publicapp);
	}

	
}
