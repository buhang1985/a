
package iih.sc.apt.scaptappl.d.desc;

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
 * 计划排班_预约_申请_手术 DO 元数据信息
 */
public class ScAptApplOptDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.sc.apt.scaptappl.d.ScAptApplOptDO";
	public static final String CLASS_DISPALYNAME = "计划排班_预约_申请_手术";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "sc_apt_appl_opt";
	public static final String TABLE_ALIAS_NAME = "a1";
	public static final String PRIMARYKEY_FIELDNAME="Id_aptapplopt";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public ScAptApplOptDODesc(){
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
		this.setKeyDesc(getId_aptapploptADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_aptapplADesc(tblDesc));
		this.add(getId_aptapploptADesc(tblDesc));
		this.add(getId_aptapplADesc(tblDesc));
		this.add(getId_anestpADesc(tblDesc));
		this.add(getSd_anestpADesc(tblDesc));
		this.add(getSpecialreqADesc(tblDesc));
		this.add(getSpecialinstrumentADesc(tblDesc));
		this.add(getSpecialdesADesc(tblDesc));
		this.add(getId_diADesc(tblDesc));
		this.add(getName_diADesc(tblDesc));
		this.add(getCode_diADesc(tblDesc));
		this.add(getAnnouncementsADesc(tblDesc));
		this.add(getSug_requireADesc(tblDesc));
		this.add(getFg_infectionADesc(tblDesc));
		this.add(getSortno_depphyADesc(tblDesc));
		this.add(getFg_confirm_phyADesc(tblDesc));
		this.add(getDt_confirm_phyADesc(tblDesc));
		this.add(getId_emp_confirm_phyADesc(tblDesc));
		this.add(getFg_need_confirmADesc(tblDesc));
		this.add(getCode_anestpADesc(tblDesc));
		this.add(getName_anestpADesc(tblDesc));
		this.add(getId_didef_codeADesc(tblDesc));
		this.add(getId_didef_nameADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_aptapploptCDesc(tblDesc));
		tblDesc.add(getId_aptapploptCDesc(tblDesc));
		tblDesc.add(getId_aptapplCDesc(tblDesc));
		tblDesc.add(getId_anestpCDesc(tblDesc));
		tblDesc.add(getSd_anestpCDesc(tblDesc));
		tblDesc.add(getSpecialreqCDesc(tblDesc));
		tblDesc.add(getSpecialinstrumentCDesc(tblDesc));
		tblDesc.add(getSpecialdesCDesc(tblDesc));
		tblDesc.add(getId_diCDesc(tblDesc));
		tblDesc.add(getName_diCDesc(tblDesc));
		tblDesc.add(getCode_diCDesc(tblDesc));
		tblDesc.add(getAnnouncementsCDesc(tblDesc));
		tblDesc.add(getSug_requireCDesc(tblDesc));
		tblDesc.add(getFg_infectionCDesc(tblDesc));
		tblDesc.add(getSortno_depphyCDesc(tblDesc));
		tblDesc.add(getFg_confirm_phyCDesc(tblDesc));
		tblDesc.add(getDt_confirm_phyCDesc(tblDesc));
		tblDesc.add(getId_emp_confirm_phyCDesc(tblDesc));
		tblDesc.add(getFg_need_confirmCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 手术预约申请ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_aptapploptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_aptapplopt",  getId_aptapploptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术预约申请ID");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 预约申请ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_aptapplADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_aptappl",  getId_aptapplCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("预约申请ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 麻醉方式id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_anestpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_anestp",  getId_anestpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("麻醉方式id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 麻醉方式编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_anestpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_anestp",  getSd_anestpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("麻醉方式编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 特殊用物属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSpecialreqADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Specialreq",  getSpecialreqCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("特殊用物");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 特殊仪器属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSpecialinstrumentADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Specialinstrument",  getSpecialinstrumentCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("特殊仪器");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 特殊准备属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSpecialdesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Specialdes",  getSpecialdesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("特殊准备");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊断id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_diADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_di",  getId_diCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊断名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_diADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_di",  getName_diCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊断编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_diADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_di",  getCode_diCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 注意事项属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAnnouncementsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Announcements",  getAnnouncementsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("注意事项");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术要求属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSug_requireADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sug_require",  getSug_requireCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术要求");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否感染手术属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_infectionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_infection",  getFg_infectionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否感染手术");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 科室手术台次属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSortno_depphyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sortno_depphy",  getSortno_depphyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("科室手术台次");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否科室确认属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_confirm_phyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_confirm_phy",  getFg_confirm_phyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否科室确认");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 科室确认时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_confirm_phyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_confirm_phy",  getDt_confirm_phyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("科室确认时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 科室确认人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_confirm_phyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_confirm_phy",  getId_emp_confirm_phyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("科室确认人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否需要确认属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_need_confirmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_need_confirm",  getFg_need_confirmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否需要确认");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_anestpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_anestp",  getCode_anestpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b3","id_anestp=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_anestpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_anestp",  getName_anestpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b3","id_anestp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊断编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_didef_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_didef_code",  getId_didef_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"ci_di_itm a1b4","code_di=id_diitm","id_didef_code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊断名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_didef_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_didef_name",  getId_didef_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"ci_di_itm a1b4","code_di=id_diitm","id_didef_name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取手术预约申请ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_aptapploptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_aptapplopt");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("手术预约申请ID"); 
		return column;
	}
	/**
	 * 获取预约申请ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_aptapplCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_aptappl");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("预约申请ID"); 
		return column;
	}
	/**
	 * 获取麻醉方式id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_anestpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_anestp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("麻醉方式id"); 
		return column;
	}
	/**
	 * 获取麻醉方式编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_anestpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_anestp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("麻醉方式编码"); 
		return column;
	}
	/**
	 * 获取特殊用物表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSpecialreqCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Specialreq");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("特殊用物"); 
		return column;
	}
	/**
	 * 获取特殊仪器表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSpecialinstrumentCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Specialinstrument");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("特殊仪器"); 
		return column;
	}
	/**
	 * 获取特殊准备表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSpecialdesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Specialdes");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("特殊准备"); 
		return column;
	}
	/**
	 * 获取诊断id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_diCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_di");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断id"); 
		return column;
	}
	/**
	 * 获取诊断名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_diCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_di");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断名称"); 
		return column;
	}
	/**
	 * 获取诊断编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_diCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_di");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断编码"); 
		return column;
	}
	/**
	 * 获取注意事项表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAnnouncementsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Announcements");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("注意事项"); 
		return column;
	}
	/**
	 * 获取手术要求表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSug_requireCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sug_require");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术要求"); 
		return column;
	}
	/**
	 * 获取是否感染手术表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_infectionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_infection");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否感染手术"); 
		return column;
	}
	/**
	 * 获取科室手术台次表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSortno_depphyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sortno_depphy");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("科室手术台次"); 
		return column;
	}
	/**
	 * 获取是否科室确认表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_confirm_phyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_confirm_phy");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否科室确认"); 
		return column;
	}
	/**
	 * 获取科室确认时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_confirm_phyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_confirm_phy");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("科室确认时间"); 
		return column;
	}
	/**
	 * 获取科室确认人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_confirm_phyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_confirm_phy");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("科室确认人"); 
		return column;
	}
	/**
	 * 获取是否需要确认表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_need_confirmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_need_confirm");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否需要确认"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_anestpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_anestp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_anestpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_anestp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取诊断编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_didef_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_didef_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断编码"); 
		return column;
	}
	/**
	 * 获取诊断名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_didef_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_didef_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断名称"); 
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
