package iih.ci.rcm.reportcardmissqry.s;

import iih.ci.rcm.contagion.dto.d.EntDto;
import iih.ci.rcm.reportcardmissqry.bp.FindReportedHistoryBp;
import iih.ci.rcm.reportcardmissqry.bp.GetDataBp;
import iih.ci.rcm.reportcardmissqry.bp.GetEntDTOListBp;
import iih.ci.rcm.reportcardmissqry.i.IReportCardMissQryService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;


/**
 * 报卡漏报查询节点服务
 */
@Service(serviceInterfaces = { IReportCardMissQryService.class }, binding = Binding.JSONRPC)
public class ReportCardMissQryServiceImpl extends PagingServiceImpl<EntDto> implements IReportCardMissQryService {
	
	/**
	 * 就诊列表查询
	 * @param qryRootNodeDTO
	 * @param paginationInfo
	 * @return
	 * @throws BizException
	 */
	@Override
	public PagingRtnData<EntDto> getEntDTOList(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo)
			throws BizException {
		GetEntDTOListBp bp = new GetEntDTOListBp();
		return bp.getEntDTOList(qryRootNodeDTO, paginationInfo);
	}

	/**
	 * 报卡信息（文书，模板，流）
	 * @param enDto
	 * @return
	 * @throws BizException
	 */
	@Override
	public FArrayList2 GetData(EntDto enDto) throws BizException {
		GetDataBp bp = new GetDataBp();
		return bp.GetData(enDto);
	}

	/**
	 * 无报卡但是既往已报时查询既往已报文书ID
	 * @param enDto
	 * @return
	 * @throws BizException
	 */
	@Override
	public String findReportedHistory(EntDto enDto) throws BizException {
		FindReportedHistoryBp bp = new FindReportedHistoryBp();
		return bp.findReportedHistory(enDto);
	}

	
}
