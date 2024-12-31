
package iih.ci.ord.bloodbadreaction.d.desc;

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
 * 输血不良反应回报单 DO 元数据信息
 */
public class CiBloodAdverseReactionDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.ci.ord.bloodbadreaction.d.CiBloodAdverseReactionDO";
	public static final String CLASS_DISPALYNAME = "输血不良反应回报单";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "ci_blood_adverse_reaction";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_ar";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public CiBloodAdverseReactionDODesc(){
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
		this.setKeyDesc(getId_arADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_arADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getUse_id_orADesc(tblDesc));
		this.add(getPre_id_orADesc(tblDesc));
		this.add(getId_enADesc(tblDesc));
		this.add(getId_patADesc(tblDesc));
		this.add(getId_sexADesc(tblDesc));
		this.add(getSd_sexADesc(tblDesc));
		this.add(getSd_patADesc(tblDesc));
		this.add(getId_bloodtype_patADesc(tblDesc));
		this.add(getSd_bloodtype_patADesc(tblDesc));
		this.add(getFg_blood_hisADesc(tblDesc));
		this.add(getDt_birthADesc(tblDesc));
		this.add(getId_depADesc(tblDesc));
		this.add(getId_disease_diagnosisADesc(tblDesc));
		this.add(getSd_disease_diagnosisADesc(tblDesc));
		this.add(getOp_noADesc(tblDesc));
		this.add(getFg_pregnantADesc(tblDesc));
		this.add(getPregnantADesc(tblDesc));
		this.add(getBirthADesc(tblDesc));
		this.add(getOthADesc(tblDesc));
		this.add(getId_operateADesc(tblDesc));
		this.add(getSd_operateADesc(tblDesc));
		this.add(getId_bloodtype_sipplyADesc(tblDesc));
		this.add(getSd_bloodtype_sipplyADesc(tblDesc));
		this.add(getId_rhADesc(tblDesc));
		this.add(getSd_rhADesc(tblDesc));
		this.add(getReaction_timeADesc(tblDesc));
		this.add(getBlood_bag_noADesc(tblDesc));
		this.add(getCollection_timeADesc(tblDesc));
		this.add(getId_bloodtype_tranADesc(tblDesc));
		this.add(getSd_bloodtype_tranADesc(tblDesc));
		this.add(getFg_tran_blood_bad_reactionADesc(tblDesc));
		this.add(getFg_feverADesc(tblDesc));
		this.add(getFg_allergyADesc(tblDesc));
		this.add(getFg_hemolysisADesc(tblDesc));
		this.add(getFg_bacterium_contaminateADesc(tblDesc));
		this.add(getFg_othADesc(tblDesc));
		this.add(getId_dispensing_nurseADesc(tblDesc));
		this.add(getSd_dispensing_nurseADesc(tblDesc));
		this.add(getId_paracent_nurseADesc(tblDesc));
		this.add(getSd_paracent_nurseADesc(tblDesc));
		this.add(getId_ward_nurseADesc(tblDesc));
		this.add(getSd_ward_nurseADesc(tblDesc));
		this.add(getId_psndocADesc(tblDesc));
		this.add(getSd_psndocADesc(tblDesc));
		this.add(getReporterADesc(tblDesc));
		this.add(getDept_signADesc(tblDesc));
		this.add(getReport_timeADesc(tblDesc));
		this.add(getTimeADesc(tblDesc));
		this.add(getId_blood_specADesc(tblDesc));
		this.add(getSd_blood_specADesc(tblDesc));
		this.add(getDef1ADesc(tblDesc));
		this.add(getDef2ADesc(tblDesc));
		this.add(getDef3ADesc(tblDesc));
		this.add(getDef4ADesc(tblDesc));
		this.add(getDef5ADesc(tblDesc));
		this.add(getDef6ADesc(tblDesc));
		this.add(getDef7ADesc(tblDesc));
		this.add(getDef8ADesc(tblDesc));
		this.add(getDef9ADesc(tblDesc));
		this.add(getDef10ADesc(tblDesc));
		this.add(getDef11ADesc(tblDesc));
		this.add(getDef12ADesc(tblDesc));
		this.add(getDef13ADesc(tblDesc));
		this.add(getDef14ADesc(tblDesc));
		this.add(getDef15ADesc(tblDesc));
		this.add(getDef16ADesc(tblDesc));
		this.add(getDef17ADesc(tblDesc));
		this.add(getDef18ADesc(tblDesc));
		this.add(getDef19ADesc(tblDesc));
		this.add(getDef20ADesc(tblDesc));
		this.add(getDef21ADesc(tblDesc));
		this.add(getDef22ADesc(tblDesc));
		this.add(getDef23ADesc(tblDesc));
		this.add(getDef24ADesc(tblDesc));
		this.add(getDef25ADesc(tblDesc));
		this.add(getDef26ADesc(tblDesc));
		this.add(getDef27ADesc(tblDesc));
		this.add(getDef28ADesc(tblDesc));
		this.add(getDef29ADesc(tblDesc));
		this.add(getDef30ADesc(tblDesc));
		this.add(getDef31ADesc(tblDesc));
		this.add(getDef32ADesc(tblDesc));
		this.add(getDef33ADesc(tblDesc));
		this.add(getDef34ADesc(tblDesc));
		this.add(getDef35ADesc(tblDesc));
		this.add(getDef36ADesc(tblDesc));
		this.add(getDef37ADesc(tblDesc));
		this.add(getDef38ADesc(tblDesc));
		this.add(getDef39ADesc(tblDesc));
		this.add(getDef40ADesc(tblDesc));
		this.add(getDef41ADesc(tblDesc));
		this.add(getDef42ADesc(tblDesc));
		this.add(getDef43ADesc(tblDesc));
		this.add(getDef44ADesc(tblDesc));
		this.add(getDef45ADesc(tblDesc));
		this.add(getDef46ADesc(tblDesc));
		this.add(getDef47ADesc(tblDesc));
		this.add(getDef48ADesc(tblDesc));
		this.add(getDef49ADesc(tblDesc));
		this.add(getDef50ADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getName_patADesc(tblDesc));
		this.add(getCode_patADesc(tblDesc));
		this.add(getName_sexADesc(tblDesc));
		this.add(getName_bloodtype_patADesc(tblDesc));
		this.add(getCode_depADesc(tblDesc));
		this.add(getName_depADesc(tblDesc));
		this.add(getName_disease_diagnosisADesc(tblDesc));
		this.add(getName_operateADesc(tblDesc));
		this.add(getName_bloodtype_sipplyADesc(tblDesc));
		this.add(getName_rhADesc(tblDesc));
		this.add(getName_bloodtype_tranADesc(tblDesc));
		this.add(getName_dispensing_nurseADesc(tblDesc));
		this.add(getName_paracent_nurseADesc(tblDesc));
		this.add(getName_ward_nurseADesc(tblDesc));
		this.add(getName_psndocADesc(tblDesc));
		this.add(getName_blood_specADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_arCDesc(tblDesc));
		tblDesc.add(getId_arCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getUse_id_orCDesc(tblDesc));
		tblDesc.add(getPre_id_orCDesc(tblDesc));
		tblDesc.add(getId_enCDesc(tblDesc));
		tblDesc.add(getId_patCDesc(tblDesc));
		tblDesc.add(getId_sexCDesc(tblDesc));
		tblDesc.add(getSd_sexCDesc(tblDesc));
		tblDesc.add(getSd_patCDesc(tblDesc));
		tblDesc.add(getId_bloodtype_patCDesc(tblDesc));
		tblDesc.add(getSd_bloodtype_patCDesc(tblDesc));
		tblDesc.add(getFg_blood_hisCDesc(tblDesc));
		tblDesc.add(getDt_birthCDesc(tblDesc));
		tblDesc.add(getId_depCDesc(tblDesc));
		tblDesc.add(getId_disease_diagnosisCDesc(tblDesc));
		tblDesc.add(getSd_disease_diagnosisCDesc(tblDesc));
		tblDesc.add(getOp_noCDesc(tblDesc));
		tblDesc.add(getFg_pregnantCDesc(tblDesc));
		tblDesc.add(getPregnantCDesc(tblDesc));
		tblDesc.add(getBirthCDesc(tblDesc));
		tblDesc.add(getOthCDesc(tblDesc));
		tblDesc.add(getId_operateCDesc(tblDesc));
		tblDesc.add(getSd_operateCDesc(tblDesc));
		tblDesc.add(getId_bloodtype_sipplyCDesc(tblDesc));
		tblDesc.add(getSd_bloodtype_sipplyCDesc(tblDesc));
		tblDesc.add(getId_rhCDesc(tblDesc));
		tblDesc.add(getSd_rhCDesc(tblDesc));
		tblDesc.add(getReaction_timeCDesc(tblDesc));
		tblDesc.add(getBlood_bag_noCDesc(tblDesc));
		tblDesc.add(getCollection_timeCDesc(tblDesc));
		tblDesc.add(getId_bloodtype_tranCDesc(tblDesc));
		tblDesc.add(getSd_bloodtype_tranCDesc(tblDesc));
		tblDesc.add(getFg_tran_blood_bad_reactionCDesc(tblDesc));
		tblDesc.add(getFg_feverCDesc(tblDesc));
		tblDesc.add(getFg_allergyCDesc(tblDesc));
		tblDesc.add(getFg_hemolysisCDesc(tblDesc));
		tblDesc.add(getFg_bacterium_contaminateCDesc(tblDesc));
		tblDesc.add(getFg_othCDesc(tblDesc));
		tblDesc.add(getId_dispensing_nurseCDesc(tblDesc));
		tblDesc.add(getSd_dispensing_nurseCDesc(tblDesc));
		tblDesc.add(getId_paracent_nurseCDesc(tblDesc));
		tblDesc.add(getSd_paracent_nurseCDesc(tblDesc));
		tblDesc.add(getId_ward_nurseCDesc(tblDesc));
		tblDesc.add(getSd_ward_nurseCDesc(tblDesc));
		tblDesc.add(getId_psndocCDesc(tblDesc));
		tblDesc.add(getSd_psndocCDesc(tblDesc));
		tblDesc.add(getReporterCDesc(tblDesc));
		tblDesc.add(getDept_signCDesc(tblDesc));
		tblDesc.add(getReport_timeCDesc(tblDesc));
		tblDesc.add(getTimeCDesc(tblDesc));
		tblDesc.add(getId_blood_specCDesc(tblDesc));
		tblDesc.add(getSd_blood_specCDesc(tblDesc));
		tblDesc.add(getDef1CDesc(tblDesc));
		tblDesc.add(getDef2CDesc(tblDesc));
		tblDesc.add(getDef3CDesc(tblDesc));
		tblDesc.add(getDef4CDesc(tblDesc));
		tblDesc.add(getDef5CDesc(tblDesc));
		tblDesc.add(getDef6CDesc(tblDesc));
		tblDesc.add(getDef7CDesc(tblDesc));
		tblDesc.add(getDef8CDesc(tblDesc));
		tblDesc.add(getDef9CDesc(tblDesc));
		tblDesc.add(getDef10CDesc(tblDesc));
		tblDesc.add(getDef11CDesc(tblDesc));
		tblDesc.add(getDef12CDesc(tblDesc));
		tblDesc.add(getDef13CDesc(tblDesc));
		tblDesc.add(getDef14CDesc(tblDesc));
		tblDesc.add(getDef15CDesc(tblDesc));
		tblDesc.add(getDef16CDesc(tblDesc));
		tblDesc.add(getDef17CDesc(tblDesc));
		tblDesc.add(getDef18CDesc(tblDesc));
		tblDesc.add(getDef19CDesc(tblDesc));
		tblDesc.add(getDef20CDesc(tblDesc));
		tblDesc.add(getDef21CDesc(tblDesc));
		tblDesc.add(getDef22CDesc(tblDesc));
		tblDesc.add(getDef23CDesc(tblDesc));
		tblDesc.add(getDef24CDesc(tblDesc));
		tblDesc.add(getDef25CDesc(tblDesc));
		tblDesc.add(getDef26CDesc(tblDesc));
		tblDesc.add(getDef27CDesc(tblDesc));
		tblDesc.add(getDef28CDesc(tblDesc));
		tblDesc.add(getDef29CDesc(tblDesc));
		tblDesc.add(getDef30CDesc(tblDesc));
		tblDesc.add(getDef31CDesc(tblDesc));
		tblDesc.add(getDef32CDesc(tblDesc));
		tblDesc.add(getDef33CDesc(tblDesc));
		tblDesc.add(getDef34CDesc(tblDesc));
		tblDesc.add(getDef35CDesc(tblDesc));
		tblDesc.add(getDef36CDesc(tblDesc));
		tblDesc.add(getDef37CDesc(tblDesc));
		tblDesc.add(getDef38CDesc(tblDesc));
		tblDesc.add(getDef39CDesc(tblDesc));
		tblDesc.add(getDef40CDesc(tblDesc));
		tblDesc.add(getDef41CDesc(tblDesc));
		tblDesc.add(getDef42CDesc(tblDesc));
		tblDesc.add(getDef43CDesc(tblDesc));
		tblDesc.add(getDef44CDesc(tblDesc));
		tblDesc.add(getDef45CDesc(tblDesc));
		tblDesc.add(getDef46CDesc(tblDesc));
		tblDesc.add(getDef47CDesc(tblDesc));
		tblDesc.add(getDef48CDesc(tblDesc));
		tblDesc.add(getDef49CDesc(tblDesc));
		tblDesc.add(getDef50CDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 不良反应单主键标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_arADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ar",  getId_arCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("不良反应单主键标识");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
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
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
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
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 用血医嘱属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getUse_id_orADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Use_id_or",  getUse_id_orCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用血医嘱");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备血医嘱属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPre_id_orADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pre_id_or",  getPre_id_orCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备血医嘱");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者就诊主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_enADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_en",  getId_enCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者就诊主键");
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
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 性别ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_sexADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_sex",  getId_sexCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("性别ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 性别编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_sexADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_sex",  getSd_sexCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("性别编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_patADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_pat",  getSd_patCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者血型ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_bloodtype_patADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_bloodtype_pat",  getId_bloodtype_patCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者血型ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 患者血型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_bloodtype_patADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_bloodtype_pat",  getSd_bloodtype_patCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者血型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 有无输血史属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_blood_hisADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_blood_his",  getFg_blood_hisCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("有无输血史");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 出生日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_birthADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_birth",  getDt_birthCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("出生日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 科别属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_depADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep",  getId_depCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("科别");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 疾病诊断ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_disease_diagnosisADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_disease_diagnosis",  getId_disease_diagnosisCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("疾病诊断ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 疾病诊断编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_disease_diagnosisADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_disease_diagnosis",  getSd_disease_diagnosisCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("疾病诊断编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 门诊号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOp_noADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Op_no",  getOp_noCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("门诊号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否有孕产属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_pregnantADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_pregnant",  getFg_pregnantCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否有孕产");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 孕属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPregnantADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pregnant",  getPregnantCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("孕");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 产属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBirthADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Birth",  getBirthCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("产");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 其他属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOthADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Oth",  getOthCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("其他");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_operateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_operate",  getId_operateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 手术编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_operateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_operate",  getSd_operateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 供血血型ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_bloodtype_sipplyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_bloodtype_sipply",  getId_bloodtype_sipplyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("供血血型ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 供血血型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_bloodtype_sipplyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_bloodtype_sipply",  getSd_bloodtype_sipplyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("供血血型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * RH血型ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_rhADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_rh",  getId_rhCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("RH血型ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * RH血型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_rhADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_rh",  getSd_rhCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("RH血型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 反应时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getReaction_timeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Reaction_time",  getReaction_timeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("反应时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 血袋储血号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBlood_bag_noADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Blood_bag_no",  getBlood_bag_noCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("血袋储血号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 采血时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCollection_timeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Collection_time",  getCollection_timeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("采血时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 输血种类ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_bloodtype_tranADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_bloodtype_tran",  getId_bloodtype_tranCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("输血种类ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 输血种类编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_bloodtype_tranADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_bloodtype_tran",  getSd_bloodtype_tranCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("输血种类编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 有无不良反应属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_tran_blood_bad_reactionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_tran_blood_bad_reaction",  getFg_tran_blood_bad_reactionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("有无不良反应");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 不良:发热反应属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_feverADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_fever",  getFg_feverCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("不良:发热反应");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 不良:过敏反应属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_allergyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_allergy",  getFg_allergyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("不良:过敏反应");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 不良:溶血反应属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_hemolysisADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_hemolysis",  getFg_hemolysisCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("不良:溶血反应");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 不良:细菌污染属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_bacterium_contaminateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_bacterium_contaminate",  getFg_bacterium_contaminateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("不良:细菌污染");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 不良:其他属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_othADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_oth",  getFg_othCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("不良:其他");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 配药护士ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dispensing_nurseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dispensing_nurse",  getId_dispensing_nurseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("配药护士ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 配药护士编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_dispensing_nurseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_dispensing_nurse",  getSd_dispensing_nurseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("配药护士编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 穿刺护士ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_paracent_nurseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_paracent_nurse",  getId_paracent_nurseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("穿刺护士ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 穿刺护士编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_paracent_nurseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_paracent_nurse",  getSd_paracent_nurseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("穿刺护士编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 病房护士长ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ward_nurseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ward_nurse",  getId_ward_nurseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病房护士长ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 病房护士长编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_ward_nurseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_ward_nurse",  getSd_ward_nurseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病房护士长编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医生ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_psndocADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_psndoc",  getId_psndocCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医生ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 医生编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_psndocADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_psndoc",  getSd_psndocCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医生编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 填报人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getReporterADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Reporter",  getReporterCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("填报人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 输血科签字属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDept_signADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dept_sign",  getDept_signCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("输血科签字");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 填报时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getReport_timeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Report_time",  getReport_timeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("填报时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTimeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Time",  getTimeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 血袋规格属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_blood_specADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_blood_spec",  getId_blood_specCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("血袋规格");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 血袋规格编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_blood_specADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_blood_spec",  getSd_blood_specCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("血袋规格编码");
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
	 * 客户扩展字段6属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef6ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def6",  getDef6CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段6");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段7属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef7ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def7",  getDef7CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段7");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段8属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef8ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def8",  getDef8CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段8");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段9属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef9ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def9",  getDef9CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段9");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段10属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef10ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def10",  getDef10CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段10");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段11属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef11ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def11",  getDef11CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段11");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段12属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef12ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def12",  getDef12CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段12");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段13属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef13ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def13",  getDef13CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段13");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段14属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef14ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def14",  getDef14CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段14");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段15属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef15ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def15",  getDef15CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段15");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段16属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef16ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def16",  getDef16CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段16");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段17属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef17ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def17",  getDef17CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段17");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段18属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef18ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def18",  getDef18CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段18");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段19属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef19ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def19",  getDef19CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段19");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段20属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef20ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def20",  getDef20CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段20");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段21属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef21ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def21",  getDef21CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段21");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段22属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef22ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def22",  getDef22CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段22");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段23属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef23ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def23",  getDef23CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段23");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段24属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef24ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def24",  getDef24CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段24");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段25属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef25ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def25",  getDef25CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段25");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段26属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef26ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def26",  getDef26CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段26");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段27属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef27ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def27",  getDef27CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段27");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段28属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef28ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def28",  getDef28CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段28");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段29属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef29ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def29",  getDef29CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段29");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段30属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef30ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def30",  getDef30CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段30");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段31属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef31ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def31",  getDef31CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段31");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段32属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef32ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def32",  getDef32CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段32");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段33属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef33ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def33",  getDef33CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段33");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段34属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef34ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def34",  getDef34CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段34");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段35属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef35ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def35",  getDef35CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段35");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段36属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef36ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def36",  getDef36CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段36");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段371属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef37ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def37",  getDef37CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段371");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段38属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef38ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def38",  getDef38CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段38");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段39属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef39ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def39",  getDef39CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段39");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段40属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef40ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def40",  getDef40CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段40");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段41属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef41ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def41",  getDef41CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段41");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段42属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef42ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def42",  getDef42CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段42");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段43属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef43ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def43",  getDef43CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段43");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段44属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef44ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def44",  getDef44CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段44");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段45属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef45ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def45",  getDef45CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段45");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段46属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef46ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def46",  getDef46CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段46");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段47属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef47ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def47",  getDef47CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段47");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段48属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef48ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def48",  getDef48CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段48");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段49属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef49ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def49",  getDef49CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段49");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段50属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef50ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def50",  getDef50CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段50");
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
		attrDesc.setRefTblInfos(new String[]{"pi_pat a0b13","id_pat=id_pat","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_patADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_pat",  getCode_patCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pi_pat a0b13","id_pat=id_pat","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_sexADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_sex",  getName_sexCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b14","id_sex=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_bloodtype_patADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_bloodtype_pat",  getName_bloodtype_patCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b2","id_bloodtype_pat=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_depADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_dep",  getCode_depCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b15","id_dep=id_dep","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_depADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dep",  getName_depCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b15","id_dep=id_dep","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊断名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_disease_diagnosisADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_disease_diagnosis",  getName_disease_diagnosisCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_di_def a0b3","id_disease_diagnosis=id_didef","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 服务名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_operateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_operate",  getName_operateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_srv a0b4","id_operate=id_srv","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_bloodtype_sipplyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_bloodtype_sipply",  getName_bloodtype_sipplyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b8","id_bloodtype_sipply=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_rhADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_rh",  getName_rhCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b7","id_rh=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 服务名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_bloodtype_tranADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_bloodtype_tran",  getName_bloodtype_tranCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_srv a0b5","id_bloodtype_tran=id_srv","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dispensing_nurseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dispensing_nurse",  getName_dispensing_nurseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b9","id_dispensing_nurse=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_paracent_nurseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_paracent_nurse",  getName_paracent_nurseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b10","id_paracent_nurse=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_ward_nurseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_ward_nurse",  getName_ward_nurseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b11","id_ward_nurse=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_psndocADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_psndoc",  getName_psndocCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b12","id_psndoc=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_blood_specADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_blood_spec",  getName_blood_specCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b16","id_blood_spec=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取不良反应单主键标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_arCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ar");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("不良反应单主键标识"); 
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
	 * 获取用血医嘱表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getUse_id_orCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Use_id_or");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("用血医嘱"); 
		return column;
	}
	/**
	 * 获取备血医嘱表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPre_id_orCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pre_id_or");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备血医嘱"); 
		return column;
	}
	/**
	 * 获取患者就诊主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_enCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_en");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("患者就诊主键"); 
		return column;
	}
	/**
	 * 获取患者id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pat");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者id"); 
		return column;
	}
	/**
	 * 获取性别ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_sexCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_sex");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("性别ID"); 
		return column;
	}
	/**
	 * 获取性别编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_sexCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_sex");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("性别编码"); 
		return column;
	}
	/**
	 * 获取患者编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_pat");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者编码"); 
		return column;
	}
	/**
	 * 获取患者血型ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_bloodtype_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_bloodtype_pat");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者血型ID"); 
		return column;
	}
	/**
	 * 获取患者血型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_bloodtype_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_bloodtype_pat");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者血型编码"); 
		return column;
	}
	/**
	 * 获取有无输血史表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_blood_hisCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_blood_his");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("有无输血史"); 
		return column;
	}
	/**
	 * 获取出生日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_birthCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_birth");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("出生日期"); 
		return column;
	}
	/**
	 * 获取科别表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_depCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("科别"); 
		return column;
	}
	/**
	 * 获取疾病诊断ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_disease_diagnosisCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_disease_diagnosis");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("疾病诊断ID"); 
		return column;
	}
	/**
	 * 获取疾病诊断编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_disease_diagnosisCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_disease_diagnosis");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("疾病诊断编码"); 
		return column;
	}
	/**
	 * 获取门诊号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOp_noCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Op_no");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("门诊号"); 
		return column;
	}
	/**
	 * 获取是否有孕产表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_pregnantCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_pregnant");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否有孕产"); 
		return column;
	}
	/**
	 * 获取孕表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPregnantCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pregnant");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("孕"); 
		return column;
	}
	/**
	 * 获取产表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBirthCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Birth");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("产"); 
		return column;
	}
	/**
	 * 获取其他表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOthCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Oth");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("其他"); 
		return column;
	}
	/**
	 * 获取手术ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_operateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_operate");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术ID"); 
		return column;
	}
	/**
	 * 获取手术编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_operateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_operate");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术编码"); 
		return column;
	}
	/**
	 * 获取供血血型ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_bloodtype_sipplyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_bloodtype_sipply");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("供血血型ID"); 
		return column;
	}
	/**
	 * 获取供血血型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_bloodtype_sipplyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_bloodtype_sipply");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("供血血型编码"); 
		return column;
	}
	/**
	 * 获取RH血型ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_rhCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_rh");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("RH血型ID"); 
		return column;
	}
	/**
	 * 获取RH血型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_rhCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_rh");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("RH血型编码"); 
		return column;
	}
	/**
	 * 获取反应时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getReaction_timeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Reaction_time");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("反应时间"); 
		return column;
	}
	/**
	 * 获取血袋储血号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBlood_bag_noCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Blood_bag_no");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("血袋储血号"); 
		return column;
	}
	/**
	 * 获取采血时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCollection_timeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Collection_time");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("采血时间"); 
		return column;
	}
	/**
	 * 获取输血种类ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_bloodtype_tranCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_bloodtype_tran");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("输血种类ID"); 
		return column;
	}
	/**
	 * 获取输血种类编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_bloodtype_tranCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_bloodtype_tran");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("输血种类编码"); 
		return column;
	}
	/**
	 * 获取有无不良反应表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_tran_blood_bad_reactionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_tran_blood_bad_reaction");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("有无不良反应"); 
		return column;
	}
	/**
	 * 获取不良:发热反应表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_feverCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_fever");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("不良:发热反应"); 
		return column;
	}
	/**
	 * 获取不良:过敏反应表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_allergyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_allergy");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("不良:过敏反应"); 
		return column;
	}
	/**
	 * 获取不良:溶血反应表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_hemolysisCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_hemolysis");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("不良:溶血反应"); 
		return column;
	}
	/**
	 * 获取不良:细菌污染表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_bacterium_contaminateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_bacterium_contaminate");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("不良:细菌污染"); 
		return column;
	}
	/**
	 * 获取不良:其他表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_othCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_oth");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("不良:其他"); 
		return column;
	}
	/**
	 * 获取配药护士ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dispensing_nurseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dispensing_nurse");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("配药护士ID"); 
		return column;
	}
	/**
	 * 获取配药护士编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_dispensing_nurseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_dispensing_nurse");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("配药护士编码"); 
		return column;
	}
	/**
	 * 获取穿刺护士ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_paracent_nurseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_paracent_nurse");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("穿刺护士ID"); 
		return column;
	}
	/**
	 * 获取穿刺护士编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_paracent_nurseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_paracent_nurse");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("穿刺护士编码"); 
		return column;
	}
	/**
	 * 获取病房护士长ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ward_nurseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ward_nurse");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病房护士长ID"); 
		return column;
	}
	/**
	 * 获取病房护士长编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_ward_nurseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_ward_nurse");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病房护士长编码"); 
		return column;
	}
	/**
	 * 获取医生ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_psndocCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_psndoc");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医生ID"); 
		return column;
	}
	/**
	 * 获取医生编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_psndocCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_psndoc");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医生编码"); 
		return column;
	}
	/**
	 * 获取填报人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getReporterCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Reporter");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("填报人"); 
		return column;
	}
	/**
	 * 获取输血科签字表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDept_signCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dept_sign");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("输血科签字"); 
		return column;
	}
	/**
	 * 获取填报时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getReport_timeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Report_time");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("填报时间"); 
		return column;
	}
	/**
	 * 获取时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTimeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Time");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("时间"); 
		return column;
	}
	/**
	 * 获取血袋规格表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_blood_specCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_blood_spec");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("血袋规格"); 
		return column;
	}
	/**
	 * 获取血袋规格编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_blood_specCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_blood_spec");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("血袋规格编码"); 
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
	 * 获取客户扩展字段6表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef6CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def6");
		column.setLength(110);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段6"); 
		return column;
	}
	/**
	 * 获取客户扩展字段7表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef7CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def7");
		column.setLength(110);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段7"); 
		return column;
	}
	/**
	 * 获取客户扩展字段8表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef8CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def8");
		column.setLength(110);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段8"); 
		return column;
	}
	/**
	 * 获取客户扩展字段9表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef9CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def9");
		column.setLength(110);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段9"); 
		return column;
	}
	/**
	 * 获取客户扩展字段10表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef10CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def10");
		column.setLength(110);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段10"); 
		return column;
	}
	/**
	 * 获取客户扩展字段11表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef11CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def11");
		column.setLength(110);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段11"); 
		return column;
	}
	/**
	 * 获取客户扩展字段12表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef12CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def12");
		column.setLength(110);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段12"); 
		return column;
	}
	/**
	 * 获取客户扩展字段13表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef13CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def13");
		column.setLength(110);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段13"); 
		return column;
	}
	/**
	 * 获取客户扩展字段14表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef14CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def14");
		column.setLength(110);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段14"); 
		return column;
	}
	/**
	 * 获取客户扩展字段15表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef15CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def15");
		column.setLength(110);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段15"); 
		return column;
	}
	/**
	 * 获取客户扩展字段16表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef16CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def16");
		column.setLength(110);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段16"); 
		return column;
	}
	/**
	 * 获取客户扩展字段17表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef17CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def17");
		column.setLength(110);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段17"); 
		return column;
	}
	/**
	 * 获取客户扩展字段18表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef18CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def18");
		column.setLength(110);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段18"); 
		return column;
	}
	/**
	 * 获取客户扩展字段19表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef19CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def19");
		column.setLength(110);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段19"); 
		return column;
	}
	/**
	 * 获取客户扩展字段20表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef20CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def20");
		column.setLength(110);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段20"); 
		return column;
	}
	/**
	 * 获取客户扩展字段21表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef21CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def21");
		column.setLength(110);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段21"); 
		return column;
	}
	/**
	 * 获取客户扩展字段22表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef22CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def22");
		column.setLength(110);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段22"); 
		return column;
	}
	/**
	 * 获取客户扩展字段23表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef23CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def23");
		column.setLength(110);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段23"); 
		return column;
	}
	/**
	 * 获取客户扩展字段24表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef24CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def24");
		column.setLength(110);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段24"); 
		return column;
	}
	/**
	 * 获取客户扩展字段25表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef25CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def25");
		column.setLength(110);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段25"); 
		return column;
	}
	/**
	 * 获取客户扩展字段26表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef26CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def26");
		column.setLength(110);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段26"); 
		return column;
	}
	/**
	 * 获取客户扩展字段27表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef27CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def27");
		column.setLength(110);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段27"); 
		return column;
	}
	/**
	 * 获取客户扩展字段28表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef28CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def28");
		column.setLength(110);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段28"); 
		return column;
	}
	/**
	 * 获取客户扩展字段29表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef29CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def29");
		column.setLength(110);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段29"); 
		return column;
	}
	/**
	 * 获取客户扩展字段30表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef30CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def30");
		column.setLength(110);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段30"); 
		return column;
	}
	/**
	 * 获取客户扩展字段31表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef31CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def31");
		column.setLength(110);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段31"); 
		return column;
	}
	/**
	 * 获取客户扩展字段32表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef32CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def32");
		column.setLength(110);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段32"); 
		return column;
	}
	/**
	 * 获取客户扩展字段33表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef33CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def33");
		column.setLength(110);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段33"); 
		return column;
	}
	/**
	 * 获取客户扩展字段34表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef34CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def34");
		column.setLength(110);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段34"); 
		return column;
	}
	/**
	 * 获取客户扩展字段35表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef35CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def35");
		column.setLength(110);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段35"); 
		return column;
	}
	/**
	 * 获取客户扩展字段36表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef36CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def36");
		column.setLength(110);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段36"); 
		return column;
	}
	/**
	 * 获取客户扩展字段371表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef37CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def37");
		column.setLength(110);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段371"); 
		return column;
	}
	/**
	 * 获取客户扩展字段38表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef38CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def38");
		column.setLength(110);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段38"); 
		return column;
	}
	/**
	 * 获取客户扩展字段39表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef39CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def39");
		column.setLength(110);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段39"); 
		return column;
	}
	/**
	 * 获取客户扩展字段40表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef40CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def40");
		column.setLength(110);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段40"); 
		return column;
	}
	/**
	 * 获取客户扩展字段41表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef41CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def41");
		column.setLength(110);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段41"); 
		return column;
	}
	/**
	 * 获取客户扩展字段42表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef42CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def42");
		column.setLength(110);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段42"); 
		return column;
	}
	/**
	 * 获取客户扩展字段43表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef43CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def43");
		column.setLength(110);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段43"); 
		return column;
	}
	/**
	 * 获取客户扩展字段44表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef44CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def44");
		column.setLength(110);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段44"); 
		return column;
	}
	/**
	 * 获取客户扩展字段45表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef45CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def45");
		column.setLength(110);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段45"); 
		return column;
	}
	/**
	 * 获取客户扩展字段46表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef46CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def46");
		column.setLength(110);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段46"); 
		return column;
	}
	/**
	 * 获取客户扩展字段47表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef47CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def47");
		column.setLength(110);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段47"); 
		return column;
	}
	/**
	 * 获取客户扩展字段48表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef48CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def48");
		column.setLength(110);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段48"); 
		return column;
	}
	/**
	 * 获取客户扩展字段49表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef49CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def49");
		column.setLength(110);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段49"); 
		return column;
	}
	/**
	 * 获取客户扩展字段50表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef50CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def50");
		column.setLength(110);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段50"); 
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
	 * 获取患者姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_pat");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者姓名"); 
		return column;
	}
	/**
	 * 获取患者编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_pat");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_sexCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_sex");
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
	private IColumnDesc getName_bloodtype_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_bloodtype_pat");
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
	private IColumnDesc getCode_depCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_dep");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_depCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dep");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取诊断名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_disease_diagnosisCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_disease_diagnosis");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断名称"); 
		return column;
	}
	/**
	 * 获取服务名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_operateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_operate");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_bloodtype_sipplyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_bloodtype_sipply");
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
	private IColumnDesc getName_rhCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_rh");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取服务名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_bloodtype_tranCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_bloodtype_tran");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务名称"); 
		return column;
	}
	/**
	 * 获取姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_dispensing_nurseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dispensing_nurse");
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
	private IColumnDesc getName_paracent_nurseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_paracent_nurse");
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
	private IColumnDesc getName_ward_nurseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_ward_nurse");
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
	private IColumnDesc getName_psndocCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_psndoc");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("姓名"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_blood_specCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_blood_spec");
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
		iBDDataInfoFldMap.put("id","Id_ar");
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
