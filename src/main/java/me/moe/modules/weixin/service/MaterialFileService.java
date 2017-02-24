package me.moe.modules.weixin.service;

import java.util.List;

import me.moe.modules.weixin.model.MaterialFile;

public class MaterialFileService {

	public List<MaterialFile> findListByToken(String token){
		String sql = "select * from `wx_material_text` where `token` = ? and is_use = 1";
		
		return MaterialFile.dao.find(sql, token);
	}
	
	
}
