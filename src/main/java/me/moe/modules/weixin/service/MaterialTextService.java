package me.moe.modules.weixin.service;

import java.util.ArrayList;
import java.util.List;

import me.moe.common.utils.CommonTools;
import me.moe.modules.weixin.model.MaterialText;

public class MaterialTextService {

	public MaterialText findMaterialTextById(String id){
		return MaterialText.dao.findById(id);		
	}
	
	public List<MaterialText> findListByToken(String token){
		String sql = "select * from `wx_material_text` where `token` = ? and is_use = 1";
		
		return MaterialText.dao.find(sql, token);
	}
	
	public List<String[]> gettabledataArray(String token){
		List<MaterialText> list = this.findListByToken(token);
		List<String[]> rs = new ArrayList<String[]>();
		
		for (int i = 0; i < list.size(); i++) {
			MaterialText temp =list.get(i);
			
			String id = temp.getId().toString();
			String mname = temp.getMname();
			String createdate = CommonTools.dateTostring("yyyy-MM-dd HH:mm:ss", temp.getCreatedate());
			String content = temp.getContent();
			
			String[] temp_arr = {mname,content,createdate,id};
			rs.add(temp_arr);
		}
		return rs;
	}
	
	public boolean delete(String id){
		MaterialText mt = this.findMaterialTextById(id);
		mt.setIsUse(new Integer(0));		
		return mt.update();
	}
}
