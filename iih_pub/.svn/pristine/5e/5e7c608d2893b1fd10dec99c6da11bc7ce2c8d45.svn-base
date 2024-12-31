package iih.pe.phm.perstin.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.phm.perstin.d.desc.PeRstinDtlDODesc;
import java.math.BigDecimal;

/**
 * 体检手工录入结果明细 DO数据 
 * 
 */
public class PeRstinDtlDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检手工录入结果明细主键标识
	public static final String ID_PERSTINDTL= "Id_perstindtl";
	//体检手工录入结果ID
	public static final String ID_PERSTIN= "Id_perstin";
	//体检项目ID
	public static final String ID_PESRVBITEM= "Id_pesrvbitem";
	//结果
	public static final String RST= "Rst";
	//异常标识
	public static final String FG_ABN= "Fg_abn";
	//异常
	public static final String MARK= "Mark";
	//建议
	public static final String ADV= "Adv";
	//编码
	public static final String CODE_ITEM= "Code_item";
	//名称
	public static final String NAME_ITEM= "Name_item";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检手工录入结果明细主键标识
	 * @return String
	 */
	public String getId_perstindtl() {
		return ((String) getAttrVal("Id_perstindtl"));
	}	
	/**
	 * 体检手工录入结果明细主键标识
	 * @param Id_perstindtl
	 */
	public void setId_perstindtl(String Id_perstindtl) {
		setAttrVal("Id_perstindtl", Id_perstindtl);
	}
	/**
	 * 体检手工录入结果ID
	 * @return String
	 */
	public String getId_perstin() {
		return ((String) getAttrVal("Id_perstin"));
	}	
	/**
	 * 体检手工录入结果ID
	 * @param Id_perstin
	 */
	public void setId_perstin(String Id_perstin) {
		setAttrVal("Id_perstin", Id_perstin);
	}
	/**
	 * 体检项目ID
	 * @return String
	 */
	public String getId_pesrvbitem() {
		return ((String) getAttrVal("Id_pesrvbitem"));
	}	
	/**
	 * 体检项目ID
	 * @param Id_pesrvbitem
	 */
	public void setId_pesrvbitem(String Id_pesrvbitem) {
		setAttrVal("Id_pesrvbitem", Id_pesrvbitem);
	}
	/**
	 * 结果
	 * @return String
	 */
	public String getRst() {
		return ((String) getAttrVal("Rst"));
	}	
	/**
	 * 结果
	 * @param Rst
	 */
	public void setRst(String Rst) {
		setAttrVal("Rst", Rst);
	}
	/**
	 * 异常标识
	 * @return FBoolean
	 */
	public FBoolean getFg_abn() {
		return ((FBoolean) getAttrVal("Fg_abn"));
	}	
	/**
	 * 异常标识
	 * @param Fg_abn
	 */
	public void setFg_abn(FBoolean Fg_abn) {
		setAttrVal("Fg_abn", Fg_abn);
	}
	/**
	 * 异常
	 * @return String
	 */
	public String getMark() {
		return ((String) getAttrVal("Mark"));
	}	
	/**
	 * 异常
	 * @param Mark
	 */
	public void setMark(String Mark) {
		setAttrVal("Mark", Mark);
	}
	/**
	 * 建议
	 * @return String
	 */
	public String getAdv() {
		return ((String) getAttrVal("Adv"));
	}	
	/**
	 * 建议
	 * @param Adv
	 */
	public void setAdv(String Adv) {
		setAttrVal("Adv", Adv);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_item() {
		return ((String) getAttrVal("Code_item"));
	}	
	/**
	 * 编码
	 * @param Code_item
	 */
	public void setCode_item(String Code_item) {
		setAttrVal("Code_item", Code_item);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_item() {
		return ((String) getAttrVal("Name_item"));
	}	
	/**
	 * 名称
	 * @param Name_item
	 */
	public void setName_item(String Name_item) {
		setAttrVal("Name_item", Name_item);
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
		return "Id_perstindtl";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_hm_perstindtl";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeRstinDtlDODesc.class);
	}
	
}