package iih.bl.cc.blcc.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bl.cc.blcc.d.desc.BlCcIncReDODesc;
import java.math.BigDecimal;

/**
 * 结账_退费发票明细 DO数据 
 * 
 */
public class BlCcIncReDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//结账作废发票主键
	public static final String ID_CCINCRE= "Id_ccincre";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//结账
	public static final String ID_CC= "Id_cc";
	//票据分类
	public static final String ID_INCCA= "Id_incca";
	//退费发票号
	public static final String INCNO_RE= "Incno_re";
	//退费发票日期
	public static final String DT_RE= "Dt_re";
	//是否电子票纸质票
	public static final String FG_EC_INC= "Fg_ec_inc";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 结账作废发票主键
	 * @return String
	 */
	public String getId_ccincre() {
		return ((String) getAttrVal("Id_ccincre"));
	}	
	/**
	 * 结账作废发票主键
	 * @param Id_ccincre
	 */
	public void setId_ccincre(String Id_ccincre) {
		setAttrVal("Id_ccincre", Id_ccincre);
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
	 * 退费发票号
	 * @return String
	 */
	public String getIncno_re() {
		return ((String) getAttrVal("Incno_re"));
	}	
	/**
	 * 退费发票号
	 * @param Incno_re
	 */
	public void setIncno_re(String Incno_re) {
		setAttrVal("Incno_re", Incno_re);
	}
	/**
	 * 退费发票日期
	 * @return FDateTime
	 */
	public FDateTime getDt_re() {
		return ((FDateTime) getAttrVal("Dt_re"));
	}	
	/**
	 * 退费发票日期
	 * @param Dt_re
	 */
	public void setDt_re(FDateTime Dt_re) {
		setAttrVal("Dt_re", Dt_re);
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
		return "Id_ccincre";
	}
	
	@Override
	public String getTableName() {	  
		return "bl_cc_inc_re";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BlCcIncReDODesc.class);
	}
	
}