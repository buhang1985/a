package iih.sfda.aeh.evrptflow;

import iih.sfda.aeh.evrptflow.listener.stgy.ICmpHandler;
import iih.sfda.aer.sfdaaerev.d.SfdaAerEvDO;
import xap.mw.core.data.BizException;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.wf.af.runtime.TaskInstance;

/**
 * 不良事件处理主流程服务
 * 
 * @author guo.s
 *
 */
public interface IAehFlowService {

	/**
	 * 事件报告提交（默认流程开始）
	 * 
	 * @param sfdaAerEvDO
	 * @throws BizException
	 */
	public void submit(SfdaAerEvDO sfdaAerEvDO) throws BizException;

	/**
	 * 撤回
	 * 
	 * @param sfdaAerEvDO
	 * @param psndocs
	 * @param opinion
	 * @throws BizException
	 */
	public void back(SfdaAerEvDO sfdaAerEvDO, String id_user, String opinion) throws BizException;

	/**
	 * 事件报告审批驳回
	 * 
	 * @param sfdaAerEvDO
	 * @param opinion
	 * @throws BizException
	 */
	public void reject(SfdaAerEvDO sfdaAerEvDO, String opinion) throws BizException;

	/**
	 * 事件报告审批通过
	 * 
	 * @param sfdaAerEvDO
	 * @param opinion
	 * @throws BizException
	 */
	public void next(SfdaAerEvDO sfdaAerEvDO, String opinion) throws BizException;

	/**
	 * 抄送
	 * 
	 * @param sfdaAerEvDO
	 * @param opinion
	 * @throws BizException
	 */
	public void copyto(SfdaAerEvDO sfdaAerEvDO, PsnDocDO[] psndocs, String opinion) throws BizException;

	/**
	 * 事件报告转发
	 * 
	 * @param sfdaAerEvDO
	 * @param opinion
	 * @throws BizException
	 */
	public void transmit(SfdaAerEvDO sfdaAerEvDO, PsnDocDO[] psndocs, String opinion) throws BizException;

	/**
	 * 查看进度
	 * 
	 * @param id_task
	 * @return
	 * @throws BizException
	 */
	public String getFlowUrl(String id_task) throws BizException;

	/**
	 * 任务完成后业务处理
	 * 
	 * @param taskIns
	 * @return
	 * @throws BizException
	 */
	public ICmpHandler TaskCmpAfterHandle(TaskInstance taskIns) throws BizException;
}
