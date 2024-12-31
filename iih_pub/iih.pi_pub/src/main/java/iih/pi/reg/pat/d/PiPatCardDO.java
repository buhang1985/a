package iih.pi.reg.pat.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pi.reg.pat.d.desc.PiPatCardDODesc;
import java.math.BigDecimal;

/**
 * 患者卡信息 DO数据 
 * 
 */
public class PiPatCardDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//患者卡ID
	public static final String ID_PATCARD= "Id_patcard";
	//患者
	public static final String ID_PAT= "Id_pat";
	//患者卡类型编码
	public static final String SD_PATCARDTP= "Sd_patcardtp";
	//患者卡类型
	public static final String ID_PATCARDTP= "Id_patcardtp";
	//患者卡编号
	public static final String CODE= "Code";
	//默认标志
	public static final String FG_DEF= "Fg_def";
	//就诊卡
	public static final String ID_CARD= "Id_card";
	//有效开始日期
	public static final String DT_B= "Dt_b";
	//有效结束日期
	public static final String DT_E= "Dt_e";
	//使用标志
	public static final String FG_ACT= "Fg_act";
	//序号
	public static final String SORTNO= "Sortno";
	//挂失
	public static final String FG_PICARDLOSS= "Fg_picardloss";
	//卡工本费
	public static final String CARD_COST= "Card_cost";
	//卡来源
	public static final String CARD_SRC= "Card_src";
	//卡费记账方式
	public static final String EU_CARDCGMD= "Eu_cardcgmd";
	//患者卡类型编码
	public static final String PATCARDTP_CODE= "Patcardtp_code";
	//患者卡类型名称
	public static final String PATCARDTP_NAME= "Patcardtp_name";
	//患者卡类型性质编码
	public static final String SD_PATCARDTP_UDI= "Sd_patcardtp_udi";
	//就诊卡编号
	public static final String CARD_CODE= "Card_code";
	//就诊卡状态
	public static final String EU_CARDSU= "Eu_cardsu";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 患者卡ID
	 * @return String
	 */
	public String getId_patcard() {
		return ((String) getAttrVal("Id_patcard"));
	}	
	/**
	 * 患者卡ID
	 * @param Id_patcard
	 */
	public void setId_patcard(String Id_patcard) {
		setAttrVal("Id_patcard", Id_patcard);
	}
	/**
	 * 患者
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	/**
	 * 患者
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 患者卡类型编码
	 * @return String
	 */
	public String getSd_patcardtp() {
		return ((String) getAttrVal("Sd_patcardtp"));
	}	
	/**
	 * 患者卡类型编码
	 * @param Sd_patcardtp
	 */
	public void setSd_patcardtp(String Sd_patcardtp) {
		setAttrVal("Sd_patcardtp", Sd_patcardtp);
	}
	/**
	 * 患者卡类型
	 * @return String
	 */
	public String getId_patcardtp() {
		return ((String) getAttrVal("Id_patcardtp"));
	}	
	/**
	 * 患者卡类型
	 * @param Id_patcardtp
	 */
	public void setId_patcardtp(String Id_patcardtp) {
		setAttrVal("Id_patcardtp", Id_patcardtp);
	}
	/**
	 * 患者卡编号
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 患者卡编号
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 默认标志
	 * @return FBoolean
	 */
	public FBoolean getFg_def() {
		return ((FBoolean) getAttrVal("Fg_def"));
	}	
	/**
	 * 默认标志
	 * @param Fg_def
	 */
	public void setFg_def(FBoolean Fg_def) {
		setAttrVal("Fg_def", Fg_def);
	}
	/**
	 * 就诊卡
	 * @return String
	 */
	public String getId_card() {
		return ((String) getAttrVal("Id_card"));
	}	
	/**
	 * 就诊卡
	 * @param Id_card
	 */
	public void setId_card(String Id_card) {
		setAttrVal("Id_card", Id_card);
	}
	/**
	 * 有效开始日期
	 * @return FDateTime
	 */
	public FDateTime getDt_b() {
		return ((FDateTime) getAttrVal("Dt_b"));
	}	
	/**
	 * 有效开始日期
	 * @param Dt_b
	 */
	public void setDt_b(FDateTime Dt_b) {
		setAttrVal("Dt_b", Dt_b);
	}
	/**
	 * 有效结束日期
	 * @return FDateTime
	 */
	public FDateTime getDt_e() {
		return ((FDateTime) getAttrVal("Dt_e"));
	}	
	/**
	 * 有效结束日期
	 * @param Dt_e
	 */
	public void setDt_e(FDateTime Dt_e) {
		setAttrVal("Dt_e", Dt_e);
	}
	/**
	 * 使用标志
	 * @return FBoolean
	 */
	public FBoolean getFg_act() {
		return ((FBoolean) getAttrVal("Fg_act"));
	}	
	/**
	 * 使用标志
	 * @param Fg_act
	 */
	public void setFg_act(FBoolean Fg_act) {
		setAttrVal("Fg_act", Fg_act);
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
	/**
	 * 挂失
	 * @return FBoolean
	 */
	public FBoolean getFg_picardloss() {
		return ((FBoolean) getAttrVal("Fg_picardloss"));
	}	
	/**
	 * 挂失
	 * @param Fg_picardloss
	 */
	public void setFg_picardloss(FBoolean Fg_picardloss) {
		setAttrVal("Fg_picardloss", Fg_picardloss);
	}
	/**
	 * 卡工本费
	 * @return FDouble
	 */
	public FDouble getCard_cost() {
		return ((FDouble) getAttrVal("Card_cost"));
	}	
	/**
	 * 卡工本费
	 * @param Card_cost
	 */
	public void setCard_cost(FDouble Card_cost) {
		setAttrVal("Card_cost", Card_cost);
	}
	/**
	 * 卡来源
	 * @return Integer
	 */
	public Integer getCard_src() {
		return ((Integer) getAttrVal("Card_src"));
	}	
	/**
	 * 卡来源
	 * @param Card_src
	 */
	public void setCard_src(Integer Card_src) {
		setAttrVal("Card_src", Card_src);
	}
	/**
	 * 卡费记账方式
	 * @return String
	 */
	public String getEu_cardcgmd() {
		return ((String) getAttrVal("Eu_cardcgmd"));
	}	
	/**
	 * 卡费记账方式
	 * @param Eu_cardcgmd
	 */
	public void setEu_cardcgmd(String Eu_cardcgmd) {
		setAttrVal("Eu_cardcgmd", Eu_cardcgmd);
	}
	/**
	 * 患者卡类型编码
	 * @return String
	 */
	public String getPatcardtp_code() {
		return ((String) getAttrVal("Patcardtp_code"));
	}	
	/**
	 * 患者卡类型编码
	 * @param Patcardtp_code
	 */
	public void setPatcardtp_code(String Patcardtp_code) {
		setAttrVal("Patcardtp_code", Patcardtp_code);
	}
	/**
	 * 患者卡类型名称
	 * @return String
	 */
	public String getPatcardtp_name() {
		return ((String) getAttrVal("Patcardtp_name"));
	}	
	/**
	 * 患者卡类型名称
	 * @param Patcardtp_name
	 */
	public void setPatcardtp_name(String Patcardtp_name) {
		setAttrVal("Patcardtp_name", Patcardtp_name);
	}
	/**
	 * 患者卡类型性质编码
	 * @return String
	 */
	public String getSd_patcardtp_udi() {
		return ((String) getAttrVal("Sd_patcardtp_udi"));
	}	
	/**
	 * 患者卡类型性质编码
	 * @param Sd_patcardtp_udi
	 */
	public void setSd_patcardtp_udi(String Sd_patcardtp_udi) {
		setAttrVal("Sd_patcardtp_udi", Sd_patcardtp_udi);
	}
	/**
	 * 就诊卡编号
	 * @return String
	 */
	public String getCard_code() {
		return ((String) getAttrVal("Card_code"));
	}	
	/**
	 * 就诊卡编号
	 * @param Card_code
	 */
	public void setCard_code(String Card_code) {
		setAttrVal("Card_code", Card_code);
	}
	/**
	 * 就诊卡状态
	 * @return Integer
	 */
	public Integer getEu_cardsu() {
		return ((Integer) getAttrVal("Eu_cardsu"));
	}	
	/**
	 * 就诊卡状态
	 * @param Eu_cardsu
	 */
	public void setEu_cardsu(Integer Eu_cardsu) {
		setAttrVal("Eu_cardsu", Eu_cardsu);
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
		return "Id_patcard";
	}
	
	@Override
	public String getTableName() {	  
		return "pi_pat_card";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PiPatCardDODesc.class);
	}
	
}