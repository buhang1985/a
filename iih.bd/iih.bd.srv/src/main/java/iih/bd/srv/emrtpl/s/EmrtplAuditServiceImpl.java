package iih.bd.srv.emrtpl.s;

import iih.bd.srv.emrtpl.d.EmrTplDO;
import iih.bd.srv.emrtpl.i.IEmrtplAuditService;
import iih.bd.srv.emrtpl.s.bp.EmrTplAuditApproveBp;
import iih.bd.srv.emrtpl.s.bp.EmrTplAuditCancelSubmitBp;
import iih.bd.srv.emrtpl.s.bp.EmrTplAuditRejectBp;
import iih.bd.srv.emrtpl.s.bp.EmrTplAuditSubmitBp;
import xap.mw.core.data.BizException;

/**
 * 病历模板审核服务
 * 
 * @author hao_wu
 *
 */
public class EmrtplAuditServiceImpl implements IEmrtplAuditService {

	@Override
	public EmrTplDO[] Approve(EmrTplDO[] emrTplArray) throws BizException {
		EmrTplAuditApproveBp bp = new EmrTplAuditApproveBp();
		EmrTplDO[] result = bp.exec(emrTplArray);
		return result;
	}

	@Override
	public EmrTplDO[] Reject(EmrTplDO[] emrTplArray) throws BizException {
		EmrTplAuditRejectBp bp = new EmrTplAuditRejectBp();
		EmrTplDO[] result = bp.exec(emrTplArray);
		return result;
	}

	@Override
	public EmrTplDO[] Submit(EmrTplDO[] emrTplArray) throws BizException {
		EmrTplAuditSubmitBp bp = new EmrTplAuditSubmitBp();
		EmrTplDO[] result = bp.exec(emrTplArray);
		return result;
	}

	@Override
	public EmrTplDO[] CancelSubmit(EmrTplDO[] emrTplArray) throws BizException {
		EmrTplAuditCancelSubmitBp bp = new EmrTplAuditCancelSubmitBp();
		EmrTplDO[] result = bp.exec(emrTplArray);
		return result;
	}
}
