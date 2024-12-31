package iih.ei.std.cr_technology.v1.d;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "body")
@XmlAccessorType(XmlAccessType.FIELD)
public class PivasSyncMaterialParamBeanList implements Serializable {

	private static final long serialVersionUID = 1L;

	@XmlElement(name = "drug")
	private PivasSyncMaterialParamBean[] _pBeans;

	public PivasSyncMaterialParamBean[] get_pBeans() {
		return _pBeans;
	}

	public void set_pBeans(PivasSyncMaterialParamBean[] _pBeans) {
		this._pBeans = _pBeans;
	}

}
