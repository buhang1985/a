
package iih.hp.cp.hpcpassess.d.desc;

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
 * 入经评估单 DO 元数据信息
 */
public class HpcpAssessDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.hp.cp.hpcpassess.d.HpcpAssessDO";
	public static final String CLASS_DISPALYNAME = "入经评估单";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "HP_CP_ASSESS";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_assess";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public HpcpAssessDODesc(){
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
		this.setKeyDesc(getId_assessADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_assessADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_hpcpappADesc(tblDesc));
		this.add(getId_entADesc(tblDesc));
		this.add(getId_dep_phyADesc(tblDesc));
		this.add(getCode_amr_ipADesc(tblDesc));
		this.add(getNamecpADesc(tblDesc));
		this.add(getEu_resultADesc(tblDesc));
		this.add(getEu_hos_infectADesc(tblDesc));
		this.add(getEu_ops_partADesc(tblDesc));
		this.add(getEu_14rehosADesc(tblDesc));
		this.add(getEu_31rehosADesc(tblDesc));
		this.add(getEu_nonplan_rehosADesc(tblDesc));
		this.add(getSideeffects1ADesc(tblDesc));
		this.add(getSideeffects2ADesc(tblDesc));
		this.add(getSideeffects3ADesc(tblDesc));
		this.add(getThd_ant_medADesc(tblDesc));
		this.add(getDay_thdantmedADesc(tblDesc));
		this.add(getPre_ant_medADesc(tblDesc));
		this.add(getDay_preantmedADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getName_patADesc(tblDesc));
		this.add(getName_dep_phyADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_assessCDesc(tblDesc));
		tblDesc.add(getId_assessCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_hpcpappCDesc(tblDesc));
		tblDesc.add(getId_entCDesc(tblDesc));
		tblDesc.add(getId_dep_phyCDesc(tblDesc));
		tblDesc.add(getCode_amr_ipCDesc(tblDesc));
		tblDesc.add(getNamecpCDesc(tblDesc));
		tblDesc.add(getEu_resultCDesc(tblDesc));
		tblDesc.add(getEu_hos_infectCDesc(tblDesc));
		tblDesc.add(getEu_ops_partCDesc(tblDesc));
		tblDesc.add(getEu_14rehosCDesc(tblDesc));
		tblDesc.add(getEu_31rehosCDesc(tblDesc));
		tblDesc.add(getEu_nonplan_rehosCDesc(tblDesc));
		tblDesc.add(getSideeffects1CDesc(tblDesc));
		tblDesc.add(getSideeffects2CDesc(tblDesc));
		tblDesc.add(getSideeffects3CDesc(tblDesc));
		tblDesc.add(getThd_ant_medCDesc(tblDesc));
		tblDesc.add(getDay_thdantmedCDesc(tblDesc));
		tblDesc.add(getPre_ant_medCDesc(tblDesc));
		tblDesc.add(getDay_preantmedCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 评估单标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_assessADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_assess",  getId_assessCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("评估单标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
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
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 路径id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_hpcpappADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_hpcpapp",  getId_hpcpappCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("路径id");
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
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 就诊科室属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dep_phyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep_phy",  getId_dep_phyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("就诊科室");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 病案号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_amr_ipADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_amr_ip",  getCode_amr_ipCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病案号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 路径名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNamecpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Namecp",  getNamecpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("路径名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 入经效果属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_resultADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_result",  getEu_resultCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("入经效果");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医院感染属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_hos_infectADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_hos_infect",  getEu_hos_infectCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("医院感染");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术病人手术部位感染属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_ops_partADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_ops_part",  getEu_ops_partCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("手术病人手术部位感染");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 14日再住院属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_14rehosADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_14rehos",  getEu_14rehosCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("14日再住院");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 31日再住院属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_31rehosADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_31rehos",  getEu_31rehosCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("31日再住院");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术病人非计划重返手术室属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_nonplan_rehosADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_nonplan_rehos",  getEu_nonplan_rehosCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("手术病人非计划重返手术室");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 并发症/手术后并发症1属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSideeffects1ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sideeffects1",  getSideeffects1CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("并发症/手术后并发症1");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 并发症/手术后并发症2属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSideeffects2ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sideeffects2",  getSideeffects2CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("并发症/手术后并发症2");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 并发症/手术后并发症3属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSideeffects3ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sideeffects3",  getSideeffects3CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("并发症/手术后并发症3");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 使用三线抗菌药物属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getThd_ant_medADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Thd_ant_med",  getThd_ant_medCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("使用三线抗菌药物");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 抗生素使用天数(天)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDay_thdantmedADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Day_thdantmed",  getDay_thdantmedCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("抗生素使用天数(天)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术病人预防性抗菌药物应用类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPre_ant_medADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pre_ant_med",  getPre_ant_medCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术病人预防性抗菌药物应用类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术病人预防性抗菌药物应用天数(天)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDay_preantmedADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Day_preantmed",  getDay_preantmedCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("手术病人预防性抗菌药物应用天数(天)");
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
	 * 患者姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_patADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_pat",  getName_patCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"en_ent a0b6","id_ent=id_ent","name_pat"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 就诊科室属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dep_phyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dep_phy",  getName_dep_phyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("就诊科室");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b5","id_dep_phy=id_dep","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取评估单标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_assessCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_assess");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("评估单标识"); 
		return column;
	}
	/**
	 * 获取组织表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_orgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_org");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("组织"); 
		return column;
	}
	/**
	 * 获取集团表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_grpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_grp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("集团"); 
		return column;
	}
	/**
	 * 获取路径id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_hpcpappCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_hpcpapp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("路径id"); 
		return column;
	}
	/**
	 * 获取就诊id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_entCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ent");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊id"); 
		return column;
	}
	/**
	 * 获取就诊科室表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dep_phyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep_phy");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊科室"); 
		return column;
	}
	/**
	 * 获取病案号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_amr_ipCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_amr_ip");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病案号"); 
		return column;
	}
	/**
	 * 获取路径名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNamecpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Namecp");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("路径名称"); 
		return column;
	}
	/**
	 * 获取入经效果表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_resultCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_result");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("入经效果"); 
		return column;
	}
	/**
	 * 获取医院感染表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_hos_infectCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_hos_infect");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("医院感染"); 
		return column;
	}
	/**
	 * 获取手术病人手术部位感染表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_ops_partCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_ops_part");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("手术病人手术部位感染"); 
		return column;
	}
	/**
	 * 获取14日再住院表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_14rehosCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_14rehos");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("14日再住院"); 
		return column;
	}
	/**
	 * 获取31日再住院表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_31rehosCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_31rehos");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("31日再住院"); 
		return column;
	}
	/**
	 * 获取手术病人非计划重返手术室表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_nonplan_rehosCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_nonplan_rehos");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("手术病人非计划重返手术室"); 
		return column;
	}
	/**
	 * 获取并发症/手术后并发症1表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSideeffects1CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sideeffects1");
		column.setLength(600);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("并发症/手术后并发症1"); 
		return column;
	}
	/**
	 * 获取并发症/手术后并发症2表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSideeffects2CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sideeffects2");
		column.setLength(600);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("并发症/手术后并发症2"); 
		return column;
	}
	/**
	 * 获取并发症/手术后并发症3表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSideeffects3CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sideeffects3");
		column.setLength(600);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("并发症/手术后并发症3"); 
		return column;
	}
	/**
	 * 获取使用三线抗菌药物表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getThd_ant_medCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Thd_ant_med");
		column.setLength(600);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("使用三线抗菌药物"); 
		return column;
	}
	/**
	 * 获取抗生素使用天数(天)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDay_thdantmedCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Day_thdantmed");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("抗生素使用天数(天)"); 
		return column;
	}
	/**
	 * 获取手术病人预防性抗菌药物应用类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPre_ant_medCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pre_ant_med");
		column.setLength(600);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术病人预防性抗菌药物应用类型"); 
		return column;
	}
	/**
	 * 获取手术病人预防性抗菌药物应用天数(天)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDay_preantmedCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Day_preantmed");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("手术病人预防性抗菌药物应用天数(天)"); 
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
	 * 获取患者姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_pat");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者姓名"); 
		return column;
	}
	/**
	 * 获取就诊科室表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_dep_phyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dep_phy");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊科室"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
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
