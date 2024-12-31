package iih.ci.ord.s.ems.ip.ems.injdrug;

import iih.ci.ord.s.ems.base.BaseEmsDriver;

/**
 * 住院注射用药医嘱医疗单驱动
 * @author wangqingzhu
 *
 */
public class EmsInjDrugsDriver extends BaseEmsDriver {
	public EmsInjDrugsDriver(){
		this.setEmsAction(new EmsInjDrugsAction(new EmsInjDrugsCreateBP(),new EmsInjDrugsLoadBP(),new EmsInjDrugsSaveBP()));
		
	}
}
