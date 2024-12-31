
package iih.nmr.nm.bch.patcarerecord.d.desc;

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
 * 一般患者护理记录单_患者信息 DO 元数据信息
 */
public class PatCareRecordDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.nmr.nm.bch.patcarerecord.d.PatCareRecordDO";
	public static final String CLASS_DISPALYNAME = "一般患者护理记录单_患者信息";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "NMR_BCH_PATCARE";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_patcare";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public PatCareRecordDODesc(){
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
		this.setKeyDesc(getId_patcareADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_patcareADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getName_dep_phyADesc(tblDesc));
		this.add(getName_dep_nurADesc(tblDesc));
		this.add(getId_patADesc(tblDesc));
		this.add(getName_bedADesc(tblDesc));
		this.add(getId_entADesc(tblDesc));
		this.add(getName_patADesc(tblDesc));
		this.add(getAgeADesc(tblDesc));
		this.add(getCode_amr_ipADesc(tblDesc));
		this.add(getId_diagnosisADesc(tblDesc));
		this.add(getName_sexADesc(tblDesc));
		this.add(getName_diagnosisADesc(tblDesc));
		this.add(getDt_datetimeADesc(tblDesc));
		this.add(getNv_tADesc(tblDesc));
		this.add(getInt_pulseADesc(tblDesc));
		this.add(getInt_breathingADesc(tblDesc));
		this.add(getInt_sbpADesc(tblDesc));
		this.add(getInt_dbpADesc(tblDesc));
		this.add(getId_mindADesc(tblDesc));
		this.add(getSd_mindADesc(tblDesc));
		this.add(getNv_sao2ADesc(tblDesc));
		this.add(getFg_dapADesc(tblDesc));
		this.add(getId_dietADesc(tblDesc));
		this.add(getSd_dietADesc(tblDesc));
		this.add(getId_diet_guidanceADesc(tblDesc));
		this.add(getSd_diet_guidanceADesc(tblDesc));
		this.add(getFg_mouth_careADesc(tblDesc));
		this.add(getId_pipe_wayADesc(tblDesc));
		this.add(getSd_pipe_wayADesc(tblDesc));
		this.add(getFg_input_atomizaADesc(tblDesc));
		this.add(getFg_bladder_washADesc(tblDesc));
		this.add(getFg_perineal_washADesc(tblDesc));
		this.add(getFg_suckADesc(tblDesc));
		this.add(getFg_oxygen_breathADesc(tblDesc));
		this.add(getFg_nasal_feedADesc(tblDesc));
		this.add(getId_pipesADesc(tblDesc));
		this.add(getSd_pipesADesc(tblDesc));
		this.add(getFg_pipe_careADesc(tblDesc));
		this.add(getId_position_careADesc(tblDesc));
		this.add(getSd_position_careADesc(tblDesc));
		this.add(getFg_skin_careADesc(tblDesc));
		this.add(getFg_nutrition_careADesc(tblDesc));
		this.add(getId_condition_visitADesc(tblDesc));
		this.add(getSd_condition_visitADesc(tblDesc));
		this.add(getId_tube_careADesc(tblDesc));
		this.add(getSd_tube_careADesc(tblDesc));
		this.add(getId_care_typeADesc(tblDesc));
		this.add(getSd_care_typeADesc(tblDesc));
		this.add(getId_tracheal_careADesc(tblDesc));
		this.add(getSd_tracheal_careADesc(tblDesc));
		this.add(getId_psycho_careADesc(tblDesc));
		this.add(getSd_psycho_careADesc(tblDesc));
		this.add(getId_safe_careADesc(tblDesc));
		this.add(getSd_safe_careADesc(tblDesc));
		this.add(getId_nursing_isolationADesc(tblDesc));
		this.add(getSd_nursing_isolationADesc(tblDesc));
		this.add(getName_ocnmADesc(tblDesc));
		this.add(getDt_createADesc(tblDesc));
		this.add(getId_nurADesc(tblDesc));
		this.add(getId_signADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getName_mindADesc(tblDesc));
		this.add(getName_dietADesc(tblDesc));
		this.add(getName_diet_guidanceADesc(tblDesc));
		this.add(getName_pipe_wayADesc(tblDesc));
		this.add(getName_pipesADesc(tblDesc));
		this.add(getName_position_careADesc(tblDesc));
		this.add(getName_condition_visitADesc(tblDesc));
		this.add(getName_tube_careADesc(tblDesc));
		this.add(getName_care_typeADesc(tblDesc));
		this.add(getName_tracheal_careADesc(tblDesc));
		this.add(getName_psycho_careADesc(tblDesc));
		this.add(getName_safe_careADesc(tblDesc));
		this.add(getName_nursing_isolationADesc(tblDesc));
		this.add(getName_nurADesc(tblDesc));
		this.add(getName_signADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_patcareCDesc(tblDesc));
		tblDesc.add(getId_patcareCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getName_dep_phyCDesc(tblDesc));
		tblDesc.add(getName_dep_nurCDesc(tblDesc));
		tblDesc.add(getId_patCDesc(tblDesc));
		tblDesc.add(getName_bedCDesc(tblDesc));
		tblDesc.add(getId_entCDesc(tblDesc));
		tblDesc.add(getName_patCDesc(tblDesc));
		tblDesc.add(getAgeCDesc(tblDesc));
		tblDesc.add(getCode_amr_ipCDesc(tblDesc));
		tblDesc.add(getId_diagnosisCDesc(tblDesc));
		tblDesc.add(getName_sexCDesc(tblDesc));
		tblDesc.add(getName_diagnosisCDesc(tblDesc));
		tblDesc.add(getDt_datetimeCDesc(tblDesc));
		tblDesc.add(getNv_tCDesc(tblDesc));
		tblDesc.add(getInt_pulseCDesc(tblDesc));
		tblDesc.add(getInt_breathingCDesc(tblDesc));
		tblDesc.add(getInt_sbpCDesc(tblDesc));
		tblDesc.add(getInt_dbpCDesc(tblDesc));
		tblDesc.add(getId_mindCDesc(tblDesc));
		tblDesc.add(getSd_mindCDesc(tblDesc));
		tblDesc.add(getNv_sao2CDesc(tblDesc));
		tblDesc.add(getFg_dapCDesc(tblDesc));
		tblDesc.add(getId_dietCDesc(tblDesc));
		tblDesc.add(getSd_dietCDesc(tblDesc));
		tblDesc.add(getId_diet_guidanceCDesc(tblDesc));
		tblDesc.add(getSd_diet_guidanceCDesc(tblDesc));
		tblDesc.add(getFg_mouth_careCDesc(tblDesc));
		tblDesc.add(getId_pipe_wayCDesc(tblDesc));
		tblDesc.add(getSd_pipe_wayCDesc(tblDesc));
		tblDesc.add(getFg_input_atomizaCDesc(tblDesc));
		tblDesc.add(getFg_bladder_washCDesc(tblDesc));
		tblDesc.add(getFg_perineal_washCDesc(tblDesc));
		tblDesc.add(getFg_suckCDesc(tblDesc));
		tblDesc.add(getFg_oxygen_breathCDesc(tblDesc));
		tblDesc.add(getFg_nasal_feedCDesc(tblDesc));
		tblDesc.add(getId_pipesCDesc(tblDesc));
		tblDesc.add(getSd_pipesCDesc(tblDesc));
		tblDesc.add(getFg_pipe_careCDesc(tblDesc));
		tblDesc.add(getId_position_careCDesc(tblDesc));
		tblDesc.add(getSd_position_careCDesc(tblDesc));
		tblDesc.add(getFg_skin_careCDesc(tblDesc));
		tblDesc.add(getFg_nutrition_careCDesc(tblDesc));
		tblDesc.add(getId_condition_visitCDesc(tblDesc));
		tblDesc.add(getSd_condition_visitCDesc(tblDesc));
		tblDesc.add(getId_tube_careCDesc(tblDesc));
		tblDesc.add(getSd_tube_careCDesc(tblDesc));
		tblDesc.add(getId_care_typeCDesc(tblDesc));
		tblDesc.add(getSd_care_typeCDesc(tblDesc));
		tblDesc.add(getId_tracheal_careCDesc(tblDesc));
		tblDesc.add(getSd_tracheal_careCDesc(tblDesc));
		tblDesc.add(getId_psycho_careCDesc(tblDesc));
		tblDesc.add(getSd_psycho_careCDesc(tblDesc));
		tblDesc.add(getId_safe_careCDesc(tblDesc));
		tblDesc.add(getSd_safe_careCDesc(tblDesc));
		tblDesc.add(getId_nursing_isolationCDesc(tblDesc));
		tblDesc.add(getSd_nursing_isolationCDesc(tblDesc));
		tblDesc.add(getName_ocnmCDesc(tblDesc));
		tblDesc.add(getDt_createCDesc(tblDesc));
		tblDesc.add(getId_nurCDesc(tblDesc));
		tblDesc.add(getId_signCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 护理护理记录单ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_patcareADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_patcare",  getId_patcareCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("护理护理记录单ID");
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
	 * 就诊科室属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dep_phyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dep_phy",  getName_dep_phyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("就诊科室");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 就诊病区属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dep_nurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dep_nur",  getName_dep_nurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("就诊病区");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_patADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pat",  getId_patCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 床号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_bedADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_bed",  getName_bedCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("床号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 就诊ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_entADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ent",  getId_entCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("就诊ID");
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
	 * 收缩压属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInt_sbpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Int_sbp",  getInt_sbpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("收缩压");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 舒张压属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInt_dbpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Int_dbp",  getInt_dbpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("舒张压");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 神志(患者护理)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mindADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mind",  getId_mindCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("神志(患者护理)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 神志(患者护理)编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_mindADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_mind",  getSd_mindCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("神志(患者护理)编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 动脉血氧饱和度属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNv_sao2ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Nv_sao2",  getNv_sao2CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("动脉血氧饱和度");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 足背动脉搏动属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_dapADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_dap",  getFg_dapCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("足背动脉搏动");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 饮食情况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dietADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_diet",  getId_dietCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("饮食情况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 饮食情况编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_dietADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_diet",  getSd_dietCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("饮食情况编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 饮食指导属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_diet_guidanceADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_diet_guidance",  getId_diet_guidanceCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("饮食指导");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 饮食指导编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_diet_guidanceADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_diet_guidance",  getSd_diet_guidanceCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("饮食指导编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 口腔护理属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_mouth_careADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_mouth_care",  getFg_mouth_careCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("口腔护理");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 气管类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pipe_wayADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pipe_way",  getId_pipe_wayCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("气管类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 气管类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_pipe_wayADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_pipe_way",  getSd_pipe_wayCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("气管类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 雾化吸入属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_input_atomizaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_input_atomiza",  getFg_input_atomizaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("雾化吸入");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 膀胱冲洗属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_bladder_washADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_bladder_wash",  getFg_bladder_washCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("膀胱冲洗");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 会阴冲洗属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_perineal_washADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_perineal_wash",  getFg_perineal_washCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("会阴冲洗");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 吸痰属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_suckADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_suck",  getFg_suckCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("吸痰");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 吸氧属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_oxygen_breathADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_oxygen_breath",  getFg_oxygen_breathCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("吸氧");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 鼻饲属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_nasal_feedADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_nasal_feed",  getFg_nasal_feedCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("鼻饲");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 管路属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pipesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pipes",  getId_pipesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("管路");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 管路编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_pipesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_pipes",  getSd_pipesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("管路编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 导管护理属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_pipe_careADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_pipe_care",  getFg_pipe_careCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("导管护理");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体位护理属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_position_careADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_position_care",  getId_position_careCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体位护理");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 体位护理编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_position_careADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_position_care",  getSd_position_careCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体位护理编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 皮肤护理属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_skin_careADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_skin_care",  getFg_skin_careCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("皮肤护理");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 营养护理属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_nutrition_careADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_nutrition_care",  getFg_nutrition_careCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("营养护理");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 病情巡视属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_condition_visitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_condition_visit",  getId_condition_visitCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病情巡视");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 病情巡视编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_condition_visitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_condition_visit",  getSd_condition_visitCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病情巡视编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 置管护理属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_tube_careADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_tube_care",  getId_tube_careCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("置管护理");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 置管护理编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_tube_careADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_tube_care",  getSd_tube_careCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("置管护理编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 护理类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_care_typeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_care_type",  getId_care_typeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("护理类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 护理类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_care_typeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_care_type",  getSd_care_typeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("护理类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 气管护理属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_tracheal_careADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_tracheal_care",  getId_tracheal_careCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("气管护理");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 气管护理编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_tracheal_careADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_tracheal_care",  getSd_tracheal_careCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("气管护理编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 心理护理属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_psycho_careADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_psycho_care",  getId_psycho_careCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("心理护理");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 心理护理编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_psycho_careADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_psycho_care",  getSd_psycho_careCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("心理护理编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 安全护理属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_safe_careADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_safe_care",  getId_safe_careCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("安全护理");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 安全护理编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_safe_careADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_safe_care",  getSd_safe_careCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("安全护理编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 护理隔离种类属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_nursing_isolationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_nursing_isolation",  getId_nursing_isolationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("护理隔离种类");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 护理隔离种类编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_nursing_isolationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_nursing_isolation",  getSd_nursing_isolationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("护理隔离种类编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 病情观察及护理措施属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_ocnmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_ocnm",  getName_ocnmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病情观察及护理措施");
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
	 * 护士签名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_nurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_nur",  getId_nurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("护士签名");
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
		attrDesc.setRefType(true);
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
	 * 神志名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_mindADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_mind",  getName_mindCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("神志名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b7","id_mind=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 饮食名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dietADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_diet",  getName_dietCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("饮食名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b8","id_diet=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 饮食指导名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_diet_guidanceADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_diet_guidance",  getName_diet_guidanceCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("饮食指导名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b9","id_diet_guidance=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 气管方式名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_pipe_wayADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_pipe_way",  getName_pipe_wayCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("气管方式名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b10","id_pipe_way=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 管路名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_pipesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_pipes",  getName_pipesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("管路名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b11","id_pipes=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体位名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_position_careADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_position_care",  getName_position_careCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体位名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b12","id_position_care=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 巡视名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_condition_visitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_condition_visit",  getName_condition_visitCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("巡视名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b13","id_condition_visit=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 置管护理名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_tube_careADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_tube_care",  getName_tube_careCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("置管护理名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b14","id_tube_care=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 护理类型名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_care_typeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_care_type",  getName_care_typeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("护理类型名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b15","id_care_type=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 气管名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_tracheal_careADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_tracheal_care",  getName_tracheal_careCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("气管名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b16","id_tracheal_care=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 心理名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_psycho_careADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_psycho_care",  getName_psycho_careCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("心理名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b17","id_psycho_care=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 安全名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_safe_careADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_safe_care",  getName_safe_careCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("安全名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b18","id_safe_care=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 护理隔离种类名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_nursing_isolationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_nursing_isolation",  getName_nursing_isolationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("护理隔离种类名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b19","id_nursing_isolation=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 护士姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_nurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_nur",  getName_nurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("护士姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b20","id_nur=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 录入人员姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_signADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_sign",  getName_signCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("录入人员姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b21","id_sign=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取护理护理记录单ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_patcareCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_patcare");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("护理护理记录单ID"); 
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
	 * 获取就诊科室表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_dep_phyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dep_phy");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊科室"); 
		return column;
	}
	/**
	 * 获取就诊病区表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_dep_nurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dep_nur");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊病区"); 
		return column;
	}
	/**
	 * 获取患者ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pat");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者ID"); 
		return column;
	}
	/**
	 * 获取床号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_bedCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_bed");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("床号"); 
		return column;
	}
	/**
	 * 获取就诊ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_entCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ent");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊ID"); 
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
	 * 获取收缩压表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInt_sbpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Int_sbp");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("收缩压"); 
		return column;
	}
	/**
	 * 获取舒张压表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInt_dbpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Int_dbp");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("舒张压"); 
		return column;
	}
	/**
	 * 获取神志(患者护理)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mindCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mind");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("神志(患者护理)"); 
		return column;
	}
	/**
	 * 获取神志(患者护理)编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_mindCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_mind");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("神志(患者护理)编码"); 
		return column;
	}
	/**
	 * 获取动脉血氧饱和度表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNv_sao2CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Nv_sao2");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("动脉血氧饱和度"); 
		return column;
	}
	/**
	 * 获取足背动脉搏动表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_dapCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_dap");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("足背动脉搏动"); 
		return column;
	}
	/**
	 * 获取饮食情况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dietCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_diet");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("饮食情况"); 
		return column;
	}
	/**
	 * 获取饮食情况编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_dietCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_diet");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("饮食情况编码"); 
		return column;
	}
	/**
	 * 获取饮食指导表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_diet_guidanceCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_diet_guidance");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("饮食指导"); 
		return column;
	}
	/**
	 * 获取饮食指导编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_diet_guidanceCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_diet_guidance");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("饮食指导编码"); 
		return column;
	}
	/**
	 * 获取口腔护理表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_mouth_careCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_mouth_care");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("口腔护理"); 
		return column;
	}
	/**
	 * 获取气管类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pipe_wayCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pipe_way");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("气管类型"); 
		return column;
	}
	/**
	 * 获取气管类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_pipe_wayCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_pipe_way");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("气管类型编码"); 
		return column;
	}
	/**
	 * 获取雾化吸入表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_input_atomizaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_input_atomiza");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("雾化吸入"); 
		return column;
	}
	/**
	 * 获取膀胱冲洗表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_bladder_washCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_bladder_wash");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("膀胱冲洗"); 
		return column;
	}
	/**
	 * 获取会阴冲洗表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_perineal_washCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_perineal_wash");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("会阴冲洗"); 
		return column;
	}
	/**
	 * 获取吸痰表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_suckCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_suck");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("吸痰"); 
		return column;
	}
	/**
	 * 获取吸氧表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_oxygen_breathCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_oxygen_breath");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("吸氧"); 
		return column;
	}
	/**
	 * 获取鼻饲表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_nasal_feedCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_nasal_feed");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("鼻饲"); 
		return column;
	}
	/**
	 * 获取管路表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pipesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pipes");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("管路"); 
		return column;
	}
	/**
	 * 获取管路编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_pipesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_pipes");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("管路编码"); 
		return column;
	}
	/**
	 * 获取导管护理表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_pipe_careCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_pipe_care");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("导管护理"); 
		return column;
	}
	/**
	 * 获取体位护理表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_position_careCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_position_care");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体位护理"); 
		return column;
	}
	/**
	 * 获取体位护理编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_position_careCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_position_care");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体位护理编码"); 
		return column;
	}
	/**
	 * 获取皮肤护理表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_skin_careCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_skin_care");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("皮肤护理"); 
		return column;
	}
	/**
	 * 获取营养护理表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_nutrition_careCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_nutrition_care");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("营养护理"); 
		return column;
	}
	/**
	 * 获取病情巡视表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_condition_visitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_condition_visit");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病情巡视"); 
		return column;
	}
	/**
	 * 获取病情巡视编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_condition_visitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_condition_visit");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病情巡视编码"); 
		return column;
	}
	/**
	 * 获取置管护理表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_tube_careCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_tube_care");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("置管护理"); 
		return column;
	}
	/**
	 * 获取置管护理编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_tube_careCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_tube_care");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("置管护理编码"); 
		return column;
	}
	/**
	 * 获取护理类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_care_typeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_care_type");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("护理类型"); 
		return column;
	}
	/**
	 * 获取护理类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_care_typeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_care_type");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("护理类型编码"); 
		return column;
	}
	/**
	 * 获取气管护理表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_tracheal_careCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_tracheal_care");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("气管护理"); 
		return column;
	}
	/**
	 * 获取气管护理编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_tracheal_careCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_tracheal_care");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("气管护理编码"); 
		return column;
	}
	/**
	 * 获取心理护理表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_psycho_careCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_psycho_care");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("心理护理"); 
		return column;
	}
	/**
	 * 获取心理护理编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_psycho_careCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_psycho_care");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("心理护理编码"); 
		return column;
	}
	/**
	 * 获取安全护理表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_safe_careCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_safe_care");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("安全护理"); 
		return column;
	}
	/**
	 * 获取安全护理编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_safe_careCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_safe_care");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("安全护理编码"); 
		return column;
	}
	/**
	 * 获取护理隔离种类表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_nursing_isolationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_nursing_isolation");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("护理隔离种类"); 
		return column;
	}
	/**
	 * 获取护理隔离种类编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_nursing_isolationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_nursing_isolation");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("护理隔离种类编码"); 
		return column;
	}
	/**
	 * 获取病情观察及护理措施表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_ocnmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_ocnm");
		column.setLength(1000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病情观察及护理措施"); 
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
	 * 获取护士签名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_nurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_nur");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("护士签名"); 
		return column;
	}
	/**
	 * 获取id_sign表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_signCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_sign");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("id_sign"); 
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
	 * 获取神志名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_mindCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_mind");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("神志名称"); 
		return column;
	}
	/**
	 * 获取饮食名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_dietCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_diet");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("饮食名称"); 
		return column;
	}
	/**
	 * 获取饮食指导名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_diet_guidanceCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_diet_guidance");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("饮食指导名称"); 
		return column;
	}
	/**
	 * 获取气管方式名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_pipe_wayCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_pipe_way");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("气管方式名称"); 
		return column;
	}
	/**
	 * 获取管路名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_pipesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_pipes");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("管路名称"); 
		return column;
	}
	/**
	 * 获取体位名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_position_careCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_position_care");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体位名称"); 
		return column;
	}
	/**
	 * 获取巡视名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_condition_visitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_condition_visit");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("巡视名称"); 
		return column;
	}
	/**
	 * 获取置管护理名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_tube_careCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_tube_care");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("置管护理名称"); 
		return column;
	}
	/**
	 * 获取护理类型名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_care_typeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_care_type");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("护理类型名称"); 
		return column;
	}
	/**
	 * 获取气管名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_tracheal_careCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_tracheal_care");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("气管名称"); 
		return column;
	}
	/**
	 * 获取心理名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_psycho_careCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_psycho_care");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("心理名称"); 
		return column;
	}
	/**
	 * 获取安全名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_safe_careCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_safe_care");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("安全名称"); 
		return column;
	}
	/**
	 * 获取护理隔离种类名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_nursing_isolationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_nursing_isolation");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("护理隔离种类名称"); 
		return column;
	}
	/**
	 * 获取护士姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_nurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_nur");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("护士姓名"); 
		return column;
	}
	/**
	 * 获取录入人员姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_signCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_sign");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("录入人员姓名"); 
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
