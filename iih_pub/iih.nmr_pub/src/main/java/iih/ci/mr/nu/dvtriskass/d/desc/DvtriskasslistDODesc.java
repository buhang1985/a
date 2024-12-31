
package iih.ci.mr.nu.dvtriskass.d.desc;

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
 * DVT风险评估单列表 DO 元数据信息
 */
public class DvtriskasslistDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.ci.mr.nu.dvtriskass.d.DvtriskasslistDO";
	public static final String CLASS_DISPALYNAME = "DVT风险评估单列表";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "mr_nu_dvtriskasslist";
	public static final String TABLE_ALIAS_NAME = "a1";
	public static final String PRIMARYKEY_FIELDNAME="Id_dvtriskasslist";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public DvtriskasslistDODesc(){
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
		this.setKeyDesc(getId_dvtriskasslistADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.setFKeyDesc(getId_dvtADesc(tblDesc));
		this.add(getId_dvtriskasslistADesc(tblDesc));
		this.add(getId_dvtADesc(tblDesc));
		this.add(getId_age_rangeADesc(tblDesc));
		this.add(getSd_age_rangeADesc(tblDesc));
		this.add(getId_bmiADesc(tblDesc));
		this.add(getSd_bmiADesc(tblDesc));
		this.add(getId_activeADesc(tblDesc));
		this.add(getSd_activeADesc(tblDesc));
		this.add(getId_trauma_riskADesc(tblDesc));
		this.add(getSd_trauma_riskADesc(tblDesc));
		this.add(getId_special_riskADesc(tblDesc));
		this.add(getSd_special_riskADesc(tblDesc));
		this.add(getId_disease_riskADesc(tblDesc));
		this.add(getSd_disease_riskADesc(tblDesc));
		this.add(getId_surgeryADesc(tblDesc));
		this.add(getSd_surgeryADesc(tblDesc));
		this.add(getId_nursing_measuresADesc(tblDesc));
		this.add(getSd_nursing_measuresADesc(tblDesc));
		this.add(getId_signatureADesc(tblDesc));
		this.add(getNum_weightADesc(tblDesc));
		this.add(getNum_heightADesc(tblDesc));
		this.add(getExecution_dateADesc(tblDesc));
		this.add(getSc_age_rangeADesc(tblDesc));
		this.add(getSc_bmiADesc(tblDesc));
		this.add(getSc_activeADesc(tblDesc));
		this.add(getSc_trauma_riskADesc(tblDesc));
		this.add(getSc_special_riskADesc(tblDesc));
		this.add(getSc_disease_riskADesc(tblDesc));
		this.add(getSc_surgeryADesc(tblDesc));
		this.add(getSc_nursing_measuresADesc(tblDesc));
		this.add(getTotal_scoreADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getName_age_rangeADesc(tblDesc));
		this.add(getName_bmiADesc(tblDesc));
		this.add(getName_activeADesc(tblDesc));
		this.add(getName_trauma_riskADesc(tblDesc));
		this.add(getName_special_riskADesc(tblDesc));
		this.add(getName_disease_riskADesc(tblDesc));
		this.add(getName_surgeryADesc(tblDesc));
		this.add(getName_nursing_measuresADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_dvtriskasslistCDesc(tblDesc));
		tblDesc.add(getId_dvtriskasslistCDesc(tblDesc));
		tblDesc.add(getId_dvtCDesc(tblDesc));
		tblDesc.add(getId_age_rangeCDesc(tblDesc));
		tblDesc.add(getSd_age_rangeCDesc(tblDesc));
		tblDesc.add(getId_bmiCDesc(tblDesc));
		tblDesc.add(getSd_bmiCDesc(tblDesc));
		tblDesc.add(getId_activeCDesc(tblDesc));
		tblDesc.add(getSd_activeCDesc(tblDesc));
		tblDesc.add(getId_trauma_riskCDesc(tblDesc));
		tblDesc.add(getSd_trauma_riskCDesc(tblDesc));
		tblDesc.add(getId_special_riskCDesc(tblDesc));
		tblDesc.add(getSd_special_riskCDesc(tblDesc));
		tblDesc.add(getId_disease_riskCDesc(tblDesc));
		tblDesc.add(getSd_disease_riskCDesc(tblDesc));
		tblDesc.add(getId_surgeryCDesc(tblDesc));
		tblDesc.add(getSd_surgeryCDesc(tblDesc));
		tblDesc.add(getId_nursing_measuresCDesc(tblDesc));
		tblDesc.add(getSd_nursing_measuresCDesc(tblDesc));
		tblDesc.add(getId_signatureCDesc(tblDesc));
		tblDesc.add(getNum_weightCDesc(tblDesc));
		tblDesc.add(getNum_heightCDesc(tblDesc));
		tblDesc.add(getExecution_dateCDesc(tblDesc));
		tblDesc.add(getSc_age_rangeCDesc(tblDesc));
		tblDesc.add(getSc_bmiCDesc(tblDesc));
		tblDesc.add(getSc_activeCDesc(tblDesc));
		tblDesc.add(getSc_trauma_riskCDesc(tblDesc));
		tblDesc.add(getSc_special_riskCDesc(tblDesc));
		tblDesc.add(getSc_disease_riskCDesc(tblDesc));
		tblDesc.add(getSc_surgeryCDesc(tblDesc));
		tblDesc.add(getSc_nursing_measuresCDesc(tblDesc));
		tblDesc.add(getTotal_scoreCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * DVT风险评估单列表ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dvtriskasslistADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dvtriskasslist",  getId_dvtriskasslistCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("DVT风险评估单列表ID");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * DVT风险评估单ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dvtADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dvt",  getId_dvtCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("DVT风险评估单ID");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * DVT年龄属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_age_rangeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_age_range",  getId_age_rangeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("DVT年龄");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * DVT年龄编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_age_rangeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_age_range",  getSd_age_rangeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("DVT年龄编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * DVT体重指数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_bmiADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_bmi",  getId_bmiCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("DVT体重指数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * DVT体重指数编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_bmiADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_bmi",  getSd_bmiCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("DVT体重指数编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * DVT活动属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_activeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_active",  getId_activeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("DVT活动");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * DVT活动编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_activeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_active",  getSd_activeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("DVT活动编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * DVT创伤风险属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_trauma_riskADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_trauma_risk",  getId_trauma_riskCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("DVT创伤风险");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * DVT创伤风险编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_trauma_riskADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_trauma_risk",  getSd_trauma_riskCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("DVT创伤风险编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * DVT特殊风险属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_special_riskADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_special_risk",  getId_special_riskCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("DVT特殊风险");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * DVT特殊风险编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_special_riskADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_special_risk",  getSd_special_riskCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("DVT特殊风险编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * DVT高危疾病属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_disease_riskADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_disease_risk",  getId_disease_riskCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("DVT高危疾病");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * DVT高危疾病编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_disease_riskADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_disease_risk",  getSd_disease_riskCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("DVT高危疾病编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * DVT外科手术属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_surgeryADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_surgery",  getId_surgeryCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("DVT外科手术");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * DVT外科手术编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_surgeryADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_surgery",  getSd_surgeryCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("DVT外科手术编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * DVT护理措施属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_nursing_measuresADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_nursing_measures",  getId_nursing_measuresCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("DVT护理措施");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * DVT护理措施编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_nursing_measuresADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_nursing_measures",  getSd_nursing_measuresCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("DVT护理措施编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * DVT执行者签名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_signatureADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_signature",  getId_signatureCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("DVT执行者签名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * DVT体重属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNum_weightADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Num_weight",  getNum_weightCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("DVT体重");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * DVT身高属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNum_heightADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Num_height",  getNum_heightCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("DVT身高");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * DVT执行日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getExecution_dateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Execution_date",  getExecution_dateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("DVT执行日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * DVT年龄评分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSc_age_rangeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sc_age_range",  getSc_age_rangeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("DVT年龄评分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * DVT体重指数评分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSc_bmiADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sc_bmi",  getSc_bmiCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("DVT体重指数评分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * DVT活动评分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSc_activeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sc_active",  getSc_activeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("DVT活动评分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * DVT创伤风险评分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSc_trauma_riskADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sc_trauma_risk",  getSc_trauma_riskCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("DVT创伤风险评分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * DVT特殊风险评分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSc_special_riskADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sc_special_risk",  getSc_special_riskCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("DVT特殊风险评分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * DVT高危疾病评分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSc_disease_riskADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sc_disease_risk",  getSc_disease_riskCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("DVT高危疾病评分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * DVT外科手术评分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSc_surgeryADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sc_surgery",  getSc_surgeryCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("DVT外科手术评分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * DVT护理措施评分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSc_nursing_measuresADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sc_nursing_measures",  getSc_nursing_measuresCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("DVT护理措施评分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * DVT总分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTotal_scoreADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Total_score",  getTotal_scoreCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("DVT总分");
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
	 * DVT年龄名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_age_rangeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_age_range",  getName_age_rangeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("DVT年龄名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b14","id_age_range=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * DVT体重指数名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_bmiADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_bmi",  getName_bmiCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("DVT体重指数名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b15","id_bmi=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * DVT活动名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_activeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_active",  getName_activeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("DVT活动名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b16","id_active=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * DVT创伤风险名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_trauma_riskADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_trauma_risk",  getName_trauma_riskCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("DVT创伤风险名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b17","id_trauma_risk=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * DVT特殊风险名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_special_riskADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_special_risk",  getName_special_riskCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("DVT特殊风险名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b18","id_special_risk=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * DVT高危疾病名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_disease_riskADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_disease_risk",  getName_disease_riskCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("DVT高危疾病名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b19","id_disease_risk=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * DVT外科手术名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_surgeryADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_surgery",  getName_surgeryCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("DVT外科手术名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b20","id_surgery=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * DVT护理措施名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_nursing_measuresADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_nursing_measures",  getName_nursing_measuresCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("DVT护理措施名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b21","id_nursing_measures=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * DVT执行者姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_signatureADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_signature",  getName_signatureCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("DVT执行者姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a1b13","id_signature=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取DVT风险评估单列表ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dvtriskasslistCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dvtriskasslist");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("DVT风险评估单列表ID"); 
		return column;
	}
	/**
	 * 获取DVT风险评估单ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dvtCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dvt");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("DVT风险评估单ID"); 
		return column;
	}
	/**
	 * 获取DVT年龄表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_age_rangeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_age_range");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("DVT年龄"); 
		return column;
	}
	/**
	 * 获取DVT年龄编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_age_rangeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_age_range");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("DVT年龄编码"); 
		return column;
	}
	/**
	 * 获取DVT体重指数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_bmiCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_bmi");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("DVT体重指数"); 
		return column;
	}
	/**
	 * 获取DVT体重指数编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_bmiCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_bmi");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("DVT体重指数编码"); 
		return column;
	}
	/**
	 * 获取DVT活动表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_activeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_active");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("DVT活动"); 
		return column;
	}
	/**
	 * 获取DVT活动编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_activeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_active");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("DVT活动编码"); 
		return column;
	}
	/**
	 * 获取DVT创伤风险表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_trauma_riskCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_trauma_risk");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("DVT创伤风险"); 
		return column;
	}
	/**
	 * 获取DVT创伤风险编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_trauma_riskCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_trauma_risk");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("DVT创伤风险编码"); 
		return column;
	}
	/**
	 * 获取DVT特殊风险表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_special_riskCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_special_risk");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("DVT特殊风险"); 
		return column;
	}
	/**
	 * 获取DVT特殊风险编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_special_riskCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_special_risk");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("DVT特殊风险编码"); 
		return column;
	}
	/**
	 * 获取DVT高危疾病表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_disease_riskCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_disease_risk");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("DVT高危疾病"); 
		return column;
	}
	/**
	 * 获取DVT高危疾病编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_disease_riskCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_disease_risk");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("DVT高危疾病编码"); 
		return column;
	}
	/**
	 * 获取DVT外科手术表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_surgeryCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_surgery");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("DVT外科手术"); 
		return column;
	}
	/**
	 * 获取DVT外科手术编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_surgeryCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_surgery");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("DVT外科手术编码"); 
		return column;
	}
	/**
	 * 获取DVT护理措施表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_nursing_measuresCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_nursing_measures");
		column.setLength(2000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("DVT护理措施"); 
		return column;
	}
	/**
	 * 获取DVT护理措施编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_nursing_measuresCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_nursing_measures");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("DVT护理措施编码"); 
		return column;
	}
	/**
	 * 获取DVT执行者签名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_signatureCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_signature");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("DVT执行者签名"); 
		return column;
	}
	/**
	 * 获取DVT体重表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNum_weightCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Num_weight");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("DVT体重"); 
		return column;
	}
	/**
	 * 获取DVT身高表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNum_heightCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Num_height");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("DVT身高"); 
		return column;
	}
	/**
	 * 获取DVT执行日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getExecution_dateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Execution_date");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("DVT执行日期"); 
		return column;
	}
	/**
	 * 获取DVT年龄评分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSc_age_rangeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sc_age_range");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("DVT年龄评分"); 
		return column;
	}
	/**
	 * 获取DVT体重指数评分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSc_bmiCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sc_bmi");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("DVT体重指数评分"); 
		return column;
	}
	/**
	 * 获取DVT活动评分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSc_activeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sc_active");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("DVT活动评分"); 
		return column;
	}
	/**
	 * 获取DVT创伤风险评分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSc_trauma_riskCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sc_trauma_risk");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("DVT创伤风险评分"); 
		return column;
	}
	/**
	 * 获取DVT特殊风险评分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSc_special_riskCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sc_special_risk");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("DVT特殊风险评分"); 
		return column;
	}
	/**
	 * 获取DVT高危疾病评分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSc_disease_riskCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sc_disease_risk");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("DVT高危疾病评分"); 
		return column;
	}
	/**
	 * 获取DVT外科手术评分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSc_surgeryCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sc_surgery");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("DVT外科手术评分"); 
		return column;
	}
	/**
	 * 获取DVT护理措施评分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSc_nursing_measuresCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sc_nursing_measures");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("DVT护理措施评分"); 
		return column;
	}
	/**
	 * 获取DVT总分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTotal_scoreCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Total_score");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("DVT总分"); 
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
	 * 获取DVT年龄名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_age_rangeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_age_range");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("DVT年龄名称"); 
		return column;
	}
	/**
	 * 获取DVT体重指数名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_bmiCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_bmi");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("DVT体重指数名称"); 
		return column;
	}
	/**
	 * 获取DVT活动名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_activeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_active");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("DVT活动名称"); 
		return column;
	}
	/**
	 * 获取DVT创伤风险名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_trauma_riskCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_trauma_risk");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("DVT创伤风险名称"); 
		return column;
	}
	/**
	 * 获取DVT特殊风险名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_special_riskCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_special_risk");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("DVT特殊风险名称"); 
		return column;
	}
	/**
	 * 获取DVT高危疾病名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_disease_riskCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_disease_risk");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("DVT高危疾病名称"); 
		return column;
	}
	/**
	 * 获取DVT外科手术名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_surgeryCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_surgery");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("DVT外科手术名称"); 
		return column;
	}
	/**
	 * 获取DVT护理措施名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_nursing_measuresCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_nursing_measures");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("DVT护理措施名称"); 
		return column;
	}
	/**
	 * 获取DVT执行者姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_signatureCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_signature");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("DVT执行者姓名"); 
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
