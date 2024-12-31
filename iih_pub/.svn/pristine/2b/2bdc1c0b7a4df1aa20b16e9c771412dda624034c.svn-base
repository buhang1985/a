
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
 * 诊疗计划元素_规则包_模板 DO 元数据信息
 */
public class HpCpElemRulePkgTplDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.hp.cp.eletpl.d.HpCpElemRulePkgTplDO";
	public static final String CLASS_DISPALYNAME = "诊疗计划元素_规则包_模板";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "HP_CP_ELE_RULEPKG_TPL";
	public static final String TABLE_ALIAS_NAME = "${EntityMeta.entityClassMeta.aliasName}";
	public static final String PRIMARYKEY_FIELDNAME="Id_ele_rulepkg_tpl";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public HpCpElemRulePkgTplDODesc(){
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
		this.setKeyDesc(getId_ele_rulepkg_tplADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.add(getId_ele_rulepkg_tplADesc(tblDesc));
		this.add(getId_ele_tplADesc(tblDesc));
		this.add(getId_rulepkg_tpADesc(tblDesc));
		this.add(getSd_rulepkg_tpADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_ele_rulepkg_tplCDesc(tblDesc));
		tblDesc.add(getId_ele_rulepkg_tplCDesc(tblDesc));
		tblDesc.add(getId_ele_tplCDesc(tblDesc));
		tblDesc.add(getId_rulepkg_tpCDesc(tblDesc));
		tblDesc.add(getSd_rulepkg_tpCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 规则包ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ele_rulepkg_tplADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ele_rulepkg_tpl",  getId_ele_rulepkg_tplCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("规则包ID");
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
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 规则包类型ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_rulepkg_tpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_rulepkg_tp",  getId_rulepkg_tpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("规则包类型ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 规则包类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_rulepkg_tpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_rulepkg_tp",  getSd_rulepkg_tpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("规则包类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取规则包ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ele_rulepkg_tplCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ele_rulepkg_tpl");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("规则包ID"); 
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
	 * 获取规则包类型ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_rulepkg_tpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_rulepkg_tp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("规则包类型ID"); 
		return column;
	}
	/**
	 * 获取规则包类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_rulepkg_tpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_rulepkg_tp");
		column.setLength(10);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("规则包类型编码"); 
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
