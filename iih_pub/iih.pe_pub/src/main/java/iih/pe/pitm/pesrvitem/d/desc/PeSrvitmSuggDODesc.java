
package iih.pe.pitm.pesrvitem.d.desc;

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
 * 体检结果与建议关联 DO 元数据信息
 */
public class PeSrvitmSuggDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.pe.pitm.pesrvitem.d.PeSrvitmSuggDO";
	public static final String CLASS_DISPALYNAME = "体检结果与建议关联";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "pe_itm_peitmsugg";
	public static final String TABLE_ALIAS_NAME = "a2";
	public static final String PRIMARYKEY_FIELDNAME="Id_pesrvitmsugg";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public PeSrvitmSuggDODesc(){
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
		this.setKeyDesc(getId_pesrvitmsuggADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_pesrvitemADesc(tblDesc));
		this.add(getId_pesrvitmsuggADesc(tblDesc));
		this.add(getId_pesrvitemADesc(tblDesc));
		this.add(getId_perstsuggdefADesc(tblDesc));
		this.add(getName_suggADesc(tblDesc));
		this.add(getCode_suggADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_pesrvitmsuggCDesc(tblDesc));
		tblDesc.add(getId_pesrvitmsuggCDesc(tblDesc));
		tblDesc.add(getId_pesrvitemCDesc(tblDesc));
		tblDesc.add(getId_perstsuggdefCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 体检检查结果关联建议主键标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pesrvitmsuggADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pesrvitmsugg",  getId_pesrvitmsuggCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检检查结果关联建议主键标识");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检结果ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pesrvitemADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pesrvitem",  getId_pesrvitemCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检结果ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 关联建议ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_perstsuggdefADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_perstsuggdef",  getId_perstsuggdefCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("关联建议ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 建议名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_suggADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_sugg",  getName_suggCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("建议名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_itm_perstsuggdef a2b2","id_perstsuggdef=id_perstsuggdef","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 建议编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_suggADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_sugg",  getCode_suggCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("建议编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_itm_perstsuggdef a2b2","id_perstsuggdef=id_perstsuggdef","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取体检检查结果关联建议主键标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pesrvitmsuggCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pesrvitmsugg");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("体检检查结果关联建议主键标识"); 
		return column;
	}
	/**
	 * 获取体检结果ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pesrvitemCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pesrvitem");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检结果ID"); 
		return column;
	}
	/**
	 * 获取关联建议ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_perstsuggdefCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_perstsuggdef");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("关联建议ID"); 
		return column;
	}
	/**
	 * 获取建议名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_suggCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_sugg");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("建议名称"); 
		return column;
	}
	/**
	 * 获取建议编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_suggCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_sugg");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("建议编码"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id","Id_pesrvitmsugg");
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
