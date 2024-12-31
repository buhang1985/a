package iih.ci.ord.printmanage.dto;
/**
 * @code 会诊受邀信息DTO
 * @author LiYue
 * @date 2019年12月25日,下午2:55:18
 */
public class CiConsInviteDO {
    /**
     * 受邀科室
     */
	private String Name_dep;
	/**
	 * 受邀人姓名
	 */
	private String Name_emp;
	/**
	 * 受邀人职称
	 */
	private String Name_emptitle_invite;
	/*
	 * 医嘱编码
	 */
	private String Id_or;
	
	public String getId_or() {
		return Id_or;
	}
	public void setId_or(String id_or) {
		Id_or = id_or;
	}
	public String getName_dep() {
		return Name_dep;
	}
	public void setName_dep(String name_dep) {
		Name_dep = name_dep;
	}
	public String getName_emp() {
		return Name_emp;
	}
	public void setName_emp(String name_emp) {
		Name_emp = name_emp;
	}
	public String getName_emptitle_invite() {
		return Name_emptitle_invite;
	}
	public void setName_emptitle_invite(String name_emptitle_invite) {
		Name_emptitle_invite = name_emptitle_invite;
	}
	
}
