
package iih.mp.nr.mpordperformstate.d.desc;

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
 * 医嘱执行状态记录 DO 元数据信息
 */
public class MpOrdPerformStateDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.mp.nr.mpordperformstate.d.MpOrdPerformStateDO";
	public static final String CLASS_DISPALYNAME = "医嘱执行状态记录";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "MP_OR_PR_STA";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_orprsta";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public MpOrdPerformStateDODesc(){
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
		this.setKeyDesc(getId_orprstaADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_orprstaADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_previousADesc(tblDesc));
		this.add(getId_or_prADesc(tblDesc));
		this.add(getId_orADesc(tblDesc));
		this.add(getDt_mp_planADesc(tblDesc));
		this.add(getEu_suADesc(tblDesc));
		this.add(getSd_srvtpADesc(tblDesc));
		this.add(getId_patADesc(tblDesc));
		this.add(getCode_entpADesc(tblDesc));
		this.add(getId_entADesc(tblDesc));
		this.add(getId_orpltpstaADesc(tblDesc));
		this.add(getName_orpltpstaADesc(tblDesc));
		this.add(getId_skip_reasonADesc(tblDesc));
		this.add(getSd_skip_reasonADesc(tblDesc));
		this.add(getSkip_reasonADesc(tblDesc));
		this.add(getDt_mpADesc(tblDesc));
		this.add(getId_empADesc(tblDesc));
		this.add(getId_depADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getFg_cancelADesc(tblDesc));
		this.add(getFg_selfreviewADesc(tblDesc));
		this.add(getSd_selfreviewADesc(tblDesc));
		this.add(getFg_cancelableADesc(tblDesc));
		this.add(getCodeADesc(tblDesc));
		this.add(getSortnoADesc(tblDesc));
		this.add(getFg_feertnableADesc(tblDesc));
		this.add(getUsercodeADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_orprstaCDesc(tblDesc));
		tblDesc.add(getId_orprstaCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_previousCDesc(tblDesc));
		tblDesc.add(getId_or_prCDesc(tblDesc));
		tblDesc.add(getId_orCDesc(tblDesc));
		tblDesc.add(getDt_mp_planCDesc(tblDesc));
		tblDesc.add(getEu_suCDesc(tblDesc));
		tblDesc.add(getSd_srvtpCDesc(tblDesc));
		tblDesc.add(getId_patCDesc(tblDesc));
		tblDesc.add(getCode_entpCDesc(tblDesc));
		tblDesc.add(getId_entCDesc(tblDesc));
		tblDesc.add(getId_orpltpstaCDesc(tblDesc));
		tblDesc.add(getName_orpltpstaCDesc(tblDesc));
		tblDesc.add(getId_skip_reasonCDesc(tblDesc));
		tblDesc.add(getSd_skip_reasonCDesc(tblDesc));
		tblDesc.add(getSkip_reasonCDesc(tblDesc));
		tblDesc.add(getDt_mpCDesc(tblDesc));
		tblDesc.add(getId_empCDesc(tblDesc));
		tblDesc.add(getId_depCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		tblDesc.add(getFg_cancelCDesc(tblDesc));
		tblDesc.add(getFg_selfreviewCDesc(tblDesc));
		tblDesc.add(getSd_selfreviewCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 医嘱执行状态记录id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_orprstaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_orprsta",  getId_orprstaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医嘱执行状态记录id");
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
	 * 上一个状态属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_previousADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_previous",  getId_previousCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("上一个状态");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医嘱执行记录id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_or_prADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_or_pr",  getId_or_prCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医嘱执行记录id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 医嘱属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_orADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_or",  getId_orCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医嘱");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 计划执行时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_mp_planADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_mp_plan",  getDt_mp_planCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("计划执行时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 执行状态属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_suADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_su",  getEu_suCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("执行状态");
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
	private IAttrDesc getSd_srvtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_srvtp",  getSd_srvtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_patADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pat",  getId_patCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者");
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
	 * 就诊id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_entADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ent",  getId_entCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("就诊id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医嘱执行闭环分类状态ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_orpltpstaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_orpltpsta",  getId_orpltpstaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医嘱执行闭环分类状态ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 医嘱执行闭环分类状态名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_orpltpstaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_orpltpsta",  getName_orpltpstaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医嘱执行闭环分类状态名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 不执行原因ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_skip_reasonADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_skip_reason",  getId_skip_reasonCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("不执行原因ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 不执行原因编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_skip_reasonADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_skip_reason",  getSd_skip_reasonCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("不执行原因编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 不执行原因属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSkip_reasonADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Skip_reason",  getSkip_reasonCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("不执行原因");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 执行时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_mpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_mp",  getDt_mpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("执行时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 执行人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_empADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp",  getId_empCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("执行人");
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
	private IAttrDesc getId_depADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep",  getId_depCDesc(tblDesc), this);
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
	 * 是否取消属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_cancelADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_cancel",  getFg_cancelCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否取消");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 同一人复核配液标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_selfreviewADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_selfreview",  getFg_selfreviewCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("同一人复核配液标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 同一复核配液原因属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_selfreviewADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_selfreview",  getSd_selfreviewCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("同一复核配液原因");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 可取消标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_cancelableADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_cancelable",  getFg_cancelableCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("可取消标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"BD_ORPLTPSTA a0b9","id_orpltpsta=id_orpltpsta","fg_cancelable"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 闭环状态编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code",  getCodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("闭环状态编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"BD_ORPLTPSTA a0b9","id_orpltpsta=id_orpltpsta","code"});
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
		attrDesc.setRefTblInfos(new String[]{"BD_ORPLTPSTA a0b9","id_orpltpsta=id_orpltpsta","sortno"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 可退费标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_feertnableADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_feertnable",  getFg_feertnableCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("可退费标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"BD_ORPLTPSTA a0b9","id_orpltpsta=id_orpltpsta","fg_feertnable"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 用户编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getUsercodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Usercode",  getUsercodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用户编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sys_user a0b6","createdby=id_user","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取医嘱执行状态记录id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_orprstaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_orprsta");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医嘱执行状态记录id"); 
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
	 * 获取上一个状态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_previousCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_previous");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("上一个状态"); 
		return column;
	}
	/**
	 * 获取医嘱执行记录id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_or_prCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_or_pr");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医嘱执行记录id"); 
		return column;
	}
	/**
	 * 获取医嘱表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_orCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_or");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医嘱"); 
		return column;
	}
	/**
	 * 获取计划执行时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_mp_planCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_mp_plan");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("计划执行时间"); 
		return column;
	}
	/**
	 * 获取执行状态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_suCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_su");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("执行状态"); 
		return column;
	}
	/**
	 * 获取服务类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_srvtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_srvtp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务类型"); 
		return column;
	}
	/**
	 * 获取患者表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pat");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者"); 
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
	 * 获取就诊id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_entCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ent");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊id"); 
		return column;
	}
	/**
	 * 获取医嘱执行闭环分类状态ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_orpltpstaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_orpltpsta");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医嘱执行闭环分类状态ID"); 
		return column;
	}
	/**
	 * 获取医嘱执行闭环分类状态名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_orpltpstaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_orpltpsta");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医嘱执行闭环分类状态名称"); 
		return column;
	}
	/**
	 * 获取不执行原因ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_skip_reasonCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_skip_reason");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("不执行原因ID"); 
		return column;
	}
	/**
	 * 获取不执行原因编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_skip_reasonCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_skip_reason");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("不执行原因编码"); 
		return column;
	}
	/**
	 * 获取不执行原因表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSkip_reasonCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Skip_reason");
		column.setLength(256);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("不执行原因"); 
		return column;
	}
	/**
	 * 获取执行时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_mpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_mp");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("执行时间"); 
		return column;
	}
	/**
	 * 获取执行人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_empCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("执行人"); 
		return column;
	}
	/**
	 * 获取执行科室表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_depCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("执行科室"); 
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
	 * 获取是否取消表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_cancelCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_cancel");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否取消"); 
		return column;
	}
	/**
	 * 获取同一人复核配液标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_selfreviewCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_selfreview");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("同一人复核配液标志"); 
		return column;
	}
	/**
	 * 获取同一复核配液原因表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_selfreviewCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_selfreview");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("同一复核配液原因"); 
		return column;
	}
	/**
	 * 获取可取消标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_cancelableCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_cancelable");
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("可取消标志"); 
		return column;
	}
	/**
	 * 获取闭环状态编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("闭环状态编码"); 
		return column;
	}
	/**
	 * 获取序号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSortnoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sortno");
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("序号"); 
		return column;
	}
	/**
	 * 获取可退费标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_feertnableCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_feertnable");
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("可退费标志"); 
		return column;
	}
	/**
	 * 获取用户编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getUsercodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Usercode");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("用户编码"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id","Id_orprsta");
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
