
package iih.bd.fc.wf.d.desc;

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
 * 流程配置_流向科室 DO 元数据信息
 */
public class WfDepDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.bd.fc.wf.d.WfDepDO";
	public static final String CLASS_DISPALYNAME = "流程配置_流向科室";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "BD_WF_DEP";
	public static final String TABLE_ALIAS_NAME = "a2";
	public static final String PRIMARYKEY_FIELDNAME="Id_wfdep";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public WfDepDODesc(){
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
		this.setKeyDesc(getId_wfdepADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_wfADesc(tblDesc));
		this.add(getId_wfdepADesc(tblDesc));
		this.add(getId_wfADesc(tblDesc));
		this.add(getSortnoADesc(tblDesc));
		this.add(getFg_macroADesc(tblDesc));
		this.add(getEu_macrodepmpADesc(tblDesc));
		this.add(getId_dep_mpADesc(tblDesc));
		this.add(getId_org_mpADesc(tblDesc));
		this.add(getId_srvcasADesc(tblDesc));
		this.add(getSd_srvcasADesc(tblDesc));
		this.add(getId_srvsADesc(tblDesc));
		this.add(getSd_srvsADesc(tblDesc));
		this.add(getId_usgsADesc(tblDesc));
		this.add(getSd_usgsADesc(tblDesc));
		this.add(getId_dosagesADesc(tblDesc));
		this.add(getId_mmsADesc(tblDesc));
		this.add(getFg_mmwhADesc(tblDesc));
		this.add(getEu_presoutpctrADesc(tblDesc));
		this.add(getId_poisADesc(tblDesc));
		this.add(getSd_poisADesc(tblDesc));
		this.add(getOrdrecurtpADesc(tblDesc));
		this.add(getTime_bADesc(tblDesc));
		this.add(getTime_eADesc(tblDesc));
		this.add(getId_weeksADesc(tblDesc));
		this.add(getSd_weeksADesc(tblDesc));
		this.add(getId_dep_orsADesc(tblDesc));
		this.add(getId_dep_clinicsADesc(tblDesc));
		this.add(getId_dep_nursADesc(tblDesc));
		this.add(getId_herbpreparationtpADesc(tblDesc));
		this.add(getSd_herbpreparationtpADesc(tblDesc));
		this.add(getEu_wftpADesc(tblDesc));
		this.add(getName_dep_mpADesc(tblDesc));
		this.add(getId_org_depADesc(tblDesc));
		this.add(getName_orgADesc(tblDesc));
		this.add(getCode_orgADesc(tblDesc));
		this.add(getName_srvcaADesc(tblDesc));
		this.add(getCode_srvcaADesc(tblDesc));
		this.add(getName_srvADesc(tblDesc));
		this.add(getName_usgADesc(tblDesc));
		this.add(getDosage_nameADesc(tblDesc));
		this.add(getMm_nameADesc(tblDesc));
		this.add(getName_posiADesc(tblDesc));
		this.add(getName_weekADesc(tblDesc));
		this.add(getName_dep_orADesc(tblDesc));
		this.add(getName_dep_clnicADesc(tblDesc));
		this.add(getName_dep_nurADesc(tblDesc));
		this.add(getName_herbpreparationtpADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_wfdepCDesc(tblDesc));
		tblDesc.add(getId_wfdepCDesc(tblDesc));
		tblDesc.add(getId_wfCDesc(tblDesc));
		tblDesc.add(getSortnoCDesc(tblDesc));
		tblDesc.add(getFg_macroCDesc(tblDesc));
		tblDesc.add(getEu_macrodepmpCDesc(tblDesc));
		tblDesc.add(getId_dep_mpCDesc(tblDesc));
		tblDesc.add(getId_org_mpCDesc(tblDesc));
		tblDesc.add(getId_srvcasCDesc(tblDesc));
		tblDesc.add(getSd_srvcasCDesc(tblDesc));
		tblDesc.add(getId_srvsCDesc(tblDesc));
		tblDesc.add(getSd_srvsCDesc(tblDesc));
		tblDesc.add(getId_usgsCDesc(tblDesc));
		tblDesc.add(getSd_usgsCDesc(tblDesc));
		tblDesc.add(getId_dosagesCDesc(tblDesc));
		tblDesc.add(getId_mmsCDesc(tblDesc));
		tblDesc.add(getFg_mmwhCDesc(tblDesc));
		tblDesc.add(getEu_presoutpctrCDesc(tblDesc));
		tblDesc.add(getId_poisCDesc(tblDesc));
		tblDesc.add(getSd_poisCDesc(tblDesc));
		tblDesc.add(getOrdrecurtpCDesc(tblDesc));
		tblDesc.add(getTime_bCDesc(tblDesc));
		tblDesc.add(getTime_eCDesc(tblDesc));
		tblDesc.add(getId_weeksCDesc(tblDesc));
		tblDesc.add(getSd_weeksCDesc(tblDesc));
		tblDesc.add(getId_dep_orsCDesc(tblDesc));
		tblDesc.add(getId_dep_clinicsCDesc(tblDesc));
		tblDesc.add(getId_dep_nursCDesc(tblDesc));
		tblDesc.add(getId_herbpreparationtpCDesc(tblDesc));
		tblDesc.add(getSd_herbpreparationtpCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 流向科室主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_wfdepADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_wfdep",  getId_wfdepCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("流向科室主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医嘱流向主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_wfADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_wf",  getId_wfCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医嘱流向主键");
		attrDesc.setNullable(true);
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
	 * 宏_执行科室属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_macrodepmpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_macrodepmp",  getEu_macrodepmpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("宏_执行科室");
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
	 * 服务分类ID串属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_srvcasADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_srvcas",  getId_srvcasCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务分类ID串");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 服务分类编码串属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_srvcasADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_srvcas",  getSd_srvcasCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务分类编码串");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 服务项目串属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_srvsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_srvs",  getId_srvsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务项目串");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 服务项目编码串属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_srvsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_srvs",  getSd_srvsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务项目编码串");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医嘱用法串属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_usgsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_usgs",  getId_usgsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医嘱用法串");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 医嘱用法编码串属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_usgsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_usgs",  getSd_usgsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医嘱用法编码串");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 剂型串属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dosagesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dosages",  getId_dosagesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("剂型串");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 物品串属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mmsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mms",  getId_mmsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("物品串");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 物品目录限制属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_mmwhADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_mmwh",  getFg_mmwhCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("物品目录限制");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 出院带药标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_presoutpctrADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_presoutpctr",  getEu_presoutpctrCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("出院带药标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 毒麻分类ID串属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_poisADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pois",  getId_poisCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("毒麻分类ID串");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 毒麻分类编码串属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_poisADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_pois",  getSd_poisCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("毒麻分类编码串");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医嘱周期类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOrdrecurtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ordrecurtp",  getOrdrecurtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("医嘱周期类型");
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
	private IAttrDesc getTime_bADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Time_b",  getTime_bCDesc(tblDesc), this);
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
	private IAttrDesc getTime_eADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Time_e",  getTime_eCDesc(tblDesc), this);
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
	 * 星期串属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_weeksADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_weeks",  getId_weeksCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("星期串");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 星期串编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_weeksADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_weeks",  getSd_weeksCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("星期串编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 开单科室串属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dep_orsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep_ors",  getId_dep_orsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("开单科室串");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 就诊科室串属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dep_clinicsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep_clinics",  getId_dep_clinicsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("就诊科室串");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 护理单元串属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dep_nursADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep_nurs",  getId_dep_nursCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("护理单元串");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 草药剂型id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_herbpreparationtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_herbpreparationtp",  getId_herbpreparationtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("草药剂型id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 草药剂型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_herbpreparationtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_herbpreparationtp",  getSd_herbpreparationtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("草药剂型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 流向类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_wftpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_wftp",  getEu_wftpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("流向类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"BD_WF a2b11","id_wf=id_wf","eu_wftp"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dep_mpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dep_mp",  getName_dep_mpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a2b2","id_dep_mp=id_dep","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 所属机构属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_org_depADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_org_dep",  getId_org_depCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("所属机构");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a2b2","id_dep_mp=id_dep","id_org"});
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 执行机构属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_orgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_org",  getName_orgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("执行机构");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_org a2b3","id_org_mp=id_org","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 组织编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_orgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_org",  getCode_orgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("组织编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_org a2b3","id_org_mp=id_org","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 服务分类名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_srvcaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_srvca",  getName_srvcaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务分类名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_srvca a2b12","id_srvcas=id_srvca","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 服务分类编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_srvcaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_srvca",  getCode_srvcaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务分类编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_srvca a2b12","id_srvcas=id_srvca","code"});
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
		attrDesc.setRefTblInfos(new String[]{"bd_srv a2b8","id_srvs=id_srv","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 用法名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_usgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_usg",  getName_usgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用法名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_route a2b9","id_usgs=id_route","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 剂型名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDosage_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dosage_name",  getDosage_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("剂型名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a2b13","id_dosages=id_udidoc","name"});
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
		attrDesc.setRefTblInfos(new String[]{"BD_MM a2b14","id_mms=id_mm","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 毒麻分类名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_posiADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_posi",  getName_posiCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("毒麻分类名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a2b15","id_pois=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_weekADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_week",  getName_weekCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a2b10","id_weeks=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dep_orADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dep_or",  getName_dep_orCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a2b4","id_dep_ors=id_dep","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dep_clnicADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dep_clnic",  getName_dep_clnicCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a2b5","id_dep_clinics=id_dep","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dep_nurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dep_nur",  getName_dep_nurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a2b6","id_dep_nurs=id_dep","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_herbpreparationtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_herbpreparationtp",  getName_herbpreparationtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a2b18","id_herbpreparationtp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取流向科室主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_wfdepCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_wfdep");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("流向科室主键"); 
		return column;
	}
	/**
	 * 获取医嘱流向主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_wfCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_wf");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医嘱流向主键"); 
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
	 * 获取宏_执行科室表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_macrodepmpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_macrodepmp");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("宏_执行科室"); 
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
	 * 获取服务分类ID串表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_srvcasCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_srvcas");
		column.setLength(2000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务分类ID串"); 
		return column;
	}
	/**
	 * 获取服务分类编码串表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_srvcasCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_srvcas");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务分类编码串"); 
		return column;
	}
	/**
	 * 获取服务项目串表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_srvsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_srvs");
		column.setLength(1000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务项目串"); 
		return column;
	}
	/**
	 * 获取服务项目编码串表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_srvsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_srvs");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务项目编码串"); 
		return column;
	}
	/**
	 * 获取医嘱用法串表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_usgsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_usgs");
		column.setLength(1000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医嘱用法串"); 
		return column;
	}
	/**
	 * 获取医嘱用法编码串表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_usgsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_usgs");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医嘱用法编码串"); 
		return column;
	}
	/**
	 * 获取剂型串表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dosagesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dosages");
		column.setLength(2000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("剂型串"); 
		return column;
	}
	/**
	 * 获取物品串表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mmsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mms");
		column.setLength(1000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("物品串"); 
		return column;
	}
	/**
	 * 获取物品目录限制表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_mmwhCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_mmwh");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("物品目录限制"); 
		return column;
	}
	/**
	 * 获取出院带药标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_presoutpctrCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_presoutpctr");
		column.setLength(20);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("出院带药标识"); 
		return column;
	}
	/**
	 * 获取毒麻分类ID串表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_poisCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pois");
		column.setLength(2000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("毒麻分类ID串"); 
		return column;
	}
	/**
	 * 获取毒麻分类编码串表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_poisCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_pois");
		column.setLength(1000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("毒麻分类编码串"); 
		return column;
	}
	/**
	 * 获取医嘱周期类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOrdrecurtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ordrecurtp");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("医嘱周期类型"); 
		return column;
	}
	/**
	 * 获取开始时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTime_bCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Time_b");
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
	private IColumnDesc getTime_eCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Time_e");
		column.setLength(8);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("结束时间"); 
		return column;
	}
	/**
	 * 获取星期串表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_weeksCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_weeks");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("星期串"); 
		return column;
	}
	/**
	 * 获取星期串编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_weeksCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_weeks");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("星期串编码"); 
		return column;
	}
	/**
	 * 获取开单科室串表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dep_orsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep_ors");
		column.setLength(1000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("开单科室串"); 
		return column;
	}
	/**
	 * 获取就诊科室串表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dep_clinicsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep_clinics");
		column.setLength(1000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊科室串"); 
		return column;
	}
	/**
	 * 获取护理单元串表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dep_nursCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep_nurs");
		column.setLength(1000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("护理单元串"); 
		return column;
	}
	/**
	 * 获取草药剂型id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_herbpreparationtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_herbpreparationtp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("草药剂型id"); 
		return column;
	}
	/**
	 * 获取草药剂型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_herbpreparationtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_herbpreparationtp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("草药剂型编码"); 
		return column;
	}
	/**
	 * 获取流向类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_wftpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_wftp");
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("流向类型"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_dep_mpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dep_mp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取所属机构表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_org_depCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_org_dep");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("所属机构"); 
		return column;
	}
	/**
	 * 获取执行机构表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_orgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_org");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("执行机构"); 
		return column;
	}
	/**
	 * 获取组织编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_orgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_org");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("组织编码"); 
		return column;
	}
	/**
	 * 获取服务分类名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_srvcaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_srvca");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务分类名称"); 
		return column;
	}
	/**
	 * 获取服务分类编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_srvcaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_srvca");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务分类编码"); 
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
	 * 获取用法名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_usgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_usg");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("用法名称"); 
		return column;
	}
	/**
	 * 获取剂型名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDosage_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dosage_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("剂型名称"); 
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
	 * 获取毒麻分类名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_posiCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_posi");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("毒麻分类名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_weekCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_week");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_dep_orCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dep_or");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_dep_clnicCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dep_clnic");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_dep_nurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dep_nur");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_herbpreparationtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_herbpreparationtp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
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
