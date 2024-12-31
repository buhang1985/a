
package iih.bl.cc.blcc.d.desc;

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
 * 结账_发票信息 DO 元数据信息
 */
public class BlCcIncDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.bl.cc.blcc.d.BlCcIncDO";
	public static final String CLASS_DISPALYNAME = "结账_发票信息";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "bl_cc_inc";
	public static final String TABLE_ALIAS_NAME = "a2";
	public static final String PRIMARYKEY_FIELDNAME="Id_ccinc";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public BlCcIncDODesc(){
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
		this.setKeyDesc(getId_ccincADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_ccADesc(tblDesc));
		this.add(getId_ccincADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_ccADesc(tblDesc));
		this.add(getId_inccaADesc(tblDesc));
		this.add(getCode_incpkgADesc(tblDesc));
		this.add(getNum_bADesc(tblDesc));
		this.add(getNum_eADesc(tblDesc));
		this.add(getIncnos_cancADesc(tblDesc));
		this.add(getFg_ec_incADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_ccincCDesc(tblDesc));
		tblDesc.add(getId_ccincCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_ccCDesc(tblDesc));
		tblDesc.add(getId_inccaCDesc(tblDesc));
		tblDesc.add(getCode_incpkgCDesc(tblDesc));
		tblDesc.add(getNum_bCDesc(tblDesc));
		tblDesc.add(getNum_eCDesc(tblDesc));
		tblDesc.add(getIncnos_cancCDesc(tblDesc));
		tblDesc.add(getFg_ec_incCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 结账票据信息键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ccincADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ccinc",  getId_ccincCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("结账票据信息键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 所属集团属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_grpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_grp",  getId_grpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("所属集团");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 所属组织属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_orgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_org",  getId_orgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("所属组织");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 结账属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ccADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_cc",  getId_ccCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("结账");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 票据分类属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_inccaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_incca",  getId_inccaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("票据分类");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 票据包编号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_incpkgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_incpkg",  getCode_incpkgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("票据包编号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 票据开始号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNum_bADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Num_b",  getNum_bCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("票据开始号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 票据结束号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNum_eADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Num_e",  getNum_eCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("票据结束号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 作废发票号串属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIncnos_cancADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Incnos_canc",  getIncnos_cancCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("作废发票号串");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否电子票纸质票属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_ec_incADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_ec_inc",  getFg_ec_incCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否电子票纸质票");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取结账票据信息键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ccincCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ccinc");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("结账票据信息键"); 
		return column;
	}
	/**
	 * 获取所属集团表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_grpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_grp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("所属集团"); 
		return column;
	}
	/**
	 * 获取所属组织表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_orgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_org");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("所属组织"); 
		return column;
	}
	/**
	 * 获取结账表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ccCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_cc");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("结账"); 
		return column;
	}
	/**
	 * 获取票据分类表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_inccaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_incca");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("票据分类"); 
		return column;
	}
	/**
	 * 获取票据包编号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_incpkgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_incpkg");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("票据包编号"); 
		return column;
	}
	/**
	 * 获取票据开始号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNum_bCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Num_b");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("票据开始号"); 
		return column;
	}
	/**
	 * 获取票据结束号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNum_eCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Num_e");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("票据结束号"); 
		return column;
	}
	/**
	 * 获取作废发票号串表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIncnos_cancCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Incnos_canc");
		column.setLength(4000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("作废发票号串"); 
		return column;
	}
	/**
	 * 获取是否电子票纸质票表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_ec_incCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_ec_inc");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否电子票纸质票"); 
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
