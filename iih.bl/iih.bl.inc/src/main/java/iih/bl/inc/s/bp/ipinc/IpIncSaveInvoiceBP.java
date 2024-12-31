package iih.bl.inc.s.bp.ipinc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import iih.bd.base.exception.ArgumentNullException;
import iih.bd.bc.udi.pub.IBdPpCodeTypeConst;
import iih.bd.pp.incca.i.IBdInccaCodeConst;
import iih.bl.cg.blcgquery.d.BlCgIpDO;
import iih.bl.inc.blinccgip.d.BlIncCgIpDO;
import iih.bl.inc.blincip.d.BlIncIpDO;
import iih.bl.inc.blincip.d.BlIncItmIpDO;
import iih.bl.inc.blincip.d.BlincipAggDO;
import iih.bl.inc.blincip.i.IBlincipCudService;
import iih.bl.inc.blincoep.d.BlFreeMdEnum;
import iih.bl.inc.blreinccgitmdto.d.BlReIncPageDTO;
import iih.bl.inc.s.bp.ipinc.util.IpIncAssembleUtil;
import iih.bl.inc.s.bp.opinc.OpIncRePreSplitBP;
import iih.bl.inc.s.util.InvoicePrintUtil;
import iih.bl.params.BlParamsAnalysisUtil;
import iih.bl.st.blstip.d.BlStIpDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 住院生成发票数据处理类
 * 
 * @author Administrator
 *
 */
public class IpIncSaveInvoiceBP {

	/**
	 * 保存发票数据
	 * 
	 * @param cgDos
	 *            记账数据
	 * @param freeAmt
	 *            减免金额
	 * @return 住院发票数据(分票时可能为多条)
	 * @throws BizException
	 */
	public BlincipAggDO[] exec(BlCgIpDO[] cgDos, FDouble freeAmt,BlStIpDO stDO) throws BizException {

		// 1.入参校验
		this.validate(cgDos);

		List<BlCgIpDO> cgList = new ArrayList<BlCgIpDO>();
		for (BlCgIpDO cgIpDO : cgDos) {
//			if (!FBoolean.TRUE.equals(cgIpDO.getFg_refund())) {
				cgList.add(cgIpDO);
//			}
		}
		if (cgList.size() == 0) {
			return null;
		}
		
		// 判断是否开启电子发票
		FBoolean fgEcInc = BlParamsAnalysisUtil.BLINC0029(IBdInccaCodeConst.ID_INHOS_INVOICE);
		
		// 2.发票分票逻辑
		Map<String, List<BlCgIpDO>> splitMap = null;
		if(FBoolean.FALSE.equals(fgEcInc)){
			splitMap = new IpIncSplitCoreBP().split(cgList);
		}else{
			splitMap = new IpIncSplitCoreBP().noSplit(cgList);
		}

		// 3.发票数据
		List<BlincipAggDO> aggList = new ArrayList<BlincipAggDO>();
		// 发票费用明细
		List<BlIncCgIpDO> incCgDoList = new ArrayList<BlIncCgIpDO>();

		for (Entry<String, List<BlCgIpDO>> entry : splitMap.entrySet()) {
			BlincipAggDO incAggDO = IpIncAssembleUtil.assemble(entry.getValue(), incCgDoList,stDO);
			incAggDO.getParentDO().setFg_ec_inc(fgEcInc);
			aggList.add(incAggDO);
		}

		// 4.费用减免

		// 项目减免金额
		FDouble reduceItm = FDouble.ZERO_DBL;

		List<BlCgIpDO> reduceList = new ArrayList<BlCgIpDO>();

		for (BlCgIpDO cgDO : cgList) {
			if (FBoolean.TRUE.equals(cgDO.getFg_free())) {
				reduceItm.add(cgDO.getAmt_ratio());
				reduceList.add(cgDO);
			}
		}

		if (reduceList.size() != 0) {
			// 进行项目减免
			this.reduceItm(aggList, reduceList, incCgDoList);
		}

		if (freeAmt!=null && freeAmt.compareTo(FDouble.ZERO_DBL) != 0) {
			// 进行金额减免
			this.reduceAmt(aggList, freeAmt);
		}

		//IBlinccgipCudService incCgCudService = ServiceFinder.find(IBlinccgipCudService.class);
		//BlIncCgIpDO[] doArr = incCgCudService.save(incCgDoList.toArray(new BlIncCgIpDO[0]));

		IBlincipCudService incCudService = ServiceFinder.find(IBlincipCudService.class);
		BlincipAggDO[] incDOArr = incCudService.save(aggList.toArray(new BlincipAggDO[0]));
		return incDOArr;
	}

	/**
	 * 住院手工分票
	 * @param stDO
	 * @param incPages
	 * @return
	 * @throws BizException
	 */
	public BlincipAggDO[] execReInc(BlStIpDO stDO, BlReIncPageDTO[] incPages) throws BizException {
		// 1.入参校验
		if (incPages.length == 0) {
			return null;
		}

		// 判断是否开启电子发票
		FBoolean fgEcInc = BlParamsAnalysisUtil.BLINC0029(IBdInccaCodeConst.ID_INHOS_INVOICE);

		// 2.发票分票逻辑
//		Map<String, List<BlCgIpDO>> splitMap = null;
//		if (FBoolean.FALSE.equals(fgEcInc)) {
//			IpIncRePreSplitBP bp = new IpIncRePreSplitBP();
//			splitMap = bp.exec(cgList, incPages);
//		} else {
//			splitMap = new IpIncSplitCoreBP().noSplit(cgList);
//		}
		
		// 3.发票数据
		List<BlincipAggDO> aggList = new ArrayList<BlincipAggDO>();

		for (int i = 0; i < incPages.length; i++) {
			BlincipAggDO incAggDO = IpIncAssembleUtil.assembleReInc(stDO,incPages[i]);

			incAggDO.getParentDO().setFg_ec_inc(FBoolean.FALSE);
			if (incPages[i].getAmt_free() != null && 
					incPages[i].getAmt_free().compareTo(FDouble.ZERO_DBL) != 0) {
				List<BlincipAggDO> tempList = new ArrayList<BlincipAggDO>();
				tempList.add(incAggDO);
				// 进行金额减免
				this.reduceAmt(tempList, incPages[i].getAmt_free());
			}
			
			aggList.add(incAggDO);
		}

		IBlincipCudService incCudService = ServiceFinder.find(IBlincipCudService.class);
		BlincipAggDO[] incDOArr = incCudService.save(aggList.toArray(new BlincipAggDO[0]));
		return incDOArr;
	}
	/**
	 * 进行项目减免
	 * 
	 * @param aggList
	 * @param freeAmt
	 * @date 2018年8月11日
	 * @author wq.li
	 */
	private void reduceItm(List<BlincipAggDO> aggList, List<BlCgIpDO> cgItms, List<BlIncCgIpDO> incCgDoList) {

		// 发票费用明细map
		Map<String, List<BlIncCgIpDO>> incCgMap = new HashMap<String, List<BlIncCgIpDO>>();
		for (BlIncCgIpDO incCgIpDO : incCgDoList) {
			if (incCgMap.containsKey(incCgIpDO.getId_incip())) {
				List<BlIncCgIpDO> incCgMapList = incCgMap.get(incCgIpDO.getId_incip());
				incCgMapList.add(incCgIpDO);
			} else {
				List<BlIncCgIpDO> incCgMapList = new ArrayList<BlIncCgIpDO>();
				incCgMapList.add(incCgIpDO);
				incCgMap.put(incCgIpDO.getId_incip(), incCgMapList);
			}
		}

		for (BlCgIpDO cgItm : cgItms) {

			for (BlincipAggDO aggDO : aggList) {

				boolean contain = false;
				for (BlIncCgIpDO incCgItm : incCgMap.get(aggDO.getParentDO().getId_incip())) {

					if (incCgItm.getId_cgip().equals(cgItm.getId_cgip())) {
						contain = true;
						break;
					}
				}

				if (!contain) {
					continue;
				}

				FDouble free = cgItm.getAmt_ratio();

				// 设置主表减免金额
				BlIncIpDO inc = aggDO.getParentDO();
				inc.setEu_freemd(BlFreeMdEnum.ITM_FREE_MD);
				inc.setAmt(inc.getAmt().sub(free));
				inc.setAmt_free(inc.getAmt_free().add(free));

				// 设置发票项减免金额
				for (BlIncItmIpDO incItm : aggDO.getBlIncItmIpDO()) {

					if (cgItm.getCode_inccaitm().equals(incItm.getCode())) {
						incItm.setAmt(incItm.getAmt().sub(free));
						incItm.setAmt_free(incItm.getAmt_free().add(free));
						break;
					}
				}

				break;
			}
		}

	}

	/**
	 * 进行金额减免
	 * 
	 * @param aggList
	 * @param freeAmt
	 * @date 2018年8月11日
	 * @author wq.li
	 */
	private void reduceAmt(List<BlincipAggDO> aggList, FDouble freeAmt) {

		// 发票主表进行减免
		FDouble totalAmt = FDouble.ZERO_DBL;
		for (BlincipAggDO blincipAggDO : aggList) {
			totalAmt = totalAmt.add(blincipAggDO.getParentDO().getAmt());
		}
		if(totalAmt.compareTo(FDouble.ZERO_DBL)==0){
			return;
		}
		
		FDouble notLast = FDouble.ZERO_DBL;
		for (int i = 0; i < aggList.size(); i++) {

			FDouble free = null;
			if (i == aggList.size() - 1) {
				free = freeAmt.sub(notLast).setScale(-2, BigDecimal.ROUND_HALF_UP);
			} else {
				free = freeAmt.multiply(aggList.get(i).getParentDO().getAmt()).div(totalAmt).setScale(-2, BigDecimal.ROUND_HALF_UP);
			}

			BlIncIpDO inc = aggList.get(i).getParentDO();
			inc.setEu_freemd(BlFreeMdEnum.AMT_FREE_MD);
			inc.setAmt(inc.getAmt().sub(free));
			inc.setAmt_free(inc.getAmt_free().add(free));

			notLast = notLast.add(free);
		}
		// 子表进行减免
		for (BlincipAggDO aggDO : aggList) {
			FDouble itmamt = aggDO.getParentDO().getAmt_free();
			FDouble totalitmAmt=aggDO.getParentDO().getAmt().add(aggDO.getParentDO().getAmt_free());
			FDouble itmnotLast = FDouble.ZERO_DBL;
			for (int i = 0; i < aggDO.getBlIncItmIpDO().length; i++) {
				FDouble free = null;
				if (i == aggDO.getBlIncItmIpDO().length - 1) {
					free = itmamt.sub(itmnotLast).setScale(-2, BigDecimal.ROUND_HALF_UP);
				} else {
					free = itmamt.multiply(aggDO.getBlIncItmIpDO()[i].getAmt()).div(totalitmAmt).setScale(-2, BigDecimal.ROUND_HALF_UP);
				}

				BlIncItmIpDO incItm = aggDO.getBlIncItmIpDO()[i];
				incItm.setAmt(incItm.getAmt().sub(free));
				incItm.setAmt_free(incItm.getAmt_free().add(free));

				itmnotLast = itmnotLast.add(free);
			}
		}

	}

	/**
	 * 入参校验
	 * 
	 * @param cgDos
	 * @throws BizException
	 * @date 2018年8月11日
	 * @author wq.li
	 */
	private void validate(BlCgIpDO[] cgDos) throws BizException {

		if (ArrayUtil.isEmpty(cgDos)) {
			throw new ArgumentNullException("住院发票保存", "记账实体数组");
		}
	}

}
