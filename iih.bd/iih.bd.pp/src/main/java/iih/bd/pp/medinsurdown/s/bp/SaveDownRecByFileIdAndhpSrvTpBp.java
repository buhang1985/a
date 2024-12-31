package iih.bd.pp.medinsurdown.s.bp;

import org.apache.commons.lang.StringUtils;

import iih.bd.base.utils.AppUtils;
import iih.bd.pp.anhuiinsur.bgtasks.IBdPpBgTaskCodeConst;
import iih.bd.pp.anhuiinsur.bgtasks.IBdPpBgTaskParamCodeConst;
import iih.bd.pp.medinsurdown.d.MedInsurFileDownRecDO;
import iih.bd.pp.medinsurdown.i.IMedinsurfiledownrecCudService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.FMap2;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.devcfg.alert.taskcenter.itf.ISchedulerServiceAPI;

/**
 * 根据文件Id和医保项目类型保存安徽医保文件下载记录业务逻辑
 * 
 * @author hao_wu
 *
 */
public class SaveDownRecByFileIdAndhpSrvTpBp {

	public MedInsurFileDownRecDO exec(String fileId, Integer hpSrvTp) throws BizException {
		if (StringUtils.isEmpty(fileId)) {
			throw new BizException("文件ID不允许为空");
		}
		if (hpSrvTp == null) {
			throw new BizException("医保项目类型不允许为空");
		}

		MedInsurFileDownRecDO result = SaveDownRec(fileId, hpSrvTp);
		StartImportMedInsurRecBgTask(result);
		return result;
	}

	/**
	 * 开始导入医保记录后台任务
	 * 
	 * @param downRec
	 */
	private void StartImportMedInsurRecBgTask(MedInsurFileDownRecDO downRec) {
		FMap2 paramMap = new FMap2();
		paramMap.put(IBdPpBgTaskParamCodeConst.CODE_IMPORTMEDINSURREC_DOWNRECID, downRec.getId_down());

		ISchedulerServiceAPI schedulerServiceAPI = ServiceFinder.find(ISchedulerServiceAPI.class);
		schedulerServiceAPI.submitTask1(IBdPpBgTaskCodeConst.CODE_IMPORTMEDINSURREC, paramMap);
	}

	/**
	 * 保存下载记录
	 * 
	 * @param fileId
	 *            文件ID
	 * @param hpSrvTp
	 *            医保项目类型
	 * @return
	 * @throws BizException
	 */
	private MedInsurFileDownRecDO SaveDownRec(String fileId, Integer hpSrvTp) throws BizException {
		MedInsurFileDownRecDO newData = new MedInsurFileDownRecDO();
		newData.setId_grp(Context.get().getGroupId());
		newData.setId_org(Context.get().getOrgId());
		newData.setEu_cenprokind(hpSrvTp);
		newData.setDt_down(AppUtils.getServerDateTime());
		newData.setFileid(fileId);

		IMedinsurfiledownrecCudService medinsurfiledownrecCudService = ServiceFinder
				.find(IMedinsurfiledownrecCudService.class);
		MedInsurFileDownRecDO[] result = medinsurfiledownrecCudService.insert(new MedInsurFileDownRecDO[] { newData });
		return result[0];
	}

}
