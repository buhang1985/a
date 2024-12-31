package iih.ci.ord.s.external.thirdws.op.apbt;

import iih.ci.ord.i.external.thirdws.ent.d.EntWsDTO;
import iih.ci.ord.s.external.thirdws.op.base.OpEmsCommonSaveBP;

/**
 * 备血(输血)医疗单保存逻辑
 * 
 * @author zhoudongliang
 *
 */
public class ThirdEmsApBtSaveBP extends OpEmsCommonSaveBP {

	public ThirdEmsApBtSaveBP() {
		this.setSaveAction(new EmsApbtSaveAction());
		this.setValidate(new ThirdEmsApBtValidate());
	}

	public ThirdEmsApBtSaveBP(EntWsDTO dataSource) {
		super(dataSource);
		this.setSaveAction(new EmsApbtSaveAction());
		this.setValidate(new ThirdEmsApBtValidate());
	}
}
