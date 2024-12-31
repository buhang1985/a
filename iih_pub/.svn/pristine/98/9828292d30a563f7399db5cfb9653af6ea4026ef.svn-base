package iih.en.er.pre.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.en.er.pre.d.desc.EnErPreScoreDODesc;
import java.math.BigDecimal;

/**
 * 急诊预检_分级 DO数据 
 * 
 */
public class EnErPreScoreDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//急诊预检分级id
	public static final String ID_ERPRE_SCORE= "Id_erpre_score";
	//预检id
	public static final String ID_ERPRE= "Id_erpre";
	//评分类型
	public static final String ID_SCOTP= "Id_scotp";
	//评分类型编码
	public static final String SD_SCOTP= "Sd_scotp";
	//分数
	public static final String SCORE= "Score";
	//补充说明
	public static final String NOTE= "Note";
	//评分类型名称
	public static final String NAME_SCOTP= "Name_scotp";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 急诊预检分级id
	 * @return String
	 */
	public String getId_erpre_score() {
		return ((String) getAttrVal("Id_erpre_score"));
	}	
	/**
	 * 急诊预检分级id
	 * @param Id_erpre_score
	 */
	public void setId_erpre_score(String Id_erpre_score) {
		setAttrVal("Id_erpre_score", Id_erpre_score);
	}
	/**
	 * 预检id
	 * @return String
	 */
	public String getId_erpre() {
		return ((String) getAttrVal("Id_erpre"));
	}	
	/**
	 * 预检id
	 * @param Id_erpre
	 */
	public void setId_erpre(String Id_erpre) {
		setAttrVal("Id_erpre", Id_erpre);
	}
	/**
	 * 评分类型
	 * @return String
	 */
	public String getId_scotp() {
		return ((String) getAttrVal("Id_scotp"));
	}	
	/**
	 * 评分类型
	 * @param Id_scotp
	 */
	public void setId_scotp(String Id_scotp) {
		setAttrVal("Id_scotp", Id_scotp);
	}
	/**
	 * 评分类型编码
	 * @return String
	 */
	public String getSd_scotp() {
		return ((String) getAttrVal("Sd_scotp"));
	}	
	/**
	 * 评分类型编码
	 * @param Sd_scotp
	 */
	public void setSd_scotp(String Sd_scotp) {
		setAttrVal("Sd_scotp", Sd_scotp);
	}
	/**
	 * 分数
	 * @return String
	 */
	public String getScore() {
		return ((String) getAttrVal("Score"));
	}	
	/**
	 * 分数
	 * @param Score
	 */
	public void setScore(String Score) {
		setAttrVal("Score", Score);
	}
	/**
	 * 补充说明
	 * @return String
	 */
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}	
	/**
	 * 补充说明
	 * @param Note
	 */
	public void setNote(String Note) {
		setAttrVal("Note", Note);
	}
	/**
	 * 评分类型名称
	 * @return String
	 */
	public String getName_scotp() {
		return ((String) getAttrVal("Name_scotp"));
	}	
	/**
	 * 评分类型名称
	 * @param Name_scotp
	 */
	public void setName_scotp(String Name_scotp) {
		setAttrVal("Name_scotp", Name_scotp);
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
		return "Id_erpre_score";
	}
	
	@Override
	public String getTableName() {	  
		return "EN_ERPRE_SCORE";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(EnErPreScoreDODesc.class);
	}
	
}