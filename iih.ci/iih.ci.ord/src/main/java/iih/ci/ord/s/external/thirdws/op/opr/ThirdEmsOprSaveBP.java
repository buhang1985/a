package iih.ci.ord.s.external.thirdws.op.opr;

import iih.ci.ord.i.external.thirdws.ent.d.EntWsDTO;
import iih.ci.ord.s.external.thirdws.op.apbu.ThirdEmsApBuValidate;
import iih.ci.ord.s.external.thirdws.op.base.OpEmsCommonSaveBP;

/**
 * 手术医疗单保存逻辑
 * 
 * @author zhangwq
 *
 */
public class ThirdEmsOprSaveBP extends OpEmsCommonSaveBP {

	
	public ThirdEmsOprSaveBP() {
		this.setSaveAction(new EmsOprSaveAction());
		this.setValidate(new ThirdEmsApBuValidate());
	}

	public ThirdEmsOprSaveBP(EntWsDTO dataSource) {
		super(dataSource);
		this.setSaveAction(new EmsOprSaveAction());
		this.setValidate(new ThirdEmsApBuValidate());
	}
	
	

	
	
}
