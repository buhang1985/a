
package iih.hp.cp.eletpl.d.desc;

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
 * 诊疗计划元素_医嘱包_模板 DO 元数据信息
 */
public class HpCpElemOrderPkgTplDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.hp.cp.eletpl.d.HpCpElemOrderPkgTplDO";
	public static final String CLASS_DISPALYNAME = "诊疗计划元素_医嘱包_模板";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "HP_CP_ELE_ORDERPKG_TPL";
	public static final String TABLE_ALIAS_NAME = "${EntityMeta.entityClassMeta.aliasName}";
	public static final String PRIMARYKEY_FIELDNAME="Id_ele_orderkpg_tpl";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public HpCpElemOrderPkgTplDODesc(){
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
		this.setKeyDesc(getId_ele_orderkpg_tplADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.add(getId_ele_orderkpg_tplADesc(tblDesc));
		this.add(getId_ele_tplADesc(tblDesc));
		this.add(getEu_order_relADesc(tblDesc));
		this.add(getFg_longADesc(tblDesc));
		this.add(getId_routeADesc(tblDesc));
		this.add(getId_freqADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_ele_orderkpg_tplCDesc(tblDesc));
		tblDesc.add(getId_ele_orderkpg_tplCDesc(tblDesc));
		tblDesc.add(getId_ele_tplCDesc(tblDesc));
		tblDesc.add(getEu_order_relCDesc(tblDesc));
		tblDesc.add(getFg_longCDesc(tblDesc));
		tblDesc.add(getId_routeCDesc(tblDesc));
		tblDesc.add(getId_freqCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 医嘱包ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ele_orderkpg_tplADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ele_orderkpg_tpl",  getId_ele_orderkpg_tplCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医嘱包ID");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 元素ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ele_tplADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ele_tpl",  getId_ele_tplCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("元素ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 包内医嘱关联关系属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_order_relADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_order_rel",  getEu_order_relCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("包内医嘱关联关系");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 长临标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_longADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_long",  getFg_longCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("长临标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 给药途径属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_routeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_route",  getId_routeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("给药途径");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 使用频次属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_freqADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_freq",  getId_freqCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("使用频次");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取医嘱包ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ele_orderkpg_tplCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ele_orderkpg_tpl");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("医嘱包ID"); 
		return column;
	}
	/**
	 * 获取元素ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ele_tplCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ele_tpl");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("元素ID"); 
		return column;
	}
	/**
	 * 获取包内医嘱关联关系表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_order_relCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_order_rel");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("包内医嘱关联关系"); 
		return column;
	}
	/**
	 * 获取长临标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_longCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_long");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("长临标识"); 
		return column;
	}
	/**
	 * 获取给药途径表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_routeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_route");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("给药途径"); 
		return column;
	}
	/**
	 * 获取使用频次表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_freqCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_freq");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("使用频次"); 
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
