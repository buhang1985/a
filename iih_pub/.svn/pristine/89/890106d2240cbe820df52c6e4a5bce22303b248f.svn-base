package iih.pe.phm.pesuvdigest.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.phm.pesuvdigest.d.desc.PeSuvDigestDODesc;
import java.math.BigDecimal;

/**
 * 健康问卷摘要 DO数据 
 * 
 */
public class PeSuvDigestDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//健康问卷摘要主键标识
	public static final String ID_PESUVDIGEST= "Id_pesuvdigest";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//健康管理服务预约ID
	public static final String ID_PEHMAPPT= "Id_pehmappt";
	//体检问卷问题分组ID
	public static final String ID_PEQACATLOG= "Id_peqacatlog";
	//体检问卷结果ID
	public static final String ID_PERSTSURVERYKEY= "Id_perstsurverykey";
	//体检问卷ID
	public static final String ID_PERSTSURVERY= "Id_perstsurvery";
	//体检问卷问题库ID
	public static final String ID_PEQACONTENTDEF= "Id_peqacontentdef";
	//体检问卷选项ID
	public static final String ID_PEQAKEYDEF= "Id_peqakeydef";
	//备注
	public static final String NOTE= "Note";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//预约日期
	public static final String DT_APPT= "Dt_appt";
	//预约号
	public static final String NO_APPT= "No_appt";
	//健康管理状态
	public static final String HMSTATUS= "Hmstatus";
	//问卷分组编码
	public static final String CODE_GROUP= "Code_group";
	//问卷分组名称
	public static final String NAME_GROUP= "Name_group";
	//体检问卷问题编码
	public static final String CODE_QUS= "Code_qus";
	//体检问卷问题
	public static final String NAME_QUS= "Name_qus";
	//编码
	public static final String CODE_ANS= "Code_ans";
	//名称
	public static final String NAME_ANS= "Name_ans";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 健康问卷摘要主键标识
	 * @return String
	 */
	public String getId_pesuvdigest() {
		return ((String) getAttrVal("Id_pesuvdigest"));
	}	
	/**
	 * 健康问卷摘要主键标识
	 * @param Id_pesuvdigest
	 */
	public void setId_pesuvdigest(String Id_pesuvdigest) {
		setAttrVal("Id_pesuvdigest", Id_pesuvdigest);
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
	 * 健康管理服务预约ID
	 * @return String
	 */
	public String getId_pehmappt() {
		return ((String) getAttrVal("Id_pehmappt"));
	}	
	/**
	 * 健康管理服务预约ID
	 * @param Id_pehmappt
	 */
	public void setId_pehmappt(String Id_pehmappt) {
		setAttrVal("Id_pehmappt", Id_pehmappt);
	}
	/**
	 * 体检问卷问题分组ID
	 * @return String
	 */
	public String getId_peqacatlog() {
		return ((String) getAttrVal("Id_peqacatlog"));
	}	
	/**
	 * 体检问卷问题分组ID
	 * @param Id_peqacatlog
	 */
	public void setId_peqacatlog(String Id_peqacatlog) {
		setAttrVal("Id_peqacatlog", Id_peqacatlog);
	}
	/**
	 * 体检问卷结果ID
	 * @return String
	 */
	public String getId_perstsurverykey() {
		return ((String) getAttrVal("Id_perstsurverykey"));
	}	
	/**
	 * 体检问卷结果ID
	 * @param Id_perstsurverykey
	 */
	public void setId_perstsurverykey(String Id_perstsurverykey) {
		setAttrVal("Id_perstsurverykey", Id_perstsurverykey);
	}
	/**
	 * 体检问卷ID
	 * @return String
	 */
	public String getId_perstsurvery() {
		return ((String) getAttrVal("Id_perstsurvery"));
	}	
	/**
	 * 体检问卷ID
	 * @param Id_perstsurvery
	 */
	public void setId_perstsurvery(String Id_perstsurvery) {
		setAttrVal("Id_perstsurvery", Id_perstsurvery);
	}
	/**
	 * 体检问卷问题库ID
	 * @return String
	 */
	public String getId_peqacontentdef() {
		return ((String) getAttrVal("Id_peqacontentdef"));
	}	
	/**
	 * 体检问卷问题库ID
	 * @param Id_peqacontentdef
	 */
	public void setId_peqacontentdef(String Id_peqacontentdef) {
		setAttrVal("Id_peqacontentdef", Id_peqacontentdef);
	}
	/**
	 * 体检问卷选项ID
	 * @return String
	 */
	public String getId_peqakeydef() {
		return ((String) getAttrVal("Id_peqakeydef"));
	}	
	/**
	 * 体检问卷选项ID
	 * @param Id_peqakeydef
	 */
	public void setId_peqakeydef(String Id_peqakeydef) {
		setAttrVal("Id_peqakeydef", Id_peqakeydef);
	}
	/**
	 * 备注
	 * @return String
	 */
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}	
	/**
	 * 备注
	 * @param Note
	 */
	public void setNote(String Note) {
		setAttrVal("Note", Note);
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
	 * 预约日期
	 * @return FDate
	 */
	public FDate getDt_appt() {
		return ((FDate) getAttrVal("Dt_appt"));
	}	
	/**
	 * 预约日期
	 * @param Dt_appt
	 */
	public void setDt_appt(FDate Dt_appt) {
		setAttrVal("Dt_appt", Dt_appt);
	}
	/**
	 * 预约号
	 * @return Integer
	 */
	public Integer getNo_appt() {
		return ((Integer) getAttrVal("No_appt"));
	}	
	/**
	 * 预约号
	 * @param No_appt
	 */
	public void setNo_appt(Integer No_appt) {
		setAttrVal("No_appt", No_appt);
	}
	/**
	 * 健康管理状态
	 * @return Integer
	 */
	public Integer getHmstatus() {
		return ((Integer) getAttrVal("Hmstatus"));
	}	
	/**
	 * 健康管理状态
	 * @param Hmstatus
	 */
	public void setHmstatus(Integer Hmstatus) {
		setAttrVal("Hmstatus", Hmstatus);
	}
	/**
	 * 问卷分组编码
	 * @return String
	 */
	public String getCode_group() {
		return ((String) getAttrVal("Code_group"));
	}	
	/**
	 * 问卷分组编码
	 * @param Code_group
	 */
	public void setCode_group(String Code_group) {
		setAttrVal("Code_group", Code_group);
	}
	/**
	 * 问卷分组名称
	 * @return String
	 */
	public String getName_group() {
		return ((String) getAttrVal("Name_group"));
	}	
	/**
	 * 问卷分组名称
	 * @param Name_group
	 */
	public void setName_group(String Name_group) {
		setAttrVal("Name_group", Name_group);
	}
	/**
	 * 体检问卷问题编码
	 * @return String
	 */
	public String getCode_qus() {
		return ((String) getAttrVal("Code_qus"));
	}	
	/**
	 * 体检问卷问题编码
	 * @param Code_qus
	 */
	public void setCode_qus(String Code_qus) {
		setAttrVal("Code_qus", Code_qus);
	}
	/**
	 * 体检问卷问题
	 * @return String
	 */
	public String getName_qus() {
		return ((String) getAttrVal("Name_qus"));
	}	
	/**
	 * 体检问卷问题
	 * @param Name_qus
	 */
	public void setName_qus(String Name_qus) {
		setAttrVal("Name_qus", Name_qus);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_ans() {
		return ((String) getAttrVal("Code_ans"));
	}	
	/**
	 * 编码
	 * @param Code_ans
	 */
	public void setCode_ans(String Code_ans) {
		setAttrVal("Code_ans", Code_ans);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_ans() {
		return ((String) getAttrVal("Name_ans"));
	}	
	/**
	 * 名称
	 * @param Name_ans
	 */
	public void setName_ans(String Name_ans) {
		setAttrVal("Name_ans", Name_ans);
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
		return "Id_pesuvdigest";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_hm_suvdigest";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeSuvDigestDODesc.class);
	}
	
}