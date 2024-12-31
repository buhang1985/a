package iih.ei.een.ws.param;

import iih.bd.webservice.BaseWsParam;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "params")
@XmlAccessorType(XmlAccessType.FIELD)
public class GetDepListParam extends BaseWsParam implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 是否只取末级科室
	 */
	private String fg_only_leaf;

	public String getFg_only_leaf() {
		return fg_only_leaf;
	}

	public void setFg_only_leaf(String fg_only_leaf) {
		this.fg_only_leaf = fg_only_leaf;
	}
}
