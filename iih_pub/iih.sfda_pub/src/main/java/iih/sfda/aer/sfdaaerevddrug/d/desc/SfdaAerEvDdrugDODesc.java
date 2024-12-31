
package iih.sfda.aer.sfdaaerevddrug.d.desc;

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
 * 药物不良反应事件 DO 元数据信息
 */
public class SfdaAerEvDdrugDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.sfda.aer.sfdaaerevddrug.d.SfdaAerEvDdrugDO";
	public static final String CLASS_DISPALYNAME = "药物不良反应事件";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "SFDA_AER_EV_DDRUG";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_aer_ev_ddrug";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public SfdaAerEvDdrugDODesc(){
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
		this.setKeyDesc(getId_aer_ev_ddrugADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_aer_ev_ddrugADesc(tblDesc));
		this.add(getId_aer_evADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_drug_badADesc(tblDesc));
		this.add(getSd_drug_badADesc(tblDesc));
		this.add(getRe_peopleADesc(tblDesc));
		this.add(getRe_ph_numberADesc(tblDesc));
		this.add(getEle_emailADesc(tblDesc));
		this.add(getPat_contact_wayADesc(tblDesc));
		this.add(getOri_diseaseADesc(tblDesc));
		this.add(getBa_drug_faADesc(tblDesc));
		this.add(getOth_drug_faADesc(tblDesc));
		this.add(getBa_drug_alwADesc(tblDesc));
		this.add(getOth_drug_alwADesc(tblDesc));
		this.add(getId_rela_infoADesc(tblDesc));
		this.add(getSd_rela_infoADesc(tblDesc));
		this.add(getOth_rela_infoADesc(tblDesc));
		this.add(getBad_event_nameADesc(tblDesc));
		this.add(getBad_des_sitADesc(tblDesc));
		this.add(getBad_deal_sitADesc(tblDesc));
		this.add(getId_dou_drugADesc(tblDesc));
		this.add(getSd_dou_drugADesc(tblDesc));
		this.add(getDes_dou_drugADesc(tblDesc));
		this.add(getId_with_drugADesc(tblDesc));
		this.add(getSd_with_drugADesc(tblDesc));
		this.add(getDes_with_drugADesc(tblDesc));
		this.add(getId_pat_conADesc(tblDesc));
		this.add(getSd_pat_conADesc(tblDesc));
		this.add(getDes_pat_conADesc(tblDesc));
		this.add(getWhy_deathADesc(tblDesc));
		this.add(getDea_dateADesc(tblDesc));
		this.add(getId_ori_impactADesc(tblDesc));
		this.add(getSd_ori_impactADesc(tblDesc));
		this.add(getDes_ori_impactADesc(tblDesc));
		this.add(getId_corr_evaluADesc(tblDesc));
		this.add(getSd_corr_evaluADesc(tblDesc));
		this.add(getId_problem_oneADesc(tblDesc));
		this.add(getId_problem_twoADesc(tblDesc));
		this.add(getId_problem_threeADesc(tblDesc));
		this.add(getId_problem_fourADesc(tblDesc));
		this.add(getId_problem_fiveADesc(tblDesc));
		this.add(getId_noteADesc(tblDesc));
		this.add(getDef1ADesc(tblDesc));
		this.add(getDef2ADesc(tblDesc));
		this.add(getDef3ADesc(tblDesc));
		this.add(getDef4ADesc(tblDesc));
		this.add(getDef5ADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getName_orgADesc(tblDesc));
		this.add(getName_grpADesc(tblDesc));
		this.add(getName_drug_badADesc(tblDesc));
		this.add(getName_rela_infoADesc(tblDesc));
		this.add(getCtrl1_dou_drugADesc(tblDesc));
		this.add(getCtrl1_with_drugADesc(tblDesc));
		this.add(getName_pat_conADesc(tblDesc));
		this.add(getName_ori_impactADesc(tblDesc));
		this.add(getName_corr_evaluADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_aer_ev_ddrugCDesc(tblDesc));
		tblDesc.add(getId_aer_ev_ddrugCDesc(tblDesc));
		tblDesc.add(getId_aer_evCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_drug_badCDesc(tblDesc));
		tblDesc.add(getSd_drug_badCDesc(tblDesc));
		tblDesc.add(getRe_peopleCDesc(tblDesc));
		tblDesc.add(getRe_ph_numberCDesc(tblDesc));
		tblDesc.add(getEle_emailCDesc(tblDesc));
		tblDesc.add(getPat_contact_wayCDesc(tblDesc));
		tblDesc.add(getOri_diseaseCDesc(tblDesc));
		tblDesc.add(getBa_drug_faCDesc(tblDesc));
		tblDesc.add(getOth_drug_faCDesc(tblDesc));
		tblDesc.add(getBa_drug_alwCDesc(tblDesc));
		tblDesc.add(getOth_drug_alwCDesc(tblDesc));
		tblDesc.add(getId_rela_infoCDesc(tblDesc));
		tblDesc.add(getSd_rela_infoCDesc(tblDesc));
		tblDesc.add(getOth_rela_infoCDesc(tblDesc));
		tblDesc.add(getBad_event_nameCDesc(tblDesc));
		tblDesc.add(getBad_des_sitCDesc(tblDesc));
		tblDesc.add(getBad_deal_sitCDesc(tblDesc));
		tblDesc.add(getId_dou_drugCDesc(tblDesc));
		tblDesc.add(getSd_dou_drugCDesc(tblDesc));
		tblDesc.add(getDes_dou_drugCDesc(tblDesc));
		tblDesc.add(getId_with_drugCDesc(tblDesc));
		tblDesc.add(getSd_with_drugCDesc(tblDesc));
		tblDesc.add(getDes_with_drugCDesc(tblDesc));
		tblDesc.add(getId_pat_conCDesc(tblDesc));
		tblDesc.add(getSd_pat_conCDesc(tblDesc));
		tblDesc.add(getDes_pat_conCDesc(tblDesc));
		tblDesc.add(getWhy_deathCDesc(tblDesc));
		tblDesc.add(getDea_dateCDesc(tblDesc));
		tblDesc.add(getId_ori_impactCDesc(tblDesc));
		tblDesc.add(getSd_ori_impactCDesc(tblDesc));
		tblDesc.add(getDes_ori_impactCDesc(tblDesc));
		tblDesc.add(getId_corr_evaluCDesc(tblDesc));
		tblDesc.add(getSd_corr_evaluCDesc(tblDesc));
		tblDesc.add(getId_problem_oneCDesc(tblDesc));
		tblDesc.add(getId_problem_twoCDesc(tblDesc));
		tblDesc.add(getId_problem_threeCDesc(tblDesc));
		tblDesc.add(getId_problem_fourCDesc(tblDesc));
		tblDesc.add(getId_problem_fiveCDesc(tblDesc));
		tblDesc.add(getId_noteCDesc(tblDesc));
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
	 * 药物不良反应事件主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_aer_ev_ddrugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_aer_ev_ddrug",  getId_aer_ev_ddrugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("药物不良反应事件主键");
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
	 * 药品不良反应类型id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_drug_badADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_drug_bad",  getId_drug_badCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("药品不良反应类型id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 药品不良反应类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_drug_badADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_drug_bad",  getSd_drug_badCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("药品不良反应类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 报告人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRe_peopleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Re_people",  getRe_peopleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("报告人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 报告人联系电话属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRe_ph_numberADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Re_ph_number",  getRe_ph_numberCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("报告人联系电话");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 电子邮箱属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEle_emailADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ele_email",  getEle_emailCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("电子邮箱");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者联系方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPat_contact_wayADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pat_contact_way",  getPat_contact_wayCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者联系方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 原患疾病属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOri_diseaseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ori_disease",  getOri_diseaseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("原患疾病");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 家族药品不良反应属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBa_drug_faADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ba_drug_fa",  getBa_drug_faCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("家族药品不良反应");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 家族有药品不良反应描述属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOth_drug_faADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Oth_drug_fa",  getOth_drug_faCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("家族有药品不良反应描述");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 既往药品不良反应情况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBa_drug_alwADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ba_drug_alw",  getBa_drug_alwCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("既往药品不良反应情况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 既往有药品不良反应描述属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOth_drug_alwADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Oth_drug_alw",  getOth_drug_alwCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("既往有药品不良反应描述");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 相关重要信息id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_rela_infoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_rela_info",  getId_rela_infoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("相关重要信息id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 相关重要信息编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_rela_infoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_rela_info",  getSd_rela_infoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("相关重要信息编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 其他相关重要信息属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOth_rela_infoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Oth_rela_info",  getOth_rela_infoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("其他相关重要信息");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 不良反应/事件名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBad_event_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Bad_event_name",  getBad_event_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("不良反应/事件名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 不良反应过程描述及处理情况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBad_des_sitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Bad_des_sit",  getBad_des_sitCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("不良反应过程描述及处理情况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 不良反应处理情况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBad_deal_sitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Bad_deal_sit",  getBad_deal_sitCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("不良反应处理情况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 怀疑药品id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dou_drugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dou_drug",  getId_dou_drugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("怀疑药品id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 怀疑药品编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_dou_drugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_dou_drug",  getSd_dou_drugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("怀疑药品编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 怀疑药品描述属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDes_dou_drugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Des_dou_drug",  getDes_dou_drugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("怀疑药品描述");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 并用药品id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_with_drugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_with_drug",  getId_with_drugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("并用药品id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 并用药品编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_with_drugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_with_drug",  getSd_with_drugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("并用药品编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 并用药品描述属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDes_with_drugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Des_with_drug",  getDes_with_drugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("并用药品描述");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 对患者造成的后果属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pat_conADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pat_con",  getId_pat_conCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("对患者造成的后果");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 对患者造成的编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_pat_conADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_pat_con",  getSd_pat_conCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("对患者造成的编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 有后遗症表现描述属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDes_pat_conADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Des_pat_con",  getDes_pat_conCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("有后遗症表现描述");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 死亡直接原因属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWhy_deathADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Why_death",  getWhy_deathCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("死亡直接原因");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 死亡日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDea_dateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dea_date",  getDea_dateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("死亡日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 对原有疾病的影响id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ori_impactADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ori_impact",  getId_ori_impactCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("对原有疾病的影响id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 对原有疾病的影响编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_ori_impactADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_ori_impact",  getSd_ori_impactCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("对原有疾病的影响编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 导致后遗症描述属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDes_ori_impactADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Des_ori_impact",  getDes_ori_impactCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("导致后遗症描述");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 关联性评价id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_corr_evaluADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_corr_evalu",  getId_corr_evaluCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("关联性评价id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 关联性评价编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_corr_evaluADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_corr_evalu",  getSd_corr_evaluCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("关联性评价编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 问题一属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_problem_oneADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_problem_one",  getId_problem_oneCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("问题一");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 问题二属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_problem_twoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_problem_two",  getId_problem_twoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("问题二");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 问题三属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_problem_threeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_problem_three",  getId_problem_threeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("问题三");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 问题四属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_problem_fourADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_problem_four",  getId_problem_fourCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("问题四");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 问题五属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_problem_fiveADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_problem_five",  getId_problem_fiveCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("问题五");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备注属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_noteADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_note",  getId_noteCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备注");
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
		attrDesc.setRefTblInfos(new String[]{"bd_grp a0b3","id_grp=id_grp","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_drug_badADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_drug_bad",  getName_drug_badCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b4","id_drug_bad=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_rela_infoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_rela_info",  getName_rela_infoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b5","id_rela_info=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 扩展字段1属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCtrl1_dou_drugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ctrl1_dou_drug",  getCtrl1_dou_drugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("扩展字段1");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b6","id_dou_drug=id_udidoc","ctrl1"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 扩展字段1属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCtrl1_with_drugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ctrl1_with_drug",  getCtrl1_with_drugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("扩展字段1");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b7","id_with_drug=id_udidoc","ctrl1"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_pat_conADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_pat_con",  getName_pat_conCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b8","id_pat_con=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_ori_impactADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_ori_impact",  getName_ori_impactCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b9","id_ori_impact=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_corr_evaluADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_corr_evalu",  getName_corr_evaluCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b10","id_corr_evalu=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取药物不良反应事件主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_aer_ev_ddrugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_aer_ev_ddrug");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("药物不良反应事件主键"); 
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
	 * 获取药品不良反应类型id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_drug_badCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_drug_bad");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("药品不良反应类型id"); 
		return column;
	}
	/**
	 * 获取药品不良反应类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_drug_badCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_drug_bad");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("药品不良反应类型编码"); 
		return column;
	}
	/**
	 * 获取报告人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRe_peopleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Re_people");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("报告人"); 
		return column;
	}
	/**
	 * 获取报告人联系电话表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRe_ph_numberCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Re_ph_number");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("报告人联系电话"); 
		return column;
	}
	/**
	 * 获取电子邮箱表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEle_emailCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ele_email");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("电子邮箱"); 
		return column;
	}
	/**
	 * 获取患者联系方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPat_contact_wayCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pat_contact_way");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者联系方式"); 
		return column;
	}
	/**
	 * 获取原患疾病表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOri_diseaseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ori_disease");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("原患疾病"); 
		return column;
	}
	/**
	 * 获取家族药品不良反应表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBa_drug_faCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ba_drug_fa");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("家族药品不良反应"); 
		return column;
	}
	/**
	 * 获取家族有药品不良反应描述表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOth_drug_faCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Oth_drug_fa");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("家族有药品不良反应描述"); 
		return column;
	}
	/**
	 * 获取既往药品不良反应情况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBa_drug_alwCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ba_drug_alw");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("既往药品不良反应情况"); 
		return column;
	}
	/**
	 * 获取既往有药品不良反应描述表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOth_drug_alwCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Oth_drug_alw");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("既往有药品不良反应描述"); 
		return column;
	}
	/**
	 * 获取相关重要信息id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_rela_infoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_rela_info");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("相关重要信息id"); 
		return column;
	}
	/**
	 * 获取相关重要信息编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_rela_infoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_rela_info");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("相关重要信息编码"); 
		return column;
	}
	/**
	 * 获取其他相关重要信息表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOth_rela_infoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Oth_rela_info");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("其他相关重要信息"); 
		return column;
	}
	/**
	 * 获取不良反应/事件名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBad_event_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Bad_event_name");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("不良反应/事件名称"); 
		return column;
	}
	/**
	 * 获取不良反应过程描述及处理情况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBad_des_sitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Bad_des_sit");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("不良反应过程描述及处理情况"); 
		return column;
	}
	/**
	 * 获取不良反应处理情况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBad_deal_sitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Bad_deal_sit");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("不良反应处理情况"); 
		return column;
	}
	/**
	 * 获取怀疑药品id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dou_drugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dou_drug");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("怀疑药品id"); 
		return column;
	}
	/**
	 * 获取怀疑药品编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_dou_drugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_dou_drug");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("怀疑药品编码"); 
		return column;
	}
	/**
	 * 获取怀疑药品描述表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDes_dou_drugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Des_dou_drug");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("怀疑药品描述"); 
		return column;
	}
	/**
	 * 获取并用药品id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_with_drugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_with_drug");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("并用药品id"); 
		return column;
	}
	/**
	 * 获取并用药品编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_with_drugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_with_drug");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("并用药品编码"); 
		return column;
	}
	/**
	 * 获取并用药品描述表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDes_with_drugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Des_with_drug");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("并用药品描述"); 
		return column;
	}
	/**
	 * 获取对患者造成的后果表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pat_conCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pat_con");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("对患者造成的后果"); 
		return column;
	}
	/**
	 * 获取对患者造成的编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_pat_conCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_pat_con");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("对患者造成的编码"); 
		return column;
	}
	/**
	 * 获取有后遗症表现描述表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDes_pat_conCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Des_pat_con");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("有后遗症表现描述"); 
		return column;
	}
	/**
	 * 获取死亡直接原因表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWhy_deathCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Why_death");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("死亡直接原因"); 
		return column;
	}
	/**
	 * 获取死亡日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDea_dateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dea_date");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("死亡日期"); 
		return column;
	}
	/**
	 * 获取对原有疾病的影响id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ori_impactCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ori_impact");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("对原有疾病的影响id"); 
		return column;
	}
	/**
	 * 获取对原有疾病的影响编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_ori_impactCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_ori_impact");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("对原有疾病的影响编码"); 
		return column;
	}
	/**
	 * 获取导致后遗症描述表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDes_ori_impactCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Des_ori_impact");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("导致后遗症描述"); 
		return column;
	}
	/**
	 * 获取关联性评价id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_corr_evaluCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_corr_evalu");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("关联性评价id"); 
		return column;
	}
	/**
	 * 获取关联性评价编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_corr_evaluCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_corr_evalu");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("关联性评价编码"); 
		return column;
	}
	/**
	 * 获取问题一表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_problem_oneCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_problem_one");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("问题一"); 
		return column;
	}
	/**
	 * 获取问题二表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_problem_twoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_problem_two");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("问题二"); 
		return column;
	}
	/**
	 * 获取问题三表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_problem_threeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_problem_three");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("问题三"); 
		return column;
	}
	/**
	 * 获取问题四表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_problem_fourCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_problem_four");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("问题四"); 
		return column;
	}
	/**
	 * 获取问题五表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_problem_fiveCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_problem_five");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("问题五"); 
		return column;
	}
	/**
	 * 获取备注表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_noteCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_note");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备注"); 
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
	private IColumnDesc getName_grpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_grp");
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
	private IColumnDesc getName_drug_badCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_drug_bad");
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
	private IColumnDesc getName_rela_infoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_rela_info");
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
	private IColumnDesc getCtrl1_dou_drugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ctrl1_dou_drug");
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
	private IColumnDesc getCtrl1_with_drugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ctrl1_with_drug");
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
	private IColumnDesc getName_pat_conCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_pat_con");
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
	private IColumnDesc getName_ori_impactCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_ori_impact");
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
	private IColumnDesc getName_corr_evaluCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_corr_evalu");
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
