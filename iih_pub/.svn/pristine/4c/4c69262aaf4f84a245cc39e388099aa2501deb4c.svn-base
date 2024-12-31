package iih.pe.por.pepsnbinfo.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.por.pepsnbinfo.d.desc.PePsnPhyDODesc;
import java.math.BigDecimal;

/**
 * 体检客户生理指标 DO数据 
 * 
 */
public class PePsnPhyDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检客户生理指标主键标识
	public static final String ID_PEPSNPHY= "Id_pepsnphy";
	//体检客户ID
	public static final String ID_PEPSNBINFO= "Id_pepsnbinfo";
	//记录日期
	public static final String DT_RECORD= "Dt_record";
	//期望寿命
	public static final String LIFEEXPECTANCY= "Lifeexpectancy";
	//血型
	public static final String BLOODTYPE= "Bloodtype";
	//编码
	public static final String CODE_BLOODTYPE= "Code_bloodtype";
	//名称
	public static final String NAME_BLOODTYPE= "Name_bloodtype";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检客户生理指标主键标识
	 * @return String
	 */
	public String getId_pepsnphy() {
		return ((String) getAttrVal("Id_pepsnphy"));
	}	
	/**
	 * 体检客户生理指标主键标识
	 * @param Id_pepsnphy
	 */
	public void setId_pepsnphy(String Id_pepsnphy) {
		setAttrVal("Id_pepsnphy", Id_pepsnphy);
	}
	/**
	 * 体检客户ID
	 * @return String
	 */
	public String getId_pepsnbinfo() {
		return ((String) getAttrVal("Id_pepsnbinfo"));
	}	
	/**
	 * 体检客户ID
	 * @param Id_pepsnbinfo
	 */
	public void setId_pepsnbinfo(String Id_pepsnbinfo) {
		setAttrVal("Id_pepsnbinfo", Id_pepsnbinfo);
	}
	/**
	 * 记录日期
	 * @return FDate
	 */
	public FDate getDt_record() {
		return ((FDate) getAttrVal("Dt_record"));
	}	
	/**
	 * 记录日期
	 * @param Dt_record
	 */
	public void setDt_record(FDate Dt_record) {
		setAttrVal("Dt_record", Dt_record);
	}
	/**
	 * 期望寿命
	 * @return Integer
	 */
	public Integer getLifeexpectancy() {
		return ((Integer) getAttrVal("Lifeexpectancy"));
	}	
	/**
	 * 期望寿命
	 * @param Lifeexpectancy
	 */
	public void setLifeexpectancy(Integer Lifeexpectancy) {
		setAttrVal("Lifeexpectancy", Lifeexpectancy);
	}
	/**
	 * 血型
	 * @return String
	 */
	public String getBloodtype() {
		return ((String) getAttrVal("Bloodtype"));
	}	
	/**
	 * 血型
	 * @param Bloodtype
	 */
	public void setBloodtype(String Bloodtype) {
		setAttrVal("Bloodtype", Bloodtype);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_bloodtype() {
		return ((String) getAttrVal("Code_bloodtype"));
	}	
	/**
	 * 编码
	 * @param Code_bloodtype
	 */
	public void setCode_bloodtype(String Code_bloodtype) {
		setAttrVal("Code_bloodtype", Code_bloodtype);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_bloodtype() {
		return ((String) getAttrVal("Name_bloodtype"));
	}	
	/**
	 * 名称
	 * @param Name_bloodtype
	 */
	public void setName_bloodtype(String Name_bloodtype) {
		setAttrVal("Name_bloodtype", Name_bloodtype);
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
		return "Id_pepsnphy";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_or_pepsnphy";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PePsnPhyDODesc.class);
	}
	
}