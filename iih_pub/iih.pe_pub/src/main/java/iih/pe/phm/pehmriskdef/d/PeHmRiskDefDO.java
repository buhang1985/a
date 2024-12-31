package iih.pe.phm.pehmriskdef.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.phm.pehmriskdef.d.desc.PeHmRiskDefDODesc;
import java.math.BigDecimal;

/**
 * 健康危险因素目录定义 DO数据 
 * 
 */
public class PeHmRiskDefDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//健康危险因素目录主键标识
	public static final String ID_RISKDEF= "Id_riskdef";
	//健康危险因素目录父ID
	public static final String ID_RISKDEF_PAR= "Id_riskdef_par";
	//健康危险因素分组ID
	public static final String ID_RISKCATLOG= "Id_riskcatlog";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//编码
	public static final String CODE= "Code";
	//名称
	public static final String NAME= "Name";
	//数据来源
	public static final String DATATP= "Datatp";
	//序号
	public static final String SORTNO= "Sortno";
	//参考值
	public static final String VALUE_REF= "Value_ref";
	//理想值
	public static final String VALUE_IDEA= "Value_idea";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//可改变危险因素
	public static final String FG_MODIFIABLE= "Fg_modifiable";
	//启用标识
	public static final String FG_ACTIVE= "Fg_active";
	//非危险因素
	public static final String FG_NONRISK= "Fg_nonrisk";
	//固定编码
	public static final String HARDCODE= "Hardcode";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 健康危险因素目录主键标识
	 * @return String
	 */
	public String getId_riskdef() {
		return ((String) getAttrVal("Id_riskdef"));
	}	
	/**
	 * 健康危险因素目录主键标识
	 * @param Id_riskdef
	 */
	public void setId_riskdef(String Id_riskdef) {
		setAttrVal("Id_riskdef", Id_riskdef);
	}
	/**
	 * 健康危险因素目录父ID
	 * @return String
	 */
	public String getId_riskdef_par() {
		return ((String) getAttrVal("Id_riskdef_par"));
	}	
	/**
	 * 健康危险因素目录父ID
	 * @param Id_riskdef_par
	 */
	public void setId_riskdef_par(String Id_riskdef_par) {
		setAttrVal("Id_riskdef_par", Id_riskdef_par);
	}
	/**
	 * 健康危险因素分组ID
	 * @return String
	 */
	public String getId_riskcatlog() {
		return ((String) getAttrVal("Id_riskcatlog"));
	}	
	/**
	 * 健康危险因素分组ID
	 * @param Id_riskcatlog
	 */
	public void setId_riskcatlog(String Id_riskcatlog) {
		setAttrVal("Id_riskcatlog", Id_riskcatlog);
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
	 * 编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 数据来源
	 * @return Integer
	 */
	public Integer getDatatp() {
		return ((Integer) getAttrVal("Datatp"));
	}	
	/**
	 * 数据来源
	 * @param Datatp
	 */
	public void setDatatp(Integer Datatp) {
		setAttrVal("Datatp", Datatp);
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
	 * 参考值
	 * @return String
	 */
	public String getValue_ref() {
		return ((String) getAttrVal("Value_ref"));
	}	
	/**
	 * 参考值
	 * @param Value_ref
	 */
	public void setValue_ref(String Value_ref) {
		setAttrVal("Value_ref", Value_ref);
	}
	/**
	 * 理想值
	 * @return String
	 */
	public String getValue_idea() {
		return ((String) getAttrVal("Value_idea"));
	}	
	/**
	 * 理想值
	 * @param Value_idea
	 */
	public void setValue_idea(String Value_idea) {
		setAttrVal("Value_idea", Value_idea);
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
	 * 可改变危险因素
	 * @return FBoolean
	 */
	public FBoolean getFg_modifiable() {
		return ((FBoolean) getAttrVal("Fg_modifiable"));
	}	
	/**
	 * 可改变危险因素
	 * @param Fg_modifiable
	 */
	public void setFg_modifiable(FBoolean Fg_modifiable) {
		setAttrVal("Fg_modifiable", Fg_modifiable);
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
	 * 非危险因素
	 * @return FBoolean
	 */
	public FBoolean getFg_nonrisk() {
		return ((FBoolean) getAttrVal("Fg_nonrisk"));
	}	
	/**
	 * 非危险因素
	 * @param Fg_nonrisk
	 */
	public void setFg_nonrisk(FBoolean Fg_nonrisk) {
		setAttrVal("Fg_nonrisk", Fg_nonrisk);
	}
	/**
	 * 固定编码
	 * @return String
	 */
	public String getHardcode() {
		return ((String) getAttrVal("Hardcode"));
	}	
	/**
	 * 固定编码
	 * @param Hardcode
	 */
	public void setHardcode(String Hardcode) {
		setAttrVal("Hardcode", Hardcode);
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
		return "Id_riskdef";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_hm_riskdef";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeHmRiskDefDODesc.class);
	}
	
}