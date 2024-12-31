
package iih.nm.nom.nomquality.d.desc;

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
 * 护理质量管理 DO 元数据信息
 */
public class NomNurQualityDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.nm.nom.nomquality.d.NomNurQualityDO";
	public static final String CLASS_DISPALYNAME = "护理质量管理";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "nom_nur_quality";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_nom_nurquality";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public NomNurQualityDODesc(){
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
		this.setKeyDesc(getId_nom_nurqualityADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_nom_nurqualityADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_dep_nurADesc(tblDesc));
		this.add(getFall_randinspectADesc(tblDesc));
		this.add(getFall_evalADesc(tblDesc));
		this.add(getPress_randinspectADesc(tblDesc));
		this.add(getPress_evalADesc(tblDesc));
		this.add(getPressADesc(tblDesc));
		this.add(getFallADesc(tblDesc));
		this.add(getInfuADesc(tblDesc));
		this.add(getInfu_reactADesc(tblDesc));
		this.add(getTransfusionADesc(tblDesc));
		this.add(getTransfu_reactADesc(tblDesc));
		this.add(getAdverse_eventADesc(tblDesc));
		this.add(getAdverse_eventiADesc(tblDesc));
		this.add(getAdverse_eventiiADesc(tblDesc));
		this.add(getAdverse_eventiiiADesc(tblDesc));
		this.add(getAdverse_eventivADesc(tblDesc));
		this.add(getImp_deliveryADesc(tblDesc));
		this.add(getImp_qualifiedADesc(tblDesc));
		this.add(getEmergencyADesc(tblDesc));
		this.add(getCom_emergencyADesc(tblDesc));
		this.add(getOperationADesc(tblDesc));
		this.add(getOperat_qualifiedADesc(tblDesc));
		this.add(getProce_specifADesc(tblDesc));
		this.add(getProce_qualifiedADesc(tblDesc));
		this.add(getHealth_edu_itemADesc(tblDesc));
		this.add(getKnown_health_eduADesc(tblDesc));
		this.add(getNur_specifADesc(tblDesc));
		this.add(getNur_specif_truthADesc(tblDesc));
		this.add(getCheck_begintimeADesc(tblDesc));
		this.add(getCheck_endtimeADesc(tblDesc));
		this.add(getCheck_monthADesc(tblDesc));
		this.add(getFg_comfirmADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getName_dep_nurADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_nom_nurqualityCDesc(tblDesc));
		tblDesc.add(getId_nom_nurqualityCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_dep_nurCDesc(tblDesc));
		tblDesc.add(getFall_randinspectCDesc(tblDesc));
		tblDesc.add(getFall_evalCDesc(tblDesc));
		tblDesc.add(getPress_randinspectCDesc(tblDesc));
		tblDesc.add(getPress_evalCDesc(tblDesc));
		tblDesc.add(getPressCDesc(tblDesc));
		tblDesc.add(getFallCDesc(tblDesc));
		tblDesc.add(getInfuCDesc(tblDesc));
		tblDesc.add(getInfu_reactCDesc(tblDesc));
		tblDesc.add(getTransfusionCDesc(tblDesc));
		tblDesc.add(getTransfu_reactCDesc(tblDesc));
		tblDesc.add(getAdverse_eventCDesc(tblDesc));
		tblDesc.add(getAdverse_eventiCDesc(tblDesc));
		tblDesc.add(getAdverse_eventiiCDesc(tblDesc));
		tblDesc.add(getAdverse_eventiiiCDesc(tblDesc));
		tblDesc.add(getAdverse_eventivCDesc(tblDesc));
		tblDesc.add(getImp_deliveryCDesc(tblDesc));
		tblDesc.add(getImp_qualifiedCDesc(tblDesc));
		tblDesc.add(getEmergencyCDesc(tblDesc));
		tblDesc.add(getCom_emergencyCDesc(tblDesc));
		tblDesc.add(getOperationCDesc(tblDesc));
		tblDesc.add(getOperat_qualifiedCDesc(tblDesc));
		tblDesc.add(getProce_specifCDesc(tblDesc));
		tblDesc.add(getProce_qualifiedCDesc(tblDesc));
		tblDesc.add(getHealth_edu_itemCDesc(tblDesc));
		tblDesc.add(getKnown_health_eduCDesc(tblDesc));
		tblDesc.add(getNur_specifCDesc(tblDesc));
		tblDesc.add(getNur_specif_truthCDesc(tblDesc));
		tblDesc.add(getCheck_begintimeCDesc(tblDesc));
		tblDesc.add(getCheck_endtimeCDesc(tblDesc));
		tblDesc.add(getCheck_monthCDesc(tblDesc));
		tblDesc.add(getFg_comfirmCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 护理质量管理主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_nom_nurqualityADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_nom_nurquality",  getId_nom_nurqualityCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("护理质量管理主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
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
	 * 住院跌倒抽检人数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFall_randinspectADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fall_randinspect",  getFall_randinspectCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("住院跌倒抽检人数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 住院跌倒符合数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFall_evalADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fall_eval",  getFall_evalCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("住院跌倒符合数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 住院压疮抽检人数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPress_randinspectADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Press_randinspect",  getPress_randinspectCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("住院压疮抽检人数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 住院压疮符合数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPress_evalADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Press_eval",  getPress_evalCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("住院压疮符合数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 院内压疮数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPressADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Press",  getPressCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("院内压疮数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 跌倒数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFallADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fall",  getFallCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("跌倒数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 输液人数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInfuADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Infu",  getInfuCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("输液人数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 输液反应数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInfu_reactADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Infu_react",  getInfu_reactCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("输液反应数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 输血人数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTransfusionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Transfusion",  getTransfusionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("输血人数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 输血反应数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTransfu_reactADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Transfu_react",  getTransfu_reactCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("输血反应数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 不良事件上报数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAdverse_eventADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Adverse_event",  getAdverse_eventCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("不良事件上报数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 不良事件I级属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAdverse_eventiADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Adverse_eventi",  getAdverse_eventiCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("不良事件I级");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 不良事件II级属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAdverse_eventiiADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Adverse_eventii",  getAdverse_eventiiCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("不良事件II级");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 不良事件三级属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAdverse_eventiiiADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Adverse_eventiii",  getAdverse_eventiiiCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("不良事件三级");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 不良事件四级属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAdverse_eventivADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Adverse_eventiv",  getAdverse_eventivCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("不良事件四级");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 重点环节交接人数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getImp_deliveryADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Imp_delivery",  getImp_deliveryCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("重点环节交接人数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 重点环节合格人数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getImp_qualifiedADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Imp_qualified",  getImp_qualifiedCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("重点环节合格人数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 急救物品属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEmergencyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Emergency",  getEmergencyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("急救物品");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 完好急救物品属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCom_emergencyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Com_emergency",  getCom_emergencyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("完好急救物品");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 操作考核人数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOperationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Operation",  getOperationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("操作考核人数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 操作考核合格人数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOperat_qualifiedADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Operat_qualified",  getOperat_qualifiedCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("操作考核合格人数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 流程规范抽查人数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getProce_specifADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Proce_specif",  getProce_specifCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("流程规范抽查人数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 流程规范合格人数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getProce_qualifiedADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Proce_qualified",  getProce_qualifiedCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("流程规范合格人数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 健康教育项目属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHealth_edu_itemADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Health_edu_item",  getHealth_edu_itemCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("健康教育项目");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 健康教育知晓项目属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getKnown_health_eduADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Known_health_edu",  getKnown_health_eduCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("健康教育知晓项目");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 护理规范应落实项目属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNur_specifADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Nur_specif",  getNur_specifCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("护理规范应落实项目");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 护理规范实际落实属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNur_specif_truthADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Nur_specif_truth",  getNur_specif_truthCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("护理规范实际落实");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 考核开始时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCheck_begintimeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Check_begintime",  getCheck_begintimeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("考核开始时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 考核结束时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCheck_endtimeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Check_endtime",  getCheck_endtimeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("考核结束时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 考核年月属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCheck_monthADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Check_month",  getCheck_monthCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("考核年月");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否上报属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_comfirmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_comfirm",  getFg_comfirmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否上报");
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
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dep_nurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dep_nur",  getName_dep_nurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b6","id_dep_nur=id_dep","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取护理质量管理主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_nom_nurqualityCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_nom_nurquality");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("护理质量管理主键"); 
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
	 * 获取住院跌倒抽检人数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFall_randinspectCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fall_randinspect");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("住院跌倒抽检人数"); 
		return column;
	}
	/**
	 * 获取住院跌倒符合数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFall_evalCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fall_eval");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("住院跌倒符合数"); 
		return column;
	}
	/**
	 * 获取住院压疮抽检人数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPress_randinspectCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Press_randinspect");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("住院压疮抽检人数"); 
		return column;
	}
	/**
	 * 获取住院压疮符合数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPress_evalCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Press_eval");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("住院压疮符合数"); 
		return column;
	}
	/**
	 * 获取院内压疮数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPressCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Press");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("院内压疮数"); 
		return column;
	}
	/**
	 * 获取跌倒数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFallCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fall");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("跌倒数"); 
		return column;
	}
	/**
	 * 获取输液人数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInfuCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Infu");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("输液人数"); 
		return column;
	}
	/**
	 * 获取输液反应数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInfu_reactCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Infu_react");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("输液反应数"); 
		return column;
	}
	/**
	 * 获取输血人数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTransfusionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Transfusion");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("输血人数"); 
		return column;
	}
	/**
	 * 获取输血反应数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTransfu_reactCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Transfu_react");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("输血反应数"); 
		return column;
	}
	/**
	 * 获取不良事件上报数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAdverse_eventCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Adverse_event");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("不良事件上报数"); 
		return column;
	}
	/**
	 * 获取不良事件I级表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAdverse_eventiCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Adverse_eventi");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("不良事件I级"); 
		return column;
	}
	/**
	 * 获取不良事件II级表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAdverse_eventiiCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Adverse_eventii");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("不良事件II级"); 
		return column;
	}
	/**
	 * 获取不良事件三级表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAdverse_eventiiiCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Adverse_eventiii");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("不良事件三级"); 
		return column;
	}
	/**
	 * 获取不良事件四级表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAdverse_eventivCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Adverse_eventiv");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("不良事件四级"); 
		return column;
	}
	/**
	 * 获取重点环节交接人数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getImp_deliveryCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Imp_delivery");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("重点环节交接人数"); 
		return column;
	}
	/**
	 * 获取重点环节合格人数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getImp_qualifiedCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Imp_qualified");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("重点环节合格人数"); 
		return column;
	}
	/**
	 * 获取急救物品表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEmergencyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Emergency");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("急救物品"); 
		return column;
	}
	/**
	 * 获取完好急救物品表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCom_emergencyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Com_emergency");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("完好急救物品"); 
		return column;
	}
	/**
	 * 获取操作考核人数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOperationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Operation");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("操作考核人数"); 
		return column;
	}
	/**
	 * 获取操作考核合格人数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOperat_qualifiedCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Operat_qualified");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("操作考核合格人数"); 
		return column;
	}
	/**
	 * 获取流程规范抽查人数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getProce_specifCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Proce_specif");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("流程规范抽查人数"); 
		return column;
	}
	/**
	 * 获取流程规范合格人数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getProce_qualifiedCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Proce_qualified");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("流程规范合格人数"); 
		return column;
	}
	/**
	 * 获取健康教育项目表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHealth_edu_itemCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Health_edu_item");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("健康教育项目"); 
		return column;
	}
	/**
	 * 获取健康教育知晓项目表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getKnown_health_eduCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Known_health_edu");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("健康教育知晓项目"); 
		return column;
	}
	/**
	 * 获取护理规范应落实项目表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNur_specifCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Nur_specif");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("护理规范应落实项目"); 
		return column;
	}
	/**
	 * 获取护理规范实际落实表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNur_specif_truthCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Nur_specif_truth");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("护理规范实际落实"); 
		return column;
	}
	/**
	 * 获取考核开始时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCheck_begintimeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Check_begintime");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("考核开始时间"); 
		return column;
	}
	/**
	 * 获取考核结束时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCheck_endtimeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Check_endtime");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("考核结束时间"); 
		return column;
	}
	/**
	 * 获取考核年月表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCheck_monthCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Check_month");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("考核年月"); 
		return column;
	}
	/**
	 * 获取是否上报表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_comfirmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_comfirm");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否上报"); 
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
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_dep_nurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dep_nur");
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
		iBDDataInfoFldMap.put("id","Nom_nurquality_id");
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
