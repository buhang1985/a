package iih.mp.nr.i;

import java.util.HashMap;
import java.util.List;

import iih.bd.srv.dto.d.PhySignDTO;
import iih.bd.srv.mrtplvs.d.BdMrtplVsDO;
import iih.mp.mpbd.dto.hdv.d.HdvSumDTO;
import iih.mp.mpbd.dto.vstmatch.d.VstmatchparanDTO;
import iih.mp.nr.batchskintest.d.BatchContentDTO;
import iih.mp.nr.batchskintest.d.SkinTestTimeDTO;
import iih.mp.nr.crisisval.d.CrisisValDO;
import iih.mp.nr.crisisval.d.CrisisValLisDO;
import iih.mp.nr.crisisval.d.CrisisValObsDO;
import iih.mp.nr.drugrev.d.DrugRevDTO;
import iih.mp.nr.dto.batchvs.d.BatchVsPatDTO;
import iih.mp.nr.dto.batchvs.d.VsPatCheckDTO;
import iih.mp.nr.dto.d.BedQuanDTO;
import iih.mp.nr.dto.d.MporppDto;
import iih.mp.nr.dto.executeinvalid.d.CondDTO;
import iih.mp.nr.dto.executeinvalid.d.InvalidOrderDTO;
import iih.mp.nr.dto.infureg.d.GroupPlanDTO;
import iih.mp.nr.dto.infureg.d.InfuRegPatDTO;
import iih.mp.nr.dto.infureg.d.RegValRstDTO;
import iih.mp.nr.dto.internal.d.OrPlanDTO;
import iih.mp.nr.dto.labcrvalqry.d.CrisvalResultDTO;
import iih.mp.nr.dto.labcrvalqry.d.HndLabcrvalDTO;
import iih.mp.nr.dto.labcrvalqry.d.LabcrvalCondDTO;
import iih.mp.nr.dto.mpskdmsg.d.MpSkdMsgDTO;
import iih.mp.nr.dto.nurstrs.d.RSDTO;
import iih.mp.nr.dto.orderview.d.OrderCondDTO;
import iih.mp.nr.dto.orderview.d.OrderViewDTO;
import iih.mp.nr.dto.signtimemodify.d.VsInOutHosDTO;
import iih.mp.nr.dto.sugapply.d.SugApplyDTO;
import iih.mp.nr.dto.sugapply.d.SugApplyParamDTO;
import iih.mp.nr.dto.tmpchartprntrecord.d.TmpChartPrntDTO;
import iih.mp.nr.dto.wardprint.d.ExeTabDTO;
import iih.mp.nr.dto.wardprint.d.PatInfoDTO;
import iih.mp.nr.exenur.d.ExecNurCondDTO;
import iih.mp.nr.mpnrbanner.d.Mpnrbannerdto;
import iih.mp.nr.mpwardprint.d.MpOrPrncaTreeDTO;
import iih.mp.nr.mpwardprint.d.WardPrntOrderDTO;
import iih.mp.nr.nur.d.MpOrNurDO;
import iih.mp.nr.ordermpqry.d.MpOrPrDTO;
import iih.mp.nr.ordermpqry.d.OrderContentDTO;
import iih.mp.nr.ordermpqry.d.OrderQryConditionDTO;
import iih.mp.nr.soaplable.d.SoapLabelDTO;
import iih.mp.nr.temperaturechart.d.TemperatureChartDTO;
import iih.mp.nr.visgncollectsingle.d.VisgnsingleTreeDTO;
import iih.mp.nr.vitalsign.d.VitalSignRecordDTO;
import iih.mp.nr.wardsrvqry.d.WardSrvQryConditionDTO;
import iih.mp.nr.wardsrvqry.d.WardSrvQryDetailDTO;
import iih.mp.nr.wardsrvqry.d.WardSrvQrySumDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

public interface IMpNrQueryService {

	/**
	 * 获取执行确认列表数据集合
	 * 
	 * @param id_ent
	 * @param dt_mp_plan
	 * @return
	 */
	public abstract MporppDto[] GetMporprDTOList(String[] id_ents, String dt_mp_plan) throws BizException;

	/**
	 * 获取执行确认分页列表数据集合
	 * 
	 * @param pg
	 *            分页信息
	 * @param id_ents
	 *            患者id信息
	 * @param condition
	 *            页面查询条件信息
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnData<MporppDto> GetMporprDTOPageList(PaginationInfo pg, String[] id_ents, Mpnrbannerdto condition) throws BizException;

	/**
	 * 获取批量执行确认列表数据集合
	 * 
	 * @param id_ent
	 * @param dt_mp_plan
	 * @return
	 */
	public abstract MporppDto[] getBatchMporppDtos(String[] id_ents, String dt_mp_plan) throws BizException;

	/**
	 * 获取医嘱床旁余量列表
	 * 
	 * @param id_or
	 * @return
	 * @throws BizException
	 */
	public abstract BedQuanDTO[] getOrderSrvBedQuan(String id_or) throws BizException;

	/**
	 * 医嘱查看
	 * 
	 * @param id_ent
	 * @throws BizException
	 */
	public abstract OrderViewDTO[] getOrderView(OrderCondDTO conDTO) throws BizException;

	/**
	 * 分页医嘱查看
	 * 
	 * @param id_ent
	 * @throws BizException
	 */
	public abstract PagingRtnData<OrderViewDTO> getOrderViews(PaginationInfo pg, OrderCondDTO param) throws BizException;

	/**
	 * 批量执行 执行计划查询
	 * 
	 * @param id_ents以","分隔的多个就诊ID
	 * @param time_begin查询开始时间
	 * @param time_end查询截止时间
	 * @return
	 * @throws BizException
	 */
	public abstract MporppDto[] GetBatchMporprDTOList(String id_ents, String time_begin, String time_end, String executestatus) throws BizException;

	/**
	 * 可作废医嘱查看
	 * 
	 * @param
	 * @throws BizException
	 */
	public abstract InvalidOrderDTO[] getInvalidOrderDTO(CondDTO param) throws BizException;

	/**
	 * 患者体征采集明细
	 * 
	 * @param id_ent
	 * @param dt_vt
	 * @return
	 * @throws BizException
	 */
	public abstract VisgnsingleTreeDTO[] getSigleVSTreeInfo(String id_ent, String dt_vt) throws BizException;

	/**
	 * 基于体征模板获取自定义体征项
	 * 
	 * @param id_mrtpl_vst
	 * @return
	 * @throws BizException
	 */
	public abstract BdMrtplVsDO[] getDefMrtplvs(String id_mrtpl_vst) throws BizException;

	/**
	 * 查询患者指定区间内的体征信息
	 * 
	 * @param id_ent
	 * @param dt_begin
	 * @param dt_end
	 * @param code_vs全部加载的项目编码
	 * @return
	 * @throws BizException
	 */
	public abstract TemperatureChartDTO queryTempChar(String id_ent, String dt_begin, String dt_end) throws BizException;

	/**
	 * 根据患者ID和就诊次数获取体温单数据
	 * 
	 * @param code_pat
	 * @param time_cur
	 * @return
	 * @throws BizException
	 */
	public abstract TemperatureChartDTO queryTempCharByPat(String code_pat, Integer time_cur) throws BizException;

	/**
	 * 根据就诊ID获取体温单数据
	 * 
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	public abstract TemperatureChartDTO queryTempCharByEnt(String id_ent) throws BizException;

	/**
	 * 体征采集患者信息获取
	 * 
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnData<BatchVsPatDTO> getBatchVsPatInfo(PaginationInfo pg, String sd_status, String signType, String key, String adultAndBabyTp) throws BizException;

	/**
	 * 获取婴儿信息列表
	 * 
	 * @return
	 * @throws BizException
	 */
	public abstract BatchVsPatDTO[] getBabyBatchVsPatInfo() throws BizException;

	/**
	 * 获取患者体征信息
	 * 
	 * @param id_ent
	 * @param code_vs
	 * @param dt_begin
	 * @param dt_end
	 * @return
	 * @throws BizException
	 */
	public abstract VitalSignRecordDTO[] getPatVsInfo(String id_ent, String id_mrtpl_vst, String dt_vt) throws BizException;

	/**
	 * 获取体征采集DTO
	 * 
	 * @param vstmatchparanDTO
	 * @return
	 * @throws BizException
	 */
	public abstract PhySignDTO[] getPhySignDTOInfo(VstmatchparanDTO vstmatchparanDTO) throws BizException;

	/**
	 * 获取医嘱最大允许执行的计划点
	 * 
	 * @param id_ors
	 * @return
	 * @throws BizException
	 */
	public OrPlanDTO[] GetPlanMaxExec(String[] id_ors) throws BizException;

	/**
	 * 护士站滚屏数据查询
	 * 
	 * @return
	 * @throws BizException
	 */
	public RSDTO[] getNurStationRsInfo(String id_rs) throws BizException;

	/**
	 * 获取病区打印患者信息
	 * 
	 * @return
	 * @throws BizException
	 */
	public PatInfoDTO[] getWardPrintPatInfos() throws BizException;

	/**
	 * 实例化分类执行单Tab数据结构
	 * 
	 * @return
	 * @throws BizException
	 */
	public abstract ExeTabDTO[] initExeListTab() throws BizException;

	/**
	 * 获取手术申请单信息
	 * 
	 * @param id_dep_mp
	 * @param dt_begin
	 * @param dt_end
	 * @return
	 * @throws BizException
	 */
	public abstract SugApplyDTO[] getIpSugInfo(SugApplyParamDTO param) throws BizException;

	/**
	 * 获取科室下的全部人员信息
	 * 
	 * @return
	 * @throws BizException
	 */
	public abstract String[] getDeptPsnInfo(String id_dep) throws BizException;

	/**
	 * 根据患者就诊ID和医嘱开立时间 获取批量患者医嘱内容
	 * 
	 * @param id_ent
	 * @param timedto
	 * @return
	 * @throws BizException
	 */
	public BatchContentDTO[] getContentList(String[] id_ent, SkinTestTimeDTO timedto) throws BizException;

	/**
	 * 护理单根据就诊id获取所有医嘱
	 * 
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	public String getNurContent(String entIds) throws BizException;

	/**
	 * 获取输液登记患者列表
	 * 
	 * @param dt_begin
	 * @param dt_end
	 * @return
	 * @throws BizException
	 */
	public abstract InfuRegPatDTO[] getInfuRegPatInfo(String dt_begin, String dt_end, String id_pat) throws BizException;

	/**
	 * 门急诊输液登记校验
	 * 
	 * @param params
	 * @return
	 * @throws BizException
	 */
	public abstract RegValRstDTO valInfuReg(GroupPlanDTO[] params) throws BizException;

	/**
	 * 获取患者的输液计划
	 * 
	 * @param dt_begin
	 * @param dt_end
	 * @param id_pat
	 * @return
	 * @throws BizException
	 */
	public abstract GroupPlanDTO[] getPatPlanInfo(String dt_begin, String dt_end, String id_pat) throws BizException;

	/**
	 * 获取输液执行患者列表
	 * 
	 * @param dt_begin
	 * @param dt_end
	 * @return
	 * @throws BizException
	 */
	public abstract InfuRegPatDTO[] getInfuExecPatInfo(String dt_begin, String dt_end, String id_pat) throws BizException;

	/**
	 * 获取输液执行的计划
	 * 
	 * @param dt_begin
	 * @param dt_end
	 * @param id_pat
	 * @return
	 * @throws BizException
	 */
	public abstract GroupPlanDTO[] getInfuExecPlanInfo(String dt_begin, String dt_end, String id_pat) throws BizException;

	/**
	 * 门急诊输液查询患者列表
	 * 
	 * @param dt_begin
	 * @param dt_end
	 * @param id_pat
	 * @return
	 * @throws BizException
	 */
	public abstract InfuRegPatDTO[] getInfuQrycPatInfo(InfuRegPatDTO patDTO) throws BizException;

	/**
	 * 门急诊输液查询计划列表
	 * 
	 * @param dt_begin
	 * @param dt_end
	 * @param id_pat
	 * @return
	 * @throws BizException
	 */
	public abstract GroupPlanDTO[] getInfuQrycPlanInfo(InfuRegPatDTO patDTO) throws BizException;

	/**
	 * 获取护理任务信息
	 * 
	 * @param id_emp
	 *            患者Id
	 * @param id_dept
	 *            患者科室
	 * @return
	 */
	public abstract MpSkdMsgDTO[] getMpSkdMsgInfo(String id_emp, String id_dept) throws BizException;

	/**
	 * 根据患者姓名，入院时间和截止时间以及服务类型，获取指定患者所有医嘱执行状态
	 * 
	 * @param qrydto
	 * @return
	 * @throws BizException
	 */
	public OrderContentDTO[] getOrderStaSrvList(OrderQryConditionDTO qrydto) throws BizException;

	/**
	 * 病区诊疗项目汇总查询（整个病区所有患者的服务）
	 * 
	 * @param qrydto
	 * @return
	 * @throws BizException
	 */
	public WardSrvQrySumDTO[] getWardSrvSumList(WardSrvQryConditionDTO qrydto) throws BizException;

	/**
	 * 病区诊疗项目明细查询（整个病区所有开立该服务的患者）
	 * 
	 * @param qrydto
	 * @return
	 * @throws BizException
	 */
	public WardSrvQryDetailDTO[] getWardSrvDetailList(WardSrvQryConditionDTO qrydto) throws BizException;

	/**
	 * 获取患者出入院体征记录
	 * 
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	public VsInOutHosDTO[] getVsInOutHosPatInfo(String id_ent) throws BizException;

	/**
	 * 代煎药标签打印
	 * 
	 * @param qryRootNodeDTO
	 * @param print_code
	 * @param sd_exectp
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnData<SoapLabelDTO> getSoapLabelDTOs(QryRootNodeDTO qryRootNodeDTO, String print_code, String sd_exectp, PaginationInfo pg) throws BizException;

	/**
	 * 获取病区执行打印单据维护树DTO
	 * 
	 * @author fengjj
	 * @return
	 * @throws BizException
	 */
	public abstract MpOrPrncaTreeDTO[] getMpOrPrncaTreeDTOs() throws BizException;

	/**
	 * 获取门急诊执行打印患者列表
	 * 
	 * @param dt_begin
	 * @param dt_end
	 * @param id_pat
	 * @return
	 * @throws BizException
	 */
	public abstract InfuRegPatDTO[] getOpmeExePrnPatInfo(String dt_begin, String dt_end) throws BizException;

	/**
	 * 获取体温单打印记录
	 * 
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnData<TmpChartPrntDTO> getTmpChartPrntDTOs(PaginationInfo pg, FBoolean fg_ip, String dt_begin, String dt_end, Integer eu_prnt, String key) throws BizException;

	/**
	 * 条件查询在院/出院患者
	 * 
	 * @param pg
	 * @param patCheckDTO
	 * @param adultAndBabyTp
	 * @param fun_code
	 * @param dt_date
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnData<BatchVsPatDTO> getBatchVsPatDTOs(PaginationInfo pg, VsPatCheckDTO patCheckDTO, String adultAndBabyTp, String fun_code, FDateTime dt_date) throws BizException;

	/**
	 * 获取危急值查询结果
	 * 
	 * @param conddto
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<CrisvalResultDTO> getLabcrvalRes(PaginationInfo pg, LabcrvalCondDTO dto) throws BizException;

	/**
	 * 获取危急项目
	 * 
	 * @param id_lab_crval
	 * @return
	 */
	public CrisisValLisDO[] getLabcrvalItm(String id_lab_crval) throws BizException;

	/**
	 * 获取危急患者信息及危急项目
	 * 
	 * @param id_lab_crval
	 * @return
	 * @throws BizException
	 */
	public HndLabcrvalDTO getLabPatInfo(String id_task) throws BizException;

	/**
	 * 获取危急项目
	 * 
	 * @param id_lab_crval
	 *            （检查）
	 * @return
	 */
	public CrisisValObsDO[] getObscrvalItm(String id_lab_crval) throws BizException;

	/**
	 * 获取危急值查询结果（检查）
	 * 
	 * @param conddto
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<CrisisValDO> getObscrvalRes(PaginationInfo pg, LabcrvalCondDTO dto) throws BizException;

	/**
	 * 获取危急患者信息及危急项目（检查）
	 * 
	 * @param id_lab_crval
	 * @return
	 * @throws BizException
	 */
	public HndLabcrvalDTO getObsPatInfo(String id_task) throws BizException;

	/**
	 * 获取指定患者指定医嘱的执行计划及其状态和服务（计费）
	 * 
	 * @param id_or
	 * @param qrydto
	 * @return
	 * @throws BizException
	 */
	public MpOrPrDTO[] getOrPlanStaSrvList(String id_or, OrderQryConditionDTO qrydto) throws BizException;

	/**
	 * 根据指标对照关系获取指定患者的指标信息
	 * 
	 * @param entParams
	 * @param vstagtParams
	 * @return
	 * @throws BizException
	 */
	public HashMap<String, List<String>> getPatTagtinfo(String[] entParams, String[] vstagtParams, FDateTime dt_date) throws BizException;

	/**
	 * 医嘱执行护士维护节点医嘱列表查询
	 */
	public PagingRtnData<MpOrNurDO> getOrdExeNurList(PaginationInfo pg, ExecNurCondDTO execNurCondDTO) throws BizException;

	/**
	 * 获取病区执行打印医嘱列表
	 * 
	 * @param id_keys
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnData<WardPrntOrderDTO> getWradPrntOrderList(PaginationInfo pg, String[] id_keys) throws BizException;

	/**
	 * 获取当前科室全部交班记录
	 * 
	 * @param pg
	 * @param dt_begin
	 * @param dt_end
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnData<HdvSumDTO> getNurHdvList(PaginationInfo pg, String dt_begin, String dt_end) throws BizException;
	
	/**
	 * 获取病区药品接收计划列表
	 * @param no_bar
	 * @return
	 * @throws BizException
	 */
	public abstract DrugRevDTO[] getDrugRevPlanList(String fun_code,String code_dgipde) throws BizException;
	
	/**
	 * 医技医嘱执行护士维护节点医嘱列表查询
	 */
	public abstract PagingRtnData<MpOrNurDO> getOrdSkillNurList(PaginationInfo pg, ExecNurCondDTO execNurCondDTO) throws BizException;

	
}
