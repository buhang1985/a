
package iih.pe.phm.pehmriskdef.d.desc;

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
 * 健康危险因素-评价年龄定义 DO 元数据信息
 */
public class PeHmRiskAgeTargetDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.pe.phm.pehmriskdef.d.PeHmRiskAgeTargetDO";
	public static final String CLASS_DISPALYNAME = "健康危险因素-评价年龄定义";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "pe_hm_riskagetarget";
	public static final String TABLE_ALIAS_NAME = "a4";
	public static final String PRIMARYKEY_FIELDNAME="Id_riskagetarget";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public PeHmRiskAgeTargetDODesc(){
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
		this.setKeyDesc(getId_riskagetargetADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_riskdefADesc(tblDesc));
		this.add(getId_riskagetargetADesc(tblDesc));
		this.add(getId_riskdefADesc(tblDesc));
		this.add(getSexlimitADesc(tblDesc));
		this.add(getAge_beginADesc(tblDesc));
		this.add(getAge_endADesc(tblDesc));
		this.add(getIntensityADesc(tblDesc));
		this.add(getFreqADesc(tblDesc));
		this.add(getDegreeADesc(tblDesc));
		this.add(getSortnoADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_riskagetargetCDesc(tblDesc));
		tblDesc.add(getId_riskagetargetCDesc(tblDesc));
		tblDesc.add(getId_riskdefCDesc(tblDesc));
		tblDesc.add(getSexlimitCDesc(tblDesc));
		tblDesc.add(getAge_beginCDesc(tblDesc));
		tblDesc.add(getAge_endCDesc(tblDesc));
		tblDesc.add(getIntensityCDesc(tblDesc));
		tblDesc.add(getFreqCDesc(tblDesc));
		tblDesc.add(getDegreeCDesc(tblDesc));
		tblDesc.add(getSortnoCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 健康危险因素-评价年龄主键标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_riskagetargetADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_riskagetarget",  getId_riskagetargetCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("健康危险因素-评价年龄主键标识");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 健康危险因素目录ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_riskdefADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_riskdef",  getId_riskdefCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("健康危险因素目录ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 性别限制属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSexlimitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sexlimit",  getSexlimitCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("性别限制");
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
	 * 危险强度属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIntensityADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Intensity",  getIntensityCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("危险强度");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 危险频度属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFreqADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Freq",  getFreqCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("危险频度");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 危险程度属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDegreeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Degree",  getDegreeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("危险程度");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 序号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSortnoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sortno",  getSortnoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("序号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取健康危险因素-评价年龄主键标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_riskagetargetCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_riskagetarget");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("健康危险因素-评价年龄主键标识"); 
		return column;
	}
	/**
	 * 获取健康危险因素目录ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_riskdefCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_riskdef");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("健康危险因素目录ID"); 
		return column;
	}
	/**
	 * 获取性别限制表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSexlimitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sexlimit");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("性别限制"); 
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
	 * 获取危险强度表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIntensityCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Intensity");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("危险强度"); 
		return column;
	}
	/**
	 * 获取危险频度表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFreqCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Freq");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("危险频度"); 
		return column;
	}
	/**
	 * 获取危险程度表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDegreeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Degree");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("危险程度"); 
		return column;
	}
	/**
	 * 获取序号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSortnoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sortno");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("序号"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id","Id_riskagetarget");
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
