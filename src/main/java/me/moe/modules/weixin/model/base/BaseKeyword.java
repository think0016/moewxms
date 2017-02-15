package me.moe.modules.weixin.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseKeyword<M extends BaseKeyword<M>> extends Model<M> implements IBean {

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

	public void setToken(java.lang.String token) {
		set("token", token);
	}

	public java.lang.String getToken() {
		return get("token");
	}

	public void setAddon(java.lang.String addon) {
		set("addon", addon);
	}

	public java.lang.String getAddon() {
		return get("addon");
	}

	public void setAimId(java.lang.Long aimId) {
		set("aim_id", aimId);
	}

	public java.lang.Long getAimId() {
		return get("aim_id");
	}

	public void setCreatedate(java.util.Date createdate) {
		set("createdate", createdate);
	}

	public java.util.Date getCreatedate() {
		return get("createdate");
	}

	public void setKeywordLength(java.lang.Long keywordLength) {
		set("keyword_length", keywordLength);
	}

	public java.lang.Long getKeywordLength() {
		return get("keyword_length");
	}

	public void setKeywordType(java.lang.Integer keywordType) {
		set("keyword_type", keywordType);
	}

	public java.lang.Integer getKeywordType() {
		return get("keyword_type");
	}

	public void setRequestCount(java.lang.Integer requestCount) {
		set("request_count", requestCount);
	}

	public java.lang.Integer getRequestCount() {
		return get("request_count");
	}

}
