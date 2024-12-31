package iih.en.pv.out.ws.bean.result;

import iih.bd.webservice.BaseWsResult;
import iih.en.pv.out.ws.bean.EntBedBean;
import iih.en.pv.out.ws.bean.EntContBean;
import iih.en.pv.out.ws.bean.EntDepTransBean;
import iih.en.pv.out.ws.bean.EntDiBean;
import iih.en.pv.out.ws.bean.EntHpBean;
import iih.en.pv.out.ws.bean.EntStateBean;
import iih.en.pv.out.ws.bean.IpDetailInfoBean;

import java.io.Serializable;
import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * 住院详细基本信息返回值
 * 
 * @author liubin
 *
 */
@XmlRootElement(name = "result")
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
@XmlSeeAlso({EntDiBean.class, EntHpBean.class, EntStateBean.class, EntDepTransBean.class, EntBedBean.class, EntContBean.class})
public class IpDetailInfoReturnBean<T> extends BaseWsResult implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private Set<IpDetailInfoBean<T>> data;

    @XmlElementWrapper(name="datas")
	public Set<IpDetailInfoBean<T>> getData() {
		return data;
	}

	public void setData(Set<IpDetailInfoBean<T>> data) {
		this.data = data;
	}

    
}
