
package iih.mkr.ms.mkrms.d.desc;

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
 * 组套与医嘱模板关系 DO 元数据信息
 */
public class MkrMsOrtplDesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.mkr.ms.mkrms.d.MkrMsOrtpl";
	public static final String CLASS_DISPALYNAME = "组套与医嘱模板关系";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "MKR_MS_ORTPL";
	public static final String TABLE_ALIAS_NAME = "a2";
	public static final String PRIMARYKEY_FIELDNAME="Id_msortpl";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public MkrMsOrtplDesc(){
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
		this.setKeyDesc(getId_msortplADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.setFKeyDesc(getId_msADesc(tblDesc));
		this.add(getId_msortplADesc(tblDesc));
		this.add(getId_msADesc(tblDesc));
		this.add(getId_srvortplADesc(tblDesc));
		this.add(getOrtpl_nameADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_msortplCDesc(tblDesc));
		tblDesc.add(getId_msortplCDesc(tblDesc));
		tblDesc.add(getId_msCDesc(tblDesc));
		tblDesc.add(getId_srvortplCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 组套与医嘱模板关系ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_msortplADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_msortpl",  getId_msortplCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("组套与医嘱模板关系ID");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 组套ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_msADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ms",  getId_msCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("组套ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 医嘱模板主键ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_srvortplADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_srvortpl",  getId_srvortplCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医嘱模板主键ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 模板名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOrtpl_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ortpl_name",  getOrtpl_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("模板名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_srv_ortmpl a2b3","id_srvortpl=id_ortmpl","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取组套与医嘱模板关系ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_msortplCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_msortpl");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("组套与医嘱模板关系ID"); 
		return column;
	}
	/**
	 * 获取组套ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_msCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ms");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("组套ID"); 
		return column;
	}
	/**
	 * 获取医嘱模板主键ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_srvortplCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_srvortpl");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医嘱模板主键ID"); 
		return column;
	}
	/**
	 * 获取模板名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOrtpl_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ortpl_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("模板名称"); 
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
