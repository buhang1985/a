
package iih.bd.pp.anhuiinsur.d.desc;

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
 * 安徽医保诊疗目录 DO 元数据信息
 */
public class BdHpZlOrginalDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.bd.pp.anhuiinsur.d.BdHpZlOrginalDO";
	public static final String CLASS_DISPALYNAME = "安徽医保诊疗目录";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "BD_HP_ZL_ORGINAL";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_hpzlorginal";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public BdHpZlOrginalDODesc(){
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
		this.setKeyDesc(getId_hpzlorginalADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_hpzlorginalADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_hpADesc(tblDesc));
		this.add(getPay_self_tpADesc(tblDesc));
		this.add(getStr_approveADesc(tblDesc));
		this.add(getStr_two_insurpayADesc(tblDesc));
		this.add(getStr_add_insurADesc(tblDesc));
		this.add(getStr_add_insur_salADesc(tblDesc));
		this.add(getStr_special_itmADesc(tblDesc));
		this.add(getOrigin_placeADesc(tblDesc));
		this.add(getAmt_prepay_maxADesc(tblDesc));
		this.add(getDomestic_pri_maxADesc(tblDesc));
		this.add(getStr_hospital_helpADesc(tblDesc));
		this.add(getHospital_codeADesc(tblDesc));
		this.add(getUnitADesc(tblDesc));
		this.add(getFirm_nameADesc(tblDesc));
		this.add(getId_emp_handleADesc(tblDesc));
		this.add(getDt_handleADesc(tblDesc));
		this.add(getStr_effectiveADesc(tblDesc));
		this.add(getPy_codeADesc(tblDesc));
		this.add(getWb_codeADesc(tblDesc));
		this.add(getZdy_codeADesc(tblDesc));
		this.add(getStr_prc_druglistADesc(tblDesc));
		this.add(getStr_prc_b_druglistADesc(tblDesc));
		this.add(getStr_resident_useADesc(tblDesc));
		this.add(getCodeADesc(tblDesc));
		this.add(getNameADesc(tblDesc));
		this.add(getCode_caADesc(tblDesc));
		this.add(getName_caADesc(tblDesc));
		this.add(getSd_hpsrvtpADesc(tblDesc));
		this.add(getPri_maxADesc(tblDesc));
		this.add(getRetire_ey_pri_maxADesc(tblDesc));
		this.add(getNoteADesc(tblDesc));
		this.add(getDesADesc(tblDesc));
		this.add(getDt_bADesc(tblDesc));
		this.add(getDt_eADesc(tblDesc));
		this.add(getRate_self_oepADesc(tblDesc));
		this.add(getRate_self_ipADesc(tblDesc));
		this.add(getRate_retireADesc(tblDesc));
		this.add(getRate_injuryADesc(tblDesc));
		this.add(getRate_birthADesc(tblDesc));
		this.add(getRate_eyADesc(tblDesc));
		this.add(getRate_unitADesc(tblDesc));
		this.add(getRate_familyADesc(tblDesc));
		this.add(getRate_import_diffADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getOrdernoADesc(tblDesc));
		this.add(getUndrugno_dmiADesc(tblDesc));
		this.add(getPri_eyADesc(tblDesc));
		this.add(getPri_max_cityADesc(tblDesc));
		this.add(getPri_max_countyADesc(tblDesc));
		this.add(getPri_belowcounyADesc(tblDesc));
		this.add(getPri_retireADesc(tblDesc));
		this.add(getRate_resiADesc(tblDesc));
		this.add(getRate_army_oepADesc(tblDesc));
		this.add(getRate_army_ipADesc(tblDesc));
		this.add(getFg_injuryADesc(tblDesc));
		this.add(getFg_birthADesc(tblDesc));
		this.add(getFg_basemedicADesc(tblDesc));
		this.add(getHospital_rankADesc(tblDesc));
		this.add(getDt_self_bADesc(tblDesc));
		this.add(getDt_self_eADesc(tblDesc));
		this.add(new DsAttr(dsColumn,this));
		this.add(new SvAttr(svColumn,this));
		
	}
		
	/**
	 * 获得表元数据
	 * @return
	 */
	private ITableDesc getTableDesc(){
		TableDesc tblDesc=new TableDesc(TABLE_NAME,TABLE_ALIAS_NAME);
		tblDesc.setLabel(CLASS_DISPALYNAME);
		tblDesc.setPrimaryKey(getId_hpzlorginalCDesc(tblDesc));
		tblDesc.add(getId_hpzlorginalCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_hpCDesc(tblDesc));
		tblDesc.add(getPay_self_tpCDesc(tblDesc));
		tblDesc.add(getStr_approveCDesc(tblDesc));
		tblDesc.add(getStr_two_insurpayCDesc(tblDesc));
		tblDesc.add(getStr_add_insurCDesc(tblDesc));
		tblDesc.add(getStr_add_insur_salCDesc(tblDesc));
		tblDesc.add(getStr_special_itmCDesc(tblDesc));
		tblDesc.add(getOrigin_placeCDesc(tblDesc));
		tblDesc.add(getAmt_prepay_maxCDesc(tblDesc));
		tblDesc.add(getDomestic_pri_maxCDesc(tblDesc));
		tblDesc.add(getStr_hospital_helpCDesc(tblDesc));
		tblDesc.add(getHospital_codeCDesc(tblDesc));
		tblDesc.add(getUnitCDesc(tblDesc));
		tblDesc.add(getFirm_nameCDesc(tblDesc));
		tblDesc.add(getId_emp_handleCDesc(tblDesc));
		tblDesc.add(getDt_handleCDesc(tblDesc));
		tblDesc.add(getStr_effectiveCDesc(tblDesc));
		tblDesc.add(getPy_codeCDesc(tblDesc));
		tblDesc.add(getWb_codeCDesc(tblDesc));
		tblDesc.add(getZdy_codeCDesc(tblDesc));
		tblDesc.add(getStr_prc_druglistCDesc(tblDesc));
		tblDesc.add(getStr_prc_b_druglistCDesc(tblDesc));
		tblDesc.add(getStr_resident_useCDesc(tblDesc));
		tblDesc.add(getCodeCDesc(tblDesc));
		tblDesc.add(getNameCDesc(tblDesc));
		tblDesc.add(getCode_caCDesc(tblDesc));
		tblDesc.add(getName_caCDesc(tblDesc));
		tblDesc.add(getSd_hpsrvtpCDesc(tblDesc));
		tblDesc.add(getPri_maxCDesc(tblDesc));
		tblDesc.add(getRetire_ey_pri_maxCDesc(tblDesc));
		tblDesc.add(getNoteCDesc(tblDesc));
		tblDesc.add(getDesCDesc(tblDesc));
		tblDesc.add(getDt_bCDesc(tblDesc));
		tblDesc.add(getDt_eCDesc(tblDesc));
		tblDesc.add(getRate_self_oepCDesc(tblDesc));
		tblDesc.add(getRate_self_ipCDesc(tblDesc));
		tblDesc.add(getRate_retireCDesc(tblDesc));
		tblDesc.add(getRate_injuryCDesc(tblDesc));
		tblDesc.add(getRate_birthCDesc(tblDesc));
		tblDesc.add(getRate_eyCDesc(tblDesc));
		tblDesc.add(getRate_unitCDesc(tblDesc));
		tblDesc.add(getRate_familyCDesc(tblDesc));
		tblDesc.add(getRate_import_diffCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		tblDesc.add(getOrdernoCDesc(tblDesc));
		tblDesc.add(getUndrugno_dmiCDesc(tblDesc));
		tblDesc.add(getPri_eyCDesc(tblDesc));
		tblDesc.add(getPri_max_cityCDesc(tblDesc));
		tblDesc.add(getPri_max_countyCDesc(tblDesc));
		tblDesc.add(getPri_belowcounyCDesc(tblDesc));
		tblDesc.add(getPri_retireCDesc(tblDesc));
		tblDesc.add(getRate_resiCDesc(tblDesc));
		tblDesc.add(getRate_army_oepCDesc(tblDesc));
		tblDesc.add(getRate_army_ipCDesc(tblDesc));
		tblDesc.add(getFg_injuryCDesc(tblDesc));
		tblDesc.add(getFg_birthCDesc(tblDesc));
		tblDesc.add(getFg_basemedicCDesc(tblDesc));
		tblDesc.add(getHospital_rankCDesc(tblDesc));
		tblDesc.add(getDt_self_bCDesc(tblDesc));
		tblDesc.add(getDt_self_eCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 医保计划服务诊疗原始主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_hpzlorginalADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_hpzlorginal",  getId_hpzlorginalCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医保计划服务诊疗原始主键");
		attrDesc.setNullable(true);
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
	 * 医保计划属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_hpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_hp",  getId_hpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医保计划");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setExtTag("BDMODE,URC");
		attrDesc.setRefType(true);
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
	 * 是否需要审批标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getStr_approveADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Str_approve",  getStr_approveCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("是否需要审批标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否二次报销属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getStr_two_insurpayADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Str_two_insurpay",  getStr_two_insurpayCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("是否二次报销");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 自理部分进入统筹标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getStr_add_insurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Str_add_insur",  getStr_add_insurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("自理部分进入统筹标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 自理部分进入救助医疗标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getStr_add_insur_salADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Str_add_insur_sal",  getStr_add_insur_salCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("自理部分进入救助医疗标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 特检特制标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getStr_special_itmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Str_special_itm",  getStr_special_itmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("特检特制标志");
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
	 * 医院帮定标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getStr_hospital_helpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Str_hospital_help",  getStr_hospital_helpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医院帮定标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 定点医疗机构编号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHospital_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Hospital_code",  getHospital_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("定点医疗机构编号");
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
	private IAttrDesc getId_emp_handleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_handle",  getId_emp_handleCDesc(tblDesc), this);
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
	private IAttrDesc getStr_effectiveADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Str_effective",  getStr_effectiveCDesc(tblDesc), this);
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
	private IAttrDesc getPy_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Py_code",  getPy_codeCDesc(tblDesc), this);
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
	private IAttrDesc getWb_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Wb_code",  getWb_codeCDesc(tblDesc), this);
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
	private IAttrDesc getZdy_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Zdy_code",  getZdy_codeCDesc(tblDesc), this);
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
	 * 国家基本药品目录标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getStr_prc_druglistADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Str_prc_druglist",  getStr_prc_druglistCDesc(tblDesc), this);
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
	 * 国家基本药品目录基层卫生机构用药标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getStr_prc_b_druglistADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Str_prc_b_druglist",  getStr_prc_b_druglistCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("国家基本药品目录基层卫生机构用药标志");
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
	private IAttrDesc getStr_resident_useADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Str_resident_use",  getStr_resident_useCDesc(tblDesc), this);
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
	 * 项目编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code",  getCodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("项目编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setExtTag("BDMODE,URC");
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 项目名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name",  getNameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("项目名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setExtTag("BDMODE,URC");
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 费用类别编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_caADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_ca",  getCode_caCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("费用类别编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 费用类别名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_caADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_ca",  getName_caCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("费用类别名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 收费项目等级属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_hpsrvtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_hpsrvtp",  getSd_hpsrvtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("收费项目等级");
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
	 * 备注属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNoteADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Note",  getNoteCDesc(tblDesc), this);
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
	 * 限制报销条件属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Des",  getDesCDesc(tblDesc), this);
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
	 * 序号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOrdernoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Orderno",  getOrdernoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("序号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 定点医疗机构非药品项目编号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getUndrugno_dmiADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Undrugno_dmi",  getUndrugno_dmiCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("定点医疗机构非药品项目编号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 二乙价格属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPri_eyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pri_ey",  getPri_eyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("二乙价格");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 市级最高价格属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPri_max_cityADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pri_max_city",  getPri_max_cityCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("市级最高价格");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 县级最高价格属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPri_max_countyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pri_max_county",  getPri_max_countyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("县级最高价格");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 县级以下价格属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPri_belowcounyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pri_belowcouny",  getPri_belowcounyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("县级以下价格");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 离休价格属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPri_retireADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pri_retire",  getPri_retireCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("离休价格");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 居民自付比例属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRate_resiADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Rate_resi",  getRate_resiCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("居民自付比例");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 军休门诊自付比例属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRate_army_oepADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Rate_army_oep",  getRate_army_oepCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("军休门诊自付比例");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 军休住院自付比例属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRate_army_ipADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Rate_army_ip",  getRate_army_ipCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("军休住院自付比例");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 工伤使用标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_injuryADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_injury",  getFg_injuryCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("工伤使用标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 生育使用标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_birthADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_birth",  getFg_birthCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("生育使用标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 基本医疗使用标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_basemedicADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_basemedic",  getFg_basemedicCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("基本医疗使用标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医院等级属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHospital_rankADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Hospital_rank",  getHospital_rankCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医院等级");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 自付比例开始日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_self_bADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_self_b",  getDt_self_bCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("自付比例开始日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 自付比例结束日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_self_eADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_self_e",  getDt_self_eCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("自付比例结束日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取医保计划服务诊疗原始主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_hpzlorginalCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_hpzlorginal");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医保计划服务诊疗原始主键"); 
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
	 * 获取医保计划表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_hpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_hp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医保计划"); 
		return column;
	}
	/**
	 * 获取自付类别表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPay_self_tpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pay_self_tp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("自付类别"); 
		return column;
	}
	/**
	 * 获取是否需要审批标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getStr_approveCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Str_approve");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("是否需要审批标志"); 
		return column;
	}
	/**
	 * 获取是否二次报销表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getStr_two_insurpayCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Str_two_insurpay");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("是否二次报销"); 
		return column;
	}
	/**
	 * 获取自理部分进入统筹标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getStr_add_insurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Str_add_insur");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("自理部分进入统筹标志"); 
		return column;
	}
	/**
	 * 获取自理部分进入救助医疗标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getStr_add_insur_salCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Str_add_insur_sal");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("自理部分进入救助医疗标志"); 
		return column;
	}
	/**
	 * 获取特检特制标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getStr_special_itmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Str_special_itm");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("特检特制标志"); 
		return column;
	}
	/**
	 * 获取产地表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOrigin_placeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Origin_place");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("产地"); 
		return column;
	}
	/**
	 * 获取先付限价表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_prepay_maxCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_prepay_max");
		column.setLength(16);
        column.setPrecision(4);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("先付限价"); 
		return column;
	}
	/**
	 * 获取国产限价表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDomestic_pri_maxCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Domestic_pri_max");
		column.setLength(16);
        column.setPrecision(4);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("国产限价"); 
		return column;
	}
	/**
	 * 获取医院帮定标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getStr_hospital_helpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Str_hospital_help");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医院帮定标志"); 
		return column;
	}
	/**
	 * 获取定点医疗机构编号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHospital_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Hospital_code");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("定点医疗机构编号"); 
		return column;
	}
	/**
	 * 获取单位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getUnitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Unit");
		column.setLength(50);
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
		column.setLength(50);
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
	private IColumnDesc getId_emp_handleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_handle");
		column.setLength(50);
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
	private IColumnDesc getStr_effectiveCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Str_effective");
		column.setLength(50);
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
	private IColumnDesc getPy_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Py_code");
		column.setLength(50);
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
	private IColumnDesc getWb_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Wb_code");
		column.setLength(50);
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
	private IColumnDesc getZdy_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Zdy_code");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("自定义码"); 
		return column;
	}
	/**
	 * 获取国家基本药品目录标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getStr_prc_druglistCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Str_prc_druglist");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("国家基本药品目录标志"); 
		return column;
	}
	/**
	 * 获取国家基本药品目录基层卫生机构用药标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getStr_prc_b_druglistCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Str_prc_b_druglist");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("国家基本药品目录基层卫生机构用药标志"); 
		return column;
	}
	/**
	 * 获取居民使用标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getStr_resident_useCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Str_resident_use");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("居民使用标志"); 
		return column;
	}
	/**
	 * 获取项目编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("项目编码"); 
		return column;
	}
	/**
	 * 获取项目名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("项目名称"); 
		return column;
	}
	/**
	 * 获取费用类别编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_caCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_ca");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("费用类别编码"); 
		return column;
	}
	/**
	 * 获取费用类别名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_caCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_ca");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("费用类别名称"); 
		return column;
	}
	/**
	 * 获取收费项目等级表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_hpsrvtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_hpsrvtp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("收费项目等级"); 
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
	 * 获取离休二乙最高限价表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRetire_ey_pri_maxCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Retire_ey_pri_max");
		column.setLength(16);
        column.setPrecision(4);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("离休二乙最高限价"); 
		return column;
	}
	/**
	 * 获取备注表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNoteCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Note");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备注"); 
		return column;
	}
	/**
	 * 获取限制报销条件表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Des");
		column.setLength(256);
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
	 * 获取序号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOrdernoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Orderno");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("序号"); 
		return column;
	}
	/**
	 * 获取定点医疗机构非药品项目编号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getUndrugno_dmiCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Undrugno_dmi");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("定点医疗机构非药品项目编号"); 
		return column;
	}
	/**
	 * 获取二乙价格表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPri_eyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pri_ey");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("二乙价格"); 
		return column;
	}
	/**
	 * 获取市级最高价格表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPri_max_cityCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pri_max_city");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("市级最高价格"); 
		return column;
	}
	/**
	 * 获取县级最高价格表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPri_max_countyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pri_max_county");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("县级最高价格"); 
		return column;
	}
	/**
	 * 获取县级以下价格表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPri_belowcounyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pri_belowcouny");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("县级以下价格"); 
		return column;
	}
	/**
	 * 获取离休价格表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPri_retireCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pri_retire");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("离休价格"); 
		return column;
	}
	/**
	 * 获取居民自付比例表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRate_resiCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Rate_resi");
		column.setLength(10);
        column.setPrecision(4);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("居民自付比例"); 
		return column;
	}
	/**
	 * 获取军休门诊自付比例表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRate_army_oepCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Rate_army_oep");
		column.setLength(10);
        column.setPrecision(4);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("军休门诊自付比例"); 
		return column;
	}
	/**
	 * 获取军休住院自付比例表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRate_army_ipCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Rate_army_ip");
		column.setLength(10);
        column.setPrecision(4);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("军休住院自付比例"); 
		return column;
	}
	/**
	 * 获取工伤使用标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_injuryCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_injury");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("工伤使用标志"); 
		return column;
	}
	/**
	 * 获取生育使用标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_birthCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_birth");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("生育使用标志"); 
		return column;
	}
	/**
	 * 获取基本医疗使用标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_basemedicCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_basemedic");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("基本医疗使用标志"); 
		return column;
	}
	/**
	 * 获取医院等级表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHospital_rankCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Hospital_rank");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医院等级"); 
		return column;
	}
	/**
	 * 获取自付比例开始日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_self_bCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_self_b");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("自付比例开始日期"); 
		return column;
	}
	/**
	 * 获取自付比例结束日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_self_eCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_self_e");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("自付比例结束日期"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id","Id_hpzlorginal");
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
