package iih.pis.ivx.pisivxsrvact.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pis.ivx.pisivxsrvact.d.desc.PisIvxSrvactTagDODesc;
import java.math.BigDecimal;

/**
 * 服务号标签 DO数据 
 * 
 */
public class PisIvxSrvactTagDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//服务号标签主键
	public static final String ID_IVX_SRVACT_TAG= "Id_ivx_srvact_tag";
	//标签id
	public static final String TAG_ID= "Tag_id";
	//名称
	public static final String NAME= "Name";
	//标签下粉丝数
	public static final String COUNT= "Count";
	//服务号外键
	public static final String ID_IVX_SRVACT= "Id_ivx_srvact";
	//说明
	public static final String DES= "Des";
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
	 * 服务号标签主键
	 * @return String
	 */
	public String getId_ivx_srvact_tag() {
		return ((String) getAttrVal("Id_ivx_srvact_tag"));
	}	
	/**
	 * 服务号标签主键
	 * @param Id_ivx_srvact_tag
	 */
	public void setId_ivx_srvact_tag(String Id_ivx_srvact_tag) {
		setAttrVal("Id_ivx_srvact_tag", Id_ivx_srvact_tag);
	}
	/**
	 * 标签id
	 * @return Integer
	 */
	public Integer getTag_id() {
		return ((Integer) getAttrVal("Tag_id"));
	}	
	/**
	 * 标签id
	 * @param Tag_id
	 */
	public void setTag_id(Integer Tag_id) {
		setAttrVal("Tag_id", Tag_id);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 标签下粉丝数
	 * @return Integer
	 */
	public Integer getCount() {
		return ((Integer) getAttrVal("Count"));
	}	
	/**
	 * 标签下粉丝数
	 * @param Count
	 */
	public void setCount(Integer Count) {
		setAttrVal("Count", Count);
	}
	/**
	 * 服务号外键
	 * @return String
	 */
	public String getId_ivx_srvact() {
		return ((String) getAttrVal("Id_ivx_srvact"));
	}	
	/**
	 * 服务号外键
	 * @param Id_ivx_srvact
	 */
	public void setId_ivx_srvact(String Id_ivx_srvact) {
		setAttrVal("Id_ivx_srvact", Id_ivx_srvact);
	}
	/**
	 * 说明
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	/**
	 * 说明
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
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
		return "Id_ivx_srvact_tag";
	}
	
	@Override
	public String getTableName() {	  
		return "pis_ivx_srvact_tag";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PisIvxSrvactTagDODesc.class);
	}
	
}