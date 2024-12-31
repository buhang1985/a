
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
 * 健康评估模型_缺血性冠心病_平均分 DO 元数据信息
 */
public class PeIcdvModelAvgDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.pe.pqn.peicdvmodel.d.PeIcdvModelAvgDO";
	public static final String CLASS_DISPALYNAME = "健康评估模型_缺血性冠心病_平均分";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "pe_qn_peicdvmodelavg";
	public static final String TABLE_ALIAS_NAME = "a7";
	public static final String PRIMARYKEY_FIELDNAME="Id_peicdvmodelavg";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public PeIcdvModelAvgDODesc(){
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
		this.setKeyDesc(getId_peicdvmodelavgADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_peicdvmodelADesc(tblDesc));
		this.add(getId_peicdvmodelavgADesc(tblDesc));
		this.add(getId_peicdvmodelADesc(tblDesc));
		this.add(getAge_beginADesc(tblDesc));
		this.add(getAge_endADesc(tblDesc));
		this.add(getRisk_avgADesc(tblDesc));
		this.add(getRisk_lowADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_peicdvmodelavgCDesc(tblDesc));
		tblDesc.add(getId_peicdvmodelavgCDesc(tblDesc));
		tblDesc.add(getId_peicdvmodelCDesc(tblDesc));
		tblDesc.add(getAge_beginCDesc(tblDesc));
		tblDesc.add(getAge_endCDesc(tblDesc));
		tblDesc.add(getRisk_avgCDesc(tblDesc));
		tblDesc.add(getRisk_lowCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 缺血性冠心病评估模型平均分主键标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_peicdvmodelavgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_peicdvmodelavg",  getId_peicdvmodelavgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("缺血性冠心病评估模型平均分主键标识");
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
	 * 平均风险属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRisk_avgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Risk_avg",  getRisk_avgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("平均风险");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 最低风险属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRisk_lowADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Risk_low",  getRisk_lowCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("最低风险");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取缺血性冠心病评估模型平均分主键标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_peicdvmodelavgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_peicdvmodelavg");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("缺血性冠心病评估模型平均分主键标识"); 
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
	 * 获取平均风险表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRisk_avgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Risk_avg");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("平均风险"); 
		return column;
	}
	/**
	 * 获取最低风险表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRisk_lowCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Risk_low");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("最低风险"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id","Id_peicdvmodelavg");
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
