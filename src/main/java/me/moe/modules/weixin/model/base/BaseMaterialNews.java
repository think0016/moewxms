package me.moe.modules.weixin.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseMaterialNews<M extends BaseMaterialNews<M>> extends Model<M> implements IBean {

	public void setId(java.lang.Long id) {
		set("id", id);
	}

	public java.lang.Long getId() {
		return get("id");
	}

	public void setTitle(java.lang.String title) {
		set("title", title);
	}

	public java.lang.String getTitle() {
		return get("title");
	}

	public void setAuthor(java.lang.String author) {
		set("author", author);
	}

	public java.lang.String getAuthor() {
		return get("author");
	}

	public void setCoverId(java.lang.Long coverId) {
		set("cover_id", coverId);
	}

	public java.lang.Long getCoverId() {
		return get("cover_id");
	}

	public void setIntro(java.lang.String intro) {
		set("intro", intro);
	}

	public java.lang.String getIntro() {
		return get("intro");
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

	public void setThumbMediaId(java.lang.String thumbMediaId) {
		set("thumb_media_id", thumbMediaId);
	}

	public java.lang.String getThumbMediaId() {
		return get("thumb_media_id");
	}

	public void setMediaId(java.lang.String mediaId) {
		set("media_id", mediaId);
	}

	public java.lang.String getMediaId() {
		return get("media_id");
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

	public void setCreatedate(java.util.Date createdate) {
		set("createdate", createdate);
	}

	public java.util.Date getCreatedate() {
		return get("createdate");
	}

	public void setUrl(java.lang.String url) {
		set("url", url);
	}

	public java.lang.String getUrl() {
		return get("url");
	}

	public void setIsUse(java.lang.Integer isUse) {
		set("is_use", isUse);
	}

	public java.lang.Integer getIsUse() {
		return get("is_use");
	}

}
