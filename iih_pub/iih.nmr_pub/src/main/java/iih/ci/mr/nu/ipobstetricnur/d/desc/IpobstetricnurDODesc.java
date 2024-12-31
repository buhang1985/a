
package iih.ci.mr.nu.ipobstetricnur.d.desc;

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
 * 产科住院患者护理记录单 DO 元数据信息
 */
public class IpobstetricnurDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.ci.mr.nu.ipobstetricnur.d.IpobstetricnurDO";
	public static final String CLASS_DISPALYNAME = "产科住院患者护理记录单";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "mr_nu_ipobstinfo_iotc";
	public static final String TABLE_ALIAS_NAME = "a1";
	public static final String PRIMARYKEY_FIELDNAME="Id_obsinpa";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public IpobstetricnurDODesc(){
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
		this.setKeyDesc(getId_obsinpaADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.setFKeyDesc(getId_obsinfoADesc(tblDesc));
		this.add(getId_obsinpaADesc(tblDesc));
		this.add(getId_obsinfoADesc(tblDesc));
		this.add(getDt_recordADesc(tblDesc));
		this.add(getTemADesc(tblDesc));
		this.add(getPaulseADesc(tblDesc));
		this.add(getBreathADesc(tblDesc));
		this.add(getSys_preADesc(tblDesc));
		this.add(getDia_preADesc(tblDesc));
		this.add(getPainscoreADesc(tblDesc));
		this.add(getSpo2ADesc(tblDesc));
		this.add(getEu_incconADesc(tblDesc));
		this.add(getEntryitemADesc(tblDesc));
		this.add(getAmountADesc(tblDesc));
		this.add(getUrioutADesc(tblDesc));
		this.add(getOtheroutADesc(tblDesc));
		this.add(getNavelheightADesc(tblDesc));
		this.add(getUpperheightADesc(tblDesc));
		this.add(getLowerheightADesc(tblDesc));
		this.add(getEu_uterconADesc(tblDesc));
		this.add(getEu_bleedingADesc(tblDesc));
		this.add(getBleedingamADesc(tblDesc));
		this.add(getOtherADesc(tblDesc));
		this.add(getChangemeaADesc(tblDesc));
		this.add(getId_signADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_obsinpaCDesc(tblDesc));
		tblDesc.add(getId_obsinpaCDesc(tblDesc));
		tblDesc.add(getId_obsinfoCDesc(tblDesc));
		tblDesc.add(getDt_recordCDesc(tblDesc));
		tblDesc.add(getTemCDesc(tblDesc));
		tblDesc.add(getPaulseCDesc(tblDesc));
		tblDesc.add(getBreathCDesc(tblDesc));
		tblDesc.add(getSys_preCDesc(tblDesc));
		tblDesc.add(getDia_preCDesc(tblDesc));
		tblDesc.add(getPainscoreCDesc(tblDesc));
		tblDesc.add(getSpo2CDesc(tblDesc));
		tblDesc.add(getEu_incconCDesc(tblDesc));
		tblDesc.add(getEntryitemCDesc(tblDesc));
		tblDesc.add(getAmountCDesc(tblDesc));
		tblDesc.add(getUrioutCDesc(tblDesc));
		tblDesc.add(getOtheroutCDesc(tblDesc));
		tblDesc.add(getNavelheightCDesc(tblDesc));
		tblDesc.add(getUpperheightCDesc(tblDesc));
		tblDesc.add(getLowerheightCDesc(tblDesc));
		tblDesc.add(getEu_uterconCDesc(tblDesc));
		tblDesc.add(getEu_bleedingCDesc(tblDesc));
		tblDesc.add(getBleedingamCDesc(tblDesc));
		tblDesc.add(getOtherCDesc(tblDesc));
		tblDesc.add(getChangemeaCDesc(tblDesc));
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
	 * 产科住院患者护理记录单id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_obsinpaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_obsinpa",  getId_obsinpaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("产科住院患者护理记录单id");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 产科住院患者基本信息id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_obsinfoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_obsinfo",  getId_obsinfoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("产科住院患者基本信息id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 日期时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_recordADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_record",  getDt_recordCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("日期时间");
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
	 * 脉搏属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPaulseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Paulse",  getPaulseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("脉搏");
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
	 * 疼痛分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPainscoreADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Painscore",  getPainscoreCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
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
	 * 切口情况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_incconADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_inccon",  getEu_incconCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("切口情况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 入量项目属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEntryitemADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Entryitem",  getEntryitemCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入量项目");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 入量量(ml)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmountADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amount",  getAmountCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("入量量(ml)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 尿量出量(ml)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getUrioutADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Uriout",  getUrioutCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("尿量出量(ml)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 其他出量(ml)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOtheroutADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Otherout",  getOtheroutCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("其他出量(ml)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 脐平宫底高度(cm)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNavelheightADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Navelheight",  getNavelheightCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("脐平宫底高度(cm)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 脐上宫底高度(cm)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getUpperheightADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Upperheight",  getUpperheightCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("脐上宫底高度(cm)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 脐下宫底高度(cm)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getLowerheightADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Lowerheight",  getLowerheightCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("脐下宫底高度(cm)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 宫缩情况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_uterconADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_utercon",  getEu_uterconCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("宫缩情况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 阴道流血情况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_bleedingADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_bleeding",  getEu_bleedingCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("阴道流血情况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 阴道流血量(ml)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBleedingamADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Bleedingam",  getBleedingamCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("阴道流血量(ml)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 其他属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOtherADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Other",  getOtherCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("其他");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 病情变化及措施属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getChangemeaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Changemea",  getChangemeaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病情变化及措施");
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
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a1b3","id_sign=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取产科住院患者护理记录单id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_obsinpaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_obsinpa");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("产科住院患者护理记录单id"); 
		return column;
	}
	/**
	 * 获取产科住院患者基本信息id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_obsinfoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_obsinfo");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("产科住院患者基本信息id"); 
		return column;
	}
	/**
	 * 获取日期时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_recordCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_record");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("日期时间"); 
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
	 * 获取脉搏表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPaulseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Paulse");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("脉搏"); 
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
	 * 获取疼痛分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPainscoreCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Painscore");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
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
	 * 获取切口情况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_incconCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_inccon");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("切口情况"); 
		return column;
	}
	/**
	 * 获取入量项目表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEntryitemCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Entryitem");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入量项目"); 
		return column;
	}
	/**
	 * 获取入量量(ml)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmountCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amount");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("入量量(ml)"); 
		return column;
	}
	/**
	 * 获取尿量出量(ml)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getUrioutCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Uriout");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("尿量出量(ml)"); 
		return column;
	}
	/**
	 * 获取其他出量(ml)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOtheroutCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Otherout");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("其他出量(ml)"); 
		return column;
	}
	/**
	 * 获取脐平宫底高度(cm)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNavelheightCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Navelheight");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("脐平宫底高度(cm)"); 
		return column;
	}
	/**
	 * 获取脐上宫底高度(cm)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getUpperheightCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Upperheight");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("脐上宫底高度(cm)"); 
		return column;
	}
	/**
	 * 获取脐下宫底高度(cm)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getLowerheightCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Lowerheight");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("脐下宫底高度(cm)"); 
		return column;
	}
	/**
	 * 获取宫缩情况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_uterconCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_utercon");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("宫缩情况"); 
		return column;
	}
	/**
	 * 获取阴道流血情况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_bleedingCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_bleeding");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("阴道流血情况"); 
		return column;
	}
	/**
	 * 获取阴道流血量(ml)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBleedingamCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Bleedingam");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("阴道流血量(ml)"); 
		return column;
	}
	/**
	 * 获取其他表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOtherCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Other");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("其他"); 
		return column;
	}
	/**
	 * 获取病情变化及措施表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getChangemeaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Changemea");
		column.setLength(2000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病情变化及措施"); 
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
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id_org","Id_grp");
		iBDDataInfoFldMap.put("id_group","Id_org");
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
