package iih.en.pv.out.ws.bean.result;

import iih.bd.webservice.BaseWsResult;
import iih.en.pv.out.ws.bean.IpInfoBean;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 住院基本信息返回值
 * 
 * @author liubin
 *
 */
@XmlRootElement(name = "result")
@XmlAccessorType(XmlAccessType.FIELD)
public class IpInfoReturnBean extends BaseWsResult implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private IpInfoBean[] data;

    public IpInfoBean[] getData() {
        return data;
    }

    public void setData(IpInfoBean[] data) {
        this.data = data;
    }

}
