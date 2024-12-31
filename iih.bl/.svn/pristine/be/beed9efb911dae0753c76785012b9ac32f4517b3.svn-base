package iih.bl.inc.bp.reinc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import iih.bd.base.utils.AppUtils;
import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.d.BlcgoepAggDO;
import iih.bl.cg.blcgoep.i.IBlCgItmOepDORService;
import iih.bl.cg.blcgoep.i.IBlcgoepRService;
import iih.bl.inc.blincip.d.BlincipAggDO;
import iih.bl.inc.blincip.i.IBlincipCudService;
import iih.bl.inc.blincip.i.IBlincipRService;
import iih.bl.inc.blincoep.d.BlincoepAggDO;
import iih.bl.inc.blincoep.i.IBlincoepCudService;
import iih.bl.inc.blincoep.i.IBlincoepRService;
import iih.bl.inc.blreinccgitmdto.d.BlReIncCgItmDTO;
import iih.bl.inc.blreinccgitmdto.d.BlReIncPageDTO;
import iih.bl.inc.blreinclog.d.BlReIncLog;
import iih.bl.inc.blreinclog.i.IBlreinclogCudService;
import iih.bl.inc.dto.blincprint.d.BlIncPrintDTO;
import iih.bl.inc.i.IBlIncOutCmdService;
import iih.bl.inc.s.bp.opinc.OpIncReprintInvioceBP;
import iih.bl.inc.s.oldbp.InvalidateIpIncBp;
import iih.bl.inc.s.util.InvoicePrintUtil;
import iih.bl.params.BlParamsAnalysisUtil;
import iih.bl.st.blstip.d.BlStIpDO;
import iih.bl.st.blstip.i.IBlstipRService;
import iih.bl.st.blstoep.d.BlStOepDO;
import iih.bl.st.blstoep.i.IBlstoepRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

public class ReIncByCgItmBP {

	/**
	 * 门诊拆票，通过记账明细进行划分
	 * @param cgitms
	 * @return
	 * @throws BizException
	 */
	public String exec(BlReIncPageDTO[] cgitms) throws BizException {
		if (cgitms == null || cgitms.length == 0)
			return null;
		FDateTime nowTime = AppUtils.getServerDateTime();
		FArrayList2 arr = cgitms[0].getReincitms();
		String strOldIdstoep = ((BlReIncCgItmDTO) arr.get(0)).getId_st();

		IBlincoepRService blincoepService = ServiceFinder.find(IBlincoepRService.class);
		BlincoepAggDO[] blincoepDOArr = blincoepService.find(" a0.id_stoep = '" + strOldIdstoep + "' ", null,
				FBoolean.FALSE);
		String inccaId = blincoepDOArr[0].getParentDO().getId_incca();
		FBoolean fgEcInc = BlParamsAnalysisUtil.BLINC0029(inccaId);
		if(fgEcInc.booleanValue())
		{
			throw new BizException("电子发票不能手工拆票!");
		}
		
		IBlstoepRService blstService = ServiceFinder.find(IBlstoepRService.class);
		BlStOepDO oldstOepDO = blstService.findById(strOldIdstoep);

		IBlCgItmOepDORService cgitmService = ServiceFinder.find(IBlCgItmOepDORService.class);
		BlCgItmOepDO[] oldcgitms = cgitmService.find(" Id_stoep = '" + strOldIdstoep + "' ", null, FBoolean.FALSE);
		Set<String> strCgIds = new HashSet<String>();
		for (int i = 0; i < oldcgitms.length; i++) {
			strCgIds.add(oldcgitms[i].getId_cgoep());
		}

		IBlcgoepRService cgService = ServiceFinder.find(IBlcgoepRService.class);
		String[] cgIds = new String[strCgIds.size()];
		cgIds = strCgIds.toArray(new String[0]);
		BlcgoepAggDO[] oldcgAggs = cgService.findByIds(cgIds, FBoolean.FALSE);

		FBoolean bPrint = blincoepDOArr[0].getParentDO().getFg_print();
		if (bPrint == null) {
			return null;
		}

		// 1、如果原票没打印，则删除原有未打印发票信息，重新生成正向发票
		if (bPrint.equals(FBoolean.FALSE)) {
			IBlincoepCudService incSaveService = ServiceFinder.find(IBlincoepCudService.class);
			incSaveService.delete(blincoepDOArr);

			IBlIncOutCmdService incService = ServiceFinder.find(IBlIncOutCmdService.class);
			incService.saveReInvoice(oldcgAggs, cgitms);

			BlReIncLog logDO = getOepLog(oldstOepDO, null, nowTime);
			IBlreinclogCudService logService = ServiceFinder.find(IBlreinclogCudService.class);
			logService.save(new BlReIncLog[]{ logDO});
			
			return strOldIdstoep;
		}
		// 2、如果原票打印了，则红冲结算收付款发票，再重新生成结算收付款发票信息
		else if (bPrint.equals(FBoolean.TRUE)) {
			OpIncReprintInvioceBP updateBp = new OpIncReprintInvioceBP();
			updateBp.updateReIncData(blincoepDOArr); 

			IBlIncOutCmdService incService = ServiceFinder.find(IBlIncOutCmdService.class);
			BlincoepAggDO[] reincs = incService.saveReInvoice(oldcgAggs, cgitms);

			BlReIncLog logDO = getOepLog(oldstOepDO, null, nowTime);
			IBlreinclogCudService logService = ServiceFinder.find(IBlreinclogCudService.class);
			logService.save(new BlReIncLog[]{ logDO});
			
			return strOldIdstoep;
			
		}

		return "";
	}

	/**
	 * 门诊重拆票，通过发票项进行拆票
	 * @param incItms
	 * @return
	 * @throws BizException
	 */
	public String execIp(BlReIncPageDTO[] incItms) throws BizException {
		if (incItms == null || incItms.length == 0)
			return null;

		FDateTime nowTime = AppUtils.getServerDateTime();

		String strOldIdstip = incItms[0].getId_st();

		IBlincipRService blincipService = ServiceFinder.find(IBlincipRService.class);
		BlincipAggDO[] blincipDOArr = blincipService.find(" a0.id_stip = '" + strOldIdstip + "' ", null,
				FBoolean.FALSE);
		String inccaId = blincipDOArr[0].getParentDO().getId_incca();
		FBoolean fgEcInc = BlParamsAnalysisUtil.BLINC0029(inccaId);
		if(fgEcInc.booleanValue())
		{
			throw new BizException("电子发票不能手工拆票!");
		}

		IBlstipRService blstService = ServiceFinder.find(IBlstipRService.class);
		BlStIpDO oldstIpDO = blstService.findById(strOldIdstip);

		FBoolean bPrint = blincipDOArr[0].getParentDO().getFg_print();
		if (bPrint == null) {
			return null;
		}

		if (bPrint.equals(FBoolean.FALSE)) {
			IBlincipCudService incSaveService = ServiceFinder.find(IBlincipCudService.class);
			incSaveService.delete(blincipDOArr);

			IBlIncOutCmdService incService = ServiceFinder.find(IBlIncOutCmdService.class);
			incService.saveIpReInvoice(oldstIpDO, incItms);

			BlReIncLog logDO = getIpLog(oldstIpDO, null, nowTime);
			IBlreinclogCudService logService = ServiceFinder.find(IBlreinclogCudService.class);
			logService.save(new BlReIncLog[]{ logDO});
			
			return strOldIdstip;
		} else {
			List<String> incIdList = new ArrayList<String>();
			for (int i = 0; i < blincipDOArr.length; i++) {
				incIdList.add(blincipDOArr[i].getParentDO().getId_incip());
			}
			String[] incIds = incIdList.toArray(new String[0]);

			InvalidateIpIncBp bp = new InvalidateIpIncBp();
			bp.execReIncIp(incIds);


			IBlIncOutCmdService incService = ServiceFinder.find(IBlIncOutCmdService.class);
			incService.saveIpReInvoice(oldstIpDO, incItms);

			BlReIncLog logDO = getIpLog(oldstIpDO, null, nowTime);
			IBlreinclogCudService logService = ServiceFinder.find(IBlreinclogCudService.class);
			logService.save(new BlReIncLog[]{ logDO});
			
			return strOldIdstip;
		}
	}
	
	/**
	 * 组装重拆票的日志数据
	 * @param oldstOepDO
	 * @param newstOepDO
	 * @param nowTime
	 * @return
	 */
	private BlReIncLog getOepLog(BlStOepDO oldstOepDO, BlStOepDO newstOepDO, FDateTime nowTime)
	{
		BlReIncLog logDO = new   BlReIncLog();
		logDO.setId_pat(oldstOepDO.getId_pat());
		logDO.setId_ent(oldstOepDO.getId_ent());
		logDO.setCode_entp(oldstOepDO.getCode_enttp());
		logDO.setId_entp(oldstOepDO.getId_enttp());
		logDO.setId_stoep_orgin(oldstOepDO.getId_stoep());
		if(newstOepDO != null)
			logDO.setId_stoep_new(newstOepDO.getId_stoep());
		else
		{
			logDO.setId_stoep_new(oldstOepDO.getId_stoep());
		}
		logDO.setDt_oper(nowTime);
		logDO.setId_emp_oper(Context.get().getStuffId());
		logDO.setId_dep_oper(Context.get().getDeptId());
		logDO.setId_org(Context.get().getOrgId());
		logDO.setId_grp(Context.get().getGroupId());
		logDO.setStatus(DOStatus.NEW);
		return logDO;
	}
	
	/**
	 * 组装住院拆票日志
	 * @param oldstIpDO
	 * @param newstIpDO
	 * @param nowTime
	 * @return
	 */
	private BlReIncLog getIpLog(BlStIpDO oldstIpDO, BlStIpDO newstIpDO, FDateTime nowTime)
	{
		BlReIncLog logDO = new   BlReIncLog();
		logDO.setId_pat(oldstIpDO.getId_pat());
		logDO.setId_ent(oldstIpDO.getId_ent());
		logDO.setCode_entp(oldstIpDO.getCode_enttp());
		logDO.setId_entp(oldstIpDO.getId_enttp());
		logDO.setId_stoep_orgin(oldstIpDO.getId_stip());
		if(newstIpDO != null)
			logDO.setId_stoep_new(newstIpDO.getId_stip());
		else
		{
			logDO.setId_stoep_new(oldstIpDO.getId_stip());
		}
		logDO.setDt_oper(nowTime);
		logDO.setId_emp_oper(Context.get().getStuffId());
		logDO.setId_dep_oper(Context.get().getDeptId());
		logDO.setId_org(Context.get().getOrgId());
		logDO.setId_grp(Context.get().getGroupId());
		logDO.setStatus(DOStatus.NEW);
		return logDO;
	}

}
