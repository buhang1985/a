
package iih.ci.mrm.healthsystem.d.desc;

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
 * 字段校验规则 DO 元数据信息
 */
public class FieldCheckRuleDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.ci.mrm.healthsystem.d.FieldCheckRuleDO";
	public static final String CLASS_DISPALYNAME = "字段校验规则";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "ci_mrm_check_rule";
	public static final String TABLE_ALIAS_NAME = "a2";
	public static final String PRIMARYKEY_FIELDNAME="Id_check";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public FieldCheckRuleDODesc(){
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
		this.setKeyDesc(getId_checkADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_field_comparisonADesc(tblDesc));
		this.add(getId_checkADesc(tblDesc));
		this.add(getId_field_comparisonADesc(tblDesc));
		this.add(getRule_codeADesc(tblDesc));
		this.add(getRule_nameADesc(tblDesc));
		this.add(getScript_typeADesc(tblDesc));
		this.add(getCheck_scriptADesc(tblDesc));
		this.add(getCheck_failed_colorADesc(tblDesc));
		this.add(getForce_check_markADesc(tblDesc));
		this.add(getEnableADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_checkCDesc(tblDesc));
		tblDesc.add(getId_checkCDesc(tblDesc));
		tblDesc.add(getId_field_comparisonCDesc(tblDesc));
		tblDesc.add(getRule_codeCDesc(tblDesc));
		tblDesc.add(getRule_nameCDesc(tblDesc));
		tblDesc.add(getScript_typeCDesc(tblDesc));
		tblDesc.add(getCheck_scriptCDesc(tblDesc));
		tblDesc.add(getCheck_failed_colorCDesc(tblDesc));
		tblDesc.add(getForce_check_markCDesc(tblDesc));
		tblDesc.add(getEnableCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 校验主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_checkADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_check",  getId_checkCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("校验主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 字段转换外键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_field_comparisonADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_field_comparison",  getId_field_comparisonCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("字段转换外键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 规则编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRule_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Rule_code",  getRule_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("规则编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 规则名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRule_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Rule_name",  getRule_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("规则名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 脚本类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getScript_typeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Script_type",  getScript_typeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("脚本类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 校验脚本属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCheck_scriptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Check_script",  getCheck_scriptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("校验脚本");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 校验失败COlOR属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCheck_failed_colorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Check_failed_color",  getCheck_failed_colorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("校验失败COlOR");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 强制校验标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getForce_check_markADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Force_check_mark",  getForce_check_markCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("强制校验标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 启用属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEnableADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Enable",  getEnableCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("启用");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取校验主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_checkCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_check");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("校验主键"); 
		return column;
	}
	/**
	 * 获取字段转换外键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_field_comparisonCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_field_comparison");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("字段转换外键"); 
		return column;
	}
	/**
	 * 获取规则编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRule_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Rule_code");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("规则编码"); 
		return column;
	}
	/**
	 * 获取规则名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRule_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Rule_name");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("规则名称"); 
		return column;
	}
	/**
	 * 获取脚本类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getScript_typeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Script_type");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("脚本类型"); 
		return column;
	}
	/**
	 * 获取校验脚本表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCheck_scriptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Check_script");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("校验脚本"); 
		return column;
	}
	/**
	 * 获取校验失败COlOR表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCheck_failed_colorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Check_failed_color");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("校验失败COlOR"); 
		return column;
	}
	/**
	 * 获取强制校验标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getForce_check_markCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Force_check_mark");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("强制校验标志"); 
		return column;
	}
	/**
	 * 获取启用表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEnableCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Enable");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("启用"); 
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
