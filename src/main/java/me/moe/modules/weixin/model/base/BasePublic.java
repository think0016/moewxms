package me.moe.modules.weixin.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BasePublic<M extends BasePublic<M>> extends Model<M> implements IBean {

	public void setId(java.lang.String id) {
		set("id", id);
	}

	public java.lang.String getId() {
		return get("id");
	}

	public void setUid(java.lang.Integer uid) {
		set("uid", uid);
	}

	public java.lang.Integer getUid() {
		return get("uid");
	}

	public void setPublicName(java.lang.String publicName) {
		set("public_name", publicName);
	}

	public java.lang.String getPublicName() {
		return get("public_name");
	}

	public void setPublicId(java.lang.String publicId) {
		set("public_id", publicId);
	}

	public java.lang.String getPublicId() {
		return get("public_id");
	}

	public void setWechat(java.lang.String wechat) {
		set("wechat", wechat);
	}

	public java.lang.String getWechat() {
		return get("wechat");
	}

	public void setInterfaceUrl(java.lang.String interfaceUrl) {
		set("interface_url", interfaceUrl);
	}

	public java.lang.String getInterfaceUrl() {
		return get("interface_url");
	}

	public void setHeadfaceUrl(java.lang.String headfaceUrl) {
		set("headface_url", headfaceUrl);
	}

	public java.lang.String getHeadfaceUrl() {
		return get("headface_url");
	}

	public void setToken(java.lang.String token) {
		set("token", token);
	}

	public java.lang.String getToken() {
		return get("token");
	}

	public void setIsUse(java.lang.Integer isUse) {
		set("is_use", isUse);
	}

	public java.lang.Integer getIsUse() {
		return get("is_use");
	}

	public void setType(java.lang.String type) {
		set("type", type);
	}

	public java.lang.String getType() {
		return get("type");
	}

	public void setAppid(java.lang.String appid) {
		set("appid", appid);
	}

	public java.lang.String getAppid() {
		return get("appid");
	}

	public void setSecret(java.lang.String secret) {
		set("secret", secret);
	}

	public java.lang.String getSecret() {
		return get("secret");
	}

	public void setIsencryptMessage(java.lang.Integer isencryptMessage) {
		set("isencryptMessage", isencryptMessage);
	}

	public java.lang.Integer getIsencryptMessage() {
		return get("isencryptMessage");
	}

	public void setEncodingaeskey(java.lang.String encodingaeskey) {
		set("encodingaeskey", encodingaeskey);
	}

	public java.lang.String getEncodingaeskey() {
		return get("encodingaeskey");
	}

	public void setWelcome(java.lang.String welcome) {
		set("welcome", welcome);
	}

	public java.lang.String getWelcome() {
		return get("welcome");
	}

	public void setNoanswer(java.lang.String noanswer) {
		set("noanswer", noanswer);
	}

	public java.lang.String getNoanswer() {
		return get("noanswer");
	}

	public void setCreatedate(java.util.Date createdate) {
		set("createdate", createdate);
	}

	public java.util.Date getCreatedate() {
		return get("createdate");
	}

}