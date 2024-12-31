
package iih.pmp.pay.billcheckexception.d.desc;

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
 * 对账异常 DO 元数据信息
 */
public class BillCheckExceptionDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.pmp.pay.billcheckexception.d.BillCheckExceptionDO";
	public static final String CLASS_DISPALYNAME = "对账异常";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "pmp_billcheck_exception";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_billcheck_exception";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public BillCheckExceptionDODesc(){
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
		this.setKeyDesc(getId_billcheck_exceptionADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_billcheck_exceptionADesc(tblDesc));
		this.add(getDt_reqADesc(tblDesc));
		this.add(getId_tradeADesc(tblDesc));
		this.add(getId_ordADesc(tblDesc));
		this.add(getId_billitemADesc(tblDesc));
		this.add(getCheckresultADesc(tblDesc));
		this.add(getOrd_noADesc(tblDesc));
		this.add(getTrade_noADesc(tblDesc));
		this.add(getTrade_typeADesc(tblDesc));
		this.add(getIs_amaout_ckeckedADesc(tblDesc));
		this.add(getIs_status_checkedADesc(tblDesc));
		this.add(getFailed_tableADesc(tblDesc));
		this.add(getRefund_trade_noADesc(tblDesc));
		this.add(getId_chlADesc(tblDesc));
		this.add(getSd_chlADesc(tblDesc));
		this.add(getTradetimeADesc(tblDesc));
		this.add(getMchnoADesc(tblDesc));
		this.add(getBill_typeADesc(tblDesc));
		this.add(getBanktradenoADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_billcheck_exceptionCDesc(tblDesc));
		tblDesc.add(getId_billcheck_exceptionCDesc(tblDesc));
		tblDesc.add(getDt_reqCDesc(tblDesc));
		tblDesc.add(getId_tradeCDesc(tblDesc));
		tblDesc.add(getId_ordCDesc(tblDesc));
		tblDesc.add(getId_billitemCDesc(tblDesc));
		tblDesc.add(getCheckresultCDesc(tblDesc));
		tblDesc.add(getOrd_noCDesc(tblDesc));
		tblDesc.add(getTrade_noCDesc(tblDesc));
		tblDesc.add(getTrade_typeCDesc(tblDesc));
		tblDesc.add(getIs_amaout_ckeckedCDesc(tblDesc));
		tblDesc.add(getIs_status_checkedCDesc(tblDesc));
		tblDesc.add(getFailed_tableCDesc(tblDesc));
		tblDesc.add(getRefund_trade_noCDesc(tblDesc));
		tblDesc.add(getId_chlCDesc(tblDesc));
		tblDesc.add(getSd_chlCDesc(tblDesc));
		tblDesc.add(getTradetimeCDesc(tblDesc));
		tblDesc.add(getMchnoCDesc(tblDesc));
		tblDesc.add(getBill_typeCDesc(tblDesc));
		tblDesc.add(getBanktradenoCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_billcheck_exceptionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_billcheck_exception",  getId_billcheck_exceptionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 请求日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_reqADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_req",  getDt_reqCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("请求日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 交易表主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_tradeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_trade",  getId_tradeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("交易表主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 订单表主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ordADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ord",  getId_ordCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("订单表主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 第三方主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_billitemADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_billitem",  getId_billitemCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("第三方主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 对账结果属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCheckresultADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Checkresult",  getCheckresultCDesc(tblDesc), this);
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
	 * 外部订单号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOrd_noADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ord_no",  getOrd_noCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("外部订单号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 交易号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTrade_noADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Trade_no",  getTrade_noCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("交易号");
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
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("交易类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 交易金额是否正确属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIs_amaout_ckeckedADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Is_amaout_ckecked",  getIs_amaout_ckeckedCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("交易金额是否正确");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 交易状态是否正确属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIs_status_checkedADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Is_status_checked",  getIs_status_checkedCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("交易状态是否正确");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 异常表属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFailed_tableADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Failed_table",  getFailed_tableCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("异常表");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 退款交易号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRefund_trade_noADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Refund_trade_no",  getRefund_trade_noCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("退款交易号");
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
	 * 第三方交易时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTradetimeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Tradetime",  getTradetimeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("第三方交易时间");
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
	private IAttrDesc getMchnoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mchno",  getMchnoCDesc(tblDesc), this);
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
	 * 对账类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBill_typeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Bill_type",  getBill_typeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("对账类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 第三方交易号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBanktradenoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Banktradeno",  getBanktradenoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("第三方交易号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
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
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b2","id_chl=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_billcheck_exceptionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_billcheck_exception");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("主键"); 
		return column;
	}
	/**
	 * 获取请求日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_reqCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_req");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("请求日期"); 
		return column;
	}
	/**
	 * 获取交易表主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_tradeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_trade");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("交易表主键"); 
		return column;
	}
	/**
	 * 获取订单表主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ordCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ord");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("订单表主键"); 
		return column;
	}
	/**
	 * 获取第三方主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_billitemCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_billitem");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("第三方主键"); 
		return column;
	}
	/**
	 * 获取对账结果表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCheckresultCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Checkresult");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("对账结果"); 
		return column;
	}
	/**
	 * 获取外部订单号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOrd_noCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ord_no");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("外部订单号"); 
		return column;
	}
	/**
	 * 获取交易号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTrade_noCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Trade_no");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("交易号"); 
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
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("交易类型"); 
		return column;
	}
	/**
	 * 获取交易金额是否正确表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIs_amaout_ckeckedCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Is_amaout_ckecked");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("交易金额是否正确"); 
		return column;
	}
	/**
	 * 获取交易状态是否正确表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIs_status_checkedCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Is_status_checked");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("交易状态是否正确"); 
		return column;
	}
	/**
	 * 获取异常表表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFailed_tableCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Failed_table");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("异常表"); 
		return column;
	}
	/**
	 * 获取退款交易号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRefund_trade_noCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Refund_trade_no");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("退款交易号"); 
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
	 * 获取第三方交易时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTradetimeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Tradetime");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("第三方交易时间"); 
		return column;
	}
	/**
	 * 获取商户订单号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMchnoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mchno");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("商户订单号"); 
		return column;
	}
	/**
	 * 获取对账类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBill_typeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Bill_type");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("对账类型"); 
		return column;
	}
	/**
	 * 获取第三方交易号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBanktradenoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Banktradeno");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("第三方交易号"); 
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
