
package iih.bd.fc.mdwfor.d.desc;

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
 * 医嘱流向开立参数 DO 元数据信息
 */
public class MdWfOrDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.bd.fc.mdwfor.d.MdWfOrDO";
	public static final String CLASS_DISPALYNAME = "医嘱流向开立参数";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "md_wf_or";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_wfor";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public MdWfOrDODesc(){
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
		this.setKeyDesc(getId_wforADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.add(getId_wforADesc(tblDesc));
		this.add(getId_wfADesc(tblDesc));
		this.add(getEu_wftpADesc(tblDesc));
		this.add(getSortnoADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_entpADesc(tblDesc));
		this.add(getEu_srv_tpADesc(tblDesc));
		this.add(getId_srvtpADesc(tblDesc));
		this.add(getSd_srvtpADesc(tblDesc));
		this.add(getId_srvcaADesc(tblDesc));
		this.add(getId_srvADesc(tblDesc));
		this.add(getId_usgADesc(tblDesc));
		this.add(getId_ordrecurtpADesc(tblDesc));
		this.add(getTime_bADesc(tblDesc));
		this.add(getTime_eADesc(tblDesc));
		this.add(getWeeksADesc(tblDesc));
		this.add(getId_dep_orADesc(tblDesc));
		this.add(getId_dep_clinicADesc(tblDesc));
		this.add(getId_dep_nurADesc(tblDesc));
		this.add(getFg_macroADesc(tblDesc));
		this.add(getDeptmacroADesc(tblDesc));
		this.add(getId_deptADesc(tblDesc));
		this.add(getId_wfdepADesc(tblDesc));
		this.add(getInnercode_srvcaADesc(tblDesc));
		this.add(getMdwfitm_codeADesc(tblDesc));
		this.add(getMdwfitm_nameADesc(tblDesc));
		this.add(getOrg_codeADesc(tblDesc));
		this.add(getOrg_nameADesc(tblDesc));
		this.add(getEntp_codeADesc(tblDesc));
		this.add(getEntp_nameADesc(tblDesc));
		this.add(getSrvtp_codeADesc(tblDesc));
		this.add(getSrvtp_nameADesc(tblDesc));
		this.add(getSrvca_codeADesc(tblDesc));
		this.add(getSrvca_nameADesc(tblDesc));
		this.add(getSrv_codeADesc(tblDesc));
		this.add(getSrv_nameADesc(tblDesc));
		this.add(getUsg_codeADesc(tblDesc));
		this.add(getUsg_nameADesc(tblDesc));
		this.add(getOrdrecurtp_codeADesc(tblDesc));
		this.add(getOrdrecurtp_nameADesc(tblDesc));
		this.add(getDept_codeADesc(tblDesc));
		this.add(getDept_nameADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_wforCDesc(tblDesc));
		tblDesc.add(getId_wforCDesc(tblDesc));
		tblDesc.add(getId_wfCDesc(tblDesc));
		tblDesc.add(getEu_wftpCDesc(tblDesc));
		tblDesc.add(getSortnoCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_entpCDesc(tblDesc));
		tblDesc.add(getEu_srv_tpCDesc(tblDesc));
		tblDesc.add(getId_srvtpCDesc(tblDesc));
		tblDesc.add(getSd_srvtpCDesc(tblDesc));
		tblDesc.add(getId_srvcaCDesc(tblDesc));
		tblDesc.add(getId_srvCDesc(tblDesc));
		tblDesc.add(getId_usgCDesc(tblDesc));
		tblDesc.add(getId_ordrecurtpCDesc(tblDesc));
		tblDesc.add(getTime_bCDesc(tblDesc));
		tblDesc.add(getTime_eCDesc(tblDesc));
		tblDesc.add(getWeeksCDesc(tblDesc));
		tblDesc.add(getId_dep_orCDesc(tblDesc));
		tblDesc.add(getId_dep_clinicCDesc(tblDesc));
		tblDesc.add(getId_dep_nurCDesc(tblDesc));
		tblDesc.add(getFg_macroCDesc(tblDesc));
		tblDesc.add(getDeptmacroCDesc(tblDesc));
		tblDesc.add(getId_deptCDesc(tblDesc));
		tblDesc.add(getId_wfdepCDesc(tblDesc));
		tblDesc.add(getInnercode_srvcaCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 医嘱流向开立主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_wforADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_wfor",  getId_wforCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医嘱流向开立主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医嘱流向属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_wfADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_wf",  getId_wfCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医嘱流向");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 流向类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_wftpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_wftp",  getEu_wftpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("流向类型");
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
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("序号");
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
	 * 就诊类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_entpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_entp",  getId_entpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("就诊类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 流向服务规则属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_srv_tpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_srv_tp",  getEu_srv_tpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("流向服务规则");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 服务类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_srvtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_srvtp",  getId_srvtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 服务类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_srvtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_srvtp",  getSd_srvtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 服务分类属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_srvcaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_srvca",  getId_srvcaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务分类");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 服务项目属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_srvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_srv",  getId_srvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务项目");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 医嘱用法属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_usgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_usg",  getId_usgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医嘱用法");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 医嘱周期类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ordrecurtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ordrecurtp",  getId_ordrecurtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医嘱周期类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 开始时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTime_bADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Time_b",  getTime_bCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FTime);
		attrDesc.setLabel("开始时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 结束时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTime_eADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Time_e",  getTime_eCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FTime);
		attrDesc.setLabel("结束时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 星期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWeeksADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Weeks",  getWeeksCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("星期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 开单科室属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dep_orADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep_or",  getId_dep_orCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("开单科室");
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
	private IAttrDesc getId_dep_clinicADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep_clinic",  getId_dep_clinicCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("就诊科室");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
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
	 * 宏标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_macroADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_macro",  getFg_macroCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("宏标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 部门变量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDeptmacroADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Deptmacro",  getDeptmacroCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("部门变量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 执行科室属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_deptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dept",  getId_deptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("执行科室");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 医嘱流向科室属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_wfdepADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_wfdep",  getId_wfdepCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医嘱流向科室");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 服务分类内码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInnercode_srvcaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Innercode_srvca",  getInnercode_srvcaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务分类内码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医嘱流向编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMdwfitm_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mdwfitm_code",  getMdwfitm_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医嘱流向编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"md_wf a0b1","id_wf=id_wf","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医嘱流向名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMdwfitm_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mdwfitm_name",  getMdwfitm_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医嘱流向名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"md_wf a0b1","id_wf=id_wf","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 组织编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOrg_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Org_code",  getOrg_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("组织编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_org a0b2","id_org=id_org","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 组织名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOrg_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Org_name",  getOrg_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("组织名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_org a0b2","id_org=id_org","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 就诊类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEntp_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Entp_code",  getEntp_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("就诊类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_entp a0b4","id_entp=id_entp","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 就诊类型名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEntp_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Entp_name",  getEntp_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("就诊类型名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_entp a0b4","id_entp=id_entp","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSrvtp_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Srvtp_code",  getSrvtp_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b5","id_srvtp=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSrvtp_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Srvtp_name",  getSrvtp_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b5","id_srvtp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 服务分类编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSrvca_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Srvca_code",  getSrvca_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务分类编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_srvca a0b6","id_srvca=id_srvca","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 服务分类名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSrvca_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Srvca_name",  getSrvca_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务分类名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_srvca a0b6","id_srvca=id_srvca","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 服务编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSrv_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Srv_code",  getSrv_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_srv a0b7","id_srv=id_srv","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 服务名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSrv_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Srv_name",  getSrv_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_srv a0b7","id_srv=id_srv","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 用法编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getUsg_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Usg_code",  getUsg_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用法编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_route a0b8","id_usg=id_route","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 用法名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getUsg_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Usg_name",  getUsg_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用法名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_route a0b8","id_usg=id_route","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOrdrecurtp_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ordrecurtp_code",  getOrdrecurtp_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b9","id_ordrecurtp=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOrdrecurtp_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ordrecurtp_name",  getOrdrecurtp_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b9","id_ordrecurtp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDept_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dept_code",  getDept_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b3","id_dept=id_dep","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDept_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dept_name",  getDept_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b3","id_dept=id_dep","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取医嘱流向开立主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_wforCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_wfor");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("医嘱流向开立主键"); 
		return column;
	}
	/**
	 * 获取医嘱流向表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_wfCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_wf");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医嘱流向"); 
		return column;
	}
	/**
	 * 获取流向类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_wftpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_wftp");
		column.setLength(20);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("流向类型"); 
		return column;
	}
	/**
	 * 获取序号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSortnoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sortno");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("序号"); 
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
	 * 获取就诊类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_entpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_entp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊类型"); 
		return column;
	}
	/**
	 * 获取流向服务规则表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_srv_tpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_srv_tp");
		column.setLength(20);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("流向服务规则"); 
		return column;
	}
	/**
	 * 获取服务类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_srvtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_srvtp");
		column.setLength(1000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务类型"); 
		return column;
	}
	/**
	 * 获取服务类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_srvtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_srvtp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务类型编码"); 
		return column;
	}
	/**
	 * 获取服务分类表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_srvcaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_srvca");
		column.setLength(1000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务分类"); 
		return column;
	}
	/**
	 * 获取服务项目表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_srvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_srv");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务项目"); 
		return column;
	}
	/**
	 * 获取医嘱用法表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_usgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_usg");
		column.setLength(1000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医嘱用法"); 
		return column;
	}
	/**
	 * 获取医嘱周期类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ordrecurtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ordrecurtp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医嘱周期类型"); 
		return column;
	}
	/**
	 * 获取开始时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTime_bCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Time_b");
		column.setLength(8);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("开始时间"); 
		return column;
	}
	/**
	 * 获取结束时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTime_eCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Time_e");
		column.setLength(8);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("结束时间"); 
		return column;
	}
	/**
	 * 获取星期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWeeksCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Weeks");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("星期"); 
		return column;
	}
	/**
	 * 获取开单科室表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dep_orCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep_or");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("开单科室"); 
		return column;
	}
	/**
	 * 获取就诊科室表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dep_clinicCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep_clinic");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊科室"); 
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
	 * 获取宏标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_macroCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_macro");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("宏标识"); 
		return column;
	}
	/**
	 * 获取部门变量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDeptmacroCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Deptmacro");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("部门变量"); 
		return column;
	}
	/**
	 * 获取执行科室表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_deptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dept");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("执行科室"); 
		return column;
	}
	/**
	 * 获取医嘱流向科室表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_wfdepCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_wfdep");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医嘱流向科室"); 
		return column;
	}
	/**
	 * 获取服务分类内码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInnercode_srvcaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Innercode_srvca");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务分类内码"); 
		return column;
	}
	/**
	 * 获取医嘱流向编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMdwfitm_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mdwfitm_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医嘱流向编码"); 
		return column;
	}
	/**
	 * 获取医嘱流向名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMdwfitm_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mdwfitm_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医嘱流向名称"); 
		return column;
	}
	/**
	 * 获取组织编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOrg_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Org_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("组织编码"); 
		return column;
	}
	/**
	 * 获取组织名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOrg_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Org_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("组织名称"); 
		return column;
	}
	/**
	 * 获取就诊类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEntp_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Entp_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊类型编码"); 
		return column;
	}
	/**
	 * 获取就诊类型名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEntp_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Entp_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊类型名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSrvtp_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Srvtp_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSrvtp_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Srvtp_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取服务分类编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSrvca_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Srvca_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务分类编码"); 
		return column;
	}
	/**
	 * 获取服务分类名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSrvca_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Srvca_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务分类名称"); 
		return column;
	}
	/**
	 * 获取服务编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSrv_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Srv_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务编码"); 
		return column;
	}
	/**
	 * 获取服务名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSrv_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Srv_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务名称"); 
		return column;
	}
	/**
	 * 获取用法编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getUsg_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Usg_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("用法编码"); 
		return column;
	}
	/**
	 * 获取用法名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getUsg_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Usg_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("用法名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOrdrecurtp_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ordrecurtp_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOrdrecurtp_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ordrecurtp_name");
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
	private IColumnDesc getDept_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dept_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDept_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dept_name");
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
	
}
