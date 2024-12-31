
package iih.pe.pip.peipregquery.d.desc;

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
 * 住院体检名单列表查询 DO 元数据信息
 */
public class PeIpRegQueryDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.pe.pip.peipregquery.d.PeIpRegQueryDO";
	public static final String CLASS_DISPALYNAME = "住院体检名单列表查询";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_peregquery";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public PeIpRegQueryDODesc(){
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
		this.setKeyDesc(getId_peregqueryADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_peregqueryADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getDt_beginADesc(tblDesc));
		this.add(getDt_endADesc(tblDesc));
		this.add(getFiltercaADesc(tblDesc));
		this.add(getId_corpADesc(tblDesc));
		this.add(getCodeADesc(tblDesc));
		this.add(getNameADesc(tblDesc));
		this.add(getPe_codeADesc(tblDesc));
		this.add(getIdcodeADesc(tblDesc));
		this.add(getPycodeADesc(tblDesc));
		this.add(getMobADesc(tblDesc));
		this.add(getDt_birthADesc(tblDesc));
		this.add(getCardtpADesc(tblDesc));
		this.add(getCardnoADesc(tblDesc));
		this.add(getFg_prtguideADesc(tblDesc));
		this.add(getFg_prtbarcodeADesc(tblDesc));
		this.add(getFg_continputADesc(tblDesc));
		this.add(getFg_newADesc(tblDesc));
		this.add(getPsn_countADesc(tblDesc));
		this.add(getSt_diningADesc(tblDesc));
		this.add(getFilterovalADesc(tblDesc));
		this.add(getFiltertrackADesc(tblDesc));
		this.add(getFilterhmADesc(tblDesc));
		this.add(getHmerADesc(tblDesc));
		this.add(getFg_guiderprintADesc(tblDesc));
		this.add(getFg_barcodeprintADesc(tblDesc));
		this.add(getId_custADesc(tblDesc));
		this.add(getId_pecmpyADesc(tblDesc));
		this.add(getId_dep_nuradmADesc(tblDesc));
		this.add(getId_dep_phyadmADesc(tblDesc));
		this.add(getCode_corpADesc(tblDesc));
		this.add(getName_corpADesc(tblDesc));
		this.add(getCode_hmerADesc(tblDesc));
		this.add(getName_hmerADesc(tblDesc));
		this.add(getCode_custADesc(tblDesc));
		this.add(getName_custADesc(tblDesc));
		this.add(getNo_contractADesc(tblDesc));
		this.add(getTimes_peADesc(tblDesc));
		this.add(getEu_statusADesc(tblDesc));
		this.add(getCode_nuradmADesc(tblDesc));
		this.add(getName_nuradmADesc(tblDesc));
		this.add(getCode_phyadmADesc(tblDesc));
		this.add(getName_phyadmADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_peregqueryCDesc(tblDesc));
		tblDesc.add(getId_peregqueryCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getDt_beginCDesc(tblDesc));
		tblDesc.add(getDt_endCDesc(tblDesc));
		tblDesc.add(getFiltercaCDesc(tblDesc));
		tblDesc.add(getId_corpCDesc(tblDesc));
		tblDesc.add(getCodeCDesc(tblDesc));
		tblDesc.add(getNameCDesc(tblDesc));
		tblDesc.add(getPe_codeCDesc(tblDesc));
		tblDesc.add(getIdcodeCDesc(tblDesc));
		tblDesc.add(getPycodeCDesc(tblDesc));
		tblDesc.add(getMobCDesc(tblDesc));
		tblDesc.add(getDt_birthCDesc(tblDesc));
		tblDesc.add(getCardtpCDesc(tblDesc));
		tblDesc.add(getCardnoCDesc(tblDesc));
		tblDesc.add(getFg_prtguideCDesc(tblDesc));
		tblDesc.add(getFg_prtbarcodeCDesc(tblDesc));
		tblDesc.add(getFg_continputCDesc(tblDesc));
		tblDesc.add(getFg_newCDesc(tblDesc));
		tblDesc.add(getPsn_countCDesc(tblDesc));
		tblDesc.add(getSt_diningCDesc(tblDesc));
		tblDesc.add(getFilterovalCDesc(tblDesc));
		tblDesc.add(getFiltertrackCDesc(tblDesc));
		tblDesc.add(getFilterhmCDesc(tblDesc));
		tblDesc.add(getHmerCDesc(tblDesc));
		tblDesc.add(getFg_guiderprintCDesc(tblDesc));
		tblDesc.add(getFg_barcodeprintCDesc(tblDesc));
		tblDesc.add(getId_custCDesc(tblDesc));
		tblDesc.add(getId_pecmpyCDesc(tblDesc));
		tblDesc.add(getId_dep_nuradmCDesc(tblDesc));
		tblDesc.add(getId_dep_phyadmCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 体检登记检索主键标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_peregqueryADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_peregquery",  getId_peregqueryCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检登记检索主键标识");
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
	 * 客户编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code",  getCodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户编码");
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
	 * 体检唯一号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPe_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pe_code",  getPe_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检唯一号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 证件号码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIdcodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Idcode",  getIdcodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("证件号码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 拼音缩写属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPycodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pycode",  getPycodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("拼音缩写");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 移动电话属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMobADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mob",  getMobCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("移动电话");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 出生日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_birthADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_birth",  getDt_birthCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("出生日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 卡类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCardtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Cardtp",  getCardtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("卡类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 卡号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCardnoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Cardno",  getCardnoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("卡号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 打印导引单属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_prtguideADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_prtguide",  getFg_prtguideCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("打印导引单");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 打印条码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_prtbarcodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_prtbarcode",  getFg_prtbarcodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("打印条码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 连续录入属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_continputADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_continput",  getFg_continputCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("连续录入");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 自动新建属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_newADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_new",  getFg_newCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("自动新建");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 人数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPsn_countADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Psn_count",  getPsn_countCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("人数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 用餐状态属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSt_diningADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("St_dining",  getSt_diningCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("用餐状态");
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
	 * 健康管理预约状态过滤属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFilterhmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Filterhm",  getFilterhmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("健康管理预约状态过滤");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 健康管理师属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHmerADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Hmer",  getHmerCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("健康管理师");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 导引单打印标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_guiderprintADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_guiderprint",  getFg_guiderprintCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("导引单打印标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 条码打印标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_barcodeprintADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_barcodeprint",  getFg_barcodeprintCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("条码打印标识");
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
	 * 入院病区属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dep_nuradmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep_nuradm",  getId_dep_nuradmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入院病区");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 入院科室属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dep_phyadmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep_phyadm",  getId_dep_phyadmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入院科室");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
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
		attrDesc.setRefTblInfos(new String[]{"pe_or_pecorpbinfo a0b3","id_corp=id_pecorpbinfo","code"});
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
		attrDesc.setRefTblInfos(new String[]{"pe_or_pecorpbinfo a0b3","id_corp=id_pecorpbinfo","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 健康管理师编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_hmerADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_hmer",  getCode_hmerCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("健康管理师编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_hm_hmer a0b4","hmer=id_pehmer","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 健康管理师姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_hmerADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_hmer",  getName_hmerCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("健康管理师姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_hm_hmer a0b4","hmer=id_pehmer","name"});
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
		attrDesc.setRefTblInfos(new String[]{"bd_cust a0b5","id_cust=id_cust","code"});
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
		attrDesc.setRefTblInfos(new String[]{"bd_cust a0b5","id_cust=id_cust","name"});
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
		attrDesc.setRefTblInfos(new String[]{"en_pe_cmpy a0b6","id_pecmpy=id_pecmpy","no_contract"});
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
		attrDesc.setRefTblInfos(new String[]{"en_pe_cmpy a0b6","id_pecmpy=id_pecmpy","times_pe"});
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
		attrDesc.setRefTblInfos(new String[]{"en_pe_cmpy a0b6","id_pecmpy=id_pecmpy","eu_status"});
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_nuradmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_nuradm",  getCode_nuradmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b7","id_dep_nuradm=id_dep","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_nuradmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_nuradm",  getName_nuradmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b7","id_dep_nuradm=id_dep","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_phyadmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_phyadm",  getCode_phyadmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b8","id_dep_phyadm=id_dep","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_phyadmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_phyadm",  getName_phyadmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b8","id_dep_phyadm=id_dep","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取体检登记检索主键标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_peregqueryCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_peregquery");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("体检登记检索主键标识"); 
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
	 * 获取客户编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户编码"); 
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
	 * 获取体检唯一号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPe_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pe_code");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检唯一号"); 
		return column;
	}
	/**
	 * 获取证件号码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIdcodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Idcode");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("证件号码"); 
		return column;
	}
	/**
	 * 获取拼音缩写表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPycodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pycode");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("拼音缩写"); 
		return column;
	}
	/**
	 * 获取移动电话表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMobCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mob");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("移动电话"); 
		return column;
	}
	/**
	 * 获取出生日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_birthCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_birth");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("出生日期"); 
		return column;
	}
	/**
	 * 获取卡类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCardtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Cardtp");
		column.setLength(20);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("卡类型"); 
		return column;
	}
	/**
	 * 获取卡号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCardnoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Cardno");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("卡号"); 
		return column;
	}
	/**
	 * 获取打印导引单表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_prtguideCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_prtguide");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("打印导引单"); 
		return column;
	}
	/**
	 * 获取打印条码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_prtbarcodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_prtbarcode");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("打印条码"); 
		return column;
	}
	/**
	 * 获取连续录入表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_continputCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_continput");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("连续录入"); 
		return column;
	}
	/**
	 * 获取自动新建表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_newCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_new");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("自动新建"); 
		return column;
	}
	/**
	 * 获取人数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPsn_countCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Psn_count");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("人数"); 
		return column;
	}
	/**
	 * 获取用餐状态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSt_diningCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"St_dining");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("用餐状态"); 
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
	 * 获取健康管理预约状态过滤表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFilterhmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Filterhm");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("健康管理预约状态过滤"); 
		return column;
	}
	/**
	 * 获取健康管理师表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHmerCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Hmer");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("健康管理师"); 
		return column;
	}
	/**
	 * 获取导引单打印标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_guiderprintCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_guiderprint");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("导引单打印标识"); 
		return column;
	}
	/**
	 * 获取条码打印标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_barcodeprintCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_barcodeprint");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("条码打印标识"); 
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
	 * 获取入院病区表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dep_nuradmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep_nuradm");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入院病区"); 
		return column;
	}
	/**
	 * 获取入院科室表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dep_phyadmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep_phyadm");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入院科室"); 
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
	 * 获取健康管理师编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_hmerCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_hmer");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("健康管理师编码"); 
		return column;
	}
	/**
	 * 获取健康管理师姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_hmerCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_hmer");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("健康管理师姓名"); 
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
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_nuradmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_nuradm");
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
	private IColumnDesc getName_nuradmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_nuradm");
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
	private IColumnDesc getCode_phyadmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_phyadm");
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
	private IColumnDesc getName_phyadmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_phyadm");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id","Id_peregquery");
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
