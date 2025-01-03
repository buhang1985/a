
package iih.pe.pwf.pedwsquery.d.desc;

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
 * 体检分检检索 DO 元数据信息
 */
public class PeDwsQueryDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.pe.pwf.pedwsquery.d.PeDwsQueryDO";
	public static final String CLASS_DISPALYNAME = "体检分检检索";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_pedwsquery";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public PeDwsQueryDODesc(){
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
		this.setKeyDesc(getId_pedwsqueryADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_pedwsqueryADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getDt_beginADesc(tblDesc));
		this.add(getDt_endADesc(tblDesc));
		this.add(getDttpADesc(tblDesc));
		this.add(getId_depADesc(tblDesc));
		this.add(getId_pepsnapptADesc(tblDesc));
		this.add(getSuggtpADesc(tblDesc));
		this.add(getFiltercaADesc(tblDesc));
		this.add(getId_corpADesc(tblDesc));
		this.add(getFilterovalADesc(tblDesc));
		this.add(getFiltertrackADesc(tblDesc));
		this.add(getFilterhmADesc(tblDesc));
		this.add(getSortovalADesc(tblDesc));
		this.add(getRmk_corpADesc(tblDesc));
		this.add(getId_oval_doctorADesc(tblDesc));
		this.add(getId_corpapptADesc(tblDesc));
		this.add(getId_corpgrpADesc(tblDesc));
		this.add(getId_pedeptsetADesc(tblDesc));
		this.add(getPe_codeADesc(tblDesc));
		this.add(getKeytpADesc(tblDesc));
		this.add(getIdentitytpADesc(tblDesc));
		this.add(getCode_roomADesc(tblDesc));
		this.add(getName_roomADesc(tblDesc));
		this.add(getName_psnADesc(tblDesc));
		this.add(getAge_psnADesc(tblDesc));
		this.add(getSd_sex_psnADesc(tblDesc));
		this.add(getCard_peADesc(tblDesc));
		this.add(getCode_corpADesc(tblDesc));
		this.add(getName_corpADesc(tblDesc));
		this.add(getName_ovalADesc(tblDesc));
		this.add(getCode_ovalADesc(tblDesc));
		this.add(getCode_deptADesc(tblDesc));
		this.add(getName_deptADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_pedwsqueryCDesc(tblDesc));
		tblDesc.add(getId_pedwsqueryCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getDt_beginCDesc(tblDesc));
		tblDesc.add(getDt_endCDesc(tblDesc));
		tblDesc.add(getDttpCDesc(tblDesc));
		tblDesc.add(getId_depCDesc(tblDesc));
		tblDesc.add(getId_pepsnapptCDesc(tblDesc));
		tblDesc.add(getSuggtpCDesc(tblDesc));
		tblDesc.add(getFiltercaCDesc(tblDesc));
		tblDesc.add(getId_corpCDesc(tblDesc));
		tblDesc.add(getFilterovalCDesc(tblDesc));
		tblDesc.add(getFiltertrackCDesc(tblDesc));
		tblDesc.add(getFilterhmCDesc(tblDesc));
		tblDesc.add(getSortovalCDesc(tblDesc));
		tblDesc.add(getRmk_corpCDesc(tblDesc));
		tblDesc.add(getId_oval_doctorCDesc(tblDesc));
		tblDesc.add(getId_corpapptCDesc(tblDesc));
		tblDesc.add(getId_corpgrpCDesc(tblDesc));
		tblDesc.add(getId_pedeptsetCDesc(tblDesc));
		tblDesc.add(getPe_codeCDesc(tblDesc));
		tblDesc.add(getKeytpCDesc(tblDesc));
		tblDesc.add(getIdentitytpCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 体检分检检索主键标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pedwsqueryADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pedwsquery",  getId_pedwsqueryCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检分检检索主键标识");
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
	 * 开始日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_beginADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_begin",  getDt_beginCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("开始日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 结束日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_endADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_end",  getDt_endCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("结束日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 检索日期类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDttpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dttp",  getDttpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("检索日期类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 所属诊间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_depADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep",  getId_depCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("所属诊间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 体检预约单ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pepsnapptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pepsnappt",  getId_pepsnapptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检预约单ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 建议过滤属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSuggtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Suggtp",  getSuggtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("建议过滤");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 过滤分类属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFiltercaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Filterca",  getFiltercaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("过滤分类");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 团体属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_corpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_corp",  getId_corpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("团体");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 总检状态过滤属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFilterovalADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Filteroval",  getFilterovalCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("总检状态过滤");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 阳性追踪状态过滤属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFiltertrackADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Filtertrack",  getFiltertrackCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("阳性追踪状态过滤");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 健康管理状态过滤属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFilterhmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Filterhm",  getFilterhmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("健康管理状态过滤");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 总检排序方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSortovalADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sortoval",  getSortovalCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("总检排序方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备注属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRmk_corpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Rmk_corp",  getRmk_corpCDesc(tblDesc), this);
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
	 * 总检医生属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_oval_doctorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_oval_doctor",  getId_oval_doctorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("总检医生");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 团体预约单ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_corpapptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_corpappt",  getId_corpapptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("团体预约单ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 团体分组ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_corpgrpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_corpgrp",  getId_corpgrpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("团体分组ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检科室ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pedeptsetADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pedeptset",  getId_pedeptsetCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检科室ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 体检编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPe_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pe_code",  getPe_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 检索关键字类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getKeytpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Keytp",  getKeytpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("检索关键字类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检者身份属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIdentitytpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Identitytp",  getIdentitytpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("体检者身份");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊间编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_roomADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_room",  getCode_roomCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊间编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_bd_diroom a0b3","id_dep=id_pediroom","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊间名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_roomADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_room",  getName_roomCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊间名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_bd_diroom a0b3","id_dep=id_pediroom","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_psnADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_psn",  getName_psnCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_apt_pepsnappt a0b4","id_pepsnappt=id_pepsnappt","name_psn"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 年龄属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAge_psnADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Age_psn",  getAge_psnCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("年龄");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_apt_pepsnappt a0b4","id_pepsnappt=id_pepsnappt","age_psn"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 性别编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_sex_psnADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_sex_psn",  getSd_sex_psnCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("性别编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_apt_pepsnappt a0b4","id_pepsnappt=id_pepsnappt","sd_sex_psn"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检流程号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCard_peADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Card_pe",  getCard_peCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检流程号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_apt_pepsnappt a0b4","id_pepsnappt=id_pepsnappt","card_pe"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 单位编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_corpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_corp",  getCode_corpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("单位编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_or_pecorpbinfo a0b5","id_corp=id_pecorpbinfo","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 单位名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_corpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_corp",  getName_corpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("单位名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_or_pecorpbinfo a0b5","id_corp=id_pecorpbinfo","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 总检医生名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_ovalADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_oval",  getName_ovalCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("总检医生名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sys_user a0b6","id_oval_doctor=id_user","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 总检医生编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_ovalADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_oval",  getCode_ovalCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("总检医生编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sys_user a0b6","id_oval_doctor=id_user","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检科室编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_deptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_dept",  getCode_deptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检科室编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_bd_deptset a0b7","id_pedeptset=id_pedeptset","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检科室名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_deptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dept",  getName_deptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检科室名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_bd_deptset a0b7","id_pedeptset=id_pedeptset","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取体检分检检索主键标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pedwsqueryCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pedwsquery");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("体检分检检索主键标识"); 
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
	 * 获取开始日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_beginCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_begin");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("开始日期"); 
		return column;
	}
	/**
	 * 获取结束日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_endCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_end");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("结束日期"); 
		return column;
	}
	/**
	 * 获取检索日期类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDttpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dttp");
		column.setLength(20);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("检索日期类型"); 
		return column;
	}
	/**
	 * 获取所属诊间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_depCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("所属诊间"); 
		return column;
	}
	/**
	 * 获取体检预约单ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pepsnapptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pepsnappt");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检预约单ID"); 
		return column;
	}
	/**
	 * 获取建议过滤表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSuggtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Suggtp");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("建议过滤"); 
		return column;
	}
	/**
	 * 获取过滤分类表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFiltercaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Filterca");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("过滤分类"); 
		return column;
	}
	/**
	 * 获取团体表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_corpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_corp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("团体"); 
		return column;
	}
	/**
	 * 获取总检状态过滤表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFilterovalCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Filteroval");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("总检状态过滤"); 
		return column;
	}
	/**
	 * 获取阳性追踪状态过滤表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFiltertrackCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Filtertrack");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("阳性追踪状态过滤"); 
		return column;
	}
	/**
	 * 获取健康管理状态过滤表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFilterhmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Filterhm");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("健康管理状态过滤"); 
		return column;
	}
	/**
	 * 获取总检排序方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSortovalCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sortoval");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("总检排序方式"); 
		return column;
	}
	/**
	 * 获取备注表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRmk_corpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Rmk_corp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备注"); 
		return column;
	}
	/**
	 * 获取总检医生表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_oval_doctorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_oval_doctor");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("总检医生"); 
		return column;
	}
	/**
	 * 获取团体预约单ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_corpapptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_corpappt");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("团体预约单ID"); 
		return column;
	}
	/**
	 * 获取团体分组ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_corpgrpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_corpgrp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("团体分组ID"); 
		return column;
	}
	/**
	 * 获取体检科室ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pedeptsetCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pedeptset");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检科室ID"); 
		return column;
	}
	/**
	 * 获取体检编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPe_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pe_code");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检编码"); 
		return column;
	}
	/**
	 * 获取检索关键字类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getKeytpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Keytp");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("检索关键字类型"); 
		return column;
	}
	/**
	 * 获取体检者身份表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIdentitytpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Identitytp");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("体检者身份"); 
		return column;
	}
	/**
	 * 获取诊间编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_roomCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_room");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊间编码"); 
		return column;
	}
	/**
	 * 获取诊间名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_roomCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_room");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊间名称"); 
		return column;
	}
	/**
	 * 获取客户姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_psnCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_psn");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户姓名"); 
		return column;
	}
	/**
	 * 获取年龄表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAge_psnCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Age_psn");
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("年龄"); 
		return column;
	}
	/**
	 * 获取性别编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_sex_psnCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_sex_psn");
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("性别编码"); 
		return column;
	}
	/**
	 * 获取体检流程号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCard_peCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Card_pe");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检流程号"); 
		return column;
	}
	/**
	 * 获取单位编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_corpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_corp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("单位编码"); 
		return column;
	}
	/**
	 * 获取单位名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_corpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_corp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("单位名称"); 
		return column;
	}
	/**
	 * 获取总检医生名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_ovalCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_oval");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("总检医生名称"); 
		return column;
	}
	/**
	 * 获取总检医生编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_ovalCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_oval");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("总检医生编码"); 
		return column;
	}
	/**
	 * 获取体检科室编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_deptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_dept");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检科室编码"); 
		return column;
	}
	/**
	 * 获取体检科室名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_deptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dept");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检科室名称"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id","Id_pedwsquery");
		iBDDataInfoFldMap.put("id_org","Id_org");
		iBDDataInfoFldMap.put("id_group","Id_grp");
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
