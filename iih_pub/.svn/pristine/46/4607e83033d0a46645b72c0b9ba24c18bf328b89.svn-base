package iih.bd.pp.hpdupitmpri.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.pp.hpdupitmpri.d.desc.HpDupItmPriDODesc;
import java.math.BigDecimal;

/**
 * 医保计划重复收费项目 DO数据 
 * 
 */
public class HpDupItmPriDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//医保计划重复收费项目主键
	public static final String ID_HPDUPITMPRI= "Id_hpdupitmpri";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//医保计划
	public static final String ID_HP= "Id_hp";
	//服务项目
	public static final String ID_SRV= "Id_srv";
	//定价价格
	public static final String PRICE= "Price";
	//价格系数
	public static final String PRICECOEFFICIENT= "Pricecoefficient";
	//开始时间
	public static final String STARTTIME= "Starttime";
	//结束时间
	public static final String ENDTIME= "Endtime";
	//适用门诊
	public static final String FG_OP= "Fg_op";
	//适用住院
	public static final String FG_IP= "Fg_ip";
	//急诊流水标志
	public static final String FG_ER= "Fg_er";
	//急诊抢救标志
	public static final String FG_USE_ER1= "Fg_use_er1";
	//急诊留观标志
	public static final String FG_USE_ER2= "Fg_use_er2";
	//适用体检
	public static final String FG_PE= "Fg_pe";
	//适用家庭
	public static final String FG_FM= "Fg_fm";
	//备注
	public static final String DES= "Des";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//可使用标识_预住院
	public static final String FG_USE_PIP= "Fg_use_pip";
	//医保计划名称
	public static final String HP_NAME= "Hp_name";
	//服务名称
	public static final String SRV_NAME= "Srv_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 医保计划重复收费项目主键
	 * @return String
	 */
	public String getId_hpdupitmpri() {
		return ((String) getAttrVal("Id_hpdupitmpri"));
	}	
	/**
	 * 医保计划重复收费项目主键
	 * @param Id_hpdupitmpri
	 */
	public void setId_hpdupitmpri(String Id_hpdupitmpri) {
		setAttrVal("Id_hpdupitmpri", Id_hpdupitmpri);
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
	 * 定价价格
	 * @return FDouble
	 */
	public FDouble getPrice() {
		return ((FDouble) getAttrVal("Price"));
	}	
	/**
	 * 定价价格
	 * @param Price
	 */
	public void setPrice(FDouble Price) {
		setAttrVal("Price", Price);
	}
	/**
	 * 价格系数
	 * @return FDouble
	 */
	public FDouble getPricecoefficient() {
		return ((FDouble) getAttrVal("Pricecoefficient"));
	}	
	/**
	 * 价格系数
	 * @param Pricecoefficient
	 */
	public void setPricecoefficient(FDouble Pricecoefficient) {
		setAttrVal("Pricecoefficient", Pricecoefficient);
	}
	/**
	 * 开始时间
	 * @return FDateTime
	 */
	public FDateTime getStarttime() {
		return ((FDateTime) getAttrVal("Starttime"));
	}	
	/**
	 * 开始时间
	 * @param Starttime
	 */
	public void setStarttime(FDateTime Starttime) {
		setAttrVal("Starttime", Starttime);
	}
	/**
	 * 结束时间
	 * @return FDateTime
	 */
	public FDateTime getEndtime() {
		return ((FDateTime) getAttrVal("Endtime"));
	}	
	/**
	 * 结束时间
	 * @param Endtime
	 */
	public void setEndtime(FDateTime Endtime) {
		setAttrVal("Endtime", Endtime);
	}
	/**
	 * 适用门诊
	 * @return FBoolean
	 */
	public FBoolean getFg_op() {
		return ((FBoolean) getAttrVal("Fg_op"));
	}	
	/**
	 * 适用门诊
	 * @param Fg_op
	 */
	public void setFg_op(FBoolean Fg_op) {
		setAttrVal("Fg_op", Fg_op);
	}
	/**
	 * 适用住院
	 * @return FBoolean
	 */
	public FBoolean getFg_ip() {
		return ((FBoolean) getAttrVal("Fg_ip"));
	}	
	/**
	 * 适用住院
	 * @param Fg_ip
	 */
	public void setFg_ip(FBoolean Fg_ip) {
		setAttrVal("Fg_ip", Fg_ip);
	}
	/**
	 * 急诊流水标志
	 * @return FBoolean
	 */
	public FBoolean getFg_er() {
		return ((FBoolean) getAttrVal("Fg_er"));
	}	
	/**
	 * 急诊流水标志
	 * @param Fg_er
	 */
	public void setFg_er(FBoolean Fg_er) {
		setAttrVal("Fg_er", Fg_er);
	}
	/**
	 * 急诊抢救标志
	 * @return FBoolean
	 */
	public FBoolean getFg_use_er1() {
		return ((FBoolean) getAttrVal("Fg_use_er1"));
	}	
	/**
	 * 急诊抢救标志
	 * @param Fg_use_er1
	 */
	public void setFg_use_er1(FBoolean Fg_use_er1) {
		setAttrVal("Fg_use_er1", Fg_use_er1);
	}
	/**
	 * 急诊留观标志
	 * @return FBoolean
	 */
	public FBoolean getFg_use_er2() {
		return ((FBoolean) getAttrVal("Fg_use_er2"));
	}	
	/**
	 * 急诊留观标志
	 * @param Fg_use_er2
	 */
	public void setFg_use_er2(FBoolean Fg_use_er2) {
		setAttrVal("Fg_use_er2", Fg_use_er2);
	}
	/**
	 * 适用体检
	 * @return FBoolean
	 */
	public FBoolean getFg_pe() {
		return ((FBoolean) getAttrVal("Fg_pe"));
	}	
	/**
	 * 适用体检
	 * @param Fg_pe
	 */
	public void setFg_pe(FBoolean Fg_pe) {
		setAttrVal("Fg_pe", Fg_pe);
	}
	/**
	 * 适用家庭
	 * @return FBoolean
	 */
	public FBoolean getFg_fm() {
		return ((FBoolean) getAttrVal("Fg_fm"));
	}	
	/**
	 * 适用家庭
	 * @param Fg_fm
	 */
	public void setFg_fm(FBoolean Fg_fm) {
		setAttrVal("Fg_fm", Fg_fm);
	}
	/**
	 * 备注
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	/**
	 * 备注
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
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
	 * 可使用标识_预住院
	 * @return FBoolean
	 */
	public FBoolean getFg_use_pip() {
		return ((FBoolean) getAttrVal("Fg_use_pip"));
	}	
	/**
	 * 可使用标识_预住院
	 * @param Fg_use_pip
	 */
	public void setFg_use_pip(FBoolean Fg_use_pip) {
		setAttrVal("Fg_use_pip", Fg_use_pip);
	}
	/**
	 * 医保计划名称
	 * @return String
	 */
	public String getHp_name() {
		return ((String) getAttrVal("Hp_name"));
	}	
	/**
	 * 医保计划名称
	 * @param Hp_name
	 */
	public void setHp_name(String Hp_name) {
		setAttrVal("Hp_name", Hp_name);
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
		return "Id_hpdupitmpri";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_hp_dup_itm_pri";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(HpDupItmPriDODesc.class);
	}
	
}