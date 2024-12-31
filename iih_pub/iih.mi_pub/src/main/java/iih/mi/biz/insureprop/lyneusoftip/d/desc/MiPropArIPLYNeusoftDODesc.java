
package iih.mi.biz.insureprop.lyneusoftip.d.desc;

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
 * 临沂住院医保分摊 DO 元数据信息
 */
public class MiPropArIPLYNeusoftDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.mi.biz.insureprop.lyneusoftip.d.MiPropArIPLYNeusoftDO";
	public static final String CLASS_DISPALYNAME = "临沂住院医保分摊";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "mi_prop_arip_lyneusoft";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_propar_lyneusoft";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public MiPropArIPLYNeusoftDODesc(){
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
		this.setKeyDesc(getId_propar_lyneusoftADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_propar_lyneusoftADesc(tblDesc));
		this.add(getCode_hospADesc(tblDesc));
		this.add(getPersoncodeADesc(tblDesc));
		this.add(getCode_entADesc(tblDesc));
		this.add(getCode_billADesc(tblDesc));
		this.add(getTradetpADesc(tblDesc));
		this.add(getCode_hisADesc(tblDesc));
		this.add(getCode_hpADesc(tblDesc));
		this.add(getAmt_allADesc(tblDesc));
		this.add(getAmt_psnADesc(tblDesc));
		this.add(getAmt_hpADesc(tblDesc));
		this.add(getAmt_seriousillADesc(tblDesc));
		this.add(getAmt_civilserviceADesc(tblDesc));
		this.add(getAmt_enterprisesuppADesc(tblDesc));
		this.add(getAmt_cashADesc(tblDesc));
		this.add(getAmt_selfpayADesc(tblDesc));
		this.add(getAmt_ypzlADesc(tblDesc));
		this.add(getAmt_xmzlADesc(tblDesc));
		this.add(getAmt_tjtzzlADesc(tblDesc));
		this.add(getAmt_execrxselfADesc(tblDesc));
		this.add(getAmt_deductiblepayselfADesc(tblDesc));
		this.add(getAmt_inhpADesc(tblDesc));
		this.add(getAmt_hpsegselfADesc(tblDesc));
		this.add(getAmt_incivilADesc(tblDesc));
		this.add(getAmt_civilselfpayADesc(tblDesc));
		this.add(getAmt_overtopselfADesc(tblDesc));
		this.add(getAmt_baseallADesc(tblDesc));
		this.add(getAmt_paystandADesc(tblDesc));
		this.add(getIp_timesADesc(tblDesc));
		this.add(getAmt_bigillcomplefundADesc(tblDesc));
		this.add(getAmt_inbigillcompleADesc(tblDesc));
		this.add(getAmt_emfundADesc(tblDesc));
		this.add(getAmt_transferADesc(tblDesc));
		this.add(getAmt_fiscalADesc(tblDesc));
		this.add(getAmt_retirplanADesc(tblDesc));
		this.add(getAmt_oepplanADesc(tblDesc));
		this.add(getAmt_inpplanADesc(tblDesc));
		this.add(getTradenoADesc(tblDesc));
		this.add(getTrade_refnoADesc(tblDesc));
		this.add(getTrade_posnoADesc(tblDesc));
		this.add(getTrade_orgindateADesc(tblDesc));
		this.add(getTrade_succfgADesc(tblDesc));
		this.add(getBanknoADesc(tblDesc));
		this.add(getAmt_civilhelpADesc(tblDesc));
		this.add(getAmt_civilbighelpADesc(tblDesc));
		this.add(getAmt_busicompleADesc(tblDesc));
		this.add(getAmt_orgreducADesc(tblDesc));
		this.add(getAmt_officersupplyADesc(tblDesc));
		this.add(getAmt_overlimitselfADesc(tblDesc));
		this.add(getAmt_overlimithosADesc(tblDesc));
		this.add(getLast_hpchargetotalADesc(tblDesc));
		this.add(getLast_largetotalADesc(tblDesc));
		this.add(getTjgb_civilsubsidyADesc(tblDesc));
		this.add(getWifeofmaleworker_nameADesc(tblDesc));
		this.add(getAreacodeADesc(tblDesc));
		this.add(getAmt_incomplemediADesc(tblDesc));
		this.add(getAmt_speccompleADesc(tblDesc));
		this.add(getExaminebear_feeADesc(tblDesc));
		this.add(getAmt_inbigillcompleallADesc(tblDesc));
		this.add(getAmt_bigillcomplefundallADesc(tblDesc));
		this.add(getAmt_hosloadADesc(tblDesc));
		this.add(getId_proparipADesc(tblDesc));
		this.add(getId_hpADesc(tblDesc));
		this.add(getCode_medkindADesc(tblDesc));
		this.add(getDi_codeADesc(tblDesc));
		this.add(getDi_nameADesc(tblDesc));
		this.add(getCode_hppatcaADesc(tblDesc));
		this.add(getCompanycodeADesc(tblDesc));
		this.add(getCompanynameADesc(tblDesc));
		this.add(getSpecneed_flagADesc(tblDesc));
		this.add(getCivil_flagADesc(tblDesc));
		this.add(getAllo_stsheetADesc(tblDesc));
		this.add(getAmt_specialhpADesc(tblDesc));
		this.add(getAmt_specialsubsidyADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_propar_lyneusoftCDesc(tblDesc));
		tblDesc.add(getId_propar_lyneusoftCDesc(tblDesc));
		tblDesc.add(getCode_hospCDesc(tblDesc));
		tblDesc.add(getPersoncodeCDesc(tblDesc));
		tblDesc.add(getCode_entCDesc(tblDesc));
		tblDesc.add(getCode_billCDesc(tblDesc));
		tblDesc.add(getTradetpCDesc(tblDesc));
		tblDesc.add(getCode_hisCDesc(tblDesc));
		tblDesc.add(getCode_hpCDesc(tblDesc));
		tblDesc.add(getAmt_allCDesc(tblDesc));
		tblDesc.add(getAmt_psnCDesc(tblDesc));
		tblDesc.add(getAmt_hpCDesc(tblDesc));
		tblDesc.add(getAmt_seriousillCDesc(tblDesc));
		tblDesc.add(getAmt_civilserviceCDesc(tblDesc));
		tblDesc.add(getAmt_enterprisesuppCDesc(tblDesc));
		tblDesc.add(getAmt_cashCDesc(tblDesc));
		tblDesc.add(getAmt_selfpayCDesc(tblDesc));
		tblDesc.add(getAmt_ypzlCDesc(tblDesc));
		tblDesc.add(getAmt_xmzlCDesc(tblDesc));
		tblDesc.add(getAmt_tjtzzlCDesc(tblDesc));
		tblDesc.add(getAmt_execrxselfCDesc(tblDesc));
		tblDesc.add(getAmt_deductiblepayselfCDesc(tblDesc));
		tblDesc.add(getAmt_inhpCDesc(tblDesc));
		tblDesc.add(getAmt_hpsegselfCDesc(tblDesc));
		tblDesc.add(getAmt_incivilCDesc(tblDesc));
		tblDesc.add(getAmt_civilselfpayCDesc(tblDesc));
		tblDesc.add(getAmt_overtopselfCDesc(tblDesc));
		tblDesc.add(getAmt_baseallCDesc(tblDesc));
		tblDesc.add(getAmt_paystandCDesc(tblDesc));
		tblDesc.add(getIp_timesCDesc(tblDesc));
		tblDesc.add(getAmt_bigillcomplefundCDesc(tblDesc));
		tblDesc.add(getAmt_inbigillcompleCDesc(tblDesc));
		tblDesc.add(getAmt_emfundCDesc(tblDesc));
		tblDesc.add(getAmt_transferCDesc(tblDesc));
		tblDesc.add(getAmt_fiscalCDesc(tblDesc));
		tblDesc.add(getAmt_retirplanCDesc(tblDesc));
		tblDesc.add(getAmt_oepplanCDesc(tblDesc));
		tblDesc.add(getAmt_inpplanCDesc(tblDesc));
		tblDesc.add(getTradenoCDesc(tblDesc));
		tblDesc.add(getTrade_refnoCDesc(tblDesc));
		tblDesc.add(getTrade_posnoCDesc(tblDesc));
		tblDesc.add(getTrade_orgindateCDesc(tblDesc));
		tblDesc.add(getTrade_succfgCDesc(tblDesc));
		tblDesc.add(getBanknoCDesc(tblDesc));
		tblDesc.add(getAmt_civilhelpCDesc(tblDesc));
		tblDesc.add(getAmt_civilbighelpCDesc(tblDesc));
		tblDesc.add(getAmt_busicompleCDesc(tblDesc));
		tblDesc.add(getAmt_orgreducCDesc(tblDesc));
		tblDesc.add(getAmt_officersupplyCDesc(tblDesc));
		tblDesc.add(getAmt_overlimitselfCDesc(tblDesc));
		tblDesc.add(getAmt_overlimithosCDesc(tblDesc));
		tblDesc.add(getLast_hpchargetotalCDesc(tblDesc));
		tblDesc.add(getLast_largetotalCDesc(tblDesc));
		tblDesc.add(getTjgb_civilsubsidyCDesc(tblDesc));
		tblDesc.add(getWifeofmaleworker_nameCDesc(tblDesc));
		tblDesc.add(getAreacodeCDesc(tblDesc));
		tblDesc.add(getAmt_incomplemediCDesc(tblDesc));
		tblDesc.add(getAmt_speccompleCDesc(tblDesc));
		tblDesc.add(getExaminebear_feeCDesc(tblDesc));
		tblDesc.add(getAmt_inbigillcompleallCDesc(tblDesc));
		tblDesc.add(getAmt_bigillcomplefundallCDesc(tblDesc));
		tblDesc.add(getAmt_hosloadCDesc(tblDesc));
		tblDesc.add(getId_proparipCDesc(tblDesc));
		tblDesc.add(getId_hpCDesc(tblDesc));
		tblDesc.add(getCode_medkindCDesc(tblDesc));
		tblDesc.add(getDi_codeCDesc(tblDesc));
		tblDesc.add(getDi_nameCDesc(tblDesc));
		tblDesc.add(getCode_hppatcaCDesc(tblDesc));
		tblDesc.add(getCompanycodeCDesc(tblDesc));
		tblDesc.add(getCompanynameCDesc(tblDesc));
		tblDesc.add(getSpecneed_flagCDesc(tblDesc));
		tblDesc.add(getCivil_flagCDesc(tblDesc));
		tblDesc.add(getAllo_stsheetCDesc(tblDesc));
		tblDesc.add(getAmt_specialhpCDesc(tblDesc));
		tblDesc.add(getAmt_specialsubsidyCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 应收扩展表主键ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_propar_lyneusoftADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_propar_lyneusoft",  getId_propar_lyneusoftCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("应收扩展表主键ID");
		attrDesc.setNullable(false);
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
	private IAttrDesc getCode_hospADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_hosp",  getCode_hospCDesc(tblDesc), this);
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
	 * 医保个人编号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPersoncodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Personcode",  getPersoncodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医保个人编号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 门诊住院流水号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_entADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_ent",  getCode_entCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("门诊住院流水号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 单据号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_billADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_bill",  getCode_billCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("单据号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 交易类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTradetpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Tradetp",  getTradetpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("交易类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医院交易流水号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_hisADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_his",  getCode_hisCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医院交易流水号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 中心交易流水号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_hpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_hp",  getCode_hpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("中心交易流水号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 总费用属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_allADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_all",  getAmt_allCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("总费用");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 本次账户支付属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_psnADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_psn",  getAmt_psnCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("本次账户支付");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 统筹支付金额属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_hpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_hp",  getAmt_hpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("统筹支付金额");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 大病救助基金支付属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_seriousillADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_seriousill",  getAmt_seriousillCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("大病救助基金支付");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 公务员补助金额属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_civilserviceADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_civilservice",  getAmt_civilserviceCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("公务员补助金额");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 企业补充基金支付属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_enterprisesuppADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_enterprisesupp",  getAmt_enterprisesuppCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("企业补充基金支付");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 本次现金支付属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_cashADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_cash",  getAmt_cashCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("本次现金支付");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 自费费用属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_selfpayADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_selfpay",  getAmt_selfpayCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("自费费用");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 乙类药品自理费用属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_ypzlADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_ypzl",  getAmt_ypzlCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("乙类药品自理费用");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 乙类项目自理费用属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_xmzlADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_xmzl",  getAmt_xmzlCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("乙类项目自理费用");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 特检特治自理属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_tjtzzlADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_tjtzzl",  getAmt_tjtzzlCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("特检特治自理");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 超出治疗方案自付金额属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_execrxselfADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_execrxself",  getAmt_execrxselfCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("超出治疗方案自付金额");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 起付标准自付金额属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_deductiblepayselfADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_deductiblepayself",  getAmt_deductiblepayselfCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("起付标准自付金额");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 进入统筹费用属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_inhpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_inhp",  getAmt_inhpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("进入统筹费用");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 统筹分段自付属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_hpsegselfADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_hpsegself",  getAmt_hpsegselfCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("统筹分段自付");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 进入救助金费用属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_incivilADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_incivil",  getAmt_incivilCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("进入救助金费用");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 救助金自付属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_civilselfpayADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_civilselfpay",  getAmt_civilselfpayCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("救助金自付");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 超大额封顶线自付属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_overtopselfADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_overtopself",  getAmt_overtopselfCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("超大额封顶线自付");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 符合基本医疗费用总额属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_baseallADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_baseall",  getAmt_baseallCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("符合基本医疗费用总额");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 一般起付标准额属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_paystandADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_paystand",  getAmt_paystandCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("一般起付标准额");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 住院次数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIp_timesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ip_times",  getIp_timesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("住院次数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 大病补充基金支付属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_bigillcomplefundADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_bigillcomplefund",  getAmt_bigillcomplefundCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("大病补充基金支付");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 进入大病补充费用属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_inbigillcompleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_inbigillcomple",  getAmt_inbigillcompleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("进入大病补充费用");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 意外伤害支付费用属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_emfundADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_emfund",  getAmt_emfundCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("意外伤害支付费用");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 转诊先自付属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_transferADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_transfer",  getAmt_transferCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("转诊先自付");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 财政支出属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_fiscalADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_fiscal",  getAmt_fiscalCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("财政支出");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 离休统筹支出属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_retirplanADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_retirplan",  getAmt_retirplanCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("离休统筹支出");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 门诊统筹支出属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_oepplanADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_oepplan",  getAmt_oepplanCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("门诊统筹支出");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 住院统筹支出属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_inpplanADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_inpplan",  getAmt_inpplanCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("住院统筹支出");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 交易索引号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTradenoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Tradeno",  getTradenoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("交易索引号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 参考号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTrade_refnoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Trade_refno",  getTrade_refnoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("参考号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * Pos机交易编号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTrade_posnoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Trade_posno",  getTrade_posnoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("Pos机交易编号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 原交易日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTrade_orgindateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Trade_orgindate",  getTrade_orgindateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("原交易日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 银行交易成功标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTrade_succfgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Trade_succfg",  getTrade_succfgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("银行交易成功标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 银行账号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBanknoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Bankno",  getBanknoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("银行账号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 民政救助支出属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_civilhelpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_civilhelp",  getAmt_civilhelpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("民政救助支出");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 民政特大救助支出属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_civilbighelpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_civilbighelp",  getAmt_civilbighelpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("民政特大救助支出");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 商业补充保险支出属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_busicompleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_busicomple",  getAmt_busicompleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("商业补充保险支出");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医疗机构减免属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_orgreducADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_orgreduc",  getAmt_orgreducCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("医疗机构减免");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 师职补助属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_officersupplyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_officersupply",  getAmt_officersupplyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("师职补助");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 超限价自付金额属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_overlimitselfADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_overlimitself",  getAmt_overlimitselfCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("超限价自付金额");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 超限价定点支付金额属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_overlimithosADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_overlimithos",  getAmt_overlimithosCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("超限价定点支付金额");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 上次统筹记账累计属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getLast_hpchargetotalADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Last_hpchargetotal",  getLast_hpchargetotalCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("上次统筹记账累计");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 上次大额累计属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getLast_largetotalADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Last_largetotal",  getLast_largetotalCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("上次大额累计");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 厅级干部公务员补助属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTjgb_civilsubsidyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Tjgb_civilsubsidy",  getTjgb_civilsubsidyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("厅级干部公务员补助");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 男职工配偶姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWifeofmaleworker_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Wifeofmaleworker_name",  getWifeofmaleworker_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("男职工配偶姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 统筹区号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAreacodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Areacode",  getAreacodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("统筹区号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 统筹部分进入补充医疗自付费用属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_incomplemediADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_incomplemedi",  getAmt_incomplemediCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("统筹部分进入补充医疗自付费用");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 特殊补充医疗报销金额属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_speccompleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_speccomple",  getAmt_speccompleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("特殊补充医疗报销金额");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 产前检查费（周口用）属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getExaminebear_feeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Examinebear_fee",  getExaminebear_feeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("产前检查费（周口用）");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 本年进入大病补充累计（不含本次）属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_inbigillcompleallADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_inbigillcompleall",  getAmt_inbigillcompleallCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("本年进入大病补充累计（不含本次）");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 本年大病补充支付累计(不含本次)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_bigillcomplefundallADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_bigillcomplefundall",  getAmt_bigillcomplefundallCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("本年大病补充支付累计(不含本次)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 定点承担金额属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_hosloadADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_hosload",  getAmt_hosloadCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("定点承担金额");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 应收主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_proparipADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_proparip",  getId_proparipCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("应收主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医保产品属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_hpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_hp",  getId_hpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医保产品");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医疗类别属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_medkindADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_medkind",  getCode_medkindCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医疗类别");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊断编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDi_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Di_code",  getDi_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断编码");
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
	private IAttrDesc getDi_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Di_name",  getDi_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医保人员身份属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_hppatcaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_hppatca",  getCode_hppatcaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医保人员身份");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 单位编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCompanycodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Companycode",  getCompanycodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("单位编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 单位名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCompanynameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Companyname",  getCompanynameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("单位名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 精准扶贫标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSpecneed_flagADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Specneed_flag",  getSpecneed_flagCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("精准扶贫标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 民政人员标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCivil_flagADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Civil_flag",  getCivil_flagCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("民政人员标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 异地结算单属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAllo_stsheetADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Allo_stsheet",  getAllo_stsheetCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("异地结算单");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 特优保支付属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_specialhpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_specialhp",  getAmt_specialhpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("特优保支付");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 特优补助支付属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_specialsubsidyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_specialsubsidy",  getAmt_specialsubsidyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("特优补助支付");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取应收扩展表主键ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_propar_lyneusoftCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_propar_lyneusoft");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("应收扩展表主键ID"); 
		return column;
	}
	/**
	 * 获取定点医疗机构编号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_hospCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_hosp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("定点医疗机构编号"); 
		return column;
	}
	/**
	 * 获取医保个人编号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPersoncodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Personcode");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医保个人编号"); 
		return column;
	}
	/**
	 * 获取门诊住院流水号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_entCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_ent");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("门诊住院流水号"); 
		return column;
	}
	/**
	 * 获取单据号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_billCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_bill");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("单据号"); 
		return column;
	}
	/**
	 * 获取交易类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTradetpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Tradetp");
		column.setLength(5);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("交易类型"); 
		return column;
	}
	/**
	 * 获取医院交易流水号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_hisCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_his");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医院交易流水号"); 
		return column;
	}
	/**
	 * 获取中心交易流水号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_hpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_hp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("中心交易流水号"); 
		return column;
	}
	/**
	 * 获取总费用表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_allCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_all");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("总费用"); 
		return column;
	}
	/**
	 * 获取本次账户支付表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_psnCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_psn");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("本次账户支付"); 
		return column;
	}
	/**
	 * 获取统筹支付金额表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_hpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_hp");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("统筹支付金额"); 
		return column;
	}
	/**
	 * 获取大病救助基金支付表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_seriousillCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_seriousill");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("大病救助基金支付"); 
		return column;
	}
	/**
	 * 获取公务员补助金额表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_civilserviceCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_civilservice");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("公务员补助金额"); 
		return column;
	}
	/**
	 * 获取企业补充基金支付表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_enterprisesuppCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_enterprisesupp");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("企业补充基金支付"); 
		return column;
	}
	/**
	 * 获取本次现金支付表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_cashCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_cash");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("本次现金支付"); 
		return column;
	}
	/**
	 * 获取自费费用表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_selfpayCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_selfpay");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("自费费用"); 
		return column;
	}
	/**
	 * 获取乙类药品自理费用表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_ypzlCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_ypzl");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("乙类药品自理费用"); 
		return column;
	}
	/**
	 * 获取乙类项目自理费用表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_xmzlCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_xmzl");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("乙类项目自理费用"); 
		return column;
	}
	/**
	 * 获取特检特治自理表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_tjtzzlCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_tjtzzl");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("特检特治自理"); 
		return column;
	}
	/**
	 * 获取超出治疗方案自付金额表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_execrxselfCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_execrxself");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("超出治疗方案自付金额"); 
		return column;
	}
	/**
	 * 获取起付标准自付金额表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_deductiblepayselfCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_deductiblepayself");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("起付标准自付金额"); 
		return column;
	}
	/**
	 * 获取进入统筹费用表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_inhpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_inhp");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("进入统筹费用"); 
		return column;
	}
	/**
	 * 获取统筹分段自付表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_hpsegselfCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_hpsegself");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("统筹分段自付"); 
		return column;
	}
	/**
	 * 获取进入救助金费用表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_incivilCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_incivil");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("进入救助金费用"); 
		return column;
	}
	/**
	 * 获取救助金自付表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_civilselfpayCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_civilselfpay");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("救助金自付"); 
		return column;
	}
	/**
	 * 获取超大额封顶线自付表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_overtopselfCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_overtopself");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("超大额封顶线自付"); 
		return column;
	}
	/**
	 * 获取符合基本医疗费用总额表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_baseallCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_baseall");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("符合基本医疗费用总额"); 
		return column;
	}
	/**
	 * 获取一般起付标准额表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_paystandCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_paystand");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("一般起付标准额"); 
		return column;
	}
	/**
	 * 获取住院次数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIp_timesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ip_times");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("住院次数"); 
		return column;
	}
	/**
	 * 获取大病补充基金支付表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_bigillcomplefundCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_bigillcomplefund");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("大病补充基金支付"); 
		return column;
	}
	/**
	 * 获取进入大病补充费用表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_inbigillcompleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_inbigillcomple");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("进入大病补充费用"); 
		return column;
	}
	/**
	 * 获取意外伤害支付费用表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_emfundCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_emfund");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("意外伤害支付费用"); 
		return column;
	}
	/**
	 * 获取转诊先自付表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_transferCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_transfer");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("转诊先自付"); 
		return column;
	}
	/**
	 * 获取财政支出表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_fiscalCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_fiscal");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("财政支出"); 
		return column;
	}
	/**
	 * 获取离休统筹支出表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_retirplanCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_retirplan");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("离休统筹支出"); 
		return column;
	}
	/**
	 * 获取门诊统筹支出表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_oepplanCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_oepplan");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("门诊统筹支出"); 
		return column;
	}
	/**
	 * 获取住院统筹支出表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_inpplanCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_inpplan");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("住院统筹支出"); 
		return column;
	}
	/**
	 * 获取交易索引号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTradenoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Tradeno");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("交易索引号"); 
		return column;
	}
	/**
	 * 获取参考号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTrade_refnoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Trade_refno");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("参考号"); 
		return column;
	}
	/**
	 * 获取Pos机交易编号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTrade_posnoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Trade_posno");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("Pos机交易编号"); 
		return column;
	}
	/**
	 * 获取原交易日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTrade_orgindateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Trade_orgindate");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("原交易日期"); 
		return column;
	}
	/**
	 * 获取银行交易成功标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTrade_succfgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Trade_succfg");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("银行交易成功标志"); 
		return column;
	}
	/**
	 * 获取银行账号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBanknoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Bankno");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("银行账号"); 
		return column;
	}
	/**
	 * 获取民政救助支出表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_civilhelpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_civilhelp");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("民政救助支出"); 
		return column;
	}
	/**
	 * 获取民政特大救助支出表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_civilbighelpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_civilbighelp");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("民政特大救助支出"); 
		return column;
	}
	/**
	 * 获取商业补充保险支出表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_busicompleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_busicomple");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("商业补充保险支出"); 
		return column;
	}
	/**
	 * 获取医疗机构减免表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_orgreducCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_orgreduc");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("医疗机构减免"); 
		return column;
	}
	/**
	 * 获取师职补助表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_officersupplyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_officersupply");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("师职补助"); 
		return column;
	}
	/**
	 * 获取超限价自付金额表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_overlimitselfCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_overlimitself");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("超限价自付金额"); 
		return column;
	}
	/**
	 * 获取超限价定点支付金额表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_overlimithosCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_overlimithos");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("超限价定点支付金额"); 
		return column;
	}
	/**
	 * 获取上次统筹记账累计表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getLast_hpchargetotalCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Last_hpchargetotal");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("上次统筹记账累计"); 
		return column;
	}
	/**
	 * 获取上次大额累计表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getLast_largetotalCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Last_largetotal");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("上次大额累计"); 
		return column;
	}
	/**
	 * 获取厅级干部公务员补助表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTjgb_civilsubsidyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Tjgb_civilsubsidy");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("厅级干部公务员补助"); 
		return column;
	}
	/**
	 * 获取男职工配偶姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWifeofmaleworker_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Wifeofmaleworker_name");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("男职工配偶姓名"); 
		return column;
	}
	/**
	 * 获取统筹区号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAreacodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Areacode");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("统筹区号"); 
		return column;
	}
	/**
	 * 获取统筹部分进入补充医疗自付费用表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_incomplemediCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_incomplemedi");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("统筹部分进入补充医疗自付费用"); 
		return column;
	}
	/**
	 * 获取特殊补充医疗报销金额表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_speccompleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_speccomple");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("特殊补充医疗报销金额"); 
		return column;
	}
	/**
	 * 获取产前检查费（周口用）表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getExaminebear_feeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Examinebear_fee");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("产前检查费（周口用）"); 
		return column;
	}
	/**
	 * 获取本年进入大病补充累计（不含本次）表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_inbigillcompleallCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_inbigillcompleall");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("本年进入大病补充累计（不含本次）"); 
		return column;
	}
	/**
	 * 获取本年大病补充支付累计(不含本次)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_bigillcomplefundallCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_bigillcomplefundall");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("本年大病补充支付累计(不含本次)"); 
		return column;
	}
	/**
	 * 获取定点承担金额表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_hosloadCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_hosload");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("定点承担金额"); 
		return column;
	}
	/**
	 * 获取应收主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_proparipCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_proparip");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("应收主键"); 
		return column;
	}
	/**
	 * 获取医保产品表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_hpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_hp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医保产品"); 
		return column;
	}
	/**
	 * 获取医疗类别表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_medkindCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_medkind");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医疗类别"); 
		return column;
	}
	/**
	 * 获取诊断编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDi_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Di_code");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断编码"); 
		return column;
	}
	/**
	 * 获取诊断名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDi_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Di_name");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断名称"); 
		return column;
	}
	/**
	 * 获取医保人员身份表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_hppatcaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_hppatca");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医保人员身份"); 
		return column;
	}
	/**
	 * 获取单位编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCompanycodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Companycode");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("单位编码"); 
		return column;
	}
	/**
	 * 获取单位名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCompanynameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Companyname");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("单位名称"); 
		return column;
	}
	/**
	 * 获取精准扶贫标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSpecneed_flagCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Specneed_flag");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("精准扶贫标志"); 
		return column;
	}
	/**
	 * 获取民政人员标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCivil_flagCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Civil_flag");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("民政人员标志"); 
		return column;
	}
	/**
	 * 获取异地结算单表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAllo_stsheetCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Allo_stsheet");
		column.setLength(0);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("异地结算单"); 
		return column;
	}
	/**
	 * 获取特优保支付表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_specialhpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_specialhp");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("特优保支付"); 
		return column;
	}
	/**
	 * 获取特优补助支付表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_specialsubsidyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_specialsubsidy");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("特优补助支付"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
	}

	/**
	 * 设置实体审计信息数据映射关系 
	 */
	private void setIAuditInfoFldMap(){
	}
	
	/**
	 * 设置实体默认值
	 */
	private void setDefaultValueMap(){
		defaultValueMap=new HashMap<String, Object>();
	}
	
}
