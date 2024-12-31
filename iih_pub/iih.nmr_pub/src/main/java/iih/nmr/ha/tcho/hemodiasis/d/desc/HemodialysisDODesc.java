
package iih.nmr.ha.tcho.hemodiasis.d.desc;

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
 * 血液透析护理记录 DO 元数据信息
 */
public class HemodialysisDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.nmr.ha.tcho.hemodiasis.d.HemodialysisDO";
	public static final String CLASS_DISPALYNAME = "血液透析护理记录";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "NMR_TCHO_HEMO";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_hemodia";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public HemodialysisDODesc(){
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
		this.setKeyDesc(getId_hemodiaADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_hemodiaADesc(tblDesc));
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
		this.add(getId_diagnosisADesc(tblDesc));
		this.add(getName_diagnosisADesc(tblDesc));
		this.add(getDt_dateADesc(tblDesc));
		this.add(getId_nurADesc(tblDesc));
		this.add(getNum_hemodialysisADesc(tblDesc));
		this.add(getWeightADesc(tblDesc));
		this.add(getDt_sethemodialyADesc(tblDesc));
		this.add(getDt_relhemodialyADesc(tblDesc));
		this.add(getNum_primedoseADesc(tblDesc));
		this.add(getNum_maintendoseADesc(tblDesc));
		this.add(getNum_wt_prehemodialADesc(tblDesc));
		this.add(getNum_wt_afthemodialADesc(tblDesc));
		this.add(getId_method_anticoagulADesc(tblDesc));
		this.add(getSd_method_anticoagulADesc(tblDesc));
		this.add(getNo_dialymachineADesc(tblDesc));
		this.add(getSno_dialymachineADesc(tblDesc));
		this.add(getNum_setdehydraADesc(tblDesc));
		this.add(getNum_reldehydraADesc(tblDesc));
		this.add(getNum_peeADesc(tblDesc));
		this.add(getNum_caADesc(tblDesc));
		this.add(getNum_hco3ADesc(tblDesc));
		this.add(getNum_flowADesc(tblDesc));
		this.add(getNum_naADesc(tblDesc));
		this.add(getEu_edemaADesc(tblDesc));
		this.add(getEu_heartfailureADesc(tblDesc));
		this.add(getEu_bleedingtendADesc(tblDesc));
		this.add(getNum_prereplaceADesc(tblDesc));
		this.add(getNum_aftreplaceADesc(tblDesc));
		this.add(getEu_dialyzintactADesc(tblDesc));
		this.add(getEu_dialyzusefulADesc(tblDesc));
		this.add(getId_interfistcauseADesc(tblDesc));
		this.add(getSd_interfistcauseADesc(tblDesc));
		this.add(getNum_arteriopunctureADesc(tblDesc));
		this.add(getNum_venipunctureADesc(tblDesc));
		this.add(getNum_interfisthematlenADesc(tblDesc));
		this.add(getNum_interfisthematwidADesc(tblDesc));
		this.add(getEu_interfistdefflowADesc(tblDesc));
		this.add(getEu_interfisthematADesc(tblDesc));
		this.add(getNum_pullneedlematlenADesc(tblDesc));
		this.add(getNum_pullneedlematwidADesc(tblDesc));
		this.add(getEu_pullneedlesmoothADesc(tblDesc));
		this.add(getEu_pullneedlerrhysisADesc(tblDesc));
		this.add(getEu_pullneedlehematADesc(tblDesc));
		this.add(getId_pullneedlecauseADesc(tblDesc));
		this.add(getSd_pullneedlecauseADesc(tblDesc));
		this.add(getSno_machineADesc(tblDesc));
		this.add(getEu_machstoppageADesc(tblDesc));
		this.add(getName_oth_machineADesc(tblDesc));
		this.add(getCause_failureADesc(tblDesc));
		this.add(getDes_oth_bleedingtendADesc(tblDesc));
		this.add(getDes_oth_dialysiswayADesc(tblDesc));
		this.add(getId_type_machineADesc(tblDesc));
		this.add(getSd_type_machineADesc(tblDesc));
		this.add(getId_vascularaccessADesc(tblDesc));
		this.add(getSd_vascularaccessADesc(tblDesc));
		this.add(getId_dialysiswayADesc(tblDesc));
		this.add(getSd_dialysiswayADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getEu_interfistsmoothADesc(tblDesc));
		this.add(getEu_fistulatremorADesc(tblDesc));
		this.add(getEu_noiseADesc(tblDesc));
		this.add(getId_doc_signADesc(tblDesc));
		this.add(getId_ccz_signADesc(tblDesc));
		this.add(getId_xjz_signADesc(tblDesc));
		this.add(getId_signADesc(tblDesc));
		this.add(getDt_createADesc(tblDesc));
		this.add(getNameADesc(tblDesc));
		this.add(getName_method_anticoagulADesc(tblDesc));
		this.add(getName_interfistcauseADesc(tblDesc));
		this.add(getName_pullneedlecauseADesc(tblDesc));
		this.add(getName_type_machineADesc(tblDesc));
		this.add(getName_vascularaccessADesc(tblDesc));
		this.add(getName_dialysiswayADesc(tblDesc));
		this.add(getName_doc_signADesc(tblDesc));
		this.add(getName_ccz_signADesc(tblDesc));
		this.add(getName_xjz_signADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_hemodiaCDesc(tblDesc));
		tblDesc.add(getId_hemodiaCDesc(tblDesc));
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
		tblDesc.add(getId_diagnosisCDesc(tblDesc));
		tblDesc.add(getName_diagnosisCDesc(tblDesc));
		tblDesc.add(getDt_dateCDesc(tblDesc));
		tblDesc.add(getId_nurCDesc(tblDesc));
		tblDesc.add(getNum_hemodialysisCDesc(tblDesc));
		tblDesc.add(getWeightCDesc(tblDesc));
		tblDesc.add(getDt_sethemodialyCDesc(tblDesc));
		tblDesc.add(getDt_relhemodialyCDesc(tblDesc));
		tblDesc.add(getNum_primedoseCDesc(tblDesc));
		tblDesc.add(getNum_maintendoseCDesc(tblDesc));
		tblDesc.add(getNum_wt_prehemodialCDesc(tblDesc));
		tblDesc.add(getNum_wt_afthemodialCDesc(tblDesc));
		tblDesc.add(getId_method_anticoagulCDesc(tblDesc));
		tblDesc.add(getSd_method_anticoagulCDesc(tblDesc));
		tblDesc.add(getNo_dialymachineCDesc(tblDesc));
		tblDesc.add(getSno_dialymachineCDesc(tblDesc));
		tblDesc.add(getNum_setdehydraCDesc(tblDesc));
		tblDesc.add(getNum_reldehydraCDesc(tblDesc));
		tblDesc.add(getNum_peeCDesc(tblDesc));
		tblDesc.add(getNum_caCDesc(tblDesc));
		tblDesc.add(getNum_hco3CDesc(tblDesc));
		tblDesc.add(getNum_flowCDesc(tblDesc));
		tblDesc.add(getNum_naCDesc(tblDesc));
		tblDesc.add(getEu_edemaCDesc(tblDesc));
		tblDesc.add(getEu_heartfailureCDesc(tblDesc));
		tblDesc.add(getEu_bleedingtendCDesc(tblDesc));
		tblDesc.add(getNum_prereplaceCDesc(tblDesc));
		tblDesc.add(getNum_aftreplaceCDesc(tblDesc));
		tblDesc.add(getEu_dialyzintactCDesc(tblDesc));
		tblDesc.add(getEu_dialyzusefulCDesc(tblDesc));
		tblDesc.add(getId_interfistcauseCDesc(tblDesc));
		tblDesc.add(getSd_interfistcauseCDesc(tblDesc));
		tblDesc.add(getNum_arteriopunctureCDesc(tblDesc));
		tblDesc.add(getNum_venipunctureCDesc(tblDesc));
		tblDesc.add(getNum_interfisthematlenCDesc(tblDesc));
		tblDesc.add(getNum_interfisthematwidCDesc(tblDesc));
		tblDesc.add(getEu_interfistdefflowCDesc(tblDesc));
		tblDesc.add(getEu_interfisthematCDesc(tblDesc));
		tblDesc.add(getNum_pullneedlematlenCDesc(tblDesc));
		tblDesc.add(getNum_pullneedlematwidCDesc(tblDesc));
		tblDesc.add(getEu_pullneedlesmoothCDesc(tblDesc));
		tblDesc.add(getEu_pullneedlerrhysisCDesc(tblDesc));
		tblDesc.add(getEu_pullneedlehematCDesc(tblDesc));
		tblDesc.add(getId_pullneedlecauseCDesc(tblDesc));
		tblDesc.add(getSd_pullneedlecauseCDesc(tblDesc));
		tblDesc.add(getSno_machineCDesc(tblDesc));
		tblDesc.add(getEu_machstoppageCDesc(tblDesc));
		tblDesc.add(getName_oth_machineCDesc(tblDesc));
		tblDesc.add(getCause_failureCDesc(tblDesc));
		tblDesc.add(getDes_oth_bleedingtendCDesc(tblDesc));
		tblDesc.add(getDes_oth_dialysiswayCDesc(tblDesc));
		tblDesc.add(getId_type_machineCDesc(tblDesc));
		tblDesc.add(getSd_type_machineCDesc(tblDesc));
		tblDesc.add(getId_vascularaccessCDesc(tblDesc));
		tblDesc.add(getSd_vascularaccessCDesc(tblDesc));
		tblDesc.add(getId_dialysiswayCDesc(tblDesc));
		tblDesc.add(getSd_dialysiswayCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		tblDesc.add(getEu_interfistsmoothCDesc(tblDesc));
		tblDesc.add(getEu_fistulatremorCDesc(tblDesc));
		tblDesc.add(getEu_noiseCDesc(tblDesc));
		tblDesc.add(getId_doc_signCDesc(tblDesc));
		tblDesc.add(getId_ccz_signCDesc(tblDesc));
		tblDesc.add(getId_xjz_signCDesc(tblDesc));
		tblDesc.add(getId_signCDesc(tblDesc));
		tblDesc.add(getDt_createCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 血液透析护理记录属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_hemodiaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_hemodia",  getId_hemodiaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("血液透析护理记录");
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
	 * 诊断属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_diagnosisADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_diagnosis",  getName_diagnosisCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_dateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_date",  getDt_dateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("日期");
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
	 * 透析次数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNum_hemodialysisADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Num_hemodialysis",  getNum_hemodialysisCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("透析次数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 干体重属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWeightADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Weight",  getWeightCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("干体重");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 设定透析时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_sethemodialyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_sethemodialy",  getDt_sethemodialyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("设定透析时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 实际透析时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_relhemodialyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_relhemodialy",  getDt_relhemodialyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("实际透析时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 肝素首量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNum_primedoseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Num_primedose",  getNum_primedoseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("肝素首量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 肝素维持量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNum_maintendoseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Num_maintendose",  getNum_maintendoseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("肝素维持量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 透前体重属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNum_wt_prehemodialADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Num_wt_prehemodial",  getNum_wt_prehemodialCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("透前体重");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 透后体重属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNum_wt_afthemodialADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Num_wt_afthemodial",  getNum_wt_afthemodialCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("透后体重");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 抗凝方法属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_method_anticoagulADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_method_anticoagul",  getId_method_anticoagulCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("抗凝方法");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 抗凝方法编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_method_anticoagulADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_method_anticoagul",  getSd_method_anticoagulCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("抗凝方法编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 透析机型号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNo_dialymachineADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("No_dialymachine",  getNo_dialymachineCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("透析机型号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 透析机序号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSno_dialymachineADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sno_dialymachine",  getSno_dialymachineCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("透析机序号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 设定脱水量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNum_setdehydraADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Num_setdehydra",  getNum_setdehydraCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("设定脱水量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 实际脱水量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNum_reldehydraADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Num_reldehydra",  getNum_reldehydraCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("实际脱水量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 尿量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNum_peeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Num_pee",  getNum_peeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("尿量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 透析液成分钙属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNum_caADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Num_ca",  getNum_caCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("透析液成分钙");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 透析液成分碳酸氢根属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNum_hco3ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Num_hco3",  getNum_hco3CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("透析液成分碳酸氢根");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 透析液流量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNum_flowADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Num_flow",  getNum_flowCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("透析液流量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 透析液成分钠属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNum_naADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Num_na",  getNum_naCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("透析液成分钠");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 水肿属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_edemaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_edema",  getEu_edemaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("水肿");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 心衰属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_heartfailureADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_heartfailure",  getEu_heartfailureCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("心衰");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 出血倾向属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_bleedingtendADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_bleedingtend",  getEu_bleedingtendCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("出血倾向");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 置换液量前容积属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNum_prereplaceADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Num_prereplace",  getNum_prereplaceCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("置换液量前容积");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 置换液量后容积属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNum_aftreplaceADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Num_aftreplace",  getNum_aftreplaceCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("置换液量后容积");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 透析器完好属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_dialyzintactADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_dialyzintact",  getEu_dialyzintactCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("透析器完好");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 透析器有效期内属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_dialyzusefulADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_dialyzuseful",  getEu_dialyzusefulCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("透析器有效期内");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 内瘘穿刺原因属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_interfistcauseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_interfistcause",  getId_interfistcauseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("内瘘穿刺原因");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 内瘘穿刺原因编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_interfistcauseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_interfistcause",  getSd_interfistcauseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("内瘘穿刺原因编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 动脉穿刺次数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNum_arteriopunctureADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Num_arteriopuncture",  getNum_arteriopunctureCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("动脉穿刺次数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 静脉穿刺次数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNum_venipunctureADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Num_venipuncture",  getNum_venipunctureCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("静脉穿刺次数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 内瘘穿刺血肿长属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNum_interfisthematlenADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Num_interfisthematlen",  getNum_interfisthematlenCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("内瘘穿刺血肿长");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 内瘘穿刺血肿宽属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNum_interfisthematwidADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Num_interfisthematwid",  getNum_interfisthematwidCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("内瘘穿刺血肿宽");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 内瘘穿刺流量不足有无属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_interfistdefflowADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_interfistdefflow",  getEu_interfistdefflowCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("内瘘穿刺流量不足有无");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 内瘘穿刺血肿有无属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_interfisthematADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_interfisthemat",  getEu_interfisthematCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("内瘘穿刺血肿有无");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 下机拔针血肿长属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNum_pullneedlematlenADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Num_pullneedlematlen",  getNum_pullneedlematlenCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("下机拔针血肿长");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 下机拔针血肿宽属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNum_pullneedlematwidADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Num_pullneedlematwid",  getNum_pullneedlematwidCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("下机拔针血肿宽");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 下机拔针是否顺利属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_pullneedlesmoothADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_pullneedlesmooth",  getEu_pullneedlesmoothCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("下机拔针是否顺利");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 下机拔针渗血有无属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_pullneedlerrhysisADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_pullneedlerrhysis",  getEu_pullneedlerrhysisCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("下机拔针渗血有无");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 下机拔针血肿有无属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_pullneedlehematADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_pullneedlehemat",  getEu_pullneedlehematCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("下机拔针血肿有无");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 下机拔针原因属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pullneedlecauseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pullneedlecause",  getId_pullneedlecauseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("下机拔针原因");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 下机拔针原因编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_pullneedlecauseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_pullneedlecause",  getSd_pullneedlecauseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("下机拔针原因编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 机器号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSno_machineADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sno_machine",  getSno_machineCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("机器号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 机器故障属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_machstoppageADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_machstoppage",  getEu_machstoppageCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("机器故障");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 机器机型其他属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_oth_machineADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_oth_machine",  getName_oth_machineCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("机器机型其他");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 故障原因属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCause_failureADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Cause_failure",  getCause_failureCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("故障原因");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 出血倾向其他属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDes_oth_bleedingtendADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Des_oth_bleedingtend",  getDes_oth_bleedingtendCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("出血倾向其他");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 透析方式其他属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDes_oth_dialysiswayADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Des_oth_dialysisway",  getDes_oth_dialysiswayCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("透析方式其他");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 机器机型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_type_machineADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_type_machine",  getId_type_machineCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("机器机型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 机器机型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_type_machineADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_type_machine",  getSd_type_machineCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("机器机型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 血管通路属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_vascularaccessADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_vascularaccess",  getId_vascularaccessCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("血管通路");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 血管通路编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_vascularaccessADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_vascularaccess",  getSd_vascularaccessCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("血管通路编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 透析方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dialysiswayADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dialysisway",  getId_dialysiswayCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("透析方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 透析方式编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_dialysiswayADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_dialysisway",  getSd_dialysiswayCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("透析方式编码");
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
	 * 内瘘穿刺是否顺利属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_interfistsmoothADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_interfistsmooth",  getEu_interfistsmoothCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("内瘘穿刺是否顺利");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 内瘘震颤属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_fistulatremorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_fistulatremor",  getEu_fistulatremorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("内瘘震颤");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 杂音属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_noiseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_noise",  getEu_noiseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("杂音");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医生签名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_doc_signADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_doc_sign",  getId_doc_signCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医生签名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 穿刺者签名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ccz_signADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ccz_sign",  getId_ccz_signCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("穿刺者签名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 下机者签名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_xjz_signADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_xjz_sign",  getId_xjz_signCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("下机者签名");
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
	 * 签名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name",  getNameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("签名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b13","id_nur=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 抗凝方法属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_method_anticoagulADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_method_anticoagul",  getName_method_anticoagulCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("抗凝方法");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b4","id_method_anticoagul=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 内瘘穿刺原因属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_interfistcauseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_interfistcause",  getName_interfistcauseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("内瘘穿刺原因");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b5","id_interfistcause=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 下机拔针原因属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_pullneedlecauseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_pullneedlecause",  getName_pullneedlecauseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("下机拔针原因");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b6","id_pullneedlecause=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 机器机型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_type_machineADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_type_machine",  getName_type_machineCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("机器机型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b7","id_type_machine=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 血管通路属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_vascularaccessADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_vascularaccess",  getName_vascularaccessCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("血管通路");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b8","id_vascularaccess=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 透析方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dialysiswayADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dialysisway",  getName_dialysiswayCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("透析方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b9","id_dialysisway=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医生签名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_doc_signADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_doc_sign",  getName_doc_signCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医生签名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b16","id_doc_sign=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 穿刺者签名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_ccz_signADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_ccz_sign",  getName_ccz_signCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("穿刺者签名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b17","id_ccz_sign=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_xjz_signADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_xjz_sign",  getName_xjz_signCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b18","id_xjz_sign=id_psndoc","name"});
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
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b19","id_sign=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取血液透析护理记录表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_hemodiaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_hemodia");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("血液透析护理记录"); 
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
	 * 获取诊断表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_diagnosisCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_diagnosis");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断"); 
		return column;
	}
	/**
	 * 获取日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_dateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_date");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("日期"); 
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
	 * 获取透析次数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNum_hemodialysisCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Num_hemodialysis");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("透析次数"); 
		return column;
	}
	/**
	 * 获取干体重表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWeightCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Weight");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("干体重"); 
		return column;
	}
	/**
	 * 获取设定透析时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_sethemodialyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_sethemodialy");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("设定透析时间"); 
		return column;
	}
	/**
	 * 获取实际透析时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_relhemodialyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_relhemodialy");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("实际透析时间"); 
		return column;
	}
	/**
	 * 获取肝素首量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNum_primedoseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Num_primedose");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("肝素首量"); 
		return column;
	}
	/**
	 * 获取肝素维持量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNum_maintendoseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Num_maintendose");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("肝素维持量"); 
		return column;
	}
	/**
	 * 获取透前体重表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNum_wt_prehemodialCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Num_wt_prehemodial");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("透前体重"); 
		return column;
	}
	/**
	 * 获取透后体重表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNum_wt_afthemodialCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Num_wt_afthemodial");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("透后体重"); 
		return column;
	}
	/**
	 * 获取抗凝方法表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_method_anticoagulCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_method_anticoagul");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("抗凝方法"); 
		return column;
	}
	/**
	 * 获取抗凝方法编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_method_anticoagulCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_method_anticoagul");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("抗凝方法编码"); 
		return column;
	}
	/**
	 * 获取透析机型号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNo_dialymachineCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"No_dialymachine");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("透析机型号"); 
		return column;
	}
	/**
	 * 获取透析机序号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSno_dialymachineCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sno_dialymachine");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("透析机序号"); 
		return column;
	}
	/**
	 * 获取设定脱水量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNum_setdehydraCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Num_setdehydra");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("设定脱水量"); 
		return column;
	}
	/**
	 * 获取实际脱水量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNum_reldehydraCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Num_reldehydra");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("实际脱水量"); 
		return column;
	}
	/**
	 * 获取尿量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNum_peeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Num_pee");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("尿量"); 
		return column;
	}
	/**
	 * 获取透析液成分钙表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNum_caCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Num_ca");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("透析液成分钙"); 
		return column;
	}
	/**
	 * 获取透析液成分碳酸氢根表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNum_hco3CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Num_hco3");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("透析液成分碳酸氢根"); 
		return column;
	}
	/**
	 * 获取透析液流量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNum_flowCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Num_flow");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("透析液流量"); 
		return column;
	}
	/**
	 * 获取透析液成分钠表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNum_naCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Num_na");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("透析液成分钠"); 
		return column;
	}
	/**
	 * 获取水肿表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_edemaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_edema");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("水肿"); 
		return column;
	}
	/**
	 * 获取心衰表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_heartfailureCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_heartfailure");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("心衰"); 
		return column;
	}
	/**
	 * 获取出血倾向表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_bleedingtendCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_bleedingtend");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("出血倾向"); 
		return column;
	}
	/**
	 * 获取置换液量前容积表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNum_prereplaceCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Num_prereplace");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("置换液量前容积"); 
		return column;
	}
	/**
	 * 获取置换液量后容积表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNum_aftreplaceCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Num_aftreplace");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("置换液量后容积"); 
		return column;
	}
	/**
	 * 获取透析器完好表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_dialyzintactCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_dialyzintact");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("透析器完好"); 
		return column;
	}
	/**
	 * 获取透析器有效期内表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_dialyzusefulCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_dialyzuseful");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("透析器有效期内"); 
		return column;
	}
	/**
	 * 获取内瘘穿刺原因表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_interfistcauseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_interfistcause");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("内瘘穿刺原因"); 
		return column;
	}
	/**
	 * 获取内瘘穿刺原因编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_interfistcauseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_interfistcause");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("内瘘穿刺原因编码"); 
		return column;
	}
	/**
	 * 获取动脉穿刺次数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNum_arteriopunctureCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Num_arteriopuncture");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("动脉穿刺次数"); 
		return column;
	}
	/**
	 * 获取静脉穿刺次数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNum_venipunctureCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Num_venipuncture");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("静脉穿刺次数"); 
		return column;
	}
	/**
	 * 获取内瘘穿刺血肿长表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNum_interfisthematlenCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Num_interfisthematlen");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("内瘘穿刺血肿长"); 
		return column;
	}
	/**
	 * 获取内瘘穿刺血肿宽表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNum_interfisthematwidCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Num_interfisthematwid");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("内瘘穿刺血肿宽"); 
		return column;
	}
	/**
	 * 获取内瘘穿刺流量不足有无表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_interfistdefflowCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_interfistdefflow");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("内瘘穿刺流量不足有无"); 
		return column;
	}
	/**
	 * 获取内瘘穿刺血肿有无表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_interfisthematCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_interfisthemat");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("内瘘穿刺血肿有无"); 
		return column;
	}
	/**
	 * 获取下机拔针血肿长表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNum_pullneedlematlenCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Num_pullneedlematlen");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("下机拔针血肿长"); 
		return column;
	}
	/**
	 * 获取下机拔针血肿宽表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNum_pullneedlematwidCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Num_pullneedlematwid");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("下机拔针血肿宽"); 
		return column;
	}
	/**
	 * 获取下机拔针是否顺利表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_pullneedlesmoothCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_pullneedlesmooth");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("下机拔针是否顺利"); 
		return column;
	}
	/**
	 * 获取下机拔针渗血有无表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_pullneedlerrhysisCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_pullneedlerrhysis");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("下机拔针渗血有无"); 
		return column;
	}
	/**
	 * 获取下机拔针血肿有无表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_pullneedlehematCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_pullneedlehemat");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("下机拔针血肿有无"); 
		return column;
	}
	/**
	 * 获取下机拔针原因表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pullneedlecauseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pullneedlecause");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("下机拔针原因"); 
		return column;
	}
	/**
	 * 获取下机拔针原因编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_pullneedlecauseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_pullneedlecause");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("下机拔针原因编码"); 
		return column;
	}
	/**
	 * 获取机器号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSno_machineCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sno_machine");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("机器号"); 
		return column;
	}
	/**
	 * 获取机器故障表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_machstoppageCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_machstoppage");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("机器故障"); 
		return column;
	}
	/**
	 * 获取机器机型其他表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_oth_machineCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_oth_machine");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("机器机型其他"); 
		return column;
	}
	/**
	 * 获取故障原因表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCause_failureCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Cause_failure");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("故障原因"); 
		return column;
	}
	/**
	 * 获取出血倾向其他表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDes_oth_bleedingtendCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Des_oth_bleedingtend");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("出血倾向其他"); 
		return column;
	}
	/**
	 * 获取透析方式其他表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDes_oth_dialysiswayCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Des_oth_dialysisway");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("透析方式其他"); 
		return column;
	}
	/**
	 * 获取机器机型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_type_machineCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_type_machine");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("机器机型"); 
		return column;
	}
	/**
	 * 获取机器机型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_type_machineCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_type_machine");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("机器机型编码"); 
		return column;
	}
	/**
	 * 获取血管通路表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_vascularaccessCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_vascularaccess");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("血管通路"); 
		return column;
	}
	/**
	 * 获取血管通路编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_vascularaccessCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_vascularaccess");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("血管通路编码"); 
		return column;
	}
	/**
	 * 获取透析方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dialysiswayCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dialysisway");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("透析方式"); 
		return column;
	}
	/**
	 * 获取透析方式编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_dialysiswayCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_dialysisway");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("透析方式编码"); 
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
	 * 获取内瘘穿刺是否顺利表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_interfistsmoothCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_interfistsmooth");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("内瘘穿刺是否顺利"); 
		return column;
	}
	/**
	 * 获取内瘘震颤表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_fistulatremorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_fistulatremor");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("内瘘震颤"); 
		return column;
	}
	/**
	 * 获取杂音表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_noiseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_noise");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("杂音"); 
		return column;
	}
	/**
	 * 获取医生签名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_doc_signCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_doc_sign");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医生签名"); 
		return column;
	}
	/**
	 * 获取穿刺者签名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ccz_signCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ccz_sign");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("穿刺者签名"); 
		return column;
	}
	/**
	 * 获取下机者签名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_xjz_signCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_xjz_sign");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("下机者签名"); 
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
	 * 获取签名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("签名"); 
		return column;
	}
	/**
	 * 获取抗凝方法表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_method_anticoagulCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_method_anticoagul");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("抗凝方法"); 
		return column;
	}
	/**
	 * 获取内瘘穿刺原因表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_interfistcauseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_interfistcause");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("内瘘穿刺原因"); 
		return column;
	}
	/**
	 * 获取下机拔针原因表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_pullneedlecauseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_pullneedlecause");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("下机拔针原因"); 
		return column;
	}
	/**
	 * 获取机器机型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_type_machineCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_type_machine");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("机器机型"); 
		return column;
	}
	/**
	 * 获取血管通路表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_vascularaccessCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_vascularaccess");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("血管通路"); 
		return column;
	}
	/**
	 * 获取透析方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_dialysiswayCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dialysisway");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("透析方式"); 
		return column;
	}
	/**
	 * 获取医生签名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_doc_signCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_doc_sign");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医生签名"); 
		return column;
	}
	/**
	 * 获取穿刺者签名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_ccz_signCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_ccz_sign");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("穿刺者签名"); 
		return column;
	}
	/**
	 * 获取姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_xjz_signCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_xjz_sign");
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
	private IColumnDesc getName_signCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_sign");
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
