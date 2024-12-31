
package iih.bd.pp.bdprewarn.d.desc;

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
 * 预交金警告策略 DO 元数据信息
 */
public class BdPreWarnDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.bd.pp.bdprewarn.d.BdPreWarnDO";
	public static final String CLASS_DISPALYNAME = "预交金警告策略";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "bd_prewarn";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_prewarn";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public BdPreWarnDODesc(){
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
		this.setKeyDesc(getId_prewarnADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_prewarnADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_depADesc(tblDesc));
		this.add(getLimitADesc(tblDesc));
		this.add(getEu_prewarntpADesc(tblDesc));
		this.add(getId_patcaADesc(tblDesc));
		this.add(getP_controlADesc(tblDesc));
		this.add(getF_controlADesc(tblDesc));
		this.add(getEu_controlADesc(tblDesc));
		this.add(getId_entpADesc(tblDesc));
		this.add(getCode_entpADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getFg_whiteADesc(tblDesc));
		this.add(getId_dep_nurADesc(tblDesc));
		this.add(getId_hppatcaADesc(tblDesc));
		this.add(getFg_prewarnADesc(tblDesc));
		this.add(getDeptcodeADesc(tblDesc));
		this.add(getDeptnameADesc(tblDesc));
		this.add(getPatca_codeADesc(tblDesc));
		this.add(getPatca_nameADesc(tblDesc));
		this.add(getEntp_nameADesc(tblDesc));
		this.add(getName_dep_nurADesc(tblDesc));
		this.add(getCode_dep_nurADesc(tblDesc));
		this.add(getCode_hppatcaADesc(tblDesc));
		this.add(getName_hppatcaADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_prewarnCDesc(tblDesc));
		tblDesc.add(getId_prewarnCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_depCDesc(tblDesc));
		tblDesc.add(getLimitCDesc(tblDesc));
		tblDesc.add(getEu_prewarntpCDesc(tblDesc));
		tblDesc.add(getId_patcaCDesc(tblDesc));
		tblDesc.add(getP_controlCDesc(tblDesc));
		tblDesc.add(getF_controlCDesc(tblDesc));
		tblDesc.add(getEu_controlCDesc(tblDesc));
		tblDesc.add(getId_entpCDesc(tblDesc));
		tblDesc.add(getCode_entpCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		tblDesc.add(getFg_whiteCDesc(tblDesc));
		tblDesc.add(getId_dep_nurCDesc(tblDesc));
		tblDesc.add(getId_hppatcaCDesc(tblDesc));
		tblDesc.add(getFg_prewarnCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 预交金警告策略主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_prewarnADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_prewarn",  getId_prewarnCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("预交金警告策略主键");
		attrDesc.setNullable(false);
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
	 * 科室ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_depADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep",  getId_depCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("科室ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setExtTag("BDMODE,URC");
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 警告值属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getLimitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Limit",  getLimitCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("警告值");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 所属类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_prewarntpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_prewarntp",  getEu_prewarntpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("所属类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setExtTag("BDMODE,URC");
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 患者身份属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_patcaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_patca",  getId_patcaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者身份");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setExtTag("BDMODE,URC");
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 部分控制值属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getP_controlADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("P_control",  getP_controlCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("部分控制值");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 完全控制值属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getF_controlADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("F_control",  getF_controlCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("完全控制值");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 控制模式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_controlADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_control",  getEu_controlCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("控制模式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setExtTag("BDMODE,URC");
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 就诊类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_entpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_entp",  getId_entpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("就诊类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setExtTag("BDMODE,URC");
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 就诊类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_entpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_entp",  getCode_entpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("就诊类型编码");
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
	 * 受控白名单标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_whiteADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_white",  getFg_whiteCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("受控白名单标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 病区属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dep_nurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep_nur",  getId_dep_nurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病区");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setExtTag("BDMODE,URC");
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 医保计划身份属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_hppatcaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_hppatca",  getId_hppatcaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医保计划身份");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setExtTag("BDMODE,URC");
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 欠费控制属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_prewarnADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_prewarn",  getFg_prewarnCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("欠费控制");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDeptcodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Deptcode",  getDeptcodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b4","id_dep=id_dep","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDeptnameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Deptname",  getDeptnameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b4","id_dep=id_dep","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者分类编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPatca_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Patca_code",  getPatca_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者分类编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pi_pat_ca a0b5","id_patca=id_patca","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者分类名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPatca_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Patca_name",  getPatca_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者分类名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pi_pat_ca a0b5","id_patca=id_patca","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 就诊类型名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEntp_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Entp_name",  getEntp_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("就诊类型名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_entp a0b9","id_entp=id_entp","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 病区名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dep_nurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dep_nur",  getName_dep_nurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病区名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b10","id_dep_nur=id_dep","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 病区编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_dep_nurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_dep_nur",  getCode_dep_nurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病区编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b10","id_dep_nur=id_dep","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医保身份编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_hppatcaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_hppatca",  getCode_hppatcaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医保身份编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"BD_HP_PATCA a0b11","id_hppatca=id_hppatca","code_hppatca"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医保身份名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_hppatcaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_hppatca",  getName_hppatcaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医保身份名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"BD_HP_PATCA a0b11","id_hppatca=id_hppatca","name_hppatca"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取预交金警告策略主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_prewarnCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_prewarn");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("预交金警告策略主键"); 
		return column;
	}
	/**
	 * 获取组织表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_orgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_org");
		column.setLength(20);
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
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("集团"); 
		return column;
	}
	/**
	 * 获取科室ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_depCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("科室ID"); 
		return column;
	}
	/**
	 * 获取警告值表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getLimitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Limit");
		column.setLength(14);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("警告值"); 
		return column;
	}
	/**
	 * 获取所属类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_prewarntpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_prewarntp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("所属类型"); 
		return column;
	}
	/**
	 * 获取患者身份表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_patcaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_patca");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者身份"); 
		return column;
	}
	/**
	 * 获取部分控制值表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getP_controlCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"P_control");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("部分控制值"); 
		return column;
	}
	/**
	 * 获取完全控制值表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getF_controlCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"F_control");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("完全控制值"); 
		return column;
	}
	/**
	 * 获取控制模式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_controlCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_control");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("控制模式"); 
		return column;
	}
	/**
	 * 获取就诊类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_entpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_entp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊类型"); 
		return column;
	}
	/**
	 * 获取就诊类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_entpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_entp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊类型编码"); 
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
	 * 获取受控白名单标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_whiteCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_white");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("受控白名单标志"); 
		return column;
	}
	/**
	 * 获取病区表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dep_nurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep_nur");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病区"); 
		return column;
	}
	/**
	 * 获取医保计划身份表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_hppatcaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_hppatca");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医保计划身份"); 
		return column;
	}
	/**
	 * 获取欠费控制表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_prewarnCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_prewarn");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("欠费控制"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDeptcodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Deptcode");
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
	private IColumnDesc getDeptnameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Deptname");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取患者分类编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPatca_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Patca_code");
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
	private IColumnDesc getPatca_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Patca_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者分类名称"); 
		return column;
	}
	/**
	 * 获取就诊类型名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEntp_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Entp_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊类型名称"); 
		return column;
	}
	/**
	 * 获取病区名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_dep_nurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dep_nur");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病区名称"); 
		return column;
	}
	/**
	 * 获取病区编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_dep_nurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_dep_nur");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病区编码"); 
		return column;
	}
	/**
	 * 获取医保身份编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_hppatcaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_hppatca");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医保身份编码"); 
		return column;
	}
	/**
	 * 获取医保身份名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_hppatcaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_hppatca");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医保身份名称"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id","Id_prewarn");
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
		defaultValueMap.put("Fg_prewarn",new xap.mw.coreitf.d.FBoolean("Y"));
	}
	
}
