
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
 * 医保诊断目录 DO 元数据信息
 */
public class BdHpDiOrginalDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.bd.pp.anhuiinsur.d.BdHpDiOrginalDO";
	public static final String CLASS_DISPALYNAME = "医保诊断目录";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "BD_HP_DI_ORGINAL";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_hpdiorginal";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public BdHpDiOrginalDODesc(){
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
		this.setKeyDesc(getId_hpdiorginalADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_hpdiorginalADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_hpADesc(tblDesc));
		this.add(getId_hpdiADesc(tblDesc));
		this.add(getNameADesc(tblDesc));
		this.add(getCodeADesc(tblDesc));
		this.add(getClassific_diADesc(tblDesc));
		this.add(getStr_di_specADesc(tblDesc));
		this.add(getStr_di_payADesc(tblDesc));
		this.add(getClassific_di_specADesc(tblDesc));
		this.add(getStr_treatment_planADesc(tblDesc));
		this.add(getPay_maxADesc(tblDesc));
		this.add(getTr_bind_deductibleADesc(tblDesc));
		this.add(getPay_small_45_oepADesc(tblDesc));
		this.add(getPay_big_45_oepADesc(tblDesc));
		this.add(getPay_small_45_ipADesc(tblDesc));
		this.add(getPay_big_45_ipADesc(tblDesc));
		this.add(getPay_retire_oepADesc(tblDesc));
		this.add(getPay_retire_ipADesc(tblDesc));
		this.add(getAmt_amount_diseaseADesc(tblDesc));
		this.add(getPy_codeADesc(tblDesc));
		this.add(getWb_codeADesc(tblDesc));
		this.add(getZdy_codeADesc(tblDesc));
		this.add(getStr_effectiveADesc(tblDesc));
		this.add(getId_emp_handleADesc(tblDesc));
		this.add(getDt_handleADesc(tblDesc));
		this.add(getNoteADesc(tblDesc));
		this.add(getPay_mx_small_45oepADesc(tblDesc));
		this.add(getPay_mx_big_45oepADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getOrdernoADesc(tblDesc));
		this.add(getDrugno_dmiADesc(tblDesc));
		this.add(getFg_injuryADesc(tblDesc));
		this.add(getFg_birthADesc(tblDesc));
		this.add(getFg_basemedicADesc(tblDesc));
		this.add(getHospital_rankADesc(tblDesc));
		this.add(getDt_bADesc(tblDesc));
		this.add(getDt_eADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_hpdiorginalCDesc(tblDesc));
		tblDesc.add(getId_hpdiorginalCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_hpCDesc(tblDesc));
		tblDesc.add(getId_hpdiCDesc(tblDesc));
		tblDesc.add(getNameCDesc(tblDesc));
		tblDesc.add(getCodeCDesc(tblDesc));
		tblDesc.add(getClassific_diCDesc(tblDesc));
		tblDesc.add(getStr_di_specCDesc(tblDesc));
		tblDesc.add(getStr_di_payCDesc(tblDesc));
		tblDesc.add(getClassific_di_specCDesc(tblDesc));
		tblDesc.add(getStr_treatment_planCDesc(tblDesc));
		tblDesc.add(getPay_maxCDesc(tblDesc));
		tblDesc.add(getTr_bind_deductibleCDesc(tblDesc));
		tblDesc.add(getPay_small_45_oepCDesc(tblDesc));
		tblDesc.add(getPay_big_45_oepCDesc(tblDesc));
		tblDesc.add(getPay_small_45_ipCDesc(tblDesc));
		tblDesc.add(getPay_big_45_ipCDesc(tblDesc));
		tblDesc.add(getPay_retire_oepCDesc(tblDesc));
		tblDesc.add(getPay_retire_ipCDesc(tblDesc));
		tblDesc.add(getAmt_amount_diseaseCDesc(tblDesc));
		tblDesc.add(getPy_codeCDesc(tblDesc));
		tblDesc.add(getWb_codeCDesc(tblDesc));
		tblDesc.add(getZdy_codeCDesc(tblDesc));
		tblDesc.add(getStr_effectiveCDesc(tblDesc));
		tblDesc.add(getId_emp_handleCDesc(tblDesc));
		tblDesc.add(getDt_handleCDesc(tblDesc));
		tblDesc.add(getNoteCDesc(tblDesc));
		tblDesc.add(getPay_mx_small_45oepCDesc(tblDesc));
		tblDesc.add(getPay_mx_big_45oepCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		tblDesc.add(getOrdernoCDesc(tblDesc));
		tblDesc.add(getDrugno_dmiCDesc(tblDesc));
		tblDesc.add(getFg_injuryCDesc(tblDesc));
		tblDesc.add(getFg_birthCDesc(tblDesc));
		tblDesc.add(getFg_basemedicCDesc(tblDesc));
		tblDesc.add(getHospital_rankCDesc(tblDesc));
		tblDesc.add(getDt_bCDesc(tblDesc));
		tblDesc.add(getDt_eCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 医保原始诊断主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_hpdiorginalADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_hpdiorginal",  getId_hpdiorginalCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医保原始诊断主键");
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
	 * 医保诊断id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_hpdiADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_hpdi",  getId_hpdiCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医保诊断id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 疾病名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name",  getNameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("疾病名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setExtTag("BDMODE,URC");
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 疾病编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code",  getCodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("疾病编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setExtTag("BDMODE,URC");
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 病种分类属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getClassific_diADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Classific_di",  getClassific_diCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病种分类");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 特殊病病种标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getStr_di_specADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Str_di_spec",  getStr_di_specCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("特殊病病种标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 病种报销标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getStr_di_payADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Str_di_pay",  getStr_di_payCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病种报销标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 特病分类属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getClassific_di_specADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Classific_di_spec",  getClassific_di_specCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("特病分类");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否使用治疗方案属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getStr_treatment_planADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Str_treatment_plan",  getStr_treatment_planCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("是否使用治疗方案");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 基金最高支付标准属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPay_maxADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pay_max",  getPay_maxCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("基金最高支付标准");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 绑定起付标准标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTr_bind_deductibleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Tr_bind_deductible",  getTr_bind_deductibleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("绑定起付标准标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 45岁以下在职门诊起付标准属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPay_small_45_oepADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pay_small_45_oep",  getPay_small_45_oepCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("45岁以下在职门诊起付标准");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 45岁以上在职门诊起付标准属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPay_big_45_oepADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pay_big_45_oep",  getPay_big_45_oepCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("45岁以上在职门诊起付标准");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 45岁以下在职住院起付标准属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPay_small_45_ipADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pay_small_45_ip",  getPay_small_45_ipCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("45岁以下在职住院起付标准");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 45岁以上在职住院起付标准属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPay_big_45_ipADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pay_big_45_ip",  getPay_big_45_ipCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("45岁以上在职住院起付标准");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 退休门诊起付标准属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPay_retire_oepADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pay_retire_oep",  getPay_retire_oepCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("退休门诊起付标准");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 退休住院起付标准属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPay_retire_ipADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pay_retire_ip",  getPay_retire_ipCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("退休住院起付标准");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 多病种累加金额属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_amount_diseaseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_amount_disease",  getAmt_amount_diseaseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("多病种累加金额");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 拼音助记码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPy_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Py_code",  getPy_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("拼音助记码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 五笔助记码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWb_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Wb_code",  getWb_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("五笔助记码");
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
	 * 经办时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_handleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_handle",  getDt_handleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("经办时间");
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
	 * 45岁以下在职门诊慢性病基金(或进入基金)支付限额属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPay_mx_small_45oepADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pay_mx_small_45oep",  getPay_mx_small_45oepCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("45岁以下在职门诊慢性病基金(或进入基金)支付限额");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 45岁以上在职门诊慢性病基金(或进入基金)支付限额属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPay_mx_big_45oepADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pay_mx_big_45oep",  getPay_mx_big_45oepCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("45岁以上在职门诊慢性病基金(或进入基金)支付限额");
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
	 * 定点医疗机构药品编号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDrugno_dmiADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Drugno_dmi",  getDrugno_dmiCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("定点医疗机构药品编号");
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
	 * 终止时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_eADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_e",  getDt_eCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("终止时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取医保原始诊断主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_hpdiorginalCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_hpdiorginal");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("医保原始诊断主键"); 
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
	 * 获取医保诊断id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_hpdiCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_hpdi");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医保诊断id"); 
		return column;
	}
	/**
	 * 获取疾病名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name");
		column.setLength(256);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("疾病名称"); 
		return column;
	}
	/**
	 * 获取疾病编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("疾病编码"); 
		return column;
	}
	/**
	 * 获取病种分类表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getClassific_diCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Classific_di");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病种分类"); 
		return column;
	}
	/**
	 * 获取特殊病病种标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getStr_di_specCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Str_di_spec");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("特殊病病种标志"); 
		return column;
	}
	/**
	 * 获取病种报销标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getStr_di_payCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Str_di_pay");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病种报销标志"); 
		return column;
	}
	/**
	 * 获取特病分类表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getClassific_di_specCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Classific_di_spec");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("特病分类"); 
		return column;
	}
	/**
	 * 获取是否使用治疗方案表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getStr_treatment_planCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Str_treatment_plan");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("是否使用治疗方案"); 
		return column;
	}
	/**
	 * 获取基金最高支付标准表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPay_maxCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pay_max");
		column.setLength(16);
        column.setPrecision(4);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("基金最高支付标准"); 
		return column;
	}
	/**
	 * 获取绑定起付标准标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTr_bind_deductibleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Tr_bind_deductible");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("绑定起付标准标志"); 
		return column;
	}
	/**
	 * 获取45岁以下在职门诊起付标准表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPay_small_45_oepCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pay_small_45_oep");
		column.setLength(16);
        column.setPrecision(4);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("45岁以下在职门诊起付标准"); 
		return column;
	}
	/**
	 * 获取45岁以上在职门诊起付标准表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPay_big_45_oepCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pay_big_45_oep");
		column.setLength(16);
        column.setPrecision(4);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("45岁以上在职门诊起付标准"); 
		return column;
	}
	/**
	 * 获取45岁以下在职住院起付标准表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPay_small_45_ipCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pay_small_45_ip");
		column.setLength(16);
        column.setPrecision(4);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("45岁以下在职住院起付标准"); 
		return column;
	}
	/**
	 * 获取45岁以上在职住院起付标准表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPay_big_45_ipCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pay_big_45_ip");
		column.setLength(16);
        column.setPrecision(4);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("45岁以上在职住院起付标准"); 
		return column;
	}
	/**
	 * 获取退休门诊起付标准表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPay_retire_oepCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pay_retire_oep");
		column.setLength(16);
        column.setPrecision(4);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("退休门诊起付标准"); 
		return column;
	}
	/**
	 * 获取退休住院起付标准表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPay_retire_ipCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pay_retire_ip");
		column.setLength(16);
        column.setPrecision(4);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("退休住院起付标准"); 
		return column;
	}
	/**
	 * 获取多病种累加金额表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_amount_diseaseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_amount_disease");
		column.setLength(16);
        column.setPrecision(4);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("多病种累加金额"); 
		return column;
	}
	/**
	 * 获取拼音助记码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPy_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Py_code");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("拼音助记码"); 
		return column;
	}
	/**
	 * 获取五笔助记码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWb_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Wb_code");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("五笔助记码"); 
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
	 * 获取经办时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_handleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_handle");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("经办时间"); 
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
	 * 获取45岁以下在职门诊慢性病基金(或进入基金)支付限额表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPay_mx_small_45oepCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pay_mx_small_45oep");
		column.setLength(16);
        column.setPrecision(4);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("45岁以下在职门诊慢性病基金(或进入基金)支付限额"); 
		return column;
	}
	/**
	 * 获取45岁以上在职门诊慢性病基金(或进入基金)支付限额表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPay_mx_big_45oepCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pay_mx_big_45oep");
		column.setLength(16);
        column.setPrecision(4);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("45岁以上在职门诊慢性病基金(或进入基金)支付限额"); 
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
	 * 获取定点医疗机构药品编号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDrugno_dmiCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Drugno_dmi");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("定点医疗机构药品编号"); 
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
	 * 获取终止时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_eCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_e");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("终止时间"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id","Id_hpdiorginal");
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
