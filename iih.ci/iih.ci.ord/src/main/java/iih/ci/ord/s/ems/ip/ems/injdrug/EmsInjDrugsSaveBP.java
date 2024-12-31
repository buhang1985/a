package iih.ci.ord.s.ems.ip.ems.injdrug;

import iih.ci.ord.s.ems.base.BaseEmsSaveBP;

/**
 * 输液医疗单保存逻辑
 * @author wangqingzhu
 *
 */
public class EmsInjDrugsSaveBP extends BaseEmsSaveBP {

	public EmsInjDrugsSaveBP(){
		this.setEmsValidate(new EmsInjDrugsValidate());
	}
}
