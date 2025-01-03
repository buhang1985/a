
package iih.bd.res.bed.d.desc;

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
 * 床位特征 DO 元数据信息
 */
public class BedAttrDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.bd.res.bed.d.BedAttrDO";
	public static final String CLASS_DISPALYNAME = "床位特征";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "BD_BED_ATTR";
	public static final String TABLE_ALIAS_NAME = "a2";
	public static final String PRIMARYKEY_FIELDNAME="Id_bedattr";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public BedAttrDODesc(){
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
		this.setKeyDesc(getId_bedattrADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_bedADesc(tblDesc));
		this.add(getId_bedattrADesc(tblDesc));
		this.add(getId_bedADesc(tblDesc));
		this.add(getId_bedattr_tpADesc(tblDesc));
		this.add(getSd_bedattr_tpADesc(tblDesc));
		this.add(getName_bedattr_tpADesc(tblDesc));
		this.add(getValADesc(tblDesc));
		this.add(getId_attrdefADesc(tblDesc));
		this.add(getBedattr_tp_nameADesc(tblDesc));
		this.add(getAttrdef_nameADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_bedattrCDesc(tblDesc));
		tblDesc.add(getId_bedattrCDesc(tblDesc));
		tblDesc.add(getId_bedCDesc(tblDesc));
		tblDesc.add(getId_bedattr_tpCDesc(tblDesc));
		tblDesc.add(getSd_bedattr_tpCDesc(tblDesc));
		tblDesc.add(getName_bedattr_tpCDesc(tblDesc));
		tblDesc.add(getValCDesc(tblDesc));
		tblDesc.add(getId_attrdefCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 床位属性id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_bedattrADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_bedattr",  getId_bedattrCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("床位属性id");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 床位id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_bedADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_bed",  getId_bedCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("床位id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 特征类型id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_bedattr_tpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_bedattr_tp",  getId_bedattr_tpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("特征类型id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 特征类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_bedattr_tpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_bedattr_tp",  getSd_bedattr_tpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("特征类型编码");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 特征类型名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_bedattr_tpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_bedattr_tp",  getName_bedattr_tpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("特征类型名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 特征值属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getValADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Val",  getValCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("特征值");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 特征值Id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_attrdefADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_attrdef",  getId_attrdefCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("特征值Id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 特征类型名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBedattr_tp_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Bedattr_tp_name",  getBedattr_tp_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("特征类型名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a2b3","id_bedattr_tp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 特征值名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAttrdef_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Attrdef_name",  getAttrdef_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("特征值名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"BD_BED_ATTR_DEF a2b5","id_attrdef=id_bedattrdef","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取床位属性id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_bedattrCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_bedattr");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("床位属性id"); 
		return column;
	}
	/**
	 * 获取床位id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_bedCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_bed");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("床位id"); 
		return column;
	}
	/**
	 * 获取特征类型id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_bedattr_tpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_bedattr_tp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("特征类型id"); 
		return column;
	}
	/**
	 * 获取特征类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_bedattr_tpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_bedattr_tp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("特征类型编码"); 
		return column;
	}
	/**
	 * 获取特征类型名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_bedattr_tpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_bedattr_tp");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("特征类型名称"); 
		return column;
	}
	/**
	 * 获取特征值表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getValCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Val");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("特征值"); 
		return column;
	}
	/**
	 * 获取特征值Id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_attrdefCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_attrdef");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("特征值Id"); 
		return column;
	}
	/**
	 * 获取特征类型名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBedattr_tp_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Bedattr_tp_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("特征类型名称"); 
		return column;
	}
	/**
	 * 获取特征值名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAttrdef_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Attrdef_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("特征值名称"); 
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
