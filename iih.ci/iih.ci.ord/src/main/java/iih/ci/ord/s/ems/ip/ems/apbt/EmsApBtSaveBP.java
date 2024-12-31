package iih.ci.ord.s.ems.ip.ems.apbt;

import iih.ci.ord.s.ems.base.BaseEmsSaveBP;

/**
 * 备血医疗单保存校验
 * @author wangqingzhu
 *
 */
public class EmsApBtSaveBP extends BaseEmsSaveBP {

	public EmsApBtSaveBP(){
		this.setEmsValidate(new EmsApBtValidate());
	}
}
