package iih.en.pv.entplan.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.en.pv.entplan.d.desc.EntHpDODesc;
import java.math.BigDecimal;

/**
 * 就诊医保计划 DO数据 
 * 
 */
public class EntHpDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//患者就诊医保计划主键
	public static final String ID_ENTHP= "Id_enthp";
	//患者就诊
	public static final String ID_ENT= "Id_ent";
	//序号
	public static final String SORTNO= "Sortno";
	//医保计划
	public static final String ID_HP= "Id_hp";
	//医保卡号
	public static final String NO_HP= "No_hp";
	//主医保计划标志
	public static final String FG_MAJ= "Fg_maj";
	//医保基金支付标志
	public static final String FG_FUNDPAY= "Fg_fundpay";
	//是否持卡结算
	public static final String FG_HP_CARD= "Fg_hp_card";
	//险种
	public static final String ID_HPKIND= "Id_hpkind";
	//特病标识
	public static final String FG_HPSPCL= "Fg_hpspcl";
	//险种编码
	public static final String CODE_HPKIND= "Code_hpkind";
	//医保身份id
	public static final String ID_HPPATCA= "Id_hppatca";
	//医保身份编码
	public static final String CODE_HPPATCA= "Code_hppatca";
	//医保统筹地区
	public static final String CODE_HPAREA= "Code_hparea";
	//个人编号
	public static final String PERSONNO= "Personno";
	//医疗类别
	public static final String CODE_HPMEDKIND= "Code_hpmedkind";
	//医保计划名称
	public static final String NAME_HP= "Name_hp";
	//医保计划编码
	public static final String CODE_HP= "Code_hp";
	//险种名称
	public static final String NAME_HPKIND= "Name_hpkind";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 患者就诊医保计划主键
	 * @return String
	 */
	public String getId_enthp() {
		return ((String) getAttrVal("Id_enthp"));
	}	
	/**
	 * 患者就诊医保计划主键
	 * @param Id_enthp
	 */
	public void setId_enthp(String Id_enthp) {
		setAttrVal("Id_enthp", Id_enthp);
	}
	/**
	 * 患者就诊
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	/**
	 * 患者就诊
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
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
	 * 医保计划
	 * @return String
	 */
	public String getId_hp() {
		return ((String) getAttrVal("Id_hp"));
	}	
	/**
	 * 医保计划
	 * @param Id_hp
	 */
	public void setId_hp(String Id_hp) {
		setAttrVal("Id_hp", Id_hp);
	}
	/**
	 * 医保卡号
	 * @return String
	 */
	public String getNo_hp() {
		return ((String) getAttrVal("No_hp"));
	}	
	/**
	 * 医保卡号
	 * @param No_hp
	 */
	public void setNo_hp(String No_hp) {
		setAttrVal("No_hp", No_hp);
	}
	/**
	 * 主医保计划标志
	 * @return FBoolean
	 */
	public FBoolean getFg_maj() {
		return ((FBoolean) getAttrVal("Fg_maj"));
	}	
	/**
	 * 主医保计划标志
	 * @param Fg_maj
	 */
	public void setFg_maj(FBoolean Fg_maj) {
		setAttrVal("Fg_maj", Fg_maj);
	}
	/**
	 * 医保基金支付标志
	 * @return FBoolean
	 */
	public FBoolean getFg_fundpay() {
		return ((FBoolean) getAttrVal("Fg_fundpay"));
	}	
	/**
	 * 医保基金支付标志
	 * @param Fg_fundpay
	 */
	public void setFg_fundpay(FBoolean Fg_fundpay) {
		setAttrVal("Fg_fundpay", Fg_fundpay);
	}
	/**
	 * 是否持卡结算
	 * @return FBoolean
	 */
	public FBoolean getFg_hp_card() {
		return ((FBoolean) getAttrVal("Fg_hp_card"));
	}	
	/**
	 * 是否持卡结算
	 * @param Fg_hp_card
	 */
	public void setFg_hp_card(FBoolean Fg_hp_card) {
		setAttrVal("Fg_hp_card", Fg_hp_card);
	}
	/**
	 * 险种
	 * @return String
	 */
	public String getId_hpkind() {
		return ((String) getAttrVal("Id_hpkind"));
	}	
	/**
	 * 险种
	 * @param Id_hpkind
	 */
	public void setId_hpkind(String Id_hpkind) {
		setAttrVal("Id_hpkind", Id_hpkind);
	}
	/**
	 * 特病标识
	 * @return FBoolean
	 */
	public FBoolean getFg_hpspcl() {
		return ((FBoolean) getAttrVal("Fg_hpspcl"));
	}	
	/**
	 * 特病标识
	 * @param Fg_hpspcl
	 */
	public void setFg_hpspcl(FBoolean Fg_hpspcl) {
		setAttrVal("Fg_hpspcl", Fg_hpspcl);
	}
	/**
	 * 险种编码
	 * @return String
	 */
	public String getCode_hpkind() {
		return ((String) getAttrVal("Code_hpkind"));
	}	
	/**
	 * 险种编码
	 * @param Code_hpkind
	 */
	public void setCode_hpkind(String Code_hpkind) {
		setAttrVal("Code_hpkind", Code_hpkind);
	}
	/**
	 * 医保身份id
	 * @return String
	 */
	public String getId_hppatca() {
		return ((String) getAttrVal("Id_hppatca"));
	}	
	/**
	 * 医保身份id
	 * @param Id_hppatca
	 */
	public void setId_hppatca(String Id_hppatca) {
		setAttrVal("Id_hppatca", Id_hppatca);
	}
	/**
	 * 医保身份编码
	 * @return String
	 */
	public String getCode_hppatca() {
		return ((String) getAttrVal("Code_hppatca"));
	}	
	/**
	 * 医保身份编码
	 * @param Code_hppatca
	 */
	public void setCode_hppatca(String Code_hppatca) {
		setAttrVal("Code_hppatca", Code_hppatca);
	}
	/**
	 * 医保统筹地区
	 * @return String
	 */
	public String getCode_hparea() {
		return ((String) getAttrVal("Code_hparea"));
	}	
	/**
	 * 医保统筹地区
	 * @param Code_hparea
	 */
	public void setCode_hparea(String Code_hparea) {
		setAttrVal("Code_hparea", Code_hparea);
	}
	/**
	 * 个人编号
	 * @return String
	 */
	public String getPersonno() {
		return ((String) getAttrVal("Personno"));
	}	
	/**
	 * 个人编号
	 * @param Personno
	 */
	public void setPersonno(String Personno) {
		setAttrVal("Personno", Personno);
	}
	/**
	 * 医疗类别
	 * @return String
	 */
	public String getCode_hpmedkind() {
		return ((String) getAttrVal("Code_hpmedkind"));
	}	
	/**
	 * 医疗类别
	 * @param Code_hpmedkind
	 */
	public void setCode_hpmedkind(String Code_hpmedkind) {
		setAttrVal("Code_hpmedkind", Code_hpmedkind);
	}
	/**
	 * 医保计划名称
	 * @return String
	 */
	public String getName_hp() {
		return ((String) getAttrVal("Name_hp"));
	}	
	/**
	 * 医保计划名称
	 * @param Name_hp
	 */
	public void setName_hp(String Name_hp) {
		setAttrVal("Name_hp", Name_hp);
	}
	/**
	 * 医保计划编码
	 * @return String
	 */
	public String getCode_hp() {
		return ((String) getAttrVal("Code_hp"));
	}	
	/**
	 * 医保计划编码
	 * @param Code_hp
	 */
	public void setCode_hp(String Code_hp) {
		setAttrVal("Code_hp", Code_hp);
	}
	/**
	 * 险种名称
	 * @return String
	 */
	public String getName_hpkind() {
		return ((String) getAttrVal("Name_hpkind"));
	}	
	/**
	 * 险种名称
	 * @param Name_hpkind
	 */
	public void setName_hpkind(String Name_hpkind) {
		setAttrVal("Name_hpkind", Name_hpkind);
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
		return "Id_enthp";
	}
	
	@Override
	public String getTableName() {	  
		return "en_ent_hp";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(EntHpDODesc.class);
	}
	
}