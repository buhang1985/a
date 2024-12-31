package iih.ci.ord.s.external.thirdws.op.ris;



import iih.ci.ord.i.external.thirdws.ent.d.EntWsDTO;
import iih.ci.ord.s.external.thirdws.op.base.OpEmsCommonSaveBP;


/**
 * 检验医疗单处理保存逻辑
 * 
 * @author zhangwq
 *
 */
public class ThirdEmsRisSaveBP extends OpEmsCommonSaveBP {
	public ThirdEmsRisSaveBP() {
		this.setValidate(new ThirdEmsRisValidate());
		this.setSaveAction(new EmsRisSaveAction());
	}

	public ThirdEmsRisSaveBP(EntWsDTO dataSource) {
		super(dataSource);
		this.setValidate(new ThirdEmsRisValidate());
		this.setSaveAction(new EmsRisSaveAction());
	}
	
}
