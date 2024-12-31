
package iih.ci.mr.nu.intervopre.d.desc;

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
 * 介入手术信息 DO 元数据信息
 */
public class InterOperInfoDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.ci.mr.nu.intervopre.d.InterOperInfoDO";
	public static final String CLASS_DISPALYNAME = "介入手术信息";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "MR_NU_INTEROPERINFO";
	public static final String TABLE_ALIAS_NAME = "a2";
	public static final String PRIMARYKEY_FIELDNAME="Id_oper_pre";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public InterOperInfoDODesc(){
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
		this.setKeyDesc(getId_oper_preADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.setFKeyDesc(getId_patinfoADesc(tblDesc));
		this.add(getId_oper_preADesc(tblDesc));
		this.add(getId_patinfoADesc(tblDesc));
		this.add(getInfu_nameADesc(tblDesc));
		this.add(getId_sigADesc(tblDesc));
		this.add(getX_irradiationADesc(tblDesc));
		this.add(getSys_preADesc(tblDesc));
		this.add(getDia_preADesc(tblDesc));
		this.add(getBreathADesc(tblDesc));
		this.add(getInfu_volumeADesc(tblDesc));
		this.add(getInfu_rateADesc(tblDesc));
		this.add(getUrine_volumeADesc(tblDesc));
		this.add(getHeartrateADesc(tblDesc));
		this.add(getSpo2ADesc(tblDesc));
		this.add(getT_operADesc(tblDesc));
		this.add(getT_oper_processADesc(tblDesc));
		this.add(getId_consciousADesc(tblDesc));
		this.add(getSd_consciousADesc(tblDesc));
		this.add(getId_pupil_shapeADesc(tblDesc));
		this.add(getSd_pupil_shapeADesc(tblDesc));
		this.add(getId_pupil_reflectADesc(tblDesc));
		this.add(getSd_pupil_reflectADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getName_sigADesc(tblDesc));
		this.add(getName_consciousADesc(tblDesc));
		this.add(getName_pupil_shapeADesc(tblDesc));
		this.add(getName_pupil_reflectADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_oper_preCDesc(tblDesc));
		tblDesc.add(getId_oper_preCDesc(tblDesc));
		tblDesc.add(getId_patinfoCDesc(tblDesc));
		tblDesc.add(getInfu_nameCDesc(tblDesc));
		tblDesc.add(getId_sigCDesc(tblDesc));
		tblDesc.add(getX_irradiationCDesc(tblDesc));
		tblDesc.add(getSys_preCDesc(tblDesc));
		tblDesc.add(getDia_preCDesc(tblDesc));
		tblDesc.add(getBreathCDesc(tblDesc));
		tblDesc.add(getInfu_volumeCDesc(tblDesc));
		tblDesc.add(getInfu_rateCDesc(tblDesc));
		tblDesc.add(getUrine_volumeCDesc(tblDesc));
		tblDesc.add(getHeartrateCDesc(tblDesc));
		tblDesc.add(getSpo2CDesc(tblDesc));
		tblDesc.add(getT_operCDesc(tblDesc));
		tblDesc.add(getT_oper_processCDesc(tblDesc));
		tblDesc.add(getId_consciousCDesc(tblDesc));
		tblDesc.add(getSd_consciousCDesc(tblDesc));
		tblDesc.add(getId_pupil_shapeCDesc(tblDesc));
		tblDesc.add(getSd_pupil_shapeCDesc(tblDesc));
		tblDesc.add(getId_pupil_reflectCDesc(tblDesc));
		tblDesc.add(getSd_pupil_reflectCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 手术信息ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_oper_preADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_oper_pre",  getId_oper_preCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术信息ID");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者信息ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_patinfoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_patinfo",  getId_patinfoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者信息ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 输入名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInfu_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Infu_name",  getInfu_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("输入名称");
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
	private IAttrDesc getId_sigADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_sig",  getId_sigCDesc(tblDesc), this);
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
	 * 透视照射时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getX_irradiationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("X_irradiation",  getX_irradiationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("透视照射时间");
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
	 * 输入量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInfu_volumeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Infu_volume",  getInfu_volumeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("输入量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 输入速率属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInfu_rateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Infu_rate",  getInfu_rateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("输入速率");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 尿量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getUrine_volumeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Urine_volume",  getUrine_volumeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("尿量");
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
	 * 手术时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getT_operADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("T_oper",  getT_operCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FTime);
		attrDesc.setLabel("手术时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术进程时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getT_oper_processADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("T_oper_process",  getT_oper_processCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FTime);
		attrDesc.setLabel("手术进程时间");
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
	private IAttrDesc getId_consciousADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_conscious",  getId_consciousCDesc(tblDesc), this);
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
	private IAttrDesc getSd_consciousADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_conscious",  getSd_consciousCDesc(tblDesc), this);
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
	 * 瞳孔形状属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pupil_shapeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pupil_shape",  getId_pupil_shapeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("瞳孔形状");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 瞳孔形状编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_pupil_shapeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_pupil_shape",  getSd_pupil_shapeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("瞳孔形状编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 瞳孔反射属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pupil_reflectADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pupil_reflect",  getId_pupil_reflectCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("瞳孔反射");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 瞳孔反射编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_pupil_reflectADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_pupil_reflect",  getSd_pupil_reflectCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("瞳孔反射编码");
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
	 * 签名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_sigADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_sig",  getName_sigCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("签名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a2b8","id_sig=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 意识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_consciousADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_conscious",  getName_consciousCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("意识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a2b5","id_conscious=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 瞳孔形状属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_pupil_shapeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_pupil_shape",  getName_pupil_shapeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("瞳孔形状");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a2b6","id_pupil_shape=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 瞳孔反射属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_pupil_reflectADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_pupil_reflect",  getName_pupil_reflectCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("瞳孔反射");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a2b7","id_pupil_reflect=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取手术信息ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_oper_preCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_oper_pre");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("手术信息ID"); 
		return column;
	}
	/**
	 * 获取患者信息ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_patinfoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_patinfo");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者信息ID"); 
		return column;
	}
	/**
	 * 获取输入名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInfu_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Infu_name");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("输入名称"); 
		return column;
	}
	/**
	 * 获取签名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_sigCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_sig");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("签名"); 
		return column;
	}
	/**
	 * 获取透视照射时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getX_irradiationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"X_irradiation");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("透视照射时间"); 
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
	 * 获取输入量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInfu_volumeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Infu_volume");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("输入量"); 
		return column;
	}
	/**
	 * 获取输入速率表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInfu_rateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Infu_rate");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("输入速率"); 
		return column;
	}
	/**
	 * 获取尿量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getUrine_volumeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Urine_volume");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("尿量"); 
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
	 * 获取手术时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getT_operCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"T_oper");
		column.setLength(8);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("手术时间"); 
		return column;
	}
	/**
	 * 获取手术进程时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getT_oper_processCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"T_oper_process");
		column.setLength(8);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("手术进程时间"); 
		return column;
	}
	/**
	 * 获取意识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_consciousCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_conscious");
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
	private IColumnDesc getSd_consciousCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_conscious");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("意识编码"); 
		return column;
	}
	/**
	 * 获取瞳孔形状表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pupil_shapeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pupil_shape");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("瞳孔形状"); 
		return column;
	}
	/**
	 * 获取瞳孔形状编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_pupil_shapeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_pupil_shape");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("瞳孔形状编码"); 
		return column;
	}
	/**
	 * 获取瞳孔反射表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pupil_reflectCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pupil_reflect");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("瞳孔反射"); 
		return column;
	}
	/**
	 * 获取瞳孔反射编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_pupil_reflectCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_pupil_reflect");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("瞳孔反射编码"); 
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
	 * 获取签名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_sigCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_sig");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("签名"); 
		return column;
	}
	/**
	 * 获取意识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_consciousCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_conscious");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("意识"); 
		return column;
	}
	/**
	 * 获取瞳孔形状表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_pupil_shapeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_pupil_shape");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("瞳孔形状"); 
		return column;
	}
	/**
	 * 获取瞳孔反射表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_pupil_reflectCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_pupil_reflect");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("瞳孔反射"); 
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
