package me.moe.modules.weixin.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseMaterialFile<M extends BaseMaterialFile<M>> extends Model<M> implements IBean {

	public void setId(java.lang.Long id) {
		set("id", id);
	}

	public java.lang.Long getId() {
		return get("id");
	}

	public void setFileId(java.lang.Integer fileId) {
		set("file_id", fileId);
	}

	public java.lang.Integer getFileId() {
		return get("file_id");
	}

	public void setMname(java.lang.String mname) {
		set("mname", mname);
	}

	public java.lang.String getMname() {
		return get("mname");
	}
	
	public void setFileUrl(java.lang.String fileUrl) {
		set("file_url", fileUrl);
	}

	public java.lang.String getFileUrl() {
		return get("file_url");
	}

	public void setMediaId(java.lang.String mediaId) {
		set("media_id", mediaId);
	}

	public java.lang.String getMediaId() {
		return get("media_id");
	}

	public void setWechatUrl(java.lang.String wechatUrl) {
		set("wechat_url", wechatUrl);
	}

	public java.lang.String getWechatUrl() {
		return get("wechat_url");
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

	public void setTitle(java.lang.String title) {
		set("title", title);
	}

	public java.lang.String getTitle() {
		return get("title");
	}

	public void setType(java.lang.Integer type) {
		set("type", type);
	}

	public java.lang.Integer getType() {
		return get("type");
	}

	public void setCreatedate(java.util.Date createdate) {
		set("createdate", createdate);
	}

	public java.util.Date getCreatedate() {
		return get("createdate");
	}

	public void setIntroduction(java.lang.String introduction) {
		set("introduction", introduction);
	}

	public java.lang.String getIntroduction() {
		return get("introduction");
	}

	public void setIsUse(java.lang.Integer isUse) {
		set("is_use", isUse);
	}

	public java.lang.Integer getIsUse() {
		return get("is_use");
	}

}
