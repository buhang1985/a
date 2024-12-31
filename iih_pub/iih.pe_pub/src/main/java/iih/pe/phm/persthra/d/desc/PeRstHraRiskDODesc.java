
package iih.pe.phm.persthra.d.desc;

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
 * 健康评估结果-单因素风险 DO 元数据信息
 */
public class PeRstHraRiskDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.pe.phm.persthra.d.PeRstHraRiskDO";
	public static final String CLASS_DISPALYNAME = "健康评估结果-单因素风险";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "pe_hm_persthrarisk";
	public static final String TABLE_ALIAS_NAME = "a1";
	public static final String PRIMARYKEY_FIELDNAME="Id_persthrarisk";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public PeRstHraRiskDODesc(){
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
		this.setKeyDesc(getId_persthrariskADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_persthraADesc(tblDesc));
		this.add(getId_persthrariskADesc(tblDesc));
		this.add(getId_persthraADesc(tblDesc));
		this.add(getId_pehramodelriskADesc(tblDesc));
		this.add(getRriADesc(tblDesc));
		this.add(getRrcADesc(tblDesc));
		this.add(getPADesc(tblDesc));
		this.add(getCode_riskADesc(tblDesc));
		this.add(getName_riskADesc(tblDesc));
		this.add(getGroupno_riskADesc(tblDesc));
		this.add(getSexlimit_riskADesc(tblDesc));
		this.add(getOpt_riskADesc(tblDesc));
		this.add(getVal_riskADesc(tblDesc));
		this.add(getVal_low_riskADesc(tblDesc));
		this.add(getVal_high_riskADesc(tblDesc));
		this.add(getRri_riskADesc(tblDesc));
		this.add(getRrc_riskADesc(tblDesc));
		this.add(getP_riskADesc(tblDesc));
		this.add(getId_riskdefADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_persthrariskCDesc(tblDesc));
		tblDesc.add(getId_persthrariskCDesc(tblDesc));
		tblDesc.add(getId_persthraCDesc(tblDesc));
		tblDesc.add(getId_pehramodelriskCDesc(tblDesc));
		tblDesc.add(getRriCDesc(tblDesc));
		tblDesc.add(getRrcCDesc(tblDesc));
		tblDesc.add(getPCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 健康评估结果单因素风险主键标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_persthrariskADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_persthrarisk",  getId_persthrariskCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("健康评估结果单因素风险主键标识");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 健康评估结果单因素ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_persthraADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_persthra",  getId_persthraCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("健康评估结果单因素ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 体检疾病风险评估模型危险因素ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pehramodelriskADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pehramodelrisk",  getId_pehramodelriskCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检疾病风险评估模型危险因素ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 个体相对风险度属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRriADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Rri",  getRriCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("个体相对风险度");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 专家风险度共识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRrcADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Rrc",  getRrcCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("专家风险度共识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 危险因素人群暴露率属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("P",  getPCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("危险因素人群暴露率");
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
	private IAttrDesc getCode_riskADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_risk",  getCode_riskCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_qn_pehramodelrisk a1b3","id_pehramodelrisk=id_pehramodelrisk","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_riskADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_risk",  getName_riskCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_qn_pehramodelrisk a1b3","id_pehramodelrisk=id_pehramodelrisk","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 组号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getGroupno_riskADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Groupno_risk",  getGroupno_riskCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("组号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_qn_pehramodelrisk a1b3","id_pehramodelrisk=id_pehramodelrisk","groupno"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 性别限制属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSexlimit_riskADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sexlimit_risk",  getSexlimit_riskCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("性别限制");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_qn_pehramodelrisk a1b3","id_pehramodelrisk=id_pehramodelrisk","sexlimit"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 计算等式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOpt_riskADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Opt_risk",  getOpt_riskCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("计算等式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_qn_pehramodelrisk a1b3","id_pehramodelrisk=id_pehramodelrisk","opt"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 结果值属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getVal_riskADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Val_risk",  getVal_riskCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("结果值");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_qn_pehramodelrisk a1b3","id_pehramodelrisk=id_pehramodelrisk","val"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 低值属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getVal_low_riskADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Val_low_risk",  getVal_low_riskCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("低值");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_qn_pehramodelrisk a1b3","id_pehramodelrisk=id_pehramodelrisk","val_low"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 高值属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getVal_high_riskADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Val_high_risk",  getVal_high_riskCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("高值");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_qn_pehramodelrisk a1b3","id_pehramodelrisk=id_pehramodelrisk","val_high"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 个体相对风险度属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRri_riskADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Rri_risk",  getRri_riskCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("个体相对风险度");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_qn_pehramodelrisk a1b3","id_pehramodelrisk=id_pehramodelrisk","rri"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 专家风险度共识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRrc_riskADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Rrc_risk",  getRrc_riskCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("专家风险度共识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_qn_pehramodelrisk a1b3","id_pehramodelrisk=id_pehramodelrisk","rrc"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 危险因素人群暴露率属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getP_riskADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("P_risk",  getP_riskCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("危险因素人群暴露率");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_qn_pehramodelrisk a1b3","id_pehramodelrisk=id_pehramodelrisk","p"});
		attrDesc.setRefType(false);
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
		attrDesc.setRefTblInfos(new String[]{"pe_qn_pehramodelrisk a1b3","id_pehramodelrisk=id_pehramodelrisk","id_riskdef"});
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 获取健康评估结果单因素风险主键标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_persthrariskCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_persthrarisk");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("健康评估结果单因素风险主键标识"); 
		return column;
	}
	/**
	 * 获取健康评估结果单因素ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_persthraCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_persthra");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("健康评估结果单因素ID"); 
		return column;
	}
	/**
	 * 获取体检疾病风险评估模型危险因素ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pehramodelriskCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pehramodelrisk");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检疾病风险评估模型危险因素ID"); 
		return column;
	}
	/**
	 * 获取个体相对风险度表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRriCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Rri");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("个体相对风险度"); 
		return column;
	}
	/**
	 * 获取专家风险度共识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRrcCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Rrc");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("专家风险度共识"); 
		return column;
	}
	/**
	 * 获取危险因素人群暴露率表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"P");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("危险因素人群暴露率"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_riskCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_risk");
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
	private IColumnDesc getName_riskCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_risk");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取组号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getGroupno_riskCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Groupno_risk");
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("组号"); 
		return column;
	}
	/**
	 * 获取性别限制表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSexlimit_riskCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sexlimit_risk");
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("性别限制"); 
		return column;
	}
	/**
	 * 获取计算等式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOpt_riskCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Opt_risk");
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("计算等式"); 
		return column;
	}
	/**
	 * 获取结果值表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getVal_riskCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Val_risk");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("结果值"); 
		return column;
	}
	/**
	 * 获取低值表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getVal_low_riskCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Val_low_risk");
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("低值"); 
		return column;
	}
	/**
	 * 获取高值表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getVal_high_riskCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Val_high_risk");
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("高值"); 
		return column;
	}
	/**
	 * 获取个体相对风险度表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRri_riskCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Rri_risk");
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("个体相对风险度"); 
		return column;
	}
	/**
	 * 获取专家风险度共识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRrc_riskCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Rrc_risk");
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("专家风险度共识"); 
		return column;
	}
	/**
	 * 获取危险因素人群暴露率表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getP_riskCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"P_risk");
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("危险因素人群暴露率"); 
		return column;
	}
	/**
	 * 获取健康危险因素目录ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_riskdefCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_riskdef");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("健康危险因素目录ID"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id","Id_persthrarisk");
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
