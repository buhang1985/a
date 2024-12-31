package iih.pe.phm.pehmriskdef.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.phm.pehmriskdef.d.desc.PeHmRiskAgeTargetDODesc;
import java.math.BigDecimal;

/**
 * 健康危险因素-评价年龄定义 DO数据 
 * 
 */
public class PeHmRiskAgeTargetDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//健康危险因素-评价年龄主键标识
	public static final String ID_RISKAGETARGET= "Id_riskagetarget";
	//健康危险因素目录ID
	public static final String ID_RISKDEF= "Id_riskdef";
	//性别限制
	public static final String SEXLIMIT= "Sexlimit";
	//开始年龄
	public static final String AGE_BEGIN= "Age_begin";
	//截止年龄
	public static final String AGE_END= "Age_end";
	//危险强度
	public static final String INTENSITY= "Intensity";
	//危险频度
	public static final String FREQ= "Freq";
	//危险程度
	public static final String DEGREE= "Degree";
	//序号
	public static final String SORTNO= "Sortno";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 健康危险因素-评价年龄主键标识
	 * @return String
	 */
	public String getId_riskagetarget() {
		return ((String) getAttrVal("Id_riskagetarget"));
	}	
	/**
	 * 健康危险因素-评价年龄主键标识
	 * @param Id_riskagetarget
	 */
	public void setId_riskagetarget(String Id_riskagetarget) {
		setAttrVal("Id_riskagetarget", Id_riskagetarget);
	}
	/**
	 * 健康危险因素目录ID
	 * @return String
	 */
	public String getId_riskdef() {
		return ((String) getAttrVal("Id_riskdef"));
	}	
	/**
	 * 健康危险因素目录ID
	 * @param Id_riskdef
	 */
	public void setId_riskdef(String Id_riskdef) {
		setAttrVal("Id_riskdef", Id_riskdef);
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
	 * 危险强度
	 * @return FDouble
	 */
	public FDouble getIntensity() {
		return ((FDouble) getAttrVal("Intensity"));
	}	
	/**
	 * 危险强度
	 * @param Intensity
	 */
	public void setIntensity(FDouble Intensity) {
		setAttrVal("Intensity", Intensity);
	}
	/**
	 * 危险频度
	 * @return FDouble
	 */
	public FDouble getFreq() {
		return ((FDouble) getAttrVal("Freq"));
	}	
	/**
	 * 危险频度
	 * @param Freq
	 */
	public void setFreq(FDouble Freq) {
		setAttrVal("Freq", Freq);
	}
	/**
	 * 危险程度
	 * @return FDouble
	 */
	public FDouble getDegree() {
		return ((FDouble) getAttrVal("Degree"));
	}	
	/**
	 * 危险程度
	 * @param Degree
	 */
	public void setDegree(FDouble Degree) {
		setAttrVal("Degree", Degree);
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
		return "Id_riskagetarget";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_hm_riskagetarget";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeHmRiskAgeTargetDODesc.class);
	}
	
}