
package iih.pe.pitm.perstillness.d.desc;

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
 * 体检疾病定义关键字 DO 元数据信息
 */
public class PeRstIllnessKeyDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.pe.pitm.perstillness.d.PeRstIllnessKeyDO";
	public static final String CLASS_DISPALYNAME = "体检疾病定义关键字";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "pe_itm_perstillnesskey";
	public static final String TABLE_ALIAS_NAME = "a5";
	public static final String PRIMARYKEY_FIELDNAME="Id_perstillnesskey";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public PeRstIllnessKeyDODesc(){
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
		this.setKeyDesc(getId_perstillnesskeyADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_perstillnessADesc(tblDesc));
		this.add(getId_perstillnesskeyADesc(tblDesc));
		this.add(getId_perstillnessADesc(tblDesc));
		this.add(getInckeywordADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_perstillnesskeyCDesc(tblDesc));
		tblDesc.add(getId_perstillnesskeyCDesc(tblDesc));
		tblDesc.add(getId_perstillnessCDesc(tblDesc));
		tblDesc.add(getInckeywordCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 体检疾病定义关键字主键标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_perstillnesskeyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_perstillnesskey",  getId_perstillnesskeyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检疾病定义关键字主键标识");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检疾病定义ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_perstillnessADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_perstillness",  getId_perstillnessCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检疾病定义ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 关键字属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInckeywordADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Inckeyword",  getInckeywordCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("关键字");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取体检疾病定义关键字主键标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_perstillnesskeyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_perstillnesskey");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("体检疾病定义关键字主键标识"); 
		return column;
	}
	/**
	 * 获取体检疾病定义ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_perstillnessCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_perstillness");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检疾病定义ID"); 
		return column;
	}
	/**
	 * 获取关键字表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInckeywordCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Inckeyword");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("关键字"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id","Id_perstillnesskey");
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
