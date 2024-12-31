
package iih.pe.phm.peinterveneplan.d.desc;

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
 * 健康危险因素干预个人计划 DO 元数据信息
 */
public class PeIntervenePlanRiskDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.pe.phm.peinterveneplan.d.PeIntervenePlanRiskDO";
	public static final String CLASS_DISPALYNAME = "健康危险因素干预个人计划";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "pe_hm_peinterveneplanrisk";
	public static final String TABLE_ALIAS_NAME = "a1";
	public static final String PRIMARYKEY_FIELDNAME="Id_peinterveneplanrisk";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public PeIntervenePlanRiskDODesc(){
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
		this.setKeyDesc(getId_peinterveneplanriskADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_peinterveneplanADesc(tblDesc));
		this.add(getId_peinterveneplanriskADesc(tblDesc));
		this.add(getId_peinterveneplanADesc(tblDesc));
		this.add(getId_perstrisksADesc(tblDesc));
		this.add(getId_riskdefADesc(tblDesc));
		this.add(getRst_goalADesc(tblDesc));
		this.add(getRst_interveneADesc(tblDesc));
		this.add(getIntervenetpADesc(tblDesc));
		this.add(getRst_riskADesc(tblDesc));
		this.add(getFg_posi_riskADesc(tblDesc));
		this.add(getMark_posi_riskADesc(tblDesc));
		this.add(getCode_riskdefADesc(tblDesc));
		this.add(getName_riskdefADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_peinterveneplanriskCDesc(tblDesc));
		tblDesc.add(getId_peinterveneplanriskCDesc(tblDesc));
		tblDesc.add(getId_peinterveneplanCDesc(tblDesc));
		tblDesc.add(getId_perstrisksCDesc(tblDesc));
		tblDesc.add(getId_riskdefCDesc(tblDesc));
		tblDesc.add(getRst_goalCDesc(tblDesc));
		tblDesc.add(getRst_interveneCDesc(tblDesc));
		tblDesc.add(getIntervenetpCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 健康干预个人计划危险因素主键标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_peinterveneplanriskADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_peinterveneplanrisk",  getId_peinterveneplanriskCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("健康干预个人计划危险因素主键标识");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 健康干预个人计划ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_peinterveneplanADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_peinterveneplan",  getId_peinterveneplanCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("健康干预个人计划ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 健康危险因素汇总ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_perstrisksADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_perstrisks",  getId_perstrisksCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("健康危险因素汇总ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 危险因素ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_riskdefADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_riskdef",  getId_riskdefCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("危险因素ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 干预目标属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRst_goalADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Rst_goal",  getRst_goalCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("干预目标");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 实际干预结果属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRst_interveneADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Rst_intervene",  getRst_interveneCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("实际干预结果");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 干预结果分类属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIntervenetpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Intervenetp",  getIntervenetpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("干预结果分类");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 结果属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRst_riskADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Rst_risk",  getRst_riskCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("结果");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_hm_perstrisks a1b3","id_perstrisks=id_perstrisks","rst"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 阳性标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_posi_riskADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_posi_risk",  getFg_posi_riskCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("阳性标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_hm_perstrisks a1b3","id_perstrisks=id_perstrisks","fg_posi"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 阳性符号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMark_posi_riskADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mark_posi_risk",  getMark_posi_riskCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("阳性符号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_hm_perstrisks a1b3","id_perstrisks=id_perstrisks","mark_posi"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_riskdefADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_riskdef",  getCode_riskdefCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_hm_riskdef a1b4","id_riskdef=id_riskdef","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_riskdefADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_riskdef",  getName_riskdefCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_hm_riskdef a1b4","id_riskdef=id_riskdef","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取健康干预个人计划危险因素主键标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_peinterveneplanriskCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_peinterveneplanrisk");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("健康干预个人计划危险因素主键标识"); 
		return column;
	}
	/**
	 * 获取健康干预个人计划ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_peinterveneplanCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_peinterveneplan");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("健康干预个人计划ID"); 
		return column;
	}
	/**
	 * 获取健康危险因素汇总ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_perstrisksCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_perstrisks");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("健康危险因素汇总ID"); 
		return column;
	}
	/**
	 * 获取危险因素ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_riskdefCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_riskdef");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("危险因素ID"); 
		return column;
	}
	/**
	 * 获取干预目标表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRst_goalCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Rst_goal");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("干预目标"); 
		return column;
	}
	/**
	 * 获取实际干预结果表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRst_interveneCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Rst_intervene");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("实际干预结果"); 
		return column;
	}
	/**
	 * 获取干预结果分类表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIntervenetpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Intervenetp");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("干预结果分类"); 
		return column;
	}
	/**
	 * 获取结果表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRst_riskCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Rst_risk");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("结果"); 
		return column;
	}
	/**
	 * 获取阳性标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_posi_riskCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_posi_risk");
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("阳性标识"); 
		return column;
	}
	/**
	 * 获取阳性符号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMark_posi_riskCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mark_posi_risk");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("阳性符号"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_riskdefCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_riskdef");
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
	private IColumnDesc getName_riskdefCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_riskdef");
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
		iBDDataInfoFldMap.put("id","Id_peinterveneplanrisk");
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
