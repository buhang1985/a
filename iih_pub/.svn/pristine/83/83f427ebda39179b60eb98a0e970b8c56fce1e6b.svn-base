package iih.hp.cp.hpcp.i;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import xap.mw.sf.core.util.ServiceFinder;
import xap.wf.af.constant.WfTaskStateType;
import xap.wf.af.itf.IWfTaskBill;
import xap.wf.af.itf.IWfTaskQry;
import xap.wf.af.runtime.NodeInstance;
import xap.wf.af.runtime.TaskInstance;

/**
 * 
 * @author chenxiang
 *
 * @date 2019年9月11日下午6:40:52
 *
 * @classpath iih.hp.cp.hpcp.i.HpCpListenerCommon
 *
 * 	临床路径监听器公共部分 
 *
 */
public class HpCpListenerCommon {

	/**
	 * 	删除当前节点的多余的无用任务
	 *  
	 * @param taskId 当前任务id 
	 */
	public void deleteCurrentPortUselessTask(String taskId) {
		//1、获取当前任务的前驱节点的待办任务id集合
		IWfTaskQry wfTaskQry = ServiceFinder.find(IWfTaskQry.class);
		List<String> taskIdList = new ArrayList<>();
		//根据任务id获得任务实例
		TaskInstance task = wfTaskQry.getTaskByPk(taskId);
		//获取任务的节点实例
		NodeInstance node = task.getNodeInstance();
		Set<TaskInstance> tasks = wfTaskQry.getTasksByNodeInsPk(node.getId_nodeins());
		for (TaskInstance curTask : tasks) {
			//待办任务
			if (curTask == null) {
				continue;
			}
			if (WfTaskStateType.Todo.toString().equals(curTask.getState().toString())) {
				taskIdList.add(curTask.getId_task());
			}
		}
		//2、删除这些任务
		deleteUselessTasks(taskIdList);
	}
	
	/**
	 * 	删除前驱节点的多余的无用任务
	 *  
	 * @param taskId 当前任务id 
	 */
	public void deletePrePortUselessTask(String taskId) {
		//1、获取当前任务的前驱节点的待办任务id集合
		IWfTaskQry wfTaskQry = ServiceFinder.find(IWfTaskQry.class);
		List<String> taskIdList = new ArrayList<>();
		//根据任务id获得任务实例
		TaskInstance task = wfTaskQry.getTaskByPk(taskId);
		//获取任务的节点实例
		NodeInstance node = task.getNodeInstance();
		//获取前驱节点，目前存在前驱节点只有一个的情况
		Set<NodeInstance> preNodes = node.getPreNodeInstances();
		for (NodeInstance preNode : preNodes) {
			Set<TaskInstance> tasks = wfTaskQry.getTasksByNodeInsPk(preNode.getId_nodeins());
			if (tasks == null) {
				continue;
			}
			for (TaskInstance preTask : tasks) {
				//待办任务
				if (WfTaskStateType.Todo.toString().equals(preTask.getState().toString())) {
					taskIdList.add(preTask.getId_task());
				}
			}
		}
		//2、删除这些任务
		deleteUselessTasks(taskIdList);
	}
	
	/**
	 * 	删除无用的待办任务
	 * 
	 * @param taskIdList
	 */
	private void deleteUselessTasks(List<String> taskIdList) {
		if (taskIdList == null || taskIdList.size() == 0) {
			return;	
		}
		IWfTaskBill wIWfTaskBill = ServiceFinder.find(IWfTaskBill.class);
		for (String uselessTaskId : taskIdList) {
			wIWfTaskBill.realDeleteTask(uselessTaskId);
		}
	}
}
