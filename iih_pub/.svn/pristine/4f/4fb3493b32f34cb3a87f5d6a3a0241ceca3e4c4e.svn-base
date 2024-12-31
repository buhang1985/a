package iih.bd.pp.modifypriplan.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.pp.modifypriplan.d.desc.ModifyPriPlanItmDODesc;
import java.math.BigDecimal;

/**
 * 调价计划明细 DO数据 
 * 
 */
public class ModifyPriPlanItmDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//调价计划明细表主键
	public static final String ID_MODIFYPRISRVPLANITM= "Id_modifyprisrvplanitm";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//调价计划
	public static final String ID_MODIFYPRIPLAN= "Id_modifypriplan";
	//服务项目
	public static final String ID_SRV= "Id_srv";
	//调价价格
	public static final String PRICE= "Price";
	//调价成功标志
	public static final String FG_MODIFYSUCC= "Fg_modifysucc";
	//医保限价
	public static final String PRI_MAX= "Pri_max";
	//调价前金额
	public static final String PRICE_OLD= "Price_old";
	//当前价格
	public static final String NOW_PRICE= "Now_price";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//服务编码
	public static final String SRV_CODE= "Srv_code";
	//服务名称
	public static final String SRV_NAME= "Srv_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 调价计划明细表主键
	 * @return String
	 */
	public String getId_modifyprisrvplanitm() {
		return ((String) getAttrVal("Id_modifyprisrvplanitm"));
	}	
	/**
	 * 调价计划明细表主键
	 * @param Id_modifyprisrvplanitm
	 */
	public void setId_modifyprisrvplanitm(String Id_modifyprisrvplanitm) {
		setAttrVal("Id_modifyprisrvplanitm", Id_modifyprisrvplanitm);
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
	 * 调价计划
	 * @return String
	 */
	public String getId_modifypriplan() {
		return ((String) getAttrVal("Id_modifypriplan"));
	}	
	/**
	 * 调价计划
	 * @param Id_modifypriplan
	 */
	public void setId_modifypriplan(String Id_modifypriplan) {
		setAttrVal("Id_modifypriplan", Id_modifypriplan);
	}
	/**
	 * 服务项目
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	/**
	 * 服务项目
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 调价价格
	 * @return FDouble
	 */
	public FDouble getPrice() {
		return ((FDouble) getAttrVal("Price"));
	}	
	/**
	 * 调价价格
	 * @param Price
	 */
	public void setPrice(FDouble Price) {
		setAttrVal("Price", Price);
	}
	/**
	 * 调价成功标志
	 * @return FBoolean
	 */
	public FBoolean getFg_modifysucc() {
		return ((FBoolean) getAttrVal("Fg_modifysucc"));
	}	
	/**
	 * 调价成功标志
	 * @param Fg_modifysucc
	 */
	public void setFg_modifysucc(FBoolean Fg_modifysucc) {
		setAttrVal("Fg_modifysucc", Fg_modifysucc);
	}
	/**
	 * 医保限价
	 * @return FDouble
	 */
	public FDouble getPri_max() {
		return ((FDouble) getAttrVal("Pri_max"));
	}	
	/**
	 * 医保限价
	 * @param Pri_max
	 */
	public void setPri_max(FDouble Pri_max) {
		setAttrVal("Pri_max", Pri_max);
	}
	/**
	 * 调价前金额
	 * @return FDouble
	 */
	public FDouble getPrice_old() {
		return ((FDouble) getAttrVal("Price_old"));
	}	
	/**
	 * 调价前金额
	 * @param Price_old
	 */
	public void setPrice_old(FDouble Price_old) {
		setAttrVal("Price_old", Price_old);
	}
	/**
	 * 当前价格
	 * @return FDouble
	 */
	public FDouble getNow_price() {
		return ((FDouble) getAttrVal("Now_price"));
	}	
	/**
	 * 当前价格
	 * @param Now_price
	 */
	public void setNow_price(FDouble Now_price) {
		setAttrVal("Now_price", Now_price);
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
	 * 服务编码
	 * @return String
	 */
	public String getSrv_code() {
		return ((String) getAttrVal("Srv_code"));
	}	
	/**
	 * 服务编码
	 * @param Srv_code
	 */
	public void setSrv_code(String Srv_code) {
		setAttrVal("Srv_code", Srv_code);
	}
	/**
	 * 服务名称
	 * @return String
	 */
	public String getSrv_name() {
		return ((String) getAttrVal("Srv_name"));
	}	
	/**
	 * 服务名称
	 * @param Srv_name
	 */
	public void setSrv_name(String Srv_name) {
		setAttrVal("Srv_name", Srv_name);
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
		return "Id_modifyprisrvplanitm";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_modify_pri_plan_itm";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ModifyPriPlanItmDODesc.class);
	}
	
}