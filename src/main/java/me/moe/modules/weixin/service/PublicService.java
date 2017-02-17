package me.moe.modules.weixin.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.jfinal.kit.PropKit;
import com.jfinal.weixin.sdk.api.ApiConfig;

import me.moe.modules.weixin.model.Public;

public class PublicService {
	
	public List<Public> getPublicByUid(Integer uid){
		String sql = "select * from wx_public where uid = ?";
		return Public.dao.find(sql, uid);
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