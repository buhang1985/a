
package iih.sfda.aer.sfdaaerevnpipe.d.desc;

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
 * 导管事件 DO 元数据信息
 */
public class SfdaAerEvNpipeDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.sfda.aer.sfdaaerevnpipe.d.SfdaAerEvNpipeDO";
	public static final String CLASS_DISPALYNAME = "导管事件";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "SFDA_AER_EV_NPIPE";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_aer_ev_npipe";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public SfdaAerEvNpipeDODesc(){
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
		this.setKeyDesc(getId_aer_ev_npipeADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_aer_ev_npipeADesc(tblDesc));
		this.add(getId_aer_evADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_pipe_errtpADesc(tblDesc));
		this.add(getSd_pipe_errtpADesc(tblDesc));
		this.add(getPipe_errtp_othADesc(tblDesc));
		this.add(getId_pipe_tpADesc(tblDesc));
		this.add(getSd_pipe_tpADesc(tblDesc));
		this.add(getPipe_tp_othADesc(tblDesc));
		this.add(getId_ocur_ativyADesc(tblDesc));
		this.add(getSd_ocur_ativyADesc(tblDesc));
		this.add(getOcur_ativy_othADesc(tblDesc));
		this.add(getId_pipe_mtrADesc(tblDesc));
		this.add(getSd_pipe_mtrADesc(tblDesc));
		this.add(getPipe_mtr_othADesc(tblDesc));
		this.add(getEu_rept_instADesc(tblDesc));
		this.add(getId_unawarADesc(tblDesc));
		this.add(getSd_unawarADesc(tblDesc));
		this.add(getCount_pull_pipeADesc(tblDesc));
		this.add(getEu_any_cpyADesc(tblDesc));
		this.add(getEu_cpy_hereADesc(tblDesc));
		this.add(getCpy_here_othADesc(tblDesc));
		this.add(getExt1ADesc(tblDesc));
		this.add(getExt2ADesc(tblDesc));
		this.add(getExt3ADesc(tblDesc));
		this.add(getExt4ADesc(tblDesc));
		this.add(getExt5ADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getName_grpADesc(tblDesc));
		this.add(getName_orgADesc(tblDesc));
		this.add(getName_pipe_errtpADesc(tblDesc));
		this.add(getName_pipe_tpADesc(tblDesc));
		this.add(getName_ocur_ativyADesc(tblDesc));
		this.add(getName_pipe_mtrADesc(tblDesc));
		this.add(getName_unawarADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_aer_ev_npipeCDesc(tblDesc));
		tblDesc.add(getId_aer_ev_npipeCDesc(tblDesc));
		tblDesc.add(getId_aer_evCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_pipe_errtpCDesc(tblDesc));
		tblDesc.add(getSd_pipe_errtpCDesc(tblDesc));
		tblDesc.add(getPipe_errtp_othCDesc(tblDesc));
		tblDesc.add(getId_pipe_tpCDesc(tblDesc));
		tblDesc.add(getSd_pipe_tpCDesc(tblDesc));
		tblDesc.add(getPipe_tp_othCDesc(tblDesc));
		tblDesc.add(getId_ocur_ativyCDesc(tblDesc));
		tblDesc.add(getSd_ocur_ativyCDesc(tblDesc));
		tblDesc.add(getOcur_ativy_othCDesc(tblDesc));
		tblDesc.add(getId_pipe_mtrCDesc(tblDesc));
		tblDesc.add(getSd_pipe_mtrCDesc(tblDesc));
		tblDesc.add(getPipe_mtr_othCDesc(tblDesc));
		tblDesc.add(getEu_rept_instCDesc(tblDesc));
		tblDesc.add(getId_unawarCDesc(tblDesc));
		tblDesc.add(getSd_unawarCDesc(tblDesc));
		tblDesc.add(getCount_pull_pipeCDesc(tblDesc));
		tblDesc.add(getEu_any_cpyCDesc(tblDesc));
		tblDesc.add(getEu_cpy_hereCDesc(tblDesc));
		tblDesc.add(getCpy_here_othCDesc(tblDesc));
		tblDesc.add(getExt1CDesc(tblDesc));
		tblDesc.add(getExt2CDesc(tblDesc));
		tblDesc.add(getExt3CDesc(tblDesc));
		tblDesc.add(getExt4CDesc(tblDesc));
		tblDesc.add(getExt5CDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 护理事件主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_aer_ev_npipeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_aer_ev_npipe",  getId_aer_ev_npipeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("护理事件主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 事件外键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_aer_evADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_aer_ev",  getId_aer_evCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("事件外键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
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
	 * 导管事件错误id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pipe_errtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pipe_errtp",  getId_pipe_errtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("导管事件错误id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 导管事件错误类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_pipe_errtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_pipe_errtp",  getSd_pipe_errtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("导管事件错误类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 其他导管事件错误类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPipe_errtp_othADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pipe_errtp_oth",  getPipe_errtp_othCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("其他导管事件错误类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 导管id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pipe_tpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pipe_tp",  getId_pipe_tpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("导管id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 导管种类属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_pipe_tpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_pipe_tp",  getSd_pipe_tpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("导管种类");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 其他导管种类属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPipe_tp_othADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pipe_tp_oth",  getPipe_tp_othCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("其他导管种类");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 事件发生于何项活动id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ocur_ativyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ocur_ativy",  getId_ocur_ativyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("事件发生于何项活动id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 事件发生于何项活动过程属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_ocur_ativyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_ocur_ativy",  getSd_ocur_ativyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("事件发生于何项活动过程");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 事件发生于其他活动属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOcur_ativy_othADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ocur_ativy_oth",  getOcur_ativy_othCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("事件发生于其他活动");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 固定导管使用的材料id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pipe_mtrADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pipe_mtr",  getId_pipe_mtrCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("固定导管使用的材料id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 固定导管使用的材料属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_pipe_mtrADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_pipe_mtr",  getSd_pipe_mtrCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("固定导管使用的材料");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 固定导管使用的其他材料属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPipe_mtr_othADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pipe_mtr_oth",  getPipe_mtr_othCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("固定导管使用的其他材料");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否重新插/置管属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_rept_instADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_rept_inst",  getEu_rept_instCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("是否重新插/置管");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 意识障碍的程度id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_unawarADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_unawar",  getId_unawarCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("意识障碍的程度id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 意识障碍的程度属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_unawarADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_unawar",  getSd_unawarCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("意识障碍的程度");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 最近一星期病人自拔导管次数（包含所有导管类型）属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCount_pull_pipeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Count_pull_pipe",  getCount_pull_pipeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("最近一星期病人自拔导管次数（包含所有导管类型）");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 平日有无陪伴者属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_any_cpyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_any_cpy",  getEu_any_cpyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("平日有无陪伴者");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 事件发生陪伴者是否在场属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_cpy_hereADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_cpy_here",  getEu_cpy_hereCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("事件发生陪伴者是否在场");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 事件发生时在场陪伴者属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCpy_here_othADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Cpy_here_oth",  getCpy_here_othCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("事件发生时在场陪伴者");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 扩展字段1属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getExt1ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ext1",  getExt1CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("扩展字段1");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 扩展字段2属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getExt2ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ext2",  getExt2CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("扩展字段2");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 扩展字段3属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getExt3ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ext3",  getExt3CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("扩展字段3");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 扩展字段4属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getExt4ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ext4",  getExt4CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("扩展字段4");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 扩展字段5属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getExt5ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ext5",  getExt5CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("扩展字段5");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 创建人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCreatedbyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Createdby",  getCreatedbyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("创建人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 创建时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCreatedtimeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Createdtime",  getCreatedtimeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("创建时间");
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
	private IAttrDesc getModifiedbyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Modifiedby",  getModifiedbyCDesc(tblDesc), this);
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
	private IAttrDesc getModifiedtimeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Modifiedtime",  getModifiedtimeCDesc(tblDesc), this);
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
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_grpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_grp",  getName_grpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_grp a0b2","id_grp=id_grp","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 组织名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_orgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_org",  getName_orgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("组织名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_org a0b3","id_org=id_org","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 导管事件错误类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_pipe_errtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_pipe_errtp",  getName_pipe_errtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("导管事件错误类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b6","id_pipe_errtp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 导管种类属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_pipe_tpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_pipe_tp",  getName_pipe_tpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("导管种类");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b7","id_pipe_tp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 事件发生于何项活动属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_ocur_ativyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_ocur_ativy",  getName_ocur_ativyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("事件发生于何项活动");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b8","id_ocur_ativy=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 固定导管使用的材料属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_pipe_mtrADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_pipe_mtr",  getName_pipe_mtrCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("固定导管使用的材料");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b9","id_pipe_mtr=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 意识障碍的程度属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_unawarADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_unawar",  getName_unawarCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("意识障碍的程度");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b10","id_unawar=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取护理事件主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_aer_ev_npipeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_aer_ev_npipe");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("护理事件主键"); 
		return column;
	}
	/**
	 * 获取事件外键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_aer_evCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_aer_ev");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("事件外键"); 
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
	 * 获取导管事件错误id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pipe_errtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pipe_errtp");
		column.setLength(1000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("导管事件错误id"); 
		return column;
	}
	/**
	 * 获取导管事件错误类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_pipe_errtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_pipe_errtp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("导管事件错误类型"); 
		return column;
	}
	/**
	 * 获取其他导管事件错误类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPipe_errtp_othCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pipe_errtp_oth");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("其他导管事件错误类型"); 
		return column;
	}
	/**
	 * 获取导管id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pipe_tpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pipe_tp");
		column.setLength(2000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("导管id"); 
		return column;
	}
	/**
	 * 获取导管种类表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_pipe_tpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_pipe_tp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("导管种类"); 
		return column;
	}
	/**
	 * 获取其他导管种类表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPipe_tp_othCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pipe_tp_oth");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("其他导管种类"); 
		return column;
	}
	/**
	 * 获取事件发生于何项活动id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ocur_ativyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ocur_ativy");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("事件发生于何项活动id"); 
		return column;
	}
	/**
	 * 获取事件发生于何项活动过程表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_ocur_ativyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_ocur_ativy");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("事件发生于何项活动过程"); 
		return column;
	}
	/**
	 * 获取事件发生于其他活动表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOcur_ativy_othCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ocur_ativy_oth");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("事件发生于其他活动"); 
		return column;
	}
	/**
	 * 获取固定导管使用的材料id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pipe_mtrCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pipe_mtr");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("固定导管使用的材料id"); 
		return column;
	}
	/**
	 * 获取固定导管使用的材料表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_pipe_mtrCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_pipe_mtr");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("固定导管使用的材料"); 
		return column;
	}
	/**
	 * 获取固定导管使用的其他材料表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPipe_mtr_othCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pipe_mtr_oth");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("固定导管使用的其他材料"); 
		return column;
	}
	/**
	 * 获取是否重新插/置管表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_rept_instCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_rept_inst");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("是否重新插/置管"); 
		return column;
	}
	/**
	 * 获取意识障碍的程度id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_unawarCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_unawar");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("意识障碍的程度id"); 
		return column;
	}
	/**
	 * 获取意识障碍的程度表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_unawarCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_unawar");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("意识障碍的程度"); 
		return column;
	}
	/**
	 * 获取最近一星期病人自拔导管次数（包含所有导管类型）表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCount_pull_pipeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Count_pull_pipe");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("最近一星期病人自拔导管次数（包含所有导管类型）"); 
		return column;
	}
	/**
	 * 获取平日有无陪伴者表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_any_cpyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_any_cpy");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("平日有无陪伴者"); 
		return column;
	}
	/**
	 * 获取事件发生陪伴者是否在场表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_cpy_hereCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_cpy_here");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("事件发生陪伴者是否在场"); 
		return column;
	}
	/**
	 * 获取事件发生时在场陪伴者表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCpy_here_othCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Cpy_here_oth");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("事件发生时在场陪伴者"); 
		return column;
	}
	/**
	 * 获取扩展字段1表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getExt1CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ext1");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("扩展字段1"); 
		return column;
	}
	/**
	 * 获取扩展字段2表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getExt2CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ext2");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("扩展字段2"); 
		return column;
	}
	/**
	 * 获取扩展字段3表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getExt3CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ext3");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("扩展字段3"); 
		return column;
	}
	/**
	 * 获取扩展字段4表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getExt4CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ext4");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("扩展字段4"); 
		return column;
	}
	/**
	 * 获取扩展字段5表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getExt5CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ext5");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("扩展字段5"); 
		return column;
	}
	/**
	 * 获取创建人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCreatedbyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Createdby");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("创建人"); 
		return column;
	}
	/**
	 * 获取创建时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCreatedtimeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Createdtime");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("创建时间"); 
		return column;
	}
	/**
	 * 获取最后修改人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getModifiedbyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Modifiedby");
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
	private IColumnDesc getModifiedtimeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Modifiedtime");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("最后修改时间"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_grpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_grp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取组织名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_orgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_org");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("组织名称"); 
		return column;
	}
	/**
	 * 获取导管事件错误类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_pipe_errtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_pipe_errtp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("导管事件错误类型"); 
		return column;
	}
	/**
	 * 获取导管种类表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_pipe_tpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_pipe_tp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("导管种类"); 
		return column;
	}
	/**
	 * 获取事件发生于何项活动表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_ocur_ativyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_ocur_ativy");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("事件发生于何项活动"); 
		return column;
	}
	/**
	 * 获取固定导管使用的材料表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_pipe_mtrCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_pipe_mtr");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("固定导管使用的材料"); 
		return column;
	}
	/**
	 * 获取意识障碍的程度表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_unawarCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_unawar");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("意识障碍的程度"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id","Id_aer_ev_npipe");
		iBDDataInfoFldMap.put("id_org","Id_org");
		iBDDataInfoFldMap.put("id_group","Id_grp");
	}

	/**
	 * 设置实体审计信息数据映射关系 
	 */
	private void setIAuditInfoFldMap(){
		iAuditInfoFldMap=new HashMap<String, String>();
		iAuditInfoFldMap.put("createdby","Createdby");
		iAuditInfoFldMap.put("createdtime","Createdtime");
		iAuditInfoFldMap.put("modifiedby","Modifiedby");
		iAuditInfoFldMap.put("modifiedtime","Modifiedtime");
	}
	
	/**
	 * 设置实体默认值
	 */
	private void setDefaultValueMap(){
		defaultValueMap=new HashMap<String, Object>();
	}
	
}
