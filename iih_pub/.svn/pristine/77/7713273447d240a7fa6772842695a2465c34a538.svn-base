package iih.en.itf.bean.output;

import iih.bd.webservice.BaseWsResult;
import iih.en.itf.bean.output.opapt.WsEnResultCfmPaidApt;
import iih.en.itf.bean.output.opapt.WsEnResultMakeApt;
import iih.en.itf.bean.output.opapt.WsEnResultPayForApt;
import iih.en.itf.bean.output.opapt.WsEnResultRegPricing;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * EN Ws出参
 * 
 * @author liubin
 *
 */
@XmlRootElement(name = "result")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({WsEnResultMakeApt.class, WsEnResultPayForApt.class, WsEnResultRegPricing.class, WsEnResultCfmPaidApt.class})
public class WsEnResult<T extends WsEnResultInfo> extends BaseWsResult {

	private static final long serialVersionUID = 1L;
	
	@XmlElementWrapper(name = "datas")
	@XmlElementRef
	private List<T> datas;

	public List<T> getDatas() {
		return datas;
	}

	public void setDatas(List<T> datas) {
		this.datas = datas;
	}

}
