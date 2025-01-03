package iih.mbh.mp.i;

import java.text.ParseException;
import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import iih.mbh.mp.d.InfusPatrolDTO;
import iih.mbh.mp.drugrev.d.DrugRevDTO;
import iih.mbh.mp.entlv.d.EntLvDTO;
import iih.mbh.mp.orplan.d.MpOrPlanDTO;
import iih.mbh.mp.patrol.d.PatrolDTO;
import iih.mbh.mp.planexe.d.PlanExeParamDTO;
import iih.mbh.mp.planexe.d.SkinExeDTO;
import iih.mbh.sys.appdto.d.AppMenuParamDTO;
import iih.mbh.sys.response.d.ResponseDTO;
import xap.mw.core.data.BizException;

@WebService
public interface IMbhMpMaintanceService {

	public abstract boolean savePlanExec(@WebParam(name = "exeParam") PlanExeParamDTO exeParam, @WebParam(name = "fun_code") String fun_code) throws BizException;

	public abstract boolean saveFuExec(@WebParam(name = "exeParam") PlanExeParamDTO exeParam, @WebParam(name = "fun_code") String fun_code, @WebParam(name = "fuParam") InfusPatrolDTO fuParam) throws BizException;

	/**
	 * 穿刺医嘱提交
	 * 
	 * @param exeParam
	 * @param fun_code
	 * @param skinParam
	 * @return
	 * @throws BizException
	 */
	public abstract boolean savePunctureExec(@WebParam(name = "exeParam") PlanExeParamDTO exeParam, @WebParam(name = "fun_code") String fun_code, @WebParam(name = "skinParam") SkinExeDTO skinParam) throws BizException;

	/**
	 * 皮试医嘱提交
	 * 
	 * @param exeParam
	 * @param fun_code
	 * @param skinParam
	 * @return
	 * @throws BizException
	 * @throws ParseException
	 */
	public abstract boolean saveSkinExec(@WebParam(name = "exeParam") PlanExeParamDTO exeParam, @WebParam(name = "fun_code") String fun_code, @WebParam(name = "skinParam") SkinExeDTO skinParam) throws BizException, ParseException;

	/**
	 * 摆药、复核、配液提交
	 * 
	 * @param execParam
	 * @param fun_code
	 * @return
	 * @throws BizException
	 */
	public abstract boolean saveRegisterExec(@WebParam(name = "execParam") List<PlanExeParamDTO> execParam, @WebParam(name = "fun_code") String fun_code) throws BizException;

	public abstract boolean saveMedLaborExec(@WebParam(name="exeParam") PlanExeParamDTO exeParam, @WebParam(name="fun_code") String fun_code, @WebParam(name="id_labsamp") String id_labsamp) throws BizException;

	/**
	 * 保存\更新护理巡房信息
	 * 
	 * @param band_code
	 *            腕带码，腕带码不为空，是新增
	 * @param patrolDTO
	 *            dto不为空，是修改记录
	 * @return
	 * @throws BizException
	 */
	public abstract PatrolDTO savePatrolInfo(@WebParam(name = "band_code") String band_code, @WebParam(name = "patrolDTO") PatrolDTO patrolDTO) throws BizException;

	/**
	 * 门诊医嘱执行保存（摆药,复核）
	 * 
	 * @param exeParam
	 * @param fun_code
	 * @return
	 * @throws BizException
	 */
	public abstract boolean opSaveBasePlanExec(@WebParam(name = "exeParam") List<PlanExeParamDTO> exeParam, @WebParam(name = "fun_code") String fun_code) throws BizException;

	/**
	 * 门诊医嘱执行保存(配液，穿刺，巡视）
	 * 
	 * @param exeParam
	 * @param fuParam
	 * @param fun_code
	 * @return
	 * @throws BizException
	 */
	public abstract ResponseDTO opSaveInfuPlanExec(@WebParam(name="exeParam") List<PlanExeParamDTO> exeParam, @WebParam(name="fuParam") InfusPatrolDTO fuParam, @WebParam(name="fun_code") String fun_code) throws BizException;

	/**
	 * 门诊皮试医嘱提交
	 * 
	 * @param exeParam
	 * @param fun_code
	 * @param skinParam
	 * @return
	 * @throws BizException
	 * @throws ParseException
	 */
	public abstract boolean opSaveSkinExec(@WebParam(name = "exeParam") PlanExeParamDTO exeParam, @WebParam(name = "fun_code") String fun_code, @WebParam(name = "skinParam") SkinExeDTO skinParam) throws BizException, ParseException;

	/**
	 * 门诊输液医嘱提交
	 * 
	 * @param exeParam
	 * @param fun_code
	 * @param fuParam
	 * @return
	 * @throws BizException
	 */
	public abstract boolean opSaveFuExec(@WebParam(name = "exeParam") PlanExeParamDTO exeParam, @WebParam(name = "fun_code") String fun_code, @WebParam(name = "fuParam") InfusPatrolDTO fuParam) throws BizException;

	/**
	 * 更新护理任务信息
	 * 
	 * @param id_msg
	 * @return
	 * @throws BizException
	 */
	public abstract boolean updateMpSkdMsgInfo(@WebParam(name = "id_msg") String id_msg) throws BizException;

	/**
	 * 皮试穿刺执行
	 * @param exeParam
	 * @param fun_code
	 * @return
	 * @throws BizException
	 */
	public abstract boolean opSaveSkinExecing(@WebParam(name="exeParam") List<PlanExeParamDTO> exeParam, @WebParam(name="fun_code") String fun_code, @WebParam(name="id_ent") String id_ent) throws BizException;
	
	/**
	 * 药品登记保存接口
	 * @param exeParam
	 * @param fun_code
	 * @return
	 * @throws BizException
	 */
	public abstract MpOrPlanDTO ipSaveDrugReg(@WebParam(name="exeParam") PlanExeParamDTO exeParam, @WebParam(name="param") List<AppMenuParamDTO> param, @WebParam(name="id_ent") String id_ent) throws BizException;
	
	/**
	 * 校验患者是否有
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	public abstract EntLvDTO ipEntCheckOrSaveBack(@WebParam(name="id_ent") String id_ent,@WebParam(name="is_add") boolean is_add) throws BizException;
	
	/**
	 * 保存患者离开记录
	 * @param entLvDTO
	 * @return
	 * @throws BizException
	 */
	public abstract boolean ipEntSaveLv(@WebParam(name="entLvDTO") EntLvDTO entLvDTO) throws BizException;

	/**
	 * 保存输液穿刺
	 * @param exeParam
	 * @param fun_code
	 * @return
	 * @throws BizException
	 */
	public abstract boolean savePlanPunctureExec(@WebParam(name="exeParam") PlanExeParamDTO exeParam, @WebParam(name="fun_code") String fun_code) throws BizException;
	/**
	 * 药品接收保存
	 * 
	 * @param params
	 * @throws BizException
	 */
	public abstract void saveDrugPlanRev(@WebParam(name = "params") List<DrugRevDTO> params, @WebParam(name = "fun_code") String fun_code) throws BizException;
 
}