package me.moe.modules.weixin.controller;

import com.jfinal.aop.Before;

import me.moe.modules.weixin.interceptor.VerifyCurrentPublic;

/**
 * 素材管理控制器
 * @author liu
 *
 */
@Before({VerifyCurrentPublic.class})
public class WeixinMaterialController extends WeixinBaseController {
	public void index(){
		render("index.html");
	}
}
