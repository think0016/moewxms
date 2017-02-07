package me.moe.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import me.moe.model.base.BaseUser;

/**
 * Generated by JFinal.
 */
@SuppressWarnings("serial")
public class User extends BaseUser<User> {
	public static final User dao = new User().dao();
	
	
	private String[] role;

	public Department getDepartment() {
		String sql = "SELECT * FROM `qx_department` WHERE did = ?";
		
		return Department.dao.findFirst(sql,getDid());
	}

	public void setDepartment(Department department) {
		//this.department = department;		
	}

	public String[] getRole() {
		return role;
	}

	public void setRole(String[] role) {
		this.role = role;
	}
	
	/**
	 * 获取角色列表
	 * @return
	 */
	public List<Role> getRolelist(){
		String sql = "SELECT `a`.* FROM `qx_role` `a` "
				+ "LEFT JOIN `qx_user_role` `b` ON `a`.`roleid`=`b`.`role_id` "
				+ "LEFT JOIN `qx_user` `c` ON `c`.`uid`=`b`.`user_id` "
				+ "WHERE `c`.`uid`=? AND `a`.`del_flag`=0";		
		return Role.dao.find(sql, getUid());
	}
	
	public String getFormaterLogindate(String pattern){
		if("".equals(pattern)){
			pattern = "yyyy-MM-dd HH:mm:ss";
		}
		SimpleDateFormat dateFormater = new SimpleDateFormat(pattern);
		Date date=new Date();
		return dateFormater.format(date);
	}
	
	public String getRealHeadphoto(){
		String headphoto =  this.getHeadphoto();
		if(StringUtils.isEmpty(headphoto)){
			headphoto = "/static/dist/img/default_photo.jpg";
		}else{
			
		}
		return headphoto;
	}
}