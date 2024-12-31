
package iih.pmp.pay.billcheckrst.d.desc;

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
 * 对账结果 DO 元数据信息
 */
public class BillCheckRstDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.pmp.pay.billcheckrst.d.BillCheckRstDO";
	public static final String CLASS_DISPALYNAME = "对账结果";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "pmp_billcheck";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_billcheck";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public BillCheckRstDODesc(){
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
		this.setKeyDesc(getId_billcheckADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_billcheckADesc(tblDesc));
		this.add(getBill_typeADesc(tblDesc));
		this.add(getSd_chlADesc(tblDesc));
		this.add(getId_chlADesc(tblDesc));
		this.add(getFee_paidADesc(tblDesc));
		this.add(getFee_refundADesc(tblDesc));
		this.add(getTotal_feeADesc(tblDesc));
		this.add(getDt_billADesc(tblDesc));
		this.add(getChl_fee_paidADesc(tblDesc));
		this.add(getChl_fee_refundADesc(tblDesc));
		this.add(getChl_total_feeADesc(tblDesc));
		this.add(getNum_paidADesc(tblDesc));
		this.add(getNum_refundADesc(tblDesc));
		this.add(getChl_num_paidADesc(tblDesc));
		this.add(getChl_num_refundADesc(tblDesc));
		this.add(getName_chlADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_billcheckCDesc(tblDesc));
		tblDesc.add(getId_billcheckCDesc(tblDesc));
		tblDesc.add(getBill_typeCDesc(tblDesc));
		tblDesc.add(getSd_chlCDesc(tblDesc));
		tblDesc.add(getId_chlCDesc(tblDesc));
		tblDesc.add(getFee_paidCDesc(tblDesc));
		tblDesc.add(getFee_refundCDesc(tblDesc));
		tblDesc.add(getTotal_feeCDesc(tblDesc));
		tblDesc.add(getDt_billCDesc(tblDesc));
		tblDesc.add(getChl_fee_paidCDesc(tblDesc));
		tblDesc.add(getChl_fee_refundCDesc(tblDesc));
		tblDesc.add(getChl_total_feeCDesc(tblDesc));
		tblDesc.add(getNum_paidCDesc(tblDesc));
		tblDesc.add(getNum_refundCDesc(tblDesc));
		tblDesc.add(getChl_num_paidCDesc(tblDesc));
		tblDesc.add(getChl_num_refundCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 对账结果主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_billcheckADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_billcheck",  getId_billcheckCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("对账结果主键");
		attrDesc.setNullable(false);
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
	 * 支付渠道编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_chlADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_chl",  getSd_chlCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("支付渠道编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 支付渠道名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_chlADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_chl",  getId_chlCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("支付渠道名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 支付总金额属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFee_paidADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fee_paid",  getFee_paidCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("支付总金额");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 退款总金额属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFee_refundADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fee_refund",  getFee_refundCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("退款总金额");
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
	 * 对账日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_billADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_bill",  getDt_billCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("对账日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 渠道支付金额属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getChl_fee_paidADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Chl_fee_paid",  getChl_fee_paidCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("渠道支付金额");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 渠道退款金额属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getChl_fee_refundADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Chl_fee_refund",  getChl_fee_refundCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("渠道退款金额");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 渠道总金额属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getChl_total_feeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Chl_total_fee",  getChl_total_feeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("渠道总金额");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 支付总笔数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNum_paidADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Num_paid",  getNum_paidCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("支付总笔数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 退款总笔数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNum_refundADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Num_refund",  getNum_refundCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("退款总笔数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 渠道支付总笔数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getChl_num_paidADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Chl_num_paid",  getChl_num_paidCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("渠道支付总笔数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 渠道退款总笔数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getChl_num_refundADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Chl_num_refund",  getChl_num_refundCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("渠道退款总笔数");
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
	private IAttrDesc getName_chlADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_chl",  getName_chlCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("渠道名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b2","id_chl=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取对账结果主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_billcheckCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_billcheck");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("对账结果主键"); 
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
	 * 获取支付渠道编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_chlCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_chl");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("支付渠道编码"); 
		return column;
	}
	/**
	 * 获取支付渠道名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_chlCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_chl");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("支付渠道名称"); 
		return column;
	}
	/**
	 * 获取支付总金额表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFee_paidCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fee_paid");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("支付总金额"); 
		return column;
	}
	/**
	 * 获取退款总金额表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFee_refundCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fee_refund");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("退款总金额"); 
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
	 * 获取对账日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_billCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_bill");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("对账日期"); 
		return column;
	}
	/**
	 * 获取渠道支付金额表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getChl_fee_paidCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Chl_fee_paid");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("渠道支付金额"); 
		return column;
	}
	/**
	 * 获取渠道退款金额表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getChl_fee_refundCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Chl_fee_refund");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("渠道退款金额"); 
		return column;
	}
	/**
	 * 获取渠道总金额表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getChl_total_feeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Chl_total_fee");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("渠道总金额"); 
		return column;
	}
	/**
	 * 获取支付总笔数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNum_paidCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Num_paid");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("支付总笔数"); 
		return column;
	}
	/**
	 * 获取退款总笔数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNum_refundCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Num_refund");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("退款总笔数"); 
		return column;
	}
	/**
	 * 获取渠道支付总笔数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getChl_num_paidCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Chl_num_paid");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("渠道支付总笔数"); 
		return column;
	}
	/**
	 * 获取渠道退款总笔数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getChl_num_refundCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Chl_num_refund");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("渠道退款总笔数"); 
		return column;
	}
	/**
	 * 获取渠道名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_chlCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_chl");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("渠道名称"); 
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
