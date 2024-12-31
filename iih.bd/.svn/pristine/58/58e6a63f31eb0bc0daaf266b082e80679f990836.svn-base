package iih.bd.pp.anhuisrvorca.s;

import iih.bd.pp.anhuisrvorca.d.FwssCompDTO;
import iih.bd.pp.anhuisrvorca.i.IFwssCompApprovalService;
import iih.bd.pp.anhuisrvorca.s.bp.FwssCompApprovalBp;
import iih.bd.pp.anhuisrvorca.s.bp.FwssCompExpiredBp;
import iih.bd.pp.anhuisrvorca.s.bp.FwssCompRejectBp;
import xap.mw.core.data.BizException;

/**
 * 安徽东软医保_服务设施对照审核服务
 * 
 * @author hao_wu
 *
 */
public class FwssCompApprovalServiceImpl implements IFwssCompApprovalService {

	@Override
	public FwssCompDTO[] Approval(FwssCompDTO[] fwssCompDTOs) throws BizException {
		FwssCompApprovalBp bp = new FwssCompApprovalBp();
		FwssCompDTO[] result = bp.exec(fwssCompDTOs);
		return result;
	}

	@Override
	public FwssCompDTO[] Reject(FwssCompDTO[] fwssCompDTOs) throws BizException {
		FwssCompRejectBp bp = new FwssCompRejectBp();
		FwssCompDTO[] result = bp.exec(fwssCompDTOs);
		return result;
	}

	@Override
	public FwssCompDTO[] Expired(FwssCompDTO[] fwssCompDTOs) throws BizException {
		FwssCompExpiredBp bp = new FwssCompExpiredBp();
		FwssCompDTO[] result = bp.exec(fwssCompDTOs);
		return result;
	}
}
