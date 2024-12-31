
package iih.sc.sch.scsch.d.desc;

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
 * 计划排班_排班_服务 DO 元数据信息
 */
public class ScSchOptsrvDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.sc.sch.scsch.d.ScSchOptsrvDO";
	public static final String CLASS_DISPALYNAME = "计划排班_排班_服务";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "sc_sch_optsrv";
	public static final String TABLE_ALIAS_NAME = "a4";
	public static final String PRIMARYKEY_FIELDNAME="Id_schoptsrv";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public ScSchOptsrvDODesc(){
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
		this.setKeyDesc(getId_schoptsrvADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_schADesc(tblDesc));
		this.add(getId_schoptsrvADesc(tblDesc));
		this.add(getId_schADesc(tblDesc));
		this.add(getId_scsrvADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_schoptsrvCDesc(tblDesc));
		tblDesc.add(getId_schoptsrvCDesc(tblDesc));
		tblDesc.add(getId_schCDesc(tblDesc));
		tblDesc.add(getId_scsrvCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 排班备用服务id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_schoptsrvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_schoptsrv",  getId_schoptsrvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("排班备用服务id");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 排班id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_schADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_sch",  getId_schCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("排班id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 排班服务属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_scsrvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_scsrv",  getId_scsrvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("排班服务");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 获取排班备用服务id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_schoptsrvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_schoptsrv");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("排班备用服务id"); 
		return column;
	}
	/**
	 * 获取排班id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_schCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_sch");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("排班id"); 
		return column;
	}
	/**
	 * 获取排班服务表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_scsrvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_scsrv");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("排班服务"); 
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
