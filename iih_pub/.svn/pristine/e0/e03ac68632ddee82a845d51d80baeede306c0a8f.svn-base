
package iih.pis.ivx.pisivxorder.d.desc;

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
 * 微信处方订单明细 DO 元数据信息
 */
public class PisIvxOrderDtlDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.pis.ivx.pisivxorder.d.PisIvxOrderDtlDO";
	public static final String CLASS_DISPALYNAME = "微信处方订单明细";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "pis_ivx_pisivxorderdtl";
	public static final String TABLE_ALIAS_NAME = "a1";
	public static final String PRIMARYKEY_FIELDNAME="Id_pisivxorderdtl";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public PisIvxOrderDtlDODesc(){
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
		this.setKeyDesc(getId_pisivxorderdtlADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_pisivxorderADesc(tblDesc));
		this.add(getId_pisivxorderdtlADesc(tblDesc));
		this.add(getId_pisivxorderADesc(tblDesc));
		this.add(getTypenameADesc(tblDesc));
		this.add(getDrugnameADesc(tblDesc));
		this.add(getSpecificationADesc(tblDesc));
		this.add(getAmountADesc(tblDesc));
		this.add(getChargepriceADesc(tblDesc));
		this.add(getTotalADesc(tblDesc));
		this.add(getId_patADesc(tblDesc));
		this.add(getTimesADesc(tblDesc));
		this.add(getOrdertypeADesc(tblDesc));
		this.add(getOrdernumADesc(tblDesc));
		this.add(getItemnoADesc(tblDesc));
		this.add(getChargecodeADesc(tblDesc));
		this.add(getChargeamountADesc(tblDesc));
		this.add(getCaoyaofuADesc(tblDesc));
		this.add(getDt_happenADesc(tblDesc));
		this.add(getName_depADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_pisivxorderdtlCDesc(tblDesc));
		tblDesc.add(getId_pisivxorderdtlCDesc(tblDesc));
		tblDesc.add(getId_pisivxorderCDesc(tblDesc));
		tblDesc.add(getTypenameCDesc(tblDesc));
		tblDesc.add(getDrugnameCDesc(tblDesc));
		tblDesc.add(getSpecificationCDesc(tblDesc));
		tblDesc.add(getAmountCDesc(tblDesc));
		tblDesc.add(getChargepriceCDesc(tblDesc));
		tblDesc.add(getTotalCDesc(tblDesc));
		tblDesc.add(getId_patCDesc(tblDesc));
		tblDesc.add(getTimesCDesc(tblDesc));
		tblDesc.add(getOrdertypeCDesc(tblDesc));
		tblDesc.add(getOrdernumCDesc(tblDesc));
		tblDesc.add(getItemnoCDesc(tblDesc));
		tblDesc.add(getChargecodeCDesc(tblDesc));
		tblDesc.add(getChargeamountCDesc(tblDesc));
		tblDesc.add(getCaoyaofuCDesc(tblDesc));
		tblDesc.add(getDt_happenCDesc(tblDesc));
		tblDesc.add(getName_depCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 微信处方订单明细主键标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pisivxorderdtlADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pisivxorderdtl",  getId_pisivxorderdtlCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("微信处方订单明细主键标识");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 微信处方订单ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pisivxorderADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pisivxorder",  getId_pisivxorderCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("微信处方订单ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * displaynam2属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTypenameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Typename",  getTypenameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("displaynam2");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * displaynam3属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDrugnameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Drugname",  getDrugnameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("displaynam3");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * displaynam4属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSpecificationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Specification",  getSpecificationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("displaynam4");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * displaynam5属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmountADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amount",  getAmountCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("displaynam5");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * displaynam6属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getChargepriceADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Chargeprice",  getChargepriceCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("displaynam6");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * displaynam7属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTotalADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Total",  getTotalCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("displaynam7");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * displaynam8属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_patADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pat",  getId_patCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("displaynam8");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * displaynam9属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTimesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Times",  getTimesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("displaynam9");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * displaynam10属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOrdertypeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ordertype",  getOrdertypeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("displaynam10");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * displaynam11属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOrdernumADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ordernum",  getOrdernumCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("displaynam11");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * displaynam12属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getItemnoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Itemno",  getItemnoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("displaynam12");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * displaynam13属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getChargecodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Chargecode",  getChargecodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("displaynam13");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * displaynam14属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getChargeamountADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Chargeamount",  getChargeamountCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("displaynam14");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * displaynam15属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCaoyaofuADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Caoyaofu",  getCaoyaofuCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("displaynam15");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * displaynam16属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_happenADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_happen",  getDt_happenCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("displaynam16");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * displaynam17属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_depADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dep",  getName_depCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("displaynam17");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取微信处方订单明细主键标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pisivxorderdtlCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pisivxorderdtl");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("微信处方订单明细主键标识"); 
		return column;
	}
	/**
	 * 获取微信处方订单ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pisivxorderCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pisivxorder");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("微信处方订单ID"); 
		return column;
	}
	/**
	 * 获取displaynam2表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTypenameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Typename");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("displaynam2"); 
		return column;
	}
	/**
	 * 获取displaynam3表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDrugnameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Drugname");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("displaynam3"); 
		return column;
	}
	/**
	 * 获取displaynam4表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSpecificationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Specification");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("displaynam4"); 
		return column;
	}
	/**
	 * 获取displaynam5表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmountCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amount");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("displaynam5"); 
		return column;
	}
	/**
	 * 获取displaynam6表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getChargepriceCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Chargeprice");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("displaynam6"); 
		return column;
	}
	/**
	 * 获取displaynam7表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTotalCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Total");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("displaynam7"); 
		return column;
	}
	/**
	 * 获取displaynam8表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pat");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("displaynam8"); 
		return column;
	}
	/**
	 * 获取displaynam9表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTimesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Times");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("displaynam9"); 
		return column;
	}
	/**
	 * 获取displaynam10表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOrdertypeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ordertype");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("displaynam10"); 
		return column;
	}
	/**
	 * 获取displaynam11表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOrdernumCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ordernum");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("displaynam11"); 
		return column;
	}
	/**
	 * 获取displaynam12表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getItemnoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Itemno");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("displaynam12"); 
		return column;
	}
	/**
	 * 获取displaynam13表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getChargecodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Chargecode");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("displaynam13"); 
		return column;
	}
	/**
	 * 获取displaynam14表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getChargeamountCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Chargeamount");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("displaynam14"); 
		return column;
	}
	/**
	 * 获取displaynam15表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCaoyaofuCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Caoyaofu");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("displaynam15"); 
		return column;
	}
	/**
	 * 获取displaynam16表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_happenCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_happen");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("displaynam16"); 
		return column;
	}
	/**
	 * 获取displaynam17表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_depCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dep");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("displaynam17"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id","Id_pisivxorderdtl");
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
