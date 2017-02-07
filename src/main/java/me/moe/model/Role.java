package me.moe.model;

import java.util.List;

import me.moe.model.base.BaseRole;

/**
 * Generated by JFinal.
 */
@SuppressWarnings("serial")
public class Role extends BaseRole<Role> {
	public static final Role dao = new Role().dao();
	
	public List<Menu> getMenu(){
		String sql = "SELECT `a`.* FROM `qx_menu` `a` "
				+ "LEFT JOIN `qx_role_menu` `b` ON `a`.`menuid` = `b`.`menu_id` "
				+ "LEFT JOIN `qx_role` `c` ON `c`.`roleid` = `b`.`role_id` "
				+ "WHERE `c`.`roleid`=?";
		
		return Menu.dao.find(sql,getRoleid());
	}
}
