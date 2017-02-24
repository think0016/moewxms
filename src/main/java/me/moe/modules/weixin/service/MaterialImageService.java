package me.moe.modules.weixin.service;

import java.util.List;

import me.moe.modules.weixin.model.MaterialImage;

public class MaterialImageService {

	public List<MaterialImage> findListByToken(String token){
		String sql = "select * from `wx_material_image` where `token` = ? and is_use = 1";
		
		return MaterialImage.dao.find(sql, token);
	}
}
