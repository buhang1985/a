package iih.mm.bl.stockbl.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mm.bl.stockbl.d.desc.StockBlDODesc;
import java.math.BigDecimal;

/**
 * 结存 DO数据 
 * 
 */
public class StockBlDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//结存主键
	public static final String ID_BL= "Id_bl";
	//集团
	public static final String ID_GRP= "Id_grp";
	//机构
	public static final String ID_ORG= "Id_org";
	//库存地点
	public static final String ID_WH= "Id_wh";
	//物品
	public static final String ID_MM= "Id_mm";
	//唯一码
	public static final String ONLYCODE= "Onlycode";
	//批次
	public static final String BATCH= "Batch";
	//失效期
	public static final String DATE_EXPI= "Date_expi";
	//进价_基本单位
	public static final String PRI_ACT= "Pri_act";
	//零售价
	public static final String PRI_SA= "Pri_sa";
	//基本包装单位
	public static final String ID_UNIT_PKGBASE= "Id_unit_pkgbase";
	//现存量_基本单位
	public static final String QUAN_STOCK= "Quan_stock";
	//预留数量_基本单位
	public static final String QUAN_RESERVE= "Quan_reserve";
	//可用数量_基本单位
	public static final String QUAN_USABLE= "Quan_usable";
	//成本金额
	public static final String AMT_COST= "Amt_cost";
	//停用标识
	public static final String FG_STOP= "Fg_stop";
	//过期标识
	public static final String FG_EXPIRED= "Fg_expired";
	//调价停用标识
	public static final String FG_STOP_CHGPRI= "Fg_stop_chgpri";
	//关闭标识
	public static final String FG_CLOSE= "Fg_close";
	//数据改变标识
	public static final String FG_CHANGED= "Fg_changed";
	//最后使用时间
	public static final String DT_LASTUPDATE= "Dt_lastupdate";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//更新库存数量
	public static final String REQ_NUM= "Req_num";
	//更新预留数量
	public static final String REQ_RESERVE_NUM= "Req_reserve_num";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 结存主键
	 * @return String
	 */
	public String getId_bl() {
		return ((String) getAttrVal("Id_bl"));
	}	
	/**
	 * 结存主键
	 * @param Id_bl
	 */
	public void setId_bl(String Id_bl) {
		setAttrVal("Id_bl", Id_bl);
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
	 * 机构
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	/**
	 * 机构
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 库存地点
	 * @return String
	 */
	public String getId_wh() {
		return ((String) getAttrVal("Id_wh"));
	}	
	/**
	 * 库存地点
	 * @param Id_wh
	 */
	public void setId_wh(String Id_wh) {
		setAttrVal("Id_wh", Id_wh);
	}
	/**
	 * 物品
	 * @return String
	 */
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}	
	/**
	 * 物品
	 * @param Id_mm
	 */
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}
	/**
	 * 唯一码
	 * @return String
	 */
	public String getOnlycode() {
		return ((String) getAttrVal("Onlycode"));
	}	
	/**
	 * 唯一码
	 * @param Onlycode
	 */
	public void setOnlycode(String Onlycode) {
		setAttrVal("Onlycode", Onlycode);
	}
	/**
	 * 批次
	 * @return String
	 */
	public String getBatch() {
		return ((String) getAttrVal("Batch"));
	}	
	/**
	 * 批次
	 * @param Batch
	 */
	public void setBatch(String Batch) {
		setAttrVal("Batch", Batch);
	}
	/**
	 * 失效期
	 * @return FDate
	 */
	public FDate getDate_expi() {
		return ((FDate) getAttrVal("Date_expi"));
	}	
	/**
	 * 失效期
	 * @param Date_expi
	 */
	public void setDate_expi(FDate Date_expi) {
		setAttrVal("Date_expi", Date_expi);
	}
	/**
	 * 进价_基本单位
	 * @return FDouble
	 */
	public FDouble getPri_act() {
		return ((FDouble) getAttrVal("Pri_act"));
	}	
	/**
	 * 进价_基本单位
	 * @param Pri_act
	 */
	public void setPri_act(FDouble Pri_act) {
		setAttrVal("Pri_act", Pri_act);
	}
	/**
	 * 零售价
	 * @return FDouble
	 */
	public FDouble getPri_sa() {
		return ((FDouble) getAttrVal("Pri_sa"));
	}	
	/**
	 * 零售价
	 * @param Pri_sa
	 */
	public void setPri_sa(FDouble Pri_sa) {
		setAttrVal("Pri_sa", Pri_sa);
	}
	/**
	 * 基本包装单位
	 * @return String
	 */
	public String getId_unit_pkgbase() {
		return ((String) getAttrVal("Id_unit_pkgbase"));
	}	
	/**
	 * 基本包装单位
	 * @param Id_unit_pkgbase
	 */
	public void setId_unit_pkgbase(String Id_unit_pkgbase) {
		setAttrVal("Id_unit_pkgbase", Id_unit_pkgbase);
	}
	/**
	 * 现存量_基本单位
	 * @return FDouble
	 */
	public FDouble getQuan_stock() {
		return ((FDouble) getAttrVal("Quan_stock"));
	}	
	/**
	 * 现存量_基本单位
	 * @param Quan_stock
	 */
	public void setQuan_stock(FDouble Quan_stock) {
		setAttrVal("Quan_stock", Quan_stock);
	}
	/**
	 * 预留数量_基本单位
	 * @return FDouble
	 */
	public FDouble getQuan_reserve() {
		return ((FDouble) getAttrVal("Quan_reserve"));
	}	
	/**
	 * 预留数量_基本单位
	 * @param Quan_reserve
	 */
	public void setQuan_reserve(FDouble Quan_reserve) {
		setAttrVal("Quan_reserve", Quan_reserve);
	}
	/**
	 * 可用数量_基本单位
	 * @return FDouble
	 */
	public FDouble getQuan_usable() {
		return ((FDouble) getAttrVal("Quan_usable"));
	}	
	/**
	 * 可用数量_基本单位
	 * @param Quan_usable
	 */
	public void setQuan_usable(FDouble Quan_usable) {
		setAttrVal("Quan_usable", Quan_usable);
	}
	/**
	 * 成本金额
	 * @return FDouble
	 */
	public FDouble getAmt_cost() {
		return ((FDouble) getAttrVal("Amt_cost"));
	}	
	/**
	 * 成本金额
	 * @param Amt_cost
	 */
	public void setAmt_cost(FDouble Amt_cost) {
		setAttrVal("Amt_cost", Amt_cost);
	}
	/**
	 * 停用标识
	 * @return FBoolean
	 */
	public FBoolean getFg_stop() {
		return ((FBoolean) getAttrVal("Fg_stop"));
	}	
	/**
	 * 停用标识
	 * @param Fg_stop
	 */
	public void setFg_stop(FBoolean Fg_stop) {
		setAttrVal("Fg_stop", Fg_stop);
	}
	/**
	 * 过期标识
	 * @return FBoolean
	 */
	public FBoolean getFg_expired() {
		return ((FBoolean) getAttrVal("Fg_expired"));
	}	
	/**
	 * 过期标识
	 * @param Fg_expired
	 */
	public void setFg_expired(FBoolean Fg_expired) {
		setAttrVal("Fg_expired", Fg_expired);
	}
	/**
	 * 调价停用标识
	 * @return FBoolean
	 */
	public FBoolean getFg_stop_chgpri() {
		return ((FBoolean) getAttrVal("Fg_stop_chgpri"));
	}	
	/**
	 * 调价停用标识
	 * @param Fg_stop_chgpri
	 */
	public void setFg_stop_chgpri(FBoolean Fg_stop_chgpri) {
		setAttrVal("Fg_stop_chgpri", Fg_stop_chgpri);
	}
	/**
	 * 关闭标识
	 * @return FBoolean
	 */
	public FBoolean getFg_close() {
		return ((FBoolean) getAttrVal("Fg_close"));
	}	
	/**
	 * 关闭标识
	 * @param Fg_close
	 */
	public void setFg_close(FBoolean Fg_close) {
		setAttrVal("Fg_close", Fg_close);
	}
	/**
	 * 数据改变标识
	 * @return FBoolean
	 */
	public FBoolean getFg_changed() {
		return ((FBoolean) getAttrVal("Fg_changed"));
	}	
	/**
	 * 数据改变标识
	 * @param Fg_changed
	 */
	public void setFg_changed(FBoolean Fg_changed) {
		setAttrVal("Fg_changed", Fg_changed);
	}
	/**
	 * 最后使用时间
	 * @return FDateTime
	 */
	public FDateTime getDt_lastupdate() {
		return ((FDateTime) getAttrVal("Dt_lastupdate"));
	}	
	/**
	 * 最后使用时间
	 * @param Dt_lastupdate
	 */
	public void setDt_lastupdate(FDateTime Dt_lastupdate) {
		setAttrVal("Dt_lastupdate", Dt_lastupdate);
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
	 * 更新库存数量
	 * @return FDouble
	 */
	public FDouble getReq_num() {
		return ((FDouble) getAttrVal("Req_num"));
	}	
	/**
	 * 更新库存数量
	 * @param Req_num
	 */
	public void setReq_num(FDouble Req_num) {
		setAttrVal("Req_num", Req_num);
	}
	/**
	 * 更新预留数量
	 * @return FDouble
	 */
	public FDouble getReq_reserve_num() {
		return ((FDouble) getAttrVal("Req_reserve_num"));
	}	
	/**
	 * 更新预留数量
	 * @param Req_reserve_num
	 */
	public void setReq_reserve_num(FDouble Req_reserve_num) {
		setAttrVal("Req_reserve_num", Req_reserve_num);
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
		return "Id_bl";
	}
	
	@Override
	public String getTableName() {	  
		return "MM_BL";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(StockBlDODesc.class);
	}
	
}