package iih.bl.cg.s.bp;

import java.util.List;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.d.BlCgOepDO;
import iih.bl.cg.blcgoep.d.BlcgoepAggDO;
import iih.bl.cg.blcgoep.i.IBlCgItmOepDOCudService;
import iih.bl.cg.blrecgoep.d.BlRecgOepDO;
import iih.bl.cg.ep.OepReCgEP;
import iih.bl.cg.ep.RecgEP;
import iih.bl.cg.service.d.OperatorInfoDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

public class OepRepricingBP {

	/**
	 * 对指定就诊进行门诊重划价
	 * 备注：只针对补费产生的数据（即尽在CG表中存在的数据）。如果是医嘱产生的数据，则不能直接在计费阶段修改价格分类
	 * @param id_ent 就诊ID
	 * @param id_pripat_from 原价格分类
	 * @param id_pripat_to 新价格分类
	 * @param operatorInfo 操作员人员信息
	 * @return 重划价成功返回FBoolean.true ,重划价失败返回FBoolean.false
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public FBoolean exec(String id_pat,String id_ent,String id_pripat_from,String id_pripat_to,OperatorInfoDTO operatorInfo) throws BizException {
				
		FBoolean fRePricingSuccess = FBoolean.TRUE;			
		RecgEP recgEP = new RecgEP();
		OepReCgEP oepReCgEP = new OepReCgEP();
		// 1.查找指定就诊下未结算费用明细		
		BlcgoepAggDO[] cgAggDos = oepReCgEP.getAggCgOepDOs(id_ent);
		if(ArrayUtil.isEmpty(cgAggDos)) {
			// 1.1.更新就诊域和PI域中的价格分类ID主键
			recgEP.updatePirPat(id_pat,id_ent,id_pripat_to);
			// 1.2.保存重划价记录			
			oepReCgEP.saveRecgOepRecord(id_pripat_from,id_pripat_to,operatorInfo);
			return fRePricingSuccess;
		}
		
		// 2.过滤Agg中无效数据
		List<BlcgoepAggDO>  aggDoList = oepReCgEP.getOrignAggDOs(cgAggDos);
		
		// 3.拆解过滤后的AGG 且获取原记账中消费金额		
		List<BlCgOepDO> cgList = oepReCgEP.getCgOepDOs(aggDoList.toArray(new BlcgoepAggDO[]{}));
		List<BlCgItmOepDO> cgItmList = oepReCgEP.getCgItmOepDOs(aggDoList.toArray(new BlcgoepAggDO[]{}));
		// 3.1.原来消费额度
		FDouble orginAccAmt = this.getConsumeAmt(aggDoList,cgItmList);
		
		// 4.更新子表中fg_refund为Y
		for (BlCgItmOepDO itm : cgItmList) {
			itm.setFg_refund(FBoolean.TRUE);
			itm.setStatus(DOStatus.UPDATED);
		}
		IBlCgItmOepDOCudService cgService = ServiceFinder.find(IBlCgItmOepDOCudService.class);
		BlCgItmOepDO[] orginCgItmDOArr =  cgService.save(cgItmList.toArray(new BlCgItmOepDO[]{}));
		
		// 5.保存重划价记录	
		BlRecgOepDO recgOepDo = oepReCgEP.saveRecgOepRecord(id_pripat_from,id_pripat_to,operatorInfo);
		
		// 6.保存门诊费用明细 并返回重收记账的AGG
		List<BlcgoepAggDO> reChargeAggDos = oepReCgEP.saveRedandRechargeCg(orginCgItmDOArr,	cgList.toArray(new BlCgOepDO[]{}), operatorInfo, recgOepDo);
		// 6.1获取重收记账明细总金额
		List<BlCgItmOepDO> reChargeCgItms = oepReCgEP.getCgItmOepDOs(reChargeAggDos.toArray(new BlcgoepAggDO[]{}));
		// 6.2新消费额度
		FDouble newAccAmt =  this.getConsumeAmt(reChargeAggDos,reChargeCgItms);
		
		// 7.修改就诊账户的消费额度
		oepReCgEP.updateAccConsume(id_pat, orginAccAmt, newAccAmt);

		//8.更新就诊域和PI域中的价格分类ID主键		
		recgEP.updatePirPat(id_pat, id_ent, id_pripat_to);

		return fRePricingSuccess;
	}
	
	/**
	 * 获取消费记账金额
	 * @param aggDOs
	 * @param cgItmDos
	 * @return
	 */
	@SuppressWarnings("unused")
	private FDouble getConsumeAmt(List<BlcgoepAggDO> aggDOs, List<BlCgItmOepDO> cgItmDos) {
		FDouble ConsumeAmt = FDouble.ZERO_DBL;
		for (BlcgoepAggDO aggDO : aggDOs) {
			for (BlCgItmOepDO itmDo : cgItmDos) {
				ConsumeAmt = ConsumeAmt.add(itmDo.getAmt_ratio().multiply(
						aggDO.getParentDO().getEu_direct()));
			}
		}
		return ConsumeAmt;
	}
	
}
