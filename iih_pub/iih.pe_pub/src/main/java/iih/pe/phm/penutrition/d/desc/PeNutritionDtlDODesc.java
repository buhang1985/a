
package iih.pe.phm.penutrition.d.desc;

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
 * 健康营养评估结果 DO 元数据信息
 */
public class PeNutritionDtlDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.pe.phm.penutrition.d.PeNutritionDtlDO";
	public static final String CLASS_DISPALYNAME = "健康营养评估结果";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "pe_hm_nutritiondtl";
	public static final String TABLE_ALIAS_NAME = "a1";
	public static final String PRIMARYKEY_FIELDNAME="Id_penutritiondtl";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public PeNutritionDtlDODesc(){
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
		this.setKeyDesc(getId_penutritiondtlADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_penutritionADesc(tblDesc));
		this.add(getId_penutritiondtlADesc(tblDesc));
		this.add(getId_penutritionADesc(tblDesc));
		this.add(getId_peevalnutritionclsADesc(tblDesc));
		this.add(getIntakeADesc(tblDesc));
		this.add(getLevel_intakeADesc(tblDesc));
		this.add(getCode_nuclsADesc(tblDesc));
		this.add(getName_nuclsADesc(tblDesc));
		this.add(getValue_refADesc(tblDesc));
		this.add(getValue_lowADesc(tblDesc));
		this.add(getValue_highADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_penutritiondtlCDesc(tblDesc));
		tblDesc.add(getId_penutritiondtlCDesc(tblDesc));
		tblDesc.add(getId_penutritionCDesc(tblDesc));
		tblDesc.add(getId_peevalnutritionclsCDesc(tblDesc));
		tblDesc.add(getIntakeCDesc(tblDesc));
		tblDesc.add(getLevel_intakeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 健康营养评估结果主键标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_penutritiondtlADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_penutritiondtl",  getId_penutritiondtlCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("健康营养评估结果主键标识");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 健康营养评估ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_penutritionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_penutrition",  getId_penutritionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("健康营养评估ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 健康营养评估定义营养分类ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_peevalnutritionclsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_peevalnutritioncls",  getId_peevalnutritionclsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("健康营养评估定义营养分类ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 实际摄入量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIntakeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Intake",  getIntakeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("实际摄入量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 摄入量分级属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getLevel_intakeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Level_intake",  getLevel_intakeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("摄入量分级");
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
	private IAttrDesc getCode_nuclsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_nucls",  getCode_nuclsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_qn_peevalnutritioncls a1b3","id_peevalnutritioncls=id_peevalnutritioncls","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_nuclsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_nucls",  getName_nuclsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_qn_peevalnutritioncls a1b3","id_peevalnutritioncls=id_peevalnutritioncls","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 参考摄入量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getValue_refADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Value_ref",  getValue_refCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("参考摄入量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_qn_peevalnutritioncls a1b3","id_peevalnutritioncls=id_peevalnutritioncls","value_ref"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 低值属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getValue_lowADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Value_low",  getValue_lowCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("低值");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_qn_peevalnutritioncls a1b3","id_peevalnutritioncls=id_peevalnutritioncls","value_low"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 高值属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getValue_highADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Value_high",  getValue_highCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("高值");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_qn_peevalnutritioncls a1b3","id_peevalnutritioncls=id_peevalnutritioncls","value_high"});
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
		attrDesc.setRefTblInfos(new String[]{"pe_qn_peevalnutritioncls a1b3","id_peevalnutritioncls=id_peevalnutritioncls","id_riskdef"});
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 获取健康营养评估结果主键标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_penutritiondtlCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_penutritiondtl");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("健康营养评估结果主键标识"); 
		return column;
	}
	/**
	 * 获取健康营养评估ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_penutritionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_penutrition");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("健康营养评估ID"); 
		return column;
	}
	/**
	 * 获取健康营养评估定义营养分类ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_peevalnutritionclsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_peevalnutritioncls");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("健康营养评估定义营养分类ID"); 
		return column;
	}
	/**
	 * 获取实际摄入量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIntakeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Intake");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("实际摄入量"); 
		return column;
	}
	/**
	 * 获取摄入量分级表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getLevel_intakeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Level_intake");
		column.setLength(20);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("摄入量分级"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_nuclsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_nucls");
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
	private IColumnDesc getName_nuclsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_nucls");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取参考摄入量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getValue_refCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Value_ref");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("参考摄入量"); 
		return column;
	}
	/**
	 * 获取低值表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getValue_lowCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Value_low");
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
	private IColumnDesc getValue_highCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Value_high");
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("高值"); 
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
		iBDDataInfoFldMap.put("id","Id_penutritiondtl");
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
