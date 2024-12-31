
package iih.nm.nqm.nmnqmnightround.d.desc;

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
 * 夜查房 DO 元数据信息
 */
public class NmNqmNightRoundDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.nm.nqm.nmnqmnightround.d.NmNqmNightRoundDO";
	public static final String CLASS_DISPALYNAME = "夜查房";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "NM_NQM_NIGHTROUND";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_nqm_rounds";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public NmNqmNightRoundDODesc(){
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
		this.setKeyDesc(getId_nqm_roundsADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_nqm_roundsADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getDt_roundsADesc(tblDesc));
		this.add(getId_nurADesc(tblDesc));
		this.add(getId_dep_nurADesc(tblDesc));
		this.add(getId_depADesc(tblDesc));
		this.add(getId_duty_nurADesc(tblDesc));
		this.add(getName_dutynurADesc(tblDesc));
		this.add(getCount_patADesc(tblDesc));
		this.add(getCount_criserADesc(tblDesc));
		this.add(getCount_supercareADesc(tblDesc));
		this.add(getCount_firstcareADesc(tblDesc));
		this.add(getCount_newpatADesc(tblDesc));
		this.add(getCount_preoperADesc(tblDesc));
		this.add(getCount_postoperADesc(tblDesc));
		this.add(getCount_bloodtransADesc(tblDesc));
		this.add(getCount_chemoADesc(tblDesc));
		this.add(getCount_uexlowriskADesc(tblDesc));
		this.add(getCount_uexmedriskADesc(tblDesc));
		this.add(getCount_uexhighriskADesc(tblDesc));
		this.add(getCount_thrombuslowADesc(tblDesc));
		this.add(getCount_thrombusmedADesc(tblDesc));
		this.add(getCount_thrombushighADesc(tblDesc));
		this.add(getCount_pressurelowADesc(tblDesc));
		this.add(getCount_pressuremedADesc(tblDesc));
		this.add(getCount_pressurehighADesc(tblDesc));
		this.add(getCount_accidentslowADesc(tblDesc));
		this.add(getCount_accidentsmedADesc(tblDesc));
		this.add(getCount_accidentshighADesc(tblDesc));
		this.add(getCriticalsituationADesc(tblDesc));
		this.add(getSerioussituationADesc(tblDesc));
		this.add(getPatsituationADesc(tblDesc));
		this.add(getPatsituatnumADesc(tblDesc));
		this.add(getExistproblemADesc(tblDesc));
		this.add(getMend_measADesc(tblDesc));
		this.add(getCtrl1ADesc(tblDesc));
		this.add(getCtrl2ADesc(tblDesc));
		this.add(getCtrl3ADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getName_nurADesc(tblDesc));
		this.add(getName_dep_nurADesc(tblDesc));
		this.add(getName_dutyADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_nqm_roundsCDesc(tblDesc));
		tblDesc.add(getId_nqm_roundsCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getDt_roundsCDesc(tblDesc));
		tblDesc.add(getId_nurCDesc(tblDesc));
		tblDesc.add(getId_dep_nurCDesc(tblDesc));
		tblDesc.add(getId_depCDesc(tblDesc));
		tblDesc.add(getId_duty_nurCDesc(tblDesc));
		tblDesc.add(getName_dutynurCDesc(tblDesc));
		tblDesc.add(getCount_patCDesc(tblDesc));
		tblDesc.add(getCount_criserCDesc(tblDesc));
		tblDesc.add(getCount_supercareCDesc(tblDesc));
		tblDesc.add(getCount_firstcareCDesc(tblDesc));
		tblDesc.add(getCount_newpatCDesc(tblDesc));
		tblDesc.add(getCount_preoperCDesc(tblDesc));
		tblDesc.add(getCount_postoperCDesc(tblDesc));
		tblDesc.add(getCount_bloodtransCDesc(tblDesc));
		tblDesc.add(getCount_chemoCDesc(tblDesc));
		tblDesc.add(getCount_uexlowriskCDesc(tblDesc));
		tblDesc.add(getCount_uexmedriskCDesc(tblDesc));
		tblDesc.add(getCount_uexhighriskCDesc(tblDesc));
		tblDesc.add(getCount_thrombuslowCDesc(tblDesc));
		tblDesc.add(getCount_thrombusmedCDesc(tblDesc));
		tblDesc.add(getCount_thrombushighCDesc(tblDesc));
		tblDesc.add(getCount_pressurelowCDesc(tblDesc));
		tblDesc.add(getCount_pressuremedCDesc(tblDesc));
		tblDesc.add(getCount_pressurehighCDesc(tblDesc));
		tblDesc.add(getCount_accidentslowCDesc(tblDesc));
		tblDesc.add(getCount_accidentsmedCDesc(tblDesc));
		tblDesc.add(getCount_accidentshighCDesc(tblDesc));
		tblDesc.add(getCriticalsituationCDesc(tblDesc));
		tblDesc.add(getSerioussituationCDesc(tblDesc));
		tblDesc.add(getPatsituationCDesc(tblDesc));
		tblDesc.add(getPatsituatnumCDesc(tblDesc));
		tblDesc.add(getExistproblemCDesc(tblDesc));
		tblDesc.add(getMend_measCDesc(tblDesc));
		tblDesc.add(getCtrl1CDesc(tblDesc));
		tblDesc.add(getCtrl2CDesc(tblDesc));
		tblDesc.add(getCtrl3CDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 夜查房主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_nqm_roundsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_nqm_rounds",  getId_nqm_roundsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("夜查房主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 所属集团属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_grpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_grp",  getId_grpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("所属集团");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 所属组织属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_orgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_org",  getId_orgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("所属组织");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 查房时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_roundsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_rounds",  getDt_roundsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("查房时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 查房人员id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_nurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_nur",  getId_nurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("查房人员id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 护理单元id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dep_nurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep_nur",  getId_dep_nurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("护理单元id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 科室id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_depADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep",  getId_depCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("科室id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 值班护士id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_duty_nurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_duty_nur",  getId_duty_nurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("值班护士id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 值班护士名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dutynurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dutynur",  getName_dutynurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("值班护士名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 病人总数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCount_patADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Count_pat",  getCount_patCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("病人总数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 危重人数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCount_criserADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Count_criser",  getCount_criserCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("危重人数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 特级护理人数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCount_supercareADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Count_supercare",  getCount_supercareCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("特级护理人数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 一级护理人数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCount_firstcareADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Count_firstcare",  getCount_firstcareCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("一级护理人数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 新入患者人数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCount_newpatADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Count_newpat",  getCount_newpatCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("新入患者人数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术前人数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCount_preoperADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Count_preoper",  getCount_preoperCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("术前人数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术后人数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCount_postoperADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Count_postoper",  getCount_postoperCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("术后人数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 输血人数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCount_bloodtransADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Count_bloodtrans",  getCount_bloodtransCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("输血人数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 化疗人数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCount_chemoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Count_chemo",  getCount_chemoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("化疗人数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 非计划拔管低风险人数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCount_uexlowriskADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Count_uexlowrisk",  getCount_uexlowriskCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("非计划拔管低风险人数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 非计划拔管中风险人数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCount_uexmedriskADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Count_uexmedrisk",  getCount_uexmedriskCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("非计划拔管中风险人数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 非计划性拔管高风险人数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCount_uexhighriskADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Count_uexhighrisk",  getCount_uexhighriskCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("非计划性拔管高风险人数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 深V血栓低风险人数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCount_thrombuslowADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Count_thrombuslow",  getCount_thrombuslowCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("深V血栓低风险人数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 深V血栓中风险人数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCount_thrombusmedADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Count_thrombusmed",  getCount_thrombusmedCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("深V血栓中风险人数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 深V血栓高风险人数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCount_thrombushighADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Count_thrombushigh",  getCount_thrombushighCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("深V血栓高风险人数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 压疮低风险人数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCount_pressurelowADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Count_pressurelow",  getCount_pressurelowCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("压疮低风险人数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 压疮中风险人数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCount_pressuremedADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Count_pressuremed",  getCount_pressuremedCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("压疮中风险人数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 压疮高风险人数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCount_pressurehighADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Count_pressurehigh",  getCount_pressurehighCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("压疮高风险人数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 意外因素低风险人数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCount_accidentslowADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Count_accidentslow",  getCount_accidentslowCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("意外因素低风险人数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 意外因素中风险人数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCount_accidentsmedADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Count_accidentsmed",  getCount_accidentsmedCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("意外因素中风险人数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 意外因素高风险人数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCount_accidentshighADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Count_accidentshigh",  getCount_accidentshighCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("意外因素高风险人数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 急危患者落实情况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCriticalsituationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Criticalsituation",  getCriticalsituationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("急危患者落实情况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 高危患者落实情况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSerioussituationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Serioussituation",  getSerioussituationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("高危患者落实情况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 住院大于30天患者情况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPatsituationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Patsituation",  getPatsituationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("住院大于30天患者情况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 住院大于30天患者人数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPatsituatnumADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Patsituatnum",  getPatsituatnumCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("住院大于30天患者人数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 存在问题属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getExistproblemADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Existproblem",  getExistproblemCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("存在问题");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 整改措施属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMend_measADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mend_meas",  getMend_measCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("整改措施");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 扩展字段1属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCtrl1ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ctrl1",  getCtrl1CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("扩展字段1");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 扩展字段2属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCtrl2ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ctrl2",  getCtrl2CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("扩展字段2");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 扩展字段3属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCtrl3ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ctrl3",  getCtrl3CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("扩展字段3");
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
	 * 人员姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_nurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_nur",  getName_nurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("人员姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"NM_NUR a0b6","id_nur=id_nur","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 护理单元名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dep_nurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dep_nur",  getName_dep_nurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("护理单元名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"NM_NBD_DEP a0b7","id_dep_nur=id_nbd_dep","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 人员姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dutyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_duty",  getName_dutyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("人员姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"NM_NUR a0b8","id_duty_nur=id_nur","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取夜查房主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_nqm_roundsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_nqm_rounds");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("夜查房主键"); 
		return column;
	}
	/**
	 * 获取所属集团表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_grpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_grp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("所属集团"); 
		return column;
	}
	/**
	 * 获取所属组织表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_orgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_org");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("所属组织"); 
		return column;
	}
	/**
	 * 获取查房时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_roundsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_rounds");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("查房时间"); 
		return column;
	}
	/**
	 * 获取查房人员id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_nurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_nur");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("查房人员id"); 
		return column;
	}
	/**
	 * 获取护理单元id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dep_nurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep_nur");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("护理单元id"); 
		return column;
	}
	/**
	 * 获取科室id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_depCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("科室id"); 
		return column;
	}
	/**
	 * 获取值班护士id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_duty_nurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_duty_nur");
		column.setLength(150);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("值班护士id"); 
		return column;
	}
	/**
	 * 获取值班护士名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_dutynurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dutynur");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("值班护士名称"); 
		return column;
	}
	/**
	 * 获取病人总数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCount_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Count_pat");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("病人总数"); 
		return column;
	}
	/**
	 * 获取危重人数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCount_criserCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Count_criser");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("危重人数"); 
		return column;
	}
	/**
	 * 获取特级护理人数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCount_supercareCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Count_supercare");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("特级护理人数"); 
		return column;
	}
	/**
	 * 获取一级护理人数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCount_firstcareCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Count_firstcare");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("一级护理人数"); 
		return column;
	}
	/**
	 * 获取新入患者人数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCount_newpatCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Count_newpat");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("新入患者人数"); 
		return column;
	}
	/**
	 * 获取术前人数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCount_preoperCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Count_preoper");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("术前人数"); 
		return column;
	}
	/**
	 * 获取术后人数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCount_postoperCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Count_postoper");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("术后人数"); 
		return column;
	}
	/**
	 * 获取输血人数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCount_bloodtransCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Count_bloodtrans");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("输血人数"); 
		return column;
	}
	/**
	 * 获取化疗人数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCount_chemoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Count_chemo");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("化疗人数"); 
		return column;
	}
	/**
	 * 获取非计划拔管低风险人数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCount_uexlowriskCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Count_uexlowrisk");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("非计划拔管低风险人数"); 
		return column;
	}
	/**
	 * 获取非计划拔管中风险人数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCount_uexmedriskCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Count_uexmedrisk");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("非计划拔管中风险人数"); 
		return column;
	}
	/**
	 * 获取非计划性拔管高风险人数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCount_uexhighriskCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Count_uexhighrisk");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("非计划性拔管高风险人数"); 
		return column;
	}
	/**
	 * 获取深V血栓低风险人数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCount_thrombuslowCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Count_thrombuslow");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("深V血栓低风险人数"); 
		return column;
	}
	/**
	 * 获取深V血栓中风险人数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCount_thrombusmedCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Count_thrombusmed");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("深V血栓中风险人数"); 
		return column;
	}
	/**
	 * 获取深V血栓高风险人数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCount_thrombushighCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Count_thrombushigh");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("深V血栓高风险人数"); 
		return column;
	}
	/**
	 * 获取压疮低风险人数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCount_pressurelowCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Count_pressurelow");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("压疮低风险人数"); 
		return column;
	}
	/**
	 * 获取压疮中风险人数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCount_pressuremedCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Count_pressuremed");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("压疮中风险人数"); 
		return column;
	}
	/**
	 * 获取压疮高风险人数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCount_pressurehighCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Count_pressurehigh");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("压疮高风险人数"); 
		return column;
	}
	/**
	 * 获取意外因素低风险人数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCount_accidentslowCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Count_accidentslow");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("意外因素低风险人数"); 
		return column;
	}
	/**
	 * 获取意外因素中风险人数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCount_accidentsmedCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Count_accidentsmed");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("意外因素中风险人数"); 
		return column;
	}
	/**
	 * 获取意外因素高风险人数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCount_accidentshighCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Count_accidentshigh");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("意外因素高风险人数"); 
		return column;
	}
	/**
	 * 获取急危患者落实情况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCriticalsituationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Criticalsituation");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("急危患者落实情况"); 
		return column;
	}
	/**
	 * 获取高危患者落实情况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSerioussituationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Serioussituation");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("高危患者落实情况"); 
		return column;
	}
	/**
	 * 获取住院大于30天患者情况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPatsituationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Patsituation");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("住院大于30天患者情况"); 
		return column;
	}
	/**
	 * 获取住院大于30天患者人数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPatsituatnumCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Patsituatnum");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("住院大于30天患者人数"); 
		return column;
	}
	/**
	 * 获取存在问题表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getExistproblemCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Existproblem");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("存在问题"); 
		return column;
	}
	/**
	 * 获取整改措施表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMend_measCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mend_meas");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("整改措施"); 
		return column;
	}
	/**
	 * 获取扩展字段1表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCtrl1CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ctrl1");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("扩展字段1"); 
		return column;
	}
	/**
	 * 获取扩展字段2表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCtrl2CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ctrl2");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("扩展字段2"); 
		return column;
	}
	/**
	 * 获取扩展字段3表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCtrl3CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ctrl3");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("扩展字段3"); 
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
	 * 获取人员姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_nurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_nur");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("人员姓名"); 
		return column;
	}
	/**
	 * 获取护理单元名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_dep_nurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dep_nur");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("护理单元名称"); 
		return column;
	}
	/**
	 * 获取人员姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_dutyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_duty");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("人员姓名"); 
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
	
	/**
	 * 设置实体默认值
	 */
	private void setDefaultValueMap(){
		defaultValueMap=new HashMap<String, Object>();
	}
	
}
