package iih.ci.mr.mrsign.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mr.mrsign.d.desc.CiMrSignCaDODesc;
import java.math.BigDecimal;

/**
 * 医疗记录_电子签名 DO数据 
 * 
 */
public class CiMrSignCaDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//电子签名主键
	public static final String ID_MRSIGNCA= "Id_mrsignca";
	//签署主键
	public static final String ID_MRSIGN= "Id_mrsign";
	//签署人公钥
	public static final String SIGN_CERT_CA= "Sign_cert_ca";
	//病历文件路径
	public static final String EMR_FILEPATH= "Emr_filepath";
	//加密后病历文件路径
	public static final String CRYPTD_EMR_FILEPATH= "Cryptd_emr_filepath";
	//签署时间
	public static final String PLAIN_SIGN_TIME= "Plain_sign_time";
	//加密签署时间
	public static final String CRYPT_SIGN_TIME= "Crypt_sign_time";
	//病历数据流
	public static final String EMR_FS= "Emr_fs";
	//加密病历数据流
	public static final String CRYPTD_EMR_FS= "Cryptd_emr_fs";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 电子签名主键
	 * @return String
	 */
	public String getId_mrsignca() {
		return ((String) getAttrVal("Id_mrsignca"));
	}	
	/**
	 * 电子签名主键
	 * @param Id_mrsignca
	 */
	public void setId_mrsignca(String Id_mrsignca) {
		setAttrVal("Id_mrsignca", Id_mrsignca);
	}
	/**
	 * 签署主键
	 * @return String
	 */
	public String getId_mrsign() {
		return ((String) getAttrVal("Id_mrsign"));
	}	
	/**
	 * 签署主键
	 * @param Id_mrsign
	 */
	public void setId_mrsign(String Id_mrsign) {
		setAttrVal("Id_mrsign", Id_mrsign);
	}
	/**
	 * 签署人公钥
	 * @return String
	 */
	public String getSign_cert_ca() {
		return ((String) getAttrVal("Sign_cert_ca"));
	}	
	/**
	 * 签署人公钥
	 * @param Sign_cert_ca
	 */
	public void setSign_cert_ca(String Sign_cert_ca) {
		setAttrVal("Sign_cert_ca", Sign_cert_ca);
	}
	/**
	 * 病历文件路径
	 * @return String
	 */
	public String getEmr_filepath() {
		return ((String) getAttrVal("Emr_filepath"));
	}	
	/**
	 * 病历文件路径
	 * @param Emr_filepath
	 */
	public void setEmr_filepath(String Emr_filepath) {
		setAttrVal("Emr_filepath", Emr_filepath);
	}
	/**
	 * 加密后病历文件路径
	 * @return String
	 */
	public String getCryptd_emr_filepath() {
		return ((String) getAttrVal("Cryptd_emr_filepath"));
	}	
	/**
	 * 加密后病历文件路径
	 * @param Cryptd_emr_filepath
	 */
	public void setCryptd_emr_filepath(String Cryptd_emr_filepath) {
		setAttrVal("Cryptd_emr_filepath", Cryptd_emr_filepath);
	}
	/**
	 * 签署时间
	 * @return String
	 */
	public String getPlain_sign_time() {
		return ((String) getAttrVal("Plain_sign_time"));
	}	
	/**
	 * 签署时间
	 * @param Plain_sign_time
	 */
	public void setPlain_sign_time(String Plain_sign_time) {
		setAttrVal("Plain_sign_time", Plain_sign_time);
	}
	/**
	 * 加密签署时间
	 * @return String
	 */
	public String getCrypt_sign_time() {
		return ((String) getAttrVal("Crypt_sign_time"));
	}	
	/**
	 * 加密签署时间
	 * @param Crypt_sign_time
	 */
	public void setCrypt_sign_time(String Crypt_sign_time) {
		setAttrVal("Crypt_sign_time", Crypt_sign_time);
	}
	/**
	 * 病历数据流
	 * @return byte[]
	 */
	public byte[] getEmr_fs() {
		return ((byte[]) getAttrVal("Emr_fs"));
	}	
	/**
	 * 病历数据流
	 * @param Emr_fs
	 */
	public void setEmr_fs(byte[] Emr_fs) {
		setAttrVal("Emr_fs", Emr_fs);
	}
	/**
	 * 加密病历数据流
	 * @return byte[]
	 */
	public byte[] getCryptd_emr_fs() {
		return ((byte[]) getAttrVal("Cryptd_emr_fs"));
	}	
	/**
	 * 加密病历数据流
	 * @param Cryptd_emr_fs
	 */
	public void setCryptd_emr_fs(byte[] Cryptd_emr_fs) {
		setAttrVal("Cryptd_emr_fs", Cryptd_emr_fs);
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
		return "Id_mrsignca";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_mr_signca";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CiMrSignCaDODesc.class);
	}
	
}