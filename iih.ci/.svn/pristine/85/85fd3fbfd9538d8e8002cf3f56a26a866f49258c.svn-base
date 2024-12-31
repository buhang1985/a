package iih.ci.ord.s.external.thirdws.op.treat;

import iih.ci.ord.i.external.thirdws.ent.d.EntWsDTO;
import iih.ci.ord.s.external.thirdws.op.base.OpEmsCommonSaveBP;

/**
 * 治疗医疗单保存逻辑 EntWstreatDTO 参数包含关系：EntWstreatDTO 父 EmstreatOrdDTO 子 
 * EmstreatSrvDTO 孙
 * 
 * @author 李岳
 *
 */
public class ThirdEmsTreatSaveBP extends OpEmsCommonSaveBP {
	public ThirdEmsTreatSaveBP() {
		this.setValidate(new ThirdEmsTreatValidate());
		this.setSaveAction(new EmsTreatSaveAction());
	}

	public ThirdEmsTreatSaveBP(EntWsDTO dataSource) {
		super(dataSource);
		this.setValidate(new ThirdEmsTreatValidate());
		this.setSaveAction(new EmsTreatSaveAction());
	}
}
