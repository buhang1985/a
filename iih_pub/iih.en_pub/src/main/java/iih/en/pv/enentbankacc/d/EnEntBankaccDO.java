package iih.en.pv.enentbankacc.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.en.pv.enentbankacc.d.desc.EnEntBankaccDODesc;
import java.math.BigDecimal;

/**
 * 患者银行账户 DO数据 
 * 
 */
public class EnEntBankaccDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//患者就诊银行账户id
	public static final String ID_ENTBANKACC= "Id_entbankacc";
	//集团
	public static final String ID_GRP= "Id_grp";
	//组织
	public static final String ID_ORG= "Id_org";
	//就诊id
	public static final String ID_ENT= "Id_ent";
	//患者id
	public static final String ID_PAT= "Id_pat";
	//银行id
	public static final String ID_BANK= "Id_bank";
	//银行名称
	public static final String BANK_NAME= "Bank_name";
	//联行号
	public static final String BANK_ID_CODE= "Bank_id_code";
	//账户
	public static final String NO_ACC= "No_acc";
	//账户名称
	public static final String NAME_ACC= "Name_acc";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//编码
	public static final String CODE_BANK= "Code_bank";
	//扩展字段1
	public static final String CTRL1= "Ctrl1";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 患者就诊银行账户id
	 * @return String
	 */
	public String getId_entbankacc() {
		return ((String) getAttrVal("Id_entbankacc"));
	}	
	/**
	 * 患者就诊银行账户id
	 * @param Id_entbankacc
	 */
	public void setId_entbankacc(String Id_entbankacc) {
		setAttrVal("Id_entbankacc", Id_entbankacc);
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
	 * 就诊id
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	/**
	 * 就诊id
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 患者id
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	/**
	 * 患者id
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 银行id
	 * @return String
	 */
	public String getId_bank() {
		return ((String) getAttrVal("Id_bank"));
	}	
	/**
	 * 银行id
	 * @param Id_bank
	 */
	public void setId_bank(String Id_bank) {
		setAttrVal("Id_bank", Id_bank);
	}
	/**
	 * 银行名称
	 * @return String
	 */
	public String getBank_name() {
		return ((String) getAttrVal("Bank_name"));
	}	
	/**
	 * 银行名称
	 * @param Bank_name
	 */
	public void setBank_name(String Bank_name) {
		setAttrVal("Bank_name", Bank_name);
	}
	/**
	 * 联行号
	 * @return String
	 */
	public String getBank_id_code() {
		return ((String) getAttrVal("Bank_id_code"));
	}	
	/**
	 * 联行号
	 * @param Bank_id_code
	 */
	public void setBank_id_code(String Bank_id_code) {
		setAttrVal("Bank_id_code", Bank_id_code);
	}
	/**
	 * 账户
	 * @return String
	 */
	public String getNo_acc() {
		return ((String) getAttrVal("No_acc"));
	}	
	/**
	 * 账户
	 * @param No_acc
	 */
	public void setNo_acc(String No_acc) {
		setAttrVal("No_acc", No_acc);
	}
	/**
	 * 账户名称
	 * @return String
	 */
	public String getName_acc() {
		return ((String) getAttrVal("Name_acc"));
	}	
	/**
	 * 账户名称
	 * @param Name_acc
	 */
	public void setName_acc(String Name_acc) {
		setAttrVal("Name_acc", Name_acc);
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
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_bank() {
		return ((String) getAttrVal("Code_bank"));
	}	
	/**
	 * 编码
	 * @param Code_bank
	 */
	public void setCode_bank(String Code_bank) {
		setAttrVal("Code_bank", Code_bank);
	}
	/**
	 * 扩展字段1
	 * @return String
	 */
	public String getCtrl1() {
		return ((String) getAttrVal("Ctrl1"));
	}	
	/**
	 * 扩展字段1
	 * @param Ctrl1
	 */
	public void setCtrl1(String Ctrl1) {
		setAttrVal("Ctrl1", Ctrl1);
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
		return "Id_entbankacc";
	}
	
	@Override
	public String getTableName() {	  
		return "en_ent_bankacc";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(EnEntBankaccDODesc.class);
	}
	
}