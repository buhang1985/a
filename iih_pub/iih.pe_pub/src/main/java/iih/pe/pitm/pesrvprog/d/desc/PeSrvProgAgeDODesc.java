
package iih.pe.pitm.pesrvprog.d.desc;

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
 * 体检方案年龄定义 DO 元数据信息
 */
public class PeSrvProgAgeDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.pe.pitm.pesrvprog.d.PeSrvProgAgeDO";
	public static final String CLASS_DISPALYNAME = "体检方案年龄定义";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "pe_itm_pesrvprogage";
	public static final String TABLE_ALIAS_NAME = "a1";
	public static final String PRIMARYKEY_FIELDNAME="Id_pesrvprogage";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public PeSrvProgAgeDODesc(){
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
		this.setKeyDesc(getId_pesrvprogageADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_pesrvprogADesc(tblDesc));
		this.add(getId_pesrvprogageADesc(tblDesc));
		this.add(getId_pesrvprogADesc(tblDesc));
		this.add(getAge_beginADesc(tblDesc));
		this.add(getAge_endADesc(tblDesc));
		this.add(getCheck_freqADesc(tblDesc));
		this.add(getExperts_rangeADesc(tblDesc));
		this.add(getYear_freq_minADesc(tblDesc));
		this.add(getYear_freq_maxADesc(tblDesc));
		this.add(new DsAttr(dsColumn,this));
		this.add(new SvAttr(svColumn,this));
		
	}
		
	/**
	 * 获得表元数据
	 * @return
	 */
	private ITableDesc getTableDesc(){
		TableDesc tblDesc=new TableDesc(TABLE_NAME,TABLE_ALIAS_NAME);
		tblDesc.setLabel(CLASS_DISPALYNAME);
		tblDesc.setPrimaryKey(getId_pesrvprogageCDesc(tblDesc));
		tblDesc.add(getId_pesrvprogageCDesc(tblDesc));
		tblDesc.add(getId_pesrvprogCDesc(tblDesc));
		tblDesc.add(getAge_beginCDesc(tblDesc));
		tblDesc.add(getAge_endCDesc(tblDesc));
		tblDesc.add(getCheck_freqCDesc(tblDesc));
		tblDesc.add(getExperts_rangeCDesc(tblDesc));
		tblDesc.add(getYear_freq_minCDesc(tblDesc));
		tblDesc.add(getYear_freq_maxCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 体检方案年龄定义主键标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pesrvprogageADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pesrvprogage",  getId_pesrvprogageCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检方案年龄定义主键标识");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检方案定义ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pesrvprogADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pesrvprog",  getId_pesrvprogCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检方案定义ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 开始年龄属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAge_beginADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Age_begin",  getAge_beginCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("开始年龄");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 截止年龄属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAge_endADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Age_end",  getAge_endCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("截止年龄");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 检查频率描述属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCheck_freqADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Check_freq",  getCheck_freqCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("检查频率描述");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 专家推荐分类属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getExperts_rangeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Experts_range",  getExperts_rangeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("专家推荐分类");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 最小周期-年属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getYear_freq_minADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Year_freq_min",  getYear_freq_minCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("最小周期-年");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 最大周期-年属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getYear_freq_maxADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Year_freq_max",  getYear_freq_maxCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("最大周期-年");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取体检方案年龄定义主键标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pesrvprogageCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pesrvprogage");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("体检方案年龄定义主键标识"); 
		return column;
	}
	/**
	 * 获取体检方案定义ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pesrvprogCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pesrvprog");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检方案定义ID"); 
		return column;
	}
	/**
	 * 获取开始年龄表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAge_beginCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Age_begin");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("开始年龄"); 
		return column;
	}
	/**
	 * 获取截止年龄表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAge_endCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Age_end");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("截止年龄"); 
		return column;
	}
	/**
	 * 获取检查频率描述表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCheck_freqCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Check_freq");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("检查频率描述"); 
		return column;
	}
	/**
	 * 获取专家推荐分类表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getExperts_rangeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Experts_range");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("专家推荐分类"); 
		return column;
	}
	/**
	 * 获取最小周期-年表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getYear_freq_minCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Year_freq_min");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("最小周期-年"); 
		return column;
	}
	/**
	 * 获取最大周期-年表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getYear_freq_maxCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Year_freq_max");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("最大周期-年"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id","Id_pesrvprogage");
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
