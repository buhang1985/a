
package iih.pe.pqn.peicdvmodel.d.desc;

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
 * 健康评估模型_缺血性冠心病_总胆固醇 DO 元数据信息
 */
public class PeIcdvModelTcDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.pe.pqn.peicdvmodel.d.PeIcdvModelTcDO";
	public static final String CLASS_DISPALYNAME = "健康评估模型_缺血性冠心病_总胆固醇";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "pe_qn_peicdvmodeltc";
	public static final String TABLE_ALIAS_NAME = "a4";
	public static final String PRIMARYKEY_FIELDNAME="Id_peicdvmodeltc";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public PeIcdvModelTcDODesc(){
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
		this.setKeyDesc(getId_peicdvmodeltcADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_peicdvmodelADesc(tblDesc));
		this.add(getId_peicdvmodeltcADesc(tblDesc));
		this.add(getId_peicdvmodelADesc(tblDesc));
		this.add(getValue_lowADesc(tblDesc));
		this.add(getValue_heighADesc(tblDesc));
		this.add(getScoreADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_peicdvmodeltcCDesc(tblDesc));
		tblDesc.add(getId_peicdvmodeltcCDesc(tblDesc));
		tblDesc.add(getId_peicdvmodelCDesc(tblDesc));
		tblDesc.add(getValue_lowCDesc(tblDesc));
		tblDesc.add(getValue_heighCDesc(tblDesc));
		tblDesc.add(getScoreCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 缺血性冠心病评估模型总胆固醇主键标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_peicdvmodeltcADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_peicdvmodeltc",  getId_peicdvmodeltcCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("缺血性冠心病评估模型总胆固醇主键标识");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 缺血性冠心病ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_peicdvmodelADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_peicdvmodel",  getId_peicdvmodelCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("缺血性冠心病ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 低值属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getValue_lowADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Value_low",  getValue_lowCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("低值");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 高值属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getValue_heighADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Value_heigh",  getValue_heighCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("高值");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 评分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getScoreADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Score",  getScoreCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("评分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取缺血性冠心病评估模型总胆固醇主键标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_peicdvmodeltcCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_peicdvmodeltc");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("缺血性冠心病评估模型总胆固醇主键标识"); 
		return column;
	}
	/**
	 * 获取缺血性冠心病ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_peicdvmodelCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_peicdvmodel");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("缺血性冠心病ID"); 
		return column;
	}
	/**
	 * 获取低值表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getValue_lowCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Value_low");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("低值"); 
		return column;
	}
	/**
	 * 获取高值表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getValue_heighCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Value_heigh");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("高值"); 
		return column;
	}
	/**
	 * 获取评分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getScoreCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Score");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("评分"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id","Id_peicdvmodeltc");
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
