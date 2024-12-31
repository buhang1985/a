
package iih.hp.cp.ele.d.desc;

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
 * 诊疗计划元素_患者生命体征 DO 元数据信息
 */
public class HpCpElemVitalDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.hp.cp.ele.d.HpCpElemVitalDO";
	public static final String CLASS_DISPALYNAME = "诊疗计划元素_患者生命体征";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "HP_CP_ELE_VT";
	public static final String TABLE_ALIAS_NAME = "a3";
	public static final String PRIMARYKEY_FIELDNAME="Id_ele_vt";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public HpCpElemVitalDODesc(){
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
		this.setKeyDesc(getId_ele_vtADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_eleADesc(tblDesc));
		this.add(getId_ele_vtADesc(tblDesc));
		this.add(getId_eleADesc(tblDesc));
		this.add(getId_vt_tpADesc(tblDesc));
		this.add(getSd_vt_tpADesc(tblDesc));
		this.add(getId_deADesc(tblDesc));
		this.add(getId_de_nameADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_ele_vtCDesc(tblDesc));
		tblDesc.add(getId_ele_vtCDesc(tblDesc));
		tblDesc.add(getId_eleCDesc(tblDesc));
		tblDesc.add(getId_vt_tpCDesc(tblDesc));
		tblDesc.add(getSd_vt_tpCDesc(tblDesc));
		tblDesc.add(getId_deCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 生命体征ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ele_vtADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ele_vt",  getId_ele_vtCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("生命体征ID");
		attrDesc.setNullable(false);
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
	private IAttrDesc getId_eleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ele",  getId_eleCDesc(tblDesc), this);
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
	 * 患者生命体征类型ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_vt_tpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_vt_tp",  getId_vt_tpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者生命体征类型ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者生命体征类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_vt_tpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_vt_tp",  getSd_vt_tpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者生命体征类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 公共数据元属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_deADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_de",  getId_deCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("公共数据元");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 数据元名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_de_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_de_name",  getId_de_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("数据元名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_de a3b3","id_de=id_de","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取生命体征ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ele_vtCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ele_vt");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("生命体征ID"); 
		return column;
	}
	/**
	 * 获取元素ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_eleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ele");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("元素ID"); 
		return column;
	}
	/**
	 * 获取患者生命体征类型ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_vt_tpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_vt_tp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者生命体征类型ID"); 
		return column;
	}
	/**
	 * 获取患者生命体征类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_vt_tpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_vt_tp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者生命体征类型编码"); 
		return column;
	}
	/**
	 * 获取公共数据元表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_deCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_de");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("公共数据元"); 
		return column;
	}
	/**
	 * 获取数据元名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_de_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_de_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("数据元名称"); 
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
