package iih.ci.ord.s.external.thirdws.op.drugs;

import iih.ci.ord.i.external.thirdws.ent.d.EntWsDTO;
import iih.ci.ord.s.external.thirdws.op.base.OpEmsCommonSaveBP;

/**
 * 药品医疗单，根据传入的数据源，完善医疗单信息并保存
 * 
 * @author zhangwq
 *
 */
public class ThirdEmsDrugsSaveBP extends OpEmsCommonSaveBP {

	public ThirdEmsDrugsSaveBP() {
		this.setValidate(new ThirdEmsDrugsValidate());
		this.setSaveAction(new EmsDrugSaveAction());
	}

	public ThirdEmsDrugsSaveBP(EntWsDTO dataSource) {
		super(dataSource);
		this.setValidate(new ThirdEmsDrugsValidate());
		this.setSaveAction(new EmsDrugSaveAction());
	}

}
