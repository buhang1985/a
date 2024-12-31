
package iih.nm.net.examppqurule.d.desc;

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
 * 试卷试题抽取规则 DO 元数据信息
 */
public class ExamppQuruleDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.nm.net.examppqurule.d.ExamppQuruleDO";
	public static final String CLASS_DISPALYNAME = "试卷试题抽取规则";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "NM_EXAM_PP_QURULE";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_pp_rule";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public ExamppQuruleDODesc(){
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
		this.setKeyDesc(getId_pp_ruleADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.add(getId_pp_ruleADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_ppADesc(tblDesc));
		this.add(getId_ppsecADesc(tblDesc));
		this.add(getId_qucaADesc(tblDesc));
		this.add(getId_qutypeADesc(tblDesc));
		this.add(getSd_qutypeADesc(tblDesc));
		this.add(getId_qulvlADesc(tblDesc));
		this.add(getSd_qulvlADesc(tblDesc));
		this.add(getQuanADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getName_ppADesc(tblDesc));
		this.add(getName_ppsecADesc(tblDesc));
		this.add(getName_qucaADesc(tblDesc));
		this.add(getName_qutypeADesc(tblDesc));
		this.add(getName_qulvlADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_pp_ruleCDesc(tblDesc));
		tblDesc.add(getId_pp_ruleCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_ppCDesc(tblDesc));
		tblDesc.add(getId_ppsecCDesc(tblDesc));
		tblDesc.add(getId_qucaCDesc(tblDesc));
		tblDesc.add(getId_qutypeCDesc(tblDesc));
		tblDesc.add(getSd_qutypeCDesc(tblDesc));
		tblDesc.add(getId_qulvlCDesc(tblDesc));
		tblDesc.add(getSd_qulvlCDesc(tblDesc));
		tblDesc.add(getQuanCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 试卷规则ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pp_ruleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pp_rule",  getId_pp_ruleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("试卷规则ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 组织属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_orgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_org",  getId_orgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("组织");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 集团属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_grpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_grp",  getId_grpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("集团");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 试卷ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ppADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pp",  getId_ppCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("试卷ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 试卷段落属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ppsecADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ppsec",  getId_ppsecCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("试卷段落");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 试题类别属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_qucaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_quca",  getId_qucaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("试题类别");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 试题类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_qutypeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_qutype",  getId_qutypeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("试题类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 试题类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_qutypeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_qutype",  getSd_qutypeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("试题类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 难度属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_qulvlADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_qulvl",  getId_qulvlCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("难度");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 难度编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_qulvlADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_qulvl",  getSd_qulvlCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("难度编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 题目数量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuanADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Quan",  getQuanCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("题目数量");
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
	 * 试卷名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_ppADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_pp",  getName_ppCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("试卷名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"NM_EXAM_PP a0b4","id_pp=id_pp","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 段落名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_ppsecADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_ppsec",  getName_ppsecCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("段落名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"NM_EXAM_PP_SEC a0b5","id_ppsec=id_ppsec","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 试题类别名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_qucaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_quca",  getName_qucaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("试题类别名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"NM_EXAM_QU_CA a0b6","id_quca=id_qu_ca","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 试题类型名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_qutypeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_qutype",  getName_qutypeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("试题类型名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b7","id_qutype=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 试题难度名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_qulvlADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_qulvl",  getName_qulvlCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("试题难度名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b8","id_qulvl=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取试卷规则ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pp_ruleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pp_rule");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("试卷规则ID"); 
		return column;
	}
	/**
	 * 获取组织表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_orgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_org");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("组织"); 
		return column;
	}
	/**
	 * 获取集团表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_grpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_grp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("集团"); 
		return column;
	}
	/**
	 * 获取试卷ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ppCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("试卷ID"); 
		return column;
	}
	/**
	 * 获取试卷段落表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ppsecCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ppsec");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("试卷段落"); 
		return column;
	}
	/**
	 * 获取试题类别表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_qucaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_quca");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("试题类别"); 
		return column;
	}
	/**
	 * 获取试题类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_qutypeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_qutype");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("试题类型"); 
		return column;
	}
	/**
	 * 获取试题类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_qutypeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_qutype");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("试题类型编码"); 
		return column;
	}
	/**
	 * 获取难度表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_qulvlCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_qulvl");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("难度"); 
		return column;
	}
	/**
	 * 获取难度编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_qulvlCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_qulvl");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("难度编码"); 
		return column;
	}
	/**
	 * 获取题目数量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuanCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Quan");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("题目数量"); 
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
	 * 获取试卷名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_ppCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_pp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("试卷名称"); 
		return column;
	}
	/**
	 * 获取段落名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_ppsecCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_ppsec");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("段落名称"); 
		return column;
	}
	/**
	 * 获取试题类别名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_qucaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_quca");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("试题类别名称"); 
		return column;
	}
	/**
	 * 获取试题类型名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_qutypeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_qutype");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("试题类型名称"); 
		return column;
	}
	/**
	 * 获取试题难度名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_qulvlCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_qulvl");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("试题难度名称"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id_org","Id_org");
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
	
}
