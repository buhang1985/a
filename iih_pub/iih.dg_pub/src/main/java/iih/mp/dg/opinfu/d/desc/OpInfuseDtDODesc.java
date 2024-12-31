
package iih.mp.dg.opinfu.d.desc;

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
 * 门诊输液执行明细 DO 元数据信息
 */
public class OpInfuseDtDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.mp.dg.opinfu.d.OpInfuseDtDO";
	public static final String CLASS_DISPALYNAME = "门诊输液执行明细";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "mp_dg_oep_infu_dt";
	public static final String TABLE_ALIAS_NAME = "${EntityMeta.entityClassMeta.aliasName}";
	public static final String PRIMARYKEY_FIELDNAME="Id_dgoepinfudt";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public OpInfuseDtDODesc(){
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
		this.setKeyDesc(getId_dgoepinfudtADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.setFKeyDesc(getId_dgoepinfuADesc(tblDesc));
		this.add(getId_dgoepinfudtADesc(tblDesc));
		this.add(getId_dgoepinfuADesc(tblDesc));
		this.add(getCode_barADesc(tblDesc));
		this.add(getExec_curADesc(tblDesc));
		this.add(getPers_dayADesc(tblDesc));
		this.add(getDt_execADesc(tblDesc));
		this.add(getDt_exec_timeADesc(tblDesc));
		this.add(getId_emp_execADesc(tblDesc));
		this.add(getEu_su_execADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_dgoepinfudtCDesc(tblDesc));
		tblDesc.add(getId_dgoepinfudtCDesc(tblDesc));
		tblDesc.add(getId_dgoepinfuCDesc(tblDesc));
		tblDesc.add(getCode_barCDesc(tblDesc));
		tblDesc.add(getExec_curCDesc(tblDesc));
		tblDesc.add(getPers_dayCDesc(tblDesc));
		tblDesc.add(getDt_execCDesc(tblDesc));
		tblDesc.add(getDt_exec_timeCDesc(tblDesc));
		tblDesc.add(getId_emp_execCDesc(tblDesc));
		tblDesc.add(getEu_su_execCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 输液执行明细主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dgoepinfudtADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dgoepinfudt",  getId_dgoepinfudtCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("输液执行明细主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 输液执行主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dgoepinfuADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dgoepinfu",  getId_dgoepinfuCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("输液执行主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 条码号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_barADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_bar",  getCode_barCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("条码号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 执行次数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getExec_curADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Exec_cur",  getExec_curCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("执行次数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 本次所属天数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPers_dayADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pers_day",  getPers_dayCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("本次所属天数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 执行日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_execADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_exec",  getDt_execCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("执行日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 执行时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_exec_timeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_exec_time",  getDt_exec_timeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FTime);
		attrDesc.setLabel("执行时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 执行人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_execADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_exec",  getId_emp_execCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("执行人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 执行状态属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_su_execADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_su_exec",  getEu_su_execCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("执行状态");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取输液执行明细主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dgoepinfudtCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dgoepinfudt");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("输液执行明细主键"); 
		return column;
	}
	/**
	 * 获取输液执行主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dgoepinfuCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dgoepinfu");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("输液执行主键"); 
		return column;
	}
	/**
	 * 获取条码号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_barCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_bar");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("条码号"); 
		return column;
	}
	/**
	 * 获取执行次数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getExec_curCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Exec_cur");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("执行次数"); 
		return column;
	}
	/**
	 * 获取本次所属天数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPers_dayCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pers_day");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("本次所属天数"); 
		return column;
	}
	/**
	 * 获取执行日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_execCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_exec");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("执行日期"); 
		return column;
	}
	/**
	 * 获取执行时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_exec_timeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_exec_time");
		column.setLength(8);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("执行时间"); 
		return column;
	}
	/**
	 * 获取执行人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_execCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_exec");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("执行人"); 
		return column;
	}
	/**
	 * 获取执行状态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_su_execCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_su_exec");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("执行状态"); 
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
	
}
