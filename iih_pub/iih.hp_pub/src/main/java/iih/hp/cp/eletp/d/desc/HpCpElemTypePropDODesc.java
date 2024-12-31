
package iih.hp.cp.eletp.d.desc;

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
 * 诊疗计划元素类型属性面板配置 DO 元数据信息
 */
public class HpCpElemTypePropDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.hp.cp.eletp.d.HpCpElemTypePropDO";
	public static final String CLASS_DISPALYNAME = "诊疗计划元素类型属性面板配置";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "HP_CP_ELETP_PPE";
	public static final String TABLE_ALIAS_NAME = "a2";
	public static final String PRIMARYKEY_FIELDNAME="Id_eletpppe";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public HpCpElemTypePropDODesc(){
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
		this.setKeyDesc(getId_eletpppeADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_eletpADesc(tblDesc));
		this.add(getId_eletpppeADesc(tblDesc));
		this.add(getId_eletpADesc(tblDesc));
		this.add(getNameADesc(tblDesc));
		this.add(getCodeADesc(tblDesc));
		this.add(getId_ppe_grpADesc(tblDesc));
		this.add(getSd_ppe_grpADesc(tblDesc));
		this.add(getSerialnoADesc(tblDesc));
		this.add(getEu_ctrl_tpADesc(tblDesc));
		this.add(getDefault_valADesc(tblDesc));
		this.add(getRefcodeADesc(tblDesc));
		this.add(getReffilterADesc(tblDesc));
		this.add(getRef_save_colADesc(tblDesc));
		this.add(getFg_ref_multiADesc(tblDesc));
		this.add(getFg_editableADesc(tblDesc));
		this.add(getFg_requiredADesc(tblDesc));
		this.add(getDataobjADesc(tblDesc));
		this.add(getDoppeADesc(tblDesc));
		this.add(getId_valchk_tpADesc(tblDesc));
		this.add(getSd_valchk_tpADesc(tblDesc));
		this.add(getDesADesc(tblDesc));
		this.add(getName_ppe_grpADesc(tblDesc));
		this.add(getSeqnoADesc(tblDesc));
		this.add(getName_valchk_tpADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_eletpppeCDesc(tblDesc));
		tblDesc.add(getId_eletpppeCDesc(tblDesc));
		tblDesc.add(getId_eletpCDesc(tblDesc));
		tblDesc.add(getNameCDesc(tblDesc));
		tblDesc.add(getCodeCDesc(tblDesc));
		tblDesc.add(getId_ppe_grpCDesc(tblDesc));
		tblDesc.add(getSd_ppe_grpCDesc(tblDesc));
		tblDesc.add(getSerialnoCDesc(tblDesc));
		tblDesc.add(getEu_ctrl_tpCDesc(tblDesc));
		tblDesc.add(getDefault_valCDesc(tblDesc));
		tblDesc.add(getRefcodeCDesc(tblDesc));
		tblDesc.add(getReffilterCDesc(tblDesc));
		tblDesc.add(getRef_save_colCDesc(tblDesc));
		tblDesc.add(getFg_ref_multiCDesc(tblDesc));
		tblDesc.add(getFg_editableCDesc(tblDesc));
		tblDesc.add(getFg_requiredCDesc(tblDesc));
		tblDesc.add(getDataobjCDesc(tblDesc));
		tblDesc.add(getDoppeCDesc(tblDesc));
		tblDesc.add(getId_valchk_tpCDesc(tblDesc));
		tblDesc.add(getSd_valchk_tpCDesc(tblDesc));
		tblDesc.add(getDesCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 元素类型属性ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_eletpppeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_eletpppe",  getId_eletpppeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("元素类型属性ID");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 元素类型ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_eletpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_eletp",  getId_eletpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("元素类型ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 属性名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name",  getNameCDesc(tblDesc), this);
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
	 * 属性编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code",  getCodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("属性编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 属性分组ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ppe_grpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ppe_grp",  getId_ppe_grpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("属性分组ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 属性分组编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_ppe_grpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_ppe_grp",  getSd_ppe_grpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("属性分组编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 属性组内序号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSerialnoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Serialno",  getSerialnoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("属性组内序号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 属性编辑类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_ctrl_tpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_ctrl_tp",  getEu_ctrl_tpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("属性编辑类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 属性默认值属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDefault_valADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Default_val",  getDefault_valCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("属性默认值");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 参照编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRefcodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Refcode",  getRefcodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("参照编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 参照过滤器属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getReffilterADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Reffilter",  getReffilterCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("参照过滤器");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 参照储存列名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRef_save_colADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ref_save_col",  getRef_save_colCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("参照储存列名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 参照是否支持多选属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_ref_multiADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_ref_multi",  getFg_ref_multiCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("参照是否支持多选");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否可编辑属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_editableADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_editable",  getFg_editableCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否可编辑");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否必填属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_requiredADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_required",  getFg_requiredCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否必填");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * DO路径属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDataobjADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dataobj",  getDataobjCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("DO路径");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * DO属性属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDoppeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Doppe",  getDoppeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("DO属性");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 属性值检查类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_valchk_tpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_valchk_tp",  getId_valchk_tpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("属性值检查类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 属性值检查类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_valchk_tpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_valchk_tp",  getSd_valchk_tpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("属性值检查类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 描述属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Des",  getDesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("描述");
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
	private IAttrDesc getName_ppe_grpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_ppe_grp",  getName_ppe_grpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a2b3","id_ppe_grp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 排序字段属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSeqnoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Seqno",  getSeqnoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("排序字段");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a2b3","id_ppe_grp=id_udidoc","seqno"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 值检查类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_valchk_tpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_valchk_tp",  getName_valchk_tpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("值检查类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a2b4","id_valchk_tp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取元素类型属性ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_eletpppeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_eletpppe");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("元素类型属性ID"); 
		return column;
	}
	/**
	 * 获取元素类型ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_eletpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_eletp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("元素类型ID"); 
		return column;
	}
	/**
	 * 获取属性名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("属性名称"); 
		return column;
	}
	/**
	 * 获取属性编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("属性编码"); 
		return column;
	}
	/**
	 * 获取属性分组ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ppe_grpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ppe_grp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("属性分组ID"); 
		return column;
	}
	/**
	 * 获取属性分组编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_ppe_grpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_ppe_grp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("属性分组编码"); 
		return column;
	}
	/**
	 * 获取属性组内序号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSerialnoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Serialno");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("属性组内序号"); 
		return column;
	}
	/**
	 * 获取属性编辑类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_ctrl_tpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_ctrl_tp");
		column.setLength(20);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("属性编辑类型"); 
		return column;
	}
	/**
	 * 获取属性默认值表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDefault_valCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Default_val");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("属性默认值"); 
		return column;
	}
	/**
	 * 获取参照编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRefcodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Refcode");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("参照编码"); 
		return column;
	}
	/**
	 * 获取参照过滤器表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getReffilterCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Reffilter");
		column.setLength(2000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("参照过滤器"); 
		return column;
	}
	/**
	 * 获取参照储存列名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRef_save_colCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ref_save_col");
		column.setLength(2000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("参照储存列名"); 
		return column;
	}
	/**
	 * 获取参照是否支持多选表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_ref_multiCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_ref_multi");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("参照是否支持多选"); 
		return column;
	}
	/**
	 * 获取是否可编辑表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_editableCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_editable");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否可编辑"); 
		return column;
	}
	/**
	 * 获取是否必填表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_requiredCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_required");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否必填"); 
		return column;
	}
	/**
	 * 获取DO路径表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDataobjCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dataobj");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("DO路径"); 
		return column;
	}
	/**
	 * 获取DO属性表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDoppeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Doppe");
		column.setLength(2000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("DO属性"); 
		return column;
	}
	/**
	 * 获取属性值检查类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_valchk_tpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_valchk_tp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("属性值检查类型"); 
		return column;
	}
	/**
	 * 获取属性值检查类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_valchk_tpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_valchk_tp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("属性值检查类型编码"); 
		return column;
	}
	/**
	 * 获取描述表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Des");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("描述"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_ppe_grpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_ppe_grp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取排序字段表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSeqnoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Seqno");
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("排序字段"); 
		return column;
	}
	/**
	 * 获取值检查类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_valchk_tpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_valchk_tp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("值检查类型"); 
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
	}
	
}
