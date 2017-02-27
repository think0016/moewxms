package me.moe.modules.weixin.service;

import me.moe.modules.weixin.model.Attachment;

public class AttachmentService {
	public long save(Attachment attachment){
		boolean flag = attachment.save();
		long id = 0;
		if(flag){
			id = attachment.getId().longValue();
		}
		return id;
	}
	
	public boolean update(Attachment attachment){
		return attachment.update();
	}
}
