package iih.ei.std.cr_technology.v1.d;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import iih.bd.webservice.BaseWsResult;

/**
 *  药品执行计划出参
 * 
 * @author dj.zhang
 *
 */
@XmlRootElement(name = "result")
@XmlAccessorType(XmlAccessType.FIELD)
public class PivasExecPlanRstBeanList extends BaseWsResult implements Serializable {

	private static final long serialVersionUID = 1L;

	@XmlElementWrapper(name = "orderItems")
	@XmlElement(name = "orderItem")
	private PivasExecPlanRstBean[] orBeans;

	public PivasExecPlanRstBean[] getOrBeans() {
		return orBeans;
	}

	public void setOrBeans(PivasExecPlanRstBean[] orBeans) {
		this.orBeans = orBeans;
	}
	

}
