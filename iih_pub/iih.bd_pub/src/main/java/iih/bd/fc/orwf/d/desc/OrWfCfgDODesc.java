
package iih.bd.fc.orwf.d.desc;

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
 * 流向配置 DO 元数据信息
 */
public class OrWfCfgDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.bd.fc.orwf.d.OrWfCfgDO";
	public static final String CLASS_DISPALYNAME = "流向配置";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "bd_wf_cfg";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_wf_cfg";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public OrWfCfgDODesc(){
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
		this.setKeyDesc(getId_wf_cfgADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_wf_cfgADesc(tblDesc));
		this.add(getId_wfADesc(tblDesc));
		this.add(getSortnoADesc(tblDesc));
		this.add(getFg_macroADesc(tblDesc));
		this.add(getEu_macroADesc(tblDesc));
		this.add(getId_dep_mpADesc(tblDesc));
		this.add(getId_org_mpADesc(tblDesc));
		this.add(getEu_ageADesc(tblDesc));
		this.add(getEu_srvcaADesc(tblDesc));
		this.add(getEu_srvADesc(tblDesc));
		this.add(getEu_dosageADesc(tblDesc));
		this.add(getEu_poisADesc(tblDesc));
		this.add(getEu_mmADesc(tblDesc));
		this.add(getEu_herbperpADesc(tblDesc));
		this.add(getEu_dep_orADesc(tblDesc));
		this.add(getEu_dep_phyADesc(tblDesc));
		this.add(getEu_dep_recordADesc(tblDesc));
		this.add(getEu_dep_nurADesc(tblDesc));
		this.add(getEu_pres_outADesc(tblDesc));
		this.add(getFg_mmwhADesc(tblDesc));
		this.add(getFg_stockADesc(tblDesc));
		this.add(getEu_routeADesc(tblDesc));
		this.add(getEu_weekADesc(tblDesc));
		this.add(getEu_longADesc(tblDesc));
		this.add(getTime_beginADesc(tblDesc));
		this.add(getTime_endADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getName_dep_mpADesc(tblDesc));
		this.add(getName_org_mpADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_wf_cfgCDesc(tblDesc));
		tblDesc.add(getId_wf_cfgCDesc(tblDesc));
		tblDesc.add(getId_wfCDesc(tblDesc));
		tblDesc.add(getSortnoCDesc(tblDesc));
		tblDesc.add(getFg_macroCDesc(tblDesc));
		tblDesc.add(getEu_macroCDesc(tblDesc));
		tblDesc.add(getId_dep_mpCDesc(tblDesc));
		tblDesc.add(getId_org_mpCDesc(tblDesc));
		tblDesc.add(getEu_ageCDesc(tblDesc));
		tblDesc.add(getEu_srvcaCDesc(tblDesc));
		tblDesc.add(getEu_srvCDesc(tblDesc));
		tblDesc.add(getEu_dosageCDesc(tblDesc));
		tblDesc.add(getEu_poisCDesc(tblDesc));
		tblDesc.add(getEu_mmCDesc(tblDesc));
		tblDesc.add(getEu_herbperpCDesc(tblDesc));
		tblDesc.add(getEu_dep_orCDesc(tblDesc));
		tblDesc.add(getEu_dep_phyCDesc(tblDesc));
		tblDesc.add(getEu_dep_recordCDesc(tblDesc));
		tblDesc.add(getEu_dep_nurCDesc(tblDesc));
		tblDesc.add(getEu_pres_outCDesc(tblDesc));
		tblDesc.add(getFg_mmwhCDesc(tblDesc));
		tblDesc.add(getFg_stockCDesc(tblDesc));
		tblDesc.add(getEu_routeCDesc(tblDesc));
		tblDesc.add(getEu_weekCDesc(tblDesc));
		tblDesc.add(getEu_longCDesc(tblDesc));
		tblDesc.add(getTime_beginCDesc(tblDesc));
		tblDesc.add(getTime_endCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 医嘱流向配置属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_wf_cfgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_wf_cfg",  getId_wf_cfgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医嘱流向配置");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医嘱流向属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_wfADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_wf",  getId_wfCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医嘱流向");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 优先级属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSortnoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sortno",  getSortnoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("优先级");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 宏标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_macroADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_macro",  getFg_macroCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("宏标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 宏标志执行科室属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_macroADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_macro",  getEu_macroCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("宏标志执行科室");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
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
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 执行机构属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_org_mpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_org_mp",  getId_org_mpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("执行机构");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 年龄等级属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_ageADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_age",  getEu_ageCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("年龄等级");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 启用服务分类限制属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_srvcaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_srvca",  getEu_srvcaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("启用服务分类限制");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 启用服务限制属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_srvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_srv",  getEu_srvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("启用服务限制");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 启用剂型限制属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_dosageADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_dosage",  getEu_dosageCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("启用剂型限制");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 启用毒麻限制属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_poisADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_pois",  getEu_poisCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("启用毒麻限制");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 启用物品限制属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_mmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_mm",  getEu_mmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("启用物品限制");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 草药制剂限制属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_herbperpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_herbperp",  getEu_herbperpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("草药制剂限制");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 启用开单科室限制属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_dep_orADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_dep_or",  getEu_dep_orCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("启用开单科室限制");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 启用就诊科室限制属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_dep_phyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_dep_phy",  getEu_dep_phyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("启用就诊科室限制");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 启用录入科室限制属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_dep_recordADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_dep_record",  getEu_dep_recordCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("启用录入科室限制");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 启用护理单元限制属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_dep_nurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_dep_nur",  getEu_dep_nurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("启用护理单元限制");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 出院带药属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_pres_outADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_pres_out",  getEu_pres_outCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("出院带药");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 启用仓库限制属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_mmwhADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_mmwh",  getFg_mmwhCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("启用仓库限制");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 启用库存限制属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_stockADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_stock",  getFg_stockCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("启用库存限制");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 用法限制属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_routeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_route",  getEu_routeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("用法限制");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 星期限制属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_weekADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_week",  getEu_weekCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("星期限制");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 周期类型限制属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_longADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_long",  getEu_longCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("周期类型限制");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 开始时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTime_beginADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Time_begin",  getTime_beginCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FTime);
		attrDesc.setLabel("开始时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 结束时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTime_endADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Time_end",  getTime_endCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FTime);
		attrDesc.setLabel("结束时间");
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
	 * 执行科室名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dep_mpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dep_mp",  getName_dep_mpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("执行科室名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b5","id_dep_mp=id_dep","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 机构名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_org_mpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_org_mp",  getName_org_mpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("机构名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_org a0b6","id_org_mp=id_org","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取医嘱流向配置表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_wf_cfgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_wf_cfg");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("医嘱流向配置"); 
		return column;
	}
	/**
	 * 获取医嘱流向表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_wfCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_wf");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医嘱流向"); 
		return column;
	}
	/**
	 * 获取优先级表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSortnoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sortno");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("优先级"); 
		return column;
	}
	/**
	 * 获取宏标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_macroCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_macro");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("宏标志"); 
		return column;
	}
	/**
	 * 获取宏标志执行科室表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_macroCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_macro");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("宏标志执行科室"); 
		return column;
	}
	/**
	 * 获取执行科室表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dep_mpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep_mp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("执行科室"); 
		return column;
	}
	/**
	 * 获取执行机构表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_org_mpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_org_mp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("执行机构"); 
		return column;
	}
	/**
	 * 获取年龄等级表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_ageCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_age");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("年龄等级"); 
		return column;
	}
	/**
	 * 获取启用服务分类限制表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_srvcaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_srvca");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("启用服务分类限制"); 
		return column;
	}
	/**
	 * 获取启用服务限制表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_srvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_srv");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("启用服务限制"); 
		return column;
	}
	/**
	 * 获取启用剂型限制表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_dosageCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_dosage");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("启用剂型限制"); 
		return column;
	}
	/**
	 * 获取启用毒麻限制表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_poisCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_pois");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("启用毒麻限制"); 
		return column;
	}
	/**
	 * 获取启用物品限制表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_mmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_mm");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("启用物品限制"); 
		return column;
	}
	/**
	 * 获取草药制剂限制表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_herbperpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_herbperp");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("草药制剂限制"); 
		return column;
	}
	/**
	 * 获取启用开单科室限制表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_dep_orCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_dep_or");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("启用开单科室限制"); 
		return column;
	}
	/**
	 * 获取启用就诊科室限制表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_dep_phyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_dep_phy");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("启用就诊科室限制"); 
		return column;
	}
	/**
	 * 获取启用录入科室限制表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_dep_recordCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_dep_record");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("启用录入科室限制"); 
		return column;
	}
	/**
	 * 获取启用护理单元限制表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_dep_nurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_dep_nur");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("启用护理单元限制"); 
		return column;
	}
	/**
	 * 获取出院带药表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_pres_outCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_pres_out");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("出院带药"); 
		return column;
	}
	/**
	 * 获取启用仓库限制表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_mmwhCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_mmwh");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("启用仓库限制"); 
		return column;
	}
	/**
	 * 获取启用库存限制表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_stockCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_stock");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("启用库存限制"); 
		return column;
	}
	/**
	 * 获取用法限制表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_routeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_route");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("用法限制"); 
		return column;
	}
	/**
	 * 获取星期限制表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_weekCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_week");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("星期限制"); 
		return column;
	}
	/**
	 * 获取周期类型限制表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_longCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_long");
		column.setLength(20);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("周期类型限制"); 
		return column;
	}
	/**
	 * 获取开始时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTime_beginCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Time_begin");
		column.setLength(8);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("开始时间"); 
		return column;
	}
	/**
	 * 获取结束时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTime_endCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Time_end");
		column.setLength(8);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("结束时间"); 
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
	 * 获取执行科室名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_dep_mpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dep_mp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("执行科室名称"); 
		return column;
	}
	/**
	 * 获取机构名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_org_mpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_org_mp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("机构名称"); 
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
