
package iih.sfda.aer.sfdaaerev.d.desc;

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
 * 不良上报事件 DO 元数据信息
 */
public class SfdaAerEvDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.sfda.aer.sfdaaerev.d.SfdaAerEvDO";
	public static final String CLASS_DISPALYNAME = "不良上报事件";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "SFDA_AER_EV";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_aer_ev";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public SfdaAerEvDODesc(){
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
		this.setKeyDesc(getId_aer_evADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_aer_evADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_taskADesc(tblDesc));
		this.add(getFg_ismitADesc(tblDesc));
		this.add(getCode_evADesc(tblDesc));
		this.add(getId_sfda_imprd_tpADesc(tblDesc));
		this.add(getSd_sfda_imprd_tpADesc(tblDesc));
		this.add(getId_psndocADesc(tblDesc));
		this.add(getDt_occurADesc(tblDesc));
		this.add(getId_dep_occurADesc(tblDesc));
		this.add(getId_occur_dttpADesc(tblDesc));
		this.add(getSd_occur_dttpADesc(tblDesc));
		this.add(getId_occur_adrADesc(tblDesc));
		this.add(getSd_occur_adrADesc(tblDesc));
		this.add(getId_ev_lvlADesc(tblDesc));
		this.add(getSd_ev_lvlADesc(tblDesc));
		this.add(getId_hurt_lvlADesc(tblDesc));
		this.add(getSd_hurt_lvlADesc(tblDesc));
		this.add(getEv_desADesc(tblDesc));
		this.add(getId_ev_caADesc(tblDesc));
		this.add(getSd_ev_caADesc(tblDesc));
		this.add(getEu_diag_tsADesc(tblDesc));
		this.add(getDiag_ts_desADesc(tblDesc));
		this.add(getId_ev_afhdleADesc(tblDesc));
		this.add(getSd_ev_afhdleADesc(tblDesc));
		this.add(getEv_afhdle_desADesc(tblDesc));
		this.add(getEu_notify_relpsnADesc(tblDesc));
		this.add(getId_notify_relpsnADesc(tblDesc));
		this.add(getSd_notify_relpsnADesc(tblDesc));
		this.add(getContent_notify_relpsnADesc(tblDesc));
		this.add(getEu_notify_famADesc(tblDesc));
		this.add(getDt_notify_famADesc(tblDesc));
		this.add(getEu_fam_udADesc(tblDesc));
		this.add(getEu_ev_reftpADesc(tblDesc));
		this.add(getEv_statusADesc(tblDesc));
		this.add(getCurr_nodeADesc(tblDesc));
		this.add(getId_currhdl_userADesc(tblDesc));
		this.add(getHdl_limtADesc(tblDesc));
		this.add(getExt1ADesc(tblDesc));
		this.add(getExt2ADesc(tblDesc));
		this.add(getExt3ADesc(tblDesc));
		this.add(getExt4ADesc(tblDesc));
		this.add(getExt5ADesc(tblDesc));
		this.add(getExt6ADesc(tblDesc));
		this.add(getExt7ADesc(tblDesc));
		this.add(getExt8ADesc(tblDesc));
		this.add(getExt9ADesc(tblDesc));
		this.add(getExt10ADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getName_orgADesc(tblDesc));
		this.add(getName_grpADesc(tblDesc));
		this.add(getName_sfda_imprd_tpADesc(tblDesc));
		this.add(getName_psndocADesc(tblDesc));
		this.add(getName_dep_occurADesc(tblDesc));
		this.add(getName_occur_dttpADesc(tblDesc));
		this.add(getName_occur_adrADesc(tblDesc));
		this.add(getName_ev_lvlADesc(tblDesc));
		this.add(getDes_ev_lvlADesc(tblDesc));
		this.add(getName_hurt_lvlADesc(tblDesc));
		this.add(getDes_hurt_lvlADesc(tblDesc));
		this.add(getName_ev_caADesc(tblDesc));
		this.add(getName_ev_afhdleADesc(tblDesc));
		this.add(getName_notify_relpsnADesc(tblDesc));
		this.add(getName_currhdl_userADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_aer_evCDesc(tblDesc));
		tblDesc.add(getId_aer_evCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_taskCDesc(tblDesc));
		tblDesc.add(getFg_ismitCDesc(tblDesc));
		tblDesc.add(getCode_evCDesc(tblDesc));
		tblDesc.add(getId_sfda_imprd_tpCDesc(tblDesc));
		tblDesc.add(getSd_sfda_imprd_tpCDesc(tblDesc));
		tblDesc.add(getId_psndocCDesc(tblDesc));
		tblDesc.add(getDt_occurCDesc(tblDesc));
		tblDesc.add(getId_dep_occurCDesc(tblDesc));
		tblDesc.add(getId_occur_dttpCDesc(tblDesc));
		tblDesc.add(getSd_occur_dttpCDesc(tblDesc));
		tblDesc.add(getId_occur_adrCDesc(tblDesc));
		tblDesc.add(getSd_occur_adrCDesc(tblDesc));
		tblDesc.add(getId_ev_lvlCDesc(tblDesc));
		tblDesc.add(getSd_ev_lvlCDesc(tblDesc));
		tblDesc.add(getId_hurt_lvlCDesc(tblDesc));
		tblDesc.add(getSd_hurt_lvlCDesc(tblDesc));
		tblDesc.add(getEv_desCDesc(tblDesc));
		tblDesc.add(getId_ev_caCDesc(tblDesc));
		tblDesc.add(getSd_ev_caCDesc(tblDesc));
		tblDesc.add(getEu_diag_tsCDesc(tblDesc));
		tblDesc.add(getDiag_ts_desCDesc(tblDesc));
		tblDesc.add(getId_ev_afhdleCDesc(tblDesc));
		tblDesc.add(getSd_ev_afhdleCDesc(tblDesc));
		tblDesc.add(getEv_afhdle_desCDesc(tblDesc));
		tblDesc.add(getEu_notify_relpsnCDesc(tblDesc));
		tblDesc.add(getId_notify_relpsnCDesc(tblDesc));
		tblDesc.add(getSd_notify_relpsnCDesc(tblDesc));
		tblDesc.add(getContent_notify_relpsnCDesc(tblDesc));
		tblDesc.add(getEu_notify_famCDesc(tblDesc));
		tblDesc.add(getDt_notify_famCDesc(tblDesc));
		tblDesc.add(getEu_fam_udCDesc(tblDesc));
		tblDesc.add(getEu_ev_reftpCDesc(tblDesc));
		tblDesc.add(getEv_statusCDesc(tblDesc));
		tblDesc.add(getCurr_nodeCDesc(tblDesc));
		tblDesc.add(getId_currhdl_userCDesc(tblDesc));
		tblDesc.add(getHdl_limtCDesc(tblDesc));
		tblDesc.add(getExt1CDesc(tblDesc));
		tblDesc.add(getExt2CDesc(tblDesc));
		tblDesc.add(getExt3CDesc(tblDesc));
		tblDesc.add(getExt4CDesc(tblDesc));
		tblDesc.add(getExt5CDesc(tblDesc));
		tblDesc.add(getExt6CDesc(tblDesc));
		tblDesc.add(getExt7CDesc(tblDesc));
		tblDesc.add(getExt8CDesc(tblDesc));
		tblDesc.add(getExt9CDesc(tblDesc));
		tblDesc.add(getExt10CDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 事件主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_aer_evADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_aer_ev",  getId_aer_evCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("事件主键");
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
	 * 任务外键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_taskADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_task",  getId_taskCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("任务外键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否匿名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_ismitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_ismit",  getFg_ismitCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否匿名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 事件编号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_evADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_ev",  getCode_evCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("事件编号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 受害者类型id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_sfda_imprd_tpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_sfda_imprd_tp",  getId_sfda_imprd_tpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("受害者类型id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 受害者类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_sfda_imprd_tpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_sfda_imprd_tp",  getSd_sfda_imprd_tpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("受害者类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 发现人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_psndocADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_psndoc",  getId_psndocCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("发现人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 发生日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_occurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_occur",  getDt_occurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("发生日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 发生部门属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dep_occurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep_occur",  getId_dep_occurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("发生部门");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 发生时间类型id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_occur_dttpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_occur_dttp",  getId_occur_dttpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("发生时间类型id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 发生时间类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_occur_dttpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_occur_dttp",  getSd_occur_dttpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("发生时间类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 发生地点id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_occur_adrADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_occur_adr",  getId_occur_adrCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("发生地点id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 发生地点编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_occur_adrADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_occur_adr",  getSd_occur_adrCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("发生地点编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 不良事件级别id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ev_lvlADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ev_lvl",  getId_ev_lvlCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("不良事件级别id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 不良事件级别编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_ev_lvlADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_ev_lvl",  getSd_ev_lvlCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("不良事件级别编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 伤害严重度id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_hurt_lvlADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_hurt_lvl",  getId_hurt_lvlCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("伤害严重度id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 伤害严重度编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_hurt_lvlADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_hurt_lvl",  getSd_hurt_lvlCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("伤害严重度编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 事件经过及详细信息属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEv_desADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ev_des",  getEv_desCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("事件经过及详细信息");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 事件类别id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ev_caADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ev_ca",  getId_ev_caCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("事件类别id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 事件类别编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_ev_caADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_ev_ca",  getSd_ev_caCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("事件类别编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊断性检查属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_diag_tsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_diag_ts",  getEu_diag_tsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("诊断性检查");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊断性检查描述属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDiag_ts_desADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Diag_ts_des",  getDiag_ts_desCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断性检查描述");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 事件发生后的处理id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ev_afhdleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ev_afhdle",  getId_ev_afhdleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("事件发生后的处理id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 事件发生后的处理编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_ev_afhdleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_ev_afhdle",  getSd_ev_afhdleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("事件发生后的处理编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 事件发生后的处理描述属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEv_afhdle_desADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ev_afhdle_des",  getEv_afhdle_desCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("事件发生后的处理描述");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否通知相关人员属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_notify_relpsnADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_notify_relpsn",  getEu_notify_relpsnCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否通知相关人员");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 通知相关人员id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_notify_relpsnADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_notify_relpsn",  getId_notify_relpsnCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("通知相关人员id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 通知相关人员编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_notify_relpsnADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_notify_relpsn",  getSd_notify_relpsnCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("通知相关人员编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 通知相关人员内容属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getContent_notify_relpsnADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Content_notify_relpsn",  getContent_notify_relpsnCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("通知相关人员内容");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否通知家属属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_notify_famADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_notify_fam",  getEu_notify_famCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否通知家属");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 通知家属时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_notify_famADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_notify_fam",  getDt_notify_famCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("通知家属时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 家属书否理解属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_fam_udADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_fam_ud",  getEu_fam_udCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("家属书否理解");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 事件涉及类别属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_ev_reftpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_ev_reftp",  getEu_ev_reftpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("事件涉及类别");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 事件状态属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEv_statusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ev_status",  getEv_statusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("事件状态");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 当前处理节点属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCurr_nodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Curr_node",  getCurr_nodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("当前处理节点");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 当前处理者属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_currhdl_userADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_currhdl_user",  getId_currhdl_userCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("当前处理者");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 处理期限属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHdl_limtADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Hdl_limt",  getHdl_limtCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("处理期限");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 扩展字段1属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getExt1ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ext1",  getExt1CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("扩展字段1");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 扩展字段2属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getExt2ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ext2",  getExt2CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("扩展字段2");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 扩展字段3属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getExt3ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ext3",  getExt3CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("扩展字段3");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 扩展字段4属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getExt4ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ext4",  getExt4CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("扩展字段4");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 扩展字段5属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getExt5ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ext5",  getExt5CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("扩展字段5");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 扩展字段6属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getExt6ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ext6",  getExt6CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("扩展字段6");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 扩展字段7属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getExt7ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ext7",  getExt7CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("扩展字段7");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 扩展字段8属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getExt8ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ext8",  getExt8CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("扩展字段8");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 扩展字段9属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getExt9ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ext9",  getExt9CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("扩展字段9");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 扩展字段10属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getExt10ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ext10",  getExt10CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("扩展字段10");
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
	private IAttrDesc getName_orgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_org",  getName_orgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("组织名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_org a0b2","id_org=id_org","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 集团名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_grpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_grp",  getName_grpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("集团名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_grp a0b3","id_grp=id_grp","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_sfda_imprd_tpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_sfda_imprd_tp",  getName_sfda_imprd_tpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b6","id_sfda_imprd_tp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 上报人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_psndocADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_psndoc",  getName_psndocCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("上报人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b4","id_psndoc=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 发生部门属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dep_occurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dep_occur",  getName_dep_occurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("发生部门");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b5","id_dep_occur=id_dep","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_occur_dttpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_occur_dttp",  getName_occur_dttpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b9","id_occur_dttp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 发生地点属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_occur_adrADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_occur_adr",  getName_occur_adrCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("发生地点");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b10","id_occur_adr=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_ev_lvlADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_ev_lvl",  getName_ev_lvlCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b12","id_ev_lvl=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 标准编码描述属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDes_ev_lvlADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Des_ev_lvl",  getDes_ev_lvlCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("标准编码描述");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b12","id_ev_lvl=id_udidoc","des"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_hurt_lvlADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_hurt_lvl",  getName_hurt_lvlCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b14","id_hurt_lvl=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 标准编码描述属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDes_hurt_lvlADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Des_hurt_lvl",  getDes_hurt_lvlCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("标准编码描述");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b14","id_hurt_lvl=id_udidoc","des"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 事件类别名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_ev_caADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_ev_ca",  getName_ev_caCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("事件类别名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b11","id_ev_ca=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 事件发生后的处理属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_ev_afhdleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_ev_afhdle",  getName_ev_afhdleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("事件发生后的处理");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b13","id_ev_afhdle=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_notify_relpsnADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_notify_relpsn",  getName_notify_relpsnCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b16","id_notify_relpsn=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 用户属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_currhdl_userADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_currhdl_user",  getName_currhdl_userCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用户");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sys_user a0b15","id_currhdl_user=id_user","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取事件主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_aer_evCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_aer_ev");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("事件主键"); 
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
	private IColumnDesc getId_grpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_grp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("集团"); 
		return column;
	}
	/**
	 * 获取任务外键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_taskCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_task");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("任务外键"); 
		return column;
	}
	/**
	 * 获取是否匿名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_ismitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_ismit");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否匿名"); 
		return column;
	}
	/**
	 * 获取事件编号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_evCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_ev");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("事件编号"); 
		return column;
	}
	/**
	 * 获取受害者类型id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_sfda_imprd_tpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_sfda_imprd_tp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("受害者类型id"); 
		return column;
	}
	/**
	 * 获取受害者类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_sfda_imprd_tpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_sfda_imprd_tp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("受害者类型编码"); 
		return column;
	}
	/**
	 * 获取发现人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_psndocCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_psndoc");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("发现人"); 
		return column;
	}
	/**
	 * 获取发生日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_occurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_occur");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("发生日期"); 
		return column;
	}
	/**
	 * 获取发生部门表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dep_occurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep_occur");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("发生部门"); 
		return column;
	}
	/**
	 * 获取发生时间类型id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_occur_dttpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_occur_dttp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("发生时间类型id"); 
		return column;
	}
	/**
	 * 获取发生时间类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_occur_dttpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_occur_dttp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("发生时间类型编码"); 
		return column;
	}
	/**
	 * 获取发生地点id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_occur_adrCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_occur_adr");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("发生地点id"); 
		return column;
	}
	/**
	 * 获取发生地点编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_occur_adrCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_occur_adr");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("发生地点编码"); 
		return column;
	}
	/**
	 * 获取不良事件级别id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ev_lvlCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ev_lvl");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("不良事件级别id"); 
		return column;
	}
	/**
	 * 获取不良事件级别编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_ev_lvlCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_ev_lvl");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("不良事件级别编码"); 
		return column;
	}
	/**
	 * 获取伤害严重度id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_hurt_lvlCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_hurt_lvl");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("伤害严重度id"); 
		return column;
	}
	/**
	 * 获取伤害严重度编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_hurt_lvlCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_hurt_lvl");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("伤害严重度编码"); 
		return column;
	}
	/**
	 * 获取事件经过及详细信息表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEv_desCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ev_des");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("事件经过及详细信息"); 
		return column;
	}
	/**
	 * 获取事件类别id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ev_caCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ev_ca");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("事件类别id"); 
		return column;
	}
	/**
	 * 获取事件类别编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_ev_caCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_ev_ca");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("事件类别编码"); 
		return column;
	}
	/**
	 * 获取诊断性检查表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_diag_tsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_diag_ts");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("诊断性检查"); 
		return column;
	}
	/**
	 * 获取诊断性检查描述表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDiag_ts_desCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Diag_ts_des");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断性检查描述"); 
		return column;
	}
	/**
	 * 获取事件发生后的处理id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ev_afhdleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ev_afhdle");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("事件发生后的处理id"); 
		return column;
	}
	/**
	 * 获取事件发生后的处理编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_ev_afhdleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_ev_afhdle");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("事件发生后的处理编码"); 
		return column;
	}
	/**
	 * 获取事件发生后的处理描述表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEv_afhdle_desCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ev_afhdle_des");
		column.setLength(2000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("事件发生后的处理描述"); 
		return column;
	}
	/**
	 * 获取是否通知相关人员表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_notify_relpsnCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_notify_relpsn");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否通知相关人员"); 
		return column;
	}
	/**
	 * 获取通知相关人员id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_notify_relpsnCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_notify_relpsn");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("通知相关人员id"); 
		return column;
	}
	/**
	 * 获取通知相关人员编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_notify_relpsnCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_notify_relpsn");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("通知相关人员编码"); 
		return column;
	}
	/**
	 * 获取通知相关人员内容表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getContent_notify_relpsnCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Content_notify_relpsn");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("通知相关人员内容"); 
		return column;
	}
	/**
	 * 获取是否通知家属表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_notify_famCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_notify_fam");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否通知家属"); 
		return column;
	}
	/**
	 * 获取通知家属时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_notify_famCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_notify_fam");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("通知家属时间"); 
		return column;
	}
	/**
	 * 获取家属书否理解表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_fam_udCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_fam_ud");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("家属书否理解"); 
		return column;
	}
	/**
	 * 获取事件涉及类别表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_ev_reftpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_ev_reftp");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("事件涉及类别"); 
		return column;
	}
	/**
	 * 获取事件状态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEv_statusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ev_status");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("事件状态"); 
		return column;
	}
	/**
	 * 获取当前处理节点表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCurr_nodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Curr_node");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("当前处理节点"); 
		return column;
	}
	/**
	 * 获取当前处理者表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_currhdl_userCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_currhdl_user");
		column.setLength(250);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("当前处理者"); 
		return column;
	}
	/**
	 * 获取处理期限表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHdl_limtCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Hdl_limt");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("处理期限"); 
		return column;
	}
	/**
	 * 获取扩展字段1表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getExt1CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ext1");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("扩展字段1"); 
		return column;
	}
	/**
	 * 获取扩展字段2表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getExt2CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ext2");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("扩展字段2"); 
		return column;
	}
	/**
	 * 获取扩展字段3表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getExt3CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ext3");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("扩展字段3"); 
		return column;
	}
	/**
	 * 获取扩展字段4表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getExt4CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ext4");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("扩展字段4"); 
		return column;
	}
	/**
	 * 获取扩展字段5表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getExt5CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ext5");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("扩展字段5"); 
		return column;
	}
	/**
	 * 获取扩展字段6表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getExt6CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ext6");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("扩展字段6"); 
		return column;
	}
	/**
	 * 获取扩展字段7表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getExt7CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ext7");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("扩展字段7"); 
		return column;
	}
	/**
	 * 获取扩展字段8表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getExt8CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ext8");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("扩展字段8"); 
		return column;
	}
	/**
	 * 获取扩展字段9表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getExt9CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ext9");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("扩展字段9"); 
		return column;
	}
	/**
	 * 获取扩展字段10表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getExt10CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ext10");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("扩展字段10"); 
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
	private IColumnDesc getName_orgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_org");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("组织名称"); 
		return column;
	}
	/**
	 * 获取集团名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_grpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_grp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("集团名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_sfda_imprd_tpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_sfda_imprd_tp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取上报人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_psndocCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_psndoc");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("上报人"); 
		return column;
	}
	/**
	 * 获取发生部门表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_dep_occurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dep_occur");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("发生部门"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_occur_dttpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_occur_dttp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取发生地点表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_occur_adrCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_occur_adr");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("发生地点"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_ev_lvlCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_ev_lvl");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取标准编码描述表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDes_ev_lvlCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Des_ev_lvl");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("标准编码描述"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_hurt_lvlCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_hurt_lvl");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取标准编码描述表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDes_hurt_lvlCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Des_hurt_lvl");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("标准编码描述"); 
		return column;
	}
	/**
	 * 获取事件类别名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_ev_caCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_ev_ca");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("事件类别名称"); 
		return column;
	}
	/**
	 * 获取事件发生后的处理表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_ev_afhdleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_ev_afhdle");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("事件发生后的处理"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_notify_relpsnCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_notify_relpsn");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取用户表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_currhdl_userCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_currhdl_user");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("用户"); 
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
