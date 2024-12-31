package iih.ei.std.cr_technology.v1.d;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import iih.bd.webservice.BaseWsResult;

/**
 * Pivas查询药品执行计划结果Bean
 * 
 * @author hao_wu 2018-6-26
 *
 */

@XmlRootElement(name = "result")
@XmlAccessorType(XmlAccessType.FIELD)
public class PivasFindMpPlansResultBean extends BaseWsResult {

	private static final long serialVersionUID = 1L;

	@XmlElementWrapper(name = "mpPlans")
	@XmlElement(name = "mpPlan")
	private PivasFindMpPlansMpPlanBean[] mpPlans;

	/**
	 * 执行计划集合
	 * 
	 * @return 执行计划集合
	 */
	public PivasFindMpPlansMpPlanBean[] getMpPlans() {
		return mpPlans;
	}

	/**
	 * 执行计划集合
	 * 
	 * @param mpPlans
	 *            执行计划集合
	 */
	public void setMpPlans(PivasFindMpPlansMpPlanBean[] mpPlans) {
		this.mpPlans = mpPlans;
	}

}
