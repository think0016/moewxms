package me.moe.modules.weixin.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseAutoReply<M extends BaseAutoReply<M>> extends Model<M> implements IBean {

	public void setId(java.lang.Long id) {
		set("id", id);
	}

	public java.lang.Long getId() {
		return get("id");
	}

	public void setKeyword(java.lang.String keyword) {
		set("keyword", keyword);
	}

	public java.lang.String getKeyword() {
		return get("keyword");
	}

	public void setMsgType(java.lang.String msgType) {
		set("msg_type", msgType);
	}

	public java.lang.String getMsgType() {
		return get("msg_type");
	}

	public void setContent(java.lang.String content) {
		set("content", content);
	}

	public java.lang.String getContent() {
		return get("content");
	}

	public void setGroupId(java.lang.Integer groupId) {
		set("group_id", groupId);
	}

	public java.lang.Integer getGroupId() {
		return get("group_id");
	}

	public void setImageId(java.lang.Long imageId) {
		set("image_id", imageId);
	}

	public java.lang.Long getImageId() {
		return get("image_id");
	}

	public void setManagerId(java.lang.Integer managerId) {
		set("manager_id", managerId);
	}

	public java.lang.Integer getManagerId() {
		return get("manager_id");
	}

	public void setToken(java.lang.String token) {
		set("token", token);
	}

	public java.lang.String getToken() {
		return get("token");
	}

	public void setImageMaterial(java.lang.Integer imageMaterial) {
		set("image_material", imageMaterial);
	}

	public java.lang.Integer getImageMaterial() {
		return get("image_material");
	}

	public void setVoiceId(java.lang.Integer voiceId) {
		set("voice_id", voiceId);
	}

	public java.lang.Integer getVoiceId() {
		return get("voice_id");
	}

	public void setVideoId(java.lang.Integer videoId) {
		set("video_id", videoId);
	}

	public java.lang.Integer getVideoId() {
		return get("video_id");
	}

}
