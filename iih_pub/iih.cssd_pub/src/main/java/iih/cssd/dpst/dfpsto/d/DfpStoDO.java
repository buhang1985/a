package iih.cssd.dpst.dfpsto.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.cssd.dpst.dfpsto.d.desc.DfpStoDODesc;
import java.math.BigDecimal;

/**
 * 消毒包储藏 DO数据 
 * 
 */
public class DfpStoDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//储藏ID
	public static final String ID_DFP_STO= "Id_dfp_sto";
	//组织
	public static final String ID_ORG= "Id_org";
	//集团
	public static final String ID_GRP= "Id_grp";
	//消毒包
	public static final String ID_DFP= "Id_dfp";
	//储藏位置
	public static final String ID_INSTR= "Id_instr";
	//储藏详细位置
	public static final String INSTR_FULL_NAME= "Instr_full_name";
	//储藏科室
	public static final String ID_DEP_STO= "Id_dep_sto";
	//储藏人
	public static final String ID_EMP_STO= "Id_emp_sto";
	//储藏时间
	public static final String DT_STO= "Dt_sto";
	//取离科室
	public static final String ID_DEP_LV= "Id_dep_lv";
	//取离人
	public static final String ID_EMP_LV= "Id_emp_lv";
	//取离时间
	public static final String DT_LV= "Dt_lv";
	//有效标记
	public static final String FG_EFFE= "Fg_effe";
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
	//父级ID
	public static final String ID_PARENT= "Id_parent";
	//是否消毒包
	public static final String FG_DFP= "Fg_dfp";
	//消毒包名称
	public static final String NAME= "Name";
	//识别码
	public static final String NO_BAR= "No_bar";
	//器械名称
	public static final String NAME_INSTR= "Name_instr";
	//内码
	public static final String INNERCODE= "Innercode";
	//储物架编码
	public static final String CODE_INSTR= "Code_instr";
	//储藏科室名称
	public static final String NAME_DEP_STO= "Name_dep_sto";
	//储藏人姓名
	public static final String NAME_EMP_STO= "Name_emp_sto";
	//取离科室名称
	public static final String NAME_DEP_LV= "Name_dep_lv";
	//取离人姓名
	public static final String NAME_EMP_LV= "Name_emp_lv";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 储藏ID
	 * @return String
	 */
	public String getId_dfp_sto() {
		return ((String) getAttrVal("Id_dfp_sto"));
	}	
	/**
	 * 储藏ID
	 * @param Id_dfp_sto
	 */
	public void setId_dfp_sto(String Id_dfp_sto) {
		setAttrVal("Id_dfp_sto", Id_dfp_sto);
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
	 * 消毒包
	 * @return String
	 */
	public String getId_dfp() {
		return ((String) getAttrVal("Id_dfp"));
	}	
	/**
	 * 消毒包
	 * @param Id_dfp
	 */
	public void setId_dfp(String Id_dfp) {
		setAttrVal("Id_dfp", Id_dfp);
	}
	/**
	 * 储藏位置
	 * @return String
	 */
	public String getId_instr() {
		return ((String) getAttrVal("Id_instr"));
	}	
	/**
	 * 储藏位置
	 * @param Id_instr
	 */
	public void setId_instr(String Id_instr) {
		setAttrVal("Id_instr", Id_instr);
	}
	/**
	 * 储藏详细位置
	 * @return String
	 */
	public String getInstr_full_name() {
		return ((String) getAttrVal("Instr_full_name"));
	}	
	/**
	 * 储藏详细位置
	 * @param Instr_full_name
	 */
	public void setInstr_full_name(String Instr_full_name) {
		setAttrVal("Instr_full_name", Instr_full_name);
	}
	/**
	 * 储藏科室
	 * @return String
	 */
	public String getId_dep_sto() {
		return ((String) getAttrVal("Id_dep_sto"));
	}	
	/**
	 * 储藏科室
	 * @param Id_dep_sto
	 */
	public void setId_dep_sto(String Id_dep_sto) {
		setAttrVal("Id_dep_sto", Id_dep_sto);
	}
	/**
	 * 储藏人
	 * @return String
	 */
	public String getId_emp_sto() {
		return ((String) getAttrVal("Id_emp_sto"));
	}	
	/**
	 * 储藏人
	 * @param Id_emp_sto
	 */
	public void setId_emp_sto(String Id_emp_sto) {
		setAttrVal("Id_emp_sto", Id_emp_sto);
	}
	/**
	 * 储藏时间
	 * @return FDateTime
	 */
	public FDateTime getDt_sto() {
		return ((FDateTime) getAttrVal("Dt_sto"));
	}	
	/**
	 * 储藏时间
	 * @param Dt_sto
	 */
	public void setDt_sto(FDateTime Dt_sto) {
		setAttrVal("Dt_sto", Dt_sto);
	}
	/**
	 * 取离科室
	 * @return String
	 */
	public String getId_dep_lv() {
		return ((String) getAttrVal("Id_dep_lv"));
	}	
	/**
	 * 取离科室
	 * @param Id_dep_lv
	 */
	public void setId_dep_lv(String Id_dep_lv) {
		setAttrVal("Id_dep_lv", Id_dep_lv);
	}
	/**
	 * 取离人
	 * @return String
	 */
	public String getId_emp_lv() {
		return ((String) getAttrVal("Id_emp_lv"));
	}	
	/**
	 * 取离人
	 * @param Id_emp_lv
	 */
	public void setId_emp_lv(String Id_emp_lv) {
		setAttrVal("Id_emp_lv", Id_emp_lv);
	}
	/**
	 * 取离时间
	 * @return FDateTime
	 */
	public FDateTime getDt_lv() {
		return ((FDateTime) getAttrVal("Dt_lv"));
	}	
	/**
	 * 取离时间
	 * @param Dt_lv
	 */
	public void setDt_lv(FDateTime Dt_lv) {
		setAttrVal("Dt_lv", Dt_lv);
	}
	/**
	 * 有效标记
	 * @return FBoolean
	 */
	public FBoolean getFg_effe() {
		return ((FBoolean) getAttrVal("Fg_effe"));
	}	
	/**
	 * 有效标记
	 * @param Fg_effe
	 */
	public void setFg_effe(FBoolean Fg_effe) {
		setAttrVal("Fg_effe", Fg_effe);
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
	 * 父级ID
	 * @return String
	 */
	public String getId_parent() {
		return ((String) getAttrVal("Id_parent"));
	}	
	/**
	 * 父级ID
	 * @param Id_parent
	 */
	public void setId_parent(String Id_parent) {
		setAttrVal("Id_parent", Id_parent);
	}
	/**
	 * 是否消毒包
	 * @return FBoolean
	 */
	public FBoolean getFg_dfp() {
		return ((FBoolean) getAttrVal("Fg_dfp"));
	}	
	/**
	 * 是否消毒包
	 * @param Fg_dfp
	 */
	public void setFg_dfp(FBoolean Fg_dfp) {
		setAttrVal("Fg_dfp", Fg_dfp);
	}
	/**
	 * 消毒包名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 消毒包名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 识别码
	 * @return String
	 */
	public String getNo_bar() {
		return ((String) getAttrVal("No_bar"));
	}	
	/**
	 * 识别码
	 * @param No_bar
	 */
	public void setNo_bar(String No_bar) {
		setAttrVal("No_bar", No_bar);
	}
	/**
	 * 器械名称
	 * @return String
	 */
	public String getName_instr() {
		return ((String) getAttrVal("Name_instr"));
	}	
	/**
	 * 器械名称
	 * @param Name_instr
	 */
	public void setName_instr(String Name_instr) {
		setAttrVal("Name_instr", Name_instr);
	}
	/**
	 * 内码
	 * @return String
	 */
	public String getInnercode() {
		return ((String) getAttrVal("Innercode"));
	}	
	/**
	 * 内码
	 * @param Innercode
	 */
	public void setInnercode(String Innercode) {
		setAttrVal("Innercode", Innercode);
	}
	/**
	 * 储物架编码
	 * @return String
	 */
	public String getCode_instr() {
		return ((String) getAttrVal("Code_instr"));
	}	
	/**
	 * 储物架编码
	 * @param Code_instr
	 */
	public void setCode_instr(String Code_instr) {
		setAttrVal("Code_instr", Code_instr);
	}
	/**
	 * 储藏科室名称
	 * @return String
	 */
	public String getName_dep_sto() {
		return ((String) getAttrVal("Name_dep_sto"));
	}	
	/**
	 * 储藏科室名称
	 * @param Name_dep_sto
	 */
	public void setName_dep_sto(String Name_dep_sto) {
		setAttrVal("Name_dep_sto", Name_dep_sto);
	}
	/**
	 * 储藏人姓名
	 * @return String
	 */
	public String getName_emp_sto() {
		return ((String) getAttrVal("Name_emp_sto"));
	}	
	/**
	 * 储藏人姓名
	 * @param Name_emp_sto
	 */
	public void setName_emp_sto(String Name_emp_sto) {
		setAttrVal("Name_emp_sto", Name_emp_sto);
	}
	/**
	 * 取离科室名称
	 * @return String
	 */
	public String getName_dep_lv() {
		return ((String) getAttrVal("Name_dep_lv"));
	}	
	/**
	 * 取离科室名称
	 * @param Name_dep_lv
	 */
	public void setName_dep_lv(String Name_dep_lv) {
		setAttrVal("Name_dep_lv", Name_dep_lv);
	}
	/**
	 * 取离人姓名
	 * @return String
	 */
	public String getName_emp_lv() {
		return ((String) getAttrVal("Name_emp_lv"));
	}	
	/**
	 * 取离人姓名
	 * @param Name_emp_lv
	 */
	public void setName_emp_lv(String Name_emp_lv) {
		setAttrVal("Name_emp_lv", Name_emp_lv);
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
		return "Id_dfp_sto";
	}
	
	@Override
	public String getTableName() {	  
		return "cssd_dfp_sto";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(DfpStoDODesc.class);
	}
	
}