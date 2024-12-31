
package iih.sfda.aer.sfdaaerevdinfureac.d.desc;

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
 * 输液反应事件 DO 元数据信息
 */
public class SfdaAerEvDInfuReacDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.sfda.aer.sfdaaerevdinfureac.d.SfdaAerEvDInfuReacDO";
	public static final String CLASS_DISPALYNAME = "输液反应事件";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "SFDA_AER_EV_DINFUREAC";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_aer_ev_dinfureac";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public SfdaAerEvDInfuReacDODesc(){
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
		this.setKeyDesc(getId_aer_ev_dinfureacADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_aer_ev_dinfureacADesc(tblDesc));
		this.add(getId_aer_evADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getMedic_diagnADesc(tblDesc));
		this.add(getLiquid_nameADesc(tblDesc));
		this.add(getInfu_chge_tmADesc(tblDesc));
		this.add(getAppe_disc_tmADesc(tblDesc));
		this.add(getPat_clin_featADesc(tblDesc));
		this.add(getEu_chillADesc(tblDesc));
		this.add(getEu_rashADesc(tblDesc));
		this.add(getId_rash_partsADesc(tblDesc));
		this.add(getSd_rash_partsADesc(tblDesc));
		this.add(getId_pruritusADesc(tblDesc));
		this.add(getSd_pruritusADesc(tblDesc));
		this.add(getEu_dyspneicADesc(tblDesc));
		this.add(getOth_expreADesc(tblDesc));
		this.add(getId_handleADesc(tblDesc));
		this.add(getSd_handleADesc(tblDesc));
		this.add(getOth_handleADesc(tblDesc));
		this.add(getBy_doct_giveADesc(tblDesc));
		this.add(getPat_remit_tmADesc(tblDesc));
		this.add(getPat_remit_stateADesc(tblDesc));
		this.add(getId_infu_refdrugADesc(tblDesc));
		this.add(getSd_infu_refdrugADesc(tblDesc));
		this.add(getInfu_refdrug_descADesc(tblDesc));
		this.add(getId_conf_refapplADesc(tblDesc));
		this.add(getSd_conf_refapplADesc(tblDesc));
		this.add(getConf_refappl_descADesc(tblDesc));
		this.add(getId_liqconf_siteADesc(tblDesc));
		this.add(getSd_liqconf_siteADesc(tblDesc));
		this.add(getDrug_use_dayADesc(tblDesc));
		this.add(getId_irrit_testresADesc(tblDesc));
		this.add(getSd_irrit_testresADesc(tblDesc));
		this.add(getIrrit_testres_tmADesc(tblDesc));
		this.add(getId_infu_wayADesc(tblDesc));
		this.add(getSd_infu_wayADesc(tblDesc));
		this.add(getPunct_dateADesc(tblDesc));
		this.add(getPunct_partADesc(tblDesc));
		this.add(getPunct_part_nurwayADesc(tblDesc));
		this.add(getInfu_conf_tmADesc(tblDesc));
		this.add(getInfu_capacityADesc(tblDesc));
		this.add(getInfu_speedADesc(tblDesc));
		this.add(getEu_safekeepADesc(tblDesc));
		this.add(getEu_put_closetADesc(tblDesc));
		this.add(getEu_inspectADesc(tblDesc));
		this.add(getInspect_dateADesc(tblDesc));
		this.add(getInspect_depADesc(tblDesc));
		this.add(getSoup_culti_resuADesc(tblDesc));
		this.add(getReas_analyADesc(tblDesc));
		this.add(getDosage_nurseADesc(tblDesc));
		this.add(getPunct_nurseADesc(tblDesc));
		this.add(getWard_head_nurseADesc(tblDesc));
		this.add(getDef1ADesc(tblDesc));
		this.add(getDef2ADesc(tblDesc));
		this.add(getDef3ADesc(tblDesc));
		this.add(getDef4ADesc(tblDesc));
		this.add(getDef5ADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getTempADesc(tblDesc));
		this.add(getPulseADesc(tblDesc));
		this.add(getDbpADesc(tblDesc));
		this.add(getSbpADesc(tblDesc));
		this.add(getSpo2ADesc(tblDesc));
		this.add(getName_grpADesc(tblDesc));
		this.add(getName_orgADesc(tblDesc));
		this.add(getName_rash_partsADesc(tblDesc));
		this.add(getName_pruritusADesc(tblDesc));
		this.add(getName_handleADesc(tblDesc));
		this.add(getName_infu_refdrugADesc(tblDesc));
		this.add(getName_conf_refapplADesc(tblDesc));
		this.add(getName_liqconf_siteADesc(tblDesc));
		this.add(getName_irrit_testresADesc(tblDesc));
		this.add(getName_infu_wayADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_aer_ev_dinfureacCDesc(tblDesc));
		tblDesc.add(getId_aer_ev_dinfureacCDesc(tblDesc));
		tblDesc.add(getId_aer_evCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getMedic_diagnCDesc(tblDesc));
		tblDesc.add(getLiquid_nameCDesc(tblDesc));
		tblDesc.add(getInfu_chge_tmCDesc(tblDesc));
		tblDesc.add(getAppe_disc_tmCDesc(tblDesc));
		tblDesc.add(getPat_clin_featCDesc(tblDesc));
		tblDesc.add(getEu_chillCDesc(tblDesc));
		tblDesc.add(getEu_rashCDesc(tblDesc));
		tblDesc.add(getId_rash_partsCDesc(tblDesc));
		tblDesc.add(getSd_rash_partsCDesc(tblDesc));
		tblDesc.add(getId_pruritusCDesc(tblDesc));
		tblDesc.add(getSd_pruritusCDesc(tblDesc));
		tblDesc.add(getEu_dyspneicCDesc(tblDesc));
		tblDesc.add(getOth_expreCDesc(tblDesc));
		tblDesc.add(getId_handleCDesc(tblDesc));
		tblDesc.add(getSd_handleCDesc(tblDesc));
		tblDesc.add(getOth_handleCDesc(tblDesc));
		tblDesc.add(getBy_doct_giveCDesc(tblDesc));
		tblDesc.add(getPat_remit_tmCDesc(tblDesc));
		tblDesc.add(getPat_remit_stateCDesc(tblDesc));
		tblDesc.add(getId_infu_refdrugCDesc(tblDesc));
		tblDesc.add(getSd_infu_refdrugCDesc(tblDesc));
		tblDesc.add(getInfu_refdrug_descCDesc(tblDesc));
		tblDesc.add(getId_conf_refapplCDesc(tblDesc));
		tblDesc.add(getSd_conf_refapplCDesc(tblDesc));
		tblDesc.add(getConf_refappl_descCDesc(tblDesc));
		tblDesc.add(getId_liqconf_siteCDesc(tblDesc));
		tblDesc.add(getSd_liqconf_siteCDesc(tblDesc));
		tblDesc.add(getDrug_use_dayCDesc(tblDesc));
		tblDesc.add(getId_irrit_testresCDesc(tblDesc));
		tblDesc.add(getSd_irrit_testresCDesc(tblDesc));
		tblDesc.add(getIrrit_testres_tmCDesc(tblDesc));
		tblDesc.add(getId_infu_wayCDesc(tblDesc));
		tblDesc.add(getSd_infu_wayCDesc(tblDesc));
		tblDesc.add(getPunct_dateCDesc(tblDesc));
		tblDesc.add(getPunct_partCDesc(tblDesc));
		tblDesc.add(getPunct_part_nurwayCDesc(tblDesc));
		tblDesc.add(getInfu_conf_tmCDesc(tblDesc));
		tblDesc.add(getInfu_capacityCDesc(tblDesc));
		tblDesc.add(getInfu_speedCDesc(tblDesc));
		tblDesc.add(getEu_safekeepCDesc(tblDesc));
		tblDesc.add(getEu_put_closetCDesc(tblDesc));
		tblDesc.add(getEu_inspectCDesc(tblDesc));
		tblDesc.add(getInspect_dateCDesc(tblDesc));
		tblDesc.add(getInspect_depCDesc(tblDesc));
		tblDesc.add(getSoup_culti_resuCDesc(tblDesc));
		tblDesc.add(getReas_analyCDesc(tblDesc));
		tblDesc.add(getDosage_nurseCDesc(tblDesc));
		tblDesc.add(getPunct_nurseCDesc(tblDesc));
		tblDesc.add(getWard_head_nurseCDesc(tblDesc));
		tblDesc.add(getDef1CDesc(tblDesc));
		tblDesc.add(getDef2CDesc(tblDesc));
		tblDesc.add(getDef3CDesc(tblDesc));
		tblDesc.add(getDef4CDesc(tblDesc));
		tblDesc.add(getDef5CDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		tblDesc.add(getTempCDesc(tblDesc));
		tblDesc.add(getPulseCDesc(tblDesc));
		tblDesc.add(getDbpCDesc(tblDesc));
		tblDesc.add(getSbpCDesc(tblDesc));
		tblDesc.add(getSpo2CDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 输液反应事件主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_aer_ev_dinfureacADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_aer_ev_dinfureac",  getId_aer_ev_dinfureacCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("输液反应事件主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 事件外键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_aer_evADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_aer_ev",  getId_aer_evCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("事件外键");
		attrDesc.setNullable(true);
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
	 * 医疗诊断属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMedic_diagnADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Medic_diagn",  getMedic_diagnCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医疗诊断");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 液体名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getLiquid_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Liquid_name",  getLiquid_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("液体名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 输液更换时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInfu_chge_tmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Infu_chge_tm",  getInfu_chge_tmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("输液更换时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 出现不适时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAppe_disc_tmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Appe_disc_tm",  getAppe_disc_tmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("出现不适时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者的临床表现属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPat_clin_featADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pat_clin_feat",  getPat_clin_featCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者的临床表现");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 寒战属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_chillADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_chill",  getEu_chillCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("寒战");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 疹属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_rashADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_rash",  getEu_rashCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("疹");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 皮疹部位id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_rash_partsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_rash_parts",  getId_rash_partsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("皮疹部位id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 皮疹部位编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_rash_partsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_rash_parts",  getSd_rash_partsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("皮疹部位编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 骚痒id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pruritusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pruritus",  getId_pruritusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("骚痒id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 骚痒编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_pruritusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_pruritus",  getSd_pruritusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("骚痒编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 呼吸困难属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_dyspneicADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_dyspneic",  getEu_dyspneicCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("呼吸困难");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 其它表现属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOth_expreADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Oth_expre",  getOth_expreCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("其它表现");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 处理id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_handleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_handle",  getId_handleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("处理id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 处理编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_handleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_handle",  getSd_handleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("处理编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 其他处理属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOth_handleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Oth_handle",  getOth_handleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("其他处理");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 遵医嘱给予属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBy_doct_giveADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("By_doct_give",  getBy_doct_giveCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("遵医嘱给予");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 处理后患者缓解时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPat_remit_tmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pat_remit_tm",  getPat_remit_tmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("处理后患者缓解时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 处理后患者缓解状况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPat_remit_stateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pat_remit_state",  getPat_remit_stateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("处理后患者缓解状况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 液体输入过程涉及药品id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_infu_refdrugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_infu_refdrug",  getId_infu_refdrugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("液体输入过程涉及药品id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 液体输入过程涉及药品编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_infu_refdrugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_infu_refdrug",  getSd_infu_refdrugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("液体输入过程涉及药品编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 液体输入过程涉及药品描述属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInfu_refdrug_descADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Infu_refdrug_desc",  getInfu_refdrug_descCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("液体输入过程涉及药品描述");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 配置过程中涉及医疗器械id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_conf_refapplADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_conf_refappl",  getId_conf_refapplCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("配置过程中涉及医疗器械id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 配置过程中涉及医疗器械编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_conf_refapplADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_conf_refappl",  getSd_conf_refapplCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("配置过程中涉及医疗器械编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 配置过程中涉及医疗器械描述属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getConf_refappl_descADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Conf_refappl_desc",  getConf_refappl_descCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("配置过程中涉及医疗器械描述");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 液体配置地点id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_liqconf_siteADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_liqconf_site",  getId_liqconf_siteCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("液体配置地点id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 液体配置地点编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_liqconf_siteADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_liqconf_site",  getSd_liqconf_siteCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("液体配置地点编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 药物已使用天数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDrug_use_dayADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Drug_use_day",  getDrug_use_dayCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("药物已使用天数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 用药过敏试验结果id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_irrit_testresADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_irrit_testres",  getId_irrit_testresCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用药过敏试验结果id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 用药过敏试验结果编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_irrit_testresADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_irrit_testres",  getSd_irrit_testresCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用药过敏试验结果编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 用药过敏试验时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIrrit_testres_tmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Irrit_testres_tm",  getIrrit_testres_tmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("用药过敏试验时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 输液方式id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_infu_wayADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_infu_way",  getId_infu_wayCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("输液方式id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 输液方式编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_infu_wayADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_infu_way",  getSd_infu_wayCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("输液方式编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 穿刺日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPunct_dateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Punct_date",  getPunct_dateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("穿刺日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 穿刺部位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPunct_partADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Punct_part",  getPunct_partCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("穿刺部位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 穿刺部位护理方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPunct_part_nurwayADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Punct_part_nurway",  getPunct_part_nurwayCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("穿刺部位护理方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 液体配置后几分钟后输入属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInfu_conf_tmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Infu_conf_tm",  getInfu_conf_tmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("液体配置后几分钟后输入");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 已输入液体容量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInfu_capacityADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Infu_capacity",  getInfu_capacityCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("已输入液体容量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 输液速度属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInfu_speedADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Infu_speed",  getInfu_speedCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("输液速度");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否封存属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_safekeepADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_safekeep",  getEu_safekeepCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("是否封存");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否放置于冷藏室属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_put_closetADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_put_closet",  getEu_put_closetCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("是否放置于冷藏室");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否送检属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_inspectADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_inspect",  getEu_inspectCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("是否送检");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 送检日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInspect_dateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Inspect_date",  getInspect_dateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("送检日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 送检部门属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInspect_depADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Inspect_dep",  getInspect_depCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("送检部门");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 药液培养结果属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSoup_culti_resuADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Soup_culti_resu",  getSoup_culti_resuCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("药液培养结果");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 原因分析属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getReas_analyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Reas_analy",  getReas_analyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("原因分析");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 配药护士属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDosage_nurseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dosage_nurse",  getDosage_nurseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("配药护士");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 穿刺护士属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPunct_nurseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Punct_nurse",  getPunct_nurseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("穿刺护士");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 病房护士长属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWard_head_nurseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ward_head_nurse",  getWard_head_nurseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病房护士长");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段1属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef1ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def1",  getDef1CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段1");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段2属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef2ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def2",  getDef2CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段2");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段3属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef3ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def3",  getDef3CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段3");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段4属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef4ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def4",  getDef4CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段4");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段5属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef5ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def5",  getDef5CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段5");
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
	 * T属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTempADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Temp",  getTempCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("T");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * P属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPulseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pulse",  getPulseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("P");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * DBp属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDbpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dbp",  getDbpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("DBp");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * SBp属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSbpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sbp",  getSbpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("SBp");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * Spo2属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSpo2ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Spo2",  getSpo2CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("Spo2");
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
	private IAttrDesc getName_grpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_grp",  getName_grpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_grp a0b2","id_grp=id_grp","name"});
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
		attrDesc.setRefTblInfos(new String[]{"bd_org a0b3","id_org=id_org","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_rash_partsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_rash_parts",  getName_rash_partsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b6","id_rash_parts=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_pruritusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_pruritus",  getName_pruritusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b7","id_pruritus=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_handleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_handle",  getName_handleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b8","id_handle=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_infu_refdrugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_infu_refdrug",  getName_infu_refdrugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b9","id_infu_refdrug=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_conf_refapplADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_conf_refappl",  getName_conf_refapplCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b10","id_conf_refappl=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_liqconf_siteADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_liqconf_site",  getName_liqconf_siteCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b11","id_liqconf_site=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_irrit_testresADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_irrit_testres",  getName_irrit_testresCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b12","id_irrit_testres=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_infu_wayADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_infu_way",  getName_infu_wayCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b13","id_infu_way=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取输液反应事件主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_aer_ev_dinfureacCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_aer_ev_dinfureac");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("输液反应事件主键"); 
		return column;
	}
	/**
	 * 获取事件外键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_aer_evCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_aer_ev");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("事件外键"); 
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
	 * 获取医疗诊断表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMedic_diagnCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Medic_diagn");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医疗诊断"); 
		return column;
	}
	/**
	 * 获取液体名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getLiquid_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Liquid_name");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("液体名称"); 
		return column;
	}
	/**
	 * 获取输液更换时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInfu_chge_tmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Infu_chge_tm");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("输液更换时间"); 
		return column;
	}
	/**
	 * 获取出现不适时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAppe_disc_tmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Appe_disc_tm");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("出现不适时间"); 
		return column;
	}
	/**
	 * 获取患者的临床表现表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPat_clin_featCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pat_clin_feat");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者的临床表现"); 
		return column;
	}
	/**
	 * 获取寒战表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_chillCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_chill");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("寒战"); 
		return column;
	}
	/**
	 * 获取疹表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_rashCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_rash");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("疹"); 
		return column;
	}
	/**
	 * 获取皮疹部位id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_rash_partsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_rash_parts");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("皮疹部位id"); 
		return column;
	}
	/**
	 * 获取皮疹部位编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_rash_partsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_rash_parts");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("皮疹部位编码"); 
		return column;
	}
	/**
	 * 获取骚痒id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pruritusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pruritus");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("骚痒id"); 
		return column;
	}
	/**
	 * 获取骚痒编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_pruritusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_pruritus");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("骚痒编码"); 
		return column;
	}
	/**
	 * 获取呼吸困难表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_dyspneicCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_dyspneic");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("呼吸困难"); 
		return column;
	}
	/**
	 * 获取其它表现表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOth_expreCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Oth_expre");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("其它表现"); 
		return column;
	}
	/**
	 * 获取处理id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_handleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_handle");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("处理id"); 
		return column;
	}
	/**
	 * 获取处理编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_handleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_handle");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("处理编码"); 
		return column;
	}
	/**
	 * 获取其他处理表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOth_handleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Oth_handle");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("其他处理"); 
		return column;
	}
	/**
	 * 获取遵医嘱给予表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBy_doct_giveCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"By_doct_give");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("遵医嘱给予"); 
		return column;
	}
	/**
	 * 获取处理后患者缓解时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPat_remit_tmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pat_remit_tm");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("处理后患者缓解时间"); 
		return column;
	}
	/**
	 * 获取处理后患者缓解状况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPat_remit_stateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pat_remit_state");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("处理后患者缓解状况"); 
		return column;
	}
	/**
	 * 获取液体输入过程涉及药品id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_infu_refdrugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_infu_refdrug");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("液体输入过程涉及药品id"); 
		return column;
	}
	/**
	 * 获取液体输入过程涉及药品编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_infu_refdrugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_infu_refdrug");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("液体输入过程涉及药品编码"); 
		return column;
	}
	/**
	 * 获取液体输入过程涉及药品描述表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInfu_refdrug_descCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Infu_refdrug_desc");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("液体输入过程涉及药品描述"); 
		return column;
	}
	/**
	 * 获取配置过程中涉及医疗器械id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_conf_refapplCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_conf_refappl");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("配置过程中涉及医疗器械id"); 
		return column;
	}
	/**
	 * 获取配置过程中涉及医疗器械编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_conf_refapplCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_conf_refappl");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("配置过程中涉及医疗器械编码"); 
		return column;
	}
	/**
	 * 获取配置过程中涉及医疗器械描述表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getConf_refappl_descCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Conf_refappl_desc");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("配置过程中涉及医疗器械描述"); 
		return column;
	}
	/**
	 * 获取液体配置地点id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_liqconf_siteCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_liqconf_site");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("液体配置地点id"); 
		return column;
	}
	/**
	 * 获取液体配置地点编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_liqconf_siteCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_liqconf_site");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("液体配置地点编码"); 
		return column;
	}
	/**
	 * 获取药物已使用天数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDrug_use_dayCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Drug_use_day");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("药物已使用天数"); 
		return column;
	}
	/**
	 * 获取用药过敏试验结果id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_irrit_testresCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_irrit_testres");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("用药过敏试验结果id"); 
		return column;
	}
	/**
	 * 获取用药过敏试验结果编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_irrit_testresCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_irrit_testres");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("用药过敏试验结果编码"); 
		return column;
	}
	/**
	 * 获取用药过敏试验时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIrrit_testres_tmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Irrit_testres_tm");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("用药过敏试验时间"); 
		return column;
	}
	/**
	 * 获取输液方式id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_infu_wayCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_infu_way");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("输液方式id"); 
		return column;
	}
	/**
	 * 获取输液方式编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_infu_wayCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_infu_way");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("输液方式编码"); 
		return column;
	}
	/**
	 * 获取穿刺日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPunct_dateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Punct_date");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("穿刺日期"); 
		return column;
	}
	/**
	 * 获取穿刺部位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPunct_partCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Punct_part");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("穿刺部位"); 
		return column;
	}
	/**
	 * 获取穿刺部位护理方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPunct_part_nurwayCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Punct_part_nurway");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("穿刺部位护理方式"); 
		return column;
	}
	/**
	 * 获取液体配置后几分钟后输入表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInfu_conf_tmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Infu_conf_tm");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("液体配置后几分钟后输入"); 
		return column;
	}
	/**
	 * 获取已输入液体容量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInfu_capacityCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Infu_capacity");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("已输入液体容量"); 
		return column;
	}
	/**
	 * 获取输液速度表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInfu_speedCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Infu_speed");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("输液速度"); 
		return column;
	}
	/**
	 * 获取是否封存表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_safekeepCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_safekeep");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("是否封存"); 
		return column;
	}
	/**
	 * 获取是否放置于冷藏室表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_put_closetCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_put_closet");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("是否放置于冷藏室"); 
		return column;
	}
	/**
	 * 获取是否送检表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_inspectCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_inspect");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("是否送检"); 
		return column;
	}
	/**
	 * 获取送检日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInspect_dateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Inspect_date");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("送检日期"); 
		return column;
	}
	/**
	 * 获取送检部门表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInspect_depCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Inspect_dep");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("送检部门"); 
		return column;
	}
	/**
	 * 获取药液培养结果表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSoup_culti_resuCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Soup_culti_resu");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("药液培养结果"); 
		return column;
	}
	/**
	 * 获取原因分析表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getReas_analyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Reas_analy");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("原因分析"); 
		return column;
	}
	/**
	 * 获取配药护士表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDosage_nurseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dosage_nurse");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("配药护士"); 
		return column;
	}
	/**
	 * 获取穿刺护士表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPunct_nurseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Punct_nurse");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("穿刺护士"); 
		return column;
	}
	/**
	 * 获取病房护士长表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWard_head_nurseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ward_head_nurse");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病房护士长"); 
		return column;
	}
	/**
	 * 获取客户扩展字段1表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef1CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def1");
		column.setLength(110);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段1"); 
		return column;
	}
	/**
	 * 获取客户扩展字段2表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef2CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def2");
		column.setLength(110);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段2"); 
		return column;
	}
	/**
	 * 获取客户扩展字段3表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef3CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def3");
		column.setLength(110);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段3"); 
		return column;
	}
	/**
	 * 获取客户扩展字段4表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef4CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def4");
		column.setLength(110);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段4"); 
		return column;
	}
	/**
	 * 获取客户扩展字段5表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef5CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def5");
		column.setLength(110);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段5"); 
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
	 * 获取T表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTempCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Temp");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("T"); 
		return column;
	}
	/**
	 * 获取P表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPulseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pulse");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("P"); 
		return column;
	}
	/**
	 * 获取DBp表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDbpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dbp");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("DBp"); 
		return column;
	}
	/**
	 * 获取SBp表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSbpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sbp");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("SBp"); 
		return column;
	}
	/**
	 * 获取Spo2表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSpo2CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Spo2");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("Spo2"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_grpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_grp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
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
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_rash_partsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_rash_parts");
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
	private IColumnDesc getName_pruritusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_pruritus");
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
	private IColumnDesc getName_handleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_handle");
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
	private IColumnDesc getName_infu_refdrugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_infu_refdrug");
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
	private IColumnDesc getName_conf_refapplCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_conf_refappl");
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
	private IColumnDesc getName_liqconf_siteCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_liqconf_site");
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
	private IColumnDesc getName_irrit_testresCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_irrit_testres");
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
	private IColumnDesc getName_infu_wayCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_infu_way");
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
		iBDDataInfoFldMap.put("id","Id_aer_ev_dinfureac");
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
