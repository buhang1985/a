
package iih.sc.scp.scplan.d.desc;

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
 * 排班计划 DO 元数据信息
 */
public class ScPlanDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.sc.scp.scplan.d.ScPlanDO";
	public static final String CLASS_DISPALYNAME = "排班计划";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "sc_pl";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_scpl";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public ScPlanDODesc(){
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
		this.setKeyDesc(getId_scplADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_scplADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_sctpADesc(tblDesc));
		this.add(getSd_sctpADesc(tblDesc));
		this.add(getId_depADesc(tblDesc));
		this.add(getId_scsrvADesc(tblDesc));
		this.add(getId_scresADesc(tblDesc));
		this.add(getId_sccaADesc(tblDesc));
		this.add(getCodeADesc(tblDesc));
		this.add(getNameADesc(tblDesc));
		this.add(getDesADesc(tblDesc));
		this.add(getScpolcnADesc(tblDesc));
		this.add(getId_tickmdADesc(tblDesc));
		this.add(getSd_tickmdADesc(tblDesc));
		this.add(getFg_tickADesc(tblDesc));
		this.add(getId_apptruADesc(tblDesc));
		this.add(getSrvslotADesc(tblDesc));
		this.add(getNoteADesc(tblDesc));
		this.add(getFg_activeADesc(tblDesc));
		this.add(getDef1ADesc(tblDesc));
		this.add(getDef2ADesc(tblDesc));
		this.add(getDef3ADesc(tblDesc));
		this.add(getDef4ADesc(tblDesc));
		this.add(getDef5ADesc(tblDesc));
		this.add(getDef6ADesc(tblDesc));
		this.add(getPycodeADesc(tblDesc));
		this.add(getWbcodeADesc(tblDesc));
		this.add(getInstrADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getD_last_schADesc(tblDesc));
		this.add(getEu_edit_tpADesc(tblDesc));
		this.add(getId_depparamADesc(tblDesc));
		this.add(getId_quebenADesc(tblDesc));
		this.add(getSrvslot_calADesc(tblDesc));
		this.add(getSrvslot_minADesc(tblDesc));
		this.add(getId_queruleADesc(tblDesc));
		this.add(getEu_timeslottpADesc(tblDesc));
		this.add(getLevel_priADesc(tblDesc));
		this.add(getId_release_ruleADesc(tblDesc));
		this.add(getFg_timechkADesc(tblDesc));
		this.add(getFg_stopschADesc(tblDesc));
		this.add(getName_depADesc(tblDesc));
		this.add(getName_srvADesc(tblDesc));
		this.add(getCode_srvADesc(tblDesc));
		this.add(getName_optsrvADesc(tblDesc));
		this.add(getCode_resADesc(tblDesc));
		this.add(getName_resADesc(tblDesc));
		this.add(getId_scca_scplADesc(tblDesc));
		this.add(getName_tickmdADesc(tblDesc));
		this.add(getCode_apptruADesc(tblDesc));
		this.add(getName_apptruADesc(tblDesc));
		this.add(getCode_schruleADesc(tblDesc));
		this.add(getVerADesc(tblDesc));
		this.add(getName_quebenADesc(tblDesc));
		this.add(getCode_quebenADesc(tblDesc));
		this.add(getName_ruleADesc(tblDesc));
		this.add(getCode_ruleADesc(tblDesc));
		this.add(getCode_release_ruleADesc(tblDesc));
		this.add(getName_release_ruleADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_scplCDesc(tblDesc));
		tblDesc.add(getId_scplCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_sctpCDesc(tblDesc));
		tblDesc.add(getSd_sctpCDesc(tblDesc));
		tblDesc.add(getId_depCDesc(tblDesc));
		tblDesc.add(getId_scsrvCDesc(tblDesc));
		tblDesc.add(getId_scresCDesc(tblDesc));
		tblDesc.add(getId_sccaCDesc(tblDesc));
		tblDesc.add(getCodeCDesc(tblDesc));
		tblDesc.add(getNameCDesc(tblDesc));
		tblDesc.add(getDesCDesc(tblDesc));
		tblDesc.add(getScpolcnCDesc(tblDesc));
		tblDesc.add(getId_tickmdCDesc(tblDesc));
		tblDesc.add(getSd_tickmdCDesc(tblDesc));
		tblDesc.add(getFg_tickCDesc(tblDesc));
		tblDesc.add(getId_apptruCDesc(tblDesc));
		tblDesc.add(getSrvslotCDesc(tblDesc));
		tblDesc.add(getNoteCDesc(tblDesc));
		tblDesc.add(getFg_activeCDesc(tblDesc));
		tblDesc.add(getDef1CDesc(tblDesc));
		tblDesc.add(getDef2CDesc(tblDesc));
		tblDesc.add(getDef3CDesc(tblDesc));
		tblDesc.add(getDef4CDesc(tblDesc));
		tblDesc.add(getDef5CDesc(tblDesc));
		tblDesc.add(getDef6CDesc(tblDesc));
		tblDesc.add(getPycodeCDesc(tblDesc));
		tblDesc.add(getWbcodeCDesc(tblDesc));
		tblDesc.add(getInstrCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		tblDesc.add(getD_last_schCDesc(tblDesc));
		tblDesc.add(getEu_edit_tpCDesc(tblDesc));
		tblDesc.add(getId_depparamCDesc(tblDesc));
		tblDesc.add(getId_quebenCDesc(tblDesc));
		tblDesc.add(getSrvslot_calCDesc(tblDesc));
		tblDesc.add(getSrvslot_minCDesc(tblDesc));
		tblDesc.add(getId_queruleCDesc(tblDesc));
		tblDesc.add(getEu_timeslottpCDesc(tblDesc));
		tblDesc.add(getLevel_priCDesc(tblDesc));
		tblDesc.add(getId_release_ruleCDesc(tblDesc));
		tblDesc.add(getFg_timechkCDesc(tblDesc));
		tblDesc.add(getFg_stopschCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 计划ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_scplADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_scpl",  getId_scplCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("计划ID");
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
		attrDesc.setNullable(false);
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
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 排班类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_sctpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_sctp",  getId_sctpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("排班类型");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 排班类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_sctpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_sctp",  getSd_sctpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("排班类型编码");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 计划归属部门属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_depADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep",  getId_depCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("计划归属部门");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
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
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 排班资源属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_scresADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_scres",  getId_scresCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("排班资源");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 排班分类属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_sccaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_scca",  getId_sccaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("排班分类");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 计划编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code",  getCodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("计划编码");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setExtTag("BDMODE,URC");
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 计划名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name",  getNameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("计划名称");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setExtTag("BDMODE,URC");
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 计划描述属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Des",  getDesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("计划描述");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 启用号源池总数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getScpolcnADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Scpolcn",  getScpolcnCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("启用号源池总数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 票号模式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_tickmdADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_tickmd",  getId_tickmdCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("票号模式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 票号模式编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_tickmdADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_tickmd",  getSd_tickmdCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("票号模式编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 生成号位标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_tickADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_tick",  getFg_tickCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("生成号位标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 优先开放规则属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_apptruADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_apptru",  getId_apptruCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("优先开放规则");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 单个服务时间(分钟)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSrvslotADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Srvslot",  getSrvslotCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("单个服务时间(分钟)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 注意事项属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNoteADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Note",  getNoteCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("注意事项");
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
		attrDesc.setExtTag("BDMODE,URC");
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段1属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef1ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def1",  getDef1CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段1");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段2属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef2ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def2",  getDef2CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段2");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段3属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef3ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def3",  getDef3CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段3");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段4属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef4ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def4",  getDef4CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段4");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段5属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef5ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def5",  getDef5CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段5");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段6属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef6ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def6",  getDef6CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段6");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 拼音码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPycodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pycode",  getPycodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("拼音码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 五笔码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWbcodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Wbcode",  getWbcodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("五笔码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 助记符属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInstrADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Instr",  getInstrCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("助记符");
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
	 * 最后排班日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getD_last_schADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("D_last_sch",  getD_last_schCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("最后排班日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编辑模式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_edit_tpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_edit_tp",  getEu_edit_tpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编辑模式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 科室参数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_depparamADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_depparam",  getId_depparamCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("科室参数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 队列工作台属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_quebenADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_queben",  getId_quebenCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("队列工作台");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 计算单服务时长属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSrvslot_calADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Srvslot_cal",  getSrvslot_calCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("计算单服务时长");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 最小刻度属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSrvslot_minADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Srvslot_min",  getSrvslot_minCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("最小刻度");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 规则属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_queruleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_querule",  getId_queruleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("规则");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 预约使用时间类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_timeslottpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_timeslottp",  getEu_timeslottpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("预约使用时间类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 预约优先级属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getLevel_priADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Level_pri",  getLevel_priCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("预约优先级");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 号源释放规则属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_release_ruleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_release_rule",  getId_release_ruleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("号源释放规则");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 时间核查标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_timechkADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_timechk",  getFg_timechkCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("时间核查标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 停止排班标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_stopschADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_stopsch",  getFg_stopschCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("停止排班标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 排班所属部门名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_depADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dep",  getName_depCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("排班所属部门名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b11","id_dep=id_dep","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 排班服务名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_srvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_srv",  getName_srvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("排班服务名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sc_srv a0b4","id_scsrv=id_scsrv","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 排班服务编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_srvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_srv",  getCode_srvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("排班服务编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sc_srv a0b4","id_scsrv=id_scsrv","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备用服务名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_optsrvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_optsrv",  getName_optsrvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备用服务名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sc_srv a0b12","id_optsrv=id_scsrv","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 资源编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_resADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_res",  getCode_resCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("资源编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sc_res a0b5","id_scres=id_scres","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 资源名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_resADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_res",  getName_resCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("资源名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sc_res a0b5","id_scres=id_scres","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 排班分类属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_scca_scplADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_scca_scpl",  getId_scca_scplCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("排班分类");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sc_res a0b5","id_scres=id_scres","id_scca"});
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 票号模式名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_tickmdADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_tickmd",  getName_tickmdCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("票号模式名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b6","id_tickmd=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 优先开放规则编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_apptruADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_apptru",  getCode_apptruCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("优先开放规则编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sc_apptrule a0b7","id_apptru=id_apptru","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 优先开放规则名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_apptruADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_apptru",  getName_apptruCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("优先开放规则名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sc_apptrule a0b7","id_apptru=id_apptru","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 优先开放规则类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_schruleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_schrule",  getCode_schruleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("优先开放规则类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sc_apptrule a0b7","id_apptru=id_apptru","sd_schrule"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 版本属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getVerADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ver",  getVerCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("版本");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sc_dep_param a0b13","id_depparam=id_deptparam","ver"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 工作台名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_quebenADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_queben",  getName_quebenCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("工作台名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_que_ben a0b15","id_queben=id_queben","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 工作台编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_quebenADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_queben",  getCode_quebenCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("工作台编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_que_ben a0b15","id_queben=id_queben","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_ruleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_rule",  getName_ruleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_que_rule a0b16","id_querule=id_querule","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_ruleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_rule",  getCode_ruleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_que_rule a0b16","id_querule=id_querule","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_release_ruleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_release_rule",  getCode_release_ruleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sc_release_rule a0b17","id_release_rule=id_release_rule","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_release_ruleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_release_rule",  getName_release_ruleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sc_release_rule a0b17","id_release_rule=id_release_rule","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取计划ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_scplCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_scpl");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("计划ID"); 
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
	 * 获取排班类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_sctpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_sctp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("排班类型"); 
		return column;
	}
	/**
	 * 获取排班类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_sctpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_sctp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("排班类型编码"); 
		return column;
	}
	/**
	 * 获取计划归属部门表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_depCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("计划归属部门"); 
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
	 * 获取排班资源表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_scresCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_scres");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("排班资源"); 
		return column;
	}
	/**
	 * 获取排班分类表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_sccaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_scca");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("排班分类"); 
		return column;
	}
	/**
	 * 获取计划编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("计划编码"); 
		return column;
	}
	/**
	 * 获取计划名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("计划名称"); 
		return column;
	}
	/**
	 * 获取计划描述表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Des");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("计划描述"); 
		return column;
	}
	/**
	 * 获取启用号源池总数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getScpolcnCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Scpolcn");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("启用号源池总数"); 
		return column;
	}
	/**
	 * 获取票号模式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_tickmdCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_tickmd");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("票号模式"); 
		return column;
	}
	/**
	 * 获取票号模式编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_tickmdCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_tickmd");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("票号模式编码"); 
		return column;
	}
	/**
	 * 获取生成号位标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_tickCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_tick");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("生成号位标志"); 
		return column;
	}
	/**
	 * 获取优先开放规则表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_apptruCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_apptru");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("优先开放规则"); 
		return column;
	}
	/**
	 * 获取单个服务时间(分钟)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSrvslotCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Srvslot");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("单个服务时间(分钟)"); 
		return column;
	}
	/**
	 * 获取注意事项表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNoteCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Note");
		column.setLength(1000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("注意事项"); 
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
	 * 获取客户扩展字段1表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef1CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def1");
		column.setLength(110);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段1"); 
		return column;
	}
	/**
	 * 获取客户扩展字段2表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef2CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def2");
		column.setLength(110);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段2"); 
		return column;
	}
	/**
	 * 获取客户扩展字段3表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef3CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def3");
		column.setLength(110);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段3"); 
		return column;
	}
	/**
	 * 获取客户扩展字段4表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef4CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def4");
		column.setLength(110);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段4"); 
		return column;
	}
	/**
	 * 获取客户扩展字段5表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef5CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def5");
		column.setLength(110);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段5"); 
		return column;
	}
	/**
	 * 获取客户扩展字段6表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef6CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def6");
		column.setLength(110);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段6"); 
		return column;
	}
	/**
	 * 获取拼音码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPycodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pycode");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("拼音码"); 
		return column;
	}
	/**
	 * 获取五笔码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWbcodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Wbcode");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("五笔码"); 
		return column;
	}
	/**
	 * 获取助记符表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInstrCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Instr");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("助记符"); 
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
	 * 获取最后排班日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getD_last_schCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"D_last_sch");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("最后排班日期"); 
		return column;
	}
	/**
	 * 获取编辑模式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_edit_tpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_edit_tp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编辑模式"); 
		return column;
	}
	/**
	 * 获取科室参数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_depparamCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_depparam");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("科室参数"); 
		return column;
	}
	/**
	 * 获取队列工作台表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_quebenCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_queben");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("队列工作台"); 
		return column;
	}
	/**
	 * 获取计算单服务时长表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSrvslot_calCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Srvslot_cal");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("计算单服务时长"); 
		return column;
	}
	/**
	 * 获取最小刻度表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSrvslot_minCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Srvslot_min");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("最小刻度"); 
		return column;
	}
	/**
	 * 获取规则表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_queruleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_querule");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("规则"); 
		return column;
	}
	/**
	 * 获取预约使用时间类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_timeslottpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_timeslottp");
		column.setLength(20);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("预约使用时间类型"); 
		return column;
	}
	/**
	 * 获取预约优先级表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getLevel_priCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Level_pri");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("预约优先级"); 
		return column;
	}
	/**
	 * 获取号源释放规则表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_release_ruleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_release_rule");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("号源释放规则"); 
		return column;
	}
	/**
	 * 获取时间核查标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_timechkCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_timechk");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("时间核查标志"); 
		return column;
	}
	/**
	 * 获取停止排班标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_stopschCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_stopsch");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("停止排班标志"); 
		return column;
	}
	/**
	 * 获取排班所属部门名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_depCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dep");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("排班所属部门名称"); 
		return column;
	}
	/**
	 * 获取排班服务名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_srvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_srv");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("排班服务名称"); 
		return column;
	}
	/**
	 * 获取排班服务编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_srvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_srv");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("排班服务编码"); 
		return column;
	}
	/**
	 * 获取备用服务名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_optsrvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_optsrv");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备用服务名称"); 
		return column;
	}
	/**
	 * 获取资源编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_resCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_res");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("资源编码"); 
		return column;
	}
	/**
	 * 获取资源名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_resCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_res");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("资源名称"); 
		return column;
	}
	/**
	 * 获取排班分类表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_scca_scplCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_scca_scpl");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("排班分类"); 
		return column;
	}
	/**
	 * 获取票号模式名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_tickmdCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_tickmd");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("票号模式名称"); 
		return column;
	}
	/**
	 * 获取优先开放规则编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_apptruCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_apptru");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("优先开放规则编码"); 
		return column;
	}
	/**
	 * 获取优先开放规则名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_apptruCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_apptru");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("优先开放规则名称"); 
		return column;
	}
	/**
	 * 获取优先开放规则类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_schruleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_schrule");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("优先开放规则类型编码"); 
		return column;
	}
	/**
	 * 获取版本表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getVerCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ver");
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("版本"); 
		return column;
	}
	/**
	 * 获取工作台名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_quebenCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_queben");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("工作台名称"); 
		return column;
	}
	/**
	 * 获取工作台编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_quebenCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_queben");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("工作台编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_ruleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_rule");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_ruleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_rule");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_release_ruleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_release_rule");
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
	private IColumnDesc getName_release_ruleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_release_rule");
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
		iBDDataInfoFldMap.put("id","Id_scpl");
		iBDDataInfoFldMap.put("id_org","Id_org");
		iBDDataInfoFldMap.put("code","Code");
		iBDDataInfoFldMap.put("name","Name");
		iBDDataInfoFldMap.put("id_group","Id_grp");
		iBDDataInfoFldMap.put("pycode","Pycode");
		iBDDataInfoFldMap.put("wbcode","Wbcode");
		iBDDataInfoFldMap.put("mnecode","Instr");
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
