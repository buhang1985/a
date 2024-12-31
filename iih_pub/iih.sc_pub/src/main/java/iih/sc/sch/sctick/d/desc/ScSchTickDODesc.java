
package iih.sc.sch.sctick.d.desc;

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
 * 计划排班_号位 DO 元数据信息
 */
public class ScSchTickDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.sc.sch.sctick.d.ScSchTickDO";
	public static final String CLASS_DISPALYNAME = "计划排班_号位";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "sc_tick";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_tick";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public ScSchTickDODesc(){
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
		this.setKeyDesc(getId_tickADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_tickADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_schADesc(tblDesc));
		this.add(getId_ticksADesc(tblDesc));
		this.add(getCodeADesc(tblDesc));
		this.add(getNameADesc(tblDesc));
		this.add(getQuenoADesc(tblDesc));
		this.add(getT_bADesc(tblDesc));
		this.add(getT_eADesc(tblDesc));
		this.add(getEu_usedADesc(tblDesc));
		this.add(getEu_usescopeADesc(tblDesc));
		this.add(getFg_activeADesc(tblDesc));
		this.add(getEu_addADesc(tblDesc));
		this.add(getId_scsrvADesc(tblDesc));
		this.add(getPolno_usedADesc(tblDesc));
		this.add(getId_tick_occupierADesc(tblDesc));
		this.add(getPrjfld1ADesc(tblDesc));
		this.add(getPrjfld2ADesc(tblDesc));
		this.add(getPrjfld3ADesc(tblDesc));
		this.add(getPrjfld4ADesc(tblDesc));
		this.add(getPrjfld5ADesc(tblDesc));
		this.add(getPrjfld6ADesc(tblDesc));
		this.add(getFg_addADesc(tblDesc));
		this.add(getId_reserve_rsnADesc(tblDesc));
		this.add(getSd_reserve_rsnADesc(tblDesc));
		this.add(getNote_reserveADesc(tblDesc));
		this.add(getIds_scchlADesc(tblDesc));
		this.add(getPolnoADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getIds_kinditmADesc(tblDesc));
		this.add(getName_srvADesc(tblDesc));
		this.add(getCode_scchlADesc(tblDesc));
		this.add(getName_scchlADesc(tblDesc));
		this.add(getCode_kinditmADesc(tblDesc));
		this.add(getName_kinditmADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_tickCDesc(tblDesc));
		tblDesc.add(getId_tickCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_schCDesc(tblDesc));
		tblDesc.add(getId_ticksCDesc(tblDesc));
		tblDesc.add(getCodeCDesc(tblDesc));
		tblDesc.add(getNameCDesc(tblDesc));
		tblDesc.add(getQuenoCDesc(tblDesc));
		tblDesc.add(getT_bCDesc(tblDesc));
		tblDesc.add(getT_eCDesc(tblDesc));
		tblDesc.add(getEu_usedCDesc(tblDesc));
		tblDesc.add(getEu_usescopeCDesc(tblDesc));
		tblDesc.add(getFg_activeCDesc(tblDesc));
		tblDesc.add(getEu_addCDesc(tblDesc));
		tblDesc.add(getId_scsrvCDesc(tblDesc));
		tblDesc.add(getPolno_usedCDesc(tblDesc));
		tblDesc.add(getId_tick_occupierCDesc(tblDesc));
		tblDesc.add(getPrjfld1CDesc(tblDesc));
		tblDesc.add(getPrjfld2CDesc(tblDesc));
		tblDesc.add(getPrjfld3CDesc(tblDesc));
		tblDesc.add(getPrjfld4CDesc(tblDesc));
		tblDesc.add(getPrjfld5CDesc(tblDesc));
		tblDesc.add(getPrjfld6CDesc(tblDesc));
		tblDesc.add(getFg_addCDesc(tblDesc));
		tblDesc.add(getId_reserve_rsnCDesc(tblDesc));
		tblDesc.add(getSd_reserve_rsnCDesc(tblDesc));
		tblDesc.add(getNote_reserveCDesc(tblDesc));
		tblDesc.add(getIds_scchlCDesc(tblDesc));
		tblDesc.add(getPolnoCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		tblDesc.add(getIds_kinditmCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 号位ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_tickADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_tick",  getId_tickCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("号位ID");
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
	 * 排班属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_schADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_sch",  getId_schCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("排班");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 号段id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ticksADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ticks",  getId_ticksCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("号段id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 号位编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code",  getCodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("号位编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 号位名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name",  getNameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("号位名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 票号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuenoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Queno",  getQuenoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("票号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 预计开始时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getT_bADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("T_b",  getT_bCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FTime);
		attrDesc.setLabel("预计开始时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 预计结束时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getT_eADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("T_e",  getT_eCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FTime);
		attrDesc.setLabel("预计结束时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 已使用标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_usedADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_used",  getEu_usedCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("已使用标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 可使用范围属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_usescopeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_usescope",  getEu_usescopeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("可使用范围");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 启用标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_activeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_active",  getFg_activeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("启用标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 加号类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_addADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_add",  getEu_addCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("加号类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 排班服务属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_scsrvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_scsrv",  getId_scsrvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("排班服务");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 使用号源池号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPolno_usedADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Polno_used",  getPolno_usedCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("使用号源池号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 占用者属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_tick_occupierADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_tick_occupier",  getId_tick_occupierCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("占用者");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 客开扩展字段1属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPrjfld1ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Prjfld1",  getPrjfld1CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客开扩展字段1");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客开扩展字段2属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPrjfld2ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Prjfld2",  getPrjfld2CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客开扩展字段2");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客开扩展字段3属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPrjfld3ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Prjfld3",  getPrjfld3CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客开扩展字段3");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客开扩展字段4属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPrjfld4ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Prjfld4",  getPrjfld4CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客开扩展字段4");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客开扩展字段5属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPrjfld5ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Prjfld5",  getPrjfld5CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客开扩展字段5");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客开扩展字段6属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPrjfld6ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Prjfld6",  getPrjfld6CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客开扩展字段6");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 加号标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_addADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_add",  getFg_addCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("加号标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 保留原因类型id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_reserve_rsnADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_reserve_rsn",  getId_reserve_rsnCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("保留原因类型id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 保留原因类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_reserve_rsnADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_reserve_rsn",  getSd_reserve_rsnCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("保留原因类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 保留说明属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNote_reserveADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Note_reserve",  getNote_reserveCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("保留说明");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 使用渠道属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIds_scchlADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ids_scchl",  getIds_scchlCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("使用渠道");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 使用号源池属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPolnoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Polno",  getPolnoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("使用号源池");
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
	 * 可使用类别细目属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIds_kinditmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ids_kinditm",  getIds_kinditmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("可使用类别细目");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 排班服务名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_srvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_srv",  getName_srvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("排班服务名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sc_srv a0b6","id_scsrv=id_scsrv","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 预约渠道编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_scchlADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_scchl",  getCode_scchlCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("预约渠道编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sc_chl a0b9","ids_scchl=id_scchl","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 预约渠道名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_scchlADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_scchl",  getName_scchlCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("预约渠道名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sc_chl a0b9","ids_scchl=id_scchl","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_kinditmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_kinditm",  getCode_kinditmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sc_srv_kind_itm a0b12","ids_kinditm=id_scsrvkinditm","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_kinditmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_kinditm",  getName_kinditmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sc_srv_kind_itm a0b12","ids_kinditm=id_scsrvkinditm","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取号位ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_tickCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_tick");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("号位ID"); 
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
	 * 获取排班表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_schCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_sch");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("排班"); 
		return column;
	}
	/**
	 * 获取号段id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ticksCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ticks");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("号段id"); 
		return column;
	}
	/**
	 * 获取号位编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("号位编码"); 
		return column;
	}
	/**
	 * 获取号位名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("号位名称"); 
		return column;
	}
	/**
	 * 获取票号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuenoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Queno");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("票号"); 
		return column;
	}
	/**
	 * 获取预计开始时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getT_bCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"T_b");
		column.setLength(8);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("预计开始时间"); 
		return column;
	}
	/**
	 * 获取预计结束时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getT_eCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"T_e");
		column.setLength(8);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("预计结束时间"); 
		return column;
	}
	/**
	 * 获取已使用标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_usedCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_used");
		column.setLength(20);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("已使用标志"); 
		return column;
	}
	/**
	 * 获取可使用范围表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_usescopeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_usescope");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("可使用范围"); 
		return column;
	}
	/**
	 * 获取启用标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_activeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_active");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("启用标志"); 
		return column;
	}
	/**
	 * 获取加号类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_addCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_add");
		column.setLength(1);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("加号类型"); 
		return column;
	}
	/**
	 * 获取排班服务表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_scsrvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_scsrv");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("排班服务"); 
		return column;
	}
	/**
	 * 获取使用号源池号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPolno_usedCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Polno_used");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("使用号源池号"); 
		return column;
	}
	/**
	 * 获取占用者表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_tick_occupierCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_tick_occupier");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("占用者"); 
		return column;
	}
	/**
	 * 获取客开扩展字段1表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPrjfld1CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Prjfld1");
		column.setLength(256);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客开扩展字段1"); 
		return column;
	}
	/**
	 * 获取客开扩展字段2表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPrjfld2CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Prjfld2");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客开扩展字段2"); 
		return column;
	}
	/**
	 * 获取客开扩展字段3表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPrjfld3CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Prjfld3");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客开扩展字段3"); 
		return column;
	}
	/**
	 * 获取客开扩展字段4表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPrjfld4CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Prjfld4");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客开扩展字段4"); 
		return column;
	}
	/**
	 * 获取客开扩展字段5表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPrjfld5CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Prjfld5");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客开扩展字段5"); 
		return column;
	}
	/**
	 * 获取客开扩展字段6表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPrjfld6CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Prjfld6");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客开扩展字段6"); 
		return column;
	}
	/**
	 * 获取加号标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_addCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_add");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("加号标识"); 
		return column;
	}
	/**
	 * 获取保留原因类型id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_reserve_rsnCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_reserve_rsn");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("保留原因类型id"); 
		return column;
	}
	/**
	 * 获取保留原因类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_reserve_rsnCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_reserve_rsn");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("保留原因类型编码"); 
		return column;
	}
	/**
	 * 获取保留说明表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNote_reserveCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Note_reserve");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("保留说明"); 
		return column;
	}
	/**
	 * 获取使用渠道表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIds_scchlCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ids_scchl");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("使用渠道"); 
		return column;
	}
	/**
	 * 获取使用号源池表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPolnoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Polno");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("使用号源池"); 
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
	 * 获取可使用类别细目表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIds_kinditmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ids_kinditm");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("可使用类别细目"); 
		return column;
	}
	/**
	 * 获取排班服务名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_srvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_srv");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("排班服务名称"); 
		return column;
	}
	/**
	 * 获取预约渠道编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_scchlCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_scchl");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("预约渠道编码"); 
		return column;
	}
	/**
	 * 获取预约渠道名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_scchlCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_scchl");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("预约渠道名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_kinditmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_kinditm");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_kinditmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_kinditm");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id_org","Id_org");
		iBDDataInfoFldMap.put("id_group","Id_grp");
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
	}
	
}
