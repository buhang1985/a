package iih.mp.nr.i;

import java.util.List;

import iih.ci.mr.cimrvs.d.CimrvsAggDO;
import iih.mp.mpbd.dto.hdv.d.HdvSumDTO;
import iih.mp.nr.drugrev.d.DrugRevDTO;
import iih.mp.nr.dto.d.BedQuanDTO;
import iih.mp.nr.dto.d.MporppDto;
import iih.mp.nr.dto.d.SkinTestDto;
import iih.mp.nr.dto.dbsignval.d.DbSignDTO;
import iih.mp.nr.dto.infureg.d.GroupPlanDTO;
import iih.mp.nr.dto.infureg.d.InfuExecCardDTO;
import iih.mp.nr.dto.internal.d.OrPlanDTO;
import iih.mp.nr.dto.internal.d.PlanDTO;
import iih.mp.nr.dto.signtimemodify.d.VsInOutHosDTO;
import iih.mp.nr.dto.skinexe.d.SkinExeDTO;
import iih.mp.nr.dto.vsconfig.d.VsConfigDTO;
import iih.mp.nr.mpnelabsamp.d.LabSampDO;
import iih.mp.nr.mporplan.d.MpOrPlanDO;
import iih.mp.nr.skdmsg.d.MpSkdMsgDO;
import iih.mp.nr.splitplan.splitrequest.d.ComSpQueParamDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;

public interface IMpNrMaintanceService {

	/**
	 * 住院医嘱拆分请求
	 * 
	 * @param param
	 * @throws BizException
	 */
	public abstract void ipSplitRequest(ComSpQueParamDTO param) throws BizException;

	/**
	 * 病区医嘱执行确认保存
	 * 
	 * @param ordMpPlanDos
	 * @return
	 * @throws BizException
	 */
	public abstract void wardConfirm(MporppDto[] params, SkinTestDto SkTDTO, FBoolean fg_postpaid) throws BizException;

	/**
	 * 批量医嘱执行
	 * 
	 * @param params
	 * @param id_emp
	 * @param dt_exe
	 * @return
	 * @throws BizException
	 */
	public abstract String batchOrderExec(MporppDto[] params, FBoolean fg_postpaid) throws BizException;

	/**
	 * 病区医嘱执行确认取消
	 * 
	 * @param params
	 * @return
	 * @throws BizException
	 */
	public abstract MpOrPlanDO[] wardConfirmCancel(OrPlanDTO[] params) throws BizException;;

	/**
	 * 更新医嘱床旁余量
	 * 
	 * @param id_or
	 * @return
	 * @throws BizException
	 */
	public abstract String updateOrderSrvBedQuan(BedQuanDTO[] quanDTOS) throws BizException;

	/***
	 * 
	 * 重新生成拆分相关属性
	 * 
	 * @param id_ents
	 */
	public abstract MpOrPlanDO[] regenerateSplit(String[] id_ents) throws BizException;

	/***
	 * 
	 * 执行医嘱作废
	 * 
	 * @param Id_or
	 */
	public abstract void invalidSave(String Id_or) throws BizException;

	/**
	 * 体征信息保存前（数据完整性）校验
	 * 
	 * @param aggs
	 * @throws BizException
	 */
	public abstract void mrVsSaveValidation(CimrvsAggDO[] aggs) throws BizException;

	/**
	 * 体温单配置信息保存
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public abstract void saveVsConfig(VsConfigDTO param) throws BizException;

	/**
	 * 病区打印拆分请求
	 * 
	 * @param id_ents
	 * @param dt_end
	 * @throws BizException
	 */
	public abstract void wardPrintSplit(String[] id_ents, String dt_end) throws BizException;

	/**
	 * 通用病区医嘱执行确认
	 * 
	 * @param params
	 * @param fun_code
	 * @return
	 * @throws BizException
	 */
	public abstract MpOrPlanDO[] wardExeConfirm(PlanDTO[] params, String fun_code, String code_oper) throws BizException;

	/**
	 * 保存皮试结果相关逻辑
	 * 
	 * @param params
	 * @param fun_code
	 * @return
	 * @throws BizException
	 */
	public abstract void saveSkinConfirm(SkinExeDTO param) throws BizException;

	/**
	 * 更新标签打印次数
	 * 
	 * @param id_or_prs
	 * @throws BizException
	 */
	public abstract void updateLablePrntTimes(String[] id_or_prs) throws BizException;

	/**
	 * 更新检验标签打印次数
	 * 
	 * @param id_or_prs
	 * @throws BizException
	 */
	public abstract void updateTestLablePrntTimes(String[] id_labsamps) throws BizException;

	/**
	 * 更新各种执行计划相关单子的打印状态
	 * @param ids
	 * @param sd_exectp
	 * @throws BizException
	 */
	public abstract void updateMpPrnStatus(String[] ids, String sd_exectp) throws BizException;

	/**
	 * 医技医嘱生成（纯生成）
	 * 
	 * @param id_ors
	 * @throws BizException
	 */
	public abstract MpOrPlanDO[] grntTechOr(String[] id_ors) throws BizException;

	/**
	 * 批量皮试保存
	 * 
	 * @param params
	 * @param stDtos
	 * @throws BizException
	 */
	public abstract void batchSaveSkinTest(MporppDto[] params, SkinTestDto[] stDtos) throws BizException;

	/**
	 * 门诊输液登记分组操作
	 * 
	 * @param params
	 * @return
	 * @throws BizException
	 */
	public void groupInfuReg(GroupPlanDTO[] params) throws BizException;

	/**
	 * 门诊输液登记取消分组操作
	 * 
	 * @param params
	 * @return
	 * @throws BizException
	 */
	public void cancelInfuRegGroup(GroupPlanDTO[] params) throws BizException;

	/**
	 * 门诊输液登记
	 * 
	 * @param params
	 * @param id_pat
	 * @throws BizException
	 */
	public void infuRegOrder(GroupPlanDTO[] params, String id_pat, String funcode, DbSignDTO dbSignDTO) throws BizException;

	/**
	 * 输液执行操作
	 * 
	 * @param param
	 * @throws BizException
	 */
	public void opInfuExec(InfuExecCardDTO param, String fun_code) throws BizException;

	/**
	 * 输液取消登记
	 * 
	 * @param params
	 * @throws BizException
	 */
	public void opInfuCancelReg(GroupPlanDTO[] params) throws BizException;

	/**
	 * 输液带走
	 * 
	 * @param params
	 * @throws BizException
	 */
	public void opInfuTakeAway(GroupPlanDTO[] params, String id_pat) throws BizException;

	/**
	 * 通用门诊医嘱执行确认
	 * 
	 * @param params
	 * @param fun_code
	 * @return
	 * @throws BizException
	 */
	public abstract MpOrPlanDO[] opWardExeConfirm(PlanDTO[] params, String fun_code, String code_oper) throws BizException;

	/**
	 * 保存或者更新护理任务信息
	 * 
	 * @param mpSkdMsgDO
	 * @return
	 * @throws BizException
	 */
	public abstract MpSkdMsgDO updateMpSkdMsgInfo(MpSkdMsgDO mpSkdMsgDO) throws BizException;

	/**
	 * 创建任务消息
	 * 
	 * @param idSkds
	 * @param id_ent
	 * @param id_pat
	 * @throws BizException
	 */
	public abstract void createMsgBp(List<String> idSkds, String id_ent, String id_param,List<String> param2) throws BizException;

	/**
	 * 响应临嘱打印和取消打印操作
	 * 更新临嘱执行人可编辑状态
	 * @param id_ors
	 * @param fg_prnt
	 * @return 
	 * @throws BizException
	 */
	public abstract boolean updateOrPrntStatus(String[] id_ors, FBoolean fg_prnt) throws BizException;

	/**
	 * 执行双签保存
	 * @param id_ors
	 * @param fg_prnt
	 * @throws BizException
	 */
	public abstract void dbSignSave(String[] id_or_prs, String id_emp_sign, String pwd, String sd_dbsign_tp) throws BizException;

	/**
	 * 保存体征修改记录
	 * @param id_mr_vs
	 * @param old_time
	 * @throws BizException
	 */
	public abstract void saveVsRec(VsInOutHosDTO[] list) throws BizException;

	/**
	 * 保存体征模板采集方案
	 * @param id_mrtpl_vst
	 * @param fun_code
	 * @param id_mrtpl_vs_itm
	 * @throws BizException
	 */
	public abstract void saveVsCollPrg(String id_mrtpl_vst, String fun_code, String[] id_mrtpl_vs_itm) throws BizException;

	/**
	 * 保存体温单打印记录
	 * @param id_ent
	 * @param dt_begin
	 * @param dt_end
	 * @param num
	 * @throws BizException
	 */
	public abstract void saveTmpChartPrnt(String id_ent, FDateTime dt_begin, FDateTime dt_end, int num) throws BizException;

	
	/**
	 * 病区执行打印保存
	 * @param id_keys
	 * @param id_prntca
	 * @throws BizException
	 */
	public abstract void wardPrntSave(String[] id_keys, String id_prntca) throws BizException;
	
	/**
	 * 处理危急值
	 * 
	 * @param id_lab_crval
	 * @throws BizException
	 */
	public abstract void hndLabCrVal(String id_lab_crval, String hnd_msg,String id_notic_doc,String dt_notic_doc, int type) throws BizException;
	
	/**
	 * 班次新增
	 * 
	 * @param dt_hdv
	 * @param id_hdv_def
	 * @param id_dep_nur
	 * @return
	 * @throws BizException
	 */
	public abstract HdvSumDTO addHdv(String dt_hdv, String id_hdv_def, String id_dep_nur) throws BizException;

	/**
	 * 交班保存/提交
	 * 
	 * @param dt_hdv
	 * @param id_hdv_def
	 * @param id_dep_nur
	 * @return
	 * @throws BizException
	 */
	public abstract void saveHdv(HdvSumDTO param, FBoolean fg_submit) throws BizException;

	/**
	 * 删除未提交的交班记录
	 * 
	 * @param param
	 * @throws BizException
	 */
	public abstract void delHavRecord(HdvSumDTO param) throws BizException;
	
	/**
	 * 标本费用计算
	 * 
	 * @param params
	 * @throws BizException
	 */
	public abstract void setSamplePrice(LabSampDO[] params, FBoolean fg_recal) throws BizException;
	 /**
	  * 药品接收保存
	  * @param params
	  * @throws BizException
	  */
	public abstract void saveDrugPlanRev(DrugRevDTO[] params, String fun_code) throws BizException;

	/**
	 * 通用医嘱(非医技)执行确认,加欠费执行参数
	 * @param params
	 * @param fun_code
	 * @param code_oper
	 * @param Fg_postpaid
	 * @return
	 * @throws BizException
	 */
	public MpOrPlanDO[] wardExeConfirmWithPostpaid(PlanDTO[] params, String fun_code, String code_oper, FBoolean Fg_postpaid) throws BizException;
	
}
