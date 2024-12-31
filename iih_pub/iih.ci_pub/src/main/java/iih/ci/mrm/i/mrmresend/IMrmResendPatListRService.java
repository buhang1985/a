package iih.ci.mrm.i.mrmresend;

import iih.ci.mrm.dto.cimrmresendpatdto.d.CiMrmResendPATDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

public interface IMrmResendPatListRService {
	
	/**
	 * 病案重发节点-患者信息查询
	 * @param qryRootNodeDTO
	 * @param paginationInfo
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnData<CiMrmResendPATDTO> getCiMrmResendPATDTOList(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo) throws BizException;
	/**
	 * 推送病案信息
	 * @return
	 * @throws BizException
	 */
	public abstract boolean sendMrmInfo(CiMrmResendPATDTO[] ciMrmResendPATDTOs) throws BizException;
	/**
	 * 推送门诊住院工作量
	 * @param ciMrmResendPATDTO
	 * @return
	 * @throws BizException
	 */
	public abstract boolean sendWorkload(CiMrmResendPATDTO ciMrmResendPATDTO) throws BizException;
	
}
