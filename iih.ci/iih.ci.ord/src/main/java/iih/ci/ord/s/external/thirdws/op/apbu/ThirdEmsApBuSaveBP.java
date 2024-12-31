package iih.ci.ord.s.external.thirdws.op.apbu;

import iih.ci.ord.i.external.thirdws.ent.d.EntWsDTO;
import iih.ci.ord.s.external.thirdws.op.base.OpEmsCommonSaveBP;

/**
 * 用血医疗单保存逻辑
 * 
 * @author zhoudongliang
 *
 */
public class ThirdEmsApBuSaveBP extends OpEmsCommonSaveBP {
	public ThirdEmsApBuSaveBP() {
		this.setSaveAction(new EmsApbuSaveAction());
		this.setValidate(new ThirdEmsApBuValidate());
	}

	public ThirdEmsApBuSaveBP(EntWsDTO dataSource) {
		super(dataSource);
		this.setSaveAction(new EmsApbuSaveAction());
		this.setValidate(new ThirdEmsApBuValidate());
	}
}
