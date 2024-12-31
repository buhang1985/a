
package iih.hp.cp.eletp.d.desc;

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
 * 诊疗计划可嵌套元素类型 DO 元数据信息
 */
public class HpCpElemTypeNestableDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.hp.cp.eletp.d.HpCpElemTypeNestableDO";
	public static final String CLASS_DISPALYNAME = "诊疗计划可嵌套元素类型";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "hp_cp_eletpnestable";
	public static final String TABLE_ALIAS_NAME = "a1";
	public static final String PRIMARYKEY_FIELDNAME="Id_nestable";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public HpCpElemTypeNestableDODesc(){
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
		this.setKeyDesc(getId_nestableADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_eletpADesc(tblDesc));
		this.add(getId_nestableADesc(tblDesc));
		this.add(getId_eletpADesc(tblDesc));
		this.add(getId_eletp_nestableADesc(tblDesc));
		this.add(getName_eletpADesc(tblDesc));
		this.add(getFg_pkgADesc(tblDesc));
		this.add(getFg_needmatchADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_nestableCDesc(tblDesc));
		tblDesc.add(getId_nestableCDesc(tblDesc));
		tblDesc.add(getId_eletpCDesc(tblDesc));
		tblDesc.add(getId_eletp_nestableCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 关系id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_nestableADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_nestable",  getId_nestableCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("关系id");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 元素类型id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_eletpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_eletp",  getId_eletpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("元素类型id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 可嵌套元素类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_eletp_nestableADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_eletp_nestable",  getId_eletp_nestableCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("可嵌套元素类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setExtTag("BDMODE,URC");
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_eletpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_eletp",  getName_eletpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"hp_cp_eletp a1b3","id_eletp_nestable=id_eletp","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 包标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_pkgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_pkg",  getFg_pkgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("包标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"hp_cp_eletp a1b3","id_eletp_nestable=id_eletp","fg_pkg"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否需要对照属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_needmatchADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_needmatch",  getFg_needmatchCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否需要对照");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"hp_cp_eletp a1b3","id_eletp_nestable=id_eletp","fg_needmatch"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取关系id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_nestableCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_nestable");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("关系id"); 
		return column;
	}
	/**
	 * 获取元素类型id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_eletpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_eletp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("元素类型id"); 
		return column;
	}
	/**
	 * 获取可嵌套元素类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_eletp_nestableCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_eletp_nestable");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("可嵌套元素类型"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_eletpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_eletp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取包标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_pkgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_pkg");
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("包标志"); 
		return column;
	}
	/**
	 * 获取是否需要对照表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_needmatchCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_needmatch");
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否需要对照"); 
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
