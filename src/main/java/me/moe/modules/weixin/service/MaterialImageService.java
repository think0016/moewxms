package me.moe.modules.weixin.service;

import java.util.ArrayList;
import java.util.List;

import me.moe.common.utils.CommonTools;
import me.moe.modules.weixin.model.MaterialImage;

public class MaterialImageService {

	public MaterialImage findMaterialImageById(String id){
		return MaterialImage.dao.findById(id);
	}
	
	public List<MaterialImage> findListByToken(String token){
		String sql = "select * from `wx_material_image` where `token` = ? and is_use = 1";		
		return MaterialImage.dao.find(sql, token);
	}
	
	public Long save(MaterialImage materialImage){
		Long id = 0L;
		if(materialImage.save()){
			id = materialImage.getId();
		}
		return id;
	}
	
	public List<String[]> gettabledataArray(String token){
		List<MaterialImage> list = this.findListByToken(token);
		List<String[]> rs = new ArrayList<String[]>();
		
		for (int i = 0; i < list.size(); i++) {
			MaterialImage temp =list.get(i);
			
			String id = temp.getId().toString();
			String mname = temp.getMname();
			String createdate = CommonTools.dateTostring("yyyy-MM-dd HH:mm:ss", temp.getCreatedate());
			String url = temp.getFileUrl();
			
			String[] temp_arr = {mname,url,createdate,id};
			rs.add(temp_arr);
		}
		return rs;
	}
	
	public boolean delete(MaterialImage mi){
		mi.setIsUse(new Integer(0));	
		return mi.update();
	}
	
	public boolean delete(String id){
		MaterialImage mi = this.findMaterialImageById(id);
		mi.setIsUse(new Integer(0));		
		return mi.update();
	}
}
