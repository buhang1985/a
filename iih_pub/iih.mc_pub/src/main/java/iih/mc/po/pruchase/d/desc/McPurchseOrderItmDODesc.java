
package iih.mc.po.pruchase.d.desc;

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
 * 采购订单明细 DO 元数据信息
 */
public class McPurchseOrderItmDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.mc.po.pruchase.d.McPurchseOrderItmDO";
	public static final String CLASS_DISPALYNAME = "采购订单明细";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "MC_PO_ITM";
	public static final String TABLE_ALIAS_NAME = "a1";
	public static final String PRIMARYKEY_FIELDNAME="Id_poitm";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public McPurchseOrderItmDODesc(){
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
		this.setKeyDesc(getId_poitmADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_poADesc(tblDesc));
		this.add(getId_poitmADesc(tblDesc));
		this.add(getId_poADesc(tblDesc));
		this.add(getId_mmADesc(tblDesc));
		this.add(getId_mmpkgu_actualADesc(tblDesc));
		this.add(getPri_protocolADesc(tblDesc));
		this.add(getPri_poADesc(tblDesc));
		this.add(getQuan_poADesc(tblDesc));
		this.add(getAmtADesc(tblDesc));
		this.add(getQuan_bkADesc(tblDesc));
		this.add(getDesADesc(tblDesc));
		this.add(getEu_mmcaADesc(tblDesc));
		this.add(getId_orADesc(tblDesc));
		this.add(getMm_codeADesc(tblDesc));
		this.add(getMm_nameADesc(tblDesc));
		this.add(getMm_specADesc(tblDesc));
		this.add(getFactory_nameADesc(tblDesc));
		this.add(getMmpkgunameADesc(tblDesc));
		this.add(getName_orADesc(tblDesc));
		this.add(getId_dep_mpADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_poitmCDesc(tblDesc));
		tblDesc.add(getId_poitmCDesc(tblDesc));
		tblDesc.add(getId_poCDesc(tblDesc));
		tblDesc.add(getId_mmCDesc(tblDesc));
		tblDesc.add(getId_mmpkgu_actualCDesc(tblDesc));
		tblDesc.add(getPri_protocolCDesc(tblDesc));
		tblDesc.add(getPri_poCDesc(tblDesc));
		tblDesc.add(getQuan_poCDesc(tblDesc));
		tblDesc.add(getAmtCDesc(tblDesc));
		tblDesc.add(getQuan_bkCDesc(tblDesc));
		tblDesc.add(getDesCDesc(tblDesc));
		tblDesc.add(getEu_mmcaCDesc(tblDesc));
		tblDesc.add(getId_orCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 采购单明细主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_poitmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_poitm",  getId_poitmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("采购单明细主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 库存采购单属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_poADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_po",  getId_poCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("库存采购单");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 物品属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mm",  getId_mmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("物品");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 包装单位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mmpkgu_actualADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mmpkgu_actual",  getId_mmpkgu_actualCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("包装单位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 协议价属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPri_protocolADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pri_protocol",  getPri_protocolCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("协议价");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 采购价属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPri_poADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pri_po",  getPri_poCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("采购价");
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
	private IAttrDesc getQuan_poADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Quan_po",  getQuan_poCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("数量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 金额属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmtADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt",  getAmtCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("金额");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 现存量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuan_bkADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Quan_bk",  getQuan_bkCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("现存量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 描述属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Des",  getDesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("描述");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 高低值分类属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_mmcaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_mmca",  getEu_mmcaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("高低值分类");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 临床医嘱属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_orADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_or",  getId_orCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("临床医嘱");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 物品编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMm_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mm_code",  getMm_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("物品编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"BD_MM a1b3","id_mm=id_mm","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 物品名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMm_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mm_name",  getMm_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("物品名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"BD_MM a1b3","id_mm=id_mm","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 物品规格属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMm_specADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mm_spec",  getMm_specCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("物品规格");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"BD_MM a1b3","id_mm=id_mm","spec"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 生产厂家名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFactory_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Factory_name",  getFactory_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("生产厂家名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"BD_MM a1b3","id_mm=id_mm","sup_name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 包装单位名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMmpkgunameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mmpkguname",  getMmpkgunameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("包装单位名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"BD_MM_PKGU a1b4","id_mmpkgu_actual=id_mmpkgu","mmpkguname"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医嘱名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_orADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_or",  getName_orCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医嘱名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"ci_order a1b5","id_or=id_or","name_or"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 执行科室属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dep_mpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep_mp",  getId_dep_mpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("执行科室");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"ci_order a1b5","id_or=id_or","id_dep_mp"});
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 获取采购单明细主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_poitmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_poitm");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("采购单明细主键"); 
		return column;
	}
	/**
	 * 获取库存采购单表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_poCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_po");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("库存采购单"); 
		return column;
	}
	/**
	 * 获取物品表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mm");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("物品"); 
		return column;
	}
	/**
	 * 获取包装单位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mmpkgu_actualCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mmpkgu_actual");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("包装单位"); 
		return column;
	}
	/**
	 * 获取协议价表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPri_protocolCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pri_protocol");
		column.setLength(38);
        column.setPrecision(8);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("协议价"); 
		return column;
	}
	/**
	 * 获取采购价表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPri_poCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pri_po");
		column.setLength(38);
        column.setPrecision(8);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("采购价"); 
		return column;
	}
	/**
	 * 获取数量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuan_poCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Quan_po");
		column.setLength(38);
        column.setPrecision(8);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("数量"); 
		return column;
	}
	/**
	 * 获取金额表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmtCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt");
		column.setLength(38);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("金额"); 
		return column;
	}
	/**
	 * 获取现存量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuan_bkCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Quan_bk");
		column.setLength(38);
        column.setPrecision(8);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("现存量"); 
		return column;
	}
	/**
	 * 获取描述表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Des");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("描述"); 
		return column;
	}
	/**
	 * 获取高低值分类表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_mmcaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_mmca");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("高低值分类"); 
		return column;
	}
	/**
	 * 获取临床医嘱表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_orCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_or");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("临床医嘱"); 
		return column;
	}
	/**
	 * 获取物品编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMm_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mm_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("物品编码"); 
		return column;
	}
	/**
	 * 获取物品名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMm_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mm_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("物品名称"); 
		return column;
	}
	/**
	 * 获取物品规格表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMm_specCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mm_spec");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("物品规格"); 
		return column;
	}
	/**
	 * 获取生产厂家名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFactory_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Factory_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("生产厂家名称"); 
		return column;
	}
	/**
	 * 获取包装单位名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMmpkgunameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mmpkguname");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("包装单位名称"); 
		return column;
	}
	/**
	 * 获取医嘱名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_orCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_or");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医嘱名称"); 
		return column;
	}
	/**
	 * 获取执行科室表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dep_mpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep_mp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("执行科室"); 
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
