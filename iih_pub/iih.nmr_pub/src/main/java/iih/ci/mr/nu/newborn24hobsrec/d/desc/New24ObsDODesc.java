
package iih.ci.mr.nu.newborn24hobsrec.d.desc;

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
 * 观察记录单内容 DO 元数据信息
 */
public class New24ObsDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.ci.mr.nu.newborn24hobsrec.d.New24ObsDO";
	public static final String CLASS_DISPALYNAME = "观察记录单内容";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "MR_NU_NEW24OBS";
	public static final String TABLE_ALIAS_NAME = "a1";
	public static final String PRIMARYKEY_FIELDNAME="Id_obsrec";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public New24ObsDODesc(){
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
		this.setKeyDesc(getId_obsrecADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.setFKeyDesc(getId_patinfoADesc(tblDesc));
		this.add(getId_obsrecADesc(tblDesc));
		this.add(getId_patinfoADesc(tblDesc));
		this.add(getNo_recADesc(tblDesc));
		this.add(getT_newbornADesc(tblDesc));
		this.add(getId_face_colorADesc(tblDesc));
		this.add(getSd_face_colorADesc(tblDesc));
		this.add(getId_cry_soundADesc(tblDesc));
		this.add(getSd_cry_soundADesc(tblDesc));
		this.add(getId_breathADesc(tblDesc));
		this.add(getSd_breathADesc(tblDesc));
		this.add(getEn_outputADesc(tblDesc));
		this.add(getBaby_suckADesc(tblDesc));
		this.add(getId_shit_statusADesc(tblDesc));
		this.add(getSd_shit_statusADesc(tblDesc));
		this.add(getEn_shit_volumeADesc(tblDesc));
		this.add(getUrine_outADesc(tblDesc));
		this.add(getNum_vomitADesc(tblDesc));
		this.add(getId_vomit_statusADesc(tblDesc));
		this.add(getSd_vomit_statusADesc(tblDesc));
		this.add(getEn_vomit_volumeADesc(tblDesc));
		this.add(getOxygen_inADesc(tblDesc));
		this.add(getDes_handleADesc(tblDesc));
		this.add(getId_sigADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getName_face_colorADesc(tblDesc));
		this.add(getName_cry_soundADesc(tblDesc));
		this.add(getName_breathADesc(tblDesc));
		this.add(getName_shit_statusADesc(tblDesc));
		this.add(getName_vomit_statusADesc(tblDesc));
		this.add(getName_sigADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_obsrecCDesc(tblDesc));
		tblDesc.add(getId_obsrecCDesc(tblDesc));
		tblDesc.add(getId_patinfoCDesc(tblDesc));
		tblDesc.add(getNo_recCDesc(tblDesc));
		tblDesc.add(getT_newbornCDesc(tblDesc));
		tblDesc.add(getId_face_colorCDesc(tblDesc));
		tblDesc.add(getSd_face_colorCDesc(tblDesc));
		tblDesc.add(getId_cry_soundCDesc(tblDesc));
		tblDesc.add(getSd_cry_soundCDesc(tblDesc));
		tblDesc.add(getId_breathCDesc(tblDesc));
		tblDesc.add(getSd_breathCDesc(tblDesc));
		tblDesc.add(getEn_outputCDesc(tblDesc));
		tblDesc.add(getBaby_suckCDesc(tblDesc));
		tblDesc.add(getId_shit_statusCDesc(tblDesc));
		tblDesc.add(getSd_shit_statusCDesc(tblDesc));
		tblDesc.add(getEn_shit_volumeCDesc(tblDesc));
		tblDesc.add(getUrine_outCDesc(tblDesc));
		tblDesc.add(getNum_vomitCDesc(tblDesc));
		tblDesc.add(getId_vomit_statusCDesc(tblDesc));
		tblDesc.add(getSd_vomit_statusCDesc(tblDesc));
		tblDesc.add(getEn_vomit_volumeCDesc(tblDesc));
		tblDesc.add(getOxygen_inCDesc(tblDesc));
		tblDesc.add(getDes_handleCDesc(tblDesc));
		tblDesc.add(getId_sigCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 观察记录单ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_obsrecADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_obsrec",  getId_obsrecCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("观察记录单ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 新生儿基本信息ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_patinfoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_patinfo",  getId_patinfoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("新生儿基本信息ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 序号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNo_recADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("No_rec",  getNo_recCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("序号");
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
	private IAttrDesc getT_newbornADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("T_newborn",  getT_newbornCDesc(tblDesc), this);
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
	 * 面色属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_face_colorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_face_color",  getId_face_colorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("面色");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 面色编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_face_colorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_face_color",  getSd_face_colorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("面色编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 哭声属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_cry_soundADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_cry_sound",  getId_cry_soundCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("哭声");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 哭声编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_cry_soundADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_cry_sound",  getSd_cry_soundCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("哭声编码");
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
	private IAttrDesc getId_breathADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_breath",  getId_breathCDesc(tblDesc), this);
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
	private IAttrDesc getSd_breathADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_breath",  getSd_breathCDesc(tblDesc), this);
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
	 * 脐出血属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEn_outputADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("En_output",  getEn_outputCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("脐出血");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 吸吮属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBaby_suckADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Baby_suck",  getBaby_suckCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("吸吮");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 大便性质属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_shit_statusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_shit_status",  getId_shit_statusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("大便性质");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 大便性质编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_shit_statusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_shit_status",  getSd_shit_statusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("大便性质编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 大便量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEn_shit_volumeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("En_shit_volume",  getEn_shit_volumeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("大便量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 解尿属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getUrine_outADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Urine_out",  getUrine_outCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("解尿");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 呕吐次数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNum_vomitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Num_vomit",  getNum_vomitCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("呕吐次数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 呕吐性质属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_vomit_statusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_vomit_status",  getId_vomit_statusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("呕吐性质");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 呕吐性质编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_vomit_statusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_vomit_status",  getSd_vomit_statusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("呕吐性质编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 呕吐量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEn_vomit_volumeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("En_vomit_volume",  getEn_vomit_volumeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("呕吐量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 氧气吸入属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOxygen_inADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Oxygen_in",  getOxygen_inCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("氧气吸入");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 病情观察及处理属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDes_handleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Des_handle",  getDes_handleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病情观察及处理");
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
	 * 面色属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_face_colorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_face_color",  getName_face_colorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("面色");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b9","id_face_color=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 哭声属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_cry_soundADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_cry_sound",  getName_cry_soundCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("哭声");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b3","id_cry_sound=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 呼吸属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_breathADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_breath",  getName_breathCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("呼吸");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b4","id_breath=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 大便性质属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_shit_statusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_shit_status",  getName_shit_statusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("大便性质");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b5","id_shit_status=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 呕吐性质属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_vomit_statusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_vomit_status",  getName_vomit_statusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("呕吐性质");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b6","id_vomit_status=id_udidoc","name"});
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
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a1b10","id_sig=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取观察记录单ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_obsrecCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_obsrec");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("观察记录单ID"); 
		return column;
	}
	/**
	 * 获取新生儿基本信息ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_patinfoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_patinfo");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("新生儿基本信息ID"); 
		return column;
	}
	/**
	 * 获取序号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNo_recCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"No_rec");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("序号"); 
		return column;
	}
	/**
	 * 获取时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getT_newbornCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"T_newborn");
		column.setLength(8);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("时间"); 
		return column;
	}
	/**
	 * 获取面色表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_face_colorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_face_color");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("面色"); 
		return column;
	}
	/**
	 * 获取面色编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_face_colorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_face_color");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("面色编码"); 
		return column;
	}
	/**
	 * 获取哭声表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_cry_soundCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_cry_sound");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("哭声"); 
		return column;
	}
	/**
	 * 获取哭声编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_cry_soundCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_cry_sound");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("哭声编码"); 
		return column;
	}
	/**
	 * 获取呼吸表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_breathCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_breath");
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
	private IColumnDesc getSd_breathCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_breath");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("呼吸编码"); 
		return column;
	}
	/**
	 * 获取脐出血表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEn_outputCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"En_output");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("脐出血"); 
		return column;
	}
	/**
	 * 获取吸吮表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBaby_suckCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Baby_suck");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("吸吮"); 
		return column;
	}
	/**
	 * 获取大便性质表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_shit_statusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_shit_status");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("大便性质"); 
		return column;
	}
	/**
	 * 获取大便性质编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_shit_statusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_shit_status");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("大便性质编码"); 
		return column;
	}
	/**
	 * 获取大便量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEn_shit_volumeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"En_shit_volume");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("大便量"); 
		return column;
	}
	/**
	 * 获取解尿表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getUrine_outCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Urine_out");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("解尿"); 
		return column;
	}
	/**
	 * 获取呕吐次数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNum_vomitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Num_vomit");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("呕吐次数"); 
		return column;
	}
	/**
	 * 获取呕吐性质表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_vomit_statusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_vomit_status");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("呕吐性质"); 
		return column;
	}
	/**
	 * 获取呕吐性质编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_vomit_statusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_vomit_status");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("呕吐性质编码"); 
		return column;
	}
	/**
	 * 获取呕吐量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEn_vomit_volumeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"En_vomit_volume");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("呕吐量"); 
		return column;
	}
	/**
	 * 获取氧气吸入表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOxygen_inCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Oxygen_in");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("氧气吸入"); 
		return column;
	}
	/**
	 * 获取病情观察及处理表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDes_handleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Des_handle");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病情观察及处理"); 
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
	 * 获取面色表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_face_colorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_face_color");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("面色"); 
		return column;
	}
	/**
	 * 获取哭声表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_cry_soundCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_cry_sound");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("哭声"); 
		return column;
	}
	/**
	 * 获取呼吸表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_breathCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_breath");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("呼吸"); 
		return column;
	}
	/**
	 * 获取大便性质表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_shit_statusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_shit_status");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("大便性质"); 
		return column;
	}
	/**
	 * 获取呕吐性质表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_vomit_statusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_vomit_status");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("呕吐性质"); 
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
