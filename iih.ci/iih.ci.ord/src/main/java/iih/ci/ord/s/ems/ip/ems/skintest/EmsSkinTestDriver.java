package iih.ci.ord.s.ems.ip.ems.skintest;

import iih.ci.ord.s.ems.base.BaseEmsDriver;

/**
 * 皮实医疗单驱动
 * 
 * @author wangqingzhu
 *
 */
public class EmsSkinTestDriver extends BaseEmsDriver {

	public EmsSkinTestDriver() {
		this.setEmsAction(
				new EmsSkinTestAction(new EmsSkinTestCreateBP(), new EmsSkinTestLoadBP(), new EmsSkinTestSaveBP()));
	}
}
