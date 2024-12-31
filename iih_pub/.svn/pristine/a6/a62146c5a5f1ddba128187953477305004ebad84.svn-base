
package iih.bd.pp.inccasplit.d.desc;

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
 * 票据分票设置 DO 元数据信息
 */
public class BdInccaSplitDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.bd.pp.inccasplit.d.BdInccaSplitDO";
	public static final String CLASS_DISPALYNAME = "票据分票设置";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "bd_incca_split";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_inccasplit";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public BdInccaSplitDODesc(){
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
		this.setKeyDesc(getId_inccasplitADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_inccasplitADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_inccaADesc(tblDesc));
		this.add(getFg_splitbyoperADesc(tblDesc));
		this.add(getId_split_caseADesc(tblDesc));
		this.add(getSd_split_caseADesc(tblDesc));
		this.add(getCode_entpADesc(tblDesc));
		this.add(getId_disptpADesc(tblDesc));
		this.add(getSd_disptpADesc(tblDesc));
		this.add(getId_disp_ci_srvtpADesc(tblDesc));
		this.add(getSd_disp_ci_srvtpADesc(tblDesc));
		this.add(getId_disp_incitmADesc(tblDesc));
		this.add(getSd_disp_incitmADesc(tblDesc));
		this.add(getId_disp_notdetail_srvtpADesc(tblDesc));
		this.add(getSd_disp_notdetail_srvtpADesc(tblDesc));
		this.add(getItmbignumADesc(tblDesc));
		this.add(getFg_splitbyaccountADesc(tblDesc));
		this.add(getId_split_acc_caseADesc(tblDesc));
		this.add(getSd_split_acc_caseADesc(tblDesc));
		this.add(getCount_accountADesc(tblDesc));
		this.add(getId_ac_disptpADesc(tblDesc));
		this.add(getSd_ac_disptpADesc(tblDesc));
		this.add(getFg_sysADesc(tblDesc));
		this.add(getFg_activeADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getName_split_caseADesc(tblDesc));
		this.add(getName_disptpADesc(tblDesc));
		this.add(getName_disp_ci_srvtpADesc(tblDesc));
		this.add(getName_incitmADesc(tblDesc));
		this.add(getName_disp_notdetail_srvtpADesc(tblDesc));
		this.add(getName_split_acc_caseADesc(tblDesc));
		this.add(getName_ac_disptpADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_inccasplitCDesc(tblDesc));
		tblDesc.add(getId_inccasplitCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_inccaCDesc(tblDesc));
		tblDesc.add(getFg_splitbyoperCDesc(tblDesc));
		tblDesc.add(getId_split_caseCDesc(tblDesc));
		tblDesc.add(getSd_split_caseCDesc(tblDesc));
		tblDesc.add(getCode_entpCDesc(tblDesc));
		tblDesc.add(getId_disptpCDesc(tblDesc));
		tblDesc.add(getSd_disptpCDesc(tblDesc));
		tblDesc.add(getId_disp_ci_srvtpCDesc(tblDesc));
		tblDesc.add(getSd_disp_ci_srvtpCDesc(tblDesc));
		tblDesc.add(getId_disp_incitmCDesc(tblDesc));
		tblDesc.add(getSd_disp_incitmCDesc(tblDesc));
		tblDesc.add(getId_disp_notdetail_srvtpCDesc(tblDesc));
		tblDesc.add(getSd_disp_notdetail_srvtpCDesc(tblDesc));
		tblDesc.add(getItmbignumCDesc(tblDesc));
		tblDesc.add(getFg_splitbyaccountCDesc(tblDesc));
		tblDesc.add(getId_split_acc_caseCDesc(tblDesc));
		tblDesc.add(getSd_split_acc_caseCDesc(tblDesc));
		tblDesc.add(getCount_accountCDesc(tblDesc));
		tblDesc.add(getId_ac_disptpCDesc(tblDesc));
		tblDesc.add(getSd_ac_disptpCDesc(tblDesc));
		tblDesc.add(getFg_sysCDesc(tblDesc));
		tblDesc.add(getFg_activeCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 票据分类自动拆分主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_inccasplitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_inccasplit",  getId_inccasplitCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("票据分类自动拆分主键");
		attrDesc.setNullable(false);
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
	 * 票据分类主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_inccaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_incca",  getId_inccaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("票据分类主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 是否允许手工拆票属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_splitbyoperADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_splitbyoper",  getFg_splitbyoperCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否允许手工拆票");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 主票拆票条件属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_split_caseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_split_case",  getId_split_caseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("主票拆票条件");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 主票拆票条件编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_split_caseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_split_case",  getSd_split_caseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("主票拆票条件编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 就诊类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_entpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_entp",  getCode_entpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("就诊类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 票据显示内容属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_disptpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_disptp",  getId_disptpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("票据显示内容");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 票据显示内容编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_disptpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_disptp",  getSd_disptpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("票据显示内容编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 需要显示医嘱的开单服务类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_disp_ci_srvtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_disp_ci_srvtp",  getId_disp_ci_srvtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("需要显示医嘱的开单服务类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 需要显示医嘱的开单服务类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_disp_ci_srvtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_disp_ci_srvtp",  getSd_disp_ci_srvtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("需要显示医嘱的开单服务类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 需要显示账单的账单项属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_disp_incitmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_disp_incitm",  getId_disp_incitmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("需要显示账单的账单项");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 需要显示账单的账单项编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_disp_incitmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_disp_incitm",  getSd_disp_incitmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("需要显示账单的账单项编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 不显示为明细的服务类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_disp_notdetail_srvtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_disp_notdetail_srvtp",  getId_disp_notdetail_srvtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("不显示为明细的服务类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 不显示为明细的服务类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_disp_notdetail_srvtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_disp_notdetail_srvtp",  getSd_disp_notdetail_srvtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("不显示为明细的服务类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 一页内发票明细最大数量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getItmbignumADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Itmbignum",  getItmbignumCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("一页内发票明细最大数量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否按核算联分票属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_splitbyaccountADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_splitbyaccount",  getFg_splitbyaccountCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否按核算联分票");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 核算联分组条件属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_split_acc_caseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_split_acc_case",  getId_split_acc_caseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("核算联分组条件");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 核算联分组条件编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_split_acc_caseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_split_acc_case",  getSd_split_acc_caseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("核算联分组条件编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 核算联数量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCount_accountADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Count_account",  getCount_accountCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("核算联数量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 核算联显示内容属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ac_disptpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ac_disptp",  getId_ac_disptpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("核算联显示内容");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 核算联显示内容编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_ac_disptpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_ac_disptp",  getSd_ac_disptpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("核算联显示内容编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 系统标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_sysADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_sys",  getFg_sysCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("系统标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 启用标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_activeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_active",  getFg_activeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("启用标志");
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
	 * 自动拆票名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_split_caseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_split_case",  getName_split_caseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("自动拆票名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b7","id_split_case=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 票据显示名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_disptpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_disptp",  getName_disptpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("票据显示名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b8","id_disptp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 需要显示医嘱的开单服务类型名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_disp_ci_srvtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_disp_ci_srvtp",  getName_disp_ci_srvtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("需要显示医嘱的开单服务类型名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b11","id_disp_ci_srvtp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 票据项目名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_incitmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_incitm",  getName_incitmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("票据项目名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_incca_itm a0b13","id_disp_incitm=id_inccaitm","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 不显示为明细的服务类型名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_disp_notdetail_srvtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_disp_notdetail_srvtp",  getName_disp_notdetail_srvtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("不显示为明细的服务类型名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b12","id_disp_notdetail_srvtp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 核算联分组条件名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_split_acc_caseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_split_acc_case",  getName_split_acc_caseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("核算联分组条件名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b10","id_split_acc_case=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 核算联显示内容名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_ac_disptpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_ac_disptp",  getName_ac_disptpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("核算联显示内容名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b9","id_ac_disptp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取票据分类自动拆分主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_inccasplitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_inccasplit");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("票据分类自动拆分主键"); 
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
	 * 获取票据分类主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_inccaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_incca");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("票据分类主键"); 
		return column;
	}
	/**
	 * 获取是否允许手工拆票表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_splitbyoperCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_splitbyoper");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否允许手工拆票"); 
		return column;
	}
	/**
	 * 获取主票拆票条件表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_split_caseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_split_case");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("主票拆票条件"); 
		return column;
	}
	/**
	 * 获取主票拆票条件编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_split_caseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_split_case");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("主票拆票条件编码"); 
		return column;
	}
	/**
	 * 获取就诊类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_entpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_entp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊类型"); 
		return column;
	}
	/**
	 * 获取票据显示内容表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_disptpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_disptp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("票据显示内容"); 
		return column;
	}
	/**
	 * 获取票据显示内容编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_disptpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_disptp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("票据显示内容编码"); 
		return column;
	}
	/**
	 * 获取需要显示医嘱的开单服务类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_disp_ci_srvtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_disp_ci_srvtp");
		column.setLength(2000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("需要显示医嘱的开单服务类型"); 
		return column;
	}
	/**
	 * 获取需要显示医嘱的开单服务类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_disp_ci_srvtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_disp_ci_srvtp");
		column.setLength(2000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("需要显示医嘱的开单服务类型编码"); 
		return column;
	}
	/**
	 * 获取需要显示账单的账单项表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_disp_incitmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_disp_incitm");
		column.setLength(2000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("需要显示账单的账单项"); 
		return column;
	}
	/**
	 * 获取需要显示账单的账单项编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_disp_incitmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_disp_incitm");
		column.setLength(2000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("需要显示账单的账单项编码"); 
		return column;
	}
	/**
	 * 获取不显示为明细的服务类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_disp_notdetail_srvtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_disp_notdetail_srvtp");
		column.setLength(2000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("不显示为明细的服务类型"); 
		return column;
	}
	/**
	 * 获取不显示为明细的服务类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_disp_notdetail_srvtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_disp_notdetail_srvtp");
		column.setLength(2000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("不显示为明细的服务类型编码"); 
		return column;
	}
	/**
	 * 获取一页内发票明细最大数量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getItmbignumCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Itmbignum");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("一页内发票明细最大数量"); 
		return column;
	}
	/**
	 * 获取是否按核算联分票表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_splitbyaccountCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_splitbyaccount");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否按核算联分票"); 
		return column;
	}
	/**
	 * 获取核算联分组条件表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_split_acc_caseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_split_acc_case");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("核算联分组条件"); 
		return column;
	}
	/**
	 * 获取核算联分组条件编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_split_acc_caseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_split_acc_case");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("核算联分组条件编码"); 
		return column;
	}
	/**
	 * 获取核算联数量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCount_accountCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Count_account");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("核算联数量"); 
		return column;
	}
	/**
	 * 获取核算联显示内容表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ac_disptpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ac_disptp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("核算联显示内容"); 
		return column;
	}
	/**
	 * 获取核算联显示内容编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_ac_disptpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_ac_disptp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("核算联显示内容编码"); 
		return column;
	}
	/**
	 * 获取系统标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_sysCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_sys");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("系统标志"); 
		return column;
	}
	/**
	 * 获取启用标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_activeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_active");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("启用标志"); 
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
	 * 获取自动拆票名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_split_caseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_split_case");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("自动拆票名称"); 
		return column;
	}
	/**
	 * 获取票据显示名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_disptpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_disptp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("票据显示名称"); 
		return column;
	}
	/**
	 * 获取需要显示医嘱的开单服务类型名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_disp_ci_srvtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_disp_ci_srvtp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("需要显示医嘱的开单服务类型名称"); 
		return column;
	}
	/**
	 * 获取票据项目名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_incitmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_incitm");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("票据项目名称"); 
		return column;
	}
	/**
	 * 获取不显示为明细的服务类型名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_disp_notdetail_srvtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_disp_notdetail_srvtp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("不显示为明细的服务类型名称"); 
		return column;
	}
	/**
	 * 获取核算联分组条件名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_split_acc_caseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_split_acc_case");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("核算联分组条件名称"); 
		return column;
	}
	/**
	 * 获取核算联显示内容名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_ac_disptpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_ac_disptp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("核算联显示内容名称"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id","Id_inccasplit");
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
