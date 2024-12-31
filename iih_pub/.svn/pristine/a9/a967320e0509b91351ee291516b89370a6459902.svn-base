
package iih.nmr.ha.tcho.tchoillpatientcare.d.desc;

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
 * 病危(病重)患者护理记录 DO 元数据信息
 */
public class TchoIllPatientCareDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.nmr.ha.tcho.tchoillpatientcare.d.TchoIllPatientCareDO";
	public static final String CLASS_DISPALYNAME = "病危(病重)患者护理记录";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "nmr_ha_tcho_illpatcare";
	public static final String TABLE_ALIAS_NAME = "a1";
	public static final String PRIMARYKEY_FIELDNAME="Id_patcare";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public TchoIllPatientCareDODesc(){
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
		this.setKeyDesc(getId_patcareADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_illpatADesc(tblDesc));
		this.add(getId_patcareADesc(tblDesc));
		this.add(getId_illpatADesc(tblDesc));
		this.add(getSys_preADesc(tblDesc));
		this.add(getDia_preADesc(tblDesc));
		this.add(getHeartrateADesc(tblDesc));
		this.add(getBreathADesc(tblDesc));
		this.add(getTemADesc(tblDesc));
		this.add(getPainscoreADesc(tblDesc));
		this.add(getSpo2ADesc(tblDesc));
		this.add(getLeftpupsizeADesc(tblDesc));
		this.add(getRightpupsizeADesc(tblDesc));
		this.add(getOxyrateADesc(tblDesc));
		this.add(getExudeamADesc(tblDesc));
		this.add(getDosageADesc(tblDesc));
		this.add(getOthdosageADesc(tblDesc));
		this.add(getUrioutputADesc(tblDesc));
		this.add(getOthoutputADesc(tblDesc));
		this.add(getNotifydocADesc(tblDesc));
		this.add(getSputumADesc(tblDesc));
		this.add(getAtomizerADesc(tblDesc));
		this.add(getExudeADesc(tblDesc));
		this.add(getDatiADesc(tblDesc));
		this.add(getEnumconstraintADesc(tblDesc));
		this.add(getId_senseADesc(tblDesc));
		this.add(getSd_senseADesc(tblDesc));
		this.add(getId_oxygenADesc(tblDesc));
		this.add(getSd_oxygenADesc(tblDesc));
		this.add(getId_pipenameADesc(tblDesc));
		this.add(getSd_pipenameADesc(tblDesc));
		this.add(getId_venousnurADesc(tblDesc));
		this.add(getSd_venousnurADesc(tblDesc));
		this.add(getId_trepumpADesc(tblDesc));
		this.add(getSd_trepumpADesc(tblDesc));
		this.add(getId_morcareADesc(tblDesc));
		this.add(getSd_morcareADesc(tblDesc));
		this.add(getId_nightcareADesc(tblDesc));
		this.add(getSd_nightcareADesc(tblDesc));
		this.add(getId_nurguidADesc(tblDesc));
		this.add(getSd_nurguidADesc(tblDesc));
		this.add(getId_drainADesc(tblDesc));
		this.add(getSd_drainADesc(tblDesc));
		this.add(getId_skinADesc(tblDesc));
		this.add(getSd_skinADesc(tblDesc));
		this.add(getId_leftpupilADesc(tblDesc));
		this.add(getSd_leftpupilADesc(tblDesc));
		this.add(getId_rightpupilADesc(tblDesc));
		this.add(getSd_rightpupilADesc(tblDesc));
		this.add(getId_venousnameADesc(tblDesc));
		this.add(getSd_venousnameADesc(tblDesc));
		this.add(getId_positionADesc(tblDesc));
		this.add(getSd_positionADesc(tblDesc));
		this.add(getDes_statetendADesc(tblDesc));
		this.add(getId_signADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getName_senseADesc(tblDesc));
		this.add(getName_oxygenADesc(tblDesc));
		this.add(getName_pipenameADesc(tblDesc));
		this.add(getName_venousnurADesc(tblDesc));
		this.add(getName_trepumpADesc(tblDesc));
		this.add(getName_morcareADesc(tblDesc));
		this.add(getName_nightcareADesc(tblDesc));
		this.add(getName_nurguidADesc(tblDesc));
		this.add(getName_drainADesc(tblDesc));
		this.add(getName_skinADesc(tblDesc));
		this.add(getName_leftpupilADesc(tblDesc));
		this.add(getName_rightpupilADesc(tblDesc));
		this.add(getName_venousnameADesc(tblDesc));
		this.add(getName_positionADesc(tblDesc));
		this.add(getName_signADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_patcareCDesc(tblDesc));
		tblDesc.add(getId_patcareCDesc(tblDesc));
		tblDesc.add(getId_illpatCDesc(tblDesc));
		tblDesc.add(getSys_preCDesc(tblDesc));
		tblDesc.add(getDia_preCDesc(tblDesc));
		tblDesc.add(getHeartrateCDesc(tblDesc));
		tblDesc.add(getBreathCDesc(tblDesc));
		tblDesc.add(getTemCDesc(tblDesc));
		tblDesc.add(getPainscoreCDesc(tblDesc));
		tblDesc.add(getSpo2CDesc(tblDesc));
		tblDesc.add(getLeftpupsizeCDesc(tblDesc));
		tblDesc.add(getRightpupsizeCDesc(tblDesc));
		tblDesc.add(getOxyrateCDesc(tblDesc));
		tblDesc.add(getExudeamCDesc(tblDesc));
		tblDesc.add(getDosageCDesc(tblDesc));
		tblDesc.add(getOthdosageCDesc(tblDesc));
		tblDesc.add(getUrioutputCDesc(tblDesc));
		tblDesc.add(getOthoutputCDesc(tblDesc));
		tblDesc.add(getNotifydocCDesc(tblDesc));
		tblDesc.add(getSputumCDesc(tblDesc));
		tblDesc.add(getAtomizerCDesc(tblDesc));
		tblDesc.add(getExudeCDesc(tblDesc));
		tblDesc.add(getDatiCDesc(tblDesc));
		tblDesc.add(getEnumconstraintCDesc(tblDesc));
		tblDesc.add(getId_senseCDesc(tblDesc));
		tblDesc.add(getSd_senseCDesc(tblDesc));
		tblDesc.add(getId_oxygenCDesc(tblDesc));
		tblDesc.add(getSd_oxygenCDesc(tblDesc));
		tblDesc.add(getId_pipenameCDesc(tblDesc));
		tblDesc.add(getSd_pipenameCDesc(tblDesc));
		tblDesc.add(getId_venousnurCDesc(tblDesc));
		tblDesc.add(getSd_venousnurCDesc(tblDesc));
		tblDesc.add(getId_trepumpCDesc(tblDesc));
		tblDesc.add(getSd_trepumpCDesc(tblDesc));
		tblDesc.add(getId_morcareCDesc(tblDesc));
		tblDesc.add(getSd_morcareCDesc(tblDesc));
		tblDesc.add(getId_nightcareCDesc(tblDesc));
		tblDesc.add(getSd_nightcareCDesc(tblDesc));
		tblDesc.add(getId_nurguidCDesc(tblDesc));
		tblDesc.add(getSd_nurguidCDesc(tblDesc));
		tblDesc.add(getId_drainCDesc(tblDesc));
		tblDesc.add(getSd_drainCDesc(tblDesc));
		tblDesc.add(getId_skinCDesc(tblDesc));
		tblDesc.add(getSd_skinCDesc(tblDesc));
		tblDesc.add(getId_leftpupilCDesc(tblDesc));
		tblDesc.add(getSd_leftpupilCDesc(tblDesc));
		tblDesc.add(getId_rightpupilCDesc(tblDesc));
		tblDesc.add(getSd_rightpupilCDesc(tblDesc));
		tblDesc.add(getId_venousnameCDesc(tblDesc));
		tblDesc.add(getSd_venousnameCDesc(tblDesc));
		tblDesc.add(getId_positionCDesc(tblDesc));
		tblDesc.add(getSd_positionCDesc(tblDesc));
		tblDesc.add(getDes_statetendCDesc(tblDesc));
		tblDesc.add(getId_signCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 患者护理记录单id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_patcareADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_patcare",  getId_patcareCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者护理记录单id");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 病危患者信息表id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_illpatADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_illpat",  getId_illpatCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病危患者信息表id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
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
	 * 疼痛分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPainscoreADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Painscore",  getPainscoreCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("疼痛分");
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
	 * 左瞳孔大小(mm)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getLeftpupsizeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Leftpupsize",  getLeftpupsizeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("左瞳孔大小(mm)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 右瞳孔大小(mm)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRightpupsizeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Rightpupsize",  getRightpupsizeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("右瞳孔大小(mm)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 吸氧流量L/min属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOxyrateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Oxyrate",  getOxyrateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("吸氧流量L/min");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 伤口渗出量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getExudeamADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Exudeam",  getExudeamCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("伤口渗出量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 用药入量/ml属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDosageADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dosage",  getDosageCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("用药入量/ml");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 其他入量/ml属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOthdosageADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Othdosage",  getOthdosageCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("其他入量/ml");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 尿出量/ml属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getUrioutputADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Urioutput",  getUrioutputCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("尿出量/ml");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 其他出量/ml属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOthoutputADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Othoutput",  getOthoutputCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("其他出量/ml");
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
	private IAttrDesc getNotifydocADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Notifydoc",  getNotifydocCDesc(tblDesc), this);
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
	 * 吸痰属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSputumADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sputum",  getSputumCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("吸痰");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 雾化属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAtomizerADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Atomizer",  getAtomizerCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("雾化");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 伤口渗出属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getExudeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Exude",  getExudeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("伤口渗出");
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
	private IAttrDesc getDatiADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dati",  getDatiCDesc(tblDesc), this);
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
	 * 神志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_senseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_sense",  getId_senseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("神志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 神志编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_senseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_sense",  getSd_senseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("神志编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 吸氧方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_oxygenADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_oxygen",  getId_oxygenCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("吸氧方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 吸氧方式编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_oxygenADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_oxygen",  getSd_oxygenCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("吸氧方式编码");
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
	 * 治疗泵属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_trepumpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_trepump",  getId_trepumpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("治疗泵");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 治疗泵编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_trepumpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_trepump",  getSd_trepumpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("治疗泵编码");
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
	 * 左瞳孔反射属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_leftpupilADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_leftpupil",  getId_leftpupilCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("左瞳孔反射");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 左瞳孔反射编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_leftpupilADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_leftpupil",  getSd_leftpupilCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("左瞳孔反射编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 右瞳孔反射属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_rightpupilADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_rightpupil",  getId_rightpupilCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("右瞳孔反射");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 右瞳孔反射编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_rightpupilADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_rightpupil",  getSd_rightpupilCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("右瞳孔反射编码");
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
	 * 护理签名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_signADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_sign",  getId_signCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("护理签名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
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
	 * 神志名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_senseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_sense",  getName_senseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("神志名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b3","id_sense=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 吸氧方式名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_oxygenADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_oxygen",  getName_oxygenCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("吸氧方式名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b4","id_oxygen=id_udidoc","name"});
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
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b5","id_pipename=id_udidoc","name"});
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
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b6","id_venousnur=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 治疗泵名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_trepumpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_trepump",  getName_trepumpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("治疗泵名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b7","id_trepump=id_udidoc","name"});
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
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b8","id_morcare=id_udidoc","name"});
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
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b9","id_nightcare=id_udidoc","name"});
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
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b10","id_nurguid=id_udidoc","name"});
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
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b20","id_skin=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 左瞳孔反射名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_leftpupilADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_leftpupil",  getName_leftpupilCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("左瞳孔反射名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b13","id_leftpupil=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 右瞳孔反射名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_rightpupilADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_rightpupil",  getName_rightpupilCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("右瞳孔反射名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b14","id_rightpupil=id_udidoc","name"});
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
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b15","id_venousname=id_udidoc","name"});
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
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b16","id_position=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_signADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_sign",  getName_signCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a1b17","id_sign=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取患者护理记录单id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_patcareCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_patcare");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("患者护理记录单id"); 
		return column;
	}
	/**
	 * 获取病危患者信息表id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_illpatCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_illpat");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病危患者信息表id"); 
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
	 * 获取疼痛分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPainscoreCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Painscore");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("疼痛分"); 
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
	 * 获取左瞳孔大小(mm)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getLeftpupsizeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Leftpupsize");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("左瞳孔大小(mm)"); 
		return column;
	}
	/**
	 * 获取右瞳孔大小(mm)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRightpupsizeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Rightpupsize");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("右瞳孔大小(mm)"); 
		return column;
	}
	/**
	 * 获取吸氧流量L/min表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOxyrateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Oxyrate");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("吸氧流量L/min"); 
		return column;
	}
	/**
	 * 获取伤口渗出量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getExudeamCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Exudeam");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("伤口渗出量"); 
		return column;
	}
	/**
	 * 获取用药入量/ml表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDosageCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dosage");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("用药入量/ml"); 
		return column;
	}
	/**
	 * 获取其他入量/ml表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOthdosageCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Othdosage");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("其他入量/ml"); 
		return column;
	}
	/**
	 * 获取尿出量/ml表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getUrioutputCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Urioutput");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("尿出量/ml"); 
		return column;
	}
	/**
	 * 获取其他出量/ml表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOthoutputCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Othoutput");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("其他出量/ml"); 
		return column;
	}
	/**
	 * 获取通知医生表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNotifydocCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Notifydoc");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("通知医生"); 
		return column;
	}
	/**
	 * 获取吸痰表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSputumCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sputum");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("吸痰"); 
		return column;
	}
	/**
	 * 获取雾化表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAtomizerCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Atomizer");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("雾化"); 
		return column;
	}
	/**
	 * 获取伤口渗出表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getExudeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Exude");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("伤口渗出"); 
		return column;
	}
	/**
	 * 获取日期/时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDatiCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dati");
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
	 * 获取神志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_senseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_sense");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("神志"); 
		return column;
	}
	/**
	 * 获取神志编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_senseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_sense");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("神志编码"); 
		return column;
	}
	/**
	 * 获取吸氧方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_oxygenCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_oxygen");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("吸氧方式"); 
		return column;
	}
	/**
	 * 获取吸氧方式编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_oxygenCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_oxygen");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("吸氧方式编码"); 
		return column;
	}
	/**
	 * 获取管道名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pipenameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pipename");
		column.setLength(500);
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
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("管道名称编码"); 
		return column;
	}
	/**
	 * 获取静脉置管护理表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_venousnurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_venousnur");
		column.setLength(500);
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
	 * 获取治疗泵表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_trepumpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_trepump");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("治疗泵"); 
		return column;
	}
	/**
	 * 获取治疗泵编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_trepumpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_trepump");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("治疗泵编码"); 
		return column;
	}
	/**
	 * 获取晨间护理表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_morcareCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_morcare");
		column.setLength(500);
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
		column.setLength(200);
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
		column.setLength(500);
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
		column.setLength(200);
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
		column.setLength(500);
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
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("护理指导编码"); 
		return column;
	}
	/**
	 * 获取排泄护理表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_drainCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_drain");
		column.setLength(500);
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
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("排泄护理编码"); 
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
	 * 获取左瞳孔反射表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_leftpupilCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_leftpupil");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("左瞳孔反射"); 
		return column;
	}
	/**
	 * 获取左瞳孔反射编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_leftpupilCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_leftpupil");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("左瞳孔反射编码"); 
		return column;
	}
	/**
	 * 获取右瞳孔反射表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_rightpupilCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_rightpupil");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("右瞳孔反射"); 
		return column;
	}
	/**
	 * 获取右瞳孔反射编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_rightpupilCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_rightpupil");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("右瞳孔反射编码"); 
		return column;
	}
	/**
	 * 获取静脉置管名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_venousnameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_venousname");
		column.setLength(500);
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
	 * 获取体位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_positionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_position");
		column.setLength(500);
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
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体位编码"); 
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
	 * 获取护理签名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_signCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_sign");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("护理签名"); 
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
	 * 获取神志名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_senseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_sense");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("神志名称"); 
		return column;
	}
	/**
	 * 获取吸氧方式名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_oxygenCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_oxygen");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("吸氧方式名称"); 
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
	 * 获取治疗泵名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_trepumpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_trepump");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("治疗泵名称"); 
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
	 * 获取左瞳孔反射名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_leftpupilCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_leftpupil");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("左瞳孔反射名称"); 
		return column;
	}
	/**
	 * 获取右瞳孔反射名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_rightpupilCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_rightpupil");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("右瞳孔反射名称"); 
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
	 * 获取姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_signCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_sign");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("姓名"); 
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
