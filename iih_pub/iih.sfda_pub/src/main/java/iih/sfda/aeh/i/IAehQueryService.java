package iih.sfda.aeh.i;

import iih.sfda.aer.aerevwarn.d.AerEvWarnDO;
import iih.sfda.aer.dto.sfdaaerevflowrec.d.AerEvFlowRecDO;
import iih.sfda.aer.dto.sfdaevsumryinfo.d.SfdaEvSumryInfoDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

public interface IAehQueryService {
	/**
	 * 获取被退回的报告
	 * 
	 * @param pg
	 * @param qryRootNodeDTO
	 * @param id_user
	 * @param orderStr
	 * @return
	 * @throws BizException
	 * @author lijm
	 */
	public PagingRtnData<SfdaEvSumryInfoDTO> GetBackAerRptByPageInfo(PaginationInfo pg, QryRootNodeDTO qryRootNodeDTO, String id_user, String orderStr) throws BizException;

	/**
	 * 获取全部已处理的报告
	 * 
	 * @param pg
	 * @param qryRootNodeDTO
	 * @param id_user
	 * @param orderStr
	 * @return
	 * @throws BizException
	 * @author lijm
	 */
	public PagingRtnData<SfdaEvSumryInfoDTO> GetDoneAerRptByPageInfo(PaginationInfo pg, QryRootNodeDTO qryRootNodeDTO, String id_user, String orderStr) throws BizException;

	/**
	 * 获取草稿箱报告
	 * 
	 * @param pg
	 * @param qryRootNodeDTO
	 * @param id_user
	 * @param orderStr
	 * @return
	 * @throws BizException
	 * @author lijm
	 */
	public PagingRtnData<SfdaEvSumryInfoDTO> GetDraftAerRptByPageInfo(PaginationInfo pg, QryRootNodeDTO qryRootNodeDTO, String id_user, String orderStr) throws BizException;

	/**
	 * 获取我的报告
	 * 
	 * @param pg
	 * @param qryRootNodeDTO
	 * @param id_user
	 * @param orderStr
	 * @return
	 * @throws BizException
	 * @author lijm
	 */
	public PagingRtnData<SfdaEvSumryInfoDTO> GetMyEvRptByPageInfo(PaginationInfo pg, QryRootNodeDTO qryRootNodeDTO, String id_user, String orderStr) throws BizException;

	/**
	 * 获取超期未处理的报告
	 * 
	 * @param pg
	 * @param qryRootNodeDTO
	 * @param id_user
	 * @param orderStr
	 * @return
	 * @throws BizException
	 * @author lijm
	 */
	public PagingRtnData<SfdaEvSumryInfoDTO> GetOverDueTodoRptByPageInfo(PaginationInfo pg, QryRootNodeDTO qryRootNodeDTO, String id_user, String orderStr) throws BizException;

	/**
	 * 获取收件一览报告
	 * 
	 * @param pg
	 * @param qryRootNodeDTO
	 * @param id_user
	 * @param orderStr
	 * @return
	 * @throws BizException
	 * @author lijm
	 */
	public PagingRtnData<SfdaEvSumryInfoDTO> GetReceivPrvRptByPageInfo(PaginationInfo pg, QryRootNodeDTO qryRootNodeDTO, String id_user, String orderStr) throws BizException;

	/**
	 * 获取未处理报告
	 * 
	 * @param pg
	 * @param qryRootNodeDTO
	 * @param id_user
	 * @param orderStr
	 * @return
	 * @throws BizException
	 * @author lijm
	 */
	public PagingRtnData<SfdaEvSumryInfoDTO> GetTodoRptByPageInfo(PaginationInfo pg, QryRootNodeDTO qryRootNodeDTO, String id_user, String orderStr) throws BizException;

	/**
	 * 获取有提醒的报告
	 * 
	 * @param pg
	 * @param qryRootNodeDTO
	 * @param id_user
	 * @param orderStr
	 * @return
	 * @throws BizException
	 * @author lijm
	 */
	public PagingRtnData<SfdaEvSumryInfoDTO> GetWarnRptByPageInfo(PaginationInfo pg, QryRootNodeDTO qryRootNodeDTO, String id_user, String orderStr) throws BizException;

	/**
	 * 获取我关注的报告
	 * 
	 * @param pg
	 * @param qryRootNodeDTO
	 * @param id_user
	 * @param orderStr
	 * @return
	 * @throws BizException
	 * @author lijm
	 */
	public PagingRtnData<SfdaEvSumryInfoDTO> GetMyFocusRptByPageInfo(PaginationInfo pg, QryRootNodeDTO qryRootNodeDTO, String id_user, String orderStr) throws BizException;

	/**
	 * 获取事件涉及用户
	 * 
	 * @param id_aer_ev
	 * @return
	 * @throws BizException
	 */
	public AerEvWarnDO[] GetEvRelatedUsers(String id_aer_ev) throws BizException;

	/**
	 * 获取事件报告流程履历
	 * 
	 * @param id_aer_ev
	 * @return
	 * @throws BizException
	 */
	public AerEvFlowRecDO[] GetEvRptFlowRec(String id_aer_ev) throws BizException;

}