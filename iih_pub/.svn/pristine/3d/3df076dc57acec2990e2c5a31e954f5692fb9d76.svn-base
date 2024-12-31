
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
 * 医疗服务检验属性 DO 元数据信息
 */
public class MedSrvLisDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.bd.srv.medsrv.d.MedSrvLisDO";
	public static final String CLASS_DISPALYNAME = "医疗服务检验属性";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "bd_srv_lab";
	public static final String TABLE_ALIAS_NAME = "a1";
	public static final String PRIMARYKEY_FIELDNAME="Id_srvlab";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public MedSrvLisDODesc(){
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
		this.setKeyDesc(getId_srvlabADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_srvADesc(tblDesc));
		this.add(getId_srvlabADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_samptpADesc(tblDesc));
		this.add(getSd_samptpADesc(tblDesc));
		this.add(getQuanADesc(tblDesc));
		this.add(getId_unit_quanADesc(tblDesc));
		this.add(getId_colltpADesc(tblDesc));
		this.add(getSd_colltpADesc(tblDesc));
		this.add(getDes_labsampADesc(tblDesc));
		this.add(getId_labgroupADesc(tblDesc));
		this.add(getSd_labgroupADesc(tblDesc));
		this.add(getStd_hiADesc(tblDesc));
		this.add(getStd_loADesc(tblDesc));
		this.add(getId_unit_nuitADesc(tblDesc));
		this.add(getNoteADesc(tblDesc));
		this.add(getId_srvADesc(tblDesc));
		this.add(getId_restrptlabtpADesc(tblDesc));
		this.add(getSd_restrptlabtpADesc(tblDesc));
		this.add(getVal_restrptlabADesc(tblDesc));
		this.add(getId_contpADesc(tblDesc));
		this.add(getSd_contpADesc(tblDesc));
		this.add(getId_sampcoltimeADesc(tblDesc));
		this.add(getLen_sampcoltimeADesc(tblDesc));
		this.add(getId_unit_sampcoltimeADesc(tblDesc));
		this.add(getId_sampcollecttimetpADesc(tblDesc));
		this.add(getSd_sampcollecttimetpADesc(tblDesc));
		this.add(getFit_sexADesc(tblDesc));
		this.add(getSamptp_codeADesc(tblDesc));
		this.add(getSamptp_nameADesc(tblDesc));
		this.add(getQunitcodeADesc(tblDesc));
		this.add(getQunitnameADesc(tblDesc));
		this.add(getColltp_codeADesc(tblDesc));
		this.add(getColltp_nameADesc(tblDesc));
		this.add(getGro_codeADesc(tblDesc));
		this.add(getGro_nameADesc(tblDesc));
		this.add(getNuit_nameADesc(tblDesc));
		this.add(getNuit_codeADesc(tblDesc));
		this.add(getSrv_nameADesc(tblDesc));
		this.add(getCode_lisrsttpADesc(tblDesc));
		this.add(getName_lisrsttpADesc(tblDesc));
		this.add(getName_contpADesc(tblDesc));
		this.add(getName_sampcoltimeADesc(tblDesc));
		this.add(getIdsampcollecttimetpADesc(tblDesc));
		this.add(getSdsampcollecttimetpADesc(tblDesc));
		this.add(getId_unittimeADesc(tblDesc));
		this.add(getLentimeADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_srvlabCDesc(tblDesc));
		tblDesc.add(getId_srvlabCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_samptpCDesc(tblDesc));
		tblDesc.add(getSd_samptpCDesc(tblDesc));
		tblDesc.add(getQuanCDesc(tblDesc));
		tblDesc.add(getId_unit_quanCDesc(tblDesc));
		tblDesc.add(getId_colltpCDesc(tblDesc));
		tblDesc.add(getSd_colltpCDesc(tblDesc));
		tblDesc.add(getDes_labsampCDesc(tblDesc));
		tblDesc.add(getId_labgroupCDesc(tblDesc));
		tblDesc.add(getSd_labgroupCDesc(tblDesc));
		tblDesc.add(getStd_hiCDesc(tblDesc));
		tblDesc.add(getStd_loCDesc(tblDesc));
		tblDesc.add(getId_unit_nuitCDesc(tblDesc));
		tblDesc.add(getNoteCDesc(tblDesc));
		tblDesc.add(getId_srvCDesc(tblDesc));
		tblDesc.add(getId_restrptlabtpCDesc(tblDesc));
		tblDesc.add(getSd_restrptlabtpCDesc(tblDesc));
		tblDesc.add(getVal_restrptlabCDesc(tblDesc));
		tblDesc.add(getId_contpCDesc(tblDesc));
		tblDesc.add(getSd_contpCDesc(tblDesc));
		tblDesc.add(getId_sampcoltimeCDesc(tblDesc));
		tblDesc.add(getLen_sampcoltimeCDesc(tblDesc));
		tblDesc.add(getId_unit_sampcoltimeCDesc(tblDesc));
		tblDesc.add(getId_sampcollecttimetpCDesc(tblDesc));
		tblDesc.add(getSd_sampcollecttimetpCDesc(tblDesc));
		tblDesc.add(getFit_sexCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 检验属性主键标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_srvlabADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_srvlab",  getId_srvlabCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("检验属性主键标识");
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
	 * 标本类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_samptpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_samptp",  getId_samptpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("标本类型");
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
	 * 标本需求量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuanADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Quan",  getQuanCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("标本需求量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 标本需求量单位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_unit_quanADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_unit_quan",  getId_unit_quanCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("标本需求量单位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 采集方法属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_colltpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_colltp",  getId_colltpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("采集方法");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 采集方法编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_colltpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_colltp",  getSd_colltpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("采集方法编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 标本说明属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDes_labsampADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Des_labsamp",  getDes_labsampCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("标本说明");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 检验分组属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_labgroupADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_labgroup",  getId_labgroupCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("检验分组");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 检验分组编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_labgroupADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_labgroup",  getSd_labgroupCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("检验分组编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 标准上限属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getStd_hiADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Std_hi",  getStd_hiCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("标准上限");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 标准下限属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getStd_loADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Std_lo",  getStd_loCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("标准下限");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 上下限单位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_unit_nuitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_unit_nuit",  getId_unit_nuitCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("上下限单位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 注意事项属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNoteADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Note",  getNoteCDesc(tblDesc), this);
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
	 * 医疗服务项目属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_srvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_srv",  getId_srvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医疗服务项目");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 检验结果值类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_restrptlabtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_restrptlabtp",  getId_restrptlabtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("检验结果值类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 检验结果值类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_restrptlabtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_restrptlabtp",  getSd_restrptlabtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("检验结果值类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 检验结果值域属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getVal_restrptlabADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Val_restrptlab",  getVal_restrptlabCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("检验结果值域");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 容器类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_contpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_contp",  getId_contpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("容器类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 容器类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_contpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_contp",  getSd_contpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("容器类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 标本采集时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_sampcoltimeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_sampcoltime",  getId_sampcoltimeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("标本采集时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 标本采集时长属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getLen_sampcoltimeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Len_sampcoltime",  getLen_sampcoltimeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("标本采集时长");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 时长单位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_unit_sampcoltimeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_unit_sampcoltime",  getId_unit_sampcoltimeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("时长单位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 标本采集时间类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_sampcollecttimetpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_sampcollecttimetp",  getId_sampcollecttimetpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("标本采集时间类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 标本采集时间类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_sampcollecttimetpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_sampcollecttimetp",  getSd_sampcollecttimetpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("标本采集时间类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 适用性别属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFit_sexADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fit_sex",  getFit_sexCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("适用性别");
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
	private IAttrDesc getSamptp_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Samptp_code",  getSamptp_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b4","id_samptp=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSamptp_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Samptp_name",  getSamptp_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b4","id_samptp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 需求量单位编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQunitcodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Qunitcode",  getQunitcodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("需求量单位编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_measdoc a1b10","id_unit_quan=id_measdoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 需求量单位名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQunitnameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Qunitname",  getQunitnameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("需求量单位名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_measdoc a1b10","id_unit_quan=id_measdoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getColltp_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Colltp_code",  getColltp_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b5","id_colltp=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getColltp_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Colltp_name",  getColltp_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b5","id_colltp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getGro_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Gro_code",  getGro_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b6","id_labgroup=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getGro_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Gro_name",  getGro_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b6","id_labgroup=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 上下限单位名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNuit_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Nuit_name",  getNuit_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("上下限单位名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_measdoc a1b7","id_unit_nuit=id_measdoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 上下限单位编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNuit_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Nuit_code",  getNuit_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("上下限单位编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_measdoc a1b7","id_unit_nuit=id_measdoc","code"});
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
		attrDesc.setRefTblInfos(new String[]{"bd_srv a1b8","id_srv=id_srv","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 检验结果类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_lisrsttpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_lisrsttp",  getCode_lisrsttpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("检验结果类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b11","id_restrptlabtp=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 检验结果类型名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_lisrsttpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_lisrsttp",  getName_lisrsttpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("检验结果类型名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b11","id_restrptlabtp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 容器类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_contpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_contp",  getName_contpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("容器类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b9","id_contp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 标本采集时间名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_sampcoltimeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_sampcoltime",  getName_sampcoltimeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("标本采集时间名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_sampcol_time a1b12","id_sampcoltime=id_sampcollecttime","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 标本采集时间类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIdsampcollecttimetpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Idsampcollecttimetp",  getIdsampcollecttimetpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("标本采集时间类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_sampcol_time a1b12","id_sampcoltime=id_sampcollecttime","id_sampcollecttimetp"});
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 标本采集时间类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSdsampcollecttimetpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sdsampcollecttimetp",  getSdsampcollecttimetpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("标本采集时间类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_sampcol_time a1b12","id_sampcoltime=id_sampcollecttime","sd_sampcollecttimetp"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 时长单位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_unittimeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_unittime",  getId_unittimeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("时长单位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_sampcol_time a1b12","id_sampcoltime=id_sampcollecttime","id_unit_time"});
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 时长属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getLentimeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Lentime",  getLentimeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("时长");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_sampcol_time a1b12","id_sampcoltime=id_sampcollecttime","len_time"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取检验属性主键标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_srvlabCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_srvlab");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("检验属性主键标识"); 
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
	 * 获取标本类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_samptpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_samptp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("标本类型"); 
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
	 * 获取标本需求量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuanCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Quan");
		column.setLength(12);
        column.setPrecision(4);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("标本需求量"); 
		return column;
	}
	/**
	 * 获取标本需求量单位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_unit_quanCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_unit_quan");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("标本需求量单位"); 
		return column;
	}
	/**
	 * 获取采集方法表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_colltpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_colltp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("采集方法"); 
		return column;
	}
	/**
	 * 获取采集方法编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_colltpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_colltp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("采集方法编码"); 
		return column;
	}
	/**
	 * 获取标本说明表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDes_labsampCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Des_labsamp");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("标本说明"); 
		return column;
	}
	/**
	 * 获取检验分组表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_labgroupCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_labgroup");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("检验分组"); 
		return column;
	}
	/**
	 * 获取检验分组编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_labgroupCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_labgroup");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("检验分组编码"); 
		return column;
	}
	/**
	 * 获取标准上限表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getStd_hiCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Std_hi");
		column.setLength(12);
        column.setPrecision(4);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("标准上限"); 
		return column;
	}
	/**
	 * 获取标准下限表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getStd_loCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Std_lo");
		column.setLength(12);
        column.setPrecision(4);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("标准下限"); 
		return column;
	}
	/**
	 * 获取上下限单位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_unit_nuitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_unit_nuit");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("上下限单位"); 
		return column;
	}
	/**
	 * 获取注意事项表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNoteCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Note");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("注意事项"); 
		return column;
	}
	/**
	 * 获取医疗服务项目表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_srvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_srv");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医疗服务项目"); 
		return column;
	}
	/**
	 * 获取检验结果值类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_restrptlabtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_restrptlabtp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("检验结果值类型"); 
		return column;
	}
	/**
	 * 获取检验结果值类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_restrptlabtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_restrptlabtp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("检验结果值类型编码"); 
		return column;
	}
	/**
	 * 获取检验结果值域表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getVal_restrptlabCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Val_restrptlab");
		column.setLength(1000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("检验结果值域"); 
		return column;
	}
	/**
	 * 获取容器类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_contpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_contp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("容器类型"); 
		return column;
	}
	/**
	 * 获取容器类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_contpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_contp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("容器类型编码"); 
		return column;
	}
	/**
	 * 获取标本采集时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_sampcoltimeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_sampcoltime");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("标本采集时间"); 
		return column;
	}
	/**
	 * 获取标本采集时长表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getLen_sampcoltimeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Len_sampcoltime");
		column.setLength(14);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("标本采集时长"); 
		return column;
	}
	/**
	 * 获取时长单位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_unit_sampcoltimeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_unit_sampcoltime");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("时长单位"); 
		return column;
	}
	/**
	 * 获取标本采集时间类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_sampcollecttimetpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_sampcollecttimetp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("标本采集时间类型"); 
		return column;
	}
	/**
	 * 获取标本采集时间类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_sampcollecttimetpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_sampcollecttimetp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("标本采集时间类型编码"); 
		return column;
	}
	/**
	 * 获取适用性别表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFit_sexCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fit_sex");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("适用性别"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSamptp_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Samptp_code");
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
	private IColumnDesc getSamptp_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Samptp_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取需求量单位编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQunitcodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Qunitcode");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("需求量单位编码"); 
		return column;
	}
	/**
	 * 获取需求量单位名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQunitnameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Qunitname");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("需求量单位名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getColltp_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Colltp_code");
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
	private IColumnDesc getColltp_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Colltp_name");
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
	private IColumnDesc getGro_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Gro_code");
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
	private IColumnDesc getGro_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Gro_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取上下限单位名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNuit_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Nuit_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("上下限单位名称"); 
		return column;
	}
	/**
	 * 获取上下限单位编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNuit_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Nuit_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("上下限单位编码"); 
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
	 * 获取检验结果类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_lisrsttpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_lisrsttp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("检验结果类型编码"); 
		return column;
	}
	/**
	 * 获取检验结果类型名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_lisrsttpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_lisrsttp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("检验结果类型名称"); 
		return column;
	}
	/**
	 * 获取容器类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_contpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_contp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("容器类型"); 
		return column;
	}
	/**
	 * 获取标本采集时间名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_sampcoltimeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_sampcoltime");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("标本采集时间名称"); 
		return column;
	}
	/**
	 * 获取标本采集时间类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIdsampcollecttimetpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Idsampcollecttimetp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("标本采集时间类型"); 
		return column;
	}
	/**
	 * 获取标本采集时间类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSdsampcollecttimetpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sdsampcollecttimetp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("标本采集时间类型编码"); 
		return column;
	}
	/**
	 * 获取时长单位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_unittimeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_unittime");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("时长单位"); 
		return column;
	}
	/**
	 * 获取时长表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getLentimeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Lentime");
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("时长"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id","Id_srvlab");
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
	}
	
}
