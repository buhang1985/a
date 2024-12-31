
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
 * 体检健康平台明细表 DO 元数据信息
 */
public class PeEmrPhysicalExamItemDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.pe.pwf.pehealthplatform.d.PeEmrPhysicalExamItemDO";
	public static final String CLASS_DISPALYNAME = "体检健康平台明细表";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "emr_physical_exam_item";
	public static final String TABLE_ALIAS_NAME = "${EntityMeta.entityClassMeta.aliasName}";
	public static final String PRIMARYKEY_FIELDNAME="Id";
	
	/**
	 * 无参构造函数
	 */
	public PeEmrPhysicalExamItemDODesc(){
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
		this.add(getItem_codeADesc(tblDesc));
		this.add(getItem_nameADesc(tblDesc));
		this.add(getResult_typeADesc(tblDesc));
		this.add(getResult_valueADesc(tblDesc));
		this.add(getAttached_resultADesc(tblDesc));
		this.add(getResult_unitADesc(tblDesc));
		this.add(getRefer_value_lowerADesc(tblDesc));
		this.add(getRefer_value_upperADesc(tblDesc));
		this.add(getNotesADesc(tblDesc));
		this.add(getResult_explainADesc(tblDesc));
		this.add(getResult_explain_nameADesc(tblDesc));
		this.add(getEffective_timeADesc(tblDesc));
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
		tblDesc.add(getItem_codeCDesc(tblDesc));
		tblDesc.add(getItem_nameCDesc(tblDesc));
		tblDesc.add(getResult_typeCDesc(tblDesc));
		tblDesc.add(getResult_valueCDesc(tblDesc));
		tblDesc.add(getAttached_resultCDesc(tblDesc));
		tblDesc.add(getResult_unitCDesc(tblDesc));
		tblDesc.add(getRefer_value_lowerCDesc(tblDesc));
		tblDesc.add(getRefer_value_upperCDesc(tblDesc));
		tblDesc.add(getNotesCDesc(tblDesc));
		tblDesc.add(getResult_explainCDesc(tblDesc));
		tblDesc.add(getResult_explain_nameCDesc(tblDesc));
		tblDesc.add(getEffective_timeCDesc(tblDesc));
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
	 * displaynam24属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getExam_type_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Exam_type_name",  getExam_type_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("displaynam24");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检项目编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getItem_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Item_code",  getItem_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检项目编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检项目名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getItem_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Item_name",  getItem_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检项目名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 结果类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getResult_typeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Result_type",  getResult_typeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("结果类型");
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
	private IAttrDesc getResult_valueADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Result_value",  getResult_valueCDesc(tblDesc), this);
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
	 * 附属结果属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAttached_resultADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Attached_result",  getAttached_resultCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("附属结果");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 单位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getResult_unitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Result_unit",  getResult_unitCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("单位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 正常参考值下限属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRefer_value_lowerADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Refer_value_lower",  getRefer_value_lowerCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("正常参考值下限");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 正常参考值上限属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRefer_value_upperADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Refer_value_upper",  getRefer_value_upperCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("正常参考值上限");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 参考值备注属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNotesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Notes",  getNotesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("参考值备注");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 结果值的解释属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getResult_explainADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Result_explain",  getResult_explainCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("结果值的解释");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * displaynam25属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getResult_explain_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Result_explain_name",  getResult_explain_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("displaynam25");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 活动发生时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEffective_timeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Effective_time",  getEffective_timeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("活动发生时间");
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
		column.setLength(100);
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
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检类别编码"); 
		return column;
	}
	/**
	 * 获取displaynam24表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getExam_type_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Exam_type_name");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("displaynam24"); 
		return column;
	}
	/**
	 * 获取体检项目编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getItem_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Item_code");
		column.setLength(100);
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
	private IColumnDesc getItem_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Item_name");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检项目名称"); 
		return column;
	}
	/**
	 * 获取结果类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getResult_typeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Result_type");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("结果类型"); 
		return column;
	}
	/**
	 * 获取结果值表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getResult_valueCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Result_value");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("结果值"); 
		return column;
	}
	/**
	 * 获取附属结果表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAttached_resultCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Attached_result");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("附属结果"); 
		return column;
	}
	/**
	 * 获取单位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getResult_unitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Result_unit");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("单位"); 
		return column;
	}
	/**
	 * 获取正常参考值下限表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRefer_value_lowerCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Refer_value_lower");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("正常参考值下限"); 
		return column;
	}
	/**
	 * 获取正常参考值上限表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRefer_value_upperCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Refer_value_upper");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("正常参考值上限"); 
		return column;
	}
	/**
	 * 获取参考值备注表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNotesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Notes");
		column.setLength(2000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("参考值备注"); 
		return column;
	}
	/**
	 * 获取结果值的解释表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getResult_explainCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Result_explain");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("结果值的解释"); 
		return column;
	}
	/**
	 * 获取displaynam25表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getResult_explain_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Result_explain_name");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("displaynam25"); 
		return column;
	}
	/**
	 * 获取活动发生时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEffective_timeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Effective_time");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("活动发生时间"); 
		return column;
	}
	/**
	 * 获取组织机构代码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOrg_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Org_code");
		column.setLength(100);
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
		column.setLength(100);
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
		column.setLength(100);
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
		column.setLength(100);
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
		iBDDataInfoFldMap.put("id","Id_result");
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
