package iih.bd.pp.anhuiinsur.bgtasks.bp;

import java.io.InputStream;

import iih.bd.base.utils.FileServerUtils;
import iih.bd.pp.hpsrvorca.d.HpSrvTpEnum;
import iih.bd.pp.medinsurdown.d.MedInsurFileDownRecDO;
import xap.mw.core.data.BizException;

/**
 * 导入医保计划信息业务逻辑
 * 
 * @author hao_wu
 *
 */
public class ImportMedInsurRecBp {

	public void exec(MedInsurFileDownRecDO downRec) throws BizException {
		if (downRec == null) {
			throw new BizException("医保下载记录不允许为空。");
		}

		ImportMedInsurRec(downRec);
	}

	/**
	 * 导入医保记录
	 * 
	 * @param fileKey
	 * @param hpCode
	 * @param _hpSrvTp
	 * @throws BizException
	 */
	private void ImportMedInsurRec(MedInsurFileDownRecDO downRec) throws BizException {
		InputStream fileStream = FileServerUtils.Download(downRec.getFileid(), true);
		ImportMedInsurRec(fileStream, downRec);
	}

	/**
	 * 导入医保计划信息
	 * 
	 * @param fileStream
	 * @param hpdo
	 * @param _hpSrvTp
	 * @throws BizException
	 */
	private void ImportMedInsurRec(InputStream fileStream, MedInsurFileDownRecDO medInsurFileDownRec)
			throws BizException {
		Integer hpSrvTp = medInsurFileDownRec.getEu_cenprokind();

		if (hpSrvTp.equals(HpSrvTpEnum.DRUG)) {
			ImportMedInsurDrugRec(fileStream, medInsurFileDownRec);
		} else if (hpSrvTp.equals(HpSrvTpEnum.ZL)) {
			ImportMedInsurZlRec(fileStream, medInsurFileDownRec);
		} else if (hpSrvTp.equals(HpSrvTpEnum.FWSS)) {
			ImportMedInsurFwssRec(fileStream, medInsurFileDownRec);
		} else if (hpSrvTp.equals(HpSrvTpEnum.DI)) {
			ImportMedInsurFwssRec(fileStream, medInsurFileDownRec);
		}
	}

	/**
	 * 导入医保诊疗
	 * 
	 * @param fileStream
	 * @throws BizException
	 */
	private void ImportMedInsurZlRec(InputStream fileStream, MedInsurFileDownRecDO medInsurFileDownRec)
			throws BizException {
		ImportMedInsurZlRecBp bp = new ImportMedInsurZlRecBp();
		bp.exec(fileStream, medInsurFileDownRec);
	}

	/**
	 * 导入医保服务设施
	 * 
	 * @param fileStream
	 * @throws BizException
	 */
	private void ImportMedInsurFwssRec(InputStream fileStream, MedInsurFileDownRecDO medInsurFileDownRec)
			throws BizException {
		ImportMedInsurFwssRecBp bp = new ImportMedInsurFwssRecBp();
		bp.exec(fileStream, medInsurFileDownRec);
	}

	/**
	 * 导入医保药品
	 * 
	 * @param fileStream
	 * @throws BizException
	 */
	private void ImportMedInsurDrugRec(InputStream fileStream, MedInsurFileDownRecDO medInsurFileDownRec)
			throws BizException {
		ImportMedInsurDrugRecBp bp = new ImportMedInsurDrugRecBp();
		bp.exec(fileStream, medInsurFileDownRec);
	}
}
