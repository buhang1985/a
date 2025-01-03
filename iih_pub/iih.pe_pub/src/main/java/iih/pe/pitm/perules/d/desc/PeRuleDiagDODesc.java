
package iih.pe.pitm.perules.d.desc;

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
 * 体检规则关联诊断 DO 元数据信息
 */
public class PeRuleDiagDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.pe.pitm.perules.d.PeRuleDiagDO";
	public static final String CLASS_DISPALYNAME = "体检规则关联诊断";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "pe_itm_perulediag";
	public static final String TABLE_ALIAS_NAME = "a3";
	public static final String PRIMARYKEY_FIELDNAME="Id_perulediag";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public PeRuleDiagDODesc(){
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
		this.setKeyDesc(getId_perulediagADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_peruledefADesc(tblDesc));
		this.add(getId_perulediagADesc(tblDesc));
		this.add(getId_peruledefADesc(tblDesc));
		this.add(getId_perstdidefADesc(tblDesc));
		this.add(getOperation_typeADesc(tblDesc));
		this.add(getSd_ruleADesc(tblDesc));
		this.add(getSd_diagADesc(tblDesc));
		this.add(getSd_linkADesc(tblDesc));
		this.add(getName_diagADesc(tblDesc));
		this.add(getAdvice_diagADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_perulediagCDesc(tblDesc));
		tblDesc.add(getId_perulediagCDesc(tblDesc));
		tblDesc.add(getId_peruledefCDesc(tblDesc));
		tblDesc.add(getId_perstdidefCDesc(tblDesc));
		tblDesc.add(getOperation_typeCDesc(tblDesc));
		tblDesc.add(getSd_ruleCDesc(tblDesc));
		tblDesc.add(getSd_diagCDesc(tblDesc));
		tblDesc.add(getSd_linkCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 体检规则诊断主键标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_perulediagADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_perulediag",  getId_perulediagCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检规则诊断主键标识");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检异常判断规则ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_peruledefADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_peruledef",  getId_peruledefCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检异常判断规则ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 诊断定义主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_perstdidefADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_perstdidef",  getId_perstdidefCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断定义主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOperation_typeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Operation_type",  getOperation_typeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 规则编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_ruleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_rule",  getSd_ruleCDesc(tblDesc), this);
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
	 * 诊断编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_diagADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_diag",  getSd_diagCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 关联编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_linkADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_link",  getSd_linkCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("关联编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊断名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_diagADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_diag",  getName_diagCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_itm_perstdidef a3b2","id_perstdidef=id_perstdidef","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 直连建议属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAdvice_diagADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Advice_diag",  getAdvice_diagCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("直连建议");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_itm_perstdidef a3b2","id_perstdidef=id_perstdidef","advice"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取体检规则诊断主键标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_perulediagCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_perulediag");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("体检规则诊断主键标识"); 
		return column;
	}
	/**
	 * 获取体检异常判断规则ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_peruledefCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_peruledef");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检异常判断规则ID"); 
		return column;
	}
	/**
	 * 获取诊断定义主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_perstdidefCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_perstdidef");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断定义主键"); 
		return column;
	}
	/**
	 * 获取类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOperation_typeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Operation_type");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("类型"); 
		return column;
	}
	/**
	 * 获取规则编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_ruleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_rule");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("规则编码"); 
		return column;
	}
	/**
	 * 获取诊断编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_diagCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_diag");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断编码"); 
		return column;
	}
	/**
	 * 获取关联编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_linkCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_link");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("关联编码"); 
		return column;
	}
	/**
	 * 获取诊断名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_diagCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_diag");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断名称"); 
		return column;
	}
	/**
	 * 获取直连建议表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAdvice_diagCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Advice_diag");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("直连建议"); 
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
		defaultValueMap.put("Operation_type",2);
	}
	
}
