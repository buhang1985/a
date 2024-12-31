
package iih.ci.tsip.d.desc;

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
 * 治疗方案医嘱 DO 元数据信息
 */
public class CiTsOrDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.ci.tsip.d.CiTsOrDO";
	public static final String CLASS_DISPALYNAME = "治疗方案医嘱";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "ci_ts_or";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_tsor";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public CiTsOrDODesc(){
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
		this.setKeyDesc(getId_tsorADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_tsorADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_patADesc(tblDesc));
		this.add(getId_enADesc(tblDesc));
		this.add(getSd_entpADesc(tblDesc));
		this.add(getSd_srvtpADesc(tblDesc));
		this.add(getId_srvADesc(tblDesc));
		this.add(getFg_setADesc(tblDesc));
		this.add(getFg_longADesc(tblDesc));
		this.add(getCode_orADesc(tblDesc));
		this.add(getContent_orADesc(tblDesc));
		this.add(getName_orADesc(tblDesc));
		this.add(getId_freqADesc(tblDesc));
		this.add(getId_routeADesc(tblDesc));
		this.add(getId_routedesADesc(tblDesc));
		this.add(getDays_orADesc(tblDesc));
		this.add(getId_boilADesc(tblDesc));
		this.add(getOrdersADesc(tblDesc));
		this.add(getTimes_curADesc(tblDesc));
		this.add(getDt_bl_lastADesc(tblDesc));
		this.add(getEu_tsorsrcmdtpADesc(tblDesc));
		this.add(getSd_su_ts_orADesc(tblDesc));
		this.add(getSd_su_ts_mpADesc(tblDesc));
		this.add(getDt_effeADesc(tblDesc));
		this.add(getDt_endADesc(tblDesc));
		this.add(getDes_orADesc(tblDesc));
		this.add(getId_srvofADesc(tblDesc));
		this.add(getFuncclassstrADesc(tblDesc));
		this.add(getId_org_createADesc(tblDesc));
		this.add(getId_dep_createADesc(tblDesc));
		this.add(getId_wg_createADesc(tblDesc));
		this.add(getId_emp_createADesc(tblDesc));
		this.add(getId_dep_nur_createADesc(tblDesc));
		this.add(getDt_createADesc(tblDesc));
		this.add(getFg_signADesc(tblDesc));
		this.add(getId_emp_signADesc(tblDesc));
		this.add(getDt_signADesc(tblDesc));
		this.add(getId_dep_signADesc(tblDesc));
		this.add(getFg_stopADesc(tblDesc));
		this.add(getId_emp_stopADesc(tblDesc));
		this.add(getId_dep_stopADesc(tblDesc));
		this.add(getDt_stopADesc(tblDesc));
		this.add(getFg_cancADesc(tblDesc));
		this.add(getId_dep_cancADesc(tblDesc));
		this.add(getId_emp_cancADesc(tblDesc));
		this.add(getDt_cancADesc(tblDesc));
		this.add(getId_org_mpADesc(tblDesc));
		this.add(getId_dep_mpADesc(tblDesc));
		this.add(getId_di_defADesc(tblDesc));
		this.add(getNo_applyformADesc(tblDesc));
		this.add(getSd_tstpADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getRoutedes_nameADesc(tblDesc));
		this.add(getOrg_or_nameADesc(tblDesc));
		this.add(getDept_or_nameADesc(tblDesc));
		this.add(getEmp_phy_nameADesc(tblDesc));
		this.add(getEmp_sign_nameADesc(tblDesc));
		this.add(getDep_sign_nameADesc(tblDesc));
		this.add(getEmp_stop_nameADesc(tblDesc));
		this.add(getDep_stop_nameADesc(tblDesc));
		this.add(getDep_canc_nameADesc(tblDesc));
		this.add(getEmp_canc_nameADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_tsorCDesc(tblDesc));
		tblDesc.add(getId_tsorCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_patCDesc(tblDesc));
		tblDesc.add(getId_enCDesc(tblDesc));
		tblDesc.add(getSd_entpCDesc(tblDesc));
		tblDesc.add(getSd_srvtpCDesc(tblDesc));
		tblDesc.add(getId_srvCDesc(tblDesc));
		tblDesc.add(getFg_setCDesc(tblDesc));
		tblDesc.add(getFg_longCDesc(tblDesc));
		tblDesc.add(getCode_orCDesc(tblDesc));
		tblDesc.add(getContent_orCDesc(tblDesc));
		tblDesc.add(getName_orCDesc(tblDesc));
		tblDesc.add(getId_freqCDesc(tblDesc));
		tblDesc.add(getId_routeCDesc(tblDesc));
		tblDesc.add(getId_routedesCDesc(tblDesc));
		tblDesc.add(getDays_orCDesc(tblDesc));
		tblDesc.add(getId_boilCDesc(tblDesc));
		tblDesc.add(getOrdersCDesc(tblDesc));
		tblDesc.add(getTimes_curCDesc(tblDesc));
		tblDesc.add(getDt_bl_lastCDesc(tblDesc));
		tblDesc.add(getEu_tsorsrcmdtpCDesc(tblDesc));
		tblDesc.add(getSd_su_ts_orCDesc(tblDesc));
		tblDesc.add(getSd_su_ts_mpCDesc(tblDesc));
		tblDesc.add(getDt_effeCDesc(tblDesc));
		tblDesc.add(getDt_endCDesc(tblDesc));
		tblDesc.add(getDes_orCDesc(tblDesc));
		tblDesc.add(getId_srvofCDesc(tblDesc));
		tblDesc.add(getFuncclassstrCDesc(tblDesc));
		tblDesc.add(getId_org_createCDesc(tblDesc));
		tblDesc.add(getId_dep_createCDesc(tblDesc));
		tblDesc.add(getId_wg_createCDesc(tblDesc));
		tblDesc.add(getId_emp_createCDesc(tblDesc));
		tblDesc.add(getId_dep_nur_createCDesc(tblDesc));
		tblDesc.add(getDt_createCDesc(tblDesc));
		tblDesc.add(getFg_signCDesc(tblDesc));
		tblDesc.add(getId_emp_signCDesc(tblDesc));
		tblDesc.add(getDt_signCDesc(tblDesc));
		tblDesc.add(getId_dep_signCDesc(tblDesc));
		tblDesc.add(getFg_stopCDesc(tblDesc));
		tblDesc.add(getId_emp_stopCDesc(tblDesc));
		tblDesc.add(getId_dep_stopCDesc(tblDesc));
		tblDesc.add(getDt_stopCDesc(tblDesc));
		tblDesc.add(getFg_cancCDesc(tblDesc));
		tblDesc.add(getId_dep_cancCDesc(tblDesc));
		tblDesc.add(getId_emp_cancCDesc(tblDesc));
		tblDesc.add(getDt_cancCDesc(tblDesc));
		tblDesc.add(getId_org_mpCDesc(tblDesc));
		tblDesc.add(getId_dep_mpCDesc(tblDesc));
		tblDesc.add(getId_di_defCDesc(tblDesc));
		tblDesc.add(getNo_applyformCDesc(tblDesc));
		tblDesc.add(getSd_tstpCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 治疗方案医嘱ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_tsorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_tsor",  getId_tsorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("治疗方案医嘱ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
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
	 * 患者属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_patADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pat",  getId_patCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 就诊属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_enADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_en",  getId_enCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("就诊");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 就诊类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_entpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_entp",  getSd_entpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("就诊类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医嘱类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_srvtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_srvtp",  getSd_srvtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医嘱类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 服务属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_srvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_srv",  getId_srvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 服务套标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_setADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_set",  getFg_setCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("服务套标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 长临标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_longADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_long",  getFg_longCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("长临标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医嘱编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_orADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_or",  getCode_orCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医嘱编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医嘱内容属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getContent_orADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Content_or",  getContent_orCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医嘱内容");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医嘱名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_orADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_or",  getName_orCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医嘱名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医嘱频次属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_freqADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_freq",  getId_freqCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医嘱频次");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 医嘱用法属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_routeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_route",  getId_routeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医嘱用法");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 医嘱用法要求属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_routedesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_routedes",  getId_routedesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医嘱用法要求");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 医嘱天数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDays_orADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Days_or",  getDays_orCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("医嘱天数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 煎法属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_boilADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_boil",  getId_boilCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("煎法");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 医嘱付数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOrdersADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Orders",  getOrdersCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("医嘱付数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 次数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTimes_curADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Times_cur",  getTimes_curCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("次数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 最近生成日期时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_bl_lastADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_bl_last",  getDt_bl_lastCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("最近生成日期时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 方案医嘱来源方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_tsorsrcmdtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_tsorsrcmdtp",  getEu_tsorsrcmdtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("方案医嘱来源方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 方案医嘱状态属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_su_ts_orADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_su_ts_or",  getSd_su_ts_orCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("方案医嘱状态");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 方案医嘱生成状态属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_su_ts_mpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_su_ts_mp",  getSd_su_ts_mpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("方案医嘱生成状态");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医嘱生效日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_effeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_effe",  getDt_effeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("医嘱生效日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医嘱结束时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_endADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_end",  getDt_endCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("医嘱结束时间");
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
	private IAttrDesc getDes_orADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Des_or",  getDes_orCDesc(tblDesc), this);
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
	 * 医疗单属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_srvofADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_srvof",  getId_srvofCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医疗单");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 医疗单URL属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFuncclassstrADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Funcclassstr",  getFuncclassstrCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医疗单URL");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 开立机构属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_org_createADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_org_create",  getId_org_createCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("开立机构");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 开立部门属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dep_createADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep_create",  getId_dep_createCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("开立部门");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 开立医疗组属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_wg_createADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_wg_create",  getId_wg_createCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("开立医疗组");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 开立医生属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_createADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_create",  getId_emp_createCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("开立医生");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 开立病区属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dep_nur_createADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep_nur_create",  getId_dep_nur_createCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("开立病区");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 开立日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_createADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_create",  getDt_createCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("开立日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 签署标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_signADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_sign",  getFg_signCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("签署标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 签署医生属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_signADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_sign",  getId_emp_signCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("签署医生");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 签署日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_signADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_sign",  getDt_signCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("签署日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 签署部门属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dep_signADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep_sign",  getId_dep_signCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("签署部门");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 停止标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_stopADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_stop",  getFg_stopCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("停止标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 停止医生属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_stopADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_stop",  getId_emp_stopCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("停止医生");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 停止科室属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dep_stopADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep_stop",  getId_dep_stopCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("停止科室");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 停止日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_stopADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_stop",  getDt_stopCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("停止日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 作废标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_cancADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_canc",  getFg_cancCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("作废标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 作废科室属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dep_cancADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep_canc",  getId_dep_cancCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("作废科室");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 作废医生属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_cancADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_canc",  getId_emp_cancCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("作废医生");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 作废日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_cancADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_canc",  getDt_cancCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("作废日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 执行机构属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_org_mpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_org_mp",  getId_org_mpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("执行机构");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 执行科室属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dep_mpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep_mp",  getId_dep_mpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("执行科室");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 临床诊断属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_di_defADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_di_def",  getId_di_defCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("临床诊断");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 申请单号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNo_applyformADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("No_applyform",  getNo_applyformCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("申请单号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 方案类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_tstpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_tstp",  getSd_tstpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("方案类型");
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
	 * 用法要求属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRoutedes_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Routedes_name",  getRoutedes_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用法要求");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_route_des a0b9","id_routedes=id_routedes","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 组织名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOrg_or_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Org_or_name",  getOrg_or_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("组织名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_org a0b12","id_org_create=id_org","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDept_or_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dept_or_name",  getDept_or_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b13","id_dep_create=id_dep","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEmp_phy_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Emp_phy_name",  getEmp_phy_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b15","id_emp_create=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEmp_sign_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Emp_sign_name",  getEmp_sign_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b16","id_emp_sign=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDep_sign_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dep_sign_name",  getDep_sign_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b17","id_dep_sign=id_dep","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEmp_stop_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Emp_stop_name",  getEmp_stop_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b18","id_emp_stop=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDep_stop_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dep_stop_name",  getDep_stop_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b19","id_dep_stop=id_dep","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDep_canc_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dep_canc_name",  getDep_canc_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b20","id_dep_canc=id_dep","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEmp_canc_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Emp_canc_name",  getEmp_canc_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b21","id_emp_canc=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取治疗方案医嘱ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_tsorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_tsor");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("治疗方案医嘱ID"); 
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
	 * 获取患者表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pat");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者"); 
		return column;
	}
	/**
	 * 获取就诊表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_enCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_en");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊"); 
		return column;
	}
	/**
	 * 获取就诊类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_entpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_entp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊类型编码"); 
		return column;
	}
	/**
	 * 获取医嘱类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_srvtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_srvtp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医嘱类型编码"); 
		return column;
	}
	/**
	 * 获取服务表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_srvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_srv");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务"); 
		return column;
	}
	/**
	 * 获取服务套标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_setCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_set");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("服务套标识"); 
		return column;
	}
	/**
	 * 获取长临标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_longCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_long");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("长临标识"); 
		return column;
	}
	/**
	 * 获取医嘱编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_orCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_or");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医嘱编码"); 
		return column;
	}
	/**
	 * 获取医嘱内容表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getContent_orCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Content_or");
		column.setLength(4000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医嘱内容"); 
		return column;
	}
	/**
	 * 获取医嘱名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_orCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_or");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医嘱名称"); 
		return column;
	}
	/**
	 * 获取医嘱频次表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_freqCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_freq");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医嘱频次"); 
		return column;
	}
	/**
	 * 获取医嘱用法表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_routeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_route");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医嘱用法"); 
		return column;
	}
	/**
	 * 获取医嘱用法要求表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_routedesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_routedes");
		column.setLength(3000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医嘱用法要求"); 
		return column;
	}
	/**
	 * 获取医嘱天数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDays_orCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Days_or");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("医嘱天数"); 
		return column;
	}
	/**
	 * 获取煎法表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_boilCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_boil");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("煎法"); 
		return column;
	}
	/**
	 * 获取医嘱付数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOrdersCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Orders");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("医嘱付数"); 
		return column;
	}
	/**
	 * 获取次数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTimes_curCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Times_cur");
		column.setLength(2);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("次数"); 
		return column;
	}
	/**
	 * 获取最近生成日期时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_bl_lastCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_bl_last");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("最近生成日期时间"); 
		return column;
	}
	/**
	 * 获取方案医嘱来源方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_tsorsrcmdtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_tsorsrcmdtp");
		column.setLength(2);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("方案医嘱来源方式"); 
		return column;
	}
	/**
	 * 获取方案医嘱状态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_su_ts_orCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_su_ts_or");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("方案医嘱状态"); 
		return column;
	}
	/**
	 * 获取方案医嘱生成状态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_su_ts_mpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_su_ts_mp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("方案医嘱生成状态"); 
		return column;
	}
	/**
	 * 获取医嘱生效日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_effeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_effe");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("医嘱生效日期"); 
		return column;
	}
	/**
	 * 获取医嘱结束时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_endCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_end");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("医嘱结束时间"); 
		return column;
	}
	/**
	 * 获取备注表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDes_orCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Des_or");
		column.setLength(4000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备注"); 
		return column;
	}
	/**
	 * 获取医疗单表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_srvofCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_srvof");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医疗单"); 
		return column;
	}
	/**
	 * 获取医疗单URL表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFuncclassstrCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Funcclassstr");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医疗单URL"); 
		return column;
	}
	/**
	 * 获取开立机构表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_org_createCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_org_create");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("开立机构"); 
		return column;
	}
	/**
	 * 获取开立部门表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dep_createCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep_create");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("开立部门"); 
		return column;
	}
	/**
	 * 获取开立医疗组表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_wg_createCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_wg_create");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("开立医疗组"); 
		return column;
	}
	/**
	 * 获取开立医生表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_createCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_create");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("开立医生"); 
		return column;
	}
	/**
	 * 获取开立病区表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dep_nur_createCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep_nur_create");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("开立病区"); 
		return column;
	}
	/**
	 * 获取开立日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_createCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_create");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("开立日期"); 
		return column;
	}
	/**
	 * 获取签署标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_signCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_sign");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("签署标识"); 
		return column;
	}
	/**
	 * 获取签署医生表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_signCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_sign");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("签署医生"); 
		return column;
	}
	/**
	 * 获取签署日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_signCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_sign");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("签署日期"); 
		return column;
	}
	/**
	 * 获取签署部门表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dep_signCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep_sign");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("签署部门"); 
		return column;
	}
	/**
	 * 获取停止标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_stopCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_stop");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("停止标识"); 
		return column;
	}
	/**
	 * 获取停止医生表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_stopCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_stop");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("停止医生"); 
		return column;
	}
	/**
	 * 获取停止科室表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dep_stopCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep_stop");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("停止科室"); 
		return column;
	}
	/**
	 * 获取停止日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_stopCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_stop");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("停止日期"); 
		return column;
	}
	/**
	 * 获取作废标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_cancCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_canc");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("作废标识"); 
		return column;
	}
	/**
	 * 获取作废科室表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dep_cancCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep_canc");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("作废科室"); 
		return column;
	}
	/**
	 * 获取作废医生表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_cancCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_canc");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("作废医生"); 
		return column;
	}
	/**
	 * 获取作废日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_cancCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_canc");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("作废日期"); 
		return column;
	}
	/**
	 * 获取执行机构表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_org_mpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_org_mp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("执行机构"); 
		return column;
	}
	/**
	 * 获取执行科室表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dep_mpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep_mp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("执行科室"); 
		return column;
	}
	/**
	 * 获取临床诊断表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_di_defCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_di_def");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("临床诊断"); 
		return column;
	}
	/**
	 * 获取申请单号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNo_applyformCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"No_applyform");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("申请单号"); 
		return column;
	}
	/**
	 * 获取方案类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_tstpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_tstp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("方案类型"); 
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
	 * 获取用法要求表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRoutedes_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Routedes_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("用法要求"); 
		return column;
	}
	/**
	 * 获取组织名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOrg_or_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Org_or_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("组织名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDept_or_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dept_or_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEmp_phy_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Emp_phy_name");
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
	private IColumnDesc getEmp_sign_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Emp_sign_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("姓名"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDep_sign_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dep_sign_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEmp_stop_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Emp_stop_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("姓名"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDep_stop_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dep_stop_name");
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
	private IColumnDesc getDep_canc_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dep_canc_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEmp_canc_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Emp_canc_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("姓名"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id","Id_tsor");
		iBDDataInfoFldMap.put("id_org","Id_org");
		iBDDataInfoFldMap.put("code","Code_or");
		iBDDataInfoFldMap.put("name","Name_or");
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
		defaultValueMap.put("Dt_end",new xap.mw.coreitf.d.FDateTime("2099-01-01 00:00:00"));
	}
	
}
