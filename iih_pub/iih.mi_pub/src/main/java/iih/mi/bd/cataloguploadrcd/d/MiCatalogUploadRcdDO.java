package iih.mi.bd.cataloguploadrcd.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mi.bd.cataloguploadrcd.d.desc.MiCatalogUploadRcdDODesc;
import java.math.BigDecimal;

/**
 * 医保原始目录文件上传记录 DO数据 
 * 
 */
public class MiCatalogUploadRcdDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//上传记录
	public static final String ID_RCD= "Id_rcd";
	//集团
	public static final String ID_GRP= "Id_grp";
	//组织
	public static final String ID_ORG= "Id_org";
	//医保产品
	public static final String ID_HP= "Id_hp";
	//医保服务类型
	public static final String EU_HPSRVTP= "Eu_hpsrvtp";
	//文件名称
	public static final String FILENAME= "Filename";
	//文件地址
	public static final String FILEPATH= "Filepath";
	//是否上传
	public static final String FG_UPLOAD= "Fg_upload";
	//是否被使用
	public static final String FG_USE= "Fg_use";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//下载时间
	public static final String DT_DOWNLOAD= "Dt_download";
	//上传到文件服务器返回的key值
	public static final String FILEKEY= "Filekey";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 上传记录
	 * @return String
	 */
	public String getId_rcd() {
		return ((String) getAttrVal("Id_rcd"));
	}	
	/**
	 * 上传记录
	 * @param Id_rcd
	 */
	public void setId_rcd(String Id_rcd) {
		setAttrVal("Id_rcd", Id_rcd);
	}
	/**
	 * 集团
	 * @return String
	 */
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	/**
	 * 集团
	 * @param Id_grp
	 */
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	/**
	 * 组织
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	/**
	 * 组织
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 医保产品
	 * @return String
	 */
	public String getId_hp() {
		return ((String) getAttrVal("Id_hp"));
	}	
	/**
	 * 医保产品
	 * @param Id_hp
	 */
	public void setId_hp(String Id_hp) {
		setAttrVal("Id_hp", Id_hp);
	}
	/**
	 * 医保服务类型
	 * @return Integer
	 */
	public Integer getEu_hpsrvtp() {
		return ((Integer) getAttrVal("Eu_hpsrvtp"));
	}	
	/**
	 * 医保服务类型
	 * @param Eu_hpsrvtp
	 */
	public void setEu_hpsrvtp(Integer Eu_hpsrvtp) {
		setAttrVal("Eu_hpsrvtp", Eu_hpsrvtp);
	}
	/**
	 * 文件名称
	 * @return String
	 */
	public String getFilename() {
		return ((String) getAttrVal("Filename"));
	}	
	/**
	 * 文件名称
	 * @param Filename
	 */
	public void setFilename(String Filename) {
		setAttrVal("Filename", Filename);
	}
	/**
	 * 文件地址
	 * @return String
	 */
	public String getFilepath() {
		return ((String) getAttrVal("Filepath"));
	}	
	/**
	 * 文件地址
	 * @param Filepath
	 */
	public void setFilepath(String Filepath) {
		setAttrVal("Filepath", Filepath);
	}
	/**
	 * 是否上传
	 * @return FBoolean
	 */
	public FBoolean getFg_upload() {
		return ((FBoolean) getAttrVal("Fg_upload"));
	}	
	/**
	 * 是否上传
	 * @param Fg_upload
	 */
	public void setFg_upload(FBoolean Fg_upload) {
		setAttrVal("Fg_upload", Fg_upload);
	}
	/**
	 * 是否被使用
	 * @return FBoolean
	 */
	public FBoolean getFg_use() {
		return ((FBoolean) getAttrVal("Fg_use"));
	}	
	/**
	 * 是否被使用
	 * @param Fg_use
	 */
	public void setFg_use(FBoolean Fg_use) {
		setAttrVal("Fg_use", Fg_use);
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
	/**
	 * 下载时间
	 * @return FDateTime
	 */
	public FDateTime getDt_download() {
		return ((FDateTime) getAttrVal("Dt_download"));
	}	
	/**
	 * 下载时间
	 * @param Dt_download
	 */
	public void setDt_download(FDateTime Dt_download) {
		setAttrVal("Dt_download", Dt_download);
	}
	/**
	 * 上传到文件服务器返回的key值
	 * @return String
	 */
	public String getFilekey() {
		return ((String) getAttrVal("Filekey"));
	}	
	/**
	 * 上传到文件服务器返回的key值
	 * @param Filekey
	 */
	public void setFilekey(String Filekey) {
		setAttrVal("Filekey", Filekey);
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
		return "Id_rcd";
	}
	
	@Override
	public String getTableName() {	  
		return "mi_catg_up_rcd";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MiCatalogUploadRcdDODesc.class);
	}
	
}