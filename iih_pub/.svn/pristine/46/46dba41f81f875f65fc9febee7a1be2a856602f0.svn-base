package iih.nm.nqm.i;

import iih.nm.nbd.nbddepca.d.NbdDepDO;
import iih.nm.nqm.dto.nmnqmwdkpida.d.NqmWdkEnDTO;
import iih.nm.nqm.dto.nqmchktable.d.QcTbDTO;
import iih.nm.nqm.nmnqmcs.d.NmNqmCsDO;
import iih.nm.nqm.nmnqmcsca.d.NmNqmCsCaDO;
import iih.nm.nqm.nmnqmkpi.d.NmnqmkpiAggDO;
import iih.nm.nqm.nmnqmqcmt.d.NmnqmqcmtAggDO;
import iih.nm.nqm.nmnqmtask.d.NmNqmTaskDO;
import iih.nm.nqm.nmnqmtask.d.NqmTaskDetDO;
import iih.nm.nqm.nmnqmtask.d.NqmtaskAggDO;
import iih.nm.nqm.nmnqmtaskdep.d.NmnqmtaskdepAggDO;
import iih.nm.nqm.nmnqmwdkpida.d.NmNqmWdKpidaDO;
import iih.nm.nqm.nqmchk.d.NqmChkDO;
import iih.nm.nqm.nqmchk.d.NqmchkAggDO;
import iih.nm.nqm.nqmtaskdetdep.d.NqmTaskDetDepDO;
import iih.nm.nqm.nqmtaskplan.d.NqmTaskPlanDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;

public interface INmNqmMaintainService {
	
	/**
	 * 保存专科指标病区录入明细
	 * @param list
	 * @param pidaDo
	 * @return
	 * @throws BizException
	 */
	public NqmWdkEnDTO[] saveNqmWdkPida(NqmWdkEnDTO[] list ,NmNqmWdKpidaDO pidaDo) throws BizException ;
	
	/**
	 * 保存检查任务信息
	 * @param taskDo
	 * @param aggArr
	 * @return
	 * @throws BizException
	 */
	public NmNqmTaskDO[] saveNqmTask(NqmtaskAggDO taskAggDo,NmnqmtaskdepAggDO[] aggArr) throws BizException;
	
	/**
	 * 保存质量检查表格信息，和护理质量检查do
	 * @param data
	 * @param dataDto
	 * @return
	 */
	public NqmchkAggDO saveNqmChkTable(NqmchkAggDO data, QcTbDTO dataDto) throws BizException;
	/**
	 * 保存质控会议会议记录
	 * @param aggDO
	 * @return
	 */
	public NmnqmqcmtAggDO saveNqmQcmt(NmnqmqcmtAggDO aggDO)throws BizException;
	
	/**
	 * 
	 * @param nqmchkAggDOs
	 * @return
	 * @throws BizException
	 */
	public FBoolean SaveNqmChkIssue (NqmchkAggDO nqmchkAggDOs) throws BizException;
	/**
	 * 
	 * @param nqmchkAggDOs
	 * @throws BizException
	 */
	public void UpdateNqmTaskInfo(NqmchkAggDO nqmchkAggDOs) throws BizException;
	
	/**
	 * 
	 * @param id_nqm_chk
	 * @param sd_status
	 * @throws BizException
	 */
	public NqmChkDO[] UpdateNqmChkStatus(String id_nqm_chk,String sd_status,String id_status) throws BizException;
	
	/**
	 * 检查任务下发
	 * @param nmNqmTaskDO
	 * @return
	 * @throws BizException
	 */
	public NqmchkAggDO[] IssueNqmTask(NmNqmTaskDO nmNqmTaskDO) throws BizException;

	/**
	 * 生成任务明细
	 * @param dt_begin
	 * @param dt_end
	 * @param count_check
	 * @return
	 * @throws BizException
	 */
	public NqmTaskDetDO[] generaTaskDetail(NmNqmTaskDO taskDO) throws BizException;
	
	/**
	 * 生成受检科室
	 * @param nbdDepDOs
	 * @return
	 * @throws BizException
	 */
	public NqmTaskDetDepDO[] generaDetDep(NqmTaskDetDO taskDetDO,NbdDepDO[] nbdDepDOs) throws BizException;
	
	/**
	 * 质量检查标准版本升级保存实现
	 * @param csAgg
	 * @return
	 * @throws BizException
	 */
	public NmNqmCsDO SaveVersionKpiData(NmNqmCsDO csDO,NmnqmkpiAggDO[] kpiAggList) throws BizException;
	


	/**
	 * 质控任务 任务完成保存任务进度
	 * @param taskPlDO
	 * @throws BizException
	 */
	public NqmTaskPlanDO saveTaskProgress(NqmTaskPlanDO taskPlDO) throws BizException;
	
	/**
	 * 保存下发的质控任务
	 * @param taskDO
	 * @return
	 * @throws BizException
	 */
	public NqmTaskPlanDO[] saveTaskIssued(NmNqmTaskDO taskDO) throws BizException; 
	
	/**
	 * 检查任务分配
	 * @param taskPlanDOs
	 * @return
	 * @throws BizException
	 */
	public NqmTaskPlanDO[] saveTaskAlloca(NqmTaskPlanDO[] taskPlanDOs) throws BizException; 

	/**
	 * 质量检查Excel导入
	 * @param nqmCsCaDO
	 * @param fmap2
	 * @return
	 * @throws BizException
	 */
	public NmNqmCsDO[] saveImportNqmCsKpi(NmNqmCsCaDO nqmCsCaDO,FMap2 fmap2) throws BizException;
	
	/**
	 * 保存任务明细
	 * @param nqmTaskDetDO
	 * @param flist
	 * @return
	 * @throws BizException
	 */
	public NqmTaskDetDO saveTaskDet(NqmTaskDetDO nqmTaskDetDO,FArrayList flist) throws BizException;

	/**
	 * 任务下发
	 * @param NqmTaskDetDO
	 * @return
	 * @throws BizException
	 */
    public NqmTaskPlanDO[] saveTaskDetIsssused(NqmTaskDetDO taskDetDO) throws BizException;

}
