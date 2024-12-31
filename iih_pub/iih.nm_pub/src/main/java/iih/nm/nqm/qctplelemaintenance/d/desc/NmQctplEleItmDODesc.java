
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
 * 质量模板元素项 DO 元数据信息
 */
public class NmQctplEleItmDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.nm.nqm.qctplelemaintenance.d.NmQctplEleItmDO";
	public static final String CLASS_DISPALYNAME = "质量模板元素项";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "NM_QCTPL_ELE_ITM";
	public static final String TABLE_ALIAS_NAME = "a1";
	public static final String PRIMARYKEY_FIELDNAME="Id_qctpl_ele_itm";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public NmQctplEleItmDODesc(){
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
		this.setKeyDesc(getId_qctpl_ele_itmADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.setFKeyDesc(getId_qctpl_eleADesc(tblDesc));
		this.add(getId_qctpl_ele_itmADesc(tblDesc));
		this.add(getId_qctpl_eleADesc(tblDesc));
		this.add(getId_chktargetADesc(tblDesc));
		this.add(getSd_chktargetADesc(tblDesc));
		this.add(getEu_colltpADesc(tblDesc));
		this.add(getName_qctpl_eleADesc(tblDesc));
		this.add(getName_chktargetADesc(tblDesc));
		this.add(getCode_chktargetADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_qctpl_ele_itmCDesc(tblDesc));
		tblDesc.add(getId_qctpl_ele_itmCDesc(tblDesc));
		tblDesc.add(getId_qctpl_eleCDesc(tblDesc));
		tblDesc.add(getId_chktargetCDesc(tblDesc));
		tblDesc.add(getSd_chktargetCDesc(tblDesc));
		tblDesc.add(getEu_colltpCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 元素项属性主键标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_qctpl_ele_itmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_qctpl_ele_itm",  getId_qctpl_ele_itmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("元素项属性主键标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 质量模板元素属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_qctpl_eleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_qctpl_ele",  getId_qctpl_eleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("质量模板元素");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 检查目标id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_chktargetADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_chktarget",  getId_chktargetCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("检查目标id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 检查目标编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_chktargetADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_chktarget",  getSd_chktargetCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("检查目标编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 采集类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_colltpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_colltp",  getEu_colltpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("采集类型");
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
		attrDesc.setRefTblInfos(new String[]{"NM_QCTPL_ELE a1b2","id_qctpl_ele=id_qctpl_ele","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_chktargetADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_chktarget",  getName_chktargetCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b3","id_chktarget=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_chktargetADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_chktarget",  getCode_chktargetCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b3","id_chktarget=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取元素项属性主键标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_qctpl_ele_itmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_qctpl_ele_itm");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("元素项属性主键标识"); 
		return column;
	}
	/**
	 * 获取质量模板元素表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_qctpl_eleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_qctpl_ele");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("质量模板元素"); 
		return column;
	}
	/**
	 * 获取检查目标id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_chktargetCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_chktarget");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("检查目标id"); 
		return column;
	}
	/**
	 * 获取检查目标编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_chktargetCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_chktarget");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("检查目标编码"); 
		return column;
	}
	/**
	 * 获取采集类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_colltpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_colltp");
		column.setLength(20);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("采集类型"); 
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
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_chktargetCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_chktarget");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_chktargetCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_chktarget");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
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
