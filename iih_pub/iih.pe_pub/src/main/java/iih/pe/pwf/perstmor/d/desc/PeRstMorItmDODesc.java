
package iih.pe.pwf.perstmor.d.desc;

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
 * 体检形态学报告结果 DO 元数据信息
 */
public class PeRstMorItmDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.pe.pwf.perstmor.d.PeRstMorItmDO";
	public static final String CLASS_DISPALYNAME = "体检形态学报告结果";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "pe_wf_perstmoritm";
	public static final String TABLE_ALIAS_NAME = "a1";
	public static final String PRIMARYKEY_FIELDNAME="Id_rptmoritm";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public PeRstMorItmDODesc(){
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
		this.setKeyDesc(getId_rptmoritmADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_perstmorADesc(tblDesc));
		this.add(getId_rptmoritmADesc(tblDesc));
		this.add(getId_perstmorADesc(tblDesc));
		this.add(getId_pepsnapptADesc(tblDesc));
		this.add(getVal_rstrptlabADesc(tblDesc));
		this.add(getCode_unitADesc(tblDesc));
		this.add(getName_unitADesc(tblDesc));
		this.add(getFg_crisisADesc(tblDesc));
		this.add(getCode_patADesc(tblDesc));
		this.add(getNo_applyformADesc(tblDesc));
		this.add(getExaminaimADesc(tblDesc));
		this.add(getSamplenoADesc(tblDesc));
		this.add(getSampletypeADesc(tblDesc));
		this.add(getCode_empADesc(tblDesc));
		this.add(getName_insmtADesc(tblDesc));
		this.add(getDt_rptlabADesc(tblDesc));
		this.add(getSd_insmtADesc(tblDesc));
		this.add(getCode_depADesc(tblDesc));
		this.add(getCode_srvADesc(tblDesc));
		this.add(getName_srvADesc(tblDesc));
		this.add(getPrintordADesc(tblDesc));
		this.add(getCode_deviateADesc(tblDesc));
		this.add(getName_deviateADesc(tblDesc));
		this.add(getMark_deviateADesc(tblDesc));
		this.add(getMark_arrowADesc(tblDesc));
		this.add(getReportorADesc(tblDesc));
		this.add(getCode_reportorADesc(tblDesc));
		this.add(getVerifierADesc(tblDesc));
		this.add(getCode_verifierADesc(tblDesc));
		this.add(getDt_rptverADesc(tblDesc));
		this.add(getCode_examgroupADesc(tblDesc));
		this.add(getName_examgroupADesc(tblDesc));
		this.add(getCode_entpADesc(tblDesc));
		this.add(getName_entpADesc(tblDesc));
		this.add(getAvg_valueADesc(tblDesc));
		this.add(getAvg_unitADesc(tblDesc));
		this.add(getSd_valueADesc(tblDesc));
		this.add(getSd_unitADesc(tblDesc));
		this.add(getNormal_valueADesc(tblDesc));
		this.add(getNormal_unitADesc(tblDesc));
		this.add(getRisk_valueADesc(tblDesc));
		this.add(getRisk_unitADesc(tblDesc));
		this.add(getAgerisk_valueADesc(tblDesc));
		this.add(getAgerisk_unitADesc(tblDesc));
		this.add(getRisktruncation_valueADesc(tblDesc));
		this.add(getRisktruncation_unitADesc(tblDesc));
		this.add(getCorrection_valueADesc(tblDesc));
		this.add(getCorrection_unitADesc(tblDesc));
		this.add(getMemoADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_rptmoritmCDesc(tblDesc));
		tblDesc.add(getId_rptmoritmCDesc(tblDesc));
		tblDesc.add(getId_perstmorCDesc(tblDesc));
		tblDesc.add(getId_pepsnapptCDesc(tblDesc));
		tblDesc.add(getVal_rstrptlabCDesc(tblDesc));
		tblDesc.add(getCode_unitCDesc(tblDesc));
		tblDesc.add(getName_unitCDesc(tblDesc));
		tblDesc.add(getFg_crisisCDesc(tblDesc));
		tblDesc.add(getCode_patCDesc(tblDesc));
		tblDesc.add(getNo_applyformCDesc(tblDesc));
		tblDesc.add(getExaminaimCDesc(tblDesc));
		tblDesc.add(getSamplenoCDesc(tblDesc));
		tblDesc.add(getSampletypeCDesc(tblDesc));
		tblDesc.add(getCode_empCDesc(tblDesc));
		tblDesc.add(getName_insmtCDesc(tblDesc));
		tblDesc.add(getDt_rptlabCDesc(tblDesc));
		tblDesc.add(getSd_insmtCDesc(tblDesc));
		tblDesc.add(getCode_depCDesc(tblDesc));
		tblDesc.add(getCode_srvCDesc(tblDesc));
		tblDesc.add(getName_srvCDesc(tblDesc));
		tblDesc.add(getPrintordCDesc(tblDesc));
		tblDesc.add(getCode_deviateCDesc(tblDesc));
		tblDesc.add(getName_deviateCDesc(tblDesc));
		tblDesc.add(getMark_deviateCDesc(tblDesc));
		tblDesc.add(getMark_arrowCDesc(tblDesc));
		tblDesc.add(getReportorCDesc(tblDesc));
		tblDesc.add(getCode_reportorCDesc(tblDesc));
		tblDesc.add(getVerifierCDesc(tblDesc));
		tblDesc.add(getCode_verifierCDesc(tblDesc));
		tblDesc.add(getDt_rptverCDesc(tblDesc));
		tblDesc.add(getCode_examgroupCDesc(tblDesc));
		tblDesc.add(getName_examgroupCDesc(tblDesc));
		tblDesc.add(getCode_entpCDesc(tblDesc));
		tblDesc.add(getName_entpCDesc(tblDesc));
		tblDesc.add(getAvg_valueCDesc(tblDesc));
		tblDesc.add(getAvg_unitCDesc(tblDesc));
		tblDesc.add(getSd_valueCDesc(tblDesc));
		tblDesc.add(getSd_unitCDesc(tblDesc));
		tblDesc.add(getNormal_valueCDesc(tblDesc));
		tblDesc.add(getNormal_unitCDesc(tblDesc));
		tblDesc.add(getRisk_valueCDesc(tblDesc));
		tblDesc.add(getRisk_unitCDesc(tblDesc));
		tblDesc.add(getAgerisk_valueCDesc(tblDesc));
		tblDesc.add(getAgerisk_unitCDesc(tblDesc));
		tblDesc.add(getRisktruncation_valueCDesc(tblDesc));
		tblDesc.add(getRisktruncation_unitCDesc(tblDesc));
		tblDesc.add(getCorrection_valueCDesc(tblDesc));
		tblDesc.add(getCorrection_unitCDesc(tblDesc));
		tblDesc.add(getMemoCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 形态学报告单明细主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_rptmoritmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_rptmoritm",  getId_rptmoritmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("形态学报告单明细主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 形态学报告ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_perstmorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_perstmor",  getId_perstmorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("形态学报告ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
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
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 结果值属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getVal_rstrptlabADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Val_rstrptlab",  getVal_rstrptlabCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("结果值");
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
	private IAttrDesc getCode_unitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_unit",  getCode_unitCDesc(tblDesc), this);
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
	private IAttrDesc getName_unitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_unit",  getName_unitCDesc(tblDesc), this);
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
	 * 危急值标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_crisisADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_crisis",  getFg_crisisCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("危急值标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_patADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_pat",  getCode_patCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 申请单属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNo_applyformADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("No_applyform",  getNo_applyformCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("申请单");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 检查分组属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getExaminaimADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Examinaim",  getExaminaimCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("检查分组");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 标本号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSamplenoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sampleno",  getSamplenoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("标本号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 标本类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSampletypeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sampletype",  getSampletypeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("标本类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 检验员编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_empADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_emp",  getCode_empCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("检验员编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 检验设备属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_insmtADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_insmt",  getName_insmtCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("检验设备");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 报告日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_rptlabADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_rptlab",  getDt_rptlabCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("报告日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 设备编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_insmtADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_insmt",  getSd_insmtCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("设备编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 科室编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_depADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_dep",  getCode_depCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("科室编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 项目编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_srvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_srv",  getCode_srvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("项目编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 项目名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_srvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_srv",  getName_srvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("项目名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 打印序号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPrintordADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Printord",  getPrintordCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("打印序号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 原始异常标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_deviateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_deviate",  getCode_deviateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("原始异常标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 异常标识名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_deviateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_deviate",  getName_deviateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("异常标识名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 异常标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMark_deviateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mark_deviate",  getMark_deviateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("异常标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 箭头标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMark_arrowADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mark_arrow",  getMark_arrowCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("箭头标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 检验人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getReportorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Reportor",  getReportorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("检验人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 检验人编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_reportorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_reportor",  getCode_reportorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("检验人编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 审核人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getVerifierADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Verifier",  getVerifierCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("审核人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 审核人编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_verifierADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_verifier",  getCode_verifierCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("审核人编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 审核日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_rptverADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_rptver",  getDt_rptverCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("审核日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 检查分组编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_examgroupADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_examgroup",  getCode_examgroupCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("检查分组编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 检查分组名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_examgroupADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_examgroup",  getName_examgroupCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("检查分组名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 就诊类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_entpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_entp",  getCode_entpCDesc(tblDesc), this);
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
	 * 就诊类型名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_entpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_entp",  getName_entpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("就诊类型名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 骨髓片平均值属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAvg_valueADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Avg_value",  getAvg_valueCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("骨髓片平均值");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 骨髓片平均值单位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAvg_unitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Avg_unit",  getAvg_unitCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("骨髓片平均值单位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 骨髓片+/-SD属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_valueADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_value",  getSd_valueCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("骨髓片+/-SD");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 骨髓片+/-SD单位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_unitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_unit",  getSd_unitCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("骨髓片+/-SD单位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 正常参考范围值属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNormal_valueADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Normal_value",  getNormal_valueCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("正常参考范围值");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 正常参考范围值单位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNormal_unitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Normal_unit",  getNormal_unitCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("正常参考范围值单位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 风险值属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRisk_valueADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Risk_value",  getRisk_valueCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("风险值");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 风险值单位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRisk_unitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Risk_unit",  getRisk_unitCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("风险值单位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 年龄风险值属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAgerisk_valueADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Agerisk_value",  getAgerisk_valueCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("年龄风险值");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 年龄风险值单位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAgerisk_unitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Agerisk_unit",  getAgerisk_unitCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("年龄风险值单位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 风险截断值属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRisktruncation_valueADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Risktruncation_value",  getRisktruncation_valueCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("风险截断值");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 风险截断值单位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRisktruncation_unitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Risktruncation_unit",  getRisktruncation_unitCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("风险截断值单位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 校正值属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCorrection_valueADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Correction_value",  getCorrection_valueCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("校正值");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 校正值单位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCorrection_unitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Correction_unit",  getCorrection_unitCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("校正值单位");
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
	private IAttrDesc getMemoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Memo",  getMemoCDesc(tblDesc), this);
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
	 * 获取形态学报告单明细主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_rptmoritmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_rptmoritm");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("形态学报告单明细主键"); 
		return column;
	}
	/**
	 * 获取形态学报告ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_perstmorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_perstmor");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("形态学报告ID"); 
		return column;
	}
	/**
	 * 获取体检预约单ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pepsnapptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pepsnappt");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检预约单ID"); 
		return column;
	}
	/**
	 * 获取结果值表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getVal_rstrptlabCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Val_rstrptlab");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("结果值"); 
		return column;
	}
	/**
	 * 获取单位编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_unitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_unit");
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
	private IColumnDesc getName_unitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_unit");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("单位名称"); 
		return column;
	}
	/**
	 * 获取危急值标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_crisisCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_crisis");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("危急值标志"); 
		return column;
	}
	/**
	 * 获取客户编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_pat");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户编码"); 
		return column;
	}
	/**
	 * 获取申请单表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNo_applyformCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"No_applyform");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("申请单"); 
		return column;
	}
	/**
	 * 获取检查分组表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getExaminaimCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Examinaim");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("检查分组"); 
		return column;
	}
	/**
	 * 获取标本号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSamplenoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sampleno");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("标本号"); 
		return column;
	}
	/**
	 * 获取标本类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSampletypeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sampletype");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("标本类型"); 
		return column;
	}
	/**
	 * 获取检验员编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_empCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_emp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("检验员编码"); 
		return column;
	}
	/**
	 * 获取检验设备表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_insmtCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_insmt");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("检验设备"); 
		return column;
	}
	/**
	 * 获取报告日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_rptlabCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_rptlab");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("报告日期"); 
		return column;
	}
	/**
	 * 获取设备编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_insmtCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_insmt");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("设备编码"); 
		return column;
	}
	/**
	 * 获取科室编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_depCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_dep");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("科室编码"); 
		return column;
	}
	/**
	 * 获取项目编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_srvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_srv");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("项目编码"); 
		return column;
	}
	/**
	 * 获取项目名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_srvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_srv");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("项目名称"); 
		return column;
	}
	/**
	 * 获取打印序号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPrintordCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Printord");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("打印序号"); 
		return column;
	}
	/**
	 * 获取原始异常标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_deviateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_deviate");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("原始异常标识"); 
		return column;
	}
	/**
	 * 获取异常标识名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_deviateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_deviate");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("异常标识名称"); 
		return column;
	}
	/**
	 * 获取异常标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMark_deviateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mark_deviate");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("异常标识"); 
		return column;
	}
	/**
	 * 获取箭头标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMark_arrowCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mark_arrow");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("箭头标识"); 
		return column;
	}
	/**
	 * 获取检验人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getReportorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Reportor");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("检验人"); 
		return column;
	}
	/**
	 * 获取检验人编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_reportorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_reportor");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("检验人编码"); 
		return column;
	}
	/**
	 * 获取审核人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getVerifierCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Verifier");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("审核人"); 
		return column;
	}
	/**
	 * 获取审核人编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_verifierCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_verifier");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("审核人编码"); 
		return column;
	}
	/**
	 * 获取审核日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_rptverCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_rptver");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("审核日期"); 
		return column;
	}
	/**
	 * 获取检查分组编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_examgroupCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_examgroup");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("检查分组编码"); 
		return column;
	}
	/**
	 * 获取检查分组名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_examgroupCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_examgroup");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("检查分组名称"); 
		return column;
	}
	/**
	 * 获取就诊类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_entpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_entp");
		column.setLength(50);
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
	private IColumnDesc getName_entpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_entp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊类型名称"); 
		return column;
	}
	/**
	 * 获取骨髓片平均值表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAvg_valueCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Avg_value");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("骨髓片平均值"); 
		return column;
	}
	/**
	 * 获取骨髓片平均值单位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAvg_unitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Avg_unit");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("骨髓片平均值单位"); 
		return column;
	}
	/**
	 * 获取骨髓片+/-SD表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_valueCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_value");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("骨髓片+/-SD"); 
		return column;
	}
	/**
	 * 获取骨髓片+/-SD单位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_unitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_unit");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("骨髓片+/-SD单位"); 
		return column;
	}
	/**
	 * 获取正常参考范围值表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNormal_valueCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Normal_value");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("正常参考范围值"); 
		return column;
	}
	/**
	 * 获取正常参考范围值单位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNormal_unitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Normal_unit");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("正常参考范围值单位"); 
		return column;
	}
	/**
	 * 获取风险值表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRisk_valueCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Risk_value");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("风险值"); 
		return column;
	}
	/**
	 * 获取风险值单位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRisk_unitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Risk_unit");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("风险值单位"); 
		return column;
	}
	/**
	 * 获取年龄风险值表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAgerisk_valueCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Agerisk_value");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("年龄风险值"); 
		return column;
	}
	/**
	 * 获取年龄风险值单位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAgerisk_unitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Agerisk_unit");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("年龄风险值单位"); 
		return column;
	}
	/**
	 * 获取风险截断值表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRisktruncation_valueCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Risktruncation_value");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("风险截断值"); 
		return column;
	}
	/**
	 * 获取风险截断值单位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRisktruncation_unitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Risktruncation_unit");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("风险截断值单位"); 
		return column;
	}
	/**
	 * 获取校正值表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCorrection_valueCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Correction_value");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("校正值"); 
		return column;
	}
	/**
	 * 获取校正值单位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCorrection_unitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Correction_unit");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("校正值单位"); 
		return column;
	}
	/**
	 * 获取备注表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMemoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Memo");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备注"); 
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
