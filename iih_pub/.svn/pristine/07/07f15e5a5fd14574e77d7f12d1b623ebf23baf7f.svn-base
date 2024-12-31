
package iih.bl.prop.blproparoep.d.desc;

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
 * 应收_门急体 DO 元数据信息
 */
public class BlPropArOepDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.bl.prop.blproparoep.d.BlPropArOepDO";
	public static final String CLASS_DISPALYNAME = "应收_门急体";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "bl_prop_ar_oep";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_proparoep";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public BlPropArOepDODesc(){
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
		this.setKeyDesc(getId_proparoepADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_proparoepADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_propoepADesc(tblDesc));
		this.add(getId_hpADesc(tblDesc));
		this.add(getEu_directADesc(tblDesc));
		this.add(getAmt_allADesc(tblDesc));
		this.add(getAmt_hpADesc(tblDesc));
		this.add(getAmt_psnaccADesc(tblDesc));
		this.add(getAmt_cashADesc(tblDesc));
		this.add(getAmt_hosbearADesc(tblDesc));
		this.add(getAmt_diffADesc(tblDesc));
		this.add(getFg_clearADesc(tblDesc));
		this.add(getReason_arADesc(tblDesc));
		this.add(getCardinfoADesc(tblDesc));
		this.add(getInputinfoADesc(tblDesc));
		this.add(getOutputinfoADesc(tblDesc));
		this.add(getCode_hpADesc(tblDesc));
		this.add(getNoteADesc(tblDesc));
		this.add(getCode_businessADesc(tblDesc));
		this.add(getAmt_otherADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_proparoepCDesc(tblDesc));
		tblDesc.add(getId_proparoepCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_propoepCDesc(tblDesc));
		tblDesc.add(getId_hpCDesc(tblDesc));
		tblDesc.add(getEu_directCDesc(tblDesc));
		tblDesc.add(getAmt_allCDesc(tblDesc));
		tblDesc.add(getAmt_hpCDesc(tblDesc));
		tblDesc.add(getAmt_psnaccCDesc(tblDesc));
		tblDesc.add(getAmt_cashCDesc(tblDesc));
		tblDesc.add(getAmt_hosbearCDesc(tblDesc));
		tblDesc.add(getAmt_diffCDesc(tblDesc));
		tblDesc.add(getFg_clearCDesc(tblDesc));
		tblDesc.add(getReason_arCDesc(tblDesc));
		tblDesc.add(getCardinfoCDesc(tblDesc));
		tblDesc.add(getInputinfoCDesc(tblDesc));
		tblDesc.add(getOutputinfoCDesc(tblDesc));
		tblDesc.add(getCode_hpCDesc(tblDesc));
		tblDesc.add(getNoteCDesc(tblDesc));
		tblDesc.add(getCode_businessCDesc(tblDesc));
		tblDesc.add(getAmt_otherCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 应收主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_proparoepADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_proparoep",  getId_proparoepCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("应收主键");
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
	 * 分摊属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_propoepADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_propoep",  getId_propoepCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("分摊");
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
	 * 应收方向属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_directADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_direct",  getEu_directCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("应收方向");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 费用总金额属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_allADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_all",  getAmt_allCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("费用总金额");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医保支付金额属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_hpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_hp",  getAmt_hpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("医保支付金额");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 个人账户支付金额属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_psnaccADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_psnacc",  getAmt_psnaccCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("个人账户支付金额");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 现金支付金额属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_cashADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_cash",  getAmt_cashCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("现金支付金额");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医保盈亏属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_hosbearADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_hosbear",  getAmt_hosbearCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("医保盈亏");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医保差额属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_diffADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_diff",  getAmt_diffCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("医保差额");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 结清标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_clearADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_clear",  getFg_clearCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("结清标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 未结清原因属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getReason_arADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Reason_ar",  getReason_arCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("未结清原因");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医保卡信息属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCardinfoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Cardinfo",  getCardinfoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医保卡信息");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医保输入参数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInputinfoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Inputinfo",  getInputinfoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医保输入参数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医保输出参数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOutputinfoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Outputinfo",  getOutputinfoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医保输出参数");
		attrDesc.setNullable(true);
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
	private IAttrDesc getCode_hpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_hp",  getCode_hpCDesc(tblDesc), this);
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
	 * 业务周期号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_businessADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_business",  getCode_businessCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("业务周期号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 其他医保支付属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_otherADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_other",  getAmt_otherCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("其他医保支付");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取应收主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_proparoepCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_proparoep");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("应收主键"); 
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
	 * 获取分摊表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_propoepCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_propoep");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("分摊"); 
		return column;
	}
	/**
	 * 获取医保产品表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_hpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_hp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医保产品"); 
		return column;
	}
	/**
	 * 获取应收方向表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_directCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_direct");
		column.setLength(2);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("应收方向"); 
		return column;
	}
	/**
	 * 获取费用总金额表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_allCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_all");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("费用总金额"); 
		return column;
	}
	/**
	 * 获取医保支付金额表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_hpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_hp");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("医保支付金额"); 
		return column;
	}
	/**
	 * 获取个人账户支付金额表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_psnaccCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_psnacc");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("个人账户支付金额"); 
		return column;
	}
	/**
	 * 获取现金支付金额表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_cashCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_cash");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("现金支付金额"); 
		return column;
	}
	/**
	 * 获取医保盈亏表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_hosbearCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_hosbear");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("医保盈亏"); 
		return column;
	}
	/**
	 * 获取医保差额表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_diffCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_diff");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("医保差额"); 
		return column;
	}
	/**
	 * 获取结清标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_clearCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_clear");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("结清标志"); 
		return column;
	}
	/**
	 * 获取未结清原因表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getReason_arCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Reason_ar");
		column.setLength(256);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("未结清原因"); 
		return column;
	}
	/**
	 * 获取医保卡信息表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCardinfoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Cardinfo");
		column.setLength(4000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医保卡信息"); 
		return column;
	}
	/**
	 * 获取医保输入参数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInputinfoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Inputinfo");
		column.setLength(0);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医保输入参数"); 
		return column;
	}
	/**
	 * 获取医保输出参数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOutputinfoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Outputinfo");
		column.setLength(0);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医保输出参数"); 
		return column;
	}
	/**
	 * 获取交易号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_hpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_hp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("交易号"); 
		return column;
	}
	/**
	 * 获取备注表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNoteCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Note");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备注"); 
		return column;
	}
	/**
	 * 获取业务周期号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_businessCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_business");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("业务周期号"); 
		return column;
	}
	/**
	 * 获取其他医保支付表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_otherCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_other");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("其他医保支付"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id","Id_proparoep");
		iBDDataInfoFldMap.put("id_org","Id_org");
		iBDDataInfoFldMap.put("id_group","Id_grp");
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
