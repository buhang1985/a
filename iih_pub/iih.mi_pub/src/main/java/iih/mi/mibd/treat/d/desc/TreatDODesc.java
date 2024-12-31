
package iih.mi.mibd.treat.d.desc;

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
 * 诊疗项目 DO 元数据信息
 */
public class TreatDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.mi.mibd.treat.d.TreatDO";
	public static final String CLASS_DISPALYNAME = "诊疗项目";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "MI_BD_TREAT";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_treat";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public TreatDODesc(){
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
		this.setKeyDesc(getId_treatADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_treatADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_misADesc(tblDesc));
		this.add(getCodeADesc(tblDesc));
		this.add(getNameADesc(tblDesc));
		this.add(getCode_cateADesc(tblDesc));
		this.add(getEu_feelevelADesc(tblDesc));
		this.add(getPri_maxADesc(tblDesc));
		this.add(getPay_self_tpADesc(tblDesc));
		this.add(getFg_approveADesc(tblDesc));
		this.add(getFg_two_insurpayADesc(tblDesc));
		this.add(getFg_add_insurADesc(tblDesc));
		this.add(getFg_add_insur_salADesc(tblDesc));
		this.add(getFg_special_itmADesc(tblDesc));
		this.add(getOrigin_placeADesc(tblDesc));
		this.add(getDomestic_pri_maxADesc(tblDesc));
		this.add(getFg_hospital_helpADesc(tblDesc));
		this.add(getFg_prc_druglistADesc(tblDesc));
		this.add(getFg_prc_b_druglistADesc(tblDesc));
		this.add(getFg_resident_useADesc(tblDesc));
		this.add(getRate_self_oepADesc(tblDesc));
		this.add(getRate_self_ipADesc(tblDesc));
		this.add(getRate_retireADesc(tblDesc));
		this.add(getRate_injuryADesc(tblDesc));
		this.add(getRate_birthADesc(tblDesc));
		this.add(getRate_eyADesc(tblDesc));
		this.add(getRate_unitADesc(tblDesc));
		this.add(getRate_familyADesc(tblDesc));
		this.add(getRate_import_diffADesc(tblDesc));
		this.add(getRetire_ey_pri_maxADesc(tblDesc));
		this.add(getAmt_prepay_maxADesc(tblDesc));
		this.add(getHospital_codeADesc(tblDesc));
		this.add(getUnitADesc(tblDesc));
		this.add(getFirm_nameADesc(tblDesc));
		this.add(getEmp_handleADesc(tblDesc));
		this.add(getDt_handleADesc(tblDesc));
		this.add(getFg_effectiveADesc(tblDesc));
		this.add(getPycodeADesc(tblDesc));
		this.add(getWbcodeADesc(tblDesc));
		this.add(getZdycodeADesc(tblDesc));
		this.add(getLimit_factorADesc(tblDesc));
		this.add(getDt_bADesc(tblDesc));
		this.add(getDt_eADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_treatCDesc(tblDesc));
		tblDesc.add(getId_treatCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_misCDesc(tblDesc));
		tblDesc.add(getCodeCDesc(tblDesc));
		tblDesc.add(getNameCDesc(tblDesc));
		tblDesc.add(getCode_cateCDesc(tblDesc));
		tblDesc.add(getEu_feelevelCDesc(tblDesc));
		tblDesc.add(getPri_maxCDesc(tblDesc));
		tblDesc.add(getPay_self_tpCDesc(tblDesc));
		tblDesc.add(getFg_approveCDesc(tblDesc));
		tblDesc.add(getFg_two_insurpayCDesc(tblDesc));
		tblDesc.add(getFg_add_insurCDesc(tblDesc));
		tblDesc.add(getFg_add_insur_salCDesc(tblDesc));
		tblDesc.add(getFg_special_itmCDesc(tblDesc));
		tblDesc.add(getOrigin_placeCDesc(tblDesc));
		tblDesc.add(getDomestic_pri_maxCDesc(tblDesc));
		tblDesc.add(getFg_hospital_helpCDesc(tblDesc));
		tblDesc.add(getFg_prc_druglistCDesc(tblDesc));
		tblDesc.add(getFg_prc_b_druglistCDesc(tblDesc));
		tblDesc.add(getFg_resident_useCDesc(tblDesc));
		tblDesc.add(getRate_self_oepCDesc(tblDesc));
		tblDesc.add(getRate_self_ipCDesc(tblDesc));
		tblDesc.add(getRate_retireCDesc(tblDesc));
		tblDesc.add(getRate_injuryCDesc(tblDesc));
		tblDesc.add(getRate_birthCDesc(tblDesc));
		tblDesc.add(getRate_eyCDesc(tblDesc));
		tblDesc.add(getRate_unitCDesc(tblDesc));
		tblDesc.add(getRate_familyCDesc(tblDesc));
		tblDesc.add(getRate_import_diffCDesc(tblDesc));
		tblDesc.add(getRetire_ey_pri_maxCDesc(tblDesc));
		tblDesc.add(getAmt_prepay_maxCDesc(tblDesc));
		tblDesc.add(getHospital_codeCDesc(tblDesc));
		tblDesc.add(getUnitCDesc(tblDesc));
		tblDesc.add(getFirm_nameCDesc(tblDesc));
		tblDesc.add(getEmp_handleCDesc(tblDesc));
		tblDesc.add(getDt_handleCDesc(tblDesc));
		tblDesc.add(getFg_effectiveCDesc(tblDesc));
		tblDesc.add(getPycodeCDesc(tblDesc));
		tblDesc.add(getWbcodeCDesc(tblDesc));
		tblDesc.add(getZdycodeCDesc(tblDesc));
		tblDesc.add(getLimit_factorCDesc(tblDesc));
		tblDesc.add(getDt_bCDesc(tblDesc));
		tblDesc.add(getDt_eCDesc(tblDesc));
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
	 * 诊疗项目主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_treatADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_treat",  getId_treatCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊疗项目主键");
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
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name",  getNameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
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
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("收费等级");
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
	 * 自付类别属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPay_self_tpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pay_self_tp",  getPay_self_tpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("自付类别");
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
	 * 特检特制标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_special_itmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_special_itm",  getFg_special_itmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("特检特制标识");
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
	 * 国产限价属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDomestic_pri_maxADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Domestic_pri_max",  getDomestic_pri_maxCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("国产限价");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医院帮定标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_hospital_helpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_hospital_help",  getFg_hospital_helpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医院帮定标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 国家基本药品目录标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_prc_druglistADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_prc_druglist",  getFg_prc_druglistCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("国家基本药品目录标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 国家基本药品目录基层卫生机构用药标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_prc_b_druglistADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_prc_b_druglist",  getFg_prc_b_druglistCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("国家基本药品目录基层卫生机构用药标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 居民使用标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_resident_useADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_resident_use",  getFg_resident_useCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("居民使用标识");
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
	 * 定点医疗机构编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHospital_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Hospital_code",  getHospital_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("定点医疗机构编码");
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
	 * 生产厂家属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFirm_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Firm_name",  getFirm_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("生产厂家");
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
	 * 自定义码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getZdycodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Zdycode",  getZdycodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("自定义码");
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
		attrDesc.setRefTblInfos(new String[]{"MI_BD_MIS a0b4","id_mis=id_mis","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取诊疗项目主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_treatCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_treat");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊疗项目主键"); 
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
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
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
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("收费等级"); 
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
	 * 获取自付类别表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPay_self_tpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pay_self_tp");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("自付类别"); 
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
	 * 获取特检特制标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_special_itmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_special_itm");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("特检特制标识"); 
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
	 * 获取国产限价表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDomestic_pri_maxCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Domestic_pri_max");
		column.setLength(10);
        column.setPrecision(4);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("国产限价"); 
		return column;
	}
	/**
	 * 获取医院帮定标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_hospital_helpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_hospital_help");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医院帮定标识"); 
		return column;
	}
	/**
	 * 获取国家基本药品目录标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_prc_druglistCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_prc_druglist");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("国家基本药品目录标识"); 
		return column;
	}
	/**
	 * 获取国家基本药品目录基层卫生机构用药标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_prc_b_druglistCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_prc_b_druglist");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("国家基本药品目录基层卫生机构用药标识"); 
		return column;
	}
	/**
	 * 获取居民使用标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_resident_useCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_resident_use");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("居民使用标识"); 
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
	 * 获取定点医疗机构编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHospital_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Hospital_code");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("定点医疗机构编码"); 
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
	 * 获取生产厂家表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFirm_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Firm_name");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("生产厂家"); 
		return column;
	}
	/**
	 * 获取经办人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEmp_handleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Emp_handle");
		column.setLength(200);
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
	 * 获取自定义码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getZdycodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Zdycode");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("自定义码"); 
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
	 * 获取开始时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_bCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_b");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
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
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("结束时间"); 
		return column;
	}
	/**
	 * 获取备注表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Des");
		column.setLength(300);
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
		iBDDataInfoFldMap.put("id","Id_treat");
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
