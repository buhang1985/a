
package iih.mp.mpbd.mpskd.d.desc;

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
 * 护理文书 DO 元数据信息
 */
public class MpSkdNmrDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.mp.mpbd.mpskd.d.MpSkdNmrDO";
	public static final String CLASS_DISPALYNAME = "护理文书";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "mp_skd_nmr";
	public static final String TABLE_ALIAS_NAME = "a3";
	public static final String PRIMARYKEY_FIELDNAME="Id_skd_nmr";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public MpSkdNmrDODesc(){
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
		this.setKeyDesc(getId_skd_nmrADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_skdADesc(tblDesc));
		this.add(getId_skd_nmrADesc(tblDesc));
		this.add(getId_skdADesc(tblDesc));
		this.add(getId_nmr_docADesc(tblDesc));
		this.add(getId_deADesc(tblDesc));
		this.add(getValADesc(tblDesc));
		this.add(getFg_mininADesc(tblDesc));
		this.add(getVal_minADesc(tblDesc));
		this.add(getVal_maxADesc(tblDesc));
		this.add(getFg_maxinADesc(tblDesc));
		this.add(getFieldnameADesc(tblDesc));
		this.add(getId_enstatetpADesc(tblDesc));
		this.add(getSd_enstatetpADesc(tblDesc));
		this.add(getId_enstateADesc(tblDesc));
		this.add(getId_evalu_timeADesc(tblDesc));
		this.add(getEvalunameADesc(tblDesc));
		this.add(getDef1ADesc(tblDesc));
		this.add(getDef2ADesc(tblDesc));
		this.add(getDef3ADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getValtypeADesc(tblDesc));
		this.add(getName_skdADesc(tblDesc));
		this.add(getName_nmr_docADesc(tblDesc));
		this.add(getId_set_nmr_docADesc(tblDesc));
		this.add(getName_deADesc(tblDesc));
		this.add(getName_enstatetpADesc(tblDesc));
		this.add(getName_enstateADesc(tblDesc));
		this.add(getName_evalu_timeADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_skd_nmrCDesc(tblDesc));
		tblDesc.add(getId_skd_nmrCDesc(tblDesc));
		tblDesc.add(getId_skdCDesc(tblDesc));
		tblDesc.add(getId_nmr_docCDesc(tblDesc));
		tblDesc.add(getId_deCDesc(tblDesc));
		tblDesc.add(getValCDesc(tblDesc));
		tblDesc.add(getFg_mininCDesc(tblDesc));
		tblDesc.add(getVal_minCDesc(tblDesc));
		tblDesc.add(getVal_maxCDesc(tblDesc));
		tblDesc.add(getFg_maxinCDesc(tblDesc));
		tblDesc.add(getFieldnameCDesc(tblDesc));
		tblDesc.add(getId_enstatetpCDesc(tblDesc));
		tblDesc.add(getSd_enstatetpCDesc(tblDesc));
		tblDesc.add(getId_enstateCDesc(tblDesc));
		tblDesc.add(getId_evalu_timeCDesc(tblDesc));
		tblDesc.add(getEvalunameCDesc(tblDesc));
		tblDesc.add(getDef1CDesc(tblDesc));
		tblDesc.add(getDef2CDesc(tblDesc));
		tblDesc.add(getDef3CDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		tblDesc.add(getValtypeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 文书规则属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_skd_nmrADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_skd_nmr",  getId_skd_nmrCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("文书规则");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 护理任务属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_skdADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_skd",  getId_skdCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("护理任务");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 护理文书属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_nmr_docADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_nmr_doc",  getId_nmr_docCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("护理文书");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 数据元属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_deADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_de",  getId_deCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("数据元");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 文本值属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getValADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Val",  getValCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("文本值");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 最小值包含属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_mininADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_minin",  getFg_mininCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("最小值包含");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 最小值属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getVal_minADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Val_min",  getVal_minCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("最小值");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 最大值属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getVal_maxADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Val_max",  getVal_maxCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("最大值");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 最大值包含属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_maxinADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_maxin",  getFg_maxinCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("最大值包含");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 属性名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFieldnameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fieldname",  getFieldnameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("属性名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 就诊状况类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_enstatetpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_enstatetp",  getId_enstatetpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("就诊状况类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 就诊状况类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_enstatetpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_enstatetp",  getSd_enstatetpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("就诊状况类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 就诊状况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_enstateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_enstate",  getId_enstateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("就诊状况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 评估时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_evalu_timeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_evalu_time",  getId_evalu_timeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("评估时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 评估时间字段属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEvalunameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Evaluname",  getEvalunameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("评估时间字段");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 扩展字段1属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef1ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def1",  getDef1CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("扩展字段1");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 扩展字段2属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef2ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def2",  getDef2CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("扩展字段2");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 扩展字段3属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef3ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def3",  getDef3CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("扩展字段3");
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
	 * 值类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getValtypeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Valtype",  getValtypeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("值类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 护理任务属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_skdADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_skd",  getName_skdCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("护理任务");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"mp_skd a3b2","id_skd=id_skd","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 护理文书属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_nmr_docADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_nmr_doc",  getName_nmr_docCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("护理文书");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"NMR_DOC a3b3","id_nmr_doc=id_nmr_doc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 护理文书数据集属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_set_nmr_docADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_set_nmr_doc",  getId_set_nmr_docCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("护理文书数据集");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"NMR_DOC a3b3","id_nmr_doc=id_nmr_doc","id_set"});
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 数据元名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_deADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_de",  getName_deCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("数据元名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_de a3b4","id_de=id_de","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 就诊状况类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_enstatetpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_enstatetp",  getName_enstatetpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("就诊状况类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a3b7","id_enstatetp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 就诊状况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_enstateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_enstate",  getName_enstateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("就诊状况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_en_state a3b8","id_enstate=id_enstate","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 评估时间字段属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_evalu_timeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_evalu_time",  getName_evalu_timeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("评估时间字段");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_de a3b9","id_evalu_time=id_de","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取文书规则表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_skd_nmrCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_skd_nmr");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("文书规则"); 
		return column;
	}
	/**
	 * 获取护理任务表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_skdCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_skd");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("护理任务"); 
		return column;
	}
	/**
	 * 获取护理文书表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_nmr_docCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_nmr_doc");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("护理文书"); 
		return column;
	}
	/**
	 * 获取数据元表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_deCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_de");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("数据元"); 
		return column;
	}
	/**
	 * 获取文本值表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getValCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Val");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("文本值"); 
		return column;
	}
	/**
	 * 获取最小值包含表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_mininCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_minin");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("最小值包含"); 
		return column;
	}
	/**
	 * 获取最小值表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getVal_minCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Val_min");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("最小值"); 
		return column;
	}
	/**
	 * 获取最大值表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getVal_maxCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Val_max");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("最大值"); 
		return column;
	}
	/**
	 * 获取最大值包含表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_maxinCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_maxin");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("最大值包含"); 
		return column;
	}
	/**
	 * 获取属性名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFieldnameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fieldname");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("属性名称"); 
		return column;
	}
	/**
	 * 获取就诊状况类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_enstatetpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_enstatetp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊状况类型"); 
		return column;
	}
	/**
	 * 获取就诊状况类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_enstatetpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_enstatetp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊状况类型编码"); 
		return column;
	}
	/**
	 * 获取就诊状况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_enstateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_enstate");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊状况"); 
		return column;
	}
	/**
	 * 获取评估时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_evalu_timeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_evalu_time");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("评估时间"); 
		return column;
	}
	/**
	 * 获取评估时间字段表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEvalunameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Evaluname");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("评估时间字段"); 
		return column;
	}
	/**
	 * 获取扩展字段1表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef1CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def1");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("扩展字段1"); 
		return column;
	}
	/**
	 * 获取扩展字段2表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef2CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def2");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("扩展字段2"); 
		return column;
	}
	/**
	 * 获取扩展字段3表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef3CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def3");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("扩展字段3"); 
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
	 * 获取值类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getValtypeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Valtype");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("值类型"); 
		return column;
	}
	/**
	 * 获取护理任务表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_skdCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_skd");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("护理任务"); 
		return column;
	}
	/**
	 * 获取护理文书表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_nmr_docCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_nmr_doc");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("护理文书"); 
		return column;
	}
	/**
	 * 获取护理文书数据集表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_set_nmr_docCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_set_nmr_doc");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("护理文书数据集"); 
		return column;
	}
	/**
	 * 获取数据元名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_deCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_de");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("数据元名称"); 
		return column;
	}
	/**
	 * 获取就诊状况类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_enstatetpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_enstatetp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊状况类型"); 
		return column;
	}
	/**
	 * 获取就诊状况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_enstateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_enstate");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊状况"); 
		return column;
	}
	/**
	 * 获取评估时间字段表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_evalu_timeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_evalu_time");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("评估时间字段"); 
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
