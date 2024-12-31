
package iih.sc.scp.scplweek.d.desc;

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
 * 计划排班_计划_周 DO 元数据信息
 */
public class ScPlanWeekDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.sc.scp.scplweek.d.ScPlanWeekDO";
	public static final String CLASS_DISPALYNAME = "计划排班_计划_周";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "sc_pl_week";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_scplweek";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public ScPlanWeekDODesc(){
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
		this.setKeyDesc(getId_scplweekADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_scplweekADesc(tblDesc));
		this.add(getId_scplADesc(tblDesc));
		this.add(getWeeknoADesc(tblDesc));
		this.add(getIdx_weekADesc(tblDesc));
		this.add(getId_dayslotADesc(tblDesc));
		this.add(getT_b_acptADesc(tblDesc));
		this.add(getT_e_acptADesc(tblDesc));
		this.add(getFg_std_acptADesc(tblDesc));
		this.add(getSrvslotADesc(tblDesc));
		this.add(getSugest_exmintADesc(tblDesc));
		this.add(getScpolcnADesc(tblDesc));
		this.add(getSugest_num_tickADesc(tblDesc));
		this.add(getSugest_num_mintADesc(tblDesc));
		this.add(getT_e_regADesc(tblDesc));
		this.add(getQuan_totalADesc(tblDesc));
		this.add(getQuan_total_apptADesc(tblDesc));
		this.add(getQuan0_apptADesc(tblDesc));
		this.add(getQuan1_apptADesc(tblDesc));
		this.add(getQuan2_apptADesc(tblDesc));
		this.add(getQuan3_apptADesc(tblDesc));
		this.add(getQuan4_apptADesc(tblDesc));
		this.add(getQuan5_apptADesc(tblDesc));
		this.add(getQuan6_apptADesc(tblDesc));
		this.add(getQuan7_apptADesc(tblDesc));
		this.add(getQuan8_apptADesc(tblDesc));
		this.add(getQuan9_apptADesc(tblDesc));
		this.add(getEu_weektpADesc(tblDesc));
		this.add(getNameADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getMax_num_addADesc(tblDesc));
		this.add(getFg_setscchlADesc(tblDesc));
		this.add(getFg_auto_releaseADesc(tblDesc));
		this.add(getFg_setentpADesc(tblDesc));
this.add(getFg_auto_aptADesc(tblDesc));
		this.add(getCode_scplADesc(tblDesc));
		this.add(getName_scplADesc(tblDesc));
		this.add(getName_dayslotADesc(tblDesc));
		this.add(getSd_dayslottpADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_scplweekCDesc(tblDesc));
		tblDesc.add(getId_scplweekCDesc(tblDesc));
		tblDesc.add(getId_scplCDesc(tblDesc));
		tblDesc.add(getWeeknoCDesc(tblDesc));
		tblDesc.add(getIdx_weekCDesc(tblDesc));
		tblDesc.add(getId_dayslotCDesc(tblDesc));
		tblDesc.add(getT_b_acptCDesc(tblDesc));
		tblDesc.add(getT_e_acptCDesc(tblDesc));
		tblDesc.add(getFg_std_acptCDesc(tblDesc));
		tblDesc.add(getSrvslotCDesc(tblDesc));
		tblDesc.add(getSugest_exmintCDesc(tblDesc));
		tblDesc.add(getScpolcnCDesc(tblDesc));
		tblDesc.add(getSugest_num_tickCDesc(tblDesc));
		tblDesc.add(getSugest_num_mintCDesc(tblDesc));
		tblDesc.add(getT_e_regCDesc(tblDesc));
		tblDesc.add(getQuan_totalCDesc(tblDesc));
		tblDesc.add(getQuan_total_apptCDesc(tblDesc));
		tblDesc.add(getQuan0_apptCDesc(tblDesc));
		tblDesc.add(getQuan1_apptCDesc(tblDesc));
		tblDesc.add(getQuan2_apptCDesc(tblDesc));
		tblDesc.add(getQuan3_apptCDesc(tblDesc));
		tblDesc.add(getQuan4_apptCDesc(tblDesc));
		tblDesc.add(getQuan5_apptCDesc(tblDesc));
		tblDesc.add(getQuan6_apptCDesc(tblDesc));
		tblDesc.add(getQuan7_apptCDesc(tblDesc));
		tblDesc.add(getQuan8_apptCDesc(tblDesc));
		tblDesc.add(getQuan9_apptCDesc(tblDesc));
		tblDesc.add(getEu_weektpCDesc(tblDesc));
		tblDesc.add(getNameCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		tblDesc.add(getMax_num_addCDesc(tblDesc));
		tblDesc.add(getFg_setscchlCDesc(tblDesc));
		tblDesc.add(getFg_auto_releaseCDesc(tblDesc));
		tblDesc.add(getFg_setentpCDesc(tblDesc));
		tblDesc.add(getFg_auto_aptCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 计划周ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_scplweekADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_scplweek",  getId_scplweekCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("计划周ID");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 计划属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_scplADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_scpl",  getId_scplCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("计划");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 星期数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWeeknoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Weekno",  getWeeknoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("星期数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 周序号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIdx_weekADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Idx_week",  getIdx_weekCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("周序号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 日期分组属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dayslotADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dayslot",  getId_dayslotCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("日期分组");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 开始就诊时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getT_b_acptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("T_b_acpt",  getT_b_acptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FTime);
		attrDesc.setLabel("开始就诊时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 结束就诊时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getT_e_acptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("T_e_acpt",  getT_e_acptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FTime);
		attrDesc.setLabel("结束就诊时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否标准就诊时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_std_acptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_std_acpt",  getFg_std_acptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否标准就诊时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 单服务时长(分钟)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSrvslotADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Srvslot",  getSrvslotCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("单服务时长(分钟)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 推荐提前报到时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSugest_exmintADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sugest_exmint",  getSugest_exmintCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("推荐提前报到时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 号源池数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getScpolcnADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Scpolcn",  getScpolcnCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("号源池数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 号数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSugest_num_tickADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sugest_num_tick",  getSugest_num_tickCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("号数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 分钟数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSugest_num_mintADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sugest_num_mint",  getSugest_num_mintCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("分钟数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 停诊挂号时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getT_e_regADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("T_e_reg",  getT_e_regCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FTime);
		attrDesc.setLabel("停诊挂号时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 数量_总数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuan_totalADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Quan_total",  getQuan_totalCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("数量_总数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 数量_总数_可预约属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuan_total_apptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Quan_total_appt",  getQuan_total_apptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("数量_总数_可预约");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 数量_号源池0_可预约属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuan0_apptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Quan0_appt",  getQuan0_apptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("数量_号源池0_可预约");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 数量_号源池1_可预约属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuan1_apptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Quan1_appt",  getQuan1_apptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("数量_号源池1_可预约");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 数量_号源池2_可预约属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuan2_apptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Quan2_appt",  getQuan2_apptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("数量_号源池2_可预约");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 数量_号源池3_可预约属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuan3_apptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Quan3_appt",  getQuan3_apptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("数量_号源池3_可预约");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 数量_号源池4_可预约属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuan4_apptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Quan4_appt",  getQuan4_apptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("数量_号源池4_可预约");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 数量_号源池5_可预约属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuan5_apptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Quan5_appt",  getQuan5_apptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("数量_号源池5_可预约");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 数量_号源池6_可预约属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuan6_apptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Quan6_appt",  getQuan6_apptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("数量_号源池6_可预约");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 数量_号源池7_可预约属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuan7_apptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Quan7_appt",  getQuan7_apptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("数量_号源池7_可预约");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 数量_号源池8_可预约属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuan8_apptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Quan8_appt",  getQuan8_apptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("数量_号源池8_可预约");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 数量_号源池9_可预约属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuan9_apptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Quan9_appt",  getQuan9_apptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("数量_号源池9_可预约");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 周计划类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_weektpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_weektp",  getEu_weektpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("周计划类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 周计划名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name",  getNameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("周计划名称");
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
	 * 最大加号数量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMax_num_addADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Max_num_add",  getMax_num_addCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("最大加号数量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否设置了渠道属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_setscchlADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_setscchl",  getFg_setscchlCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否设置了渠道");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 自动释放号源属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_auto_releaseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_auto_release",  getFg_auto_releaseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("自动释放号源");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否设置就诊类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_setentpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_setentp",  getFg_setentpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否设置就诊类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
/**
	 * 是否允许进行自动预约属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_auto_aptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_auto_apt",  getFg_auto_aptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否允许进行自动预约");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 计划编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_scplADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_scpl",  getCode_scplCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("计划编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sc_pl a0b1","id_scpl=id_scpl","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 计划名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_scplADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_scpl",  getName_scplCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("计划名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sc_pl a0b1","id_scpl=id_scpl","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 日期分组名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dayslotADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dayslot",  getName_dayslotCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("日期分组名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dayslot a0b2","id_dayslot=id_dayslot","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 日期分组类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_dayslottpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_dayslottp",  getSd_dayslottpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("日期分组类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dayslot a0b2","id_dayslot=id_dayslot","sd_dayslottp"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取计划周ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_scplweekCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_scplweek");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("计划周ID"); 
		return column;
	}
	/**
	 * 获取计划表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_scplCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_scpl");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("计划"); 
		return column;
	}
	/**
	 * 获取星期数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWeeknoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Weekno");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("星期数"); 
		return column;
	}
	/**
	 * 获取周序号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIdx_weekCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Idx_week");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("周序号"); 
		return column;
	}
	/**
	 * 获取日期分组表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dayslotCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dayslot");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("日期分组"); 
		return column;
	}
	/**
	 * 获取开始就诊时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getT_b_acptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"T_b_acpt");
		column.setLength(8);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("开始就诊时间"); 
		return column;
	}
	/**
	 * 获取结束就诊时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getT_e_acptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"T_e_acpt");
		column.setLength(8);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("结束就诊时间"); 
		return column;
	}
	/**
	 * 获取是否标准就诊时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_std_acptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_std_acpt");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否标准就诊时间"); 
		return column;
	}
	/**
	 * 获取单服务时长(分钟)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSrvslotCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Srvslot");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("单服务时长(分钟)"); 
		return column;
	}
	/**
	 * 获取推荐提前报到时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSugest_exmintCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sugest_exmint");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("推荐提前报到时间"); 
		return column;
	}
	/**
	 * 获取号源池数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getScpolcnCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Scpolcn");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("号源池数"); 
		return column;
	}
	/**
	 * 获取号数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSugest_num_tickCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sugest_num_tick");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("号数"); 
		return column;
	}
	/**
	 * 获取分钟数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSugest_num_mintCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sugest_num_mint");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("分钟数"); 
		return column;
	}
	/**
	 * 获取停诊挂号时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getT_e_regCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"T_e_reg");
		column.setLength(8);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("停诊挂号时间"); 
		return column;
	}
	/**
	 * 获取数量_总数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuan_totalCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Quan_total");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("数量_总数"); 
		return column;
	}
	/**
	 * 获取数量_总数_可预约表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuan_total_apptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Quan_total_appt");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("数量_总数_可预约"); 
		return column;
	}
	/**
	 * 获取数量_号源池0_可预约表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuan0_apptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Quan0_appt");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("数量_号源池0_可预约"); 
		return column;
	}
	/**
	 * 获取数量_号源池1_可预约表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuan1_apptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Quan1_appt");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("数量_号源池1_可预约"); 
		return column;
	}
	/**
	 * 获取数量_号源池2_可预约表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuan2_apptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Quan2_appt");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("数量_号源池2_可预约"); 
		return column;
	}
	/**
	 * 获取数量_号源池3_可预约表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuan3_apptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Quan3_appt");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("数量_号源池3_可预约"); 
		return column;
	}
	/**
	 * 获取数量_号源池4_可预约表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuan4_apptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Quan4_appt");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("数量_号源池4_可预约"); 
		return column;
	}
	/**
	 * 获取数量_号源池5_可预约表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuan5_apptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Quan5_appt");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("数量_号源池5_可预约"); 
		return column;
	}
	/**
	 * 获取数量_号源池6_可预约表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuan6_apptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Quan6_appt");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("数量_号源池6_可预约"); 
		return column;
	}
	/**
	 * 获取数量_号源池7_可预约表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuan7_apptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Quan7_appt");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("数量_号源池7_可预约"); 
		return column;
	}
	/**
	 * 获取数量_号源池8_可预约表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuan8_apptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Quan8_appt");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("数量_号源池8_可预约"); 
		return column;
	}
	/**
	 * 获取数量_号源池9_可预约表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuan9_apptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Quan9_appt");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("数量_号源池9_可预约"); 
		return column;
	}
	/**
	 * 获取周计划类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_weektpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_weektp");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("周计划类型"); 
		return column;
	}
	/**
	 * 获取周计划名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("周计划名称"); 
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
	 * 获取最大加号数量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMax_num_addCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Max_num_add");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("最大加号数量"); 
		return column;
	}
	/**
	 * 获取是否设置了渠道表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_setscchlCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_setscchl");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否设置了渠道"); 
		return column;
	}
	/**
	 * 获取自动释放号源表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_auto_releaseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_auto_release");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("自动释放号源"); 
		return column;
	}
	/**
	 * 获取是否设置就诊类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_setentpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_setentp");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否设置就诊类型"); 
		return column;
	}
/**
	 * 获取是否允许进行自动预约表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_auto_aptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_auto_apt");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否允许进行自动预约"); 
		return column;
	}
	/**
	 * 获取计划编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_scplCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_scpl");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("计划编码"); 
		return column;
	}
	/**
	 * 获取计划名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_scplCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_scpl");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("计划名称"); 
		return column;
	}
	/**
	 * 获取日期分组名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_dayslotCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dayslot");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("日期分组名称"); 
		return column;
	}
	/**
	 * 获取日期分组类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_dayslottpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_dayslottp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("日期分组类型编码"); 
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
