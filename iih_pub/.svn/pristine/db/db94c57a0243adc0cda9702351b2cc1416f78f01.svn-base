
package iih.en.er.pre.d.desc;

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
 * 急诊预检_分级 DO 元数据信息
 */
public class EnErPreScoreDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.en.er.pre.d.EnErPreScoreDO";
	public static final String CLASS_DISPALYNAME = "急诊预检_分级";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "EN_ERPRE_SCORE";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_erpre_score";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public EnErPreScoreDODesc(){
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
		this.setKeyDesc(getId_erpre_scoreADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_erpre_scoreADesc(tblDesc));
		this.add(getId_erpreADesc(tblDesc));
		this.add(getId_scotpADesc(tblDesc));
		this.add(getSd_scotpADesc(tblDesc));
		this.add(getScoreADesc(tblDesc));
		this.add(getNoteADesc(tblDesc));
		this.add(getName_scotpADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_erpre_scoreCDesc(tblDesc));
		tblDesc.add(getId_erpre_scoreCDesc(tblDesc));
		tblDesc.add(getId_erpreCDesc(tblDesc));
		tblDesc.add(getId_scotpCDesc(tblDesc));
		tblDesc.add(getSd_scotpCDesc(tblDesc));
		tblDesc.add(getScoreCDesc(tblDesc));
		tblDesc.add(getNoteCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 急诊预检分级id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_erpre_scoreADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_erpre_score",  getId_erpre_scoreCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("急诊预检分级id");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 预检id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_erpreADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_erpre",  getId_erpreCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("预检id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 评分类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_scotpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_scotp",  getId_scotpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("评分类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 评分类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_scotpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_scotp",  getSd_scotpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("评分类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 分数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getScoreADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Score",  getScoreCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("分数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 补充说明属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNoteADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Note",  getNoteCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("补充说明");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 评分类型名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_scotpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_scotp",  getName_scotpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("评分类型名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b2","id_scotp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取急诊预检分级id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_erpre_scoreCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_erpre_score");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("急诊预检分级id"); 
		return column;
	}
	/**
	 * 获取预检id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_erpreCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_erpre");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("预检id"); 
		return column;
	}
	/**
	 * 获取评分类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_scotpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_scotp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("评分类型"); 
		return column;
	}
	/**
	 * 获取评分类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_scotpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_scotp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("评分类型编码"); 
		return column;
	}
	/**
	 * 获取分数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getScoreCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Score");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("分数"); 
		return column;
	}
	/**
	 * 获取补充说明表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNoteCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Note");
		column.setLength(512);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("补充说明"); 
		return column;
	}
	/**
	 * 获取评分类型名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_scotpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_scotp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("评分类型名称"); 
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
