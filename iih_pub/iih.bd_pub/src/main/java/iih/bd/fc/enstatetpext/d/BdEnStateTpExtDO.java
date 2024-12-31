package iih.bd.fc.enstatetpext.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.fc.enstatetpext.d.desc.BdEnStateTpExtDODesc;
import java.math.BigDecimal;

/**
 * 就诊状况类型定义扩展 DO数据 
 * 
 */
public class BdEnStateTpExtDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//状况类型扩展id
	public static final String ID_ENSTATETPEXT= "Id_enstatetpext";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//状况类型id
	public static final String ID_ENSTATETP= "Id_enstatetp";
	//状况类型编码
	public static final String SD_ENSTATETP= "Sd_enstatetp";
	//就诊使用标志
	public static final String FG_ENT= "Fg_ent";
	//门诊使用标志
	public static final String FG_OP= "Fg_op";
	//住院使用
	public static final String FG_IP= "Fg_ip";
	//急诊使用
	public static final String FG_ER= "Fg_er";
	//可使用科室
	public static final String IDS_DEP_USED= "Ids_dep_used";
	//源数据类型
	public static final String EU_SOURCETP= "Eu_sourcetp";
	//默认值id
	public static final String ID_DEF_VAL= "Id_def_val";
	//默认值
	public static final String DEF_VAL= "Def_val";
	//名称
	public static final String NAME_ENSTATETP= "Name_enstatetp";
	//可使用科室名称
	public static final String NAMES_DEP_USED= "Names_dep_used";
	//可使用科室编码
	public static final String CODES_DEP_USED= "Codes_dep_used";
	//部门类型编码
	public static final String SD_DEPTTP= "Sd_depttp";
	//默认值名称
	public static final String NAME_DEF_VAL= "Name_def_val";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 状况类型扩展id
	 * @return String
	 */
	public String getId_enstatetpext() {
		return ((String) getAttrVal("Id_enstatetpext"));
	}	
	/**
	 * 状况类型扩展id
	 * @param Id_enstatetpext
	 */
	public void setId_enstatetpext(String Id_enstatetpext) {
		setAttrVal("Id_enstatetpext", Id_enstatetpext);
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
	 * 状况类型id
	 * @return String
	 */
	public String getId_enstatetp() {
		return ((String) getAttrVal("Id_enstatetp"));
	}	
	/**
	 * 状况类型id
	 * @param Id_enstatetp
	 */
	public void setId_enstatetp(String Id_enstatetp) {
		setAttrVal("Id_enstatetp", Id_enstatetp);
	}
	/**
	 * 状况类型编码
	 * @return String
	 */
	public String getSd_enstatetp() {
		return ((String) getAttrVal("Sd_enstatetp"));
	}	
	/**
	 * 状况类型编码
	 * @param Sd_enstatetp
	 */
	public void setSd_enstatetp(String Sd_enstatetp) {
		setAttrVal("Sd_enstatetp", Sd_enstatetp);
	}
	/**
	 * 就诊使用标志
	 * @return FBoolean
	 */
	public FBoolean getFg_ent() {
		return ((FBoolean) getAttrVal("Fg_ent"));
	}	
	/**
	 * 就诊使用标志
	 * @param Fg_ent
	 */
	public void setFg_ent(FBoolean Fg_ent) {
		setAttrVal("Fg_ent", Fg_ent);
	}
	/**
	 * 门诊使用标志
	 * @return FBoolean
	 */
	public FBoolean getFg_op() {
		return ((FBoolean) getAttrVal("Fg_op"));
	}	
	/**
	 * 门诊使用标志
	 * @param Fg_op
	 */
	public void setFg_op(FBoolean Fg_op) {
		setAttrVal("Fg_op", Fg_op);
	}
	/**
	 * 住院使用
	 * @return FBoolean
	 */
	public FBoolean getFg_ip() {
		return ((FBoolean) getAttrVal("Fg_ip"));
	}	
	/**
	 * 住院使用
	 * @param Fg_ip
	 */
	public void setFg_ip(FBoolean Fg_ip) {
		setAttrVal("Fg_ip", Fg_ip);
	}
	/**
	 * 急诊使用
	 * @return FBoolean
	 */
	public FBoolean getFg_er() {
		return ((FBoolean) getAttrVal("Fg_er"));
	}	
	/**
	 * 急诊使用
	 * @param Fg_er
	 */
	public void setFg_er(FBoolean Fg_er) {
		setAttrVal("Fg_er", Fg_er);
	}
	/**
	 * 可使用科室
	 * @return String
	 */
	public String getIds_dep_used() {
		return ((String) getAttrVal("Ids_dep_used"));
	}	
	/**
	 * 可使用科室
	 * @param Ids_dep_used
	 */
	public void setIds_dep_used(String Ids_dep_used) {
		setAttrVal("Ids_dep_used", Ids_dep_used);
	}
	/**
	 * 源数据类型
	 * @return Integer
	 */
	public Integer getEu_sourcetp() {
		return ((Integer) getAttrVal("Eu_sourcetp"));
	}	
	/**
	 * 源数据类型
	 * @param Eu_sourcetp
	 */
	public void setEu_sourcetp(Integer Eu_sourcetp) {
		setAttrVal("Eu_sourcetp", Eu_sourcetp);
	}
	/**
	 * 默认值id
	 * @return String
	 */
	public String getId_def_val() {
		return ((String) getAttrVal("Id_def_val"));
	}	
	/**
	 * 默认值id
	 * @param Id_def_val
	 */
	public void setId_def_val(String Id_def_val) {
		setAttrVal("Id_def_val", Id_def_val);
	}
	/**
	 * 默认值
	 * @return String
	 */
	public String getDef_val() {
		return ((String) getAttrVal("Def_val"));
	}	
	/**
	 * 默认值
	 * @param Def_val
	 */
	public void setDef_val(String Def_val) {
		setAttrVal("Def_val", Def_val);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_enstatetp() {
		return ((String) getAttrVal("Name_enstatetp"));
	}	
	/**
	 * 名称
	 * @param Name_enstatetp
	 */
	public void setName_enstatetp(String Name_enstatetp) {
		setAttrVal("Name_enstatetp", Name_enstatetp);
	}
	/**
	 * 可使用科室名称
	 * @return String
	 */
	public String getNames_dep_used() {
		return ((String) getAttrVal("Names_dep_used"));
	}	
	/**
	 * 可使用科室名称
	 * @param Names_dep_used
	 */
	public void setNames_dep_used(String Names_dep_used) {
		setAttrVal("Names_dep_used", Names_dep_used);
	}
	/**
	 * 可使用科室编码
	 * @return String
	 */
	public String getCodes_dep_used() {
		return ((String) getAttrVal("Codes_dep_used"));
	}	
	/**
	 * 可使用科室编码
	 * @param Codes_dep_used
	 */
	public void setCodes_dep_used(String Codes_dep_used) {
		setAttrVal("Codes_dep_used", Codes_dep_used);
	}
	/**
	 * 部门类型编码
	 * @return String
	 */
	public String getSd_depttp() {
		return ((String) getAttrVal("Sd_depttp"));
	}	
	/**
	 * 部门类型编码
	 * @param Sd_depttp
	 */
	public void setSd_depttp(String Sd_depttp) {
		setAttrVal("Sd_depttp", Sd_depttp);
	}
	/**
	 * 默认值名称
	 * @return String
	 */
	public String getName_def_val() {
		return ((String) getAttrVal("Name_def_val"));
	}	
	/**
	 * 默认值名称
	 * @param Name_def_val
	 */
	public void setName_def_val(String Name_def_val) {
		setAttrVal("Name_def_val", Name_def_val);
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
		return "Id_enstatetpext";
	}
	
	@Override
	public String getTableName() {	  
		return "BD_EN_STATETP_EXT";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BdEnStateTpExtDODesc.class);
	}
	
}