
package iih.nm.nqm.nmnqmwdkpida.d.desc;

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
 * 病区护理指标数据 DO 元数据信息
 */
public class NmNqmWdKpidaDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.nm.nqm.nmnqmwdkpida.d.NmNqmWdKpidaDO";
	public static final String CLASS_DISPALYNAME = "病区护理指标数据";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "NM_NQM_WD_KPIDA";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_nqm_wd_kpida";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public NmNqmWdKpidaDODesc(){
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
		this.setKeyDesc(getId_nqm_wd_kpidaADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_nqm_wd_kpidaADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_nqm_wd_kpiADesc(tblDesc));
		this.add(getDt_chkADesc(tblDesc));
		this.add(getId_dep_nurADesc(tblDesc));
		this.add(getId_nqm_spcsADesc(tblDesc));
		this.add(getId_nqm_spcs_kpiADesc(tblDesc));
		this.add(getCode_nqm_spcs_kpiADesc(tblDesc));
		this.add(getChknumbdataADesc(tblDesc));
		this.add(getChkdenorndataADesc(tblDesc));
		this.add(getSd_goalADesc(tblDesc));
		this.add(getAccu_rateADesc(tblDesc));
		this.add(getRxovADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getNameADesc(tblDesc));
		this.add(getCode_dep_nurADesc(tblDesc));
		this.add(getCode_nqm_spcsADesc(tblDesc));
		this.add(getName_nqm_spcsADesc(tblDesc));
		this.add(getName_nqm_spcs_kpiADesc(tblDesc));
		this.add(getSd_goal_nqm_spcs_kpiADesc(tblDesc));
		this.add(getChknumbname_nqm_spcs_kpiADesc(tblDesc));
		this.add(getChkdenorname_nqm_spcs_kpiADesc(tblDesc));
		this.add(getFg_activeADesc(tblDesc));
		this.add(getId_goal_nqm_spcs_kpiADesc(tblDesc));
		this.add(getNumcap_nqm_spcs_kpiADesc(tblDesc));
		this.add(getNumfloor_nqm_spcs_kpiADesc(tblDesc));
		this.add(getNumover_nqm_spcs_kpiADesc(tblDesc));
		this.add(getId_per_unit_nqm_spcs_kpiADesc(tblDesc));
		this.add(getSd_per_unit_nqm_spcs_kpiADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_nqm_wd_kpidaCDesc(tblDesc));
		tblDesc.add(getId_nqm_wd_kpidaCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_nqm_wd_kpiCDesc(tblDesc));
		tblDesc.add(getDt_chkCDesc(tblDesc));
		tblDesc.add(getId_dep_nurCDesc(tblDesc));
		tblDesc.add(getId_nqm_spcsCDesc(tblDesc));
		tblDesc.add(getId_nqm_spcs_kpiCDesc(tblDesc));
		tblDesc.add(getCode_nqm_spcs_kpiCDesc(tblDesc));
		tblDesc.add(getChknumbdataCDesc(tblDesc));
		tblDesc.add(getChkdenorndataCDesc(tblDesc));
		tblDesc.add(getSd_goalCDesc(tblDesc));
		tblDesc.add(getAccu_rateCDesc(tblDesc));
		tblDesc.add(getRxovCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 病区指标数据主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_nqm_wd_kpidaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_nqm_wd_kpida",  getId_nqm_wd_kpidaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病区指标数据主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 所属组织属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_orgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_org",  getId_orgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("所属组织");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 所属集团属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_grpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_grp",  getId_grpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("所属集团");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 病区护理指标外键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_nqm_wd_kpiADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_nqm_wd_kpi",  getId_nqm_wd_kpiCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病区护理指标外键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_chkADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_chk",  getDt_chkCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 护理单元属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dep_nurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep_nur",  getId_dep_nurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("护理单元");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 病区护理标准id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_nqm_spcsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_nqm_spcs",  getId_nqm_spcsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病区护理标准id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 护理指标外键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_nqm_spcs_kpiADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_nqm_spcs_kpi",  getId_nqm_spcs_kpiCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("护理指标外键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 病区指标编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_nqm_spcs_kpiADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_nqm_spcs_kpi",  getCode_nqm_spcs_kpiCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病区指标编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 检测数据(分子)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getChknumbdataADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Chknumbdata",  getChknumbdataCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("检测数据(分子)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 检测数据(分母）属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getChkdenorndataADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Chkdenorndata",  getChkdenorndataCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("检测数据(分母）");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 改善目标属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_goalADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_goal",  getSd_goalCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("改善目标");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 发生率属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAccu_rateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Accu_rate",  getAccu_rateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("发生率");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 超限情况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRxovADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Rxov",  getRxovCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("超限情况");
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
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name",  getNameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b7","id_dep_nur=id_dep","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_dep_nurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_dep_nur",  getCode_dep_nurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b7","id_dep_nur=id_dep","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 标准编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_nqm_spcsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_nqm_spcs",  getCode_nqm_spcsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("标准编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"NM_NQM_SPCS a0b9","id_nqm_spcs=id_nqm_spcs","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 标准属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_nqm_spcsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_nqm_spcs",  getName_nqm_spcsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("标准");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"NM_NQM_SPCS a0b9","id_nqm_spcs=id_nqm_spcs","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 指标名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_nqm_spcs_kpiADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_nqm_spcs_kpi",  getName_nqm_spcs_kpiCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("指标名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"NM_NQM_SPCS_KPI a0b8","id_nqm_spcs_kpi=id_nqm_spcs_kpi","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 改善目标编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_goal_nqm_spcs_kpiADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_goal_nqm_spcs_kpi",  getSd_goal_nqm_spcs_kpiCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("改善目标编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"NM_NQM_SPCS_KPI a0b8","id_nqm_spcs_kpi=id_nqm_spcs_kpi","sd_goal"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 检测数据（分子）属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getChknumbname_nqm_spcs_kpiADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Chknumbname_nqm_spcs_kpi",  getChknumbname_nqm_spcs_kpiCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("检测数据（分子）");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"NM_NQM_SPCS_KPI a0b8","id_nqm_spcs_kpi=id_nqm_spcs_kpi","chknumbname"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 检测数据（分母）属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getChkdenorname_nqm_spcs_kpiADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Chkdenorname_nqm_spcs_kpi",  getChkdenorname_nqm_spcs_kpiCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("检测数据（分母）");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"NM_NQM_SPCS_KPI a0b8","id_nqm_spcs_kpi=id_nqm_spcs_kpi","chkdenorname"});
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
		attrDesc.setRefTblInfos(new String[]{"NM_NQM_SPCS_KPI a0b8","id_nqm_spcs_kpi=id_nqm_spcs_kpi","fg_active"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 改善目标ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_goal_nqm_spcs_kpiADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_goal_nqm_spcs_kpi",  getId_goal_nqm_spcs_kpiCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("改善目标ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"NM_NQM_SPCS_KPI a0b8","id_nqm_spcs_kpi=id_nqm_spcs_kpi","id_goal"});
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 数值上限属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNumcap_nqm_spcs_kpiADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Numcap_nqm_spcs_kpi",  getNumcap_nqm_spcs_kpiCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("数值上限");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"NM_NQM_SPCS_KPI a0b8","id_nqm_spcs_kpi=id_nqm_spcs_kpi","numcap"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 数值下限属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNumfloor_nqm_spcs_kpiADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Numfloor_nqm_spcs_kpi",  getNumfloor_nqm_spcs_kpiCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("数值下限");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"NM_NQM_SPCS_KPI a0b8","id_nqm_spcs_kpi=id_nqm_spcs_kpi","numfloor"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 超限值属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNumover_nqm_spcs_kpiADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Numover_nqm_spcs_kpi",  getNumover_nqm_spcs_kpiCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("超限值");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"NM_NQM_SPCS_KPI a0b8","id_nqm_spcs_kpi=id_nqm_spcs_kpi","numover"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 检测数据比单位ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_per_unit_nqm_spcs_kpiADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_per_unit_nqm_spcs_kpi",  getId_per_unit_nqm_spcs_kpiCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("检测数据比单位ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"NM_NQM_SPCS_KPI a0b8","id_nqm_spcs_kpi=id_nqm_spcs_kpi","id_per_unit"});
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 检测数据比单位编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_per_unit_nqm_spcs_kpiADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_per_unit_nqm_spcs_kpi",  getSd_per_unit_nqm_spcs_kpiCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("检测数据比单位编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"NM_NQM_SPCS_KPI a0b8","id_nqm_spcs_kpi=id_nqm_spcs_kpi","sd_per_unit"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取病区指标数据主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_nqm_wd_kpidaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_nqm_wd_kpida");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("病区指标数据主键"); 
		return column;
	}
	/**
	 * 获取所属组织表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_orgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_org");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("所属组织"); 
		return column;
	}
	/**
	 * 获取所属集团表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_grpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_grp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("所属集团"); 
		return column;
	}
	/**
	 * 获取病区护理指标外键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_nqm_wd_kpiCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_nqm_wd_kpi");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病区护理指标外键"); 
		return column;
	}
	/**
	 * 获取日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_chkCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_chk");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("日期"); 
		return column;
	}
	/**
	 * 获取护理单元表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dep_nurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep_nur");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("护理单元"); 
		return column;
	}
	/**
	 * 获取病区护理标准id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_nqm_spcsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_nqm_spcs");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病区护理标准id"); 
		return column;
	}
	/**
	 * 获取护理指标外键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_nqm_spcs_kpiCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_nqm_spcs_kpi");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("护理指标外键"); 
		return column;
	}
	/**
	 * 获取病区指标编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_nqm_spcs_kpiCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_nqm_spcs_kpi");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病区指标编码"); 
		return column;
	}
	/**
	 * 获取检测数据(分子)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getChknumbdataCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Chknumbdata");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("检测数据(分子)"); 
		return column;
	}
	/**
	 * 获取检测数据(分母）表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getChkdenorndataCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Chkdenorndata");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("检测数据(分母）"); 
		return column;
	}
	/**
	 * 获取改善目标表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_goalCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_goal");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("改善目标"); 
		return column;
	}
	/**
	 * 获取发生率表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAccu_rateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Accu_rate");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("发生率"); 
		return column;
	}
	/**
	 * 获取超限情况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRxovCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Rxov");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("超限情况"); 
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
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_dep_nurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_dep_nur");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取标准编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_nqm_spcsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_nqm_spcs");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("标准编码"); 
		return column;
	}
	/**
	 * 获取标准表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_nqm_spcsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_nqm_spcs");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("标准"); 
		return column;
	}
	/**
	 * 获取指标名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_nqm_spcs_kpiCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_nqm_spcs_kpi");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("指标名称"); 
		return column;
	}
	/**
	 * 获取改善目标编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_goal_nqm_spcs_kpiCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_goal_nqm_spcs_kpi");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("改善目标编码"); 
		return column;
	}
	/**
	 * 获取检测数据（分子）表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getChknumbname_nqm_spcs_kpiCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Chknumbname_nqm_spcs_kpi");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("检测数据（分子）"); 
		return column;
	}
	/**
	 * 获取检测数据（分母）表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getChkdenorname_nqm_spcs_kpiCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Chkdenorname_nqm_spcs_kpi");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("检测数据（分母）"); 
		return column;
	}
	/**
	 * 获取启用状态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_activeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_active");
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("启用状态"); 
		return column;
	}
	/**
	 * 获取改善目标ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_goal_nqm_spcs_kpiCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_goal_nqm_spcs_kpi");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("改善目标ID"); 
		return column;
	}
	/**
	 * 获取数值上限表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNumcap_nqm_spcs_kpiCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Numcap_nqm_spcs_kpi");
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("数值上限"); 
		return column;
	}
	/**
	 * 获取数值下限表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNumfloor_nqm_spcs_kpiCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Numfloor_nqm_spcs_kpi");
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("数值下限"); 
		return column;
	}
	/**
	 * 获取超限值表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNumover_nqm_spcs_kpiCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Numover_nqm_spcs_kpi");
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("超限值"); 
		return column;
	}
	/**
	 * 获取检测数据比单位ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_per_unit_nqm_spcs_kpiCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_per_unit_nqm_spcs_kpi");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("检测数据比单位ID"); 
		return column;
	}
	/**
	 * 获取检测数据比单位编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_per_unit_nqm_spcs_kpiCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_per_unit_nqm_spcs_kpi");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("检测数据比单位编码"); 
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
