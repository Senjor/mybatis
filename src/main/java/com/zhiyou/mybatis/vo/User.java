/**
 * 
 */
package com.zhiyou.mybatis.vo;
/**
* @author 		laosun
* @version 		创建时间：Nov 5, 2018 9:53:05 AM
* @ClassName 	类名称
* @Description 	类描述
*/
/**
 * @author 1
 *
 */
public class User {
	private int u_id;
	private String u_name;
	private String u_sex;
	private String u_pwd;
	
   public User() {
	// TODO Auto-generated constructor stub
}
   public void setU_id(int u_id) {
	this.u_id = u_id;
}
   public int getU_id() {
	return u_id;
}
   public void setU_name(String u_name) {
	this.u_name = u_name;
}
   public String getU_name() {
	return u_name;
}
   public void setU_sex(String u_sex) {
	this.u_sex = u_sex;
}
   public String getU_sex() {
	return u_sex;
}
   public void setU_pwd(String u_pwd) {
	this.u_pwd = u_pwd;
}
   public String getU_pwd() {
	return u_pwd;
}
@Override
public String toString() {
	return "User [u_id=" + u_id + ", u_name=" + u_name + ", u_sex=" + u_sex + ", u_pwd=" + u_pwd + "]";
}
   

}
