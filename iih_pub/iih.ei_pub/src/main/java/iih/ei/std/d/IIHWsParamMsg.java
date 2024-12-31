package iih.ei.std.d;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import xap.mw.core.service.time.TimeService;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
/***
 * 入参操作信息
 * @author fanlq 2019-07-31
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class IIHWsParamMsg implements Serializable {

	private static final long serialVersionUID = 1L;

	public IIHWsParamMsg() {
		this.oprTime = ServiceFinder.find(TimeService.class).getUFDateTime();
	}
	
	/***
	 * 操作员编码
	 */
	@XmlElement(name="oprCode")  
	private String oprCode;
	/***
	 * 操作时间
	 */
	@XmlElement(name="oprTime")  
	private FDateTime oprTime;

	public String getOprCode() {
		return oprCode;
	}
	public void setOprCode(String oprCode) {
		this.oprCode = oprCode;
	}
	public FDateTime getOprTime() {
		return oprTime;
	}
	public void setOprTime(FDateTime oprTime) {
		this.oprTime = oprTime;
	}
	
}
