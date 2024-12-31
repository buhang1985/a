
package iih.pmp.pay.channelbillitem.d.desc;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import xap.sys.appfw.orm.desc.db.ColumnDesc;
import xap.sys.appfw.orm.desc.db.DsColumn;
import xap.sys.appfw.orm.desc.db.SvColumn;
import xap.sys.appfw.orm.desc.db.TableDesc;
import xap.sys.appfw.orm.desc.ent.dataobject.Attr;
import xap.sys.appfw.orm.desc.ent.dataobject.DODesc;
import xap.sys.appfw.orm.desc.ent.dataobject.DsAttr;
import xap.sys.appfw.orm.desc.ent.dataobject.SvAttr;
import xap.mw.coreitf.i.IAttrDesc;
import xap.mw.coreitf.i.IColumnDesc;
import xap.mw.coreitf.i.ITableDesc;
import xap.mw.coreitf.d.FType;
import java.math.BigDecimal;

/**
 * 渠道账单明细 DO 元数据信息
 */
public class ChlBillItemDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.pmp.pay.channelbillitem.d.ChlBillItemDO";
	public static final String CLASS_DISPALYNAME = "渠道账单明细";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "pmp_chlbillitem";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_channel_bill_item";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public ChlBillItemDODesc(){
		init();
	}
	
	/**
	 * 数据初始化
	 */
	private void init(){		
		this.setResID(CLASS_RESID);
		this.setResNode(CLASS_RESMODULE);
		this.setLabel(CLASS_DISPALYNAME);
		this.setEntityName(CLASS_FULLNAME);
		ITableDesc tblDesc=getTableDesc();
		this.setKeyDesc(getId_channel_bill_itemADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_channel_bill_itemADesc(tblDesc));
		this.add(getId_channel_billADesc(tblDesc));
		this.add(getTradetimeADesc(tblDesc));
		this.add(getAppidADesc(tblDesc));
		this.add(getMchidADesc(tblDesc));
		this.add(getCmchidADesc(tblDesc));
		this.add(getDevicenoADesc(tblDesc));
		this.add(getChanneltradenoADesc(tblDesc));
		this.add(getMch_trade_noADesc(tblDesc));
		this.add(getUser_identifyADesc(tblDesc));
		this.add(getTrade_typeADesc(tblDesc));
		this.add(getTrade_statusADesc(tblDesc));
		this.add(getBankADesc(tblDesc));
		this.add(getCurrency_typeADesc(tblDesc));
		this.add(getTotal_feeADesc(tblDesc));
		this.add(getVouchers_feeADesc(tblDesc));
		this.add(getChannel_refund_noADesc(tblDesc));
		this.add(getMch_refund_noADesc(tblDesc));
		this.add(getRefund_feeADesc(tblDesc));
		this.add(getRefund_typeADesc(tblDesc));
		this.add(getRefund_statusADesc(tblDesc));
		this.add(getProduct_nameADesc(tblDesc));
		this.add(getMch_dataADesc(tblDesc));
		this.add(getPoundageADesc(tblDesc));
		this.add(getRateADesc(tblDesc));
		this.add(getChalel_nameADesc(tblDesc));
		this.add(getId_chlADesc(tblDesc));
		this.add(getCheck_rstADesc(tblDesc));
		this.add(getSd_chlADesc(tblDesc));
		this.add(getBanktradenoADesc(tblDesc));
		this.add(getBill_typeADesc(tblDesc));
		this.add(getChl_nameADesc(tblDesc));
		this.add(new DsAttr(dsColumn,this));
		this.add(new SvAttr(svColumn,this));
		this.setIsRefTableInfo(true);
		
	}
		
	/**
	 * 获得表元数据
	 * @return
	 */
	private ITableDesc getTableDesc(){
		TableDesc tblDesc=new TableDesc(TABLE_NAME,TABLE_ALIAS_NAME);
		tblDesc.setLabel(CLASS_DISPALYNAME);
		tblDesc.setPrimaryKey(getId_channel_bill_itemCDesc(tblDesc));
		tblDesc.add(getId_channel_bill_itemCDesc(tblDesc));
		tblDesc.add(getId_channel_billCDesc(tblDesc));
		tblDesc.add(getTradetimeCDesc(tblDesc));
		tblDesc.add(getAppidCDesc(tblDesc));
		tblDesc.add(getMchidCDesc(tblDesc));
		tblDesc.add(getCmchidCDesc(tblDesc));
		tblDesc.add(getDevicenoCDesc(tblDesc));
		tblDesc.add(getChanneltradenoCDesc(tblDesc));
		tblDesc.add(getMch_trade_noCDesc(tblDesc));
		tblDesc.add(getUser_identifyCDesc(tblDesc));
		tblDesc.add(getTrade_typeCDesc(tblDesc));
		tblDesc.add(getTrade_statusCDesc(tblDesc));
		tblDesc.add(getBankCDesc(tblDesc));
		tblDesc.add(getCurrency_typeCDesc(tblDesc));
		tblDesc.add(getTotal_feeCDesc(tblDesc));
		tblDesc.add(getVouchers_feeCDesc(tblDesc));
		tblDesc.add(getChannel_refund_noCDesc(tblDesc));
		tblDesc.add(getMch_refund_noCDesc(tblDesc));
		tblDesc.add(getRefund_feeCDesc(tblDesc));
		tblDesc.add(getRefund_typeCDesc(tblDesc));
		tblDesc.add(getRefund_statusCDesc(tblDesc));
		tblDesc.add(getProduct_nameCDesc(tblDesc));
		tblDesc.add(getMch_dataCDesc(tblDesc));
		tblDesc.add(getPoundageCDesc(tblDesc));
		tblDesc.add(getRateCDesc(tblDesc));
		tblDesc.add(getChalel_nameCDesc(tblDesc));
		tblDesc.add(getId_chlCDesc(tblDesc));
		tblDesc.add(getCheck_rstCDesc(tblDesc));
		tblDesc.add(getSd_chlCDesc(tblDesc));
		tblDesc.add(getBanktradenoCDesc(tblDesc));
		tblDesc.add(getBill_typeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 渠道对账单明细属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_channel_bill_itemADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_channel_bill_item",  getId_channel_bill_itemCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("渠道对账单明细");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 渠道对账单属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_channel_billADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_channel_bill",  getId_channel_billCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("渠道对账单");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 交易时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTradetimeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Tradetime",  getTradetimeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("交易时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 公众号ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAppidADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Appid",  getAppidCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("公众号ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 商户号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMchidADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mchid",  getMchidCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("商户号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 子商户号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCmchidADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Cmchid",  getCmchidCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("子商户号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 设备号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDevicenoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Deviceno",  getDevicenoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("设备号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 渠道订单号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getChanneltradenoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Channeltradeno",  getChanneltradenoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("渠道订单号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 商户订单号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMch_trade_noADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mch_trade_no",  getMch_trade_noCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("商户订单号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 用户标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getUser_identifyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("User_identify",  getUser_identifyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用户标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 交易类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTrade_typeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Trade_type",  getTrade_typeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("交易类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 交易状态属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTrade_statusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Trade_status",  getTrade_statusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("交易状态");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 付款银行属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBankADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Bank",  getBankCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("付款银行");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 货币种类属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCurrency_typeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Currency_type",  getCurrency_typeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("货币种类");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 总金额属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTotal_feeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Total_fee",  getTotal_feeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("总金额");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 代金券金额属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getVouchers_feeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Vouchers_fee",  getVouchers_feeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("代金券金额");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 渠道退款单号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getChannel_refund_noADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Channel_refund_no",  getChannel_refund_noCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("渠道退款单号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 商户退款单号 属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMch_refund_noADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mch_refund_no",  getMch_refund_noCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("商户退款单号 ");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 退款金额属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRefund_feeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Refund_fee",  getRefund_feeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("退款金额");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 退款类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRefund_typeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Refund_type",  getRefund_typeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("退款类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 退款状态属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRefund_statusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Refund_status",  getRefund_statusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("退款状态");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 商品名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getProduct_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Product_name",  getProduct_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("商品名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 商户数据包属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMch_dataADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mch_data",  getMch_dataCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("商户数据包");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手续费属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPoundageADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Poundage",  getPoundageCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手续费");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 费率属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Rate",  getRateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("费率");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 渠道名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getChalel_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Chalel_name",  getChalel_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("渠道名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 渠道属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_chlADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_chl",  getId_chlCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("渠道");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 对账结果属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCheck_rstADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Check_rst",  getCheck_rstCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("对账结果");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 渠道编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_chlADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_chl",  getSd_chlCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("渠道编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 银行交易号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBanktradenoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Banktradeno",  getBanktradenoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("银行交易号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 账单类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBill_typeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Bill_type",  getBill_typeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("账单类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getChl_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Chl_name",  getChl_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b3","id_chl=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取渠道对账单明细表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_channel_bill_itemCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_channel_bill_item");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("渠道对账单明细"); 
		return column;
	}
	/**
	 * 获取渠道对账单表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_channel_billCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_channel_bill");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("渠道对账单"); 
		return column;
	}
	/**
	 * 获取交易时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTradetimeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Tradetime");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("交易时间"); 
		return column;
	}
	/**
	 * 获取公众号ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAppidCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Appid");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("公众号ID"); 
		return column;
	}
	/**
	 * 获取商户号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMchidCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mchid");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("商户号"); 
		return column;
	}
	/**
	 * 获取子商户号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCmchidCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Cmchid");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("子商户号"); 
		return column;
	}
	/**
	 * 获取设备号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDevicenoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Deviceno");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("设备号"); 
		return column;
	}
	/**
	 * 获取渠道订单号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getChanneltradenoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Channeltradeno");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("渠道订单号"); 
		return column;
	}
	/**
	 * 获取商户订单号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMch_trade_noCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mch_trade_no");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("商户订单号"); 
		return column;
	}
	/**
	 * 获取用户标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getUser_identifyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"User_identify");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("用户标识"); 
		return column;
	}
	/**
	 * 获取交易类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTrade_typeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Trade_type");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("交易类型"); 
		return column;
	}
	/**
	 * 获取交易状态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTrade_statusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Trade_status");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("交易状态"); 
		return column;
	}
	/**
	 * 获取付款银行表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBankCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Bank");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("付款银行"); 
		return column;
	}
	/**
	 * 获取货币种类表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCurrency_typeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Currency_type");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("货币种类"); 
		return column;
	}
	/**
	 * 获取总金额表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTotal_feeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Total_fee");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("总金额"); 
		return column;
	}
	/**
	 * 获取代金券金额表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getVouchers_feeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Vouchers_fee");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("代金券金额"); 
		return column;
	}
	/**
	 * 获取渠道退款单号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getChannel_refund_noCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Channel_refund_no");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("渠道退款单号"); 
		return column;
	}
	/**
	 * 获取商户退款单号 表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMch_refund_noCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mch_refund_no");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("商户退款单号 "); 
		return column;
	}
	/**
	 * 获取退款金额表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRefund_feeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Refund_fee");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("退款金额"); 
		return column;
	}
	/**
	 * 获取退款类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRefund_typeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Refund_type");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("退款类型"); 
		return column;
	}
	/**
	 * 获取退款状态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRefund_statusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Refund_status");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("退款状态"); 
		return column;
	}
	/**
	 * 获取商品名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getProduct_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Product_name");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("商品名"); 
		return column;
	}
	/**
	 * 获取商户数据包表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMch_dataCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mch_data");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("商户数据包"); 
		return column;
	}
	/**
	 * 获取手续费表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPoundageCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Poundage");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手续费"); 
		return column;
	}
	/**
	 * 获取费率表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Rate");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("费率"); 
		return column;
	}
	/**
	 * 获取渠道名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getChalel_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Chalel_name");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("渠道名称"); 
		return column;
	}
	/**
	 * 获取渠道表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_chlCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_chl");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("渠道"); 
		return column;
	}
	/**
	 * 获取对账结果表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCheck_rstCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Check_rst");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("对账结果"); 
		return column;
	}
	/**
	 * 获取渠道编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_chlCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_chl");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("渠道编码"); 
		return column;
	}
	/**
	 * 获取银行交易号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBanktradenoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Banktradeno");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("银行交易号"); 
		return column;
	}
	/**
	 * 获取账单类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBill_typeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Bill_type");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("账单类型"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getChl_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Chl_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
	}

	/**
	 * 设置实体审计信息数据映射关系 
	 */
	private void setIAuditInfoFldMap(){
	}
	
	/**
	 * 设置实体默认值
	 */
	private void setDefaultValueMap(){
		defaultValueMap=new HashMap<String, Object>();
	}
	
}
