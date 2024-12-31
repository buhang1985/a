
package iih.nmr.pkuf.admnur.d.desc;

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
 * 患者入院护理评估单 DO 元数据信息
 */
public class AdmNurDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.nmr.pkuf.admnur.d.AdmNurDO";
	public static final String CLASS_DISPALYNAME = "患者入院护理评估单";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "NMR_PKUF_ADMNUR";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_admnur";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public AdmNurDODesc(){
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
		this.setKeyDesc(getId_admnurADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_admnurADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getName_dep_phyADesc(tblDesc));
		this.add(getName_dep_nurADesc(tblDesc));
		this.add(getId_patADesc(tblDesc));
		this.add(getName_bedADesc(tblDesc));
		this.add(getId_signADesc(tblDesc));
		this.add(getDt_createADesc(tblDesc));
		this.add(getId_nurADesc(tblDesc));
		this.add(getId_entADesc(tblDesc));
		this.add(getName_patADesc(tblDesc));
		this.add(getName_sexADesc(tblDesc));
		this.add(getAgeADesc(tblDesc));
		this.add(getCode_amr_ipADesc(tblDesc));
		this.add(getDt_entryADesc(tblDesc));
		this.add(getDiagnosisADesc(tblDesc));
		this.add(getVocationADesc(tblDesc));
		this.add(getNationADesc(tblDesc));
		this.add(getName_educADesc(tblDesc));
		this.add(getTelADesc(tblDesc));
		this.add(getFam_telADesc(tblDesc));
		this.add(getId_mar_statADesc(tblDesc));
		this.add(getSd_mar_statADesc(tblDesc));
		this.add(getMar_stat_otherADesc(tblDesc));
		this.add(getId_cur_childADesc(tblDesc));
		this.add(getSd_cur_childADesc(tblDesc));
		this.add(getSon_numADesc(tblDesc));
		this.add(getDaughter_numADesc(tblDesc));
		this.add(getId_faithADesc(tblDesc));
		this.add(getSd_faithADesc(tblDesc));
		this.add(getFaith_statADesc(tblDesc));
		this.add(getId_allerhisADesc(tblDesc));
		this.add(getSd_allerhisADesc(tblDesc));
		this.add(getFood_allerhisADesc(tblDesc));
		this.add(getMed_allerhisADesc(tblDesc));
		this.add(getOth_allerhisADesc(tblDesc));
		this.add(getId_entry_wayADesc(tblDesc));
		this.add(getSd_entry_wayADesc(tblDesc));
		this.add(getWeightADesc(tblDesc));
		this.add(getHeightADesc(tblDesc));
		this.add(getNurtADesc(tblDesc));
		this.add(getNurpADesc(tblDesc));
		this.add(getNurrADesc(tblDesc));
		this.add(getNurbpADesc(tblDesc));
		this.add(getInt_sbpADesc(tblDesc));
		this.add(getInt_dbpADesc(tblDesc));
		this.add(getId_awarenessADesc(tblDesc));
		this.add(getSd_awarenessADesc(tblDesc));
		this.add(getId_breathADesc(tblDesc));
		this.add(getSd_breathADesc(tblDesc));
		this.add(getId_biteADesc(tblDesc));
		this.add(getSd_biteADesc(tblDesc));
		this.add(getSpe_biteADesc(tblDesc));
		this.add(getDietADesc(tblDesc));
		this.add(getOutside_biteADesc(tblDesc));
		this.add(getId_nutri_statADesc(tblDesc));
		this.add(getSd_nutri_statADesc(tblDesc));
		this.add(getHabittimeADesc(tblDesc));
		this.add(getId_siestaADesc(tblDesc));
		this.add(getSd_siestaADesc(tblDesc));
		this.add(getSiestatimeADesc(tblDesc));
		this.add(getId_auxiliaryADesc(tblDesc));
		this.add(getSd_auxiliaryADesc(tblDesc));
		this.add(getMed_auxiADesc(tblDesc));
		this.add(getId_cacationADesc(tblDesc));
		this.add(getSd_cacationADesc(tblDesc));
		this.add(getId_emictionADesc(tblDesc));
		this.add(getSd_emictionADesc(tblDesc));
		this.add(getId_drainageADesc(tblDesc));
		this.add(getSd_drainageADesc(tblDesc));
		this.add(getDrainage_typeADesc(tblDesc));
		this.add(getDrain_shapeADesc(tblDesc));
		this.add(getDrainage_outADesc(tblDesc));
		this.add(getId_positionADesc(tblDesc));
		this.add(getSd_positionADesc(tblDesc));
		this.add(getId_emotionADesc(tblDesc));
		this.add(getSd_emotionADesc(tblDesc));
		this.add(getId_skinADesc(tblDesc));
		this.add(getSd_skinADesc(tblDesc));
		this.add(getSkin_unusualADesc(tblDesc));
		this.add(getId_riskADesc(tblDesc));
		this.add(getSd_riskADesc(tblDesc));
		this.add(getScore_riskADesc(tblDesc));
		this.add(getId_selt_careADesc(tblDesc));
		this.add(getSd_selt_careADesc(tblDesc));
		this.add(getId_painADesc(tblDesc));
		this.add(getSd_painADesc(tblDesc));
		this.add(getScore_painADesc(tblDesc));
		this.add(getId_dis_underADesc(tblDesc));
		this.add(getSd_dis_underADesc(tblDesc));
		this.add(getId_dis_famiunderADesc(tblDesc));
		this.add(getSd_dis_famiunderADesc(tblDesc));
		this.add(getId_infusionADesc(tblDesc));
		this.add(getSd_infusionADesc(tblDesc));
		this.add(getId_superficialADesc(tblDesc));
		this.add(getSd_superficialADesc(tblDesc));
		this.add(getSuperficial_sitADesc(tblDesc));
		this.add(getId_deepADesc(tblDesc));
		this.add(getSd_deepADesc(tblDesc));
		this.add(getDeep_situADesc(tblDesc));
		this.add(getEvaluateADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getName_signADesc(tblDesc));
		this.add(getName_nurADesc(tblDesc));
		this.add(getName_mar_statADesc(tblDesc));
		this.add(getName_cur_childADesc(tblDesc));
		this.add(getName_faithADesc(tblDesc));
		this.add(getName_allerhisADesc(tblDesc));
		this.add(getName_entry_wayADesc(tblDesc));
		this.add(getName_awarenessADesc(tblDesc));
		this.add(getName_breathADesc(tblDesc));
		this.add(getName_biteADesc(tblDesc));
		this.add(getName_nutri_statADesc(tblDesc));
		this.add(getName_siestaADesc(tblDesc));
		this.add(getName_auxiliaryADesc(tblDesc));
		this.add(getName_cacationADesc(tblDesc));
		this.add(getName_emictionADesc(tblDesc));
		this.add(getName_drainageADesc(tblDesc));
		this.add(getName_positionADesc(tblDesc));
		this.add(getName_emotionADesc(tblDesc));
		this.add(getName_skinADesc(tblDesc));
		this.add(getName_riskADesc(tblDesc));
		this.add(getName_selt_careADesc(tblDesc));
		this.add(getName_painADesc(tblDesc));
		this.add(getName_dis_underADesc(tblDesc));
		this.add(getName_dis_famiunderADesc(tblDesc));
		this.add(getName_infusionADesc(tblDesc));
		this.add(getName_superficialADesc(tblDesc));
		this.add(getName_deepADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_admnurCDesc(tblDesc));
		tblDesc.add(getId_admnurCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getName_dep_phyCDesc(tblDesc));
		tblDesc.add(getName_dep_nurCDesc(tblDesc));
		tblDesc.add(getId_patCDesc(tblDesc));
		tblDesc.add(getName_bedCDesc(tblDesc));
		tblDesc.add(getId_signCDesc(tblDesc));
		tblDesc.add(getDt_createCDesc(tblDesc));
		tblDesc.add(getId_nurCDesc(tblDesc));
		tblDesc.add(getId_entCDesc(tblDesc));
		tblDesc.add(getName_patCDesc(tblDesc));
		tblDesc.add(getName_sexCDesc(tblDesc));
		tblDesc.add(getAgeCDesc(tblDesc));
		tblDesc.add(getCode_amr_ipCDesc(tblDesc));
		tblDesc.add(getDt_entryCDesc(tblDesc));
		tblDesc.add(getDiagnosisCDesc(tblDesc));
		tblDesc.add(getVocationCDesc(tblDesc));
		tblDesc.add(getNationCDesc(tblDesc));
		tblDesc.add(getName_educCDesc(tblDesc));
		tblDesc.add(getTelCDesc(tblDesc));
		tblDesc.add(getFam_telCDesc(tblDesc));
		tblDesc.add(getId_mar_statCDesc(tblDesc));
		tblDesc.add(getSd_mar_statCDesc(tblDesc));
		tblDesc.add(getMar_stat_otherCDesc(tblDesc));
		tblDesc.add(getId_cur_childCDesc(tblDesc));
		tblDesc.add(getSd_cur_childCDesc(tblDesc));
		tblDesc.add(getSon_numCDesc(tblDesc));
		tblDesc.add(getDaughter_numCDesc(tblDesc));
		tblDesc.add(getId_faithCDesc(tblDesc));
		tblDesc.add(getSd_faithCDesc(tblDesc));
		tblDesc.add(getFaith_statCDesc(tblDesc));
		tblDesc.add(getId_allerhisCDesc(tblDesc));
		tblDesc.add(getSd_allerhisCDesc(tblDesc));
		tblDesc.add(getFood_allerhisCDesc(tblDesc));
		tblDesc.add(getMed_allerhisCDesc(tblDesc));
		tblDesc.add(getOth_allerhisCDesc(tblDesc));
		tblDesc.add(getId_entry_wayCDesc(tblDesc));
		tblDesc.add(getSd_entry_wayCDesc(tblDesc));
		tblDesc.add(getWeightCDesc(tblDesc));
		tblDesc.add(getHeightCDesc(tblDesc));
		tblDesc.add(getNurtCDesc(tblDesc));
		tblDesc.add(getNurpCDesc(tblDesc));
		tblDesc.add(getNurrCDesc(tblDesc));
		tblDesc.add(getNurbpCDesc(tblDesc));
		tblDesc.add(getInt_sbpCDesc(tblDesc));
		tblDesc.add(getInt_dbpCDesc(tblDesc));
		tblDesc.add(getId_awarenessCDesc(tblDesc));
		tblDesc.add(getSd_awarenessCDesc(tblDesc));
		tblDesc.add(getId_breathCDesc(tblDesc));
		tblDesc.add(getSd_breathCDesc(tblDesc));
		tblDesc.add(getId_biteCDesc(tblDesc));
		tblDesc.add(getSd_biteCDesc(tblDesc));
		tblDesc.add(getSpe_biteCDesc(tblDesc));
		tblDesc.add(getDietCDesc(tblDesc));
		tblDesc.add(getOutside_biteCDesc(tblDesc));
		tblDesc.add(getId_nutri_statCDesc(tblDesc));
		tblDesc.add(getSd_nutri_statCDesc(tblDesc));
		tblDesc.add(getHabittimeCDesc(tblDesc));
		tblDesc.add(getId_siestaCDesc(tblDesc));
		tblDesc.add(getSd_siestaCDesc(tblDesc));
		tblDesc.add(getSiestatimeCDesc(tblDesc));
		tblDesc.add(getId_auxiliaryCDesc(tblDesc));
		tblDesc.add(getSd_auxiliaryCDesc(tblDesc));
		tblDesc.add(getMed_auxiCDesc(tblDesc));
		tblDesc.add(getId_cacationCDesc(tblDesc));
		tblDesc.add(getSd_cacationCDesc(tblDesc));
		tblDesc.add(getId_emictionCDesc(tblDesc));
		tblDesc.add(getSd_emictionCDesc(tblDesc));
		tblDesc.add(getId_drainageCDesc(tblDesc));
		tblDesc.add(getSd_drainageCDesc(tblDesc));
		tblDesc.add(getDrainage_typeCDesc(tblDesc));
		tblDesc.add(getDrain_shapeCDesc(tblDesc));
		tblDesc.add(getDrainage_outCDesc(tblDesc));
		tblDesc.add(getId_positionCDesc(tblDesc));
		tblDesc.add(getSd_positionCDesc(tblDesc));
		tblDesc.add(getId_emotionCDesc(tblDesc));
		tblDesc.add(getSd_emotionCDesc(tblDesc));
		tblDesc.add(getId_skinCDesc(tblDesc));
		tblDesc.add(getSd_skinCDesc(tblDesc));
		tblDesc.add(getSkin_unusualCDesc(tblDesc));
		tblDesc.add(getId_riskCDesc(tblDesc));
		tblDesc.add(getSd_riskCDesc(tblDesc));
		tblDesc.add(getScore_riskCDesc(tblDesc));
		tblDesc.add(getId_selt_careCDesc(tblDesc));
		tblDesc.add(getSd_selt_careCDesc(tblDesc));
		tblDesc.add(getId_painCDesc(tblDesc));
		tblDesc.add(getSd_painCDesc(tblDesc));
		tblDesc.add(getScore_painCDesc(tblDesc));
		tblDesc.add(getId_dis_underCDesc(tblDesc));
		tblDesc.add(getSd_dis_underCDesc(tblDesc));
		tblDesc.add(getId_dis_famiunderCDesc(tblDesc));
		tblDesc.add(getSd_dis_famiunderCDesc(tblDesc));
		tblDesc.add(getId_infusionCDesc(tblDesc));
		tblDesc.add(getSd_infusionCDesc(tblDesc));
		tblDesc.add(getId_superficialCDesc(tblDesc));
		tblDesc.add(getSd_superficialCDesc(tblDesc));
		tblDesc.add(getSuperficial_sitCDesc(tblDesc));
		tblDesc.add(getId_deepCDesc(tblDesc));
		tblDesc.add(getSd_deepCDesc(tblDesc));
		tblDesc.add(getDeep_situCDesc(tblDesc));
		tblDesc.add(getEvaluateCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 文书主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_admnurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_admnur",  getId_admnurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("文书主键");
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
	 * 录入人员属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_signADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_sign",  getId_signCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("录入人员");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 录入日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_createADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_create",  getDt_createCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("录入日期");
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
	 * 入院时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_entryADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_entry",  getDt_entryCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("入院时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊断属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDiagnosisADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Diagnosis",  getDiagnosisCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 职业属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getVocationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Vocation",  getVocationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("职业");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 民族属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Nation",  getNationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("民族");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 文化程度属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_educADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_educ",  getName_educCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("文化程度");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 联系电话属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTelADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Tel",  getTelCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("联系电话");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 家属联系电话属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFam_telADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fam_tel",  getFam_telCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("家属联系电话");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 婚姻状况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mar_statADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mar_stat",  getId_mar_statCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("婚姻状况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 婚姻状况编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_mar_statADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_mar_stat",  getSd_mar_statCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("婚姻状况编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 婚姻状况其它属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMar_stat_otherADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mar_stat_other",  getMar_stat_otherCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("婚姻状况其它");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 子女属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_cur_childADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_cur_child",  getId_cur_childCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("子女");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 子女编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_cur_childADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_cur_child",  getSd_cur_childCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("子女编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 儿子数量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSon_numADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Son_num",  getSon_numCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("儿子数量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 女儿数量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDaughter_numADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Daughter_num",  getDaughter_numCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("女儿数量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 宗教信仰属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_faithADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_faith",  getId_faithCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("宗教信仰");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 宗教信仰编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_faithADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_faith",  getSd_faithCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("宗教信仰编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 宗教信仰情况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFaith_statADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Faith_stat",  getFaith_statCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("宗教信仰情况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 过敏史属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_allerhisADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_allerhis",  getId_allerhisCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("过敏史");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 过敏史编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_allerhisADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_allerhis",  getSd_allerhisCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("过敏史编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 过敏食物属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFood_allerhisADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Food_allerhis",  getFood_allerhisCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("过敏食物");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 过敏药物属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMed_allerhisADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Med_allerhis",  getMed_allerhisCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("过敏药物");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 其它过敏属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOth_allerhisADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Oth_allerhis",  getOth_allerhisCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("其它过敏");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 入院方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_entry_wayADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_entry_way",  getId_entry_wayCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入院方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 入院方式编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_entry_wayADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_entry_way",  getSd_entry_wayCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入院方式编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体重属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWeightADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Weight",  getWeightCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("体重");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 身高属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHeightADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Height",  getHeightCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("身高");
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
	private IAttrDesc getNurtADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Nurt",  getNurtCDesc(tblDesc), this);
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
	private IAttrDesc getNurpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Nurp",  getNurpCDesc(tblDesc), this);
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
	 * R属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNurrADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Nurr",  getNurrCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("R");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * BP属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNurbpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Nurbp",  getNurbpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("BP");
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
	 * 意识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_awarenessADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_awareness",  getId_awarenessCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("意识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 意识编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_awarenessADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_awareness",  getSd_awarenessCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("意识编码");
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
	private IAttrDesc getId_breathADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_breath",  getId_breathCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("呼吸");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 呼吸编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_breathADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_breath",  getSd_breathCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("呼吸编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 饮食属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_biteADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_bite",  getId_biteCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("饮食");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 饮食编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_biteADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_bite",  getSd_biteCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("饮食编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 特殊饮食属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSpe_biteADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Spe_bite",  getSpe_biteCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("特殊饮食");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 忌食属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDietADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Diet",  getDietCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("忌食");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 外带胃管属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOutside_biteADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Outside_bite",  getOutside_biteCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("外带胃管");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 营养状态属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_nutri_statADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_nutri_stat",  getId_nutri_statCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("营养状态");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 营养状态编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_nutri_statADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_nutri_stat",  getSd_nutri_statCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("营养状态编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 习惯睡眠时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHabittimeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Habittime",  getHabittimeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("习惯睡眠时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 午睡属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_siestaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_siesta",  getId_siestaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("午睡");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 午睡编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_siestaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_siesta",  getSd_siestaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("午睡编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 午睡时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSiestatimeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Siestatime",  getSiestatimeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("午睡时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 辅助睡眠属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_auxiliaryADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_auxiliary",  getId_auxiliaryCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("辅助睡眠");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 辅助睡眠编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_auxiliaryADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_auxiliary",  getSd_auxiliaryCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("辅助睡眠编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 辅助睡眠药物属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMed_auxiADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Med_auxi",  getMed_auxiCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("辅助睡眠药物");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 排便属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_cacationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_cacation",  getId_cacationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("排便");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 排便编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_cacationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_cacation",  getSd_cacationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("排便编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 排尿属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emictionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emiction",  getId_emictionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("排尿");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 排尿编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_emictionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_emiction",  getSd_emictionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("排尿编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 引流属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_drainageADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_drainage",  getId_drainageCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("引流");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 引流编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_drainageADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_drainage",  getSd_drainageCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("引流编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 引流类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDrainage_typeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Drainage_type",  getDrainage_typeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("引流类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 引流液性状属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDrain_shapeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Drain_shape",  getDrain_shapeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("引流液性状");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 引流量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDrainage_outADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Drainage_out",  getDrainage_outCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("引流量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 卧位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_positionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_position",  getId_positionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("卧位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 卧位编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_positionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_position",  getSd_positionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("卧位编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 情绪属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emotionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emotion",  getId_emotionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("情绪");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 情绪编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_emotionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_emotion",  getSd_emotionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("情绪编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 皮肤状况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_skinADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_skin",  getId_skinCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("皮肤状况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 皮肤状况编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_skinADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_skin",  getSd_skinCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("皮肤状况编码");
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
	private IAttrDesc getSkin_unusualADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Skin_unusual",  getSkin_unusualCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("皮肤异常情况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 跌倒/坠床风险属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_riskADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_risk",  getId_riskCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("跌倒/坠床风险");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 跌倒/坠床风险编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_riskADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_risk",  getSd_riskCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("跌倒/坠床风险编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 跌倒/坠床得分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getScore_riskADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Score_risk",  getScore_riskCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("跌倒/坠床得分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 生活自理能力属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_selt_careADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_selt_care",  getId_selt_careCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("生活自理能力");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 生活自理能力编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_selt_careADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_selt_care",  getSd_selt_careCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("生活自理能力编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 疼痛属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_painADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pain",  getId_painCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("疼痛");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 疼痛编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_painADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_pain",  getSd_painCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("疼痛编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 疼痛评分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getScore_painADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Score_pain",  getScore_painCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("疼痛评分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 对疾病的认识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dis_underADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dis_under",  getId_dis_underCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("对疾病的认识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 对疾病的认识编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_dis_underADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_dis_under",  getSd_dis_underCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("对疾病的认识编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 家属对疾病的认识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dis_famiunderADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dis_famiunder",  getId_dis_famiunderCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("家属对疾病的认识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 家属对疾病的认识编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_dis_famiunderADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_dis_famiunder",  getSd_dis_famiunderCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("家属对疾病的认识编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 静脉输液属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_infusionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_infusion",  getId_infusionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("静脉输液");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 静脉输液编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_infusionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_infusion",  getSd_infusionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("静脉输液编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 浅静脉置管属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_superficialADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_superficial",  getId_superficialCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("浅静脉置管");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 浅静脉置管编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_superficialADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_superficial",  getSd_superficialCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("浅静脉置管编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 浅静脉置管情况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSuperficial_sitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Superficial_sit",  getSuperficial_sitCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("浅静脉置管情况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 深静脉置管属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_deepADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_deep",  getId_deepCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("深静脉置管");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 深静脉置管编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_deepADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_deep",  getSd_deepCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("深静脉置管编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 深静脉置管情况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDeep_situADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Deep_situ",  getDeep_situCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("深静脉置管情况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 专科情况评估属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEvaluateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Evaluate",  getEvaluateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("专科情况评估");
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
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_signADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_sign",  getName_signCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b4","id_sign=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_nurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_nur",  getName_nurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b5","id_nur=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_mar_statADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_mar_stat",  getName_mar_statCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b6","id_mar_stat=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_cur_childADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_cur_child",  getName_cur_childCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b7","id_cur_child=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_faithADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_faith",  getName_faithCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b8","id_faith=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_allerhisADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_allerhis",  getName_allerhisCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b9","id_allerhis=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_entry_wayADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_entry_way",  getName_entry_wayCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b10","id_entry_way=id_udidoc","name"});
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
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b11","id_awareness=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_breathADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_breath",  getName_breathCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b12","id_breath=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_biteADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_bite",  getName_biteCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b13","id_bite=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_nutri_statADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_nutri_stat",  getName_nutri_statCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b14","id_nutri_stat=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_siestaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_siesta",  getName_siestaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b15","id_siesta=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_auxiliaryADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_auxiliary",  getName_auxiliaryCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b16","id_auxiliary=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_cacationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_cacation",  getName_cacationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b17","id_cacation=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_emictionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_emiction",  getName_emictionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b18","id_emiction=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_drainageADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_drainage",  getName_drainageCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b19","id_drainage=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_positionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_position",  getName_positionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b20","id_position=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_emotionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_emotion",  getName_emotionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b21","id_emotion=id_udidoc","name"});
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
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b22","id_skin=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_riskADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_risk",  getName_riskCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b23","id_risk=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_selt_careADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_selt_care",  getName_selt_careCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b24","id_selt_care=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_painADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_pain",  getName_painCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b25","id_pain=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dis_underADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dis_under",  getName_dis_underCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b26","id_dis_under=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dis_famiunderADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dis_famiunder",  getName_dis_famiunderCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b27","id_dis_famiunder=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_infusionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_infusion",  getName_infusionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b28","id_infusion=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_superficialADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_superficial",  getName_superficialCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b29","id_superficial=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_deepADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_deep",  getName_deepCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b30","id_deep=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取文书主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_admnurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_admnur");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("文书主键"); 
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
	 * 获取录入人员表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_signCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_sign");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("录入人员"); 
		return column;
	}
	/**
	 * 获取录入日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_createCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_create");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("录入日期"); 
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
	 * 获取入院时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_entryCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_entry");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("入院时间"); 
		return column;
	}
	/**
	 * 获取诊断表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDiagnosisCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Diagnosis");
		column.setLength(1500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断"); 
		return column;
	}
	/**
	 * 获取职业表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getVocationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Vocation");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("职业"); 
		return column;
	}
	/**
	 * 获取民族表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Nation");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("民族"); 
		return column;
	}
	/**
	 * 获取文化程度表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_educCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_educ");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("文化程度"); 
		return column;
	}
	/**
	 * 获取联系电话表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTelCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Tel");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("联系电话"); 
		return column;
	}
	/**
	 * 获取家属联系电话表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFam_telCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fam_tel");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("家属联系电话"); 
		return column;
	}
	/**
	 * 获取婚姻状况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mar_statCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mar_stat");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("婚姻状况"); 
		return column;
	}
	/**
	 * 获取婚姻状况编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_mar_statCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_mar_stat");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("婚姻状况编码"); 
		return column;
	}
	/**
	 * 获取婚姻状况其它表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMar_stat_otherCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mar_stat_other");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("婚姻状况其它"); 
		return column;
	}
	/**
	 * 获取子女表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_cur_childCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_cur_child");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("子女"); 
		return column;
	}
	/**
	 * 获取子女编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_cur_childCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_cur_child");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("子女编码"); 
		return column;
	}
	/**
	 * 获取儿子数量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSon_numCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Son_num");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("儿子数量"); 
		return column;
	}
	/**
	 * 获取女儿数量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDaughter_numCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Daughter_num");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("女儿数量"); 
		return column;
	}
	/**
	 * 获取宗教信仰表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_faithCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_faith");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("宗教信仰"); 
		return column;
	}
	/**
	 * 获取宗教信仰编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_faithCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_faith");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("宗教信仰编码"); 
		return column;
	}
	/**
	 * 获取宗教信仰情况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFaith_statCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Faith_stat");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("宗教信仰情况"); 
		return column;
	}
	/**
	 * 获取过敏史表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_allerhisCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_allerhis");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("过敏史"); 
		return column;
	}
	/**
	 * 获取过敏史编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_allerhisCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_allerhis");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("过敏史编码"); 
		return column;
	}
	/**
	 * 获取过敏食物表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFood_allerhisCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Food_allerhis");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("过敏食物"); 
		return column;
	}
	/**
	 * 获取过敏药物表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMed_allerhisCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Med_allerhis");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("过敏药物"); 
		return column;
	}
	/**
	 * 获取其它过敏表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOth_allerhisCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Oth_allerhis");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("其它过敏"); 
		return column;
	}
	/**
	 * 获取入院方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_entry_wayCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_entry_way");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入院方式"); 
		return column;
	}
	/**
	 * 获取入院方式编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_entry_wayCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_entry_way");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入院方式编码"); 
		return column;
	}
	/**
	 * 获取体重表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWeightCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Weight");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("体重"); 
		return column;
	}
	/**
	 * 获取身高表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHeightCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Height");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("身高"); 
		return column;
	}
	/**
	 * 获取T表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNurtCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Nurt");
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
	private IColumnDesc getNurpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Nurp");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("P"); 
		return column;
	}
	/**
	 * 获取R表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNurrCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Nurr");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("R"); 
		return column;
	}
	/**
	 * 获取BP表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNurbpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Nurbp");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("BP"); 
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
	 * 获取意识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_awarenessCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_awareness");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("意识"); 
		return column;
	}
	/**
	 * 获取意识编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_awarenessCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_awareness");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("意识编码"); 
		return column;
	}
	/**
	 * 获取呼吸表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_breathCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_breath");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("呼吸"); 
		return column;
	}
	/**
	 * 获取呼吸编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_breathCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_breath");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("呼吸编码"); 
		return column;
	}
	/**
	 * 获取饮食表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_biteCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_bite");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("饮食"); 
		return column;
	}
	/**
	 * 获取饮食编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_biteCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_bite");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("饮食编码"); 
		return column;
	}
	/**
	 * 获取特殊饮食表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSpe_biteCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Spe_bite");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("特殊饮食"); 
		return column;
	}
	/**
	 * 获取忌食表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDietCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Diet");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("忌食"); 
		return column;
	}
	/**
	 * 获取外带胃管表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOutside_biteCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Outside_bite");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("外带胃管"); 
		return column;
	}
	/**
	 * 获取营养状态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_nutri_statCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_nutri_stat");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("营养状态"); 
		return column;
	}
	/**
	 * 获取营养状态编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_nutri_statCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_nutri_stat");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("营养状态编码"); 
		return column;
	}
	/**
	 * 获取习惯睡眠时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHabittimeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Habittime");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("习惯睡眠时间"); 
		return column;
	}
	/**
	 * 获取午睡表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_siestaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_siesta");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("午睡"); 
		return column;
	}
	/**
	 * 获取午睡编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_siestaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_siesta");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("午睡编码"); 
		return column;
	}
	/**
	 * 获取午睡时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSiestatimeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Siestatime");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("午睡时间"); 
		return column;
	}
	/**
	 * 获取辅助睡眠表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_auxiliaryCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_auxiliary");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("辅助睡眠"); 
		return column;
	}
	/**
	 * 获取辅助睡眠编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_auxiliaryCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_auxiliary");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("辅助睡眠编码"); 
		return column;
	}
	/**
	 * 获取辅助睡眠药物表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMed_auxiCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Med_auxi");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("辅助睡眠药物"); 
		return column;
	}
	/**
	 * 获取排便表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_cacationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_cacation");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("排便"); 
		return column;
	}
	/**
	 * 获取排便编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_cacationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_cacation");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("排便编码"); 
		return column;
	}
	/**
	 * 获取排尿表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emictionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emiction");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("排尿"); 
		return column;
	}
	/**
	 * 获取排尿编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_emictionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_emiction");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("排尿编码"); 
		return column;
	}
	/**
	 * 获取引流表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_drainageCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_drainage");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("引流"); 
		return column;
	}
	/**
	 * 获取引流编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_drainageCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_drainage");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("引流编码"); 
		return column;
	}
	/**
	 * 获取引流类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDrainage_typeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Drainage_type");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("引流类型"); 
		return column;
	}
	/**
	 * 获取引流液性状表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDrain_shapeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Drain_shape");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("引流液性状"); 
		return column;
	}
	/**
	 * 获取引流量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDrainage_outCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Drainage_out");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("引流量"); 
		return column;
	}
	/**
	 * 获取卧位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_positionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_position");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("卧位"); 
		return column;
	}
	/**
	 * 获取卧位编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_positionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_position");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("卧位编码"); 
		return column;
	}
	/**
	 * 获取情绪表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emotionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emotion");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("情绪"); 
		return column;
	}
	/**
	 * 获取情绪编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_emotionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_emotion");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("情绪编码"); 
		return column;
	}
	/**
	 * 获取皮肤状况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_skinCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_skin");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("皮肤状况"); 
		return column;
	}
	/**
	 * 获取皮肤状况编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_skinCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_skin");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("皮肤状况编码"); 
		return column;
	}
	/**
	 * 获取皮肤异常情况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSkin_unusualCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Skin_unusual");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("皮肤异常情况"); 
		return column;
	}
	/**
	 * 获取跌倒/坠床风险表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_riskCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_risk");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("跌倒/坠床风险"); 
		return column;
	}
	/**
	 * 获取跌倒/坠床风险编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_riskCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_risk");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("跌倒/坠床风险编码"); 
		return column;
	}
	/**
	 * 获取跌倒/坠床得分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getScore_riskCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Score_risk");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("跌倒/坠床得分"); 
		return column;
	}
	/**
	 * 获取生活自理能力表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_selt_careCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_selt_care");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("生活自理能力"); 
		return column;
	}
	/**
	 * 获取生活自理能力编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_selt_careCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_selt_care");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("生活自理能力编码"); 
		return column;
	}
	/**
	 * 获取疼痛表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_painCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pain");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("疼痛"); 
		return column;
	}
	/**
	 * 获取疼痛编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_painCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_pain");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("疼痛编码"); 
		return column;
	}
	/**
	 * 获取疼痛评分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getScore_painCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Score_pain");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("疼痛评分"); 
		return column;
	}
	/**
	 * 获取对疾病的认识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dis_underCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dis_under");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("对疾病的认识"); 
		return column;
	}
	/**
	 * 获取对疾病的认识编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_dis_underCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_dis_under");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("对疾病的认识编码"); 
		return column;
	}
	/**
	 * 获取家属对疾病的认识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dis_famiunderCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dis_famiunder");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("家属对疾病的认识"); 
		return column;
	}
	/**
	 * 获取家属对疾病的认识编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_dis_famiunderCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_dis_famiunder");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("家属对疾病的认识编码"); 
		return column;
	}
	/**
	 * 获取静脉输液表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_infusionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_infusion");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("静脉输液"); 
		return column;
	}
	/**
	 * 获取静脉输液编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_infusionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_infusion");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("静脉输液编码"); 
		return column;
	}
	/**
	 * 获取浅静脉置管表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_superficialCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_superficial");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("浅静脉置管"); 
		return column;
	}
	/**
	 * 获取浅静脉置管编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_superficialCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_superficial");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("浅静脉置管编码"); 
		return column;
	}
	/**
	 * 获取浅静脉置管情况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSuperficial_sitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Superficial_sit");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("浅静脉置管情况"); 
		return column;
	}
	/**
	 * 获取深静脉置管表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_deepCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_deep");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("深静脉置管"); 
		return column;
	}
	/**
	 * 获取深静脉置管编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_deepCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_deep");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("深静脉置管编码"); 
		return column;
	}
	/**
	 * 获取深静脉置管情况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDeep_situCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Deep_situ");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("深静脉置管情况"); 
		return column;
	}
	/**
	 * 获取专科情况评估表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEvaluateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Evaluate");
		column.setLength(1000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("专科情况评估"); 
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
	 * 获取姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_signCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_sign");
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
	private IColumnDesc getName_nurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_nur");
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
	private IColumnDesc getName_mar_statCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_mar_stat");
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
	private IColumnDesc getName_cur_childCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_cur_child");
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
	private IColumnDesc getName_faithCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_faith");
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
	private IColumnDesc getName_allerhisCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_allerhis");
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
	private IColumnDesc getName_entry_wayCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_entry_way");
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
	private IColumnDesc getName_breathCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_breath");
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
	private IColumnDesc getName_biteCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_bite");
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
	private IColumnDesc getName_nutri_statCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_nutri_stat");
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
	private IColumnDesc getName_siestaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_siesta");
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
	private IColumnDesc getName_auxiliaryCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_auxiliary");
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
	private IColumnDesc getName_cacationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_cacation");
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
	private IColumnDesc getName_emictionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_emiction");
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
	private IColumnDesc getName_drainageCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_drainage");
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
	private IColumnDesc getName_positionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_position");
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
	private IColumnDesc getName_emotionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_emotion");
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
	private IColumnDesc getName_riskCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_risk");
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
	private IColumnDesc getName_selt_careCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_selt_care");
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
	private IColumnDesc getName_painCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_pain");
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
	private IColumnDesc getName_dis_underCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dis_under");
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
	private IColumnDesc getName_dis_famiunderCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dis_famiunder");
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
	private IColumnDesc getName_infusionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_infusion");
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
	private IColumnDesc getName_superficialCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_superficial");
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
	private IColumnDesc getName_deepCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_deep");
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
