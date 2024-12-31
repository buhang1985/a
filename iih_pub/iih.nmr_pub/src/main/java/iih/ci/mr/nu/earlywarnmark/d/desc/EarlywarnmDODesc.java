
package iih.ci.mr.nu.earlywarnmark.d.desc;

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
 * 早期预警患者评分信息 DO 元数据信息
 */
public class EarlywarnmDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.ci.mr.nu.earlywarnmark.d.EarlywarnmDO";
	public static final String CLASS_DISPALYNAME = "早期预警患者评分信息";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "mr_nu_early_warn";
	public static final String TABLE_ALIAS_NAME = "a1";
	public static final String PRIMARYKEY_FIELDNAME="Id_earlywarn";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public EarlywarnmDODesc(){
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
		this.setKeyDesc(getId_earlywarnADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.setFKeyDesc(getId_earlywarinfoADesc(tblDesc));
		this.add(getId_earlywarnADesc(tblDesc));
		this.add(getId_earlywarinfoADesc(tblDesc));
		this.add(getHeartscoreADesc(tblDesc));
		this.add(getSysprescoreADesc(tblDesc));
		this.add(getBreathscoreADesc(tblDesc));
		this.add(getTempscoreADesc(tblDesc));
		this.add(getConscscoreADesc(tblDesc));
		this.add(getValue_heartADesc(tblDesc));
		this.add(getValue_syspreADesc(tblDesc));
		this.add(getValue_breatADesc(tblDesc));
		this.add(getValue_temperatureADesc(tblDesc));
		this.add(getTotalscoreADesc(tblDesc));
		this.add(getDt_earlyADesc(tblDesc));
		this.add(getId_heartrateADesc(tblDesc));
		this.add(getSd_heartrateADesc(tblDesc));
		this.add(getId_syspreADesc(tblDesc));
		this.add(getSd_syspreADesc(tblDesc));
		this.add(getId_breathingADesc(tblDesc));
		this.add(getSd_breathingADesc(tblDesc));
		this.add(getId_temperatureADesc(tblDesc));
		this.add(getSd_temperatureADesc(tblDesc));
		this.add(getId_mentalityADesc(tblDesc));
		this.add(getSd_mentalityADesc(tblDesc));
		this.add(getId_signADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getName_heratADesc(tblDesc));
		this.add(getName_syspreADesc(tblDesc));
		this.add(getName_breathADesc(tblDesc));
		this.add(getName_temADesc(tblDesc));
		this.add(getName_menADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_earlywarnCDesc(tblDesc));
		tblDesc.add(getId_earlywarnCDesc(tblDesc));
		tblDesc.add(getId_earlywarinfoCDesc(tblDesc));
		tblDesc.add(getHeartscoreCDesc(tblDesc));
		tblDesc.add(getSysprescoreCDesc(tblDesc));
		tblDesc.add(getBreathscoreCDesc(tblDesc));
		tblDesc.add(getTempscoreCDesc(tblDesc));
		tblDesc.add(getConscscoreCDesc(tblDesc));
		tblDesc.add(getValue_heartCDesc(tblDesc));
		tblDesc.add(getValue_syspreCDesc(tblDesc));
		tblDesc.add(getValue_breatCDesc(tblDesc));
		tblDesc.add(getValue_temperatureCDesc(tblDesc));
		tblDesc.add(getTotalscoreCDesc(tblDesc));
		tblDesc.add(getDt_earlyCDesc(tblDesc));
		tblDesc.add(getId_heartrateCDesc(tblDesc));
		tblDesc.add(getSd_heartrateCDesc(tblDesc));
		tblDesc.add(getId_syspreCDesc(tblDesc));
		tblDesc.add(getSd_syspreCDesc(tblDesc));
		tblDesc.add(getId_breathingCDesc(tblDesc));
		tblDesc.add(getSd_breathingCDesc(tblDesc));
		tblDesc.add(getId_temperatureCDesc(tblDesc));
		tblDesc.add(getSd_temperatureCDesc(tblDesc));
		tblDesc.add(getId_mentalityCDesc(tblDesc));
		tblDesc.add(getSd_mentalityCDesc(tblDesc));
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
	 * 早期预警患者评分信息Id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_earlywarnADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_earlywarn",  getId_earlywarnCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("早期预警患者评分信息Id");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 重症患者早期基本信息Id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_earlywarinfoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_earlywarinfo",  getId_earlywarinfoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("重症患者早期基本信息Id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 心率评分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHeartscoreADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Heartscore",  getHeartscoreCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("心率评分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 收缩压评分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSysprescoreADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sysprescore",  getSysprescoreCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("收缩压评分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 呼吸评分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBreathscoreADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Breathscore",  getBreathscoreCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("呼吸评分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体温评分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTempscoreADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Tempscore",  getTempscoreCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("体温评分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 意识评分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getConscscoreADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Conscscore",  getConscscoreCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("意识评分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 心率值属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getValue_heartADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Value_heart",  getValue_heartCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("心率值");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 收缩压值属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getValue_syspreADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Value_syspre",  getValue_syspreCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("收缩压值");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 呼吸值属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getValue_breatADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Value_breat",  getValue_breatCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("呼吸值");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体温值属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getValue_temperatureADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Value_temperature",  getValue_temperatureCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("体温值");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 总分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTotalscoreADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Totalscore",  getTotalscoreCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("总分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_earlyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_early",  getDt_earlyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("时间");
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
	private IAttrDesc getId_heartrateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_heartrate",  getId_heartrateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("心率");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 心率编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_heartrateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_heartrate",  getSd_heartrateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("心率编码");
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
	private IAttrDesc getId_syspreADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_syspre",  getId_syspreCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("收缩压");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 收缩压编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_syspreADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_syspre",  getSd_syspreCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("收缩压编码");
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
	private IAttrDesc getId_breathingADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_breathing",  getId_breathingCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("呼吸");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 呼吸编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_breathingADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_breathing",  getSd_breathingCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("呼吸编码");
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
	private IAttrDesc getId_temperatureADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_temperature",  getId_temperatureCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体温");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 体温编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_temperatureADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_temperature",  getSd_temperatureCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体温编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 意识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mentalityADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mentality",  getId_mentalityCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("意识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 意识编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_mentalityADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_mentality",  getSd_mentalityCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("意识编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 护士签名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_signADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_sign",  getId_signCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("护士签名");
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
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_heratADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_herat",  getName_heratCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b3","id_heartrate=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_syspreADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_syspre",  getName_syspreCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b11","id_syspre=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_breathADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_breath",  getName_breathCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b12","id_breathing=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_temADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_tem",  getName_temCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b6","id_temperature=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_menADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_men",  getName_menCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b7","id_mentality=id_udidoc","name"});
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
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a1b10","id_sign=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取早期预警患者评分信息Id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_earlywarnCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_earlywarn");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("早期预警患者评分信息Id"); 
		return column;
	}
	/**
	 * 获取重症患者早期基本信息Id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_earlywarinfoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_earlywarinfo");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("重症患者早期基本信息Id"); 
		return column;
	}
	/**
	 * 获取心率评分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHeartscoreCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Heartscore");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("心率评分"); 
		return column;
	}
	/**
	 * 获取收缩压评分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSysprescoreCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sysprescore");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("收缩压评分"); 
		return column;
	}
	/**
	 * 获取呼吸评分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBreathscoreCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Breathscore");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("呼吸评分"); 
		return column;
	}
	/**
	 * 获取体温评分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTempscoreCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Tempscore");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("体温评分"); 
		return column;
	}
	/**
	 * 获取意识评分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getConscscoreCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Conscscore");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("意识评分"); 
		return column;
	}
	/**
	 * 获取心率值表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getValue_heartCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Value_heart");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("心率值"); 
		return column;
	}
	/**
	 * 获取收缩压值表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getValue_syspreCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Value_syspre");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("收缩压值"); 
		return column;
	}
	/**
	 * 获取呼吸值表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getValue_breatCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Value_breat");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("呼吸值"); 
		return column;
	}
	/**
	 * 获取体温值表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getValue_temperatureCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Value_temperature");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("体温值"); 
		return column;
	}
	/**
	 * 获取总分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTotalscoreCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Totalscore");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("总分"); 
		return column;
	}
	/**
	 * 获取时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_earlyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_early");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("时间"); 
		return column;
	}
	/**
	 * 获取心率表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_heartrateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_heartrate");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("心率"); 
		return column;
	}
	/**
	 * 获取心率编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_heartrateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_heartrate");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("心率编码"); 
		return column;
	}
	/**
	 * 获取收缩压表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_syspreCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_syspre");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("收缩压"); 
		return column;
	}
	/**
	 * 获取收缩压编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_syspreCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_syspre");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("收缩压编码"); 
		return column;
	}
	/**
	 * 获取呼吸表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_breathingCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_breathing");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("呼吸"); 
		return column;
	}
	/**
	 * 获取呼吸编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_breathingCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_breathing");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("呼吸编码"); 
		return column;
	}
	/**
	 * 获取体温表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_temperatureCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_temperature");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体温"); 
		return column;
	}
	/**
	 * 获取体温编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_temperatureCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_temperature");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体温编码"); 
		return column;
	}
	/**
	 * 获取意识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mentalityCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mentality");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("意识"); 
		return column;
	}
	/**
	 * 获取意识编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_mentalityCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_mentality");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("意识编码"); 
		return column;
	}
	/**
	 * 获取护士签名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_signCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_sign");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("护士签名"); 
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
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_heratCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_herat");
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
	private IColumnDesc getName_syspreCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_syspre");
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
	private IColumnDesc getName_breathCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_breath");
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
	private IColumnDesc getName_temCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_tem");
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
	private IColumnDesc getName_menCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_men");
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
	
}
