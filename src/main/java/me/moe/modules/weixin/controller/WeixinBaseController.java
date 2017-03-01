package me.moe.modules.weixin.controller;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.jfinal.core.JFinal;
import com.jfinal.weixin.sdk.api.ApiConfig;
import com.jfinal.weixin.sdk.jfinal.ApiController;

import me.moe.common.utils.CommonTools;
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

	
	/**
	 * 按照要求获取上传文件路径信息
	 * path 完整物理路径
	 * url 相对路径（用于html访问）
	 * @param filename
	 * @return
	 */
	protected Map<String,String> getUploadPathInfo(String filename){
		Map<String,String> map = new HashMap<String,String>();
		String rootpath = JFinal.me().getServletContext().getRealPath("upload/weixin") + File.separatorChar;
		String middlepath = CommonTools.dateTostring("yyyyMMdd", new Date());
		String path = rootpath + middlepath + File.separatorChar;
		String url = middlepath + "/" + filename;
		
		map.put("filename", filename);
		map.put("path", path + filename);
		map.put("url", url);
		return map;
	}
	
	
}
