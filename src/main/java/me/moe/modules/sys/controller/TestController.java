package me.moe.modules.sys.controller;

import com.jfinal.aop.Clear;
import com.jfinal.core.Controller;

@Clear
public class TestController extends Controller {
	
	public void index(){
//		renderText("TESTINDEX");
		render("index.html");
	}
	
	public void test(){
		renderText("IJIJIJIJIJI");
	}
}
