package iih.pe.pitm.pesrvitemrange.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pitm.pesrvitemrange.d.desc.PeSrvItemRangeRuleDODesc;
import java.math.BigDecimal;

/**
 * 体检结果范围定义规则 DO数据 
 * 
 */
public class PeSrvItemRangeRuleDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检结果范围定义规则主键标识
	public static final String ID_PESRVITEMRANGERULE= "Id_pesrvitemrangerule";
	//体检结果范围定义ID
	public static final String ID_PESRVTTEMRANGE= "Id_pesrvttemrange";
	//性别限制
	public static final String SEXLIMIT= "Sexlimit";
	//开始年龄
	public static final String AGE_BEGIN= "Age_begin";
	//截止年龄
	public static final String AGE_END= "Age_end";
	//开始值
	public static final String RANGE_BEGIN= "Range_begin";
	//截止值
	public static final String RANGE_END= "Range_end";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检结果范围定义规则主键标识
	 * @return String
	 */
	public String getId_pesrvitemrangerule() {
		return ((String) getAttrVal("Id_pesrvitemrangerule"));
	}	
	/**
	 * 体检结果范围定义规则主键标识
	 * @param Id_pesrvitemrangerule
	 */
	public void setId_pesrvitemrangerule(String Id_pesrvitemrangerule) {
		setAttrVal("Id_pesrvitemrangerule", Id_pesrvitemrangerule);
	}
	/**
	 * 体检结果范围定义ID
	 * @return String
	 */
	public String getId_pesrvttemrange() {
		return ((String) getAttrVal("Id_pesrvttemrange"));
	}	
	/**
	 * 体检结果范围定义ID
	 * @param Id_pesrvttemrange
	 */
	public void setId_pesrvttemrange(String Id_pesrvttemrange) {
		setAttrVal("Id_pesrvttemrange", Id_pesrvttemrange);
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
	 * 开始年龄
	 * @return Integer
	 */
	public Integer getAge_begin() {
		return ((Integer) getAttrVal("Age_begin"));
	}	
	/**
	 * 开始年龄
	 * @param Age_begin
	 */
	public void setAge_begin(Integer Age_begin) {
		setAttrVal("Age_begin", Age_begin);
	}
	/**
	 * 截止年龄
	 * @return Integer
	 */
	public Integer getAge_end() {
		return ((Integer) getAttrVal("Age_end"));
	}	
	/**
	 * 截止年龄
	 * @param Age_end
	 */
	public void setAge_end(Integer Age_end) {
		setAttrVal("Age_end", Age_end);
	}
	/**
	 * 开始值
	 * @return FDouble
	 */
	public FDouble getRange_begin() {
		return ((FDouble) getAttrVal("Range_begin"));
	}	
	/**
	 * 开始值
	 * @param Range_begin
	 */
	public void setRange_begin(FDouble Range_begin) {
		setAttrVal("Range_begin", Range_begin);
	}
	/**
	 * 截止值
	 * @return FDouble
	 */
	public FDouble getRange_end() {
		return ((FDouble) getAttrVal("Range_end"));
	}	
	/**
	 * 截止值
	 * @param Range_end
	 */
	public void setRange_end(FDouble Range_end) {
		setAttrVal("Range_end", Range_end);
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
		return "Id_pesrvitemrangerule";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_itm_pesrvitemrangerule";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeSrvItemRangeRuleDODesc.class);
	}
	
}