package iih.mi.mibd.drug.d.desc;

import java.sql.Types;
import java.util.HashMap;
import xap.mw.coreitf.d.FType;
import xap.mw.coreitf.i.IAttrDesc;
import xap.mw.coreitf.i.IColumnDesc;
import xap.mw.coreitf.i.ITableDesc;
import xap.sys.appfw.orm.desc.db.ColumnDesc;
import xap.sys.appfw.orm.desc.db.DsColumn;
import xap.sys.appfw.orm.desc.db.SvColumn;
import xap.sys.appfw.orm.desc.db.TableDesc;
import xap.sys.appfw.orm.desc.ent.dataobject.Attr;
import xap.sys.appfw.orm.desc.ent.dataobject.DODesc;
import xap.sys.appfw.orm.desc.ent.dataobject.DsAttr;
import xap.sys.appfw.orm.desc.ent.dataobject.SvAttr;

/**
 * 药品 DO 元数据信息
 * 
 * @author hexx
 */
public class DrugDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.mi.mibd.drug.d.DrugDO";
	public static final String CLASS_DISPALYNAME = "药品";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "MI_BD_DRUG";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_drug";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public DrugDODesc(){
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
		this.setKeyDesc(getId_drugADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_drugADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_misADesc(tblDesc));
		this.add(getHospital_codeADesc(tblDesc));
		this.add(getCodeADesc(tblDesc));
		this.add(getNameADesc(tblDesc));
		this.add(getName_genericADesc(tblDesc));
		this.add(getName_englishADesc(tblDesc));
		this.add(getDrug_typeADesc(tblDesc));
		this.add(getCode_cateADesc(tblDesc));
		this.add(getEu_feelevelADesc(tblDesc));
		this.add(getPriceADesc(tblDesc));
		this.add(getPri_maxADesc(tblDesc));
		this.add(getDrug_gradeADesc(tblDesc));
		this.add(getAppnoADesc(tblDesc));
		this.add(getFg_effectiveADesc(tblDesc));
		this.add(getPycodeADesc(tblDesc));
		this.add(getWbcodeADesc(tblDesc));
		this.add(getDt_bADesc(tblDesc));
		this.add(getDt_eADesc(tblDesc));
		this.add(getLimit_factorADesc(tblDesc));
		this.add(getPycode_genericADesc(tblDesc));
		this.add(getWbcode_genericADesc(tblDesc));
		this.add(getZdycode_genericADesc(tblDesc));
		this.add(getDose_unitADesc(tblDesc));
		this.add(getDosageADesc(tblDesc));
		this.add(getSingle_doseADesc(tblDesc));
		this.add(getFreqADesc(tblDesc));
		this.add(getUsageADesc(tblDesc));
		this.add(getSpecADesc(tblDesc));
		this.add(getUnitADesc(tblDesc));
		this.add(getAmt_prepay_maxADesc(tblDesc));
		this.add(getFg_prep_selfADesc(tblDesc));
		this.add(getFg_approveADesc(tblDesc));
		this.add(getFg_octADesc(tblDesc));
		this.add(getMin_hospital_rankADesc(tblDesc));
		this.add(getMin_doctor_rankADesc(tblDesc));
		this.add(getFg_add_insurADesc(tblDesc));
		this.add(getFg_add_insur_salADesc(tblDesc));
		this.add(getFg_bidding_drugADesc(tblDesc));
		this.add(getPrice_biddingADesc(tblDesc));
		this.add(getFg_spec_drugADesc(tblDesc));
		this.add(getFg_two_insurpayADesc(tblDesc));
		this.add(getPharm_firm_nameADesc(tblDesc));
		this.add(getEmp_handleADesc(tblDesc));
		this.add(getDt_handleADesc(tblDesc));
		this.add(getPrc_direc_codeADesc(tblDesc));
		this.add(getReference_priceADesc(tblDesc));
		this.add(getReference_hospitalADesc(tblDesc));
		this.add(getOrigin_placeADesc(tblDesc));
		this.add(getFg_prc_b_druglistADesc(tblDesc));
		this.add(getFg_resident_useADesc(tblDesc));
		this.add(getSex_limit_payADesc(tblDesc));
		this.add(getDisease_limit_payADesc(tblDesc));
		this.add(getFg_prc_druglistADesc(tblDesc));
		this.add(getMax_use_daysADesc(tblDesc));
		this.add(getRetire_ey_pri_maxADesc(tblDesc));
		this.add(getRate_self_oepADesc(tblDesc));
		this.add(getRate_self_ipADesc(tblDesc));
		this.add(getRate_retireADesc(tblDesc));
		this.add(getRate_injuryADesc(tblDesc));
		this.add(getRate_birthADesc(tblDesc));
		this.add(getRate_eyADesc(tblDesc));
		this.add(getRate_unitADesc(tblDesc));
		this.add(getRate_familyADesc(tblDesc));
		this.add(getRate_import_diffADesc(tblDesc));
		this.add(getDesADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getMis_nameADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_drugCDesc(tblDesc));
		tblDesc.add(getId_drugCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_misCDesc(tblDesc));
		tblDesc.add(getHospital_codeCDesc(tblDesc));
		tblDesc.add(getCodeCDesc(tblDesc));
		tblDesc.add(getNameCDesc(tblDesc));
		tblDesc.add(getName_genericCDesc(tblDesc));
		tblDesc.add(getName_englishCDesc(tblDesc));
		tblDesc.add(getDrug_typeCDesc(tblDesc));
		tblDesc.add(getCode_cateCDesc(tblDesc));
		tblDesc.add(getEu_feelevelCDesc(tblDesc));
		tblDesc.add(getPriceCDesc(tblDesc));
		tblDesc.add(getPri_maxCDesc(tblDesc));
		tblDesc.add(getDrug_gradeCDesc(tblDesc));
		tblDesc.add(getAppnoCDesc(tblDesc));
		tblDesc.add(getFg_effectiveCDesc(tblDesc));
		tblDesc.add(getPycodeCDesc(tblDesc));
		tblDesc.add(getWbcodeCDesc(tblDesc));
		tblDesc.add(getDt_bCDesc(tblDesc));
		tblDesc.add(getDt_eCDesc(tblDesc));
		tblDesc.add(getLimit_factorCDesc(tblDesc));
		tblDesc.add(getPycode_genericCDesc(tblDesc));
		tblDesc.add(getWbcode_genericCDesc(tblDesc));
		tblDesc.add(getZdycode_genericCDesc(tblDesc));
		tblDesc.add(getDose_unitCDesc(tblDesc));
		tblDesc.add(getDosageCDesc(tblDesc));
		tblDesc.add(getSingle_doseCDesc(tblDesc));
		tblDesc.add(getFreqCDesc(tblDesc));
		tblDesc.add(getUsageCDesc(tblDesc));
		tblDesc.add(getSpecCDesc(tblDesc));
		tblDesc.add(getUnitCDesc(tblDesc));
		tblDesc.add(getAmt_prepay_maxCDesc(tblDesc));
		tblDesc.add(getFg_prep_selfCDesc(tblDesc));
		tblDesc.add(getFg_approveCDesc(tblDesc));
		tblDesc.add(getFg_octCDesc(tblDesc));
		tblDesc.add(getMin_hospital_rankCDesc(tblDesc));
		tblDesc.add(getMin_doctor_rankCDesc(tblDesc));
		tblDesc.add(getFg_add_insurCDesc(tblDesc));
		tblDesc.add(getFg_add_insur_salCDesc(tblDesc));
		tblDesc.add(getFg_bidding_drugCDesc(tblDesc));
		tblDesc.add(getPrice_biddingCDesc(tblDesc));
		tblDesc.add(getFg_spec_drugCDesc(tblDesc));
		tblDesc.add(getFg_two_insurpayCDesc(tblDesc));
		tblDesc.add(getPharm_firm_nameCDesc(tblDesc));
		tblDesc.add(getEmp_handleCDesc(tblDesc));
		tblDesc.add(getDt_handleCDesc(tblDesc));
		tblDesc.add(getPrc_direc_codeCDesc(tblDesc));
		tblDesc.add(getReference_priceCDesc(tblDesc));
		tblDesc.add(getReference_hospitalCDesc(tblDesc));
		tblDesc.add(getOrigin_placeCDesc(tblDesc));
		tblDesc.add(getFg_prc_b_druglistCDesc(tblDesc));
		tblDesc.add(getFg_resident_useCDesc(tblDesc));
		tblDesc.add(getSex_limit_payCDesc(tblDesc));
		tblDesc.add(getDisease_limit_payCDesc(tblDesc));
		tblDesc.add(getFg_prc_druglistCDesc(tblDesc));
		tblDesc.add(getMax_use_daysCDesc(tblDesc));
		tblDesc.add(getRetire_ey_pri_maxCDesc(tblDesc));
		tblDesc.add(getRate_self_oepCDesc(tblDesc));
		tblDesc.add(getRate_self_ipCDesc(tblDesc));
		tblDesc.add(getRate_retireCDesc(tblDesc));
		tblDesc.add(getRate_injuryCDesc(tblDesc));
		tblDesc.add(getRate_birthCDesc(tblDesc));
		tblDesc.add(getRate_eyCDesc(tblDesc));
		tblDesc.add(getRate_unitCDesc(tblDesc));
		tblDesc.add(getRate_familyCDesc(tblDesc));
		tblDesc.add(getRate_import_diffCDesc(tblDesc));
		tblDesc.add(getDesCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 药品主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_drugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_drug",  getId_drugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("药品主键");
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
		attrDesc.setRefType(false);
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
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医保系统属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_misADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mis",  getId_misCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医保系统");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 医疗机构编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHospital_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Hospital_code",  getHospital_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医疗机构编码");
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
	private IAttrDesc getCodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code",  getCodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 商品名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name",  getNameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("商品名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 通用名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_genericADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_generic",  getName_genericCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("通用名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 英文名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_englishADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_english",  getName_englishCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("英文名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 药品种类属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDrug_typeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Drug_type",  getDrug_typeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("药品种类");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 收费类别编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_cateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_cate",  getCode_cateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("收费类别编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 收费等级属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_feelevelADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_feelevel",  getEu_feelevelCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("收费等级");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 价格属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPriceADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Price",  getPriceCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("价格");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 单价支付上限属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPri_maxADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pri_max",  getPri_maxCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("单价支付上限");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 药品等级属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDrug_gradeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Drug_grade",  getDrug_gradeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("药品等级");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 国药准字属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAppnoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Appno",  getAppnoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("国药准字");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 有效标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_effectiveADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_effective",  getFg_effectiveCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("有效标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 拼音码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPycodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pycode",  getPycodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("拼音码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 五笔码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWbcodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Wbcode",  getWbcodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("五笔码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 开始时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_bADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_b",  getDt_bCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("开始时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 结束时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_eADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_e",  getDt_eCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("结束时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 限制报销条件属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getLimit_factorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Limit_factor",  getLimit_factorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("限制报销条件");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 通用名称拼音码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPycode_genericADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pycode_generic",  getPycode_genericCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("通用名称拼音码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 通用名称五笔码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWbcode_genericADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Wbcode_generic",  getWbcode_genericCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("通用名称五笔码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 通用名称自定义属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getZdycode_genericADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Zdycode_generic",  getZdycode_genericCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("通用名称自定义");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 药品剂量单位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDose_unitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dose_unit",  getDose_unitCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("药品剂量单位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 剂型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDosageADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dosage",  getDosageCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("剂型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 每次用量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSingle_doseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Single_dose",  getSingle_doseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("每次用量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 使用频次属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFreqADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Freq",  getFreqCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("使用频次");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 用法属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getUsageADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Usage",  getUsageCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用法");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 规格属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSpecADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Spec",  getSpecCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("规格");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 单位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getUnitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Unit",  getUnitCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("单位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 先付限价属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_prepay_maxADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_prepay_max",  getAmt_prepay_maxCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("先付限价");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 院内制剂标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_prep_selfADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_prep_self",  getFg_prep_selfCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("院内制剂标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 需要审批标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_approveADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_approve",  getFg_approveCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("需要审批标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 处方药标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_octADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_oct",  getFg_octCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("处方药标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 最小医院等级属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMin_hospital_rankADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Min_hospital_rank",  getMin_hospital_rankCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("最小医院等级");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 最小医师等级属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMin_doctor_rankADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Min_doctor_rank",  getMin_doctor_rankCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("最小医师等级");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 自理补费进入统筹标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_add_insurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_add_insur",  getFg_add_insurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("自理补费进入统筹标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 自理补费进入救助医疗标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_add_insur_salADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_add_insur_sal",  getFg_add_insur_salCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("自理补费进入救助医疗标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 招标药品标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_bidding_drugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_bidding_drug",  getFg_bidding_drugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("招标药品标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 招标价格属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPrice_biddingADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Price_bidding",  getPrice_biddingCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("招标价格");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 特药标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_spec_drugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_spec_drug",  getFg_spec_drugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("特药标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 二次报销标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_two_insurpayADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_two_insurpay",  getFg_two_insurpayCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("二次报销标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 药厂名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPharm_firm_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pharm_firm_name",  getPharm_firm_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("药厂名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 经办人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEmp_handleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Emp_handle",  getEmp_handleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("经办人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 经办日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_handleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_handle",  getDt_handleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("经办日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 国家目录编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPrc_direc_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Prc_direc_code",  getPrc_direc_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("国家目录编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 参考价格属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getReference_priceADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Reference_price",  getReference_priceCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("参考价格");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 参考医院属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getReference_hospitalADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Reference_hospital",  getReference_hospitalCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("参考医院");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 产地属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOrigin_placeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Origin_place",  getOrigin_placeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("产地");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 国家基本药品目录基层卫生医疗机构用药标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_prc_b_druglistADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_prc_b_druglist",  getFg_prc_b_druglistCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("国家基本药品目录基层卫生医疗机构用药标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 居民使用标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_resident_useADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_resident_use",  getFg_resident_useCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("居民使用标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 性别限定支付范围属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSex_limit_payADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sex_limit_pay",  getSex_limit_payCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("性别限定支付范围");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 疾病限定支付范围属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDisease_limit_payADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Disease_limit_pay",  getDisease_limit_payCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("疾病限定支付范围");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 国家基本药品目录标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_prc_druglistADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_prc_druglist",  getFg_prc_druglistCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("国家基本药品目录标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 限定天数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMax_use_daysADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Max_use_days",  getMax_use_daysCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("限定天数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 离休二乙最高限价属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRetire_ey_pri_maxADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Retire_ey_pri_max",  getRetire_ey_pri_maxCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("离休二乙最高限价");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 普通门诊自付比例属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRate_self_oepADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Rate_self_oep",  getRate_self_oepCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("普通门诊自付比例");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 住院自付比例属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRate_self_ipADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Rate_self_ip",  getRate_self_ipCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("住院自付比例");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 离休自付比例属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRate_retireADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Rate_retire",  getRate_retireCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("离休自付比例");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 工伤自付比例属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRate_injuryADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Rate_injury",  getRate_injuryCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("工伤自付比例");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 生育自付比例属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRate_birthADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Rate_birth",  getRate_birthCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("生育自付比例");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 二乙自付比例属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRate_eyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Rate_ey",  getRate_eyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("二乙自付比例");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 单位自付比例属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRate_unitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Rate_unit",  getRate_unitCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("单位自付比例");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 家属子女学生自付比例属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRate_familyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Rate_family",  getRate_familyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("家属子女学生自付比例");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 进口差价自付比例属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRate_import_diffADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Rate_import_diff",  getRate_import_diffCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("进口差价自付比例");
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
	private IAttrDesc getDesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Des",  getDesCDesc(tblDesc), this);
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
	 * 医保系统名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMis_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mis_name",  getMis_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医保系统名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"MI_BD_MIS a0b2","id_mis=id_mis","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取药品主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_drugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_drug");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("药品主键"); 
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
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("所属组织"); 
		return column;
	}
	/**
	 * 获取医保系统表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_misCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mis");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医保系统"); 
		return column;
	}
	/**
	 * 获取医疗机构编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHospital_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Hospital_code");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医疗机构编码"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取商品名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name");
		column.setLength(512);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("商品名"); 
		return column;
	}
	/**
	 * 获取通用名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_genericCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_generic");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("通用名称"); 
		return column;
	}
	/**
	 * 获取英文名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_englishCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_english");
		column.setLength(512);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("英文名称"); 
		return column;
	}
	/**
	 * 获取药品种类表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDrug_typeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Drug_type");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("药品种类"); 
		return column;
	}
	/**
	 * 获取收费类别编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_cateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_cate");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("收费类别编码"); 
		return column;
	}
	/**
	 * 获取收费等级表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_feelevelCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_feelevel");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("收费等级"); 
		return column;
	}
	/**
	 * 获取价格表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPriceCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Price");
		column.setLength(10);
        column.setPrecision(4);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("价格"); 
		return column;
	}
	/**
	 * 获取单价支付上限表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPri_maxCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pri_max");
		column.setLength(10);
        column.setPrecision(4);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("单价支付上限"); 
		return column;
	}
	/**
	 * 获取药品等级表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDrug_gradeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Drug_grade");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("药品等级"); 
		return column;
	}
	/**
	 * 获取国药准字表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAppnoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Appno");
		column.setLength(512);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("国药准字"); 
		return column;
	}
	/**
	 * 获取有效标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_effectiveCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_effective");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("有效标志"); 
		return column;
	}
	/**
	 * 获取拼音码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPycodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pycode");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("拼音码"); 
		return column;
	}
	/**
	 * 获取五笔码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWbcodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Wbcode");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("五笔码"); 
		return column;
	}
	/**
	 * 获取开始时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_bCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_b");
		column.setLength(19);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("开始时间"); 
		return column;
	}
	/**
	 * 获取结束时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_eCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_e");
		column.setLength(19);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("结束时间"); 
		return column;
	}
	/**
	 * 获取限制报销条件表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getLimit_factorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Limit_factor");
		column.setLength(512);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("限制报销条件"); 
		return column;
	}
	/**
	 * 获取通用名称拼音码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPycode_genericCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pycode_generic");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("通用名称拼音码"); 
		return column;
	}
	/**
	 * 获取通用名称五笔码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWbcode_genericCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Wbcode_generic");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("通用名称五笔码"); 
		return column;
	}
	/**
	 * 获取通用名称自定义表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getZdycode_genericCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Zdycode_generic");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("通用名称自定义"); 
		return column;
	}
	/**
	 * 获取药品剂量单位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDose_unitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dose_unit");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("药品剂量单位"); 
		return column;
	}
	/**
	 * 获取剂型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDosageCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dosage");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("剂型"); 
		return column;
	}
	/**
	 * 获取每次用量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSingle_doseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Single_dose");
		column.setLength(15);
        column.setPrecision(8);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("每次用量"); 
		return column;
	}
	/**
	 * 获取使用频次表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFreqCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Freq");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("使用频次"); 
		return column;
	}
	/**
	 * 获取用法表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getUsageCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Usage");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("用法"); 
		return column;
	}
	/**
	 * 获取规格表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSpecCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Spec");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("规格"); 
		return column;
	}
	/**
	 * 获取单位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getUnitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Unit");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("单位"); 
		return column;
	}
	/**
	 * 获取先付限价表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_prepay_maxCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_prepay_max");
		column.setLength(10);
        column.setPrecision(4);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("先付限价"); 
		return column;
	}
	/**
	 * 获取院内制剂标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_prep_selfCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_prep_self");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("院内制剂标识"); 
		return column;
	}
	/**
	 * 获取需要审批标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_approveCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_approve");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("需要审批标识"); 
		return column;
	}
	/**
	 * 获取处方药标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_octCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_oct");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("处方药标识"); 
		return column;
	}
	/**
	 * 获取最小医院等级表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMin_hospital_rankCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Min_hospital_rank");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("最小医院等级"); 
		return column;
	}
	/**
	 * 获取最小医师等级表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMin_doctor_rankCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Min_doctor_rank");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("最小医师等级"); 
		return column;
	}
	/**
	 * 获取自理补费进入统筹标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_add_insurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_add_insur");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("自理补费进入统筹标识"); 
		return column;
	}
	/**
	 * 获取自理补费进入救助医疗标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_add_insur_salCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_add_insur_sal");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("自理补费进入救助医疗标识"); 
		return column;
	}
	/**
	 * 获取招标药品标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_bidding_drugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_bidding_drug");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("招标药品标识"); 
		return column;
	}
	/**
	 * 获取招标价格表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPrice_biddingCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Price_bidding");
		column.setLength(10);
        column.setPrecision(4);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("招标价格"); 
		return column;
	}
	/**
	 * 获取特药标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_spec_drugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_spec_drug");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("特药标志"); 
		return column;
	}
	/**
	 * 获取二次报销标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_two_insurpayCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_two_insurpay");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("二次报销标识"); 
		return column;
	}
	/**
	 * 获取药厂名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPharm_firm_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pharm_firm_name");
		column.setLength(512);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("药厂名称"); 
		return column;
	}
	/**
	 * 获取经办人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEmp_handleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Emp_handle");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("经办人"); 
		return column;
	}
	/**
	 * 获取经办日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_handleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_handle");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("经办日期"); 
		return column;
	}
	/**
	 * 获取国家目录编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPrc_direc_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Prc_direc_code");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("国家目录编码"); 
		return column;
	}
	/**
	 * 获取参考价格表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getReference_priceCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Reference_price");
		column.setLength(10);
        column.setPrecision(4);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("参考价格"); 
		return column;
	}
	/**
	 * 获取参考医院表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getReference_hospitalCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Reference_hospital");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("参考医院"); 
		return column;
	}
	/**
	 * 获取产地表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOrigin_placeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Origin_place");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("产地"); 
		return column;
	}
	/**
	 * 获取国家基本药品目录基层卫生医疗机构用药标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_prc_b_druglistCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_prc_b_druglist");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("国家基本药品目录基层卫生医疗机构用药标识"); 
		return column;
	}
	/**
	 * 获取居民使用标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_resident_useCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_resident_use");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("居民使用标志"); 
		return column;
	}
	/**
	 * 获取性别限定支付范围表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSex_limit_payCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sex_limit_pay");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("性别限定支付范围"); 
		return column;
	}
	/**
	 * 获取疾病限定支付范围表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDisease_limit_payCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Disease_limit_pay");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("疾病限定支付范围"); 
		return column;
	}
	/**
	 * 获取国家基本药品目录标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_prc_druglistCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_prc_druglist");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("国家基本药品目录标志"); 
		return column;
	}
	/**
	 * 获取限定天数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMax_use_daysCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Max_use_days");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("限定天数"); 
		return column;
	}
	/**
	 * 获取离休二乙最高限价表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRetire_ey_pri_maxCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Retire_ey_pri_max");
		column.setLength(10);
        column.setPrecision(4);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("离休二乙最高限价"); 
		return column;
	}
	/**
	 * 获取普通门诊自付比例表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRate_self_oepCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Rate_self_oep");
		column.setLength(15);
        column.setPrecision(8);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("普通门诊自付比例"); 
		return column;
	}
	/**
	 * 获取住院自付比例表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRate_self_ipCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Rate_self_ip");
		column.setLength(10);
        column.setPrecision(4);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("住院自付比例"); 
		return column;
	}
	/**
	 * 获取离休自付比例表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRate_retireCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Rate_retire");
		column.setLength(10);
        column.setPrecision(4);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("离休自付比例"); 
		return column;
	}
	/**
	 * 获取工伤自付比例表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRate_injuryCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Rate_injury");
		column.setLength(10);
        column.setPrecision(4);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("工伤自付比例"); 
		return column;
	}
	/**
	 * 获取生育自付比例表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRate_birthCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Rate_birth");
		column.setLength(10);
        column.setPrecision(4);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("生育自付比例"); 
		return column;
	}
	/**
	 * 获取二乙自付比例表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRate_eyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Rate_ey");
		column.setLength(10);
        column.setPrecision(4);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("二乙自付比例"); 
		return column;
	}
	/**
	 * 获取单位自付比例表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRate_unitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Rate_unit");
		column.setLength(10);
        column.setPrecision(4);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("单位自付比例"); 
		return column;
	}
	/**
	 * 获取家属子女学生自付比例表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRate_familyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Rate_family");
		column.setLength(10);
        column.setPrecision(4);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("家属子女学生自付比例"); 
		return column;
	}
	/**
	 * 获取进口差价自付比例表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRate_import_diffCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Rate_import_diff");
		column.setLength(10);
        column.setPrecision(4);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("进口差价自付比例"); 
		return column;
	}
	/**
	 * 获取备注表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Des");
		column.setLength(512);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备注"); 
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
	 * 获取医保系统名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMis_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mis_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医保系统名称"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id","Id_drug");
		iBDDataInfoFldMap.put("id_org","Id_org");
		iBDDataInfoFldMap.put("code","Code");
		iBDDataInfoFldMap.put("name","Name");
		iBDDataInfoFldMap.put("id_group","Id_grp");
		iBDDataInfoFldMap.put("pycode","Pycode");
		iBDDataInfoFldMap.put("wbcode","Wbcode");
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
