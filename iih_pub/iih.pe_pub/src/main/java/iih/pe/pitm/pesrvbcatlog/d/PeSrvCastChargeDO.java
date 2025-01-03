package iih.pe.pitm.pesrvbcatlog.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pitm.pesrvbcatlog.d.desc.PeSrvCastChargeDODesc;
import java.math.BigDecimal;

/**
 * 体检门诊费用对应 DO数据 
 * 
 */
public class PeSrvCastChargeDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检费用对应主键标识
	public static final String ID_PESRVCASTCHARGE= "Id_pesrvcastcharge";
	//体检项目ID
	public static final String ID_PESRVBCATLOG= "Id_pesrvbcatlog";
	//费用编码
	public static final String SD_SRV= "Sd_srv";
	//费用ID
	public static final String ID_SRV= "Id_srv";
	//数量
	public static final String QTY= "Qty";
	//执行科室
	public static final String EXEC_UNIT_CHARGE= "Exec_unit_charge";
	//体检定价
	public static final String PRICE_PE= "Price_pe";
	//服务编码
	public static final String CODE_CHARGE= "Code_charge";
	//服务名称
	public static final String NAME_CHARGE= "Name_charge";
	//参考价格
	public static final String PRI= "Pri";
	//编码
	public static final String CODE_EXEC_CHARGE= "Code_exec_charge";
	//名称
	public static final String NAME_EXEC_CHARGE= "Name_exec_charge";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检费用对应主键标识
	 * @return String
	 */
	public String getId_pesrvcastcharge() {
		return ((String) getAttrVal("Id_pesrvcastcharge"));
	}	
	/**
	 * 体检费用对应主键标识
	 * @param Id_pesrvcastcharge
	 */
	public void setId_pesrvcastcharge(String Id_pesrvcastcharge) {
		setAttrVal("Id_pesrvcastcharge", Id_pesrvcastcharge);
	}
	/**
	 * 体检项目ID
	 * @return String
	 */
	public String getId_pesrvbcatlog() {
		return ((String) getAttrVal("Id_pesrvbcatlog"));
	}	
	/**
	 * 体检项目ID
	 * @param Id_pesrvbcatlog
	 */
	public void setId_pesrvbcatlog(String Id_pesrvbcatlog) {
		setAttrVal("Id_pesrvbcatlog", Id_pesrvbcatlog);
	}
	/**
	 * 费用编码
	 * @return String
	 */
	public String getSd_srv() {
		return ((String) getAttrVal("Sd_srv"));
	}	
	/**
	 * 费用编码
	 * @param Sd_srv
	 */
	public void setSd_srv(String Sd_srv) {
		setAttrVal("Sd_srv", Sd_srv);
	}
	/**
	 * 费用ID
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	/**
	 * 费用ID
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 数量
	 * @return FDouble
	 */
	public FDouble getQty() {
		return ((FDouble) getAttrVal("Qty"));
	}	
	/**
	 * 数量
	 * @param Qty
	 */
	public void setQty(FDouble Qty) {
		setAttrVal("Qty", Qty);
	}
	/**
	 * 执行科室
	 * @return String
	 */
	public String getExec_unit_charge() {
		return ((String) getAttrVal("Exec_unit_charge"));
	}	
	/**
	 * 执行科室
	 * @param Exec_unit_charge
	 */
	public void setExec_unit_charge(String Exec_unit_charge) {
		setAttrVal("Exec_unit_charge", Exec_unit_charge);
	}
	/**
	 * 体检定价
	 * @return FDouble
	 */
	public FDouble getPrice_pe() {
		return ((FDouble) getAttrVal("Price_pe"));
	}	
	/**
	 * 体检定价
	 * @param Price_pe
	 */
	public void setPrice_pe(FDouble Price_pe) {
		setAttrVal("Price_pe", Price_pe);
	}
	/**
	 * 服务编码
	 * @return String
	 */
	public String getCode_charge() {
		return ((String) getAttrVal("Code_charge"));
	}	
	/**
	 * 服务编码
	 * @param Code_charge
	 */
	public void setCode_charge(String Code_charge) {
		setAttrVal("Code_charge", Code_charge);
	}
	/**
	 * 服务名称
	 * @return String
	 */
	public String getName_charge() {
		return ((String) getAttrVal("Name_charge"));
	}	
	/**
	 * 服务名称
	 * @param Name_charge
	 */
	public void setName_charge(String Name_charge) {
		setAttrVal("Name_charge", Name_charge);
	}
	/**
	 * 参考价格
	 * @return FDouble
	 */
	public FDouble getPri() {
		return ((FDouble) getAttrVal("Pri"));
	}	
	/**
	 * 参考价格
	 * @param Pri
	 */
	public void setPri(FDouble Pri) {
		setAttrVal("Pri", Pri);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_exec_charge() {
		return ((String) getAttrVal("Code_exec_charge"));
	}	
	/**
	 * 编码
	 * @param Code_exec_charge
	 */
	public void setCode_exec_charge(String Code_exec_charge) {
		setAttrVal("Code_exec_charge", Code_exec_charge);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_exec_charge() {
		return ((String) getAttrVal("Name_exec_charge"));
	}	
	/**
	 * 名称
	 * @param Name_exec_charge
	 */
	public void setName_exec_charge(String Name_exec_charge) {
		setAttrVal("Name_exec_charge", Name_exec_charge);
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
		return "Id_pesrvcastcharge";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_itm_pesrvcastcharge";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeSrvCastChargeDODesc.class);
	}
	
}