
package iih.sc.scp.scpltick.d.desc;

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
 * 排班计划号位 DO 元数据信息
 */
public class ScPlanWeekTickDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.sc.scp.scpltick.d.ScPlanWeekTickDO";
	public static final String CLASS_DISPALYNAME = "排班计划号位";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "sc_pl_week_tick";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_tick";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public ScPlanWeekTickDODesc(){
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
		this.setKeyDesc(getId_tickADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_tickADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_scplweekADesc(tblDesc));
		this.add(getCodeADesc(tblDesc));
		this.add(getNameADesc(tblDesc));
		this.add(getId_dayslotsecADesc(tblDesc));
		this.add(getQuenoADesc(tblDesc));
		this.add(getT_bADesc(tblDesc));
		this.add(getT_eADesc(tblDesc));
		this.add(getFg_usedADesc(tblDesc));
		this.add(getEu_usescopeADesc(tblDesc));
		this.add(getFg_activeADesc(tblDesc));
		this.add(getId_scsrvADesc(tblDesc));
		this.add(getFg_addADesc(tblDesc));
		this.add(getIds_scchlADesc(tblDesc));
		this.add(getPolnoADesc(tblDesc));
		this.add(getId_scplweekticksADesc(tblDesc));
        this.add(getIds_kinditmADesc(tblDesc));
		this.add(getCode_scsrvADesc(tblDesc));
		this.add(getName_scsrvADesc(tblDesc));
		this.add(getCode_scchlADesc(tblDesc));
		this.add(getName_scchlADesc(tblDesc));
		this.add(getCode_kinditmADesc(tblDesc));
		this.add(getName_kinditmADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_tickCDesc(tblDesc));
		tblDesc.add(getId_tickCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_scplweekCDesc(tblDesc));
		tblDesc.add(getCodeCDesc(tblDesc));
		tblDesc.add(getNameCDesc(tblDesc));
		tblDesc.add(getId_dayslotsecCDesc(tblDesc));
		tblDesc.add(getQuenoCDesc(tblDesc));
		tblDesc.add(getT_bCDesc(tblDesc));
		tblDesc.add(getT_eCDesc(tblDesc));
		tblDesc.add(getFg_usedCDesc(tblDesc));
		tblDesc.add(getEu_usescopeCDesc(tblDesc));
		tblDesc.add(getFg_activeCDesc(tblDesc));
		tblDesc.add(getId_scsrvCDesc(tblDesc));
		tblDesc.add(getFg_addCDesc(tblDesc));
		tblDesc.add(getIds_scchlCDesc(tblDesc));
		tblDesc.add(getPolnoCDesc(tblDesc));
		tblDesc.add(getId_scplweekticksCDesc(tblDesc));
        tblDesc.add(getIds_kinditmCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 号位ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_tickADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_tick",  getId_tickCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("号位ID");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
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
	 * 机构属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_orgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_org",  getId_orgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("机构");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 计划周属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_scplweekADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_scplweek",  getId_scplweekCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("计划周");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 号位编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code",  getCodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("号位编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 号位名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name",  getNameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("号位名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 对应日期分组下时段属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dayslotsecADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dayslotsec",  getId_dayslotsecCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("对应日期分组下时段");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 票号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuenoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Queno",  getQuenoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("票号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 预计开始时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getT_bADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("T_b",  getT_bCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FTime);
		attrDesc.setLabel("预计开始时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 预计结束时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getT_eADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("T_e",  getT_eCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FTime);
		attrDesc.setLabel("预计结束时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 已使用标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_usedADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_used",  getFg_usedCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("已使用标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 可使用范围属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_usescopeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_usescope",  getEu_usescopeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("可使用范围");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 启用标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_activeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_active",  getFg_activeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("启用标志");
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
	private IAttrDesc getId_scsrvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_scsrv",  getId_scsrvCDesc(tblDesc), this);
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
	 * 加号标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_addADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_add",  getFg_addCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("加号标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 使用渠道属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIds_scchlADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ids_scchl",  getIds_scchlCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("使用渠道");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 号源池属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPolnoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Polno",  getPolnoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("号源池");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 对应的号段id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_scplweekticksADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_scplweekticks",  getId_scplweekticksCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("对应的号段id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 可使用类别细目属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIds_kinditmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ids_kinditm",  getIds_kinditmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("可使用类别细目");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 排班服务编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_scsrvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_scsrv",  getCode_scsrvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("排班服务编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sc_srv a0b6","id_scsrv=id_scsrv","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 排班服务名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_scsrvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_scsrv",  getName_scsrvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("排班服务名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sc_srv a0b6","id_scsrv=id_scsrv","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 预约渠道编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_scchlADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_scchl",  getCode_scchlCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("预约渠道编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sc_chl a0b7","ids_scchl=id_scchl","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 预约渠道名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_scchlADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_scchl",  getName_scchlCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("预约渠道名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sc_chl a0b7","ids_scchl=id_scchl","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_kinditmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_kinditm",  getCode_kinditmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sc_srv_kind_itm a0b8","ids_kinditm=id_scsrvkinditm","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_kinditmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_kinditm",  getName_kinditmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sc_srv_kind_itm a0b8","ids_kinditm=id_scsrvkinditm","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取号位ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_tickCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_tick");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("号位ID"); 
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
	 * 获取机构表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_orgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_org");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("机构"); 
		return column;
	}
	/**
	 * 获取计划周表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_scplweekCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_scplweek");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("计划周"); 
		return column;
	}
	/**
	 * 获取号位编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("号位编码"); 
		return column;
	}
	/**
	 * 获取号位名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("号位名称"); 
		return column;
	}
	/**
	 * 获取对应日期分组下时段表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dayslotsecCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dayslotsec");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("对应日期分组下时段"); 
		return column;
	}
	/**
	 * 获取票号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuenoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Queno");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("票号"); 
		return column;
	}
	/**
	 * 获取预计开始时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getT_bCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"T_b");
		column.setLength(8);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("预计开始时间"); 
		return column;
	}
	/**
	 * 获取预计结束时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getT_eCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"T_e");
		column.setLength(8);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("预计结束时间"); 
		return column;
	}
	/**
	 * 获取已使用标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_usedCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_used");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("已使用标志"); 
		return column;
	}
	/**
	 * 获取可使用范围表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_usescopeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_usescope");
		column.setLength(20);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("可使用范围"); 
		return column;
	}
	/**
	 * 获取启用标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_activeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_active");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("启用标志"); 
		return column;
	}
	/**
	 * 获取排班服务表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_scsrvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_scsrv");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("排班服务"); 
		return column;
	}
	/**
	 * 获取加号标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_addCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_add");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("加号标志"); 
		return column;
	}
	/**
	 * 获取使用渠道表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIds_scchlCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ids_scchl");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("使用渠道"); 
		return column;
	}
	/**
	 * 获取号源池表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPolnoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Polno");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("号源池"); 
		return column;
	}
	/**
	 * 获取对应的号段id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_scplweekticksCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_scplweekticks");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("对应的号段id"); 
		return column;
	}
	/**
	 * 获取可使用类别细目表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIds_kinditmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ids_kinditm");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("可使用类别细目"); 
		return column;
	}
	/**
	 * 获取排班服务编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_scsrvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_scsrv");
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
	private IColumnDesc getName_scsrvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_scsrv");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("排班服务名称"); 
		return column;
	}
	/**
	 * 获取预约渠道编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_scchlCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_scchl");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("预约渠道编码"); 
		return column;
	}
	/**
	 * 获取预约渠道名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_scchlCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_scchl");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("预约渠道名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_kinditmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_kinditm");
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
	private IColumnDesc getName_kinditmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_kinditm");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
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
