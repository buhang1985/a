package iih.mp.nr.foreign.i;

import iih.ci.mr.cimrpatsigns.d.VitalSignsDTO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.dto.cporderstatusdto.d.CpOrderStatusDto;
import iih.mp.nr.dto.d.EnServiceParamDTO;
import iih.mp.nr.dto.d.OrdOrpltpDetailDTO;
import iih.mp.nr.dto.d.OrdOrpltpParamDTO;
import iih.mp.nr.dto.d.ParamDTO;
import iih.mp.nr.dto.d.PeStaCountDTO;
import iih.mp.nr.dto.d.PeStaDTO;
import iih.mp.nr.dto.infusionexedetail.d.InfusionExeDetailDTO;
import iih.mp.nr.dto.internal.d.OrPlanDTO;
import iih.mp.nr.dto.mergedsamppridto.d.LabSampSrvDTO;
import iih.mp.nr.dto.orchkrfnd.d.OrChkRefundByOrDTO;
import iih.mp.nr.dto.orchkrfnd.d.OrChkRefundByPlanDTO;
import iih.mp.nr.dto.orchkrfnd.d.OrChkRefundDtlDTO;
import iih.mp.nr.dto.orchkrfnd.d.OrChkRefundSumDTO;
import iih.mp.nr.dto.vtevent.d.VtEventParamDTO;
import iih.mp.nr.foreign.d.CiorderPreviewDTO;
import iih.mp.nr.foreign.d.ExecPlanReturnDrugsDTO;
import iih.mp.nr.foreign.d.GetTemDataParamDTO;
import iih.mp.nr.foreign.d.TempDTO;
import iih.mp.nr.foreign.d.VsignImportDTO;
import iih.mp.nr.getscheduleapply.d.PrcGetScheduleApplyDTO;
import iih.mp.nr.mporplan.d.MpOrPlanDO;
import iih.mp.nr.opmergetube.d.SampleOrRelDTO;
import iih.mp.nr.temperaturechart.d.Temcharitemdto;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;

public interface IForeignService {

	/**
	 * 医嘱体征预览接口
	 * 
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	public abstract CiorderPreviewDTO[] getCiorderPreviewDTOS(String id_ent) throws BizException;

	/**
	 * 体征数据导入接口
	 * 
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	public abstract VsignImportDTO[] importVitalsignDate(VsignImportDTO[] DTOS) throws BizException;

	/**
	 * 体征数据模板查询
	 * 
	 * @return TempDTO[]
	 * @throws BizException
	 */
	public abstract TempDTO[] getVitalsignTemplate() throws BizException;

	/**
	 * 医嘱状态更新主逻辑
	 * 
	 * @param Id_or医嘱
	 * @param Dt_mp_plan计划执行时间
	 * @param Sd_orpltpsta闭环状态code
	 * @return
	 * @throws BizException
	 */
	public abstract String CheckSave(String Id_or, FDateTime Dt_mp_plan, String Sd_orpltpsta) throws BizException;

	/**
	 * 取消当前闭环状态
	 * 
	 * @param Id_or医嘱
	 * @param Dt_mp_plan计划执行时间
	 * @param Sd_orpltpsta闭环状态code
	 * @return
	 * @throws BizException
	 */
	public abstract String OrpltpBack(String Id_or, String Dt_mp_plan, String Sd_orpltpsta) throws BizException;

	/**
	 * 医嘱未执行状态统计查询
	 * 
	 * @param enParamDTO
	 * @param paramDTO
	 * @return
	 * @throws BizException
	 */
	public abstract PeStaCountDTO[] GetPeStaCount(EnServiceParamDTO[] enParamDTO, ParamDTO[] paramDTO) throws BizException;

	/**
	 * 医嘱未执行状态明细查询
	 * 
	 * @param enParamDTO
	 * @param paramDTO
	 * @return
	 * @throws BizException
	 */
	public abstract PeStaDTO[] GetPeStaList(EnServiceParamDTO enParamDTO, ParamDTO[] paramDTO) throws BizException;

	/**
	 * 出院核查（执行，费用）统计查询
	 * 
	 * @param enParamDTO
	 * @param paramDTO
	 * @return
	 * @throws BizException
	 */
	public abstract PeStaCountDTO[] getOutChkCount(EnServiceParamDTO[] ents, ParamDTO[] params, Integer eu_chk) throws BizException;

	/**
	 * 出院核查（执行，费用）明细查询
	 * 
	 * @param enParamDTO
	 * @param paramDTO
	 * @return
	 * @throws BizException
	 */
	public abstract PeStaDTO[] getOutChkDetail(EnServiceParamDTO ent, ParamDTO[] params, Integer eu_chk) throws BizException;

	/**
	 * 更改医嘱状态
	 * 
	 * @param Id_ors
	 * @return
	 * @throws BizException
	 */
	public abstract void UpdateOrderStatus(String[] Id_ors) throws BizException;

	/**
	 * 医嘱计划执行闭环明细
	 * 
	 * @param paramdtos
	 * @throws BizException
	 */
	public abstract OrdOrpltpDetailDTO[] getOrdOrpltpDetail(OrdOrpltpParamDTO[] paramdtos) throws BizException;

	/**
	 * 会诊医嘱状态处理
	 * 
	 * @param Id_or
	 * @return
	 * @throws BizException
	 */
	public abstract CiOrderDO[] ConsultationOrHandle(String[] Id_or) throws BizException;

	/**
	 * 诊疗视图体获取体征数据接口
	 * 
	 * @param paramDTO
	 * @return
	 * @throws BizException
	 */
	public abstract Temcharitemdto[] getTemData(GetTemDataParamDTO paramDTO) throws BizException;

	/**
	 * 此存接口用于通过发票号、住院号、申请单号、门诊住院标记、执行科室 从HIS获取病人的基本信息、医嘱信息、收费信息、检查信息；
	 * 
	 * @param code发票号
	 *            、住院号、申请单号
	 * @param code_entp门诊住院标记
	 * @param code_dep_mp执行科室
	 * @return 病人的基本信息、医嘱信息、收费信息、检查信息；
	 * @throws BizException
	 */
	public abstract PrcGetScheduleApplyDTO[] prcGetScheduleApply(String code, String code_entp, String code_dep_mp) throws BizException;

	/**
	 * 设置住院就诊体征事件
	 * 
	 * @throws BizException
	 */
	public abstract void setSignsOfEventsInfo(VtEventParamDTO[] paramDTOs) throws BizException;

	/**
	 * 取消住院就诊体征事件
	 * 
	 * @throws BizException
	 */
	public abstract void cancelSignsOfEventsInfo(String[] id_ors) throws BizException;

	/**
	 * 清除门诊补费医嘱计划
	 * 
	 * @param id_or_prs
	 * @throws BizException
	 */
	public abstract void clearCompensationFeePlans(String[] id_or_prs) throws BizException;

	/**
	 * 获取输液医嘱执行情况
	 * 
	 * @param id_ors
	 * @return
	 * @throws BizException
	 */
	public abstract InfusionExeDetailDTO[] getInfustionExeDetail(String[] id_ors) throws BizException;

	/**
	 * 新生儿登记处修改新生儿出生日期
	 * 
	 * @param paramDTO
	 * @throws BizException
	 */
	public abstract void updateEventInfo(VtEventParamDTO[] paramDTOs) throws BizException;

	/**
	 * 获取指定时间区间的执行计划
	 * 
	 * @param id_ors
	 * @param dt_begin
	 * @param dt_end
	 * @return
	 * @throws BizException
	 */
	public abstract MpOrPlanDO[] getEffectiveOrPlans(String[] id_ors, FDateTime dt_begin, FDateTime dt_end) throws BizException;

	/**
	 * 获取患者指定日期内的全部体征数据 就诊ID 开始时间 结束时间
	 * 
	 * @param Id_ent
	 *            就诊id
	 * @param BeginDate
	 *            开始时间
	 * @param EndDate
	 *            结束时间
	 * @return
	 * @throws BizException
	 */
	public abstract VitalSignsDTO[] GetVitalSignsDTOList(String Id_ent, String BeginDate, String EndDate) throws BizException;

	/**
	 * 获取指定区间内或者指定时间后是否含有有效执行计划
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public FBoolean hasEffectivePlanInSection(CpOrderStatusDto param) throws BizException;

	/**
	 * 门诊检验合单
	 * 
	 * @param param
	 * @throws BizException
	 */
	public abstract LabSampSrvDTO[] opMergerTube(SampleOrRelDTO[] params) throws BizException;
	
	/**
	 * 会诊专用改状态计费
	 * @param DTOS
	 * @param fun_code
	 * @param Oper_code
	 * @throws BizException
	 */
	public void upOrMpAndChargeforCons(OrPlanDTO[] DTOS, String fun_code, String Oper_code) throws BizException;
	
	/**
	 * 医技医生站 医技执行确认
	 * @param idors
	 * @param funcode
	 * @throws BizException
	 */
	public void techConfirm(String[] idors, String funcode) throws BizException;
	
	/**
	 * 医技医生站 医技执行取消
	 * @param idors
	 * @param funcode
	 * @throws BizException
	 */
	public void techCancel(String[] idors) throws BizException;
	
	/**
	 * 计算采血费和试管费
	 * @param params
	 * @return 
	 * @throws BizException
	 */
	public LabSampSrvDTO[] setSamplePrice(SampleOrRelDTO[] params) throws BizException;
	
	/**
	 * 检查哪些执行计划可以在各自对应的状态进行退药
	 * @param params
	 * @return 
	 * @throws BizException
	 */
	public ExecPlanReturnDrugsDTO[] checkReturnDrugs(ExecPlanReturnDrugsDTO[] params) throws BizException;

	/**
	 * 医嘱核停核废退执行汇总
	 * @param id_ors
	 * @return
	 * @throws BizException
	 */
	public abstract OrChkRefundSumDTO[] orChkRfndSum(String[] id_ors) throws BizException;
	
	/**
	 * 医嘱核停核废退执行明细
	 * @param id_ors
	 * @return
	 * @throws BizException
	 */
	public abstract OrChkRefundDtlDTO[] orChkRfndDtl(String[] id_ors) throws BizException;

	/**
	 * 医嘱核停核废退执行动作(计划维度)
	 * @param id_ors
	 * @return
	 * @throws BizException
	 */
	public abstract void orChkRfndByPlan(OrChkRefundByPlanDTO[] inParam) throws BizException;
	
	/**
	 * 医嘱核停核废退执行动作(医嘱维度)
	 * @param id_ors
	 * @return
	 * @throws BizException
	 */
	public abstract void orChkRfndByOr(OrChkRefundByOrDTO[] inParam) throws BizException;
}
