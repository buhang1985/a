
package iih.mkr.ms.mscacust.d.desc;

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
 * 组套自定义分类与组套定义关系 DO 元数据信息
 */
public class MkrMscaCtmMsDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.mkr.ms.mscacust.d.MkrMscaCtmMsDO";
	public static final String CLASS_DISPALYNAME = "组套自定义分类与组套定义关系";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "MKR_MSCACTM_MS";
	public static final String TABLE_ALIAS_NAME = "a1";
	public static final String PRIMARYKEY_FIELDNAME="Id_cactm_ms";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public MkrMscaCtmMsDODesc(){
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
		this.setKeyDesc(getId_cactm_msADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_cactmADesc(tblDesc));
		this.add(getId_cactm_msADesc(tblDesc));
		this.add(getId_cactmADesc(tblDesc));
		this.add(getId_msADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_cactm_msCDesc(tblDesc));
		tblDesc.add(getId_cactm_msCDesc(tblDesc));
		tblDesc.add(getId_cactmCDesc(tblDesc));
		tblDesc.add(getId_msCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 自定义分类与组套关系ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_cactm_msADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_cactm_ms",  getId_cactm_msCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("自定义分类与组套关系ID");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 自定义分类ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_cactmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_cactm",  getId_cactmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("自定义分类ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
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
	 * 获取自定义分类与组套关系ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_cactm_msCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_cactm_ms");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("自定义分类与组套关系ID"); 
		return column;
	}
	/**
	 * 获取自定义分类ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_cactmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_cactm");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("自定义分类ID"); 
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
