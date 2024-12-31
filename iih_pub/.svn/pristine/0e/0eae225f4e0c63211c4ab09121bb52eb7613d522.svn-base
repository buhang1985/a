package iih.pe.papt.pecorpappt.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.papt.pecorpappt.d.desc.PeCorpApptDODesc;
import java.math.BigDecimal;

/**
 * 体检团体预约单 DO数据 
 * 
 */
public class PeCorpApptDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检团体预约主键标识
	public static final String ID_PECORPAPPT= "Id_pecorpappt";
	//体检团体预约父ID
	public static final String ID_PECORPAPPT_PAR= "Id_pecorpappt_par";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//体检单位ID
	public static final String ID_PECORPBINFO= "Id_pecorpbinfo";
	//年度
	public static final String YEAR= "Year";
	//团体体检状态
	public static final String PESTATUSCORP= "Pestatuscorp";
	//登记日期
	public static final String DT_CORPREG= "Dt_corpreg";
	//合同开始时间
	public static final String DT_BEGIN= "Dt_begin";
	//合同截止时间
	public static final String DT_END= "Dt_end";
	//合同号
	public static final String CONTRACT_NO= "Contract_no";
	//合同人数
	public static final String CONTRACT_PSN= "Contract_psn";
	//合同金额
	public static final String CONTRACT_AMT= "Contract_amt";
	//未检查项目退费标识
	public static final String FG_RETURNS= "Fg_returns";
	//日接待上线
	public static final String DAY_UPLIMIT= "Day_uplimit";
	//个人支付标识
	public static final String FG_MODE_PERSON= "Fg_mode_person";
	//个人加项支付标识
	public static final String FG_MODE_PERSON_ADD= "Fg_mode_person_add";
	//家属支付标识
	public static final String FG_MODE_FAMILY= "Fg_mode_family";
	//家属加项支付标识
	public static final String FG_MODE_FAMILY_ADD= "Fg_mode_family_add";
	//体检结束标识
	public static final String FG_FINISH= "Fg_finish";
	//体检结束时间
	public static final String DT_FINISH= "Dt_finish";
	//团体预约唯一号
	public static final String PE_CORP_CODE= "Pe_corp_code";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//备注
	public static final String RMK_CORP= "Rmk_corp";
	//体检客户分组ID
	public static final String ID_PEMULTIGROUP= "Id_pemultigroup";
	//体检客户分组SD
	public static final String SD_PEMULTIGROUP= "Sd_pemultigroup";
	//单位编码
	public static final String CODE_CORP= "Code_corp";
	//单位名称
	public static final String NAME_CORP= "Name_corp";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检团体预约主键标识
	 * @return String
	 */
	public String getId_pecorpappt() {
		return ((String) getAttrVal("Id_pecorpappt"));
	}	
	/**
	 * 体检团体预约主键标识
	 * @param Id_pecorpappt
	 */
	public void setId_pecorpappt(String Id_pecorpappt) {
		setAttrVal("Id_pecorpappt", Id_pecorpappt);
	}
	/**
	 * 体检团体预约父ID
	 * @return String
	 */
	public String getId_pecorpappt_par() {
		return ((String) getAttrVal("Id_pecorpappt_par"));
	}	
	/**
	 * 体检团体预约父ID
	 * @param Id_pecorpappt_par
	 */
	public void setId_pecorpappt_par(String Id_pecorpappt_par) {
		setAttrVal("Id_pecorpappt_par", Id_pecorpappt_par);
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
	 * 体检单位ID
	 * @return String
	 */
	public String getId_pecorpbinfo() {
		return ((String) getAttrVal("Id_pecorpbinfo"));
	}	
	/**
	 * 体检单位ID
	 * @param Id_pecorpbinfo
	 */
	public void setId_pecorpbinfo(String Id_pecorpbinfo) {
		setAttrVal("Id_pecorpbinfo", Id_pecorpbinfo);
	}
	/**
	 * 年度
	 * @return Integer
	 */
	public Integer getYear() {
		return ((Integer) getAttrVal("Year"));
	}	
	/**
	 * 年度
	 * @param Year
	 */
	public void setYear(Integer Year) {
		setAttrVal("Year", Year);
	}
	/**
	 * 团体体检状态
	 * @return Integer
	 */
	public Integer getPestatuscorp() {
		return ((Integer) getAttrVal("Pestatuscorp"));
	}	
	/**
	 * 团体体检状态
	 * @param Pestatuscorp
	 */
	public void setPestatuscorp(Integer Pestatuscorp) {
		setAttrVal("Pestatuscorp", Pestatuscorp);
	}
	/**
	 * 登记日期
	 * @return FDate
	 */
	public FDate getDt_corpreg() {
		return ((FDate) getAttrVal("Dt_corpreg"));
	}	
	/**
	 * 登记日期
	 * @param Dt_corpreg
	 */
	public void setDt_corpreg(FDate Dt_corpreg) {
		setAttrVal("Dt_corpreg", Dt_corpreg);
	}
	/**
	 * 合同开始时间
	 * @return FDate
	 */
	public FDate getDt_begin() {
		return ((FDate) getAttrVal("Dt_begin"));
	}	
	/**
	 * 合同开始时间
	 * @param Dt_begin
	 */
	public void setDt_begin(FDate Dt_begin) {
		setAttrVal("Dt_begin", Dt_begin);
	}
	/**
	 * 合同截止时间
	 * @return FDate
	 */
	public FDate getDt_end() {
		return ((FDate) getAttrVal("Dt_end"));
	}	
	/**
	 * 合同截止时间
	 * @param Dt_end
	 */
	public void setDt_end(FDate Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	/**
	 * 合同号
	 * @return String
	 */
	public String getContract_no() {
		return ((String) getAttrVal("Contract_no"));
	}	
	/**
	 * 合同号
	 * @param Contract_no
	 */
	public void setContract_no(String Contract_no) {
		setAttrVal("Contract_no", Contract_no);
	}
	/**
	 * 合同人数
	 * @return Integer
	 */
	public Integer getContract_psn() {
		return ((Integer) getAttrVal("Contract_psn"));
	}	
	/**
	 * 合同人数
	 * @param Contract_psn
	 */
	public void setContract_psn(Integer Contract_psn) {
		setAttrVal("Contract_psn", Contract_psn);
	}
	/**
	 * 合同金额
	 * @return FDouble
	 */
	public FDouble getContract_amt() {
		return ((FDouble) getAttrVal("Contract_amt"));
	}	
	/**
	 * 合同金额
	 * @param Contract_amt
	 */
	public void setContract_amt(FDouble Contract_amt) {
		setAttrVal("Contract_amt", Contract_amt);
	}
	/**
	 * 未检查项目退费标识
	 * @return FBoolean
	 */
	public FBoolean getFg_returns() {
		return ((FBoolean) getAttrVal("Fg_returns"));
	}	
	/**
	 * 未检查项目退费标识
	 * @param Fg_returns
	 */
	public void setFg_returns(FBoolean Fg_returns) {
		setAttrVal("Fg_returns", Fg_returns);
	}
	/**
	 * 日接待上线
	 * @return Integer
	 */
	public Integer getDay_uplimit() {
		return ((Integer) getAttrVal("Day_uplimit"));
	}	
	/**
	 * 日接待上线
	 * @param Day_uplimit
	 */
	public void setDay_uplimit(Integer Day_uplimit) {
		setAttrVal("Day_uplimit", Day_uplimit);
	}
	/**
	 * 个人支付标识
	 * @return FBoolean
	 */
	public FBoolean getFg_mode_person() {
		return ((FBoolean) getAttrVal("Fg_mode_person"));
	}	
	/**
	 * 个人支付标识
	 * @param Fg_mode_person
	 */
	public void setFg_mode_person(FBoolean Fg_mode_person) {
		setAttrVal("Fg_mode_person", Fg_mode_person);
	}
	/**
	 * 个人加项支付标识
	 * @return FBoolean
	 */
	public FBoolean getFg_mode_person_add() {
		return ((FBoolean) getAttrVal("Fg_mode_person_add"));
	}	
	/**
	 * 个人加项支付标识
	 * @param Fg_mode_person_add
	 */
	public void setFg_mode_person_add(FBoolean Fg_mode_person_add) {
		setAttrVal("Fg_mode_person_add", Fg_mode_person_add);
	}
	/**
	 * 家属支付标识
	 * @return FBoolean
	 */
	public FBoolean getFg_mode_family() {
		return ((FBoolean) getAttrVal("Fg_mode_family"));
	}	
	/**
	 * 家属支付标识
	 * @param Fg_mode_family
	 */
	public void setFg_mode_family(FBoolean Fg_mode_family) {
		setAttrVal("Fg_mode_family", Fg_mode_family);
	}
	/**
	 * 家属加项支付标识
	 * @return FBoolean
	 */
	public FBoolean getFg_mode_family_add() {
		return ((FBoolean) getAttrVal("Fg_mode_family_add"));
	}	
	/**
	 * 家属加项支付标识
	 * @param Fg_mode_family_add
	 */
	public void setFg_mode_family_add(FBoolean Fg_mode_family_add) {
		setAttrVal("Fg_mode_family_add", Fg_mode_family_add);
	}
	/**
	 * 体检结束标识
	 * @return FBoolean
	 */
	public FBoolean getFg_finish() {
		return ((FBoolean) getAttrVal("Fg_finish"));
	}	
	/**
	 * 体检结束标识
	 * @param Fg_finish
	 */
	public void setFg_finish(FBoolean Fg_finish) {
		setAttrVal("Fg_finish", Fg_finish);
	}
	/**
	 * 体检结束时间
	 * @return FDate
	 */
	public FDate getDt_finish() {
		return ((FDate) getAttrVal("Dt_finish"));
	}	
	/**
	 * 体检结束时间
	 * @param Dt_finish
	 */
	public void setDt_finish(FDate Dt_finish) {
		setAttrVal("Dt_finish", Dt_finish);
	}
	/**
	 * 团体预约唯一号
	 * @return String
	 */
	public String getPe_corp_code() {
		return ((String) getAttrVal("Pe_corp_code"));
	}	
	/**
	 * 团体预约唯一号
	 * @param Pe_corp_code
	 */
	public void setPe_corp_code(String Pe_corp_code) {
		setAttrVal("Pe_corp_code", Pe_corp_code);
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
	 * 体检客户分组ID
	 * @return String
	 */
	public String getId_pemultigroup() {
		return ((String) getAttrVal("Id_pemultigroup"));
	}	
	/**
	 * 体检客户分组ID
	 * @param Id_pemultigroup
	 */
	public void setId_pemultigroup(String Id_pemultigroup) {
		setAttrVal("Id_pemultigroup", Id_pemultigroup);
	}
	/**
	 * 体检客户分组SD
	 * @return String
	 */
	public String getSd_pemultigroup() {
		return ((String) getAttrVal("Sd_pemultigroup"));
	}	
	/**
	 * 体检客户分组SD
	 * @param Sd_pemultigroup
	 */
	public void setSd_pemultigroup(String Sd_pemultigroup) {
		setAttrVal("Sd_pemultigroup", Sd_pemultigroup);
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
		return "Id_pecorpappt";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_apt_pecorpappt";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeCorpApptDODesc.class);
	}
	
}