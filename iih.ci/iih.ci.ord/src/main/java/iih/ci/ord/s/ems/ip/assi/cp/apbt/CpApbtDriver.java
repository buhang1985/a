package iih.ci.ord.s.ems.ip.assi.cp.apbt;

import iih.ci.ord.s.ems.base.BaseEmsDriver;

/**
 * 临床路径 备血逻辑
 * @author wangqingzhu
 *
 */
public class CpApbtDriver extends BaseEmsDriver {

	public CpApbtDriver() {
		super();
		this.setEmsAction(new CpApbtAction());
	}

	
}
