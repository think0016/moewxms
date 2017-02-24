package me.moe.modules.weixin.service;

import java.util.List;

import me.moe.modules.weixin.model.MaterialNews;

public class MaterialNewsService {

	public List<MaterialNews> findListByToken(String token){
		String sql = "select * from `wx_material_text` where `token` = ? and is_use = 1";
		
		return MaterialNews.dao.find(sql, token);
	}
}
