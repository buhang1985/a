
package iih.bl.hp.hprecon.d.desc;

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
 * 医保对账 DO 元数据信息
 */
public class BlHpReconciliationDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.bl.hp.hprecon.d.BlHpReconciliationDO";
	public static final String CLASS_DISPALYNAME = "医保对账";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "bl_hp_recon";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_recon";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public BlHpReconciliationDODesc(){
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
		this.setKeyDesc(getId_reconADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_reconADesc(tblDesc));
		this.add(getHoscodeADesc(tblDesc));
		this.add(getRegnoADesc(tblDesc));
		this.add(getRcpt_noADesc(tblDesc));
		this.add(getId_medkindADesc(tblDesc));
		this.add(getId_hppatcaADesc(tblDesc));
		this.add(getPersoncodeADesc(tblDesc));
		this.add(getDt_stADesc(tblDesc));
		this.add(getSettle_tagADesc(tblDesc));
		this.add(getAmt_allADesc(tblDesc));
		this.add(getAmt_psnADesc(tblDesc));
		this.add(getAmt_cashADesc(tblDesc));
		this.add(getAmt_hpADesc(tblDesc));
		this.add(getAmt_seriousillADesc(tblDesc));
		this.add(getAmt_civilserviceADesc(tblDesc));
		this.add(getId_emp_oprADesc(tblDesc));
		this.add(getDt_transactADesc(tblDesc));
		this.add(getBusiness_codeADesc(tblDesc));
		this.add(getCode_medkindADesc(tblDesc));
		this.add(getName_medkindADesc(tblDesc));
		this.add(getCode_hppatcaADesc(tblDesc));
		this.add(getName_hppatcaADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_reconCDesc(tblDesc));
		tblDesc.add(getId_reconCDesc(tblDesc));
		tblDesc.add(getHoscodeCDesc(tblDesc));
		tblDesc.add(getRegnoCDesc(tblDesc));
		tblDesc.add(getRcpt_noCDesc(tblDesc));
		tblDesc.add(getId_medkindCDesc(tblDesc));
		tblDesc.add(getId_hppatcaCDesc(tblDesc));
		tblDesc.add(getPersoncodeCDesc(tblDesc));
		tblDesc.add(getDt_stCDesc(tblDesc));
		tblDesc.add(getSettle_tagCDesc(tblDesc));
		tblDesc.add(getAmt_allCDesc(tblDesc));
		tblDesc.add(getAmt_psnCDesc(tblDesc));
		tblDesc.add(getAmt_cashCDesc(tblDesc));
		tblDesc.add(getAmt_hpCDesc(tblDesc));
		tblDesc.add(getAmt_seriousillCDesc(tblDesc));
		tblDesc.add(getAmt_civilserviceCDesc(tblDesc));
		tblDesc.add(getId_emp_oprCDesc(tblDesc));
		tblDesc.add(getDt_transactCDesc(tblDesc));
		tblDesc.add(getBusiness_codeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_reconADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_recon",  getId_reconCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医院编号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHoscodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Hoscode",  getHoscodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医院编号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 门诊流水号/住院流水号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRegnoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Regno",  getRegnoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("门诊流水号/住院流水号");
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
	private IAttrDesc getRcpt_noADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Rcpt_no",  getRcpt_noCDesc(tblDesc), this);
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
	 * 医疗类别属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_medkindADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_medkind",  getId_medkindCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医疗类别");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 人员类别属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_hppatcaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_hppatca",  getId_hppatcaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("人员类别");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 个人编号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPersoncodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Personcode",  getPersoncodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("个人编号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 结算日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_stADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_st",  getDt_stCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("结算日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 报销标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSettle_tagADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Settle_tag",  getSettle_tagCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("报销标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医疗费总额属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_allADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_all",  getAmt_allCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("医疗费总额");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 个人帐户支付属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_psnADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_psn",  getAmt_psnCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("个人帐户支付");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 个人现金支付属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_cashADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_cash",  getAmt_cashCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("个人现金支付");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 统筹实际支付属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_hpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_hp",  getAmt_hpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("统筹实际支付");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 大病实际支付属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_seriousillADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_seriousill",  getAmt_seriousillCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("大病实际支付");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 公务员补助支出属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_civilserviceADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_civilservice",  getAmt_civilserviceCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("公务员补助支出");
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
	private IAttrDesc getId_emp_oprADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_opr",  getId_emp_oprCDesc(tblDesc), this);
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
	 * 经办日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_transactADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_transact",  getDt_transactCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("经办日期");
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
	private IAttrDesc getBusiness_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Business_code",  getBusiness_codeCDesc(tblDesc), this);
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
	 * 医疗类别编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_medkindADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_medkind",  getCode_medkindCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医疗类别编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_hp_med_kind_ah a0b2","id_medkind=id_hpmedkindah","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医疗类别名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_medkindADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_medkind",  getName_medkindCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医疗类别名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_hp_med_kind_ah a0b2","id_medkind=id_hpmedkindah","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医保身份编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_hppatcaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_hppatca",  getCode_hppatcaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医保身份编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"BD_HP_PATCA a0b3","id_hppatca=id_hppatca","code_hppatca"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医保身份名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_hppatcaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_hppatca",  getName_hppatcaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医保身份名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"BD_HP_PATCA a0b3","id_hppatca=id_hppatca","name_hppatca"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_reconCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_recon");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("主键"); 
		return column;
	}
	/**
	 * 获取医院编号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHoscodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Hoscode");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医院编号"); 
		return column;
	}
	/**
	 * 获取门诊流水号/住院流水号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRegnoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Regno");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("门诊流水号/住院流水号"); 
		return column;
	}
	/**
	 * 获取单据号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRcpt_noCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Rcpt_no");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("单据号"); 
		return column;
	}
	/**
	 * 获取医疗类别表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_medkindCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_medkind");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医疗类别"); 
		return column;
	}
	/**
	 * 获取人员类别表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_hppatcaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_hppatca");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("人员类别"); 
		return column;
	}
	/**
	 * 获取个人编号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPersoncodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Personcode");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("个人编号"); 
		return column;
	}
	/**
	 * 获取结算日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_stCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_st");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("结算日期"); 
		return column;
	}
	/**
	 * 获取报销标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSettle_tagCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Settle_tag");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("报销标志"); 
		return column;
	}
	/**
	 * 获取医疗费总额表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_allCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_all");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("医疗费总额"); 
		return column;
	}
	/**
	 * 获取个人帐户支付表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_psnCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_psn");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("个人帐户支付"); 
		return column;
	}
	/**
	 * 获取个人现金支付表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_cashCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_cash");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("个人现金支付"); 
		return column;
	}
	/**
	 * 获取统筹实际支付表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_hpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_hp");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("统筹实际支付"); 
		return column;
	}
	/**
	 * 获取大病实际支付表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_seriousillCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_seriousill");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("大病实际支付"); 
		return column;
	}
	/**
	 * 获取公务员补助支出表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_civilserviceCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_civilservice");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("公务员补助支出"); 
		return column;
	}
	/**
	 * 获取经办人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_oprCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_opr");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("经办人"); 
		return column;
	}
	/**
	 * 获取经办日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_transactCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_transact");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("经办日期"); 
		return column;
	}
	/**
	 * 获取业务周期号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBusiness_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Business_code");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("业务周期号"); 
		return column;
	}
	/**
	 * 获取医疗类别编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_medkindCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_medkind");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医疗类别编码"); 
		return column;
	}
	/**
	 * 获取医疗类别名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_medkindCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_medkind");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医疗类别名称"); 
		return column;
	}
	/**
	 * 获取医保身份编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_hppatcaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_hppatca");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医保身份编码"); 
		return column;
	}
	/**
	 * 获取医保身份名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_hppatcaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_hppatca");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医保身份名称"); 
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
