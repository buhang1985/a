
package iih.mp.nr.mpnuhandoverrpt.d.desc;

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
 * 护理交接班病区汇总信息 DO 元数据信息
 */
public class MpNuHsWardDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.mp.nr.mpnuhandoverrpt.d.MpNuHsWardDO";
	public static final String CLASS_DISPALYNAME = "护理交接班病区汇总信息";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "MP_NU_HS_WARD";
	public static final String TABLE_ALIAS_NAME = "a1";
	public static final String PRIMARYKEY_FIELDNAME="Id_nuhsward";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public MpNuHsWardDODesc(){
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
		this.setKeyDesc(getId_nuhswardADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.setFKeyDesc(getId_nuhsADesc(tblDesc));
		this.add(getId_nuhswardADesc(tblDesc));
		this.add(getId_nuhsADesc(tblDesc));
		this.add(getId_nuhswarditemADesc(tblDesc));
		this.add(getSd_nuhswarditemADesc(tblDesc));
		this.add(getValADesc(tblDesc));
		this.add(getName_nuhswarditemADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_nuhswardCDesc(tblDesc));
		tblDesc.add(getId_nuhswardCDesc(tblDesc));
		tblDesc.add(getId_nuhsCDesc(tblDesc));
		tblDesc.add(getId_nuhswarditemCDesc(tblDesc));
		tblDesc.add(getSd_nuhswarditemCDesc(tblDesc));
		tblDesc.add(getValCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 交接班记录病区汇总信息ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_nuhswardADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_nuhsward",  getId_nuhswardCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("交接班记录病区汇总信息ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 交接班记录ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_nuhsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_nuhs",  getId_nuhsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("交接班记录ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 病区汇总信息项目ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_nuhswarditemADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_nuhswarditem",  getId_nuhswarditemCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病区汇总信息项目ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 病区汇总信息项目SD属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_nuhswarditemADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_nuhswarditem",  getSd_nuhswarditemCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病区汇总信息项目SD");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 值属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getValADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Val",  getValCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("值");
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
	private IAttrDesc getName_nuhswarditemADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_nuhswarditem",  getName_nuhswarditemCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b3","id_nuhswarditem=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取交接班记录病区汇总信息ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_nuhswardCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_nuhsward");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("交接班记录病区汇总信息ID"); 
		return column;
	}
	/**
	 * 获取交接班记录ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_nuhsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_nuhs");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("交接班记录ID"); 
		return column;
	}
	/**
	 * 获取病区汇总信息项目ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_nuhswarditemCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_nuhswarditem");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病区汇总信息项目ID"); 
		return column;
	}
	/**
	 * 获取病区汇总信息项目SD表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_nuhswarditemCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_nuhswarditem");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病区汇总信息项目SD"); 
		return column;
	}
	/**
	 * 获取值表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getValCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Val");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("值"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_nuhswarditemCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_nuhswarditem");
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
