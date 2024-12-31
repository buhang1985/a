
package iih.pi.overview.overview.d.desc;

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
 * 患者输血史 DO 元数据信息
 */
public class PiPatBTDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.pi.overview.overview.d.PiPatBTDO";
	public static final String CLASS_DISPALYNAME = "患者输血史";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "PI_PAT_BT";
	public static final String TABLE_ALIAS_NAME = "a1";
	public static final String PRIMARYKEY_FIELDNAME="Id_patbt";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public PiPatBTDODesc(){
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
		this.setKeyDesc(getId_patbtADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_patADesc(tblDesc));
		this.add(getId_patbtADesc(tblDesc));
		this.add(getSd_datasrcADesc(tblDesc));
		this.add(getId_datasrcADesc(tblDesc));
		this.add(getDesADesc(tblDesc));
		this.add(getUnit_btADesc(tblDesc));
		this.add(getQuan_btADesc(tblDesc));
		this.add(getDt_actADesc(tblDesc));
		this.add(getSd_ymd_actADesc(tblDesc));
		this.add(getId_ymd_actADesc(tblDesc));
		this.add(getSd_bldtpADesc(tblDesc));
		this.add(getId_bldtpADesc(tblDesc));
		this.add(getSd_blood_aboADesc(tblDesc));
		this.add(getId_blood_aboADesc(tblDesc));
		this.add(getSd_blood_rhADesc(tblDesc));
		this.add(getId_blood_rhADesc(tblDesc));
		this.add(getCauseADesc(tblDesc));
		this.add(getCd_bldorgADesc(tblDesc));
		this.add(getNm_bldorgADesc(tblDesc));
		this.add(getSd_orglvl_bldADesc(tblDesc));
		this.add(getId_orglvl_bldADesc(tblDesc));
		this.add(getCd_bloodADesc(tblDesc));
		this.add(getFg_reacADesc(tblDesc));
		this.add(getId_patADesc(tblDesc));
		this.add(getBldtp_nameADesc(tblDesc));
		this.add(getBloodabo_nameADesc(tblDesc));
		this.add(getBloodrh_nameADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_patbtCDesc(tblDesc));
		tblDesc.add(getId_patbtCDesc(tblDesc));
		tblDesc.add(getSd_datasrcCDesc(tblDesc));
		tblDesc.add(getId_datasrcCDesc(tblDesc));
		tblDesc.add(getDesCDesc(tblDesc));
		tblDesc.add(getUnit_btCDesc(tblDesc));
		tblDesc.add(getQuan_btCDesc(tblDesc));
		tblDesc.add(getDt_actCDesc(tblDesc));
		tblDesc.add(getSd_ymd_actCDesc(tblDesc));
		tblDesc.add(getId_ymd_actCDesc(tblDesc));
		tblDesc.add(getSd_bldtpCDesc(tblDesc));
		tblDesc.add(getId_bldtpCDesc(tblDesc));
		tblDesc.add(getSd_blood_aboCDesc(tblDesc));
		tblDesc.add(getId_blood_aboCDesc(tblDesc));
		tblDesc.add(getSd_blood_rhCDesc(tblDesc));
		tblDesc.add(getId_blood_rhCDesc(tblDesc));
		tblDesc.add(getCauseCDesc(tblDesc));
		tblDesc.add(getCd_bldorgCDesc(tblDesc));
		tblDesc.add(getNm_bldorgCDesc(tblDesc));
		tblDesc.add(getSd_orglvl_bldCDesc(tblDesc));
		tblDesc.add(getId_orglvl_bldCDesc(tblDesc));
		tblDesc.add(getCd_bloodCDesc(tblDesc));
		tblDesc.add(getFg_reacCDesc(tblDesc));
		tblDesc.add(getId_patCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 患者输血史ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_patbtADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_patbt",  getId_patbtCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者输血史ID");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 数据来源编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_datasrcADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_datasrc",  getSd_datasrcCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("数据来源编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 数据来源属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_datasrcADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_datasrc",  getId_datasrcCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("数据来源");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 输血史描述属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Des",  getDesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("输血史描述");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 输血单位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getUnit_btADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Unit_bt",  getUnit_btCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("输血单位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 输血量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuan_btADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Quan_bt",  getQuan_btCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("输血量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 输血日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_actADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_act",  getDt_actCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("输血日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 输血日期精度编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_ymd_actADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_ymd_act",  getSd_ymd_actCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("输血日期精度编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 输血日期精度属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ymd_actADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ymd_act",  getId_ymd_actCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("输血日期精度");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 血制品类别编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_bldtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_bldtp",  getSd_bldtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("血制品类别编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 血制品类别属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_bldtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_bldtp",  getId_bldtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("血制品类别");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 血制品血型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_blood_aboADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_blood_abo",  getSd_blood_aboCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("血制品血型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 血制品血型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_blood_aboADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_blood_abo",  getId_blood_aboCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("血制品血型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 血制品RH反应编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_blood_rhADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_blood_rh",  getSd_blood_rhCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("血制品RH反应编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 血制品RH反应属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_blood_rhADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_blood_rh",  getId_blood_rhCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("血制品RH反应");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 输血原因属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCauseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Cause",  getCauseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("输血原因");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 输血机构编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCd_bldorgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Cd_bldorg",  getCd_bldorgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("输血机构编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 输血机构名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNm_bldorgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Nm_bldorg",  getNm_bldorgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("输血机构名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 输血机构等级编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_orglvl_bldADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_orglvl_bld",  getSd_orglvl_bldCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("输血机构等级编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 输血机构等级属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_orglvl_bldADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_orglvl_bld",  getId_orglvl_bldCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("输血机构等级");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 血袋号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCd_bloodADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Cd_blood",  getCd_bloodCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("血袋号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 不良反应标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_reacADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_reac",  getFg_reacCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("不良反应标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_patADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pat",  getId_patCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者ID");
		attrDesc.setNullable(false);
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
	private IAttrDesc getBldtp_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Bldtp_name",  getBldtp_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b1","id_bldtp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBloodabo_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Bloodabo_name",  getBloodabo_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b2","id_blood_abo=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBloodrh_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Bloodrh_name",  getBloodrh_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b3","id_blood_rh=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取患者输血史ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_patbtCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_patbt");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("患者输血史ID"); 
		return column;
	}
	/**
	 * 获取数据来源编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_datasrcCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_datasrc");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("数据来源编码"); 
		return column;
	}
	/**
	 * 获取数据来源表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_datasrcCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_datasrc");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("数据来源"); 
		return column;
	}
	/**
	 * 获取输血史描述表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Des");
		column.setLength(256);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("输血史描述"); 
		return column;
	}
	/**
	 * 获取输血单位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getUnit_btCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Unit_bt");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("输血单位"); 
		return column;
	}
	/**
	 * 获取输血量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuan_btCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Quan_bt");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("输血量"); 
		return column;
	}
	/**
	 * 获取输血日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_actCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_act");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("输血日期"); 
		return column;
	}
	/**
	 * 获取输血日期精度编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_ymd_actCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_ymd_act");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("输血日期精度编码"); 
		return column;
	}
	/**
	 * 获取输血日期精度表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ymd_actCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ymd_act");
		column.setLength(20);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("输血日期精度"); 
		return column;
	}
	/**
	 * 获取血制品类别编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_bldtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_bldtp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("血制品类别编码"); 
		return column;
	}
	/**
	 * 获取血制品类别表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_bldtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_bldtp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("血制品类别"); 
		return column;
	}
	/**
	 * 获取血制品血型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_blood_aboCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_blood_abo");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("血制品血型编码"); 
		return column;
	}
	/**
	 * 获取血制品血型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_blood_aboCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_blood_abo");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("血制品血型"); 
		return column;
	}
	/**
	 * 获取血制品RH反应编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_blood_rhCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_blood_rh");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("血制品RH反应编码"); 
		return column;
	}
	/**
	 * 获取血制品RH反应表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_blood_rhCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_blood_rh");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("血制品RH反应"); 
		return column;
	}
	/**
	 * 获取输血原因表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCauseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Cause");
		column.setLength(256);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("输血原因"); 
		return column;
	}
	/**
	 * 获取输血机构编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCd_bldorgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Cd_bldorg");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("输血机构编码"); 
		return column;
	}
	/**
	 * 获取输血机构名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNm_bldorgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Nm_bldorg");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("输血机构名称"); 
		return column;
	}
	/**
	 * 获取输血机构等级编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_orglvl_bldCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_orglvl_bld");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("输血机构等级编码"); 
		return column;
	}
	/**
	 * 获取输血机构等级表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_orglvl_bldCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_orglvl_bld");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("输血机构等级"); 
		return column;
	}
	/**
	 * 获取血袋号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCd_bloodCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Cd_blood");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("血袋号"); 
		return column;
	}
	/**
	 * 获取不良反应标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_reacCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_reac");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("不良反应标志"); 
		return column;
	}
	/**
	 * 获取患者ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pat");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("患者ID"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBldtp_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Bldtp_name");
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
	private IColumnDesc getBloodabo_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Bloodabo_name");
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
	private IColumnDesc getBloodrh_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Bloodrh_name");
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
	
	/**
	 * 设置实体默认值
	 */
	private void setDefaultValueMap(){
		defaultValueMap=new HashMap<String, Object>();
	}
	
}
