
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
 * 体检规则排他性定义 DO 元数据信息
 */
public class PeRuleExclusiveDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.pe.pitm.perules.d.PeRuleExclusiveDO";
	public static final String CLASS_DISPALYNAME = "体检规则排他性定义";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "pe_itm_peruleexclusive";
	public static final String TABLE_ALIAS_NAME = "a4";
	public static final String PRIMARYKEY_FIELDNAME="Id_peruleexclusive";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public PeRuleExclusiveDODesc(){
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
		this.setKeyDesc(getId_peruleexclusiveADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_peruledefADesc(tblDesc));
		this.add(getId_peruleexclusiveADesc(tblDesc));
		this.add(getId_peruledefADesc(tblDesc));
		this.add(getId_peruledef_exADesc(tblDesc));
		this.add(getName_ruleexADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_peruleexclusiveCDesc(tblDesc));
		tblDesc.add(getId_peruleexclusiveCDesc(tblDesc));
		tblDesc.add(getId_peruledefCDesc(tblDesc));
		tblDesc.add(getId_peruledef_exCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 体检规则排他定义主键标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_peruleexclusiveADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_peruleexclusive",  getId_peruleexclusiveCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检规则排他定义主键标识");
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
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 排他规则编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_peruledef_exADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_peruledef_ex",  getId_peruledef_exCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("排他规则编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 规则名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_ruleexADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_ruleex",  getName_ruleexCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("规则名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_itm_perules a4b2","id_peruledef_ex=id_peruledef","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取体检规则排他定义主键标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_peruleexclusiveCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_peruleexclusive");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("体检规则排他定义主键标识"); 
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
	 * 获取排他规则编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_peruledef_exCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_peruledef_ex");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("排他规则编码"); 
		return column;
	}
	/**
	 * 获取规则名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_ruleexCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_ruleex");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("规则名称"); 
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
