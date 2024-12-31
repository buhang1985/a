package iih.bd.pp.anhuiinsur.bgtasks.bp;

import iih.bd.base.utils.AppUtils;
import iih.bd.pp.anhuiinsur.bgtasks.IBdPpBgTaskCodeConst;
import iih.bd.pp.anhuiinsur.bgtasks.IBdPpBgTaskParamCodeConst;
import iih.bd.pp.medinsurdown.d.MedInsurFileDownRecDO;
import iih.bd.pp.medinsurdown.i.IMedinsurfiledownrecRService;
import iih.bd.pp.medinsurrecdiff.d.AHMedIRecDiffState;
import iih.bd.pp.medinsurrecdiff.d.MedInsurRecDiffDO;
import iih.bd.pp.medinsurrecdiff.i.IMedinsurrecdiffMDOCudService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.FMap2;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.devcfg.alert.taskcenter.itf.ISchedulerServiceAPI;

/**
 * 根据下载主键和医保服务类型开始生成差异信息</br>
 * 和上次下载进行差异对比
 * 
 * @author hao_wu
 *
 */
public class StartGenerateDiffInfoByDownIdBp {

	public void exec(MedInsurFileDownRecDO fileDownRec) throws BizException {
		MedInsurFileDownRecDO preDown = FindPreDown(fileDownRec);
		if (preDown == null) {
			return;
		}
		MedInsurRecDiffDO newRecDiff = CreateNewRecDiff(fileDownRec, preDown);

		StartGenerateDiffInfoBgTask(newRecDiff);
	}

	/**
	 * 创建新的记录差异信息
	 * 
	 * @param curFileDown
	 * @param preFileDown
	 * @return
	 * @throws BizException
	 */
	private MedInsurRecDiffDO CreateNewRecDiff(MedInsurFileDownRecDO curFileDown, MedInsurFileDownRecDO preFileDown)
			throws BizException {
		MedInsurRecDiffDO newData = new MedInsurRecDiffDO();
		newData.setId_grp(Context.get().getGroupId());
		newData.setId_org(Context.get().getOrgId());
		newData.setDt_diff(AppUtils.getServerDateTime());
		newData.setEu_hpsrvtp(curFileDown.getEu_cenprokind());
		newData.setEu_state(AHMedIRecDiffState.COMPARING);
		newData.setId_predown(preFileDown.getId_down());
		newData.setId_curdown(curFileDown.getId_down());

		IMedinsurrecdiffMDOCudService medinsurrecdiffMDOCudService = ServiceFinder
				.find(IMedinsurrecdiffMDOCudService.class);
		MedInsurRecDiffDO[] medInsurRecDiffs = medinsurrecdiffMDOCudService.insert(new MedInsurRecDiffDO[] { newData });
		return medInsurRecDiffs[0];
	}

	/**
	 * 开始生成差异信息
	 * 
	 * @param medInsurRecDiffDO
	 */
	private void StartGenerateDiffInfoBgTask(MedInsurRecDiffDO medInsurRecDiffDO) {
		FMap2 paramMap = new FMap2();
		paramMap.put(IBdPpBgTaskParamCodeConst.CODE_GENERATEDIFFINFO_DIFFID, medInsurRecDiffDO.getId_diff());

		ISchedulerServiceAPI schedulerServiceAPI = ServiceFinder.find(ISchedulerServiceAPI.class);
		schedulerServiceAPI.submitTask1(IBdPpBgTaskCodeConst.CODE_GENERATEDIFFINFO, paramMap);
	}

	/**
	 * 查找上一次下载记录
	 * 
	 * @param fileDownRec
	 * @return
	 * @throws BizException
	 */
	private MedInsurFileDownRecDO FindPreDown(MedInsurFileDownRecDO fileDownRec) throws BizException {
		PaginationInfo pg = new PaginationInfo();
		pg.setPageSize(1);
		pg.setPageIndex(0);

		String wherePart = String.format("Dt_down < '%s' and Eu_cenprokind = '%s'", fileDownRec.getDt_down(),
				fileDownRec.getEu_cenprokind());

		String orderPart = "dt_down desc";

		IMedinsurfiledownrecRService medinsurfiledownrecRService = ServiceFinder
				.find(IMedinsurfiledownrecRService.class);
		PagingRtnData<MedInsurFileDownRecDO> result = medinsurfiledownrecRService.findByPageInfo(pg, wherePart,
				orderPart);

		if (result != null && result.getPageData() != null && result.getPageData().size() > 0) {
			return (MedInsurFileDownRecDO) result.getPageData().get(0);
		}

		return null;
	}
}
