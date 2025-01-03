
package iih.pe.pitm.perules.d.desc;

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
 * 体检规则条件 DO 元数据信息
 */
public class PeRuleDtlDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.pe.pitm.perules.d.PeRuleDtlDO";
	public static final String CLASS_DISPALYNAME = "体检规则条件";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "pe_itm_peruledtl";
	public static final String TABLE_ALIAS_NAME = "a2";
	public static final String PRIMARYKEY_FIELDNAME="Id_peruledtl";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public PeRuleDtlDODesc(){
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
		this.setKeyDesc(getId_peruledtlADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_peruledefADesc(tblDesc));
		this.add(getId_peruledtlADesc(tblDesc));
		this.add(getId_peruledefADesc(tblDesc));
		this.add(getId_pesrvitemADesc(tblDesc));
		this.add(getIdxADesc(tblDesc));
		this.add(getLogic_operatorADesc(tblDesc));
		this.add(getLeft_bracketADesc(tblDesc));
		this.add(getOperandADesc(tblDesc));
		this.add(getOperatorADesc(tblDesc));
		this.add(getValADesc(tblDesc));
		this.add(getRight_bracketADesc(tblDesc));
		this.add(getItemcmptpADesc(tblDesc));
		this.add(getSd_ruleADesc(tblDesc));
		this.add(getSd_itemADesc(tblDesc));
		this.add(getSd_logicADesc(tblDesc));
		this.add(getCodeADesc(tblDesc));
		this.add(getCode_itmADesc(tblDesc));
		this.add(getName_itmADesc(tblDesc));
		this.add(getReference_itmADesc(tblDesc));
		this.add(getResulttpADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_peruledtlCDesc(tblDesc));
		tblDesc.add(getId_peruledtlCDesc(tblDesc));
		tblDesc.add(getId_peruledefCDesc(tblDesc));
		tblDesc.add(getId_pesrvitemCDesc(tblDesc));
		tblDesc.add(getIdxCDesc(tblDesc));
		tblDesc.add(getLogic_operatorCDesc(tblDesc));
		tblDesc.add(getLeft_bracketCDesc(tblDesc));
		tblDesc.add(getOperandCDesc(tblDesc));
		tblDesc.add(getOperatorCDesc(tblDesc));
		tblDesc.add(getValCDesc(tblDesc));
		tblDesc.add(getRight_bracketCDesc(tblDesc));
		tblDesc.add(getItemcmptpCDesc(tblDesc));
		tblDesc.add(getSd_ruleCDesc(tblDesc));
		tblDesc.add(getSd_itemCDesc(tblDesc));
		tblDesc.add(getSd_logicCDesc(tblDesc));
		tblDesc.add(getCodeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 体检规则明细主键标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_peruledtlADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_peruledtl",  getId_peruledtlCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检规则明细主键标识");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检异常判断规则ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_peruledefADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_peruledef",  getId_peruledefCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检异常判断规则ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检结果ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pesrvitemADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pesrvitem",  getId_pesrvitemCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检结果ID");
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
	 * 体检结果比较类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getItemcmptpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Itemcmptp",  getItemcmptpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("体检结果比较类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 规则编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_ruleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_rule",  getSd_ruleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("规则编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检结果编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_itemADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_item",  getSd_itemCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检结果编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 逻辑符号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_logicADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_logic",  getSd_logicCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("逻辑符号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 索引编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code",  getCodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("索引编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 结果编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_itmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_itm",  getCode_itmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("结果编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_itm_pesrvitem a2b2","id_pesrvitem=id_pesrvitem","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 结果名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_itmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_itm",  getName_itmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("结果名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_itm_pesrvitem a2b2","id_pesrvitem=id_pesrvitem","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 参考范围属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getReference_itmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Reference_itm",  getReference_itmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("参考范围");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_itm_pesrvitem a2b2","id_pesrvitem=id_pesrvitem","reference"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检检查小项结果类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getResulttpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Resulttp",  getResulttpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("体检检查小项结果类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_itm_pesrvitem a2b2","id_pesrvitem=id_pesrvitem","resulttp"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取体检规则明细主键标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_peruledtlCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_peruledtl");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("体检规则明细主键标识"); 
		return column;
	}
	/**
	 * 获取体检异常判断规则ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_peruledefCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_peruledef");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检异常判断规则ID"); 
		return column;
	}
	/**
	 * 获取体检结果ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pesrvitemCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pesrvitem");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检结果ID"); 
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
		column.setLength(300);
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
	 * 获取体检结果比较类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getItemcmptpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Itemcmptp");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("体检结果比较类型"); 
		return column;
	}
	/**
	 * 获取规则编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_ruleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_rule");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("规则编码"); 
		return column;
	}
	/**
	 * 获取体检结果编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_itemCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_item");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检结果编码"); 
		return column;
	}
	/**
	 * 获取逻辑符号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_logicCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_logic");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("逻辑符号"); 
		return column;
	}
	/**
	 * 获取索引编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("索引编码"); 
		return column;
	}
	/**
	 * 获取结果编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_itmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_itm");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("结果编码"); 
		return column;
	}
	/**
	 * 获取结果名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_itmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_itm");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("结果名称"); 
		return column;
	}
	/**
	 * 获取参考范围表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getReference_itmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Reference_itm");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("参考范围"); 
		return column;
	}
	/**
	 * 获取体检检查小项结果类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getResulttpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Resulttp");
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("体检检查小项结果类型"); 
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
		defaultValueMap.put("Logic_operator",0);
		defaultValueMap.put("Operator",1);
		defaultValueMap.put("Itemcmptp",1);
	}
	
}
