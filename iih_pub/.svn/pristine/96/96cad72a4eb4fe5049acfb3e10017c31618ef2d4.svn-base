
package iih.mm.bl.blreserve.d.desc;

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
 * 物品结存预留处理明细表 DO 元数据信息
 */
public class StockBlReserveItemDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.mm.bl.blreserve.d.StockBlReserveItemDO";
	public static final String CLASS_DISPALYNAME = "物品结存预留处理明细表";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "mm_bl_reserve_itm";
	public static final String TABLE_ALIAS_NAME = "a1";
	public static final String PRIMARYKEY_FIELDNAME="Id_rsvitm";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public StockBlReserveItemDODesc(){
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
		this.setKeyDesc(getId_rsvitmADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_rsvADesc(tblDesc));
		this.add(getId_rsvitmADesc(tblDesc));
		this.add(getId_rsvADesc(tblDesc));
		this.add(getId_blADesc(tblDesc));
		this.add(getPri_saleADesc(tblDesc));
		this.add(getQuan_reserveADesc(tblDesc));
		this.add(getQuan_stockADesc(tblDesc));
		this.add(getQuan_bkADesc(tblDesc));
		this.add(getFg_freeADesc(tblDesc));
		this.add(new DsAttr(dsColumn,this));
		this.add(new SvAttr(svColumn,this));
		
	}
		
	/**
	 * 获得表元数据
	 * @return
	 */
	private ITableDesc getTableDesc(){
		TableDesc tblDesc=new TableDesc(TABLE_NAME,TABLE_ALIAS_NAME);
		tblDesc.setLabel(CLASS_DISPALYNAME);
		tblDesc.setPrimaryKey(getId_rsvitmCDesc(tblDesc));
		tblDesc.add(getId_rsvitmCDesc(tblDesc));
		tblDesc.add(getId_rsvCDesc(tblDesc));
		tblDesc.add(getId_blCDesc(tblDesc));
		tblDesc.add(getPri_saleCDesc(tblDesc));
		tblDesc.add(getQuan_reserveCDesc(tblDesc));
		tblDesc.add(getQuan_stockCDesc(tblDesc));
		tblDesc.add(getQuan_bkCDesc(tblDesc));
		tblDesc.add(getFg_freeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 预留明细主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_rsvitmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_rsvitm",  getId_rsvitmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("预留明细主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 预留主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_rsvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_rsv",  getId_rsvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("预留主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 结存主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_blADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_bl",  getId_blCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("结存主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 售价_零售包装属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPri_saleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pri_sale",  getPri_saleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("售价_零售包装");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 预留_基本包装属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuan_reserveADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Quan_reserve",  getQuan_reserveCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("预留_基本包装");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 实发_基本包装属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuan_stockADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Quan_stock",  getQuan_stockCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("实发_基本包装");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 退发数量_基本包装属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuan_bkADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Quan_bk",  getQuan_bkCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("退发数量_基本包装");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 减免标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_freeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_free",  getFg_freeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("减免标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取预留明细主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_rsvitmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_rsvitm");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("预留明细主键"); 
		return column;
	}
	/**
	 * 获取预留主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_rsvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_rsv");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("预留主键"); 
		return column;
	}
	/**
	 * 获取结存主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_blCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_bl");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("结存主键"); 
		return column;
	}
	/**
	 * 获取售价_零售包装表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPri_saleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pri_sale");
		column.setLength(38);
        column.setPrecision(8);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("售价_零售包装"); 
		return column;
	}
	/**
	 * 获取预留_基本包装表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuan_reserveCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Quan_reserve");
		column.setLength(38);
        column.setPrecision(8);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("预留_基本包装"); 
		return column;
	}
	/**
	 * 获取实发_基本包装表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuan_stockCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Quan_stock");
		column.setLength(38);
        column.setPrecision(8);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("实发_基本包装"); 
		return column;
	}
	/**
	 * 获取退发数量_基本包装表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuan_bkCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Quan_bk");
		column.setLength(38);
        column.setPrecision(8);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("退发数量_基本包装"); 
		return column;
	}
	/**
	 * 获取减免标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_freeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_free");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("减免标识"); 
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
