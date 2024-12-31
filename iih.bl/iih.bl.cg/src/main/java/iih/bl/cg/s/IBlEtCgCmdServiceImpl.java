package iih.bl.cg.s;

import iih.bl.cg.dto.d.BlNurSubsidyErrorReturnDTO;
import iih.bl.cg.dto.d.NurseCompFeeItmDTO;
import iih.bl.cg.i.IBlEtCgCmdService;
import iih.bl.cg.s.bp.et.BlDoEtCompensationSubmitBP;
import iih.bl.cg.s.bp.et.BlDoEtRefundFeeSubmitBP;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;

/**
* @author xy.zhou
* @date 2019年3月14日
 */
@Service(serviceInterfaces = { IBlEtCgCmdService.class }, binding = Binding.JSONRPC)
public class IBlEtCgCmdServiceImpl implements IBlEtCgCmdService{

	/**
	 * (病区)退费确认
	 */
	@Override
	public FBoolean doEtRefundFeeSubmit(NurseCompFeeItmDTO[] dtoArr) throws BizException {
		BlDoEtRefundFeeSubmitBP bp=new BlDoEtRefundFeeSubmitBP();
		return bp.exec(dtoArr);
	}

	/**
	 * （病区）补费确认
	 */
	@Override
	public BlNurSubsidyErrorReturnDTO[] doEtCompensationSubmit(NurseCompFeeItmDTO[] dtoArr, String[] list_id_ent)
			throws BizException {
		BlDoEtCompensationSubmitBP bp=new BlDoEtCompensationSubmitBP();
		return bp.exec(dtoArr, list_id_ent);
	}
	
}
