
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
 * 口腔门诊预约 DO 元数据信息
 */
public class AptOpOralDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.sc.apt.scapt.d.AptOpOralDO";
	public static final String CLASS_DISPALYNAME = "口腔门诊预约";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "SC_APT_OP_ORAL";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_aptoporal";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public AptOpOralDODesc(){
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
		this.setKeyDesc(getId_aptoporalADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.add(getId_aptoporalADesc(tblDesc));
		this.add(getId_aptADesc(tblDesc));
		this.add(getId_aptopADesc(tblDesc));
		this.add(getPosi_teethADesc(tblDesc));
		this.add(getId_proc_oralADesc(tblDesc));
		this.add(getSd_proc_oralADesc(tblDesc));
		this.add(getName_proc_oralADesc(tblDesc));
		this.add(getSvrslotADesc(tblDesc));
		this.add(getNoteADesc(tblDesc));
		this.add(getD_next_apptADesc(tblDesc));
		this.add(getNote_nextADesc(tblDesc));
		this.add(getId_statustagADesc(tblDesc));
		this.add(getSd_statustagADesc(tblDesc));
		this.add(getId_emp_lastmdfADesc(tblDesc));
		this.add(getDt_lastmdfADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_aptoporalCDesc(tblDesc));
		tblDesc.add(getId_aptoporalCDesc(tblDesc));
		tblDesc.add(getId_aptCDesc(tblDesc));
		tblDesc.add(getId_aptopCDesc(tblDesc));
		tblDesc.add(getPosi_teethCDesc(tblDesc));
		tblDesc.add(getId_proc_oralCDesc(tblDesc));
		tblDesc.add(getSd_proc_oralCDesc(tblDesc));
		tblDesc.add(getName_proc_oralCDesc(tblDesc));
		tblDesc.add(getSvrslotCDesc(tblDesc));
		tblDesc.add(getNoteCDesc(tblDesc));
		tblDesc.add(getD_next_apptCDesc(tblDesc));
		tblDesc.add(getNote_nextCDesc(tblDesc));
		tblDesc.add(getId_statustagCDesc(tblDesc));
		tblDesc.add(getSd_statustagCDesc(tblDesc));
		tblDesc.add(getId_emp_lastmdfCDesc(tblDesc));
		tblDesc.add(getDt_lastmdfCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 口腔预约id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_aptoporalADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_aptoporal",  getId_aptoporalCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("口腔预约id");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 预约ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_aptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_apt",  getId_aptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("预约ID");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 门诊预约ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_aptopADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_aptop",  getId_aptopCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("门诊预约ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 牙位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPosi_teethADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Posi_teeth",  getPosi_teethCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("牙位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 处置id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_proc_oralADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_proc_oral",  getId_proc_oralCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("处置id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 处置编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_proc_oralADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_proc_oral",  getSd_proc_oralCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("处置编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 处置属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_proc_oralADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_proc_oral",  getName_proc_oralCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("处置");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 时长（分钟）属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSvrslotADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Svrslot",  getSvrslotCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("时长（分钟）");
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
	 * 建议复诊时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getD_next_apptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("D_next_appt",  getD_next_apptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("建议复诊时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 复诊备注属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNote_nextADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Note_next",  getNote_nextCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("复诊备注");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 状态标签属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_statustagADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_statustag",  getId_statustagCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("状态标签");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 状态标签编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_statustagADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_statustag",  getSd_statustagCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("状态标签编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 最后修改人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_lastmdfADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_lastmdf",  getId_emp_lastmdfCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("最后修改人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 最后修改时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_lastmdfADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_lastmdf",  getDt_lastmdfCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("最后修改时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取口腔预约id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_aptoporalCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_aptoporal");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("口腔预约id"); 
		return column;
	}
	/**
	 * 获取预约ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_aptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_apt");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("预约ID"); 
		return column;
	}
	/**
	 * 获取门诊预约ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_aptopCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_aptop");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("门诊预约ID"); 
		return column;
	}
	/**
	 * 获取牙位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPosi_teethCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Posi_teeth");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("牙位"); 
		return column;
	}
	/**
	 * 获取处置id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_proc_oralCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_proc_oral");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("处置id"); 
		return column;
	}
	/**
	 * 获取处置编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_proc_oralCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_proc_oral");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("处置编码"); 
		return column;
	}
	/**
	 * 获取处置表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_proc_oralCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_proc_oral");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("处置"); 
		return column;
	}
	/**
	 * 获取时长（分钟）表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSvrslotCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Svrslot");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("时长（分钟）"); 
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
	 * 获取建议复诊时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getD_next_apptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"D_next_appt");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("建议复诊时间"); 
		return column;
	}
	/**
	 * 获取复诊备注表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNote_nextCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Note_next");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("复诊备注"); 
		return column;
	}
	/**
	 * 获取状态标签表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_statustagCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_statustag");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("状态标签"); 
		return column;
	}
	/**
	 * 获取状态标签编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_statustagCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_statustag");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("状态标签编码"); 
		return column;
	}
	/**
	 * 获取最后修改人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_lastmdfCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_lastmdf");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("最后修改人"); 
		return column;
	}
	/**
	 * 获取最后修改时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_lastmdfCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_lastmdf");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("最后修改时间"); 
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
