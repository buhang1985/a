
package iih.pe.phm.pehmriskrule.d.desc;

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
 * 健康危险因素规则定义项目 DO 元数据信息
 */
public class PeHmRiskRuleItemDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.pe.phm.pehmriskrule.d.PeHmRiskRuleItemDO";
	public static final String CLASS_DISPALYNAME = "健康危险因素规则定义项目";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "pe_hm_riskruleitem";
	public static final String TABLE_ALIAS_NAME = "a1";
	public static final String PRIMARYKEY_FIELDNAME="Id_riskruleitem";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public PeHmRiskRuleItemDODesc(){
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
		this.setKeyDesc(getId_riskruleitemADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_riskruleADesc(tblDesc));
		this.add(getId_riskruleitemADesc(tblDesc));
		this.add(getId_riskruleADesc(tblDesc));
		this.add(getId_riskdefADesc(tblDesc));
		this.add(getIdxADesc(tblDesc));
		this.add(getLogic_operatorADesc(tblDesc));
		this.add(getLeft_bracketADesc(tblDesc));
		this.add(getOperandADesc(tblDesc));
		this.add(getOperatorADesc(tblDesc));
		this.add(getValADesc(tblDesc));
		this.add(getRight_bracketADesc(tblDesc));
		this.add(getItemcmptpADesc(tblDesc));
		this.add(getCode_riskADesc(tblDesc));
		this.add(getName_riskADesc(tblDesc));
		this.add(getDatatpADesc(tblDesc));
		this.add(getValue_ref_riskADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_riskruleitemCDesc(tblDesc));
		tblDesc.add(getId_riskruleitemCDesc(tblDesc));
		tblDesc.add(getId_riskruleCDesc(tblDesc));
		tblDesc.add(getId_riskdefCDesc(tblDesc));
		tblDesc.add(getIdxCDesc(tblDesc));
		tblDesc.add(getLogic_operatorCDesc(tblDesc));
		tblDesc.add(getLeft_bracketCDesc(tblDesc));
		tblDesc.add(getOperandCDesc(tblDesc));
		tblDesc.add(getOperatorCDesc(tblDesc));
		tblDesc.add(getValCDesc(tblDesc));
		tblDesc.add(getRight_bracketCDesc(tblDesc));
		tblDesc.add(getItemcmptpCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 健康危险因素规则项目主键标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_riskruleitemADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_riskruleitem",  getId_riskruleitemCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("健康危险因素规则项目主键标识");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 健康危险因素规则ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_riskruleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_riskrule",  getId_riskruleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("健康危险因素规则ID");
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
	 * 索引属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIdxADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Idx",  getIdxCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("索引");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 逻辑操作符属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getLogic_operatorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Logic_operator",  getLogic_operatorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("逻辑操作符");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 左括号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getLeft_bracketADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Left_bracket",  getLeft_bracketCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("左括号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 操作数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOperandADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Operand",  getOperandCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("操作数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 操作符属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOperatorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Operator",  getOperatorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("操作符");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 值属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getValADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Val",  getValCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("值");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 右括号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRight_bracketADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Right_bracket",  getRight_bracketCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("右括号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 结果比较方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getItemcmptpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Itemcmptp",  getItemcmptpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("结果比较方式");
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
		attrDesc.setRefTblInfos(new String[]{"pe_hm_riskdef a1b3","id_riskdef=id_riskdef","code"});
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
		attrDesc.setRefTblInfos(new String[]{"pe_hm_riskdef a1b3","id_riskdef=id_riskdef","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 数据来源属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDatatpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Datatp",  getDatatpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("数据来源");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_hm_riskdef a1b3","id_riskdef=id_riskdef","datatp"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 参考值属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getValue_ref_riskADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Value_ref_risk",  getValue_ref_riskCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("参考值");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_hm_riskdef a1b3","id_riskdef=id_riskdef","value_ref"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取健康危险因素规则项目主键标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_riskruleitemCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_riskruleitem");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("健康危险因素规则项目主键标识"); 
		return column;
	}
	/**
	 * 获取健康危险因素规则ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_riskruleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_riskrule");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("健康危险因素规则ID"); 
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
	 * 获取索引表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIdxCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Idx");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("索引"); 
		return column;
	}
	/**
	 * 获取逻辑操作符表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getLogic_operatorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Logic_operator");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("逻辑操作符"); 
		return column;
	}
	/**
	 * 获取左括号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getLeft_bracketCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Left_bracket");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("左括号"); 
		return column;
	}
	/**
	 * 获取操作数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOperandCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Operand");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("操作数"); 
		return column;
	}
	/**
	 * 获取操作符表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOperatorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Operator");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("操作符"); 
		return column;
	}
	/**
	 * 获取值表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getValCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Val");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("值"); 
		return column;
	}
	/**
	 * 获取右括号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRight_bracketCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Right_bracket");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("右括号"); 
		return column;
	}
	/**
	 * 获取结果比较方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getItemcmptpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Itemcmptp");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("结果比较方式"); 
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
	 * 获取数据来源表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDatatpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Datatp");
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("数据来源"); 
		return column;
	}
	/**
	 * 获取参考值表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getValue_ref_riskCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Value_ref_risk");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("参考值"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id","Id_riskruleitem");
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
