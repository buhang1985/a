
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
 * 诊疗计划元素模板对照 DO 元数据信息
 */
public class HpCpElemTplMatchDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.hp.cp.eletpl.d.HpCpElemTplMatchDO";
	public static final String CLASS_DISPALYNAME = "诊疗计划元素模板对照";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "HP_CP_ELE_TPL_MATCH";
	public static final String TABLE_ALIAS_NAME = "${EntityMeta.entityClassMeta.aliasName}";
	public static final String PRIMARYKEY_FIELDNAME="Id_match_tpl";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public HpCpElemTplMatchDODesc(){
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
		this.setKeyDesc(getId_match_tplADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.add(getId_match_tplADesc(tblDesc));
		this.add(getId_ele_tplADesc(tblDesc));
		this.add(getId_eletpADesc(tblDesc));
		this.add(getEu_statusADesc(tblDesc));
		this.add(getTarget_posADesc(tblDesc));
		this.add(getId_targetADesc(tblDesc));
		this.add(getEu_match_tpADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_match_tplCDesc(tblDesc));
		tblDesc.add(getId_match_tplCDesc(tblDesc));
		tblDesc.add(getId_ele_tplCDesc(tblDesc));
		tblDesc.add(getId_eletpCDesc(tblDesc));
		tblDesc.add(getEu_statusCDesc(tblDesc));
		tblDesc.add(getTarget_posCDesc(tblDesc));
		tblDesc.add(getId_targetCDesc(tblDesc));
		tblDesc.add(getEu_match_tpCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 对照ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_match_tplADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_match_tpl",  getId_match_tplCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("对照ID");
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
	 * 对照状态属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_statusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_status",  getEu_statusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("对照状态");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 对照目标位置属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTarget_posADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Target_pos",  getTarget_posCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("对照目标位置");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 对照目标ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_targetADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_target",  getId_targetCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("对照目标ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 对照关系类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_match_tpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_match_tp",  getEu_match_tpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("对照关系类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取对照ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_match_tplCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_match_tpl");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("对照ID"); 
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
	 * 获取对照状态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_statusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_status");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("对照状态"); 
		return column;
	}
	/**
	 * 获取对照目标位置表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTarget_posCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Target_pos");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("对照目标位置"); 
		return column;
	}
	/**
	 * 获取对照目标ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_targetCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_target");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("对照目标ID"); 
		return column;
	}
	/**
	 * 获取对照关系类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_match_tpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_match_tp");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("对照关系类型"); 
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
