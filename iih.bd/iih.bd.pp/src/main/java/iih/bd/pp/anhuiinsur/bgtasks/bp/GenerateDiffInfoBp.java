package iih.bd.pp.anhuiinsur.bgtasks.bp;

import iih.bd.pp.hpsrvorca.d.HpSrvTpEnum;
import iih.bd.pp.medinsurrecdiff.d.AHMedIRecDiffState;
import iih.bd.pp.medinsurrecdiff.d.MedInsurRecDiffDO;
import iih.bd.pp.medinsurrecdiff.i.IMedinsurrecdiffMDOCudService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 生成差异信息业务逻辑
 * 
 * @author hao_wu
 *
 */
public class GenerateDiffInfoBp {

	public void exec(MedInsurRecDiffDO recDiff) throws BizException {
		if (recDiff == null) {
			throw new BizException("差异信息不允许为空。");
		}

		GenerateDiffInfo(recDiff);
		UpdateState(recDiff);
	}

	/**
	 * 根据差异描述生成差异信息
	 * 
	 * @param recDiff
	 * @throws BizException
	 */
	private void GenerateDiffInfo(MedInsurRecDiffDO recDiff) throws BizException {
		if (HpSrvTpEnum.DRUG.equals(recDiff.getEu_hpsrvtp())) {
			GenerateDrugDiffInfo(recDiff);
		} else if (HpSrvTpEnum.ZL.equals(recDiff.getEu_hpsrvtp())) {
			GenerateTreatDiffInfo(recDiff);
		} else if (HpSrvTpEnum.FWSS.equals(recDiff.getEu_hpsrvtp())) {
			GenerateSrvFacDiffInfo(recDiff);
		}
	}

	/**
	 * 根据差异描述生成药品差异信息
	 * 
	 * @param recDiff
	 * @throws BizException
	 */
	private void GenerateDrugDiffInfo(MedInsurRecDiffDO recDiff) throws BizException {
		GenerateDrugDiffInfoBp bp = new GenerateDrugDiffInfoBp();
		bp.exec(recDiff);
	}

	/**
	 * 根据差异描述生成诊疗差异信息
	 * 
	 * @param recDiff
	 * @throws BizException
	 */
	private void GenerateTreatDiffInfo(MedInsurRecDiffDO recDiff) throws BizException {
		GenerateTreatDiffInfoBp bp = new GenerateTreatDiffInfoBp();
		bp.exec(recDiff);
	}

	/**
	 * 根据差异描述生成服务设施差异信息
	 * 
	 * @param recDiff
	 * @throws BizException
	 */
	private void GenerateSrvFacDiffInfo(MedInsurRecDiffDO recDiff) throws BizException {
		GenerateSrvFacDiffInfoBp bp = new GenerateSrvFacDiffInfoBp();
		bp.exec(recDiff);
	}

	/**
	 * 更新状态
	 * 
	 * @param recDiff
	 * @throws BizException
	 */
	private void UpdateState(MedInsurRecDiffDO recDiff) throws BizException {
		recDiff.setEu_state(AHMedIRecDiffState.COMPLETE);
		recDiff.setStatus(DOStatus.UNCHANGED);
		IMedinsurrecdiffMDOCudService medinsurrecdiffMDOCudService = ServiceFinder
				.find(IMedinsurrecdiffMDOCudService.class);
		medinsurrecdiffMDOCudService.update(new MedInsurRecDiffDO[] { recDiff });
	}
}
