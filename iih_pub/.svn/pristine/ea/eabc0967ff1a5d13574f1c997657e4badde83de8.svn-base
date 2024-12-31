
package iih.bd.mhi.hpstaffinfo.d.desc;

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
 * 医保计划医院操作员信息上报 DO 元数据信息
 */
public class HpStaffInfoDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.bd.mhi.hpstaffinfo.d.HpStaffInfoDO";
	public static final String CLASS_DISPALYNAME = "医保计划医院操作员信息上报";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "BD_HP_STAFF_INFO";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_hpstaffinfo";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public HpStaffInfoDODesc(){
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
		this.setKeyDesc(getId_hpstaffinfoADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_hpstaffinfoADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_hpADesc(tblDesc));
		this.add(getCodeADesc(tblDesc));
		this.add(getNameADesc(tblDesc));
		this.add(getId_hprpADesc(tblDesc));
		this.add(getId_hpphytpADesc(tblDesc));
		this.add(getId_depADesc(tblDesc));
		this.add(getId_hpphytitleADesc(tblDesc));
		this.add(getAd_titleADesc(tblDesc));
		this.add(getAc_dutiesADesc(tblDesc));
		this.add(getGra_insADesc(tblDesc));
		this.add(getDept_codeADesc(tblDesc));
		this.add(getId_hpsexADesc(tblDesc));
		this.add(getTel_noADesc(tblDesc));
		this.add(getId_noADesc(tblDesc));
		this.add(getMain_diADesc(tblDesc));
		this.add(getId_hpditpADesc(tblDesc));
		this.add(getId_hpstafftpADesc(tblDesc));
		this.add(getId_emp_operADesc(tblDesc));
		this.add(getDt_operADesc(tblDesc));
		this.add(getFg_uploadADesc(tblDesc));
		this.add(getDt_uploadADesc(tblDesc));
		this.add(getWbcodeADesc(tblDesc));
		this.add(getPycodeADesc(tblDesc));
		this.add(getMnecodeADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getHprp_nameADesc(tblDesc));
		this.add(getHpphyty_nameADesc(tblDesc));
		this.add(getDep_nameADesc(tblDesc));
		this.add(getDep_codeADesc(tblDesc));
		this.add(getHpphytitle_nameADesc(tblDesc));
		this.add(getHpsex_nameADesc(tblDesc));
		this.add(getHpditp_nameADesc(tblDesc));
		this.add(getHpstafftp_nameADesc(tblDesc));
		this.add(getOper_nameADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_hpstaffinfoCDesc(tblDesc));
		tblDesc.add(getId_hpstaffinfoCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_hpCDesc(tblDesc));
		tblDesc.add(getCodeCDesc(tblDesc));
		tblDesc.add(getNameCDesc(tblDesc));
		tblDesc.add(getId_hprpCDesc(tblDesc));
		tblDesc.add(getId_hpphytpCDesc(tblDesc));
		tblDesc.add(getId_depCDesc(tblDesc));
		tblDesc.add(getId_hpphytitleCDesc(tblDesc));
		tblDesc.add(getAd_titleCDesc(tblDesc));
		tblDesc.add(getAc_dutiesCDesc(tblDesc));
		tblDesc.add(getGra_insCDesc(tblDesc));
		tblDesc.add(getDept_codeCDesc(tblDesc));
		tblDesc.add(getId_hpsexCDesc(tblDesc));
		tblDesc.add(getTel_noCDesc(tblDesc));
		tblDesc.add(getId_noCDesc(tblDesc));
		tblDesc.add(getMain_diCDesc(tblDesc));
		tblDesc.add(getId_hpditpCDesc(tblDesc));
		tblDesc.add(getId_hpstafftpCDesc(tblDesc));
		tblDesc.add(getId_emp_operCDesc(tblDesc));
		tblDesc.add(getDt_operCDesc(tblDesc));
		tblDesc.add(getFg_uploadCDesc(tblDesc));
		tblDesc.add(getDt_uploadCDesc(tblDesc));
		tblDesc.add(getWbcodeCDesc(tblDesc));
		tblDesc.add(getPycodeCDesc(tblDesc));
		tblDesc.add(getMnecodeCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 医保计划医院操作员信息主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_hpstaffinfoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_hpstaffinfo",  getId_hpstaffinfoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医保计划医院操作员信息主键");
		attrDesc.setNullable(false);
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
	 * 医保计划属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_hpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_hp",  getId_hpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医保计划");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 医师编号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code",  getCodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医师编号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name",  getNameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医保计划处方权主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_hprpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_hprp",  getId_hprpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医保计划处方权主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 医保计划医师类别主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_hpphytpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_hpphytp",  getId_hpphytpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医保计划医师类别主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 科室主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_depADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep",  getId_depCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("科室主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 医保计划医师职称主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_hpphytitleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_hpphytitle",  getId_hpphytitleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医保计划医师职称主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 行政职称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAd_titleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ad_title",  getAd_titleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("行政职称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 学术职务属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAc_dutiesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ac_duties",  getAc_dutiesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("学术职务");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 毕业院校属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getGra_insADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Gra_ins",  getGra_insCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("毕业院校");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 科室编号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDept_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dept_code",  getDept_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("科室编号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医保计划性别主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_hpsexADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_hpsex",  getId_hpsexCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医保计划性别主键");
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
	private IAttrDesc getTel_noADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Tel_no",  getTel_noCDesc(tblDesc), this);
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
	 * 身份证号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_noADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_no",  getId_noCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("身份证号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 主治疾病内容属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMain_diADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Main_di",  getMain_diCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("主治疾病内容");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医保计划疾病分类主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_hpditpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_hpditp",  getId_hpditpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医保计划疾病分类主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 医保计划医院人员类别主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_hpstafftpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_hpstafftp",  getId_hpstafftpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医保计划医院人员类别主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 医院经办人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_operADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_oper",  getId_emp_operCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医院经办人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 经办日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_operADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_oper",  getDt_operCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("经办日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否上传标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_uploadADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_upload",  getFg_uploadCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否上传标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 上传日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_uploadADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_upload",  getDt_uploadCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("上传日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 五笔属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWbcodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Wbcode",  getWbcodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("五笔");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 拼音属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPycodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pycode",  getPycodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("拼音");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 助记码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMnecodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mnecode",  getMnecodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("助记码");
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
	 * 处方权名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHprp_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Hprp_name",  getHprp_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("处方权名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"BD_HP_RP a0b7","id_hprp=id_hprp","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医师类别名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHpphyty_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Hpphyty_name",  getHpphyty_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医师类别名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"BD_HP_PHY_TP a0b8","id_hpphytp=id_hpphytp","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 部门名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDep_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dep_name",  getDep_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("部门名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b9","id_dep=id_dep","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDep_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dep_code",  getDep_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b9","id_dep=id_dep","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医师职称名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHpphytitle_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Hpphytitle_name",  getHpphytitle_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医师职称名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"BD_HP_PHY_TITLE a0b10","id_hpphytitle=id_hpphytitle","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 性别名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHpsex_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Hpsex_name",  getHpsex_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("性别名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"BD_HP_SEX a0b11","id_hpsex=id_hpsex","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 疾病分类名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHpditp_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Hpditp_name",  getHpditp_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("疾病分类名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"BD_HP_DI_TP a0b12","id_hpditp=id_hpditp","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 人员类别名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHpstafftp_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Hpstafftp_name",  getHpstafftp_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("人员类别名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"BD_HP_STAFF_TP a0b13","id_hpstafftp=id_hpstafftp","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 经办人姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOper_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Oper_name",  getOper_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("经办人姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b14","id_emp_oper=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取医保计划医院操作员信息主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_hpstaffinfoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_hpstaffinfo");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("医保计划医院操作员信息主键"); 
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
	 * 获取医保计划表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_hpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_hp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医保计划"); 
		return column;
	}
	/**
	 * 获取医师编号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医师编号"); 
		return column;
	}
	/**
	 * 获取姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("姓名"); 
		return column;
	}
	/**
	 * 获取医保计划处方权主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_hprpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_hprp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医保计划处方权主键"); 
		return column;
	}
	/**
	 * 获取医保计划医师类别主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_hpphytpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_hpphytp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医保计划医师类别主键"); 
		return column;
	}
	/**
	 * 获取科室主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_depCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("科室主键"); 
		return column;
	}
	/**
	 * 获取医保计划医师职称主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_hpphytitleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_hpphytitle");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医保计划医师职称主键"); 
		return column;
	}
	/**
	 * 获取行政职称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAd_titleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ad_title");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("行政职称"); 
		return column;
	}
	/**
	 * 获取学术职务表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAc_dutiesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ac_duties");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("学术职务"); 
		return column;
	}
	/**
	 * 获取毕业院校表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getGra_insCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Gra_ins");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("毕业院校"); 
		return column;
	}
	/**
	 * 获取科室编号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDept_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dept_code");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("科室编号"); 
		return column;
	}
	/**
	 * 获取医保计划性别主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_hpsexCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_hpsex");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医保计划性别主键"); 
		return column;
	}
	/**
	 * 获取联系电话表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTel_noCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Tel_no");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("联系电话"); 
		return column;
	}
	/**
	 * 获取身份证号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_noCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_no");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("身份证号"); 
		return column;
	}
	/**
	 * 获取主治疾病内容表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMain_diCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Main_di");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("主治疾病内容"); 
		return column;
	}
	/**
	 * 获取医保计划疾病分类主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_hpditpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_hpditp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医保计划疾病分类主键"); 
		return column;
	}
	/**
	 * 获取医保计划医院人员类别主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_hpstafftpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_hpstafftp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医保计划医院人员类别主键"); 
		return column;
	}
	/**
	 * 获取医院经办人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_operCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_oper");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医院经办人"); 
		return column;
	}
	/**
	 * 获取经办日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_operCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_oper");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("经办日期"); 
		return column;
	}
	/**
	 * 获取是否上传标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_uploadCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_upload");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否上传标志"); 
		return column;
	}
	/**
	 * 获取上传日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_uploadCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_upload");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("上传日期"); 
		return column;
	}
	/**
	 * 获取五笔表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWbcodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Wbcode");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("五笔"); 
		return column;
	}
	/**
	 * 获取拼音表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPycodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pycode");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("拼音"); 
		return column;
	}
	/**
	 * 获取助记码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMnecodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mnecode");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("助记码"); 
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
	 * 获取处方权名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHprp_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Hprp_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("处方权名称"); 
		return column;
	}
	/**
	 * 获取医师类别名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHpphyty_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Hpphyty_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医师类别名称"); 
		return column;
	}
	/**
	 * 获取部门名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDep_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dep_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("部门名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDep_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dep_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取医师职称名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHpphytitle_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Hpphytitle_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医师职称名称"); 
		return column;
	}
	/**
	 * 获取性别名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHpsex_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Hpsex_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("性别名称"); 
		return column;
	}
	/**
	 * 获取疾病分类名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHpditp_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Hpditp_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("疾病分类名称"); 
		return column;
	}
	/**
	 * 获取人员类别名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHpstafftp_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Hpstafftp_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("人员类别名称"); 
		return column;
	}
	/**
	 * 获取经办人姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOper_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Oper_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("经办人姓名"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id","Id_hpstaffinfo");
		iBDDataInfoFldMap.put("id_org","Id_org");
		iBDDataInfoFldMap.put("code","Code");
		iBDDataInfoFldMap.put("name","Name");
		iBDDataInfoFldMap.put("id_group","Id_grp");
		iBDDataInfoFldMap.put("pycode","Pycode");
		iBDDataInfoFldMap.put("wbcode","Wbcode");
		iBDDataInfoFldMap.put("mnecode","Mnecode");
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
