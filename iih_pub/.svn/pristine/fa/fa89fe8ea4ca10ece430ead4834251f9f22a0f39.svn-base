
package iih.ci.ord.cior.d.desc;

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
 * 二次手术申请单 DO 元数据信息
 */
public class OrdApOpAgainDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.ci.ord.cior.d.OrdApOpAgainDO";
	public static final String CLASS_DISPALYNAME = "二次手术申请单";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "ci_ap_sug_again ";
	public static final String TABLE_ALIAS_NAME = "a4";
	public static final String PRIMARYKEY_FIELDNAME="Id_ap_sug_again";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public OrdApOpAgainDODesc(){
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
		this.setKeyDesc(getId_ap_sug_againADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_apopADesc(tblDesc));
		this.add(getId_ap_sug_againADesc(tblDesc));
		this.add(getId_patADesc(tblDesc));
		this.add(getId_apopADesc(tblDesc));
		this.add(getDt_applyADesc(tblDesc));
		this.add(getDt_first_opADesc(tblDesc));
		this.add(getDt_again_opADesc(tblDesc));
		this.add(getFg_urgentADesc(tblDesc));
		this.add(getFg_same_depADesc(tblDesc));
		this.add(getId_emp_sugsADesc(tblDesc));
		this.add(getName_emp_sugsADesc(tblDesc));
		this.add(getFirst_op_id_srvADesc(tblDesc));
		this.add(getFirst_op_nameADesc(tblDesc));
		this.add(getAgain_op_id_srvADesc(tblDesc));
		this.add(getAgain_op_nameADesc(tblDesc));
		this.add(getId_emp_comperesADesc(tblDesc));
		this.add(getId_emp_joinsADesc(tblDesc));
		this.add(getName_emp_comperesADesc(tblDesc));
		this.add(getName_emp_joinsADesc(tblDesc));
		this.add(getPlaceADesc(tblDesc));
		this.add(getContentADesc(tblDesc));
		this.add(getDep_opinionADesc(tblDesc));
		this.add(getAdm_opinionADesc(tblDesc));
		this.add(getSd_reltpADesc(tblDesc));
		this.add(getFg_submitADesc(tblDesc));
		this.add(getName_patADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_ap_sug_againCDesc(tblDesc));
		tblDesc.add(getId_ap_sug_againCDesc(tblDesc));
		tblDesc.add(getId_patCDesc(tblDesc));
		tblDesc.add(getId_apopCDesc(tblDesc));
		tblDesc.add(getDt_applyCDesc(tblDesc));
		tblDesc.add(getDt_first_opCDesc(tblDesc));
		tblDesc.add(getDt_again_opCDesc(tblDesc));
		tblDesc.add(getFg_urgentCDesc(tblDesc));
		tblDesc.add(getFg_same_depCDesc(tblDesc));
		tblDesc.add(getId_emp_sugsCDesc(tblDesc));
		tblDesc.add(getName_emp_sugsCDesc(tblDesc));
		tblDesc.add(getFirst_op_id_srvCDesc(tblDesc));
		tblDesc.add(getFirst_op_nameCDesc(tblDesc));
		tblDesc.add(getAgain_op_id_srvCDesc(tblDesc));
		tblDesc.add(getAgain_op_nameCDesc(tblDesc));
		tblDesc.add(getId_emp_comperesCDesc(tblDesc));
		tblDesc.add(getId_emp_joinsCDesc(tblDesc));
		tblDesc.add(getName_emp_comperesCDesc(tblDesc));
		tblDesc.add(getName_emp_joinsCDesc(tblDesc));
		tblDesc.add(getPlaceCDesc(tblDesc));
		tblDesc.add(getContentCDesc(tblDesc));
		tblDesc.add(getDep_opinionCDesc(tblDesc));
		tblDesc.add(getAdm_opinionCDesc(tblDesc));
		tblDesc.add(getSd_reltpCDesc(tblDesc));
		tblDesc.add(getFg_submitCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ap_sug_againADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ap_sug_again",  getId_ap_sug_againCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_patADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pat",  getId_patCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 手术申请单主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_apopADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_apop",  getId_apopCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术申请单主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 二次手术申请时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_applyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_apply",  getDt_applyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("二次手术申请时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 首次手术时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_first_opADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_first_op",  getDt_first_opCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("首次手术时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 拟再次手术时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_again_opADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_again_op",  getDt_again_opCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("拟再次手术时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否为急诊手术属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_urgentADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_urgent",  getFg_urgentCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否为急诊手术");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否为同一科室手术属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_same_depADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_same_dep",  getFg_same_depCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否为同一科室手术");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 再次手术参加人员属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_sugsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_sugs",  getId_emp_sugsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("再次手术参加人员");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 再次手术参加人员名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_emp_sugsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_emp_sugs",  getName_emp_sugsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("再次手术参加人员名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 首次手术主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFirst_op_id_srvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("First_op_id_srv",  getFirst_op_id_srvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("首次手术主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 首次手术名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFirst_op_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("First_op_name",  getFirst_op_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("首次手术名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 拟再次手术主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAgain_op_id_srvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Again_op_id_srv",  getAgain_op_id_srvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("拟再次手术主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 拟再次手术名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAgain_op_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Again_op_name",  getAgain_op_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("拟再次手术名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 主持人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_comperesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_comperes",  getId_emp_comperesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("主持人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 参加者属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_joinsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_joins",  getId_emp_joinsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("参加者");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 主持人姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_emp_comperesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_emp_comperes",  getName_emp_comperesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("主持人姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 参加者姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_emp_joinsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_emp_joins",  getName_emp_joinsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("参加者姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 地点属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPlaceADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Place",  getPlaceCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("地点");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 讨论内容属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getContentADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Content",  getContentCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("讨论内容");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 科室主任意见属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDep_opinionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dep_opinion",  getDep_opinionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("科室主任意见");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医务部意见属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAdm_opinionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Adm_opinion",  getAdm_opinionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医务部意见");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 审批结果属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_reltpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_reltp",  getSd_reltpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("审批结果");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 提交状态属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_submitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_submit",  getFg_submitCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("提交状态");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_patADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_pat",  getName_patCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pi_pat undefinedb2","id_pat=id_pat","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ap_sug_againCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ap_sug_again");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("主键"); 
		return column;
	}
	/**
	 * 获取患者id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pat");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者id"); 
		return column;
	}
	/**
	 * 获取手术申请单主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_apopCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_apop");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术申请单主键"); 
		return column;
	}
	/**
	 * 获取二次手术申请时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_applyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_apply");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("二次手术申请时间"); 
		return column;
	}
	/**
	 * 获取首次手术时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_first_opCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_first_op");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("首次手术时间"); 
		return column;
	}
	/**
	 * 获取拟再次手术时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_again_opCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_again_op");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("拟再次手术时间"); 
		return column;
	}
	/**
	 * 获取是否为急诊手术表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_urgentCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_urgent");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否为急诊手术"); 
		return column;
	}
	/**
	 * 获取是否为同一科室手术表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_same_depCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_same_dep");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否为同一科室手术"); 
		return column;
	}
	/**
	 * 获取再次手术参加人员表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_sugsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_sugs");
		column.setLength(2000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("再次手术参加人员"); 
		return column;
	}
	/**
	 * 获取再次手术参加人员名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_emp_sugsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_emp_sugs");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("再次手术参加人员名称"); 
		return column;
	}
	/**
	 * 获取首次手术主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFirst_op_id_srvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"First_op_id_srv");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("首次手术主键"); 
		return column;
	}
	/**
	 * 获取首次手术名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFirst_op_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"First_op_name");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("首次手术名称"); 
		return column;
	}
	/**
	 * 获取拟再次手术主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAgain_op_id_srvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Again_op_id_srv");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("拟再次手术主键"); 
		return column;
	}
	/**
	 * 获取拟再次手术名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAgain_op_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Again_op_name");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("拟再次手术名称"); 
		return column;
	}
	/**
	 * 获取主持人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_comperesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_comperes");
		column.setLength(2000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("主持人"); 
		return column;
	}
	/**
	 * 获取参加者表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_joinsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_joins");
		column.setLength(2000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("参加者"); 
		return column;
	}
	/**
	 * 获取主持人姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_emp_comperesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_emp_comperes");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("主持人姓名"); 
		return column;
	}
	/**
	 * 获取参加者姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_emp_joinsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_emp_joins");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("参加者姓名"); 
		return column;
	}
	/**
	 * 获取地点表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPlaceCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Place");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("地点"); 
		return column;
	}
	/**
	 * 获取讨论内容表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getContentCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Content");
		column.setLength(2000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("讨论内容"); 
		return column;
	}
	/**
	 * 获取科室主任意见表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDep_opinionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dep_opinion");
		column.setLength(2000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("科室主任意见"); 
		return column;
	}
	/**
	 * 获取医务部意见表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAdm_opinionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Adm_opinion");
		column.setLength(2000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医务部意见"); 
		return column;
	}
	/**
	 * 获取审批结果表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_reltpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_reltp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("审批结果"); 
		return column;
	}
	/**
	 * 获取提交状态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_submitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_submit");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("提交状态"); 
		return column;
	}
	/**
	 * 获取患者姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_pat");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者姓名"); 
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
