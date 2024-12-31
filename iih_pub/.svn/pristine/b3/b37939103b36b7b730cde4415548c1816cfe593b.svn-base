
package iih.bl.itf.trdtrans.d.desc;

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
 * 第三方交易记录 DO 元数据信息
 */
public class BlThirdTransRcdDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.bl.itf.trdtrans.d.BlThirdTransRcdDO";
	public static final String CLASS_DISPALYNAME = "第三方交易记录";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "bl_trd_trans_rcd";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_transrcd";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public BlThirdTransRcdDODesc(){
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
		this.setKeyDesc(getId_transrcdADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_transrcdADesc(tblDesc));
		this.add(getId_transregADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_bizsceneADesc(tblDesc));
		this.add(getSd_bizsceneADesc(tblDesc));
		this.add(getId_patADesc(tblDesc));
		this.add(getId_entADesc(tblDesc));
		this.add(getCode_enttpADesc(tblDesc));
		this.add(getPat_cardcodeADesc(tblDesc));
		this.add(getId_payADesc(tblDesc));
		this.add(getId_pmADesc(tblDesc));
		this.add(getAmtADesc(tblDesc));
		this.add(getEu_directADesc(tblDesc));
		this.add(getEu_statusADesc(tblDesc));
		this.add(getOrder_noADesc(tblDesc));
		this.add(getSerial_noADesc(tblDesc));
		this.add(getVoucher_noADesc(tblDesc));
		this.add(getSerial_no_trdADesc(tblDesc));
		this.add(getSerial_no_ordADesc(tblDesc));
		this.add(getHos_ord_noADesc(tblDesc));
		this.add(getDigital_signADesc(tblDesc));
		this.add(getInputADesc(tblDesc));
		this.add(getOutputADesc(tblDesc));
		this.add(getId_emp_operADesc(tblDesc));
		this.add(getDt_operADesc(tblDesc));
		this.add(getFg_manualADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getId_stADesc(tblDesc));
		this.add(getId_parADesc(tblDesc));
		this.add(getFg_rollbackADesc(tblDesc));
		this.add(getSd_chlADesc(tblDesc));
		this.add(getTrademsgADesc(tblDesc));
		this.add(getRefund_req_noADesc(tblDesc));
		this.add(getName_factoryADesc(tblDesc));
		this.add(getName_bizsceneADesc(tblDesc));
		this.add(getPat_nameADesc(tblDesc));
		this.add(getPm_nameADesc(tblDesc));
		this.add(getEmp_nameADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_transrcdCDesc(tblDesc));
		tblDesc.add(getId_transrcdCDesc(tblDesc));
		tblDesc.add(getId_transregCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_bizsceneCDesc(tblDesc));
		tblDesc.add(getSd_bizsceneCDesc(tblDesc));
		tblDesc.add(getId_patCDesc(tblDesc));
		tblDesc.add(getId_entCDesc(tblDesc));
		tblDesc.add(getCode_enttpCDesc(tblDesc));
		tblDesc.add(getPat_cardcodeCDesc(tblDesc));
		tblDesc.add(getId_payCDesc(tblDesc));
		tblDesc.add(getId_pmCDesc(tblDesc));
		tblDesc.add(getAmtCDesc(tblDesc));
		tblDesc.add(getEu_directCDesc(tblDesc));
		tblDesc.add(getEu_statusCDesc(tblDesc));
		tblDesc.add(getOrder_noCDesc(tblDesc));
		tblDesc.add(getSerial_noCDesc(tblDesc));
		tblDesc.add(getVoucher_noCDesc(tblDesc));
		tblDesc.add(getSerial_no_trdCDesc(tblDesc));
		tblDesc.add(getSerial_no_ordCDesc(tblDesc));
		tblDesc.add(getHos_ord_noCDesc(tblDesc));
		tblDesc.add(getDigital_signCDesc(tblDesc));
		tblDesc.add(getInputCDesc(tblDesc));
		tblDesc.add(getOutputCDesc(tblDesc));
		tblDesc.add(getId_emp_operCDesc(tblDesc));
		tblDesc.add(getDt_operCDesc(tblDesc));
		tblDesc.add(getFg_manualCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		tblDesc.add(getId_stCDesc(tblDesc));
		tblDesc.add(getId_parCDesc(tblDesc));
		tblDesc.add(getFg_rollbackCDesc(tblDesc));
		tblDesc.add(getSd_chlCDesc(tblDesc));
		tblDesc.add(getTrademsgCDesc(tblDesc));
		tblDesc.add(getRefund_req_noCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 第三方交易记录id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_transrcdADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_transrcd",  getId_transrcdCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("第三方交易记录id");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 第三方交易注册id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_transregADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_transreg",  getId_transregCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("第三方交易注册id");
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
	 * 交易发生业务场景属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_bizsceneADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_bizscene",  getId_bizsceneCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("交易发生业务场景");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 交易发生业务场景sd属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_bizsceneADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_bizscene",  getSd_bizsceneCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("交易发生业务场景sd");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_patADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pat",  getId_patCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 就诊id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_entADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ent",  getId_entCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("就诊id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 就诊类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_enttpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_enttp",  getCode_enttpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("就诊类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者就诊卡号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPat_cardcodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pat_cardcode",  getPat_cardcodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者就诊卡号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 支付主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_payADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pay",  getId_payCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("支付主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 付款方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pm",  getId_pmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("付款方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 交易金额属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmtADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt",  getAmtCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("交易金额");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 交易方向属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_directADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_direct",  getEu_directCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("交易方向");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 交易状态属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_statusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_status",  getEu_statusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("交易状态");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 订单号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOrder_noADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Order_no",  getOrder_noCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("订单号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * IIH支付平台渠道交易号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSerial_noADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Serial_no",  getSerial_noCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("IIH支付平台渠道交易号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * IIH支付平台内部交易号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getVoucher_noADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Voucher_no",  getVoucher_noCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("IIH支付平台内部交易号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 第三方交易流水号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSerial_no_trdADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Serial_no_trd",  getSerial_no_trdCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("第三方交易流水号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 第三方交易订单号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSerial_no_ordADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Serial_no_ord",  getSerial_no_ordCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("第三方交易订单号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * IIH支付平台商户订单号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHos_ord_noADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Hos_ord_no",  getHos_ord_noCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("IIH支付平台商户订单号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 数字签名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDigital_signADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Digital_sign",  getDigital_signCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("数字签名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 入参属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInputADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Input",  getInputCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入参");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 出参属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOutputADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Output",  getOutputCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("出参");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 操作人员属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_operADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_oper",  getId_emp_operCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("操作人员");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 操作时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_operADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_oper",  getDt_operCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("操作时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手工操作属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_manualADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_manual",  getFg_manualCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("手工操作");
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
	 * 结算id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_stADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_st",  getId_stCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("结算id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 原第三方交易记录id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_parADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_par",  getId_parCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("原第三方交易记录id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否异常属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_rollbackADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_rollback",  getFg_rollbackCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否异常");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 支付渠道属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_chlADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_chl",  getSd_chlCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("支付渠道");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 交易返回信息属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTrademsgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Trademsg",  getTrademsgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("交易返回信息");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 退款请求号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRefund_req_noADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Refund_req_no",  getRefund_req_noCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("退款请求号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 第三方厂商属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_factoryADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_factory",  getName_factoryCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("第三方厂商");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bl_trd_trans_reg a0b2","id_transreg=id_transreg","name_factory"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 交易名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_bizsceneADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_bizscene",  getName_bizsceneCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("交易名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b10","id_bizscene=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPat_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pat_name",  getPat_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pi_pat a0b5","id_pat=id_pat","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 付款方式名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPm_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pm_name",  getPm_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("付款方式名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_pri_pm a0b9","id_pm=id_pm","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEmp_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Emp_name",  getEmp_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b6","id_emp_oper=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取第三方交易记录id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_transrcdCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_transrcd");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("第三方交易记录id"); 
		return column;
	}
	/**
	 * 获取第三方交易注册id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_transregCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_transreg");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("第三方交易注册id"); 
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
	 * 获取交易发生业务场景表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_bizsceneCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_bizscene");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("交易发生业务场景"); 
		return column;
	}
	/**
	 * 获取交易发生业务场景sd表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_bizsceneCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_bizscene");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("交易发生业务场景sd"); 
		return column;
	}
	/**
	 * 获取患者id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pat");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者id"); 
		return column;
	}
	/**
	 * 获取就诊id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_entCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ent");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊id"); 
		return column;
	}
	/**
	 * 获取就诊类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_enttpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_enttp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊类型"); 
		return column;
	}
	/**
	 * 获取患者就诊卡号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPat_cardcodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pat_cardcode");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者就诊卡号"); 
		return column;
	}
	/**
	 * 获取支付主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_payCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pay");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("支付主键"); 
		return column;
	}
	/**
	 * 获取付款方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pm");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("付款方式"); 
		return column;
	}
	/**
	 * 获取交易金额表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmtCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("交易金额"); 
		return column;
	}
	/**
	 * 获取交易方向表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_directCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_direct");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("交易方向"); 
		return column;
	}
	/**
	 * 获取交易状态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_statusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_status");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("交易状态"); 
		return column;
	}
	/**
	 * 获取订单号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOrder_noCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Order_no");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("订单号"); 
		return column;
	}
	/**
	 * 获取IIH支付平台渠道交易号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSerial_noCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Serial_no");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("IIH支付平台渠道交易号"); 
		return column;
	}
	/**
	 * 获取IIH支付平台内部交易号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getVoucher_noCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Voucher_no");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("IIH支付平台内部交易号"); 
		return column;
	}
	/**
	 * 获取第三方交易流水号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSerial_no_trdCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Serial_no_trd");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("第三方交易流水号"); 
		return column;
	}
	/**
	 * 获取第三方交易订单号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSerial_no_ordCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Serial_no_ord");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("第三方交易订单号"); 
		return column;
	}
	/**
	 * 获取IIH支付平台商户订单号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHos_ord_noCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Hos_ord_no");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("IIH支付平台商户订单号"); 
		return column;
	}
	/**
	 * 获取数字签名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDigital_signCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Digital_sign");
		column.setLength(0);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("数字签名"); 
		return column;
	}
	/**
	 * 获取入参表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInputCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Input");
		column.setLength(0);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入参"); 
		return column;
	}
	/**
	 * 获取出参表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOutputCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Output");
		column.setLength(0);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("出参"); 
		return column;
	}
	/**
	 * 获取操作人员表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_operCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_oper");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("操作人员"); 
		return column;
	}
	/**
	 * 获取操作时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_operCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_oper");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("操作时间"); 
		return column;
	}
	/**
	 * 获取手工操作表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_manualCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_manual");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("手工操作"); 
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
	 * 获取结算id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_stCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_st");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("结算id"); 
		return column;
	}
	/**
	 * 获取原第三方交易记录id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_parCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_par");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("原第三方交易记录id"); 
		return column;
	}
	/**
	 * 获取是否异常表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_rollbackCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_rollback");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否异常"); 
		return column;
	}
	/**
	 * 获取支付渠道表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_chlCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_chl");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("支付渠道"); 
		return column;
	}
	/**
	 * 获取交易返回信息表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTrademsgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Trademsg");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("交易返回信息"); 
		return column;
	}
	/**
	 * 获取退款请求号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRefund_req_noCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Refund_req_no");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("退款请求号"); 
		return column;
	}
	/**
	 * 获取第三方厂商表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_factoryCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_factory");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("第三方厂商"); 
		return column;
	}
	/**
	 * 获取交易名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_bizsceneCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_bizscene");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("交易名称"); 
		return column;
	}
	/**
	 * 获取患者姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPat_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pat_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者姓名"); 
		return column;
	}
	/**
	 * 获取付款方式名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPm_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pm_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("付款方式名称"); 
		return column;
	}
	/**
	 * 获取姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEmp_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Emp_name");
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
