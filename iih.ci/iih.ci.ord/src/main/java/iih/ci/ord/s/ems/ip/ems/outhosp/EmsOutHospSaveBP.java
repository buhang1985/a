package iih.ci.ord.s.ems.ip.ems.outhosp;

import iih.ci.ord.s.ems.base.BaseEmsSaveBP;

/**
 * 出院医嘱保存逻辑
 * @author wangqingzhu
 *
 */
public class EmsOutHospSaveBP extends BaseEmsSaveBP {

	public EmsOutHospSaveBP(){
		this.setEmsValidate(new EmsOutHospValidate());
	}
}
