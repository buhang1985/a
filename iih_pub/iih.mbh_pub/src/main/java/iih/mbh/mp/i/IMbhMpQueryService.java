package iih.mbh.mp.i;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import iih.mbh.mp.drugrev.d.DrugRevDTO;
import iih.mbh.mp.entlv.d.EntLvDTO;
import iih.mbh.mp.medlabor.d.MedLaborDTO;
import iih.mbh.mp.mpskd.d.MpSkdMsgQueryDTO;
import iih.mbh.mp.nurexec.d.MpNurExecDTO;
import iih.mbh.mp.orderexecpriview.d.OrdExecPreviewDTO;
import iih.mbh.mp.orplan.d.MOrPlanDTO;
import iih.mbh.mp.orplan.d.SkinResultDTO;
import iih.mbh.mp.patrol.d.PatrolDTO;
import iih.mbh.mp.patrolrecord.d.PatrolPreviewDTO;
import iih.mbh.mp.queryexe.d.QueryExeCondtionDTO;
import iih.mbh.mp.queryexe.d.QueryExeInfoDTO;
import iih.mbh.mp.scan.d.ScanInfoDTO;
import iih.mbh.mp.skipreason.d.SkipReasonDTO;
import iih.mbh.sys.appdto.d.AppMenuParamDTO;
import xap.mw.core.data.BizException;

@WebService
public interface IMbhMpQueryService {
	
	/**
	 * 获取医嘱执行记录闭环
	 * @param id_or_pr
	 * @return
	 * @throws BizException
	 */
	public abstract List<MOrPlanDTO> getOrpltpstaRecord(@WebParam(name="id_or_pr") String id_or_pr) throws BizException;
	/**
	 * 获取医嘱执行计划列表
	 * @param id_ent
	 * @param dt_date
	 * @param params 键值对 
	 * @throws BizException
	 */
	public abstract List<MOrPlanDTO> getOrPlanInfos(@WebParam(name = "id_ent") String id_ent, @WebParam(name = "params") List<AppMenuParamDTO> params) throws BizException;
	/**
	 * 获取单个医嘱执行计划
	 * @param id_ent
	 * @param dt_date
	 * @param params 键值对 
	 * @throws BizException
	 */
	public abstract List<MOrPlanDTO> getOrPlanInfo(@WebParam(name = "id_or_pr") String id_or_pr, @WebParam(name = "params") List<AppMenuParamDTO> params) throws BizException;
	/**
	 * 查询皮试结果档案
	 * @return
	 * @throws BizException
	 */
	public abstract List<SkinResultDTO> getSkinResult() throws BizException;

	/**
	 * 查看体温单
	 * @param id_ent
	 * @return
	 * @throws BizException
	 * @author Fengjj
	 */
	public abstract String getTempListData(String id_ent) throws BizException;
	
	/**
	 * 检验标本查看
	 * @param id_ent
	 * @return
	 * @throws BizException
	 * @author Fengjj
	 */
	public abstract List<MedLaborDTO> getMedLaborData(String id_ent,@WebParam(name="params") List<AppMenuParamDTO> params) throws BizException;

	/**
	 * 获取批量摆药、复核、配液记录
	 * 
	 * @param id_dep_nur
	 * @param paramDTO
	 * @return
	 * @throws BizException
	 */

	public abstract List<MpNurExecDTO> getMpNurExecInfo(@WebParam(name="id_dep_nur") String id_dep_nur, @WebParam(name="params") List<AppMenuParamDTO> params, @WebParam(name="id_or_pr") String id_or_pr) throws BizException;
	
	// 扫描码返回扫描信息
	public abstract ScanInfoDTO getScanInfo(@WebParam(name="noBar") String noBar) throws BizException;
	/**
	 * 输液巡视预览
	 * @param id_or_pr
	 * @return
	 * @throws BizException
	 */
	public abstract PatrolPreviewDTO getPatrolPreview(@WebParam(name="id_or_pr") String id_or_pr) throws BizException;
    /**
     * 医嘱执行预览查询
     * @param id_or_pr
     * @return
     * @throws BizException
     */
	public abstract OrdExecPreviewDTO getOrdExecPreview(@WebParam(name="id_or_pr") String id_or_pr) throws BizException;
	
	// 根据就诊id获取巡房记录
	public abstract List<PatrolDTO> getPatrolInfos(@WebParam(name="id_ent") String id_ent) throws BizException;
	/**
	 * 获取不执行原因
	 * @return
	 * @throws BizException
	 */
	public abstract List<SkipReasonDTO> getSkipReason() throws BizException;
	/**
	 *获取门诊批量摆药登记
	 * @param id_dep_nur
	 * @param param
	 * @param id_or_pr
	 * @return
	 * @throws BizException
	 */
	public abstract List<MpNurExecDTO> getOpBatchDispensReg(@WebParam(name="id_dep_nur") String id_dep_nur, @WebParam(name="param") List<AppMenuParamDTO> param, @WebParam(name="id_or_pr") String id_or_pr) throws BizException;

	/**
	 * 查询医嘱列表（门诊）
	 * @param id_ent
	 * @param params
	 * @return
	 * @throws BizException
	 * @author Fengjj
	 */
	public abstract List<MOrPlanDTO> getOpOrPlanInfos(@WebParam(name="id_ent") String id_ent, @WebParam(name="params") List<AppMenuParamDTO> params) throws BizException;
	
	/**
	 * 查询单个医嘱（门诊输液）
	 * @param id_or_pr
	 * @return
	 * @throws BizException
	 */
	public abstract MOrPlanDTO GetOpOnePlanInfo(@WebParam(name="id_or_pr") String id_or_pr) throws BizException;

	/**
	 * 查询单个医嘱（门诊皮试）
	 * @param id_or_pr
	 * @return
	 * @throws BizException
	 */
	public abstract MOrPlanDTO GetOpOneSkinPlanInfo(@WebParam(name="id_or_pr") String id_or_pr) throws BizException;
	/**
	 * 门诊输液巡视预览
	 * @param id_or_pr
	 * @return
	 * @throws BizException
	 */
	public abstract PatrolPreviewDTO getOpPatrolPreview(@WebParam(name="id_or_pr") String id_or_pr) throws BizException;
	/**
	 * 门诊医嘱执行预览
	 * @param id_or_pr
	 * @return
	 * @throws BizException
	 */
	public abstract OrdExecPreviewDTO getOpOrdExecPreview(@WebParam(name="id_or_pr") String id_or_pr) throws BizException;

	/**
	 * 获取护理任务信息
	 * @param id_emp
	 * @param id_dept
	 * @return
	 * @throws BizException
	 */
	public abstract List<MpSkdMsgQueryDTO> getMpSkdMsgInfo(@WebParam(name="id_emp") String id_emp, @WebParam(name="id_dept") String id_dept) throws BizException;
	
	/**
	 * 获取药品注册信息
	 * @param id_ent
	 * @param dt_date
	 * @param params
	 * @return
	 * @throws BizException
	 */
	public abstract List<MOrPlanDTO> getMpRegisInfo(@WebParam(name="id_ent") String id_ent, @WebParam(name="params") List<AppMenuParamDTO> params) throws BizException;
	
	/**
	 * 获取患者外出记录
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	public abstract List<EntLvDTO> getEntLvInfo(@WebParam(name="id_ent") String id_ent) throws BizException;
	

	// 执行查询，获取查询条件
	public abstract QueryExeCondtionDTO getExeCondtionInfo() throws BizException;

	// 获取执行查询内容
	public abstract List<QueryExeInfoDTO> getExePlanInfo(@WebParam(name="condtion") QueryExeCondtionDTO condtion) throws BizException;
	
	// 获取执行检验详细信息
	public abstract MedLaborDTO getMedLabDetailDTO(@WebParam(name="id_medlabor") String id_medlabor) throws BizException;

	// 获取病区药品接收计划列表
	public abstract List<DrugRevDTO> getDrugRevPlanList(@WebParam(name="fun_code") String fun_code, @WebParam(name="code_dgipde") String code_dgipde) throws BizException;
}
