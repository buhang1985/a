package iih.bl.cc.blcc.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bl.cc.blcc.d.desc.BlCcIncDODesc;
import java.math.BigDecimal;

/**
 * 结账_发票信息 DO数据 
 * 
 */
public class BlCcIncDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//结账票据信息键
	public static final String ID_CCINC= "Id_ccinc";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//结账
	public static final String ID_CC= "Id_cc";
	//票据分类
	public static final String ID_INCCA= "Id_incca";
	//票据包编号
	public static final String CODE_INCPKG= "Code_incpkg";
	//票据开始号
	public static final String NUM_B= "Num_b";
	//票据结束号
	public static final String NUM_E= "Num_e";
	//作废发票号串
	public static final String INCNOS_CANC= "Incnos_canc";
	//是否电子票纸质票
	public static final String FG_EC_INC= "Fg_ec_inc";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 结账票据信息键
	 * @return String
	 */
	public String getId_ccinc() {
		return ((String) getAttrVal("Id_ccinc"));
	}	
	/**
	 * 结账票据信息键
	 * @param Id_ccinc
	 */
	public void setId_ccinc(String Id_ccinc) {
		setAttrVal("Id_ccinc", Id_ccinc);
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
	 * 票据包编号
	 * @return String
	 */
	public String getCode_incpkg() {
		return ((String) getAttrVal("Code_incpkg"));
	}	
	/**
	 * 票据包编号
	 * @param Code_incpkg
	 */
	public void setCode_incpkg(String Code_incpkg) {
		setAttrVal("Code_incpkg", Code_incpkg);
	}
	/**
	 * 票据开始号
	 * @return String
	 */
	public String getNum_b() {
		return ((String) getAttrVal("Num_b"));
	}	
	/**
	 * 票据开始号
	 * @param Num_b
	 */
	public void setNum_b(String Num_b) {
		setAttrVal("Num_b", Num_b);
	}
	/**
	 * 票据结束号
	 * @return String
	 */
	public String getNum_e() {
		return ((String) getAttrVal("Num_e"));
	}	
	/**
	 * 票据结束号
	 * @param Num_e
	 */
	public void setNum_e(String Num_e) {
		setAttrVal("Num_e", Num_e);
	}
	/**
	 * 作废发票号串
	 * @return String
	 */
	public String getIncnos_canc() {
		return ((String) getAttrVal("Incnos_canc"));
	}	
	/**
	 * 作废发票号串
	 * @param Incnos_canc
	 */
	public void setIncnos_canc(String Incnos_canc) {
		setAttrVal("Incnos_canc", Incnos_canc);
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
		return "Id_ccinc";
	}
	
	@Override
	public String getTableName() {	  
		return "bl_cc_inc";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BlCcIncDODesc.class);
	}
	
}