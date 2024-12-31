package iih.pis.ivx.mt.d;

import java.io.Serializable;


import xap.mw.core.data.BaseDTO;

/**
 * 
 * 获取医技诊疗项目分类字典信息bean
 * 
 */
public class MtScDbSrvDTO extends BaseDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 诊疗项目id
	 */
	private String idSrv;
	/**
	 * 诊疗项目编码
	 */
	private String codeSrv;
	/**
	 * 诊疗项目名称
	 */
	private String nameSrv;
	/**
	 * 拼音码
	 */
	private String pyCode;
	/**
	 * 五笔码
	 */
	private String wbCode;
	/**
	 * 医技项目分类id
	 */
	private String idScca;
	/**
	 * 医技项目名称
	 */
	private String nameScca;
	/**
	 * 标准价格
	 */
	private String price;
	public String getIdSrv() {
		return idSrv;
	}
	public void setIdSrv(String idSrv) {
		this.idSrv = idSrv;
	}
	public String getCodeSrv() {
		return codeSrv;
	}
	public void setCodeSrv(String codeSrv) {
		this.codeSrv = codeSrv;
	}
	public String getNameSrv() {
		return nameSrv;
	}
	public void setNameSrv(String nameSrv) {
		this.nameSrv = nameSrv;
	}
	public String getPyCode() {
		return pyCode;
	}
	public void setPyCode(String pyCode) {
		this.pyCode = pyCode;
	}
	public String getWbCode() {
		return wbCode;
	}
	public void setWbCode(String wbCode) {
		this.wbCode = wbCode;
	}
	public String getIdScca() {
		return idScca;
	}
	public void setIdScca(String idScca) {
		this.idScca = idScca;
	}
	public String getNameScca() {
		return nameScca;
	}
	public void setNameScca(String nameScca) {
		this.nameScca = nameScca;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
}
