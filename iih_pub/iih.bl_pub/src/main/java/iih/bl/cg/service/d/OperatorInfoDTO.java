package iih.bl.cg.service.d;

import xap.mw.core.data.BaseDTO;
/**
 * 操作人员信息
 * @author tcy
 *
 */
public class OperatorInfoDTO  extends BaseDTO  {
	private static final long serialVersionUID = 1L;
	/**
	 *  操作人员ID
	 * @return
	 */
	public String getId_emp() {
		return ((String) getAttrVal("Id_emp"));
	}
	public void setId_emp(String Id_emp) {
		setAttrVal("Id_emp", Id_emp);
	}

	
	/**
	 * @return 操作员姓名
	 */
	public String getName_emp()
	{
		return ((String)getAttrVal("Name_emp"));
	}
	
	public void setName_emp(String Name_emp)
	{
		setAttrVal("Name_emp", Name_emp);
	}
	/**
	 *  所属集团
	 * @return
	 */
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	
	/**
	 *  所属组织
	 * @return
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	
	
	/**
	 *  所属科室
	 * @return
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	
	/**
	 *  操作人员所属机构
	 * @return
	 */
	public String getId_org_emp() {
		return ((String) getAttrVal("Id_org_emp"));
	}
	public void setId_org_emp(String Id_org_emp) {
		setAttrVal("Id_org_emp", Id_org_emp);
	}
	
	/** 就诊退费类型
	 * @return
	 */
	public String getEu_enrefundtp()
	{
		return ((String) getAttrVal("Eu_enrefundtp"));
	}
	
	public void setEu_enrefundtp(String Eu_enrefundtp)
	{
		setAttrVal("Eu_enrefundtp", Eu_enrefundtp);
	}
	
	/** 业务场景
	 * @return
	 */
	public String getSrcfunc_des()
	{
		return ((String) getAttrVal("Srcfunc_des"));
	}
	
	public void setSrcfunc_des(String Srcfunc_des)
	{
		setAttrVal("Srcfunc_des", Srcfunc_des);
	}
	
	/** 票据领用模式
	 * @return
	 */
	public String getBlinc0012()
	{
		return ((String) getAttrVal("Blinc0012"));
	}
	
	public void setBlinc0012(String Blinc0012)
	{
		setAttrVal("Blinc0012", Blinc0012);
	}
	
	/**
	 *  计算机id
	 * @return
	 */
	public String getId_pc() {
		return ((String) getAttrVal("Id_pc"));
	}
	public void setId_pc(String Id_pc) {
		setAttrVal("Id_pc", Id_pc);
	}
}
