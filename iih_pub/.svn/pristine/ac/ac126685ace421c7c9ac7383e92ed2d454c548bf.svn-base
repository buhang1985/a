package iih.sc.scbd.scdeptparam.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.sc.scbd.scdeptparam.d.desc.ScDeptParamDODesc;
import java.math.BigDecimal;

/**
 * 排班科室参数 DO数据 
 * 
 */
public class ScDeptParamDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_DEPTPARAM= "Id_deptparam";
	public static final String ID_SCCA= "Id_scca";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_DEP= "Id_dep";
	public static final String SEC_PERIOD= "Sec_period";
	public static final String SUGEST_EXMINT= "Sugest_exmint";
	public static final String MIN_POL_NUM= "Min_pol_num";
	public static final String POLNO_MAJ= "Polno_maj";
	public static final String VER= "Ver";
	public static final String D_BEGIN= "D_begin";
	public static final String D_END= "D_end";
	public static final String EU_STATUS= "Eu_status";
	public static final String SD_SCTP= "Sd_sctp";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String FG_AUTO_PRN= "Fg_auto_prn";
	public static final String FG_AUTO_PHO= "Fg_auto_pho";
        //是否自动打印条形码 add by yhl 2019/04/16
	public static final String Fg_auto_prn_bar= "Fg_auto_prn_bar";
	public static final String NAME_SCCA= "Name_scca";
	public static final String CODE_SCCA= "Code_scca";
	public static final String NAME_DEPT= "Name_dept";
	public static final String CODE_DEPT= "Code_dept";
	//正常退约时间
	public static final String PERIOD_CANC_NORM= "Period_canc_norm";
	//限制退约时间
	public static final String PERIOD_CANC_LIMIT= "Period_canc_limit";
	//退约时间类型编码
	public static final String SD_CANC_TIME_TP= "Sd_canc_time_tp";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_deptparam() {
		return ((String) getAttrVal("Id_deptparam"));
	}	
	public void setId_deptparam(String Id_deptparam) {
		setAttrVal("Id_deptparam", Id_deptparam);
	}
	public String getId_scca() {
		return ((String) getAttrVal("Id_scca"));
	}	
	public void setId_scca(String Id_scca) {
		setAttrVal("Id_scca", Id_scca);
	}
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}	
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	public Integer getSec_period() {
		return ((Integer) getAttrVal("Sec_period"));
	}	
	public void setSec_period(Integer Sec_period) {
		setAttrVal("Sec_period", Sec_period);
	}
	public Integer getSugest_exmint() {
		return ((Integer) getAttrVal("Sugest_exmint"));
	}	
	public void setSugest_exmint(Integer Sugest_exmint) {
		setAttrVal("Sugest_exmint", Sugest_exmint);
	}
	public Integer getMin_pol_num() {
		return ((Integer) getAttrVal("Min_pol_num"));
	}	
	public void setMin_pol_num(Integer Min_pol_num) {
		setAttrVal("Min_pol_num", Min_pol_num);
	}
	public Integer getPolno_maj() {
		return ((Integer) getAttrVal("Polno_maj"));
	}	
	public void setPolno_maj(Integer Polno_maj) {
		setAttrVal("Polno_maj", Polno_maj);
	}
	public Integer getVer() {
		return ((Integer) getAttrVal("Ver"));
	}	
	public void setVer(Integer Ver) {
		setAttrVal("Ver", Ver);
	}
	public FDate getD_begin() {
		return ((FDate) getAttrVal("D_begin"));
	}	
	public void setD_begin(FDate D_begin) {
		setAttrVal("D_begin", D_begin);
	}
	public FDate getD_end() {
		return ((FDate) getAttrVal("D_end"));
	}	
	public void setD_end(FDate D_end) {
		setAttrVal("D_end", D_end);
	}
	public Integer getEu_status() {
		return ((Integer) getAttrVal("Eu_status"));
	}	
	public void setEu_status(Integer Eu_status) {
		setAttrVal("Eu_status", Eu_status);
	}
	public String getSd_sctp() {
		return ((String) getAttrVal("Sd_sctp"));
	}	
	public void setSd_sctp(String Sd_sctp) {
		setAttrVal("Sd_sctp", Sd_sctp);
	}
	public String getCreatedby() {
		return ((String) getAttrVal("Createdby"));
	}	
	public void setCreatedby(String Createdby) {
		setAttrVal("Createdby", Createdby);
	}
	public FDateTime getCreatedtime() {
		return ((FDateTime) getAttrVal("Createdtime"));
	}	
	public void setCreatedtime(FDateTime Createdtime) {
		setAttrVal("Createdtime", Createdtime);
	}
	public String getModifiedby() {
		return ((String) getAttrVal("Modifiedby"));
	}	
	public void setModifiedby(String Modifiedby) {
		setAttrVal("Modifiedby", Modifiedby);
	}
	public FDateTime getModifiedtime() {
		return ((FDateTime) getAttrVal("Modifiedtime"));
	}	
	public void setModifiedtime(FDateTime Modifiedtime) {
		setAttrVal("Modifiedtime", Modifiedtime);
	}
	public FBoolean getFg_auto_prn() {
		return ((FBoolean) getAttrVal("Fg_auto_prn"));
	}	
	public void setFg_auto_prn(FBoolean Fg_auto_prn) {
		setAttrVal("Fg_auto_prn", Fg_auto_prn);
	}
	public FBoolean getFg_auto_pho() {
		return ((FBoolean) getAttrVal("Fg_auto_pho"));
	}	
	public void setFg_auto_pho(FBoolean Fg_auto_pho) {
		setAttrVal("Fg_auto_pho", Fg_auto_pho);
	}
	public String getName_scca() {
		return ((String) getAttrVal("Name_scca"));
	}	
	public void setName_scca(String Name_scca) {
		setAttrVal("Name_scca", Name_scca);
	}
	public String getCode_scca() {
		return ((String) getAttrVal("Code_scca"));
	}	
	public void setCode_scca(String Code_scca) {
		setAttrVal("Code_scca", Code_scca);
	}
	public String getName_dept() {
		return ((String) getAttrVal("Name_dept"));
	}	
	public void setName_dept(String Name_dept) {
		setAttrVal("Name_dept", Name_dept);
	}
	public String getCode_dept() {
		return ((String) getAttrVal("Code_dept"));
	}	
	public void setCode_dept(String Code_dept) {
		setAttrVal("Code_dept", Code_dept);
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
	/**
	 * 是否自动打印条形码
	 * @return FBoolean
	 */
	public FBoolean getFg_auto_prn_bar() {
		return ((FBoolean) getAttrVal("Fg_auto_prn_bar"));
	}	
	/**
	 * 是否自动打印条形码
	 * @param Fg_auto_prn_bar
	 */
	public void setFg_auto_prn_bar(FBoolean Fg_auto_prn_bar) {
		setAttrVal("Fg_auto_prn_bar", Fg_auto_prn_bar);
	}
	/**
	 * 退约时间类型编码
	 * @return String
	 */
	public String getSd_canc_time_tp() {
		return ((String) getAttrVal("Sd_canc_time_tp"));
	}	
	/**
	 * 退约时间类型编码
	 * @param Sd_canc_time_tp
	 */
	public void setSd_canc_time_tp(String Sd_canc_time_tp) {
		setAttrVal("Sd_canc_time_tp", Sd_canc_time_tp);
	}
	
	/**
	 * 正常退约时间
	 * @return Integer
	 */
	public Integer getPeriod_canc_norm() {
		return ((Integer) getAttrVal("Period_canc_norm"));
	}	
	/**
	 * 正常退约时间
	 * @param Period_canc_norm
	 */
	public void setPeriod_canc_norm(Integer Period_canc_norm) {
		setAttrVal("Period_canc_norm", Period_canc_norm);
	}
	/**
	 * 限制退约时间
	 * @return Integer
	 */
	public Integer getPeriod_canc_limit() {
		return ((Integer) getAttrVal("Period_canc_limit"));
	}	
	/**
	 * 限制退约时间
	 * @param Period_canc_limit
	 */
	public void setPeriod_canc_limit(Integer Period_canc_limit) {
		setAttrVal("Period_canc_limit", Period_canc_limit);
	}
//	@Override
//	public java.lang.String getParentPKFieldName() {
//		return null;
//	}
  
	@Override
	public String getPKFieldName() {
		return "Id_deptparam";
	}
	
	@Override
	public String getTableName() {	  
		return "sc_dep_param";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ScDeptParamDODesc.class);
	}
	
}