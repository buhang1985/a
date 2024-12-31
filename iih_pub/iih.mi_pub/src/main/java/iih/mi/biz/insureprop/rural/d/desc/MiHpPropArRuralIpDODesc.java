
package iih.mi.biz.insureprop.rural.d.desc;

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
 * 医保分摊国家新农合 DO 元数据信息
 */
public class MiHpPropArRuralIpDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.mi.biz.insureprop.rural.d.MiHpPropArRuralIpDO";
	public static final String CLASS_DISPALYNAME = "医保分摊国家新农合";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "mi_prop_arip_rural";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_propariprural";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public MiHpPropArRuralIpDODesc(){
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
		this.setKeyDesc(getId_proparipruralADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_proparipruralADesc(tblDesc));
		this.add(getAmt_allADesc(tblDesc));
		this.add(getAmt_patADesc(tblDesc));
		this.add(getHppolicyADesc(tblDesc));
		this.add(getAmt_hpactualADesc(tblDesc));
		this.add(getAmt_hpADesc(tblDesc));
		this.add(getAmt_drgsADesc(tblDesc));
		this.add(getAmt_sillADesc(tblDesc));
		this.add(getAmt_sill_actualADesc(tblDesc));
		this.add(getAmt_civilADesc(tblDesc));
		this.add(getRatio_hpADesc(tblDesc));
		this.add(getAmt_accumyearADesc(tblDesc));
		this.add(getTimes_accumyearADesc(tblDesc));
		this.add(getAmt_lowerADesc(tblDesc));
		this.add(getAmt_topADesc(tblDesc));
		this.add(getAmt_deducADesc(tblDesc));
		this.add(getAmt_advanceADesc(tblDesc));
		this.add(getId_proparipADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_proparipruralCDesc(tblDesc));
		tblDesc.add(getId_proparipruralCDesc(tblDesc));
		tblDesc.add(getAmt_allCDesc(tblDesc));
		tblDesc.add(getAmt_patCDesc(tblDesc));
		tblDesc.add(getHppolicyCDesc(tblDesc));
		tblDesc.add(getAmt_hpactualCDesc(tblDesc));
		tblDesc.add(getAmt_hpCDesc(tblDesc));
		tblDesc.add(getAmt_drgsCDesc(tblDesc));
		tblDesc.add(getAmt_sillCDesc(tblDesc));
		tblDesc.add(getAmt_sill_actualCDesc(tblDesc));
		tblDesc.add(getAmt_civilCDesc(tblDesc));
		tblDesc.add(getRatio_hpCDesc(tblDesc));
		tblDesc.add(getAmt_accumyearCDesc(tblDesc));
		tblDesc.add(getTimes_accumyearCDesc(tblDesc));
		tblDesc.add(getAmt_lowerCDesc(tblDesc));
		tblDesc.add(getAmt_topCDesc(tblDesc));
		tblDesc.add(getAmt_deducCDesc(tblDesc));
		tblDesc.add(getAmt_advanceCDesc(tblDesc));
		tblDesc.add(getId_proparipCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 应收扩展表主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_proparipruralADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_propariprural",  getId_proparipruralCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("应收扩展表主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 费用总额属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_allADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_all",  getAmt_allCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("费用总额");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 自付金额属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_patADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_pat",  getAmt_patCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("自付金额");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 报销（政策）年度属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHppolicyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Hppolicy",  getHppolicyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("报销（政策）年度");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 实际报销总额属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_hpactualADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_hpactual",  getAmt_hpactualCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("实际报销总额");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 可报销总额属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_hpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_hp",  getAmt_hpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("可报销总额");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 单病种费用定额属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_drgsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_drgs",  getAmt_drgsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("单病种费用定额");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 大病保险可补偿额属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_sillADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_sill",  getAmt_sillCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("大病保险可补偿额");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 大病保险实际补偿额属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_sill_actualADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_sill_actual",  getAmt_sill_actualCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("大病保险实际补偿额");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 民政救助补偿额属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_civilADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_civil",  getAmt_civilCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("民政救助补偿额");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 整体报销比例属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRatio_hpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ratio_hp",  getRatio_hpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("整体报销比例");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 本年度累计报销金额属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_accumyearADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_accumyear",  getAmt_accumyearCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("本年度累计报销金额");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 本年度累计报销次数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTimes_accumyearADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Times_accumyear",  getTimes_accumyearCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("本年度累计报销次数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 起付线属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_lowerADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_lower",  getAmt_lowerCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("起付线");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 封顶线属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_topADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_top",  getAmt_topCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("封顶线");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 扣减总额属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_deducADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_deduc",  getAmt_deducCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("扣减总额");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 垫付总额属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_advanceADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_advance",  getAmt_advanceCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("垫付总额");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 应收主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_proparipADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_proparip",  getId_proparipCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("应收主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取应收扩展表主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_proparipruralCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_propariprural");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("应收扩展表主键"); 
		return column;
	}
	/**
	 * 获取费用总额表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_allCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_all");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("费用总额"); 
		return column;
	}
	/**
	 * 获取自付金额表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_pat");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("自付金额"); 
		return column;
	}
	/**
	 * 获取报销（政策）年度表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHppolicyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Hppolicy");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("报销（政策）年度"); 
		return column;
	}
	/**
	 * 获取实际报销总额表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_hpactualCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_hpactual");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("实际报销总额"); 
		return column;
	}
	/**
	 * 获取可报销总额表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_hpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_hp");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("可报销总额"); 
		return column;
	}
	/**
	 * 获取单病种费用定额表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_drgsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_drgs");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("单病种费用定额"); 
		return column;
	}
	/**
	 * 获取大病保险可补偿额表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_sillCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_sill");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("大病保险可补偿额"); 
		return column;
	}
	/**
	 * 获取大病保险实际补偿额表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_sill_actualCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_sill_actual");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("大病保险实际补偿额"); 
		return column;
	}
	/**
	 * 获取民政救助补偿额表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_civilCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_civil");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("民政救助补偿额"); 
		return column;
	}
	/**
	 * 获取整体报销比例表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRatio_hpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ratio_hp");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("整体报销比例"); 
		return column;
	}
	/**
	 * 获取本年度累计报销金额表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_accumyearCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_accumyear");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("本年度累计报销金额"); 
		return column;
	}
	/**
	 * 获取本年度累计报销次数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTimes_accumyearCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Times_accumyear");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("本年度累计报销次数"); 
		return column;
	}
	/**
	 * 获取起付线表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_lowerCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_lower");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("起付线"); 
		return column;
	}
	/**
	 * 获取封顶线表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_topCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_top");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("封顶线"); 
		return column;
	}
	/**
	 * 获取扣减总额表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_deducCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_deduc");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("扣减总额"); 
		return column;
	}
	/**
	 * 获取垫付总额表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_advanceCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_advance");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("垫付总额"); 
		return column;
	}
	/**
	 * 获取应收主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_proparipCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_proparip");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("应收主键"); 
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
