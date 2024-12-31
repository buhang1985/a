package iih.pe.pitm.pesrvprog.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pitm.pesrvprog.d.desc.PeSrvProgAgeDODesc;
import java.math.BigDecimal;

/**
 * 体检方案年龄定义 DO数据 
 * 
 */
public class PeSrvProgAgeDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检方案年龄定义主键标识
	public static final String ID_PESRVPROGAGE= "Id_pesrvprogage";
	//体检方案定义ID
	public static final String ID_PESRVPROG= "Id_pesrvprog";
	//开始年龄
	public static final String AGE_BEGIN= "Age_begin";
	//截止年龄
	public static final String AGE_END= "Age_end";
	//检查频率描述
	public static final String CHECK_FREQ= "Check_freq";
	//专家推荐分类
	public static final String EXPERTS_RANGE= "Experts_range";
	//最小周期-年
	public static final String YEAR_FREQ_MIN= "Year_freq_min";
	//最大周期-年
	public static final String YEAR_FREQ_MAX= "Year_freq_max";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检方案年龄定义主键标识
	 * @return String
	 */
	public String getId_pesrvprogage() {
		return ((String) getAttrVal("Id_pesrvprogage"));
	}	
	/**
	 * 体检方案年龄定义主键标识
	 * @param Id_pesrvprogage
	 */
	public void setId_pesrvprogage(String Id_pesrvprogage) {
		setAttrVal("Id_pesrvprogage", Id_pesrvprogage);
	}
	/**
	 * 体检方案定义ID
	 * @return String
	 */
	public String getId_pesrvprog() {
		return ((String) getAttrVal("Id_pesrvprog"));
	}	
	/**
	 * 体检方案定义ID
	 * @param Id_pesrvprog
	 */
	public void setId_pesrvprog(String Id_pesrvprog) {
		setAttrVal("Id_pesrvprog", Id_pesrvprog);
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
	 * 检查频率描述
	 * @return String
	 */
	public String getCheck_freq() {
		return ((String) getAttrVal("Check_freq"));
	}	
	/**
	 * 检查频率描述
	 * @param Check_freq
	 */
	public void setCheck_freq(String Check_freq) {
		setAttrVal("Check_freq", Check_freq);
	}
	/**
	 * 专家推荐分类
	 * @return Integer
	 */
	public Integer getExperts_range() {
		return ((Integer) getAttrVal("Experts_range"));
	}	
	/**
	 * 专家推荐分类
	 * @param Experts_range
	 */
	public void setExperts_range(Integer Experts_range) {
		setAttrVal("Experts_range", Experts_range);
	}
	/**
	 * 最小周期-年
	 * @return FDouble
	 */
	public FDouble getYear_freq_min() {
		return ((FDouble) getAttrVal("Year_freq_min"));
	}	
	/**
	 * 最小周期-年
	 * @param Year_freq_min
	 */
	public void setYear_freq_min(FDouble Year_freq_min) {
		setAttrVal("Year_freq_min", Year_freq_min);
	}
	/**
	 * 最大周期-年
	 * @return FDouble
	 */
	public FDouble getYear_freq_max() {
		return ((FDouble) getAttrVal("Year_freq_max"));
	}	
	/**
	 * 最大周期-年
	 * @param Year_freq_max
	 */
	public void setYear_freq_max(FDouble Year_freq_max) {
		setAttrVal("Year_freq_max", Year_freq_max);
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
		return "Id_pesrvprogage";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_itm_pesrvprogage";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeSrvProgAgeDODesc.class);
	}
	
}