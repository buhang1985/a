
package iih.bl.hp.hpcheckaccount.d.desc;

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
 * 医保统计查询对账 DO 元数据信息
 */
public class BlHpCheckAccountDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.bl.hp.hpcheckaccount.d.BlHpCheckAccountDO";
	public static final String CLASS_DISPALYNAME = "医保统计查询对账";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "BL_HP_CHECK_ACCOUNT_AH";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_hpcheck";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public BlHpCheckAccountDODesc(){
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
		this.setKeyDesc(getId_hpcheckADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.add(getId_hpcheckADesc(tblDesc));
		this.add(getCode_businessADesc(tblDesc));
		this.add(getAmt_sumADesc(tblDesc));
		this.add(getAmt_psnaccADesc(tblDesc));
		this.add(getAmt_cashADesc(tblDesc));
		this.add(getAmt_hpADesc(tblDesc));
		this.add(getAmt_salvageADesc(tblDesc));
		this.add(getAmt_civilserviceADesc(tblDesc));
		this.add(getAmt_enterpriseADesc(tblDesc));
		this.add(getAmt_otherADesc(tblDesc));
		this.add(getDt_checkADesc(tblDesc));
		this.add(getFg_balanceADesc(tblDesc));
		this.add(getId_empADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_hpcheckCDesc(tblDesc));
		tblDesc.add(getId_hpcheckCDesc(tblDesc));
		tblDesc.add(getCode_businessCDesc(tblDesc));
		tblDesc.add(getAmt_sumCDesc(tblDesc));
		tblDesc.add(getAmt_psnaccCDesc(tblDesc));
		tblDesc.add(getAmt_cashCDesc(tblDesc));
		tblDesc.add(getAmt_hpCDesc(tblDesc));
		tblDesc.add(getAmt_salvageCDesc(tblDesc));
		tblDesc.add(getAmt_civilserviceCDesc(tblDesc));
		tblDesc.add(getAmt_enterpriseCDesc(tblDesc));
		tblDesc.add(getAmt_otherCDesc(tblDesc));
		tblDesc.add(getDt_checkCDesc(tblDesc));
		tblDesc.add(getFg_balanceCDesc(tblDesc));
		tblDesc.add(getId_empCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 医保对账主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_hpcheckADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_hpcheck",  getId_hpcheckCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医保对账主键");
		attrDesc.setNullable(false);
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
	 * 总金额属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_sumADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_sum",  getAmt_sumCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("总金额");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * his个人账户支付属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_psnaccADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_psnacc",  getAmt_psnaccCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("his个人账户支付");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 现金属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_cashADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_cash",  getAmt_cashCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("现金");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医保统筹属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_hpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_hp",  getAmt_hpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("医保统筹");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 救助支付金属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_salvageADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_salvage",  getAmt_salvageCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("救助支付金");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 公务员补助金属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_civilserviceADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_civilservice",  getAmt_civilserviceCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("公务员补助金");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 企业补充基金属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_enterpriseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_enterprise",  getAmt_enterpriseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("企业补充基金");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 其他基金属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_otherADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_other",  getAmt_otherCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("其他基金");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 对账日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_checkADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_check",  getDt_checkCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("对账日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 对账结果属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_balanceADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_balance",  getFg_balanceCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("对账结果");
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
	private IAttrDesc getId_empADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp",  getId_empCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("操作人员");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取医保对账主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_hpcheckCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_hpcheck");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("医保对账主键"); 
		return column;
	}
	/**
	 * 获取业务周期号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_businessCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_business");
		column.setLength(70);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("业务周期号"); 
		return column;
	}
	/**
	 * 获取总金额表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_sumCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_sum");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("总金额"); 
		return column;
	}
	/**
	 * 获取his个人账户支付表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_psnaccCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_psnacc");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("his个人账户支付"); 
		return column;
	}
	/**
	 * 获取现金表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_cashCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_cash");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("现金"); 
		return column;
	}
	/**
	 * 获取医保统筹表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_hpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_hp");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("医保统筹"); 
		return column;
	}
	/**
	 * 获取救助支付金表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_salvageCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_salvage");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("救助支付金"); 
		return column;
	}
	/**
	 * 获取公务员补助金表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_civilserviceCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_civilservice");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("公务员补助金"); 
		return column;
	}
	/**
	 * 获取企业补充基金表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_enterpriseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_enterprise");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("企业补充基金"); 
		return column;
	}
	/**
	 * 获取其他基金表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_otherCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_other");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("其他基金"); 
		return column;
	}
	/**
	 * 获取对账日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_checkCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_check");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("对账日期"); 
		return column;
	}
	/**
	 * 获取对账结果表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_balanceCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_balance");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("对账结果"); 
		return column;
	}
	/**
	 * 获取操作人员表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_empCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("操作人员"); 
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
	
}
