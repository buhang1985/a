
package iih.sc.att.sctaskexecemp.d.desc;

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
 * 考勤执行明细 DO 元数据信息
 */
public class ScTaskExecEmpDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.sc.att.sctaskexecemp.d.ScTaskExecEmpDO";
	public static final String CLASS_DISPALYNAME = "考勤执行明细";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "sc_task_exec_emp";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_taskexecemp";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public ScTaskExecEmpDODesc(){
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
		this.setKeyDesc(getId_taskexecempADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.add(getId_taskexecempADesc(tblDesc));
		this.add(getId_taskexecADesc(tblDesc));
		this.add(getId_groupADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_taskplempADesc(tblDesc));
		this.add(getId_empADesc(tblDesc));
		this.add(getD_taskADesc(tblDesc));
		this.add(getId_dateslotADesc(tblDesc));
		this.add(getId_taskplweekADesc(tblDesc));
		this.add(getEu_tasktp_plADesc(tblDesc));
		this.add(getEu_tasktp_actADesc(tblDesc));
		this.add(getId_taskca_actADesc(tblDesc));
		this.add(getName_taskca_actADesc(tblDesc));
		this.add(getFg_notmatchADesc(tblDesc));
		this.add(getRsn_notmatchADesc(tblDesc));
		this.add(getDesc_notmatchADesc(tblDesc));
		this.add(getFg_finishADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getEu_task_statusADesc(tblDesc));
		this.add(getName_empADesc(tblDesc));
		this.add(getCode_empADesc(tblDesc));
		this.add(getName_dateslotADesc(tblDesc));
		this.add(getTime_beginADesc(tblDesc));
		this.add(getTime_endADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_taskexecempCDesc(tblDesc));
		tblDesc.add(getId_taskexecempCDesc(tblDesc));
		tblDesc.add(getId_taskexecCDesc(tblDesc));
		tblDesc.add(getId_groupCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_taskplempCDesc(tblDesc));
		tblDesc.add(getId_empCDesc(tblDesc));
		tblDesc.add(getD_taskCDesc(tblDesc));
		tblDesc.add(getId_dateslotCDesc(tblDesc));
		tblDesc.add(getId_taskplweekCDesc(tblDesc));
		tblDesc.add(getEu_tasktp_plCDesc(tblDesc));
		tblDesc.add(getEu_tasktp_actCDesc(tblDesc));
		tblDesc.add(getId_taskca_actCDesc(tblDesc));
		tblDesc.add(getName_taskca_actCDesc(tblDesc));
		tblDesc.add(getFg_notmatchCDesc(tblDesc));
		tblDesc.add(getRsn_notmatchCDesc(tblDesc));
		tblDesc.add(getDesc_notmatchCDesc(tblDesc));
		tblDesc.add(getFg_finishCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 考勤执行明细id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_taskexecempADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_taskexecemp",  getId_taskexecempCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("考勤执行明细id");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 执行期间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_taskexecADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_taskexec",  getId_taskexecCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("执行期间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 集团属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_groupADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_group",  getId_groupCDesc(tblDesc), this);
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
	 * 计划明细id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_taskplempADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_taskplemp",  getId_taskplempCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("计划明细id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 员工id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_empADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp",  getId_empCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("员工id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 考勤日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getD_taskADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("D_task",  getD_taskCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("考勤日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 考勤日期分组属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dateslotADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dateslot",  getId_dateslotCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("考勤日期分组");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 计划周id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_taskplweekADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_taskplweek",  getId_taskplweekCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("计划周id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 计划考勤类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_tasktp_plADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_tasktp_pl",  getEu_tasktp_plCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("计划考勤类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 实际考勤类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_tasktp_actADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_tasktp_act",  getEu_tasktp_actCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("实际考勤类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 实际考勤类型分类ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_taskca_actADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_taskca_act",  getId_taskca_actCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("实际考勤类型分类ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 实际考勤类型分类名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_taskca_actADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_taskca_act",  getName_taskca_actCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("实际考勤类型分类名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 考勤不符合标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_notmatchADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_notmatch",  getFg_notmatchCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("考勤不符合标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 考勤不符合原因属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRsn_notmatchADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Rsn_notmatch",  getRsn_notmatchCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("考勤不符合原因");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 考勤不符合描述属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDesc_notmatchADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Desc_notmatch",  getDesc_notmatchCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("考勤不符合描述");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 排班完成标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_finishADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_finish",  getFg_finishCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("排班完成标志");
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
	 * 状态属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_task_statusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_task_status",  getEu_task_statusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("状态");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sc_task_exec a0b8","id_taskexec=id_taskexec","eu_task_status"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_empADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_emp",  getName_empCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b4","id_emp=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 人员编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_empADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_emp",  getCode_empCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("人员编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b4","id_emp=id_psndoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 日期分组名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dateslotADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dateslot",  getName_dateslotCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("日期分组名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dayslot a0b10","id_dateslot=id_dayslot","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 分组开始时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTime_beginADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Time_begin",  getTime_beginCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FTime);
		attrDesc.setLabel("分组开始时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dayslot a0b10","id_dateslot=id_dayslot","time_begin"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 分组结束时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTime_endADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Time_end",  getTime_endCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FTime);
		attrDesc.setLabel("分组结束时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dayslot a0b10","id_dateslot=id_dayslot","time_end"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取考勤执行明细id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_taskexecempCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_taskexecemp");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("考勤执行明细id"); 
		return column;
	}
	/**
	 * 获取执行期间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_taskexecCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_taskexec");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("执行期间"); 
		return column;
	}
	/**
	 * 获取集团表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_groupCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_group");
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
	 * 获取计划明细id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_taskplempCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_taskplemp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("计划明细id"); 
		return column;
	}
	/**
	 * 获取员工id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_empCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("员工id"); 
		return column;
	}
	/**
	 * 获取考勤日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getD_taskCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"D_task");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("考勤日期"); 
		return column;
	}
	/**
	 * 获取考勤日期分组表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dateslotCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dateslot");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("考勤日期分组"); 
		return column;
	}
	/**
	 * 获取计划周id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_taskplweekCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_taskplweek");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("计划周id"); 
		return column;
	}
	/**
	 * 获取计划考勤类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_tasktp_plCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_tasktp_pl");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("计划考勤类型"); 
		return column;
	}
	/**
	 * 获取实际考勤类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_tasktp_actCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_tasktp_act");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("实际考勤类型"); 
		return column;
	}
	/**
	 * 获取实际考勤类型分类ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_taskca_actCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_taskca_act");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("实际考勤类型分类ID"); 
		return column;
	}
	/**
	 * 获取实际考勤类型分类名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_taskca_actCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_taskca_act");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("实际考勤类型分类名称"); 
		return column;
	}
	/**
	 * 获取考勤不符合标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_notmatchCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_notmatch");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("考勤不符合标志"); 
		return column;
	}
	/**
	 * 获取考勤不符合原因表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRsn_notmatchCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Rsn_notmatch");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("考勤不符合原因"); 
		return column;
	}
	/**
	 * 获取考勤不符合描述表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDesc_notmatchCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Desc_notmatch");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("考勤不符合描述"); 
		return column;
	}
	/**
	 * 获取排班完成标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_finishCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_finish");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("排班完成标志"); 
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
	 * 获取状态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_task_statusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_task_status");
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("状态"); 
		return column;
	}
	/**
	 * 获取姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_empCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_emp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("姓名"); 
		return column;
	}
	/**
	 * 获取人员编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_empCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_emp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("人员编码"); 
		return column;
	}
	/**
	 * 获取日期分组名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_dateslotCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dateslot");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("日期分组名称"); 
		return column;
	}
	/**
	 * 获取分组开始时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTime_beginCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Time_begin");
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("分组开始时间"); 
		return column;
	}
	/**
	 * 获取分组结束时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTime_endCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Time_end");
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("分组结束时间"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id","Id_taskexecemp");
		iBDDataInfoFldMap.put("id_org","Id_org");
		iBDDataInfoFldMap.put("id_group","Id_group");
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
	
}
