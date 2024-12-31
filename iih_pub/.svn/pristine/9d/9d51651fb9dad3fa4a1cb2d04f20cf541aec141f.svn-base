package iih.pe.por.pecorpcharge.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.por.pecorpcharge.d.desc.PeCorpChargeItmDODesc;
import java.math.BigDecimal;

/**
 * 体检团体费用结账单明细 DO数据 
 * 
 */
public class PeCorpChargeItmDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检团体结账明细主键标识
	public static final String ID_PECORPCHARGEITM= "Id_pecorpchargeitm";
	//体检团体结账ID
	public static final String ID_PECORPCHARGE= "Id_pecorpcharge";
	//体检项目ID
	public static final String ID_PESRVBCATLOG= "Id_pesrvbcatlog";
	//医嘱项目ID
	public static final String ID_SRV_OR= "Id_srv_or";
	//医嘱项目编码
	public static final String SD_SRV_OR= "Sd_srv_or";
	//收费项目ID
	public static final String ID_SRV= "Id_srv";
	//收费项目编码
	public static final String SD_SRV= "Sd_srv";
	//单项折扣
	public static final String DIS_ITM= "Dis_itm";
	//单项价格
	public static final String PRI_ITM= "Pri_itm";
	//实收价格
	public static final String PRI_CHARGE= "Pri_charge";
	//实收人数
	public static final String NUM_CHARGE= "Num_charge";
	//应收金额
	public static final String AMT_CHARGE= "Amt_charge";
	//折后金额
	public static final String DIS_CHARGE= "Dis_charge";
	//体检费倍数
	public static final String BASEPRITIMES= "Basepritimes";
	//编码
	public static final String CODE_CATLOG= "Code_catlog";
	//名称
	public static final String NAME_CATLOG= "Name_catlog";
	//基础价格
	public static final String PRICE_CATLOG= "Price_catlog";
	//服务编码
	public static final String CODE_SRV_OR= "Code_srv_or";
	//服务名称
	public static final String NAME_SRV_OR= "Name_srv_or";
	//服务编码
	public static final String CODE_SRV= "Code_srv";
	//服务名称
	public static final String NAME_SRV= "Name_srv";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检团体结账明细主键标识
	 * @return String
	 */
	public String getId_pecorpchargeitm() {
		return ((String) getAttrVal("Id_pecorpchargeitm"));
	}	
	/**
	 * 体检团体结账明细主键标识
	 * @param Id_pecorpchargeitm
	 */
	public void setId_pecorpchargeitm(String Id_pecorpchargeitm) {
		setAttrVal("Id_pecorpchargeitm", Id_pecorpchargeitm);
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
	 * 医嘱项目ID
	 * @return String
	 */
	public String getId_srv_or() {
		return ((String) getAttrVal("Id_srv_or"));
	}	
	/**
	 * 医嘱项目ID
	 * @param Id_srv_or
	 */
	public void setId_srv_or(String Id_srv_or) {
		setAttrVal("Id_srv_or", Id_srv_or);
	}
	/**
	 * 医嘱项目编码
	 * @return String
	 */
	public String getSd_srv_or() {
		return ((String) getAttrVal("Sd_srv_or"));
	}	
	/**
	 * 医嘱项目编码
	 * @param Sd_srv_or
	 */
	public void setSd_srv_or(String Sd_srv_or) {
		setAttrVal("Sd_srv_or", Sd_srv_or);
	}
	/**
	 * 收费项目ID
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	/**
	 * 收费项目ID
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
	 * 单项折扣
	 * @return FDouble
	 */
	public FDouble getDis_itm() {
		return ((FDouble) getAttrVal("Dis_itm"));
	}	
	/**
	 * 单项折扣
	 * @param Dis_itm
	 */
	public void setDis_itm(FDouble Dis_itm) {
		setAttrVal("Dis_itm", Dis_itm);
	}
	/**
	 * 单项价格
	 * @return FDouble
	 */
	public FDouble getPri_itm() {
		return ((FDouble) getAttrVal("Pri_itm"));
	}	
	/**
	 * 单项价格
	 * @param Pri_itm
	 */
	public void setPri_itm(FDouble Pri_itm) {
		setAttrVal("Pri_itm", Pri_itm);
	}
	/**
	 * 实收价格
	 * @return FDouble
	 */
	public FDouble getPri_charge() {
		return ((FDouble) getAttrVal("Pri_charge"));
	}	
	/**
	 * 实收价格
	 * @param Pri_charge
	 */
	public void setPri_charge(FDouble Pri_charge) {
		setAttrVal("Pri_charge", Pri_charge);
	}
	/**
	 * 实收人数
	 * @return Integer
	 */
	public Integer getNum_charge() {
		return ((Integer) getAttrVal("Num_charge"));
	}	
	/**
	 * 实收人数
	 * @param Num_charge
	 */
	public void setNum_charge(Integer Num_charge) {
		setAttrVal("Num_charge", Num_charge);
	}
	/**
	 * 应收金额
	 * @return FDouble
	 */
	public FDouble getAmt_charge() {
		return ((FDouble) getAttrVal("Amt_charge"));
	}	
	/**
	 * 应收金额
	 * @param Amt_charge
	 */
	public void setAmt_charge(FDouble Amt_charge) {
		setAttrVal("Amt_charge", Amt_charge);
	}
	/**
	 * 折后金额
	 * @return FDouble
	 */
	public FDouble getDis_charge() {
		return ((FDouble) getAttrVal("Dis_charge"));
	}	
	/**
	 * 折后金额
	 * @param Dis_charge
	 */
	public void setDis_charge(FDouble Dis_charge) {
		setAttrVal("Dis_charge", Dis_charge);
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
	 * 编码
	 * @return String
	 */
	public String getCode_catlog() {
		return ((String) getAttrVal("Code_catlog"));
	}	
	/**
	 * 编码
	 * @param Code_catlog
	 */
	public void setCode_catlog(String Code_catlog) {
		setAttrVal("Code_catlog", Code_catlog);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_catlog() {
		return ((String) getAttrVal("Name_catlog"));
	}	
	/**
	 * 名称
	 * @param Name_catlog
	 */
	public void setName_catlog(String Name_catlog) {
		setAttrVal("Name_catlog", Name_catlog);
	}
	/**
	 * 基础价格
	 * @return FDouble
	 */
	public FDouble getPrice_catlog() {
		return ((FDouble) getAttrVal("Price_catlog"));
	}	
	/**
	 * 基础价格
	 * @param Price_catlog
	 */
	public void setPrice_catlog(FDouble Price_catlog) {
		setAttrVal("Price_catlog", Price_catlog);
	}
	/**
	 * 服务编码
	 * @return String
	 */
	public String getCode_srv_or() {
		return ((String) getAttrVal("Code_srv_or"));
	}	
	/**
	 * 服务编码
	 * @param Code_srv_or
	 */
	public void setCode_srv_or(String Code_srv_or) {
		setAttrVal("Code_srv_or", Code_srv_or);
	}
	/**
	 * 服务名称
	 * @return String
	 */
	public String getName_srv_or() {
		return ((String) getAttrVal("Name_srv_or"));
	}	
	/**
	 * 服务名称
	 * @param Name_srv_or
	 */
	public void setName_srv_or(String Name_srv_or) {
		setAttrVal("Name_srv_or", Name_srv_or);
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
		return "Id_pecorpchargeitm";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_or_pecorpchargeitm";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeCorpChargeItmDODesc.class);
	}
	
}