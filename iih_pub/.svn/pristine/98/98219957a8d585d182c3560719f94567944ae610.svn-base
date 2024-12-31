package iih.pe.pqn.pediabmodel.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pqn.pediabmodel.d.desc.PeDiabModelAgeDODesc;
import java.math.BigDecimal;

/**
 * 健康评估模型_糖尿病_年龄 DO数据 
 * 
 */
public class PeDiabModelAgeDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//糖尿病风险评估年龄主键标识
	public static final String ID_PEDIABMODELAGE= "Id_pediabmodelage";
	//糖尿病模型ID
	public static final String ID_PEDIABMODEL= "Id_pediabmodel";
	//开始年龄
	public static final String AGE_BEGIN= "Age_begin";
	//截止年龄
	public static final String AGE_END= "Age_end";
	//评分
	public static final String SCORE= "Score";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 糖尿病风险评估年龄主键标识
	 * @return String
	 */
	public String getId_pediabmodelage() {
		return ((String) getAttrVal("Id_pediabmodelage"));
	}	
	/**
	 * 糖尿病风险评估年龄主键标识
	 * @param Id_pediabmodelage
	 */
	public void setId_pediabmodelage(String Id_pediabmodelage) {
		setAttrVal("Id_pediabmodelage", Id_pediabmodelage);
	}
	/**
	 * 糖尿病模型ID
	 * @return String
	 */
	public String getId_pediabmodel() {
		return ((String) getAttrVal("Id_pediabmodel"));
	}	
	/**
	 * 糖尿病模型ID
	 * @param Id_pediabmodel
	 */
	public void setId_pediabmodel(String Id_pediabmodel) {
		setAttrVal("Id_pediabmodel", Id_pediabmodel);
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
	 * 评分
	 * @return Integer
	 */
	public Integer getScore() {
		return ((Integer) getAttrVal("Score"));
	}	
	/**
	 * 评分
	 * @param Score
	 */
	public void setScore(Integer Score) {
		setAttrVal("Score", Score);
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
		return "Id_pediabmodelage";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_qn_pediabmodelage";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeDiabModelAgeDODesc.class);
	}
	
}