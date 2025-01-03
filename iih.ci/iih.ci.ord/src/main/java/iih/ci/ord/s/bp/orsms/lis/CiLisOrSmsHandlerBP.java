package iih.ci.ord.s.bp.orsms.lis;

import java.util.Arrays;
import java.util.List;

import iih.ci.ord.app.d.CiapplissheetAggDO;
import iih.ci.ord.cior.d.CiOrSessionDO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.dto.mergetube.d.MergeTubeRstDTO;
import iih.ci.ord.dto.mergetube.d.MergeTubeRstEnum;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.orsms.d.CiLisOrSmsIoDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.cfg.rulecfg.rule.lis.SplitLisSetNoticesBP;
import iih.ci.ord.s.bp.orsms.lis.listener.MergeTubeAction;
import iih.ci.ord.s.bp.orsms.lis.mergetube.MergeTubeBP;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;

public class CiLisOrSmsHandlerBP {
	public List<CiLisOrSmsIoDTO> exec(CiEnContextDTO ctx, CiOrderDO[] ciors, CiOrSessionDO session)
			throws BizException {
		long startTIme1 = System.currentTimeMillis();
		long startTIme = System.currentTimeMillis();
		CiOrdUtils.getlogger().info("" + System.currentTimeMillis() + "毫秒");
		ciors=smsLisOrFilterHandle(ciors);
		if(CiOrdUtils.isEmpty(ciors))return null;
		
		List<CiLisOrSmsIoDTO> orsmsiolists=convertCiOr2CiOrSmsIoList(ciors);
		if(CiOrdUtils.isEmpty(orsmsiolists))return null;
		CiOrdUtils.getlogger().info("CiLisOrSmsHandlerBP 检验合单查询合单数据时间  .." + (System.currentTimeMillis() - startTIme) + "毫秒");
		
		startTIme = System.currentTimeMillis();
		//根据规则将检验数据合单
		orsmsiolists=ciOrSmsIoRuleArrangePluginExec(ctx,orsmsiolists);
		
		CiOrdUtils.getlogger().info("CiLisOrSmsHandlerBP 检验按规则拆分  .." + (System.currentTimeMillis() - startTIme) + "毫秒");
		startTIme = System.currentTimeMillis();
       //获取注意事项
		orsmsiolists=getAnnouncements(orsmsiolists);
		
		CiOrdUtils.getlogger().info("CiLisOrSmsHandlerBP 检验合单获取注意事项  .." + (System.currentTimeMillis() - startTIme) + "毫秒");
		startTIme = System.currentTimeMillis();
		//生成检验申请单并保存检验申请单
		genLisSheetByOrdSmsInfo(ciors,orsmsiolists, session); 
		
		CiOrdUtils.getlogger().info("CiLisOrSmsHandlerBP 检验合单保存  .." + (System.currentTimeMillis() - startTIme) + "毫秒");
		CiOrdUtils.getlogger().info("CiLisOrSmsHandlerBP 检验合单总耗时  .." + (System.currentTimeMillis() - startTIme1) + "毫秒");
		return orsmsiolists;
	}

	public MergeTubeRstDTO megeTube(CiEnContextDTO ctx, CiOrderDO[] ciors, CiOrSessionDO session)
			throws BizException {
		long startTIme1 = System.currentTimeMillis();
		long startTIme = System.currentTimeMillis();
		CiOrdUtils.getlogger().info("" + System.currentTimeMillis() + "毫秒");
		ciors = smsLisOrFilterHandle(ciors);
		if (CiOrdUtils.isEmpty(ciors))
			return null;

		List<CiLisOrSmsIoDTO> orsmsiolists = convertCiOr2CiOrSmsIoList(ciors);
		if (CiOrdUtils.isEmpty(orsmsiolists))
			return null;
		CiOrdUtils.getlogger()
				.info("CiLisOrSmsHandlerBP 检验合单查询合单数据时间  .." + (System.currentTimeMillis() - startTIme) + "毫秒");

		startTIme = System.currentTimeMillis();
		// 根据规则将检验数据合单
		orsmsiolists = ciOrSmsIoRuleArrangePluginExec(ctx, orsmsiolists);

		CiOrdUtils.getlogger()
				.info("CiLisOrSmsHandlerBP 检验按规则拆分  .." + (System.currentTimeMillis() - startTIme) + "毫秒");
		startTIme = System.currentTimeMillis();
		// 获取注意事项
		orsmsiolists = getAnnouncements(orsmsiolists);

		CiOrdUtils.getlogger()
				.info("CiLisOrSmsHandlerBP 检验合单获取注意事项  .." + (System.currentTimeMillis() - startTIme) + "毫秒");
		startTIme = System.currentTimeMillis();
		// 生成检验申请单并保存检验申请单
		CiapplissheetAggDO[] lissheets = createAppLisSheet(ciors, orsmsiolists, session);
		MergeTubeRstDTO mergeTubeRstDTO = null;
		
		if(FBoolean.TRUE.equals(orsmsiolists.get(0).getIsthird())){
			mergeTubeRstDTO = customMergeTubeOrds(ctx,lissheets, ciors,orsmsiolists);
		}else{
			// 根据合单规则，创建合管费用，生成容器费和采集费
			mergeTubeRstDTO = mergeTubeContpAndSampcolOrds(ctx,lissheets, ciors);
		}
		
		FArrayList list = new FArrayList();
		list.addAll(Arrays.asList(lissheets));
		// 合管存在需要医生操作的提示信息
		mergeTubeRstDTO.setCiapplissheet(list);
		if (MergeTubeRstEnum.FAIL.equals(mergeTubeRstDTO.getRstStatus())) {
			return mergeTubeRstDTO;
		}
		this.saveAppLisSheet(ctx,lissheets);
		
		CiOrdUtils.getlogger().info("CiLisOrSmsHandlerBP 检验合单保存  .." + (System.currentTimeMillis() - startTIme) + "毫秒");
		CiOrdUtils.getlogger()
				.info("CiLisOrSmsHandlerBP 检验合单总耗时  .." + (System.currentTimeMillis() - startTIme1) + "毫秒");
		return mergeTubeRstDTO;
	}
	
	protected MergeTubeRstDTO customMergeTubeOrds(CiEnContextDTO ctx, CiapplissheetAggDO[] lissheets, CiOrderDO[] ciors,
			List<CiLisOrSmsIoDTO> orsmsiolists) throws BizException {
		MergeTubeBP mergeTubeBP = getMergeTubeBP(ctx);
		MergeTubeRstDTO mergeTubeRstDTO = mergeTubeBP.customMergeTubeOrds(lissheets, ciors,orsmsiolists);
		return mergeTubeRstDTO;
	}

	public MergeTubeRstDTO exec(CiEnContextDTO ctx, MergeTubeRstDTO mergeTubeRstDTO) throws BizException {
		MergeTubeBP mergeTubeBP = getMergeTubeBP(ctx);
		mergeTubeRstDTO =  mergeTubeBP.exec(mergeTubeRstDTO);
		CiapplissheetAggDO[] sheetAgg = this.saveAppLisSheet(ctx,(CiapplissheetAggDO[])mergeTubeRstDTO.getCiapplissheet().toArray(new CiapplissheetAggDO[0]));
	    return mergeTubeRstDTO;
	}

	protected MergeTubeRstDTO mergeTubeContpAndSampcolOrds(CiEnContextDTO ctx, CiapplissheetAggDO[] lissheets,
			CiOrderDO[] ciors) throws BizException {
		MergeTubeBP mergeTubeBP = getMergeTubeBP(ctx);
		return mergeTubeBP.exec(lissheets);
	}
	public MergeTubeBP getMergeTubeBP(CiEnContextDTO ctx){
		return new MergeTubeBP(ctx);
	}
	/**
	 * 临床医嘱分方时，分方医嘱过滤与处理
	 * 
	 * @param ciorder
	 * @param session
	 * @return
	 * @throws BizException
	 */
	protected CiOrderDO[] smsLisOrFilterHandle(CiOrderDO[] ciorder) throws BizException {
		CiOrSmsLisOrFilterHandleBP bp = new CiOrSmsLisOrFilterHandleBP();
		return bp.exec(ciorder);
	}

	protected List<CiLisOrSmsIoDTO> convertCiOr2CiOrSmsIoList(CiOrderDO[] ciors) throws BizException {
		CiOr2CiOrSmsIoListBP bp = new CiOr2CiOrSmsIoListBP();
		return bp.exec(ciors);
	}

	protected List<CiLisOrSmsIoDTO> ciOrSmsIoRuleArrangePluginExec(CiEnContextDTO ctx,
			List<CiLisOrSmsIoDTO> orpressplitlists) throws BizException {
		MergeTubeAction action = new MergeTubeAction();
		return action.megeTube(ctx, orpressplitlists);
	}

	/**
	 * 生成处方并保存
	 * 
	 * @return
	 * @throws BizException
	 */
	protected CiapplissheetAggDO[] genLisSheetByOrdSmsInfo(CiOrderDO[] ciors, List<CiLisOrSmsIoDTO> orpressplitlists,
			CiOrSessionDO session) throws BizException {
		CiOrSmsList2CiOrLisSheetHandleBP bp = new CiOrSmsList2CiOrLisSheetHandleBP();
		return bp.exec(ciors, orpressplitlists, session);
	}
	/**
	 * 创建打印申请单
	 * @param ciors
	 * @param orpressplitlists
	 * @param session
	 * @return
	 * @throws BizException
	 */
	protected CiapplissheetAggDO[] createAppLisSheet(CiOrderDO[] ciors, List<CiLisOrSmsIoDTO> orpressplitlists,
			CiOrSessionDO session) throws BizException {
		CiOrSmsList2CiOrLisSheetHandleBP bp = new CiOrSmsList2CiOrLisSheetHandleBP();
		return bp.createAppLisSheet(ciors, orpressplitlists, session);
	}
	/**
	 * 保存打印申请单
	 * @param lissheet
	 * @return
	 * @throws BizException
	 */
	protected CiapplissheetAggDO[] saveAppLisSheet(CiEnContextDTO ctx,CiapplissheetAggDO[] lissheet) throws BizException{
		CiOrSmsList2CiOrLisSheetHandleBP bp = new CiOrSmsList2CiOrLisSheetHandleBP();
		CiapplissheetAggDO[] aggs = bp.saveLissheet(lissheet);
		return aggs;
	}

	/**
	 * 获取注意事项
	 * 
	 * @return
	 * @throws BizException
	 */
	protected List<CiLisOrSmsIoDTO> getAnnouncements(List<CiLisOrSmsIoDTO> orpressplitlists) throws BizException {
		SplitLisSetNoticesBP noticeBP = new SplitLisSetNoticesBP();
		return noticeBP.exec(orpressplitlists);
		/*
		 * CiLisSmsGetAnnouncementsBP bp = new CiLisSmsGetAnnouncementsBP();
		 * return bp.exec(orpressplitlists);
		 */
	}
}
