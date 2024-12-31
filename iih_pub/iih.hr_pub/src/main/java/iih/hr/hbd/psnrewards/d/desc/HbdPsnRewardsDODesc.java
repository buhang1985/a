
package iih.hr.hbd.psnrewards.d.desc;

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
 * 人员奖惩 DO 元数据信息
 */
public class HbdPsnRewardsDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.hr.hbd.psnrewards.d.HbdPsnRewardsDO";
	public static final String CLASS_DISPALYNAME = "人员奖惩";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "HR_HBD_PSN_REWARDS";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_hbd_psn_rewards";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public HbdPsnRewardsDODesc(){
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
		this.setKeyDesc(getId_hbd_psn_rewardsADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_hbd_psn_rewardsADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_psndocADesc(tblDesc));
		this.add(getYearADesc(tblDesc));
		this.add(getId_honortpADesc(tblDesc));
		this.add(getSd_honortpADesc(tblDesc));
		this.add(getName_honorADesc(tblDesc));
		this.add(getDt_honorADesc(tblDesc));
		this.add(getId_honor_levelADesc(tblDesc));
		this.add(getSd_honor_levelADesc(tblDesc));
		this.add(getId_honor_srcADesc(tblDesc));
		this.add(getSd_honor_srcADesc(tblDesc));
		this.add(getName_orgADesc(tblDesc));
		this.add(getId_jobtitleADesc(tblDesc));
		this.add(getSd_jobtitleADesc(tblDesc));
		this.add(getId_dutyADesc(tblDesc));
		this.add(getSd_dutyADesc(tblDesc));
		this.add(getId_emp_regADesc(tblDesc));
		this.add(getDt_regADesc(tblDesc));
		this.add(getId_emp_auditADesc(tblDesc));
		this.add(getDt_auditADesc(tblDesc));
		this.add(getDesADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getName_honortpADesc(tblDesc));
		this.add(getName_honor_levelADesc(tblDesc));
		this.add(getName_honor_srcADesc(tblDesc));
		this.add(getName_jobtitleADesc(tblDesc));
		this.add(getName_dutyADesc(tblDesc));
		this.add(getName_emp_regADesc(tblDesc));
		this.add(getName_emp_auditADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_hbd_psn_rewardsCDesc(tblDesc));
		tblDesc.add(getId_hbd_psn_rewardsCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_psndocCDesc(tblDesc));
		tblDesc.add(getYearCDesc(tblDesc));
		tblDesc.add(getId_honortpCDesc(tblDesc));
		tblDesc.add(getSd_honortpCDesc(tblDesc));
		tblDesc.add(getName_honorCDesc(tblDesc));
		tblDesc.add(getDt_honorCDesc(tblDesc));
		tblDesc.add(getId_honor_levelCDesc(tblDesc));
		tblDesc.add(getSd_honor_levelCDesc(tblDesc));
		tblDesc.add(getId_honor_srcCDesc(tblDesc));
		tblDesc.add(getSd_honor_srcCDesc(tblDesc));
		tblDesc.add(getName_orgCDesc(tblDesc));
		tblDesc.add(getId_jobtitleCDesc(tblDesc));
		tblDesc.add(getSd_jobtitleCDesc(tblDesc));
		tblDesc.add(getId_dutyCDesc(tblDesc));
		tblDesc.add(getSd_dutyCDesc(tblDesc));
		tblDesc.add(getId_emp_regCDesc(tblDesc));
		tblDesc.add(getDt_regCDesc(tblDesc));
		tblDesc.add(getId_emp_auditCDesc(tblDesc));
		tblDesc.add(getDt_auditCDesc(tblDesc));
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
	 * 人员奖惩主键标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_hbd_psn_rewardsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_hbd_psn_rewards",  getId_hbd_psn_rewardsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("人员奖惩主键标识");
		attrDesc.setNullable(true);
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
		attrDesc.setRefType(false);
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
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 护理人员属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_psndocADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_psndoc",  getId_psndocCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("护理人员");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 年份属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getYearADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Year",  getYearCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("年份");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 奖惩类型id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_honortpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_honortp",  getId_honortpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("奖惩类型id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 奖惩类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_honortpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_honortp",  getSd_honortpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("奖惩类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 奖惩名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_honorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_honor",  getName_honorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("奖惩名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 奖惩日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_honorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_honor",  getDt_honorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("奖惩日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 奖惩等级id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_honor_levelADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_honor_level",  getId_honor_levelCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("奖惩等级id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 奖惩等级属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_honor_levelADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_honor_level",  getSd_honor_levelCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("奖惩等级");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 奖惩来源id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_honor_srcADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_honor_src",  getId_honor_srcCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("奖惩来源id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 奖惩来源属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_honor_srcADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_honor_src",  getSd_honor_srcCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("奖惩来源");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 奖惩机构属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_orgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_org",  getName_orgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("奖惩机构");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 职称id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_jobtitleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_jobtitle",  getId_jobtitleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("职称id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 职称编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_jobtitleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_jobtitle",  getSd_jobtitleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("职称编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 职务id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dutyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_duty",  getId_dutyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("职务id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 职务属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_dutyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_duty",  getSd_dutyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("职务");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 登记人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_regADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_reg",  getId_emp_regCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("登记人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 登记时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_regADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_reg",  getDt_regCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("登记时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 审核人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_auditADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_audit",  getId_emp_auditCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("审核人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 审核时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_auditADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_audit",  getDt_auditCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("审核时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 描述属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Des",  getDesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("描述");
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
	 * 奖惩类型名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_honortpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_honortp",  getName_honortpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("奖惩类型名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b2","id_honortp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 奖惩等级属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_honor_levelADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_honor_level",  getName_honor_levelCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("奖惩等级");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b3","id_honor_level=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 奖惩来源属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_honor_srcADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_honor_src",  getName_honor_srcCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("奖惩来源");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b4","id_honor_src=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 职称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_jobtitleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_jobtitle",  getName_jobtitleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("职称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b5","id_jobtitle=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 职务属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dutyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_duty",  getName_dutyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("职务");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b6","id_duty=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 登记人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_emp_regADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_emp_reg",  getName_emp_regCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("登记人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b7","id_emp_reg=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 审核人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_emp_auditADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_emp_audit",  getName_emp_auditCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("审核人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b8","id_emp_audit=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取人员奖惩主键标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_hbd_psn_rewardsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_hbd_psn_rewards");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("人员奖惩主键标识"); 
		return column;
	}
	/**
	 * 获取组织表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_orgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_org");
		column.setLength(50);
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
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("集团"); 
		return column;
	}
	/**
	 * 获取护理人员表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_psndocCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_psndoc");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("护理人员"); 
		return column;
	}
	/**
	 * 获取年份表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getYearCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Year");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("年份"); 
		return column;
	}
	/**
	 * 获取奖惩类型id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_honortpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_honortp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("奖惩类型id"); 
		return column;
	}
	/**
	 * 获取奖惩类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_honortpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_honortp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("奖惩类型"); 
		return column;
	}
	/**
	 * 获取奖惩名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_honorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_honor");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("奖惩名称"); 
		return column;
	}
	/**
	 * 获取奖惩日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_honorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_honor");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("奖惩日期"); 
		return column;
	}
	/**
	 * 获取奖惩等级id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_honor_levelCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_honor_level");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("奖惩等级id"); 
		return column;
	}
	/**
	 * 获取奖惩等级表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_honor_levelCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_honor_level");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("奖惩等级"); 
		return column;
	}
	/**
	 * 获取奖惩来源id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_honor_srcCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_honor_src");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("奖惩来源id"); 
		return column;
	}
	/**
	 * 获取奖惩来源表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_honor_srcCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_honor_src");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("奖惩来源"); 
		return column;
	}
	/**
	 * 获取奖惩机构表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_orgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_org");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("奖惩机构"); 
		return column;
	}
	/**
	 * 获取职称id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_jobtitleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_jobtitle");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("职称id"); 
		return column;
	}
	/**
	 * 获取职称编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_jobtitleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_jobtitle");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("职称编码"); 
		return column;
	}
	/**
	 * 获取职务id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dutyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_duty");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("职务id"); 
		return column;
	}
	/**
	 * 获取职务表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_dutyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_duty");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("职务"); 
		return column;
	}
	/**
	 * 获取登记人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_regCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_reg");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("登记人"); 
		return column;
	}
	/**
	 * 获取登记时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_regCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_reg");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("登记时间"); 
		return column;
	}
	/**
	 * 获取审核人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_auditCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_audit");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("审核人"); 
		return column;
	}
	/**
	 * 获取审核时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_auditCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_audit");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("审核时间"); 
		return column;
	}
	/**
	 * 获取描述表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Des");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("描述"); 
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
	 * 获取奖惩类型名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_honortpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_honortp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("奖惩类型名称"); 
		return column;
	}
	/**
	 * 获取奖惩等级表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_honor_levelCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_honor_level");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("奖惩等级"); 
		return column;
	}
	/**
	 * 获取奖惩来源表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_honor_srcCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_honor_src");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("奖惩来源"); 
		return column;
	}
	/**
	 * 获取职称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_jobtitleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_jobtitle");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("职称"); 
		return column;
	}
	/**
	 * 获取职务表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_dutyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_duty");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("职务"); 
		return column;
	}
	/**
	 * 获取登记人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_emp_regCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_emp_reg");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("登记人"); 
		return column;
	}
	/**
	 * 获取审核人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_emp_auditCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_emp_audit");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("审核人"); 
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
