package iih.en.pv.appoint.result;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlRootElement;

import iih.bd.webservice.BaseWsParam;

@XmlRootElement(name = "datas")
@XmlAccessorType(XmlAccessType.FIELD)
public class ResultDatasBean<T> extends BaseWsParam implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ResultDatasBean(){}
	
	public ResultDatasBean(T[] datas){
		this.datas = datas;
	};
	
	@XmlAnyElement(lax = true)
	private T[] datas;
	
	public T[] getDatas() {
		return datas;
	}

	public void setDatas(T[] datas) {
		this.datas = datas;
	}
}
