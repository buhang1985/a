
package iih.ci.ord.cons.d.desc;

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
 * 医嘱_会诊受邀对象(新) DO 元数据信息
 */
public class CiConsInviteDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.ci.ord.cons.d.CiConsInviteDO";
	public static final String CLASS_DISPALYNAME = "医嘱_会诊受邀对象(新)";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "CI_CONS_INVITE";
	public static final String TABLE_ALIAS_NAME = "a1";
	public static final String PRIMARYKEY_FIELDNAME="Id_invitecons";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public CiConsInviteDODesc(){
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
		this.setKeyDesc(getId_inviteconsADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_apconsADesc(tblDesc));
		this.add(getId_inviteconsADesc(tblDesc));
		this.add(getId_orADesc(tblDesc));
		this.add(getId_apconsADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getName_orgADesc(tblDesc));
		this.add(getId_depADesc(tblDesc));
		this.add(getId_emptitles_reqADesc(tblDesc));
		this.add(getSd_emptitles_reqADesc(tblDesc));
		this.add(getId_empADesc(tblDesc));
		this.add(getId_emptitle_inviteADesc(tblDesc));
		this.add(getSd_emptitle_inviteADesc(tblDesc));
		this.add(getEu_actADesc(tblDesc));
		this.add(getId_dep_actADesc(tblDesc));
		this.add(getId_emp_actADesc(tblDesc));
		this.add(getId_emptitle_actADesc(tblDesc));
		this.add(getSd_emptitle_actADesc(tblDesc));
		this.add(getDt_response_actADesc(tblDesc));
		this.add(getJudgconsADesc(tblDesc));
		this.add(getName_depADesc(tblDesc));
		this.add(getName_emptitles_reqADesc(tblDesc));
		this.add(getName_empADesc(tblDesc));
		this.add(getName_emptitle_inviteADesc(tblDesc));
		this.add(getName_dep_actADesc(tblDesc));
		this.add(getName_emp_actADesc(tblDesc));
		this.add(getName_emptitle_actADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_inviteconsCDesc(tblDesc));
		tblDesc.add(getId_inviteconsCDesc(tblDesc));
		tblDesc.add(getId_orCDesc(tblDesc));
		tblDesc.add(getId_apconsCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getName_orgCDesc(tblDesc));
		tblDesc.add(getId_depCDesc(tblDesc));
		tblDesc.add(getId_emptitles_reqCDesc(tblDesc));
		tblDesc.add(getSd_emptitles_reqCDesc(tblDesc));
		tblDesc.add(getId_empCDesc(tblDesc));
		tblDesc.add(getId_emptitle_inviteCDesc(tblDesc));
		tblDesc.add(getSd_emptitle_inviteCDesc(tblDesc));
		tblDesc.add(getEu_actCDesc(tblDesc));
		tblDesc.add(getId_dep_actCDesc(tblDesc));
		tblDesc.add(getId_emp_actCDesc(tblDesc));
		tblDesc.add(getId_emptitle_actCDesc(tblDesc));
		tblDesc.add(getSd_emptitle_actCDesc(tblDesc));
		tblDesc.add(getDt_response_actCDesc(tblDesc));
		tblDesc.add(getJudgconsCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 会诊受邀对象ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_inviteconsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_invitecons",  getId_inviteconsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("会诊受邀对象ID");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 会诊医嘱属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_orADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_or",  getId_orCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("会诊医嘱");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 会诊申请属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_apconsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_apcons",  getId_apconsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("会诊申请");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 受邀机构属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_orgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_org",  getId_orgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("受邀机构");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 受邀机构名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_orgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_org",  getName_orgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("受邀机构名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 受邀科室属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_depADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep",  getId_depCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("受邀科室");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 职称要求属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emptitles_reqADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emptitles_req",  getId_emptitles_reqCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("职称要求");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 职称要求编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_emptitles_reqADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_emptitles_req",  getSd_emptitles_reqCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("职称要求编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 受邀人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_empADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp",  getId_empCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("受邀人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 受邀人职称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emptitle_inviteADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emptitle_invite",  getId_emptitle_inviteCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("受邀人职称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 受邀人职称编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_emptitle_inviteADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_emptitle_invite",  getSd_emptitle_inviteCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("受邀人职称编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 应答状态属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_actADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_act",  getEu_actCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("应答状态");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 应答科室属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dep_actADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep_act",  getId_dep_actCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("应答科室");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 应答人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_actADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_act",  getId_emp_actCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("应答人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 应答人职称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emptitle_actADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emptitle_act",  getId_emptitle_actCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("应答人职称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 应答人职称编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_emptitle_actADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_emptitle_act",  getSd_emptitle_actCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("应答人职称编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 应答时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_response_actADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_response_act",  getDt_response_actCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("应答时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 会诊评价属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getJudgconsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Judgcons",  getJudgconsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("会诊评价");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 受邀科室名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_depADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dep",  getName_depCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("受邀科室名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a1b2","id_dep=id_dep","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 职称要求名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_emptitles_reqADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_emptitles_req",  getName_emptitles_reqCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("职称要求名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b6","id_emptitles_req=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 受邀人姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_empADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_emp",  getName_empCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("受邀人姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a1b3","id_emp=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 受邀人职称名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_emptitle_inviteADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_emptitle_invite",  getName_emptitle_inviteCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("受邀人职称名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b7","id_emptitle_invite=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 应答科室名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dep_actADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dep_act",  getName_dep_actCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("应答科室名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a1b4","id_dep_act=id_dep","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 应答人姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_emp_actADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_emp_act",  getName_emp_actCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("应答人姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a1b5","id_emp_act=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 应答人职称名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_emptitle_actADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_emptitle_act",  getName_emptitle_actCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("应答人职称名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b8","id_emptitle_act=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取会诊受邀对象ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_inviteconsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_invitecons");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("会诊受邀对象ID"); 
		return column;
	}
	/**
	 * 获取会诊医嘱表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_orCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_or");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("会诊医嘱"); 
		return column;
	}
	/**
	 * 获取会诊申请表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_apconsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_apcons");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("会诊申请"); 
		return column;
	}
	/**
	 * 获取受邀机构表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_orgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_org");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("受邀机构"); 
		return column;
	}
	/**
	 * 获取受邀机构名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_orgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_org");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("受邀机构名称"); 
		return column;
	}
	/**
	 * 获取受邀科室表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_depCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("受邀科室"); 
		return column;
	}
	/**
	 * 获取职称要求表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emptitles_reqCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emptitles_req");
		column.setLength(2500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("职称要求"); 
		return column;
	}
	/**
	 * 获取职称要求编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_emptitles_reqCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_emptitles_req");
		column.setLength(2500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("职称要求编码"); 
		return column;
	}
	/**
	 * 获取受邀人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_empCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("受邀人"); 
		return column;
	}
	/**
	 * 获取受邀人职称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emptitle_inviteCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emptitle_invite");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("受邀人职称"); 
		return column;
	}
	/**
	 * 获取受邀人职称编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_emptitle_inviteCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_emptitle_invite");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("受邀人职称编码"); 
		return column;
	}
	/**
	 * 获取应答状态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_actCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_act");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("应答状态"); 
		return column;
	}
	/**
	 * 获取应答科室表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dep_actCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep_act");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("应答科室"); 
		return column;
	}
	/**
	 * 获取应答人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_actCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_act");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("应答人"); 
		return column;
	}
	/**
	 * 获取应答人职称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emptitle_actCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emptitle_act");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("应答人职称"); 
		return column;
	}
	/**
	 * 获取应答人职称编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_emptitle_actCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_emptitle_act");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("应答人职称编码"); 
		return column;
	}
	/**
	 * 获取应答时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_response_actCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_response_act");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("应答时间"); 
		return column;
	}
	/**
	 * 获取会诊评价表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getJudgconsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Judgcons");
		column.setLength(0);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("会诊评价"); 
		return column;
	}
	/**
	 * 获取受邀科室名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_depCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dep");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("受邀科室名称"); 
		return column;
	}
	/**
	 * 获取职称要求名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_emptitles_reqCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_emptitles_req");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("职称要求名称"); 
		return column;
	}
	/**
	 * 获取受邀人姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_empCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_emp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("受邀人姓名"); 
		return column;
	}
	/**
	 * 获取受邀人职称名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_emptitle_inviteCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_emptitle_invite");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("受邀人职称名称"); 
		return column;
	}
	/**
	 * 获取应答科室名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_dep_actCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dep_act");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("应答科室名称"); 
		return column;
	}
	/**
	 * 获取应答人姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_emp_actCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_emp_act");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("应答人姓名"); 
		return column;
	}
	/**
	 * 获取应答人职称名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_emptitle_actCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_emptitle_act");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("应答人职称名称"); 
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
