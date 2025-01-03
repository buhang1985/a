
package iih.pe.pwf.perstimg.d.desc;

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
 * 体检结果文档附件 DO 元数据信息
 */
public class PeRstImgDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.pe.pwf.perstimg.d.PeRstImgDO";
	public static final String CLASS_DISPALYNAME = "体检结果文档附件";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "pe_wf_perstimg";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_perstimg";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public PeRstImgDODesc(){
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
		this.setKeyDesc(getId_perstimgADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_perstimgADesc(tblDesc));
		this.add(getId_perstADesc(tblDesc));
		this.add(getId_pepsnapptADesc(tblDesc));
		this.add(getDoc_descADesc(tblDesc));
		this.add(getSortnoADesc(tblDesc));
		this.add(getDoctpADesc(tblDesc));
		this.add(getDt_examADesc(tblDesc));
		this.add(getDt_reportADesc(tblDesc));
		this.add(getDocsADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getPdfADesc(tblDesc));
		this.add(getPatcodeADesc(tblDesc));
		this.add(getTimes_inhosADesc(tblDesc));
		this.add(getNo_applyADesc(tblDesc));
		this.add(getCode_sysADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_perstimgCDesc(tblDesc));
		tblDesc.add(getId_perstimgCDesc(tblDesc));
		tblDesc.add(getId_perstCDesc(tblDesc));
		tblDesc.add(getId_pepsnapptCDesc(tblDesc));
		tblDesc.add(getDoc_descCDesc(tblDesc));
		tblDesc.add(getSortnoCDesc(tblDesc));
		tblDesc.add(getDoctpCDesc(tblDesc));
		tblDesc.add(getDt_examCDesc(tblDesc));
		tblDesc.add(getDt_reportCDesc(tblDesc));
		tblDesc.add(getDocsCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		tblDesc.add(getPdfCDesc(tblDesc));
		tblDesc.add(getPatcodeCDesc(tblDesc));
		tblDesc.add(getTimes_inhosCDesc(tblDesc));
		tblDesc.add(getNo_applyCDesc(tblDesc));
		tblDesc.add(getCode_sysCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 体检结果文档主键标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_perstimgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_perstimg",  getId_perstimgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检结果文档主键标识");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检结果主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_perstADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_perst",  getId_perstCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检结果主键");
		attrDesc.setNullable(true);
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
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 文档描述属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDoc_descADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Doc_desc",  getDoc_descCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("文档描述");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 序号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSortnoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sortno",  getSortnoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("序号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 文档类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDoctpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Doctp",  getDoctpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("文档类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 检查时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_examADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_exam",  getDt_examCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("检查时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 报告时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_reportADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_report",  getDt_reportCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("报告时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 原始文档属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDocsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Docs",  getDocsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Object);
		attrDesc.setLabel("原始文档");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
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
	 * pdf格式文件属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPdfADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pdf",  getPdfCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("pdf格式文件");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPatcodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Patcode",  getPatcodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 就诊次数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTimes_inhosADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Times_inhos",  getTimes_inhosCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("就诊次数");
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
	 * 系统编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_sysADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_sys",  getCode_sysCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("系统编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取体检结果文档主键标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_perstimgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_perstimg");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("体检结果文档主键标识"); 
		return column;
	}
	/**
	 * 获取体检结果主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_perstCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_perst");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检结果主键"); 
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
	 * 获取文档描述表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDoc_descCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Doc_desc");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("文档描述"); 
		return column;
	}
	/**
	 * 获取序号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSortnoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sortno");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("序号"); 
		return column;
	}
	/**
	 * 获取文档类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDoctpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Doctp");
		column.setLength(20);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("文档类型"); 
		return column;
	}
	/**
	 * 获取检查时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_examCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_exam");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("检查时间"); 
		return column;
	}
	/**
	 * 获取报告时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_reportCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_report");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("报告时间"); 
		return column;
	}
	/**
	 * 获取原始文档表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDocsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Docs");
		column.setLength(0);
        column.setSqlType(Types.BLOB);
		column.setNullable(true);
		column.setLabel("原始文档"); 
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
	 * 获取pdf格式文件表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPdfCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pdf");
		column.setLength(0);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("pdf格式文件"); 
		return column;
	}
	/**
	 * 获取患者编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPatcodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Patcode");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者编码"); 
		return column;
	}
	/**
	 * 获取就诊次数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTimes_inhosCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Times_inhos");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("就诊次数"); 
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
	 * 获取系统编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_sysCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_sys");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("系统编码"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id","Id_perstimg");
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
	}
	
}
