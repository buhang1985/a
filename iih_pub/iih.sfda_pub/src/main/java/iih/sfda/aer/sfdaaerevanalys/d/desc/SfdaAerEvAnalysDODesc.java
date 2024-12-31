
package iih.sfda.aer.sfdaaerevanalys.d.desc;

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
 * 分析报告 DO 元数据信息
 */
public class SfdaAerEvAnalysDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.sfda.aer.sfdaaerevanalys.d.SfdaAerEvAnalysDO";
	public static final String CLASS_DISPALYNAME = "分析报告";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "SFDA_AER_EV_ANALYS";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_aer_ev_analys";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public SfdaAerEvAnalysDODesc(){
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
		this.setKeyDesc(getId_aer_ev_analysADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_aer_ev_analysADesc(tblDesc));
		this.add(getId_aer_evADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_relcp_freqADesc(tblDesc));
		this.add(getSd_relcp_freqADesc(tblDesc));
		this.add(getId_emper_factorADesc(tblDesc));
		this.add(getSd_emper_factorADesc(tblDesc));
		this.add(getOth_emper_factorADesc(tblDesc));
		this.add(getId_patbp_factorADesc(tblDesc));
		this.add(getSd_patbp_factorADesc(tblDesc));
		this.add(getOth_patbp_factorADesc(tblDesc));
		this.add(getId_equip_factorADesc(tblDesc));
		this.add(getSd_equip_factorADesc(tblDesc));
		this.add(getOth_equip_factorADesc(tblDesc));
		this.add(getId_usedrug_factorADesc(tblDesc));
		this.add(getSd_usedrug_factorADesc(tblDesc));
		this.add(getOth_usedrug_factorADesc(tblDesc));
		this.add(getId_worksta_factorADesc(tblDesc));
		this.add(getSd_worksta_factorADesc(tblDesc));
		this.add(getOth_worksta_factorADesc(tblDesc));
		this.add(getId_communi_factorADesc(tblDesc));
		this.add(getSd_communi_factorADesc(tblDesc));
		this.add(getOth_communi_factorADesc(tblDesc));
		this.add(getId_envir_factorADesc(tblDesc));
		this.add(getSd_envir_factorADesc(tblDesc));
		this.add(getOth_envir_factorADesc(tblDesc));
		this.add(getOth_poss_eventADesc(tblDesc));
		this.add(getId_streng_edutraADesc(tblDesc));
		this.add(getSd_streng_edutraADesc(tblDesc));
		this.add(getOth_streng_edutraADesc(tblDesc));
		this.add(getId_impro_medageADesc(tblDesc));
		this.add(getSd_impro_medageADesc(tblDesc));
		this.add(getOth_impro_medageADesc(tblDesc));
		this.add(getId_impro_adminiADesc(tblDesc));
		this.add(getSd_impro_adminiADesc(tblDesc));
		this.add(getOth_impro_adminiADesc(tblDesc));
		this.add(getId_streng_comstyADesc(tblDesc));
		this.add(getSd_streng_comstyADesc(tblDesc));
		this.add(getOth_streng_comstyADesc(tblDesc));
		this.add(getOth_step_waysADesc(tblDesc));
		this.add(getEn_opera_manruleADesc(tblDesc));
		this.add(getId_opera_manruleADesc(tblDesc));
		this.add(getSd_opera_manruleADesc(tblDesc));
		this.add(getId_serres_classADesc(tblDesc));
		this.add(getSd_serres_classADesc(tblDesc));
		this.add(getId_sever_levelADesc(tblDesc));
		this.add(getSd_sever_levelADesc(tblDesc));
		this.add(getOth_opera_manruleADesc(tblDesc));
		this.add(getOth_advise_ideaADesc(tblDesc));
		this.add(getDep_ideaADesc(tblDesc));
		this.add(getDef1ADesc(tblDesc));
		this.add(getDef2ADesc(tblDesc));
		this.add(getDef3ADesc(tblDesc));
		this.add(getDef4ADesc(tblDesc));
		this.add(getDef5ADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getName_grpADesc(tblDesc));
		this.add(getName_orgADesc(tblDesc));
		this.add(getName_relcp_freqADesc(tblDesc));
		this.add(getName_emper_factorADesc(tblDesc));
		this.add(getName_patbp_factorADesc(tblDesc));
		this.add(getName_equip_factorADesc(tblDesc));
		this.add(getName_usedrug_factorADesc(tblDesc));
		this.add(getName_worksta_factorADesc(tblDesc));
		this.add(getName_communi_factorADesc(tblDesc));
		this.add(getName_envir_factorADesc(tblDesc));
		this.add(getName_streng_edutraADesc(tblDesc));
		this.add(getName_impro_medageADesc(tblDesc));
		this.add(getName_impro_adminiADesc(tblDesc));
		this.add(getName_streng_comstyADesc(tblDesc));
		this.add(getName_opera_manruleADesc(tblDesc));
		this.add(getName_serres_classADesc(tblDesc));
		this.add(getName_sever_levelADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_aer_ev_analysCDesc(tblDesc));
		tblDesc.add(getId_aer_ev_analysCDesc(tblDesc));
		tblDesc.add(getId_aer_evCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_relcp_freqCDesc(tblDesc));
		tblDesc.add(getSd_relcp_freqCDesc(tblDesc));
		tblDesc.add(getId_emper_factorCDesc(tblDesc));
		tblDesc.add(getSd_emper_factorCDesc(tblDesc));
		tblDesc.add(getOth_emper_factorCDesc(tblDesc));
		tblDesc.add(getId_patbp_factorCDesc(tblDesc));
		tblDesc.add(getSd_patbp_factorCDesc(tblDesc));
		tblDesc.add(getOth_patbp_factorCDesc(tblDesc));
		tblDesc.add(getId_equip_factorCDesc(tblDesc));
		tblDesc.add(getSd_equip_factorCDesc(tblDesc));
		tblDesc.add(getOth_equip_factorCDesc(tblDesc));
		tblDesc.add(getId_usedrug_factorCDesc(tblDesc));
		tblDesc.add(getSd_usedrug_factorCDesc(tblDesc));
		tblDesc.add(getOth_usedrug_factorCDesc(tblDesc));
		tblDesc.add(getId_worksta_factorCDesc(tblDesc));
		tblDesc.add(getSd_worksta_factorCDesc(tblDesc));
		tblDesc.add(getOth_worksta_factorCDesc(tblDesc));
		tblDesc.add(getId_communi_factorCDesc(tblDesc));
		tblDesc.add(getSd_communi_factorCDesc(tblDesc));
		tblDesc.add(getOth_communi_factorCDesc(tblDesc));
		tblDesc.add(getId_envir_factorCDesc(tblDesc));
		tblDesc.add(getSd_envir_factorCDesc(tblDesc));
		tblDesc.add(getOth_envir_factorCDesc(tblDesc));
		tblDesc.add(getOth_poss_eventCDesc(tblDesc));
		tblDesc.add(getId_streng_edutraCDesc(tblDesc));
		tblDesc.add(getSd_streng_edutraCDesc(tblDesc));
		tblDesc.add(getOth_streng_edutraCDesc(tblDesc));
		tblDesc.add(getId_impro_medageCDesc(tblDesc));
		tblDesc.add(getSd_impro_medageCDesc(tblDesc));
		tblDesc.add(getOth_impro_medageCDesc(tblDesc));
		tblDesc.add(getId_impro_adminiCDesc(tblDesc));
		tblDesc.add(getSd_impro_adminiCDesc(tblDesc));
		tblDesc.add(getOth_impro_adminiCDesc(tblDesc));
		tblDesc.add(getId_streng_comstyCDesc(tblDesc));
		tblDesc.add(getSd_streng_comstyCDesc(tblDesc));
		tblDesc.add(getOth_streng_comstyCDesc(tblDesc));
		tblDesc.add(getOth_step_waysCDesc(tblDesc));
		tblDesc.add(getEn_opera_manruleCDesc(tblDesc));
		tblDesc.add(getId_opera_manruleCDesc(tblDesc));
		tblDesc.add(getSd_opera_manruleCDesc(tblDesc));
		tblDesc.add(getId_serres_classCDesc(tblDesc));
		tblDesc.add(getSd_serres_classCDesc(tblDesc));
		tblDesc.add(getId_sever_levelCDesc(tblDesc));
		tblDesc.add(getSd_sever_levelCDesc(tblDesc));
		tblDesc.add(getOth_opera_manruleCDesc(tblDesc));
		tblDesc.add(getOth_advise_ideaCDesc(tblDesc));
		tblDesc.add(getDep_ideaCDesc(tblDesc));
		tblDesc.add(getDef1CDesc(tblDesc));
		tblDesc.add(getDef2CDesc(tblDesc));
		tblDesc.add(getDef3CDesc(tblDesc));
		tblDesc.add(getDef4CDesc(tblDesc));
		tblDesc.add(getDef5CDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 分析报告主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_aer_ev_analysADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_aer_ev_analys",  getId_aer_ev_analysCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("分析报告主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 不良事件外键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_aer_evADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_aer_ev",  getId_aer_evCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("不良事件外键");
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
	 * 再发频率id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_relcp_freqADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_relcp_freq",  getId_relcp_freqCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("再发频率id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 再发频率编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_relcp_freqADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_relcp_freq",  getSd_relcp_freqCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("再发频率编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 与员工个人因素相关id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emper_factorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emper_factor",  getId_emper_factorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("与员工个人因素相关id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 与员工个人因素相关编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_emper_factorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_emper_factor",  getSd_emper_factorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("与员工个人因素相关编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 与员工其他因素相关属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOth_emper_factorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Oth_emper_factor",  getOth_emper_factorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("与员工其他因素相关");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 与病人生理及行为因素相关id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_patbp_factorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_patbp_factor",  getId_patbp_factorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("与病人生理及行为因素相关id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 与病人生理及行为因素相关编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_patbp_factorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_patbp_factor",  getSd_patbp_factorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("与病人生理及行为因素相关编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 与病人其他因素相关属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOth_patbp_factorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Oth_patbp_factor",  getOth_patbp_factorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("与病人其他因素相关");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 与器材设备因素相关id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_equip_factorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_equip_factor",  getId_equip_factorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("与器材设备因素相关id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 与器材设备因素相关编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_equip_factorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_equip_factor",  getSd_equip_factorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("与器材设备因素相关编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 与其他因素相关属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOth_equip_factorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Oth_equip_factor",  getOth_equip_factorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("与其他因素相关");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 与使用药物相关id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_usedrug_factorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_usedrug_factor",  getId_usedrug_factorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("与使用药物相关id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 与使用药物相关编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_usedrug_factorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_usedrug_factor",  getSd_usedrug_factorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("与使用药物相关编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 与使用其他药物相关属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOth_usedrug_factorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Oth_usedrug_factor",  getOth_usedrug_factorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("与使用其他药物相关");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 与工作状态/流程设计因素相关id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_worksta_factorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_worksta_factor",  getId_worksta_factorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("与工作状态/流程设计因素相关id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 与工作状态/流程设计因素相关编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_worksta_factorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_worksta_factor",  getSd_worksta_factorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("与工作状态/流程设计因素相关编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 其他因素相关属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOth_worksta_factorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Oth_worksta_factor",  getOth_worksta_factorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("其他因素相关");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 与沟通因素相关id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_communi_factorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_communi_factor",  getId_communi_factorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("与沟通因素相关id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 与沟通因素相关编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_communi_factorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_communi_factor",  getSd_communi_factorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("与沟通因素相关编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 与其他沟通因素相关属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOth_communi_factorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Oth_communi_factor",  getOth_communi_factorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("与其他沟通因素相关");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 与环境因素相关id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_envir_factorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_envir_factor",  getId_envir_factorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("与环境因素相关id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 与环境因素相关编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_envir_factorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_envir_factor",  getSd_envir_factorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("与环境因素相关编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 与环境其他因素相关属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOth_envir_factorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Oth_envir_factor",  getOth_envir_factorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("与环境其他因素相关");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 其他事件发生可能原因属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOth_poss_eventADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Oth_poss_event",  getOth_poss_eventCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("其他事件发生可能原因");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 加强教育培训id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_streng_edutraADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_streng_edutra",  getId_streng_edutraCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("加强教育培训id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 加强教育培训编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_streng_edutraADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_streng_edutra",  getSd_streng_edutraCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("加强教育培训编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 其他加强教育培训属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOth_streng_edutraADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Oth_streng_edutra",  getOth_streng_edutraCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("其他加强教育培训");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 改善医疗护理管理id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_impro_medageADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_impro_medage",  getId_impro_medageCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("改善医疗护理管理id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 改善医疗护理管理编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_impro_medageADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_impro_medage",  getSd_impro_medageCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("改善医疗护理管理编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 其他改善医疗护理管理属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOth_impro_medageADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Oth_impro_medage",  getOth_impro_medageCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("其他改善医疗护理管理");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 改善行政管理id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_impro_adminiADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_impro_admini",  getId_impro_adminiCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("改善行政管理id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 改善行政管理编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_impro_adminiADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_impro_admini",  getSd_impro_adminiCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("改善行政管理编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 其他改善行政管理属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOth_impro_adminiADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Oth_impro_admini",  getOth_impro_adminiCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("其他改善行政管理");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 加强沟通方式id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_streng_comstyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_streng_comsty",  getId_streng_comstyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("加强沟通方式id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 加强沟通方式编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_streng_comstyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_streng_comsty",  getSd_streng_comstyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("加强沟通方式编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 其他加强沟通方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOth_streng_comstyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Oth_streng_comsty",  getOth_streng_comstyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("其他加强沟通方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 其他预防措施或方法属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOth_step_waysADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Oth_step_ways",  getOth_step_waysCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("其他预防措施或方法");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 操作流程或管理规定属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEn_opera_manruleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("En_opera_manrule",  getEn_opera_manruleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("操作流程或管理规定");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 操作流程或管理规定id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_opera_manruleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_opera_manrule",  getId_opera_manruleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("操作流程或管理规定id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 操作流程或管理规定编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_opera_manruleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_opera_manrule",  getSd_opera_manruleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("操作流程或管理规定编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 严重结果分类id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_serres_classADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_serres_class",  getId_serres_classCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("严重结果分类id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 严重结果分类编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_serres_classADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_serres_class",  getSd_serres_classCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("严重结果分类编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 严重程度id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_sever_levelADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_sever_level",  getId_sever_levelCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("严重程度id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 严重程度编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_sever_levelADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_sever_level",  getSd_sever_levelCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("严重程度编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 其他操作流程或管理规定属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOth_opera_manruleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Oth_opera_manrule",  getOth_opera_manruleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("其他操作流程或管理规定");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 其他建议或意见属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOth_advise_ideaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Oth_advise_idea",  getOth_advise_ideaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("其他建议或意见");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 主管部门意见属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDep_ideaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dep_idea",  getDep_ideaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("主管部门意见");
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
	 * 扩展字段1属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_relcp_freqADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_relcp_freq",  getName_relcp_freqCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("扩展字段1");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b7","id_relcp_freq=id_udidoc","ctrl1"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 扩展字段1属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_emper_factorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_emper_factor",  getName_emper_factorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("扩展字段1");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b6","id_emper_factor=id_udidoc","ctrl1"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 扩展字段1属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_patbp_factorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_patbp_factor",  getName_patbp_factorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("扩展字段1");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b8","id_patbp_factor=id_udidoc","ctrl1"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 扩展字段1属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_equip_factorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_equip_factor",  getName_equip_factorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("扩展字段1");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b9","id_equip_factor=id_udidoc","ctrl1"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_usedrug_factorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_usedrug_factor",  getName_usedrug_factorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b10","id_usedrug_factor=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_worksta_factorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_worksta_factor",  getName_worksta_factorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b11","id_worksta_factor=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_communi_factorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_communi_factor",  getName_communi_factorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b12","id_communi_factor=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_envir_factorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_envir_factor",  getName_envir_factorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b13","id_envir_factor=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_streng_edutraADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_streng_edutra",  getName_streng_edutraCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b14","id_streng_edutra=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_impro_medageADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_impro_medage",  getName_impro_medageCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b15","id_impro_medage=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 扩展字段1属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_impro_adminiADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_impro_admini",  getName_impro_adminiCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("扩展字段1");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b16","id_impro_admini=id_udidoc","ctrl1"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_streng_comstyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_streng_comsty",  getName_streng_comstyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b17","id_streng_comsty=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_opera_manruleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_opera_manrule",  getName_opera_manruleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b18","id_opera_manrule=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 扩展字段1属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_serres_classADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_serres_class",  getName_serres_classCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("扩展字段1");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b19","id_serres_class=id_udidoc","ctrl1"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 扩展字段1属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_sever_levelADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_sever_level",  getName_sever_levelCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("扩展字段1");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b20","id_sever_level=id_udidoc","ctrl1"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取分析报告主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_aer_ev_analysCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_aer_ev_analys");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("分析报告主键"); 
		return column;
	}
	/**
	 * 获取不良事件外键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_aer_evCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_aer_ev");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("不良事件外键"); 
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
	 * 获取再发频率id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_relcp_freqCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_relcp_freq");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("再发频率id"); 
		return column;
	}
	/**
	 * 获取再发频率编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_relcp_freqCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_relcp_freq");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("再发频率编码"); 
		return column;
	}
	/**
	 * 获取与员工个人因素相关id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emper_factorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emper_factor");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("与员工个人因素相关id"); 
		return column;
	}
	/**
	 * 获取与员工个人因素相关编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_emper_factorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_emper_factor");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("与员工个人因素相关编码"); 
		return column;
	}
	/**
	 * 获取与员工其他因素相关表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOth_emper_factorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Oth_emper_factor");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("与员工其他因素相关"); 
		return column;
	}
	/**
	 * 获取与病人生理及行为因素相关id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_patbp_factorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_patbp_factor");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("与病人生理及行为因素相关id"); 
		return column;
	}
	/**
	 * 获取与病人生理及行为因素相关编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_patbp_factorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_patbp_factor");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("与病人生理及行为因素相关编码"); 
		return column;
	}
	/**
	 * 获取与病人其他因素相关表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOth_patbp_factorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Oth_patbp_factor");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("与病人其他因素相关"); 
		return column;
	}
	/**
	 * 获取与器材设备因素相关id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_equip_factorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_equip_factor");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("与器材设备因素相关id"); 
		return column;
	}
	/**
	 * 获取与器材设备因素相关编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_equip_factorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_equip_factor");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("与器材设备因素相关编码"); 
		return column;
	}
	/**
	 * 获取与其他因素相关表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOth_equip_factorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Oth_equip_factor");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("与其他因素相关"); 
		return column;
	}
	/**
	 * 获取与使用药物相关id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_usedrug_factorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_usedrug_factor");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("与使用药物相关id"); 
		return column;
	}
	/**
	 * 获取与使用药物相关编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_usedrug_factorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_usedrug_factor");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("与使用药物相关编码"); 
		return column;
	}
	/**
	 * 获取与使用其他药物相关表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOth_usedrug_factorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Oth_usedrug_factor");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("与使用其他药物相关"); 
		return column;
	}
	/**
	 * 获取与工作状态/流程设计因素相关id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_worksta_factorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_worksta_factor");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("与工作状态/流程设计因素相关id"); 
		return column;
	}
	/**
	 * 获取与工作状态/流程设计因素相关编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_worksta_factorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_worksta_factor");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("与工作状态/流程设计因素相关编码"); 
		return column;
	}
	/**
	 * 获取其他因素相关表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOth_worksta_factorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Oth_worksta_factor");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("其他因素相关"); 
		return column;
	}
	/**
	 * 获取与沟通因素相关id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_communi_factorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_communi_factor");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("与沟通因素相关id"); 
		return column;
	}
	/**
	 * 获取与沟通因素相关编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_communi_factorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_communi_factor");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("与沟通因素相关编码"); 
		return column;
	}
	/**
	 * 获取与其他沟通因素相关表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOth_communi_factorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Oth_communi_factor");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("与其他沟通因素相关"); 
		return column;
	}
	/**
	 * 获取与环境因素相关id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_envir_factorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_envir_factor");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("与环境因素相关id"); 
		return column;
	}
	/**
	 * 获取与环境因素相关编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_envir_factorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_envir_factor");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("与环境因素相关编码"); 
		return column;
	}
	/**
	 * 获取与环境其他因素相关表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOth_envir_factorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Oth_envir_factor");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("与环境其他因素相关"); 
		return column;
	}
	/**
	 * 获取其他事件发生可能原因表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOth_poss_eventCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Oth_poss_event");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("其他事件发生可能原因"); 
		return column;
	}
	/**
	 * 获取加强教育培训id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_streng_edutraCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_streng_edutra");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("加强教育培训id"); 
		return column;
	}
	/**
	 * 获取加强教育培训编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_streng_edutraCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_streng_edutra");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("加强教育培训编码"); 
		return column;
	}
	/**
	 * 获取其他加强教育培训表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOth_streng_edutraCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Oth_streng_edutra");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("其他加强教育培训"); 
		return column;
	}
	/**
	 * 获取改善医疗护理管理id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_impro_medageCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_impro_medage");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("改善医疗护理管理id"); 
		return column;
	}
	/**
	 * 获取改善医疗护理管理编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_impro_medageCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_impro_medage");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("改善医疗护理管理编码"); 
		return column;
	}
	/**
	 * 获取其他改善医疗护理管理表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOth_impro_medageCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Oth_impro_medage");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("其他改善医疗护理管理"); 
		return column;
	}
	/**
	 * 获取改善行政管理id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_impro_adminiCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_impro_admini");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("改善行政管理id"); 
		return column;
	}
	/**
	 * 获取改善行政管理编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_impro_adminiCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_impro_admini");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("改善行政管理编码"); 
		return column;
	}
	/**
	 * 获取其他改善行政管理表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOth_impro_adminiCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Oth_impro_admini");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("其他改善行政管理"); 
		return column;
	}
	/**
	 * 获取加强沟通方式id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_streng_comstyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_streng_comsty");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("加强沟通方式id"); 
		return column;
	}
	/**
	 * 获取加强沟通方式编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_streng_comstyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_streng_comsty");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("加强沟通方式编码"); 
		return column;
	}
	/**
	 * 获取其他加强沟通方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOth_streng_comstyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Oth_streng_comsty");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("其他加强沟通方式"); 
		return column;
	}
	/**
	 * 获取其他预防措施或方法表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOth_step_waysCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Oth_step_ways");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("其他预防措施或方法"); 
		return column;
	}
	/**
	 * 获取操作流程或管理规定表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEn_opera_manruleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"En_opera_manrule");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("操作流程或管理规定"); 
		return column;
	}
	/**
	 * 获取操作流程或管理规定id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_opera_manruleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_opera_manrule");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("操作流程或管理规定id"); 
		return column;
	}
	/**
	 * 获取操作流程或管理规定编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_opera_manruleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_opera_manrule");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("操作流程或管理规定编码"); 
		return column;
	}
	/**
	 * 获取严重结果分类id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_serres_classCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_serres_class");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("严重结果分类id"); 
		return column;
	}
	/**
	 * 获取严重结果分类编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_serres_classCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_serres_class");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("严重结果分类编码"); 
		return column;
	}
	/**
	 * 获取严重程度id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_sever_levelCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_sever_level");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("严重程度id"); 
		return column;
	}
	/**
	 * 获取严重程度编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_sever_levelCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_sever_level");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("严重程度编码"); 
		return column;
	}
	/**
	 * 获取其他操作流程或管理规定表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOth_opera_manruleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Oth_opera_manrule");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("其他操作流程或管理规定"); 
		return column;
	}
	/**
	 * 获取其他建议或意见表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOth_advise_ideaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Oth_advise_idea");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("其他建议或意见"); 
		return column;
	}
	/**
	 * 获取主管部门意见表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDep_ideaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dep_idea");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("主管部门意见"); 
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
	 * 获取扩展字段1表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_relcp_freqCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_relcp_freq");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("扩展字段1"); 
		return column;
	}
	/**
	 * 获取扩展字段1表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_emper_factorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_emper_factor");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("扩展字段1"); 
		return column;
	}
	/**
	 * 获取扩展字段1表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_patbp_factorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_patbp_factor");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("扩展字段1"); 
		return column;
	}
	/**
	 * 获取扩展字段1表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_equip_factorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_equip_factor");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("扩展字段1"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_usedrug_factorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_usedrug_factor");
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
	private IColumnDesc getName_worksta_factorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_worksta_factor");
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
	private IColumnDesc getName_communi_factorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_communi_factor");
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
	private IColumnDesc getName_envir_factorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_envir_factor");
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
	private IColumnDesc getName_streng_edutraCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_streng_edutra");
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
	private IColumnDesc getName_impro_medageCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_impro_medage");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取扩展字段1表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_impro_adminiCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_impro_admini");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("扩展字段1"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_streng_comstyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_streng_comsty");
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
	private IColumnDesc getName_opera_manruleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_opera_manrule");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取扩展字段1表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_serres_classCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_serres_class");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("扩展字段1"); 
		return column;
	}
	/**
	 * 获取扩展字段1表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_sever_levelCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_sever_level");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("扩展字段1"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id","Id_aer_ev_analys");
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
