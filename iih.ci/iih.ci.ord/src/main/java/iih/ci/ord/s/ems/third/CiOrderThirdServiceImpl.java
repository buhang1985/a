package iih.ci.ord.s.ems.third;

import java.util.List;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.dto.thirdparam.ChargeForCiParamDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.OrderRstDTO;
import iih.ci.ord.i.third.ICiOrderThirdService;
import iih.ci.ord.i.third.ThirdRstDTO;
import iih.ci.ord.s.ems.third.ip.IpEmsDrugsFeeSaveBP;
import iih.ci.ord.s.ems.third.op.EmsSaveAction;
import iih.ci.ord.s.utils.OpSimpleOrderSignBP;
import iih.en.pv.pativisit.d.PatiVisitDO;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;

@Service(serviceInterfaces = { ICiOrderThirdService.class }, binding = Binding.JSONRPC)
public class CiOrderThirdServiceImpl implements ICiOrderThirdService {

	private MpOrderFeeAction mpOrderFeeAction = new MpOrderFeeAction();

	@Override
	public ThirdRstDTO save(CiorderAggDO[] szOrderAggInfo) throws BizException {
		// TODO Auto-generated method stub
		return mpOrderFeeAction.save(szOrderAggInfo);
	}

	@Override
	public ThirdRstDTO delete(String[] szId_or) throws BizException {
		// TODO Auto-generated method stub
		return mpOrderFeeAction.delete(szId_or);
	}

	@Override
	public ThirdRstDTO[] tidyFeeSave(PatiVisitDO pat, ChargeForCiParamDTO[] params) throws BizException {
		EmsSaveAction action = new EmsSaveAction();
		return action.exec(pat, params);
	}

	@Override
	public ThirdRstDTO medicalPatchFeeSave(ChargeForCiParamDTO[] params) throws BizException {
		IpEmsDrugsFeeSaveBP bp = new IpEmsDrugsFeeSaveBP();
		return bp.save(params);
	}

	@Override
	public ThirdRstDTO cancel(String[] szId_or) throws BizException {
		return mpOrderFeeAction.cancel(szId_or);
	}

	@Override
	public OrderRstDTO signOrdByCtxIdors(CiEnContextDTO ctx, String[] idors) throws BizException {
		OpSimpleOrderSignBP bp = new OpSimpleOrderSignBP();
		return bp.sign(ctx, idors);
	}

	@Override
	public OrderRstDTO signOrdByCtxOrdArrays(CiEnContextDTO ctx, CiOrderDO[] ciors) throws BizException {
		OpSimpleOrderSignBP bp = new OpSimpleOrderSignBP();
		return bp.sign(ctx,ciors);
	}

	@Override
	public OrderRstDTO signOrdByCtxOrdList(CiEnContextDTO ctx, List<CiOrderDO> ciors) throws BizException {
		OpSimpleOrderSignBP bp = new OpSimpleOrderSignBP();
		return bp.sign(ctx, ciors);
	}

	@Override
	public OrderRstDTO signOrdByIdors(String[] idors) throws BizException {
		OpSimpleOrderSignBP bp = new OpSimpleOrderSignBP();
		return bp.sign(idors);
	}

	@Override
	public OrderRstDTO signOrdByOrdArrays(CiOrderDO[] ciors) throws BizException {
		OpSimpleOrderSignBP bp = new OpSimpleOrderSignBP();
		return bp.sign(ciors);
	}

	@Override
	public OrderRstDTO signOrdByOrdList(List<CiOrderDO> ciors) throws BizException {
		OpSimpleOrderSignBP bp = new OpSimpleOrderSignBP();
		return bp.sign(ciors);
	}
	
}
