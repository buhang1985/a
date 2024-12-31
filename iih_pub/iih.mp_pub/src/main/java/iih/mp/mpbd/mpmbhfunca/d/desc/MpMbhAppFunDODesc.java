
package iih.mp.mpbd.mpmbhfunca.d.desc;

import java.sql.Types;
import java.util.HashMap;

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

/**
 * 移动医疗app功能 DO 元数据信息
 */
public class MpMbhAppFunDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.mp.mpbd.mpmbhfunca.d.MpMbhAppFunDO";
	public static final String CLASS_DISPALYNAME = "移动医疗app功能";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "mp_mbh_app_fun";
	public static final String TABLE_ALIAS_NAME = "a1";
	public static final String PRIMARYKEY_FIELDNAME="Id_mbh_app_fun";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public MpMbhAppFunDODesc(){
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
		this.setKeyDesc(getId_mbh_app_funADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_mbh_app_funcaADesc(tblDesc));
		this.add(getId_mbh_app_funADesc(tblDesc));
		this.add(getId_mbh_app_funcaADesc(tblDesc));
		this.add(getId_funADesc(tblDesc));
		this.add(getFuncodeADesc(tblDesc));
		this.add(getName_funADesc(tblDesc));
		this.add(getSnoADesc(tblDesc));
		this.add(getIconADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getFunca_nameADesc(tblDesc));
		this.add(getFun_codeADesc(tblDesc));
		this.add(getFun_nameADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_mbh_app_funCDesc(tblDesc));
		tblDesc.add(getId_mbh_app_funCDesc(tblDesc));
		tblDesc.add(getId_mbh_app_funcaCDesc(tblDesc));
		tblDesc.add(getId_funCDesc(tblDesc));
		tblDesc.add(getFuncodeCDesc(tblDesc));
		tblDesc.add(getName_funCDesc(tblDesc));
		tblDesc.add(getSnoCDesc(tblDesc));
		tblDesc.add(getIconCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 移动医疗APP功能主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mbh_app_funADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mbh_app_fun",  getId_mbh_app_funCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("移动医疗APP功能主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 移动医疗APP功能分类ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mbh_app_funcaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mbh_app_funca",  getId_mbh_app_funcaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("移动医疗APP功能分类ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 关键功能节点属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_funADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_fun",  getId_funCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("关键功能节点");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 功能节点编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFuncodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Funcode",  getFuncodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("功能节点编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 功能名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_funADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_fun",  getName_funCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("功能名称");
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
	private IAttrDesc getSnoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sno",  getSnoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("序号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 图片属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIconADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Icon",  getIconCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("图片");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
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
	 * 分类名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFunca_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Funca_name",  getFunca_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("分类名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"mp_mbh_app_ca a1b2","id_mbh_app_funca=id_mbh_app_funca","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 功能编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFun_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fun_code",  getFun_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("功能编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sys_funcreg a1b3","id_fun=id_fun","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 功能名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFun_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fun_name",  getFun_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("功能名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sys_funcreg a1b3","id_fun=id_fun","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取移动医疗APP功能主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mbh_app_funCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mbh_app_fun");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("移动医疗APP功能主键"); 
		return column;
	}
	/**
	 * 获取移动医疗APP功能分类ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mbh_app_funcaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mbh_app_funca");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("移动医疗APP功能分类ID"); 
		return column;
	}
	/**
	 * 获取关键功能节点表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_funCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_fun");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("关键功能节点"); 
		return column;
	}
	/**
	 * 获取功能节点编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFuncodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Funcode");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("功能节点编码"); 
		return column;
	}
	/**
	 * 获取功能名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_funCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_fun");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("功能名称"); 
		return column;
	}
	/**
	 * 获取序号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSnoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sno");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("序号"); 
		return column;
	}
	/**
	 * 获取图片表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIconCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Icon");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("图片"); 
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
	 * 获取分类名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFunca_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Funca_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("分类名称"); 
		return column;
	}
	/**
	 * 获取功能编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFun_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fun_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("功能编码"); 
		return column;
	}
	/**
	 * 获取功能名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFun_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fun_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("功能名称"); 
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
