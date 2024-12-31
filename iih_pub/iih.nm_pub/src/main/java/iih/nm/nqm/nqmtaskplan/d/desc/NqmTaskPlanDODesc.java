
package iih.nm.nqm.nqmtaskplan.d.desc;

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
 * 质控任务执行计划 DO 元数据信息
 */
public class NqmTaskPlanDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.nm.nqm.nqmtaskplan.d.NqmTaskPlanDO";
	public static final String CLASS_DISPALYNAME = "质控任务执行计划";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "NM_NQM_TASK_PLAN";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_nqm_task_pl";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public NqmTaskPlanDODesc(){
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
		this.setKeyDesc(getId_nqm_task_plADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_nqm_task_plADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_nqm_qcgrpADesc(tblDesc));
		this.add(getId_nqm_taskADesc(tblDesc));
		this.add(getId_nqm_task_detADesc(tblDesc));
		this.add(getId_nqm_csADesc(tblDesc));
		this.add(getId_nqm_tmplADesc(tblDesc));
		this.add(getCount_chkADesc(tblDesc));
		this.add(getId_depADesc(tblDesc));
		this.add(getId_dep_nurADesc(tblDesc));
		this.add(getDt_planADesc(tblDesc));
		this.add(getId_plan_exec_psnADesc(tblDesc));
		this.add(getTaskplanstatusADesc(tblDesc));
		this.add(getDt_execADesc(tblDesc));
		this.add(getId_exec_psnADesc(tblDesc));
		this.add(getDesADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getName_nqm_qcgrpADesc(tblDesc));
		this.add(getName_task_detADesc(tblDesc));
		this.add(getSd_qc_lvlADesc(tblDesc));
		this.add(getId_qc_lvlADesc(tblDesc));
		this.add(getName_nqm_csADesc(tblDesc));
		this.add(getFpy_nqm_csADesc(tblDesc));
		this.add(getScore_totalADesc(tblDesc));
		this.add(getCode_nqm_csADesc(tblDesc));
		this.add(getName_nqm_tmplADesc(tblDesc));
		this.add(getScore_total_templADesc(tblDesc));
		this.add(getName_depADesc(tblDesc));
		this.add(getCode_depADesc(tblDesc));
		this.add(getName_dep_nurADesc(tblDesc));
		this.add(getCode_dep_nurADesc(tblDesc));
		this.add(getName_plan_exec_psnADesc(tblDesc));
		this.add(getName_exec_psnADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_nqm_task_plCDesc(tblDesc));
		tblDesc.add(getId_nqm_task_plCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_nqm_qcgrpCDesc(tblDesc));
		tblDesc.add(getId_nqm_taskCDesc(tblDesc));
		tblDesc.add(getId_nqm_task_detCDesc(tblDesc));
		tblDesc.add(getId_nqm_csCDesc(tblDesc));
		tblDesc.add(getId_nqm_tmplCDesc(tblDesc));
		tblDesc.add(getCount_chkCDesc(tblDesc));
		tblDesc.add(getId_depCDesc(tblDesc));
		tblDesc.add(getId_dep_nurCDesc(tblDesc));
		tblDesc.add(getDt_planCDesc(tblDesc));
		tblDesc.add(getId_plan_exec_psnCDesc(tblDesc));
		tblDesc.add(getTaskplanstatusCDesc(tblDesc));
		tblDesc.add(getDt_execCDesc(tblDesc));
		tblDesc.add(getId_exec_psnCDesc(tblDesc));
		tblDesc.add(getDesCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 任务执行计划属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_nqm_task_plADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_nqm_task_pl",  getId_nqm_task_plCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("任务执行计划");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 组织属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_orgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_org",  getId_orgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("组织");
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
	 * 质控组属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_nqm_qcgrpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_nqm_qcgrp",  getId_nqm_qcgrpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("质控组");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 任务外键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_nqm_taskADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_nqm_task",  getId_nqm_taskCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("任务外键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 质控任务明细属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_nqm_task_detADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_nqm_task_det",  getId_nqm_task_detCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("质控任务明细");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 质量标准属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_nqm_csADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_nqm_cs",  getId_nqm_csCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("质量标准");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 质量标准模板属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_nqm_tmplADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_nqm_tmpl",  getId_nqm_tmplCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("质量标准模板");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 检查份数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCount_chkADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Count_chk",  getCount_chkCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("检查份数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 受检科室id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_depADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep",  getId_depCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("受检科室id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 受检护理单元属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dep_nurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep_nur",  getId_dep_nurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("受检护理单元");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 计划检查日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_planADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_plan",  getDt_planCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("计划检查日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 计划检查者属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_plan_exec_psnADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_plan_exec_psn",  getId_plan_exec_psnCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("计划检查者");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 任务状态属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTaskplanstatusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Taskplanstatus",  getTaskplanstatusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("任务状态");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 检查时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_execADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_exec",  getDt_execCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("检查时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 检查者属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_exec_psnADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_exec_psn",  getId_exec_psnCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("检查者");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 备注属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Des",  getDesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备注");
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
	 * 小组名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_nqm_qcgrpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_nqm_qcgrp",  getName_nqm_qcgrpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("小组名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"NM_NQM_QCGRP a0b2","id_nqm_qcgrp=id_nqm_qcgrp","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 任务明细名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_task_detADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_task_det",  getName_task_detCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("任务明细名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"NM_NQM_TASK_DET a0b11","id_nqm_task_det=id_nqm_task_det","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 质控级别编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_qc_lvlADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_qc_lvl",  getSd_qc_lvlCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("质控级别编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"NM_NQM_TASK_DET a0b11","id_nqm_task_det=id_nqm_task_det","sd_qc_lvl"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 质控级别属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_qc_lvlADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_qc_lvl",  getId_qc_lvlCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("质控级别");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"NM_NQM_TASK_DET a0b11","id_nqm_task_det=id_nqm_task_det","id_qc_lvl"});
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 质控标准属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_nqm_csADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_nqm_cs",  getName_nqm_csCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("质控标准");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"NM_NQM_CS a0b4","id_nqm_cs=id_nqm_cs","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 合格比率属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFpy_nqm_csADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fpy_nqm_cs",  getFpy_nqm_csCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("合格比率");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"NM_NQM_CS a0b4","id_nqm_cs=id_nqm_cs","fpy"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 标准总分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getScore_totalADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Score_total",  getScore_totalCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("标准总分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"NM_NQM_CS a0b4","id_nqm_cs=id_nqm_cs","score"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_nqm_csADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_nqm_cs",  getCode_nqm_csCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"NM_NQM_CS a0b4","id_nqm_cs=id_nqm_cs","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 质控标准模板属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_nqm_tmplADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_nqm_tmpl",  getName_nqm_tmplCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("质控标准模板");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"NM_NQM_CSTMPL a0b5","id_nqm_tmpl=id_nqm_tmpl","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 模板总分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getScore_total_templADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Score_total_templ",  getScore_total_templCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("模板总分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"NM_NQM_CSTMPL a0b5","id_nqm_tmpl=id_nqm_tmpl","score_total"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_depADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dep",  getName_depCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b14","id_dep=id_dep","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_depADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_dep",  getCode_depCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b14","id_dep=id_dep","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 护理单元名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dep_nurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dep_nur",  getName_dep_nurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("护理单元名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"NM_NBD_DEP a0b6","id_dep_nur=id_nbd_dep","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 护理单元编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_dep_nurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_dep_nur",  getCode_dep_nurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("护理单元编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"NM_NBD_DEP a0b6","id_dep_nur=id_nbd_dep","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 计划检查者属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_plan_exec_psnADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_plan_exec_psn",  getName_plan_exec_psnCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("计划检查者");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"NM_NUR a0b10","id_plan_exec_psn=id_nur","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 检查者属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_exec_psnADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_exec_psn",  getName_exec_psnCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("检查者");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"NM_NUR a0b7","id_exec_psn=id_nur","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取任务执行计划表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_nqm_task_plCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_nqm_task_pl");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("任务执行计划"); 
		return column;
	}
	/**
	 * 获取组织表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_orgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_org");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("组织"); 
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
	 * 获取质控组表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_nqm_qcgrpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_nqm_qcgrp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("质控组"); 
		return column;
	}
	/**
	 * 获取任务外键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_nqm_taskCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_nqm_task");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("任务外键"); 
		return column;
	}
	/**
	 * 获取质控任务明细表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_nqm_task_detCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_nqm_task_det");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("质控任务明细"); 
		return column;
	}
	/**
	 * 获取质量标准表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_nqm_csCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_nqm_cs");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("质量标准"); 
		return column;
	}
	/**
	 * 获取质量标准模板表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_nqm_tmplCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_nqm_tmpl");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("质量标准模板"); 
		return column;
	}
	/**
	 * 获取检查份数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCount_chkCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Count_chk");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("检查份数"); 
		return column;
	}
	/**
	 * 获取受检科室id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_depCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("受检科室id"); 
		return column;
	}
	/**
	 * 获取受检护理单元表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dep_nurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep_nur");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("受检护理单元"); 
		return column;
	}
	/**
	 * 获取计划检查日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_planCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_plan");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("计划检查日期"); 
		return column;
	}
	/**
	 * 获取计划检查者表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_plan_exec_psnCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_plan_exec_psn");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("计划检查者"); 
		return column;
	}
	/**
	 * 获取任务状态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTaskplanstatusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Taskplanstatus");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("任务状态"); 
		return column;
	}
	/**
	 * 获取检查时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_execCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_exec");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("检查时间"); 
		return column;
	}
	/**
	 * 获取检查者表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_exec_psnCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_exec_psn");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("检查者"); 
		return column;
	}
	/**
	 * 获取备注表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Des");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备注"); 
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
	 * 获取小组名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_nqm_qcgrpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_nqm_qcgrp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("小组名称"); 
		return column;
	}
	/**
	 * 获取任务明细名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_task_detCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_task_det");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("任务明细名称"); 
		return column;
	}
	/**
	 * 获取质控级别编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_qc_lvlCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_qc_lvl");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("质控级别编码"); 
		return column;
	}
	/**
	 * 获取质控级别表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_qc_lvlCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_qc_lvl");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("质控级别"); 
		return column;
	}
	/**
	 * 获取质控标准表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_nqm_csCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_nqm_cs");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("质控标准"); 
		return column;
	}
	/**
	 * 获取合格比率表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFpy_nqm_csCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fpy_nqm_cs");
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("合格比率"); 
		return column;
	}
	/**
	 * 获取标准总分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getScore_totalCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Score_total");
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("标准总分"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_nqm_csCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_nqm_cs");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取质控标准模板表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_nqm_tmplCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_nqm_tmpl");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("质控标准模板"); 
		return column;
	}
	/**
	 * 获取模板总分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getScore_total_templCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Score_total_templ");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("模板总分"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_depCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dep");
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
	private IColumnDesc getCode_depCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_dep");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取护理单元名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_dep_nurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dep_nur");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("护理单元名称"); 
		return column;
	}
	/**
	 * 获取护理单元编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_dep_nurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_dep_nur");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("护理单元编码"); 
		return column;
	}
	/**
	 * 获取计划检查者表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_plan_exec_psnCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_plan_exec_psn");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("计划检查者"); 
		return column;
	}
	/**
	 * 获取检查者表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_exec_psnCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_exec_psn");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("检查者"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id_org","Id_org");
		iBDDataInfoFldMap.put("id_group","Id_grp");
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
