package iih.bl.st.service.s;

import java.util.Map;

import iih.bl.cg.blcgquery.d.BlCgIpDO;
import iih.bl.cg.service.d.OperatorInfoDTO;
import iih.bl.pay.blpaypat.d.BlPrePayPatDO;
import iih.bl.prop.blproparip.d.BlproparipAggDO;
import iih.bl.prop.blpropip.d.BlPropIpDO;
import iih.bl.st.blpaypatip.bp.BlPayPatIpBp;
import iih.bl.st.blpaypatip.d.BlPayItmPatIpDO;
import iih.bl.st.blpaypatip.d.BlPayPatIpDO;
import iih.bl.st.blstip.bp.BlStarIpBp;
import iih.bl.st.blstip.d.BlStIpDO;
import iih.bl.st.blstiparrears.bp.BlStIpArrearsBp;
import iih.bl.st.dto.d.BlOpFeeOutDTO;
import iih.bl.st.dto.d.BlOpfeeInfoDTO;
import iih.bl.st.dto.d.BlStIpBadDebtDTO;
import iih.bl.st.dto.d.BlStIpPayInvoceInfoDTO;
import iih.bl.st.ipbaddebt.bp.BlStIpBadPayBp;
import iih.bl.st.opfeeout.bp.BlOpFeeOutBp;
import iih.bl.st.s.bp.ip.IpHpAuditStatusCheckBp;
import iih.bl.st.service.i.IBLStMaintainService;
import iih.mi.biz.dto.d.InpPayRtnValDTO;
import iih.mi.itf.context.InsureContext;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
/**
 * 住院结算
 * @author 卫佳
 *
 */
@Service(serviceInterfaces={IBLStMaintainService.class}, binding=Binding.JSONRPC)
public class IBLStMaintainServiceImpl implements IBLStMaintainService {

	
	/**
	 * 住院退费  （自费或医保)
	 */
	@Override
	public BlPrePayPatDO doStipRefund(String idEnt, String id_stip, String sd_pttp,FBoolean isSaveRedProp) throws BizException {
		BlPayPatIpBp blPayPatIpBp = new BlPayPatIpBp();
		return blPayPatIpBp.doStipRefund(idEnt,id_stip,sd_pttp,isSaveRedProp);
	}
	
	@Override
	public FBoolean doArrearsPayMent(OperatorInfoDTO operatorInfoDTO,
			BlPayPatIpDO blPayPatIpDO, BlPayItmPatIpDO[] blPayItmPatIpDOArr)
			throws BizException {
		BlStIpArrearsBp blStIpArrearsBp = new BlStIpArrearsBp();
		return blStIpArrearsBp.doStArrearsStPayment(operatorInfoDTO, blPayPatIpDO, blPayItmPatIpDOArr);
	}

	@Override
	public FBoolean doBadPayMent(BlStIpBadDebtDTO[] blStIpArr)
			throws BizException {
		BlStIpBadPayBp blStIpBadPayBp = new BlStIpBadPayBp();
		return blStIpBadPayBp.setArrearsPayToBadPay(blStIpArr);
	}

	/**
	 * 门诊费用导出接口
	 */
	@Override
	public BlOpfeeInfoDTO findLoadOutInfo(BlOpFeeOutDTO[] blOpFeeOutArr,OperatorInfoDTO operatorInfo)
			throws BizException {
		BlOpFeeOutBp blOpFeeOutBp = new BlOpFeeOutBp();
		return blOpFeeOutBp.loadOutEntHpInfos(blOpFeeOutArr,operatorInfo);
	}
	
	/**
	 * 校验患者医保审核状态
	 */
	@Override
	public FMap checkPatHpStatus(String id_ent) throws BizException {
		IpHpAuditStatusCheckBp checkPatHpStatus = new IpHpAuditStatusCheckBp();
		return checkPatHpStatus.exec(id_ent);
	}
	
}
