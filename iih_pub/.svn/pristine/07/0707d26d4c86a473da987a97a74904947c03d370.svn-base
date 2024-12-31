
package iih.mm.pl.poplanstrategy.d.desc;

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
 * 采购计划计算策略 DO 元数据信息
 */
public class PoPlanStrategyDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.mm.pl.poplanstrategy.d.PoPlanStrategyDO";
	public static final String CLASS_DISPALYNAME = "采购计划计算策略";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "MM_PL_Strategy";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_strategy";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public PoPlanStrategyDODesc(){
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
		this.setKeyDesc(getId_strategyADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_strategyADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getNameADesc(tblDesc));
		this.add(getId_whADesc(tblDesc));
		this.add(getRuleout_drugstorageADesc(tblDesc));
		this.add(getRuleout_allstorageADesc(tblDesc));
		this.add(getRuleout_drugusestorageADesc(tblDesc));
		this.add(getRuleout_allusestorageADesc(tblDesc));
		this.add(getDays_avguseADesc(tblDesc));
		this.add(getDays_poplanADesc(tblDesc));
		this.add(getPosuptypeADesc(tblDesc));
		this.add(getFg_zeroADesc(tblDesc));
		this.add(getId_whtpADesc(tblDesc));
		this.add(getId_wh_rangeADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getFg_chklowstnumADesc(tblDesc));
		this.add(getSd_quancaltp_plADesc(tblDesc));
		this.add(getFg_defaultADesc(tblDesc));
		this.add(getGroup_nameADesc(tblDesc));
		this.add(getOrg_nameADesc(tblDesc));
		this.add(getWh_nameADesc(tblDesc));
		this.add(getWhtp_nameADesc(tblDesc));
		this.add(getWh_range_nameADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_strategyCDesc(tblDesc));
		tblDesc.add(getId_strategyCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getNameCDesc(tblDesc));
		tblDesc.add(getId_whCDesc(tblDesc));
		tblDesc.add(getRuleout_drugstorageCDesc(tblDesc));
		tblDesc.add(getRuleout_allstorageCDesc(tblDesc));
		tblDesc.add(getRuleout_drugusestorageCDesc(tblDesc));
		tblDesc.add(getRuleout_allusestorageCDesc(tblDesc));
		tblDesc.add(getDays_avguseCDesc(tblDesc));
		tblDesc.add(getDays_poplanCDesc(tblDesc));
		tblDesc.add(getPosuptypeCDesc(tblDesc));
		tblDesc.add(getFg_zeroCDesc(tblDesc));
		tblDesc.add(getId_whtpCDesc(tblDesc));
		tblDesc.add(getId_wh_rangeCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		tblDesc.add(getFg_chklowstnumCDesc(tblDesc));
		tblDesc.add(getSd_quancaltp_plCDesc(tblDesc));
		tblDesc.add(getFg_defaultCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 策略主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_strategyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_strategy",  getId_strategyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("策略主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 集团属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_grpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_grp",  getId_grpCDesc(tblDesc), this);
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
	 * 机构属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_orgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_org",  getId_orgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("机构");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 策略名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name",  getNameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("策略名称");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
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
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 药库库存属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRuleout_drugstorageADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ruleout_drugstorage",  getRuleout_drugstorageCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("药库库存");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 全院库存属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRuleout_allstorageADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ruleout_allstorage",  getRuleout_allstorageCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("全院库存");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 药库可用量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRuleout_drugusestorageADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ruleout_drugusestorage",  getRuleout_drugusestorageCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("药库可用量");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 全院可用量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRuleout_allusestorageADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ruleout_allusestorage",  getRuleout_allusestorageCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("全院可用量");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 平均消耗天数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDays_avguseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Days_avguse",  getDays_avguseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("平均消耗天数");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 计划采购天数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDays_poplanADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Days_poplan",  getDays_poplanCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("计划采购天数");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 采购供应商类别属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPosuptypeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Posuptype",  getPosuptypeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("采购供应商类别");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否过滤计算量为0属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_zeroADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_zero",  getFg_zeroCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否过滤计算量为0");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 仓库类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_whtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_whtp",  getId_whtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("仓库类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 仓库范围属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_wh_rangeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_wh_range",  getId_wh_rangeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("仓库范围");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
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
	 * 校验最低库存属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_chklowstnumADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_chklowstnum",  getFg_chklowstnumCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("校验最低库存");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 采购量计算方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_quancaltp_plADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_quancaltp_pl",  getSd_quancaltp_plCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("采购量计算方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 默认标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_defaultADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_default",  getFg_defaultCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("默认标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 集团名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getGroup_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Group_name",  getGroup_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("集团名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_grp a0b5","id_grp=id_grp","name"});
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
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWhtp_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Whtp_name",  getWhtp_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b3","id_whtp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 仓库名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWh_range_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Wh_range_name",  getWh_range_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("仓库名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_wh a0b4","id_wh_range=id_wh","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取策略主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_strategyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_strategy");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("策略主键"); 
		return column;
	}
	/**
	 * 获取集团表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_grpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_grp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("集团"); 
		return column;
	}
	/**
	 * 获取机构表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_orgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_org");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("机构"); 
		return column;
	}
	/**
	 * 获取策略名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("策略名称"); 
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
	 * 获取药库库存表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRuleout_drugstorageCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ruleout_drugstorage");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("药库库存"); 
		return column;
	}
	/**
	 * 获取全院库存表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRuleout_allstorageCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ruleout_allstorage");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("全院库存"); 
		return column;
	}
	/**
	 * 获取药库可用量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRuleout_drugusestorageCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ruleout_drugusestorage");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("药库可用量"); 
		return column;
	}
	/**
	 * 获取全院可用量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRuleout_allusestorageCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ruleout_allusestorage");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("全院可用量"); 
		return column;
	}
	/**
	 * 获取平均消耗天数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDays_avguseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Days_avguse");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("平均消耗天数"); 
		return column;
	}
	/**
	 * 获取计划采购天数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDays_poplanCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Days_poplan");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("计划采购天数"); 
		return column;
	}
	/**
	 * 获取采购供应商类别表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPosuptypeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Posuptype");
		column.setLength(1);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("采购供应商类别"); 
		return column;
	}
	/**
	 * 获取是否过滤计算量为0表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_zeroCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_zero");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否过滤计算量为0"); 
		return column;
	}
	/**
	 * 获取仓库类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_whtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_whtp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("仓库类型"); 
		return column;
	}
	/**
	 * 获取仓库范围表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_wh_rangeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_wh_range");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("仓库范围"); 
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
	 * 获取校验最低库存表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_chklowstnumCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_chklowstnum");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("校验最低库存"); 
		return column;
	}
	/**
	 * 获取采购量计算方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_quancaltp_plCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_quancaltp_pl");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("采购量计算方式"); 
		return column;
	}
	/**
	 * 获取默认标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_defaultCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_default");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("默认标识"); 
		return column;
	}
	/**
	 * 获取集团名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getGroup_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Group_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("集团名称"); 
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
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWhtp_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Whtp_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取仓库名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWh_range_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Wh_range_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("仓库名称"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
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
		defaultValueMap.put("Ruleout_drugstorage",new xap.mw.coreitf.d.FBoolean("N"));
		defaultValueMap.put("Ruleout_allstorage",new xap.mw.coreitf.d.FBoolean("N"));
		defaultValueMap.put("Ruleout_drugusestorage",new xap.mw.coreitf.d.FBoolean("N"));
		defaultValueMap.put("Ruleout_allusestorage",new xap.mw.coreitf.d.FBoolean("N"));
		defaultValueMap.put("Days_avguse",120);
		defaultValueMap.put("Days_poplan",30);
		defaultValueMap.put("Posuptype",1);
		defaultValueMap.put("Fg_zero",new xap.mw.coreitf.d.FBoolean("N"));
		defaultValueMap.put("Fg_chklowstnum",new xap.mw.coreitf.d.FBoolean("N"));
		defaultValueMap.put("Sd_quancaltp_pl","3");
		defaultValueMap.put("Fg_default",new xap.mw.coreitf.d.FBoolean("N"));
	}
	
}
