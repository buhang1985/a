package iih.bl.itf.trasnsferandqry.s;

import iih.bl.itf.accountinformation.d.AccountInfomationDTO;
import iih.bl.itf.tasktransfered.d.TaskTransferedDTO;
import iih.bl.itf.transferdetails.d.TransferDetailsDTO;
import iih.bl.itf.transferqry.d.TransferInfoDTO;
import iih.bl.itf.trasnsferandqry.bp.FindBlThirdTransByBizGroupBP;
import iih.bl.itf.trasnsferandqry.bp.TransferProAndQueryBP;
import iih.bl.itf.trasnsferandqry.i.TransferProAndQueryService;
import iih.bl.itf.trdtrans.d.BlThirdTransRcdDO;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

@Service(serviceInterfaces = {TransferProAndQueryService.class}, binding = Binding.JSONRPC)
public class TransferProAndQueryServiceImpl implements
		TransferProAndQueryService {

	@Override
	public TransferDetailsDTO[] transferDetailsQry(String code) throws BizException {
		TransferProAndQueryBP bp = new TransferProAndQueryBP();
		return bp.transferDetailsBP(code);
	}
	
	@Override
	public TransferInfoDTO[] transferInfoQry(QryRootNodeDTO qryNode)
			throws BizException {
		TransferProAndQueryBP bp = new TransferProAndQueryBP();
		return bp.transferInfoQryBP(qryNode);
	}
	
	@Override
	public TaskTransferedDTO[] taskTransferedQry(QryRootNodeDTO qryNode) throws BizException {
		TransferProAndQueryBP bp = new TransferProAndQueryBP();
		return bp.taskTransferedQryBP(qryNode);
	}
	
	@Override
	public AccountInfomationDTO[] getAccountInfo(String id_pat) throws BizException {
		TransferProAndQueryBP bp = new TransferProAndQueryBP();
		return bp.getAccountInfoBP(id_pat);
	}

	@Override
	public AccountInfomationDTO[] getAccountInfoqry(QryRootNodeDTO qryNode)
			throws BizException {
		TransferProAndQueryBP bp = new TransferProAndQueryBP();
		return bp.getAccountInfoqryBP(qryNode);
		
	}

	@Override
	public PagingRtnData<BlThirdTransRcdDO> findBlThirdTransByBizGroup(QryRootNodeDTO qryRootNodeDTO,
			String idEmp, String orderStr, PaginationInfo pg) throws BizException {
		FindBlThirdTransByBizGroupBP bp = new FindBlThirdTransByBizGroupBP();
		return bp.exec(qryRootNodeDTO,idEmp,orderStr,pg);
	}

}
