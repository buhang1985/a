
package iih.ci.mr.nu.sugeryip.d.desc;

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
 * 外科患者护理记录单 DO 元数据信息
 */
public class SurgeryIpDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.ci.mr.nu.sugeryip.d.SurgeryIpDO";
	public static final String CLASS_DISPALYNAME = "外科患者护理记录单";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "MR_NU_SURGERYIP";
	public static final String TABLE_ALIAS_NAME = "a1";
	public static final String PRIMARYKEY_FIELDNAME="Id_sugeryip";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public SurgeryIpDODesc(){
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
		this.setKeyDesc(getId_sugeryipADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.setFKeyDesc(getId_patinfoADesc(tblDesc));
		this.add(getId_sugeryipADesc(tblDesc));
		this.add(getId_patinfoADesc(tblDesc));
		this.add(getWoundADesc(tblDesc));
		this.add(getId_veinpipeADesc(tblDesc));
		this.add(getSd_veinpipeADesc(tblDesc));
		this.add(getId_care_veinpipeADesc(tblDesc));
		this.add(getSd_care_veinpipeADesc(tblDesc));
		this.add(getId_pipeADesc(tblDesc));
		this.add(getSd_pipeADesc(tblDesc));
		this.add(getId_pipe_stateADesc(tblDesc));
		this.add(getSd_pipe_stateADesc(tblDesc));
		this.add(getPipe_volumeADesc(tblDesc));
		this.add(getSupplementADesc(tblDesc));
		this.add(getIllcondchangesandsolveADesc(tblDesc));
		this.add(getId_signatureADesc(tblDesc));
		this.add(getPaulseADesc(tblDesc));
		this.add(getPain_scoreADesc(tblDesc));
		this.add(getTemADesc(tblDesc));
		this.add(getBreathADesc(tblDesc));
		this.add(getSys_preADesc(tblDesc));
		this.add(getDia_preADesc(tblDesc));
		this.add(getSpo2ADesc(tblDesc));
		this.add(getD_recADesc(tblDesc));
		this.add(getT_recADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getName_veinpipeADesc(tblDesc));
		this.add(getName_care_veinpipeADesc(tblDesc));
		this.add(getName_pipeADesc(tblDesc));
		this.add(getName_pipe_stateADesc(tblDesc));
		this.add(getName_signatureADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_sugeryipCDesc(tblDesc));
		tblDesc.add(getId_sugeryipCDesc(tblDesc));
		tblDesc.add(getId_patinfoCDesc(tblDesc));
		tblDesc.add(getWoundCDesc(tblDesc));
		tblDesc.add(getId_veinpipeCDesc(tblDesc));
		tblDesc.add(getSd_veinpipeCDesc(tblDesc));
		tblDesc.add(getId_care_veinpipeCDesc(tblDesc));
		tblDesc.add(getSd_care_veinpipeCDesc(tblDesc));
		tblDesc.add(getId_pipeCDesc(tblDesc));
		tblDesc.add(getSd_pipeCDesc(tblDesc));
		tblDesc.add(getId_pipe_stateCDesc(tblDesc));
		tblDesc.add(getSd_pipe_stateCDesc(tblDesc));
		tblDesc.add(getPipe_volumeCDesc(tblDesc));
		tblDesc.add(getSupplementCDesc(tblDesc));
		tblDesc.add(getIllcondchangesandsolveCDesc(tblDesc));
		tblDesc.add(getId_signatureCDesc(tblDesc));
		tblDesc.add(getPaulseCDesc(tblDesc));
		tblDesc.add(getPain_scoreCDesc(tblDesc));
		tblDesc.add(getTemCDesc(tblDesc));
		tblDesc.add(getBreathCDesc(tblDesc));
		tblDesc.add(getSys_preCDesc(tblDesc));
		tblDesc.add(getDia_preCDesc(tblDesc));
		tblDesc.add(getSpo2CDesc(tblDesc));
		tblDesc.add(getD_recCDesc(tblDesc));
		tblDesc.add(getT_recCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 外科患者记录单属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_sugeryipADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_sugeryip",  getId_sugeryipCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("外科患者记录单");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 外科住院患者信息属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_patinfoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_patinfo",  getId_patinfoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("外科住院患者信息");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 伤口属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWoundADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Wound",  getWoundCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("伤口");
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
	private IAttrDesc getId_veinpipeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_veinpipe",  getId_veinpipeCDesc(tblDesc), this);
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
	private IAttrDesc getSd_veinpipeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_veinpipe",  getSd_veinpipeCDesc(tblDesc), this);
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
	private IAttrDesc getId_care_veinpipeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_care_veinpipe",  getId_care_veinpipeCDesc(tblDesc), this);
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
	private IAttrDesc getSd_care_veinpipeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_care_veinpipe",  getSd_care_veinpipeCDesc(tblDesc), this);
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
	private IAttrDesc getId_pipeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pipe",  getId_pipeCDesc(tblDesc), this);
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
	private IAttrDesc getSd_pipeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_pipe",  getSd_pipeCDesc(tblDesc), this);
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
	 * 管道性状属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pipe_stateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pipe_state",  getId_pipe_stateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("管道性状");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 管道性状编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_pipe_stateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_pipe_state",  getSd_pipe_stateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("管道性状编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 管道量（ml）属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPipe_volumeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pipe_volume",  getPipe_volumeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("管道量（ml）");
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
	private IAttrDesc getSupplementADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Supplement",  getSupplementCDesc(tblDesc), this);
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
	private IAttrDesc getIllcondchangesandsolveADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Illcondchangesandsolve",  getIllcondchangesandsolveCDesc(tblDesc), this);
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
	private IAttrDesc getId_signatureADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_signature",  getId_signatureCDesc(tblDesc), this);
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
	 * 疼痛分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPain_scoreADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pain_score",  getPain_scoreCDesc(tblDesc), this);
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
	 * 日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getD_recADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("D_rec",  getD_recCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("日期");
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
	private IAttrDesc getT_recADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("T_rec",  getT_recCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FTime);
		attrDesc.setLabel("时间");
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
	 * 静脉置管属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_veinpipeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_veinpipe",  getName_veinpipeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("静脉置管");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b4","id_veinpipe=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 置管护理属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_care_veinpipeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_care_veinpipe",  getName_care_veinpipeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("置管护理");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b10","id_care_veinpipe=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 管道名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_pipeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_pipe",  getName_pipeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("管道名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b5","id_pipe=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 管道性状属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_pipe_stateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_pipe_state",  getName_pipe_stateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("管道性状");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b11","id_pipe_state=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 签名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_signatureADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_signature",  getName_signatureCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("签名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a1b9","id_signature=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取外科患者记录单表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_sugeryipCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_sugeryip");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("外科患者记录单"); 
		return column;
	}
	/**
	 * 获取外科住院患者信息表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_patinfoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_patinfo");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("外科住院患者信息"); 
		return column;
	}
	/**
	 * 获取伤口表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWoundCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Wound");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("伤口"); 
		return column;
	}
	/**
	 * 获取静脉置管名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_veinpipeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_veinpipe");
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
	private IColumnDesc getSd_veinpipeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_veinpipe");
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
	private IColumnDesc getId_care_veinpipeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_care_veinpipe");
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
	private IColumnDesc getSd_care_veinpipeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_care_veinpipe");
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
	private IColumnDesc getId_pipeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pipe");
		column.setLength(2000);
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
	private IColumnDesc getSd_pipeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_pipe");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("管道名称编码"); 
		return column;
	}
	/**
	 * 获取管道性状表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pipe_stateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pipe_state");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("管道性状"); 
		return column;
	}
	/**
	 * 获取管道性状编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_pipe_stateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_pipe_state");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("管道性状编码"); 
		return column;
	}
	/**
	 * 获取管道量（ml）表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPipe_volumeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pipe_volume");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("管道量（ml）"); 
		return column;
	}
	/**
	 * 获取其他表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSupplementCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Supplement");
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
	private IColumnDesc getIllcondchangesandsolveCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Illcondchangesandsolve");
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
	private IColumnDesc getId_signatureCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_signature");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("签名"); 
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
	 * 获取疼痛分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPain_scoreCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pain_score");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("疼痛分"); 
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
	 * 获取日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getD_recCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"D_rec");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("日期"); 
		return column;
	}
	/**
	 * 获取时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getT_recCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"T_rec");
		column.setLength(8);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("时间"); 
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
	 * 获取静脉置管表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_veinpipeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_veinpipe");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("静脉置管"); 
		return column;
	}
	/**
	 * 获取置管护理表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_care_veinpipeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_care_veinpipe");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("置管护理"); 
		return column;
	}
	/**
	 * 获取管道名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_pipeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_pipe");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("管道名称"); 
		return column;
	}
	/**
	 * 获取管道性状表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_pipe_stateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_pipe_state");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("管道性状"); 
		return column;
	}
	/**
	 * 获取签名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_signatureCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_signature");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("签名"); 
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
