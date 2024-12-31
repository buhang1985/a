package iih.bl.st.s.bp.oepcharge;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;

import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.d.BlcgoepAggDO;
import iih.bl.itf.pe.IBlPeChargeService;
import iih.bl.params.BlParams;
import iih.pe.papi.i.his.IChargeService;
import iih.pe.papt.dto.peitfchargedto.d.PeItfChargeDTO;
import iih.pi.reg.patcust.d.PiPatCustDO;
import iih.pi.reg.patcust.i.IPatcustRService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 收退费回写体检系统
 * 
 * @author zhangxin
 * @date 2018年12月13日
 */
public class BlPeChargeReturnBP {
	public FBoolean exec(BlcgoepAggDO[] blcgoepAggDOs, FBoolean fgCharge) throws BizException {
		FBoolean flag = FBoolean.FALSE;
		if (BlParams.BLITF0002().booleanValue()) {
			// 调用第三方体检接口
			flag = this.getItfPeChargeService(blcgoepAggDOs, fgCharge);
		} else {
			// 调用iih 体检接口
			flag = this.getPeChargeService(blcgoepAggDOs, fgCharge);
		}
		return flag;
	}

	/**
	 * 调用iih体检接口
	 * 
	 * @param blcgoepAggDOs
	 * @return
	 * @throws BizException
	 */
	private FBoolean getPeChargeService(BlcgoepAggDO[] blcgoepAggDOs, FBoolean fgCharge) throws BizException {
		List<PeItfChargeDTO> peItfPatList = new ArrayList<PeItfChargeDTO>();

		for (BlcgoepAggDO blcgoepAgg : blcgoepAggDOs) {
			BlCgItmOepDO[] blCgItmOepDOs = blcgoepAgg.getBlCgItmOepDO();
			for (BlCgItmOepDO blCgItmOep : blCgItmOepDOs) {
				PeItfChargeDTO peItfChargeDTO = new PeItfChargeDTO();
				// 服务id
				peItfChargeDTO.setId_srv(blCgItmOep.getId_srv());
				// 收费标志
				peItfChargeDTO.setFg_charge(fgCharge);
				// 体检流水号
				peItfChargeDTO.setPe_code(blCgItmOep.getPecode());
				peItfPatList.add(peItfChargeDTO);
			}
		}
		FBoolean fgpat = this.getFgCustorPat(blcgoepAggDOs);
		IChargeService iChargeService = ServiceFinder.find(IChargeService.class);
		FBoolean flagBack = FBoolean.FALSE;
		// 是患者调用患者回传方法
		if (fgpat.booleanValue()) {
			flagBack = iChargeService.piBackpassPe(peItfPatList.toArray(new PeItfChargeDTO[] {}));
		}
		// 不是患者调用团体回写方法
		else {
			flagBack = iChargeService.piBackpassPeGroupFgpaid(peItfPatList.toArray(new PeItfChargeDTO[] {}));
		}

		return flagBack;
	}

	/**
	 * 查询是否为患者
	 * 
	 * @param blcgoepAggDOs
	 * @return
	 * @throws BizException
	 */
	private FBoolean getFgCustorPat(BlcgoepAggDO[] blcgoepAggDOs) throws BizException {
		String id_pat = blcgoepAggDOs[0].getParentDO().getId_pat();
		// 查询团体患者关系表
		IPatcustRService iPatcustRService = ServiceFinder.find(IPatcustRService.class);
		PiPatCustDO[] patCustDOs = iPatcustRService.findByAttrValString(PiPatCustDO.ID_PAT, id_pat);
		// 如果无数据 则为患者
		if (ArrayUtils.isEmpty(patCustDOs)) {
			return FBoolean.TRUE;
		}
		// 否则为团体客户
		return FBoolean.FALSE;
	}

	/**
	 * 第三方体检收费回写
	 * 
	 * @param blcgoepAggDOs
	 * @return
	 * @throws BizException
	 */
	private FBoolean getItfPeChargeService(BlcgoepAggDO[] blcgoepAggDOs, FBoolean fgCharge) throws BizException {
		IBlPeChargeService peChargeService = ServiceFinder.find(IBlPeChargeService.class);
		if (peChargeService == null) {
			throw new BizException("未获取到第三方收费接口");
		}
		FBoolean fgpat = getFgCustorPat(blcgoepAggDOs);
		FBoolean flagBack = FBoolean.FALSE;
		if (fgpat.booleanValue()) {
			 flagBack = peChargeService.peChargeReturn(blcgoepAggDOs, fgCharge);
		} else {
			 flagBack = peChargeService.peCustChargeReturn(blcgoepAggDOs, fgCharge);
		}
		return flagBack;
	}
}
