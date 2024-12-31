
package iih.bd.mm.autoreplenishconfigure.d.desc;

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
 * 自动补货配置 DO 元数据信息
 */
public class AutoReplenishConfigureDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.bd.mm.autoreplenishconfigure.d.AutoReplenishConfigureDO";
	public static final String CLASS_DISPALYNAME = "自动补货配置";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "mm_addst_cfg";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_addstrec";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public AutoReplenishConfigureDODesc(){
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
		this.setKeyDesc(getId_addstrecADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_addstrecADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_groupADesc(tblDesc));
		this.add(getId_whADesc(tblDesc));
		this.add(getId_mmADesc(tblDesc));
		this.add(getD_handleADesc(tblDesc));
		this.add(getDt_handleADesc(tblDesc));
		this.add(getId_reptpADesc(tblDesc));
		this.add(getId_strategyADesc(tblDesc));
		this.add(getDt_repADesc(tblDesc));
		this.add(getFg_activeADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getOrg_nameADesc(tblDesc));
		this.add(getGrp_nameADesc(tblDesc));
		this.add(getWh_codeADesc(tblDesc));
		this.add(getWh_nameADesc(tblDesc));
		this.add(getMm_specADesc(tblDesc));
		this.add(getMm_nameADesc(tblDesc));
		this.add(getMm_codeADesc(tblDesc));
		this.add(getSup_nameADesc(tblDesc));
		this.add(getMm_pycodeADesc(tblDesc));
		this.add(getName_unit_pkgspADesc(tblDesc));
		this.add(getReptp_nameADesc(tblDesc));
		this.add(getReptp_codeADesc(tblDesc));
		this.add(getStrategy_nameADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_addstrecCDesc(tblDesc));
		tblDesc.add(getId_addstrecCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_groupCDesc(tblDesc));
		tblDesc.add(getId_whCDesc(tblDesc));
		tblDesc.add(getId_mmCDesc(tblDesc));
		tblDesc.add(getD_handleCDesc(tblDesc));
		tblDesc.add(getDt_handleCDesc(tblDesc));
		tblDesc.add(getId_reptpCDesc(tblDesc));
		tblDesc.add(getId_strategyCDesc(tblDesc));
		tblDesc.add(getDt_repCDesc(tblDesc));
		tblDesc.add(getFg_activeCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 配置ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_addstrecADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_addstrec",  getId_addstrecCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("配置ID");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 组织属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_orgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_org",  getId_orgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("组织");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 集团属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_groupADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_group",  getId_groupCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("集团");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 仓库属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_whADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_wh",  getId_whCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("仓库");
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
	 * 处理日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getD_handleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("D_handle",  getD_handleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("处理日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 处理时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_handleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_handle",  getDt_handleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FTime);
		attrDesc.setLabel("处理时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 补货类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_reptpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_reptp",  getId_reptpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("补货类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 补货策略属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_strategyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_strategy",  getId_strategyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("补货策略");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 补货日属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_repADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_rep",  getDt_repCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("补货日");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 启用状态属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_activeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_active",  getFg_activeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("启用状态");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 创建人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCreatedbyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Createdby",  getCreatedbyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("创建人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 创建时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCreatedtimeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Createdtime",  getCreatedtimeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("创建时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 最后修改人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getModifiedbyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Modifiedby",  getModifiedbyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("最后修改人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 最后修改时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getModifiedtimeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Modifiedtime",  getModifiedtimeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("最后修改时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 组织名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOrg_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Org_name",  getOrg_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("组织名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_org a0b6","id_org=id_org","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getGrp_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Grp_name",  getGrp_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_grp a0b7","id_group=id_grp","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 仓库编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWh_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Wh_code",  getWh_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("仓库编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_wh a0b2","id_wh=id_wh","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 仓库名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWh_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Wh_name",  getWh_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("仓库名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_wh a0b2","id_wh=id_wh","name"});
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
		attrDesc.setRefTblInfos(new String[]{"BD_MM a0b3","id_mm=id_mm","spec"});
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
		attrDesc.setRefTblInfos(new String[]{"BD_MM a0b3","id_mm=id_mm","name"});
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
		attrDesc.setRefTblInfos(new String[]{"BD_MM a0b3","id_mm=id_mm","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 生产厂家名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSup_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sup_name",  getSup_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("生产厂家名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"BD_MM a0b3","id_mm=id_mm","sup_name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 物品拼音属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMm_pycodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mm_pycode",  getMm_pycodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("物品拼音");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"BD_MM a0b3","id_mm=id_mm","pycode"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 零售包装单位名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_unit_pkgspADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_unit_pkgsp",  getName_unit_pkgspCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("零售包装单位名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"BD_MM a0b3","id_mm=id_mm","name_unit_pkgsp"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 补货类型名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getReptp_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Reptp_name",  getReptp_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("补货类型名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b4","id_reptp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 补货类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getReptp_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Reptp_code",  getReptp_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("补货类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b4","id_reptp=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 策略名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getStrategy_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Strategy_name",  getStrategy_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("策略名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"MM_PL_Strategy a0b5","id_strategy=id_strategy","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取配置ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_addstrecCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_addstrec");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("配置ID"); 
		return column;
	}
	/**
	 * 获取组织表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_orgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_org");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("组织"); 
		return column;
	}
	/**
	 * 获取集团表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_groupCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_group");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("集团"); 
		return column;
	}
	/**
	 * 获取仓库表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_whCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_wh");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("仓库"); 
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
	 * 获取处理日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getD_handleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"D_handle");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("处理日期"); 
		return column;
	}
	/**
	 * 获取处理时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_handleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_handle");
		column.setLength(8);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("处理时间"); 
		return column;
	}
	/**
	 * 获取补货类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_reptpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_reptp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("补货类型"); 
		return column;
	}
	/**
	 * 获取补货策略表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_strategyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_strategy");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("补货策略"); 
		return column;
	}
	/**
	 * 获取补货日表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_repCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_rep");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("补货日"); 
		return column;
	}
	/**
	 * 获取启用状态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_activeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_active");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("启用状态"); 
		return column;
	}
	/**
	 * 获取创建人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCreatedbyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Createdby");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("创建人"); 
		return column;
	}
	/**
	 * 获取创建时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCreatedtimeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Createdtime");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("创建时间"); 
		return column;
	}
	/**
	 * 获取最后修改人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getModifiedbyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Modifiedby");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("最后修改人"); 
		return column;
	}
	/**
	 * 获取最后修改时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getModifiedtimeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Modifiedtime");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("最后修改时间"); 
		return column;
	}
	/**
	 * 获取组织名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOrg_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Org_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("组织名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getGrp_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Grp_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取仓库编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWh_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Wh_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("仓库编码"); 
		return column;
	}
	/**
	 * 获取仓库名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWh_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Wh_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("仓库名称"); 
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
	 * 获取生产厂家名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSup_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sup_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("生产厂家名称"); 
		return column;
	}
	/**
	 * 获取物品拼音表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMm_pycodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mm_pycode");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("物品拼音"); 
		return column;
	}
	/**
	 * 获取零售包装单位名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_unit_pkgspCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_unit_pkgsp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("零售包装单位名称"); 
		return column;
	}
	/**
	 * 获取补货类型名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getReptp_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Reptp_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("补货类型名称"); 
		return column;
	}
	/**
	 * 获取补货类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getReptp_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Reptp_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("补货类型编码"); 
		return column;
	}
	/**
	 * 获取策略名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getStrategy_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Strategy_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("策略名称"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id","Id_addstrec");
		iBDDataInfoFldMap.put("id_org","Id_org");
		iBDDataInfoFldMap.put("id_group","Id_group");
	}

	/**
	 * 设置实体审计信息数据映射关系 
	 */
	private void setIAuditInfoFldMap(){
		iAuditInfoFldMap=new HashMap<String, String>();
		iAuditInfoFldMap.put("createdby","Createdby");
		iAuditInfoFldMap.put("createdtime","Createdtime");
		iAuditInfoFldMap.put("modifiedby","Modifiedby");
		iAuditInfoFldMap.put("modifiedtime","Modifiedtime");
	}
	
	/**
	 * 设置实体默认值
	 */
	private void setDefaultValueMap(){
		defaultValueMap=new HashMap<String, Object>();
		defaultValueMap.put("Fg_active",new xap.mw.coreitf.d.FBoolean("Y"));
	}
	
}
