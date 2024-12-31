
package iih.nmr.nm.bch.riskhoato.d.desc;

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
 * 急危重患者交接记录 DO 元数据信息
 */
public class RiskhoatoRecordDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.nmr.nm.bch.riskhoato.d.RiskhoatoRecordDO";
	public static final String CLASS_DISPALYNAME = "急危重患者交接记录";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "NMR_BCH_RISK";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_riskhoato";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public RiskhoatoRecordDODesc(){
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
		this.setKeyDesc(getId_riskhoatoADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_riskhoatoADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_entADesc(tblDesc));
		this.add(getName_patADesc(tblDesc));
		this.add(getAgeADesc(tblDesc));
		this.add(getCode_amr_ipADesc(tblDesc));
		this.add(getId_diagnosisADesc(tblDesc));
		this.add(getName_sexADesc(tblDesc));
		this.add(getName_diagnosisADesc(tblDesc));
		this.add(getId_signADesc(tblDesc));
		this.add(getDt_datetimeADesc(tblDesc));
		this.add(getDt_createADesc(tblDesc));
		this.add(getId_inhosp_wayADesc(tblDesc));
		this.add(getSd_inhosp_wayADesc(tblDesc));
		this.add(getId_transin_wayADesc(tblDesc));
		this.add(getSd_transin_wayADesc(tblDesc));
		this.add(getId_awarenessADesc(tblDesc));
		this.add(getSd_awarenessADesc(tblDesc));
		this.add(getPressADesc(tblDesc));
		this.add(getReflexADesc(tblDesc));
		this.add(getEmergency_check_otherADesc(tblDesc));
		this.add(getFirst_aid_otherADesc(tblDesc));
		this.add(getPipeline_otherADesc(tblDesc));
		this.add(getId_emergency_checkADesc(tblDesc));
		this.add(getSd_emergency_checkADesc(tblDesc));
		this.add(getId_first_aidADesc(tblDesc));
		this.add(getSd_first_aidADesc(tblDesc));
		this.add(getId_lienADesc(tblDesc));
		this.add(getSd_lienADesc(tblDesc));
		this.add(getId_pipelineADesc(tblDesc));
		this.add(getSd_pipelineADesc(tblDesc));
		this.add(getId_skin_conditionADesc(tblDesc));
		this.add(getSd_skin_conditionADesc(tblDesc));
		this.add(getId_skinyc_conditionADesc(tblDesc));
		this.add(getSd_skinyc_conditionADesc(tblDesc));
		this.add(getId_notchADesc(tblDesc));
		this.add(getSd_notchADesc(tblDesc));
		this.add(getPipe_otherADesc(tblDesc));
		this.add(getPartareaADesc(tblDesc));
		this.add(getDrugADesc(tblDesc));
		this.add(getOut_depADesc(tblDesc));
		this.add(getIn_depADesc(tblDesc));
		this.add(getOut_nurADesc(tblDesc));
		this.add(getIn_nurADesc(tblDesc));
		this.add(getDropnumADesc(tblDesc));
		this.add(getDrop_rateADesc(tblDesc));
		this.add(getNv_tADesc(tblDesc));
		this.add(getIn_timeADesc(tblDesc));
		this.add(getOut_timeADesc(tblDesc));
		this.add(getInt_pulseADesc(tblDesc));
		this.add(getInt_breathingADesc(tblDesc));
		this.add(getInt_pupil_leftADesc(tblDesc));
		this.add(getInt_pupil_rightADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getName_inhosp_wayADesc(tblDesc));
		this.add(getName_transin_wayADesc(tblDesc));
		this.add(getName_awarenessADesc(tblDesc));
		this.add(getName_emergency_checkADesc(tblDesc));
		this.add(getName_first_aidADesc(tblDesc));
		this.add(getName_lienADesc(tblDesc));
		this.add(getName_pipelineADesc(tblDesc));
		this.add(getName_skinADesc(tblDesc));
		this.add(getName_skinyc_conditionADesc(tblDesc));
		this.add(getName_notchADesc(tblDesc));
		this.add(getName_out_depADesc(tblDesc));
		this.add(getName_in_depADesc(tblDesc));
		this.add(getName_out_nurADesc(tblDesc));
		this.add(getName_in_nurADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_riskhoatoCDesc(tblDesc));
		tblDesc.add(getId_riskhoatoCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_entCDesc(tblDesc));
		tblDesc.add(getName_patCDesc(tblDesc));
		tblDesc.add(getAgeCDesc(tblDesc));
		tblDesc.add(getCode_amr_ipCDesc(tblDesc));
		tblDesc.add(getId_diagnosisCDesc(tblDesc));
		tblDesc.add(getName_sexCDesc(tblDesc));
		tblDesc.add(getName_diagnosisCDesc(tblDesc));
		tblDesc.add(getId_signCDesc(tblDesc));
		tblDesc.add(getDt_datetimeCDesc(tblDesc));
		tblDesc.add(getDt_createCDesc(tblDesc));
		tblDesc.add(getId_inhosp_wayCDesc(tblDesc));
		tblDesc.add(getSd_inhosp_wayCDesc(tblDesc));
		tblDesc.add(getId_transin_wayCDesc(tblDesc));
		tblDesc.add(getSd_transin_wayCDesc(tblDesc));
		tblDesc.add(getId_awarenessCDesc(tblDesc));
		tblDesc.add(getSd_awarenessCDesc(tblDesc));
		tblDesc.add(getPressCDesc(tblDesc));
		tblDesc.add(getReflexCDesc(tblDesc));
		tblDesc.add(getEmergency_check_otherCDesc(tblDesc));
		tblDesc.add(getFirst_aid_otherCDesc(tblDesc));
		tblDesc.add(getPipeline_otherCDesc(tblDesc));
		tblDesc.add(getId_emergency_checkCDesc(tblDesc));
		tblDesc.add(getSd_emergency_checkCDesc(tblDesc));
		tblDesc.add(getId_first_aidCDesc(tblDesc));
		tblDesc.add(getSd_first_aidCDesc(tblDesc));
		tblDesc.add(getId_lienCDesc(tblDesc));
		tblDesc.add(getSd_lienCDesc(tblDesc));
		tblDesc.add(getId_pipelineCDesc(tblDesc));
		tblDesc.add(getSd_pipelineCDesc(tblDesc));
		tblDesc.add(getId_skin_conditionCDesc(tblDesc));
		tblDesc.add(getSd_skin_conditionCDesc(tblDesc));
		tblDesc.add(getId_skinyc_conditionCDesc(tblDesc));
		tblDesc.add(getSd_skinyc_conditionCDesc(tblDesc));
		tblDesc.add(getId_notchCDesc(tblDesc));
		tblDesc.add(getSd_notchCDesc(tblDesc));
		tblDesc.add(getPipe_otherCDesc(tblDesc));
		tblDesc.add(getPartareaCDesc(tblDesc));
		tblDesc.add(getDrugCDesc(tblDesc));
		tblDesc.add(getOut_depCDesc(tblDesc));
		tblDesc.add(getIn_depCDesc(tblDesc));
		tblDesc.add(getOut_nurCDesc(tblDesc));
		tblDesc.add(getIn_nurCDesc(tblDesc));
		tblDesc.add(getDropnumCDesc(tblDesc));
		tblDesc.add(getDrop_rateCDesc(tblDesc));
		tblDesc.add(getNv_tCDesc(tblDesc));
		tblDesc.add(getIn_timeCDesc(tblDesc));
		tblDesc.add(getOut_timeCDesc(tblDesc));
		tblDesc.add(getInt_pulseCDesc(tblDesc));
		tblDesc.add(getInt_breathingCDesc(tblDesc));
		tblDesc.add(getInt_pupil_leftCDesc(tblDesc));
		tblDesc.add(getInt_pupil_rightCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 急危重患者交接主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_riskhoatoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_riskhoato",  getId_riskhoatoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("急危重患者交接主键");
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
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 就诊号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_entADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ent",  getId_entCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("就诊号");
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
	 * 年龄属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAgeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Age",  getAgeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("年龄");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 住院病案编号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_amr_ipADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_amr_ip",  getCode_amr_ipCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("住院病案编号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊断Id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_diagnosisADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_diagnosis",  getId_diagnosisCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断Id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 性别属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_sexADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_sex",  getName_sexCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("性别");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊断名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_diagnosisADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_diagnosis",  getName_diagnosisCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * id_sign属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_signADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_sign",  getId_signCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("id_sign");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 日期时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_datetimeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_datetime",  getDt_datetimeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("日期时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * dt_create属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_createADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_create",  getDt_createCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("dt_create");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 来院方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_inhosp_wayADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_inhosp_way",  getId_inhosp_wayCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("来院方式");
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
	private IAttrDesc getSd_inhosp_wayADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_inhosp_way",  getSd_inhosp_wayCDesc(tblDesc), this);
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
	 * 转入方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_transin_wayADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_transin_way",  getId_transin_wayCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("转入方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 转入方式编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_transin_wayADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_transin_way",  getSd_transin_wayCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("转入方式编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 意识状态属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_awarenessADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_awareness",  getId_awarenessCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("意识状态");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 意识状态编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_awarenessADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_awareness",  getSd_awarenessCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("意识状态编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 血压属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPressADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Press",  getPressCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("血压");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 瞳孔反射属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getReflexADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Reflex",  getReflexCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("瞳孔反射");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 急诊检查其它属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEmergency_check_otherADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Emergency_check_other",  getEmergency_check_otherCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("急诊检查其它");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 急救处置其它属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFirst_aid_otherADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("First_aid_other",  getFirst_aid_otherCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("急救处置其它");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 留置管路其它属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPipeline_otherADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pipeline_other",  getPipeline_otherCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("留置管路其它");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 急诊检查属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emergency_checkADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emergency_check",  getId_emergency_checkCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("急诊检查");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 急诊检查编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_emergency_checkADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_emergency_check",  getSd_emergency_checkCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("急诊检查编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 急救处置属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_first_aidADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_first_aid",  getId_first_aidCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("急救处置");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 急救处置编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_first_aidADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_first_aid",  getSd_first_aidCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("急救处置编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 留置管路属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_lienADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_lien",  getId_lienCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("留置管路");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 留置管路编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_lienADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_lien",  getSd_lienCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("留置管路编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 管路情况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pipelineADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pipeline",  getId_pipelineCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("管路情况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 管路情况编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_pipelineADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_pipeline",  getSd_pipelineCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("管路情况编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 皮肤情况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_skin_conditionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_skin_condition",  getId_skin_conditionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("皮肤情况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 皮肤情况编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_skin_conditionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_skin_condition",  getSd_skin_conditionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("皮肤情况编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 皮肤异常情况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_skinyc_conditionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_skinyc_condition",  getId_skinyc_conditionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("皮肤异常情况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 皮肤异常情况编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_skinyc_conditionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_skinyc_condition",  getSd_skinyc_conditionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("皮肤异常情况编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 切口敷料属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_notchADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_notch",  getId_notchCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("切口敷料");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 切口敷料编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_notchADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_notch",  getSd_notchCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("切口敷料编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 管路情况其它属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPipe_otherADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pipe_other",  getPipe_otherCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("管路情况其它");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 部位面积属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPartareaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Partarea",  getPartareaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("部位面积");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 目前所输药物属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDrugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Drug",  getDrugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("目前所输药物");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 转出科室属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOut_depADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Out_dep",  getOut_depCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("转出科室");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 转入科室属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIn_depADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("In_dep",  getIn_depCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("转入科室");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 护送护士属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOut_nurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Out_nur",  getOut_nurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("护送护士");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 接收护士属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIn_nurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("In_nur",  getIn_nurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("接收护士");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 滴数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDropnumADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dropnum",  getDropnumCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("滴数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 滴/分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDrop_rateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Drop_rate",  getDrop_rateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("滴/分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体温属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNv_tADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Nv_t",  getNv_tCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("体温");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 转入时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIn_timeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("In_time",  getIn_timeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("转入时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 转出时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOut_timeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Out_time",  getOut_timeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("转出时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 脉搏属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInt_pulseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Int_pulse",  getInt_pulseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("脉搏");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 呼吸属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInt_breathingADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Int_breathing",  getInt_breathingCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("呼吸");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 瞳孔大小(左)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInt_pupil_leftADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Int_pupil_left",  getInt_pupil_leftCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("瞳孔大小(左)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 瞳孔大小(右)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInt_pupil_rightADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Int_pupil_right",  getInt_pupil_rightCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("瞳孔大小(右)");
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
	private IAttrDesc getName_inhosp_wayADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_inhosp_way",  getName_inhosp_wayCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b2","id_inhosp_way=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_transin_wayADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_transin_way",  getName_transin_wayCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b3","id_transin_way=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_awarenessADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_awareness",  getName_awarenessCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b4","id_awareness=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_emergency_checkADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_emergency_check",  getName_emergency_checkCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b5","id_emergency_check=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_first_aidADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_first_aid",  getName_first_aidCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b6","id_first_aid=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_lienADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_lien",  getName_lienCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b7","id_lien=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_pipelineADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_pipeline",  getName_pipelineCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b8","id_pipeline=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_skinADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_skin",  getName_skinCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b9","id_skin_condition=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_skinyc_conditionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_skinyc_condition",  getName_skinyc_conditionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b10","id_skinyc_condition=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_notchADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_notch",  getName_notchCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b11","id_notch=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_out_depADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_out_dep",  getName_out_depCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b14","out_dep=id_dep","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_in_depADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_in_dep",  getName_in_depCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b15","in_dep=id_dep","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_out_nurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_out_nur",  getName_out_nurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b16","out_nur=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_in_nurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_in_nur",  getName_in_nurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b17","in_nur=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取急危重患者交接主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_riskhoatoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_riskhoato");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("急危重患者交接主键"); 
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
	 * 获取就诊号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_entCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ent");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊号"); 
		return column;
	}
	/**
	 * 获取患者姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_pat");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者姓名"); 
		return column;
	}
	/**
	 * 获取年龄表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAgeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Age");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("年龄"); 
		return column;
	}
	/**
	 * 获取住院病案编号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_amr_ipCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_amr_ip");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("住院病案编号"); 
		return column;
	}
	/**
	 * 获取诊断Id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_diagnosisCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_diagnosis");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断Id"); 
		return column;
	}
	/**
	 * 获取性别表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_sexCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_sex");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("性别"); 
		return column;
	}
	/**
	 * 获取诊断名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_diagnosisCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_diagnosis");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断名称"); 
		return column;
	}
	/**
	 * 获取id_sign表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_signCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_sign");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("id_sign"); 
		return column;
	}
	/**
	 * 获取日期时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_datetimeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_datetime");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("日期时间"); 
		return column;
	}
	/**
	 * 获取dt_create表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_createCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_create");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("dt_create"); 
		return column;
	}
	/**
	 * 获取来院方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_inhosp_wayCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_inhosp_way");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("来院方式"); 
		return column;
	}
	/**
	 * 获取来院方式编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_inhosp_wayCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_inhosp_way");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("来院方式编码"); 
		return column;
	}
	/**
	 * 获取转入方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_transin_wayCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_transin_way");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("转入方式"); 
		return column;
	}
	/**
	 * 获取转入方式编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_transin_wayCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_transin_way");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("转入方式编码"); 
		return column;
	}
	/**
	 * 获取意识状态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_awarenessCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_awareness");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("意识状态"); 
		return column;
	}
	/**
	 * 获取意识状态编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_awarenessCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_awareness");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("意识状态编码"); 
		return column;
	}
	/**
	 * 获取血压表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPressCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Press");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("血压"); 
		return column;
	}
	/**
	 * 获取瞳孔反射表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getReflexCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Reflex");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("瞳孔反射"); 
		return column;
	}
	/**
	 * 获取急诊检查其它表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEmergency_check_otherCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Emergency_check_other");
		column.setLength(150);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("急诊检查其它"); 
		return column;
	}
	/**
	 * 获取急救处置其它表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFirst_aid_otherCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"First_aid_other");
		column.setLength(150);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("急救处置其它"); 
		return column;
	}
	/**
	 * 获取留置管路其它表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPipeline_otherCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pipeline_other");
		column.setLength(150);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("留置管路其它"); 
		return column;
	}
	/**
	 * 获取急诊检查表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emergency_checkCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emergency_check");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("急诊检查"); 
		return column;
	}
	/**
	 * 获取急诊检查编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_emergency_checkCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_emergency_check");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("急诊检查编码"); 
		return column;
	}
	/**
	 * 获取急救处置表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_first_aidCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_first_aid");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("急救处置"); 
		return column;
	}
	/**
	 * 获取急救处置编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_first_aidCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_first_aid");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("急救处置编码"); 
		return column;
	}
	/**
	 * 获取留置管路表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_lienCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_lien");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("留置管路"); 
		return column;
	}
	/**
	 * 获取留置管路编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_lienCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_lien");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("留置管路编码"); 
		return column;
	}
	/**
	 * 获取管路情况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pipelineCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pipeline");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("管路情况"); 
		return column;
	}
	/**
	 * 获取管路情况编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_pipelineCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_pipeline");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("管路情况编码"); 
		return column;
	}
	/**
	 * 获取皮肤情况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_skin_conditionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_skin_condition");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("皮肤情况"); 
		return column;
	}
	/**
	 * 获取皮肤情况编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_skin_conditionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_skin_condition");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("皮肤情况编码"); 
		return column;
	}
	/**
	 * 获取皮肤异常情况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_skinyc_conditionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_skinyc_condition");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("皮肤异常情况"); 
		return column;
	}
	/**
	 * 获取皮肤异常情况编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_skinyc_conditionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_skinyc_condition");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("皮肤异常情况编码"); 
		return column;
	}
	/**
	 * 获取切口敷料表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_notchCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_notch");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("切口敷料"); 
		return column;
	}
	/**
	 * 获取切口敷料编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_notchCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_notch");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("切口敷料编码"); 
		return column;
	}
	/**
	 * 获取管路情况其它表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPipe_otherCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pipe_other");
		column.setLength(150);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("管路情况其它"); 
		return column;
	}
	/**
	 * 获取部位面积表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPartareaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Partarea");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("部位面积"); 
		return column;
	}
	/**
	 * 获取目前所输药物表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDrugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Drug");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("目前所输药物"); 
		return column;
	}
	/**
	 * 获取转出科室表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOut_depCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Out_dep");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("转出科室"); 
		return column;
	}
	/**
	 * 获取转入科室表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIn_depCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"In_dep");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("转入科室"); 
		return column;
	}
	/**
	 * 获取护送护士表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOut_nurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Out_nur");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("护送护士"); 
		return column;
	}
	/**
	 * 获取接收护士表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIn_nurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"In_nur");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("接收护士"); 
		return column;
	}
	/**
	 * 获取滴数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDropnumCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dropnum");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("滴数"); 
		return column;
	}
	/**
	 * 获取滴/分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDrop_rateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Drop_rate");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("滴/分"); 
		return column;
	}
	/**
	 * 获取体温表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNv_tCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Nv_t");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("体温"); 
		return column;
	}
	/**
	 * 获取转入时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIn_timeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"In_time");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("转入时间"); 
		return column;
	}
	/**
	 * 获取转出时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOut_timeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Out_time");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("转出时间"); 
		return column;
	}
	/**
	 * 获取脉搏表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInt_pulseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Int_pulse");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("脉搏"); 
		return column;
	}
	/**
	 * 获取呼吸表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInt_breathingCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Int_breathing");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("呼吸"); 
		return column;
	}
	/**
	 * 获取瞳孔大小(左)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInt_pupil_leftCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Int_pupil_left");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("瞳孔大小(左)"); 
		return column;
	}
	/**
	 * 获取瞳孔大小(右)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInt_pupil_rightCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Int_pupil_right");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("瞳孔大小(右)"); 
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
	private IColumnDesc getName_inhosp_wayCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_inhosp_way");
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
	private IColumnDesc getName_transin_wayCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_transin_way");
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
	private IColumnDesc getName_awarenessCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_awareness");
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
	private IColumnDesc getName_emergency_checkCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_emergency_check");
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
	private IColumnDesc getName_first_aidCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_first_aid");
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
	private IColumnDesc getName_lienCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_lien");
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
	private IColumnDesc getName_pipelineCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_pipeline");
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
	private IColumnDesc getName_skinCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_skin");
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
	private IColumnDesc getName_skinyc_conditionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_skinyc_condition");
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
	private IColumnDesc getName_notchCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_notch");
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
	private IColumnDesc getName_out_depCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_out_dep");
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
	private IColumnDesc getName_in_depCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_in_dep");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_out_nurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_out_nur");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("姓名"); 
		return column;
	}
	/**
	 * 获取姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_in_nurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_in_nur");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("姓名"); 
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
