
package iih.bd.mm.materialnames.d.desc;

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
 * 药品通用名编码集 DO 元数据信息
 */
public class MnCodeSetDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.bd.mm.materialnames.d.MnCodeSetDO";
	public static final String CLASS_DISPALYNAME = "药品通用名编码集";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "default";
	public static final String TABLE_ALIAS_NAME = "a2";
	public static final String PRIMARYKEY_FIELDNAME="Id_codeset";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public MnCodeSetDODesc(){
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
		this.setKeyDesc(getId_codesetADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_materialnameADesc(tblDesc));
		this.add(getId_codesetADesc(tblDesc));
		this.add(getId_materialnameADesc(tblDesc));
		this.add(getId_cdstdADesc(tblDesc));
		this.add(getSd_cdstdADesc(tblDesc));
		this.add(getCodeADesc(tblDesc));
		this.add(getName_cdstdADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_codesetCDesc(tblDesc));
		tblDesc.add(getId_codesetCDesc(tblDesc));
		tblDesc.add(getId_materialnameCDesc(tblDesc));
		tblDesc.add(getId_cdstdCDesc(tblDesc));
		tblDesc.add(getSd_cdstdCDesc(tblDesc));
		tblDesc.add(getCodeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 服务项目编码主键标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_codesetADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_codeset",  getId_codesetCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务项目编码主键标识");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 药品通用名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_materialnameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_materialname",  getId_materialnameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("药品通用名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 对照编码标准属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_cdstdADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_cdstd",  getId_cdstdCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("对照编码标准");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 对照编码标准编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_cdstdADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_cdstd",  getSd_cdstdCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("对照编码标准编码");
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
	private IAttrDesc getCodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code",  getCodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 对照编码标准名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_cdstdADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_cdstd",  getName_cdstdCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("对照编码标准名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a2b2","id_cdstd=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取服务项目编码主键标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_codesetCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_codeset");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("服务项目编码主键标识"); 
		return column;
	}
	/**
	 * 获取药品通用名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_materialnameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_materialname");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("药品通用名"); 
		return column;
	}
	/**
	 * 获取对照编码标准表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_cdstdCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_cdstd");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("对照编码标准"); 
		return column;
	}
	/**
	 * 获取对照编码标准编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_cdstdCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_cdstd");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("对照编码标准编码"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取对照编码标准名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_cdstdCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_cdstd");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("对照编码标准名称"); 
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
