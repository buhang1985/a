
package iih.ci.mr.nu.ccupatcarerec.d.desc;

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
 * CCU患者护理记录 DO 元数据信息
 */
public class CcupatcarerecDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.ci.mr.nu.ccupatcarerec.d.CcupatcarerecDO";
	public static final String CLASS_DISPALYNAME = "CCU患者护理记录";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "mr_nu_ccupatcarerec";
	public static final String TABLE_ALIAS_NAME = "a1";
	public static final String PRIMARYKEY_FIELDNAME="Id_ccupatcare";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public CcupatcarerecDODesc(){
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
		this.setKeyDesc(getId_ccupatcareADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.setFKeyDesc(getId_ccupatADesc(tblDesc));
		this.add(getId_ccupatcareADesc(tblDesc));
		this.add(getId_ccupatADesc(tblDesc));
		this.add(getName_pipenursADesc(tblDesc));
		this.add(getName_usemedADesc(tblDesc));
		this.add(getId_signADesc(tblDesc));
		this.add(getDes_statetendADesc(tblDesc));
		this.add(getTemADesc(tblDesc));
		this.add(getHeartrateADesc(tblDesc));
		this.add(getBreathADesc(tblDesc));
		this.add(getSys_preADesc(tblDesc));
		this.add(getDia_preADesc(tblDesc));
		this.add(getSpo2ADesc(tblDesc));
		this.add(getName_ecgmonADesc(tblDesc));
		this.add(getName_ecgnormalADesc(tblDesc));
		this.add(getOxyrateADesc(tblDesc));
		this.add(getFg_notifydocADesc(tblDesc));
		this.add(getDt_recordADesc(tblDesc));
		this.add(getEnumconstraintADesc(tblDesc));
		this.add(getId_positionADesc(tblDesc));
		this.add(getSd_positionADesc(tblDesc));
		this.add(getId_venousnameADesc(tblDesc));
		this.add(getSd_venousnameADesc(tblDesc));
		this.add(getId_venousnurADesc(tblDesc));
		this.add(getSd_venousnurADesc(tblDesc));
		this.add(getId_pipenameADesc(tblDesc));
		this.add(getSd_pipenameADesc(tblDesc));
		this.add(getId_morcareADesc(tblDesc));
		this.add(getSd_morcareADesc(tblDesc));
		this.add(getId_nightcareADesc(tblDesc));
		this.add(getSd_nightcareADesc(tblDesc));
		this.add(getId_nurguidADesc(tblDesc));
		this.add(getSd_nurguidADesc(tblDesc));
		this.add(getId_skinADesc(tblDesc));
		this.add(getSd_skinADesc(tblDesc));
		this.add(getId_drainADesc(tblDesc));
		this.add(getSd_drainADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getName_signADesc(tblDesc));
		this.add(getName_positionADesc(tblDesc));
		this.add(getName_venousnameADesc(tblDesc));
		this.add(getName_venousnurADesc(tblDesc));
		this.add(getName_pipenameADesc(tblDesc));
		this.add(getName_morcareADesc(tblDesc));
		this.add(getName_nightcareADesc(tblDesc));
		this.add(getName_nurguidADesc(tblDesc));
		this.add(getName_skinADesc(tblDesc));
		this.add(getName_drainADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_ccupatcareCDesc(tblDesc));
		tblDesc.add(getId_ccupatcareCDesc(tblDesc));
		tblDesc.add(getId_ccupatCDesc(tblDesc));
		tblDesc.add(getName_pipenursCDesc(tblDesc));
		tblDesc.add(getName_usemedCDesc(tblDesc));
		tblDesc.add(getId_signCDesc(tblDesc));
		tblDesc.add(getDes_statetendCDesc(tblDesc));
		tblDesc.add(getTemCDesc(tblDesc));
		tblDesc.add(getHeartrateCDesc(tblDesc));
		tblDesc.add(getBreathCDesc(tblDesc));
		tblDesc.add(getSys_preCDesc(tblDesc));
		tblDesc.add(getDia_preCDesc(tblDesc));
		tblDesc.add(getSpo2CDesc(tblDesc));
		tblDesc.add(getName_ecgmonCDesc(tblDesc));
		tblDesc.add(getName_ecgnormalCDesc(tblDesc));
		tblDesc.add(getOxyrateCDesc(tblDesc));
		tblDesc.add(getFg_notifydocCDesc(tblDesc));
		tblDesc.add(getDt_recordCDesc(tblDesc));
		tblDesc.add(getEnumconstraintCDesc(tblDesc));
		tblDesc.add(getId_positionCDesc(tblDesc));
		tblDesc.add(getSd_positionCDesc(tblDesc));
		tblDesc.add(getId_venousnameCDesc(tblDesc));
		tblDesc.add(getSd_venousnameCDesc(tblDesc));
		tblDesc.add(getId_venousnurCDesc(tblDesc));
		tblDesc.add(getSd_venousnurCDesc(tblDesc));
		tblDesc.add(getId_pipenameCDesc(tblDesc));
		tblDesc.add(getSd_pipenameCDesc(tblDesc));
		tblDesc.add(getId_morcareCDesc(tblDesc));
		tblDesc.add(getSd_morcareCDesc(tblDesc));
		tblDesc.add(getId_nightcareCDesc(tblDesc));
		tblDesc.add(getSd_nightcareCDesc(tblDesc));
		tblDesc.add(getId_nurguidCDesc(tblDesc));
		tblDesc.add(getSd_nurguidCDesc(tblDesc));
		tblDesc.add(getId_skinCDesc(tblDesc));
		tblDesc.add(getSd_skinCDesc(tblDesc));
		tblDesc.add(getId_drainCDesc(tblDesc));
		tblDesc.add(getSd_drainCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * CCU患者护理记录表id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ccupatcareADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ccupatcare",  getId_ccupatcareCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("CCU患者护理记录表id");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * CCU患者信息表ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ccupatADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ccupat",  getId_ccupatCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("CCU患者信息表ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 管道护理属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_pipenursADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_pipenurs",  getName_pipenursCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("管道护理");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 用药属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_usemedADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_usemed",  getName_usemedCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用药");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 签名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_signADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_sign",  getId_signCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("签名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 病情变化及护理措施(含异常化验结果)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDes_statetendADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Des_statetend",  getDes_statetendCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病情变化及护理措施(含异常化验结果)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体温属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTemADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Tem",  getTemCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("体温");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 心率属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHeartrateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Heartrate",  getHeartrateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("心率");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 呼吸属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBreathADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Breath",  getBreathCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("呼吸");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 收缩压属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSys_preADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sys_pre",  getSys_preCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("收缩压");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 舒张压属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDia_preADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dia_pre",  getDia_preCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("舒张压");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * SPO2属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSpo2ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Spo2",  getSpo2CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("SPO2");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 心电监护窦性属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_ecgmonADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_ecgmon",  getName_ecgmonCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("心电监护窦性");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 心电监护正常属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_ecgnormalADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_ecgnormal",  getName_ecgnormalCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("心电监护正常");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 吸氧流量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOxyrateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Oxyrate",  getOxyrateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("吸氧流量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 通知医生属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_notifydocADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_notifydoc",  getFg_notifydocCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("通知医生");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 日期/时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_recordADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_record",  getDt_recordCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("日期/时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 约束属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEnumconstraintADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Enumconstraint",  getEnumconstraintCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("约束");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_positionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_position",  getId_positionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 体位编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_positionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_position",  getSd_positionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体位编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 静脉置管名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_venousnameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_venousname",  getId_venousnameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("静脉置管名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 静脉置管名称编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_venousnameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_venousname",  getSd_venousnameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("静脉置管名称编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 静脉置管护理属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_venousnurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_venousnur",  getId_venousnurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("静脉置管护理");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 静脉置管护理编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_venousnurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_venousnur",  getSd_venousnurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("静脉置管护理编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 管道名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pipenameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pipename",  getId_pipenameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("管道名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 管道名称编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_pipenameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_pipename",  getSd_pipenameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("管道名称编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 晨间护理属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_morcareADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_morcare",  getId_morcareCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("晨间护理");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 晨间护理编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_morcareADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_morcare",  getSd_morcareCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("晨间护理编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 晚间护理属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_nightcareADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_nightcare",  getId_nightcareCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("晚间护理");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 晚间护理编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_nightcareADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_nightcare",  getSd_nightcareCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("晚间护理编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 护理指导属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_nurguidADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_nurguid",  getId_nurguidCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("护理指导");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 护理指导编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_nurguidADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_nurguid",  getSd_nurguidCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("护理指导编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 皮肤属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_skinADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_skin",  getId_skinCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("皮肤");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 皮肤编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_skinADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_skin",  getSd_skinCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("皮肤编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 排泄护理属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_drainADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_drain",  getId_drainCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("排泄护理");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 排泄护理编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_drainADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_drain",  getSd_drainCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("排泄护理编码");
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
	 * 签名姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_signADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_sign",  getName_signCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("签名姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a1b14","id_sign=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体位名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_positionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_position",  getName_positionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体位名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b15","id_position=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 静脉置管名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_venousnameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_venousname",  getName_venousnameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("静脉置管名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b16","id_venousname=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 静脉置管护理名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_venousnurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_venousnur",  getName_venousnurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("静脉置管护理名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b17","id_venousnur=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 管道名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_pipenameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_pipename",  getName_pipenameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("管道名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b6","id_pipename=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 晨间护理名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_morcareADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_morcare",  getName_morcareCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("晨间护理名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b7","id_morcare=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 晚间护理名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_nightcareADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_nightcare",  getName_nightcareCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("晚间护理名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b8","id_nightcare=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 护理指导名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_nurguidADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_nurguid",  getName_nurguidCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("护理指导名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b9","id_nurguid=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 皮肤名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_skinADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_skin",  getName_skinCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("皮肤名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b10","id_skin=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 排泄护理名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_drainADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_drain",  getName_drainCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("排泄护理名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b11","id_drain=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取CCU患者护理记录表id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ccupatcareCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ccupatcare");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("CCU患者护理记录表id"); 
		return column;
	}
	/**
	 * 获取CCU患者信息表ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ccupatCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ccupat");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("CCU患者信息表ID"); 
		return column;
	}
	/**
	 * 获取管道护理表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_pipenursCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_pipenurs");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("管道护理"); 
		return column;
	}
	/**
	 * 获取用药表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_usemedCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_usemed");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("用药"); 
		return column;
	}
	/**
	 * 获取签名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_signCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_sign");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("签名"); 
		return column;
	}
	/**
	 * 获取病情变化及护理措施(含异常化验结果)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDes_statetendCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Des_statetend");
		column.setLength(2000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病情变化及护理措施(含异常化验结果)"); 
		return column;
	}
	/**
	 * 获取体温表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTemCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Tem");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("体温"); 
		return column;
	}
	/**
	 * 获取心率表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHeartrateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Heartrate");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("心率"); 
		return column;
	}
	/**
	 * 获取呼吸表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBreathCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Breath");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("呼吸"); 
		return column;
	}
	/**
	 * 获取收缩压表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSys_preCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sys_pre");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("收缩压"); 
		return column;
	}
	/**
	 * 获取舒张压表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDia_preCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dia_pre");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("舒张压"); 
		return column;
	}
	/**
	 * 获取SPO2表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSpo2CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Spo2");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("SPO2"); 
		return column;
	}
	/**
	 * 获取心电监护窦性表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_ecgmonCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_ecgmon");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("心电监护窦性"); 
		return column;
	}
	/**
	 * 获取心电监护正常表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_ecgnormalCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_ecgnormal");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("心电监护正常"); 
		return column;
	}
	/**
	 * 获取吸氧流量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOxyrateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Oxyrate");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("吸氧流量"); 
		return column;
	}
	/**
	 * 获取通知医生表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_notifydocCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_notifydoc");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("通知医生"); 
		return column;
	}
	/**
	 * 获取日期/时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_recordCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_record");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("日期/时间"); 
		return column;
	}
	/**
	 * 获取约束表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEnumconstraintCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Enumconstraint");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("约束"); 
		return column;
	}
	/**
	 * 获取体位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_positionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_position");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体位"); 
		return column;
	}
	/**
	 * 获取体位编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_positionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_position");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体位编码"); 
		return column;
	}
	/**
	 * 获取静脉置管名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_venousnameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_venousname");
		column.setLength(2000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("静脉置管名称"); 
		return column;
	}
	/**
	 * 获取静脉置管名称编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_venousnameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_venousname");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("静脉置管名称编码"); 
		return column;
	}
	/**
	 * 获取静脉置管护理表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_venousnurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_venousnur");
		column.setLength(2000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("静脉置管护理"); 
		return column;
	}
	/**
	 * 获取静脉置管护理编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_venousnurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_venousnur");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("静脉置管护理编码"); 
		return column;
	}
	/**
	 * 获取管道名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pipenameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pipename");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("管道名称"); 
		return column;
	}
	/**
	 * 获取管道名称编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_pipenameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_pipename");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("管道名称编码"); 
		return column;
	}
	/**
	 * 获取晨间护理表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_morcareCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_morcare");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("晨间护理"); 
		return column;
	}
	/**
	 * 获取晨间护理编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_morcareCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_morcare");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("晨间护理编码"); 
		return column;
	}
	/**
	 * 获取晚间护理表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_nightcareCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_nightcare");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("晚间护理"); 
		return column;
	}
	/**
	 * 获取晚间护理编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_nightcareCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_nightcare");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("晚间护理编码"); 
		return column;
	}
	/**
	 * 获取护理指导表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_nurguidCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_nurguid");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("护理指导"); 
		return column;
	}
	/**
	 * 获取护理指导编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_nurguidCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_nurguid");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("护理指导编码"); 
		return column;
	}
	/**
	 * 获取皮肤表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_skinCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_skin");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("皮肤"); 
		return column;
	}
	/**
	 * 获取皮肤编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_skinCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_skin");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("皮肤编码"); 
		return column;
	}
	/**
	 * 获取排泄护理表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_drainCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_drain");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("排泄护理"); 
		return column;
	}
	/**
	 * 获取排泄护理编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_drainCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_drain");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("排泄护理编码"); 
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
	 * 获取签名姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_signCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_sign");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("签名姓名"); 
		return column;
	}
	/**
	 * 获取体位名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_positionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_position");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体位名称"); 
		return column;
	}
	/**
	 * 获取静脉置管名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_venousnameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_venousname");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("静脉置管名称"); 
		return column;
	}
	/**
	 * 获取静脉置管护理名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_venousnurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_venousnur");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("静脉置管护理名称"); 
		return column;
	}
	/**
	 * 获取管道名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_pipenameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_pipename");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("管道名称"); 
		return column;
	}
	/**
	 * 获取晨间护理名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_morcareCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_morcare");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("晨间护理名称"); 
		return column;
	}
	/**
	 * 获取晚间护理名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_nightcareCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_nightcare");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("晚间护理名称"); 
		return column;
	}
	/**
	 * 获取护理指导名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_nurguidCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_nurguid");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("护理指导名称"); 
		return column;
	}
	/**
	 * 获取皮肤名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_skinCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_skin");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("皮肤名称"); 
		return column;
	}
	/**
	 * 获取排泄护理名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_drainCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_drain");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("排泄护理名称"); 
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
	
}
