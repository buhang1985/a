
package iih.pmp.pay.trade.d.desc;

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
 * 交易 DO 元数据信息
 */
public class TradeDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.pmp.pay.trade.d.TradeDO";
	public static final String CLASS_DISPALYNAME = "交易";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "pmp_trade";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_trade";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public TradeDODesc(){
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
		this.setKeyDesc(getId_tradeADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_tradeADesc(tblDesc));
		this.add(getTrade_noADesc(tblDesc));
		this.add(getTrade_no_relADesc(tblDesc));
		this.add(getRefund_req_noADesc(tblDesc));
		this.add(getId_ordADesc(tblDesc));
		this.add(getSubjectADesc(tblDesc));
		this.add(getBodyADesc(tblDesc));
		this.add(getAmountADesc(tblDesc));
		this.add(getDt_reqADesc(tblDesc));
		this.add(getTrade_statusADesc(tblDesc));
		this.add(getId_emp_opADesc(tblDesc));
		this.add(getId_refund_userADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getTrade_no_chlADesc(tblDesc));
		this.add(getDt_finishADesc(tblDesc));
		this.add(getBuyer_user_idADesc(tblDesc));
		this.add(getBuyer_logon_idADesc(tblDesc));
		this.add(getEu_directADesc(tblDesc));
		this.add(getFg_precreateADesc(tblDesc));
		this.add(getErr_codeADesc(tblDesc));
		this.add(getSd_chlADesc(tblDesc));
		this.add(getId_chlADesc(tblDesc));
		this.add(getOrd_noADesc(tblDesc));
		this.add(getQr_codeADesc(tblDesc));
		this.add(getSd_sceneADesc(tblDesc));
		this.add(getId_sceneADesc(tblDesc));
		this.add(getCheck_rstADesc(tblDesc));
		this.add(getDeviceinfoADesc(tblDesc));
		this.add(getTradetypeADesc(tblDesc));
		this.add(getSd_ordADesc(tblDesc));
		this.add(getBanktradenoADesc(tblDesc));
		this.add(getBankordernoADesc(tblDesc));
		this.add(getPaymodeADesc(tblDesc));
		this.add(getName_payempADesc(tblDesc));
		this.add(getName_refund_empADesc(tblDesc));
		this.add(getName_chlADesc(tblDesc));
		this.add(getName_sceneADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_tradeCDesc(tblDesc));
		tblDesc.add(getId_tradeCDesc(tblDesc));
		tblDesc.add(getTrade_noCDesc(tblDesc));
		tblDesc.add(getTrade_no_relCDesc(tblDesc));
		tblDesc.add(getRefund_req_noCDesc(tblDesc));
		tblDesc.add(getId_ordCDesc(tblDesc));
		tblDesc.add(getSubjectCDesc(tblDesc));
		tblDesc.add(getBodyCDesc(tblDesc));
		tblDesc.add(getAmountCDesc(tblDesc));
		tblDesc.add(getDt_reqCDesc(tblDesc));
		tblDesc.add(getTrade_statusCDesc(tblDesc));
		tblDesc.add(getId_emp_opCDesc(tblDesc));
		tblDesc.add(getId_refund_userCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getTrade_no_chlCDesc(tblDesc));
		tblDesc.add(getDt_finishCDesc(tblDesc));
		tblDesc.add(getBuyer_user_idCDesc(tblDesc));
		tblDesc.add(getBuyer_logon_idCDesc(tblDesc));
		tblDesc.add(getEu_directCDesc(tblDesc));
		tblDesc.add(getFg_precreateCDesc(tblDesc));
		tblDesc.add(getErr_codeCDesc(tblDesc));
		tblDesc.add(getSd_chlCDesc(tblDesc));
		tblDesc.add(getId_chlCDesc(tblDesc));
		tblDesc.add(getOrd_noCDesc(tblDesc));
		tblDesc.add(getQr_codeCDesc(tblDesc));
		tblDesc.add(getSd_sceneCDesc(tblDesc));
		tblDesc.add(getId_sceneCDesc(tblDesc));
		tblDesc.add(getCheck_rstCDesc(tblDesc));
		tblDesc.add(getDeviceinfoCDesc(tblDesc));
		tblDesc.add(getTradetypeCDesc(tblDesc));
		tblDesc.add(getSd_ordCDesc(tblDesc));
		tblDesc.add(getBanktradenoCDesc(tblDesc));
		tblDesc.add(getBankordernoCDesc(tblDesc));
		tblDesc.add(getPaymodeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 交易主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_tradeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_trade",  getId_tradeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("交易主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 交易号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTrade_noADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Trade_no",  getTrade_noCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("交易号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 关联交易号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTrade_no_relADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Trade_no_rel",  getTrade_no_relCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("关联交易号");
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
	 * 订单主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ordADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ord",  getId_ordCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("订单主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 交易名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSubjectADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Subject",  getSubjectCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("交易名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 交易内容属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBodyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Body",  getBodyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("交易内容");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 交易金额属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmountADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amount",  getAmountCDesc(tblDesc), this);
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
	 * 交易发起时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_reqADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_req",  getDt_reqCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("交易发起时间");
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
	private IAttrDesc getTrade_statusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Trade_status",  getTrade_statusCDesc(tblDesc), this);
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
	 * 操作人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_opADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_op",  getId_emp_opCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("操作人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 退款操作人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_refund_userADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_refund_user",  getId_refund_userCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("退款操作人");
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
	 * 渠道交易号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTrade_no_chlADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Trade_no_chl",  getTrade_no_chlCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("渠道交易号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 交易完成时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_finishADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_finish",  getDt_finishCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("交易完成时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 买家用户id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBuyer_user_idADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Buyer_user_id",  getBuyer_user_idCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("买家用户id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 买家登录id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBuyer_logon_idADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Buyer_logon_id",  getBuyer_logon_idCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("买家登录id");
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
	 * 预下单标记属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_precreateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_precreate",  getFg_precreateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("预下单标记");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 错误代码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getErr_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Err_code",  getErr_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("错误代码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 渠道编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_chlADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_chl",  getSd_chlCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("渠道编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 渠道id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_chlADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_chl",  getId_chlCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("渠道id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 外部订单号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOrd_noADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ord_no",  getOrd_noCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("外部订单号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 二维码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQr_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Qr_code",  getQr_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("二维码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 场景编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_sceneADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_scene",  getSd_sceneCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("场景编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 场景id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_sceneADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_scene",  getId_sceneCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("场景id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 对账结果属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCheck_rstADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Check_rst",  getCheck_rstCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("对账结果");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 设备号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDeviceinfoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Deviceinfo",  getDeviceinfoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("设备号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 支付类型（民生银行专用）属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTradetypeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Tradetype",  getTradetypeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("支付类型（民生银行专用）");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 订单编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_ordADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_ord",  getSd_ordCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("订单编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 银行流水号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBanktradenoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Banktradeno",  getBanktradenoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("银行流水号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 银行订单号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBankordernoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Bankorderno",  getBankordernoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("银行订单号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 创新中心支付方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPaymodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Paymode",  getPaymodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("创新中心支付方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 支付操作人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_payempADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_payemp",  getName_payempCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("支付操作人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b5","id_emp_op=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 退款操作人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_refund_empADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_refund_emp",  getName_refund_empCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("退款操作人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b8","id_refund_user=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 渠道属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_chlADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_chl",  getName_chlCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("渠道");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b6","id_chl=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 场景属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_sceneADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_scene",  getName_sceneCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("场景");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b7","id_scene=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取交易主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_tradeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_trade");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("交易主键"); 
		return column;
	}
	/**
	 * 获取交易号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTrade_noCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Trade_no");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("交易号"); 
		return column;
	}
	/**
	 * 获取关联交易号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTrade_no_relCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Trade_no_rel");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("关联交易号"); 
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
	 * 获取订单主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ordCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ord");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("订单主键"); 
		return column;
	}
	/**
	 * 获取交易名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSubjectCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Subject");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("交易名称"); 
		return column;
	}
	/**
	 * 获取交易内容表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBodyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Body");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("交易内容"); 
		return column;
	}
	/**
	 * 获取交易金额表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmountCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amount");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("交易金额"); 
		return column;
	}
	/**
	 * 获取交易发起时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_reqCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_req");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("交易发起时间"); 
		return column;
	}
	/**
	 * 获取交易状态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTrade_statusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Trade_status");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("交易状态"); 
		return column;
	}
	/**
	 * 获取操作人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_opCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_op");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("操作人"); 
		return column;
	}
	/**
	 * 获取退款操作人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_refund_userCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_refund_user");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("退款操作人"); 
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
	 * 获取渠道交易号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTrade_no_chlCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Trade_no_chl");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("渠道交易号"); 
		return column;
	}
	/**
	 * 获取交易完成时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_finishCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_finish");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("交易完成时间"); 
		return column;
	}
	/**
	 * 获取买家用户id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBuyer_user_idCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Buyer_user_id");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("买家用户id"); 
		return column;
	}
	/**
	 * 获取买家登录id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBuyer_logon_idCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Buyer_logon_id");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("买家登录id"); 
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
	 * 获取预下单标记表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_precreateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_precreate");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("预下单标记"); 
		return column;
	}
	/**
	 * 获取错误代码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getErr_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Err_code");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("错误代码"); 
		return column;
	}
	/**
	 * 获取渠道编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_chlCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_chl");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("渠道编码"); 
		return column;
	}
	/**
	 * 获取渠道id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_chlCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_chl");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("渠道id"); 
		return column;
	}
	/**
	 * 获取外部订单号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOrd_noCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ord_no");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("外部订单号"); 
		return column;
	}
	/**
	 * 获取二维码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQr_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Qr_code");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("二维码"); 
		return column;
	}
	/**
	 * 获取场景编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_sceneCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_scene");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("场景编码"); 
		return column;
	}
	/**
	 * 获取场景id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_sceneCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_scene");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("场景id"); 
		return column;
	}
	/**
	 * 获取对账结果表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCheck_rstCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Check_rst");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("对账结果"); 
		return column;
	}
	/**
	 * 获取设备号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDeviceinfoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Deviceinfo");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("设备号"); 
		return column;
	}
	/**
	 * 获取支付类型（民生银行专用）表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTradetypeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Tradetype");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("支付类型（民生银行专用）"); 
		return column;
	}
	/**
	 * 获取订单编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_ordCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_ord");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("订单编码"); 
		return column;
	}
	/**
	 * 获取银行流水号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBanktradenoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Banktradeno");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("银行流水号"); 
		return column;
	}
	/**
	 * 获取银行订单号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBankordernoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Bankorderno");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("银行订单号"); 
		return column;
	}
	/**
	 * 获取创新中心支付方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPaymodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Paymode");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("创新中心支付方式"); 
		return column;
	}
	/**
	 * 获取支付操作人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_payempCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_payemp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("支付操作人"); 
		return column;
	}
	/**
	 * 获取退款操作人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_refund_empCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_refund_emp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("退款操作人"); 
		return column;
	}
	/**
	 * 获取渠道表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_chlCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_chl");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("渠道"); 
		return column;
	}
	/**
	 * 获取场景表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_sceneCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_scene");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("场景"); 
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
