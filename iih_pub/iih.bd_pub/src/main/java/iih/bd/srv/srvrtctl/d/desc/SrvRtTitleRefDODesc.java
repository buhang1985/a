
package iih.bd.srv.srvrtctl.d.desc;

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
 * 服务开立控制与职称关系 DO 元数据信息
 */
public class SrvRtTitleRefDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.bd.srv.srvrtctl.d.SrvRtTitleRefDO";
	public static final String CLASS_DISPALYNAME = "服务开立控制与职称关系";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "bd_srv_rt_title_ref";
	public static final String TABLE_ALIAS_NAME = "a3";
	public static final String PRIMARYKEY_FIELDNAME="Id_srvrttitleref";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public SrvRtTitleRefDODesc(){
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
		this.setKeyDesc(getId_srvrttitlerefADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.setFKeyDesc(getId_srvrtADesc(tblDesc));
		this.add(getId_srvrttitlerefADesc(tblDesc));
		this.add(getId_srvrtADesc(tblDesc));
		this.add(getId_emp_titleADesc(tblDesc));
		this.add(getSd_emp_titleADesc(tblDesc));
		this.add(getTitlerefsrvrtcodeADesc(tblDesc));
		this.add(getTitlerefsrvrtnameADesc(tblDesc));
		this.add(getIdemptitlecodeADesc(tblDesc));
		this.add(getIdemptitlenameADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_srvrttitlerefCDesc(tblDesc));
		tblDesc.add(getId_srvrttitlerefCDesc(tblDesc));
		tblDesc.add(getId_srvrtCDesc(tblDesc));
		tblDesc.add(getId_emp_titleCDesc(tblDesc));
		tblDesc.add(getSd_emp_titleCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 服务开立控制与职称关系主键标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_srvrttitlerefADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_srvrttitleref",  getId_srvrttitlerefCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务开立控制与职称关系主键标识");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 服务开立权限属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_srvrtADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_srvrt",  getId_srvrtCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务开立权限");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 人员聘任职称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_titleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_title",  getId_emp_titleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("人员聘任职称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 人员聘任职称编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_emp_titleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_emp_title",  getSd_emp_titleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("人员聘任职称编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 服务开立权限编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTitlerefsrvrtcodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Titlerefsrvrtcode",  getTitlerefsrvrtcodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务开立权限编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_srv_rt a3b1","id_srvrt=id_srvrt","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 服务开立权限名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTitlerefsrvrtnameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Titlerefsrvrtname",  getTitlerefsrvrtnameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务开立权限名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_srv_rt a3b1","id_srvrt=id_srvrt","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIdemptitlecodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Idemptitlecode",  getIdemptitlecodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a3b2","id_emp_title=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIdemptitlenameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Idemptitlename",  getIdemptitlenameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a3b2","id_emp_title=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取服务开立控制与职称关系主键标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_srvrttitlerefCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_srvrttitleref");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("服务开立控制与职称关系主键标识"); 
		return column;
	}
	/**
	 * 获取服务开立权限表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_srvrtCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_srvrt");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务开立权限"); 
		return column;
	}
	/**
	 * 获取人员聘任职称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_titleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_title");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("人员聘任职称"); 
		return column;
	}
	/**
	 * 获取人员聘任职称编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_emp_titleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_emp_title");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("人员聘任职称编码"); 
		return column;
	}
	/**
	 * 获取服务开立权限编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTitlerefsrvrtcodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Titlerefsrvrtcode");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务开立权限编码"); 
		return column;
	}
	/**
	 * 获取服务开立权限名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTitlerefsrvrtnameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Titlerefsrvrtname");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务开立权限名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIdemptitlecodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Idemptitlecode");
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
	private IColumnDesc getIdemptitlenameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Idemptitlename");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
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
	
}
