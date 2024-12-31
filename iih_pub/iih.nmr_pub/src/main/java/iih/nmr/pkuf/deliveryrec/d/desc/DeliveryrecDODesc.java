
package iih.nmr.pkuf.deliveryrec.d.desc;

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
 * 分娩记录单 DO 元数据信息
 */
public class DeliveryrecDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.nmr.pkuf.deliveryrec.d.DeliveryrecDO";
	public static final String CLASS_DISPALYNAME = "分娩记录单";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "NMR_PKUF_DELIVER";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_deliveryrec";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public DeliveryrecDODesc(){
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
		this.setKeyDesc(getId_deliveryrecADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_deliveryrecADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_patADesc(tblDesc));
		this.add(getId_entADesc(tblDesc));
		this.add(getName_dep_phyADesc(tblDesc));
		this.add(getName_dep_nurADesc(tblDesc));
		this.add(getName_bedADesc(tblDesc));
		this.add(getName_patADesc(tblDesc));
		this.add(getName_sexADesc(tblDesc));
		this.add(getAgeADesc(tblDesc));
		this.add(getCode_amr_ipADesc(tblDesc));
		this.add(getId_signADesc(tblDesc));
		this.add(getDt_createADesc(tblDesc));
		this.add(getDt_uc_bADesc(tblDesc));
		this.add(getDt_orifice_uterusADesc(tblDesc));
		this.add(getDt_membranesADesc(tblDesc));
		this.add(getId_r_membranesADesc(tblDesc));
		this.add(getSd_r_membranesADesc(tblDesc));
		this.add(getName_membranADesc(tblDesc));
		this.add(getDt_out_infantADesc(tblDesc));
		this.add(getId_way_infantADesc(tblDesc));
		this.add(getSd_way_infantADesc(tblDesc));
		this.add(getName_way_infantADesc(tblDesc));
		this.add(getDt_placentaADesc(tblDesc));
		this.add(getId_way_placentaADesc(tblDesc));
		this.add(getSd_way_placentaADesc(tblDesc));
		this.add(getName_way_placenADesc(tblDesc));
		this.add(getId_condi_amnioticADesc(tblDesc));
		this.add(getSd_condi_amnioticADesc(tblDesc));
		this.add(getName_condi_amnicADesc(tblDesc));
		this.add(getId_positationADesc(tblDesc));
		this.add(getSd_positationADesc(tblDesc));
		this.add(getName_positationADesc(tblDesc));
		this.add(getLen_placentaADesc(tblDesc));
		this.add(getWidth_placentaADesc(tblDesc));
		this.add(getHeight_placentaADesc(tblDesc));
		this.add(getId_check_placentaADesc(tblDesc));
		this.add(getSd_check_placentaADesc(tblDesc));
		this.add(getName_check_placeADesc(tblDesc));
		this.add(getWeight_placentaADesc(tblDesc));
		this.add(getShap_placentaADesc(tblDesc));
		this.add(getId_adhere_umbiliADesc(tblDesc));
		this.add(getSd_adhere_umbiliADesc(tblDesc));
		this.add(getName_adhere_umADesc(tblDesc));
		this.add(getLen_umbiliADesc(tblDesc));
		this.add(getFirst_labor_hADesc(tblDesc));
		this.add(getFirst_labor_mADesc(tblDesc));
		this.add(getSecond_labor_hADesc(tblDesc));
		this.add(getSecond_labor_mADesc(tblDesc));
		this.add(getThird_labor_hADesc(tblDesc));
		this.add(getThird_labor_mADesc(tblDesc));
		this.add(getFouth_labor_hADesc(tblDesc));
		this.add(getFouth_labor_mADesc(tblDesc));
		this.add(getWhole_laborADesc(tblDesc));
		this.add(getId_perineal_ruptureADesc(tblDesc));
		this.add(getSd_perineal_ruptureADesc(tblDesc));
		this.add(getName_perineal_rupADesc(tblDesc));
		this.add(getId_perineal_sutureADesc(tblDesc));
		this.add(getSd_perineal_sutureADesc(tblDesc));
		this.add(getName_perineal_sutADesc(tblDesc));
		this.add(getPro_drugADesc(tblDesc));
		this.add(getSys_pre_thirtyADesc(tblDesc));
		this.add(getDia_preADesc(tblDesc));
		this.add(getDia_pre_thirtyADesc(tblDesc));
		this.add(getSys_preADesc(tblDesc));
		this.add(getSys_pre_oneADesc(tblDesc));
		this.add(getDia_pre_oneADesc(tblDesc));
		this.add(getSys_pre_twoADesc(tblDesc));
		this.add(getDia_pre_twoADesc(tblDesc));
		this.add(getLose_bloodADesc(tblDesc));
		this.add(getLose_blood_thirtyADesc(tblDesc));
		this.add(getLose_blood_oneADesc(tblDesc));
		this.add(getLose_blood_twoADesc(tblDesc));
		this.add(getId_pro_ucADesc(tblDesc));
		this.add(getSd_pro_ucADesc(tblDesc));
		this.add(getName_pro_ucADesc(tblDesc));
		this.add(getId_delivery_analgesiaADesc(tblDesc));
		this.add(getSd_delivery_analgesiaADesc(tblDesc));
		this.add(getName_delivery_anaADesc(tblDesc));
		this.add(getInfant_maleADesc(tblDesc));
		this.add(getInfant_femaleADesc(tblDesc));
		this.add(getInfant_sexADesc(tblDesc));
		this.add(getInfant_lengthADesc(tblDesc));
		this.add(getInfant_weightADesc(tblDesc));
		this.add(getId_infant_stifleADesc(tblDesc));
		this.add(getSd_infant_stifleADesc(tblDesc));
		this.add(getName_infant_stifleADesc(tblDesc));
		this.add(getInfant_brethADesc(tblDesc));
		this.add(getInfant_breth_fiveADesc(tblDesc));
		this.add(getInfant_heartbeatADesc(tblDesc));
		this.add(getInfant_heartbeat_fiveADesc(tblDesc));
		this.add(getInfant_colorADesc(tblDesc));
		this.add(getInfant_color_fiveADesc(tblDesc));
		this.add(getInfant_stimulateADesc(tblDesc));
		this.add(getInfant_stimulate_fiveADesc(tblDesc));
		this.add(getInfant_tensionADesc(tblDesc));
		this.add(getInfant_tension_fiveADesc(tblDesc));
		this.add(getPuerpera_condiADesc(tblDesc));
		this.add(getDt_puerpera_laveADesc(tblDesc));
		this.add(getOtherADesc(tblDesc));
		this.add(getId_midwifeADesc(tblDesc));
		this.add(getId_supervisorADesc(tblDesc));
		this.add(getCheck_otherADesc(tblDesc));
		this.add(getSuture_otherADesc(tblDesc));
		this.add(getDrug_otherADesc(tblDesc));
		this.add(getUc_otherADesc(tblDesc));
		this.add(getId_operatorADesc(tblDesc));
		this.add(getSd_operatorADesc(tblDesc));
		this.add(getDiagnosisADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getId_infant_specialADesc(tblDesc));
		this.add(getSd_infant_specialADesc(tblDesc));
		this.add(getName_infant_special_condiADesc(tblDesc));
		this.add(getMembran_nameADesc(tblDesc));
		this.add(getWay_infant_nameADesc(tblDesc));
		this.add(getWay_placen_nameADesc(tblDesc));
		this.add(getCondi_amnic_nameADesc(tblDesc));
		this.add(getPositation_nameADesc(tblDesc));
		this.add(getCheck_place_nameADesc(tblDesc));
		this.add(getAdhere_um_nameADesc(tblDesc));
		this.add(getPerineal_rup_nameADesc(tblDesc));
		this.add(getPerineal_sut_nameADesc(tblDesc));
		this.add(getPro_uc_nameADesc(tblDesc));
		this.add(getDelivery_ana_nameADesc(tblDesc));
		this.add(getInfant_stifle_nameADesc(tblDesc));
		this.add(getName_midwifeADesc(tblDesc));
		this.add(getName_supervisor1ADesc(tblDesc));
		this.add(getName_operatorADesc(tblDesc));
		this.add(getName_infant_specialADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_deliveryrecCDesc(tblDesc));
		tblDesc.add(getId_deliveryrecCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_patCDesc(tblDesc));
		tblDesc.add(getId_entCDesc(tblDesc));
		tblDesc.add(getName_dep_phyCDesc(tblDesc));
		tblDesc.add(getName_dep_nurCDesc(tblDesc));
		tblDesc.add(getName_bedCDesc(tblDesc));
		tblDesc.add(getName_patCDesc(tblDesc));
		tblDesc.add(getName_sexCDesc(tblDesc));
		tblDesc.add(getAgeCDesc(tblDesc));
		tblDesc.add(getCode_amr_ipCDesc(tblDesc));
		tblDesc.add(getId_signCDesc(tblDesc));
		tblDesc.add(getDt_createCDesc(tblDesc));
		tblDesc.add(getDt_uc_bCDesc(tblDesc));
		tblDesc.add(getDt_orifice_uterusCDesc(tblDesc));
		tblDesc.add(getDt_membranesCDesc(tblDesc));
		tblDesc.add(getId_r_membranesCDesc(tblDesc));
		tblDesc.add(getSd_r_membranesCDesc(tblDesc));
		tblDesc.add(getName_membranCDesc(tblDesc));
		tblDesc.add(getDt_out_infantCDesc(tblDesc));
		tblDesc.add(getId_way_infantCDesc(tblDesc));
		tblDesc.add(getSd_way_infantCDesc(tblDesc));
		tblDesc.add(getName_way_infantCDesc(tblDesc));
		tblDesc.add(getDt_placentaCDesc(tblDesc));
		tblDesc.add(getId_way_placentaCDesc(tblDesc));
		tblDesc.add(getSd_way_placentaCDesc(tblDesc));
		tblDesc.add(getName_way_placenCDesc(tblDesc));
		tblDesc.add(getId_condi_amnioticCDesc(tblDesc));
		tblDesc.add(getSd_condi_amnioticCDesc(tblDesc));
		tblDesc.add(getName_condi_amnicCDesc(tblDesc));
		tblDesc.add(getId_positationCDesc(tblDesc));
		tblDesc.add(getSd_positationCDesc(tblDesc));
		tblDesc.add(getName_positationCDesc(tblDesc));
		tblDesc.add(getLen_placentaCDesc(tblDesc));
		tblDesc.add(getWidth_placentaCDesc(tblDesc));
		tblDesc.add(getHeight_placentaCDesc(tblDesc));
		tblDesc.add(getId_check_placentaCDesc(tblDesc));
		tblDesc.add(getSd_check_placentaCDesc(tblDesc));
		tblDesc.add(getName_check_placeCDesc(tblDesc));
		tblDesc.add(getWeight_placentaCDesc(tblDesc));
		tblDesc.add(getShap_placentaCDesc(tblDesc));
		tblDesc.add(getId_adhere_umbiliCDesc(tblDesc));
		tblDesc.add(getSd_adhere_umbiliCDesc(tblDesc));
		tblDesc.add(getName_adhere_umCDesc(tblDesc));
		tblDesc.add(getLen_umbiliCDesc(tblDesc));
		tblDesc.add(getFirst_labor_hCDesc(tblDesc));
		tblDesc.add(getFirst_labor_mCDesc(tblDesc));
		tblDesc.add(getSecond_labor_hCDesc(tblDesc));
		tblDesc.add(getSecond_labor_mCDesc(tblDesc));
		tblDesc.add(getThird_labor_hCDesc(tblDesc));
		tblDesc.add(getThird_labor_mCDesc(tblDesc));
		tblDesc.add(getFouth_labor_hCDesc(tblDesc));
		tblDesc.add(getFouth_labor_mCDesc(tblDesc));
		tblDesc.add(getWhole_laborCDesc(tblDesc));
		tblDesc.add(getId_perineal_ruptureCDesc(tblDesc));
		tblDesc.add(getSd_perineal_ruptureCDesc(tblDesc));
		tblDesc.add(getName_perineal_rupCDesc(tblDesc));
		tblDesc.add(getId_perineal_sutureCDesc(tblDesc));
		tblDesc.add(getSd_perineal_sutureCDesc(tblDesc));
		tblDesc.add(getName_perineal_sutCDesc(tblDesc));
		tblDesc.add(getPro_drugCDesc(tblDesc));
		tblDesc.add(getSys_pre_thirtyCDesc(tblDesc));
		tblDesc.add(getDia_preCDesc(tblDesc));
		tblDesc.add(getDia_pre_thirtyCDesc(tblDesc));
		tblDesc.add(getSys_preCDesc(tblDesc));
		tblDesc.add(getSys_pre_oneCDesc(tblDesc));
		tblDesc.add(getDia_pre_oneCDesc(tblDesc));
		tblDesc.add(getSys_pre_twoCDesc(tblDesc));
		tblDesc.add(getDia_pre_twoCDesc(tblDesc));
		tblDesc.add(getLose_bloodCDesc(tblDesc));
		tblDesc.add(getLose_blood_thirtyCDesc(tblDesc));
		tblDesc.add(getLose_blood_oneCDesc(tblDesc));
		tblDesc.add(getLose_blood_twoCDesc(tblDesc));
		tblDesc.add(getId_pro_ucCDesc(tblDesc));
		tblDesc.add(getSd_pro_ucCDesc(tblDesc));
		tblDesc.add(getName_pro_ucCDesc(tblDesc));
		tblDesc.add(getId_delivery_analgesiaCDesc(tblDesc));
		tblDesc.add(getSd_delivery_analgesiaCDesc(tblDesc));
		tblDesc.add(getName_delivery_anaCDesc(tblDesc));
		tblDesc.add(getInfant_maleCDesc(tblDesc));
		tblDesc.add(getInfant_femaleCDesc(tblDesc));
		tblDesc.add(getInfant_sexCDesc(tblDesc));
		tblDesc.add(getInfant_lengthCDesc(tblDesc));
		tblDesc.add(getInfant_weightCDesc(tblDesc));
		tblDesc.add(getId_infant_stifleCDesc(tblDesc));
		tblDesc.add(getSd_infant_stifleCDesc(tblDesc));
		tblDesc.add(getName_infant_stifleCDesc(tblDesc));
		tblDesc.add(getInfant_brethCDesc(tblDesc));
		tblDesc.add(getInfant_breth_fiveCDesc(tblDesc));
		tblDesc.add(getInfant_heartbeatCDesc(tblDesc));
		tblDesc.add(getInfant_heartbeat_fiveCDesc(tblDesc));
		tblDesc.add(getInfant_colorCDesc(tblDesc));
		tblDesc.add(getInfant_color_fiveCDesc(tblDesc));
		tblDesc.add(getInfant_stimulateCDesc(tblDesc));
		tblDesc.add(getInfant_stimulate_fiveCDesc(tblDesc));
		tblDesc.add(getInfant_tensionCDesc(tblDesc));
		tblDesc.add(getInfant_tension_fiveCDesc(tblDesc));
		tblDesc.add(getPuerpera_condiCDesc(tblDesc));
		tblDesc.add(getDt_puerpera_laveCDesc(tblDesc));
		tblDesc.add(getOtherCDesc(tblDesc));
		tblDesc.add(getId_midwifeCDesc(tblDesc));
		tblDesc.add(getId_supervisorCDesc(tblDesc));
		tblDesc.add(getCheck_otherCDesc(tblDesc));
		tblDesc.add(getSuture_otherCDesc(tblDesc));
		tblDesc.add(getDrug_otherCDesc(tblDesc));
		tblDesc.add(getUc_otherCDesc(tblDesc));
		tblDesc.add(getId_operatorCDesc(tblDesc));
		tblDesc.add(getSd_operatorCDesc(tblDesc));
		tblDesc.add(getDiagnosisCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		tblDesc.add(getId_infant_specialCDesc(tblDesc));
		tblDesc.add(getSd_infant_specialCDesc(tblDesc));
		tblDesc.add(getName_infant_special_condiCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 分娩记录单主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_deliveryrecADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_deliveryrec",  getId_deliveryrecCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("分娩记录单主键");
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
	 * 科室属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dep_phyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dep_phy",  getName_dep_phyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("科室");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 病区属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dep_nurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dep_nur",  getName_dep_nurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病区");
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
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_patADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_pat",  getName_patCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
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
	 * 住院号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_amr_ipADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_amr_ip",  getCode_amr_ipCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("住院号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
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
	 * 宫缩起始时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_uc_bADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_uc_b",  getDt_uc_bCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("宫缩起始时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 宫口开全时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_orifice_uterusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_orifice_uterus",  getDt_orifice_uterusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("宫口开全时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 胎膜破裂时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_membranesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_membranes",  getDt_membranesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("胎膜破裂时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 胎膜破裂方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_r_membranesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_r_membranes",  getId_r_membranesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("胎膜破裂方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 胎膜破裂方式编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_r_membranesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_r_membranes",  getSd_r_membranesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("胎膜破裂方式编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 胎膜破裂方式名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_membranADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_membran",  getName_membranCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("胎膜破裂方式名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 婴儿娩出时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_out_infantADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_out_infant",  getDt_out_infantCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("婴儿娩出时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 婴儿娩出方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_way_infantADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_way_infant",  getId_way_infantCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("婴儿娩出方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 婴儿娩出方式编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_way_infantADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_way_infant",  getSd_way_infantCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("婴儿娩出方式编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 婴儿娩出方式名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_way_infantADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_way_infant",  getName_way_infantCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("婴儿娩出方式名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 胎盘娩出时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_placentaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_placenta",  getDt_placentaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("胎盘娩出时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 胎盘娩出方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_way_placentaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_way_placenta",  getId_way_placentaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("胎盘娩出方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 胎盘娩出方式编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_way_placentaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_way_placenta",  getSd_way_placentaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("胎盘娩出方式编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 胎盘娩出方式名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_way_placenADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_way_placen",  getName_way_placenCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("胎盘娩出方式名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 羊水情况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_condi_amnioticADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_condi_amniotic",  getId_condi_amnioticCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("羊水情况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 羊水情况编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_condi_amnioticADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_condi_amniotic",  getSd_condi_amnioticCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("羊水情况编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 羊水情况名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_condi_amnicADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_condi_amnic",  getName_condi_amnicCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("羊水情况名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 胎方位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_positationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_positation",  getId_positationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("胎方位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 胎方位编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_positationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_positation",  getSd_positationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("胎方位编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 胎方位名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_positationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_positation",  getName_positationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("胎方位名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 胎盘长属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getLen_placentaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Len_placenta",  getLen_placentaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("胎盘长");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 胎盘宽属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWidth_placentaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Width_placenta",  getWidth_placentaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("胎盘宽");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 胎盘高属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHeight_placentaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Height_placenta",  getHeight_placentaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("胎盘高");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 胎盘检查属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_check_placentaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_check_placenta",  getId_check_placentaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("胎盘检查");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 胎盘检查编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_check_placentaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_check_placenta",  getSd_check_placentaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("胎盘检查编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 胎盘检查名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_check_placeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_check_place",  getName_check_placeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("胎盘检查名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 胎盘重量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWeight_placentaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Weight_placenta",  getWeight_placentaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("胎盘重量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 胎盘形状属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getShap_placentaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Shap_placenta",  getShap_placentaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("胎盘形状");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 脐带附着属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_adhere_umbiliADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_adhere_umbili",  getId_adhere_umbiliCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("脐带附着");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 脐带附着编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_adhere_umbiliADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_adhere_umbili",  getSd_adhere_umbiliCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("脐带附着编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 脐带附着名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_adhere_umADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_adhere_um",  getName_adhere_umCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("脐带附着名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 脐带长属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getLen_umbiliADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Len_umbili",  getLen_umbiliCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("脐带长");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 第一产程属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFirst_labor_hADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("First_labor_h",  getFirst_labor_hCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("第一产程");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 第一产程分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFirst_labor_mADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("First_labor_m",  getFirst_labor_mCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("第一产程分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 第二产程时属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSecond_labor_hADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Second_labor_h",  getSecond_labor_hCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("第二产程时");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 第二产程分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSecond_labor_mADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Second_labor_m",  getSecond_labor_mCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("第二产程分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 第三产程时属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getThird_labor_hADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Third_labor_h",  getThird_labor_hCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("第三产程时");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 第三产程分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getThird_labor_mADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Third_labor_m",  getThird_labor_mCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("第三产程分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 第四产程时属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFouth_labor_hADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fouth_labor_h",  getFouth_labor_hCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("第四产程时");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 第四产程分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFouth_labor_mADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fouth_labor_m",  getFouth_labor_mCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("第四产程分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 总产程属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWhole_laborADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Whole_labor",  getWhole_laborCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("总产程");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 会阴破裂属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_perineal_ruptureADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_perineal_rupture",  getId_perineal_ruptureCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("会阴破裂");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 会阴破裂编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_perineal_ruptureADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_perineal_rupture",  getSd_perineal_ruptureCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("会阴破裂编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 会阴破裂名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_perineal_rupADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_perineal_rup",  getName_perineal_rupCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("会阴破裂名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 会阴缝合方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_perineal_sutureADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_perineal_suture",  getId_perineal_sutureCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("会阴缝合方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 会阴缝合方式编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_perineal_sutureADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_perineal_suture",  getSd_perineal_sutureCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("会阴缝合方式编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 会阴缝合方式名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_perineal_sutADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_perineal_sut",  getName_perineal_sutCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("会阴缝合方式名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 产时用药属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPro_drugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pro_drug",  getPro_drugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("产时用药");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 收缩压30分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSys_pre_thirtyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sys_pre_thirty",  getSys_pre_thirtyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("收缩压30分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 舒张压15分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDia_preADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dia_pre",  getDia_preCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("舒张压15分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 舒张压30分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDia_pre_thirtyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dia_pre_thirty",  getDia_pre_thirtyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("舒张压30分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 收缩压15分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSys_preADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sys_pre",  getSys_preCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("收缩压15分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 收缩压1小时属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSys_pre_oneADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sys_pre_one",  getSys_pre_oneCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("收缩压1小时");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 舒张压1小时属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDia_pre_oneADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dia_pre_one",  getDia_pre_oneCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("舒张压1小时");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 收缩压2小时属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSys_pre_twoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sys_pre_two",  getSys_pre_twoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("收缩压2小时");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 舒张压2小时属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDia_pre_twoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dia_pre_two",  getDia_pre_twoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("舒张压2小时");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 失血量15分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getLose_bloodADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Lose_blood",  getLose_bloodCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("失血量15分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 失血量30分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getLose_blood_thirtyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Lose_blood_thirty",  getLose_blood_thirtyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("失血量30分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 失血量1小时属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getLose_blood_oneADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Lose_blood_one",  getLose_blood_oneCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("失血量1小时");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 失血量2小时属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getLose_blood_twoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Lose_blood_two",  getLose_blood_twoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("失血量2小时");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 产出宫缩属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pro_ucADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pro_uc",  getId_pro_ucCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("产出宫缩");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 产出宫缩编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_pro_ucADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_pro_uc",  getSd_pro_ucCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("产出宫缩编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 产出宫缩名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_pro_ucADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_pro_uc",  getName_pro_ucCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("产出宫缩名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 分娩镇痛属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_delivery_analgesiaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_delivery_analgesia",  getId_delivery_analgesiaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("分娩镇痛");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 分娩镇痛编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_delivery_analgesiaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_delivery_analgesia",  getSd_delivery_analgesiaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("分娩镇痛编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 分娩镇痛名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_delivery_anaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_delivery_ana",  getName_delivery_anaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("分娩镇痛名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 婴儿男属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInfant_maleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Infant_male",  getInfant_maleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("婴儿男");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 婴儿女属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInfant_femaleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Infant_female",  getInfant_femaleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("婴儿女");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 性别(特殊情况)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInfant_sexADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Infant_sex",  getInfant_sexCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("性别(特殊情况)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 身长属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInfant_lengthADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Infant_length",  getInfant_lengthCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("身长");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 婴儿体重属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInfant_weightADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Infant_weight",  getInfant_weightCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("婴儿体重");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 婴儿窒息属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_infant_stifleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_infant_stifle",  getId_infant_stifleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("婴儿窒息");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 婴儿窒息编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_infant_stifleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_infant_stifle",  getSd_infant_stifleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("婴儿窒息编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 婴儿窒息名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_infant_stifleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_infant_stifle",  getName_infant_stifleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("婴儿窒息名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 呼吸1分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInfant_brethADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Infant_breth",  getInfant_brethCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("呼吸1分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 呼吸5分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInfant_breth_fiveADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Infant_breth_five",  getInfant_breth_fiveCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("呼吸5分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 心跳1分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInfant_heartbeatADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Infant_heartbeat",  getInfant_heartbeatCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("心跳1分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 心跳5分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInfant_heartbeat_fiveADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Infant_heartbeat_five",  getInfant_heartbeat_fiveCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("心跳5分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 颜色1分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInfant_colorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Infant_color",  getInfant_colorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("颜色1分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 颜色5分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInfant_color_fiveADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Infant_color_five",  getInfant_color_fiveCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("颜色5分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 刺激反应属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInfant_stimulateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Infant_stimulate",  getInfant_stimulateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("刺激反应");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 刺激反应5分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInfant_stimulate_fiveADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Infant_stimulate_five",  getInfant_stimulate_fiveCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("刺激反应5分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 张力属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInfant_tensionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Infant_tension",  getInfant_tensionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("张力");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 张力5分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInfant_tension_fiveADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Infant_tension_five",  getInfant_tension_fiveCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("张力5分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 产妇离开产房情形属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPuerpera_condiADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Puerpera_condi",  getPuerpera_condiCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("产妇离开产房情形");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 产妇离开产房时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_puerpera_laveADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_puerpera_lave",  getDt_puerpera_laveCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FTime);
		attrDesc.setLabel("产妇离开产房时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 其它属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOtherADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Other",  getOtherCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("其它");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 接生者签名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_midwifeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_midwife",  getId_midwifeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("接生者签名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 督导者签名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_supervisorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_supervisor",  getId_supervisorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("督导者签名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 检查胎盘备注属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCheck_otherADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Check_other",  getCheck_otherCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("检查胎盘备注");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 会阴缝合备注属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSuture_otherADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Suture_other",  getSuture_otherCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("会阴缝合备注");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 产时用药备注属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDrug_otherADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Drug_other",  getDrug_otherCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("产时用药备注");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 产出宫缩备注属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getUc_otherADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Uc_other",  getUc_otherCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("产出宫缩备注");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_operatorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_operator",  getId_operatorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术");
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
	private IAttrDesc getSd_operatorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_operator",  getSd_operatorCDesc(tblDesc), this);
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
	 * 婴儿特殊情况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_infant_specialADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_infant_special",  getId_infant_specialCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("婴儿特殊情况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 婴儿特殊情况编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_infant_specialADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_infant_special",  getSd_infant_specialCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("婴儿特殊情况编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 婴儿特殊情况名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_infant_special_condiADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_infant_special_condi",  getName_infant_special_condiCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("婴儿特殊情况名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 胎膜破裂方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMembran_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Membran_name",  getMembran_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("胎膜破裂方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b4","id_r_membranes=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 婴儿娩出方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWay_infant_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Way_infant_name",  getWay_infant_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("婴儿娩出方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b6","id_way_infant=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 胎盘娩出方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWay_placen_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Way_placen_name",  getWay_placen_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("胎盘娩出方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b8","id_way_placenta=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 羊水情况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCondi_amnic_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Condi_amnic_name",  getCondi_amnic_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("羊水情况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b5","id_condi_amniotic=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 胎方位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPositation_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Positation_name",  getPositation_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("胎方位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b7","id_positation=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 胎盘检查属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCheck_place_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Check_place_name",  getCheck_place_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("胎盘检查");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b9","id_check_placenta=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 脐带附着属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAdhere_um_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Adhere_um_name",  getAdhere_um_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("脐带附着");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b10","id_adhere_umbili=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 会阴破裂属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPerineal_rup_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Perineal_rup_name",  getPerineal_rup_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("会阴破裂");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b11","id_perineal_rupture=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 会阴缝合方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPerineal_sut_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Perineal_sut_name",  getPerineal_sut_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("会阴缝合方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b12","id_perineal_suture=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 产出宫缩属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPro_uc_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pro_uc_name",  getPro_uc_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("产出宫缩");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b13","id_pro_uc=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 分娩镇痛属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDelivery_ana_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Delivery_ana_name",  getDelivery_ana_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("分娩镇痛");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b14","id_delivery_analgesia=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 婴儿窒息属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInfant_stifle_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Infant_stifle_name",  getInfant_stifle_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("婴儿窒息");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b15","id_infant_stifle=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 接生者属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_midwifeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_midwife",  getName_midwifeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("接生者");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b16","id_midwife=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 督导者属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_supervisor1ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_supervisor1",  getName_supervisor1CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("督导者");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b17","id_supervisor=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_operatorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_operator",  getName_operatorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b18","id_operator=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 特殊情况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_infant_specialADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_infant_special",  getName_infant_specialCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("特殊情况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b21","id_infant_special=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取分娩记录单主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_deliveryrecCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_deliveryrec");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("分娩记录单主键"); 
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
	 * 获取科室表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_dep_phyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dep_phy");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("科室"); 
		return column;
	}
	/**
	 * 获取病区表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_dep_nurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dep_nur");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病区"); 
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
	 * 获取姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_pat");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("姓名"); 
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
	 * 获取住院号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_amr_ipCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_amr_ip");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("住院号"); 
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
	 * 获取宫缩起始时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_uc_bCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_uc_b");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("宫缩起始时间"); 
		return column;
	}
	/**
	 * 获取宫口开全时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_orifice_uterusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_orifice_uterus");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("宫口开全时间"); 
		return column;
	}
	/**
	 * 获取胎膜破裂时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_membranesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_membranes");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("胎膜破裂时间"); 
		return column;
	}
	/**
	 * 获取胎膜破裂方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_r_membranesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_r_membranes");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("胎膜破裂方式"); 
		return column;
	}
	/**
	 * 获取胎膜破裂方式编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_r_membranesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_r_membranes");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("胎膜破裂方式编码"); 
		return column;
	}
	/**
	 * 获取胎膜破裂方式名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_membranCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_membran");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("胎膜破裂方式名称"); 
		return column;
	}
	/**
	 * 获取婴儿娩出时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_out_infantCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_out_infant");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("婴儿娩出时间"); 
		return column;
	}
	/**
	 * 获取婴儿娩出方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_way_infantCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_way_infant");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("婴儿娩出方式"); 
		return column;
	}
	/**
	 * 获取婴儿娩出方式编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_way_infantCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_way_infant");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("婴儿娩出方式编码"); 
		return column;
	}
	/**
	 * 获取婴儿娩出方式名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_way_infantCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_way_infant");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("婴儿娩出方式名称"); 
		return column;
	}
	/**
	 * 获取胎盘娩出时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_placentaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_placenta");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("胎盘娩出时间"); 
		return column;
	}
	/**
	 * 获取胎盘娩出方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_way_placentaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_way_placenta");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("胎盘娩出方式"); 
		return column;
	}
	/**
	 * 获取胎盘娩出方式编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_way_placentaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_way_placenta");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("胎盘娩出方式编码"); 
		return column;
	}
	/**
	 * 获取胎盘娩出方式名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_way_placenCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_way_placen");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("胎盘娩出方式名称"); 
		return column;
	}
	/**
	 * 获取羊水情况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_condi_amnioticCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_condi_amniotic");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("羊水情况"); 
		return column;
	}
	/**
	 * 获取羊水情况编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_condi_amnioticCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_condi_amniotic");
		column.setLength(150);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("羊水情况编码"); 
		return column;
	}
	/**
	 * 获取羊水情况名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_condi_amnicCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_condi_amnic");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("羊水情况名称"); 
		return column;
	}
	/**
	 * 获取胎方位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_positationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_positation");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("胎方位"); 
		return column;
	}
	/**
	 * 获取胎方位编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_positationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_positation");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("胎方位编码"); 
		return column;
	}
	/**
	 * 获取胎方位名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_positationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_positation");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("胎方位名称"); 
		return column;
	}
	/**
	 * 获取胎盘长表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getLen_placentaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Len_placenta");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("胎盘长"); 
		return column;
	}
	/**
	 * 获取胎盘宽表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWidth_placentaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Width_placenta");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("胎盘宽"); 
		return column;
	}
	/**
	 * 获取胎盘高表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHeight_placentaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Height_placenta");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("胎盘高"); 
		return column;
	}
	/**
	 * 获取胎盘检查表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_check_placentaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_check_placenta");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("胎盘检查"); 
		return column;
	}
	/**
	 * 获取胎盘检查编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_check_placentaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_check_placenta");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("胎盘检查编码"); 
		return column;
	}
	/**
	 * 获取胎盘检查名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_check_placeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_check_place");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("胎盘检查名称"); 
		return column;
	}
	/**
	 * 获取胎盘重量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWeight_placentaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Weight_placenta");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("胎盘重量"); 
		return column;
	}
	/**
	 * 获取胎盘形状表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getShap_placentaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Shap_placenta");
		column.setLength(150);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("胎盘形状"); 
		return column;
	}
	/**
	 * 获取脐带附着表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_adhere_umbiliCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_adhere_umbili");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("脐带附着"); 
		return column;
	}
	/**
	 * 获取脐带附着编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_adhere_umbiliCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_adhere_umbili");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("脐带附着编码"); 
		return column;
	}
	/**
	 * 获取脐带附着名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_adhere_umCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_adhere_um");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("脐带附着名称"); 
		return column;
	}
	/**
	 * 获取脐带长表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getLen_umbiliCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Len_umbili");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("脐带长"); 
		return column;
	}
	/**
	 * 获取第一产程表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFirst_labor_hCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"First_labor_h");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("第一产程"); 
		return column;
	}
	/**
	 * 获取第一产程分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFirst_labor_mCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"First_labor_m");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("第一产程分"); 
		return column;
	}
	/**
	 * 获取第二产程时表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSecond_labor_hCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Second_labor_h");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("第二产程时"); 
		return column;
	}
	/**
	 * 获取第二产程分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSecond_labor_mCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Second_labor_m");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("第二产程分"); 
		return column;
	}
	/**
	 * 获取第三产程时表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getThird_labor_hCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Third_labor_h");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("第三产程时"); 
		return column;
	}
	/**
	 * 获取第三产程分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getThird_labor_mCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Third_labor_m");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("第三产程分"); 
		return column;
	}
	/**
	 * 获取第四产程时表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFouth_labor_hCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fouth_labor_h");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("第四产程时"); 
		return column;
	}
	/**
	 * 获取第四产程分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFouth_labor_mCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fouth_labor_m");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("第四产程分"); 
		return column;
	}
	/**
	 * 获取总产程表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWhole_laborCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Whole_labor");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("总产程"); 
		return column;
	}
	/**
	 * 获取会阴破裂表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_perineal_ruptureCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_perineal_rupture");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("会阴破裂"); 
		return column;
	}
	/**
	 * 获取会阴破裂编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_perineal_ruptureCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_perineal_rupture");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("会阴破裂编码"); 
		return column;
	}
	/**
	 * 获取会阴破裂名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_perineal_rupCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_perineal_rup");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("会阴破裂名称"); 
		return column;
	}
	/**
	 * 获取会阴缝合方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_perineal_sutureCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_perineal_suture");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("会阴缝合方式"); 
		return column;
	}
	/**
	 * 获取会阴缝合方式编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_perineal_sutureCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_perineal_suture");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("会阴缝合方式编码"); 
		return column;
	}
	/**
	 * 获取会阴缝合方式名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_perineal_sutCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_perineal_sut");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("会阴缝合方式名称"); 
		return column;
	}
	/**
	 * 获取产时用药表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPro_drugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pro_drug");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("产时用药"); 
		return column;
	}
	/**
	 * 获取收缩压30分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSys_pre_thirtyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sys_pre_thirty");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("收缩压30分"); 
		return column;
	}
	/**
	 * 获取舒张压15分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDia_preCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dia_pre");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("舒张压15分"); 
		return column;
	}
	/**
	 * 获取舒张压30分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDia_pre_thirtyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dia_pre_thirty");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("舒张压30分"); 
		return column;
	}
	/**
	 * 获取收缩压15分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSys_preCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sys_pre");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("收缩压15分"); 
		return column;
	}
	/**
	 * 获取收缩压1小时表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSys_pre_oneCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sys_pre_one");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("收缩压1小时"); 
		return column;
	}
	/**
	 * 获取舒张压1小时表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDia_pre_oneCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dia_pre_one");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("舒张压1小时"); 
		return column;
	}
	/**
	 * 获取收缩压2小时表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSys_pre_twoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sys_pre_two");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("收缩压2小时"); 
		return column;
	}
	/**
	 * 获取舒张压2小时表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDia_pre_twoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dia_pre_two");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("舒张压2小时"); 
		return column;
	}
	/**
	 * 获取失血量15分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getLose_bloodCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Lose_blood");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("失血量15分"); 
		return column;
	}
	/**
	 * 获取失血量30分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getLose_blood_thirtyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Lose_blood_thirty");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("失血量30分"); 
		return column;
	}
	/**
	 * 获取失血量1小时表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getLose_blood_oneCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Lose_blood_one");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("失血量1小时"); 
		return column;
	}
	/**
	 * 获取失血量2小时表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getLose_blood_twoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Lose_blood_two");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("失血量2小时"); 
		return column;
	}
	/**
	 * 获取产出宫缩表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pro_ucCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pro_uc");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("产出宫缩"); 
		return column;
	}
	/**
	 * 获取产出宫缩编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_pro_ucCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_pro_uc");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("产出宫缩编码"); 
		return column;
	}
	/**
	 * 获取产出宫缩名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_pro_ucCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_pro_uc");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("产出宫缩名称"); 
		return column;
	}
	/**
	 * 获取分娩镇痛表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_delivery_analgesiaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_delivery_analgesia");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("分娩镇痛"); 
		return column;
	}
	/**
	 * 获取分娩镇痛编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_delivery_analgesiaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_delivery_analgesia");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("分娩镇痛编码"); 
		return column;
	}
	/**
	 * 获取分娩镇痛名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_delivery_anaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_delivery_ana");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("分娩镇痛名称"); 
		return column;
	}
	/**
	 * 获取婴儿男表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInfant_maleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Infant_male");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("婴儿男"); 
		return column;
	}
	/**
	 * 获取婴儿女表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInfant_femaleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Infant_female");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("婴儿女"); 
		return column;
	}
	/**
	 * 获取性别(特殊情况)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInfant_sexCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Infant_sex");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("性别(特殊情况)"); 
		return column;
	}
	/**
	 * 获取身长表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInfant_lengthCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Infant_length");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("身长"); 
		return column;
	}
	/**
	 * 获取婴儿体重表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInfant_weightCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Infant_weight");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("婴儿体重"); 
		return column;
	}
	/**
	 * 获取婴儿窒息表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_infant_stifleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_infant_stifle");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("婴儿窒息"); 
		return column;
	}
	/**
	 * 获取婴儿窒息编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_infant_stifleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_infant_stifle");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("婴儿窒息编码"); 
		return column;
	}
	/**
	 * 获取婴儿窒息名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_infant_stifleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_infant_stifle");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("婴儿窒息名称"); 
		return column;
	}
	/**
	 * 获取呼吸1分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInfant_brethCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Infant_breth");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("呼吸1分"); 
		return column;
	}
	/**
	 * 获取呼吸5分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInfant_breth_fiveCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Infant_breth_five");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("呼吸5分"); 
		return column;
	}
	/**
	 * 获取心跳1分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInfant_heartbeatCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Infant_heartbeat");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("心跳1分"); 
		return column;
	}
	/**
	 * 获取心跳5分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInfant_heartbeat_fiveCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Infant_heartbeat_five");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("心跳5分"); 
		return column;
	}
	/**
	 * 获取颜色1分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInfant_colorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Infant_color");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("颜色1分"); 
		return column;
	}
	/**
	 * 获取颜色5分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInfant_color_fiveCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Infant_color_five");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("颜色5分"); 
		return column;
	}
	/**
	 * 获取刺激反应表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInfant_stimulateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Infant_stimulate");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("刺激反应"); 
		return column;
	}
	/**
	 * 获取刺激反应5分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInfant_stimulate_fiveCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Infant_stimulate_five");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("刺激反应5分"); 
		return column;
	}
	/**
	 * 获取张力表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInfant_tensionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Infant_tension");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("张力"); 
		return column;
	}
	/**
	 * 获取张力5分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInfant_tension_fiveCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Infant_tension_five");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("张力5分"); 
		return column;
	}
	/**
	 * 获取产妇离开产房情形表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPuerpera_condiCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Puerpera_condi");
		column.setLength(3000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("产妇离开产房情形"); 
		return column;
	}
	/**
	 * 获取产妇离开产房时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_puerpera_laveCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_puerpera_lave");
		column.setLength(8);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("产妇离开产房时间"); 
		return column;
	}
	/**
	 * 获取其它表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOtherCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Other");
		column.setLength(3000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("其它"); 
		return column;
	}
	/**
	 * 获取接生者签名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_midwifeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_midwife");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("接生者签名"); 
		return column;
	}
	/**
	 * 获取督导者签名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_supervisorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_supervisor");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("督导者签名"); 
		return column;
	}
	/**
	 * 获取检查胎盘备注表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCheck_otherCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Check_other");
		column.setLength(150);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("检查胎盘备注"); 
		return column;
	}
	/**
	 * 获取会阴缝合备注表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSuture_otherCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Suture_other");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("会阴缝合备注"); 
		return column;
	}
	/**
	 * 获取产时用药备注表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDrug_otherCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Drug_other");
		column.setLength(150);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("产时用药备注"); 
		return column;
	}
	/**
	 * 获取产出宫缩备注表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getUc_otherCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Uc_other");
		column.setLength(150);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("产出宫缩备注"); 
		return column;
	}
	/**
	 * 获取手术表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_operatorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_operator");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术"); 
		return column;
	}
	/**
	 * 获取手术编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_operatorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_operator");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术编码"); 
		return column;
	}
	/**
	 * 获取诊断表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDiagnosisCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Diagnosis");
		column.setLength(150);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断"); 
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
	 * 获取婴儿特殊情况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_infant_specialCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_infant_special");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("婴儿特殊情况"); 
		return column;
	}
	/**
	 * 获取婴儿特殊情况编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_infant_specialCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_infant_special");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("婴儿特殊情况编码"); 
		return column;
	}
	/**
	 * 获取婴儿特殊情况名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_infant_special_condiCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_infant_special_condi");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("婴儿特殊情况名称"); 
		return column;
	}
	/**
	 * 获取胎膜破裂方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMembran_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Membran_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("胎膜破裂方式"); 
		return column;
	}
	/**
	 * 获取婴儿娩出方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWay_infant_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Way_infant_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("婴儿娩出方式"); 
		return column;
	}
	/**
	 * 获取胎盘娩出方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWay_placen_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Way_placen_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("胎盘娩出方式"); 
		return column;
	}
	/**
	 * 获取羊水情况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCondi_amnic_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Condi_amnic_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("羊水情况"); 
		return column;
	}
	/**
	 * 获取胎方位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPositation_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Positation_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("胎方位"); 
		return column;
	}
	/**
	 * 获取胎盘检查表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCheck_place_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Check_place_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("胎盘检查"); 
		return column;
	}
	/**
	 * 获取脐带附着表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAdhere_um_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Adhere_um_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("脐带附着"); 
		return column;
	}
	/**
	 * 获取会阴破裂表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPerineal_rup_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Perineal_rup_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("会阴破裂"); 
		return column;
	}
	/**
	 * 获取会阴缝合方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPerineal_sut_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Perineal_sut_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("会阴缝合方式"); 
		return column;
	}
	/**
	 * 获取产出宫缩表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPro_uc_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pro_uc_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("产出宫缩"); 
		return column;
	}
	/**
	 * 获取分娩镇痛表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDelivery_ana_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Delivery_ana_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("分娩镇痛"); 
		return column;
	}
	/**
	 * 获取婴儿窒息表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInfant_stifle_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Infant_stifle_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("婴儿窒息"); 
		return column;
	}
	/**
	 * 获取接生者表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_midwifeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_midwife");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("接生者"); 
		return column;
	}
	/**
	 * 获取督导者表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_supervisor1CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_supervisor1");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("督导者"); 
		return column;
	}
	/**
	 * 获取手术表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_operatorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_operator");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术"); 
		return column;
	}
	/**
	 * 获取特殊情况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_infant_specialCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_infant_special");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("特殊情况"); 
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
