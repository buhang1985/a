
package iih.bl.st.blpaypatip.d.desc;

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
 * 住院患者收付款明细 DO 元数据信息
 */
public class BlPayItmPatIpDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.bl.st.blpaypatip.d.BlPayItmPatIpDO";
	public static final String CLASS_DISPALYNAME = "住院患者收付款明细";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "bl_pay_itm_pat_ip";
	public static final String TABLE_ALIAS_NAME = "a1";
	public static final String PRIMARYKEY_FIELDNAME="Id_payitmpatip";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public BlPayItmPatIpDODesc(){
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
		this.setKeyDesc(getId_payitmpatipADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_paypatipADesc(tblDesc));
		this.add(getId_payitmpatipADesc(tblDesc));
		this.add(getId_paypatipADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getEu_directADesc(tblDesc));
		this.add(getFg_realpayADesc(tblDesc));
		this.add(getId_pmADesc(tblDesc));
		this.add(getSd_pmADesc(tblDesc));
		this.add(getAmtADesc(tblDesc));
		this.add(getId_bankADesc(tblDesc));
		this.add(getBanknoADesc(tblDesc));
		this.add(getPaymodenodeADesc(tblDesc));
		this.add(getId_paypatADesc(tblDesc));
		this.add(getFg_refund_manualADesc(tblDesc));
		this.add(getId_custADesc(tblDesc));
		this.add(getAcc_nameADesc(tblDesc));
		this.add(getBankcardnoADesc(tblDesc));
		this.add(getOrg_codeADesc(tblDesc));
		this.add(getOrg_nameADesc(tblDesc));
		this.add(getPm_codeADesc(tblDesc));
		this.add(getPm_nameADesc(tblDesc));
		this.add(getBank_nameADesc(tblDesc));
		this.add(getBank_codeADesc(tblDesc));
		this.add(getCode_custADesc(tblDesc));
		this.add(getName_custADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_payitmpatipCDesc(tblDesc));
		tblDesc.add(getId_payitmpatipCDesc(tblDesc));
		tblDesc.add(getId_paypatipCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getEu_directCDesc(tblDesc));
		tblDesc.add(getFg_realpayCDesc(tblDesc));
		tblDesc.add(getId_pmCDesc(tblDesc));
		tblDesc.add(getSd_pmCDesc(tblDesc));
		tblDesc.add(getAmtCDesc(tblDesc));
		tblDesc.add(getId_bankCDesc(tblDesc));
		tblDesc.add(getBanknoCDesc(tblDesc));
		tblDesc.add(getPaymodenodeCDesc(tblDesc));
		tblDesc.add(getId_paypatCDesc(tblDesc));
		tblDesc.add(getFg_refund_manualCDesc(tblDesc));
		tblDesc.add(getId_custCDesc(tblDesc));
		tblDesc.add(getAcc_nameCDesc(tblDesc));
		tblDesc.add(getBankcardnoCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 患者收收付款明细主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_payitmpatipADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_payitmpatip",  getId_payitmpatipCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者收收付款明细主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者收付款主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_paypatipADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_paypatip",  getId_paypatipCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者收付款主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 所属机构属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_orgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_org",  getId_orgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("所属机构");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 收付款方向属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_directADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_direct",  getEu_directCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("收付款方向");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 实收（退）付款段标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_realpayADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_realpay",  getFg_realpayCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("实收（退）付款段标志");
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
	 * 预交金收付款属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_paypatADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_paypat",  getId_paypatCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("预交金收付款");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手工退费标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_refund_manualADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_refund_manual",  getFg_refund_manualCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("手工退费标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 支付方属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_custADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_cust",  getId_custCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("支付方");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
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
		attrDesc.setRefTblInfos(new String[]{"bd_org a1b4","id_org=id_org","code"});
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
		attrDesc.setRefTblInfos(new String[]{"bd_org a1b4","id_org=id_org","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 付款方式编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPm_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pm_code",  getPm_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("付款方式编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_pri_pm a1b5","id_pm=id_pm","code"});
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
		attrDesc.setRefTblInfos(new String[]{"bd_pri_pm a1b5","id_pm=id_pm","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 银行名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBank_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Bank_name",  getBank_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("银行名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_bank a1b6","id_bank=id_bank","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 银行编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBank_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Bank_code",  getBank_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("银行编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_bank a1b6","id_bank=id_bank","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_custADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_cust",  getCode_custCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_cust a1b7","id_cust=id_cust","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_custADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_cust",  getName_custCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_cust a1b7","id_cust=id_cust","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取患者收收付款明细主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_payitmpatipCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_payitmpatip");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("患者收收付款明细主键"); 
		return column;
	}
	/**
	 * 获取患者收付款主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_paypatipCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_paypatip");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者收付款主键"); 
		return column;
	}
	/**
	 * 获取所属机构表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_orgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_org");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("所属机构"); 
		return column;
	}
	/**
	 * 获取收付款方向表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_directCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_direct");
		column.setLength(1);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("收付款方向"); 
		return column;
	}
	/**
	 * 获取实收（退）付款段标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_realpayCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_realpay");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("实收（退）付款段标志"); 
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
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("收付款方式编码"); 
		return column;
	}
	/**
	 * 获取收退款金额表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmtCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt");
		column.setLength(16);
        column.setPrecision(4);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("收退款金额"); 
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
	 * 获取预交金收付款表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_paypatCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_paypat");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("预交金收付款"); 
		return column;
	}
	/**
	 * 获取手工退费标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_refund_manualCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_refund_manual");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("手工退费标识"); 
		return column;
	}
	/**
	 * 获取支付方表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_custCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_cust");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("支付方"); 
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
	 * 获取付款方式编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPm_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pm_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("付款方式编码"); 
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
	 * 获取银行名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBank_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Bank_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("银行名称"); 
		return column;
	}
	/**
	 * 获取银行编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBank_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Bank_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("银行编码"); 
		return column;
	}
	/**
	 * 获取客户编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_custCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_cust");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户编码"); 
		return column;
	}
	/**
	 * 获取客户名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_custCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_cust");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户名称"); 
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
