package iih.pe.pqn.peevalchrorisk.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pqn.peevalchrorisk.d.desc.PeChroRiskDODesc;
import java.math.BigDecimal;

/**
 * 体检慢性病风险因素-主 DO数据 
 * 
 */
public class PeChroRiskDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检慢性病风险因素主键标识
	public static final String ID_PECHRORISK= "Id_pechrorisk";
	//体检慢性病风险因素父ID
	public static final String ID_PECHRORISK_PAR= "Id_pechrorisk_par";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//风险因素编码
	public static final String CODE= "Code";
	//风险因素名称
	public static final String NAME= "Name";
	//序号
	public static final String SORTNO= "Sortno";
	//年龄开始
	public static final String AGE_BEGIN= "Age_begin";
	//年龄截止
	public static final String AGE_END= "Age_end";
	//性别限制
	public static final String SEXLIMIT= "Sexlimit";
	//婚否限制
	public static final String MARILIMIT= "Marilimit";
	//风险类型
	public static final String RISKTP= "Risktp";
	//风险可控标识
	public static final String FG_CRTL= "Fg_crtl";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检慢性病风险因素主键标识
	 * @return String
	 */
	public String getId_pechrorisk() {
		return ((String) getAttrVal("Id_pechrorisk"));
	}	
	/**
	 * 体检慢性病风险因素主键标识
	 * @param Id_pechrorisk
	 */
	public void setId_pechrorisk(String Id_pechrorisk) {
		setAttrVal("Id_pechrorisk", Id_pechrorisk);
	}
	/**
	 * 体检慢性病风险因素父ID
	 * @return String
	 */
	public String getId_pechrorisk_par() {
		return ((String) getAttrVal("Id_pechrorisk_par"));
	}	
	/**
	 * 体检慢性病风险因素父ID
	 * @param Id_pechrorisk_par
	 */
	public void setId_pechrorisk_par(String Id_pechrorisk_par) {
		setAttrVal("Id_pechrorisk_par", Id_pechrorisk_par);
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
	 * 风险因素编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 风险因素编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 风险因素名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 风险因素名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
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
	 * 年龄开始
	 * @return Integer
	 */
	public Integer getAge_begin() {
		return ((Integer) getAttrVal("Age_begin"));
	}	
	/**
	 * 年龄开始
	 * @param Age_begin
	 */
	public void setAge_begin(Integer Age_begin) {
		setAttrVal("Age_begin", Age_begin);
	}
	/**
	 * 年龄截止
	 * @return Integer
	 */
	public Integer getAge_end() {
		return ((Integer) getAttrVal("Age_end"));
	}	
	/**
	 * 年龄截止
	 * @param Age_end
	 */
	public void setAge_end(Integer Age_end) {
		setAttrVal("Age_end", Age_end);
	}
	/**
	 * 性别限制
	 * @return Integer
	 */
	public Integer getSexlimit() {
		return ((Integer) getAttrVal("Sexlimit"));
	}	
	/**
	 * 性别限制
	 * @param Sexlimit
	 */
	public void setSexlimit(Integer Sexlimit) {
		setAttrVal("Sexlimit", Sexlimit);
	}
	/**
	 * 婚否限制
	 * @return Integer
	 */
	public Integer getMarilimit() {
		return ((Integer) getAttrVal("Marilimit"));
	}	
	/**
	 * 婚否限制
	 * @param Marilimit
	 */
	public void setMarilimit(Integer Marilimit) {
		setAttrVal("Marilimit", Marilimit);
	}
	/**
	 * 风险类型
	 * @return Integer
	 */
	public Integer getRisktp() {
		return ((Integer) getAttrVal("Risktp"));
	}	
	/**
	 * 风险类型
	 * @param Risktp
	 */
	public void setRisktp(Integer Risktp) {
		setAttrVal("Risktp", Risktp);
	}
	/**
	 * 风险可控标识
	 * @return FBoolean
	 */
	public FBoolean getFg_crtl() {
		return ((FBoolean) getAttrVal("Fg_crtl"));
	}	
	/**
	 * 风险可控标识
	 * @param Fg_crtl
	 */
	public void setFg_crtl(FBoolean Fg_crtl) {
		setAttrVal("Fg_crtl", Fg_crtl);
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
		return "Id_pechrorisk";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_qn_pechrorisk";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeChroRiskDODesc.class);
	}
	
}