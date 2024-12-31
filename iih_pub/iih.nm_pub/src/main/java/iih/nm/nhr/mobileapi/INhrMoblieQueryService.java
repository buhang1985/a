package iih.nm.nhr.mobileapi;

import iih.nm.nhr.nhroverwork.d.NhrOverWorkDO;
import iih.nm.nhr.nmnhrschedlv.d.NmNhrSchedLvDO;
import iih.nm.nhr.nmnhrschedrp.d.NhrSchedRpDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.wf.af.vos.d.WfTaskDO;

/**
 * 对外（移动端）访问审批流程查询接口
 * 
 * @author lijm
 * @TIME 2019-5-8 21:13:10
 *
 */
public interface INhrMoblieQueryService {

	/**
	 * 获取给定用户加班申请（待提交、审批中、已审批）
	 * 
	 * @param userId
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<NhrOverWorkDO> getOverWorkBillByPsndocId(String psndocId, PaginationInfo pg, String statusBill) throws BizException;

	/**
	 * 获取给定用户替班申请（待提交、审批中、已审批）
	 * 
	 * @param userId
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<NhrSchedRpDO> getSchedRpBillByPsndocId(String psndocId, PaginationInfo pg, String statusBill) throws BizException;

	/**
	 * 获取给定用户请假申请（待提交、审核中、已审批）
	 * 
	 * @param userId
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<NmNhrSchedLvDO> getSchedLvBillByPsndocId(String psndocId, PaginationInfo pg, String statusBill) throws BizException;

	/**
	 * 获取给定用户待审批任务
	 * 
	 * @param userId
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<WfTaskDO> getToDoTaskByUserId(String userId, PaginationInfo pg,int applicatype,String dt_begin) throws BizException;

	/**
	 * 获取给定用户已审批任务
	 * 
	 * @param userId
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<WfTaskDO> getDoneTaskByUserId(String userId, PaginationInfo pg,int applicatype,String dt_begin) throws BizException;

}
