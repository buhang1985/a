package iih.bd.srv.preformat.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.preformat.d.desc.MrPreFormatDODesc;
import java.math.BigDecimal;

/**
 * 处方格式 DO数据 
 * 
 */
public class MrPreFormatDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//处方格式主键
	public static final String ID_MR_PRE_FORMAT= "Id_mr_pre_format";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//服务类型
	public static final String ID_MEDSRVTYPE= "Id_medsrvtype";
	//就诊类型
	public static final String ID_ENTP= "Id_entp";
	//科室
	public static final String ID_DEPT= "Id_dept";
	//医疗记录片段模板
	public static final String ID_MRTPLSEC= "Id_mrtplsec";
	//排序字段
	public static final String NU_SORT= "Nu_sort";
	//循环标识
	public static final String FG_LOOP= "Fg_loop";
	//分组标识
	public static final String FG_GROUP= "Fg_group";
	//启用标识
	public static final String FG_ACTIVE= "Fg_active";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//病历编辑器名称
	public static final String NAME_MRED= "Name_mred";
	//编码
	public static final String CODE_GRP= "Code_grp";
	//名称
	public static final String NAME_GRP= "Name_grp";
	//组织编码
	public static final String CODE_ORG= "Code_org";
	//组织名称
	public static final String NAME_ORG= "Name_org";
	//编码
	public static final String CODE_MEDSRVTYPE= "Code_medsrvtype";
	//名称
	public static final String NAME_MEDSRVTYPE= "Name_medsrvtype";
	//就诊类型编码
	public static final String CODE_ENTP= "Code_entp";
	//就诊类型名称
	public static final String NAME_ENTP= "Name_entp";
	//编码
	public static final String CODE_DEPT= "Code_dept";
	//名称
	public static final String NAME_DEPT= "Name_dept";
	//片段模板编码
	public static final String CODE_MRTPLSEC= "Code_mrtplsec";
	//片段模板名称
	public static final String NAME_MRTPLSEC= "Name_mrtplsec";
	//用户名称
	public static final String MODTI_NAME= "Modti_name";
	//用户编码
	public static final String MODTI_CODE= "Modti_code";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 处方格式主键
	 * @return String
	 */
	public String getId_mr_pre_format() {
		return ((String) getAttrVal("Id_mr_pre_format"));
	}	
	/**
	 * 处方格式主键
	 * @param Id_mr_pre_format
	 */
	public void setId_mr_pre_format(String Id_mr_pre_format) {
		setAttrVal("Id_mr_pre_format", Id_mr_pre_format);
	}
	/**
	 * 所属集团
	 * @return String
	 */
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	/**
	 * 所属集团
	 * @param Id_grp
	 */
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	/**
	 * 所属组织
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	/**
	 * 所属组织
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 服务类型
	 * @return String
	 */
	public String getId_medsrvtype() {
		return ((String) getAttrVal("Id_medsrvtype"));
	}	
	/**
	 * 服务类型
	 * @param Id_medsrvtype
	 */
	public void setId_medsrvtype(String Id_medsrvtype) {
		setAttrVal("Id_medsrvtype", Id_medsrvtype);
	}
	/**
	 * 就诊类型
	 * @return String
	 */
	public String getId_entp() {
		return ((String) getAttrVal("Id_entp"));
	}	
	/**
	 * 就诊类型
	 * @param Id_entp
	 */
	public void setId_entp(String Id_entp) {
		setAttrVal("Id_entp", Id_entp);
	}
	/**
	 * 科室
	 * @return String
	 */
	public String getId_dept() {
		return ((String) getAttrVal("Id_dept"));
	}	
	/**
	 * 科室
	 * @param Id_dept
	 */
	public void setId_dept(String Id_dept) {
		setAttrVal("Id_dept", Id_dept);
	}
	/**
	 * 医疗记录片段模板
	 * @return String
	 */
	public String getId_mrtplsec() {
		return ((String) getAttrVal("Id_mrtplsec"));
	}	
	/**
	 * 医疗记录片段模板
	 * @param Id_mrtplsec
	 */
	public void setId_mrtplsec(String Id_mrtplsec) {
		setAttrVal("Id_mrtplsec", Id_mrtplsec);
	}
	/**
	 * 排序字段
	 * @return Integer
	 */
	public Integer getNu_sort() {
		return ((Integer) getAttrVal("Nu_sort"));
	}	
	/**
	 * 排序字段
	 * @param Nu_sort
	 */
	public void setNu_sort(Integer Nu_sort) {
		setAttrVal("Nu_sort", Nu_sort);
	}
	/**
	 * 循环标识
	 * @return FBoolean
	 */
	public FBoolean getFg_loop() {
		return ((FBoolean) getAttrVal("Fg_loop"));
	}	
	/**
	 * 循环标识
	 * @param Fg_loop
	 */
	public void setFg_loop(FBoolean Fg_loop) {
		setAttrVal("Fg_loop", Fg_loop);
	}
	/**
	 * 分组标识
	 * @return FBoolean
	 */
	public FBoolean getFg_group() {
		return ((FBoolean) getAttrVal("Fg_group"));
	}	
	/**
	 * 分组标识
	 * @param Fg_group
	 */
	public void setFg_group(FBoolean Fg_group) {
		setAttrVal("Fg_group", Fg_group);
	}
	/**
	 * 启用标识
	 * @return FBoolean
	 */
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	/**
	 * 启用标识
	 * @param Fg_active
	 */
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
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
	 * 病历编辑器名称
	 * @return String
	 */
	public String getName_mred() {
		return ((String) getAttrVal("Name_mred"));
	}	
	/**
	 * 病历编辑器名称
	 * @param Name_mred
	 */
	public void setName_mred(String Name_mred) {
		setAttrVal("Name_mred", Name_mred);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_grp() {
		return ((String) getAttrVal("Code_grp"));
	}	
	/**
	 * 编码
	 * @param Code_grp
	 */
	public void setCode_grp(String Code_grp) {
		setAttrVal("Code_grp", Code_grp);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_grp() {
		return ((String) getAttrVal("Name_grp"));
	}	
	/**
	 * 名称
	 * @param Name_grp
	 */
	public void setName_grp(String Name_grp) {
		setAttrVal("Name_grp", Name_grp);
	}
	/**
	 * 组织编码
	 * @return String
	 */
	public String getCode_org() {
		return ((String) getAttrVal("Code_org"));
	}	
	/**
	 * 组织编码
	 * @param Code_org
	 */
	public void setCode_org(String Code_org) {
		setAttrVal("Code_org", Code_org);
	}
	/**
	 * 组织名称
	 * @return String
	 */
	public String getName_org() {
		return ((String) getAttrVal("Name_org"));
	}	
	/**
	 * 组织名称
	 * @param Name_org
	 */
	public void setName_org(String Name_org) {
		setAttrVal("Name_org", Name_org);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_medsrvtype() {
		return ((String) getAttrVal("Code_medsrvtype"));
	}	
	/**
	 * 编码
	 * @param Code_medsrvtype
	 */
	public void setCode_medsrvtype(String Code_medsrvtype) {
		setAttrVal("Code_medsrvtype", Code_medsrvtype);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_medsrvtype() {
		return ((String) getAttrVal("Name_medsrvtype"));
	}	
	/**
	 * 名称
	 * @param Name_medsrvtype
	 */
	public void setName_medsrvtype(String Name_medsrvtype) {
		setAttrVal("Name_medsrvtype", Name_medsrvtype);
	}
	/**
	 * 就诊类型编码
	 * @return String
	 */
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}	
	/**
	 * 就诊类型编码
	 * @param Code_entp
	 */
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
	}
	/**
	 * 就诊类型名称
	 * @return String
	 */
	public String getName_entp() {
		return ((String) getAttrVal("Name_entp"));
	}	
	/**
	 * 就诊类型名称
	 * @param Name_entp
	 */
	public void setName_entp(String Name_entp) {
		setAttrVal("Name_entp", Name_entp);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_dept() {
		return ((String) getAttrVal("Code_dept"));
	}	
	/**
	 * 编码
	 * @param Code_dept
	 */
	public void setCode_dept(String Code_dept) {
		setAttrVal("Code_dept", Code_dept);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_dept() {
		return ((String) getAttrVal("Name_dept"));
	}	
	/**
	 * 名称
	 * @param Name_dept
	 */
	public void setName_dept(String Name_dept) {
		setAttrVal("Name_dept", Name_dept);
	}
	/**
	 * 片段模板编码
	 * @return String
	 */
	public String getCode_mrtplsec() {
		return ((String) getAttrVal("Code_mrtplsec"));
	}	
	/**
	 * 片段模板编码
	 * @param Code_mrtplsec
	 */
	public void setCode_mrtplsec(String Code_mrtplsec) {
		setAttrVal("Code_mrtplsec", Code_mrtplsec);
	}
	/**
	 * 片段模板名称
	 * @return String
	 */
	public String getName_mrtplsec() {
		return ((String) getAttrVal("Name_mrtplsec"));
	}	
	/**
	 * 片段模板名称
	 * @param Name_mrtplsec
	 */
	public void setName_mrtplsec(String Name_mrtplsec) {
		setAttrVal("Name_mrtplsec", Name_mrtplsec);
	}
	/**
	 * 用户名称
	 * @return String
	 */
	public String getModti_name() {
		return ((String) getAttrVal("Modti_name"));
	}	
	/**
	 * 用户名称
	 * @param Modti_name
	 */
	public void setModti_name(String Modti_name) {
		setAttrVal("Modti_name", Modti_name);
	}
	/**
	 * 用户编码
	 * @return String
	 */
	public String getModti_code() {
		return ((String) getAttrVal("Modti_code"));
	}	
	/**
	 * 用户编码
	 * @param Modti_code
	 */
	public void setModti_code(String Modti_code) {
		setAttrVal("Modti_code", Modti_code);
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
		return "Id_mr_pre_format";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_mr_pre_format";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MrPreFormatDODesc.class);
	}
	
}