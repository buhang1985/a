
package iih.ci.mr.nu.perioperativenurrec.d.desc;

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
 * 围手术期护理主DO DO 元数据信息
 */
public class PpNurDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.ci.mr.nu.perioperativenurrec.d.PpNurDO";
	public static final String CLASS_DISPALYNAME = "围手术期护理主DO";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "MR_NU_PPNUR";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_ppnur";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public PpNurDODesc(){
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
		this.setKeyDesc(getId_ppnurADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.add(getId_ppnurADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_entADesc(tblDesc));
		this.add(getName_dep_phyADesc(tblDesc));
		this.add(getName_bedADesc(tblDesc));
		this.add(getName_patADesc(tblDesc));
		this.add(getAgeADesc(tblDesc));
		this.add(getName_sexADesc(tblDesc));
		this.add(getCode_amr_ipADesc(tblDesc));
		this.add(getId_diagnosisADesc(tblDesc));
		this.add(getName_diagnosisADesc(tblDesc));
		this.add(getId_operADesc(tblDesc));
		this.add(getPre_opercareADesc(tblDesc));
		this.add(getEdu_preoperADesc(tblDesc));
		this.add(getEu_postoperADesc(tblDesc));
		this.add(getPaulseADesc(tblDesc));
		this.add(getTemADesc(tblDesc));
		this.add(getBreathADesc(tblDesc));
		this.add(getSys_preADesc(tblDesc));
		this.add(getDia_preADesc(tblDesc));
		this.add(getWeightADesc(tblDesc));
		this.add(getDt_operADesc(tblDesc));
		this.add(getDt_entryADesc(tblDesc));
		this.add(getWristbandADesc(tblDesc));
		this.add(getSign_opersiteADesc(tblDesc));
		this.add(getPre_skinADesc(tblDesc));
		this.add(getBathADesc(tblDesc));
		this.add(getChange_surgownADesc(tblDesc));
		this.add(getIntestinal_cleanADesc(tblDesc));
		this.add(getBladder_emptyADesc(tblDesc));
		this.add(getRemove_jewelryADesc(tblDesc));
		this.add(getTube_nasogastricADesc(tblDesc));
		this.add(getCatheterADesc(tblDesc));
		this.add(getPre_bloodADesc(tblDesc));
		this.add(getInspeclistADesc(tblDesc));
		this.add(getAdvice_askADesc(tblDesc));
		this.add(getDt_receivepatADesc(tblDesc));
		this.add(getId_signADesc(tblDesc));
		this.add(getAfter_opercareADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getName_operADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_ppnurCDesc(tblDesc));
		tblDesc.add(getId_ppnurCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_entCDesc(tblDesc));
		tblDesc.add(getName_dep_phyCDesc(tblDesc));
		tblDesc.add(getName_bedCDesc(tblDesc));
		tblDesc.add(getName_patCDesc(tblDesc));
		tblDesc.add(getAgeCDesc(tblDesc));
		tblDesc.add(getName_sexCDesc(tblDesc));
		tblDesc.add(getCode_amr_ipCDesc(tblDesc));
		tblDesc.add(getId_diagnosisCDesc(tblDesc));
		tblDesc.add(getName_diagnosisCDesc(tblDesc));
		tblDesc.add(getId_operCDesc(tblDesc));
		tblDesc.add(getPre_opercareCDesc(tblDesc));
		tblDesc.add(getEdu_preoperCDesc(tblDesc));
		tblDesc.add(getEu_postoperCDesc(tblDesc));
		tblDesc.add(getPaulseCDesc(tblDesc));
		tblDesc.add(getTemCDesc(tblDesc));
		tblDesc.add(getBreathCDesc(tblDesc));
		tblDesc.add(getSys_preCDesc(tblDesc));
		tblDesc.add(getDia_preCDesc(tblDesc));
		tblDesc.add(getWeightCDesc(tblDesc));
		tblDesc.add(getDt_operCDesc(tblDesc));
		tblDesc.add(getDt_entryCDesc(tblDesc));
		tblDesc.add(getWristbandCDesc(tblDesc));
		tblDesc.add(getSign_opersiteCDesc(tblDesc));
		tblDesc.add(getPre_skinCDesc(tblDesc));
		tblDesc.add(getBathCDesc(tblDesc));
		tblDesc.add(getChange_surgownCDesc(tblDesc));
		tblDesc.add(getIntestinal_cleanCDesc(tblDesc));
		tblDesc.add(getBladder_emptyCDesc(tblDesc));
		tblDesc.add(getRemove_jewelryCDesc(tblDesc));
		tblDesc.add(getTube_nasogastricCDesc(tblDesc));
		tblDesc.add(getCatheterCDesc(tblDesc));
		tblDesc.add(getPre_bloodCDesc(tblDesc));
		tblDesc.add(getInspeclistCDesc(tblDesc));
		tblDesc.add(getAdvice_askCDesc(tblDesc));
		tblDesc.add(getDt_receivepatCDesc(tblDesc));
		tblDesc.add(getId_signCDesc(tblDesc));
		tblDesc.add(getAfter_opercareCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 围手术期护理基本信息ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ppnurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ppnur",  getId_ppnurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("围手术期护理基本信息ID");
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
	 * 诊断属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_diagnosisADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_diagnosis",  getId_diagnosisCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊断名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_diagnosisADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_diagnosis",  getName_diagnosisCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 手术名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_operADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_oper",  getId_operCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 术前护理属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPre_opercareADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pre_opercare",  getPre_opercareCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术前护理");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术前手术、麻醉相关知识宣教属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEdu_preoperADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Edu_preoper",  getEdu_preoperCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术前手术、麻醉相关知识宣教");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术后配合属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_postoperADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_postoper",  getEu_postoperCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("术后配合");
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
	 * 体重属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWeightADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Weight",  getWeightCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体重");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_operADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_oper",  getDt_operCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("手术日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 入院时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_entryADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_entry",  getDt_entryCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("入院时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 腕带属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWristbandADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Wristband",  getWristbandCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("腕带");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术部位标记属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSign_opersiteADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sign_opersite",  getSign_opersiteCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("手术部位标记");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备皮属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPre_skinADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pre_skin",  getPre_skinCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("备皮");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 沐浴属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBathADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Bath",  getBathCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("沐浴");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 更换手术衣属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getChange_surgownADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Change_surgown",  getChange_surgownCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("更换手术衣");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 肠道清洁属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIntestinal_cleanADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Intestinal_clean",  getIntestinal_cleanCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("肠道清洁");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 肠道排空属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBladder_emptyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Bladder_empty",  getBladder_emptyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("肠道排空");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 去除假牙首饰属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRemove_jewelryADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Remove_jewelry",  getRemove_jewelryCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("去除假牙首饰");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 放置鼻胃管属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTube_nasogastricADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Tube_nasogastric",  getTube_nasogastricCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("放置鼻胃管");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 放置导尿管属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCatheterADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Catheter",  getCatheterCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("放置导尿管");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备血情况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPre_bloodADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pre_blood",  getPre_bloodCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("备血情况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 实验室检查单属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInspeclistADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Inspeclist",  getInspeclistCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("实验室检查单");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术征求意见单签属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAdvice_askADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Advice_ask",  getAdvice_askCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("手术征求意见单签");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术室接患者时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_receivepatADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_receivepat",  getDt_receivepatCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("手术室接患者时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 护士签名ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_signADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_sign",  getId_signCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("护士签名ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 术后护理属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAfter_opercareADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("After_opercare",  getAfter_opercareCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术后护理");
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
	 * 服务名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_operADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_oper",  getName_operCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_srv a0b8","id_oper=id_srv","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 护士签名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_signADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_sign",  getName_signCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("护士签名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b6","id_sign=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取围手术期护理基本信息ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ppnurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ppnur");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("围手术期护理基本信息ID"); 
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
	 * 获取诊断表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_diagnosisCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_diagnosis");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断"); 
		return column;
	}
	/**
	 * 获取诊断名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_diagnosisCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_diagnosis");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断名称"); 
		return column;
	}
	/**
	 * 获取手术名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_operCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_oper");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术名称"); 
		return column;
	}
	/**
	 * 获取术前护理表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPre_opercareCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pre_opercare");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术前护理"); 
		return column;
	}
	/**
	 * 获取术前手术、麻醉相关知识宣教表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEdu_preoperCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Edu_preoper");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术前手术、麻醉相关知识宣教"); 
		return column;
	}
	/**
	 * 获取术后配合表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_postoperCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_postoper");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("术后配合"); 
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
	 * 获取体重表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWeightCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Weight");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体重"); 
		return column;
	}
	/**
	 * 获取手术日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_operCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_oper");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("手术日期"); 
		return column;
	}
	/**
	 * 获取入院时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_entryCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_entry");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("入院时间"); 
		return column;
	}
	/**
	 * 获取腕带表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWristbandCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Wristband");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("腕带"); 
		return column;
	}
	/**
	 * 获取手术部位标记表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSign_opersiteCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sign_opersite");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("手术部位标记"); 
		return column;
	}
	/**
	 * 获取备皮表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPre_skinCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pre_skin");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("备皮"); 
		return column;
	}
	/**
	 * 获取沐浴表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBathCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Bath");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("沐浴"); 
		return column;
	}
	/**
	 * 获取更换手术衣表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getChange_surgownCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Change_surgown");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("更换手术衣"); 
		return column;
	}
	/**
	 * 获取肠道清洁表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIntestinal_cleanCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Intestinal_clean");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("肠道清洁"); 
		return column;
	}
	/**
	 * 获取肠道排空表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBladder_emptyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Bladder_empty");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("肠道排空"); 
		return column;
	}
	/**
	 * 获取去除假牙首饰表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRemove_jewelryCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Remove_jewelry");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("去除假牙首饰"); 
		return column;
	}
	/**
	 * 获取放置鼻胃管表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTube_nasogastricCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Tube_nasogastric");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("放置鼻胃管"); 
		return column;
	}
	/**
	 * 获取放置导尿管表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCatheterCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Catheter");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("放置导尿管"); 
		return column;
	}
	/**
	 * 获取备血情况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPre_bloodCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pre_blood");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("备血情况"); 
		return column;
	}
	/**
	 * 获取实验室检查单表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInspeclistCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Inspeclist");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("实验室检查单"); 
		return column;
	}
	/**
	 * 获取手术征求意见单签表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAdvice_askCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Advice_ask");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("手术征求意见单签"); 
		return column;
	}
	/**
	 * 获取手术室接患者时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_receivepatCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_receivepat");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("手术室接患者时间"); 
		return column;
	}
	/**
	 * 获取护士签名ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_signCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_sign");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("护士签名ID"); 
		return column;
	}
	/**
	 * 获取术后护理表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAfter_opercareCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"After_opercare");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术后护理"); 
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
	 * 获取服务名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_operCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_oper");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务名称"); 
		return column;
	}
	/**
	 * 获取护士签名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_signCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_sign");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("护士签名"); 
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
