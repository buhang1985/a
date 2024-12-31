
package iih.hp.cp.eletp.d.desc;

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
 * 诊疗计划元素类型 DO 元数据信息
 */
public class HpCpElemTypeDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.hp.cp.eletp.d.HpCpElemTypeDO";
	public static final String CLASS_DISPALYNAME = "诊疗计划元素类型";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "hp_cp_eletp";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_eletp";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public HpCpElemTypeDODesc(){
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
		this.setKeyDesc(getId_eletpADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_eletpADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getNameADesc(tblDesc));
		this.add(getCodeADesc(tblDesc));
		this.add(getSerialnoADesc(tblDesc));
		this.add(getId_parADesc(tblDesc));
		this.add(getFg_pkgADesc(tblDesc));
		this.add(getEu_pkg_disp_tpADesc(tblDesc));
		this.add(getFg_expand_defADesc(tblDesc));
		this.add(getEu_expand_dirADesc(tblDesc));
		this.add(getEu_child_sn_disp_tpADesc(tblDesc));
		this.add(getFg_needmatchADesc(tblDesc));
		this.add(getTarget_posADesc(tblDesc));
		this.add(getMatch_sqlADesc(tblDesc));
		this.add(getFg_need_execfmADesc(tblDesc));
		this.add(getId_exe_roleADesc(tblDesc));
		this.add(getSd_exe_roleADesc(tblDesc));
		this.add(getId_icoADesc(tblDesc));
		this.add(getSd_icoADesc(tblDesc));
		this.add(getId_if_exe_funcADesc(tblDesc));
		this.add(getId_if_exe_rsltADesc(tblDesc));
		this.add(getDataobjADesc(tblDesc));
		this.add(getFg_pat_noticeADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getId_inherit_parADesc(tblDesc));
		this.add(getName_parADesc(tblDesc));
		this.add(getName_exe_roleADesc(tblDesc));
		this.add(getIco_nameADesc(tblDesc));
		this.add(getName_if_funcADesc(tblDesc));
		this.add(getIf_func_contentADesc(tblDesc));
		this.add(getSd_iftp_funcADesc(tblDesc));
		this.add(getCode_if_funcADesc(tblDesc));
		this.add(getSd_iftp_rsltADesc(tblDesc));
		this.add(getName_if_rsltADesc(tblDesc));
		this.add(getCode_if_rsltADesc(tblDesc));
		this.add(getIf_rslt_contentADesc(tblDesc));
		this.add(getName_inherit_parADesc(tblDesc));
		this.add(getCode_inherit_parADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_eletpCDesc(tblDesc));
		tblDesc.add(getId_eletpCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getNameCDesc(tblDesc));
		tblDesc.add(getCodeCDesc(tblDesc));
		tblDesc.add(getSerialnoCDesc(tblDesc));
		tblDesc.add(getId_parCDesc(tblDesc));
		tblDesc.add(getFg_pkgCDesc(tblDesc));
		tblDesc.add(getEu_pkg_disp_tpCDesc(tblDesc));
		tblDesc.add(getFg_expand_defCDesc(tblDesc));
		tblDesc.add(getEu_expand_dirCDesc(tblDesc));
		tblDesc.add(getEu_child_sn_disp_tpCDesc(tblDesc));
		tblDesc.add(getFg_needmatchCDesc(tblDesc));
		tblDesc.add(getTarget_posCDesc(tblDesc));
		tblDesc.add(getMatch_sqlCDesc(tblDesc));
		tblDesc.add(getFg_need_execfmCDesc(tblDesc));
		tblDesc.add(getId_exe_roleCDesc(tblDesc));
		tblDesc.add(getSd_exe_roleCDesc(tblDesc));
		tblDesc.add(getId_icoCDesc(tblDesc));
		tblDesc.add(getSd_icoCDesc(tblDesc));
		tblDesc.add(getId_if_exe_funcCDesc(tblDesc));
		tblDesc.add(getId_if_exe_rsltCDesc(tblDesc));
		tblDesc.add(getDataobjCDesc(tblDesc));
		tblDesc.add(getFg_pat_noticeCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		tblDesc.add(getId_inherit_parCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 元素类型ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_eletpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_eletp",  getId_eletpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("元素类型ID");
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
	 * 机构属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_orgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_org",  getId_orgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("机构");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name",  getNameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setExtTag("BDMODE,URC");
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code",  getCodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setExtTag("BDMODE,URC");
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 序号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSerialnoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Serialno",  getSerialnoCDesc(tblDesc), this);
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
	 * 父类型ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_parADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_par",  getId_parCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("父类型ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 包标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_pkgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_pkg",  getFg_pkgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("包标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 包显示样式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_pkg_disp_tpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_pkg_disp_tp",  getEu_pkg_disp_tpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("包显示样式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 包是否默认展开属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_expand_defADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_expand_def",  getFg_expand_defCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("包是否默认展开");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 包展开方向属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_expand_dirADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_expand_dir",  getEu_expand_dirCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("包展开方向");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 子元素序号显示类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_child_sn_disp_tpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_child_sn_disp_tp",  getEu_child_sn_disp_tpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("子元素序号显示类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否需要对照属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_needmatchADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_needmatch",  getFg_needmatchCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否需要对照");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 对照目标位置属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTarget_posADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Target_pos",  getTarget_posCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("对照目标位置");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 对照数据获取SQL属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMatch_sqlADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Match_sql",  getMatch_sqlCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("对照数据获取SQL");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 需要执行确认属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_need_execfmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_need_execfm",  getFg_need_execfmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("需要执行确认");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 确认角色ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_exe_roleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_exe_role",  getId_exe_roleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("确认角色ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 确认角色编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_exe_roleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_exe_role",  getSd_exe_roleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("确认角色编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 元素图标属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_icoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ico",  getId_icoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("元素图标");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 元素图标编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_icoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_ico",  getSd_icoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("元素图标编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 执行功能触发接口属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_if_exe_funcADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_if_exe_func",  getId_if_exe_funcCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("执行功能触发接口");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 执行结果判断接口属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_if_exe_rsltADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_if_exe_rslt",  getId_if_exe_rsltCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("执行结果判断接口");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 对应DO路径属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDataobjADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dataobj",  getDataobjCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("对应DO路径");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否显示在患者版路径告知单属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_pat_noticeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_pat_notice",  getFg_pat_noticeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否显示在患者版路径告知单");
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
	 * 继承父级元素类型ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_inherit_parADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_inherit_par",  getId_inherit_parCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("继承父级元素类型ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_parADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_par",  getName_parCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"hp_cp_eletp a0b2","id_par=id_eletp","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 确认角色属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_exe_roleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_exe_role",  getName_exe_roleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("确认角色");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b5","id_exe_role=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 元素图标属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIco_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ico_name",  getIco_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("元素图标");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b6","id_ico=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 接口名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_if_funcADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_if_func",  getName_if_funcCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("接口名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"HP_CP_IF a0b3","id_if_exe_func=id_if","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 接口内容属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIf_func_contentADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("If_func_content",  getIf_func_contentCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("接口内容");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"HP_CP_IF a0b3","id_if_exe_func=id_if","if_content"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 接口类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_iftp_funcADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_iftp_func",  getSd_iftp_funcCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("接口类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"HP_CP_IF a0b3","id_if_exe_func=id_if","sd_iftp"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 接口编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_if_funcADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_if_func",  getCode_if_funcCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("接口编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"HP_CP_IF a0b3","id_if_exe_func=id_if","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 接口类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_iftp_rsltADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_iftp_rslt",  getSd_iftp_rsltCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("接口类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"HP_CP_IF a0b4","id_if_exe_rslt=id_if","sd_iftp"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 接口名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_if_rsltADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_if_rslt",  getName_if_rsltCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("接口名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"HP_CP_IF a0b4","id_if_exe_rslt=id_if","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 接口编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_if_rsltADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_if_rslt",  getCode_if_rsltCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("接口编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"HP_CP_IF a0b4","id_if_exe_rslt=id_if","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 接口内容属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIf_rslt_contentADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("If_rslt_content",  getIf_rslt_contentCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("接口内容");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"HP_CP_IF a0b4","id_if_exe_rslt=id_if","if_content"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 继承父级元素名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_inherit_parADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_inherit_par",  getName_inherit_parCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("继承父级元素名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"hp_cp_eletp a0b11","id_inherit_par=id_eletp","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 继承父级元素编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_inherit_parADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_inherit_par",  getCode_inherit_parCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("继承父级元素编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"hp_cp_eletp a0b11","id_inherit_par=id_eletp","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取元素类型ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_eletpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_eletp");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("元素类型ID"); 
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
	 * 获取机构表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_orgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_org");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("机构"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name");
		column.setLength(100);
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
	private IColumnDesc getCodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取序号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSerialnoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Serialno");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("序号"); 
		return column;
	}
	/**
	 * 获取父类型ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_parCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_par");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("父类型ID"); 
		return column;
	}
	/**
	 * 获取包标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_pkgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_pkg");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("包标志"); 
		return column;
	}
	/**
	 * 获取包显示样式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_pkg_disp_tpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_pkg_disp_tp");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("包显示样式"); 
		return column;
	}
	/**
	 * 获取包是否默认展开表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_expand_defCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_expand_def");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("包是否默认展开"); 
		return column;
	}
	/**
	 * 获取包展开方向表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_expand_dirCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_expand_dir");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("包展开方向"); 
		return column;
	}
	/**
	 * 获取子元素序号显示类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_child_sn_disp_tpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_child_sn_disp_tp");
		column.setLength(20);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("子元素序号显示类型"); 
		return column;
	}
	/**
	 * 获取是否需要对照表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_needmatchCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_needmatch");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否需要对照"); 
		return column;
	}
	/**
	 * 获取对照目标位置表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTarget_posCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Target_pos");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("对照目标位置"); 
		return column;
	}
	/**
	 * 获取对照数据获取SQL表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMatch_sqlCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Match_sql");
		column.setLength(4000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("对照数据获取SQL"); 
		return column;
	}
	/**
	 * 获取需要执行确认表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_need_execfmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_need_execfm");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("需要执行确认"); 
		return column;
	}
	/**
	 * 获取确认角色ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_exe_roleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_exe_role");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("确认角色ID"); 
		return column;
	}
	/**
	 * 获取确认角色编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_exe_roleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_exe_role");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("确认角色编码"); 
		return column;
	}
	/**
	 * 获取元素图标表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_icoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ico");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("元素图标"); 
		return column;
	}
	/**
	 * 获取元素图标编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_icoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_ico");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("元素图标编码"); 
		return column;
	}
	/**
	 * 获取执行功能触发接口表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_if_exe_funcCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_if_exe_func");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("执行功能触发接口"); 
		return column;
	}
	/**
	 * 获取执行结果判断接口表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_if_exe_rsltCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_if_exe_rslt");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("执行结果判断接口"); 
		return column;
	}
	/**
	 * 获取对应DO路径表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDataobjCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dataobj");
		column.setLength(4000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("对应DO路径"); 
		return column;
	}
	/**
	 * 获取是否显示在患者版路径告知单表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_pat_noticeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_pat_notice");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否显示在患者版路径告知单"); 
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
	 * 获取继承父级元素类型ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_inherit_parCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_inherit_par");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("继承父级元素类型ID"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_parCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_par");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取确认角色表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_exe_roleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_exe_role");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("确认角色"); 
		return column;
	}
	/**
	 * 获取元素图标表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIco_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ico_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("元素图标"); 
		return column;
	}
	/**
	 * 获取接口名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_if_funcCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_if_func");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("接口名称"); 
		return column;
	}
	/**
	 * 获取接口内容表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIf_func_contentCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"If_func_content");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("接口内容"); 
		return column;
	}
	/**
	 * 获取接口类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_iftp_funcCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_iftp_func");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("接口类型编码"); 
		return column;
	}
	/**
	 * 获取接口编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_if_funcCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_if_func");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("接口编码"); 
		return column;
	}
	/**
	 * 获取接口类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_iftp_rsltCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_iftp_rslt");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("接口类型编码"); 
		return column;
	}
	/**
	 * 获取接口名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_if_rsltCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_if_rslt");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("接口名称"); 
		return column;
	}
	/**
	 * 获取接口编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_if_rsltCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_if_rslt");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("接口编码"); 
		return column;
	}
	/**
	 * 获取接口内容表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIf_rslt_contentCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"If_rslt_content");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("接口内容"); 
		return column;
	}
	/**
	 * 获取继承父级元素名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_inherit_parCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_inherit_par");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("继承父级元素名称"); 
		return column;
	}
	/**
	 * 获取继承父级元素编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_inherit_parCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_inherit_par");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("继承父级元素编码"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("name","Name");
		iBDDataInfoFldMap.put("id_group","Id_grp");
		iBDDataInfoFldMap.put("pid","Id_par");
		iBDDataInfoFldMap.put("id","Id_eletp");
		iBDDataInfoFldMap.put("id_org","Id_org");
		iBDDataInfoFldMap.put("code","Serialno");
	}

	/**
	 * 设置实体审计信息数据映射关系 
	 */
	private void setIAuditInfoFldMap(){
		iAuditInfoFldMap=new HashMap<String, String>();
		iAuditInfoFldMap.put("modifiedtime","Modifiedtime");
		iAuditInfoFldMap.put("createdby","Createdby");
		iAuditInfoFldMap.put("createdtime","Createdtime");
		iAuditInfoFldMap.put("modifiedby","Modifiedby");
	}
	
	/**
	 * 设置实体默认值
	 */
	private void setDefaultValueMap(){
		defaultValueMap=new HashMap<String, Object>();
	}
	
}
