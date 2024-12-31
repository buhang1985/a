package iih.bd.srv.mrctmca.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.mrctmca.d.desc.MrCaCtmItmDODesc;
import java.math.BigDecimal;

/**
 * 医疗记录类型自定义分类项目 DO数据 
 * 
 */
public class MrCaCtmItmDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//医疗记录类型自定义分类项目主键标识
	public static final String ID_MRCACTMITM= "Id_mrcactmitm";
	//医疗记录类型自定义分类
	public static final String ID_MRCACTM= "Id_mrcactm";
	//医疗记录类型
	public static final String ID_MRTP= "Id_mrtp";
	//适用范围
	public static final String ID_OWTP= "Id_owtp";
	//适用范围编码
	public static final String SD_OWTP= "Sd_owtp";
	//所属机构
	public static final String ID_ORG= "Id_org";
	//所属科室
	public static final String ID_DEP= "Id_dep";
	//序号
	public static final String SORTNO= "Sortno";
	//医疗记录类型编码
	public static final String MRTP_CODE= "Mrtp_code";
	//医疗记录类型名称
	public static final String MRTP_NAME= "Mrtp_name";
	//描述
	public static final String MRTP_DES= "Mrtp_des";
	//病历文书审签级别编码
	public static final String MRTP_MR_SIGN_LVL_CD= "Mrtp_mr_sign_lvl_cd";
	//仅有标记（1 一份，0多分）
	public static final String MRTP_FG_ONLY= "Mrtp_fg_only";
	//医疗记录类型国家编码
	public static final String CD_STD= "Cd_std";
	//编码
	public static final String OWTP_CODE= "Owtp_code";
	//名称
	public static final String OWTP_NAME= "Owtp_name";
	//组织编码
	public static final String ORGCODE= "Orgcode";
	//组织名称
	public static final String ORGNAME= "Orgname";
	//编码
	public static final String DEPCODE= "Depcode";
	//名称
	public static final String DEPNAME= "Depname";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 医疗记录类型自定义分类项目主键标识
	 * @return String
	 */
	public String getId_mrcactmitm() {
		return ((String) getAttrVal("Id_mrcactmitm"));
	}	
	/**
	 * 医疗记录类型自定义分类项目主键标识
	 * @param Id_mrcactmitm
	 */
	public void setId_mrcactmitm(String Id_mrcactmitm) {
		setAttrVal("Id_mrcactmitm", Id_mrcactmitm);
	}
	/**
	 * 医疗记录类型自定义分类
	 * @return String
	 */
	public String getId_mrcactm() {
		return ((String) getAttrVal("Id_mrcactm"));
	}	
	/**
	 * 医疗记录类型自定义分类
	 * @param Id_mrcactm
	 */
	public void setId_mrcactm(String Id_mrcactm) {
		setAttrVal("Id_mrcactm", Id_mrcactm);
	}
	/**
	 * 医疗记录类型
	 * @return String
	 */
	public String getId_mrtp() {
		return ((String) getAttrVal("Id_mrtp"));
	}	
	/**
	 * 医疗记录类型
	 * @param Id_mrtp
	 */
	public void setId_mrtp(String Id_mrtp) {
		setAttrVal("Id_mrtp", Id_mrtp);
	}
	/**
	 * 适用范围
	 * @return String
	 */
	public String getId_owtp() {
		return ((String) getAttrVal("Id_owtp"));
	}	
	/**
	 * 适用范围
	 * @param Id_owtp
	 */
	public void setId_owtp(String Id_owtp) {
		setAttrVal("Id_owtp", Id_owtp);
	}
	/**
	 * 适用范围编码
	 * @return String
	 */
	public String getSd_owtp() {
		return ((String) getAttrVal("Sd_owtp"));
	}	
	/**
	 * 适用范围编码
	 * @param Sd_owtp
	 */
	public void setSd_owtp(String Sd_owtp) {
		setAttrVal("Sd_owtp", Sd_owtp);
	}
	/**
	 * 所属机构
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	/**
	 * 所属机构
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 所属科室
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}	
	/**
	 * 所属科室
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	/**
	 * 序号
	 * @return Integer
	 */
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	/**
	 * 序号
	 * @param Sortno
	 */
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	/**
	 * 医疗记录类型编码
	 * @return String
	 */
	public String getMrtp_code() {
		return ((String) getAttrVal("Mrtp_code"));
	}	
	/**
	 * 医疗记录类型编码
	 * @param Mrtp_code
	 */
	public void setMrtp_code(String Mrtp_code) {
		setAttrVal("Mrtp_code", Mrtp_code);
	}
	/**
	 * 医疗记录类型名称
	 * @return String
	 */
	public String getMrtp_name() {
		return ((String) getAttrVal("Mrtp_name"));
	}	
	/**
	 * 医疗记录类型名称
	 * @param Mrtp_name
	 */
	public void setMrtp_name(String Mrtp_name) {
		setAttrVal("Mrtp_name", Mrtp_name);
	}
	/**
	 * 描述
	 * @return String
	 */
	public String getMrtp_des() {
		return ((String) getAttrVal("Mrtp_des"));
	}	
	/**
	 * 描述
	 * @param Mrtp_des
	 */
	public void setMrtp_des(String Mrtp_des) {
		setAttrVal("Mrtp_des", Mrtp_des);
	}
	/**
	 * 病历文书审签级别编码
	 * @return String
	 */
	public String getMrtp_mr_sign_lvl_cd() {
		return ((String) getAttrVal("Mrtp_mr_sign_lvl_cd"));
	}	
	/**
	 * 病历文书审签级别编码
	 * @param Mrtp_mr_sign_lvl_cd
	 */
	public void setMrtp_mr_sign_lvl_cd(String Mrtp_mr_sign_lvl_cd) {
		setAttrVal("Mrtp_mr_sign_lvl_cd", Mrtp_mr_sign_lvl_cd);
	}
	/**
	 * 仅有标记（1 一份，0多分）
	 * @return FBoolean
	 */
	public FBoolean getMrtp_fg_only() {
		return ((FBoolean) getAttrVal("Mrtp_fg_only"));
	}	
	/**
	 * 仅有标记（1 一份，0多分）
	 * @param Mrtp_fg_only
	 */
	public void setMrtp_fg_only(FBoolean Mrtp_fg_only) {
		setAttrVal("Mrtp_fg_only", Mrtp_fg_only);
	}
	/**
	 * 医疗记录类型国家编码
	 * @return String
	 */
	public String getCd_std() {
		return ((String) getAttrVal("Cd_std"));
	}	
	/**
	 * 医疗记录类型国家编码
	 * @param Cd_std
	 */
	public void setCd_std(String Cd_std) {
		setAttrVal("Cd_std", Cd_std);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getOwtp_code() {
		return ((String) getAttrVal("Owtp_code"));
	}	
	/**
	 * 编码
	 * @param Owtp_code
	 */
	public void setOwtp_code(String Owtp_code) {
		setAttrVal("Owtp_code", Owtp_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getOwtp_name() {
		return ((String) getAttrVal("Owtp_name"));
	}	
	/**
	 * 名称
	 * @param Owtp_name
	 */
	public void setOwtp_name(String Owtp_name) {
		setAttrVal("Owtp_name", Owtp_name);
	}
	/**
	 * 组织编码
	 * @return String
	 */
	public String getOrgcode() {
		return ((String) getAttrVal("Orgcode"));
	}	
	/**
	 * 组织编码
	 * @param Orgcode
	 */
	public void setOrgcode(String Orgcode) {
		setAttrVal("Orgcode", Orgcode);
	}
	/**
	 * 组织名称
	 * @return String
	 */
	public String getOrgname() {
		return ((String) getAttrVal("Orgname"));
	}	
	/**
	 * 组织名称
	 * @param Orgname
	 */
	public void setOrgname(String Orgname) {
		setAttrVal("Orgname", Orgname);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getDepcode() {
		return ((String) getAttrVal("Depcode"));
	}	
	/**
	 * 编码
	 * @param Depcode
	 */
	public void setDepcode(String Depcode) {
		setAttrVal("Depcode", Depcode);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getDepname() {
		return ((String) getAttrVal("Depname"));
	}	
	/**
	 * 名称
	 * @param Depname
	 */
	public void setDepname(String Depname) {
		setAttrVal("Depname", Depname);
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
		return "Id_mrcactmitm";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_mrca_ctm_itm";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MrCaCtmItmDODesc.class);
	}
	
}