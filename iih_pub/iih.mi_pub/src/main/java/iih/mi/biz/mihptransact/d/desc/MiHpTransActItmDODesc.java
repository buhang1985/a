
package iih.mi.biz.mihptransact.d.desc;

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
 * 安徽医保交易明细 DO 元数据信息
 */
public class MiHpTransActItmDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.mi.biz.mihptransact.d.MiHpTransActItmDO";
	public static final String CLASS_DISPALYNAME = "安徽医保交易明细";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "mi_hptransactitm";
	public static final String TABLE_ALIAS_NAME = "a1";
	public static final String PRIMARYKEY_FIELDNAME="Id_hptransactitm";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public MiHpTransActItmDODesc(){
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
		this.setKeyDesc(getId_hptransactitmADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_hptransactADesc(tblDesc));
		this.add(getId_hptransactitmADesc(tblDesc));
		this.add(getId_hptransactADesc(tblDesc));
		this.add(getId_cgitmADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_hptransactitmCDesc(tblDesc));
		tblDesc.add(getId_hptransactitmCDesc(tblDesc));
		tblDesc.add(getId_hptransactCDesc(tblDesc));
		tblDesc.add(getId_cgitmCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 安徽医保交易明细主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_hptransactitmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_hptransactitm",  getId_hptransactitmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("安徽医保交易明细主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 安徽医保交子表易主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_hptransactADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_hptransact",  getId_hptransactCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("安徽医保交子表易主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 交易明细属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_cgitmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_cgitm",  getId_cgitmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("交易明细");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取安徽医保交易明细主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_hptransactitmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_hptransactitm");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("安徽医保交易明细主键"); 
		return column;
	}
	/**
	 * 获取安徽医保交子表易主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_hptransactCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_hptransact");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("安徽医保交子表易主键"); 
		return column;
	}
	/**
	 * 获取交易明细表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_cgitmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_cgitm");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("交易明细"); 
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
