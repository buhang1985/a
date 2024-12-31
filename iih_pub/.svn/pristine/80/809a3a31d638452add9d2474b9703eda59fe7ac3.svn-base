
package iih.sc.apt.scapt.d.desc;

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
 * 计划排班_预约_医技辅 DO 元数据信息
 */
public class ScAptMtDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.sc.apt.scapt.d.ScAptMtDO";
	public static final String CLASS_DISPALYNAME = "计划排班_预约_医技辅";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "sc_apt_mt";
	public static final String TABLE_ALIAS_NAME = "a2";
	public static final String PRIMARYKEY_FIELDNAME="Id_aptmt";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public ScAptMtDODesc(){
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
		this.setKeyDesc(getId_aptmtADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_aptADesc(tblDesc));
		this.add(getId_aptmtADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_aptADesc(tblDesc));
		this.add(getId_mtADesc(tblDesc));
		this.add(getId_dep_mpADesc(tblDesc));
		this.add(getFg_arriveADesc(tblDesc));
		this.add(getId_mp_mtADesc(tblDesc));
		this.add(getUrl_photoADesc(tblDesc));
		this.add(getId_aptapplADesc(tblDesc));
		this.add(getFg_manu_takADesc(tblDesc));
		this.add(getFg_aptcfmADesc(tblDesc));
		this.add(getFg_needcfmADesc(tblDesc));
		this.add(getId_emp_cfmADesc(tblDesc));
		this.add(getDt_apt_cfmADesc(tblDesc));
		this.add(getNoteADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_aptmtCDesc(tblDesc));
		tblDesc.add(getId_aptmtCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_aptCDesc(tblDesc));
		tblDesc.add(getId_mtCDesc(tblDesc));
		tblDesc.add(getId_dep_mpCDesc(tblDesc));
		tblDesc.add(getFg_arriveCDesc(tblDesc));
		tblDesc.add(getId_mp_mtCDesc(tblDesc));
		tblDesc.add(getUrl_photoCDesc(tblDesc));
		tblDesc.add(getId_aptapplCDesc(tblDesc));
		tblDesc.add(getFg_manu_takCDesc(tblDesc));
		tblDesc.add(getFg_aptcfmCDesc(tblDesc));
		tblDesc.add(getFg_needcfmCDesc(tblDesc));
		tblDesc.add(getId_emp_cfmCDesc(tblDesc));
		tblDesc.add(getDt_apt_cfmCDesc(tblDesc));
		tblDesc.add(getNoteCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 预约医技辅属性ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_aptmtADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_aptmt",  getId_aptmtCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("预约医技辅属性ID");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 组织属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_orgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_org",  getId_orgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("组织");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 集团属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_grpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_grp",  getId_grpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("集团");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 预约属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_aptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_apt",  getId_aptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("预约");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 医技辅属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mtADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mt",  getId_mtCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医技辅");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 执行部门属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dep_mpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep_mp",  getId_dep_mpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("执行部门");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 医技辅签到标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_arriveADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_arrive",  getFg_arriveCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("医技辅签到标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医技辅执行属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mp_mtADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mp_mt",  getId_mp_mtCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医技辅执行");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 相片地址属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getUrl_photoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Url_photo",  getUrl_photoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("相片地址");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 预约申请id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_aptapplADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_aptappl",  getId_aptapplCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("预约申请id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 手工选择标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_manu_takADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_manu_tak",  getFg_manu_takCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("手工选择标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 确认标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_aptcfmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_aptcfm",  getFg_aptcfmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("确认标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 需确认标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_needcfmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_needcfm",  getFg_needcfmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("需确认标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 确认员工属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_cfmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_cfm",  getId_emp_cfmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("确认员工");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 确认时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_apt_cfmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_apt_cfm",  getDt_apt_cfmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("确认时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备注属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNoteADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Note",  getNoteCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备注");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取预约医技辅属性ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_aptmtCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_aptmt");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("预约医技辅属性ID"); 
		return column;
	}
	/**
	 * 获取组织表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_orgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_org");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("组织"); 
		return column;
	}
	/**
	 * 获取集团表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_grpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_grp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("集团"); 
		return column;
	}
	/**
	 * 获取预约表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_aptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_apt");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("预约"); 
		return column;
	}
	/**
	 * 获取医技辅表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mtCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mt");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医技辅"); 
		return column;
	}
	/**
	 * 获取执行部门表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dep_mpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep_mp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("执行部门"); 
		return column;
	}
	/**
	 * 获取医技辅签到标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_arriveCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_arrive");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("医技辅签到标志"); 
		return column;
	}
	/**
	 * 获取医技辅执行表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mp_mtCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mp_mt");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医技辅执行"); 
		return column;
	}
	/**
	 * 获取相片地址表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getUrl_photoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Url_photo");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("相片地址"); 
		return column;
	}
	/**
	 * 获取预约申请id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_aptapplCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_aptappl");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("预约申请id"); 
		return column;
	}
	/**
	 * 获取手工选择标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_manu_takCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_manu_tak");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("手工选择标志"); 
		return column;
	}
	/**
	 * 获取确认标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_aptcfmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_aptcfm");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("确认标志"); 
		return column;
	}
	/**
	 * 获取需确认标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_needcfmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_needcfm");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("需确认标志"); 
		return column;
	}
	/**
	 * 获取确认员工表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_cfmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_cfm");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("确认员工"); 
		return column;
	}
	/**
	 * 获取确认时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_apt_cfmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_apt_cfm");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("确认时间"); 
		return column;
	}
	/**
	 * 获取备注表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNoteCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Note");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备注"); 
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
		defaultValueMap.put("Fg_manu_tak",new xap.mw.coreitf.d.FBoolean("N"));
		defaultValueMap.put("Fg_aptcfm",new xap.mw.coreitf.d.FBoolean("N"));
		defaultValueMap.put("Fg_needcfm",new xap.mw.coreitf.d.FBoolean("N"));
	}
	
}
