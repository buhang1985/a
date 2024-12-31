
package iih.bl.prop.blproparoep.d.desc;

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
 * 应收付款段_门急体 DO 元数据信息
 */
public class BlPropArSegOepDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.bl.prop.blproparoep.d.BlPropArSegOepDO";
	public static final String CLASS_DISPALYNAME = "应收付款段_门急体";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "bl_prop_ar_seg_oep";
	public static final String TABLE_ALIAS_NAME = "a2";
	public static final String PRIMARYKEY_FIELDNAME="Id_proparsegoep";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public BlPropArSegOepDODesc(){
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
		this.setKeyDesc(getId_proparsegoepADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_proparoepADesc(tblDesc));
		this.add(getId_proparsegoepADesc(tblDesc));
		this.add(getId_proparoepADesc(tblDesc));
		this.add(getId_propADesc(tblDesc));
		this.add(getId_hpsegADesc(tblDesc));
		this.add(getName_hpsegADesc(tblDesc));
		this.add(getAmt_hpsegADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_proparsegoepCDesc(tblDesc));
		tblDesc.add(getId_proparsegoepCDesc(tblDesc));
		tblDesc.add(getId_proparoepCDesc(tblDesc));
		tblDesc.add(getId_propCDesc(tblDesc));
		tblDesc.add(getId_hpsegCDesc(tblDesc));
		tblDesc.add(getName_hpsegCDesc(tblDesc));
		tblDesc.add(getAmt_hpsegCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 应收付款段主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_proparsegoepADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_proparsegoep",  getId_proparsegoepCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("应收付款段主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 应收属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_proparoepADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_proparoep",  getId_proparoepCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("应收");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 分摊属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_propADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_prop",  getId_propCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("分摊");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 付款段属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_hpsegADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_hpseg",  getId_hpsegCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("付款段");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 付款段名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_hpsegADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_hpseg",  getName_hpsegCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("付款段名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 付款金额属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_hpsegADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_hpseg",  getAmt_hpsegCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("付款金额");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取应收付款段主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_proparsegoepCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_proparsegoep");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("应收付款段主键"); 
		return column;
	}
	/**
	 * 获取应收表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_proparoepCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_proparoep");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("应收"); 
		return column;
	}
	/**
	 * 获取分摊表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_propCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_prop");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("分摊"); 
		return column;
	}
	/**
	 * 获取付款段表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_hpsegCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_hpseg");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("付款段"); 
		return column;
	}
	/**
	 * 获取付款段名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_hpsegCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_hpseg");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("付款段名称"); 
		return column;
	}
	/**
	 * 获取付款金额表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_hpsegCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_hpseg");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("付款金额"); 
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
