package iih.ei.sc.ws.bean;

import iih.bd.webservice.BaseWsParam;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * 获取医技项目分类字典信息bean
 * 
 * @author yzh
 * 
 * @date 2018年10月25日 16:30:58
 */
@XmlRootElement(name = "data")
@XmlAccessorType(XmlAccessType.FIELD)
public class GetMtScCaListBean extends BaseWsParam implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 分类id
	 */
	private String idScca = "";
	/**
	 * 分类编码
	 */
	private String code = "";
	/**
	 * 分类名称
	 */
	private String name = "";
	/**
	 * 拼音码
	 */
	private String pycode = "";
	/**
	 * 五笔码
	 */
	private String wbcode = "";
	
	public String getIdScca() {
		return idScca;
	}
	public void setIdScca(String idScca) {
		this.idScca = idScca;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPycode() {
		return pycode;
	}
	public void setPycode(String pycode) {
		this.pycode = pycode;
	}
	public String getWbcode() {
		return wbcode;
	}
	public void setWbcode(String wbcode) {
		this.wbcode = wbcode;
	}
}
