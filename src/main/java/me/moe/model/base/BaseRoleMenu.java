package me.moe.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseRoleMenu<M extends BaseRoleMenu<M>> extends Model<M> implements IBean {

	public void setRmid(java.lang.Integer rmid) {
		set("rmid", rmid);
	}

	public java.lang.Integer getRmid() {
		return get("rmid");
	}

	public void setRoleId(java.lang.Integer roleId) {
		set("role_id", roleId);
	}

	public java.lang.Integer getRoleId() {
		return get("role_id");
	}

	public void setMenuId(java.lang.Integer menuId) {
		set("menu_id", menuId);
	}

	public java.lang.Integer getMenuId() {
		return get("menu_id");
	}

}