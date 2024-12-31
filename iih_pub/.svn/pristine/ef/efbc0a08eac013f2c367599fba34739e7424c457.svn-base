
package iih.ei.itf.eiitfresultdo.d.desc;

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
 * 接口出参DO DO 元数据信息
 */
public class EiItfResultDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.ei.itf.eiitfresultdo.d.EiItfResultDO";
	public static final String CLASS_DISPALYNAME = "接口出参DO";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "ei_itf_result";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_itfresult";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public EiItfResultDODesc(){
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
		this.setKeyDesc(getId_itfresultADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_itfresultADesc(tblDesc));
		this.add(getId_itfADesc(tblDesc));
		this.add(getResultinfoADesc(tblDesc));
		this.add(getCodeADesc(tblDesc));
		this.add(getNameADesc(tblDesc));
		this.add(getServicenameADesc(tblDesc));
		this.add(getMethodnameADesc(tblDesc));
		this.add(getFg_sysADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_itfresultCDesc(tblDesc));
		tblDesc.add(getId_itfresultCDesc(tblDesc));
		tblDesc.add(getId_itfCDesc(tblDesc));
		tblDesc.add(getResultinfoCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 接口出参id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_itfresultADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_itfresult",  getId_itfresultCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("接口出参id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 接口id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_itfADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_itf",  getId_itfCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("接口id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 出参信息DTO属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getResultinfoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Resultinfo",  getResultinfoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("出参信息DTO");
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
		attrDesc.setRefTblInfos(new String[]{"ei_itf a0b2","id_itf=id_itf","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name",  getNameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"ei_itf a0b2","id_itf=id_itf","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 服务名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getServicenameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Servicename",  getServicenameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"ei_itf a0b2","id_itf=id_itf","servicename"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 方法名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMethodnameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Methodname",  getMethodnameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("方法名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"ei_itf a0b2","id_itf=id_itf","methodname"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 系统标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_sysADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_sys",  getFg_sysCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("系统标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"ei_itf a0b2","id_itf=id_itf","fg_sys"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取接口出参id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_itfresultCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_itfresult");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("接口出参id"); 
		return column;
	}
	/**
	 * 获取接口id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_itfCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_itf");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("接口id"); 
		return column;
	}
	/**
	 * 获取出参信息DTO表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getResultinfoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Resultinfo");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("出参信息DTO"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code");
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
	private IColumnDesc getNameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取服务名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getServicenameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Servicename");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务名"); 
		return column;
	}
	/**
	 * 获取方法名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMethodnameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Methodname");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("方法名"); 
		return column;
	}
	/**
	 * 获取系统标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_sysCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_sys");
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("系统标识"); 
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
