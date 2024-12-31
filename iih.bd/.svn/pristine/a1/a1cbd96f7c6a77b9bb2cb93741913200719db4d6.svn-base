package iih.bd.pp.anhuisrvorca.s;

import iih.bd.pp.anhuisrvorca.d.DrugCompDTO;
import iih.bd.pp.anhuisrvorca.i.IDrugCompApprovalService;
import iih.bd.pp.anhuisrvorca.s.bp.DrugCompApprovalBp;
import iih.bd.pp.anhuisrvorca.s.bp.DrugCompExpiredBp;
import iih.bd.pp.anhuisrvorca.s.bp.DrugCompRejectBp;
import xap.mw.core.data.BizException;

/**
 * 安徽东软医保_药品对照审核服务
 * 
 * @author hao_wu
 *
 */
public class DrugCompApprovalServiceImpl implements IDrugCompApprovalService {

	@Override
	public DrugCompDTO[] Approval(DrugCompDTO[] drugCompDTOs) throws BizException {
		DrugCompApprovalBp bp = new DrugCompApprovalBp();
		DrugCompDTO[] result = bp.exec(drugCompDTOs);
		return result;
	}

	@Override
	public DrugCompDTO[] Reject(DrugCompDTO[] drugCompDTOs) throws BizException {
		DrugCompRejectBp bp = new DrugCompRejectBp();
		DrugCompDTO[] result = bp.exec(drugCompDTOs);
		return result;
	}

	@Override
	public DrugCompDTO[] Expired(DrugCompDTO[] drugCompDTOs) throws BizException {
		DrugCompExpiredBp bp = new DrugCompExpiredBp();
		DrugCompDTO[] result = bp.exec(drugCompDTOs);
		return result;
	}
}
