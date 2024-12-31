package iih.pe.pqn.peicdvmodel.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pqn.peicdvmodel.d.desc.PeIcdvModelAgeDODesc;
import java.math.BigDecimal;

/**
 * 健康评估模型_缺血性冠心病_年龄 DO数据 
 * 
 */
public class PeIcdvModelAgeDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//缺血性冠心病评估模型年龄主键标识
	public static final String ID_PEICDVMODELAGE= "Id_peicdvmodelage";
	//缺血性冠心病ID
	public static final String ID_PEICDVMODEL= "Id_peicdvmodel";
	//开始年龄
	public static final String AGE_BEGIN= "Age_begin";
	//截止年龄
	public static final String AGE_END= "Age_end";
	//评分
	public static final String SCORE= "Score";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 缺血性冠心病评估模型年龄主键标识
	 * @return String
	 */
	public String getId_peicdvmodelage() {
		return ((String) getAttrVal("Id_peicdvmodelage"));
	}	
	/**
	 * 缺血性冠心病评估模型年龄主键标识
	 * @param Id_peicdvmodelage
	 */
	public void setId_peicdvmodelage(String Id_peicdvmodelage) {
		setAttrVal("Id_peicdvmodelage", Id_peicdvmodelage);
	}
	/**
	 * 缺血性冠心病ID
	 * @return String
	 */
	public String getId_peicdvmodel() {
		return ((String) getAttrVal("Id_peicdvmodel"));
	}	
	/**
	 * 缺血性冠心病ID
	 * @param Id_peicdvmodel
	 */
	public void setId_peicdvmodel(String Id_peicdvmodel) {
		setAttrVal("Id_peicdvmodel", Id_peicdvmodel);
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
		return "Id_peicdvmodelage";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_qn_peicdvmodelage";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeIcdvModelAgeDODesc.class);
	}
	
}