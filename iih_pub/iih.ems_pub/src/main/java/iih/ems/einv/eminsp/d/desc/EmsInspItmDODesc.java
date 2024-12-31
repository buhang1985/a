
package iih.ems.einv.eminsp.d.desc;

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
 * 大型设备验收单细目 DO 元数据信息
 */
public class EmsInspItmDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.ems.einv.eminsp.d.EmsInspItmDO";
	public static final String CLASS_DISPALYNAME = "大型设备验收单细目";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "Ems_Insp_itm";
	public static final String TABLE_ALIAS_NAME = "a1";
	public static final String PRIMARYKEY_FIELDNAME="Id_inspitm";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public EmsInspItmDODesc(){
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
		this.setKeyDesc(getId_inspitmADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_inspADesc(tblDesc));
		this.add(getId_inspitmADesc(tblDesc));
		this.add(getId_inspADesc(tblDesc));
		this.add(getId_emADesc(tblDesc));
		this.add(getInnercodeADesc(tblDesc));
		this.add(getPriceADesc(tblDesc));
		this.add(getNumADesc(tblDesc));
		this.add(getAmtADesc(tblDesc));
		this.add(getBarcodeADesc(tblDesc));
		this.add(getId_facADesc(tblDesc));
		this.add(getCode_emADesc(tblDesc));
		this.add(getName_emADesc(tblDesc));
		this.add(getSpecsADesc(tblDesc));
		this.add(getId_unitADesc(tblDesc));
		this.add(getId_emcaADesc(tblDesc));
		this.add(getCurr_priceADesc(tblDesc));
		this.add(getBrand_nameADesc(tblDesc));
		this.add(getEnglish_nameADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_inspitmCDesc(tblDesc));
		tblDesc.add(getId_inspitmCDesc(tblDesc));
		tblDesc.add(getId_inspCDesc(tblDesc));
		tblDesc.add(getId_emCDesc(tblDesc));
		tblDesc.add(getInnercodeCDesc(tblDesc));
		tblDesc.add(getPriceCDesc(tblDesc));
		tblDesc.add(getNumCDesc(tblDesc));
		tblDesc.add(getAmtCDesc(tblDesc));
		tblDesc.add(getBarcodeCDesc(tblDesc));
		tblDesc.add(getId_facCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 验收单细项主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_inspitmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_inspitm",  getId_inspitmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("验收单细项主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 验收单主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_inspADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_insp",  getId_inspCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("验收单主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 设备基本信息属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_em",  getId_emCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("设备基本信息");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 院内码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInnercodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Innercode",  getInnercodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("院内码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 单价属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPriceADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Price",  getPriceCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("单价");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 数量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNumADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Num",  getNumCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("数量");
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
	private IAttrDesc getAmtADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt",  getAmtCDesc(tblDesc), this);
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
	 * 厂商条码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBarcodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Barcode",  getBarcodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("厂商条码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 生产厂商属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_facADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_fac",  getId_facCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("生产厂商");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 设备编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_emADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_em",  getCode_emCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("设备编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"ems_info a1b3","id_em=id_em","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 设备名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_emADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_em",  getName_emCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("设备名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"ems_info a1b3","id_em=id_em","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 规格属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSpecsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Specs",  getSpecsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("规格");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"ems_info a1b3","id_em=id_em","specs"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 单位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_unitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_unit",  getId_unitCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("单位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"ems_info a1b3","id_em=id_em","id_unit"});
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 设备分类属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emcaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emca",  getId_emcaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("设备分类");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"ems_info a1b3","id_em=id_em","id_emca"});
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 最新单价属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCurr_priceADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Curr_price",  getCurr_priceCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("最新单价");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"ems_info a1b3","id_em=id_em","curr_price"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 品牌名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBrand_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Brand_name",  getBrand_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("品牌名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"ems_info a1b3","id_em=id_em","brand_name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 英文名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEnglish_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("English_name",  getEnglish_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("英文名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"ems_info a1b3","id_em=id_em","english_name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取验收单细项主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_inspitmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_inspitm");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("验收单细项主键"); 
		return column;
	}
	/**
	 * 获取验收单主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_inspCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_insp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("验收单主键"); 
		return column;
	}
	/**
	 * 获取设备基本信息表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_em");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("设备基本信息"); 
		return column;
	}
	/**
	 * 获取院内码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInnercodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Innercode");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("院内码"); 
		return column;
	}
	/**
	 * 获取单价表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPriceCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Price");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("单价"); 
		return column;
	}
	/**
	 * 获取数量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNumCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Num");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("数量"); 
		return column;
	}
	/**
	 * 获取总金额表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmtCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("总金额"); 
		return column;
	}
	/**
	 * 获取厂商条码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBarcodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Barcode");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("厂商条码"); 
		return column;
	}
	/**
	 * 获取生产厂商表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_facCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_fac");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("生产厂商"); 
		return column;
	}
	/**
	 * 获取设备编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_emCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_em");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("设备编码"); 
		return column;
	}
	/**
	 * 获取设备名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_emCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_em");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("设备名称"); 
		return column;
	}
	/**
	 * 获取规格表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSpecsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Specs");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("规格"); 
		return column;
	}
	/**
	 * 获取单位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_unitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_unit");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("单位"); 
		return column;
	}
	/**
	 * 获取设备分类表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emcaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emca");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("设备分类"); 
		return column;
	}
	/**
	 * 获取最新单价表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCurr_priceCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Curr_price");
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("最新单价"); 
		return column;
	}
	/**
	 * 获取品牌名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBrand_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Brand_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("品牌名称"); 
		return column;
	}
	/**
	 * 获取英文名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEnglish_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"English_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("英文名"); 
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
