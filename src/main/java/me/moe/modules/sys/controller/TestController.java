package me.moe.modules.sys.controller;

import javax.servlet.http.HttpServletRequest;

import com.jfinal.aop.Clear;
import com.jfinal.core.Controller;

import me.moe.modules.weixin.model.Public;

//import me.moe.modules.weixin.model.bean.Welcome;

@Clear
public class TestController extends Controller {
	
	public void index(){
//		renderText("TESTINDEX");
		renderText("index.html");
	}
	
	public void test(){
		HttpServletRequest request = getRequest();
		String path = request.getContextPath();
        String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";  
		
		renderText(basePath);
	}
	
	public static void main(String[] args) {
//		Gson gson = new Gson();
//		Welcome w = new Welcome();
//		w.setItemid(33);
//		w.setItemtype("text");
//		
//		String sss=gson.toJson(w);
//		
//		System.out.println(sss);
//		String str = "{\"itemtype\":\"text\",\"itemid\":33}";
//		Welcome wx = gson.fromJson(str, Welcome.class);
//		System.out.println(wx.getItemtype()+"   "+wx.getItemid());
//		
//		HashMap hm = gson.fromJson(str, HashMap.class);
//		System.out.println(hm.get("itemid"));
		
	}
}
