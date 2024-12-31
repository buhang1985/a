
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
 * 健康评估模型_缺血性冠心病_吸烟 DO 元数据信息
 */
public class PeIcdvModelSmokeDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.pe.pqn.peicdvmodel.d.PeIcdvModelSmokeDO";
	public static final String CLASS_DISPALYNAME = "健康评估模型_缺血性冠心病_吸烟";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "pe_qn_peicdvmodelsmoke";
	public static final String TABLE_ALIAS_NAME = "a5";
	public static final String PRIMARYKEY_FIELDNAME="Id_peicdvmodelsmoke";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public PeIcdvModelSmokeDODesc(){
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
		this.setKeyDesc(getId_peicdvmodelsmokeADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_peicdvmodelADesc(tblDesc));
		this.add(getId_peicdvmodelsmokeADesc(tblDesc));
		this.add(getId_peicdvmodelADesc(tblDesc));
		this.add(getFg_smokeADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_peicdvmodelsmokeCDesc(tblDesc));
		tblDesc.add(getId_peicdvmodelsmokeCDesc(tblDesc));
		tblDesc.add(getId_peicdvmodelCDesc(tblDesc));
		tblDesc.add(getFg_smokeCDesc(tblDesc));
		tblDesc.add(getScoreCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 缺血性冠心病评估模型吸烟主键标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_peicdvmodelsmokeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_peicdvmodelsmoke",  getId_peicdvmodelsmokeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("缺血性冠心病评估模型吸烟主键标识");
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
	 * 吸烟标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_smokeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_smoke",  getFg_smokeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("吸烟标识");
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
	 * 获取缺血性冠心病评估模型吸烟主键标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_peicdvmodelsmokeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_peicdvmodelsmoke");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("缺血性冠心病评估模型吸烟主键标识"); 
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
	 * 获取吸烟标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_smokeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_smoke");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("吸烟标识"); 
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
		iBDDataInfoFldMap.put("id","Id_peicdvmodelsmoke");
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
