package iih.pe.pwf.pedwsquery.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pwf.pedwsquery.d.desc.PeDwsQueryDODesc;
import java.math.BigDecimal;

/**
 * 体检分检检索 DO数据 
 * 
 */
public class PeDwsQueryDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检分检检索主键标识
	public static final String ID_PEDWSQUERY= "Id_pedwsquery";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//开始日期
	public static final String DT_BEGIN= "Dt_begin";
	//结束日期
	public static final String DT_END= "Dt_end";
	//检索日期类型
	public static final String DTTP= "Dttp";
	//所属诊间
	public static final String ID_DEP= "Id_dep";
	//体检预约单ID
	public static final String ID_PEPSNAPPT= "Id_pepsnappt";
	//建议过滤
	public static final String SUGGTP= "Suggtp";
	//过滤分类
	public static final String FILTERCA= "Filterca";
	//团体
	public static final String ID_CORP= "Id_corp";
	//总检状态过滤
	public static final String FILTEROVAL= "Filteroval";
	//阳性追踪状态过滤
	public static final String FILTERTRACK= "Filtertrack";
	//健康管理状态过滤
	public static final String FILTERHM= "Filterhm";
	//总检排序方式
	public static final String SORTOVAL= "Sortoval";
	//备注
	public static final String RMK_CORP= "Rmk_corp";
	//总检医生
	public static final String ID_OVAL_DOCTOR= "Id_oval_doctor";
	//团体预约单ID
	public static final String ID_CORPAPPT= "Id_corpappt";
	//团体分组ID
	public static final String ID_CORPGRP= "Id_corpgrp";
	//体检科室ID
	public static final String ID_PEDEPTSET= "Id_pedeptset";
	//体检编码
	public static final String PE_CODE= "Pe_code";
	//检索关键字类型
	public static final String KEYTP= "Keytp";
	//体检者身份
	public static final String IDENTITYTP= "Identitytp";
	//诊间编码
	public static final String CODE_ROOM= "Code_room";
	//诊间名称
	public static final String NAME_ROOM= "Name_room";
	//客户姓名
	public static final String NAME_PSN= "Name_psn";
	//年龄
	public static final String AGE_PSN= "Age_psn";
	//性别编码
	public static final String SD_SEX_PSN= "Sd_sex_psn";
	//体检流程号
	public static final String CARD_PE= "Card_pe";
	//单位编码
	public static final String CODE_CORP= "Code_corp";
	//单位名称
	public static final String NAME_CORP= "Name_corp";
	//总检医生名称
	public static final String NAME_OVAL= "Name_oval";
	//总检医生编码
	public static final String CODE_OVAL= "Code_oval";
	//体检科室编码
	public static final String CODE_DEPT= "Code_dept";
	//体检科室名称
	public static final String NAME_DEPT= "Name_dept";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检分检检索主键标识
	 * @return String
	 */
	public String getId_pedwsquery() {
		return ((String) getAttrVal("Id_pedwsquery"));
	}	
	/**
	 * 体检分检检索主键标识
	 * @param Id_pedwsquery
	 */
	public void setId_pedwsquery(String Id_pedwsquery) {
		setAttrVal("Id_pedwsquery", Id_pedwsquery);
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
	 * 开始日期
	 * @return FDate
	 */
	public FDate getDt_begin() {
		return ((FDate) getAttrVal("Dt_begin"));
	}	
	/**
	 * 开始日期
	 * @param Dt_begin
	 */
	public void setDt_begin(FDate Dt_begin) {
		setAttrVal("Dt_begin", Dt_begin);
	}
	/**
	 * 结束日期
	 * @return FDate
	 */
	public FDate getDt_end() {
		return ((FDate) getAttrVal("Dt_end"));
	}	
	/**
	 * 结束日期
	 * @param Dt_end
	 */
	public void setDt_end(FDate Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	/**
	 * 检索日期类型
	 * @return Integer
	 */
	public Integer getDttp() {
		return ((Integer) getAttrVal("Dttp"));
	}	
	/**
	 * 检索日期类型
	 * @param Dttp
	 */
	public void setDttp(Integer Dttp) {
		setAttrVal("Dttp", Dttp);
	}
	/**
	 * 所属诊间
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}	
	/**
	 * 所属诊间
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	/**
	 * 体检预约单ID
	 * @return String
	 */
	public String getId_pepsnappt() {
		return ((String) getAttrVal("Id_pepsnappt"));
	}	
	/**
	 * 体检预约单ID
	 * @param Id_pepsnappt
	 */
	public void setId_pepsnappt(String Id_pepsnappt) {
		setAttrVal("Id_pepsnappt", Id_pepsnappt);
	}
	/**
	 * 建议过滤
	 * @return Integer
	 */
	public Integer getSuggtp() {
		return ((Integer) getAttrVal("Suggtp"));
	}	
	/**
	 * 建议过滤
	 * @param Suggtp
	 */
	public void setSuggtp(Integer Suggtp) {
		setAttrVal("Suggtp", Suggtp);
	}
	/**
	 * 过滤分类
	 * @return Integer
	 */
	public Integer getFilterca() {
		return ((Integer) getAttrVal("Filterca"));
	}	
	/**
	 * 过滤分类
	 * @param Filterca
	 */
	public void setFilterca(Integer Filterca) {
		setAttrVal("Filterca", Filterca);
	}
	/**
	 * 团体
	 * @return String
	 */
	public String getId_corp() {
		return ((String) getAttrVal("Id_corp"));
	}	
	/**
	 * 团体
	 * @param Id_corp
	 */
	public void setId_corp(String Id_corp) {
		setAttrVal("Id_corp", Id_corp);
	}
	/**
	 * 总检状态过滤
	 * @return Integer
	 */
	public Integer getFilteroval() {
		return ((Integer) getAttrVal("Filteroval"));
	}	
	/**
	 * 总检状态过滤
	 * @param Filteroval
	 */
	public void setFilteroval(Integer Filteroval) {
		setAttrVal("Filteroval", Filteroval);
	}
	/**
	 * 阳性追踪状态过滤
	 * @return Integer
	 */
	public Integer getFiltertrack() {
		return ((Integer) getAttrVal("Filtertrack"));
	}	
	/**
	 * 阳性追踪状态过滤
	 * @param Filtertrack
	 */
	public void setFiltertrack(Integer Filtertrack) {
		setAttrVal("Filtertrack", Filtertrack);
	}
	/**
	 * 健康管理状态过滤
	 * @return Integer
	 */
	public Integer getFilterhm() {
		return ((Integer) getAttrVal("Filterhm"));
	}	
	/**
	 * 健康管理状态过滤
	 * @param Filterhm
	 */
	public void setFilterhm(Integer Filterhm) {
		setAttrVal("Filterhm", Filterhm);
	}
	/**
	 * 总检排序方式
	 * @return Integer
	 */
	public Integer getSortoval() {
		return ((Integer) getAttrVal("Sortoval"));
	}	
	/**
	 * 总检排序方式
	 * @param Sortoval
	 */
	public void setSortoval(Integer Sortoval) {
		setAttrVal("Sortoval", Sortoval);
	}
	/**
	 * 备注
	 * @return String
	 */
	public String getRmk_corp() {
		return ((String) getAttrVal("Rmk_corp"));
	}	
	/**
	 * 备注
	 * @param Rmk_corp
	 */
	public void setRmk_corp(String Rmk_corp) {
		setAttrVal("Rmk_corp", Rmk_corp);
	}
	/**
	 * 总检医生
	 * @return String
	 */
	public String getId_oval_doctor() {
		return ((String) getAttrVal("Id_oval_doctor"));
	}	
	/**
	 * 总检医生
	 * @param Id_oval_doctor
	 */
	public void setId_oval_doctor(String Id_oval_doctor) {
		setAttrVal("Id_oval_doctor", Id_oval_doctor);
	}
	/**
	 * 团体预约单ID
	 * @return String
	 */
	public String getId_corpappt() {
		return ((String) getAttrVal("Id_corpappt"));
	}	
	/**
	 * 团体预约单ID
	 * @param Id_corpappt
	 */
	public void setId_corpappt(String Id_corpappt) {
		setAttrVal("Id_corpappt", Id_corpappt);
	}
	/**
	 * 团体分组ID
	 * @return String
	 */
	public String getId_corpgrp() {
		return ((String) getAttrVal("Id_corpgrp"));
	}	
	/**
	 * 团体分组ID
	 * @param Id_corpgrp
	 */
	public void setId_corpgrp(String Id_corpgrp) {
		setAttrVal("Id_corpgrp", Id_corpgrp);
	}
	/**
	 * 体检科室ID
	 * @return String
	 */
	public String getId_pedeptset() {
		return ((String) getAttrVal("Id_pedeptset"));
	}	
	/**
	 * 体检科室ID
	 * @param Id_pedeptset
	 */
	public void setId_pedeptset(String Id_pedeptset) {
		setAttrVal("Id_pedeptset", Id_pedeptset);
	}
	/**
	 * 体检编码
	 * @return String
	 */
	public String getPe_code() {
		return ((String) getAttrVal("Pe_code"));
	}	
	/**
	 * 体检编码
	 * @param Pe_code
	 */
	public void setPe_code(String Pe_code) {
		setAttrVal("Pe_code", Pe_code);
	}
	/**
	 * 检索关键字类型
	 * @return Integer
	 */
	public Integer getKeytp() {
		return ((Integer) getAttrVal("Keytp"));
	}	
	/**
	 * 检索关键字类型
	 * @param Keytp
	 */
	public void setKeytp(Integer Keytp) {
		setAttrVal("Keytp", Keytp);
	}
	/**
	 * 体检者身份
	 * @return Integer
	 */
	public Integer getIdentitytp() {
		return ((Integer) getAttrVal("Identitytp"));
	}	
	/**
	 * 体检者身份
	 * @param Identitytp
	 */
	public void setIdentitytp(Integer Identitytp) {
		setAttrVal("Identitytp", Identitytp);
	}
	/**
	 * 诊间编码
	 * @return String
	 */
	public String getCode_room() {
		return ((String) getAttrVal("Code_room"));
	}	
	/**
	 * 诊间编码
	 * @param Code_room
	 */
	public void setCode_room(String Code_room) {
		setAttrVal("Code_room", Code_room);
	}
	/**
	 * 诊间名称
	 * @return String
	 */
	public String getName_room() {
		return ((String) getAttrVal("Name_room"));
	}	
	/**
	 * 诊间名称
	 * @param Name_room
	 */
	public void setName_room(String Name_room) {
		setAttrVal("Name_room", Name_room);
	}
	/**
	 * 客户姓名
	 * @return String
	 */
	public String getName_psn() {
		return ((String) getAttrVal("Name_psn"));
	}	
	/**
	 * 客户姓名
	 * @param Name_psn
	 */
	public void setName_psn(String Name_psn) {
		setAttrVal("Name_psn", Name_psn);
	}
	/**
	 * 年龄
	 * @return Integer
	 */
	public Integer getAge_psn() {
		return ((Integer) getAttrVal("Age_psn"));
	}	
	/**
	 * 年龄
	 * @param Age_psn
	 */
	public void setAge_psn(Integer Age_psn) {
		setAttrVal("Age_psn", Age_psn);
	}
	/**
	 * 性别编码
	 * @return Integer
	 */
	public Integer getSd_sex_psn() {
		return ((Integer) getAttrVal("Sd_sex_psn"));
	}	
	/**
	 * 性别编码
	 * @param Sd_sex_psn
	 */
	public void setSd_sex_psn(Integer Sd_sex_psn) {
		setAttrVal("Sd_sex_psn", Sd_sex_psn);
	}
	/**
	 * 体检流程号
	 * @return String
	 */
	public String getCard_pe() {
		return ((String) getAttrVal("Card_pe"));
	}	
	/**
	 * 体检流程号
	 * @param Card_pe
	 */
	public void setCard_pe(String Card_pe) {
		setAttrVal("Card_pe", Card_pe);
	}
	/**
	 * 单位编码
	 * @return String
	 */
	public String getCode_corp() {
		return ((String) getAttrVal("Code_corp"));
	}	
	/**
	 * 单位编码
	 * @param Code_corp
	 */
	public void setCode_corp(String Code_corp) {
		setAttrVal("Code_corp", Code_corp);
	}
	/**
	 * 单位名称
	 * @return String
	 */
	public String getName_corp() {
		return ((String) getAttrVal("Name_corp"));
	}	
	/**
	 * 单位名称
	 * @param Name_corp
	 */
	public void setName_corp(String Name_corp) {
		setAttrVal("Name_corp", Name_corp);
	}
	/**
	 * 总检医生名称
	 * @return String
	 */
	public String getName_oval() {
		return ((String) getAttrVal("Name_oval"));
	}	
	/**
	 * 总检医生名称
	 * @param Name_oval
	 */
	public void setName_oval(String Name_oval) {
		setAttrVal("Name_oval", Name_oval);
	}
	/**
	 * 总检医生编码
	 * @return String
	 */
	public String getCode_oval() {
		return ((String) getAttrVal("Code_oval"));
	}	
	/**
	 * 总检医生编码
	 * @param Code_oval
	 */
	public void setCode_oval(String Code_oval) {
		setAttrVal("Code_oval", Code_oval);
	}
	/**
	 * 体检科室编码
	 * @return String
	 */
	public String getCode_dept() {
		return ((String) getAttrVal("Code_dept"));
	}	
	/**
	 * 体检科室编码
	 * @param Code_dept
	 */
	public void setCode_dept(String Code_dept) {
		setAttrVal("Code_dept", Code_dept);
	}
	/**
	 * 体检科室名称
	 * @return String
	 */
	public String getName_dept() {
		return ((String) getAttrVal("Name_dept"));
	}	
	/**
	 * 体检科室名称
	 * @param Name_dept
	 */
	public void setName_dept(String Name_dept) {
		setAttrVal("Name_dept", Name_dept);
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
		return "Id_pedwsquery";
	}
	
	@Override
	public String getTableName() {	  
		return "";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeDwsQueryDODesc.class);
	}
	
}