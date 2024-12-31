package iih.bl.hp.hpentrefunddetail.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bl.hp.hpentrefunddetail.d.desc.HpEntRefundDetailDODesc;
import java.math.BigDecimal;

/**
 * 医保半退明细记录 DO数据 
 * 
 */
public class HpEntRefundDetailDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//半退明细记录id
	public static final String ID_RFDITM= "Id_rfditm";
	//集团
	public static final String ID_GRP= "Id_grp";
	//组织
	public static final String ID_ORG= "Id_org";
	//医保登记id
	public static final String ID_ENTCODE= "Id_entcode";
	//重收结算编码
	public static final String CODE_ST_RECHARGE= "Code_st_recharge";
	//原记账id
	public static final String ID_CGITMOLD= "Id_cgitmold";
	//退费数量
	public static final String QUAN_RET= "Quan_ret";
	//新记账id
	public static final String ID_CGITMNEW= "Id_cgitmnew";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 半退明细记录id
	 * @return String
	 */
	public String getId_rfditm() {
		return ((String) getAttrVal("Id_rfditm"));
	}	
	/**
	 * 半退明细记录id
	 * @param Id_rfditm
	 */
	public void setId_rfditm(String Id_rfditm) {
		setAttrVal("Id_rfditm", Id_rfditm);
	}
	/**
	 * 集团
	 * @return String
	 */
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	/**
	 * 集团
	 * @param Id_grp
	 */
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	/**
	 * 组织
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	/**
	 * 组织
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 医保登记id
	 * @return String
	 */
	public String getId_entcode() {
		return ((String) getAttrVal("Id_entcode"));
	}	
	/**
	 * 医保登记id
	 * @param Id_entcode
	 */
	public void setId_entcode(String Id_entcode) {
		setAttrVal("Id_entcode", Id_entcode);
	}
	/**
	 * 重收结算编码
	 * @return String
	 */
	public String getCode_st_recharge() {
		return ((String) getAttrVal("Code_st_recharge"));
	}	
	/**
	 * 重收结算编码
	 * @param Code_st_recharge
	 */
	public void setCode_st_recharge(String Code_st_recharge) {
		setAttrVal("Code_st_recharge", Code_st_recharge);
	}
	/**
	 * 原记账id
	 * @return String
	 */
	public String getId_cgitmold() {
		return ((String) getAttrVal("Id_cgitmold"));
	}	
	/**
	 * 原记账id
	 * @param Id_cgitmold
	 */
	public void setId_cgitmold(String Id_cgitmold) {
		setAttrVal("Id_cgitmold", Id_cgitmold);
	}
	/**
	 * 退费数量
	 * @return FDouble
	 */
	public FDouble getQuan_ret() {
		return ((FDouble) getAttrVal("Quan_ret"));
	}	
	/**
	 * 退费数量
	 * @param Quan_ret
	 */
	public void setQuan_ret(FDouble Quan_ret) {
		setAttrVal("Quan_ret", Quan_ret);
	}
	/**
	 * 新记账id
	 * @return String
	 */
	public String getId_cgitmnew() {
		return ((String) getAttrVal("Id_cgitmnew"));
	}	
	/**
	 * 新记账id
	 * @param Id_cgitmnew
	 */
	public void setId_cgitmnew(String Id_cgitmnew) {
		setAttrVal("Id_cgitmnew", Id_cgitmnew);
	}
	/**
	 * 创建人
	 * @return String
	 */
	public String getCreatedby() {
		return ((String) getAttrVal("Createdby"));
	}	
	/**
	 * 创建人
	 * @param Createdby
	 */
	public void setCreatedby(String Createdby) {
		setAttrVal("Createdby", Createdby);
	}
	/**
	 * 创建时间
	 * @return FDateTime
	 */
	public FDateTime getCreatedtime() {
		return ((FDateTime) getAttrVal("Createdtime"));
	}	
	/**
	 * 创建时间
	 * @param Createdtime
	 */
	public void setCreatedtime(FDateTime Createdtime) {
		setAttrVal("Createdtime", Createdtime);
	}
	/**
	 * 最后修改人
	 * @return String
	 */
	public String getModifiedby() {
		return ((String) getAttrVal("Modifiedby"));
	}	
	/**
	 * 最后修改人
	 * @param Modifiedby
	 */
	public void setModifiedby(String Modifiedby) {
		setAttrVal("Modifiedby", Modifiedby);
	}
	/**
	 * 最后修改时间
	 * @return FDateTime
	 */
	public FDateTime getModifiedtime() {
		return ((FDateTime) getAttrVal("Modifiedtime"));
	}	
	/**
	 * 最后修改时间
	 * @param Modifiedtime
	 */
	public void setModifiedtime(FDateTime Modifiedtime) {
		setAttrVal("Modifiedtime", Modifiedtime);
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
		return "Id_rfditm";
	}
	
	@Override
	public String getTableName() {	  
		return "bl_hp_entcode_rfditm";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(HpEntRefundDetailDODesc.class);
	}
	
}