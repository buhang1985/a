
package iih.bl.pay.blpaypat.d.desc;

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
 * 预交金_患者 DO 元数据信息
 */
public class BlPrePayPatDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.bl.pay.blpaypat.d.BlPrePayPatDO";
	public static final String CLASS_DISPALYNAME = "预交金_患者";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "bl_prepay_pat";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_paypat";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public BlPrePayPatDODesc(){
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
		this.setKeyDesc(getId_paypatADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_paypatADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_paytpADesc(tblDesc));
		this.add(getSd_paytpADesc(tblDesc));
		this.add(getId_patADesc(tblDesc));
		this.add(getId_enttpADesc(tblDesc));
		this.add(getCode_enttpADesc(tblDesc));
		this.add(getId_entADesc(tblDesc));
		this.add(getEu_directADesc(tblDesc));
		this.add(getAmtADesc(tblDesc));
		this.add(getAmt_retADesc(tblDesc));
		this.add(getId_pttpADesc(tblDesc));
		this.add(getSd_pttpADesc(tblDesc));
		this.add(getId_pmADesc(tblDesc));
		this.add(getSd_pmADesc(tblDesc));
		this.add(getId_bankADesc(tblDesc));
		this.add(getBanknoADesc(tblDesc));
		this.add(getPaymodenodeADesc(tblDesc));
		this.add(getDt_payADesc(tblDesc));
		this.add(getId_org_payADesc(tblDesc));
		this.add(getId_dep_payADesc(tblDesc));
		this.add(getId_emp_payADesc(tblDesc));
		this.add(getFg_ccADesc(tblDesc));
		this.add(getId_ccADesc(tblDesc));
		this.add(getId_inccaADesc(tblDesc));
		this.add(getCode_inccaADesc(tblDesc));
		this.add(getCode_repADesc(tblDesc));
		this.add(getFg_rep_returnADesc(tblDesc));
		this.add(getId_rep_lostADesc(tblDesc));
		this.add(getSd_rep_lostADesc(tblDesc));
		this.add(getDt_returnADesc(tblDesc));
		this.add(getId_emp_returnADesc(tblDesc));
		this.add(getId_parADesc(tblDesc));
		this.add(getId_st_midADesc(tblDesc));
		this.add(getFg_cancADesc(tblDesc));
		this.add(getId_emp_cancADesc(tblDesc));
		this.add(getDt_cancADesc(tblDesc));
		this.add(getNoteADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getTradenoADesc(tblDesc));
		this.add(getAcc_nameADesc(tblDesc));
		this.add(getFg_refund_manualADesc(tblDesc));
		this.add(getBankcardnoADesc(tblDesc));
		this.add(getGrp_codeADesc(tblDesc));
		this.add(getGrp_nameADesc(tblDesc));
		this.add(getOrg_codeADesc(tblDesc));
		this.add(getOrg_nameADesc(tblDesc));
		this.add(getPaytpcodeADesc(tblDesc));
		this.add(getPaytpnameADesc(tblDesc));
		this.add(getPatcodeADesc(tblDesc));
		this.add(getPatnameADesc(tblDesc));
		this.add(getEnttpcodeADesc(tblDesc));
		this.add(getEnttpnameADesc(tblDesc));
		this.add(getPaymodecodeADesc(tblDesc));
		this.add(getPaymodenameADesc(tblDesc));
		this.add(getBank_codeADesc(tblDesc));
		this.add(getBank_nameADesc(tblDesc));
		this.add(getDeptpaycodeADesc(tblDesc));
		this.add(getDeptpaynameADesc(tblDesc));
		this.add(getEmp_codeADesc(tblDesc));
		this.add(getEmp_nameADesc(tblDesc));
		this.add(getInccacodeADesc(tblDesc));
		this.add(getInccanameADesc(tblDesc));
		this.add(getRep_codeADesc(tblDesc));
		this.add(getRep_nameADesc(tblDesc));
		this.add(getEmpr_codeADesc(tblDesc));
		this.add(getEmpr_nameADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_paypatCDesc(tblDesc));
		tblDesc.add(getId_paypatCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_paytpCDesc(tblDesc));
		tblDesc.add(getSd_paytpCDesc(tblDesc));
		tblDesc.add(getId_patCDesc(tblDesc));
		tblDesc.add(getId_enttpCDesc(tblDesc));
		tblDesc.add(getCode_enttpCDesc(tblDesc));
		tblDesc.add(getId_entCDesc(tblDesc));
		tblDesc.add(getEu_directCDesc(tblDesc));
		tblDesc.add(getAmtCDesc(tblDesc));
		tblDesc.add(getAmt_retCDesc(tblDesc));
		tblDesc.add(getId_pttpCDesc(tblDesc));
		tblDesc.add(getSd_pttpCDesc(tblDesc));
		tblDesc.add(getId_pmCDesc(tblDesc));
		tblDesc.add(getSd_pmCDesc(tblDesc));
		tblDesc.add(getId_bankCDesc(tblDesc));
		tblDesc.add(getBanknoCDesc(tblDesc));
		tblDesc.add(getPaymodenodeCDesc(tblDesc));
		tblDesc.add(getDt_payCDesc(tblDesc));
		tblDesc.add(getId_org_payCDesc(tblDesc));
		tblDesc.add(getId_dep_payCDesc(tblDesc));
		tblDesc.add(getId_emp_payCDesc(tblDesc));
		tblDesc.add(getFg_ccCDesc(tblDesc));
		tblDesc.add(getId_ccCDesc(tblDesc));
		tblDesc.add(getId_inccaCDesc(tblDesc));
		tblDesc.add(getCode_inccaCDesc(tblDesc));
		tblDesc.add(getCode_repCDesc(tblDesc));
		tblDesc.add(getFg_rep_returnCDesc(tblDesc));
		tblDesc.add(getId_rep_lostCDesc(tblDesc));
		tblDesc.add(getSd_rep_lostCDesc(tblDesc));
		tblDesc.add(getDt_returnCDesc(tblDesc));
		tblDesc.add(getId_emp_returnCDesc(tblDesc));
		tblDesc.add(getId_parCDesc(tblDesc));
		tblDesc.add(getId_st_midCDesc(tblDesc));
		tblDesc.add(getFg_cancCDesc(tblDesc));
		tblDesc.add(getId_emp_cancCDesc(tblDesc));
		tblDesc.add(getDt_cancCDesc(tblDesc));
		tblDesc.add(getNoteCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		tblDesc.add(getTradenoCDesc(tblDesc));
		tblDesc.add(getAcc_nameCDesc(tblDesc));
		tblDesc.add(getFg_refund_manualCDesc(tblDesc));
		tblDesc.add(getBankcardnoCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 患者收付款主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_paypatADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_paypat",  getId_paypatCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者收付款主键");
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
	 * 患者收付款类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_paytpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_paytp",  getId_paytpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者收付款类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 患者收付款类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_paytpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_paytp",  getSd_paytpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者收付款类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_patADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pat",  getId_patCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 就诊类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_enttpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_enttp",  getId_enttpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("就诊类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 就诊类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_enttpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_enttp",  getCode_enttpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("就诊类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 就诊属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_entADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ent",  getId_entCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("就诊");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 收退款方向属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_directADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_direct",  getEu_directCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("收退款方向");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 收退款金额属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmtADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt",  getAmtCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("收退款金额");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 已退金额属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_retADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_ret",  getAmt_retCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("已退金额");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 收付款终端类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pttpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pttp",  getId_pttpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("收付款终端类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 收付款终端类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_pttpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_pttp",  getSd_pttpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("收付款终端类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 收付款方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pm",  getId_pmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("收付款方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 收付款方式编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_pmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_pm",  getSd_pmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("收付款方式编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 银行属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_bankADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_bank",  getId_bankCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("银行");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 银行卡号(外部交易号)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBanknoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Bankno",  getBanknoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("银行卡号(外部交易号)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 收款方信息属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPaymodenodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Paymodenode",  getPaymodenodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("收款方信息");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 收付款日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_payADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_pay",  getDt_payCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("收付款日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 收付款机构属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_org_payADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_org_pay",  getId_org_payCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("收付款机构");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 收付款部门属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dep_payADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep_pay",  getId_dep_payCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("收付款部门");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 收款人员属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_payADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_pay",  getId_emp_payCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("收款人员");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 结账标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_ccADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_cc",  getFg_ccCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("结账标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 操作员结账属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ccADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_cc",  getId_ccCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("操作员结账");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 票据分类属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_inccaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_incca",  getId_inccaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("票据分类");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 票据分类编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_inccaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_incca",  getCode_inccaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("票据分类编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 收据编号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_repADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_rep",  getCode_repCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("收据编号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 原收据收回标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_rep_returnADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_rep_return",  getFg_rep_returnCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("原收据收回标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 未收回原收据原因属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_rep_lostADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_rep_lost",  getId_rep_lostCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("未收回原收据原因");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 未收回原收据原因编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_rep_lostADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_rep_lost",  getSd_rep_lostCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("未收回原收据原因编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 收据收回日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_returnADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_return",  getDt_returnCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("收据收回日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 收据收回人员属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_returnADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_return",  getId_emp_returnCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("收据收回人员");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 退费时对应的收费ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_parADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_par",  getId_parCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("退费时对应的收费ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 转入预交金对应的中途结算属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_st_midADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_st_mid",  getId_st_midCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("转入预交金对应的中途结算");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 取消标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_cancADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_canc",  getFg_cancCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("取消标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 取消人员属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_cancADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_canc",  getId_emp_cancCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("取消人员");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 取消日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_cancADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_canc",  getDt_cancCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("取消日期");
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
	 * 第三方支付的交易流水号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTradenoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Tradeno",  getTradenoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("第三方支付的交易流水号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 账户名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAcc_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Acc_name",  getAcc_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("账户名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手工退账属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_refund_manualADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_refund_manual",  getFg_refund_manualCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("手工退账");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 银行卡号(真实)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBankcardnoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Bankcardno",  getBankcardnoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("银行卡号(真实)");
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
	private IAttrDesc getGrp_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Grp_code",  getGrp_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_grp a0b1","id_grp=id_grp","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getGrp_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Grp_name",  getGrp_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_grp a0b1","id_grp=id_grp","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 组织编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOrg_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Org_code",  getOrg_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("组织编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_org a0b2","id_org=id_org","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 组织名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOrg_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Org_name",  getOrg_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("组织名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_org a0b2","id_org=id_org","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPaytpcodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Paytpcode",  getPaytpcodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b3","id_paytp=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPaytpnameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Paytpname",  getPaytpnameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b3","id_paytp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPatcodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Patcode",  getPatcodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pi_pat a0b4","id_pat=id_pat","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPatnameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Patname",  getPatnameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pi_pat a0b4","id_pat=id_pat","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 就诊类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEnttpcodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Enttpcode",  getEnttpcodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("就诊类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_entp a0b5","id_enttp=id_entp","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 就诊类型名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEnttpnameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Enttpname",  getEnttpnameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("就诊类型名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_entp a0b5","id_enttp=id_entp","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPaymodecodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Paymodecode",  getPaymodecodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_pri_pm a0b7","id_pm=id_pm","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPaymodenameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Paymodename",  getPaymodenameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_pri_pm a0b7","id_pm=id_pm","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBank_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Bank_code",  getBank_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b8","id_bank=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBank_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Bank_name",  getBank_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b8","id_bank=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDeptpaycodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Deptpaycode",  getDeptpaycodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b10","id_dep_pay=id_dep","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDeptpaynameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Deptpayname",  getDeptpaynameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b10","id_dep_pay=id_dep","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 操作人员编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEmp_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Emp_code",  getEmp_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("操作人员编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b11","id_emp_pay=id_psndoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 操作人姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEmp_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Emp_name",  getEmp_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("操作人姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b11","id_emp_pay=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 票据分类编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInccacodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Inccacode",  getInccacodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("票据分类编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_incca a0b12","id_incca=id_incca","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 票据分类名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInccanameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Inccaname",  getInccanameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("票据分类名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_incca a0b12","id_incca=id_incca","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRep_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Rep_code",  getRep_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b13","id_rep_lost=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRep_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Rep_name",  getRep_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b13","id_rep_lost=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 人员编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEmpr_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Empr_code",  getEmpr_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("人员编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b14","id_emp_return=id_psndoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEmpr_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Empr_name",  getEmpr_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b14","id_emp_return=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取患者收付款主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_paypatCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_paypat");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("患者收付款主键"); 
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
	 * 获取患者收付款类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_paytpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_paytp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者收付款类型"); 
		return column;
	}
	/**
	 * 获取患者收付款类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_paytpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_paytp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者收付款类型编码"); 
		return column;
	}
	/**
	 * 获取患者表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pat");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者"); 
		return column;
	}
	/**
	 * 获取就诊类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_enttpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_enttp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊类型"); 
		return column;
	}
	/**
	 * 获取就诊类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_enttpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_enttp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊类型编码"); 
		return column;
	}
	/**
	 * 获取就诊表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_entCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ent");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊"); 
		return column;
	}
	/**
	 * 获取收退款方向表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_directCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_direct");
		column.setLength(1);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("收退款方向"); 
		return column;
	}
	/**
	 * 获取收退款金额表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmtCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt");
		column.setLength(14);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("收退款金额"); 
		return column;
	}
	/**
	 * 获取已退金额表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_retCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_ret");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("已退金额"); 
		return column;
	}
	/**
	 * 获取收付款终端类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pttpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pttp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("收付款终端类型"); 
		return column;
	}
	/**
	 * 获取收付款终端类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_pttpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_pttp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("收付款终端类型编码"); 
		return column;
	}
	/**
	 * 获取收付款方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pm");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("收付款方式"); 
		return column;
	}
	/**
	 * 获取收付款方式编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_pmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_pm");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("收付款方式编码"); 
		return column;
	}
	/**
	 * 获取银行表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_bankCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_bank");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("银行"); 
		return column;
	}
	/**
	 * 获取银行卡号(外部交易号)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBanknoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Bankno");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("银行卡号(外部交易号)"); 
		return column;
	}
	/**
	 * 获取收款方信息表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPaymodenodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Paymodenode");
		column.setLength(256);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("收款方信息"); 
		return column;
	}
	/**
	 * 获取收付款日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_payCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_pay");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("收付款日期"); 
		return column;
	}
	/**
	 * 获取收付款机构表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_org_payCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_org_pay");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("收付款机构"); 
		return column;
	}
	/**
	 * 获取收付款部门表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dep_payCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep_pay");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("收付款部门"); 
		return column;
	}
	/**
	 * 获取收款人员表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_payCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_pay");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("收款人员"); 
		return column;
	}
	/**
	 * 获取结账标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_ccCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_cc");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("结账标志"); 
		return column;
	}
	/**
	 * 获取操作员结账表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ccCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_cc");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("操作员结账"); 
		return column;
	}
	/**
	 * 获取票据分类表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_inccaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_incca");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("票据分类"); 
		return column;
	}
	/**
	 * 获取票据分类编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_inccaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_incca");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("票据分类编码"); 
		return column;
	}
	/**
	 * 获取收据编号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_repCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_rep");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("收据编号"); 
		return column;
	}
	/**
	 * 获取原收据收回标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_rep_returnCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_rep_return");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("原收据收回标志"); 
		return column;
	}
	/**
	 * 获取未收回原收据原因表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_rep_lostCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_rep_lost");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("未收回原收据原因"); 
		return column;
	}
	/**
	 * 获取未收回原收据原因编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_rep_lostCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_rep_lost");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("未收回原收据原因编码"); 
		return column;
	}
	/**
	 * 获取收据收回日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_returnCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_return");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("收据收回日期"); 
		return column;
	}
	/**
	 * 获取收据收回人员表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_returnCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_return");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("收据收回人员"); 
		return column;
	}
	/**
	 * 获取退费时对应的收费ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_parCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_par");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("退费时对应的收费ID"); 
		return column;
	}
	/**
	 * 获取转入预交金对应的中途结算表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_st_midCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_st_mid");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("转入预交金对应的中途结算"); 
		return column;
	}
	/**
	 * 获取取消标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_cancCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_canc");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("取消标志"); 
		return column;
	}
	/**
	 * 获取取消人员表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_cancCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_canc");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("取消人员"); 
		return column;
	}
	/**
	 * 获取取消日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_cancCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_canc");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("取消日期"); 
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
	 * 获取第三方支付的交易流水号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTradenoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Tradeno");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("第三方支付的交易流水号"); 
		return column;
	}
	/**
	 * 获取账户名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAcc_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Acc_name");
		column.setLength(256);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("账户名称"); 
		return column;
	}
	/**
	 * 获取手工退账表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_refund_manualCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_refund_manual");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("手工退账"); 
		return column;
	}
	/**
	 * 获取银行卡号(真实)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBankcardnoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Bankcardno");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("银行卡号(真实)"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getGrp_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Grp_code");
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
	private IColumnDesc getGrp_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Grp_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取组织编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOrg_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Org_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("组织编码"); 
		return column;
	}
	/**
	 * 获取组织名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOrg_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Org_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("组织名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPaytpcodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Paytpcode");
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
	private IColumnDesc getPaytpnameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Paytpname");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取患者编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPatcodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Patcode");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者编码"); 
		return column;
	}
	/**
	 * 获取患者姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPatnameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Patname");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者姓名"); 
		return column;
	}
	/**
	 * 获取就诊类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEnttpcodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Enttpcode");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊类型编码"); 
		return column;
	}
	/**
	 * 获取就诊类型名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEnttpnameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Enttpname");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊类型名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPaymodecodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Paymodecode");
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
	private IColumnDesc getPaymodenameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Paymodename");
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
	private IColumnDesc getBank_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Bank_code");
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
	private IColumnDesc getBank_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Bank_name");
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
	private IColumnDesc getDeptpaycodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Deptpaycode");
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
	private IColumnDesc getDeptpaynameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Deptpayname");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取操作人员编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEmp_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Emp_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("操作人员编码"); 
		return column;
	}
	/**
	 * 获取操作人姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEmp_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Emp_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("操作人姓名"); 
		return column;
	}
	/**
	 * 获取票据分类编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInccacodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Inccacode");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("票据分类编码"); 
		return column;
	}
	/**
	 * 获取票据分类名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInccanameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Inccaname");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("票据分类名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRep_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Rep_code");
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
	private IColumnDesc getRep_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Rep_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取人员编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEmpr_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Empr_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("人员编码"); 
		return column;
	}
	/**
	 * 获取姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEmpr_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Empr_name");
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
		iBDDataInfoFldMap.put("id","Id_paypat");
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
