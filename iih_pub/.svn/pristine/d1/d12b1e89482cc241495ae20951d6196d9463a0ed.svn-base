
package iih.ci.ord.specanti.d.desc;

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
 * 特殊级抗菌药会诊受邀对象 DO 元数据信息
 */
public class SpecAntiInvitesDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.ci.ord.specanti.d.SpecAntiInvitesDO";
	public static final String CLASS_DISPALYNAME = "特殊级抗菌药会诊受邀对象";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "ci_ap_spec_anti_invites";
	public static final String TABLE_ALIAS_NAME = "a1";
	public static final String PRIMARYKEY_FIELDNAME="Id_apspecantiinvites";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public SpecAntiInvitesDODesc(){
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
		this.setKeyDesc(getId_apspecantiinvitesADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_apspecanticonsADesc(tblDesc));
		this.add(getId_apspecantiinvitesADesc(tblDesc));
		this.add(getId_orADesc(tblDesc));
		this.add(getId_apspecanticonsADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getName_orgADesc(tblDesc));
		this.add(getId_depADesc(tblDesc));
		this.add(getCode_depADesc(tblDesc));
		this.add(getName_depADesc(tblDesc));
		this.add(getId_empADesc(tblDesc));
		this.add(getCode_empADesc(tblDesc));
		this.add(getName_empADesc(tblDesc));
		this.add(getId_emp_titleADesc(tblDesc));
		this.add(getSd_emp_titleADesc(tblDesc));
		this.add(getName_emp_titleADesc(tblDesc));
		this.add(getFg_invitedADesc(tblDesc));
		this.add(getId_consmdADesc(tblDesc));
		this.add(getSd_consmdADesc(tblDesc));
		this.add(getAdviceADesc(tblDesc));
		this.add(getId_emp_recordADesc(tblDesc));
		this.add(getDt_recordADesc(tblDesc));
		this.add(getDt_consADesc(tblDesc));
		this.add(getId_approve_empADesc(tblDesc));
		this.add(getSd_approve_empADesc(tblDesc));
		this.add(getFg_sign_recordADesc(tblDesc));
		this.add(getSortnoADesc(tblDesc));
		this.add(getName_consmdADesc(tblDesc));
		this.add(getName_emp_recordADesc(tblDesc));
		this.add(getName_approve_empADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_apspecantiinvitesCDesc(tblDesc));
		tblDesc.add(getId_apspecantiinvitesCDesc(tblDesc));
		tblDesc.add(getId_orCDesc(tblDesc));
		tblDesc.add(getId_apspecanticonsCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getName_orgCDesc(tblDesc));
		tblDesc.add(getId_depCDesc(tblDesc));
		tblDesc.add(getCode_depCDesc(tblDesc));
		tblDesc.add(getName_depCDesc(tblDesc));
		tblDesc.add(getId_empCDesc(tblDesc));
		tblDesc.add(getCode_empCDesc(tblDesc));
		tblDesc.add(getName_empCDesc(tblDesc));
		tblDesc.add(getId_emp_titleCDesc(tblDesc));
		tblDesc.add(getSd_emp_titleCDesc(tblDesc));
		tblDesc.add(getName_emp_titleCDesc(tblDesc));
		tblDesc.add(getFg_invitedCDesc(tblDesc));
		tblDesc.add(getId_consmdCDesc(tblDesc));
		tblDesc.add(getSd_consmdCDesc(tblDesc));
		tblDesc.add(getAdviceCDesc(tblDesc));
		tblDesc.add(getId_emp_recordCDesc(tblDesc));
		tblDesc.add(getDt_recordCDesc(tblDesc));
		tblDesc.add(getDt_consCDesc(tblDesc));
		tblDesc.add(getId_approve_empCDesc(tblDesc));
		tblDesc.add(getSd_approve_empCDesc(tblDesc));
		tblDesc.add(getFg_sign_recordCDesc(tblDesc));
		tblDesc.add(getSortnoCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 特殊级抗菌药会诊受邀对象ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_apspecantiinvitesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_apspecantiinvites",  getId_apspecantiinvitesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("特殊级抗菌药会诊受邀对象ID");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 关联医嘱属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_orADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_or",  getId_orCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("关联医嘱");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 抗菌药会诊申请属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_apspecanticonsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_apspecanticons",  getId_apspecanticonsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("抗菌药会诊申请");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 受邀机构id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_orgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_org",  getId_orgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("受邀机构id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 受邀机构名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_orgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_org",  getName_orgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("受邀机构名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 受邀科室id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_depADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep",  getId_depCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("受邀科室id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 受邀科室编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_depADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_dep",  getCode_depCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("受邀科室编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 受邀科室名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_depADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dep",  getName_depCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("受邀科室名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 受邀人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_empADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp",  getId_empCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("受邀人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 受邀人编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_empADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_emp",  getCode_empCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("受邀人编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 受邀人名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_empADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_emp",  getName_empCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("受邀人名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 受邀人职称id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_titleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_title",  getId_emp_titleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("受邀人职称id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 受邀人职称编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_emp_titleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_emp_title",  getSd_emp_titleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("受邀人职称编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 受邀人职称名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_emp_titleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_emp_title",  getName_emp_titleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("受邀人职称名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否应邀参与会诊属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_invitedADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_invited",  getFg_invitedCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否应邀参与会诊");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 会诊方式ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_consmdADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_consmd",  getId_consmdCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("会诊方式ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 会诊方式编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_consmdADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_consmd",  getSd_consmdCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("会诊方式编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 会诊专家意见属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAdviceADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Advice",  getAdviceCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("会诊专家意见");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 会诊意见记录人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_recordADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_record",  getId_emp_recordCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("会诊意见记录人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 会诊意见记录时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_recordADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_record",  getDt_recordCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("会诊意见记录时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 实际会诊时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_consADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_cons",  getDt_consCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("实际会诊时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 专家会诊结果ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_approve_empADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_approve_emp",  getId_approve_empCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("专家会诊结果ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 专家会诊结果编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_approve_empADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_approve_emp",  getSd_approve_empCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("专家会诊结果编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 会诊记录签署标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_sign_recordADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_sign_record",  getFg_sign_recordCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("会诊记录签署标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 序号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSortnoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sortno",  getSortnoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("序号");
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
	private IAttrDesc getName_consmdADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_consmd",  getName_consmdCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b8","id_consmd=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_emp_recordADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_emp_record",  getName_emp_recordCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a1b9","id_emp_record=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_approve_empADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_approve_emp",  getName_approve_empCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b10","id_approve_emp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取特殊级抗菌药会诊受邀对象ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_apspecantiinvitesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_apspecantiinvites");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("特殊级抗菌药会诊受邀对象ID"); 
		return column;
	}
	/**
	 * 获取关联医嘱表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_orCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_or");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("关联医嘱"); 
		return column;
	}
	/**
	 * 获取抗菌药会诊申请表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_apspecanticonsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_apspecanticons");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("抗菌药会诊申请"); 
		return column;
	}
	/**
	 * 获取受邀机构id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_orgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_org");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("受邀机构id"); 
		return column;
	}
	/**
	 * 获取受邀机构名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_orgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_org");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("受邀机构名称"); 
		return column;
	}
	/**
	 * 获取受邀科室id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_depCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("受邀科室id"); 
		return column;
	}
	/**
	 * 获取受邀科室编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_depCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_dep");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("受邀科室编码"); 
		return column;
	}
	/**
	 * 获取受邀科室名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_depCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dep");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("受邀科室名称"); 
		return column;
	}
	/**
	 * 获取受邀人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_empCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("受邀人"); 
		return column;
	}
	/**
	 * 获取受邀人编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_empCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_emp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("受邀人编码"); 
		return column;
	}
	/**
	 * 获取受邀人名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_empCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_emp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("受邀人名称"); 
		return column;
	}
	/**
	 * 获取受邀人职称id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_titleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_title");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("受邀人职称id"); 
		return column;
	}
	/**
	 * 获取受邀人职称编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_emp_titleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_emp_title");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("受邀人职称编码"); 
		return column;
	}
	/**
	 * 获取受邀人职称名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_emp_titleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_emp_title");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("受邀人职称名称"); 
		return column;
	}
	/**
	 * 获取是否应邀参与会诊表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_invitedCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_invited");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否应邀参与会诊"); 
		return column;
	}
	/**
	 * 获取会诊方式ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_consmdCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_consmd");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("会诊方式ID"); 
		return column;
	}
	/**
	 * 获取会诊方式编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_consmdCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_consmd");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("会诊方式编码"); 
		return column;
	}
	/**
	 * 获取会诊专家意见表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAdviceCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Advice");
		column.setLength(2000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("会诊专家意见"); 
		return column;
	}
	/**
	 * 获取会诊意见记录人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_recordCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_record");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("会诊意见记录人"); 
		return column;
	}
	/**
	 * 获取会诊意见记录时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_recordCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_record");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("会诊意见记录时间"); 
		return column;
	}
	/**
	 * 获取实际会诊时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_consCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_cons");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("实际会诊时间"); 
		return column;
	}
	/**
	 * 获取专家会诊结果ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_approve_empCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_approve_emp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("专家会诊结果ID"); 
		return column;
	}
	/**
	 * 获取专家会诊结果编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_approve_empCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_approve_emp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("专家会诊结果编码"); 
		return column;
	}
	/**
	 * 获取会诊记录签署标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_sign_recordCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_sign_record");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("会诊记录签署标识"); 
		return column;
	}
	/**
	 * 获取序号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSortnoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sortno");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("序号"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_consmdCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_consmd");
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
	private IColumnDesc getName_emp_recordCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_emp_record");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("姓名"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_approve_empCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_approve_emp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
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
	}
	
	/**
	 * 设置实体默认值
	 */
	private void setDefaultValueMap(){
		defaultValueMap=new HashMap<String, Object>();
	}
	
}
