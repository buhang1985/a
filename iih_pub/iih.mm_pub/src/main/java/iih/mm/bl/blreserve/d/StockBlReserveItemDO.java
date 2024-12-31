package iih.mm.bl.blreserve.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mm.bl.blreserve.d.desc.StockBlReserveItemDODesc;
import java.math.BigDecimal;

/**
 * 物品结存预留处理明细表 DO数据 
 * 
 */
public class StockBlReserveItemDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//预留明细主键
	public static final String ID_RSVITM= "Id_rsvitm";
	//预留主键
	public static final String ID_RSV= "Id_rsv";
	//结存主键
	public static final String ID_BL= "Id_bl";
	//售价_零售包装
	public static final String PRI_SALE= "Pri_sale";
	//预留_基本包装
	public static final String QUAN_RESERVE= "Quan_reserve";
	//实发_基本包装
	public static final String QUAN_STOCK= "Quan_stock";
	//退发数量_基本包装
	public static final String QUAN_BK= "Quan_bk";
	//请求数量
	public static final String REQ_NUM= "Req_num";
	//减免标识
	public static final String FG_FREE= "Fg_free";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 预留明细主键
	 * @return String
	 */
	public String getId_rsvitm() {
		return ((String) getAttrVal("Id_rsvitm"));
	}	
	/**
	 * 预留明细主键
	 * @param Id_rsvitm
	 */
	public void setId_rsvitm(String Id_rsvitm) {
		setAttrVal("Id_rsvitm", Id_rsvitm);
	}
	/**
	 * 预留主键
	 * @return String
	 */
	public String getId_rsv() {
		return ((String) getAttrVal("Id_rsv"));
	}	
	/**
	 * 预留主键
	 * @param Id_rsv
	 */
	public void setId_rsv(String Id_rsv) {
		setAttrVal("Id_rsv", Id_rsv);
	}
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
	 * 售价_零售包装
	 * @return FDouble
	 */
	public FDouble getPri_sale() {
		return ((FDouble) getAttrVal("Pri_sale"));
	}	
	/**
	 * 售价_零售包装
	 * @param Pri_sale
	 */
	public void setPri_sale(FDouble Pri_sale) {
		setAttrVal("Pri_sale", Pri_sale);
	}
	/**
	 * 预留_基本包装
	 * @return FDouble
	 */
	public FDouble getQuan_reserve() {
		return ((FDouble) getAttrVal("Quan_reserve"));
	}	
	/**
	 * 预留_基本包装
	 * @param Quan_reserve
	 */
	public void setQuan_reserve(FDouble Quan_reserve) {
		setAttrVal("Quan_reserve", Quan_reserve);
	}
	/**
	 * 实发_基本包装
	 * @return FDouble
	 */
	public FDouble getQuan_stock() {
		return ((FDouble) getAttrVal("Quan_stock"));
	}	
	/**
	 * 实发_基本包装
	 * @param Quan_stock
	 */
	public void setQuan_stock(FDouble Quan_stock) {
		setAttrVal("Quan_stock", Quan_stock);
	}
	/**
	 * 退发数量_基本包装
	 * @return FDouble
	 */
	public FDouble getQuan_bk() {
		return ((FDouble) getAttrVal("Quan_bk"));
	}	
	/**
	 * 退发数量_基本包装
	 * @param Quan_bk
	 */
	public void setQuan_bk(FDouble Quan_bk) {
		setAttrVal("Quan_bk", Quan_bk);
	}
	/**
	 * 请求数量
	 * @return FDouble
	 */
	public FDouble getReq_num() {
		return ((FDouble) getAttrVal("Req_num"));
	}	
	/**
	 * 请求数量
	 * @param Req_num
	 */
	public void setReq_num(FDouble Req_num) {
		setAttrVal("Req_num", Req_num);
	}
	/**
	 * 减免标识
	 * @return FBoolean
	 */
	public FBoolean getFg_free() {
		return ((FBoolean) getAttrVal("Fg_free"));
	}	
	/**
	 * 减免标识
	 * @param Fg_free
	 */
	public void setFg_free(FBoolean Fg_free) {
		setAttrVal("Fg_free", Fg_free);
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
		return "Id_rsvitm";
	}
	
	@Override
	public String getTableName() {	  
		return "mm_bl_reserve_itm";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(StockBlReserveItemDODesc.class);
	}
	
}