package iih.ci.ord.s.ems.ip.ems.crossdept;

import iih.ci.ord.s.ems.base.BaseEmsSaveBP;

/**
 * 跨科医疗单保存逻辑
 * @author wangqingzhu
 *
 */
public class EmsCrossDeptSaveBP extends BaseEmsSaveBP {
	public EmsCrossDeptSaveBP(){
		this.setEmsValidate(new EmsCrossDeptValidate());
	}
}
