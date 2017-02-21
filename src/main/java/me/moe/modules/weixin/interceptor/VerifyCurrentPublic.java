package me.moe.modules.weixin.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

import me.moe.modules.weixin.model.Public;

public class VerifyCurrentPublic implements Interceptor {

	@Override
	public void intercept(Invocation inv) {
		// TODO Auto-generated method stub
		Public publicapp = (Public)inv.getController().getSession().getAttribute("cache_wxpublic");
		if(publicapp == null){
			//System.out.println("---未登录---");
			//inv.getController().redirect("/login");
			inv.getController().setAttr("msg1", "登录失效请重新登录");
			inv.getController().forwardAction("/weixin/index/list");
		}else{
			inv.getController().setAttr("cache_wxPublicName", publicapp.getPublicName());
			inv.invoke();
		}
		
		
	}

}
