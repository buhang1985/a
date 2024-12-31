package iih.ci.mr.mrsign.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mr.mrsign.d.desc.CiMrSignDODesc;
import java.math.BigDecimal;

/**
 * 临床医疗记录签名 DO数据 
 * 
 */
public class CiMrSignDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//医疗记录签名
	public static final String ID_MRSIGN= "Id_mrsign";
	//医疗记录ID
	public static final String ID_MR= "Id_mr";
	//组织
	public static final String ID_ORG= "Id_org";
	//集团
	public static final String ID_GRP= "Id_grp";
	//签名级别
	public static final String ID_SIGNLVL= "Id_signlvl";
	//签名级别编码
	public static final String SD_SIGNLVL= "Sd_signlvl";
	//签名角色
	public static final String ID_ROLE_SIGN= "Id_role_sign";
	//签名角色编码
	public static final String SD_ROLE_SIGN= "Sd_role_sign";
	//签名类型
	public static final String ID_SIGNTP= "Id_signtp";
	//签名类型编码
	public static final String SD_SIGNTP= "Sd_signtp";
	//签名时间
	public static final String DT_SIGN= "Dt_sign";
	//签名医生
	public static final String ID_EMP_SIGN= "Id_emp_sign";
	//签署人员姓名
	public static final String NAME_PSN= "Name_psn";
	//签名患者
	public static final String ID_PAT_SIGN= "Id_pat_sign";
	//签名科室
	public static final String ID_DEP= "Id_dep";
	//签署科室名称
	public static final String NAME_DEPT= "Name_dept";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//患者签署人
	public static final String EU_PAT_SIGN= "Eu_pat_sign";
	//患者签署人姓名
	public static final String NAME_PAT_SIGN= "Name_pat_sign";
	//患者签署人图片
	public static final String IMG_PAT_SIGN= "Img_pat_sign";
	//签名元素id
	public static final String ID_SIGN= "Id_sign";
	//人员编码
	public static final String EMP_SIGN_CODE= "Emp_sign_code";
	//姓名
	public static final String EMP_SIGN_NAME= "Emp_sign_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 医疗记录签名
	 * @return String
	 */
	public String getId_mrsign() {
		return ((String) getAttrVal("Id_mrsign"));
	}	
	/**
	 * 医疗记录签名
	 * @param Id_mrsign
	 */
	public void setId_mrsign(String Id_mrsign) {
		setAttrVal("Id_mrsign", Id_mrsign);
	}
	/**
	 * 医疗记录ID
	 * @return String
	 */
	public String getId_mr() {
		return ((String) getAttrVal("Id_mr"));
	}	
	/**
	 * 医疗记录ID
	 * @param Id_mr
	 */
	public void setId_mr(String Id_mr) {
		setAttrVal("Id_mr", Id_mr);
	}
	/**
	 * 组织
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	/**
	 * 组织
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 集团
	 * @return String
	 */
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	/**
	 * 集团
	 * @param Id_grp
	 */
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	/**
	 * 签名级别
	 * @return String
	 */
	public String getId_signlvl() {
		return ((String) getAttrVal("Id_signlvl"));
	}	
	/**
	 * 签名级别
	 * @param Id_signlvl
	 */
	public void setId_signlvl(String Id_signlvl) {
		setAttrVal("Id_signlvl", Id_signlvl);
	}
	/**
	 * 签名级别编码
	 * @return String
	 */
	public String getSd_signlvl() {
		return ((String) getAttrVal("Sd_signlvl"));
	}	
	/**
	 * 签名级别编码
	 * @param Sd_signlvl
	 */
	public void setSd_signlvl(String Sd_signlvl) {
		setAttrVal("Sd_signlvl", Sd_signlvl);
	}
	/**
	 * 签名角色
	 * @return String
	 */
	public String getId_role_sign() {
		return ((String) getAttrVal("Id_role_sign"));
	}	
	/**
	 * 签名角色
	 * @param Id_role_sign
	 */
	public void setId_role_sign(String Id_role_sign) {
		setAttrVal("Id_role_sign", Id_role_sign);
	}
	/**
	 * 签名角色编码
	 * @return String
	 */
	public String getSd_role_sign() {
		return ((String) getAttrVal("Sd_role_sign"));
	}	
	/**
	 * 签名角色编码
	 * @param Sd_role_sign
	 */
	public void setSd_role_sign(String Sd_role_sign) {
		setAttrVal("Sd_role_sign", Sd_role_sign);
	}
	/**
	 * 签名类型
	 * @return String
	 */
	public String getId_signtp() {
		return ((String) getAttrVal("Id_signtp"));
	}	
	/**
	 * 签名类型
	 * @param Id_signtp
	 */
	public void setId_signtp(String Id_signtp) {
		setAttrVal("Id_signtp", Id_signtp);
	}
	/**
	 * 签名类型编码
	 * @return String
	 */
	public String getSd_signtp() {
		return ((String) getAttrVal("Sd_signtp"));
	}	
	/**
	 * 签名类型编码
	 * @param Sd_signtp
	 */
	public void setSd_signtp(String Sd_signtp) {
		setAttrVal("Sd_signtp", Sd_signtp);
	}
	/**
	 * 签名时间
	 * @return FDateTime
	 */
	public FDateTime getDt_sign() {
		return ((FDateTime) getAttrVal("Dt_sign"));
	}	
	/**
	 * 签名时间
	 * @param Dt_sign
	 */
	public void setDt_sign(FDateTime Dt_sign) {
		setAttrVal("Dt_sign", Dt_sign);
	}
	/**
	 * 签名医生
	 * @return String
	 */
	public String getId_emp_sign() {
		return ((String) getAttrVal("Id_emp_sign"));
	}	
	/**
	 * 签名医生
	 * @param Id_emp_sign
	 */
	public void setId_emp_sign(String Id_emp_sign) {
		setAttrVal("Id_emp_sign", Id_emp_sign);
	}
	/**
	 * 签署人员姓名
	 * @return String
	 */
	public String getName_psn() {
		return ((String) getAttrVal("Name_psn"));
	}	
	/**
	 * 签署人员姓名
	 * @param Name_psn
	 */
	public void setName_psn(String Name_psn) {
		setAttrVal("Name_psn", Name_psn);
	}
	/**
	 * 签名患者
	 * @return String
	 */
	public String getId_pat_sign() {
		return ((String) getAttrVal("Id_pat_sign"));
	}	
	/**
	 * 签名患者
	 * @param Id_pat_sign
	 */
	public void setId_pat_sign(String Id_pat_sign) {
		setAttrVal("Id_pat_sign", Id_pat_sign);
	}
	/**
	 * 签名科室
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}	
	/**
	 * 签名科室
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	/**
	 * 签署科室名称
	 * @return String
	 */
	public String getName_dept() {
		return ((String) getAttrVal("Name_dept"));
	}	
	/**
	 * 签署科室名称
	 * @param Name_dept
	 */
	public void setName_dept(String Name_dept) {
		setAttrVal("Name_dept", Name_dept);
	}
	/**
	 * 创建人
	 * @return String
	 */
	public String getCreatedby() {
		return ((String) getAttrVal("Createdby"));
	}	
	/**
	 * 创建人
	 * @param Createdby
	 */
	public void setCreatedby(String Createdby) {
		setAttrVal("Createdby", Createdby);
	}
	/**
	 * 创建时间
	 * @return FDateTime
	 */
	public FDateTime getCreatedtime() {
		return ((FDateTime) getAttrVal("Createdtime"));
	}	
	/**
	 * 创建时间
	 * @param Createdtime
	 */
	public void setCreatedtime(FDateTime Createdtime) {
		setAttrVal("Createdtime", Createdtime);
	}
	/**
	 * 最后修改人
	 * @return String
	 */
	public String getModifiedby() {
		return ((String) getAttrVal("Modifiedby"));
	}	
	/**
	 * 最后修改人
	 * @param Modifiedby
	 */
	public void setModifiedby(String Modifiedby) {
		setAttrVal("Modifiedby", Modifiedby);
	}
	/**
	 * 最后修改时间
	 * @return FDateTime
	 */
	public FDateTime getModifiedtime() {
		return ((FDateTime) getAttrVal("Modifiedtime"));
	}	
	/**
	 * 最后修改时间
	 * @param Modifiedtime
	 */
	public void setModifiedtime(FDateTime Modifiedtime) {
		setAttrVal("Modifiedtime", Modifiedtime);
	}
	/**
	 * 患者签署人
	 * @return String
	 */
	public String getEu_pat_sign() {
		return ((String) getAttrVal("Eu_pat_sign"));
	}	
	/**
	 * 患者签署人
	 * @param Eu_pat_sign
	 */
	public void setEu_pat_sign(String Eu_pat_sign) {
		setAttrVal("Eu_pat_sign", Eu_pat_sign);
	}
	/**
	 * 患者签署人姓名
	 * @return String
	 */
	public String getName_pat_sign() {
		return ((String) getAttrVal("Name_pat_sign"));
	}	
	/**
	 * 患者签署人姓名
	 * @param Name_pat_sign
	 */
	public void setName_pat_sign(String Name_pat_sign) {
		setAttrVal("Name_pat_sign", Name_pat_sign);
	}
	/**
	 * 患者签署人图片
	 * @return byte[]
	 */
	public byte[] getImg_pat_sign() {
		return ((byte[]) getAttrVal("Img_pat_sign"));
	}	
	/**
	 * 患者签署人图片
	 * @param Img_pat_sign
	 */
	public void setImg_pat_sign(byte[] Img_pat_sign) {
		setAttrVal("Img_pat_sign", Img_pat_sign);
	}
	/**
	 * 签名元素id
	 * @return String
	 */
	public String getId_sign() {
		return ((String) getAttrVal("Id_sign"));
	}	
	/**
	 * 签名元素id
	 * @param Id_sign
	 */
	public void setId_sign(String Id_sign) {
		setAttrVal("Id_sign", Id_sign);
	}
	/**
	 * 人员编码
	 * @return String
	 */
	public String getEmp_sign_code() {
		return ((String) getAttrVal("Emp_sign_code"));
	}	
	/**
	 * 人员编码
	 * @param Emp_sign_code
	 */
	public void setEmp_sign_code(String Emp_sign_code) {
		setAttrVal("Emp_sign_code", Emp_sign_code);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getEmp_sign_name() {
		return ((String) getAttrVal("Emp_sign_name"));
	}	
	/**
	 * 姓名
	 * @param Emp_sign_name
	 */
	public void setEmp_sign_name(String Emp_sign_name) {
		setAttrVal("Emp_sign_name", Emp_sign_name);
	}

	public Integer getDs() {
		return ((Integer) getAttrVal(GlobalConst.DELETE_SIGN));
	}
	
	public void setDs(Integer ds) {
		setAttrVal(GlobalConst.DELETE_SIGN, ds);
	}
	
	public FDateTime getSv() {
		return ((FDateTime) getAttrVal(GlobalConst.SYSTEM_VERSION));
	}
	
	public void setSv(FDateTime sv) {
		setAttrVal(GlobalConst.SYSTEM_VERSION, sv);
	}

//	@Override
//	public java.lang.String getParentPKFieldName() {
//		return null;
//	}
  
	@Override
	public String getPKFieldName() {
		return "Id_mrsign";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_mr_sign";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CiMrSignDODesc.class);
	}
	
}