package iih.ci.mrm.i.mrmbackoff.qry;

import iih.ci.mrm.dto.cimrmqrylist.d.CiMrmQryListDTO;
import iih.ci.mrm.mrmbackoffmsgdto.d.MrmBackoffMsgDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

public interface IMrmBackoffQryService {

	/**
	*  病案整理回退查询
	*/
	public abstract PagingRtnData<CiMrmQryListDTO> getMrmBackoffDTOList(QryRootNodeDTO qryRootNodeDTO,PaginationInfo paginationInfo) throws BizException;

	/**
	 * 病案回退发送消息
	 */
	public void SendBackoffMsg(MrmBackoffMsgDTO backoffdto)throws BizException;
}
