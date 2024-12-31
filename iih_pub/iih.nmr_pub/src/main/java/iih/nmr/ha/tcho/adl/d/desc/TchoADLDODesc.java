
package iih.nmr.ha.tcho.adl.d.desc;

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
 * 患者生活自理能力评定量表 DO 元数据信息
 */
public class TchoADLDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.nmr.ha.tcho.adl.d.TchoADLDO";
	public static final String CLASS_DISPALYNAME = "患者生活自理能力评定量表";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "nur_ha_tcho_ADL";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_adl";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public TchoADLDODesc(){
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
		this.setKeyDesc(getId_adlADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_adlADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_dep_nurADesc(tblDesc));
		this.add(getId_entADesc(tblDesc));
		this.add(getId_patADesc(tblDesc));
		this.add(getName_sexADesc(tblDesc));
		this.add(getName_bedADesc(tblDesc));
		this.add(getCode_amr_ipADesc(tblDesc));
		this.add(getId_diagnosisADesc(tblDesc));
		this.add(getName_diagnosisADesc(tblDesc));
		this.add(getChinese_diagnoseADesc(tblDesc));
		this.add(getWestern_diagnoseADesc(tblDesc));
		this.add(getAgeADesc(tblDesc));
		this.add(getDt_entryADesc(tblDesc));
		this.add(getId_takefoodADesc(tblDesc));
		this.add(getSd_takefoodADesc(tblDesc));
		this.add(getSco_takefoodADesc(tblDesc));
		this.add(getId_bathADesc(tblDesc));
		this.add(getSd_bathADesc(tblDesc));
		this.add(getSco_bathADesc(tblDesc));
		this.add(getId_bedeckADesc(tblDesc));
		this.add(getSd_bedeckADesc(tblDesc));
		this.add(getSco_bedeckADesc(tblDesc));
		this.add(getId_dressADesc(tblDesc));
		this.add(getSd_dressADesc(tblDesc));
		this.add(getSco_dressADesc(tblDesc));
		this.add(getId_ctrfecesADesc(tblDesc));
		this.add(getSd_ctrfecesADesc(tblDesc));
		this.add(getSco_ctrfecesADesc(tblDesc));
		this.add(getId_ctrpeeADesc(tblDesc));
		this.add(getSd_ctrpeeADesc(tblDesc));
		this.add(getSco_ctrpeeADesc(tblDesc));
		this.add(getId_defcationADesc(tblDesc));
		this.add(getSd_defcationADesc(tblDesc));
		this.add(getSco_defcationADesc(tblDesc));
		this.add(getId_bedbentranADesc(tblDesc));
		this.add(getSd_bedbentranADesc(tblDesc));
		this.add(getSco_bedbentranADesc(tblDesc));
		this.add(getId_levtalkADesc(tblDesc));
		this.add(getSd_levtalkADesc(tblDesc));
		this.add(getSco_levtalkADesc(tblDesc));
		this.add(getId_updownstairADesc(tblDesc));
		this.add(getSd_updownstairADesc(tblDesc));
		this.add(getSco_updownstairADesc(tblDesc));
		this.add(getAss_resultADesc(tblDesc));
		this.add(getDt_assADesc(tblDesc));
		this.add(getId_ass_psnADesc(tblDesc));
		this.add(getId_signatureADesc(tblDesc));
		this.add(getTotalscoreADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getName_dep_nurADesc(tblDesc));
		this.add(getName_patADesc(tblDesc));
		this.add(getName_takefoodADesc(tblDesc));
		this.add(getName_bathADesc(tblDesc));
		this.add(getName_bedeckADesc(tblDesc));
		this.add(getName_dressADesc(tblDesc));
		this.add(getName_ctrfecesADesc(tblDesc));
		this.add(getName_ctrpeeADesc(tblDesc));
		this.add(getName_defcationADesc(tblDesc));
		this.add(getName_bedbentranADesc(tblDesc));
		this.add(getName_levtalkADesc(tblDesc));
		this.add(getName_updownstairADesc(tblDesc));
		this.add(getName_ass_psnADesc(tblDesc));
		this.add(getName_signatureADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_adlCDesc(tblDesc));
		tblDesc.add(getId_adlCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_dep_nurCDesc(tblDesc));
		tblDesc.add(getId_entCDesc(tblDesc));
		tblDesc.add(getId_patCDesc(tblDesc));
		tblDesc.add(getName_sexCDesc(tblDesc));
		tblDesc.add(getName_bedCDesc(tblDesc));
		tblDesc.add(getCode_amr_ipCDesc(tblDesc));
		tblDesc.add(getId_diagnosisCDesc(tblDesc));
		tblDesc.add(getName_diagnosisCDesc(tblDesc));
		tblDesc.add(getChinese_diagnoseCDesc(tblDesc));
		tblDesc.add(getWestern_diagnoseCDesc(tblDesc));
		tblDesc.add(getAgeCDesc(tblDesc));
		tblDesc.add(getDt_entryCDesc(tblDesc));
		tblDesc.add(getId_takefoodCDesc(tblDesc));
		tblDesc.add(getSd_takefoodCDesc(tblDesc));
		tblDesc.add(getSco_takefoodCDesc(tblDesc));
		tblDesc.add(getId_bathCDesc(tblDesc));
		tblDesc.add(getSd_bathCDesc(tblDesc));
		tblDesc.add(getSco_bathCDesc(tblDesc));
		tblDesc.add(getId_bedeckCDesc(tblDesc));
		tblDesc.add(getSd_bedeckCDesc(tblDesc));
		tblDesc.add(getSco_bedeckCDesc(tblDesc));
		tblDesc.add(getId_dressCDesc(tblDesc));
		tblDesc.add(getSd_dressCDesc(tblDesc));
		tblDesc.add(getSco_dressCDesc(tblDesc));
		tblDesc.add(getId_ctrfecesCDesc(tblDesc));
		tblDesc.add(getSd_ctrfecesCDesc(tblDesc));
		tblDesc.add(getSco_ctrfecesCDesc(tblDesc));
		tblDesc.add(getId_ctrpeeCDesc(tblDesc));
		tblDesc.add(getSd_ctrpeeCDesc(tblDesc));
		tblDesc.add(getSco_ctrpeeCDesc(tblDesc));
		tblDesc.add(getId_defcationCDesc(tblDesc));
		tblDesc.add(getSd_defcationCDesc(tblDesc));
		tblDesc.add(getSco_defcationCDesc(tblDesc));
		tblDesc.add(getId_bedbentranCDesc(tblDesc));
		tblDesc.add(getSd_bedbentranCDesc(tblDesc));
		tblDesc.add(getSco_bedbentranCDesc(tblDesc));
		tblDesc.add(getId_levtalkCDesc(tblDesc));
		tblDesc.add(getSd_levtalkCDesc(tblDesc));
		tblDesc.add(getSco_levtalkCDesc(tblDesc));
		tblDesc.add(getId_updownstairCDesc(tblDesc));
		tblDesc.add(getSd_updownstairCDesc(tblDesc));
		tblDesc.add(getSco_updownstairCDesc(tblDesc));
		tblDesc.add(getAss_resultCDesc(tblDesc));
		tblDesc.add(getDt_assCDesc(tblDesc));
		tblDesc.add(getId_ass_psnCDesc(tblDesc));
		tblDesc.add(getId_signatureCDesc(tblDesc));
		tblDesc.add(getTotalscoreCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * ADL指数评估单主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_adlADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_adl",  getId_adlCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("ADL指数评估单主键");
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
		attrDesc.setNullable(true);
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
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 病区属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dep_nurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep_nur",  getId_dep_nurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病区");
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
		attrDesc.setRefType(true);
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
	 * 中医诊断属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getChinese_diagnoseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Chinese_diagnose",  getChinese_diagnoseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("中医诊断");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 西医诊断属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWestern_diagnoseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Western_diagnose",  getWestern_diagnoseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("西医诊断");
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
	 * 进食属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_takefoodADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_takefood",  getId_takefoodCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("进食");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 进食编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_takefoodADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_takefood",  getSd_takefoodCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("进食编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 进食得分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSco_takefoodADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sco_takefood",  getSco_takefoodCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("进食得分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 洗澡属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_bathADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_bath",  getId_bathCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("洗澡");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 洗澡编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_bathADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_bath",  getSd_bathCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("洗澡编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 洗澡得分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSco_bathADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sco_bath",  getSco_bathCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("洗澡得分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 修饰属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_bedeckADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_bedeck",  getId_bedeckCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("修饰");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 修饰编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_bedeckADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_bedeck",  getSd_bedeckCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("修饰编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 修饰得分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSco_bedeckADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sco_bedeck",  getSco_bedeckCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("修饰得分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 穿衣属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dressADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dress",  getId_dressCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("穿衣");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 穿衣编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_dressADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_dress",  getSd_dressCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("穿衣编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 穿衣得分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSco_dressADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sco_dress",  getSco_dressCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("穿衣得分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 大便属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ctrfecesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ctrfeces",  getId_ctrfecesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("大便");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 大便编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_ctrfecesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_ctrfeces",  getSd_ctrfecesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("大便编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 控制大便得分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSco_ctrfecesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sco_ctrfeces",  getSco_ctrfecesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("控制大便得分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 小便属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ctrpeeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ctrpee",  getId_ctrpeeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("小便");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 小便编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_ctrpeeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_ctrpee",  getSd_ctrpeeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("小便编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 控制小便得分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSco_ctrpeeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sco_ctrpee",  getSco_ctrpeeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("控制小便得分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 如厕属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_defcationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_defcation",  getId_defcationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("如厕");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 如厕编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_defcationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_defcation",  getSd_defcationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("如厕编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 如厕得分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSco_defcationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sco_defcation",  getSco_defcationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("如厕得分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 座椅转移属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_bedbentranADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_bedbentran",  getId_bedbentranCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("座椅转移");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 座椅转移编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_bedbentranADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_bedbentran",  getSd_bedbentranCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("座椅转移编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 座椅转移得分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSco_bedbentranADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sco_bedbentran",  getSco_bedbentranCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("座椅转移得分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 平地行走属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_levtalkADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_levtalk",  getId_levtalkCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("平地行走");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 平地行走编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_levtalkADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_levtalk",  getSd_levtalkCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("平地行走编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 平地行走得分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSco_levtalkADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sco_levtalk",  getSco_levtalkCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("平地行走得分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 上下楼梯属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_updownstairADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_updownstair",  getId_updownstairCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("上下楼梯");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 上下楼梯编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_updownstairADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_updownstair",  getSd_updownstairCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("上下楼梯编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 上下楼梯得分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSco_updownstairADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sco_updownstair",  getSco_updownstairCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("上下楼梯得分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 评估结果属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAss_resultADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ass_result",  getAss_resultCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("评估结果");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 评估时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_assADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_ass",  getDt_assCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("评估时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 评估人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ass_psnADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ass_psn",  getId_ass_psnCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("评估人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 签名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_signatureADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_signature",  getId_signatureCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("签名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 总分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTotalscoreADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Totalscore",  getTotalscoreCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("总分");
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
	private IAttrDesc getName_dep_nurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dep_nur",  getName_dep_nurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b4","id_dep_nur=id_dep","name"});
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
		attrDesc.setRefTblInfos(new String[]{"pi_pat a0b17","id_pat=id_pat","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_takefoodADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_takefood",  getName_takefoodCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b5","id_takefood=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_bathADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_bath",  getName_bathCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b6","id_bath=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_bedeckADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_bedeck",  getName_bedeckCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b7","id_bedeck=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dressADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dress",  getName_dressCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b8","id_dress=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_ctrfecesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_ctrfeces",  getName_ctrfecesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b9","id_ctrfeces=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_ctrpeeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_ctrpee",  getName_ctrpeeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b10","id_ctrpee=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_defcationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_defcation",  getName_defcationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b11","id_defcation=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_bedbentranADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_bedbentran",  getName_bedbentranCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b12","id_bedbentran=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_levtalkADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_levtalk",  getName_levtalkCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b13","id_levtalk=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_updownstairADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_updownstair",  getName_updownstairCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b14","id_updownstair=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_ass_psnADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_ass_psn",  getName_ass_psnCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b20","id_ass_psn=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_signatureADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_signature",  getName_signatureCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b21","id_signature=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取ADL指数评估单主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_adlCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_adl");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("ADL指数评估单主键"); 
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
	 * 获取病区表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dep_nurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep_nur");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病区"); 
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
	 * 获取患者ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pat");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者ID"); 
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
	 * 获取床号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_bedCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_bed");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("床号"); 
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
	 * 获取诊断名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_diagnosisCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_diagnosis");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断名称"); 
		return column;
	}
	/**
	 * 获取中医诊断表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getChinese_diagnoseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Chinese_diagnose");
		column.setLength(1500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("中医诊断"); 
		return column;
	}
	/**
	 * 获取西医诊断表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWestern_diagnoseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Western_diagnose");
		column.setLength(1500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("西医诊断"); 
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
	 * 获取进食表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_takefoodCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_takefood");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("进食"); 
		return column;
	}
	/**
	 * 获取进食编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_takefoodCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_takefood");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("进食编码"); 
		return column;
	}
	/**
	 * 获取进食得分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSco_takefoodCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sco_takefood");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("进食得分"); 
		return column;
	}
	/**
	 * 获取洗澡表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_bathCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_bath");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("洗澡"); 
		return column;
	}
	/**
	 * 获取洗澡编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_bathCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_bath");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("洗澡编码"); 
		return column;
	}
	/**
	 * 获取洗澡得分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSco_bathCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sco_bath");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("洗澡得分"); 
		return column;
	}
	/**
	 * 获取修饰表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_bedeckCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_bedeck");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("修饰"); 
		return column;
	}
	/**
	 * 获取修饰编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_bedeckCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_bedeck");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("修饰编码"); 
		return column;
	}
	/**
	 * 获取修饰得分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSco_bedeckCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sco_bedeck");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("修饰得分"); 
		return column;
	}
	/**
	 * 获取穿衣表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dressCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dress");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("穿衣"); 
		return column;
	}
	/**
	 * 获取穿衣编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_dressCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_dress");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("穿衣编码"); 
		return column;
	}
	/**
	 * 获取穿衣得分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSco_dressCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sco_dress");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("穿衣得分"); 
		return column;
	}
	/**
	 * 获取大便表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ctrfecesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ctrfeces");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("大便"); 
		return column;
	}
	/**
	 * 获取大便编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_ctrfecesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_ctrfeces");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("大便编码"); 
		return column;
	}
	/**
	 * 获取控制大便得分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSco_ctrfecesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sco_ctrfeces");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("控制大便得分"); 
		return column;
	}
	/**
	 * 获取小便表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ctrpeeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ctrpee");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("小便"); 
		return column;
	}
	/**
	 * 获取小便编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_ctrpeeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_ctrpee");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("小便编码"); 
		return column;
	}
	/**
	 * 获取控制小便得分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSco_ctrpeeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sco_ctrpee");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("控制小便得分"); 
		return column;
	}
	/**
	 * 获取如厕表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_defcationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_defcation");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("如厕"); 
		return column;
	}
	/**
	 * 获取如厕编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_defcationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_defcation");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("如厕编码"); 
		return column;
	}
	/**
	 * 获取如厕得分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSco_defcationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sco_defcation");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("如厕得分"); 
		return column;
	}
	/**
	 * 获取座椅转移表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_bedbentranCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_bedbentran");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("座椅转移"); 
		return column;
	}
	/**
	 * 获取座椅转移编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_bedbentranCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_bedbentran");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("座椅转移编码"); 
		return column;
	}
	/**
	 * 获取座椅转移得分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSco_bedbentranCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sco_bedbentran");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("座椅转移得分"); 
		return column;
	}
	/**
	 * 获取平地行走表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_levtalkCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_levtalk");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("平地行走"); 
		return column;
	}
	/**
	 * 获取平地行走编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_levtalkCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_levtalk");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("平地行走编码"); 
		return column;
	}
	/**
	 * 获取平地行走得分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSco_levtalkCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sco_levtalk");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("平地行走得分"); 
		return column;
	}
	/**
	 * 获取上下楼梯表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_updownstairCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_updownstair");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("上下楼梯"); 
		return column;
	}
	/**
	 * 获取上下楼梯编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_updownstairCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_updownstair");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("上下楼梯编码"); 
		return column;
	}
	/**
	 * 获取上下楼梯得分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSco_updownstairCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sco_updownstair");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("上下楼梯得分"); 
		return column;
	}
	/**
	 * 获取评估结果表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAss_resultCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ass_result");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("评估结果"); 
		return column;
	}
	/**
	 * 获取评估时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_assCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_ass");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("评估时间"); 
		return column;
	}
	/**
	 * 获取评估人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ass_psnCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ass_psn");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("评估人"); 
		return column;
	}
	/**
	 * 获取签名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_signatureCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_signature");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("签名"); 
		return column;
	}
	/**
	 * 获取总分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTotalscoreCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Totalscore");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("总分"); 
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
	private IColumnDesc getName_dep_nurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dep_nur");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
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
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_takefoodCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_takefood");
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
	private IColumnDesc getName_bathCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_bath");
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
	private IColumnDesc getName_bedeckCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_bedeck");
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
	private IColumnDesc getName_dressCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dress");
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
	private IColumnDesc getName_ctrfecesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_ctrfeces");
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
	private IColumnDesc getName_ctrpeeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_ctrpee");
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
	private IColumnDesc getName_defcationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_defcation");
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
	private IColumnDesc getName_bedbentranCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_bedbentran");
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
	private IColumnDesc getName_levtalkCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_levtalk");
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
	private IColumnDesc getName_updownstairCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_updownstair");
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
	private IColumnDesc getName_ass_psnCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_ass_psn");
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
	private IColumnDesc getName_signatureCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_signature");
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
