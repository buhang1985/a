package iih.cssd.dpp.stz.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.cssd.dpp.stz.d.desc.CssddfpstzDODesc;
import java.math.BigDecimal;

/**
 * 包灭菌 DO数据 
 * 
 */
public class CssddfpstzDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//包灭菌
	public static final String ID_DFP_STZ= "Id_dfp_stz";
	//组织
	public static final String ID_ORG= "Id_org";
	//集团
	public static final String ID_GRP= "Id_grp";
	//灭菌设备
	public static final String ID_DFP_INSTR= "Id_dfp_instr";
	//灭菌方式
	public static final String ID_PKGSTZ= "Id_pkgstz";
	//灭菌方式编码
	public static final String SD_PKGSTZ= "Sd_pkgstz";
	//灭菌程序
	public static final String ID_PRO= "Id_pro";
	//灭菌程序编码
	public static final String SD_PRO= "Sd_pro";
	//灭菌开始时间
	public static final String DT_BEGIN= "Dt_begin";
	//灭菌截止时间
	public static final String DT_END= "Dt_end";
	//灭菌日期
	public static final String DT_STZ= "Dt_stz";
	//灭菌人
	public static final String ID_EMP_STZ= "Id_emp_stz";
	//灭菌科室
	public static final String ID_DEP_STZ= "Id_dep_stz";
	//灭菌结果id
	public static final String ID_RESULT= "Id_result";
	//灭菌结果sd
	public static final String SD_RESULT= "Sd_result";
	//锅次
	public static final String SORTNO= "Sortno";
	//灭菌锅次码
	public static final String NO_BAR= "No_bar";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//灭菌设备名称
	public static final String NAME_DFP_INSTR= "Name_dfp_instr";
	//灭菌方式名称
	public static final String NAME_PKGSTZ= "Name_pkgstz";
	//灭菌程序名称
	public static final String NAME_PRO= "Name_pro";
	//灭菌人姓名
	public static final String NAME_EMP_STZ= "Name_emp_stz";
	//灭菌科室名称
	public static final String NAME_DEP_STZ= "Name_dep_stz";
	//灭菌结果名称
	public static final String NAME_RESULT= "Name_result";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 包灭菌
	 * @return String
	 */
	public String getId_dfp_stz() {
		return ((String) getAttrVal("Id_dfp_stz"));
	}	
	/**
	 * 包灭菌
	 * @param Id_dfp_stz
	 */
	public void setId_dfp_stz(String Id_dfp_stz) {
		setAttrVal("Id_dfp_stz", Id_dfp_stz);
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
	 * 灭菌设备
	 * @return String
	 */
	public String getId_dfp_instr() {
		return ((String) getAttrVal("Id_dfp_instr"));
	}	
	/**
	 * 灭菌设备
	 * @param Id_dfp_instr
	 */
	public void setId_dfp_instr(String Id_dfp_instr) {
		setAttrVal("Id_dfp_instr", Id_dfp_instr);
	}
	/**
	 * 灭菌方式
	 * @return String
	 */
	public String getId_pkgstz() {
		return ((String) getAttrVal("Id_pkgstz"));
	}	
	/**
	 * 灭菌方式
	 * @param Id_pkgstz
	 */
	public void setId_pkgstz(String Id_pkgstz) {
		setAttrVal("Id_pkgstz", Id_pkgstz);
	}
	/**
	 * 灭菌方式编码
	 * @return String
	 */
	public String getSd_pkgstz() {
		return ((String) getAttrVal("Sd_pkgstz"));
	}	
	/**
	 * 灭菌方式编码
	 * @param Sd_pkgstz
	 */
	public void setSd_pkgstz(String Sd_pkgstz) {
		setAttrVal("Sd_pkgstz", Sd_pkgstz);
	}
	/**
	 * 灭菌程序
	 * @return String
	 */
	public String getId_pro() {
		return ((String) getAttrVal("Id_pro"));
	}	
	/**
	 * 灭菌程序
	 * @param Id_pro
	 */
	public void setId_pro(String Id_pro) {
		setAttrVal("Id_pro", Id_pro);
	}
	/**
	 * 灭菌程序编码
	 * @return String
	 */
	public String getSd_pro() {
		return ((String) getAttrVal("Sd_pro"));
	}	
	/**
	 * 灭菌程序编码
	 * @param Sd_pro
	 */
	public void setSd_pro(String Sd_pro) {
		setAttrVal("Sd_pro", Sd_pro);
	}
	/**
	 * 灭菌开始时间
	 * @return FDateTime
	 */
	public FDateTime getDt_begin() {
		return ((FDateTime) getAttrVal("Dt_begin"));
	}	
	/**
	 * 灭菌开始时间
	 * @param Dt_begin
	 */
	public void setDt_begin(FDateTime Dt_begin) {
		setAttrVal("Dt_begin", Dt_begin);
	}
	/**
	 * 灭菌截止时间
	 * @return FDateTime
	 */
	public FDateTime getDt_end() {
		return ((FDateTime) getAttrVal("Dt_end"));
	}	
	/**
	 * 灭菌截止时间
	 * @param Dt_end
	 */
	public void setDt_end(FDateTime Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	/**
	 * 灭菌日期
	 * @return FDate
	 */
	public FDate getDt_stz() {
		return ((FDate) getAttrVal("Dt_stz"));
	}	
	/**
	 * 灭菌日期
	 * @param Dt_stz
	 */
	public void setDt_stz(FDate Dt_stz) {
		setAttrVal("Dt_stz", Dt_stz);
	}
	/**
	 * 灭菌人
	 * @return String
	 */
	public String getId_emp_stz() {
		return ((String) getAttrVal("Id_emp_stz"));
	}	
	/**
	 * 灭菌人
	 * @param Id_emp_stz
	 */
	public void setId_emp_stz(String Id_emp_stz) {
		setAttrVal("Id_emp_stz", Id_emp_stz);
	}
	/**
	 * 灭菌科室
	 * @return String
	 */
	public String getId_dep_stz() {
		return ((String) getAttrVal("Id_dep_stz"));
	}	
	/**
	 * 灭菌科室
	 * @param Id_dep_stz
	 */
	public void setId_dep_stz(String Id_dep_stz) {
		setAttrVal("Id_dep_stz", Id_dep_stz);
	}
	/**
	 * 灭菌结果id
	 * @return String
	 */
	public String getId_result() {
		return ((String) getAttrVal("Id_result"));
	}	
	/**
	 * 灭菌结果id
	 * @param Id_result
	 */
	public void setId_result(String Id_result) {
		setAttrVal("Id_result", Id_result);
	}
	/**
	 * 灭菌结果sd
	 * @return String
	 */
	public String getSd_result() {
		return ((String) getAttrVal("Sd_result"));
	}	
	/**
	 * 灭菌结果sd
	 * @param Sd_result
	 */
	public void setSd_result(String Sd_result) {
		setAttrVal("Sd_result", Sd_result);
	}
	/**
	 * 锅次
	 * @return Integer
	 */
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	/**
	 * 锅次
	 * @param Sortno
	 */
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	/**
	 * 灭菌锅次码
	 * @return String
	 */
	public String getNo_bar() {
		return ((String) getAttrVal("No_bar"));
	}	
	/**
	 * 灭菌锅次码
	 * @param No_bar
	 */
	public void setNo_bar(String No_bar) {
		setAttrVal("No_bar", No_bar);
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
	 * 灭菌设备名称
	 * @return String
	 */
	public String getName_dfp_instr() {
		return ((String) getAttrVal("Name_dfp_instr"));
	}	
	/**
	 * 灭菌设备名称
	 * @param Name_dfp_instr
	 */
	public void setName_dfp_instr(String Name_dfp_instr) {
		setAttrVal("Name_dfp_instr", Name_dfp_instr);
	}
	/**
	 * 灭菌方式名称
	 * @return String
	 */
	public String getName_pkgstz() {
		return ((String) getAttrVal("Name_pkgstz"));
	}	
	/**
	 * 灭菌方式名称
	 * @param Name_pkgstz
	 */
	public void setName_pkgstz(String Name_pkgstz) {
		setAttrVal("Name_pkgstz", Name_pkgstz);
	}
	/**
	 * 灭菌程序名称
	 * @return String
	 */
	public String getName_pro() {
		return ((String) getAttrVal("Name_pro"));
	}	
	/**
	 * 灭菌程序名称
	 * @param Name_pro
	 */
	public void setName_pro(String Name_pro) {
		setAttrVal("Name_pro", Name_pro);
	}
	/**
	 * 灭菌人姓名
	 * @return String
	 */
	public String getName_emp_stz() {
		return ((String) getAttrVal("Name_emp_stz"));
	}	
	/**
	 * 灭菌人姓名
	 * @param Name_emp_stz
	 */
	public void setName_emp_stz(String Name_emp_stz) {
		setAttrVal("Name_emp_stz", Name_emp_stz);
	}
	/**
	 * 灭菌科室名称
	 * @return String
	 */
	public String getName_dep_stz() {
		return ((String) getAttrVal("Name_dep_stz"));
	}	
	/**
	 * 灭菌科室名称
	 * @param Name_dep_stz
	 */
	public void setName_dep_stz(String Name_dep_stz) {
		setAttrVal("Name_dep_stz", Name_dep_stz);
	}
	/**
	 * 灭菌结果名称
	 * @return String
	 */
	public String getName_result() {
		return ((String) getAttrVal("Name_result"));
	}	
	/**
	 * 灭菌结果名称
	 * @param Name_result
	 */
	public void setName_result(String Name_result) {
		setAttrVal("Name_result", Name_result);
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
		return "Id_dfp_stz";
	}
	
	@Override
	public String getTableName() {	  
		return "CSSD_DFP_STZ";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CssddfpstzDODesc.class);
	}
	
}