package iih.ci.rcm.reportcardmissqry.i;

import iih.ci.rcm.contagion.dto.d.EntDto;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
* 报卡漏报查询节点服务
*/
public interface IReportCardMissQryService {
	
	/**
	 * 就诊列表查询
	 * @param qryRootNodeDTO
	 * @param paginationInfo
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnData<EntDto> getEntDTOList(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo)throws BizException;
	
	/**
	 * 报卡信息（文书，模板，流）
	 * @param enDto
	 * @return
	 * @throws BizException
	 */
	public abstract FArrayList2 GetData(EntDto enDto)throws BizException;
	
	/**
	 * 无报卡但是既往已报时查询既往已报文书ID
	 * @param enDto
	 * @return
	 * @throws BizException
	 */
	public abstract String findReportedHistory(EntDto enDto)throws BizException;
	
	
}
