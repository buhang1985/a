
package iih.pmp.pay.ord.d.desc;

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
 * 订单 DO 元数据信息
 */
public class OrdDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.pmp.pay.ord.d.OrdDO";
	public static final String CLASS_DISPALYNAME = "订单";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "pmp_ord";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_ord";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public OrdDODesc(){
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
		this.setKeyDesc(getId_ordADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_ordADesc(tblDesc));
		this.add(getOrd_noADesc(tblDesc));
		this.add(getCodeADesc(tblDesc));
		this.add(getOrd_statusADesc(tblDesc));
		this.add(getDt_ordADesc(tblDesc));
		this.add(getAmountADesc(tblDesc));
		this.add(getAmount_bkADesc(tblDesc));
		this.add(getId_chlADesc(tblDesc));
		this.add(getSd_chlADesc(tblDesc));
		this.add(getId_sceneADesc(tblDesc));
		this.add(getSd_sceneADesc(tblDesc));
		this.add(getSpbill_create_ipADesc(tblDesc));
		this.add(getDt_payADesc(tblDesc));
		this.add(getSubjectADesc(tblDesc));
		this.add(getBodyADesc(tblDesc));
		this.add(getId_emp_opADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getCheck_rstADesc(tblDesc));
		this.add(getDeviceinfoADesc(tblDesc));
		this.add(getTradetypeADesc(tblDesc));
		this.add(getId_patADesc(tblDesc));
		this.add(getId_bizsceneADesc(tblDesc));
		this.add(getSd_bizsceneADesc(tblDesc));
		this.add(getId_pri_pmADesc(tblDesc));
		this.add(getName_chlADesc(tblDesc));
		this.add(getName_sceneADesc(tblDesc));
		this.add(getName_empADesc(tblDesc));
		this.add(getName_patADesc(tblDesc));
		this.add(getCode_patADesc(tblDesc));
		this.add(getName_bizsceneADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_ordCDesc(tblDesc));
		tblDesc.add(getId_ordCDesc(tblDesc));
		tblDesc.add(getOrd_noCDesc(tblDesc));
		tblDesc.add(getCodeCDesc(tblDesc));
		tblDesc.add(getOrd_statusCDesc(tblDesc));
		tblDesc.add(getDt_ordCDesc(tblDesc));
		tblDesc.add(getAmountCDesc(tblDesc));
		tblDesc.add(getAmount_bkCDesc(tblDesc));
		tblDesc.add(getId_chlCDesc(tblDesc));
		tblDesc.add(getSd_chlCDesc(tblDesc));
		tblDesc.add(getId_sceneCDesc(tblDesc));
		tblDesc.add(getSd_sceneCDesc(tblDesc));
		tblDesc.add(getSpbill_create_ipCDesc(tblDesc));
		tblDesc.add(getDt_payCDesc(tblDesc));
		tblDesc.add(getSubjectCDesc(tblDesc));
		tblDesc.add(getBodyCDesc(tblDesc));
		tblDesc.add(getId_emp_opCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getCheck_rstCDesc(tblDesc));
		tblDesc.add(getDeviceinfoCDesc(tblDesc));
		tblDesc.add(getTradetypeCDesc(tblDesc));
		tblDesc.add(getId_patCDesc(tblDesc));
		tblDesc.add(getId_bizsceneCDesc(tblDesc));
		tblDesc.add(getSd_bizsceneCDesc(tblDesc));
		tblDesc.add(getId_pri_pmCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
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
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
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
	 * 订单状态属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOrd_statusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ord_status",  getOrd_statusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("订单状态");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 创建时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_ordADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_ord",  getDt_ordCDesc(tblDesc), this);
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
	 * 订单金额属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmountADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amount",  getAmountCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("订单金额");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 可退金额属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmount_bkADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amount_bk",  getAmount_bkCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("可退金额");
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
	private IAttrDesc getId_chlADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_chl",  getId_chlCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("支付渠道");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 支付渠道编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_chlADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_chl",  getSd_chlCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("支付渠道编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 支付场景属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_sceneADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_scene",  getId_sceneCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("支付场景");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 支付场景编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_sceneADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_scene",  getSd_sceneCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("支付场景编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 终端IP属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSpbill_create_ipADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Spbill_create_ip",  getSpbill_create_ipCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("终端IP");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 支付时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_payADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_pay",  getDt_payCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("支付时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 订单名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSubjectADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Subject",  getSubjectCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("订单名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 订单内容属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBodyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Body",  getBodyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("订单内容");
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
	 * 患者主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_patADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pat",  getId_patCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 业务场景主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_bizsceneADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_bizscene",  getId_bizsceneCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("业务场景主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 业务场景编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_bizsceneADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_bizscene",  getSd_bizsceneCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("业务场景编码");
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
	private IAttrDesc getId_pri_pmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pri_pm",  getId_pri_pmCDesc(tblDesc), this);
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
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_chlADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_chl",  getName_chlCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b4","id_chl=id_udidoc","name"});
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
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b5","id_scene=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 操作人员属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_empADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_emp",  getName_empCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("操作人员");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b6","id_emp_op=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_patADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_pat",  getName_patCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pi_pat a0b7","id_pat=id_pat","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_patADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_pat",  getCode_patCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pi_pat a0b7","id_pat=id_pat","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_bizsceneADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_bizscene",  getName_bizsceneCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b8","id_bizscene=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取订单主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ordCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ord");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("订单主键"); 
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
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取订单状态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOrd_statusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ord_status");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("订单状态"); 
		return column;
	}
	/**
	 * 获取创建时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_ordCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_ord");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("创建时间"); 
		return column;
	}
	/**
	 * 获取订单金额表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmountCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amount");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("订单金额"); 
		return column;
	}
	/**
	 * 获取可退金额表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmount_bkCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amount_bk");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("可退金额"); 
		return column;
	}
	/**
	 * 获取支付渠道表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_chlCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_chl");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("支付渠道"); 
		return column;
	}
	/**
	 * 获取支付渠道编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_chlCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_chl");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("支付渠道编码"); 
		return column;
	}
	/**
	 * 获取支付场景表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_sceneCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_scene");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("支付场景"); 
		return column;
	}
	/**
	 * 获取支付场景编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_sceneCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_scene");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("支付场景编码"); 
		return column;
	}
	/**
	 * 获取终端IP表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSpbill_create_ipCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Spbill_create_ip");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("终端IP"); 
		return column;
	}
	/**
	 * 获取支付时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_payCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_pay");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("支付时间"); 
		return column;
	}
	/**
	 * 获取订单名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSubjectCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Subject");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("订单名称"); 
		return column;
	}
	/**
	 * 获取订单内容表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBodyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Body");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("订单内容"); 
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
	 * 获取患者主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pat");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者主键"); 
		return column;
	}
	/**
	 * 获取业务场景主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_bizsceneCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_bizscene");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("业务场景主键"); 
		return column;
	}
	/**
	 * 获取业务场景编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_bizsceneCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_bizscene");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("业务场景编码"); 
		return column;
	}
	/**
	 * 获取付款方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pri_pmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pri_pm");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("付款方式"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_chlCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_chl");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
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
	 * 获取操作人员表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_empCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_emp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("操作人员"); 
		return column;
	}
	/**
	 * 获取患者姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_pat");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者姓名"); 
		return column;
	}
	/**
	 * 获取患者编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_pat");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_bizsceneCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_bizscene");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
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
