package me.moe.modules.weixin.controller;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.jfinal.aop.Before;

import me.moe.modules.weixin.interceptor.VerifyCurrentPublic;
import me.moe.modules.weixin.service.MaterialTextService;

/**
 * 素材管理控制器
 * 
 * @author liu
 *
 */
public class WeixinMaterialController extends WeixinBaseController {
	private MaterialTextService materialTextService = new MaterialTextService();
	private Gson gson = new Gson();

	@Before({ VerifyCurrentPublic.class })
	public void index() {

		// List<MaterialText> mtextlist=
		// materialTextService.findListByToken(this.current_token);

		render("index.html");
	}

	@Before({ VerifyCurrentPublic.class })
	public void getmlist() {
		// Public publicapp =
		// (Public)getSession().getAttribute("cache_wxpublic");
		// if(publicapp == null){
		// System.out.println("publicapp is null");
		// }else{
		// System.out.println("publicapp is NOT null");
		// }

		String type = getPara("type");
		//DatatablesArray datatablesArray = new DatatablesArray();
		List<String[]> rs = new ArrayList<String[]>();
		if ("text".equals(type)) {
			rs = materialTextService.gettabledataArray(this.current_token);
			//datatablesArray.setData(rs);
		} else if ("image".equals(type)) {

		} else if ("voice".equals(type)) {

		} else if ("video".equals(type)) {

		} else if ("news".equals(type)) {

		}

		renderText(gson.toJson(rs));

	}
}
