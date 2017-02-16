package me.moe.modules.weixin.controller;

import com.jfinal.weixin.sdk.api.ApiConfig;
import com.jfinal.weixin.sdk.api.ApiResult;
import com.jfinal.weixin.sdk.api.MessageApi;
import com.jfinal.weixin.sdk.jfinal.ApiController;

import me.moe.modules.weixin.service.PublicService;

public class WeixinApi2Controller extends ApiController {

	public ApiConfig getApiConfig() {
		// TODO Auto-generated method stub
		String id = "96d0628b4a1844c58ab2b6baedf77be6";
		PublicService ps = new PublicService();
		return ps.getApiConfig(id);
	}

	public void sendjkmsg(){
		String jsonStr = "{\"filter\":{\"is_to_all\":true},\"text\":{\"content\":\"JK\"},\"msgtype\":\"text\"}";
		ApiResult apiResult = MessageApi.sendAll(jsonStr);
		renderText(apiResult.getJson());
	}
}
