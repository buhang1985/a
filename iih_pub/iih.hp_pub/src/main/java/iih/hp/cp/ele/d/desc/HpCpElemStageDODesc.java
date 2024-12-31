
package iih.hp.cp.ele.d.desc;

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
 * 诊疗计划元素_计划阶段 DO 元数据信息
 */
public class HpCpElemStageDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.hp.cp.ele.d.HpCpElemStageDO";
	public static final String CLASS_DISPALYNAME = "诊疗计划元素_计划阶段";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "HP_CP_ELE_STAGE";
	public static final String TABLE_ALIAS_NAME = "a9";
	public static final String PRIMARYKEY_FIELDNAME="Id_ele_stage";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public HpCpElemStageDODesc(){
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
		this.setKeyDesc(getId_ele_stageADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_eleADesc(tblDesc));
		this.add(getId_ele_stageADesc(tblDesc));
		this.add(getId_eleADesc(tblDesc));
		this.add(getSerialnoADesc(tblDesc));
		this.add(getFg_sugery_dayADesc(tblDesc));
		this.add(getEu_relativetpADesc(tblDesc));
		this.add(getRelativeminADesc(tblDesc));
		this.add(getRelativemaxADesc(tblDesc));
		this.add(getEu_relative_unitsADesc(tblDesc));
		this.add(getId_ele_transcriterionADesc(tblDesc));
		this.add(getEu_normtranstgttpADesc(tblDesc));
		this.add(getNormtranstgtADesc(tblDesc));
		this.add(getEu_abertranstgttpADesc(tblDesc));
		this.add(getAbertranstgtADesc(tblDesc));
		this.add(getFg_neednursignADesc(tblDesc));
		this.add(getFg_needdoctsignADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_ele_stageCDesc(tblDesc));
		tblDesc.add(getId_ele_stageCDesc(tblDesc));
		tblDesc.add(getId_eleCDesc(tblDesc));
		tblDesc.add(getSerialnoCDesc(tblDesc));
		tblDesc.add(getFg_sugery_dayCDesc(tblDesc));
		tblDesc.add(getEu_relativetpCDesc(tblDesc));
		tblDesc.add(getRelativeminCDesc(tblDesc));
		tblDesc.add(getRelativemaxCDesc(tblDesc));
		tblDesc.add(getEu_relative_unitsCDesc(tblDesc));
		tblDesc.add(getId_ele_transcriterionCDesc(tblDesc));
		tblDesc.add(getEu_normtranstgttpCDesc(tblDesc));
		tblDesc.add(getNormtranstgtCDesc(tblDesc));
		tblDesc.add(getEu_abertranstgttpCDesc(tblDesc));
		tblDesc.add(getAbertranstgtCDesc(tblDesc));
		tblDesc.add(getFg_neednursignCDesc(tblDesc));
		tblDesc.add(getFg_needdoctsignCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 计划阶段ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ele_stageADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ele_stage",  getId_ele_stageCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("计划阶段ID");
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
	private IAttrDesc getId_eleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ele",  getId_eleCDesc(tblDesc), this);
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
	 * 序号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSerialnoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Serialno",  getSerialnoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("序号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否手术日属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_sugery_dayADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_sugery_day",  getFg_sugery_dayCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否手术日");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 相对时间类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_relativetpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_relativetp",  getEu_relativetpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("相对时间类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 相对时间数值下限属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRelativeminADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Relativemin",  getRelativeminCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("相对时间数值下限");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 相对时间数值上限属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRelativemaxADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Relativemax",  getRelativemaxCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("相对时间数值上限");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 相对时间单位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_relative_unitsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_relative_units",  getEu_relative_unitsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("相对时间单位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 转移逻辑ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ele_transcriterionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ele_transcriterion",  getId_ele_transcriterionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("转移逻辑ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 正常转移目标类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_normtranstgttpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_normtranstgttp",  getEu_normtranstgttpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("正常转移目标类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 正常转移目标属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNormtranstgtADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Normtranstgt",  getNormtranstgtCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("正常转移目标");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 变异转移目标类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_abertranstgttpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_abertranstgttp",  getEu_abertranstgttpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("变异转移目标类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 变异转移目标属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAbertranstgtADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Abertranstgt",  getAbertranstgtCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("变异转移目标");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否需要护士签名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_neednursignADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_neednursign",  getFg_neednursignCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否需要护士签名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否需要医师签名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_needdoctsignADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_needdoctsign",  getFg_needdoctsignCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否需要医师签名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取计划阶段ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ele_stageCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ele_stage");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("计划阶段ID"); 
		return column;
	}
	/**
	 * 获取元素ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_eleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ele");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("元素ID"); 
		return column;
	}
	/**
	 * 获取序号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSerialnoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Serialno");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("序号"); 
		return column;
	}
	/**
	 * 获取是否手术日表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_sugery_dayCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_sugery_day");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否手术日"); 
		return column;
	}
	/**
	 * 获取相对时间类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_relativetpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_relativetp");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("相对时间类型"); 
		return column;
	}
	/**
	 * 获取相对时间数值下限表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRelativeminCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Relativemin");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("相对时间数值下限"); 
		return column;
	}
	/**
	 * 获取相对时间数值上限表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRelativemaxCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Relativemax");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("相对时间数值上限"); 
		return column;
	}
	/**
	 * 获取相对时间单位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_relative_unitsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_relative_units");
		column.setLength(1);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("相对时间单位"); 
		return column;
	}
	/**
	 * 获取转移逻辑ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ele_transcriterionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ele_transcriterion");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("转移逻辑ID"); 
		return column;
	}
	/**
	 * 获取正常转移目标类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_normtranstgttpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_normtranstgttp");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("正常转移目标类型"); 
		return column;
	}
	/**
	 * 获取正常转移目标表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNormtranstgtCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Normtranstgt");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("正常转移目标"); 
		return column;
	}
	/**
	 * 获取变异转移目标类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_abertranstgttpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_abertranstgttp");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("变异转移目标类型"); 
		return column;
	}
	/**
	 * 获取变异转移目标表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAbertranstgtCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Abertranstgt");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("变异转移目标"); 
		return column;
	}
	/**
	 * 获取是否需要护士签名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_neednursignCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_neednursign");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否需要护士签名"); 
		return column;
	}
	/**
	 * 获取是否需要医师签名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_needdoctsignCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_needdoctsign");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否需要医师签名"); 
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
	}
	
}
