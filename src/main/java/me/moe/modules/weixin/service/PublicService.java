package me.moe.modules.weixin.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.jfinal.kit.PropKit;
import com.jfinal.weixin.sdk.api.ApiConfig;

import me.moe.modules.weixin.model.Public;

public class PublicService {
	
	public Public findPublicById(String id){
		//String sql = "select * from wx_public where id = ?";		
		return Public.dao.findById(id);
	}
	
	public List<Public> findPublicByUid(Integer uid){
		String sql = "select * from wx_public where uid = ?";
		return Public.dao.find(sql, uid);
	}	
	
	public Public findPublicByPublicid(String publicid){
		String sql = "select * from wx_public where public_id = ?";		
		return Public.dao.findFirst(sql, publicid);		
	}
	
	public boolean deletepublic(String id){
		return Public.dao.deleteById(id);
	}
	
	public ApiConfig getApiConfig(String id) {
		ApiConfig ac = new ApiConfig();

		Public publicapp = Public.dao.findById(id);
		if (publicapp != null) {
			ac.setAppId(publicapp.getAppid());
			ac.setAppSecret(publicapp.getSecret());
			ac.setToken(PropKit.get("weixin_token", "moewxms"));
			
			if (publicapp.getIsencryptMessage() == 1 && StringUtils.isNotEmpty(publicapp.getEncodingaeskey())) {
				ac.setEncryptMessage(true);
				ac.setEncodingAesKey(publicapp.getEncodingaeskey());
			}else{
				ac.setEncryptMessage(false);
				ac.setEncodingAesKey("null");
			}

		}

		return ac;
	}
}
