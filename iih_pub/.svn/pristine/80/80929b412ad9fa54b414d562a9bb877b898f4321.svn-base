
package iih.bd.srv.reportcardtplstream.d.desc;

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
 * 报卡模板流 DO 元数据信息
 */
public class ReportcardtplstreamDesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.bd.srv.reportcardtplstream.d.Reportcardtplstream";
	public static final String CLASS_DISPALYNAME = "报卡模板流";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "bd_rcm_tpl_fs";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_rcm_tpl_fs";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public ReportcardtplstreamDesc(){
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
		this.setKeyDesc(getId_rcm_tpl_fsADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_rcm_tpl_fsADesc(tblDesc));
		this.add(getId_bd_rcm_tplADesc(tblDesc));
		this.add(getFsADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_rcm_tpl_fsCDesc(tblDesc));
		tblDesc.add(getId_rcm_tpl_fsCDesc(tblDesc));
		tblDesc.add(getId_bd_rcm_tplCDesc(tblDesc));
		tblDesc.add(getFsCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_rcm_tpl_fsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_rcm_tpl_fs",  getId_rcm_tpl_fsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 报卡模板表主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_bd_rcm_tplADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_bd_rcm_tpl",  getId_bd_rcm_tplCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("报卡模板表主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 模板流属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fs",  getFsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Object);
		attrDesc.setLabel("模板流");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 获取主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_rcm_tpl_fsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_rcm_tpl_fs");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("主键"); 
		return column;
	}
	/**
	 * 获取报卡模板表主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_bd_rcm_tplCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_bd_rcm_tpl");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("报卡模板表主键"); 
		return column;
	}
	/**
	 * 获取模板流表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fs");
		column.setLength(0);
        column.setSqlType(Types.BLOB);
		column.setNullable(true);
		column.setLabel("模板流"); 
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
