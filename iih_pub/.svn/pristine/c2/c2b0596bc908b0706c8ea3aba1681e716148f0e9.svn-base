package iih.en.pv.out.ws.bean.result;

import iih.bd.webservice.BaseWsResult;
import iih.en.pv.out.ws.bean.IpAllInfoBean;

import java.io.Serializable;
import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 住院基本信息返回值
 * 
 * @author liubin
 *
 */
@XmlRootElement(name = "result")
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
public class IpAllInfoReturnBean extends BaseWsResult implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private Set<IpAllInfoBean> data;

    @XmlElementWrapper(name="datas")
	public Set<IpAllInfoBean> getData() {
		return data;
	}

	public void setData(Set<IpAllInfoBean> data) {
		this.data = data;
	}
    
}
