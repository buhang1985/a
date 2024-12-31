
package iih.pe.pqn.pediabmodel.d.desc;

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
 * 健康评估模型_糖尿病_家族史 DO 元数据信息
 */
public class PeDiabModelFamHisDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.pe.pqn.pediabmodel.d.PeDiabModelFamHisDO";
	public static final String CLASS_DISPALYNAME = "健康评估模型_糖尿病_家族史";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "pe_qn_pediabmodelfamhis";
	public static final String TABLE_ALIAS_NAME = "a6";
	public static final String PRIMARYKEY_FIELDNAME="Id_pediabmodelfamhis";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public PeDiabModelFamHisDODesc(){
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
		this.setKeyDesc(getId_pediabmodelfamhisADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_pediabmodelADesc(tblDesc));
		this.add(getId_pediabmodelfamhisADesc(tblDesc));
		this.add(getId_pediabmodelADesc(tblDesc));
		this.add(getFg_famhisADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_pediabmodelfamhisCDesc(tblDesc));
		tblDesc.add(getId_pediabmodelfamhisCDesc(tblDesc));
		tblDesc.add(getId_pediabmodelCDesc(tblDesc));
		tblDesc.add(getFg_famhisCDesc(tblDesc));
		tblDesc.add(getScoreCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 糖尿病模型家族史主键标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pediabmodelfamhisADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pediabmodelfamhis",  getId_pediabmodelfamhisCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("糖尿病模型家族史主键标识");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 糖尿病模型ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pediabmodelADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pediabmodel",  getId_pediabmodelCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("糖尿病模型ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 糖尿病家族史属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_famhisADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_famhis",  getFg_famhisCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("糖尿病家族史");
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
	 * 获取糖尿病模型家族史主键标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pediabmodelfamhisCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pediabmodelfamhis");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("糖尿病模型家族史主键标识"); 
		return column;
	}
	/**
	 * 获取糖尿病模型ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pediabmodelCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pediabmodel");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("糖尿病模型ID"); 
		return column;
	}
	/**
	 * 获取糖尿病家族史表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_famhisCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_famhis");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("糖尿病家族史"); 
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
		iBDDataInfoFldMap.put("id","Id_pediabmodelfamhis");
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
