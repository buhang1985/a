package iih.mp.nr.pacs.d;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "obsrpts")
@XmlAccessorType(XmlAccessType.FIELD)
public class RptObsItemDTOS implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@XmlElement(name = "obsrpt")
	private RptObsItemDTO[] itemDTOs;

	public RptObsItemDTO[] getItemDTOs() {
		return itemDTOs;
	}

	public void setItemDTOs(RptObsItemDTO[] itemDTOs) {
		this.itemDTOs = itemDTOs;
	}
}
