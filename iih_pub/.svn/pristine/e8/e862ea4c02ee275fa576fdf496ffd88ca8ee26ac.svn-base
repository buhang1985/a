
package iih.pe.phm.pehmgroup.d.desc;

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
 * 体检健康管理群体干预危险因素 DO 元数据信息
 */
public class PeHmGroupRisksDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.pe.phm.pehmgroup.d.PeHmGroupRisksDO";
	public static final String CLASS_DISPALYNAME = "体检健康管理群体干预危险因素";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "pe_hm_pehmgrouprisks";
	public static final String TABLE_ALIAS_NAME = "a2";
	public static final String PRIMARYKEY_FIELDNAME="Id_pehmgrouprisks";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public PeHmGroupRisksDODesc(){
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
		this.setKeyDesc(getId_pehmgrouprisksADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_pehmgroupADesc(tblDesc));
		this.add(getId_pehmgrouprisksADesc(tblDesc));
		this.add(getId_pehmgroupADesc(tblDesc));
		this.add(getId_riskdefADesc(tblDesc));
		this.add(getMean_originalADesc(tblDesc));
		this.add(getMean_pm_originalADesc(tblDesc));
		this.add(getMedian_originalADesc(tblDesc));
		this.add(getMean_goalADesc(tblDesc));
		this.add(getMean_pm_goalADesc(tblDesc));
		this.add(getMedian_goalADesc(tblDesc));
		this.add(getCode_riskADesc(tblDesc));
		this.add(getName_riskADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_pehmgrouprisksCDesc(tblDesc));
		tblDesc.add(getId_pehmgrouprisksCDesc(tblDesc));
		tblDesc.add(getId_pehmgroupCDesc(tblDesc));
		tblDesc.add(getId_riskdefCDesc(tblDesc));
		tblDesc.add(getMean_originalCDesc(tblDesc));
		tblDesc.add(getMean_pm_originalCDesc(tblDesc));
		tblDesc.add(getMedian_originalCDesc(tblDesc));
		tblDesc.add(getMean_goalCDesc(tblDesc));
		tblDesc.add(getMean_pm_goalCDesc(tblDesc));
		tblDesc.add(getMedian_goalCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 健康管理群体干预危险因素主键标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pehmgrouprisksADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pehmgrouprisks",  getId_pehmgrouprisksCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("健康管理群体干预危险因素主键标识");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检健康群体定义ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pehmgroupADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pehmgroup",  getId_pehmgroupCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检健康群体定义ID");
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
	 * 原平均值属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMean_originalADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mean_original",  getMean_originalCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("原平均值");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 原平均值正负属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMean_pm_originalADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mean_pm_original",  getMean_pm_originalCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("原平均值正负");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 原中位数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMedian_originalADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Median_original",  getMedian_originalCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("原中位数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 目标平均值属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMean_goalADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mean_goal",  getMean_goalCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("目标平均值");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 目标平均值正负属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMean_pm_goalADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mean_pm_goal",  getMean_pm_goalCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("目标平均值正负");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 目标中位数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMedian_goalADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Median_goal",  getMedian_goalCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("目标中位数");
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
	private IAttrDesc getCode_riskADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_risk",  getCode_riskCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_hm_riskdef a2b3","id_riskdef=id_riskdef","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_riskADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_risk",  getName_riskCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_hm_riskdef a2b3","id_riskdef=id_riskdef","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取健康管理群体干预危险因素主键标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pehmgrouprisksCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pehmgrouprisks");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("健康管理群体干预危险因素主键标识"); 
		return column;
	}
	/**
	 * 获取体检健康群体定义ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pehmgroupCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pehmgroup");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检健康群体定义ID"); 
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
	 * 获取原平均值表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMean_originalCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mean_original");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("原平均值"); 
		return column;
	}
	/**
	 * 获取原平均值正负表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMean_pm_originalCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mean_pm_original");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("原平均值正负"); 
		return column;
	}
	/**
	 * 获取原中位数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMedian_originalCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Median_original");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("原中位数"); 
		return column;
	}
	/**
	 * 获取目标平均值表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMean_goalCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mean_goal");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("目标平均值"); 
		return column;
	}
	/**
	 * 获取目标平均值正负表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMean_pm_goalCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mean_pm_goal");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("目标平均值正负"); 
		return column;
	}
	/**
	 * 获取目标中位数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMedian_goalCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Median_goal");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("目标中位数"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_riskCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_risk");
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
	private IColumnDesc getName_riskCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_risk");
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
		iBDDataInfoFldMap.put("id","Id_pehmgrouprisks");
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
