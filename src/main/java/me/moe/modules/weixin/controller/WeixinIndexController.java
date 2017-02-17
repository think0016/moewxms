package me.moe.modules.weixin.controller;

import java.util.HashMap;
import java.util.List;

import com.google.gson.Gson;

import me.moe.common.utils.UUIDGenerator;
import me.moe.model.User;
import me.moe.modules.weixin.model.Public;
import me.moe.modules.weixin.service.PublicService;

public class WeixinIndexController extends WeixinBaseController {
	private PublicService publicService = new PublicService();
	
	
	public void index(){
		
		render("index.html");
	}
	
	public void list(){
		User cuser = (User) getSession().getAttribute("cache_user");
		
		List<Public> publiclist = publicService.getPublicByUid(cuser.getUid());
		setAttr("plist", publiclist);
		render("list.html");
	}
	
	public void form(){
		
		setAttr("subtitle", "新增公众号");
		
		render("addform.html");		
	}
	
	/**
	 * 获取一个uuid
	 */
	public void getpid(){
		HashMap<String, String> rs = new HashMap<String, String>();
		rs.put("id", UUIDGenerator.getUUID());
		Gson gson = new Gson();
		String json = gson.toJson(rs);
		renderText(json);		
	}
	
}
