
package iih.sc.sch.scsch.d.desc;

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
 * 计划排班_排班 DO 元数据信息
 */
public class ScSchDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.sc.sch.scsch.d.ScSchDO";
	public static final String CLASS_DISPALYNAME = "计划排班_排班";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "sc_sch";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_sch";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public ScSchDODesc(){
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
		this.setKeyDesc(getId_schADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_schADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_scplADesc(tblDesc));
		this.add(getId_sctpADesc(tblDesc));
		this.add(getSd_sctpADesc(tblDesc));
		this.add(getId_sccaADesc(tblDesc));
		this.add(getD_schADesc(tblDesc));
		this.add(getId_dayslotADesc(tblDesc));
		this.add(getScpolcnADesc(tblDesc));
		this.add(getId_tickmdADesc(tblDesc));
		this.add(getSd_tickmdADesc(tblDesc));
		this.add(getId_apptruADesc(tblDesc));
		this.add(getQuan_totalADesc(tblDesc));
		this.add(getQuan_total_apptADesc(tblDesc));
		this.add(getQuan_total_usedADesc(tblDesc));
		this.add(getQuan0_apptADesc(tblDesc));
		this.add(getQuan0_usedADesc(tblDesc));
		this.add(getQuan1_apptADesc(tblDesc));
		this.add(getQuan1_usedADesc(tblDesc));
		this.add(getQuan2_apptADesc(tblDesc));
		this.add(getQuan2_usedADesc(tblDesc));
		this.add(getQuan3_apptADesc(tblDesc));
		this.add(getQuan3_usedADesc(tblDesc));
		this.add(getQuan4_apptADesc(tblDesc));
		this.add(getQuan4_usedADesc(tblDesc));
		this.add(getQuan5_apptADesc(tblDesc));
		this.add(getQuan5_usedADesc(tblDesc));
		this.add(getQuan6_apptADesc(tblDesc));
		this.add(getQuan6_usedADesc(tblDesc));
		this.add(getQuan7_apptADesc(tblDesc));
		this.add(getQuan7_usedADesc(tblDesc));
		this.add(getQuan8_apptADesc(tblDesc));
		this.add(getQuan8_usedADesc(tblDesc));
		this.add(getQuan9_apptADesc(tblDesc));
		this.add(getQuan9_usedADesc(tblDesc));
		this.add(getAddquecnADesc(tblDesc));
		this.add(getT_b_acptADesc(tblDesc));
		this.add(getT_e_acptADesc(tblDesc));
		this.add(getFg_std_acptADesc(tblDesc));
		this.add(getSrvslotADesc(tblDesc));
		this.add(getSugest_exmintADesc(tblDesc));
		this.add(getSugest_num_tickADesc(tblDesc));
		this.add(getSugest_num_mintADesc(tblDesc));
		this.add(getT_e_regADesc(tblDesc));
		this.add(getFg_activeADesc(tblDesc));
		this.add(getDef1ADesc(tblDesc));
		this.add(getDef2ADesc(tblDesc));
		this.add(getDef3ADesc(tblDesc));
		this.add(getDef4ADesc(tblDesc));
		this.add(getDef5ADesc(tblDesc));
		this.add(getDef6ADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getId_quesiteADesc(tblDesc));
		this.add(getId_emp_nurseADesc(tblDesc));
		this.add(getId_depparamADesc(tblDesc));
		this.add(getMax_num_addADesc(tblDesc));
		this.add(getId_scsch_canctoADesc(tblDesc));
		this.add(getFg_auto_releaseADesc(tblDesc));
		this.add(getFg_setentpADesc(tblDesc));
		this.add(getFg_auto_aptADesc(tblDesc));
		this.add(getFg_transedADesc(tblDesc));
		this.add(getName_dayslotADesc(tblDesc));
		this.add(getSd_schruleADesc(tblDesc));
		this.add(getVerADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_schCDesc(tblDesc));
		tblDesc.add(getId_schCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_scplCDesc(tblDesc));
		tblDesc.add(getId_sctpCDesc(tblDesc));
		tblDesc.add(getSd_sctpCDesc(tblDesc));
		tblDesc.add(getId_sccaCDesc(tblDesc));
		tblDesc.add(getD_schCDesc(tblDesc));
		tblDesc.add(getId_dayslotCDesc(tblDesc));
		tblDesc.add(getScpolcnCDesc(tblDesc));
		tblDesc.add(getId_tickmdCDesc(tblDesc));
		tblDesc.add(getSd_tickmdCDesc(tblDesc));
		tblDesc.add(getId_apptruCDesc(tblDesc));
		tblDesc.add(getQuan_totalCDesc(tblDesc));
		tblDesc.add(getQuan_total_apptCDesc(tblDesc));
		tblDesc.add(getQuan_total_usedCDesc(tblDesc));
		tblDesc.add(getQuan0_apptCDesc(tblDesc));
		tblDesc.add(getQuan0_usedCDesc(tblDesc));
		tblDesc.add(getQuan1_apptCDesc(tblDesc));
		tblDesc.add(getQuan1_usedCDesc(tblDesc));
		tblDesc.add(getQuan2_apptCDesc(tblDesc));
		tblDesc.add(getQuan2_usedCDesc(tblDesc));
		tblDesc.add(getQuan3_apptCDesc(tblDesc));
		tblDesc.add(getQuan3_usedCDesc(tblDesc));
		tblDesc.add(getQuan4_apptCDesc(tblDesc));
		tblDesc.add(getQuan4_usedCDesc(tblDesc));
		tblDesc.add(getQuan5_apptCDesc(tblDesc));
		tblDesc.add(getQuan5_usedCDesc(tblDesc));
		tblDesc.add(getQuan6_apptCDesc(tblDesc));
		tblDesc.add(getQuan6_usedCDesc(tblDesc));
		tblDesc.add(getQuan7_apptCDesc(tblDesc));
		tblDesc.add(getQuan7_usedCDesc(tblDesc));
		tblDesc.add(getQuan8_apptCDesc(tblDesc));
		tblDesc.add(getQuan8_usedCDesc(tblDesc));
		tblDesc.add(getQuan9_apptCDesc(tblDesc));
		tblDesc.add(getQuan9_usedCDesc(tblDesc));
		tblDesc.add(getAddquecnCDesc(tblDesc));
		tblDesc.add(getT_b_acptCDesc(tblDesc));
		tblDesc.add(getT_e_acptCDesc(tblDesc));
		tblDesc.add(getFg_std_acptCDesc(tblDesc));
		tblDesc.add(getSrvslotCDesc(tblDesc));
		tblDesc.add(getSugest_exmintCDesc(tblDesc));
		tblDesc.add(getSugest_num_tickCDesc(tblDesc));
		tblDesc.add(getSugest_num_mintCDesc(tblDesc));
		tblDesc.add(getT_e_regCDesc(tblDesc));
		tblDesc.add(getFg_activeCDesc(tblDesc));
		tblDesc.add(getDef1CDesc(tblDesc));
		tblDesc.add(getDef2CDesc(tblDesc));
		tblDesc.add(getDef3CDesc(tblDesc));
		tblDesc.add(getDef4CDesc(tblDesc));
		tblDesc.add(getDef5CDesc(tblDesc));
		tblDesc.add(getDef6CDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		tblDesc.add(getId_quesiteCDesc(tblDesc));
		tblDesc.add(getId_emp_nurseCDesc(tblDesc));
		tblDesc.add(getId_depparamCDesc(tblDesc));
		tblDesc.add(getMax_num_addCDesc(tblDesc));
		tblDesc.add(getId_scsch_canctoCDesc(tblDesc));
		tblDesc.add(getFg_auto_releaseCDesc(tblDesc));
		tblDesc.add(getFg_setentpCDesc(tblDesc));
		tblDesc.add(getFg_auto_aptCDesc(tblDesc));
		tblDesc.add(getFg_transedCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 排班ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_schADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_sch",  getId_schCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("排班ID");
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
	 * 排班类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_sctpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_sctp",  getId_sctpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("排班类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 排班类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_sctpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_sctp",  getSd_sctpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("排班类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 排班分类属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_sccaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_scca",  getId_sccaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("排班分类");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getD_schADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("D_sch",  getD_schCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("日期");
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
	 * 号源池总数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getScpolcnADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Scpolcn",  getScpolcnCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("号源池总数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 票号模式id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_tickmdADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_tickmd",  getId_tickmdCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("票号模式id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 票号模式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_tickmdADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_tickmd",  getSd_tickmdCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("票号模式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 预约规则属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_apptruADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_apptru",  getId_apptruCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("预约规则");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
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
	 * 数量_总使用属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuan_total_usedADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Quan_total_used",  getQuan_total_usedCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("数量_总使用");
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
	 * 数量_号源池0_已用属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuan0_usedADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Quan0_used",  getQuan0_usedCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("数量_号源池0_已用");
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
	 * 数量_号源池1_已用属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuan1_usedADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Quan1_used",  getQuan1_usedCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("数量_号源池1_已用");
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
	 * 数量_号源池2_已用属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuan2_usedADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Quan2_used",  getQuan2_usedCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("数量_号源池2_已用");
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
	 * 数量_号源池3_已用属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuan3_usedADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Quan3_used",  getQuan3_usedCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("数量_号源池3_已用");
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
	 * 数量_号源池4_已用属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuan4_usedADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Quan4_used",  getQuan4_usedCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("数量_号源池4_已用");
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
	 * 数量_号源池5_已用属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuan5_usedADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Quan5_used",  getQuan5_usedCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("数量_号源池5_已用");
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
	 * 数量_号源池6_已用属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuan6_usedADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Quan6_used",  getQuan6_usedCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("数量_号源池6_已用");
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
	 * 数量_号源池7_已用属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuan7_usedADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Quan7_used",  getQuan7_usedCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("数量_号源池7_已用");
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
	 * 数量_号源池8_已用属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuan8_usedADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Quan8_used",  getQuan8_usedCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("数量_号源池8_已用");
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
	 * 数量_号源池9_已用属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuan9_usedADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Quan9_used",  getQuan9_usedCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("数量_号源池9_已用");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 已加号数量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAddquecnADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Addquecn",  getAddquecnCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("已加号数量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
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
	 * 诊椅属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_quesiteADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_quesite",  getId_quesiteCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊椅");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 排班护士属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_nurseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_nurse",  getId_emp_nurseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("排班护士");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 科室参数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_depparamADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_depparam",  getId_depparamCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("科室参数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
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
	 * 替诊排班属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_scsch_canctoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_scsch_cancto",  getId_scsch_canctoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("替诊排班");
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
	 * 是否自动预约属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_auto_aptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_auto_apt",  getFg_auto_aptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否自动预约");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 数据转移标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_transedADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_transed",  getFg_transedCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("数据转移标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
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
		attrDesc.setRefTblInfos(new String[]{"bd_dayslot a0b7","id_dayslot=id_dayslot","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 预约规则类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_schruleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_schrule",  getSd_schruleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("预约规则类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sc_apptrule a0b11","id_apptru=id_apptru","sd_schrule"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 版本号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getVerADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ver",  getVerCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("版本号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sc_dep_param a0b14","id_depparam=id_deptparam","ver"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取排班ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_schCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_sch");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("排班ID"); 
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
	 * 获取排班类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_sctpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_sctp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("排班类型"); 
		return column;
	}
	/**
	 * 获取排班类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_sctpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_sctp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("排班类型编码"); 
		return column;
	}
	/**
	 * 获取排班分类表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_sccaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_scca");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("排班分类"); 
		return column;
	}
	/**
	 * 获取日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getD_schCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"D_sch");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("日期"); 
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
	 * 获取号源池总数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getScpolcnCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Scpolcn");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("号源池总数"); 
		return column;
	}
	/**
	 * 获取票号模式id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_tickmdCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_tickmd");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("票号模式id"); 
		return column;
	}
	/**
	 * 获取票号模式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_tickmdCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_tickmd");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("票号模式"); 
		return column;
	}
	/**
	 * 获取预约规则表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_apptruCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_apptru");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("预约规则"); 
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
	 * 获取数量_总使用表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuan_total_usedCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Quan_total_used");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("数量_总使用"); 
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
	 * 获取数量_号源池0_已用表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuan0_usedCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Quan0_used");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("数量_号源池0_已用"); 
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
	 * 获取数量_号源池1_已用表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuan1_usedCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Quan1_used");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("数量_号源池1_已用"); 
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
	 * 获取数量_号源池2_已用表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuan2_usedCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Quan2_used");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("数量_号源池2_已用"); 
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
	 * 获取数量_号源池3_已用表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuan3_usedCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Quan3_used");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("数量_号源池3_已用"); 
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
	 * 获取数量_号源池4_已用表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuan4_usedCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Quan4_used");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("数量_号源池4_已用"); 
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
	 * 获取数量_号源池5_已用表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuan5_usedCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Quan5_used");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("数量_号源池5_已用"); 
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
	 * 获取数量_号源池6_已用表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuan6_usedCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Quan6_used");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("数量_号源池6_已用"); 
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
	 * 获取数量_号源池7_已用表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuan7_usedCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Quan7_used");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("数量_号源池7_已用"); 
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
	 * 获取数量_号源池8_已用表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuan8_usedCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Quan8_used");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("数量_号源池8_已用"); 
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
	 * 获取数量_号源池9_已用表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuan9_usedCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Quan9_used");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("数量_号源池9_已用"); 
		return column;
	}
	/**
	 * 获取已加号数量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAddquecnCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Addquecn");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("已加号数量"); 
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
	 * 获取客户扩展字段1表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef1CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def1");
		column.setLength(110);
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
		column.setLength(110);
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
		column.setLength(110);
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
		column.setLength(110);
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
		column.setLength(110);
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
		column.setLength(110);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段6"); 
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
	 * 获取诊椅表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_quesiteCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_quesite");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊椅"); 
		return column;
	}
	/**
	 * 获取排班护士表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_nurseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_nurse");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("排班护士"); 
		return column;
	}
	/**
	 * 获取科室参数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_depparamCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_depparam");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("科室参数"); 
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
	 * 获取替诊排班表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_scsch_canctoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_scsch_cancto");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("替诊排班"); 
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
	 * 获取是否自动预约表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_auto_aptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_auto_apt");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否自动预约"); 
		return column;
	}
	/**
	 * 获取数据转移标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_transedCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_transed");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("数据转移标志"); 
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
	 * 获取预约规则类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_schruleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_schrule");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("预约规则类型编码"); 
		return column;
	}
	/**
	 * 获取版本号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getVerCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ver");
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("版本号"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id","Id_sch");
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
		defaultValueMap.put("Addquecn",0);
	}
	
}
