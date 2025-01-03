
package iih.pe.pip.peipdwquery.d.desc;

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
 * 体检住院医生站查询 DO 元数据信息
 */
public class PeIpDwQueryDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.pe.pip.peipdwquery.d.PeIpDwQueryDO";
	public static final String CLASS_DISPALYNAME = "体检住院医生站查询";
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
	public PeIpDwQueryDODesc(){
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
		this.add(getId_depADesc(tblDesc));
		this.add(getId_pepsnapptADesc(tblDesc));
		this.add(getSuggtpADesc(tblDesc));
		this.add(getFiltercaADesc(tblDesc));
		this.add(getFilterovalADesc(tblDesc));
		this.add(getFiltertrackADesc(tblDesc));
		this.add(getFilterhmADesc(tblDesc));
		this.add(getSortovalADesc(tblDesc));
		this.add(getRmk_corpADesc(tblDesc));
		this.add(getId_custADesc(tblDesc));
		this.add(getId_pecmpyADesc(tblDesc));
		this.add(getCode_roomADesc(tblDesc));
		this.add(getName_roomADesc(tblDesc));
		this.add(getName_psnADesc(tblDesc));
		this.add(getAge_psnADesc(tblDesc));
		this.add(getSd_sex_psnADesc(tblDesc));
		this.add(getCard_peADesc(tblDesc));
		this.add(getCode_custADesc(tblDesc));
		this.add(getName_custADesc(tblDesc));
		this.add(getNo_contractADesc(tblDesc));
		this.add(getTimes_peADesc(tblDesc));
		this.add(getEu_statusADesc(tblDesc));
		this.add(getFg_activeADesc(tblDesc));
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
		tblDesc.add(getId_depCDesc(tblDesc));
		tblDesc.add(getId_pepsnapptCDesc(tblDesc));
		tblDesc.add(getSuggtpCDesc(tblDesc));
		tblDesc.add(getFiltercaCDesc(tblDesc));
		tblDesc.add(getFilterovalCDesc(tblDesc));
		tblDesc.add(getFiltertrackCDesc(tblDesc));
		tblDesc.add(getFilterhmCDesc(tblDesc));
		tblDesc.add(getSortovalCDesc(tblDesc));
		tblDesc.add(getRmk_corpCDesc(tblDesc));
		tblDesc.add(getId_custCDesc(tblDesc));
		tblDesc.add(getId_pecmpyCDesc(tblDesc));
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
	 * 付款客户属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_custADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_cust",  getId_custCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("付款客户");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 团检记录属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pecmpyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pecmpy",  getId_pecmpyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("团检记录");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
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
	 * 客户编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_custADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_cust",  getCode_custCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_cust a0b6","id_cust=id_cust","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_custADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_cust",  getName_custCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_cust a0b6","id_cust=id_cust","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 团检编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNo_contractADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("No_contract",  getNo_contractCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("团检编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"en_pe_cmpy a0b7","id_pecmpy=id_pecmpy","no_contract"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检次数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTimes_peADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Times_pe",  getTimes_peCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("体检次数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"en_pe_cmpy a0b7","id_pecmpy=id_pecmpy","times_pe"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 团检状态属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_statusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_status",  getEu_statusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("团检状态");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"en_pe_cmpy a0b7","id_pecmpy=id_pecmpy","eu_status"});
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 有效标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_activeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_active",  getFg_activeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("有效标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"en_pe_cmpy a0b7","id_pecmpy=id_pecmpy","fg_active"});
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
	 * 获取付款客户表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_custCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_cust");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("付款客户"); 
		return column;
	}
	/**
	 * 获取团检记录表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pecmpyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pecmpy");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("团检记录"); 
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
	 * 获取客户编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_custCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_cust");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户编码"); 
		return column;
	}
	/**
	 * 获取客户名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_custCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_cust");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户名称"); 
		return column;
	}
	/**
	 * 获取团检编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNo_contractCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"No_contract");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("团检编码"); 
		return column;
	}
	/**
	 * 获取体检次数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTimes_peCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Times_pe");
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("体检次数"); 
		return column;
	}
	/**
	 * 获取团检状态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_statusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_status");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("团检状态"); 
		return column;
	}
	/**
	 * 获取有效标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_activeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_active");
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("有效标识"); 
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
