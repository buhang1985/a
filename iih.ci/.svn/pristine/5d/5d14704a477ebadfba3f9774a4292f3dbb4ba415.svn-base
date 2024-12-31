package iih.ci.ord.s.external.thirdws.op.lis;
import iih.ci.ord.i.external.thirdws.ent.d.EntWsDTO;
import iih.ci.ord.s.external.thirdws.op.base.OpEmsCommonSaveBP;

/**
 * 检验医疗单保存逻辑
 * 
 * @author LiYue
 *
 */
public class ThirdEmsLisSaveBP extends OpEmsCommonSaveBP{
	public ThirdEmsLisSaveBP() {
		this.setValidate(new ThirdEmsLisValidate());
		this.setSaveAction(new EmsLisSaveAction());
	}

	public ThirdEmsLisSaveBP(EntWsDTO dataSource) {
		super(dataSource);
		this.setValidate(new ThirdEmsLisValidate());
		this.setSaveAction(new EmsLisSaveAction());
	}
}
