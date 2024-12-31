
package iih.pi.dic.patcatehp.d.desc;

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
 * 患者分类医保计划 DO 元数据信息
 */
public class PiPatCaHpDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.pi.dic.patcatehp.d.PiPatCaHpDO";
	public static final String CLASS_DISPALYNAME = "患者分类医保计划";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "pi_pat_ca_hp";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_patcahp";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public PiPatCaHpDODesc(){
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
		this.setKeyDesc(getId_patcahpADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_patcahpADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_patcaADesc(tblDesc));
		this.add(getId_hpADesc(tblDesc));
		this.add(getFg_fundpayADesc(tblDesc));
		this.add(getId_hpkindADesc(tblDesc));
		this.add(getId_medkind_oepdftADesc(tblDesc));
		this.add(getFg_hp_cardADesc(tblDesc));
		this.add(getFg_hp_spclADesc(tblDesc));
		this.add(getId_hppatsourceADesc(tblDesc));
		this.add(getSd_hppatsourceADesc(tblDesc));
		this.add(getFg_self_uploadADesc(tblDesc));
		this.add(getEu_ident_readADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getCode_patcaADesc(tblDesc));
		this.add(getName_patcaADesc(tblDesc));
		this.add(getCode_hpADesc(tblDesc));
		this.add(getName_hpADesc(tblDesc));
		this.add(getFg_reqhpcodeADesc(tblDesc));
		this.add(getCode_hpkindADesc(tblDesc));
		this.add(getName_hpkindADesc(tblDesc));
		this.add(getCode_medkind_oepADesc(tblDesc));
		this.add(getName_medkind_oepADesc(tblDesc));
		this.add(getHppatsource_nameADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_patcahpCDesc(tblDesc));
		tblDesc.add(getId_patcahpCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_patcaCDesc(tblDesc));
		tblDesc.add(getId_hpCDesc(tblDesc));
		tblDesc.add(getFg_fundpayCDesc(tblDesc));
		tblDesc.add(getId_hpkindCDesc(tblDesc));
		tblDesc.add(getId_medkind_oepdftCDesc(tblDesc));
		tblDesc.add(getFg_hp_cardCDesc(tblDesc));
		tblDesc.add(getFg_hp_spclCDesc(tblDesc));
		tblDesc.add(getId_hppatsourceCDesc(tblDesc));
		tblDesc.add(getSd_hppatsourceCDesc(tblDesc));
		tblDesc.add(getFg_self_uploadCDesc(tblDesc));
		tblDesc.add(getEu_ident_readCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 患者分类医保计划id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_patcahpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_patcahp",  getId_patcahpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者分类医保计划id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
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
	 * 患者分类属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_patcaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_patca",  getId_patcaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者分类");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 医保计划属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_hpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_hp",  getId_hpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医保计划");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 医保基金支付标准属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_fundpayADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_fundpay",  getFg_fundpayCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("医保基金支付标准");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 险种属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_hpkindADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_hpkind",  getId_hpkindCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("险种");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 门诊默认医疗类别属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_medkind_oepdftADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_medkind_oepdft",  getId_medkind_oepdftCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("门诊默认医疗类别");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 持卡标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_hp_cardADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_hp_card",  getFg_hp_cardCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("持卡标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 特病标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_hp_spclADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_hp_spcl",  getFg_hp_spclCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("特病标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医保患者来源属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_hppatsourceADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_hppatsource",  getId_hppatsourceCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医保患者来源");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 医保患者来源编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_hppatsourceADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_hppatsource",  getSd_hppatsourceCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医保患者来源编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 自费方是否上传属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_self_uploadADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_self_upload",  getFg_self_uploadCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("自费方是否上传");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医保身份读取模式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_ident_readADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_ident_read",  getEu_ident_readCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医保身份读取模式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
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
	 * 患者分类编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_patcaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_patca",  getCode_patcaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者分类编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pi_pat_ca a0b4","id_patca=id_patca","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者分类名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_patcaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_patca",  getName_patcaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者分类名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pi_pat_ca a0b4","id_patca=id_patca","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医保计划编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_hpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_hp",  getCode_hpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医保计划编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_hp a0b5","id_hp=id_hp","code"});
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
		attrDesc.setRefTblInfos(new String[]{"bd_hp a0b5","id_hp=id_hp","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医保号码必填标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_reqhpcodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_reqhpcode",  getFg_reqhpcodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("医保号码必填标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_hp a0b5","id_hp=id_hp","fg_reqhpcode"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 险种编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_hpkindADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_hpkind",  getCode_hpkindCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("险种编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"BD_HP_KIND a0b6","id_hpkind=id_hpkind","code_hpkind"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 险种名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_hpkindADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_hpkind",  getName_hpkindCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("险种名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"BD_HP_KIND a0b6","id_hpkind=id_hpkind","name_hpkind"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 门诊默认医疗类别编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_medkind_oepADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_medkind_oep",  getCode_medkind_oepCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("门诊默认医疗类别编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_hp_med_kind_ah a0b10","id_medkind_oepdft=id_hpmedkindah","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 门诊默认医疗类别名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_medkind_oepADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_medkind_oep",  getName_medkind_oepCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("门诊默认医疗类别名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_hp_med_kind_ah a0b10","id_medkind_oepdft=id_hpmedkindah","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者来源名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHppatsource_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Hppatsource_name",  getHppatsource_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者来源名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b9","id_hppatsource=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取患者分类医保计划id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_patcahpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_patcahp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者分类医保计划id"); 
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
	 * 获取患者分类表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_patcaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_patca");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者分类"); 
		return column;
	}
	/**
	 * 获取医保计划表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_hpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_hp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医保计划"); 
		return column;
	}
	/**
	 * 获取医保基金支付标准表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_fundpayCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_fundpay");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("医保基金支付标准"); 
		return column;
	}
	/**
	 * 获取险种表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_hpkindCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_hpkind");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("险种"); 
		return column;
	}
	/**
	 * 获取门诊默认医疗类别表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_medkind_oepdftCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_medkind_oepdft");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("门诊默认医疗类别"); 
		return column;
	}
	/**
	 * 获取持卡标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_hp_cardCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_hp_card");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("持卡标志"); 
		return column;
	}
	/**
	 * 获取特病标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_hp_spclCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_hp_spcl");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("特病标志"); 
		return column;
	}
	/**
	 * 获取医保患者来源表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_hppatsourceCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_hppatsource");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医保患者来源"); 
		return column;
	}
	/**
	 * 获取医保患者来源编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_hppatsourceCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_hppatsource");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医保患者来源编码"); 
		return column;
	}
	/**
	 * 获取自费方是否上传表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_self_uploadCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_self_upload");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("自费方是否上传"); 
		return column;
	}
	/**
	 * 获取医保身份读取模式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_ident_readCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_ident_read");
		column.setLength(10);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医保身份读取模式"); 
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
	 * 获取患者分类编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_patcaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_patca");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者分类编码"); 
		return column;
	}
	/**
	 * 获取患者分类名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_patcaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_patca");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者分类名称"); 
		return column;
	}
	/**
	 * 获取医保计划编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_hpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_hp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医保计划编码"); 
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
	 * 获取医保号码必填标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_reqhpcodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_reqhpcode");
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("医保号码必填标志"); 
		return column;
	}
	/**
	 * 获取险种编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_hpkindCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_hpkind");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("险种编码"); 
		return column;
	}
	/**
	 * 获取险种名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_hpkindCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_hpkind");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("险种名称"); 
		return column;
	}
	/**
	 * 获取门诊默认医疗类别编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_medkind_oepCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_medkind_oep");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("门诊默认医疗类别编码"); 
		return column;
	}
	/**
	 * 获取门诊默认医疗类别名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_medkind_oepCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_medkind_oep");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("门诊默认医疗类别名称"); 
		return column;
	}
	/**
	 * 获取患者来源名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHppatsource_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Hppatsource_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者来源名称"); 
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
