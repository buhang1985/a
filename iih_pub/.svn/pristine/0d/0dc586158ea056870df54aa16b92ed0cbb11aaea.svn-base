package iih.hp.cp.hpcp.i;

import iih.hp.cp.hpcp.d.HpCpDO;
import iih.hp.cp.hpcp.d.HpcpAggDO;
import xap.mw.core.data.BizException;
import xap.wf.af.vos.d.WfTaskDO;

public interface IHpcpFlowService {
	
	/**
	 * 提交诊疗计划
	 */
	public HpcpAggDO[] submitHpcp(String[] ids) throws BizException;
	
	/**
	 * 
	
	 * <p>Title: retrieve</p>  
	
	 * <p>Description: 取回诊疗计划</p>  
	
	 * @param ids 临床路径ID数组
	 * @return
	 * @throws BizException
	 */
	public HpcpAggDO[] retrieveHpcp(String[] ids) throws BizException;
	
	/**
	 * 诊疗计划审核通过
	 */
	public HpcpAggDO[] acceptHpcp(HpCpDO[] hpcpDOList) throws BizException;
	
	/**
	 * 诊疗计划审核驳回
	 */
	public HpcpAggDO[] rejectHpcp(HpCpDO[] hpcpDOList) throws BizException;
	
	/**
	 * 获取查看进度用URL
	 */
	public String getFlowUrl(String id_task) throws BizException;
	
	/**
	 * 获取当前用户待办任务集合主键
	 */
	public String[] getMyUndoWorkTaskID() throws BizException;
	
	/**
	 * 	获取当前用户待办任务集合
	 * @param id_cp
	 * @return
	 * @throws BizException
	 */
	public WfTaskDO[] getMyUndoWorkTask() throws BizException;

	/**
	 * 	获得允许取回的任务id
	 * 		返回值null或者空字符串时表示不允许取回。
	 *  
	 * @param hHpCpDO
	 * @return 
	 * @throws BizException
	 */
	public String getAllowRetrieveTaskID(HpCpDO hpCpDO) throws BizException;
}
