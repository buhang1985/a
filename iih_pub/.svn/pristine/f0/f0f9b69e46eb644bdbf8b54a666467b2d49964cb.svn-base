
package iih.ci.rcm.catheter.d.desc;

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
 * ICU病例监测_导管 DO 元数据信息
 */
public class CatheterDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.ci.rcm.catheter.d.CatheterDO";
	public static final String CLASS_DISPALYNAME = "ICU病例监测_导管";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "ci_rcm_cath";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_catheter";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public CatheterDODesc(){
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
		this.setKeyDesc(getId_catheterADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_catheterADesc(tblDesc));
		this.add(getId_caseADesc(tblDesc));
		this.add(getId_equip_categoryADesc(tblDesc));
		this.add(getSd_equip_categoryADesc(tblDesc));
		this.add(getName_equip_categoryADesc(tblDesc));
		this.add(getId_catheter_typeADesc(tblDesc));
		this.add(getSd_catheter_typeADesc(tblDesc));
		this.add(getName_catheter_typeADesc(tblDesc));
		this.add(getId_catheter_cavity_numADesc(tblDesc));
		this.add(getSd_catheter_cavity_numADesc(tblDesc));
		this.add(getName_catheter_cavity_numADesc(tblDesc));
		this.add(getId_siteADesc(tblDesc));
		this.add(getSd_siteADesc(tblDesc));
		this.add(getName_siteADesc(tblDesc));
		this.add(getIntubation_dateADesc(tblDesc));
		this.add(getExtubation_dateADesc(tblDesc));
		this.add(getCatheter_dayADesc(tblDesc));
		this.add(getId_intubationistADesc(tblDesc));
		this.add(getSd_intubationistADesc(tblDesc));
		this.add(getName_intubationistADesc(tblDesc));
		this.add(getId_catheter_placeADesc(tblDesc));
		this.add(getSd_catheter_placeADesc(tblDesc));
		this.add(getName_catheter_placeADesc(tblDesc));
		this.add(getIs_infectionADesc(tblDesc));
		this.add(getInfection_symptomsADesc(tblDesc));
		this.add(getInfection_dateADesc(tblDesc));
		this.add(getInfection_catheter_dayADesc(tblDesc));
		this.add(getPathogenic_examADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getEquip_category_codeADesc(tblDesc));
		this.add(getEquip_category_nameADesc(tblDesc));
		this.add(getCatheter_type_codeADesc(tblDesc));
		this.add(getCatheter_type_nameADesc(tblDesc));
		this.add(getCatheter_cavity_num_codeADesc(tblDesc));
		this.add(getCatheter_cavity_num_nameADesc(tblDesc));
		this.add(getSite_nameADesc(tblDesc));
		this.add(getSite_codeADesc(tblDesc));
		this.add(getIntubationist_nameADesc(tblDesc));
		this.add(getIntubationist_codeADesc(tblDesc));
		this.add(getCatheter_place_codeADesc(tblDesc));
		this.add(getCatheter_place_nameADesc(tblDesc));
		this.add(getInfesym_codeADesc(tblDesc));
		this.add(getInfesym_nameADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_catheterCDesc(tblDesc));
		tblDesc.add(getId_catheterCDesc(tblDesc));
		tblDesc.add(getId_caseCDesc(tblDesc));
		tblDesc.add(getId_equip_categoryCDesc(tblDesc));
		tblDesc.add(getSd_equip_categoryCDesc(tblDesc));
		tblDesc.add(getName_equip_categoryCDesc(tblDesc));
		tblDesc.add(getId_catheter_typeCDesc(tblDesc));
		tblDesc.add(getSd_catheter_typeCDesc(tblDesc));
		tblDesc.add(getName_catheter_typeCDesc(tblDesc));
		tblDesc.add(getId_catheter_cavity_numCDesc(tblDesc));
		tblDesc.add(getSd_catheter_cavity_numCDesc(tblDesc));
		tblDesc.add(getName_catheter_cavity_numCDesc(tblDesc));
		tblDesc.add(getId_siteCDesc(tblDesc));
		tblDesc.add(getSd_siteCDesc(tblDesc));
		tblDesc.add(getName_siteCDesc(tblDesc));
		tblDesc.add(getIntubation_dateCDesc(tblDesc));
		tblDesc.add(getExtubation_dateCDesc(tblDesc));
		tblDesc.add(getCatheter_dayCDesc(tblDesc));
		tblDesc.add(getId_intubationistCDesc(tblDesc));
		tblDesc.add(getSd_intubationistCDesc(tblDesc));
		tblDesc.add(getName_intubationistCDesc(tblDesc));
		tblDesc.add(getId_catheter_placeCDesc(tblDesc));
		tblDesc.add(getSd_catheter_placeCDesc(tblDesc));
		tblDesc.add(getName_catheter_placeCDesc(tblDesc));
		tblDesc.add(getIs_infectionCDesc(tblDesc));
		tblDesc.add(getInfection_symptomsCDesc(tblDesc));
		tblDesc.add(getInfection_dateCDesc(tblDesc));
		tblDesc.add(getInfection_catheter_dayCDesc(tblDesc));
		tblDesc.add(getPathogenic_examCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 导管主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_catheterADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_catheter",  getId_catheterCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("导管主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * ICU监测主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_caseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_case",  getId_caseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("ICU监测主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 设备类别属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_equip_categoryADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_equip_category",  getId_equip_categoryCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("设备类别");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 设备类别编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_equip_categoryADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_equip_category",  getSd_equip_categoryCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("设备类别编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 设备类别名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_equip_categoryADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_equip_category",  getName_equip_categoryCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("设备类别名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 导管类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_catheter_typeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_catheter_type",  getId_catheter_typeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("导管类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 导管类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_catheter_typeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_catheter_type",  getSd_catheter_typeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("导管类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 导管类型名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_catheter_typeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_catheter_type",  getName_catheter_typeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("导管类型名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 导管腔数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_catheter_cavity_numADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_catheter_cavity_num",  getId_catheter_cavity_numCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("导管腔数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 导管腔数编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_catheter_cavity_numADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_catheter_cavity_num",  getSd_catheter_cavity_numCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("导管腔数编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 导管腔数名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_catheter_cavity_numADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_catheter_cavity_num",  getName_catheter_cavity_numCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("导管腔数名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 部位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_siteADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_site",  getId_siteCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("部位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 部位编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_siteADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_site",  getSd_siteCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("部位编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 部位名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_siteADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_site",  getName_siteCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("部位名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 插管日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIntubation_dateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Intubation_date",  getIntubation_dateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("插管日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 拔管日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getExtubation_dateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Extubation_date",  getExtubation_dateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("拔管日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 导管天数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCatheter_dayADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Catheter_day",  getCatheter_dayCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("导管天数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 插管者属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_intubationistADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_intubationist",  getId_intubationistCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("插管者");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 插管编编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_intubationistADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_intubationist",  getSd_intubationistCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("插管编编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 插管者名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_intubationistADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_intubationist",  getName_intubationistCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("插管者名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 置管地点属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_catheter_placeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_catheter_place",  getId_catheter_placeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("置管地点");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 置管地点编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_catheter_placeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_catheter_place",  getSd_catheter_placeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("置管地点编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 置管地点名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_catheter_placeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_catheter_place",  getName_catheter_placeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("置管地点名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否感染属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIs_infectionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Is_infection",  getIs_infectionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否感染");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 感染症状属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInfection_symptomsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Infection_symptoms",  getInfection_symptomsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("感染症状");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 感染日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInfection_dateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Infection_date",  getInfection_dateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("感染日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 感染距置管天数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInfection_catheter_dayADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Infection_catheter_day",  getInfection_catheter_dayCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("感染距置管天数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 病原学检验属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPathogenic_examADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pathogenic_exam",  getPathogenic_examCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("病原学检验");
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
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEquip_category_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Equip_category_code",  getEquip_category_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b2","id_equip_category=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEquip_category_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Equip_category_name",  getEquip_category_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b2","id_equip_category=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCatheter_type_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Catheter_type_code",  getCatheter_type_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b3","id_catheter_type=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCatheter_type_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Catheter_type_name",  getCatheter_type_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b3","id_catheter_type=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCatheter_cavity_num_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Catheter_cavity_num_code",  getCatheter_cavity_num_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b4","id_catheter_cavity_num=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCatheter_cavity_num_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Catheter_cavity_num_name",  getCatheter_cavity_num_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b4","id_catheter_cavity_num=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSite_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Site_name",  getSite_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b5","id_site=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSite_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Site_code",  getSite_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b5","id_site=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIntubationist_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Intubationist_name",  getIntubationist_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b6","id_intubationist=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIntubationist_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Intubationist_code",  getIntubationist_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b6","id_intubationist=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCatheter_place_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Catheter_place_code",  getCatheter_place_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b7","id_catheter_place=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCatheter_place_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Catheter_place_name",  getCatheter_place_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b7","id_catheter_place=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInfesym_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Infesym_code",  getInfesym_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b10","infection_symptoms=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInfesym_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Infesym_name",  getInfesym_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b10","infection_symptoms=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取导管主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_catheterCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_catheter");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("导管主键"); 
		return column;
	}
	/**
	 * 获取ICU监测主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_caseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_case");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("ICU监测主键"); 
		return column;
	}
	/**
	 * 获取设备类别表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_equip_categoryCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_equip_category");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("设备类别"); 
		return column;
	}
	/**
	 * 获取设备类别编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_equip_categoryCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_equip_category");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("设备类别编码"); 
		return column;
	}
	/**
	 * 获取设备类别名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_equip_categoryCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_equip_category");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("设备类别名称"); 
		return column;
	}
	/**
	 * 获取导管类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_catheter_typeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_catheter_type");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("导管类型"); 
		return column;
	}
	/**
	 * 获取导管类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_catheter_typeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_catheter_type");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("导管类型编码"); 
		return column;
	}
	/**
	 * 获取导管类型名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_catheter_typeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_catheter_type");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("导管类型名称"); 
		return column;
	}
	/**
	 * 获取导管腔数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_catheter_cavity_numCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_catheter_cavity_num");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("导管腔数"); 
		return column;
	}
	/**
	 * 获取导管腔数编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_catheter_cavity_numCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_catheter_cavity_num");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("导管腔数编码"); 
		return column;
	}
	/**
	 * 获取导管腔数名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_catheter_cavity_numCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_catheter_cavity_num");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("导管腔数名称"); 
		return column;
	}
	/**
	 * 获取部位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_siteCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_site");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("部位"); 
		return column;
	}
	/**
	 * 获取部位编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_siteCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_site");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("部位编码"); 
		return column;
	}
	/**
	 * 获取部位名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_siteCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_site");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("部位名称"); 
		return column;
	}
	/**
	 * 获取插管日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIntubation_dateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Intubation_date");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("插管日期"); 
		return column;
	}
	/**
	 * 获取拔管日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getExtubation_dateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Extubation_date");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("拔管日期"); 
		return column;
	}
	/**
	 * 获取导管天数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCatheter_dayCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Catheter_day");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("导管天数"); 
		return column;
	}
	/**
	 * 获取插管者表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_intubationistCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_intubationist");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("插管者"); 
		return column;
	}
	/**
	 * 获取插管编编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_intubationistCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_intubationist");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("插管编编码"); 
		return column;
	}
	/**
	 * 获取插管者名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_intubationistCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_intubationist");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("插管者名称"); 
		return column;
	}
	/**
	 * 获取置管地点表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_catheter_placeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_catheter_place");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("置管地点"); 
		return column;
	}
	/**
	 * 获取置管地点编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_catheter_placeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_catheter_place");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("置管地点编码"); 
		return column;
	}
	/**
	 * 获取置管地点名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_catheter_placeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_catheter_place");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("置管地点名称"); 
		return column;
	}
	/**
	 * 获取是否感染表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIs_infectionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Is_infection");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否感染"); 
		return column;
	}
	/**
	 * 获取感染症状表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInfection_symptomsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Infection_symptoms");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("感染症状"); 
		return column;
	}
	/**
	 * 获取感染日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInfection_dateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Infection_date");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("感染日期"); 
		return column;
	}
	/**
	 * 获取感染距置管天数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInfection_catheter_dayCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Infection_catheter_day");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("感染距置管天数"); 
		return column;
	}
	/**
	 * 获取病原学检验表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPathogenic_examCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pathogenic_exam");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("病原学检验"); 
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
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEquip_category_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Equip_category_code");
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
	private IColumnDesc getEquip_category_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Equip_category_name");
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
	private IColumnDesc getCatheter_type_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Catheter_type_code");
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
	private IColumnDesc getCatheter_type_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Catheter_type_name");
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
	private IColumnDesc getCatheter_cavity_num_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Catheter_cavity_num_code");
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
	private IColumnDesc getCatheter_cavity_num_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Catheter_cavity_num_name");
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
	private IColumnDesc getSite_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Site_name");
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
	private IColumnDesc getSite_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Site_code");
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
	private IColumnDesc getIntubationist_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Intubationist_name");
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
	private IColumnDesc getIntubationist_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Intubationist_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCatheter_place_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Catheter_place_code");
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
	private IColumnDesc getCatheter_place_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Catheter_place_name");
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
	private IColumnDesc getInfesym_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Infesym_code");
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
	private IColumnDesc getInfesym_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Infesym_name");
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
		iBDDataInfoFldMap.put("id","Id_catheter");
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
