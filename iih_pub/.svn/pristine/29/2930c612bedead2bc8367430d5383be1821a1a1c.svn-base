package iih.pe.phm.pehmlifestyle.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.phm.pehmlifestyle.d.desc.PeHmLifestyleDtlDODesc;
import java.math.BigDecimal;

/**
 * 健康生活方式评估结果 DO数据 
 * 
 */
public class PeHmLifestyleDtlDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//健康生活方式评估明细主键标识
	public static final String ID_LIFESTYLEDTL= "Id_lifestyledtl";
	//健康生活方式评估ID
	public static final String ID_LIFESTYLE= "Id_lifestyle";
	//健康生活方式评估项目定义ID
	public static final String ID_PEEVALLIFESTYLEITM= "Id_peevallifestyleitm";
	//评估结果
	public static final String RST= "Rst";
	//立即改善
	public static final String FG_IMPROVE= "Fg_improve";
	//继续改善
	public static final String FG_CONTIMPROVE= "Fg_contimprove";
	//继续保存
	public static final String FG_MAINTAIN= "Fg_maintain";
	//本次得分
	public static final String SCORE= "Score";
	//项目编码
	public static final String CODE_ITEM= "Code_item";
	//项目名称
	public static final String NAME_ITEM= "Name_item";
	//参考值
	public static final String VALUE_REF_ITEM= "Value_ref_item";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 健康生活方式评估明细主键标识
	 * @return String
	 */
	public String getId_lifestyledtl() {
		return ((String) getAttrVal("Id_lifestyledtl"));
	}	
	/**
	 * 健康生活方式评估明细主键标识
	 * @param Id_lifestyledtl
	 */
	public void setId_lifestyledtl(String Id_lifestyledtl) {
		setAttrVal("Id_lifestyledtl", Id_lifestyledtl);
	}
	/**
	 * 健康生活方式评估ID
	 * @return String
	 */
	public String getId_lifestyle() {
		return ((String) getAttrVal("Id_lifestyle"));
	}	
	/**
	 * 健康生活方式评估ID
	 * @param Id_lifestyle
	 */
	public void setId_lifestyle(String Id_lifestyle) {
		setAttrVal("Id_lifestyle", Id_lifestyle);
	}
	/**
	 * 健康生活方式评估项目定义ID
	 * @return String
	 */
	public String getId_peevallifestyleitm() {
		return ((String) getAttrVal("Id_peevallifestyleitm"));
	}	
	/**
	 * 健康生活方式评估项目定义ID
	 * @param Id_peevallifestyleitm
	 */
	public void setId_peevallifestyleitm(String Id_peevallifestyleitm) {
		setAttrVal("Id_peevallifestyleitm", Id_peevallifestyleitm);
	}
	/**
	 * 评估结果
	 * @return String
	 */
	public String getRst() {
		return ((String) getAttrVal("Rst"));
	}	
	/**
	 * 评估结果
	 * @param Rst
	 */
	public void setRst(String Rst) {
		setAttrVal("Rst", Rst);
	}
	/**
	 * 立即改善
	 * @return FBoolean
	 */
	public FBoolean getFg_improve() {
		return ((FBoolean) getAttrVal("Fg_improve"));
	}	
	/**
	 * 立即改善
	 * @param Fg_improve
	 */
	public void setFg_improve(FBoolean Fg_improve) {
		setAttrVal("Fg_improve", Fg_improve);
	}
	/**
	 * 继续改善
	 * @return FBoolean
	 */
	public FBoolean getFg_contimprove() {
		return ((FBoolean) getAttrVal("Fg_contimprove"));
	}	
	/**
	 * 继续改善
	 * @param Fg_contimprove
	 */
	public void setFg_contimprove(FBoolean Fg_contimprove) {
		setAttrVal("Fg_contimprove", Fg_contimprove);
	}
	/**
	 * 继续保存
	 * @return FBoolean
	 */
	public FBoolean getFg_maintain() {
		return ((FBoolean) getAttrVal("Fg_maintain"));
	}	
	/**
	 * 继续保存
	 * @param Fg_maintain
	 */
	public void setFg_maintain(FBoolean Fg_maintain) {
		setAttrVal("Fg_maintain", Fg_maintain);
	}
	/**
	 * 本次得分
	 * @return FDouble
	 */
	public FDouble getScore() {
		return ((FDouble) getAttrVal("Score"));
	}	
	/**
	 * 本次得分
	 * @param Score
	 */
	public void setScore(FDouble Score) {
		setAttrVal("Score", Score);
	}
	/**
	 * 项目编码
	 * @return String
	 */
	public String getCode_item() {
		return ((String) getAttrVal("Code_item"));
	}	
	/**
	 * 项目编码
	 * @param Code_item
	 */
	public void setCode_item(String Code_item) {
		setAttrVal("Code_item", Code_item);
	}
	/**
	 * 项目名称
	 * @return String
	 */
	public String getName_item() {
		return ((String) getAttrVal("Name_item"));
	}	
	/**
	 * 项目名称
	 * @param Name_item
	 */
	public void setName_item(String Name_item) {
		setAttrVal("Name_item", Name_item);
	}
	/**
	 * 参考值
	 * @return String
	 */
	public String getValue_ref_item() {
		return ((String) getAttrVal("Value_ref_item"));
	}	
	/**
	 * 参考值
	 * @param Value_ref_item
	 */
	public void setValue_ref_item(String Value_ref_item) {
		setAttrVal("Value_ref_item", Value_ref_item);
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
		return "Id_lifestyledtl";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_hm_lifestyledtl";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeHmLifestyleDtlDODesc.class);
	}
	
}