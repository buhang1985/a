
package iih.ci.rcm.contagion.d.desc;

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
 * 新型冠状病毒肺炎附卡 DO 元数据信息
 */
public class NCPDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.ci.rcm.contagion.d.NCPDO";
	public static final String CLASS_DISPALYNAME = "新型冠状病毒肺炎附卡";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "CI_MR_CONTAGION_CARD_NCP";
	public static final String TABLE_ALIAS_NAME = "a7";
	public static final String PRIMARYKEY_FIELDNAME="Id_contagion_ncp";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public NCPDODesc(){
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
		this.setKeyDesc(getId_contagion_ncpADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_contagionADesc(tblDesc));
		this.add(getId_contagion_ncpADesc(tblDesc));
		this.add(getId_contagionADesc(tblDesc));
		this.add(getId_formADesc(tblDesc));
		this.add(getId_ci_severityADesc(tblDesc));
		this.add(getSd_ci_severityADesc(tblDesc));
		this.add(getName_ci_severityADesc(tblDesc));
		this.add(getOut_dateADesc(tblDesc));
		this.add(getFg_importedADesc(tblDesc));
		this.add(getRegionADesc(tblDesc));
		this.add(getCode_sevADesc(tblDesc));
		this.add(getName_sevADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_contagion_ncpCDesc(tblDesc));
		tblDesc.add(getId_contagion_ncpCDesc(tblDesc));
		tblDesc.add(getId_contagionCDesc(tblDesc));
		tblDesc.add(getId_formCDesc(tblDesc));
		tblDesc.add(getId_ci_severityCDesc(tblDesc));
		tblDesc.add(getSd_ci_severityCDesc(tblDesc));
		tblDesc.add(getName_ci_severityCDesc(tblDesc));
		tblDesc.add(getOut_dateCDesc(tblDesc));
		tblDesc.add(getFg_importedCDesc(tblDesc));
		tblDesc.add(getRegionCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 新冠肺炎附卡ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_contagion_ncpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_contagion_ncp",  getId_contagion_ncpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("新冠肺炎附卡ID");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 父ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_contagionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_contagion",  getId_contagionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("父ID");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 表单属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_formADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_form",  getId_formCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("表单");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 临床严重程度属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ci_severityADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ci_severity",  getId_ci_severityCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("临床严重程度");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 临床严重程度编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_ci_severityADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_ci_severity",  getSd_ci_severityCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("临床严重程度编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 临床严重程度名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_ci_severityADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_ci_severity",  getName_ci_severityCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("临床严重程度名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 出院或者解除隔离日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOut_dateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Out_date",  getOut_dateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("出院或者解除隔离日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否输入病例属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_importedADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_imported",  getFg_importedCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否输入病例");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 入境前居住或旅行的国家或地区属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRegionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Region",  getRegionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入境前居住或旅行的国家或地区");
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
	private IAttrDesc getCode_sevADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_sev",  getCode_sevCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a7b2","id_ci_severity=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_sevADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_sev",  getName_sevCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a7b2","id_ci_severity=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取新冠肺炎附卡ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_contagion_ncpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_contagion_ncp");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("新冠肺炎附卡ID"); 
		return column;
	}
	/**
	 * 获取父ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_contagionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_contagion");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("父ID"); 
		return column;
	}
	/**
	 * 获取表单表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_formCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_form");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("表单"); 
		return column;
	}
	/**
	 * 获取临床严重程度表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ci_severityCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ci_severity");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("临床严重程度"); 
		return column;
	}
	/**
	 * 获取临床严重程度编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_ci_severityCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_ci_severity");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("临床严重程度编码"); 
		return column;
	}
	/**
	 * 获取临床严重程度名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_ci_severityCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_ci_severity");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("临床严重程度名称"); 
		return column;
	}
	/**
	 * 获取出院或者解除隔离日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOut_dateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Out_date");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("出院或者解除隔离日期"); 
		return column;
	}
	/**
	 * 获取是否输入病例表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_importedCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_imported");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否输入病例"); 
		return column;
	}
	/**
	 * 获取入境前居住或旅行的国家或地区表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRegionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Region");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入境前居住或旅行的国家或地区"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_sevCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_sev");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_sevCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_sev");
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
