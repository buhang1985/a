
package iih.bd.fc.enstatetpext.d.desc;

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
 * 就诊状况类型定义扩展 DO 元数据信息
 */
public class BdEnStateTpExtDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.bd.fc.enstatetpext.d.BdEnStateTpExtDO";
	public static final String CLASS_DISPALYNAME = "就诊状况类型定义扩展";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "BD_EN_STATETP_EXT";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_enstatetpext";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public BdEnStateTpExtDODesc(){
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
		this.setKeyDesc(getId_enstatetpextADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_enstatetpextADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_enstatetpADesc(tblDesc));
		this.add(getSd_enstatetpADesc(tblDesc));
		this.add(getFg_entADesc(tblDesc));
		this.add(getFg_opADesc(tblDesc));
		this.add(getFg_ipADesc(tblDesc));
		this.add(getFg_erADesc(tblDesc));
		this.add(getIds_dep_usedADesc(tblDesc));
		this.add(getEu_sourcetpADesc(tblDesc));
		this.add(getId_def_valADesc(tblDesc));
		this.add(getDef_valADesc(tblDesc));
		this.add(getName_enstatetpADesc(tblDesc));
		this.add(getNames_dep_usedADesc(tblDesc));
		this.add(getCodes_dep_usedADesc(tblDesc));
		this.add(getSd_depttpADesc(tblDesc));
		this.add(getName_def_valADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_enstatetpextCDesc(tblDesc));
		tblDesc.add(getId_enstatetpextCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_enstatetpCDesc(tblDesc));
		tblDesc.add(getSd_enstatetpCDesc(tblDesc));
		tblDesc.add(getFg_entCDesc(tblDesc));
		tblDesc.add(getFg_opCDesc(tblDesc));
		tblDesc.add(getFg_ipCDesc(tblDesc));
		tblDesc.add(getFg_erCDesc(tblDesc));
		tblDesc.add(getIds_dep_usedCDesc(tblDesc));
		tblDesc.add(getEu_sourcetpCDesc(tblDesc));
		tblDesc.add(getId_def_valCDesc(tblDesc));
		tblDesc.add(getDef_valCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 状况类型扩展id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_enstatetpextADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_enstatetpext",  getId_enstatetpextCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("状况类型扩展id");
		attrDesc.setNullable(true);
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
	 * 状况类型id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_enstatetpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_enstatetp",  getId_enstatetpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("状况类型id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 状况类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_enstatetpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_enstatetp",  getSd_enstatetpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("状况类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 就诊使用标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_entADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_ent",  getFg_entCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("就诊使用标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 门诊使用标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_opADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_op",  getFg_opCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("门诊使用标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 住院使用属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_ipADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_ip",  getFg_ipCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("住院使用");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 急诊使用属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_erADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_er",  getFg_erCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("急诊使用");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 可使用科室属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIds_dep_usedADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ids_dep_used",  getIds_dep_usedCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("可使用科室");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 源数据类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_sourcetpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_sourcetp",  getEu_sourcetpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("源数据类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 默认值id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_def_valADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_def_val",  getId_def_valCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("默认值id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 默认值属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef_valADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def_val",  getDef_valCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("默认值");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_enstatetpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_enstatetp",  getName_enstatetpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b2","id_enstatetp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 可使用科室名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNames_dep_usedADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Names_dep_used",  getNames_dep_usedCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("可使用科室名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b3","ids_dep_used=id_dep","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 可使用科室编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCodes_dep_usedADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Codes_dep_used",  getCodes_dep_usedCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("可使用科室编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b3","ids_dep_used=id_dep","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 部门类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_depttpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_depttp",  getSd_depttpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("部门类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b3","ids_dep_used=id_dep","sd_depttp"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 默认值名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_def_valADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_def_val",  getName_def_valCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("默认值名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_en_state a0b4","id_def_val=id_enstate","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取状况类型扩展id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_enstatetpextCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_enstatetpext");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("状况类型扩展id"); 
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
	 * 获取状况类型id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_enstatetpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_enstatetp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("状况类型id"); 
		return column;
	}
	/**
	 * 获取状况类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_enstatetpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_enstatetp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("状况类型编码"); 
		return column;
	}
	/**
	 * 获取就诊使用标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_entCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_ent");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("就诊使用标志"); 
		return column;
	}
	/**
	 * 获取门诊使用标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_opCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_op");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("门诊使用标志"); 
		return column;
	}
	/**
	 * 获取住院使用表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_ipCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_ip");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("住院使用"); 
		return column;
	}
	/**
	 * 获取急诊使用表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_erCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_er");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("急诊使用"); 
		return column;
	}
	/**
	 * 获取可使用科室表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIds_dep_usedCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ids_dep_used");
		column.setLength(1024);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("可使用科室"); 
		return column;
	}
	/**
	 * 获取源数据类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_sourcetpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_sourcetp");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("源数据类型"); 
		return column;
	}
	/**
	 * 获取默认值id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_def_valCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_def_val");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("默认值id"); 
		return column;
	}
	/**
	 * 获取默认值表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef_valCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def_val");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("默认值"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_enstatetpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_enstatetp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取可使用科室名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNames_dep_usedCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Names_dep_used");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("可使用科室名称"); 
		return column;
	}
	/**
	 * 获取可使用科室编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCodes_dep_usedCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Codes_dep_used");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("可使用科室编码"); 
		return column;
	}
	/**
	 * 获取部门类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_depttpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_depttp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("部门类型编码"); 
		return column;
	}
	/**
	 * 获取默认值名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_def_valCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_def_val");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("默认值名称"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id","Id_enstatetpext");
		iBDDataInfoFldMap.put("id_org","Id_org");
		iBDDataInfoFldMap.put("id_group","Id_grp");
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
