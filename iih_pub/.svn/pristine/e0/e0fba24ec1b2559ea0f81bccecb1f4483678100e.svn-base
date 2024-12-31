
package iih.en.doc.pregdoc.d.desc;

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
 * 产妇状况 DO 元数据信息
 */
public class PregDocStatDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.en.doc.pregdoc.d.PregDocStatDO";
	public static final String CLASS_DISPALYNAME = "产妇状况";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "en_doc_preg_stat";
	public static final String TABLE_ALIAS_NAME = "${EntityMeta.entityClassMeta.aliasName}";
	public static final String PRIMARYKEY_FIELDNAME="Id_pregdocstat";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public PregDocStatDODesc(){
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
		this.setKeyDesc(getId_pregdocstatADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.setFKeyDesc(getId_pregdocADesc(tblDesc));
		this.add(getId_pregdocstatADesc(tblDesc));
		this.add(getId_pregdocADesc(tblDesc));
		this.add(getId_entdocADesc(tblDesc));
		this.add(getId_ent_last_opADesc(tblDesc));
		this.add(getId_ent_last_ipADesc(tblDesc));
		this.add(getId_apt_lastADesc(tblDesc));
		this.add(getFg_hypertADesc(tblDesc));
		this.add(getFg_diab_pregADesc(tblDesc));
		this.add(getFg_preg_diabADesc(tblDesc));
		this.add(getWeit_docADesc(tblDesc));
		this.add(getFg_have_bornADesc(tblDesc));
		this.add(getWeit_bornADesc(tblDesc));
		this.add(getMins_bornADesc(tblDesc));
		this.add(getVol_out_bloodADesc(tblDesc));
		this.add(getFg_prematureADesc(tblDesc));
		this.add(getTimes_pregADesc(tblDesc));
		this.add(getTimes_bornADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_pregdocstatCDesc(tblDesc));
		tblDesc.add(getId_pregdocstatCDesc(tblDesc));
		tblDesc.add(getId_pregdocCDesc(tblDesc));
		tblDesc.add(getId_entdocCDesc(tblDesc));
		tblDesc.add(getId_ent_last_opCDesc(tblDesc));
		tblDesc.add(getId_ent_last_ipCDesc(tblDesc));
		tblDesc.add(getId_apt_lastCDesc(tblDesc));
		tblDesc.add(getFg_hypertCDesc(tblDesc));
		tblDesc.add(getFg_diab_pregCDesc(tblDesc));
		tblDesc.add(getFg_preg_diabCDesc(tblDesc));
		tblDesc.add(getWeit_docCDesc(tblDesc));
		tblDesc.add(getFg_have_bornCDesc(tblDesc));
		tblDesc.add(getWeit_bornCDesc(tblDesc));
		tblDesc.add(getMins_bornCDesc(tblDesc));
		tblDesc.add(getVol_out_bloodCDesc(tblDesc));
		tblDesc.add(getFg_prematureCDesc(tblDesc));
		tblDesc.add(getTimes_pregCDesc(tblDesc));
		tblDesc.add(getTimes_bornCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 产妇状况主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pregdocstatADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pregdocstat",  getId_pregdocstatCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("产妇状况主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 产科建档主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pregdocADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pregdoc",  getId_pregdocCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("产科建档主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 建档主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_entdocADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_entdoc",  getId_entdocCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("建档主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 最后一次门诊就诊id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ent_last_opADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ent_last_op",  getId_ent_last_opCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("最后一次门诊就诊id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 最后一次住院就诊id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ent_last_ipADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ent_last_ip",  getId_ent_last_ipCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("最后一次住院就诊id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 最后一次门诊预约id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_apt_lastADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_apt_last",  getId_apt_lastCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("最后一次门诊预约id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 高血压标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_hypertADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_hypert",  getFg_hypertCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("高血压标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 糖尿病妊娠属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_diab_pregADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_diab_preg",  getFg_diab_pregCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("糖尿病妊娠");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 妊娠糖尿病属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_preg_diabADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_preg_diab",  getFg_preg_diabCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("妊娠糖尿病");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 建档体重属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWeit_docADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Weit_doc",  getWeit_docCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("建档体重");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 已分娩标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_have_bornADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_have_born",  getFg_have_bornCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("已分娩标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 分娩体重属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWeit_bornADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Weit_born",  getWeit_bornCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("分娩体重");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 分娩时长(min)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMins_bornADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mins_born",  getMins_bornCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("分娩时长(min)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 产后出血量(ml)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getVol_out_bloodADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Vol_out_blood",  getVol_out_bloodCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("产后出血量(ml)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 早产标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_prematureADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_premature",  getFg_prematureCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("早产标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 孕次属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTimes_pregADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Times_preg",  getTimes_pregCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("孕次");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 产次属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTimes_bornADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Times_born",  getTimes_bornCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("产次");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取产妇状况主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pregdocstatCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pregdocstat");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("产妇状况主键"); 
		return column;
	}
	/**
	 * 获取产科建档主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pregdocCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pregdoc");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("产科建档主键"); 
		return column;
	}
	/**
	 * 获取建档主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_entdocCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_entdoc");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("建档主键"); 
		return column;
	}
	/**
	 * 获取最后一次门诊就诊id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ent_last_opCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ent_last_op");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("最后一次门诊就诊id"); 
		return column;
	}
	/**
	 * 获取最后一次住院就诊id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ent_last_ipCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ent_last_ip");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("最后一次住院就诊id"); 
		return column;
	}
	/**
	 * 获取最后一次门诊预约id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_apt_lastCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_apt_last");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("最后一次门诊预约id"); 
		return column;
	}
	/**
	 * 获取高血压标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_hypertCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_hypert");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("高血压标识"); 
		return column;
	}
	/**
	 * 获取糖尿病妊娠表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_diab_pregCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_diab_preg");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("糖尿病妊娠"); 
		return column;
	}
	/**
	 * 获取妊娠糖尿病表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_preg_diabCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_preg_diab");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("妊娠糖尿病"); 
		return column;
	}
	/**
	 * 获取建档体重表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWeit_docCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Weit_doc");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("建档体重"); 
		return column;
	}
	/**
	 * 获取已分娩标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_have_bornCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_have_born");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("已分娩标识"); 
		return column;
	}
	/**
	 * 获取分娩体重表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWeit_bornCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Weit_born");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("分娩体重"); 
		return column;
	}
	/**
	 * 获取分娩时长(min)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMins_bornCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mins_born");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("分娩时长(min)"); 
		return column;
	}
	/**
	 * 获取产后出血量(ml)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getVol_out_bloodCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Vol_out_blood");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("产后出血量(ml)"); 
		return column;
	}
	/**
	 * 获取早产标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_prematureCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_premature");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("早产标识"); 
		return column;
	}
	/**
	 * 获取孕次表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTimes_pregCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Times_preg");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("孕次"); 
		return column;
	}
	/**
	 * 获取产次表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTimes_bornCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Times_born");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("产次"); 
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
