
package iih.bd.srv.medsrv.d.desc;

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
 * 医疗服务药品属性 DO 元数据信息
 */
public class MedSrvDrugDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.bd.srv.medsrv.d.MedSrvDrugDO";
	public static final String CLASS_DISPALYNAME = "医疗服务药品属性";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "bd_srv_drug";
	public static final String TABLE_ALIAS_NAME = "a5";
	public static final String PRIMARYKEY_FIELDNAME="Id_srvdrug";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public MedSrvDrugDODesc(){
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
		this.setKeyDesc(getId_srvdrugADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_srvADesc(tblDesc));
		this.add(getId_srvdrugADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_srvADesc(tblDesc));
		this.add(getId_dosageADesc(tblDesc));
		this.add(getSd_dosageADesc(tblDesc));
		this.add(getId_pharmADesc(tblDesc));
		this.add(getSd_pharmADesc(tblDesc));
		this.add(getFg_poisADesc(tblDesc));
		this.add(getId_poisADesc(tblDesc));
		this.add(getSd_poisADesc(tblDesc));
		this.add(getFg_antiADesc(tblDesc));
		this.add(getId_antiADesc(tblDesc));
		this.add(getSd_antiADesc(tblDesc));
		this.add(getIndicaADesc(tblDesc));
		this.add(getConstrADesc(tblDesc));
		this.add(getUsageADesc(tblDesc));
		this.add(getReactADesc(tblDesc));
		this.add(getPrecautADesc(tblDesc));
		this.add(getInteractADesc(tblDesc));
		this.add(getId_mmtpADesc(tblDesc));
		this.add(getSd_mmtpADesc(tblDesc));
		this.add(getFg_highriskADesc(tblDesc));
		this.add(getId_antdrugcaADesc(tblDesc));
		this.add(getSd_antdrugcaADesc(tblDesc));
		this.add(getSrv_nameADesc(tblDesc));
		this.add(getDs_codeADesc(tblDesc));
		this.add(getDs_nameADesc(tblDesc));
		this.add(getName_pharmADesc(tblDesc));
		this.add(getName_poisADesc(tblDesc));
		this.add(getName_antiADesc(tblDesc));
		this.add(getName_mmtpADesc(tblDesc));
		this.add(getName_antdrugcaADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_srvdrugCDesc(tblDesc));
		tblDesc.add(getId_srvdrugCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_srvCDesc(tblDesc));
		tblDesc.add(getId_dosageCDesc(tblDesc));
		tblDesc.add(getSd_dosageCDesc(tblDesc));
		tblDesc.add(getId_pharmCDesc(tblDesc));
		tblDesc.add(getSd_pharmCDesc(tblDesc));
		tblDesc.add(getFg_poisCDesc(tblDesc));
		tblDesc.add(getId_poisCDesc(tblDesc));
		tblDesc.add(getSd_poisCDesc(tblDesc));
		tblDesc.add(getFg_antiCDesc(tblDesc));
		tblDesc.add(getId_antiCDesc(tblDesc));
		tblDesc.add(getSd_antiCDesc(tblDesc));
		tblDesc.add(getIndicaCDesc(tblDesc));
		tblDesc.add(getConstrCDesc(tblDesc));
		tblDesc.add(getUsageCDesc(tblDesc));
		tblDesc.add(getReactCDesc(tblDesc));
		tblDesc.add(getPrecautCDesc(tblDesc));
		tblDesc.add(getInteractCDesc(tblDesc));
		tblDesc.add(getId_mmtpCDesc(tblDesc));
		tblDesc.add(getSd_mmtpCDesc(tblDesc));
		tblDesc.add(getFg_highriskCDesc(tblDesc));
		tblDesc.add(getId_antdrugcaCDesc(tblDesc));
		tblDesc.add(getSd_antdrugcaCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 医疗服务药品属性主键标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_srvdrugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_srvdrug",  getId_srvdrugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医疗服务药品属性主键标识");
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
	 * 所属医疗服务属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_srvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_srv",  getId_srvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("所属医疗服务");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 药品剂型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dosageADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dosage",  getId_dosageCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("药品剂型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 药品剂型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_dosageADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_dosage",  getSd_dosageCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("药品剂型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 药理分类属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pharmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pharm",  getId_pharmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("药理分类");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 药理分类编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_pharmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_pharm",  getSd_pharmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("药理分类编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 毒麻标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_poisADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_pois",  getFg_poisCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("毒麻标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 毒麻分类属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_poisADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pois",  getId_poisCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("毒麻分类");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 毒麻分类编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_poisADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_pois",  getSd_poisCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("毒麻分类编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 抗菌药标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_antiADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_anti",  getFg_antiCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("抗菌药标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 抗菌药分类属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_antiADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_anti",  getId_antiCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("抗菌药分类");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 抗菌药分类编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_antiADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_anti",  getSd_antiCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("抗菌药分类编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 适应症属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIndicaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Indica",  getIndicaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("适应症");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 禁忌症属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getConstrADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Constr",  getConstrCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("禁忌症");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 用量与用法属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getUsageADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Usage",  getUsageCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用量与用法");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 不良反应属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getReactADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("React",  getReactCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("不良反应");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 注意事项属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPrecautADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Precaut",  getPrecautCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("注意事项");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 药品相互作用属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInteractADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Interact",  getInteractCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("药品相互作用");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 药品类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mmtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mmtp",  getId_mmtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("药品类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 药品类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_mmtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_mmtp",  getSd_mmtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("药品类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 高危药品标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_highriskADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_highrisk",  getFg_highriskCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("高危药品标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 抗肿瘤药物分类属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_antdrugcaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_antdrugca",  getId_antdrugcaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("抗肿瘤药物分类");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 抗肿瘤药物分类编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_antdrugcaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_antdrugca",  getSd_antdrugcaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("抗肿瘤药物分类编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 服务名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSrv_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Srv_name",  getSrv_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_srv a5b4","id_srv=id_srv","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDs_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ds_code",  getDs_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a5b5","id_dosage=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDs_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ds_name",  getDs_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a5b5","id_dosage=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_pharmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_pharm",  getName_pharmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a5b6","id_pharm=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_poisADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_pois",  getName_poisCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a5b8","id_pois=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_antiADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_anti",  getName_antiCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a5b9","id_anti=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 药品类型名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_mmtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_mmtp",  getName_mmtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("药品类型名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a5b10","id_mmtp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 抗肿瘤药物分类名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_antdrugcaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_antdrugca",  getName_antdrugcaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("抗肿瘤药物分类名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a5b11","id_antdrugca=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取医疗服务药品属性主键标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_srvdrugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_srvdrug");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("医疗服务药品属性主键标识"); 
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
	 * 获取所属医疗服务表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_srvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_srv");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("所属医疗服务"); 
		return column;
	}
	/**
	 * 获取药品剂型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dosageCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dosage");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("药品剂型"); 
		return column;
	}
	/**
	 * 获取药品剂型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_dosageCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_dosage");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("药品剂型编码"); 
		return column;
	}
	/**
	 * 获取药理分类表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pharmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pharm");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("药理分类"); 
		return column;
	}
	/**
	 * 获取药理分类编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_pharmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_pharm");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("药理分类编码"); 
		return column;
	}
	/**
	 * 获取毒麻标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_poisCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_pois");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("毒麻标识"); 
		return column;
	}
	/**
	 * 获取毒麻分类表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_poisCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pois");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("毒麻分类"); 
		return column;
	}
	/**
	 * 获取毒麻分类编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_poisCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_pois");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("毒麻分类编码"); 
		return column;
	}
	/**
	 * 获取抗菌药标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_antiCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_anti");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("抗菌药标识"); 
		return column;
	}
	/**
	 * 获取抗菌药分类表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_antiCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_anti");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("抗菌药分类"); 
		return column;
	}
	/**
	 * 获取抗菌药分类编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_antiCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_anti");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("抗菌药分类编码"); 
		return column;
	}
	/**
	 * 获取适应症表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIndicaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Indica");
		column.setLength(0);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("适应症"); 
		return column;
	}
	/**
	 * 获取禁忌症表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getConstrCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Constr");
		column.setLength(0);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("禁忌症"); 
		return column;
	}
	/**
	 * 获取用量与用法表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getUsageCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Usage");
		column.setLength(0);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("用量与用法"); 
		return column;
	}
	/**
	 * 获取不良反应表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getReactCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"React");
		column.setLength(0);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("不良反应"); 
		return column;
	}
	/**
	 * 获取注意事项表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPrecautCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Precaut");
		column.setLength(0);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("注意事项"); 
		return column;
	}
	/**
	 * 获取药品相互作用表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInteractCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Interact");
		column.setLength(0);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("药品相互作用"); 
		return column;
	}
	/**
	 * 获取药品类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mmtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mmtp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("药品类型"); 
		return column;
	}
	/**
	 * 获取药品类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_mmtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_mmtp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("药品类型编码"); 
		return column;
	}
	/**
	 * 获取高危药品标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_highriskCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_highrisk");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("高危药品标识"); 
		return column;
	}
	/**
	 * 获取抗肿瘤药物分类表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_antdrugcaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_antdrugca");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("抗肿瘤药物分类"); 
		return column;
	}
	/**
	 * 获取抗肿瘤药物分类编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_antdrugcaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_antdrugca");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("抗肿瘤药物分类编码"); 
		return column;
	}
	/**
	 * 获取服务名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSrv_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Srv_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDs_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ds_code");
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
	private IColumnDesc getDs_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ds_name");
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
	private IColumnDesc getName_pharmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_pharm");
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
	private IColumnDesc getName_poisCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_pois");
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
	private IColumnDesc getName_antiCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_anti");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取药品类型名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_mmtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_mmtp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("药品类型名称"); 
		return column;
	}
	/**
	 * 获取抗肿瘤药物分类名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_antdrugcaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_antdrugca");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("抗肿瘤药物分类名称"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id","Id_srvdrug");
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
		defaultValueMap.put("Id_mmtp","~");
	}
	
}
