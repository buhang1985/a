package iih.bd.pp.anhuisrvorca.s;

import iih.bd.pp.anhuisrvorca.d.TreatCompDTO;
import iih.bd.pp.anhuisrvorca.i.ITreatCompApprovalService;
import iih.bd.pp.anhuisrvorca.s.bp.TreatCompApprovalBp;
import iih.bd.pp.anhuisrvorca.s.bp.TreatCompExpiredBp;
import iih.bd.pp.anhuisrvorca.s.bp.TreatCompRejectBp;
import xap.mw.core.data.BizException;

/**
 * 安徽东软医保_诊疗对照审核服务
 * 
 * @author hao_wu
 *
 */
public class TreatCompApprovalServiceImpl implements ITreatCompApprovalService {

	@Override
	public TreatCompDTO[] Approval(TreatCompDTO[] treatCompDtos) throws BizException {
		TreatCompApprovalBp bp = new TreatCompApprovalBp();
		TreatCompDTO[] result = bp.exec(treatCompDtos);
		return result;
	}

	@Override
	public TreatCompDTO[] Reject(TreatCompDTO[] treatCompDtos) throws BizException {
		TreatCompRejectBp bp = new TreatCompRejectBp();
		TreatCompDTO[] result = bp.exec(treatCompDtos);
		return result;
	}

	@Override
	public TreatCompDTO[] Expired(TreatCompDTO[] treatCompDtos) throws BizException {
		TreatCompExpiredBp bp = new TreatCompExpiredBp();
		TreatCompDTO[] result = bp.exec(treatCompDtos);
		return result;
	}
}
