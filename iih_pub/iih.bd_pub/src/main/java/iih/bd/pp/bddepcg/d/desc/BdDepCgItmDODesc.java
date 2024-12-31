
package iih.bd.pp.bddepcg.d.desc;

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
 * 科室补费策略_明细 DO 元数据信息
 */
public class BdDepCgItmDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.bd.pp.bddepcg.d.BdDepCgItmDO";
	public static final String CLASS_DISPALYNAME = "科室补费策略_明细";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "bd_dep_cg_itm";
	public static final String TABLE_ALIAS_NAME = "a1";
	public static final String PRIMARYKEY_FIELDNAME="Id_depcg_itm";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public BdDepCgItmDODesc(){
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
		this.setKeyDesc(getId_depcg_itmADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.setFKeyDesc(getId_depcgADesc(tblDesc));
		this.add(getId_depcg_itmADesc(tblDesc));
		this.add(getId_depcgADesc(tblDesc));
		this.add(getId_srvADesc(tblDesc));
		this.add(getSrvcodeADesc(tblDesc));
		this.add(getSrvnameADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_depcg_itmCDesc(tblDesc));
		tblDesc.add(getId_depcg_itmCDesc(tblDesc));
		tblDesc.add(getId_depcgCDesc(tblDesc));
		tblDesc.add(getId_srvCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 科室补费明细主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_depcg_itmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_depcg_itm",  getId_depcg_itmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("科室补费明细主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 科室补费策略属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_depcgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_depcg",  getId_depcgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("科室补费策略");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 服务属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_srvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_srv",  getId_srvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setExtTag("URC,BDMODE");
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 服务编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSrvcodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Srvcode",  getSrvcodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_srv a1b3","id_srv=id_srv","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 服务名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSrvnameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Srvname",  getSrvnameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_srv a1b3","id_srv=id_srv","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取科室补费明细主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_depcg_itmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_depcg_itm");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("科室补费明细主键"); 
		return column;
	}
	/**
	 * 获取科室补费策略表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_depcgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_depcg");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("科室补费策略"); 
		return column;
	}
	/**
	 * 获取服务表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_srvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_srv");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务"); 
		return column;
	}
	/**
	 * 获取服务编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSrvcodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Srvcode");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务编码"); 
		return column;
	}
	/**
	 * 获取服务名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSrvnameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Srvname");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务名称"); 
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