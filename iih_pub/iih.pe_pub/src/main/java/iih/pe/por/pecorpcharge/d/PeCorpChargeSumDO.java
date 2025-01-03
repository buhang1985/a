package iih.pe.por.pecorpcharge.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.por.pecorpcharge.d.desc.PeCorpChargeSumDODesc;
import java.math.BigDecimal;

/**
 * 体检团体费用结账单汇总 DO数据 
 * 
 */
public class PeCorpChargeSumDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检团体结账汇总主键标识
	public static final String ID_PECORPCHARGESUM= "Id_pecorpchargesum";
	//体检团体结账ID
	public static final String ID_PECORPCHARGE= "Id_pecorpcharge";
	//收费项目
	public static final String ID_SRV= "Id_srv";
	//收费项目编码
	public static final String SD_SRV= "Sd_srv";
	//体检费基础价格
	public static final String BASE_PRI= "Base_pri";
	//套餐价格
	public static final String CHARGE_PE_SET= "Charge_pe_set";
	//加项价格
	public static final String CHARGE_PE_ADD= "Charge_pe_add";
	//减项价格
	public static final String CHARGE_PE_SUB= "Charge_pe_sub";
	//体检总费用
	public static final String CHARGE_PE= "Charge_pe";
	//折扣
	public static final String DISCOUNT= "Discount";
	//折后实收费用
	public static final String AMOUNT= "Amount";
	//体检人数汇总
	public static final String PSNS= "Psns";
	//体检费倍数
	public static final String BASEPRITIMES= "Basepritimes";
	//服务编码
	public static final String CODE_SRV= "Code_srv";
	//服务名称
	public static final String NAME_SRV= "Name_srv";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检团体结账汇总主键标识
	 * @return String
	 */
	public String getId_pecorpchargesum() {
		return ((String) getAttrVal("Id_pecorpchargesum"));
	}	
	/**
	 * 体检团体结账汇总主键标识
	 * @param Id_pecorpchargesum
	 */
	public void setId_pecorpchargesum(String Id_pecorpchargesum) {
		setAttrVal("Id_pecorpchargesum", Id_pecorpchargesum);
	}
	/**
	 * 体检团体结账ID
	 * @return String
	 */
	public String getId_pecorpcharge() {
		return ((String) getAttrVal("Id_pecorpcharge"));
	}	
	/**
	 * 体检团体结账ID
	 * @param Id_pecorpcharge
	 */
	public void setId_pecorpcharge(String Id_pecorpcharge) {
		setAttrVal("Id_pecorpcharge", Id_pecorpcharge);
	}
	/**
	 * 收费项目
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	/**
	 * 收费项目
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 收费项目编码
	 * @return String
	 */
	public String getSd_srv() {
		return ((String) getAttrVal("Sd_srv"));
	}	
	/**
	 * 收费项目编码
	 * @param Sd_srv
	 */
	public void setSd_srv(String Sd_srv) {
		setAttrVal("Sd_srv", Sd_srv);
	}
	/**
	 * 体检费基础价格
	 * @return FDouble
	 */
	public FDouble getBase_pri() {
		return ((FDouble) getAttrVal("Base_pri"));
	}	
	/**
	 * 体检费基础价格
	 * @param Base_pri
	 */
	public void setBase_pri(FDouble Base_pri) {
		setAttrVal("Base_pri", Base_pri);
	}
	/**
	 * 套餐价格
	 * @return FDouble
	 */
	public FDouble getCharge_pe_set() {
		return ((FDouble) getAttrVal("Charge_pe_set"));
	}	
	/**
	 * 套餐价格
	 * @param Charge_pe_set
	 */
	public void setCharge_pe_set(FDouble Charge_pe_set) {
		setAttrVal("Charge_pe_set", Charge_pe_set);
	}
	/**
	 * 加项价格
	 * @return FDouble
	 */
	public FDouble getCharge_pe_add() {
		return ((FDouble) getAttrVal("Charge_pe_add"));
	}	
	/**
	 * 加项价格
	 * @param Charge_pe_add
	 */
	public void setCharge_pe_add(FDouble Charge_pe_add) {
		setAttrVal("Charge_pe_add", Charge_pe_add);
	}
	/**
	 * 减项价格
	 * @return FDouble
	 */
	public FDouble getCharge_pe_sub() {
		return ((FDouble) getAttrVal("Charge_pe_sub"));
	}	
	/**
	 * 减项价格
	 * @param Charge_pe_sub
	 */
	public void setCharge_pe_sub(FDouble Charge_pe_sub) {
		setAttrVal("Charge_pe_sub", Charge_pe_sub);
	}
	/**
	 * 体检总费用
	 * @return FDouble
	 */
	public FDouble getCharge_pe() {
		return ((FDouble) getAttrVal("Charge_pe"));
	}	
	/**
	 * 体检总费用
	 * @param Charge_pe
	 */
	public void setCharge_pe(FDouble Charge_pe) {
		setAttrVal("Charge_pe", Charge_pe);
	}
	/**
	 * 折扣
	 * @return FDouble
	 */
	public FDouble getDiscount() {
		return ((FDouble) getAttrVal("Discount"));
	}	
	/**
	 * 折扣
	 * @param Discount
	 */
	public void setDiscount(FDouble Discount) {
		setAttrVal("Discount", Discount);
	}
	/**
	 * 折后实收费用
	 * @return FDouble
	 */
	public FDouble getAmount() {
		return ((FDouble) getAttrVal("Amount"));
	}	
	/**
	 * 折后实收费用
	 * @param Amount
	 */
	public void setAmount(FDouble Amount) {
		setAttrVal("Amount", Amount);
	}
	/**
	 * 体检人数汇总
	 * @return Integer
	 */
	public Integer getPsns() {
		return ((Integer) getAttrVal("Psns"));
	}	
	/**
	 * 体检人数汇总
	 * @param Psns
	 */
	public void setPsns(Integer Psns) {
		setAttrVal("Psns", Psns);
	}
	/**
	 * 体检费倍数
	 * @return Integer
	 */
	public Integer getBasepritimes() {
		return ((Integer) getAttrVal("Basepritimes"));
	}	
	/**
	 * 体检费倍数
	 * @param Basepritimes
	 */
	public void setBasepritimes(Integer Basepritimes) {
		setAttrVal("Basepritimes", Basepritimes);
	}
	/**
	 * 服务编码
	 * @return String
	 */
	public String getCode_srv() {
		return ((String) getAttrVal("Code_srv"));
	}	
	/**
	 * 服务编码
	 * @param Code_srv
	 */
	public void setCode_srv(String Code_srv) {
		setAttrVal("Code_srv", Code_srv);
	}
	/**
	 * 服务名称
	 * @return String
	 */
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}	
	/**
	 * 服务名称
	 * @param Name_srv
	 */
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
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
		return "Id_pecorpchargesum";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_or_pecorpchargesum";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeCorpChargeSumDODesc.class);
	}
	
}