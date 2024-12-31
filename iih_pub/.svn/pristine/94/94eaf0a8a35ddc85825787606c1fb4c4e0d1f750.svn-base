package iih.pe.pqn.pestrokemodel.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pqn.pestrokemodel.d.desc.PeStrokeModelAgeDODesc;
import java.math.BigDecimal;

/**
 * 健康评估模型_脑卒中_年龄 DO数据 
 * 
 */
public class PeStrokeModelAgeDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//脑卒中评估模型年龄主键标识
	public static final String ID_PESTROKEMODELAGE= "Id_pestrokemodelage";
	//脑卒中评估模型ID
	public static final String ID_PESTROKEMODEL= "Id_pestrokemodel";
	//开始年龄
	public static final String AGE_BEGIN= "Age_begin";
	//截止年龄
	public static final String AGE_END= "Age_end";
	//评分
	public static final String SCORE= "Score";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 脑卒中评估模型年龄主键标识
	 * @return String
	 */
	public String getId_pestrokemodelage() {
		return ((String) getAttrVal("Id_pestrokemodelage"));
	}	
	/**
	 * 脑卒中评估模型年龄主键标识
	 * @param Id_pestrokemodelage
	 */
	public void setId_pestrokemodelage(String Id_pestrokemodelage) {
		setAttrVal("Id_pestrokemodelage", Id_pestrokemodelage);
	}
	/**
	 * 脑卒中评估模型ID
	 * @return String
	 */
	public String getId_pestrokemodel() {
		return ((String) getAttrVal("Id_pestrokemodel"));
	}	
	/**
	 * 脑卒中评估模型ID
	 * @param Id_pestrokemodel
	 */
	public void setId_pestrokemodel(String Id_pestrokemodel) {
		setAttrVal("Id_pestrokemodel", Id_pestrokemodel);
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
		return "Id_pestrokemodelage";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_qn_pestrokemodelage";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeStrokeModelAgeDODesc.class);
	}
	
}