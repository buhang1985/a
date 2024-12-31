
package iih.pe.pwf.pehealthplatform.d.desc;

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
 * 体检健康平台项目表 DO 元数据信息
 */
public class PeEmrPhysicalExamDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.pe.pwf.pehealthplatform.d.PeEmrPhysicalExamDO";
	public static final String CLASS_DISPALYNAME = "体检健康平台项目表";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "emr_physical_exam";
	public static final String TABLE_ALIAS_NAME = "${EntityMeta.entityClassMeta.aliasName}";
	public static final String PRIMARYKEY_FIELDNAME="Id";
	
	/**
	 * 无参构造函数
	 */
	public PeEmrPhysicalExamDODesc(){
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
		this.setKeyDesc(getIdADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getIdADesc(tblDesc));
		this.add(getHealth_exam_noADesc(tblDesc));
		this.add(getExam_type_codeADesc(tblDesc));
		this.add(getExam_type_nameADesc(tblDesc));
		this.add(getDept_codeADesc(tblDesc));
		this.add(getDept_nameADesc(tblDesc));
		this.add(getDoc_idcardADesc(tblDesc));
		this.add(getDoc_nameADesc(tblDesc));
		this.add(getPerform_dtimeADesc(tblDesc));
		this.add(getSummaryADesc(tblDesc));
		this.add(getOrg_codeADesc(tblDesc));
		this.add(getOrg_nameADesc(tblDesc));
		this.add(getDistrict_codeADesc(tblDesc));
		this.add(getSystem_timeADesc(tblDesc));
		this.add(getExchange_typeADesc(tblDesc));
		
	}
		
	/**
	 * 获得表元数据
	 * @return
	 */
	private ITableDesc getTableDesc(){
		TableDesc tblDesc=new TableDesc(TABLE_NAME,TABLE_ALIAS_NAME);
		tblDesc.setLabel(CLASS_DISPALYNAME);
		tblDesc.setPrimaryKey(getIdCDesc(tblDesc));
		tblDesc.add(getIdCDesc(tblDesc));
		tblDesc.add(getHealth_exam_noCDesc(tblDesc));
		tblDesc.add(getExam_type_codeCDesc(tblDesc));
		tblDesc.add(getExam_type_nameCDesc(tblDesc));
		tblDesc.add(getDept_codeCDesc(tblDesc));
		tblDesc.add(getDept_nameCDesc(tblDesc));
		tblDesc.add(getDoc_idcardCDesc(tblDesc));
		tblDesc.add(getDoc_nameCDesc(tblDesc));
		tblDesc.add(getPerform_dtimeCDesc(tblDesc));
		tblDesc.add(getSummaryCDesc(tblDesc));
		tblDesc.add(getOrg_codeCDesc(tblDesc));
		tblDesc.add(getOrg_nameCDesc(tblDesc));
		tblDesc.add(getDistrict_codeCDesc(tblDesc));
		tblDesc.add(getSystem_timeCDesc(tblDesc));
		tblDesc.add(getExchange_typeCDesc(tblDesc));
	
		return tblDesc;
	}
	
	/**
	 * 主键ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIdADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id",  getIdCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("主键ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 健康体检表编号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHealth_exam_noADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Health_exam_no",  getHealth_exam_noCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("健康体检表编号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检类别编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getExam_type_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Exam_type_code",  getExam_type_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检类别编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检类别名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getExam_type_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Exam_type_name",  getExam_type_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检类别名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 执行科室编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDept_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dept_code",  getDept_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("执行科室编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 执行科室名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDept_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dept_name",  getDept_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("执行科室名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 执行身份证号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDoc_idcardADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Doc_idcard",  getDoc_idcardCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("执行身份证号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 执行医生属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDoc_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Doc_name",  getDoc_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("执行医生");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 执行时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPerform_dtimeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Perform_dtime",  getPerform_dtimeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("执行时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 小结属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSummaryADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Summary",  getSummaryCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("小结");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 组织机构代码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOrg_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Org_code",  getOrg_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("组织机构代码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 组织机构名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOrg_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Org_name",  getOrg_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("组织机构名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 行政区划代码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDistrict_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("District_code",  getDistrict_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("行政区划代码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 时间戳属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSystem_timeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("System_time",  getSystem_timeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("时间戳");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 交换类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getExchange_typeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Exchange_type",  getExchange_typeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("交换类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取主键ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIdCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("主键ID"); 
		return column;
	}
	/**
	 * 获取健康体检表编号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHealth_exam_noCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Health_exam_no");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("健康体检表编号"); 
		return column;
	}
	/**
	 * 获取体检类别编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getExam_type_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Exam_type_code");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检类别编码"); 
		return column;
	}
	/**
	 * 获取体检类别名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getExam_type_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Exam_type_name");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检类别名称"); 
		return column;
	}
	/**
	 * 获取执行科室编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDept_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dept_code");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("执行科室编码"); 
		return column;
	}
	/**
	 * 获取执行科室名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDept_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dept_name");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("执行科室名称"); 
		return column;
	}
	/**
	 * 获取执行身份证号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDoc_idcardCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Doc_idcard");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("执行身份证号"); 
		return column;
	}
	/**
	 * 获取执行医生表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDoc_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Doc_name");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("执行医生"); 
		return column;
	}
	/**
	 * 获取执行时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPerform_dtimeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Perform_dtime");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("执行时间"); 
		return column;
	}
	/**
	 * 获取小结表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSummaryCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Summary");
		column.setLength(1000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("小结"); 
		return column;
	}
	/**
	 * 获取组织机构代码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOrg_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Org_code");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("组织机构代码"); 
		return column;
	}
	/**
	 * 获取组织机构名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOrg_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Org_name");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("组织机构名称"); 
		return column;
	}
	/**
	 * 获取行政区划代码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDistrict_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"District_code");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("行政区划代码"); 
		return column;
	}
	/**
	 * 获取时间戳表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSystem_timeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"System_time");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("时间戳"); 
		return column;
	}
	/**
	 * 获取交换类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getExchange_typeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Exchange_type");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("交换类型"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id","Id_catlogs");
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
