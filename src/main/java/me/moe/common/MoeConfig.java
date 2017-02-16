package me.moe.common;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.ext.handler.ContextPathHandler;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.plugin.ehcache.EhCachePlugin;
import com.jfinal.render.ViewType;
import com.jfinal.template.Engine;

import me.moe.common.route.SystemRoutes;
import me.moe.common.route.WeiXinRoutes;
import me.moe.model._MappingKit;
import me.moe.modules.sys.interceptor.CommonHandler;
import me.moe.modules.sys.interceptor.VerifyLoginInterceptor;
import me.moe.modules.weixin.model.Wx_MappingKit;


public class MoeConfig extends JFinalConfig {

	@Override
	public void configConstant(Constants me) {
		PropKit.use("commoncfg.properties");
		me.setDevMode(PropKit.getBoolean("devMode", false));
		me.setViewType(ViewType.FREE_MARKER);	
	}

	@Override
	public void configEngine(Engine me) {

	}

	@Override
	public void configHandler(Handlers me) {
		me.add(new ContextPathHandler("ctxroot"));
		//me.add(new MenuHandler());
		me.add(new CommonHandler());
	}

	@Override
	public void configInterceptor(Interceptors me) {
		me.add(new VerifyLoginInterceptor());
	}

	@Override
	public void configPlugin(Plugins me) {
		// ehcache缓存插件
        me.add(new EhCachePlugin());
		
		// 配置C3p0数据库连接池插件
		C3p0Plugin C3p0Plugin = createC3p0Plugin();
		me.add(C3p0Plugin);
		
		// 配置ActiveRecord插件
		ActiveRecordPlugin arp = new ActiveRecordPlugin(C3p0Plugin);
		me.add(arp);
		//输出SQL语句(测试)
		//arp.setShowSql(true);
		// 所有配置在 MappingKit 中搞定
		_MappingKit.mapping(arp);
		Wx_MappingKit.mapping(arp);
	}

	@Override
	public void configRoute(Routes me) {
		
//		me.setBaseViewPath("/views/modules");
//		me.add("/", IndexController.class, "/sys/index");	// 第三个参数为该Controller的视图存放路径
//		me.add("/user", UserController.class, "/sys/user");
//		me.add("/department", DepartmentController.class, "/sys/department");
//		me.add("/role", RoleController.class, "/sys/role");
//		me.add("/menu", MenuController.class, "/sys/menu");
		me.add(new SystemRoutes());
		me.add(new WeiXinRoutes());
//		me.setBaseViewPath("/temp");
//		me.add("/test", TestController.class);
		
	}

	public static C3p0Plugin createC3p0Plugin() {
		
		return new C3p0Plugin(PropKit.get("jdbcUrl"), PropKit.get("user"), PropKit.get("password").trim());
		
	}
}
