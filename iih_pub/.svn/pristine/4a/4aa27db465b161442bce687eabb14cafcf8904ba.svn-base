
package iih.nm.nqm.qctplelemaintenance.d.desc;

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
 * 质量模板元素组 DO 元数据信息
 */
public class NmQctplEleGrpDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.nm.nqm.qctplelemaintenance.d.NmQctplEleGrpDO";
	public static final String CLASS_DISPALYNAME = "质量模板元素组";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "NM_QCTPL_ELE_GRP";
	public static final String TABLE_ALIAS_NAME = "a2";
	public static final String PRIMARYKEY_FIELDNAME="Id_qctpl_ele_grp";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public NmQctplEleGrpDODesc(){
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
		this.setKeyDesc(getId_qctpl_ele_grpADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.setFKeyDesc(getId_qctpl_eleADesc(tblDesc));
		this.add(getId_qctpl_ele_grpADesc(tblDesc));
		this.add(getId_qctpl_eleADesc(tblDesc));
		this.add(getEu_seltpADesc(tblDesc));
		this.add(getEu_gradetpADesc(tblDesc));
		this.add(getRate_passADesc(tblDesc));
		this.add(getName_qctpl_eleADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_qctpl_ele_grpCDesc(tblDesc));
		tblDesc.add(getId_qctpl_ele_grpCDesc(tblDesc));
		tblDesc.add(getId_qctpl_eleCDesc(tblDesc));
		tblDesc.add(getEu_seltpCDesc(tblDesc));
		tblDesc.add(getEu_gradetpCDesc(tblDesc));
		tblDesc.add(getRate_passCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 元素组属性主键标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_qctpl_ele_grpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_qctpl_ele_grp",  getId_qctpl_ele_grpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("元素组属性主键标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 元素ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_qctpl_eleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_qctpl_ele",  getId_qctpl_eleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("元素ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 组内选择类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_seltpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_seltp",  getEu_seltpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("组内选择类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 组内评分类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_gradetpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_gradetp",  getEu_gradetpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("组内评分类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 标准合格率属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRate_passADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Rate_pass",  getRate_passCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("标准合格率");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_qctpl_eleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_qctpl_ele",  getName_qctpl_eleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"NM_QCTPL_ELE a2b2","id_qctpl_ele=id_qctpl_ele","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取元素组属性主键标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_qctpl_ele_grpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_qctpl_ele_grp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("元素组属性主键标识"); 
		return column;
	}
	/**
	 * 获取元素ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_qctpl_eleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_qctpl_ele");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("元素ID"); 
		return column;
	}
	/**
	 * 获取组内选择类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_seltpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_seltp");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("组内选择类型"); 
		return column;
	}
	/**
	 * 获取组内评分类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_gradetpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_gradetp");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("组内评分类型"); 
		return column;
	}
	/**
	 * 获取标准合格率表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRate_passCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Rate_pass");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("标准合格率"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_qctpl_eleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_qctpl_ele");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
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
	
}
