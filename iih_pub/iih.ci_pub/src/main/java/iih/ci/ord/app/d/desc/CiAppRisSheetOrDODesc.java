
package iih.ci.ord.app.d.desc;

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
 * 检查打印申请单明细 DO 元数据信息
 */
public class CiAppRisSheetOrDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.ci.ord.app.d.CiAppRisSheetOrDO";
	public static final String CLASS_DISPALYNAME = "检查打印申请单明细";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "ci_app_ris_or";
	public static final String TABLE_ALIAS_NAME = "a1";
	public static final String PRIMARYKEY_FIELDNAME="Id_risprn_detail";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public CiAppRisSheetOrDODesc(){
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
		this.setKeyDesc(getId_risprn_detailADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_ciapprissheetADesc(tblDesc));
		this.add(getId_risprn_detailADesc(tblDesc));
		this.add(getId_ciapprissheetADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_orADesc(tblDesc));
		this.add(getId_srvADesc(tblDesc));
		this.add(getId_orobsADesc(tblDesc));
		this.add(getName_orADesc(tblDesc));
		this.add(getFg_setADesc(tblDesc));
		this.add(getId_org_appADesc(tblDesc));
		this.add(getId_dep_appADesc(tblDesc));
		this.add(getId_dep_mpADesc(tblDesc));
		this.add(getId_emp_appADesc(tblDesc));
		this.add(getFg_orhpADesc(tblDesc));
		this.add(getFg_urgentADesc(tblDesc));
		this.add(getFg_prepayADesc(tblDesc));
		this.add(getFg_blsettledADesc(tblDesc));
		this.add(getId_su_blADesc(tblDesc));
		this.add(getSd_su_blADesc(tblDesc));
		this.add(getOr_total_priADesc(tblDesc));
		this.add(getSortnoADesc(tblDesc));
		this.add(getId_diADesc(tblDesc));
		this.add(getName_diagADesc(tblDesc));
		this.add(getId_diitmADesc(tblDesc));
		this.add(getStr_id_diitmADesc(tblDesc));
		this.add(getStr_code_diADesc(tblDesc));
		this.add(getStr_name_diADesc(tblDesc));
		this.add(getDt_planADesc(tblDesc));
		this.add(getNo_applyformADesc(tblDesc));
		this.add(getDt_appADesc(tblDesc));
		this.add(getResearchinfoADesc(tblDesc));
		this.add(getBiopsyADesc(tblDesc));
		this.add(getDes_sympsignADesc(tblDesc));
		this.add(getClinicalzztzADesc(tblDesc));
		this.add(getAuximtexamADesc(tblDesc));
		this.add(getPastillnessADesc(tblDesc));
		this.add(getAnnouncementsADesc(tblDesc));
		this.add(getId_ppsADesc(tblDesc));
		this.add(getSd_ppsADesc(tblDesc));
		this.add(getDes_ppsADesc(tblDesc));
		this.add(getId_bodyADesc(tblDesc));
		this.add(getSd_bodyADesc(tblDesc));
		this.add(getId_posADesc(tblDesc));
		this.add(getSd_posADesc(tblDesc));
		this.add(getFg_mp_bedADesc(tblDesc));
		this.add(getDef1ADesc(tblDesc));
		this.add(getDef2ADesc(tblDesc));
		this.add(getDef3ADesc(tblDesc));
		this.add(getDef4ADesc(tblDesc));
		this.add(getDef5ADesc(tblDesc));
		this.add(getDef6ADesc(tblDesc));
		this.add(getDef7ADesc(tblDesc));
		this.add(getDef8ADesc(tblDesc));
		this.add(getDef9ADesc(tblDesc));
		this.add(getDef10ADesc(tblDesc));
		this.add(getDef11ADesc(tblDesc));
		this.add(getDef12ADesc(tblDesc));
		this.add(getDef13ADesc(tblDesc));
		this.add(getDef14ADesc(tblDesc));
		this.add(getDef15ADesc(tblDesc));
		this.add(getDef16ADesc(tblDesc));
		this.add(getDef17ADesc(tblDesc));
		this.add(getDef18ADesc(tblDesc));
		this.add(getDef19ADesc(tblDesc));
		this.add(getDef20ADesc(tblDesc));
		this.add(getDef21ADesc(tblDesc));
		this.add(getDef22ADesc(tblDesc));
		this.add(getDef23ADesc(tblDesc));
		this.add(getDef24ADesc(tblDesc));
		this.add(getDef25ADesc(tblDesc));
		this.add(getDef26ADesc(tblDesc));
		this.add(getDef27ADesc(tblDesc));
		this.add(getDef28ADesc(tblDesc));
		this.add(getDef29ADesc(tblDesc));
		this.add(getDef30ADesc(tblDesc));
		this.add(getDef31ADesc(tblDesc));
		this.add(getDef32ADesc(tblDesc));
		this.add(getDef33ADesc(tblDesc));
		this.add(getDef34ADesc(tblDesc));
		this.add(getDef35ADesc(tblDesc));
		this.add(getDef36ADesc(tblDesc));
		this.add(getDef37ADesc(tblDesc));
		this.add(getDef38ADesc(tblDesc));
		this.add(getDef39ADesc(tblDesc));
		this.add(getDef40ADesc(tblDesc));
		this.add(getDef41ADesc(tblDesc));
		this.add(getDef42ADesc(tblDesc));
		this.add(getDef43ADesc(tblDesc));
		this.add(getDef44ADesc(tblDesc));
		this.add(getDef45ADesc(tblDesc));
		this.add(getDef46ADesc(tblDesc));
		this.add(getDef47ADesc(tblDesc));
		this.add(getDef48ADesc(tblDesc));
		this.add(getDef49ADesc(tblDesc));
		this.add(getDef50ADesc(tblDesc));
		this.add(getName_bodyADesc(tblDesc));
		this.add(new DsAttr(dsColumn,this));
		this.add(new SvAttr(svColumn,this));
		
	}
		
	/**
	 * 获得表元数据
	 * @return
	 */
	private ITableDesc getTableDesc(){
		TableDesc tblDesc=new TableDesc(TABLE_NAME,TABLE_ALIAS_NAME);
		tblDesc.setLabel(CLASS_DISPALYNAME);
		tblDesc.setPrimaryKey(getId_risprn_detailCDesc(tblDesc));
		tblDesc.add(getId_risprn_detailCDesc(tblDesc));
		tblDesc.add(getId_ciapprissheetCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_orCDesc(tblDesc));
		tblDesc.add(getId_srvCDesc(tblDesc));
		tblDesc.add(getId_orobsCDesc(tblDesc));
		tblDesc.add(getName_orCDesc(tblDesc));
		tblDesc.add(getFg_setCDesc(tblDesc));
		tblDesc.add(getId_org_appCDesc(tblDesc));
		tblDesc.add(getId_dep_appCDesc(tblDesc));
		tblDesc.add(getId_dep_mpCDesc(tblDesc));
		tblDesc.add(getId_emp_appCDesc(tblDesc));
		tblDesc.add(getFg_orhpCDesc(tblDesc));
		tblDesc.add(getFg_urgentCDesc(tblDesc));
		tblDesc.add(getFg_prepayCDesc(tblDesc));
		tblDesc.add(getFg_blsettledCDesc(tblDesc));
		tblDesc.add(getId_su_blCDesc(tblDesc));
		tblDesc.add(getSd_su_blCDesc(tblDesc));
		tblDesc.add(getOr_total_priCDesc(tblDesc));
		tblDesc.add(getSortnoCDesc(tblDesc));
		tblDesc.add(getId_diCDesc(tblDesc));
		tblDesc.add(getName_diagCDesc(tblDesc));
		tblDesc.add(getId_diitmCDesc(tblDesc));
		tblDesc.add(getStr_id_diitmCDesc(tblDesc));
		tblDesc.add(getStr_code_diCDesc(tblDesc));
		tblDesc.add(getStr_name_diCDesc(tblDesc));
		tblDesc.add(getDt_planCDesc(tblDesc));
		tblDesc.add(getNo_applyformCDesc(tblDesc));
		tblDesc.add(getDt_appCDesc(tblDesc));
		tblDesc.add(getResearchinfoCDesc(tblDesc));
		tblDesc.add(getBiopsyCDesc(tblDesc));
		tblDesc.add(getDes_sympsignCDesc(tblDesc));
		tblDesc.add(getClinicalzztzCDesc(tblDesc));
		tblDesc.add(getAuximtexamCDesc(tblDesc));
		tblDesc.add(getPastillnessCDesc(tblDesc));
		tblDesc.add(getAnnouncementsCDesc(tblDesc));
		tblDesc.add(getId_ppsCDesc(tblDesc));
		tblDesc.add(getSd_ppsCDesc(tblDesc));
		tblDesc.add(getDes_ppsCDesc(tblDesc));
		tblDesc.add(getId_bodyCDesc(tblDesc));
		tblDesc.add(getSd_bodyCDesc(tblDesc));
		tblDesc.add(getId_posCDesc(tblDesc));
		tblDesc.add(getSd_posCDesc(tblDesc));
		tblDesc.add(getFg_mp_bedCDesc(tblDesc));
		tblDesc.add(getDef1CDesc(tblDesc));
		tblDesc.add(getDef2CDesc(tblDesc));
		tblDesc.add(getDef3CDesc(tblDesc));
		tblDesc.add(getDef4CDesc(tblDesc));
		tblDesc.add(getDef5CDesc(tblDesc));
		tblDesc.add(getDef6CDesc(tblDesc));
		tblDesc.add(getDef7CDesc(tblDesc));
		tblDesc.add(getDef8CDesc(tblDesc));
		tblDesc.add(getDef9CDesc(tblDesc));
		tblDesc.add(getDef10CDesc(tblDesc));
		tblDesc.add(getDef11CDesc(tblDesc));
		tblDesc.add(getDef12CDesc(tblDesc));
		tblDesc.add(getDef13CDesc(tblDesc));
		tblDesc.add(getDef14CDesc(tblDesc));
		tblDesc.add(getDef15CDesc(tblDesc));
		tblDesc.add(getDef16CDesc(tblDesc));
		tblDesc.add(getDef17CDesc(tblDesc));
		tblDesc.add(getDef18CDesc(tblDesc));
		tblDesc.add(getDef19CDesc(tblDesc));
		tblDesc.add(getDef20CDesc(tblDesc));
		tblDesc.add(getDef21CDesc(tblDesc));
		tblDesc.add(getDef22CDesc(tblDesc));
		tblDesc.add(getDef23CDesc(tblDesc));
		tblDesc.add(getDef24CDesc(tblDesc));
		tblDesc.add(getDef25CDesc(tblDesc));
		tblDesc.add(getDef26CDesc(tblDesc));
		tblDesc.add(getDef27CDesc(tblDesc));
		tblDesc.add(getDef28CDesc(tblDesc));
		tblDesc.add(getDef29CDesc(tblDesc));
		tblDesc.add(getDef30CDesc(tblDesc));
		tblDesc.add(getDef31CDesc(tblDesc));
		tblDesc.add(getDef32CDesc(tblDesc));
		tblDesc.add(getDef33CDesc(tblDesc));
		tblDesc.add(getDef34CDesc(tblDesc));
		tblDesc.add(getDef35CDesc(tblDesc));
		tblDesc.add(getDef36CDesc(tblDesc));
		tblDesc.add(getDef37CDesc(tblDesc));
		tblDesc.add(getDef38CDesc(tblDesc));
		tblDesc.add(getDef39CDesc(tblDesc));
		tblDesc.add(getDef40CDesc(tblDesc));
		tblDesc.add(getDef41CDesc(tblDesc));
		tblDesc.add(getDef42CDesc(tblDesc));
		tblDesc.add(getDef43CDesc(tblDesc));
		tblDesc.add(getDef44CDesc(tblDesc));
		tblDesc.add(getDef45CDesc(tblDesc));
		tblDesc.add(getDef46CDesc(tblDesc));
		tblDesc.add(getDef47CDesc(tblDesc));
		tblDesc.add(getDef48CDesc(tblDesc));
		tblDesc.add(getDef49CDesc(tblDesc));
		tblDesc.add(getDef50CDesc(tblDesc));
		tblDesc.add(getName_bodyCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 检查打印明细属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_risprn_detailADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_risprn_detail",  getId_risprn_detailCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("检查打印明细");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 检查打印单主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ciapprissheetADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ciapprissheet",  getId_ciapprissheetCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("检查打印单主键");
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
	 * 医嘱id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_orADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_or",  getId_orCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医嘱id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 服务ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_srvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_srv",  getId_srvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 检查申请单属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_orobsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_orobs",  getId_orobsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("检查申请单");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 医嘱名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_orADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_or",  getName_orCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医嘱名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 服务套标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_setADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_set",  getFg_setCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("服务套标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 申请机构属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_org_appADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_org_app",  getId_org_appCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("申请机构");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 申请科室属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dep_appADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep_app",  getId_dep_appCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("申请科室");
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
	private IAttrDesc getId_dep_mpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep_mp",  getId_dep_mpCDesc(tblDesc), this);
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
	 * 申请医生属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_appADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_app",  getId_emp_appCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("申请医生");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 临床项目医保标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_orhpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_orhp",  getFg_orhpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("临床项目医保标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 加急标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_urgentADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_urgent",  getFg_urgentCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("加急标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 预付费记账标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_prepayADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_prepay",  getFg_prepayCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("预付费记账标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 费用已结算标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_blsettledADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_blsettled",  getFg_blsettledCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("费用已结算标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 记账状态属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_su_blADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_su_bl",  getId_su_blCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("记账状态");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 记账状态编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_su_blADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_su_bl",  getSd_su_blCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("记账状态编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医嘱金额属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOr_total_priADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Or_total_pri",  getOr_total_priCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("医嘱金额");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医嘱排序号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSortnoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sortno",  getSortnoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("医嘱排序号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 临床诊断属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_diADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_di",  getId_diCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("临床诊断");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 诊断名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_diagADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_diag",  getName_diagCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 临床诊断子项属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_diitmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_diitm",  getId_diitmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("临床诊断子项");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 临床诊断明细id拼接属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getStr_id_diitmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Str_id_diitm",  getStr_id_diitmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("临床诊断明细id拼接");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊断编码拼接属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getStr_code_diADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Str_code_di",  getStr_code_diCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断编码拼接");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊断名称拼接属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getStr_name_diADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Str_name_di",  getStr_name_diCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断名称拼接");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 计划检查日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_planADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_plan",  getDt_planCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("计划检查日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 检查申请单号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNo_applyformADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("No_applyform",  getNo_applyformCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("检查申请单号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 申请时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_appADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_app",  getDt_appCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("申请时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 科研项目信息属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getResearchinfoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Researchinfo",  getResearchinfoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("科研项目信息");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 检查组织描述属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBiopsyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Biopsy",  getBiopsyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("检查组织描述");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 病情描述属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDes_sympsignADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Des_sympsign",  getDes_sympsignCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病情描述");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 临床症状及体征属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getClinicalzztzADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Clinicalzztz",  getClinicalzztzCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("临床症状及体征");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 其它检查所见属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAuximtexamADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Auximtexam",  getAuximtexamCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("其它检查所见");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 既往病史属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPastillnessADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pastillness",  getPastillnessCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("既往病史");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 注意事项属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAnnouncementsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Announcements",  getAnnouncementsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("注意事项");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 检查目的属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ppsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pps",  getId_ppsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("检查目的");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 检查目的编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_ppsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_pps",  getSd_ppsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("检查目的编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 检查目的描述属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDes_ppsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Des_pps",  getDes_ppsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("检查目的描述");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 检查部位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_bodyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_body",  getId_bodyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("检查部位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 检查部位编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_bodyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_body",  getSd_bodyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("检查部位编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 检查体位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_posADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pos",  getId_posCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("检查体位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 检查体位编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_posADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_pos",  getSd_posCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("检查体位编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 床旁执行标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_mp_bedADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_mp_bed",  getFg_mp_bedCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("床旁执行标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段1属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef1ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def1",  getDef1CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段1");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段2属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef2ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def2",  getDef2CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段2");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段3属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef3ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def3",  getDef3CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段3");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段4属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef4ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def4",  getDef4CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段4");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段5属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef5ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def5",  getDef5CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段5");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段6属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef6ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def6",  getDef6CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段6");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段7属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef7ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def7",  getDef7CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段7");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段8属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef8ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def8",  getDef8CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段8");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段9属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef9ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def9",  getDef9CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段9");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段10属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef10ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def10",  getDef10CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段10");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段11属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef11ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def11",  getDef11CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段11");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段12属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef12ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def12",  getDef12CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段12");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段13属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef13ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def13",  getDef13CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段13");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段14属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef14ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def14",  getDef14CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段14");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段15属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef15ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def15",  getDef15CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段15");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段16属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef16ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def16",  getDef16CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段16");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段17属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef17ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def17",  getDef17CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段17");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段18属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef18ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def18",  getDef18CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段18");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段19属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef19ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def19",  getDef19CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段19");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段20属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef20ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def20",  getDef20CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段20");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段21属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef21ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def21",  getDef21CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段21");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段22属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef22ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def22",  getDef22CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段22");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段23属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef23ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def23",  getDef23CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段23");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段24属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef24ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def24",  getDef24CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段24");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段25属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef25ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def25",  getDef25CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段25");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段26属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef26ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def26",  getDef26CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段26");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段27属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef27ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def27",  getDef27CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段27");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段28属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef28ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def28",  getDef28CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段28");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段29属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef29ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def29",  getDef29CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段29");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段30属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef30ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def30",  getDef30CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段30");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段31属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef31ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def31",  getDef31CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段31");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段32属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef32ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def32",  getDef32CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段32");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段33属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef33ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def33",  getDef33CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段33");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段34属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef34ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def34",  getDef34CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段34");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段35属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef35ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def35",  getDef35CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段35");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段36属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef36ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def36",  getDef36CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段36");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段37属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef37ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def37",  getDef37CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段37");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段38属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef38ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def38",  getDef38CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段38");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段39属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef39ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def39",  getDef39CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段39");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段40属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef40ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def40",  getDef40CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段40");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段41属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef41ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def41",  getDef41CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段41");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段42属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef42ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def42",  getDef42CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段42");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段43属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef43ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def43",  getDef43CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段43");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段44属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef44ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def44",  getDef44CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段44");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段45属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef45ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def45",  getDef45CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段45");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段46属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef46ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def46",  getDef46CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段46");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段47属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef47ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def47",  getDef47CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段47");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段48属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef48ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def48",  getDef48CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段48");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段49属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef49ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def49",  getDef49CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段49");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段50属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef50ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def50",  getDef50CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段50");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 检查部位名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_bodyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_body",  getName_bodyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("检查部位名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取检查打印明细表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_risprn_detailCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_risprn_detail");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("检查打印明细"); 
		return column;
	}
	/**
	 * 获取检查打印单主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ciapprissheetCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ciapprissheet");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("检查打印单主键"); 
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
	 * 获取医嘱id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_orCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_or");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医嘱id"); 
		return column;
	}
	/**
	 * 获取服务ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_srvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_srv");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务ID"); 
		return column;
	}
	/**
	 * 获取检查申请单表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_orobsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_orobs");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("检查申请单"); 
		return column;
	}
	/**
	 * 获取医嘱名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_orCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_or");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医嘱名称"); 
		return column;
	}
	/**
	 * 获取服务套标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_setCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_set");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("服务套标识"); 
		return column;
	}
	/**
	 * 获取申请机构表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_org_appCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_org_app");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("申请机构"); 
		return column;
	}
	/**
	 * 获取申请科室表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dep_appCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep_app");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("申请科室"); 
		return column;
	}
	/**
	 * 获取执行科室表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dep_mpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep_mp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("执行科室"); 
		return column;
	}
	/**
	 * 获取申请医生表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_appCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_app");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("申请医生"); 
		return column;
	}
	/**
	 * 获取临床项目医保标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_orhpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_orhp");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("临床项目医保标识"); 
		return column;
	}
	/**
	 * 获取加急标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_urgentCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_urgent");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("加急标识"); 
		return column;
	}
	/**
	 * 获取预付费记账标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_prepayCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_prepay");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("预付费记账标识"); 
		return column;
	}
	/**
	 * 获取费用已结算标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_blsettledCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_blsettled");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("费用已结算标识"); 
		return column;
	}
	/**
	 * 获取记账状态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_su_blCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_su_bl");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("记账状态"); 
		return column;
	}
	/**
	 * 获取记账状态编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_su_blCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_su_bl");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("记账状态编码"); 
		return column;
	}
	/**
	 * 获取医嘱金额表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOr_total_priCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Or_total_pri");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("医嘱金额"); 
		return column;
	}
	/**
	 * 获取医嘱排序号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSortnoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sortno");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("医嘱排序号"); 
		return column;
	}
	/**
	 * 获取临床诊断表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_diCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_di");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("临床诊断"); 
		return column;
	}
	/**
	 * 获取诊断名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_diagCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_diag");
		column.setLength(180);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断名称"); 
		return column;
	}
	/**
	 * 获取临床诊断子项表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_diitmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_diitm");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("临床诊断子项"); 
		return column;
	}
	/**
	 * 获取临床诊断明细id拼接表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getStr_id_diitmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Str_id_diitm");
		column.setLength(1500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("临床诊断明细id拼接"); 
		return column;
	}
	/**
	 * 获取诊断编码拼接表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getStr_code_diCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Str_code_di");
		column.setLength(1500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断编码拼接"); 
		return column;
	}
	/**
	 * 获取诊断名称拼接表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getStr_name_diCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Str_name_di");
		column.setLength(1500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断名称拼接"); 
		return column;
	}
	/**
	 * 获取计划检查日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_planCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_plan");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("计划检查日期"); 
		return column;
	}
	/**
	 * 获取检查申请单号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNo_applyformCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"No_applyform");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("检查申请单号"); 
		return column;
	}
	/**
	 * 获取申请时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_appCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_app");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("申请时间"); 
		return column;
	}
	/**
	 * 获取科研项目信息表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getResearchinfoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Researchinfo");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("科研项目信息"); 
		return column;
	}
	/**
	 * 获取检查组织描述表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBiopsyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Biopsy");
		column.setLength(4000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("检查组织描述"); 
		return column;
	}
	/**
	 * 获取病情描述表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDes_sympsignCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Des_sympsign");
		column.setLength(4000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病情描述"); 
		return column;
	}
	/**
	 * 获取临床症状及体征表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getClinicalzztzCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Clinicalzztz");
		column.setLength(4000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("临床症状及体征"); 
		return column;
	}
	/**
	 * 获取其它检查所见表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAuximtexamCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Auximtexam");
		column.setLength(4000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("其它检查所见"); 
		return column;
	}
	/**
	 * 获取既往病史表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPastillnessCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pastillness");
		column.setLength(4000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("既往病史"); 
		return column;
	}
	/**
	 * 获取注意事项表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAnnouncementsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Announcements");
		column.setLength(4000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("注意事项"); 
		return column;
	}
	/**
	 * 获取检查目的表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ppsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pps");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("检查目的"); 
		return column;
	}
	/**
	 * 获取检查目的编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_ppsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_pps");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("检查目的编码"); 
		return column;
	}
	/**
	 * 获取检查目的描述表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDes_ppsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Des_pps");
		column.setLength(1000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("检查目的描述"); 
		return column;
	}
	/**
	 * 获取检查部位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_bodyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_body");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("检查部位"); 
		return column;
	}
	/**
	 * 获取检查部位编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_bodyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_body");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("检查部位编码"); 
		return column;
	}
	/**
	 * 获取检查体位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_posCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pos");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("检查体位"); 
		return column;
	}
	/**
	 * 获取检查体位编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_posCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_pos");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("检查体位编码"); 
		return column;
	}
	/**
	 * 获取床旁执行标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_mp_bedCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_mp_bed");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("床旁执行标识"); 
		return column;
	}
	/**
	 * 获取客户扩展字段1表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef1CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def1");
		column.setLength(2500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段1"); 
		return column;
	}
	/**
	 * 获取客户扩展字段2表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef2CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def2");
		column.setLength(2500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段2"); 
		return column;
	}
	/**
	 * 获取客户扩展字段3表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef3CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def3");
		column.setLength(2500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段3"); 
		return column;
	}
	/**
	 * 获取客户扩展字段4表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef4CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def4");
		column.setLength(2500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段4"); 
		return column;
	}
	/**
	 * 获取客户扩展字段5表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef5CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def5");
		column.setLength(2500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段5"); 
		return column;
	}
	/**
	 * 获取客户扩展字段6表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef6CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def6");
		column.setLength(2500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段6"); 
		return column;
	}
	/**
	 * 获取客户扩展字段7表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef7CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def7");
		column.setLength(2500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段7"); 
		return column;
	}
	/**
	 * 获取客户扩展字段8表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef8CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def8");
		column.setLength(2500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段8"); 
		return column;
	}
	/**
	 * 获取客户扩展字段9表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef9CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def9");
		column.setLength(2500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段9"); 
		return column;
	}
	/**
	 * 获取客户扩展字段10表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef10CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def10");
		column.setLength(2500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段10"); 
		return column;
	}
	/**
	 * 获取客户扩展字段11表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef11CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def11");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段11"); 
		return column;
	}
	/**
	 * 获取客户扩展字段12表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef12CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def12");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段12"); 
		return column;
	}
	/**
	 * 获取客户扩展字段13表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef13CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def13");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段13"); 
		return column;
	}
	/**
	 * 获取客户扩展字段14表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef14CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def14");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段14"); 
		return column;
	}
	/**
	 * 获取客户扩展字段15表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef15CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def15");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段15"); 
		return column;
	}
	/**
	 * 获取客户扩展字段16表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef16CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def16");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段16"); 
		return column;
	}
	/**
	 * 获取客户扩展字段17表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef17CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def17");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段17"); 
		return column;
	}
	/**
	 * 获取客户扩展字段18表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef18CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def18");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段18"); 
		return column;
	}
	/**
	 * 获取客户扩展字段19表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef19CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def19");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段19"); 
		return column;
	}
	/**
	 * 获取客户扩展字段20表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef20CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def20");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段20"); 
		return column;
	}
	/**
	 * 获取客户扩展字段21表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef21CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def21");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段21"); 
		return column;
	}
	/**
	 * 获取客户扩展字段22表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef22CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def22");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段22"); 
		return column;
	}
	/**
	 * 获取客户扩展字段23表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef23CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def23");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段23"); 
		return column;
	}
	/**
	 * 获取客户扩展字段24表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef24CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def24");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段24"); 
		return column;
	}
	/**
	 * 获取客户扩展字段25表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef25CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def25");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段25"); 
		return column;
	}
	/**
	 * 获取客户扩展字段26表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef26CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def26");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段26"); 
		return column;
	}
	/**
	 * 获取客户扩展字段27表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef27CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def27");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段27"); 
		return column;
	}
	/**
	 * 获取客户扩展字段28表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef28CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def28");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段28"); 
		return column;
	}
	/**
	 * 获取客户扩展字段29表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef29CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def29");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段29"); 
		return column;
	}
	/**
	 * 获取客户扩展字段30表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef30CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def30");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段30"); 
		return column;
	}
	/**
	 * 获取客户扩展字段31表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef31CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def31");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段31"); 
		return column;
	}
	/**
	 * 获取客户扩展字段32表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef32CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def32");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段32"); 
		return column;
	}
	/**
	 * 获取客户扩展字段33表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef33CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def33");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段33"); 
		return column;
	}
	/**
	 * 获取客户扩展字段34表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef34CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def34");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段34"); 
		return column;
	}
	/**
	 * 获取客户扩展字段35表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef35CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def35");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段35"); 
		return column;
	}
	/**
	 * 获取客户扩展字段36表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef36CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def36");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段36"); 
		return column;
	}
	/**
	 * 获取客户扩展字段37表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef37CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def37");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段37"); 
		return column;
	}
	/**
	 * 获取客户扩展字段38表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef38CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def38");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段38"); 
		return column;
	}
	/**
	 * 获取客户扩展字段39表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef39CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def39");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段39"); 
		return column;
	}
	/**
	 * 获取客户扩展字段40表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef40CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def40");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段40"); 
		return column;
	}
	/**
	 * 获取客户扩展字段41表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef41CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def41");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段41"); 
		return column;
	}
	/**
	 * 获取客户扩展字段42表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef42CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def42");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段42"); 
		return column;
	}
	/**
	 * 获取客户扩展字段43表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef43CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def43");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段43"); 
		return column;
	}
	/**
	 * 获取客户扩展字段44表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef44CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def44");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段44"); 
		return column;
	}
	/**
	 * 获取客户扩展字段45表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef45CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def45");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段45"); 
		return column;
	}
	/**
	 * 获取客户扩展字段46表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef46CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def46");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段46"); 
		return column;
	}
	/**
	 * 获取客户扩展字段47表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef47CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def47");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段47"); 
		return column;
	}
	/**
	 * 获取客户扩展字段48表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef48CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def48");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段48"); 
		return column;
	}
	/**
	 * 获取客户扩展字段49表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef49CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def49");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段49"); 
		return column;
	}
	/**
	 * 获取客户扩展字段50表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef50CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def50");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段50"); 
		return column;
	}
	/**
	 * 获取检查部位名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_bodyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_body");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("检查部位名称"); 
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
