package iih.en.pv.s.bp.ip.ws.bean;

import iih.bd.webservice.BaseWsResult;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "result")
@XmlAccessorType(XmlAccessType.FIELD)
public class ScAptByPatResultBean extends BaseWsResult implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ScAptByPatResult[] data;

    public ScAptByPatResult[] getData() {
        return data;
    }

    public void setData(ScAptByPatResult[] data) {
        this.data = data;
    }
}
