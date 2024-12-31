
package iih.pe.pitm.perulecombine.d.desc;

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
 * 体检组合规则定义明细 DO 元数据信息
 */
public class PeRuleCombineItemDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.pe.pitm.perulecombine.d.PeRuleCombineItemDO";
	public static final String CLASS_DISPALYNAME = "体检组合规则定义明细";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "pe_itm_rulecombineitem";
	public static final String TABLE_ALIAS_NAME = "a1";
	public static final String PRIMARYKEY_FIELDNAME="Id_perulecombineitem";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public PeRuleCombineItemDODesc(){
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
		this.setKeyDesc(getId_perulecombineitemADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_perulecombineADesc(tblDesc));
		this.add(getId_perulecombineitemADesc(tblDesc));
		this.add(getId_perulecombineADesc(tblDesc));
		this.add(getId_peruledefADesc(tblDesc));
		this.add(getCode_ruleADesc(tblDesc));
		this.add(getName_ruleADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_perulecombineitemCDesc(tblDesc));
		tblDesc.add(getId_perulecombineitemCDesc(tblDesc));
		tblDesc.add(getId_perulecombineCDesc(tblDesc));
		tblDesc.add(getId_peruledefCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 体检规则组合明细主键标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_perulecombineitemADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_perulecombineitem",  getId_perulecombineitemCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检规则组合明细主键标识");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检规则组合ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_perulecombineADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_perulecombine",  getId_perulecombineCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检规则组合ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 体检规则ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_peruledefADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_peruledef",  getId_peruledefCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检规则ID");
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
	private IAttrDesc getCode_ruleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_rule",  getCode_ruleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("规则编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_itm_perules a1b3","id_peruledef=id_peruledef","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 规则名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_ruleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_rule",  getName_ruleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("规则名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_itm_perules a1b3","id_peruledef=id_peruledef","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取体检规则组合明细主键标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_perulecombineitemCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_perulecombineitem");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("体检规则组合明细主键标识"); 
		return column;
	}
	/**
	 * 获取体检规则组合ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_perulecombineCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_perulecombine");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检规则组合ID"); 
		return column;
	}
	/**
	 * 获取体检规则ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_peruledefCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_peruledef");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检规则ID"); 
		return column;
	}
	/**
	 * 获取规则编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_ruleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_rule");
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
	private IColumnDesc getName_ruleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_rule");
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
