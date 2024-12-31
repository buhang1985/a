
package iih.hr.hsc.hscschedweek.d.desc;

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
 * 排班表 DO 元数据信息
 */
public class HscSchedDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.hr.hsc.hscschedweek.d.HscSchedDO";
	public static final String CLASS_DISPALYNAME = "排班表";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "HR_HSC_SCHED";
	public static final String TABLE_ALIAS_NAME = "a1";
	public static final String PRIMARYKEY_FIELDNAME="Id_hsc_sched";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public HscSchedDODesc(){
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
		this.setKeyDesc(getId_hsc_schedADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_hsc_sched_weekADesc(tblDesc));
		this.add(getId_hsc_schedADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_hsc_sched_weekADesc(tblDesc));
		this.add(getId_depADesc(tblDesc));
		this.add(getDt_sched_dateADesc(tblDesc));
		this.add(getId_psndocADesc(tblDesc));
		this.add(getDt_sched_timeADesc(tblDesc));
		this.add(getId_hsc_sched_lvADesc(tblDesc));
		this.add(getId_reg_psnADesc(tblDesc));
		this.add(getDt_regADesc(tblDesc));
		this.add(getId_hsc_siADesc(tblDesc));
		this.add(getName_hsc_siADesc(tblDesc));
		this.add(getDt_beonADesc(tblDesc));
		this.add(getDt_offADesc(tblDesc));
		this.add(getId_chk_caADesc(tblDesc));
		this.add(getSd_chk_caADesc(tblDesc));
		this.add(getDur_chk_caADesc(tblDesc));
		this.add(getId_sicaADesc(tblDesc));
		this.add(getSd_sicaADesc(tblDesc));
		this.add(getId_siproADesc(tblDesc));
		this.add(getSd_siproADesc(tblDesc));
		this.add(getSortno_dayADesc(tblDesc));
		this.add(getDesADesc(tblDesc));
		this.add(getId_chk_statusADesc(tblDesc));
		this.add(getSd_chk_statusADesc(tblDesc));
		this.add(getFg_overtimeADesc(tblDesc));
		this.add(getDur_chk_ca_addADesc(tblDesc));
		this.add(getId_chk_ca_addADesc(tblDesc));
		this.add(getSd_chk_ca_addADesc(tblDesc));
		this.add(getDt_beon2ADesc(tblDesc));
		this.add(getDt_off2ADesc(tblDesc));
		this.add(getCtrl1ADesc(tblDesc));
		this.add(getCtrl2ADesc(tblDesc));
		this.add(getCtrl3ADesc(tblDesc));
		this.add(getCtrl4ADesc(tblDesc));
		this.add(getCtrl5ADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getName_dep_nurADesc(tblDesc));
		this.add(getName_psndocADesc(tblDesc));
		this.add(getName_reg_psnADesc(tblDesc));
		this.add(getName_hscsiADesc(tblDesc));
		this.add(getName_chk_caADesc(tblDesc));
		this.add(getName_sicaADesc(tblDesc));
		this.add(getName_siproADesc(tblDesc));
		this.add(getName_chk_statusADesc(tblDesc));
		this.add(getName_chk_ca_addADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_hsc_schedCDesc(tblDesc));
		tblDesc.add(getId_hsc_schedCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_hsc_sched_weekCDesc(tblDesc));
		tblDesc.add(getId_depCDesc(tblDesc));
		tblDesc.add(getDt_sched_dateCDesc(tblDesc));
		tblDesc.add(getId_psndocCDesc(tblDesc));
		tblDesc.add(getDt_sched_timeCDesc(tblDesc));
		tblDesc.add(getId_hsc_sched_lvCDesc(tblDesc));
		tblDesc.add(getId_reg_psnCDesc(tblDesc));
		tblDesc.add(getDt_regCDesc(tblDesc));
		tblDesc.add(getId_hsc_siCDesc(tblDesc));
		tblDesc.add(getName_hsc_siCDesc(tblDesc));
		tblDesc.add(getDt_beonCDesc(tblDesc));
		tblDesc.add(getDt_offCDesc(tblDesc));
		tblDesc.add(getId_chk_caCDesc(tblDesc));
		tblDesc.add(getSd_chk_caCDesc(tblDesc));
		tblDesc.add(getDur_chk_caCDesc(tblDesc));
		tblDesc.add(getId_sicaCDesc(tblDesc));
		tblDesc.add(getSd_sicaCDesc(tblDesc));
		tblDesc.add(getId_siproCDesc(tblDesc));
		tblDesc.add(getSd_siproCDesc(tblDesc));
		tblDesc.add(getSortno_dayCDesc(tblDesc));
		tblDesc.add(getDesCDesc(tblDesc));
		tblDesc.add(getId_chk_statusCDesc(tblDesc));
		tblDesc.add(getSd_chk_statusCDesc(tblDesc));
		tblDesc.add(getFg_overtimeCDesc(tblDesc));
		tblDesc.add(getDur_chk_ca_addCDesc(tblDesc));
		tblDesc.add(getId_chk_ca_addCDesc(tblDesc));
		tblDesc.add(getSd_chk_ca_addCDesc(tblDesc));
		tblDesc.add(getDt_beon2CDesc(tblDesc));
		tblDesc.add(getDt_off2CDesc(tblDesc));
		tblDesc.add(getCtrl1CDesc(tblDesc));
		tblDesc.add(getCtrl2CDesc(tblDesc));
		tblDesc.add(getCtrl3CDesc(tblDesc));
		tblDesc.add(getCtrl4CDesc(tblDesc));
		tblDesc.add(getCtrl5CDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 人员排班表主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_hsc_schedADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_hsc_sched",  getId_hsc_schedCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("人员排班表主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 所属组织属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_orgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_org",  getId_orgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("所属组织");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 所属集团属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_grpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_grp",  getId_grpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("所属集团");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 周排班外键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_hsc_sched_weekADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_hsc_sched_week",  getId_hsc_sched_weekCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("周排班外键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 科室属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_depADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep",  getId_depCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("科室");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 排班日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_sched_dateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_sched_date",  getDt_sched_dateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("排班日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 人员属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_psndocADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_psndoc",  getId_psndocCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("人员");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 排班时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_sched_timeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_sched_time",  getDt_sched_timeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("排班时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 人员请假记录属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_hsc_sched_lvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_hsc_sched_lv",  getId_hsc_sched_lvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("人员请假记录");
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
	 * 班次外键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_hsc_siADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_hsc_si",  getId_hsc_siCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("班次外键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 排班班次属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_hsc_siADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_hsc_si",  getName_hsc_siCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("排班班次");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 实际上班时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_beonADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_beon",  getDt_beonCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("实际上班时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 实际下班时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_offADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_off",  getDt_offCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("实际下班时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 实际考勤分类id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_chk_caADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_chk_ca",  getId_chk_caCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("实际考勤分类id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 实际考勤分类属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_chk_caADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_chk_ca",  getSd_chk_caCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("实际考勤分类");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 实际考勤时长属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDur_chk_caADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dur_chk_ca",  getDur_chk_caCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("实际考勤时长");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 实际班次分类id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_sicaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_sica",  getId_sicaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("实际班次分类id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 实际班次分类属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_sicaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_sica",  getSd_sicaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("实际班次分类");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 实际班次性质id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_siproADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_sipro",  getId_siproCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("实际班次性质id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 实际班次性质属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_siproADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_sipro",  getSd_siproCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("实际班次性质");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 班次序号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSortno_dayADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sortno_day",  getSortno_dayCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("班次序号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
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
	 * 考勤状态编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_chk_statusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_chk_status",  getId_chk_statusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("考勤状态编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 考勤状态属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_chk_statusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_chk_status",  getSd_chk_statusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("考勤状态");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 加班标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_overtimeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_overtime",  getFg_overtimeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("加班标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 附加考勤时长属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDur_chk_ca_addADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dur_chk_ca_add",  getDur_chk_ca_addCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("附加考勤时长");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 附加考勤分类id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_chk_ca_addADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_chk_ca_add",  getId_chk_ca_addCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("附加考勤分类id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 附加考勤分类属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_chk_ca_addADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_chk_ca_add",  getSd_chk_ca_addCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("附加考勤分类");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 实际上班时间2属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_beon2ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_beon2",  getDt_beon2CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("实际上班时间2");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 实际下班时间2属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_off2ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_off2",  getDt_off2CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("实际下班时间2");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 扩展字段1属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCtrl1ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ctrl1",  getCtrl1CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("扩展字段1");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 扩展字段2属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCtrl2ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ctrl2",  getCtrl2CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("扩展字段2");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 扩展字段3属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCtrl3ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ctrl3",  getCtrl3CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("扩展字段3");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 扩展字段4属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCtrl4ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ctrl4",  getCtrl4CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("扩展字段4");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 扩展字段5属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCtrl5ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ctrl5",  getCtrl5CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("扩展字段5");
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
	 * 护理单元属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dep_nurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dep_nur",  getName_dep_nurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("护理单元");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a1b3","id_dep=id_dep","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_psndocADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_psndoc",  getName_psndocCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a1b4","id_psndoc=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_reg_psnADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_reg_psn",  getName_reg_psnCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a1b5","id_reg_psn=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 班次信息属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_hscsiADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_hscsi",  getName_hscsiCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("班次信息");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"HR_HSC_SI a1b6","id_hsc_si=id_hsc_si","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 实际考勤分类属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_chk_caADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_chk_ca",  getName_chk_caCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("实际考勤分类");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b7","id_chk_ca=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 班次分类属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_sicaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_sica",  getName_sicaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("班次分类");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b8","id_sica=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 班次性质属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_siproADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_sipro",  getName_siproCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("班次性质");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b9","id_sipro=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 考勤状态属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_chk_statusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_chk_status",  getName_chk_statusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("考勤状态");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b10","id_chk_status=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 附加考勤分类属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_chk_ca_addADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_chk_ca_add",  getName_chk_ca_addCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("附加考勤分类");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b11","id_chk_ca_add=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取人员排班表主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_hsc_schedCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_hsc_sched");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("人员排班表主键"); 
		return column;
	}
	/**
	 * 获取所属组织表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_orgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_org");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("所属组织"); 
		return column;
	}
	/**
	 * 获取所属集团表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_grpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_grp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("所属集团"); 
		return column;
	}
	/**
	 * 获取周排班外键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_hsc_sched_weekCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_hsc_sched_week");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("周排班外键"); 
		return column;
	}
	/**
	 * 获取科室表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_depCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("科室"); 
		return column;
	}
	/**
	 * 获取排班日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_sched_dateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_sched_date");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("排班日期"); 
		return column;
	}
	/**
	 * 获取人员表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_psndocCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_psndoc");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("人员"); 
		return column;
	}
	/**
	 * 获取排班时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_sched_timeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_sched_time");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("排班时间"); 
		return column;
	}
	/**
	 * 获取人员请假记录表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_hsc_sched_lvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_hsc_sched_lv");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("人员请假记录"); 
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
	 * 获取班次外键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_hsc_siCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_hsc_si");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("班次外键"); 
		return column;
	}
	/**
	 * 获取排班班次表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_hsc_siCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_hsc_si");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("排班班次"); 
		return column;
	}
	/**
	 * 获取实际上班时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_beonCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_beon");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("实际上班时间"); 
		return column;
	}
	/**
	 * 获取实际下班时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_offCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_off");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("实际下班时间"); 
		return column;
	}
	/**
	 * 获取实际考勤分类id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_chk_caCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_chk_ca");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("实际考勤分类id"); 
		return column;
	}
	/**
	 * 获取实际考勤分类表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_chk_caCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_chk_ca");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("实际考勤分类"); 
		return column;
	}
	/**
	 * 获取实际考勤时长表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDur_chk_caCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dur_chk_ca");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("实际考勤时长"); 
		return column;
	}
	/**
	 * 获取实际班次分类id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_sicaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_sica");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("实际班次分类id"); 
		return column;
	}
	/**
	 * 获取实际班次分类表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_sicaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_sica");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("实际班次分类"); 
		return column;
	}
	/**
	 * 获取实际班次性质id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_siproCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_sipro");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("实际班次性质id"); 
		return column;
	}
	/**
	 * 获取实际班次性质表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_siproCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_sipro");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("实际班次性质"); 
		return column;
	}
	/**
	 * 获取班次序号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSortno_dayCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sortno_day");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("班次序号"); 
		return column;
	}
	/**
	 * 获取备注表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Des");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备注"); 
		return column;
	}
	/**
	 * 获取考勤状态编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_chk_statusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_chk_status");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("考勤状态编码"); 
		return column;
	}
	/**
	 * 获取考勤状态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_chk_statusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_chk_status");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("考勤状态"); 
		return column;
	}
	/**
	 * 获取加班标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_overtimeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_overtime");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("加班标志"); 
		return column;
	}
	/**
	 * 获取附加考勤时长表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDur_chk_ca_addCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dur_chk_ca_add");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("附加考勤时长"); 
		return column;
	}
	/**
	 * 获取附加考勤分类id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_chk_ca_addCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_chk_ca_add");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("附加考勤分类id"); 
		return column;
	}
	/**
	 * 获取附加考勤分类表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_chk_ca_addCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_chk_ca_add");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("附加考勤分类"); 
		return column;
	}
	/**
	 * 获取实际上班时间2表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_beon2CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_beon2");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("实际上班时间2"); 
		return column;
	}
	/**
	 * 获取实际下班时间2表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_off2CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_off2");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("实际下班时间2"); 
		return column;
	}
	/**
	 * 获取扩展字段1表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCtrl1CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ctrl1");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("扩展字段1"); 
		return column;
	}
	/**
	 * 获取扩展字段2表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCtrl2CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ctrl2");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("扩展字段2"); 
		return column;
	}
	/**
	 * 获取扩展字段3表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCtrl3CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ctrl3");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("扩展字段3"); 
		return column;
	}
	/**
	 * 获取扩展字段4表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCtrl4CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ctrl4");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("扩展字段4"); 
		return column;
	}
	/**
	 * 获取扩展字段5表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCtrl5CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ctrl5");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("扩展字段5"); 
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
	 * 获取护理单元表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_dep_nurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dep_nur");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("护理单元"); 
		return column;
	}
	/**
	 * 获取姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_psndocCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_psndoc");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("姓名"); 
		return column;
	}
	/**
	 * 获取姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_reg_psnCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_reg_psn");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("姓名"); 
		return column;
	}
	/**
	 * 获取班次信息表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_hscsiCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_hscsi");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("班次信息"); 
		return column;
	}
	/**
	 * 获取实际考勤分类表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_chk_caCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_chk_ca");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("实际考勤分类"); 
		return column;
	}
	/**
	 * 获取班次分类表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_sicaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_sica");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("班次分类"); 
		return column;
	}
	/**
	 * 获取班次性质表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_siproCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_sipro");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("班次性质"); 
		return column;
	}
	/**
	 * 获取考勤状态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_chk_statusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_chk_status");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("考勤状态"); 
		return column;
	}
	/**
	 * 获取附加考勤分类表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_chk_ca_addCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_chk_ca_add");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("附加考勤分类"); 
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
