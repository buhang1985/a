package iih.pe.pbd.peinstrument.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pbd.peinstrument.d.desc.PeInstrumentDODesc;
import java.math.BigDecimal;

/**
 * 仪器设备定义 DO数据 
 * 
 */
public class PeInstrumentDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检仪器设备主键标识
	public static final String ID_PEINSTRUMENT= "Id_peinstrument";
	//体检仪器设备父ID
	public static final String ID_PEINSTRUMENT_PAR= "Id_peinstrument_par";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//设备编码
	public static final String CODE= "Code";
	//设备名称
	public static final String NAME= "Name";
	//主程序主机
	public static final String HOST= "Host";
	//主程序端口
	public static final String HOST_PORT= "Host_port";
	//仪器项目对应关系类型
	public static final String CHANNELTP= "Channeltp";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检仪器设备主键标识
	 * @return String
	 */
	public String getId_peinstrument() {
		return ((String) getAttrVal("Id_peinstrument"));
	}	
	/**
	 * 体检仪器设备主键标识
	 * @param Id_peinstrument
	 */
	public void setId_peinstrument(String Id_peinstrument) {
		setAttrVal("Id_peinstrument", Id_peinstrument);
	}
	/**
	 * 体检仪器设备父ID
	 * @return String
	 */
	public String getId_peinstrument_par() {
		return ((String) getAttrVal("Id_peinstrument_par"));
	}	
	/**
	 * 体检仪器设备父ID
	 * @param Id_peinstrument_par
	 */
	public void setId_peinstrument_par(String Id_peinstrument_par) {
		setAttrVal("Id_peinstrument_par", Id_peinstrument_par);
	}
	/**
	 * 所属集团
	 * @return String
	 */
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	/**
	 * 所属集团
	 * @param Id_grp
	 */
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	/**
	 * 所属组织
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	/**
	 * 所属组织
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 设备编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 设备编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 设备名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 设备名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 主程序主机
	 * @return String
	 */
	public String getHost() {
		return ((String) getAttrVal("Host"));
	}	
	/**
	 * 主程序主机
	 * @param Host
	 */
	public void setHost(String Host) {
		setAttrVal("Host", Host);
	}
	/**
	 * 主程序端口
	 * @return Integer
	 */
	public Integer getHost_port() {
		return ((Integer) getAttrVal("Host_port"));
	}	
	/**
	 * 主程序端口
	 * @param Host_port
	 */
	public void setHost_port(Integer Host_port) {
		setAttrVal("Host_port", Host_port);
	}
	/**
	 * 仪器项目对应关系类型
	 * @return Integer
	 */
	public Integer getChanneltp() {
		return ((Integer) getAttrVal("Channeltp"));
	}	
	/**
	 * 仪器项目对应关系类型
	 * @param Channeltp
	 */
	public void setChanneltp(Integer Channeltp) {
		setAttrVal("Channeltp", Channeltp);
	}
	/**
	 * 创建人
	 * @return String
	 */
	public String getCreatedby() {
		return ((String) getAttrVal("Createdby"));
	}	
	/**
	 * 创建人
	 * @param Createdby
	 */
	public void setCreatedby(String Createdby) {
		setAttrVal("Createdby", Createdby);
	}
	/**
	 * 创建时间
	 * @return FDateTime
	 */
	public FDateTime getCreatedtime() {
		return ((FDateTime) getAttrVal("Createdtime"));
	}	
	/**
	 * 创建时间
	 * @param Createdtime
	 */
	public void setCreatedtime(FDateTime Createdtime) {
		setAttrVal("Createdtime", Createdtime);
	}
	/**
	 * 最后修改人
	 * @return String
	 */
	public String getModifiedby() {
		return ((String) getAttrVal("Modifiedby"));
	}	
	/**
	 * 最后修改人
	 * @param Modifiedby
	 */
	public void setModifiedby(String Modifiedby) {
		setAttrVal("Modifiedby", Modifiedby);
	}
	/**
	 * 最后修改时间
	 * @return FDateTime
	 */
	public FDateTime getModifiedtime() {
		return ((FDateTime) getAttrVal("Modifiedtime"));
	}	
	/**
	 * 最后修改时间
	 * @param Modifiedtime
	 */
	public void setModifiedtime(FDateTime Modifiedtime) {
		setAttrVal("Modifiedtime", Modifiedtime);
	}

	public Integer getDs() {
		return ((Integer) getAttrVal(GlobalConst.DELETE_SIGN));
	}
	
	public void setDs(Integer ds) {
		setAttrVal(GlobalConst.DELETE_SIGN, ds);
	}
	
	public FDateTime getSv() {
		return ((FDateTime) getAttrVal(GlobalConst.SYSTEM_VERSION));
	}
	
	public void setSv(FDateTime sv) {
		setAttrVal(GlobalConst.SYSTEM_VERSION, sv);
	}

//	@Override
//	public java.lang.String getParentPKFieldName() {
//		return null;
//	}
  
	@Override
	public String getPKFieldName() {
		return "Id_peinstrument";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_bd_peinstrument";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeInstrumentDODesc.class);
	}
	
}