
package iih.pe.por.pecorpcharge.d.desc;

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
 * 体检团体费用结账单汇总 DO 元数据信息
 */
public class PeCorpChargeSumDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.pe.por.pecorpcharge.d.PeCorpChargeSumDO";
	public static final String CLASS_DISPALYNAME = "体检团体费用结账单汇总";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "pe_or_pecorpchargesum";
	public static final String TABLE_ALIAS_NAME = "a2";
	public static final String PRIMARYKEY_FIELDNAME="Id_pecorpchargesum";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public PeCorpChargeSumDODesc(){
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
		this.setKeyDesc(getId_pecorpchargesumADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_pecorpchargeADesc(tblDesc));
		this.add(getId_pecorpchargesumADesc(tblDesc));
		this.add(getId_pecorpchargeADesc(tblDesc));
		this.add(getId_srvADesc(tblDesc));
		this.add(getSd_srvADesc(tblDesc));
		this.add(getBase_priADesc(tblDesc));
		this.add(getCharge_pe_setADesc(tblDesc));
		this.add(getCharge_pe_addADesc(tblDesc));
		this.add(getCharge_pe_subADesc(tblDesc));
		this.add(getCharge_peADesc(tblDesc));
		this.add(getDiscountADesc(tblDesc));
		this.add(getAmountADesc(tblDesc));
		this.add(getPsnsADesc(tblDesc));
		this.add(getBasepritimesADesc(tblDesc));
		this.add(getCode_srvADesc(tblDesc));
		this.add(getName_srvADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_pecorpchargesumCDesc(tblDesc));
		tblDesc.add(getId_pecorpchargesumCDesc(tblDesc));
		tblDesc.add(getId_pecorpchargeCDesc(tblDesc));
		tblDesc.add(getId_srvCDesc(tblDesc));
		tblDesc.add(getSd_srvCDesc(tblDesc));
		tblDesc.add(getBase_priCDesc(tblDesc));
		tblDesc.add(getCharge_pe_setCDesc(tblDesc));
		tblDesc.add(getCharge_pe_addCDesc(tblDesc));
		tblDesc.add(getCharge_pe_subCDesc(tblDesc));
		tblDesc.add(getCharge_peCDesc(tblDesc));
		tblDesc.add(getDiscountCDesc(tblDesc));
		tblDesc.add(getAmountCDesc(tblDesc));
		tblDesc.add(getPsnsCDesc(tblDesc));
		tblDesc.add(getBasepritimesCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 体检团体结账汇总主键标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pecorpchargesumADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pecorpchargesum",  getId_pecorpchargesumCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检团体结账汇总主键标识");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检团体结账ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pecorpchargeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pecorpcharge",  getId_pecorpchargeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检团体结账ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 收费项目属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_srvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_srv",  getId_srvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("收费项目");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 收费项目编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_srvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_srv",  getSd_srvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("收费项目编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检费基础价格属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBase_priADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Base_pri",  getBase_priCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("体检费基础价格");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 套餐价格属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCharge_pe_setADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Charge_pe_set",  getCharge_pe_setCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("套餐价格");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 加项价格属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCharge_pe_addADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Charge_pe_add",  getCharge_pe_addCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("加项价格");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 减项价格属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCharge_pe_subADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Charge_pe_sub",  getCharge_pe_subCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("减项价格");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检总费用属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCharge_peADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Charge_pe",  getCharge_peCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("体检总费用");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 折扣属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDiscountADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Discount",  getDiscountCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("折扣");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 折后实收费用属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmountADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amount",  getAmountCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("折后实收费用");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检人数汇总属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPsnsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Psns",  getPsnsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("体检人数汇总");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检费倍数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBasepritimesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Basepritimes",  getBasepritimesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("体检费倍数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 服务编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_srvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_srv",  getCode_srvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_srv a2b3","id_srv=id_srv","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 服务名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_srvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_srv",  getName_srvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_srv a2b3","id_srv=id_srv","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取体检团体结账汇总主键标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pecorpchargesumCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pecorpchargesum");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("体检团体结账汇总主键标识"); 
		return column;
	}
	/**
	 * 获取体检团体结账ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pecorpchargeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pecorpcharge");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检团体结账ID"); 
		return column;
	}
	/**
	 * 获取收费项目表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_srvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_srv");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("收费项目"); 
		return column;
	}
	/**
	 * 获取收费项目编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_srvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_srv");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("收费项目编码"); 
		return column;
	}
	/**
	 * 获取体检费基础价格表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBase_priCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Base_pri");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("体检费基础价格"); 
		return column;
	}
	/**
	 * 获取套餐价格表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCharge_pe_setCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Charge_pe_set");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("套餐价格"); 
		return column;
	}
	/**
	 * 获取加项价格表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCharge_pe_addCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Charge_pe_add");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("加项价格"); 
		return column;
	}
	/**
	 * 获取减项价格表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCharge_pe_subCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Charge_pe_sub");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("减项价格"); 
		return column;
	}
	/**
	 * 获取体检总费用表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCharge_peCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Charge_pe");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("体检总费用"); 
		return column;
	}
	/**
	 * 获取折扣表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDiscountCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Discount");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("折扣"); 
		return column;
	}
	/**
	 * 获取折后实收费用表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmountCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amount");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("折后实收费用"); 
		return column;
	}
	/**
	 * 获取体检人数汇总表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPsnsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Psns");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("体检人数汇总"); 
		return column;
	}
	/**
	 * 获取体检费倍数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBasepritimesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Basepritimes");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("体检费倍数"); 
		return column;
	}
	/**
	 * 获取服务编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_srvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_srv");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务编码"); 
		return column;
	}
	/**
	 * 获取服务名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_srvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_srv");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务名称"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id","Id_pecorpchargesum");
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
