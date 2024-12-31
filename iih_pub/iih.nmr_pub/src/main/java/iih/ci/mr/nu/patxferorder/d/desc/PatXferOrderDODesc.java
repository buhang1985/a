
package iih.ci.mr.nu.patxferorder.d.desc;

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
 * 患者转运交接单 DO 元数据信息
 */
public class PatXferOrderDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.ci.mr.nu.patxferorder.d.PatXferOrderDO";
	public static final String CLASS_DISPALYNAME = "患者转运交接单";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "MR_NU_PATXFERORDER";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_pat_xfer";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public PatXferOrderDODesc(){
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
		this.setKeyDesc(getId_pat_xferADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.add(getId_pat_xferADesc(tblDesc));
		this.add(getId_dep_rcvADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getRcv_telADesc(tblDesc));
		this.add(getId_psn_rcvADesc(tblDesc));
		this.add(getInfu_drugADesc(tblDesc));
		this.add(getBedsore_posADesc(tblDesc));
		this.add(getId_patADesc(tblDesc));
		this.add(getId_entADesc(tblDesc));
		this.add(getName_patADesc(tblDesc));
		this.add(getAgeADesc(tblDesc));
		this.add(getName_sexADesc(tblDesc));
		this.add(getNum_passADesc(tblDesc));
		this.add(getHeartrate_outADesc(tblDesc));
		this.add(getBreath_outADesc(tblDesc));
		this.add(getSys_pre_outADesc(tblDesc));
		this.add(getDia_pre_outADesc(tblDesc));
		this.add(getSpo2_outADesc(tblDesc));
		this.add(getDt_outADesc(tblDesc));
		this.add(getDt_rcvdADesc(tblDesc));
		this.add(getId_wound_coverADesc(tblDesc));
		this.add(getSd_wound_coverADesc(tblDesc));
		this.add(getId_drain_tubeADesc(tblDesc));
		this.add(getSd_drain_tubeADesc(tblDesc));
		this.add(getId_drain_freeADesc(tblDesc));
		this.add(getSd_drain_freeADesc(tblDesc));
		this.add(getId_follow_psnADesc(tblDesc));
		this.add(getSd_follow_psnADesc(tblDesc));
		this.add(getId_xfer_tpADesc(tblDesc));
		this.add(getSd_xfer_tpADesc(tblDesc));
		this.add(getId_rescue_fcltADesc(tblDesc));
		this.add(getSd_rescue_fcltADesc(tblDesc));
		this.add(getId_infu_blockADesc(tblDesc));
		this.add(getSd_infu_blockADesc(tblDesc));
		this.add(getId_infu_tpADesc(tblDesc));
		this.add(getSd_infu_tpADesc(tblDesc));
		this.add(getEu_bedsoreADesc(tblDesc));
		this.add(getEu_infu_freeADesc(tblDesc));
		this.add(getEn_drain_usedADesc(tblDesc));
		this.add(getEu_infu_stateADesc(tblDesc));
		this.add(getId_rcv_sigADesc(tblDesc));
		this.add(getSupplementADesc(tblDesc));
		this.add(getFg_rcd_ownerADesc(tblDesc));
		this.add(getOther_follow_psnADesc(tblDesc));
		this.add(getOther_xfer_tpADesc(tblDesc));
		this.add(getOther_infu_tpADesc(tblDesc));
		this.add(getOther_rescue_fcltADesc(tblDesc));
		this.add(getOther_drain_tubeADesc(tblDesc));
		this.add(getHeartrate_inADesc(tblDesc));
		this.add(getBreath_inADesc(tblDesc));
		this.add(getSys_pre_inADesc(tblDesc));
		this.add(getDia_pre_inADesc(tblDesc));
		this.add(getSpo2_inADesc(tblDesc));
		this.add(getName_pat_sigADesc(tblDesc));
		this.add(getId_xfer_sigADesc(tblDesc));
		this.add(getDt_aceptADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getId_signatureADesc(tblDesc));
		this.add(getName_dep_rcvADesc(tblDesc));
		this.add(getName_psn_rcvADesc(tblDesc));
		this.add(getName_wound_coverADesc(tblDesc));
		this.add(getName_drain_tubeADesc(tblDesc));
		this.add(getName_drain_freeADesc(tblDesc));
		this.add(getName_follow_psnADesc(tblDesc));
		this.add(getName_xfer_tpADesc(tblDesc));
		this.add(getName_rescue_fcltADesc(tblDesc));
		this.add(getName_infu_blockADesc(tblDesc));
		this.add(getName_infu_tpADesc(tblDesc));
		this.add(getName_rcv_sigADesc(tblDesc));
		this.add(getName_xfer_sigADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_pat_xferCDesc(tblDesc));
		tblDesc.add(getId_pat_xferCDesc(tblDesc));
		tblDesc.add(getId_dep_rcvCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getRcv_telCDesc(tblDesc));
		tblDesc.add(getId_psn_rcvCDesc(tblDesc));
		tblDesc.add(getInfu_drugCDesc(tblDesc));
		tblDesc.add(getBedsore_posCDesc(tblDesc));
		tblDesc.add(getId_patCDesc(tblDesc));
		tblDesc.add(getId_entCDesc(tblDesc));
		tblDesc.add(getName_patCDesc(tblDesc));
		tblDesc.add(getAgeCDesc(tblDesc));
		tblDesc.add(getName_sexCDesc(tblDesc));
		tblDesc.add(getNum_passCDesc(tblDesc));
		tblDesc.add(getHeartrate_outCDesc(tblDesc));
		tblDesc.add(getBreath_outCDesc(tblDesc));
		tblDesc.add(getSys_pre_outCDesc(tblDesc));
		tblDesc.add(getDia_pre_outCDesc(tblDesc));
		tblDesc.add(getSpo2_outCDesc(tblDesc));
		tblDesc.add(getDt_outCDesc(tblDesc));
		tblDesc.add(getDt_rcvdCDesc(tblDesc));
		tblDesc.add(getId_wound_coverCDesc(tblDesc));
		tblDesc.add(getSd_wound_coverCDesc(tblDesc));
		tblDesc.add(getId_drain_tubeCDesc(tblDesc));
		tblDesc.add(getSd_drain_tubeCDesc(tblDesc));
		tblDesc.add(getId_drain_freeCDesc(tblDesc));
		tblDesc.add(getSd_drain_freeCDesc(tblDesc));
		tblDesc.add(getId_follow_psnCDesc(tblDesc));
		tblDesc.add(getSd_follow_psnCDesc(tblDesc));
		tblDesc.add(getId_xfer_tpCDesc(tblDesc));
		tblDesc.add(getSd_xfer_tpCDesc(tblDesc));
		tblDesc.add(getId_rescue_fcltCDesc(tblDesc));
		tblDesc.add(getSd_rescue_fcltCDesc(tblDesc));
		tblDesc.add(getId_infu_blockCDesc(tblDesc));
		tblDesc.add(getSd_infu_blockCDesc(tblDesc));
		tblDesc.add(getId_infu_tpCDesc(tblDesc));
		tblDesc.add(getSd_infu_tpCDesc(tblDesc));
		tblDesc.add(getEu_bedsoreCDesc(tblDesc));
		tblDesc.add(getEu_infu_freeCDesc(tblDesc));
		tblDesc.add(getEn_drain_usedCDesc(tblDesc));
		tblDesc.add(getEu_infu_stateCDesc(tblDesc));
		tblDesc.add(getId_rcv_sigCDesc(tblDesc));
		tblDesc.add(getSupplementCDesc(tblDesc));
		tblDesc.add(getFg_rcd_ownerCDesc(tblDesc));
		tblDesc.add(getOther_follow_psnCDesc(tblDesc));
		tblDesc.add(getOther_xfer_tpCDesc(tblDesc));
		tblDesc.add(getOther_infu_tpCDesc(tblDesc));
		tblDesc.add(getOther_rescue_fcltCDesc(tblDesc));
		tblDesc.add(getOther_drain_tubeCDesc(tblDesc));
		tblDesc.add(getHeartrate_inCDesc(tblDesc));
		tblDesc.add(getBreath_inCDesc(tblDesc));
		tblDesc.add(getSys_pre_inCDesc(tblDesc));
		tblDesc.add(getDia_pre_inCDesc(tblDesc));
		tblDesc.add(getSpo2_inCDesc(tblDesc));
		tblDesc.add(getName_pat_sigCDesc(tblDesc));
		tblDesc.add(getId_xfer_sigCDesc(tblDesc));
		tblDesc.add(getDt_aceptCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		tblDesc.add(getId_signatureCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 患者转运交接单ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pat_xferADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pat_xfer",  getId_pat_xferCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者转运交接单ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 接收科室属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dep_rcvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep_rcv",  getId_dep_rcvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("接收科室");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 组织属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_orgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_org",  getId_orgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("组织");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 集团属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_grpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_grp",  getId_grpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("集团");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 联系电话属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRcv_telADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Rcv_tel",  getRcv_telCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("联系电话");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 接收电话人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_psn_rcvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_psn_rcv",  getId_psn_rcvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("接收电话人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 输注药物属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInfu_drugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Infu_drug",  getInfu_drugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("输注药物");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 褥疮部位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBedsore_posADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Bedsore_pos",  getBedsore_posCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("褥疮部位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_patADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pat",  getId_patCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 就诊ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_entADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ent",  getId_entCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("就诊ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_patADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_pat",  getName_patCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 年龄属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAgeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Age",  getAgeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("年龄");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 性别属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_sexADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_sex",  getName_sexCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("性别");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 通路数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNum_passADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Num_pass",  getNum_passCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("通路数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 出科心率属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHeartrate_outADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Heartrate_out",  getHeartrate_outCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("出科心率");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 出科呼吸属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBreath_outADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Breath_out",  getBreath_outCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("出科呼吸");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 出科收缩压属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSys_pre_outADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sys_pre_out",  getSys_pre_outCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("出科收缩压");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 出科舒张压属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDia_pre_outADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dia_pre_out",  getDia_pre_outCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("出科舒张压");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 出科SPO2属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSpo2_outADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Spo2_out",  getSpo2_outCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("出科SPO2");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 出科时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_outADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_out",  getDt_outCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("出科时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 到接收科时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_rcvdADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_rcvd",  getDt_rcvdCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("到接收科时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 伤口敷料属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_wound_coverADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_wound_cover",  getId_wound_coverCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("伤口敷料");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 伤口敷料编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_wound_coverADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_wound_cover",  getSd_wound_coverCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("伤口敷料编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 引流管属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_drain_tubeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_drain_tube",  getId_drain_tubeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("引流管");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 引流管编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_drain_tubeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_drain_tube",  getSd_drain_tubeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("引流管编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 通畅（引流管）属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_drain_freeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_drain_free",  getId_drain_freeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("通畅（引流管）");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 通畅（引流管）编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_drain_freeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_drain_free",  getSd_drain_freeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("通畅（引流管）编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 随送人员属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_follow_psnADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_follow_psn",  getId_follow_psnCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("随送人员");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 随送人员编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_follow_psnADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_follow_psn",  getSd_follow_psnCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("随送人员编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 转运方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_xfer_tpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_xfer_tp",  getId_xfer_tpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("转运方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 转运方式编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_xfer_tpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_xfer_tp",  getSd_xfer_tpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("转运方式编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 抢救设施属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_rescue_fcltADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_rescue_fclt",  getId_rescue_fcltCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("抢救设施");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 抢救设施编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_rescue_fcltADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_rescue_fclt",  getSd_rescue_fcltCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("抢救设施编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 输液通畅情况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_infu_blockADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_infu_block",  getId_infu_blockCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("输液通畅情况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 输液通畅情况编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_infu_blockADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_infu_block",  getSd_infu_blockCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("输液通畅情况编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 输液方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_infu_tpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_infu_tp",  getId_infu_tpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("输液方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 输液方式编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_infu_tpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_infu_tp",  getSd_infu_tpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("输液方式编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 褥疮属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_bedsoreADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_bedsore",  getEu_bedsoreCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("褥疮");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 通畅（输液）属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_infu_freeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_infu_free",  getEu_infu_freeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("通畅（输液）");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 引流管使用情况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEn_drain_usedADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("En_drain_used",  getEn_drain_usedCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("引流管使用情况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 输液情况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_infu_stateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_infu_state",  getEu_infu_stateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("输液情况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 接收护士签名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_rcv_sigADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_rcv_sig",  getId_rcv_sigCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("接收护士签名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 备注属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSupplementADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Supplement",  getSupplementCDesc(tblDesc), this);
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
	 * 就诊病历及检查资料归属属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_rcd_ownerADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_rcd_owner",  getFg_rcd_ownerCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("就诊病历及检查资料归属");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 其他随送人员属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOther_follow_psnADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Other_follow_psn",  getOther_follow_psnCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("其他随送人员");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 其他转运方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOther_xfer_tpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Other_xfer_tp",  getOther_xfer_tpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("其他转运方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 其他输液方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOther_infu_tpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Other_infu_tp",  getOther_infu_tpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("其他输液方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 其他抢救设施属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOther_rescue_fcltADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Other_rescue_fclt",  getOther_rescue_fcltCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("其他抢救设施");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 其他引流管属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOther_drain_tubeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Other_drain_tube",  getOther_drain_tubeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("其他引流管");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 入科心率属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHeartrate_inADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Heartrate_in",  getHeartrate_inCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("入科心率");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 入科呼吸属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBreath_inADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Breath_in",  getBreath_inCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("入科呼吸");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 入科收缩压属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSys_pre_inADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sys_pre_in",  getSys_pre_inCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("入科收缩压");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 入科舒张压属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDia_pre_inADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dia_pre_in",  getDia_pre_inCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("入科舒张压");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 入科SPO2属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSpo2_inADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Spo2_in",  getSpo2_inCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("入科SPO2");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者确认签名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_pat_sigADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_pat_sig",  getName_pat_sigCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者确认签名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 转科护士签名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_xfer_sigADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_xfer_sig",  getId_xfer_sigCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("转科护士签名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 到诊时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_aceptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_acept",  getDt_aceptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("到诊时间");
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
	 * 护士签名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_signatureADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_signature",  getId_signatureCDesc(tblDesc), this);
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
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dep_rcvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dep_rcv",  getName_dep_rcvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b2","id_dep_rcv=id_dep","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_psn_rcvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_psn_rcv",  getName_psn_rcvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b3","id_psn_rcv=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 伤口敷料属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_wound_coverADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_wound_cover",  getName_wound_coverCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("伤口敷料");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b31","id_wound_cover=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 引流管属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_drain_tubeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_drain_tube",  getName_drain_tubeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("引流管");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b32","id_drain_tube=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_drain_freeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_drain_free",  getName_drain_freeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b33","id_drain_free=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 随送人员属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_follow_psnADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_follow_psn",  getName_follow_psnCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("随送人员");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b34","id_follow_psn=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 转运方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_xfer_tpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_xfer_tp",  getName_xfer_tpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("转运方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b35","id_xfer_tp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 抢救设施属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_rescue_fcltADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_rescue_fclt",  getName_rescue_fcltCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("抢救设施");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b41","id_rescue_fclt=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 输液通畅情况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_infu_blockADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_infu_block",  getName_infu_blockCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("输液通畅情况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b37","id_infu_block=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 输液方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_infu_tpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_infu_tp",  getName_infu_tpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("输液方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b38","id_infu_tp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 接收护士签名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_rcv_sigADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_rcv_sig",  getName_rcv_sigCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("接收护士签名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b40","id_rcv_sig=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 转科护士签名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_xfer_sigADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_xfer_sig",  getName_xfer_sigCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("转科护士签名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b42","id_xfer_sig=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 护士签名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_signatureADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_signature",  getName_signatureCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("护士签名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b43","id_signature=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取患者转运交接单ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pat_xferCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pat_xfer");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者转运交接单ID"); 
		return column;
	}
	/**
	 * 获取接收科室表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dep_rcvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep_rcv");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("接收科室"); 
		return column;
	}
	/**
	 * 获取组织表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_orgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_org");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("组织"); 
		return column;
	}
	/**
	 * 获取集团表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_grpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_grp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("集团"); 
		return column;
	}
	/**
	 * 获取联系电话表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRcv_telCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Rcv_tel");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("联系电话"); 
		return column;
	}
	/**
	 * 获取接收电话人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_psn_rcvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_psn_rcv");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("接收电话人"); 
		return column;
	}
	/**
	 * 获取输注药物表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInfu_drugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Infu_drug");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("输注药物"); 
		return column;
	}
	/**
	 * 获取褥疮部位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBedsore_posCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Bedsore_pos");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("褥疮部位"); 
		return column;
	}
	/**
	 * 获取患者ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pat");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者ID"); 
		return column;
	}
	/**
	 * 获取就诊ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_entCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ent");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊ID"); 
		return column;
	}
	/**
	 * 获取患者姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_pat");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者姓名"); 
		return column;
	}
	/**
	 * 获取年龄表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAgeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Age");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("年龄"); 
		return column;
	}
	/**
	 * 获取性别表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_sexCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_sex");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("性别"); 
		return column;
	}
	/**
	 * 获取通路数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNum_passCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Num_pass");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("通路数"); 
		return column;
	}
	/**
	 * 获取出科心率表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHeartrate_outCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Heartrate_out");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("出科心率"); 
		return column;
	}
	/**
	 * 获取出科呼吸表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBreath_outCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Breath_out");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("出科呼吸"); 
		return column;
	}
	/**
	 * 获取出科收缩压表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSys_pre_outCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sys_pre_out");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("出科收缩压"); 
		return column;
	}
	/**
	 * 获取出科舒张压表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDia_pre_outCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dia_pre_out");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("出科舒张压"); 
		return column;
	}
	/**
	 * 获取出科SPO2表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSpo2_outCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Spo2_out");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("出科SPO2"); 
		return column;
	}
	/**
	 * 获取出科时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_outCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_out");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("出科时间"); 
		return column;
	}
	/**
	 * 获取到接收科时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_rcvdCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_rcvd");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("到接收科时间"); 
		return column;
	}
	/**
	 * 获取伤口敷料表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_wound_coverCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_wound_cover");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("伤口敷料"); 
		return column;
	}
	/**
	 * 获取伤口敷料编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_wound_coverCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_wound_cover");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("伤口敷料编码"); 
		return column;
	}
	/**
	 * 获取引流管表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_drain_tubeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_drain_tube");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("引流管"); 
		return column;
	}
	/**
	 * 获取引流管编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_drain_tubeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_drain_tube");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("引流管编码"); 
		return column;
	}
	/**
	 * 获取通畅（引流管）表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_drain_freeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_drain_free");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("通畅（引流管）"); 
		return column;
	}
	/**
	 * 获取通畅（引流管）编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_drain_freeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_drain_free");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("通畅（引流管）编码"); 
		return column;
	}
	/**
	 * 获取随送人员表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_follow_psnCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_follow_psn");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("随送人员"); 
		return column;
	}
	/**
	 * 获取随送人员编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_follow_psnCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_follow_psn");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("随送人员编码"); 
		return column;
	}
	/**
	 * 获取转运方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_xfer_tpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_xfer_tp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("转运方式"); 
		return column;
	}
	/**
	 * 获取转运方式编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_xfer_tpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_xfer_tp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("转运方式编码"); 
		return column;
	}
	/**
	 * 获取抢救设施表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_rescue_fcltCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_rescue_fclt");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("抢救设施"); 
		return column;
	}
	/**
	 * 获取抢救设施编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_rescue_fcltCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_rescue_fclt");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("抢救设施编码"); 
		return column;
	}
	/**
	 * 获取输液通畅情况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_infu_blockCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_infu_block");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("输液通畅情况"); 
		return column;
	}
	/**
	 * 获取输液通畅情况编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_infu_blockCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_infu_block");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("输液通畅情况编码"); 
		return column;
	}
	/**
	 * 获取输液方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_infu_tpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_infu_tp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("输液方式"); 
		return column;
	}
	/**
	 * 获取输液方式编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_infu_tpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_infu_tp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("输液方式编码"); 
		return column;
	}
	/**
	 * 获取褥疮表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_bedsoreCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_bedsore");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("褥疮"); 
		return column;
	}
	/**
	 * 获取通畅（输液）表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_infu_freeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_infu_free");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("通畅（输液）"); 
		return column;
	}
	/**
	 * 获取引流管使用情况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEn_drain_usedCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"En_drain_used");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("引流管使用情况"); 
		return column;
	}
	/**
	 * 获取输液情况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_infu_stateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_infu_state");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("输液情况"); 
		return column;
	}
	/**
	 * 获取接收护士签名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_rcv_sigCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_rcv_sig");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("接收护士签名"); 
		return column;
	}
	/**
	 * 获取备注表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSupplementCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Supplement");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备注"); 
		return column;
	}
	/**
	 * 获取就诊病历及检查资料归属表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_rcd_ownerCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_rcd_owner");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("就诊病历及检查资料归属"); 
		return column;
	}
	/**
	 * 获取其他随送人员表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOther_follow_psnCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Other_follow_psn");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("其他随送人员"); 
		return column;
	}
	/**
	 * 获取其他转运方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOther_xfer_tpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Other_xfer_tp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("其他转运方式"); 
		return column;
	}
	/**
	 * 获取其他输液方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOther_infu_tpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Other_infu_tp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("其他输液方式"); 
		return column;
	}
	/**
	 * 获取其他抢救设施表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOther_rescue_fcltCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Other_rescue_fclt");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("其他抢救设施"); 
		return column;
	}
	/**
	 * 获取其他引流管表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOther_drain_tubeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Other_drain_tube");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("其他引流管"); 
		return column;
	}
	/**
	 * 获取入科心率表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHeartrate_inCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Heartrate_in");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("入科心率"); 
		return column;
	}
	/**
	 * 获取入科呼吸表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBreath_inCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Breath_in");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("入科呼吸"); 
		return column;
	}
	/**
	 * 获取入科收缩压表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSys_pre_inCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sys_pre_in");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("入科收缩压"); 
		return column;
	}
	/**
	 * 获取入科舒张压表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDia_pre_inCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dia_pre_in");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("入科舒张压"); 
		return column;
	}
	/**
	 * 获取入科SPO2表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSpo2_inCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Spo2_in");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("入科SPO2"); 
		return column;
	}
	/**
	 * 获取患者确认签名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_pat_sigCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_pat_sig");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者确认签名"); 
		return column;
	}
	/**
	 * 获取转科护士签名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_xfer_sigCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_xfer_sig");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("转科护士签名"); 
		return column;
	}
	/**
	 * 获取到诊时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_aceptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_acept");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("到诊时间"); 
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
	 * 获取护士签名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_signatureCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_signature");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("护士签名"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_dep_rcvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dep_rcv");
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
	private IColumnDesc getName_psn_rcvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_psn_rcv");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("姓名"); 
		return column;
	}
	/**
	 * 获取伤口敷料表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_wound_coverCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_wound_cover");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("伤口敷料"); 
		return column;
	}
	/**
	 * 获取引流管表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_drain_tubeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_drain_tube");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("引流管"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_drain_freeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_drain_free");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取随送人员表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_follow_psnCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_follow_psn");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("随送人员"); 
		return column;
	}
	/**
	 * 获取转运方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_xfer_tpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_xfer_tp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("转运方式"); 
		return column;
	}
	/**
	 * 获取抢救设施表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_rescue_fcltCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_rescue_fclt");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("抢救设施"); 
		return column;
	}
	/**
	 * 获取输液通畅情况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_infu_blockCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_infu_block");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("输液通畅情况"); 
		return column;
	}
	/**
	 * 获取输液方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_infu_tpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_infu_tp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("输液方式"); 
		return column;
	}
	/**
	 * 获取接收护士签名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_rcv_sigCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_rcv_sig");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("接收护士签名"); 
		return column;
	}
	/**
	 * 获取转科护士签名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_xfer_sigCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_xfer_sig");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("转科护士签名"); 
		return column;
	}
	/**
	 * 获取护士签名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_signatureCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_signature");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("护士签名"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id_org","Id_org");
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
	
}
