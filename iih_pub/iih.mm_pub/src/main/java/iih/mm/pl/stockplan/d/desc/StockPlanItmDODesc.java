
package iih.mm.pl.stockplan.d.desc;

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
 * 库存计划明细 DO 元数据信息
 */
public class StockPlanItmDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.mm.pl.stockplan.d.StockPlanItmDO";
	public static final String CLASS_DISPALYNAME = "库存计划明细";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "MM_PL_ITM";
	public static final String TABLE_ALIAS_NAME = "a1";
	public static final String PRIMARYKEY_FIELDNAME="Id_plitm";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public StockPlanItmDODesc(){
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
		this.setKeyDesc(getId_plitmADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_plADesc(tblDesc));
		this.add(getId_plitmADesc(tblDesc));
		this.add(getId_plADesc(tblDesc));
		this.add(getSortnoADesc(tblDesc));
		this.add(getId_mmADesc(tblDesc));
		this.add(getFg_poADesc(tblDesc));
		this.add(getId_poADesc(tblDesc));
		this.add(getId_poitmADesc(tblDesc));
		this.add(getQuan_pl_baseADesc(tblDesc));
		this.add(getQuan_pl_actualADesc(tblDesc));
		this.add(getId_mmpkgu_baseADesc(tblDesc));
		this.add(getId_mmpkgu_actualADesc(tblDesc));
		this.add(getPri_actADesc(tblDesc));
		this.add(getAmtADesc(tblDesc));
		this.add(getFactorADesc(tblDesc));
		this.add(getId_supADesc(tblDesc));
		this.add(getDate_reqrADesc(tblDesc));
		this.add(getDesADesc(tblDesc));
		this.add(getMm_specADesc(tblDesc));
		this.add(getMm_nameADesc(tblDesc));
		this.add(getFactory_nameADesc(tblDesc));
		this.add(getMm_pycodeADesc(tblDesc));
		this.add(getMm_codeADesc(tblDesc));
		this.add(getId_srvADesc(tblDesc));
		this.add(getMm_apprnoADesc(tblDesc));
		this.add(getMmpkgunameADesc(tblDesc));
		this.add(getSup_nameADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_plitmCDesc(tblDesc));
		tblDesc.add(getId_plitmCDesc(tblDesc));
		tblDesc.add(getId_plCDesc(tblDesc));
		tblDesc.add(getSortnoCDesc(tblDesc));
		tblDesc.add(getId_mmCDesc(tblDesc));
		tblDesc.add(getFg_poCDesc(tblDesc));
		tblDesc.add(getId_poCDesc(tblDesc));
		tblDesc.add(getId_poitmCDesc(tblDesc));
		tblDesc.add(getQuan_pl_baseCDesc(tblDesc));
		tblDesc.add(getQuan_pl_actualCDesc(tblDesc));
		tblDesc.add(getId_mmpkgu_baseCDesc(tblDesc));
		tblDesc.add(getId_mmpkgu_actualCDesc(tblDesc));
		tblDesc.add(getPri_actCDesc(tblDesc));
		tblDesc.add(getAmtCDesc(tblDesc));
		tblDesc.add(getFactorCDesc(tblDesc));
		tblDesc.add(getId_supCDesc(tblDesc));
		tblDesc.add(getDate_reqrCDesc(tblDesc));
		tblDesc.add(getDesCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 库存计划明细主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_plitmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_plitm",  getId_plitmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("库存计划明细主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 库存计划属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_plADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pl",  getId_plCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("库存计划");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 序号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSortnoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sortno",  getSortnoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("序号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
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
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 采购单生成标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_poADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_po",  getFg_poCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("采购单生成标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 对应采购单属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_poADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_po",  getId_poCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("对应采购单");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 对应采购单明细属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_poitmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_poitm",  getId_poitmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("对应采购单明细");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 计划/采购数量_基本属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuan_pl_baseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Quan_pl_base",  getQuan_pl_baseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("计划/采购数量_基本");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 计划/采购数量_实际属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuan_pl_actualADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Quan_pl_actual",  getQuan_pl_actualCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("计划/采购数量_实际");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 基本包装单位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mmpkgu_baseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mmpkgu_base",  getId_mmpkgu_baseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("基本包装单位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 实际包装单位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mmpkgu_actualADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mmpkgu_actual",  getId_mmpkgu_actualCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("实际包装单位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 入库价_实际单位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPri_actADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pri_act",  getPri_actCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("入库价_实际单位");
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
	 * 换算系数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFactorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Factor",  getFactorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("换算系数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 供应商属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_supADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_sup",  getId_supCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("供应商");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 需要日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDate_reqrADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Date_reqr",  getDate_reqrCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("需要日期");
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
		attrDesc.setRefTblInfos(new String[]{"BD_MM a1b2","id_mm=id_mm","spec"});
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
		attrDesc.setRefTblInfos(new String[]{"BD_MM a1b2","id_mm=id_mm","name"});
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
		attrDesc.setRefTblInfos(new String[]{"BD_MM a1b2","id_mm=id_mm","sup_name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 拼音属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMm_pycodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mm_pycode",  getMm_pycodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("拼音");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"BD_MM a1b2","id_mm=id_mm","pycode"});
		attrDesc.setRefType(false);
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
		attrDesc.setRefTblInfos(new String[]{"BD_MM a1b2","id_mm=id_mm","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 服务项目外键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_srvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_srv",  getId_srvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务项目外键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"BD_MM a1b2","id_mm=id_mm","id_srv"});
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 当前批准文号/注册号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMm_apprnoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mm_apprno",  getMm_apprnoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("当前批准文号/注册号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"BD_MM a1b2","id_mm=id_mm","apprno"});
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
		attrDesc.setRefTblInfos(new String[]{"BD_MM_PKGU a1b8","id_mmpkgu_actual=id_mmpkgu","mmpkguname"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 供应商与厂商名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSup_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sup_name",  getSup_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("供应商与厂商名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"BD_SUP a1b9","id_sup=id_sup","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取库存计划明细主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_plitmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_plitm");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("库存计划明细主键"); 
		return column;
	}
	/**
	 * 获取库存计划表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_plCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pl");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("库存计划"); 
		return column;
	}
	/**
	 * 获取序号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSortnoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sortno");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("序号"); 
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
	 * 获取采购单生成标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_poCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_po");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("采购单生成标志"); 
		return column;
	}
	/**
	 * 获取对应采购单表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_poCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_po");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("对应采购单"); 
		return column;
	}
	/**
	 * 获取对应采购单明细表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_poitmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_poitm");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("对应采购单明细"); 
		return column;
	}
	/**
	 * 获取计划/采购数量_基本表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuan_pl_baseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Quan_pl_base");
		column.setLength(38);
        column.setPrecision(8);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("计划/采购数量_基本"); 
		return column;
	}
	/**
	 * 获取计划/采购数量_实际表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuan_pl_actualCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Quan_pl_actual");
		column.setLength(38);
        column.setPrecision(8);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("计划/采购数量_实际"); 
		return column;
	}
	/**
	 * 获取基本包装单位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mmpkgu_baseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mmpkgu_base");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("基本包装单位"); 
		return column;
	}
	/**
	 * 获取实际包装单位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mmpkgu_actualCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mmpkgu_actual");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("实际包装单位"); 
		return column;
	}
	/**
	 * 获取入库价_实际单位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPri_actCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pri_act");
		column.setLength(38);
        column.setPrecision(8);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("入库价_实际单位"); 
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
	 * 获取换算系数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFactorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Factor");
		column.setLength(16);
        column.setPrecision(8);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("换算系数"); 
		return column;
	}
	/**
	 * 获取供应商表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_supCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_sup");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("供应商"); 
		return column;
	}
	/**
	 * 获取需要日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDate_reqrCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Date_reqr");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("需要日期"); 
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
	 * 获取拼音表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMm_pycodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mm_pycode");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("拼音"); 
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
	 * 获取服务项目外键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_srvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_srv");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务项目外键"); 
		return column;
	}
	/**
	 * 获取当前批准文号/注册号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMm_apprnoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mm_apprno");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("当前批准文号/注册号"); 
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
	 * 获取供应商与厂商名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSup_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sup_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("供应商与厂商名称"); 
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
		defaultValueMap.put("Fg_po",new xap.mw.coreitf.d.FBoolean("N"));
	}
	
}
