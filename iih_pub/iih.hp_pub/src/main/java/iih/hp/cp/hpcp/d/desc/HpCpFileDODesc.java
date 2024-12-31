
package iih.hp.cp.hpcp.d.desc;

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
 * 诊疗计划文件 DO 元数据信息
 */
public class HpCpFileDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.hp.cp.hpcp.d.HpCpFileDO";
	public static final String CLASS_DISPALYNAME = "诊疗计划文件";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "hp_cp_file";
	public static final String TABLE_ALIAS_NAME = "a0b14";
	public static final String PRIMARYKEY_FIELDNAME="Id_cp_file";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public HpCpFileDODesc(){
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
		this.setKeyDesc(getId_cp_fileADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.setFKeyDesc(getId_cpADesc(tblDesc));
		this.add(getId_cp_fileADesc(tblDesc));
		this.add(getId_cpADesc(tblDesc));
		this.add(getFilecontentADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_cp_fileCDesc(tblDesc));
		tblDesc.add(getId_cp_fileCDesc(tblDesc));
		tblDesc.add(getId_cpCDesc(tblDesc));
		tblDesc.add(getFilecontentCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 诊疗计划文件ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_cp_fileADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_cp_file",  getId_cp_fileCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊疗计划文件ID");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊疗计划ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_cpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_cp",  getId_cpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊疗计划ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 文件内容属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFilecontentADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Filecontent",  getFilecontentCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Object);
		attrDesc.setLabel("文件内容");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 获取诊疗计划文件ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_cp_fileCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_cp_file");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("诊疗计划文件ID"); 
		return column;
	}
	/**
	 * 获取诊疗计划ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_cpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_cp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊疗计划ID"); 
		return column;
	}
	/**
	 * 获取文件内容表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFilecontentCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Filecontent");
		column.setLength(64000);
        column.setSqlType(Types.BLOB);
		column.setNullable(true);
		column.setLabel("文件内容"); 
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
