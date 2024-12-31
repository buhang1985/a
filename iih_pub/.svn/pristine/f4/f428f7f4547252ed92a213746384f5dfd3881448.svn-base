
package iih.nmr.pkuf.laborprorecord.d.desc;

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
 * 产程观察记录 DO 元数据信息
 */
public class LaborprorecorditmDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.nmr.pkuf.laborprorecord.d.LaborprorecorditmDO";
	public static final String CLASS_DISPALYNAME = "产程观察记录";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "NMR_PKUF_LABREC";
	public static final String TABLE_ALIAS_NAME = "a1";
	public static final String PRIMARYKEY_FIELDNAME="Id_laborprorecorditm";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public LaborprorecorditmDODesc(){
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
		this.setKeyDesc(getId_laborprorecorditmADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_puerperainfoADesc(tblDesc));
		this.add(getId_laborprorecorditmADesc(tblDesc));
		this.add(getId_puerperainfoADesc(tblDesc));
		this.add(getDt_datetimeADesc(tblDesc));
		this.add(getRate_fhrADesc(tblDesc));
		this.add(getInt_sbpADesc(tblDesc));
		this.add(getInt_dbpADesc(tblDesc));
		this.add(getNum_concentrationADesc(tblDesc));
		this.add(getNum_speedADesc(tblDesc));
		this.add(getPresentationADesc(tblDesc));
		this.add(getPresentation_positionADesc(tblDesc));
		this.add(getNum_highlowADesc(tblDesc));
		this.add(getDt_contra_ctinuADesc(tblDesc));
		this.add(getDt_contra_intervalADesc(tblDesc));
		this.add(getScore_painADesc(tblDesc));
		this.add(getUterine_contractionADesc(tblDesc));
		this.add(getNum_cvldilaADesc(tblDesc));
		this.add(getCervical_thicknessADesc(tblDesc));
		this.add(getId_positionoffetusADesc(tblDesc));
		this.add(getSd_positionoffetusADesc(tblDesc));
		this.add(getFetal_membranesADesc(tblDesc));
		this.add(getId_exmmethodADesc(tblDesc));
		this.add(getSd_exmmethodADesc(tblDesc));
		this.add(getVagina_examADesc(tblDesc));
		this.add(getAnal_examADesc(tblDesc));
		this.add(getId_fetal_deliveryADesc(tblDesc));
		this.add(getSd_fetal_deliveryADesc(tblDesc));
		this.add(getDes_observehandleADesc(tblDesc));
		this.add(getId_signADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getName_posiADesc(tblDesc));
		this.add(getName_exmmethodADesc(tblDesc));
		this.add(getName_fetal_deliveryADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_laborprorecorditmCDesc(tblDesc));
		tblDesc.add(getId_laborprorecorditmCDesc(tblDesc));
		tblDesc.add(getId_puerperainfoCDesc(tblDesc));
		tblDesc.add(getDt_datetimeCDesc(tblDesc));
		tblDesc.add(getRate_fhrCDesc(tblDesc));
		tblDesc.add(getInt_sbpCDesc(tblDesc));
		tblDesc.add(getInt_dbpCDesc(tblDesc));
		tblDesc.add(getNum_concentrationCDesc(tblDesc));
		tblDesc.add(getNum_speedCDesc(tblDesc));
		tblDesc.add(getPresentationCDesc(tblDesc));
		tblDesc.add(getPresentation_positionCDesc(tblDesc));
		tblDesc.add(getNum_highlowCDesc(tblDesc));
		tblDesc.add(getDt_contra_ctinuCDesc(tblDesc));
		tblDesc.add(getDt_contra_intervalCDesc(tblDesc));
		tblDesc.add(getScore_painCDesc(tblDesc));
		tblDesc.add(getUterine_contractionCDesc(tblDesc));
		tblDesc.add(getNum_cvldilaCDesc(tblDesc));
		tblDesc.add(getCervical_thicknessCDesc(tblDesc));
		tblDesc.add(getId_positionoffetusCDesc(tblDesc));
		tblDesc.add(getSd_positionoffetusCDesc(tblDesc));
		tblDesc.add(getFetal_membranesCDesc(tblDesc));
		tblDesc.add(getId_exmmethodCDesc(tblDesc));
		tblDesc.add(getSd_exmmethodCDesc(tblDesc));
		tblDesc.add(getVagina_examCDesc(tblDesc));
		tblDesc.add(getAnal_examCDesc(tblDesc));
		tblDesc.add(getId_fetal_deliveryCDesc(tblDesc));
		tblDesc.add(getSd_fetal_deliveryCDesc(tblDesc));
		tblDesc.add(getDes_observehandleCDesc(tblDesc));
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
	 * 产程观察护理记录单项ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_laborprorecorditmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_laborprorecorditm",  getId_laborprorecorditmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("产程观察护理记录单项ID");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 产程观察护理记录单ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_puerperainfoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_puerperainfo",  getId_puerperainfoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("产程观察护理记录单ID");
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
	private IAttrDesc getDt_datetimeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_datetime",  getDt_datetimeCDesc(tblDesc), this);
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
	 * 胎心率属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRate_fhrADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Rate_fhr",  getRate_fhrCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("胎心率");
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
	private IAttrDesc getInt_sbpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Int_sbp",  getInt_sbpCDesc(tblDesc), this);
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
	private IAttrDesc getInt_dbpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Int_dbp",  getInt_dbpCDesc(tblDesc), this);
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
	 * 浓度属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNum_concentrationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Num_concentration",  getNum_concentrationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("浓度");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 滴速属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNum_speedADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Num_speed",  getNum_speedCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("滴速");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 先露属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPresentationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Presentation",  getPresentationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("先露");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 先露位置属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPresentation_positionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Presentation_position",  getPresentation_positionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("先露位置");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 先露高低属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNum_highlowADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Num_highlow",  getNum_highlowCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("先露高低");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 阵缩间隔时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_contra_ctinuADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_contra_ctinu",  getDt_contra_ctinuCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("阵缩间隔时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 阵缩持续时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_contra_intervalADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_contra_interval",  getDt_contra_intervalCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("阵缩持续时间");
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
	private IAttrDesc getScore_painADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Score_pain",  getScore_painCDesc(tblDesc), this);
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
	 * 宫缩属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getUterine_contractionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Uterine_contraction",  getUterine_contractionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("宫缩");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 宫颈扩张属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNum_cvldilaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Num_cvldila",  getNum_cvldilaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("宫颈扩张");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 宫颈硬度属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCervical_thicknessADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Cervical_thickness",  getCervical_thicknessCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("宫颈硬度");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 胎方位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_positionoffetusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_positionoffetus",  getId_positionoffetusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("胎方位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 胎方位编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_positionoffetusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_positionoffetus",  getSd_positionoffetusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("胎方位编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 胎膜属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFetal_membranesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fetal_membranes",  getFetal_membranesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("胎膜");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 检查方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_exmmethodADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_exmmethod",  getId_exmmethodCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("检查方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 检查方式编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_exmmethodADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_exmmethod",  getSd_exmmethodCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("检查方式编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 检查阴道属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getVagina_examADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Vagina_exam",  getVagina_examCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("检查阴道");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 检查肛门属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAnal_examADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Anal_exam",  getAnal_examCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("检查肛门");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 娩出标记属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_fetal_deliveryADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_fetal_delivery",  getId_fetal_deliveryCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("娩出标记");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 娩出标记编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_fetal_deliveryADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_fetal_delivery",  getSd_fetal_deliveryCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("娩出标记编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 观察及处置属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDes_observehandleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Des_observehandle",  getDes_observehandleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("观察及处置");
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
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_posiADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_posi",  getName_posiCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b4","id_positionoffetus=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_exmmethodADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_exmmethod",  getName_exmmethodCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b8","id_exmmethod=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_fetal_deliveryADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_fetal_delivery",  getName_fetal_deliveryCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b7","id_fetal_delivery=id_udidoc","name"});
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
	 * 获取产程观察护理记录单项ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_laborprorecorditmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_laborprorecorditm");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("产程观察护理记录单项ID"); 
		return column;
	}
	/**
	 * 获取产程观察护理记录单ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_puerperainfoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_puerperainfo");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("产程观察护理记录单ID"); 
		return column;
	}
	/**
	 * 获取日期时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_datetimeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_datetime");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("日期时间"); 
		return column;
	}
	/**
	 * 获取胎心率表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRate_fhrCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Rate_fhr");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("胎心率"); 
		return column;
	}
	/**
	 * 获取收缩压表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInt_sbpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Int_sbp");
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
	private IColumnDesc getInt_dbpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Int_dbp");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("舒张压"); 
		return column;
	}
	/**
	 * 获取浓度表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNum_concentrationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Num_concentration");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("浓度"); 
		return column;
	}
	/**
	 * 获取滴速表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNum_speedCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Num_speed");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("滴速"); 
		return column;
	}
	/**
	 * 获取先露表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPresentationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Presentation");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("先露"); 
		return column;
	}
	/**
	 * 获取先露位置表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPresentation_positionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Presentation_position");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("先露位置"); 
		return column;
	}
	/**
	 * 获取先露高低表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNum_highlowCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Num_highlow");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("先露高低"); 
		return column;
	}
	/**
	 * 获取阵缩间隔时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_contra_ctinuCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_contra_ctinu");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("阵缩间隔时间"); 
		return column;
	}
	/**
	 * 获取阵缩持续时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_contra_intervalCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_contra_interval");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("阵缩持续时间"); 
		return column;
	}
	/**
	 * 获取疼痛分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getScore_painCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Score_pain");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("疼痛分"); 
		return column;
	}
	/**
	 * 获取宫缩表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getUterine_contractionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Uterine_contraction");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("宫缩"); 
		return column;
	}
	/**
	 * 获取宫颈扩张表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNum_cvldilaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Num_cvldila");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("宫颈扩张"); 
		return column;
	}
	/**
	 * 获取宫颈硬度表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCervical_thicknessCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Cervical_thickness");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("宫颈硬度"); 
		return column;
	}
	/**
	 * 获取胎方位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_positionoffetusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_positionoffetus");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("胎方位"); 
		return column;
	}
	/**
	 * 获取胎方位编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_positionoffetusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_positionoffetus");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("胎方位编码"); 
		return column;
	}
	/**
	 * 获取胎膜表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFetal_membranesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fetal_membranes");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("胎膜"); 
		return column;
	}
	/**
	 * 获取检查方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_exmmethodCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_exmmethod");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("检查方式"); 
		return column;
	}
	/**
	 * 获取检查方式编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_exmmethodCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_exmmethod");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("检查方式编码"); 
		return column;
	}
	/**
	 * 获取检查阴道表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getVagina_examCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Vagina_exam");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("检查阴道"); 
		return column;
	}
	/**
	 * 获取检查肛门表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAnal_examCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Anal_exam");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("检查肛门"); 
		return column;
	}
	/**
	 * 获取娩出标记表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_fetal_deliveryCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_fetal_delivery");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("娩出标记"); 
		return column;
	}
	/**
	 * 获取娩出标记编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_fetal_deliveryCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_fetal_delivery");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("娩出标记编码"); 
		return column;
	}
	/**
	 * 获取观察及处置表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDes_observehandleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Des_observehandle");
		column.setLength(2000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("观察及处置"); 
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
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_posiCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_posi");
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
	private IColumnDesc getName_exmmethodCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_exmmethod");
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
	private IColumnDesc getName_fetal_deliveryCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_fetal_delivery");
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
	
	/**
	 * 设置实体默认值
	 */
	private void setDefaultValueMap(){
		defaultValueMap=new HashMap<String, Object>();
	}
	
}
