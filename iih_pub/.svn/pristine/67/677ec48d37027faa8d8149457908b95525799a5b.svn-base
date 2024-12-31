package iih.pe.pitm.peexercise.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pitm.peexercise.d.desc.PeExerciseDODesc;
import java.math.BigDecimal;

/**
 * 体检运动种类定义 DO数据 
 * 
 */
public class PeExerciseDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检运动种类主键标识
	public static final String ID_PEEXERCISE= "Id_peexercise";
	//体检运动种类父ID
	public static final String ID_PEEXERCISE_PAR= "Id_peexercise_par";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//编码
	public static final String CODE= "Code";
	//名称
	public static final String NAME= "Name";
	//运动类别
	public static final String EXTP= "Extp";
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
	 * 体检运动种类主键标识
	 * @return String
	 */
	public String getId_peexercise() {
		return ((String) getAttrVal("Id_peexercise"));
	}	
	/**
	 * 体检运动种类主键标识
	 * @param Id_peexercise
	 */
	public void setId_peexercise(String Id_peexercise) {
		setAttrVal("Id_peexercise", Id_peexercise);
	}
	/**
	 * 体检运动种类父ID
	 * @return String
	 */
	public String getId_peexercise_par() {
		return ((String) getAttrVal("Id_peexercise_par"));
	}	
	/**
	 * 体检运动种类父ID
	 * @param Id_peexercise_par
	 */
	public void setId_peexercise_par(String Id_peexercise_par) {
		setAttrVal("Id_peexercise_par", Id_peexercise_par);
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
	 * 运动类别
	 * @return Integer
	 */
	public Integer getExtp() {
		return ((Integer) getAttrVal("Extp"));
	}	
	/**
	 * 运动类别
	 * @param Extp
	 */
	public void setExtp(Integer Extp) {
		setAttrVal("Extp", Extp);
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
		return "Id_peexercise";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_itm_peexercise";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeExerciseDODesc.class);
	}
	
}