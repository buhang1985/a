
package iih.pe.pqn.peqaca.d.desc;

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
 * 体检问卷组套明细 DO 元数据信息
 */
public class PeQaCaItmDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.pe.pqn.peqaca.d.PeQaCaItmDO";
	public static final String CLASS_DISPALYNAME = "体检问卷组套明细";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "pe_qn_peqacaitm";
	public static final String TABLE_ALIAS_NAME = "a1";
	public static final String PRIMARYKEY_FIELDNAME="Id_peqacaitm";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public PeQaCaItmDODesc(){
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
		this.setKeyDesc(getId_peqacaitmADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_peqacaADesc(tblDesc));
		this.add(getId_peqacaitmADesc(tblDesc));
		this.add(getId_peqacaADesc(tblDesc));
		this.add(getId_peqacontentdefADesc(tblDesc));
		this.add(getSortnoADesc(tblDesc));
		this.add(getDofieldADesc(tblDesc));
		this.add(getName_peqaADesc(tblDesc));
		this.add(getCodeADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_peqacaitmCDesc(tblDesc));
		tblDesc.add(getId_peqacaitmCDesc(tblDesc));
		tblDesc.add(getId_peqacaCDesc(tblDesc));
		tblDesc.add(getId_peqacontentdefCDesc(tblDesc));
		tblDesc.add(getSortnoCDesc(tblDesc));
		tblDesc.add(getDofieldCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 体检问卷组套明细主键标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_peqacaitmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_peqacaitm",  getId_peqacaitmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检问卷组套明细主键标识");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检问卷组套ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_peqacaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_peqaca",  getId_peqacaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检问卷组套ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检问卷问题库ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_peqacontentdefADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_peqacontentdef",  getId_peqacontentdefCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检问卷问题库ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 排序属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSortnoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sortno",  getSortnoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("排序");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 对应DO字段属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDofieldADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dofield",  getDofieldCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("对应DO字段");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检问卷问题属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_peqaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_peqa",  getName_peqaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检问卷问题");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_qn_peqacontentdef a1b3","id_peqacontentdef=id_peqacontentdef","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检问卷问题编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code",  getCodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检问卷问题编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_qn_peqacontentdef a1b3","id_peqacontentdef=id_peqacontentdef","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取体检问卷组套明细主键标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_peqacaitmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_peqacaitm");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("体检问卷组套明细主键标识"); 
		return column;
	}
	/**
	 * 获取体检问卷组套ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_peqacaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_peqaca");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检问卷组套ID"); 
		return column;
	}
	/**
	 * 获取体检问卷问题库ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_peqacontentdefCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_peqacontentdef");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检问卷问题库ID"); 
		return column;
	}
	/**
	 * 获取排序表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSortnoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sortno");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("排序"); 
		return column;
	}
	/**
	 * 获取对应DO字段表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDofieldCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dofield");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("对应DO字段"); 
		return column;
	}
	/**
	 * 获取体检问卷问题表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_peqaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_peqa");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检问卷问题"); 
		return column;
	}
	/**
	 * 获取体检问卷问题编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检问卷问题编码"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id","Id_peqacaitm");
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
