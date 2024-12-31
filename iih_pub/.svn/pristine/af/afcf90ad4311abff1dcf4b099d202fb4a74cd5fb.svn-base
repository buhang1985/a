package iih.hp.cp.hpcp.i;

import iih.hp.cp.hpcp.d.HpcpFormAggDO;
import xap.mw.log.logging.Logger;
import xap.mw.sf.core.util.ServiceFinder;
import xap.wf.af.bpmn.UserTaskActivity;
import xap.wf.af.context.PwfmContext;
import xap.wf.af.event.IExecutionListener;
import xap.wf.af.event.WfEventExecution;
import xap.wf.af.graph.IPort;
import xap.wf.af.itf.IWfTaskBill;
import xap.wf.af.itf.IWfTaskQry;
import xap.wf.af.model.WfUser;
import xap.wf.af.runtime.TaskInstance;
import xap.wf.af.server.WfFormInfoCtx;

/**
 * 
 * @author chenxiang
 *
 * @date 2019年9月11日下午8:13:27
 *
 * @classpath iih.hp.cp.hpcp.i.HpcpResetSubmitTaskListener
 *
 * 审核驳回后重置待提交任务
 * 1、该监听器要在审核驳回后执行，因为我们要等到HpcpRejcListener监听器在审核驳回前完成，生成最新的待办任务，并将该任务id填充到对应的hpcpdo中。
 * 2、如1所示，我们可以从当前监听器中获得最新的hpcpdo，获得最新的待办任务id。
 * 3、取回也是如此。
 * 4、获取当前任务中的节点实例的IPort，即UserTaskActivity，获取分配策略中的参与者策略。
 *
 */
public class HpcpResetSubmitTaskListener implements IExecutionListener {
	
	private static final long serialVersionUID = -7050119249986564884L;

	@Override
	public void notify(WfEventExecution arg0) throws Exception {
		Logger.info("开始监听审核驳回后或者取回后重置待提交任务");
		WfFormInfoCtx wfFormInfoCtx = PwfmContext.getCurrentBpmnSession().getInputBillInfo();
		//1、审核驳回后，获得流程引擎自动创建的待办任务
		//获得最新的流程引擎上下文，因为该监听器是在审核驳回后执行的，所以此时的上下文中的hpcpdo中的任务id就是审核驳回后自动创建的最新的待办任务的id。就是我们需要拷贝的源任务对象。
		HpcpFormAggDO hpcpFormAggDO = (HpcpFormAggDO)wfFormInfoCtx;
		IWfTaskQry wfTaskQry = ServiceFinder.find(IWfTaskQry.class);
		TaskInstance task = wfTaskQry.getTaskByPk(hpcpFormAggDO.getParentDO().getId_task());
		if (task == null) {
			return;
		}
		IPort port = task.getNodeInstance().getPort();
		if (!(port instanceof UserTaskActivity)) {
			return;
		} 
		
		//删除当前任务前驱节点的待办任务
		new HpCpListenerCommon().deletePrePortUselessTask(task.getId_task());
		
		//2、审核驳回后，除了上次提交的用户外，获得可以再次提交的用户
		UserTaskActivity userTaskActivity = (UserTaskActivity)port;
		//获取分配策略中分配的用户
		WfUser[] wfUsers = userTaskActivity.getAllotSgy().getActorSgy().getMainActor().getActors(wfFormInfoCtx);
		//3、审核驳回后，添加指定人员可再次提交的待办任务
		IWfTaskBill wIWfTaskBill = ServiceFinder.find(IWfTaskBill.class);
		for (WfUser wfUser : wfUsers) {
			if (task.getId_owner().equals(wfUser.getUserPk())) {
				continue;
			}
			//1、复制任务
			TaskInstance newTask = task.clone();
			//2、修改责任人id
			newTask.setId_owner(wfUser.getUserPk());
			newTask.setId_task(null);
			newTask.setTitile("");
			//3、同步数据
			//newTask.asyn();
			wIWfTaskBill.saveOrUpate(newTask.getTaskDo());
		}
		Logger.info("结束监听审核驳回后或者取回后重置待提交任务");
	}
}
