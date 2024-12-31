package iih.en.que.task.bp;

import iih.en.comm.util.EnAppUtils;
import iih.en.que.s.bp.op.cmd.benmgr.CreateQueEmpsBP;

import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.coreitf.d.FDate;


/**
 * 自动医生出诊队列管理
 * 
 * @author liubin
 *
 */
public class EnQueEmpMgrBP {
	private static final String Id_Grp = "id_grp";
	private static final String Id_Org = "id_org";
	/**
	 * 
	 * 
	 * @param keyMap
	 */
	public void exec(Map<String, Object> paramMap) throws BizException{
		// 1.检查任务参数
		checkParam(paramMap);

		// 2.初始化执行用户
		initContext(paramMap);
		
		//3.生成未维护的医生出诊队列信息
		this.inserQueEmp(EnAppUtils.getServerDate());
	}
	/**
	 * 生成未维护的医生出诊队列信息
	 * 
	 * @throws BizException
	 */
	private void inserQueEmp(FDate date) throws BizException {
		CreateQueEmpsBP bp = new CreateQueEmpsBP();
		bp.exec(null, date);
	}
	
	/**
	 * 使用后台任务参数初始化上下文
	 * 
	 * @param paramMap
	 * @throws BizException
	 */
	private void initContext(Map<String, Object> paramMap) throws BizException {
		Context.get().setGroupId((String) paramMap.get(Id_Grp));
		Context.get().setOrgId((String) paramMap.get(Id_Org));
		
		
	}

	/**
	 * 初始化任务参数
	 * 
	 * @param paramMap
	 * @throws BizException
	 */
	private void checkParam(Map<String, Object> paramMap) throws BizException {
		if(paramMap == null || !paramMap.containsKey(Id_Grp) || paramMap.get(Id_Grp) == null)
			throw new BizException(String.format("参数%s不能为空！", Id_Grp));
		if(paramMap == null || !paramMap.containsKey(Id_Org) || paramMap.get(Id_Org) == null)
			throw new BizException(String.format("参数%s不能为空！", Id_Org));
	}
}
