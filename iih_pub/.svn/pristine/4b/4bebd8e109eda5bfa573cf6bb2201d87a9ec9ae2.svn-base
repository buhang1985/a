
package iih.nm.nqm.nmnqmcstmpl.d.desc;

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
 * 护理管理_模板指标 DO 元数据信息
 */
public class NmnqmtmplitmDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.nm.nqm.nmnqmcstmpl.d.NmnqmtmplitmDO";
	public static final String CLASS_DISPALYNAME = "护理管理_模板指标";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "NM_NQM_TMPLITM";
	public static final String TABLE_ALIAS_NAME = "a1";
	public static final String PRIMARYKEY_FIELDNAME="Id_nqm_tmpl_itm";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public NmnqmtmplitmDODesc(){
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
		this.setKeyDesc(getId_nqm_tmpl_itmADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_nqm_tmplADesc(tblDesc));
		this.add(getId_nqm_tmpl_itmADesc(tblDesc));
		this.add(getId_nqm_csADesc(tblDesc));
		this.add(getId_nqm_kpiADesc(tblDesc));
		this.add(getId_nqm_kpi_parADesc(tblDesc));
		this.add(getId_nqm_tmplADesc(tblDesc));
		this.add(getName_nqm_kpiADesc(tblDesc));
		this.add(getValue_nqm_valueADesc(tblDesc));
		this.add(getWi_nqm_valueADesc(tblDesc));
		this.add(getFg_mustkpiADesc(tblDesc));
		this.add(getCode_nqm_kpiADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_nqm_tmpl_itmCDesc(tblDesc));
		tblDesc.add(getId_nqm_tmpl_itmCDesc(tblDesc));
		tblDesc.add(getId_nqm_csCDesc(tblDesc));
		tblDesc.add(getId_nqm_kpiCDesc(tblDesc));
		tblDesc.add(getId_nqm_kpi_parCDesc(tblDesc));
		tblDesc.add(getId_nqm_tmplCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 检查标准模板id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_nqm_tmpl_itmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_nqm_tmpl_itm",  getId_nqm_tmpl_itmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("检查标准模板id");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 检查标准属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_nqm_csADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_nqm_cs",  getId_nqm_csCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("检查标准");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 检查指标属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_nqm_kpiADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_nqm_kpi",  getId_nqm_kpiCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("检查指标");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 父级指标属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_nqm_kpi_parADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_nqm_kpi_par",  getId_nqm_kpi_parCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("父级指标");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 检查标准模板属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_nqm_tmplADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_nqm_tmpl",  getId_nqm_tmplCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("检查标准模板");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 指标名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_nqm_kpiADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_nqm_kpi",  getName_nqm_kpiCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("指标名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"NM_NQM_KPI a1b3","id_nqm_kpi=id_nqm_kpi","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 指标分值属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getValue_nqm_valueADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Value_nqm_value",  getValue_nqm_valueCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("指标分值");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"NM_NQM_KPI a1b3","id_nqm_kpi=id_nqm_kpi","value"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 指标权重属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWi_nqm_valueADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Wi_nqm_value",  getWi_nqm_valueCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("指标权重");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"NM_NQM_KPI a1b3","id_nqm_kpi=id_nqm_kpi","wi"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否为必要指标属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_mustkpiADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_mustkpi",  getFg_mustkpiCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否为必要指标");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"NM_NQM_KPI a1b3","id_nqm_kpi=id_nqm_kpi","fg_mustkpi"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 指标编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_nqm_kpiADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_nqm_kpi",  getCode_nqm_kpiCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("指标编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"NM_NQM_KPI a1b3","id_nqm_kpi=id_nqm_kpi","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取检查标准模板id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_nqm_tmpl_itmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_nqm_tmpl_itm");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("检查标准模板id"); 
		return column;
	}
	/**
	 * 获取检查标准表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_nqm_csCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_nqm_cs");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("检查标准"); 
		return column;
	}
	/**
	 * 获取检查指标表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_nqm_kpiCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_nqm_kpi");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("检查指标"); 
		return column;
	}
	/**
	 * 获取父级指标表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_nqm_kpi_parCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_nqm_kpi_par");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("父级指标"); 
		return column;
	}
	/**
	 * 获取检查标准模板表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_nqm_tmplCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_nqm_tmpl");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("检查标准模板"); 
		return column;
	}
	/**
	 * 获取指标名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_nqm_kpiCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_nqm_kpi");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("指标名称"); 
		return column;
	}
	/**
	 * 获取指标分值表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getValue_nqm_valueCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Value_nqm_value");
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("指标分值"); 
		return column;
	}
	/**
	 * 获取指标权重表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWi_nqm_valueCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Wi_nqm_value");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("指标权重"); 
		return column;
	}
	/**
	 * 获取是否为必要指标表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_mustkpiCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_mustkpi");
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否为必要指标"); 
		return column;
	}
	/**
	 * 获取指标编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_nqm_kpiCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_nqm_kpi");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("指标编码"); 
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
