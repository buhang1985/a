
package iih.pe.pitm.perstsuggdef.d.desc;

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
 * 体检建议定义 DO 元数据信息
 */
public class PeRstSuggDefDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.pe.pitm.perstsuggdef.d.PeRstSuggDefDO";
	public static final String CLASS_DISPALYNAME = "体检建议定义";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "pe_itm_perstsuggdef";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_perstsuggdef";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public PeRstSuggDefDODesc(){
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
		this.setKeyDesc(getId_perstsuggdefADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_perstsuggdefADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getCodeADesc(tblDesc));
		this.add(getNameADesc(tblDesc));
		this.add(getEnameADesc(tblDesc));
		this.add(getSuggkeywordADesc(tblDesc));
		this.add(getSortnoADesc(tblDesc));
		this.add(getLinktpADesc(tblDesc));
		this.add(getFrqADesc(tblDesc));
		this.add(getFg_recheckADesc(tblDesc));
		this.add(getRemind_daysADesc(tblDesc));
		this.add(getZz_contADesc(tblDesc));
		this.add(getZz_econtADesc(tblDesc));
		this.add(getNoteADesc(tblDesc));
		this.add(getFg_activeADesc(tblDesc));
		this.add(getId_perstsuggtpADesc(tblDesc));
		this.add(getWbcodeADesc(tblDesc));
		this.add(getPycodeADesc(tblDesc));
		this.add(getMnecodeADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getConADesc(tblDesc));
		this.add(getEconADesc(tblDesc));
		this.add(getCode_suggcaADesc(tblDesc));
		this.add(getName_suggcaADesc(tblDesc));
		this.add(getSugg_caADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_perstsuggdefCDesc(tblDesc));
		tblDesc.add(getId_perstsuggdefCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getCodeCDesc(tblDesc));
		tblDesc.add(getNameCDesc(tblDesc));
		tblDesc.add(getEnameCDesc(tblDesc));
		tblDesc.add(getSuggkeywordCDesc(tblDesc));
		tblDesc.add(getSortnoCDesc(tblDesc));
		tblDesc.add(getLinktpCDesc(tblDesc));
		tblDesc.add(getFrqCDesc(tblDesc));
		tblDesc.add(getFg_recheckCDesc(tblDesc));
		tblDesc.add(getRemind_daysCDesc(tblDesc));
		tblDesc.add(getZz_contCDesc(tblDesc));
		tblDesc.add(getZz_econtCDesc(tblDesc));
		tblDesc.add(getNoteCDesc(tblDesc));
		tblDesc.add(getFg_activeCDesc(tblDesc));
		tblDesc.add(getId_perstsuggtpCDesc(tblDesc));
		tblDesc.add(getWbcodeCDesc(tblDesc));
		tblDesc.add(getPycodeCDesc(tblDesc));
		tblDesc.add(getMnecodeCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		tblDesc.add(getConCDesc(tblDesc));
		tblDesc.add(getEconCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 体检建议主键标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_perstsuggdefADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_perstsuggdef",  getId_perstsuggdefCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检建议主键标识");
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
	 * 建议编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code",  getCodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("建议编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 建议名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name",  getNameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("建议名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 英文建议属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEnameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ename",  getEnameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("英文建议");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 建议关键字属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSuggkeywordADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Suggkeyword",  getSuggkeywordCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("建议关键字");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 次序属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSortnoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sortno",  getSortnoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("次序");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 关联类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getLinktpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Linktp",  getLinktpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("关联类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 使用频率属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFrqADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Frq",  getFrqCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("使用频率");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 复查标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_recheckADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_recheck",  getFg_recheckCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("复查标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 复查提醒周期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRemind_daysADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Remind_days",  getRemind_daysCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("复查提醒周期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 建议内容属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getZz_contADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Zz_cont",  getZz_contCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("建议内容");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 英文建议内容属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getZz_econtADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Zz_econt",  getZz_econtCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("英文建议内容");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备注属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNoteADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Note",  getNoteCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备注");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否启用属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_activeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_active",  getFg_activeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否启用");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 建议分类ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_perstsuggtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_perstsuggtp",  getId_perstsuggtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("建议分类ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 五笔属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWbcodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Wbcode",  getWbcodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("五笔");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 拼音属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPycodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pycode",  getPycodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("拼音");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 助记码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMnecodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mnecode",  getMnecodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("助记码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 创建人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCreatedbyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Createdby",  getCreatedbyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("创建人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 创建时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCreatedtimeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Createdtime",  getCreatedtimeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("创建时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 最后修改人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getModifiedbyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Modifiedby",  getModifiedbyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("最后修改人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 最后修改时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getModifiedtimeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Modifiedtime",  getModifiedtimeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("最后修改时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 建议内容文本属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getConADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Con",  getConCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("建议内容文本");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 英文建议内容文本属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEconADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Econ",  getEconCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("英文建议内容文本");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_suggcaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_suggca",  getCode_suggcaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_itm_perstsuggtp a0b6","id_perstsuggtp=id_perstsuggtp","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_suggcaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_suggca",  getName_suggcaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_itm_perstsuggtp a0b6","id_perstsuggtp=id_perstsuggtp","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 类别属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSugg_caADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sugg_ca",  getSugg_caCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("类别");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_itm_perstsuggtp a0b6","id_perstsuggtp=id_perstsuggtp","sugg_ca"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取体检建议主键标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_perstsuggdefCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_perstsuggdef");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("体检建议主键标识"); 
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
	 * 获取建议编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("建议编码"); 
		return column;
	}
	/**
	 * 获取建议名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("建议名称"); 
		return column;
	}
	/**
	 * 获取英文建议表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEnameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ename");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("英文建议"); 
		return column;
	}
	/**
	 * 获取建议关键字表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSuggkeywordCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Suggkeyword");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("建议关键字"); 
		return column;
	}
	/**
	 * 获取次序表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSortnoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sortno");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("次序"); 
		return column;
	}
	/**
	 * 获取关联类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getLinktpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Linktp");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("关联类型"); 
		return column;
	}
	/**
	 * 获取使用频率表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFrqCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Frq");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("使用频率"); 
		return column;
	}
	/**
	 * 获取复查标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_recheckCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_recheck");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("复查标识"); 
		return column;
	}
	/**
	 * 获取复查提醒周期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRemind_daysCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Remind_days");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("复查提醒周期"); 
		return column;
	}
	/**
	 * 获取建议内容表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getZz_contCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Zz_cont");
		column.setLength(0);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("建议内容"); 
		return column;
	}
	/**
	 * 获取英文建议内容表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getZz_econtCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Zz_econt");
		column.setLength(0);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("英文建议内容"); 
		return column;
	}
	/**
	 * 获取备注表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNoteCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Note");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备注"); 
		return column;
	}
	/**
	 * 获取是否启用表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_activeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_active");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否启用"); 
		return column;
	}
	/**
	 * 获取建议分类ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_perstsuggtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_perstsuggtp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("建议分类ID"); 
		return column;
	}
	/**
	 * 获取五笔表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWbcodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Wbcode");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("五笔"); 
		return column;
	}
	/**
	 * 获取拼音表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPycodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pycode");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("拼音"); 
		return column;
	}
	/**
	 * 获取助记码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMnecodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mnecode");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("助记码"); 
		return column;
	}
	/**
	 * 获取创建人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCreatedbyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Createdby");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("创建人"); 
		return column;
	}
	/**
	 * 获取创建时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCreatedtimeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Createdtime");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("创建时间"); 
		return column;
	}
	/**
	 * 获取最后修改人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getModifiedbyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Modifiedby");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("最后修改人"); 
		return column;
	}
	/**
	 * 获取最后修改时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getModifiedtimeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Modifiedtime");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("最后修改时间"); 
		return column;
	}
	/**
	 * 获取建议内容文本表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getConCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Con");
		column.setLength(1000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("建议内容文本"); 
		return column;
	}
	/**
	 * 获取英文建议内容文本表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEconCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Econ");
		column.setLength(1000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("英文建议内容文本"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_suggcaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_suggca");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_suggcaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_suggca");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取类别表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSugg_caCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sugg_ca");
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("类别"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id","Id_perstsuggdef");
		iBDDataInfoFldMap.put("id_org","Id_org");
		iBDDataInfoFldMap.put("code","Code");
		iBDDataInfoFldMap.put("name","Name");
		iBDDataInfoFldMap.put("id_group","Id_grp");
	}

	/**
	 * 设置实体审计信息数据映射关系 
	 */
	private void setIAuditInfoFldMap(){
		iAuditInfoFldMap=new HashMap<String, String>();
		iAuditInfoFldMap.put("createdby","Createdby");
		iAuditInfoFldMap.put("createdtime","Createdtime");
		iAuditInfoFldMap.put("modifiedby","Modifiedby");
		iAuditInfoFldMap.put("modifiedtime","Modifiedtime");
	}
	
	/**
	 * 设置实体默认值
	 */
	private void setDefaultValueMap(){
		defaultValueMap=new HashMap<String, Object>();
	}
	
}
