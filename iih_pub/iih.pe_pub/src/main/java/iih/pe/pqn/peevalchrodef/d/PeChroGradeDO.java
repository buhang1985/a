package iih.pe.pqn.peevalchrodef.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pqn.peevalchrodef.d.desc.PeChroGradeDODesc;
import java.math.BigDecimal;

/**
 * 体检慢病风险分级定义 DO数据 
 * 
 */
public class PeChroGradeDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检慢性病分级定义主键标识
	public static final String ID_PEEVALCHROGRADEDEF= "Id_peevalchrogradedef";
	//体检慢性病定义ID
	public static final String ID_PEEVALCHRODEF= "Id_peevalchrodef";
	//运动处方ID
	public static final String ID_PENSC= "Id_pensc";
	//风险等级
	public static final String GRADECA= "Gradeca";
	//大于分值
	public static final String SCORE_BEGIN= "Score_begin";
	//小于分值
	public static final String SCORE_END= "Score_end";
	//处方编码
	public static final String CODE_SC= "Code_sc";
	//处方名称
	public static final String NAME_SC= "Name_sc";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检慢性病分级定义主键标识
	 * @return String
	 */
	public String getId_peevalchrogradedef() {
		return ((String) getAttrVal("Id_peevalchrogradedef"));
	}	
	/**
	 * 体检慢性病分级定义主键标识
	 * @param Id_peevalchrogradedef
	 */
	public void setId_peevalchrogradedef(String Id_peevalchrogradedef) {
		setAttrVal("Id_peevalchrogradedef", Id_peevalchrogradedef);
	}
	/**
	 * 体检慢性病定义ID
	 * @return String
	 */
	public String getId_peevalchrodef() {
		return ((String) getAttrVal("Id_peevalchrodef"));
	}	
	/**
	 * 体检慢性病定义ID
	 * @param Id_peevalchrodef
	 */
	public void setId_peevalchrodef(String Id_peevalchrodef) {
		setAttrVal("Id_peevalchrodef", Id_peevalchrodef);
	}
	/**
	 * 运动处方ID
	 * @return String
	 */
	public String getId_pensc() {
		return ((String) getAttrVal("Id_pensc"));
	}	
	/**
	 * 运动处方ID
	 * @param Id_pensc
	 */
	public void setId_pensc(String Id_pensc) {
		setAttrVal("Id_pensc", Id_pensc);
	}
	/**
	 * 风险等级
	 * @return Integer
	 */
	public Integer getGradeca() {
		return ((Integer) getAttrVal("Gradeca"));
	}	
	/**
	 * 风险等级
	 * @param Gradeca
	 */
	public void setGradeca(Integer Gradeca) {
		setAttrVal("Gradeca", Gradeca);
	}
	/**
	 * 大于分值
	 * @return Integer
	 */
	public Integer getScore_begin() {
		return ((Integer) getAttrVal("Score_begin"));
	}	
	/**
	 * 大于分值
	 * @param Score_begin
	 */
	public void setScore_begin(Integer Score_begin) {
		setAttrVal("Score_begin", Score_begin);
	}
	/**
	 * 小于分值
	 * @return Integer
	 */
	public Integer getScore_end() {
		return ((Integer) getAttrVal("Score_end"));
	}	
	/**
	 * 小于分值
	 * @param Score_end
	 */
	public void setScore_end(Integer Score_end) {
		setAttrVal("Score_end", Score_end);
	}
	/**
	 * 处方编码
	 * @return String
	 */
	public String getCode_sc() {
		return ((String) getAttrVal("Code_sc"));
	}	
	/**
	 * 处方编码
	 * @param Code_sc
	 */
	public void setCode_sc(String Code_sc) {
		setAttrVal("Code_sc", Code_sc);
	}
	/**
	 * 处方名称
	 * @return String
	 */
	public String getName_sc() {
		return ((String) getAttrVal("Name_sc"));
	}	
	/**
	 * 处方名称
	 * @param Name_sc
	 */
	public void setName_sc(String Name_sc) {
		setAttrVal("Name_sc", Name_sc);
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
		return "Id_peevalchrogradedef";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_qn_pechrograde";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeChroGradeDODesc.class);
	}
	
}