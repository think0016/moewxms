package me.moe.modules.weixin.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseAttachment<M extends BaseAttachment<M>> extends Model<M> implements IBean {

	public void setId(java.lang.Long id) {
		set("id", id);
	}

	public java.lang.Long getId() {
		return get("id");
	}

	public void setUrl(java.lang.String url) {
		set("url", url);
	}

	public java.lang.String getUrl() {
		return get("url");
	}
	
	public void setFilename(java.lang.String filename) {
		set("filename", filename);
	}

	public java.lang.String getFilename() {
		return get("filename");
	}

	public void setPath(java.lang.String path) {
		set("path", path);
	}

	public java.lang.String getPath() {
		return get("path");
	}

	public void setExt(java.lang.String ext) {
		set("ext", ext);
	}

	public java.lang.String getExt() {
		return get("ext");
	}

	public void setIsDel(java.lang.Integer isDel) {
		set("is_del", isDel);
	}

	public java.lang.Integer getIsDel() {
		return get("is_del");
	}

	public void setManagerId(java.lang.Integer managerId) {
		set("manager_id", managerId);
	}

	public java.lang.Integer getManagerId() {
		return get("manager_id");
	}

	public void setCreatedate(java.util.Date createdate) {
		set("createdate", createdate);
	}

	public java.util.Date getCreatedate() {
		return get("createdate");
	}

}
