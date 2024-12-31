
package iih.nm.nca.satisfsurvey.d.desc;

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
 * 满意度调查 DO 元数据信息
 */
public class SatisfSurveyDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.nm.nca.satisfsurvey.d.SatisfSurveyDO";
	public static final String CLASS_DISPALYNAME = "满意度调查";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "nm_nca_srvy";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_nca_srvy";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public SatisfSurveyDODesc(){
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
		this.setKeyDesc(getId_nca_srvyADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_nca_srvyADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getDt_srvyADesc(tblDesc));
		this.add(getId_psn_srvyADesc(tblDesc));
		this.add(getSd_psn_srvyADesc(tblDesc));
		this.add(getId_dep_srvyADesc(tblDesc));
		this.add(getId_lvl_srvyADesc(tblDesc));
		this.add(getSd_lvl_srvyADesc(tblDesc));
		this.add(getId_who_srvyADesc(tblDesc));
		this.add(getSd_who_srvyADesc(tblDesc));
		this.add(getId_ntpl_appADesc(tblDesc));
		this.add(getId_who_evaADesc(tblDesc));
		this.add(getSd_who_evaADesc(tblDesc));
		this.add(getId_nbd_kpiADesc(tblDesc));
		this.add(getId_nbd_ntplADesc(tblDesc));
		this.add(getScore_caADesc(tblDesc));
		this.add(getId_lvl_caADesc(tblDesc));
		this.add(getSd_lvl_caADesc(tblDesc));
		this.add(getId_dep_nurADesc(tblDesc));
		this.add(getDesADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getName_psn_srvyADesc(tblDesc));
		this.add(getJob_noADesc(tblDesc));
		this.add(getName_dep_srvyADesc(tblDesc));
		this.add(getCode_dep_srvyADesc(tblDesc));
		this.add(getName_lvl_srvyADesc(tblDesc));
		this.add(getCode_lvl_srvyADesc(tblDesc));
		this.add(getName_who_srvyADesc(tblDesc));
		this.add(getCode_who_srvyADesc(tblDesc));
		this.add(getName_who_evaADesc(tblDesc));
		this.add(getCode_who_evaADesc(tblDesc));
		this.add(getName_kpiADesc(tblDesc));
		this.add(getCode_nbd_ntplADesc(tblDesc));
		this.add(getName_nbd_ntplADesc(tblDesc));
		this.add(getName_lvl_caADesc(tblDesc));
		this.add(getCode_lvl_caADesc(tblDesc));
		this.add(getName_dep_nurADesc(tblDesc));
		this.add(getCode_dep_nurADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_nca_srvyCDesc(tblDesc));
		tblDesc.add(getId_nca_srvyCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getDt_srvyCDesc(tblDesc));
		tblDesc.add(getId_psn_srvyCDesc(tblDesc));
		tblDesc.add(getSd_psn_srvyCDesc(tblDesc));
		tblDesc.add(getId_dep_srvyCDesc(tblDesc));
		tblDesc.add(getId_lvl_srvyCDesc(tblDesc));
		tblDesc.add(getSd_lvl_srvyCDesc(tblDesc));
		tblDesc.add(getId_who_srvyCDesc(tblDesc));
		tblDesc.add(getSd_who_srvyCDesc(tblDesc));
		tblDesc.add(getId_ntpl_appCDesc(tblDesc));
		tblDesc.add(getId_who_evaCDesc(tblDesc));
		tblDesc.add(getSd_who_evaCDesc(tblDesc));
		tblDesc.add(getId_nbd_kpiCDesc(tblDesc));
		tblDesc.add(getId_nbd_ntplCDesc(tblDesc));
		tblDesc.add(getScore_caCDesc(tblDesc));
		tblDesc.add(getId_lvl_caCDesc(tblDesc));
		tblDesc.add(getSd_lvl_caCDesc(tblDesc));
		tblDesc.add(getId_dep_nurCDesc(tblDesc));
		tblDesc.add(getDesCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 满意度调查主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_nca_srvyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_nca_srvy",  getId_nca_srvyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("满意度调查主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
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
	 * 调查时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_srvyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_srvy",  getDt_srvyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("调查时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 调查人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_psn_srvyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_psn_srvy",  getId_psn_srvyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("调查人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 调查人编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_psn_srvyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_psn_srvy",  getSd_psn_srvyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("调查人编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 调查科室属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dep_srvyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep_srvy",  getId_dep_srvyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("调查科室");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 调查级别属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_lvl_srvyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_lvl_srvy",  getId_lvl_srvyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("调查级别");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 调查级别编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_lvl_srvyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_lvl_srvy",  getSd_lvl_srvyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("调查级别编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 调查对象属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_who_srvyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_who_srvy",  getId_who_srvyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("调查对象");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 调查对象编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_who_srvyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_who_srvy",  getSd_who_srvyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("调查对象编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 调查内容属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ntpl_appADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ntpl_app",  getId_ntpl_appCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("调查内容");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 评价对象属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_who_evaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_who_eva",  getId_who_evaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("评价对象");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 评价对象编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_who_evaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_who_eva",  getSd_who_evaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("评价对象编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 满意度指标属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_nbd_kpiADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_nbd_kpi",  getId_nbd_kpiCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("满意度指标");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 文档模板属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_nbd_ntplADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_nbd_ntpl",  getId_nbd_ntplCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("文档模板");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 满意度评分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getScore_caADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Score_ca",  getScore_caCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("满意度评分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 满意度评级属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_lvl_caADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_lvl_ca",  getId_lvl_caCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("满意度评级");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 满意度评级编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_lvl_caADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_lvl_ca",  getSd_lvl_caCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("满意度评级编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 护理单元属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dep_nurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep_nur",  getId_dep_nurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("护理单元");
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
	private IAttrDesc getDesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Des",  getDesCDesc(tblDesc), this);
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
	private IAttrDesc getName_psn_srvyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_psn_srvy",  getName_psn_srvyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("人员姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"NM_NUR a0b6","id_psn_srvy=id_nur","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 工号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getJob_noADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Job_no",  getJob_noCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("工号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"NM_NUR a0b6","id_psn_srvy=id_nur","job_no"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 调查科室名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dep_srvyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dep_srvy",  getName_dep_srvyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("调查科室名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b7","id_dep_srvy=id_dep","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 调查科室编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_dep_srvyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_dep_srvy",  getCode_dep_srvyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("调查科室编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b7","id_dep_srvy=id_dep","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 调查级别名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_lvl_srvyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_lvl_srvy",  getName_lvl_srvyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("调查级别名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b9","id_lvl_srvy=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 调查级别编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_lvl_srvyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_lvl_srvy",  getCode_lvl_srvyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("调查级别编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b9","id_lvl_srvy=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 调查对象名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_who_srvyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_who_srvy",  getName_who_srvyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("调查对象名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b10","id_who_srvy=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 调查对象编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_who_srvyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_who_srvy",  getCode_who_srvyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("调查对象编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b10","id_who_srvy=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 评价对象名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_who_evaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_who_eva",  getName_who_evaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("评价对象名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b11","id_who_eva=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 评价对象编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_who_evaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_who_eva",  getCode_who_evaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("评价对象编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b11","id_who_eva=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 指标名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_kpiADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_kpi",  getName_kpiCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("指标名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"NM_NBD_KPI a0b13","id_nbd_kpi=id_nbd_kpi","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 模板编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_nbd_ntplADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_nbd_ntpl",  getCode_nbd_ntplCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("模板编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"NM_NBD_NTPL a0b14","id_nbd_ntpl=id_nbd_ntpl","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 模板名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_nbd_ntplADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_nbd_ntpl",  getName_nbd_ntplCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("模板名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"NM_NBD_NTPL a0b14","id_nbd_ntpl=id_nbd_ntpl","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 满意度评级名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_lvl_caADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_lvl_ca",  getName_lvl_caCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("满意度评级名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b12","id_lvl_ca=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 满意度评级编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_lvl_caADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_lvl_ca",  getCode_lvl_caCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("满意度评级编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b12","id_lvl_ca=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dep_nurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dep_nur",  getName_dep_nurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b8","id_dep_nur=id_dep","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_dep_nurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_dep_nur",  getCode_dep_nurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b8","id_dep_nur=id_dep","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取满意度调查主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_nca_srvyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_nca_srvy");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("满意度调查主键"); 
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
	 * 获取调查时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_srvyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_srvy");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("调查时间"); 
		return column;
	}
	/**
	 * 获取调查人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_psn_srvyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_psn_srvy");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("调查人"); 
		return column;
	}
	/**
	 * 获取调查人编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_psn_srvyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_psn_srvy");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("调查人编码"); 
		return column;
	}
	/**
	 * 获取调查科室表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dep_srvyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep_srvy");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("调查科室"); 
		return column;
	}
	/**
	 * 获取调查级别表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_lvl_srvyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_lvl_srvy");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("调查级别"); 
		return column;
	}
	/**
	 * 获取调查级别编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_lvl_srvyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_lvl_srvy");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("调查级别编码"); 
		return column;
	}
	/**
	 * 获取调查对象表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_who_srvyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_who_srvy");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("调查对象"); 
		return column;
	}
	/**
	 * 获取调查对象编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_who_srvyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_who_srvy");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("调查对象编码"); 
		return column;
	}
	/**
	 * 获取调查内容表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ntpl_appCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ntpl_app");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("调查内容"); 
		return column;
	}
	/**
	 * 获取评价对象表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_who_evaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_who_eva");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("评价对象"); 
		return column;
	}
	/**
	 * 获取评价对象编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_who_evaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_who_eva");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("评价对象编码"); 
		return column;
	}
	/**
	 * 获取满意度指标表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_nbd_kpiCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_nbd_kpi");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("满意度指标"); 
		return column;
	}
	/**
	 * 获取文档模板表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_nbd_ntplCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_nbd_ntpl");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("文档模板"); 
		return column;
	}
	/**
	 * 获取满意度评分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getScore_caCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Score_ca");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("满意度评分"); 
		return column;
	}
	/**
	 * 获取满意度评级表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_lvl_caCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_lvl_ca");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("满意度评级"); 
		return column;
	}
	/**
	 * 获取满意度评级编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_lvl_caCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_lvl_ca");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("满意度评级编码"); 
		return column;
	}
	/**
	 * 获取护理单元表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dep_nurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep_nur");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("护理单元"); 
		return column;
	}
	/**
	 * 获取备注表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Des");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备注"); 
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
	private IColumnDesc getName_psn_srvyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_psn_srvy");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("人员姓名"); 
		return column;
	}
	/**
	 * 获取工号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getJob_noCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Job_no");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("工号"); 
		return column;
	}
	/**
	 * 获取调查科室名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_dep_srvyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dep_srvy");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("调查科室名称"); 
		return column;
	}
	/**
	 * 获取调查科室编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_dep_srvyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_dep_srvy");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("调查科室编码"); 
		return column;
	}
	/**
	 * 获取调查级别名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_lvl_srvyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_lvl_srvy");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("调查级别名称"); 
		return column;
	}
	/**
	 * 获取调查级别编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_lvl_srvyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_lvl_srvy");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("调查级别编码"); 
		return column;
	}
	/**
	 * 获取调查对象名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_who_srvyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_who_srvy");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("调查对象名称"); 
		return column;
	}
	/**
	 * 获取调查对象编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_who_srvyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_who_srvy");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("调查对象编码"); 
		return column;
	}
	/**
	 * 获取评价对象名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_who_evaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_who_eva");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("评价对象名称"); 
		return column;
	}
	/**
	 * 获取评价对象编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_who_evaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_who_eva");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("评价对象编码"); 
		return column;
	}
	/**
	 * 获取指标名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_kpiCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_kpi");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("指标名称"); 
		return column;
	}
	/**
	 * 获取模板编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_nbd_ntplCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_nbd_ntpl");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("模板编码"); 
		return column;
	}
	/**
	 * 获取模板名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_nbd_ntplCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_nbd_ntpl");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("模板名称"); 
		return column;
	}
	/**
	 * 获取满意度评级名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_lvl_caCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_lvl_ca");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("满意度评级名称"); 
		return column;
	}
	/**
	 * 获取满意度评级编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_lvl_caCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_lvl_ca");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("满意度评级编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_dep_nurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dep_nur");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_dep_nurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_dep_nur");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id","Id_nca_srvy");
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
