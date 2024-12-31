
package iih.sc.scbd.screleaserule.d.desc;

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
 * 排班释放规则细目 DO 元数据信息
 */
public class ScReleaseRuleItmDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.sc.scbd.screleaserule.d.ScReleaseRuleItmDO";
	public static final String CLASS_DISPALYNAME = "排班释放规则细目";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "sc_release_rule_itm";
	public static final String TABLE_ALIAS_NAME = "a1";
	public static final String PRIMARYKEY_FIELDNAME="Id_release_ruleitm";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public ScReleaseRuleItmDODesc(){
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
		this.setKeyDesc(getId_release_ruleitmADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_release_ruleADesc(tblDesc));
		this.add(getId_release_ruleitmADesc(tblDesc));
		this.add(getId_release_ruleADesc(tblDesc));
		this.add(getId_sch_prop_tpADesc(tblDesc));
		this.add(getSd_sch_prop_tpADesc(tblDesc));
		this.add(getId_release_period_tpADesc(tblDesc));
		this.add(getSd_release_period_tpADesc(tblDesc));
		this.add(getNum_dayADesc(tblDesc));
		this.add(getNum_hourADesc(tblDesc));
		this.add(getIds_scsrvkinditmADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
                this.add(getFg_holiday_exclADesc(tblDesc));
		this.add(getIds_scsrvADesc(tblDesc));
		this.add(getName_sch_prop_tpADesc(tblDesc));
		this.add(getName_release_period_tpADesc(tblDesc));
		this.add(getCode_scsrvADesc(tblDesc));
		this.add(getName_scsrvADesc(tblDesc));
		this.add(getCode_scsrvsADesc(tblDesc));
		this.add(getName_scsrvsADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_release_ruleitmCDesc(tblDesc));
		tblDesc.add(getId_release_ruleitmCDesc(tblDesc));
		tblDesc.add(getId_release_ruleCDesc(tblDesc));
		tblDesc.add(getId_sch_prop_tpCDesc(tblDesc));
		tblDesc.add(getSd_sch_prop_tpCDesc(tblDesc));
		tblDesc.add(getId_release_period_tpCDesc(tblDesc));
		tblDesc.add(getSd_release_period_tpCDesc(tblDesc));
		tblDesc.add(getNum_dayCDesc(tblDesc));
		tblDesc.add(getNum_hourCDesc(tblDesc));
		tblDesc.add(getIds_scsrvkinditmCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		tblDesc.add(getFg_holiday_exclCDesc(tblDesc));
		tblDesc.add(getIds_scsrvCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 释放规则细目id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_release_ruleitmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_release_ruleitm",  getId_release_ruleitmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("释放规则细目id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 释放规则id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_release_ruleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_release_rule",  getId_release_ruleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("释放规则id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 排班属性类型id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_sch_prop_tpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_sch_prop_tp",  getId_sch_prop_tpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("排班属性类型id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 排班属性类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_sch_prop_tpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_sch_prop_tp",  getSd_sch_prop_tpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("排班属性类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 释放时间类型设置id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_release_period_tpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_release_period_tp",  getId_release_period_tpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("释放时间类型设置id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 释放时间类型设置编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_release_period_tpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_release_period_tp",  getSd_release_period_tpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("释放时间类型设置编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 提前天数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNum_dayADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Num_day",  getNum_dayCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("提前天数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 提前小时数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNum_hourADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Num_hour",  getNum_hourCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("提前小时数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 可用排班服务类别属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIds_scsrvkinditmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ids_scsrvkinditm",  getIds_scsrvkinditmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("可用排班服务类别");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
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
	 * 是否排除节假日属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_holiday_exclADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_holiday_excl",  getFg_holiday_exclCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否排除节假日");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 排班服务属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIds_scsrvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ids_scsrv",  getIds_scsrvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("排班服务");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 排班属性类型名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_sch_prop_tpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_sch_prop_tp",  getName_sch_prop_tpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("排班属性类型名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b4","id_sch_prop_tp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 释放时间类型名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_release_period_tpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_release_period_tp",  getName_release_period_tpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("释放时间类型名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b5","id_release_period_tp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 排班服务明细编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_scsrvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_scsrv",  getCode_scsrvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("排班服务明细编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sc_srv_kind_itm a1b6","ids_scsrvkinditm=id_scsrvkinditm","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 排班服务类别明细属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_scsrvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_scsrv",  getName_scsrvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("排班服务类别明细");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sc_srv_kind_itm a1b6","ids_scsrvkinditm=id_scsrvkinditm","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 排班服务编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_scsrvsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_scsrvs",  getCode_scsrvsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("排班服务编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sc_srv a1b7","ids_scsrv=id_scsrv","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 排班服务名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_scsrvsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_scsrvs",  getName_scsrvsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("排班服务名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sc_srv a1b7","ids_scsrv=id_scsrv","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取释放规则细目id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_release_ruleitmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_release_ruleitm");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("释放规则细目id"); 
		return column;
	}
	/**
	 * 获取释放规则id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_release_ruleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_release_rule");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("释放规则id"); 
		return column;
	}
	/**
	 * 获取排班属性类型id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_sch_prop_tpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_sch_prop_tp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("排班属性类型id"); 
		return column;
	}
	/**
	 * 获取排班属性类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_sch_prop_tpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_sch_prop_tp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("排班属性类型编码"); 
		return column;
	}
	/**
	 * 获取释放时间类型设置id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_release_period_tpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_release_period_tp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("释放时间类型设置id"); 
		return column;
	}
	/**
	 * 获取释放时间类型设置编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_release_period_tpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_release_period_tp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("释放时间类型设置编码"); 
		return column;
	}
	/**
	 * 获取提前天数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNum_dayCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Num_day");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("提前天数"); 
		return column;
	}
	/**
	 * 获取提前小时数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNum_hourCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Num_hour");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("提前小时数"); 
		return column;
	}
	/**
	 * 获取可用排班服务类别表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIds_scsrvkinditmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ids_scsrvkinditm");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("可用排班服务类别"); 
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
	 * 获取是否排除节假日表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_holiday_exclCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_holiday_excl");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否排除节假日"); 
		return column;
	}
	/**
	 * 获取排班服务表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIds_scsrvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ids_scsrv");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("排班服务"); 
		return column;
	}
	/**
	 * 获取排班属性类型名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_sch_prop_tpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_sch_prop_tp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("排班属性类型名称"); 
		return column;
	}
	/**
	 * 获取释放时间类型名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_release_period_tpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_release_period_tp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("释放时间类型名称"); 
		return column;
	}
	/**
	 * 获取排班服务明细编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_scsrvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_scsrv");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("排班服务明细编码"); 
		return column;
	}
	/**
	 * 获取排班服务类别明细表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_scsrvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_scsrv");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("排班服务类别明细"); 
		return column;
	}
	/**
	 * 获取排班服务编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_scsrvsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_scsrvs");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("排班服务编码"); 
		return column;
	}
	/**
	 * 获取排班服务名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_scsrvsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_scsrvs");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("排班服务名称"); 
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
