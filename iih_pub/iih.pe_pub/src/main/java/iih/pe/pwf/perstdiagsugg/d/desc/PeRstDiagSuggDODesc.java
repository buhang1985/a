
package iih.pe.pwf.perstdiagsugg.d.desc;

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
 * 体检结果诊断建议 DO 元数据信息
 */
public class PeRstDiagSuggDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.pe.pwf.perstdiagsugg.d.PeRstDiagSuggDO";
	public static final String CLASS_DISPALYNAME = "体检结果诊断建议";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "pe_wf_perstdiagsugg";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_perstdiagsugg";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public PeRstDiagSuggDODesc(){
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
		this.setKeyDesc(getId_perstdiagsuggADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_perstdiagsuggADesc(tblDesc));
		this.add(getId_pepsnapptADesc(tblDesc));
		this.add(getId_perstADesc(tblDesc));
		this.add(getId_pesrvitemADesc(tblDesc));
		this.add(getSortnoADesc(tblDesc));
		this.add(getDiagADesc(tblDesc));
		this.add(getSuggADesc(tblDesc));
		this.add(getFg_recheckADesc(tblDesc));
		this.add(getFollowupADesc(tblDesc));
		this.add(getFg_ovalADesc(tblDesc));
		this.add(getFg_doubtADesc(tblDesc));
		this.add(getFg_transADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getId_perstdidefADesc(tblDesc));
		this.add(getId_pedeptsetADesc(tblDesc));
		this.add(getFg_urgencyADesc(tblDesc));
		this.add(getRecheckperiodADesc(tblDesc));
		this.add(getRecheckperiodunitADesc(tblDesc));
		this.add(getId_perstsumADesc(tblDesc));
		this.add(getFg_highriskADesc(tblDesc));
		this.add(getName_diADesc(tblDesc));
		this.add(getAdvice_diADesc(tblDesc));
		this.add(getCode_depADesc(tblDesc));
		this.add(getName_depADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_perstdiagsuggCDesc(tblDesc));
		tblDesc.add(getId_perstdiagsuggCDesc(tblDesc));
		tblDesc.add(getId_pepsnapptCDesc(tblDesc));
		tblDesc.add(getId_perstCDesc(tblDesc));
		tblDesc.add(getId_pesrvitemCDesc(tblDesc));
		tblDesc.add(getSortnoCDesc(tblDesc));
		tblDesc.add(getDiagCDesc(tblDesc));
		tblDesc.add(getSuggCDesc(tblDesc));
		tblDesc.add(getFg_recheckCDesc(tblDesc));
		tblDesc.add(getFollowupCDesc(tblDesc));
		tblDesc.add(getFg_ovalCDesc(tblDesc));
		tblDesc.add(getFg_doubtCDesc(tblDesc));
		tblDesc.add(getFg_transCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		tblDesc.add(getId_perstdidefCDesc(tblDesc));
		tblDesc.add(getId_pedeptsetCDesc(tblDesc));
		tblDesc.add(getFg_urgencyCDesc(tblDesc));
		tblDesc.add(getRecheckperiodCDesc(tblDesc));
		tblDesc.add(getRecheckperiodunitCDesc(tblDesc));
		tblDesc.add(getId_perstsumCDesc(tblDesc));
		tblDesc.add(getFg_highriskCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 体检结果诊断建议主键标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_perstdiagsuggADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_perstdiagsugg",  getId_perstdiagsuggCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检结果诊断建议主键标识");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检预约单ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pepsnapptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pepsnappt",  getId_pepsnapptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检预约单ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检结果业务ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_perstADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_perst",  getId_perstCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检结果业务ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检结果ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pesrvitemADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pesrvitem",  getId_pesrvitemCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检结果ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检诊断序号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSortnoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sortno",  getSortnoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("体检诊断序号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检诊断内容属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDiagADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Diag",  getDiagCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检诊断内容");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检建议内容属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSuggADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sugg",  getSuggCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检建议内容");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 复查标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_recheckADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_recheck",  getFg_recheckCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("复查标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 追踪标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFollowupADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Followup",  getFollowupCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("追踪标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 总检标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_ovalADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_oval",  getFg_ovalCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("总检标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 可疑标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_doubtADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_doubt",  getFg_doubtCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("可疑标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 传送总检标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_transADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_trans",  getFg_transCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("传送总检标识");
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
	 * 体检诊断ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_perstdidefADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_perstdidef",  getId_perstdidefCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检诊断ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 所属科室ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pedeptsetADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pedeptset",  getId_pedeptsetCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("所属科室ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 紧急标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_urgencyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_urgency",  getFg_urgencyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("紧急标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 复查周期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRecheckperiodADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Recheckperiod",  getRecheckperiodCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("复查周期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 复查周期单位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRecheckperiodunitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Recheckperiodunit",  getRecheckperiodunitCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("复查周期单位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检异常汇总表ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_perstsumADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_perstsum",  getId_perstsumCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检异常汇总表ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 高危标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_highriskADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_highrisk",  getFg_highriskCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("高危标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊断名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_diADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_di",  getName_diCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_itm_perstdidef a0b4","id_perstdidef=id_perstdidef","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 直连建议属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAdvice_diADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Advice_di",  getAdvice_diCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("直连建议");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_itm_perstdidef a0b4","id_perstdidef=id_perstdidef","advice"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检科室编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_depADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_dep",  getCode_depCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检科室编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_bd_deptset a0b5","id_pedeptset=id_pedeptset","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检科室名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_depADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dep",  getName_depCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检科室名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_bd_deptset a0b5","id_pedeptset=id_pedeptset","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取体检结果诊断建议主键标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_perstdiagsuggCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_perstdiagsugg");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("体检结果诊断建议主键标识"); 
		return column;
	}
	/**
	 * 获取体检预约单ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pepsnapptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pepsnappt");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检预约单ID"); 
		return column;
	}
	/**
	 * 获取体检结果业务ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_perstCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_perst");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检结果业务ID"); 
		return column;
	}
	/**
	 * 获取体检结果ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pesrvitemCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pesrvitem");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检结果ID"); 
		return column;
	}
	/**
	 * 获取体检诊断序号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSortnoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sortno");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("体检诊断序号"); 
		return column;
	}
	/**
	 * 获取体检诊断内容表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDiagCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Diag");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检诊断内容"); 
		return column;
	}
	/**
	 * 获取体检建议内容表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSuggCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sugg");
		column.setLength(1000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检建议内容"); 
		return column;
	}
	/**
	 * 获取复查标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_recheckCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_recheck");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("复查标识"); 
		return column;
	}
	/**
	 * 获取追踪标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFollowupCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Followup");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("追踪标识"); 
		return column;
	}
	/**
	 * 获取总检标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_ovalCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_oval");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("总检标识"); 
		return column;
	}
	/**
	 * 获取可疑标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_doubtCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_doubt");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("可疑标识"); 
		return column;
	}
	/**
	 * 获取传送总检标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_transCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_trans");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("传送总检标识"); 
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
	 * 获取体检诊断ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_perstdidefCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_perstdidef");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检诊断ID"); 
		return column;
	}
	/**
	 * 获取所属科室ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pedeptsetCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pedeptset");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("所属科室ID"); 
		return column;
	}
	/**
	 * 获取紧急标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_urgencyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_urgency");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("紧急标识"); 
		return column;
	}
	/**
	 * 获取复查周期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRecheckperiodCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Recheckperiod");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("复查周期"); 
		return column;
	}
	/**
	 * 获取复查周期单位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRecheckperiodunitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Recheckperiodunit");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("复查周期单位"); 
		return column;
	}
	/**
	 * 获取体检异常汇总表ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_perstsumCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_perstsum");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检异常汇总表ID"); 
		return column;
	}
	/**
	 * 获取高危标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_highriskCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_highrisk");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("高危标识"); 
		return column;
	}
	/**
	 * 获取诊断名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_diCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_di");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断名称"); 
		return column;
	}
	/**
	 * 获取直连建议表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAdvice_diCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Advice_di");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("直连建议"); 
		return column;
	}
	/**
	 * 获取体检科室编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_depCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_dep");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检科室编码"); 
		return column;
	}
	/**
	 * 获取体检科室名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_depCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dep");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检科室名称"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id","Id_perstdiagsugg");
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
