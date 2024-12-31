
package iih.bd.srv.ortpl.d.desc;

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
 * 医嘱模板明细 DO 元数据信息
 */
public class OrTplNItmDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.bd.srv.ortpl.d.OrTplNItmDO";
	public static final String CLASS_DISPALYNAME = "医嘱模板明细";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "bd_srv_ortmpl_itm";
	public static final String TABLE_ALIAS_NAME = "a1";
	public static final String PRIMARYKEY_FIELDNAME="Id_ortmplitm";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public OrTplNItmDODesc(){
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
		this.setKeyDesc(getId_ortmplitmADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_ortmplADesc(tblDesc));
		this.add(getId_ortmplitmADesc(tblDesc));
		this.add(getSortnoADesc(tblDesc));
		this.add(getEu_ortplitmtpADesc(tblDesc));
		this.add(getId_ortmplADesc(tblDesc));
		this.add(getId_srvADesc(tblDesc));
		this.add(getId_srvtpADesc(tblDesc));
		this.add(getSd_srvtpADesc(tblDesc));
		this.add(getId_routeADesc(tblDesc));
		this.add(getId_routedesADesc(tblDesc));
		this.add(getId_boilADesc(tblDesc));
		this.add(getId_boildesADesc(tblDesc));
		this.add(getId_freqADesc(tblDesc));
		this.add(getId_unit_medADesc(tblDesc));
		this.add(getQuan_medADesc(tblDesc));
		this.add(getId_mmADesc(tblDesc));
		this.add(getFg_syncADesc(tblDesc));
		this.add(getId_dep_mpADesc(tblDesc));
		this.add(getDes_orADesc(tblDesc));
		this.add(getDays_orADesc(tblDesc));
		this.add(getQuan_total_meduADesc(tblDesc));
		this.add(getId_total_meduADesc(tblDesc));
		this.add(getTimesADesc(tblDesc));
		this.add(getId_samptpADesc(tblDesc));
		this.add(getSd_samptpADesc(tblDesc));
		this.add(getFg_nothingwithordersADesc(tblDesc));
		this.add(getId_dept_whADesc(tblDesc));
		this.add(getName_srvADesc(tblDesc));
		this.add(getFg_wholepackADesc(tblDesc));
		this.add(getFg_pres_outpADesc(tblDesc));
		this.add(getId_drugdeliverymethodADesc(tblDesc));
		this.add(getSd_drugdeliverymethodADesc(tblDesc));
		this.add(getName_drugdeliverymethodADesc(tblDesc));
		this.add(getQuan_medu_curADesc(tblDesc));
		this.add(getId_medu_curADesc(tblDesc));
		this.add(getFactor_curADesc(tblDesc));
		this.add(getId_excessive_reasonADesc(tblDesc));
		this.add(getSd_excessive_reasonADesc(tblDesc));
		this.add(getName_excessive_reasonADesc(tblDesc));
		this.add(getFg_skintestADesc(tblDesc));
		this.add(getOrtplnitm_srv_codeADesc(tblDesc));
		this.add(getOrtplnitm_srv_nameADesc(tblDesc));
		this.add(getFg_ctmADesc(tblDesc));
		this.add(getIsmulexecADesc(tblDesc));
		this.add(getIsmuldoseADesc(tblDesc));
		this.add(getSd_totalopenmodeADesc(tblDesc));
		this.add(getOrtplnitm_srvtp_nameADesc(tblDesc));
		this.add(getOrtplnitm_route_codeADesc(tblDesc));
		this.add(getOrtplnitm_route_nameADesc(tblDesc));
		this.add(getOrtplnitm_routedes_nameADesc(tblDesc));
		this.add(getOrtplnitm_routedes_codeADesc(tblDesc));
		this.add(getOrtplnitm_boil_codeADesc(tblDesc));
		this.add(getOrtplnitm_boil_nameADesc(tblDesc));
		this.add(getOrtplnitm_boildes_codeADesc(tblDesc));
		this.add(getOrtplnitm_boildes_nameADesc(tblDesc));
		this.add(getOrtplnitm_freq_codeADesc(tblDesc));
		this.add(getOrtplnitm_freq_nameADesc(tblDesc));
		this.add(getOrtplnitm_unit_codeADesc(tblDesc));
		this.add(getOrtplnitm_unit_nameADesc(tblDesc));
		this.add(getOrtplnitm_mm_codeADesc(tblDesc));
		this.add(getOrtplnitm_mm_nameADesc(tblDesc));
		this.add(getOrtplnitm_mm_specADesc(tblDesc));
		this.add(getId_herbpreparationtpADesc(tblDesc));
		this.add(getSd_herbpreparationtpADesc(tblDesc));
		this.add(getOrtplnitm_mp_codeADesc(tblDesc));
		this.add(getOrtplnitm_mp_nameADesc(tblDesc));
		this.add(getName_total_meduADesc(tblDesc));
		this.add(getName_hpADesc(tblDesc));
		this.add(getOrtplnitm_samptp_nameADesc(tblDesc));
		this.add(getName_dept_whADesc(tblDesc));
		this.add(getCode_dept_whADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_ortmplitmCDesc(tblDesc));
		tblDesc.add(getId_ortmplitmCDesc(tblDesc));
		tblDesc.add(getSortnoCDesc(tblDesc));
		tblDesc.add(getEu_ortplitmtpCDesc(tblDesc));
		tblDesc.add(getId_ortmplCDesc(tblDesc));
		tblDesc.add(getId_srvCDesc(tblDesc));
		tblDesc.add(getId_srvtpCDesc(tblDesc));
		tblDesc.add(getSd_srvtpCDesc(tblDesc));
		tblDesc.add(getId_routeCDesc(tblDesc));
		tblDesc.add(getId_routedesCDesc(tblDesc));
		tblDesc.add(getId_boilCDesc(tblDesc));
		tblDesc.add(getId_boildesCDesc(tblDesc));
		tblDesc.add(getId_freqCDesc(tblDesc));
		tblDesc.add(getId_unit_medCDesc(tblDesc));
		tblDesc.add(getQuan_medCDesc(tblDesc));
		tblDesc.add(getId_mmCDesc(tblDesc));
		tblDesc.add(getFg_syncCDesc(tblDesc));
		tblDesc.add(getId_dep_mpCDesc(tblDesc));
		tblDesc.add(getDes_orCDesc(tblDesc));
		tblDesc.add(getDays_orCDesc(tblDesc));
		tblDesc.add(getQuan_total_meduCDesc(tblDesc));
		tblDesc.add(getId_total_meduCDesc(tblDesc));
		tblDesc.add(getTimesCDesc(tblDesc));
		tblDesc.add(getId_samptpCDesc(tblDesc));
		tblDesc.add(getSd_samptpCDesc(tblDesc));
		tblDesc.add(getFg_nothingwithordersCDesc(tblDesc));
		tblDesc.add(getId_dept_whCDesc(tblDesc));
		tblDesc.add(getName_srvCDesc(tblDesc));
		tblDesc.add(getFg_wholepackCDesc(tblDesc));
		tblDesc.add(getFg_pres_outpCDesc(tblDesc));
		tblDesc.add(getId_drugdeliverymethodCDesc(tblDesc));
		tblDesc.add(getSd_drugdeliverymethodCDesc(tblDesc));
		tblDesc.add(getName_drugdeliverymethodCDesc(tblDesc));
		tblDesc.add(getQuan_medu_curCDesc(tblDesc));
		tblDesc.add(getId_medu_curCDesc(tblDesc));
		tblDesc.add(getFactor_curCDesc(tblDesc));
		tblDesc.add(getId_excessive_reasonCDesc(tblDesc));
		tblDesc.add(getSd_excessive_reasonCDesc(tblDesc));
		tblDesc.add(getName_excessive_reasonCDesc(tblDesc));
		tblDesc.add(getFg_skintestCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 医嘱模板项目主键标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ortmplitmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ortmplitm",  getId_ortmplitmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医嘱模板项目主键标识");
		attrDesc.setNullable(false);
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
	 * 医嘱模板项目类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_ortplitmtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_ortplitmtp",  getEu_ortplitmtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("医嘱模板项目类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医嘱模板属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ortmplADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ortmpl",  getId_ortmplCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医嘱模板");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 服务属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_srvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_srv",  getId_srvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
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
	 * 用法属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_routeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_route",  getId_routeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用法");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 要求属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_routedesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_routedes",  getId_routedesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("要求");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 煎法属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_boilADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_boil",  getId_boilCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("煎法");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 中医要求属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_boildesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_boildes",  getId_boildesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("中医要求");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 频次属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_freqADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_freq",  getId_freqCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("频次");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 医学单位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_unit_medADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_unit_med",  getId_unit_medCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医学单位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 医学单位数值属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuan_medADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Quan_med",  getQuan_medCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("医学单位数值");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 关联物品属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mm",  getId_mmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("关联物品");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 跟随标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_syncADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_sync",  getFg_syncCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("跟随标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
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
	 * 嘱托属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDes_orADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Des_or",  getDes_orCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("嘱托");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 使用天数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDays_orADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Days_or",  getDays_orCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("使用天数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 总量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuan_total_meduADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Quan_total_medu",  getQuan_total_meduCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("总量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 总量单位id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_total_meduADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_total_medu",  getId_total_meduCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("总量单位id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 默认次数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTimesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Times",  getTimesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("默认次数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 标本类型ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_samptpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_samptp",  getId_samptpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("标本类型ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 标本类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_samptpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_samptp",  getSd_samptpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("标本类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 付数无关标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_nothingwithordersADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_nothingwithorders",  getFg_nothingwithordersCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("付数无关标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 发药科室属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dept_whADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dept_wh",  getId_dept_whCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("发药科室");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 服务名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_srvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_srv",  getName_srvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 在院整领标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_wholepackADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_wholepack",  getFg_wholepackCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("在院整领标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 出院带药标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_pres_outpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_pres_outp",  getFg_pres_outpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("出院带药标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 领药方式ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_drugdeliverymethodADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_drugdeliverymethod",  getId_drugdeliverymethodCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("领药方式ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 领药方式编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_drugdeliverymethodADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_drugdeliverymethod",  getSd_drugdeliverymethodCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("领药方式编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 领药方式名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_drugdeliverymethodADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_drugdeliverymethod",  getName_drugdeliverymethodCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("领药方式名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 当前剂量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuan_medu_curADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Quan_medu_cur",  getQuan_medu_curCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("当前剂量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 当前剂量单位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_medu_curADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_medu_cur",  getId_medu_curCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("当前剂量单位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 当前换算系数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFactor_curADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Factor_cur",  getFactor_curCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("当前换算系数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 超量开单原因id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_excessive_reasonADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_excessive_reason",  getId_excessive_reasonCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("超量开单原因id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 超量开单原因sd属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_excessive_reasonADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_excessive_reason",  getSd_excessive_reasonCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("超量开单原因sd");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 超量开单原因名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_excessive_reasonADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_excessive_reason",  getName_excessive_reasonCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("超量开单原因名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 皮试标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_skintestADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_skintest",  getFg_skintestCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("皮试标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 服务编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOrtplnitm_srv_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ortplnitm_srv_code",  getOrtplnitm_srv_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_srv a1b3","id_srv=id_srv","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 服务名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOrtplnitm_srv_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ortplnitm_srv_name",  getOrtplnitm_srv_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_srv a1b3","id_srv=id_srv","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 自定义服务名称标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_ctmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_ctm",  getFg_ctmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("自定义服务名称标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_srv a1b3","id_srv=id_srv","fg_ctm"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否多次执行属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIsmulexecADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ismulexec",  getIsmulexecCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否多次执行");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_srv a1b3","id_srv=id_srv","ismulexec"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否多量开单属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIsmuldoseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ismuldose",  getIsmuldoseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否多量开单");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_srv a1b3","id_srv=id_srv","ismuldose"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 总量开单方式编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_totalopenmodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_totalopenmode",  getSd_totalopenmodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("总量开单方式编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_srv a1b3","id_srv=id_srv","sd_totalopenmode"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOrtplnitm_srvtp_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ortplnitm_srvtp_name",  getOrtplnitm_srvtp_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b4","id_srvtp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 用法编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOrtplnitm_route_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ortplnitm_route_code",  getOrtplnitm_route_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用法编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_route a1b5","id_route=id_route","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 用法名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOrtplnitm_route_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ortplnitm_route_name",  getOrtplnitm_route_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用法名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_route a1b5","id_route=id_route","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医疗要求属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOrtplnitm_routedes_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ortplnitm_routedes_name",  getOrtplnitm_routedes_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医疗要求");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_route_des a1b6","id_routedes=id_routedes","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医疗要求编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOrtplnitm_routedes_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ortplnitm_routedes_code",  getOrtplnitm_routedes_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医疗要求编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_route_des a1b6","id_routedes=id_routedes","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 煎法编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOrtplnitm_boil_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ortplnitm_boil_code",  getOrtplnitm_boil_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("煎法编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_boil a1b7","id_boil=id_boil","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 煎法名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOrtplnitm_boil_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ortplnitm_boil_name",  getOrtplnitm_boil_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("煎法名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_boil a1b7","id_boil=id_boil","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 煎法要求编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOrtplnitm_boildes_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ortplnitm_boildes_code",  getOrtplnitm_boildes_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("煎法要求编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_boil_des a1b8","id_boildes=id_boildes","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 煎法要求属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOrtplnitm_boildes_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ortplnitm_boildes_name",  getOrtplnitm_boildes_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("煎法要求");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_boil_des a1b8","id_boildes=id_boildes","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 频次编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOrtplnitm_freq_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ortplnitm_freq_code",  getOrtplnitm_freq_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("频次编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_freq a1b9","id_freq=id_freq","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 频次名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOrtplnitm_freq_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ortplnitm_freq_name",  getOrtplnitm_freq_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("频次名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_freq a1b9","id_freq=id_freq","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 计量单位编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOrtplnitm_unit_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ortplnitm_unit_code",  getOrtplnitm_unit_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("计量单位编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_measdoc a1b10","id_unit_med=id_measdoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 计量单位名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOrtplnitm_unit_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ortplnitm_unit_name",  getOrtplnitm_unit_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("计量单位名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_measdoc a1b10","id_unit_med=id_measdoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 物品编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOrtplnitm_mm_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ortplnitm_mm_code",  getOrtplnitm_mm_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("物品编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"BD_MM a1b11","id_mm=id_mm","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 物品名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOrtplnitm_mm_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ortplnitm_mm_name",  getOrtplnitm_mm_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("物品名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"BD_MM a1b11","id_mm=id_mm","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 物品规格属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOrtplnitm_mm_specADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ortplnitm_mm_spec",  getOrtplnitm_mm_specCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("物品规格");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"BD_MM a1b11","id_mm=id_mm","spec"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 草药制剂类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_herbpreparationtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_herbpreparationtp",  getId_herbpreparationtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("草药制剂类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"BD_MM a1b11","id_mm=id_mm","id_herbpreparationtp"});
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 草药制剂类型编码(0饮片；1配方颗粒)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_herbpreparationtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_herbpreparationtp",  getSd_herbpreparationtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("草药制剂类型编码(0饮片；1配方颗粒)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"BD_MM a1b11","id_mm=id_mm","sd_herbpreparationtp"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOrtplnitm_mp_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ortplnitm_mp_code",  getOrtplnitm_mp_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a1b12","id_dep_mp=id_dep","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOrtplnitm_mp_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ortplnitm_mp_name",  getOrtplnitm_mp_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a1b12","id_dep_mp=id_dep","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 总量单位名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_total_meduADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_total_medu",  getName_total_meduCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("总量单位名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_measdoc a1b16","id_total_medu=id_measdoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医保计划名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_hpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_hp",  getName_hpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医保计划名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_hp a1b13","id_hp=id_hp","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOrtplnitm_samptp_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ortplnitm_samptp_name",  getOrtplnitm_samptp_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b14","id_samptp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dept_whADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dept_wh",  getName_dept_whCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a1b15","id_dept_wh=id_dep","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_dept_whADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_dept_wh",  getCode_dept_whCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a1b15","id_dept_wh=id_dep","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取医嘱模板项目主键标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ortmplitmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ortmplitm");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("医嘱模板项目主键标识"); 
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
	 * 获取医嘱模板项目类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_ortplitmtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_ortplitmtp");
		column.setLength(2);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("医嘱模板项目类型"); 
		return column;
	}
	/**
	 * 获取医嘱模板表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ortmplCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ortmpl");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医嘱模板"); 
		return column;
	}
	/**
	 * 获取服务表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_srvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_srv");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务"); 
		return column;
	}
	/**
	 * 获取服务类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_srvtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_srvtp");
		column.setLength(20);
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
	 * 获取用法表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_routeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_route");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("用法"); 
		return column;
	}
	/**
	 * 获取要求表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_routedesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_routedes");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("要求"); 
		return column;
	}
	/**
	 * 获取煎法表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_boilCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_boil");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("煎法"); 
		return column;
	}
	/**
	 * 获取中医要求表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_boildesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_boildes");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("中医要求"); 
		return column;
	}
	/**
	 * 获取频次表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_freqCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_freq");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("频次"); 
		return column;
	}
	/**
	 * 获取医学单位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_unit_medCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_unit_med");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医学单位"); 
		return column;
	}
	/**
	 * 获取医学单位数值表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuan_medCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Quan_med");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("医学单位数值"); 
		return column;
	}
	/**
	 * 获取关联物品表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mm");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("关联物品"); 
		return column;
	}
	/**
	 * 获取跟随标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_syncCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_sync");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("跟随标识"); 
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
	 * 获取嘱托表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDes_orCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Des_or");
		column.setLength(256);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("嘱托"); 
		return column;
	}
	/**
	 * 获取使用天数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDays_orCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Days_or");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("使用天数"); 
		return column;
	}
	/**
	 * 获取总量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuan_total_meduCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Quan_total_medu");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("总量"); 
		return column;
	}
	/**
	 * 获取总量单位id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_total_meduCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_total_medu");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("总量单位id"); 
		return column;
	}
	/**
	 * 获取默认次数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTimesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Times");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("默认次数"); 
		return column;
	}
	/**
	 * 获取标本类型ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_samptpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_samptp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("标本类型ID"); 
		return column;
	}
	/**
	 * 获取标本类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_samptpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_samptp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("标本类型编码"); 
		return column;
	}
	/**
	 * 获取付数无关标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_nothingwithordersCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_nothingwithorders");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("付数无关标志"); 
		return column;
	}
	/**
	 * 获取发药科室表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dept_whCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dept_wh");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("发药科室"); 
		return column;
	}
	/**
	 * 获取服务名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_srvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_srv");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务名称"); 
		return column;
	}
	/**
	 * 获取在院整领标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_wholepackCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_wholepack");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("在院整领标识"); 
		return column;
	}
	/**
	 * 获取出院带药标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_pres_outpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_pres_outp");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("出院带药标识"); 
		return column;
	}
	/**
	 * 获取领药方式ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_drugdeliverymethodCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_drugdeliverymethod");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("领药方式ID"); 
		return column;
	}
	/**
	 * 获取领药方式编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_drugdeliverymethodCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_drugdeliverymethod");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("领药方式编码"); 
		return column;
	}
	/**
	 * 获取领药方式名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_drugdeliverymethodCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_drugdeliverymethod");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("领药方式名称"); 
		return column;
	}
	/**
	 * 获取当前剂量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuan_medu_curCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Quan_medu_cur");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("当前剂量"); 
		return column;
	}
	/**
	 * 获取当前剂量单位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_medu_curCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_medu_cur");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("当前剂量单位"); 
		return column;
	}
	/**
	 * 获取当前换算系数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFactor_curCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Factor_cur");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("当前换算系数"); 
		return column;
	}
	/**
	 * 获取超量开单原因id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_excessive_reasonCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_excessive_reason");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("超量开单原因id"); 
		return column;
	}
	/**
	 * 获取超量开单原因sd表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_excessive_reasonCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_excessive_reason");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("超量开单原因sd"); 
		return column;
	}
	/**
	 * 获取超量开单原因名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_excessive_reasonCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_excessive_reason");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("超量开单原因名称"); 
		return column;
	}
	/**
	 * 获取皮试标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_skintestCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_skintest");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("皮试标志"); 
		return column;
	}
	/**
	 * 获取服务编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOrtplnitm_srv_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ortplnitm_srv_code");
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
	private IColumnDesc getOrtplnitm_srv_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ortplnitm_srv_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务名称"); 
		return column;
	}
	/**
	 * 获取自定义服务名称标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_ctmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_ctm");
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("自定义服务名称标志"); 
		return column;
	}
	/**
	 * 获取是否多次执行表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIsmulexecCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ismulexec");
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否多次执行"); 
		return column;
	}
	/**
	 * 获取是否多量开单表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIsmuldoseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ismuldose");
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否多量开单"); 
		return column;
	}
	/**
	 * 获取总量开单方式编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_totalopenmodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_totalopenmode");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("总量开单方式编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOrtplnitm_srvtp_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ortplnitm_srvtp_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取用法编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOrtplnitm_route_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ortplnitm_route_code");
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
	private IColumnDesc getOrtplnitm_route_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ortplnitm_route_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("用法名称"); 
		return column;
	}
	/**
	 * 获取医疗要求表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOrtplnitm_routedes_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ortplnitm_routedes_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医疗要求"); 
		return column;
	}
	/**
	 * 获取医疗要求编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOrtplnitm_routedes_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ortplnitm_routedes_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医疗要求编码"); 
		return column;
	}
	/**
	 * 获取煎法编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOrtplnitm_boil_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ortplnitm_boil_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("煎法编码"); 
		return column;
	}
	/**
	 * 获取煎法名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOrtplnitm_boil_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ortplnitm_boil_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("煎法名称"); 
		return column;
	}
	/**
	 * 获取煎法要求编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOrtplnitm_boildes_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ortplnitm_boildes_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("煎法要求编码"); 
		return column;
	}
	/**
	 * 获取煎法要求表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOrtplnitm_boildes_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ortplnitm_boildes_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("煎法要求"); 
		return column;
	}
	/**
	 * 获取频次编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOrtplnitm_freq_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ortplnitm_freq_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("频次编码"); 
		return column;
	}
	/**
	 * 获取频次名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOrtplnitm_freq_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ortplnitm_freq_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("频次名称"); 
		return column;
	}
	/**
	 * 获取计量单位编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOrtplnitm_unit_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ortplnitm_unit_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("计量单位编码"); 
		return column;
	}
	/**
	 * 获取计量单位名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOrtplnitm_unit_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ortplnitm_unit_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("计量单位名称"); 
		return column;
	}
	/**
	 * 获取物品编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOrtplnitm_mm_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ortplnitm_mm_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("物品编码"); 
		return column;
	}
	/**
	 * 获取物品名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOrtplnitm_mm_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ortplnitm_mm_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("物品名称"); 
		return column;
	}
	/**
	 * 获取物品规格表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOrtplnitm_mm_specCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ortplnitm_mm_spec");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("物品规格"); 
		return column;
	}
	/**
	 * 获取草药制剂类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_herbpreparationtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_herbpreparationtp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("草药制剂类型"); 
		return column;
	}
	/**
	 * 获取草药制剂类型编码(0饮片；1配方颗粒)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_herbpreparationtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_herbpreparationtp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("草药制剂类型编码(0饮片；1配方颗粒)"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOrtplnitm_mp_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ortplnitm_mp_code");
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
	private IColumnDesc getOrtplnitm_mp_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ortplnitm_mp_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取总量单位名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_total_meduCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_total_medu");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("总量单位名称"); 
		return column;
	}
	/**
	 * 获取医保计划名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_hpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_hp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医保计划名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOrtplnitm_samptp_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ortplnitm_samptp_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_dept_whCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dept_wh");
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
	private IColumnDesc getCode_dept_whCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_dept_wh");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
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
		defaultValueMap.put("Fg_nothingwithorders",new xap.mw.coreitf.d.FBoolean("N"));
	}
	
}
