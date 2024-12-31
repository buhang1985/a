package iih.bl.cc.blcc.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bl.cc.blcc.d.desc.BlCcIncCancDODesc;
import java.math.BigDecimal;

/**
 * 结账_作废发票明细 DO数据 
 * 
 */
public class BlCcIncCancDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//结账作废发票主键
	public static final String ID_CCINCCANC= "Id_ccinccanc";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//结账
	public static final String ID_CC= "Id_cc";
	//票据分类
	public static final String ID_INCCA= "Id_incca";
	//作废发票号
	public static final String INCNO_CANC= "Incno_canc";
	//作废发票日期
	public static final String DT_CANC= "Dt_canc";
	//作废发票原因
	public static final String NOTE_CANC= "Note_canc";
	//是否电子票纸质票
	public static final String FG_EC_INC= "Fg_ec_inc";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 结账作废发票主键
	 * @return String
	 */
	public String getId_ccinccanc() {
		return ((String) getAttrVal("Id_ccinccanc"));
	}	
	/**
	 * 结账作废发票主键
	 * @param Id_ccinccanc
	 */
	public void setId_ccinccanc(String Id_ccinccanc) {
		setAttrVal("Id_ccinccanc", Id_ccinccanc);
	}
	/**
	 * 所属集团
	 * @return String
	 */
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	/**
	 * 所属集团
	 * @param Id_grp
	 */
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	/**
	 * 所属组织
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	/**
	 * 所属组织
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 结账
	 * @return String
	 */
	public String getId_cc() {
		return ((String) getAttrVal("Id_cc"));
	}	
	/**
	 * 结账
	 * @param Id_cc
	 */
	public void setId_cc(String Id_cc) {
		setAttrVal("Id_cc", Id_cc);
	}
	/**
	 * 票据分类
	 * @return String
	 */
	public String getId_incca() {
		return ((String) getAttrVal("Id_incca"));
	}	
	/**
	 * 票据分类
	 * @param Id_incca
	 */
	public void setId_incca(String Id_incca) {
		setAttrVal("Id_incca", Id_incca);
	}
	/**
	 * 作废发票号
	 * @return String
	 */
	public String getIncno_canc() {
		return ((String) getAttrVal("Incno_canc"));
	}	
	/**
	 * 作废发票号
	 * @param Incno_canc
	 */
	public void setIncno_canc(String Incno_canc) {
		setAttrVal("Incno_canc", Incno_canc);
	}
	/**
	 * 作废发票日期
	 * @return FDateTime
	 */
	public FDateTime getDt_canc() {
		return ((FDateTime) getAttrVal("Dt_canc"));
	}	
	/**
	 * 作废发票日期
	 * @param Dt_canc
	 */
	public void setDt_canc(FDateTime Dt_canc) {
		setAttrVal("Dt_canc", Dt_canc);
	}
	/**
	 * 作废发票原因
	 * @return String
	 */
	public String getNote_canc() {
		return ((String) getAttrVal("Note_canc"));
	}	
	/**
	 * 作废发票原因
	 * @param Note_canc
	 */
	public void setNote_canc(String Note_canc) {
		setAttrVal("Note_canc", Note_canc);
	}
	/**
	 * 是否电子票纸质票
	 * @return FBoolean
	 */
	public FBoolean getFg_ec_inc() {
		return ((FBoolean) getAttrVal("Fg_ec_inc"));
	}	
	/**
	 * 是否电子票纸质票
	 * @param Fg_ec_inc
	 */
	public void setFg_ec_inc(FBoolean Fg_ec_inc) {
		setAttrVal("Fg_ec_inc", Fg_ec_inc);
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
		return "Id_ccinccanc";
	}
	
	@Override
	public String getTableName() {	  
		return "bl_cc_inc_canc";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BlCcIncCancDODesc.class);
	}
	
}