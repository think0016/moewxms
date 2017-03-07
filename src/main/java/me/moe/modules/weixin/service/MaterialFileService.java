package me.moe.modules.weixin.service;

import java.util.ArrayList;
import java.util.List;

import me.moe.common.utils.CommonTools;
import me.moe.modules.weixin.model.MaterialFile;
import me.moe.modules.weixin.model.MaterialImage;

public class MaterialFileService {

	public List<MaterialFile> findListByToken(String token){
		String sql = "select * from `wx_material_file` where `token` = ? and is_use = 1";
		return MaterialFile.dao.find(sql, token);
	}
	
	public List<MaterialFile> findVideoListByToken(String token){
		String sql = "select * from `wx_material_file` where `token` = ? and is_use = 1 and type = 1";
		return MaterialFile.dao.find(sql, token);
	}
	
	public List<MaterialFile> findVoiceListByToken(String token){
		String sql = "select * from `wx_material_file` where `token` = ? and is_use = 1 and type = 0";
		return MaterialFile.dao.find(sql, token);
	}
	
	public Long save(MaterialFile materialFile){
		Long id = 0L;
		if(materialFile.save()){
			id = materialFile.getId();
		}
		return id;
	}
	
	public List<String[]> gettabledataArray(String token,int type){
		//List<MaterialFile> list = this.findListByToken(token);
		List<MaterialFile> list = null;
		if(type == 0){
			list = this.findVoiceListByToken(token);
		}else{
			list = this.findVideoListByToken(token);
		}
		
		List<String[]> rs = new ArrayList<String[]>();
		
		for (int i = 0; i < list.size(); i++) {
			MaterialFile temp =list.get(i);
			
			String id = temp.getId().toString();
			String mname = temp.getMname();
			String createdate = CommonTools.dateTostring("yyyy-MM-dd HH:mm:ss", temp.getCreatedate());
			String url = temp.getFileUrl();
			
			String[] temp_arr = {mname,url,createdate,id};
			rs.add(temp_arr);
		}
		return rs;
	}
}
