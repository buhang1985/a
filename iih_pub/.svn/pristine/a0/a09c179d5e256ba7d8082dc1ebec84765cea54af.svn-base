
package iih.ci.mr.nu.pipesliprisk.d.desc;

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
 * 管道滑脱风险患者信息 DO 元数据信息
 */
public class PipeSlipRiskDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.ci.mr.nu.pipesliprisk.d.PipeSlipRiskDO";
	public static final String CLASS_DISPALYNAME = "管道滑脱风险患者信息";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "MR_NU_PIPESLIPRISK";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_pipesliprisk";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public PipeSlipRiskDODesc(){
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
		this.setKeyDesc(getId_pipeslipriskADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.add(getId_pipeslipriskADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_entADesc(tblDesc));
		this.add(getId_patADesc(tblDesc));
		this.add(getName_patADesc(tblDesc));
		this.add(getName_dep_nurADesc(tblDesc));
		this.add(getName_bedADesc(tblDesc));
		this.add(getAgeADesc(tblDesc));
		this.add(getCode_amr_ipADesc(tblDesc));
		this.add(getId_diagnosisADesc(tblDesc));
		this.add(getName_diagnosisADesc(tblDesc));
		this.add(getName_sexADesc(tblDesc));
		this.add(getId_nurseADesc(tblDesc));
		this.add(getName_dep_phyADesc(tblDesc));
		this.add(getDt_evaluateADesc(tblDesc));
		this.add(getId_agerangeADesc(tblDesc));
		this.add(getSd_agerangeADesc(tblDesc));
		this.add(getScore_agerangeADesc(tblDesc));
		this.add(getId_awarenessADesc(tblDesc));
		this.add(getSd_awarenessADesc(tblDesc));
		this.add(getScore_awarenessADesc(tblDesc));
		this.add(getId_mindADesc(tblDesc));
		this.add(getSd_mindADesc(tblDesc));
		this.add(getScore_mindADesc(tblDesc));
		this.add(getId_activityADesc(tblDesc));
		this.add(getSd_activityADesc(tblDesc));
		this.add(getScore_activityADesc(tblDesc));
		this.add(getId_pipe_firsttpADesc(tblDesc));
		this.add(getSd_pipe_firsttpADesc(tblDesc));
		this.add(getPipe_firstotherADesc(tblDesc));
		this.add(getId_pipe_secondtpADesc(tblDesc));
		this.add(getSd_pipe_secondtpADesc(tblDesc));
		this.add(getPipe_secondotherADesc(tblDesc));
		this.add(getId_pipe_thirdtpADesc(tblDesc));
		this.add(getSd_pipe_thirdtpADesc(tblDesc));
		this.add(getPipe_thirdotherADesc(tblDesc));
		this.add(getScore_pipetpADesc(tblDesc));
		this.add(getId_painADesc(tblDesc));
		this.add(getSd_painADesc(tblDesc));
		this.add(getScore_painADesc(tblDesc));
		this.add(getId_communicatADesc(tblDesc));
		this.add(getSd_communicatADesc(tblDesc));
		this.add(getScore_communicatADesc(tblDesc));
		this.add(getId_nursmeasureADesc(tblDesc));
		this.add(getSd_nursmeasureADesc(tblDesc));
		this.add(getScore_totalADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getName_nurseADesc(tblDesc));
		this.add(getName_agerangeADesc(tblDesc));
		this.add(getName_awarenessADesc(tblDesc));
		this.add(getName_mindADesc(tblDesc));
		this.add(getName_activityADesc(tblDesc));
		this.add(getName_pipe_firsttpADesc(tblDesc));
		this.add(getName_pipe_secondtpADesc(tblDesc));
		this.add(getName_pipe_thirdtpADesc(tblDesc));
		this.add(getName_painADesc(tblDesc));
		this.add(getName_communicatADesc(tblDesc));
		this.add(getName_nursmeasureADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_pipeslipriskCDesc(tblDesc));
		tblDesc.add(getId_pipeslipriskCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_entCDesc(tblDesc));
		tblDesc.add(getId_patCDesc(tblDesc));
		tblDesc.add(getName_patCDesc(tblDesc));
		tblDesc.add(getName_dep_nurCDesc(tblDesc));
		tblDesc.add(getName_bedCDesc(tblDesc));
		tblDesc.add(getAgeCDesc(tblDesc));
		tblDesc.add(getCode_amr_ipCDesc(tblDesc));
		tblDesc.add(getId_diagnosisCDesc(tblDesc));
		tblDesc.add(getName_diagnosisCDesc(tblDesc));
		tblDesc.add(getName_sexCDesc(tblDesc));
		tblDesc.add(getId_nurseCDesc(tblDesc));
		tblDesc.add(getName_dep_phyCDesc(tblDesc));
		tblDesc.add(getDt_evaluateCDesc(tblDesc));
		tblDesc.add(getId_agerangeCDesc(tblDesc));
		tblDesc.add(getSd_agerangeCDesc(tblDesc));
		tblDesc.add(getScore_agerangeCDesc(tblDesc));
		tblDesc.add(getId_awarenessCDesc(tblDesc));
		tblDesc.add(getSd_awarenessCDesc(tblDesc));
		tblDesc.add(getScore_awarenessCDesc(tblDesc));
		tblDesc.add(getId_mindCDesc(tblDesc));
		tblDesc.add(getSd_mindCDesc(tblDesc));
		tblDesc.add(getScore_mindCDesc(tblDesc));
		tblDesc.add(getId_activityCDesc(tblDesc));
		tblDesc.add(getSd_activityCDesc(tblDesc));
		tblDesc.add(getScore_activityCDesc(tblDesc));
		tblDesc.add(getId_pipe_firsttpCDesc(tblDesc));
		tblDesc.add(getSd_pipe_firsttpCDesc(tblDesc));
		tblDesc.add(getPipe_firstotherCDesc(tblDesc));
		tblDesc.add(getId_pipe_secondtpCDesc(tblDesc));
		tblDesc.add(getSd_pipe_secondtpCDesc(tblDesc));
		tblDesc.add(getPipe_secondotherCDesc(tblDesc));
		tblDesc.add(getId_pipe_thirdtpCDesc(tblDesc));
		tblDesc.add(getSd_pipe_thirdtpCDesc(tblDesc));
		tblDesc.add(getPipe_thirdotherCDesc(tblDesc));
		tblDesc.add(getScore_pipetpCDesc(tblDesc));
		tblDesc.add(getId_painCDesc(tblDesc));
		tblDesc.add(getSd_painCDesc(tblDesc));
		tblDesc.add(getScore_painCDesc(tblDesc));
		tblDesc.add(getId_communicatCDesc(tblDesc));
		tblDesc.add(getSd_communicatCDesc(tblDesc));
		tblDesc.add(getScore_communicatCDesc(tblDesc));
		tblDesc.add(getId_nursmeasureCDesc(tblDesc));
		tblDesc.add(getSd_nursmeasureCDesc(tblDesc));
		tblDesc.add(getScore_totalCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 管道滑脱风险ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pipeslipriskADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pipesliprisk",  getId_pipeslipriskCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("管道滑脱风险ID");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
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
	 * 就诊病区属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dep_nurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dep_nur",  getName_dep_nurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("就诊病区");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 床号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_bedADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_bed",  getName_bedCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("床号");
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
	 * 住院病案编号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_amr_ipADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_amr_ip",  getCode_amr_ipCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("住院病案编号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊断ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_diagnosisADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_diagnosis",  getId_diagnosisCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊断属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_diagnosisADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_diagnosis",  getName_diagnosisCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
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
	 * 护士签名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_nurseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_nurse",  getId_nurseCDesc(tblDesc), this);
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
	 * 就诊科室属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dep_phyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dep_phy",  getName_dep_phyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("就诊科室");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 评估日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_evaluateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_evaluate",  getDt_evaluateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("评估日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 年龄1属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_agerangeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_agerange",  getId_agerangeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("年龄1");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 年龄编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_agerangeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_agerange",  getSd_agerangeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("年龄编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 年龄得分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getScore_agerangeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Score_agerange",  getScore_agerangeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("年龄得分");
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
	private IAttrDesc getId_awarenessADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_awareness",  getId_awarenessCDesc(tblDesc), this);
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
	private IAttrDesc getSd_awarenessADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_awareness",  getSd_awarenessCDesc(tblDesc), this);
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
	 * 意识得分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getScore_awarenessADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Score_awareness",  getScore_awarenessCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("意识得分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 精神属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mindADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mind",  getId_mindCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("精神");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 精神编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_mindADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_mind",  getSd_mindCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("精神编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 精神得分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getScore_mindADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Score_mind",  getScore_mindCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("精神得分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 活动属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_activityADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_activity",  getId_activityCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("活动");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 活动编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_activityADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_activity",  getSd_activityCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("活动编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 活动得分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getScore_activityADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Score_activity",  getScore_activityCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("活动得分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * Ⅰ类导管属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pipe_firsttpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pipe_firsttp",  getId_pipe_firsttpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("Ⅰ类导管");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * Ⅰ类导管编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_pipe_firsttpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_pipe_firsttp",  getSd_pipe_firsttpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("Ⅰ类导管编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * Ⅰ类导管其他属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPipe_firstotherADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pipe_firstother",  getPipe_firstotherCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("Ⅰ类导管其他");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * Ⅱ类导管属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pipe_secondtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pipe_secondtp",  getId_pipe_secondtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("Ⅱ类导管");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * Ⅱ类导管编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_pipe_secondtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_pipe_secondtp",  getSd_pipe_secondtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("Ⅱ类导管编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * Ⅱ类导管其他属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPipe_secondotherADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pipe_secondother",  getPipe_secondotherCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("Ⅱ类导管其他");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * Ⅲ类导管属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pipe_thirdtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pipe_thirdtp",  getId_pipe_thirdtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("Ⅲ类导管");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * Ⅲ类导管编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_pipe_thirdtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_pipe_thirdtp",  getSd_pipe_thirdtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("Ⅲ类导管编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * Ⅲ类导管其他属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPipe_thirdotherADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pipe_thirdother",  getPipe_thirdotherCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("Ⅲ类导管其他");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 管道得分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getScore_pipetpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Score_pipetp",  getScore_pipetpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("管道得分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 疼痛属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_painADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pain",  getId_painCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("疼痛");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 疼痛编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_painADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_pain",  getSd_painCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("疼痛编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 疼痛得分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getScore_painADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Score_pain",  getScore_painCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("疼痛得分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 沟通属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_communicatADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_communicat",  getId_communicatCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("沟通");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 沟通编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_communicatADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_communicat",  getSd_communicatCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("沟通编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 沟通得分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getScore_communicatADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Score_communicat",  getScore_communicatCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("沟通得分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 护理措施属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_nursmeasureADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_nursmeasure",  getId_nursmeasureCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("护理措施");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 护理措施编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_nursmeasureADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_nursmeasure",  getSd_nursmeasureCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("护理措施编码");
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
	private IAttrDesc getScore_totalADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Score_total",  getScore_totalCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("总分");
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
	 * 护士签名姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_nurseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_nurse",  getName_nurseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("护士签名姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b8","id_nurse=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 年龄名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_agerangeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_agerange",  getName_agerangeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("年龄名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b9","id_agerange=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 意识名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_awarenessADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_awareness",  getName_awarenessCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("意识名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b10","id_awareness=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 精神名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_mindADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_mind",  getName_mindCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("精神名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b11","id_mind=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 活动名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_activityADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_activity",  getName_activityCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("活动名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b12","id_activity=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * Ⅰ类导管名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_pipe_firsttpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_pipe_firsttp",  getName_pipe_firsttpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("Ⅰ类导管名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b17","id_pipe_firsttp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * Ⅱ类导管名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_pipe_secondtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_pipe_secondtp",  getName_pipe_secondtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("Ⅱ类导管名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b18","id_pipe_secondtp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * Ⅲ类导管名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_pipe_thirdtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_pipe_thirdtp",  getName_pipe_thirdtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("Ⅲ类导管名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b19","id_pipe_thirdtp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 疼痛名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_painADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_pain",  getName_painCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("疼痛名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b14","id_pain=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 沟通名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_communicatADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_communicat",  getName_communicatCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("沟通名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b15","id_communicat=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 护理措施名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_nursmeasureADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_nursmeasure",  getName_nursmeasureCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("护理措施名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b16","id_nursmeasure=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取管道滑脱风险ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pipeslipriskCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pipesliprisk");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("管道滑脱风险ID"); 
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
	 * 获取就诊病区表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_dep_nurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dep_nur");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊病区"); 
		return column;
	}
	/**
	 * 获取床号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_bedCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_bed");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("床号"); 
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
	 * 获取住院病案编号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_amr_ipCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_amr_ip");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("住院病案编号"); 
		return column;
	}
	/**
	 * 获取诊断ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_diagnosisCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_diagnosis");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断ID"); 
		return column;
	}
	/**
	 * 获取诊断表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_diagnosisCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_diagnosis");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断"); 
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
	 * 获取护士签名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_nurseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_nurse");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("护士签名"); 
		return column;
	}
	/**
	 * 获取就诊科室表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_dep_phyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dep_phy");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊科室"); 
		return column;
	}
	/**
	 * 获取评估日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_evaluateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_evaluate");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("评估日期"); 
		return column;
	}
	/**
	 * 获取年龄1表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_agerangeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_agerange");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("年龄1"); 
		return column;
	}
	/**
	 * 获取年龄编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_agerangeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_agerange");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("年龄编码"); 
		return column;
	}
	/**
	 * 获取年龄得分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getScore_agerangeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Score_agerange");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("年龄得分"); 
		return column;
	}
	/**
	 * 获取意识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_awarenessCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_awareness");
		column.setLength(500);
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
	private IColumnDesc getSd_awarenessCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_awareness");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("意识编码"); 
		return column;
	}
	/**
	 * 获取意识得分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getScore_awarenessCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Score_awareness");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("意识得分"); 
		return column;
	}
	/**
	 * 获取精神表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mindCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mind");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("精神"); 
		return column;
	}
	/**
	 * 获取精神编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_mindCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_mind");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("精神编码"); 
		return column;
	}
	/**
	 * 获取精神得分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getScore_mindCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Score_mind");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("精神得分"); 
		return column;
	}
	/**
	 * 获取活动表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_activityCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_activity");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("活动"); 
		return column;
	}
	/**
	 * 获取活动编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_activityCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_activity");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("活动编码"); 
		return column;
	}
	/**
	 * 获取活动得分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getScore_activityCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Score_activity");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("活动得分"); 
		return column;
	}
	/**
	 * 获取Ⅰ类导管表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pipe_firsttpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pipe_firsttp");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("Ⅰ类导管"); 
		return column;
	}
	/**
	 * 获取Ⅰ类导管编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_pipe_firsttpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_pipe_firsttp");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("Ⅰ类导管编码"); 
		return column;
	}
	/**
	 * 获取Ⅰ类导管其他表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPipe_firstotherCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pipe_firstother");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("Ⅰ类导管其他"); 
		return column;
	}
	/**
	 * 获取Ⅱ类导管表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pipe_secondtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pipe_secondtp");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("Ⅱ类导管"); 
		return column;
	}
	/**
	 * 获取Ⅱ类导管编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_pipe_secondtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_pipe_secondtp");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("Ⅱ类导管编码"); 
		return column;
	}
	/**
	 * 获取Ⅱ类导管其他表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPipe_secondotherCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pipe_secondother");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("Ⅱ类导管其他"); 
		return column;
	}
	/**
	 * 获取Ⅲ类导管表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pipe_thirdtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pipe_thirdtp");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("Ⅲ类导管"); 
		return column;
	}
	/**
	 * 获取Ⅲ类导管编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_pipe_thirdtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_pipe_thirdtp");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("Ⅲ类导管编码"); 
		return column;
	}
	/**
	 * 获取Ⅲ类导管其他表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPipe_thirdotherCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pipe_thirdother");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("Ⅲ类导管其他"); 
		return column;
	}
	/**
	 * 获取管道得分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getScore_pipetpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Score_pipetp");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("管道得分"); 
		return column;
	}
	/**
	 * 获取疼痛表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_painCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pain");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("疼痛"); 
		return column;
	}
	/**
	 * 获取疼痛编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_painCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_pain");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("疼痛编码"); 
		return column;
	}
	/**
	 * 获取疼痛得分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getScore_painCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Score_pain");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("疼痛得分"); 
		return column;
	}
	/**
	 * 获取沟通表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_communicatCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_communicat");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("沟通"); 
		return column;
	}
	/**
	 * 获取沟通编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_communicatCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_communicat");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("沟通编码"); 
		return column;
	}
	/**
	 * 获取沟通得分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getScore_communicatCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Score_communicat");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("沟通得分"); 
		return column;
	}
	/**
	 * 获取护理措施表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_nursmeasureCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_nursmeasure");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("护理措施"); 
		return column;
	}
	/**
	 * 获取护理措施编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_nursmeasureCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_nursmeasure");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("护理措施编码"); 
		return column;
	}
	/**
	 * 获取总分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getScore_totalCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Score_total");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("总分"); 
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
	 * 获取护士签名姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_nurseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_nurse");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("护士签名姓名"); 
		return column;
	}
	/**
	 * 获取年龄名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_agerangeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_agerange");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("年龄名称"); 
		return column;
	}
	/**
	 * 获取意识名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_awarenessCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_awareness");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("意识名称"); 
		return column;
	}
	/**
	 * 获取精神名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_mindCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_mind");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("精神名称"); 
		return column;
	}
	/**
	 * 获取活动名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_activityCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_activity");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("活动名称"); 
		return column;
	}
	/**
	 * 获取Ⅰ类导管名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_pipe_firsttpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_pipe_firsttp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("Ⅰ类导管名称"); 
		return column;
	}
	/**
	 * 获取Ⅱ类导管名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_pipe_secondtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_pipe_secondtp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("Ⅱ类导管名称"); 
		return column;
	}
	/**
	 * 获取Ⅲ类导管名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_pipe_thirdtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_pipe_thirdtp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("Ⅲ类导管名称"); 
		return column;
	}
	/**
	 * 获取疼痛名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_painCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_pain");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("疼痛名称"); 
		return column;
	}
	/**
	 * 获取沟通名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_communicatCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_communicat");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("沟通名称"); 
		return column;
	}
	/**
	 * 获取护理措施名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_nursmeasureCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_nursmeasure");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("护理措施名称"); 
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
