
package iih.ci.mb.dcmo.d.desc;

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
 * 备忘录文件 DO 元数据信息
 */
public class DoctorMemoFileDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.ci.mb.dcmo.d.DoctorMemoFileDO";
	public static final String CLASS_DISPALYNAME = "备忘录文件";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "ci_mb_dcfi";
	public static final String TABLE_ALIAS_NAME = "a1";
	public static final String PRIMARYKEY_FIELDNAME="Id_mefi";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public DoctorMemoFileDODesc(){
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
		this.setKeyDesc(getId_mefiADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_memoADesc(tblDesc));
		this.add(getId_mefiADesc(tblDesc));
		this.add(getId_memoADesc(tblDesc));
		this.add(getContenttypeADesc(tblDesc));
		this.add(getFilenameADesc(tblDesc));
		this.add(getDt_actADesc(tblDesc));
		this.add(getFileextnameADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_mefiCDesc(tblDesc));
		tblDesc.add(getId_mefiCDesc(tblDesc));
		tblDesc.add(getId_memoCDesc(tblDesc));
		tblDesc.add(getContenttypeCDesc(tblDesc));
		tblDesc.add(getFilenameCDesc(tblDesc));
		tblDesc.add(getDt_actCDesc(tblDesc));
		tblDesc.add(getFileextnameCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 备忘文件主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mefiADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mefi",  getId_mefiCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备忘文件主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备忘录主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_memoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_memo",  getId_memoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备忘录主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 备忘文件类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getContenttypeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Contenttype",  getContenttypeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备忘文件类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备忘文件名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFilenameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Filename",  getFilenameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备忘文件名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 记录时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_actADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_act",  getDt_actCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("记录时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 文件后缀属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFileextnameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fileextname",  getFileextnameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("文件后缀");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取备忘文件主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mefiCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mefi");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("备忘文件主键"); 
		return column;
	}
	/**
	 * 获取备忘录主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_memoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_memo");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备忘录主键"); 
		return column;
	}
	/**
	 * 获取备忘文件类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getContenttypeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Contenttype");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备忘文件类型"); 
		return column;
	}
	/**
	 * 获取备忘文件名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFilenameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Filename");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备忘文件名"); 
		return column;
	}
	/**
	 * 获取记录时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_actCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_act");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("记录时间"); 
		return column;
	}
	/**
	 * 获取文件后缀表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFileextnameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fileextname");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("文件后缀"); 
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
