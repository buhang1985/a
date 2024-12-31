package iih.mp.nr.iihtopathgy.d;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "pathgyrpts")
@XmlAccessorType(XmlAccessType.FIELD)
public class RptPathgyDTOs implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@XmlElement(name = "pathgyrpt")
	private RptPathgyDTO[] itemDTOs;

	public RptPathgyDTO[] getItemDTOs() {
		return itemDTOs;
	}

	public void setItemDTOs(RptPathgyDTO[] itemDTOs) {
		this.itemDTOs = itemDTOs;
	}
	
}
