
package iih.nm.nhr.nmoptplpsn.d.desc;

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
 * 人员实习记录 DO 元数据信息
 */
public class NmOptPsnRecDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.nm.nhr.nmoptplpsn.d.NmOptPsnRecDO";
	public static final String CLASS_DISPALYNAME = "人员实习记录";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "NM_OPT_PSN_REC";
	public static final String TABLE_ALIAS_NAME = "a1";
	public static final String PRIMARYKEY_FIELDNAME="Id_opt_psn_rec";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public NmOptPsnRecDODesc(){
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
		this.setKeyDesc(getId_opt_psn_recADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_opt_pl_psnADesc(tblDesc));
		this.add(getId_opt_psn_recADesc(tblDesc));
		this.add(getId_nurADesc(tblDesc));
		this.add(getId_dep_optADesc(tblDesc));
		this.add(getDt_beginADesc(tblDesc));
		this.add(getDt_endADesc(tblDesc));
		this.add(getId_tch_psnADesc(tblDesc));
		this.add(getGradeADesc(tblDesc));
		this.add(getId_grd_lvlADesc(tblDesc));
		this.add(getSd_grd_lvlADesc(tblDesc));
		this.add(getAct_gradeADesc(tblDesc));
		this.add(getId_act_grd_lvlADesc(tblDesc));
		this.add(getSd_act_grd_lvlADesc(tblDesc));
		this.add(getId_appraADesc(tblDesc));
		this.add(getDt_regADesc(tblDesc));
		this.add(getId_reg_psnADesc(tblDesc));
		this.add(getDesADesc(tblDesc));
		this.add(getId_opt_pl_psnADesc(tblDesc));
		this.add(getSd_appraADesc(tblDesc));
		this.add(getPsn_nameADesc(tblDesc));
		this.add(getJob_noADesc(tblDesc));
		this.add(getId_nur_levelADesc(tblDesc));
		this.add(getTec_nameADesc(tblDesc));
		this.add(getGr_nameADesc(tblDesc));
		this.add(getCgr_nameADesc(tblDesc));
		this.add(getPy_nameADesc(tblDesc));
		this.add(getDj_nameADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_opt_psn_recCDesc(tblDesc));
		tblDesc.add(getId_opt_psn_recCDesc(tblDesc));
		tblDesc.add(getId_nurCDesc(tblDesc));
		tblDesc.add(getId_dep_optCDesc(tblDesc));
		tblDesc.add(getDt_beginCDesc(tblDesc));
		tblDesc.add(getDt_endCDesc(tblDesc));
		tblDesc.add(getId_tch_psnCDesc(tblDesc));
		tblDesc.add(getGradeCDesc(tblDesc));
		tblDesc.add(getId_grd_lvlCDesc(tblDesc));
		tblDesc.add(getSd_grd_lvlCDesc(tblDesc));
		tblDesc.add(getAct_gradeCDesc(tblDesc));
		tblDesc.add(getId_act_grd_lvlCDesc(tblDesc));
		tblDesc.add(getSd_act_grd_lvlCDesc(tblDesc));
		tblDesc.add(getId_appraCDesc(tblDesc));
		tblDesc.add(getDt_regCDesc(tblDesc));
		tblDesc.add(getId_reg_psnCDesc(tblDesc));
		tblDesc.add(getDesCDesc(tblDesc));
		tblDesc.add(getId_opt_pl_psnCDesc(tblDesc));
		tblDesc.add(getSd_appraCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 人员实习记录主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_opt_psn_recADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_opt_psn_rec",  getId_opt_psn_recCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("人员实习记录主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 实习人员主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_nurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_nur",  getId_nurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("实习人员主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 科室轮转计划主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dep_optADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep_opt",  getId_dep_optCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("科室轮转计划主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 开始日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_beginADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_begin",  getDt_beginCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("开始日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 结束日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_endADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_end",  getDt_endCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("结束日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 带教老师属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_tch_psnADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_tch_psn",  getId_tch_psnCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("带教老师");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 理论成绩属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getGradeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Grade",  getGradeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("理论成绩");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 理论成绩等级id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_grd_lvlADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_grd_lvl",  getId_grd_lvlCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("理论成绩等级id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 理论成绩等级编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_grd_lvlADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_grd_lvl",  getSd_grd_lvlCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("理论成绩等级编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 实操成绩属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAct_gradeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Act_grade",  getAct_gradeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("实操成绩");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 实操成绩等级id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_act_grd_lvlADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_act_grd_lvl",  getId_act_grd_lvlCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("实操成绩等级id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 实操成绩等级编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_act_grd_lvlADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_act_grd_lvl",  getSd_act_grd_lvlCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("实操成绩等级编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 评优id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_appraADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_appra",  getId_appraCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("评优id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 登记时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_regADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_reg",  getDt_regCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("登记时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 登记人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_reg_psnADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_reg_psn",  getId_reg_psnCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("登记人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 描述属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Des",  getDesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("描述");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 实习计划参与人员主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_opt_pl_psnADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_opt_pl_psn",  getId_opt_pl_psnCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("实习计划参与人员主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 评优级别属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_appraADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_appra",  getSd_appraCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("评优级别");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 人员姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPsn_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Psn_name",  getPsn_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("人员姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"NM_NUR a1b2","id_nur=id_nur","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 工号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getJob_noADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Job_no",  getJob_noCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("工号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"NM_NUR a1b2","id_nur=id_nur","job_no"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 护士层级id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_nur_levelADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_nur_level",  getId_nur_levelCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("护士层级id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"NM_NUR a1b2","id_nur=id_nur","id_nur_level"});
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 人员姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTec_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Tec_name",  getTec_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("人员姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"NM_NUR a1b4","id_tch_psn=id_nur","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getGr_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Gr_name",  getGr_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b5","id_grd_lvl=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCgr_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Cgr_name",  getCgr_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b6","id_act_grd_lvl=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPy_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Py_name",  getPy_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b7","id_appra=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 人员姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDj_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dj_name",  getDj_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("人员姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"NM_NUR a1b8","id_reg_psn=id_nur","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取人员实习记录主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_opt_psn_recCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_opt_psn_rec");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("人员实习记录主键"); 
		return column;
	}
	/**
	 * 获取实习人员主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_nurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_nur");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("实习人员主键"); 
		return column;
	}
	/**
	 * 获取科室轮转计划主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dep_optCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep_opt");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("科室轮转计划主键"); 
		return column;
	}
	/**
	 * 获取开始日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_beginCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_begin");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("开始日期"); 
		return column;
	}
	/**
	 * 获取结束日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_endCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_end");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("结束日期"); 
		return column;
	}
	/**
	 * 获取带教老师表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_tch_psnCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_tch_psn");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("带教老师"); 
		return column;
	}
	/**
	 * 获取理论成绩表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getGradeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Grade");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("理论成绩"); 
		return column;
	}
	/**
	 * 获取理论成绩等级id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_grd_lvlCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_grd_lvl");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("理论成绩等级id"); 
		return column;
	}
	/**
	 * 获取理论成绩等级编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_grd_lvlCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_grd_lvl");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("理论成绩等级编码"); 
		return column;
	}
	/**
	 * 获取实操成绩表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAct_gradeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Act_grade");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("实操成绩"); 
		return column;
	}
	/**
	 * 获取实操成绩等级id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_act_grd_lvlCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_act_grd_lvl");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("实操成绩等级id"); 
		return column;
	}
	/**
	 * 获取实操成绩等级编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_act_grd_lvlCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_act_grd_lvl");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("实操成绩等级编码"); 
		return column;
	}
	/**
	 * 获取评优id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_appraCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_appra");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("评优id"); 
		return column;
	}
	/**
	 * 获取登记时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_regCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_reg");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("登记时间"); 
		return column;
	}
	/**
	 * 获取登记人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_reg_psnCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_reg_psn");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("登记人"); 
		return column;
	}
	/**
	 * 获取描述表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Des");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("描述"); 
		return column;
	}
	/**
	 * 获取实习计划参与人员主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_opt_pl_psnCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_opt_pl_psn");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("实习计划参与人员主键"); 
		return column;
	}
	/**
	 * 获取评优级别表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_appraCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_appra");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("评优级别"); 
		return column;
	}
	/**
	 * 获取人员姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPsn_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Psn_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("人员姓名"); 
		return column;
	}
	/**
	 * 获取工号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getJob_noCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Job_no");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("工号"); 
		return column;
	}
	/**
	 * 获取护士层级id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_nur_levelCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_nur_level");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("护士层级id"); 
		return column;
	}
	/**
	 * 获取人员姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTec_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Tec_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("人员姓名"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getGr_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Gr_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCgr_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Cgr_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPy_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Py_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取人员姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDj_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dj_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("人员姓名"); 
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
