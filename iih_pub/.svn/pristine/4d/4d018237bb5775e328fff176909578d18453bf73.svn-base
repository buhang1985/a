
package iih.pe.phm.pehmriskdef.d.desc;

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
 * 健康危险因素-问卷关系定义 DO 元数据信息
 */
public class PeHmRiskSurveyDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.pe.phm.pehmriskdef.d.PeHmRiskSurveyDO";
	public static final String CLASS_DISPALYNAME = "健康危险因素-问卷关系定义";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "pe_hm_pehmrisksurvey";
	public static final String TABLE_ALIAS_NAME = "a3";
	public static final String PRIMARYKEY_FIELDNAME="Id_pehmrisksurvey";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public PeHmRiskSurveyDODesc(){
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
		this.setKeyDesc(getId_pehmrisksurveyADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_riskdefADesc(tblDesc));
		this.add(getId_pehmrisksurveyADesc(tblDesc));
		this.add(getId_peqacatlogADesc(tblDesc));
		this.add(getId_peqacontentdefADesc(tblDesc));
		this.add(getId_peqakeydefADesc(tblDesc));
		this.add(getId_riskdefADesc(tblDesc));
		this.add(getCode_topicADesc(tblDesc));
		this.add(getName_topicADesc(tblDesc));
		this.add(getCode_subjectADesc(tblDesc));
		this.add(getName_subjectADesc(tblDesc));
		this.add(getCode_keyADesc(tblDesc));
		this.add(getName_keyADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_pehmrisksurveyCDesc(tblDesc));
		tblDesc.add(getId_pehmrisksurveyCDesc(tblDesc));
		tblDesc.add(getId_peqacatlogCDesc(tblDesc));
		tblDesc.add(getId_peqacontentdefCDesc(tblDesc));
		tblDesc.add(getId_peqakeydefCDesc(tblDesc));
		tblDesc.add(getId_riskdefCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 健康危险因素-问卷关系定义主键标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pehmrisksurveyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pehmrisksurvey",  getId_pehmrisksurveyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("健康危险因素-问卷关系定义主键标识");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 问卷分组ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_peqacatlogADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_peqacatlog",  getId_peqacatlogCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("问卷分组ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 问卷问题库ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_peqacontentdefADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_peqacontentdef",  getId_peqacontentdefCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("问卷问题库ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 问题选项库ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_peqakeydefADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_peqakeydef",  getId_peqakeydefCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("问题选项库ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 健康危险因素目录ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_riskdefADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_riskdef",  getId_riskdefCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("健康危险因素目录ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 问卷分组编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_topicADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_topic",  getCode_topicCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("问卷分组编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_qn_peqacat a3b2","id_peqacatlog=id_peqacatlog","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 问卷分组名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_topicADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_topic",  getName_topicCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("问卷分组名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_qn_peqacat a3b2","id_peqacatlog=id_peqacatlog","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检问卷问题编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_subjectADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_subject",  getCode_subjectCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检问卷问题编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_qn_peqacontentdef a3b3","id_peqacontentdef=id_peqacontentdef","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检问卷问题属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_subjectADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_subject",  getName_subjectCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检问卷问题");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_qn_peqacontentdef a3b3","id_peqacontentdef=id_peqacontentdef","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_keyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_key",  getCode_keyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_qn_peqakeydef a3b4","id_peqakeydef=id_peqakeydef","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_keyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_key",  getName_keyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_qn_peqakeydef a3b4","id_peqakeydef=id_peqakeydef","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取健康危险因素-问卷关系定义主键标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pehmrisksurveyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pehmrisksurvey");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("健康危险因素-问卷关系定义主键标识"); 
		return column;
	}
	/**
	 * 获取问卷分组ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_peqacatlogCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_peqacatlog");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("问卷分组ID"); 
		return column;
	}
	/**
	 * 获取问卷问题库ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_peqacontentdefCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_peqacontentdef");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("问卷问题库ID"); 
		return column;
	}
	/**
	 * 获取问题选项库ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_peqakeydefCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_peqakeydef");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("问题选项库ID"); 
		return column;
	}
	/**
	 * 获取健康危险因素目录ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_riskdefCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_riskdef");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("健康危险因素目录ID"); 
		return column;
	}
	/**
	 * 获取问卷分组编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_topicCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_topic");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("问卷分组编码"); 
		return column;
	}
	/**
	 * 获取问卷分组名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_topicCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_topic");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("问卷分组名称"); 
		return column;
	}
	/**
	 * 获取体检问卷问题编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_subjectCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_subject");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检问卷问题编码"); 
		return column;
	}
	/**
	 * 获取体检问卷问题表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_subjectCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_subject");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检问卷问题"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_keyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_key");
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
	private IColumnDesc getName_keyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_key");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id","Id_pehmrisksurvey");
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
