
package iih.en.er.pre.d.desc;

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
 * 急诊预检 DO 元数据信息
 */
public class EnErPreDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.en.er.pre.d.EnErPreDO";
	public static final String CLASS_DISPALYNAME = "急诊预检";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "EN_ERPRE";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_erpre";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public EnErPreDODesc(){
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
		this.setKeyDesc(getId_erpreADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_erpreADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getCodeADesc(tblDesc));
		this.add(getId_patADesc(tblDesc));
		this.add(getName_patADesc(tblDesc));
		this.add(getId_ent_fstADesc(tblDesc));
		this.add(getId_ent_lastADesc(tblDesc));
		this.add(getFg_nonpersonADesc(tblDesc));
		this.add(getDt_entryADesc(tblDesc));
		this.add(getId_come_wayADesc(tblDesc));
		this.add(getSd_come_wayADesc(tblDesc));
		this.add(getIds_companionADesc(tblDesc));
		this.add(getSds_companionADesc(tblDesc));
		this.add(getEu_chk_eqidemicADesc(tblDesc));
		this.add(getIds_chk_noteADesc(tblDesc));
		this.add(getSds_chk_noteADesc(tblDesc));
		this.add(getDt_pick_vsADesc(tblDesc));
		this.add(getId_breath_stateADesc(tblDesc));
		this.add(getSd_breath_stateADesc(tblDesc));
		this.add(getDes_cmptADesc(tblDesc));
		this.add(getId_triage_caADesc(tblDesc));
		this.add(getId_triage_cmptADesc(tblDesc));
		this.add(getId_triage_resADesc(tblDesc));
		this.add(getSd_scale_autoADesc(tblDesc));
		this.add(getSd_scale_hmADesc(tblDesc));
		this.add(getSd_scale_cmptADesc(tblDesc));
		this.add(getId_dep_toADesc(tblDesc));
		this.add(getFg_green_channelADesc(tblDesc));
		this.add(getIds_green_channel_symADesc(tblDesc));
		this.add(getSds_green_channel_symADesc(tblDesc));
		this.add(getSd_triage_toADesc(tblDesc));
		this.add(getId_emp_preADesc(tblDesc));
		this.add(getDt_endADesc(tblDesc));
		this.add(getSd_statusADesc(tblDesc));
		this.add(getId_ent_ipADesc(tblDesc));
		this.add(getSd_status_ipADesc(tblDesc));
		this.add(getDt_end_ipADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getFg_refuse_exaADesc(tblDesc));
		this.add(getName_come_wayADesc(tblDesc));
		this.add(getNames_companionADesc(tblDesc));
		this.add(getNames_chk_noteADesc(tblDesc));
		this.add(getName_breath_stateADesc(tblDesc));
		this.add(getName_triage_caADesc(tblDesc));
		this.add(getName_triage_cmptADesc(tblDesc));
		this.add(getName_triage_resADesc(tblDesc));
		this.add(getName_dep_toADesc(tblDesc));
		this.add(getCode_dep_toADesc(tblDesc));
		this.add(getNames_green_channelADesc(tblDesc));
		this.add(getName_emp_preADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_erpreCDesc(tblDesc));
		tblDesc.add(getId_erpreCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getCodeCDesc(tblDesc));
		tblDesc.add(getId_patCDesc(tblDesc));
		tblDesc.add(getName_patCDesc(tblDesc));
		tblDesc.add(getId_ent_fstCDesc(tblDesc));
		tblDesc.add(getId_ent_lastCDesc(tblDesc));
		tblDesc.add(getFg_nonpersonCDesc(tblDesc));
		tblDesc.add(getDt_entryCDesc(tblDesc));
		tblDesc.add(getId_come_wayCDesc(tblDesc));
		tblDesc.add(getSd_come_wayCDesc(tblDesc));
		tblDesc.add(getIds_companionCDesc(tblDesc));
		tblDesc.add(getSds_companionCDesc(tblDesc));
		tblDesc.add(getEu_chk_eqidemicCDesc(tblDesc));
		tblDesc.add(getIds_chk_noteCDesc(tblDesc));
		tblDesc.add(getSds_chk_noteCDesc(tblDesc));
		tblDesc.add(getDt_pick_vsCDesc(tblDesc));
		tblDesc.add(getId_breath_stateCDesc(tblDesc));
		tblDesc.add(getSd_breath_stateCDesc(tblDesc));
		tblDesc.add(getDes_cmptCDesc(tblDesc));
		tblDesc.add(getId_triage_caCDesc(tblDesc));
		tblDesc.add(getId_triage_cmptCDesc(tblDesc));
		tblDesc.add(getId_triage_resCDesc(tblDesc));
		tblDesc.add(getSd_scale_autoCDesc(tblDesc));
		tblDesc.add(getSd_scale_hmCDesc(tblDesc));
		tblDesc.add(getSd_scale_cmptCDesc(tblDesc));
		tblDesc.add(getId_dep_toCDesc(tblDesc));
		tblDesc.add(getFg_green_channelCDesc(tblDesc));
		tblDesc.add(getIds_green_channel_symCDesc(tblDesc));
		tblDesc.add(getSds_green_channel_symCDesc(tblDesc));
		tblDesc.add(getSd_triage_toCDesc(tblDesc));
		tblDesc.add(getId_emp_preCDesc(tblDesc));
		tblDesc.add(getDt_endCDesc(tblDesc));
		tblDesc.add(getSd_statusCDesc(tblDesc));
		tblDesc.add(getId_ent_ipCDesc(tblDesc));
		tblDesc.add(getSd_status_ipCDesc(tblDesc));
		tblDesc.add(getDt_end_ipCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		tblDesc.add(getFg_refuse_exaCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 预检主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_erpreADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_erpre",  getId_erpreCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("预检主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 集团id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_grpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_grp",  getId_grpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("集团id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 组织id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_orgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_org",  getId_orgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("组织id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 预检码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code",  getCodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("预检码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_patADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pat",  getId_patCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_patADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_pat",  getName_patCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 第一次就诊id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ent_fstADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ent_fst",  getId_ent_fstCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("第一次就诊id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 最后一次就诊id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ent_lastADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ent_last",  getId_ent_lastCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("最后一次就诊id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 三无人员标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_nonpersonADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_nonperson",  getFg_nonpersonCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("三无人员标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 来院时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_entryADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_entry",  getDt_entryCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("来院时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 来院方式id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_come_wayADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_come_way",  getId_come_wayCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("来院方式id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 来院方式编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_come_wayADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_come_way",  getSd_come_wayCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("来院方式编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 陪送人员ids属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIds_companionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ids_companion",  getIds_companionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("陪送人员ids");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 陪送人员编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSds_companionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sds_companion",  getSds_companionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("陪送人员编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 流行病学史标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_chk_eqidemicADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_chk_eqidemic",  getEu_chk_eqidemicCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("流行病学史标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 检查询问ids属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIds_chk_noteADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ids_chk_note",  getIds_chk_noteCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("检查询问ids");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 检查询问编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSds_chk_noteADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sds_chk_note",  getSds_chk_noteCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("检查询问编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 采集生命体征时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_pick_vsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_pick_vs",  getDt_pick_vsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("采集生命体征时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 呼吸状态ids属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_breath_stateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_breath_state",  getId_breath_stateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("呼吸状态ids");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 呼吸状态编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_breath_stateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_breath_state",  getSd_breath_stateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("呼吸状态编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 主诉描述属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDes_cmptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Des_cmpt",  getDes_cmptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("主诉描述");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 检伤分类id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_triage_caADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_triage_ca",  getId_triage_caCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("检伤分类id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 检伤主诉id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_triage_cmptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_triage_cmpt",  getId_triage_cmptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("检伤主诉id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 检伤判定id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_triage_resADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_triage_res",  getId_triage_resCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("检伤判定id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 分级编码_自动属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_scale_autoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_scale_auto",  getSd_scale_autoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("分级编码_自动");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 分级编码_手动属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_scale_hmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_scale_hm",  getSd_scale_hmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("分级编码_手动");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 分级编码_主诉判定属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_scale_cmptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_scale_cmpt",  getSd_scale_cmptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("分级编码_主诉判定");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 分诊科室id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dep_toADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep_to",  getId_dep_toCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("分诊科室id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 绿色通道标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_green_channelADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_green_channel",  getFg_green_channelCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("绿色通道标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 绿色通道症状ids属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIds_green_channel_symADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ids_green_channel_sym",  getIds_green_channel_symCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("绿色通道症状ids");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 绿色通道症状编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSds_green_channel_symADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sds_green_channel_sym",  getSds_green_channel_symCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("绿色通道症状编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 分诊去向属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_triage_toADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_triage_to",  getSd_triage_toCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("分诊去向");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 预检人员id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_preADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_pre",  getId_emp_preCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("预检人员id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 结束时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_endADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_end",  getDt_endCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("结束时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 状态属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_statusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_status",  getSd_statusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("状态");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 留观就诊id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ent_ipADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ent_ip",  getId_ent_ipCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("留观就诊id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 留观预检状态属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_status_ipADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_status_ip",  getSd_status_ipCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("留观预检状态");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 留观结束时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_end_ipADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_end_ip",  getDt_end_ipCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("留观结束时间");
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
	 * 拒绝标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_refuse_exaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_refuse_exa",  getFg_refuse_exaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("拒绝标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 来院方式名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_come_wayADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_come_way",  getName_come_wayCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("来院方式名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b2","id_come_way=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 陪送人员名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNames_companionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Names_companion",  getNames_companionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("陪送人员名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b3","ids_companion=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 检查询问名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNames_chk_noteADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Names_chk_note",  getNames_chk_noteCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("检查询问名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b4","ids_chk_note=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 呼吸状态名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_breath_stateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_breath_state",  getName_breath_stateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("呼吸状态名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b5","id_breath_state=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 检伤分类名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_triage_caADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_triage_ca",  getName_triage_caCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("检伤分类名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"BD_TRIAGE_CA a0b6","id_triage_ca=id_triageca","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 检伤主诉名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_triage_cmptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_triage_cmpt",  getName_triage_cmptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("检伤主诉名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"BD_TRIAGE_CMPT a0b7","id_triage_cmpt=id_triagecmpt","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 检伤判定名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_triage_resADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_triage_res",  getName_triage_resCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("检伤判定名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"BD_TRIAGE_RES a0b8","id_triage_res=id_triageres","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 分诊科室名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dep_toADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dep_to",  getName_dep_toCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("分诊科室名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b9","id_dep_to=id_dep","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 分诊科室编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_dep_toADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_dep_to",  getCode_dep_toCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("分诊科室编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b9","id_dep_to=id_dep","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 绿色通道名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNames_green_channelADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Names_green_channel",  getNames_green_channelCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("绿色通道名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b10","ids_green_channel_sym=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 预检人员姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_emp_preADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_emp_pre",  getName_emp_preCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("预检人员姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b11","id_emp_pre=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取预检主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_erpreCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_erpre");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("预检主键"); 
		return column;
	}
	/**
	 * 获取集团id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_grpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_grp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("集团id"); 
		return column;
	}
	/**
	 * 获取组织id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_orgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_org");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("组织id"); 
		return column;
	}
	/**
	 * 获取预检码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("预检码"); 
		return column;
	}
	/**
	 * 获取患者id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pat");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者id"); 
		return column;
	}
	/**
	 * 获取患者姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_pat");
		column.setLength(150);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者姓名"); 
		return column;
	}
	/**
	 * 获取第一次就诊id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ent_fstCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ent_fst");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("第一次就诊id"); 
		return column;
	}
	/**
	 * 获取最后一次就诊id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ent_lastCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ent_last");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("最后一次就诊id"); 
		return column;
	}
	/**
	 * 获取三无人员标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_nonpersonCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_nonperson");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("三无人员标志"); 
		return column;
	}
	/**
	 * 获取来院时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_entryCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_entry");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("来院时间"); 
		return column;
	}
	/**
	 * 获取来院方式id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_come_wayCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_come_way");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("来院方式id"); 
		return column;
	}
	/**
	 * 获取来院方式编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_come_wayCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_come_way");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("来院方式编码"); 
		return column;
	}
	/**
	 * 获取陪送人员ids表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIds_companionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ids_companion");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("陪送人员ids"); 
		return column;
	}
	/**
	 * 获取陪送人员编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSds_companionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sds_companion");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("陪送人员编码"); 
		return column;
	}
	/**
	 * 获取流行病学史标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_chk_eqidemicCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_chk_eqidemic");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("流行病学史标志"); 
		return column;
	}
	/**
	 * 获取检查询问ids表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIds_chk_noteCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ids_chk_note");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("检查询问ids"); 
		return column;
	}
	/**
	 * 获取检查询问编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSds_chk_noteCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sds_chk_note");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("检查询问编码"); 
		return column;
	}
	/**
	 * 获取采集生命体征时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_pick_vsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_pick_vs");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("采集生命体征时间"); 
		return column;
	}
	/**
	 * 获取呼吸状态ids表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_breath_stateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_breath_state");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("呼吸状态ids"); 
		return column;
	}
	/**
	 * 获取呼吸状态编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_breath_stateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_breath_state");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("呼吸状态编码"); 
		return column;
	}
	/**
	 * 获取主诉描述表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDes_cmptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Des_cmpt");
		column.setLength(3000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("主诉描述"); 
		return column;
	}
	/**
	 * 获取检伤分类id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_triage_caCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_triage_ca");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("检伤分类id"); 
		return column;
	}
	/**
	 * 获取检伤主诉id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_triage_cmptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_triage_cmpt");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("检伤主诉id"); 
		return column;
	}
	/**
	 * 获取检伤判定id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_triage_resCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_triage_res");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("检伤判定id"); 
		return column;
	}
	/**
	 * 获取分级编码_自动表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_scale_autoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_scale_auto");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("分级编码_自动"); 
		return column;
	}
	/**
	 * 获取分级编码_手动表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_scale_hmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_scale_hm");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("分级编码_手动"); 
		return column;
	}
	/**
	 * 获取分级编码_主诉判定表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_scale_cmptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_scale_cmpt");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("分级编码_主诉判定"); 
		return column;
	}
	/**
	 * 获取分诊科室id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dep_toCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep_to");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("分诊科室id"); 
		return column;
	}
	/**
	 * 获取绿色通道标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_green_channelCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_green_channel");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("绿色通道标志"); 
		return column;
	}
	/**
	 * 获取绿色通道症状ids表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIds_green_channel_symCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ids_green_channel_sym");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("绿色通道症状ids"); 
		return column;
	}
	/**
	 * 获取绿色通道症状编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSds_green_channel_symCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sds_green_channel_sym");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("绿色通道症状编码"); 
		return column;
	}
	/**
	 * 获取分诊去向表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_triage_toCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_triage_to");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("分诊去向"); 
		return column;
	}
	/**
	 * 获取预检人员id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_preCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_pre");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("预检人员id"); 
		return column;
	}
	/**
	 * 获取结束时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_endCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_end");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("结束时间"); 
		return column;
	}
	/**
	 * 获取状态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_statusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_status");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("状态"); 
		return column;
	}
	/**
	 * 获取留观就诊id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ent_ipCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ent_ip");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("留观就诊id"); 
		return column;
	}
	/**
	 * 获取留观预检状态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_status_ipCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_status_ip");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("留观预检状态"); 
		return column;
	}
	/**
	 * 获取留观结束时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_end_ipCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_end_ip");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("留观结束时间"); 
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
	 * 获取拒绝标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_refuse_exaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_refuse_exa");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("拒绝标志"); 
		return column;
	}
	/**
	 * 获取来院方式名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_come_wayCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_come_way");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("来院方式名称"); 
		return column;
	}
	/**
	 * 获取陪送人员名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNames_companionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Names_companion");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("陪送人员名称"); 
		return column;
	}
	/**
	 * 获取检查询问名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNames_chk_noteCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Names_chk_note");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("检查询问名称"); 
		return column;
	}
	/**
	 * 获取呼吸状态名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_breath_stateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_breath_state");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("呼吸状态名称"); 
		return column;
	}
	/**
	 * 获取检伤分类名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_triage_caCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_triage_ca");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("检伤分类名称"); 
		return column;
	}
	/**
	 * 获取检伤主诉名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_triage_cmptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_triage_cmpt");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("检伤主诉名称"); 
		return column;
	}
	/**
	 * 获取检伤判定名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_triage_resCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_triage_res");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("检伤判定名称"); 
		return column;
	}
	/**
	 * 获取分诊科室名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_dep_toCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dep_to");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("分诊科室名称"); 
		return column;
	}
	/**
	 * 获取分诊科室编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_dep_toCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_dep_to");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("分诊科室编码"); 
		return column;
	}
	/**
	 * 获取绿色通道名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNames_green_channelCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Names_green_channel");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("绿色通道名称"); 
		return column;
	}
	/**
	 * 获取预检人员姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_emp_preCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_emp_pre");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("预检人员姓名"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id","Id_erpre");
		iBDDataInfoFldMap.put("id_org","Id_org");
		iBDDataInfoFldMap.put("code","Code");
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
		defaultValueMap.put("Fg_refuse_exa",new xap.mw.coreitf.d.FBoolean("N"));
	}
	
}
