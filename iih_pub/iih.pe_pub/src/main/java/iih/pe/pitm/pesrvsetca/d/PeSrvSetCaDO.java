package iih.pe.pitm.pesrvsetca.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pitm.pesrvsetca.d.desc.PeSrvSetCaDODesc;
import java.math.BigDecimal;

/**
 * 体检套餐类别 DO数据 
 * 
 */
public class PeSrvSetCaDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检套餐分类主键标识
	public static final String ID_PESRVSETCA= "Id_pesrvsetca";
	//体检套餐分类父ID
	public static final String ID_PESRVSETCA_PAR= "Id_pesrvsetca_par";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//编码
	public static final String CODE= "Code";
	//名称
	public static final String NAME= "Name";
	//次序
	public static final String SORTNO= "Sortno";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//编码
	public static final String CODE_PESRVSETCA= "Code_pesrvsetca";
	//名称
	public static final String NAME_PESRVSETCA= "Name_pesrvsetca";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检套餐分类主键标识
	 * @return String
	 */
	public String getId_pesrvsetca() {
		return ((String) getAttrVal("Id_pesrvsetca"));
	}	
	/**
	 * 体检套餐分类主键标识
	 * @param Id_pesrvsetca
	 */
	public void setId_pesrvsetca(String Id_pesrvsetca) {
		setAttrVal("Id_pesrvsetca", Id_pesrvsetca);
	}
	/**
	 * 体检套餐分类父ID
	 * @return String
	 */
	public String getId_pesrvsetca_par() {
		return ((String) getAttrVal("Id_pesrvsetca_par"));
	}	
	/**
	 * 体检套餐分类父ID
	 * @param Id_pesrvsetca_par
	 */
	public void setId_pesrvsetca_par(String Id_pesrvsetca_par) {
		setAttrVal("Id_pesrvsetca_par", Id_pesrvsetca_par);
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
	 * 次序
	 * @return Integer
	 */
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	/**
	 * 次序
	 * @param Sortno
	 */
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
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
	 * 编码
	 * @return String
	 */
	public String getCode_pesrvsetca() {
		return ((String) getAttrVal("Code_pesrvsetca"));
	}	
	/**
	 * 编码
	 * @param Code_pesrvsetca
	 */
	public void setCode_pesrvsetca(String Code_pesrvsetca) {
		setAttrVal("Code_pesrvsetca", Code_pesrvsetca);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_pesrvsetca() {
		return ((String) getAttrVal("Name_pesrvsetca"));
	}	
	/**
	 * 名称
	 * @param Name_pesrvsetca
	 */
	public void setName_pesrvsetca(String Name_pesrvsetca) {
		setAttrVal("Name_pesrvsetca", Name_pesrvsetca);
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
		return "Id_pesrvsetca";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_itm_pesrvsetca";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeSrvSetCaDODesc.class);
	}
	
}