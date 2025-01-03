
package iih.pe.papt.pepsncatsel.d.desc;

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
 * 体检个人预约项目 DO 元数据信息
 */
public class PePsnapptCatDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.pe.papt.pepsncatsel.d.PePsnapptCatDO";
	public static final String CLASS_DISPALYNAME = "体检个人预约项目";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "pe_apt_pepsnapptcat";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_pepsnapptcat";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public PePsnapptCatDODesc(){
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
		this.setKeyDesc(getId_pepsnapptcatADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_pepsnapptcatADesc(tblDesc));
		this.add(getId_pepsnapptADesc(tblDesc));
		this.add(getId_pecorpapptgrpADesc(tblDesc));
		this.add(getId_pedeptsetADesc(tblDesc));
		this.add(getId_pesrvcatlogADesc(tblDesc));
		this.add(getFg_addADesc(tblDesc));
		this.add(getFg_payselfADesc(tblDesc));
		this.add(getPri_baseADesc(tblDesc));
		this.add(getPri_catADesc(tblDesc));
		this.add(getDis_catADesc(tblDesc));
		this.add(getQty_catADesc(tblDesc));
		this.add(getAmt_catADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getFg_psnADesc(tblDesc));
		this.add(getFg_paidADesc(tblDesc));
		this.add(getFg_transADesc(tblDesc));
		this.add(getNo_applyADesc(tblDesc));
		this.add(getFg_barcodeADesc(tblDesc));
		this.add(getNo_barcodeADesc(tblDesc));
		this.add(getId_orADesc(tblDesc));
		this.add(getFg_bl_payADesc(tblDesc));
		this.add(getDt_bl_payADesc(tblDesc));
		this.add(getPecatlogstatusADesc(tblDesc));
		this.add(getFg_returnADesc(tblDesc));
		this.add(getPe_codeADesc(tblDesc));
		this.add(getFg_nopayADesc(tblDesc));
		this.add(getDt_peADesc(tblDesc));
		this.add(getFg_vipADesc(tblDesc));
		this.add(getCard_peADesc(tblDesc));
		this.add(getCode_depADesc(tblDesc));
		this.add(getName_depADesc(tblDesc));
		this.add(getCode_srvitmADesc(tblDesc));
		this.add(getName_srvitmADesc(tblDesc));
		this.add(getCatlog_srvitmADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_pepsnapptcatCDesc(tblDesc));
		tblDesc.add(getId_pepsnapptcatCDesc(tblDesc));
		tblDesc.add(getId_pepsnapptCDesc(tblDesc));
		tblDesc.add(getId_pecorpapptgrpCDesc(tblDesc));
		tblDesc.add(getId_pedeptsetCDesc(tblDesc));
		tblDesc.add(getId_pesrvcatlogCDesc(tblDesc));
		tblDesc.add(getFg_addCDesc(tblDesc));
		tblDesc.add(getFg_payselfCDesc(tblDesc));
		tblDesc.add(getPri_baseCDesc(tblDesc));
		tblDesc.add(getPri_catCDesc(tblDesc));
		tblDesc.add(getDis_catCDesc(tblDesc));
		tblDesc.add(getQty_catCDesc(tblDesc));
		tblDesc.add(getAmt_catCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		tblDesc.add(getFg_psnCDesc(tblDesc));
		tblDesc.add(getFg_paidCDesc(tblDesc));
		tblDesc.add(getFg_transCDesc(tblDesc));
		tblDesc.add(getNo_applyCDesc(tblDesc));
		tblDesc.add(getFg_barcodeCDesc(tblDesc));
		tblDesc.add(getNo_barcodeCDesc(tblDesc));
		tblDesc.add(getId_orCDesc(tblDesc));
		tblDesc.add(getFg_bl_payCDesc(tblDesc));
		tblDesc.add(getDt_bl_payCDesc(tblDesc));
		tblDesc.add(getPecatlogstatusCDesc(tblDesc));
		tblDesc.add(getFg_returnCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 体检个人预约项目主键标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pepsnapptcatADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pepsnapptcat",  getId_pepsnapptcatCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检个人预约项目主键标识");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检预约单ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pepsnapptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pepsnappt",  getId_pepsnapptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检预约单ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 体检团体预约分组ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pecorpapptgrpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pecorpapptgrp",  getId_pecorpapptgrpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检团体预约分组ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 所属科室属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pedeptsetADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pedeptset",  getId_pedeptsetCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("所属科室");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 体检项目属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pesrvcatlogADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pesrvcatlog",  getId_pesrvcatlogCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检项目");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 加项标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_addADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_add",  getFg_addCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("加项标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 自付标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_payselfADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_payself",  getFg_payselfCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("自付标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 基础价格属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPri_baseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pri_base",  getPri_baseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("基础价格");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 实收价格属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPri_catADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pri_cat",  getPri_catCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("实收价格");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 折扣属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDis_catADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dis_cat",  getDis_catCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("折扣");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 数量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQty_catADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Qty_cat",  getQty_catCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("数量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 金额属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_catADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_cat",  getAmt_catCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("金额");
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
	 * 个人标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_psnADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_psn",  getFg_psnCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("个人标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 收费标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_paidADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_paid",  getFg_paidCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("收费标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 申请传输标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_transADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_trans",  getFg_transCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("申请传输标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 申请单号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNo_applyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("No_apply",  getNo_applyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("申请单号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 条码号打印标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_barcodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_barcode",  getFg_barcodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("条码号打印标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 条码号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNo_barcodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("No_barcode",  getNo_barcodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("条码号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医嘱单号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_orADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_or",  getId_orCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医嘱单号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 门诊收费标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_bl_payADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_bl_pay",  getFg_bl_payCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("门诊收费标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 门诊收费时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_bl_payADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_bl_pay",  getDt_bl_payCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("门诊收费时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检项目状态属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPecatlogstatusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pecatlogstatus",  getPecatlogstatusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("体检项目状态");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 退费标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_returnADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_return",  getFg_returnCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("退费标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检唯一码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPe_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pe_code",  getPe_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检唯一码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_apt_pepsnappt a0b2","id_pepsnappt=id_pepsnappt","pe_code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 后付费体检标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_nopayADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_nopay",  getFg_nopayCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("后付费体检标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_apt_pepsnappt a0b2","id_pepsnappt=id_pepsnappt","fg_nopay"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_peADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_pe",  getDt_peCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("体检时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_apt_pepsnappt a0b2","id_pepsnappt=id_pepsnappt","dt_pe"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * VIP标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_vipADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_vip",  getFg_vipCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("VIP标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_apt_pepsnappt a0b2","id_pepsnappt=id_pepsnappt","fg_vip"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检流程号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCard_peADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Card_pe",  getCard_peCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检流程号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_apt_pepsnappt a0b2","id_pepsnappt=id_pepsnappt","card_pe"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检科室编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_depADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_dep",  getCode_depCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检科室编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_bd_deptset a0b7","id_pedeptset=id_pedeptset","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检科室名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_depADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dep",  getName_depCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检科室名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_bd_deptset a0b7","id_pedeptset=id_pedeptset","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检项目编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_srvitmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_srvitm",  getCode_srvitmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检项目编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_itm_pesrvbcatlog a0b4","id_pesrvcatlog=id_pesrvbcatlog","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检项目名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_srvitmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_srvitm",  getName_srvitmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检项目名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_itm_pesrvbcatlog a0b4","id_pesrvcatlog=id_pesrvbcatlog","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 所属目录属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCatlog_srvitmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Catlog_srvitm",  getCatlog_srvitmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("所属目录");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_itm_pesrvbcatlog a0b4","id_pesrvcatlog=id_pesrvbcatlog","catlog"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取体检个人预约项目主键标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pepsnapptcatCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pepsnapptcat");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("体检个人预约项目主键标识"); 
		return column;
	}
	/**
	 * 获取体检预约单ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pepsnapptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pepsnappt");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检预约单ID"); 
		return column;
	}
	/**
	 * 获取体检团体预约分组ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pecorpapptgrpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pecorpapptgrp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检团体预约分组ID"); 
		return column;
	}
	/**
	 * 获取所属科室表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pedeptsetCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pedeptset");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("所属科室"); 
		return column;
	}
	/**
	 * 获取体检项目表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pesrvcatlogCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pesrvcatlog");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检项目"); 
		return column;
	}
	/**
	 * 获取加项标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_addCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_add");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("加项标识"); 
		return column;
	}
	/**
	 * 获取自付标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_payselfCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_payself");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("自付标识"); 
		return column;
	}
	/**
	 * 获取基础价格表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPri_baseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pri_base");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("基础价格"); 
		return column;
	}
	/**
	 * 获取实收价格表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPri_catCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pri_cat");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("实收价格"); 
		return column;
	}
	/**
	 * 获取折扣表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDis_catCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dis_cat");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("折扣"); 
		return column;
	}
	/**
	 * 获取数量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQty_catCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Qty_cat");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("数量"); 
		return column;
	}
	/**
	 * 获取金额表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_catCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_cat");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("金额"); 
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
	 * 获取个人标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_psnCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_psn");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("个人标识"); 
		return column;
	}
	/**
	 * 获取收费标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_paidCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_paid");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("收费标识"); 
		return column;
	}
	/**
	 * 获取申请传输标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_transCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_trans");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("申请传输标识"); 
		return column;
	}
	/**
	 * 获取申请单号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNo_applyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"No_apply");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("申请单号"); 
		return column;
	}
	/**
	 * 获取条码号打印标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_barcodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_barcode");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("条码号打印标识"); 
		return column;
	}
	/**
	 * 获取条码号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNo_barcodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"No_barcode");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("条码号"); 
		return column;
	}
	/**
	 * 获取医嘱单号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_orCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_or");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医嘱单号"); 
		return column;
	}
	/**
	 * 获取门诊收费标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_bl_payCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_bl_pay");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("门诊收费标识"); 
		return column;
	}
	/**
	 * 获取门诊收费时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_bl_payCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_bl_pay");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("门诊收费时间"); 
		return column;
	}
	/**
	 * 获取体检项目状态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPecatlogstatusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pecatlogstatus");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("体检项目状态"); 
		return column;
	}
	/**
	 * 获取退费标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_returnCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_return");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("退费标识"); 
		return column;
	}
	/**
	 * 获取体检唯一码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPe_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pe_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检唯一码"); 
		return column;
	}
	/**
	 * 获取后付费体检标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_nopayCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_nopay");
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("后付费体检标识"); 
		return column;
	}
	/**
	 * 获取体检时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_peCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_pe");
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("体检时间"); 
		return column;
	}
	/**
	 * 获取VIP标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_vipCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_vip");
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("VIP标识"); 
		return column;
	}
	/**
	 * 获取体检流程号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCard_peCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Card_pe");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检流程号"); 
		return column;
	}
	/**
	 * 获取体检科室编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_depCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_dep");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检科室编码"); 
		return column;
	}
	/**
	 * 获取体检科室名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_depCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dep");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检科室名称"); 
		return column;
	}
	/**
	 * 获取体检项目编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_srvitmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_srvitm");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检项目编码"); 
		return column;
	}
	/**
	 * 获取体检项目名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_srvitmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_srvitm");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检项目名称"); 
		return column;
	}
	/**
	 * 获取所属目录表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCatlog_srvitmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Catlog_srvitm");
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("所属目录"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id","Id_pepsnapptcat");
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
		defaultValueMap.put("Fg_add",new xap.mw.coreitf.d.FBoolean("N"));
		defaultValueMap.put("Fg_payself",new xap.mw.coreitf.d.FBoolean("N"));
		defaultValueMap.put("Fg_paid",new xap.mw.coreitf.d.FBoolean("N"));
		defaultValueMap.put("Fg_bl_pay",new xap.mw.coreitf.d.FBoolean("N"));
		defaultValueMap.put("Fg_return",new xap.mw.coreitf.d.FBoolean("N"));
	}
	
}
