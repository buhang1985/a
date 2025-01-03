package iih.bl.cg.s;

import java.io.IOException;

import org.dom4j.DocumentException;

import iih.bl.cg.bloepdelcostdto.d.BlOepDeLCostDTO;
import iih.bl.cg.blrecgoepdto.d.BlRecgOepDTO;
import iih.bl.cg.bp.ip.GetIpCgListByInccaItmBP;
import iih.bl.cg.bp.ip.GetIpCgListByOrIdBP;
import iih.bl.cg.bp.ip.GetIpCgListBySrvSumBP;
import iih.bl.cg.bp.ip.GetIpCgSrvSumListBP;
import iih.bl.cg.bp.ip.GetIpCgSumInfoByOrdBP;
import iih.bl.cg.bp.ip.GetIpInccaItmListBP;
import iih.bl.cg.bp.ip.GetIpInccaItmSumBP;
import iih.bl.cg.bp.ip.GetIpPatConListInHosBP;
import iih.bl.cg.bp.ip.GetIpPatListInHosBP;
import iih.bl.cg.bp.ip.GetIpPatListOutHosBP;
import iih.bl.cg.bp.ip.GetIpStListBP;
import iih.bl.cg.bp.oep.GetOepCanCancelCgListBP;
import iih.bl.cg.bp.oep.GetOpCgRecipeListBP;
import iih.bl.cg.d.BlIpFeeDTO;
import iih.bl.cg.dto.d.BlAnalysisQueryNodeDTO;
import iih.bl.cg.dto.d.BlFeeSrvConQryDTO;
import iih.bl.cg.dto.d.BlFeeSrvDetailQryDTO;
import iih.bl.cg.dto.d.BlFeeSrvTotalQryDTO;
import iih.bl.cg.dto.d.BlInccaItmDTO;
import iih.bl.cg.dto.d.BlIpCgDTO;
import iih.bl.cg.dto.d.BlIpCgSrvSumDTO;
import iih.bl.cg.dto.d.BlIpOrdCgDTO;
import iih.bl.cg.dto.d.BlIpPatDTO;
import iih.bl.cg.dto.d.BlIpStDTO;
import iih.bl.cg.dto.d.BlOrderRefundListDTO;
import iih.bl.cg.dto.d.BlOrderValuationQueryParamDTO;
import iih.bl.cg.dto.d.BlPreIpParamDTO;
import iih.bl.cg.dto.d.BlPreIpSummayDTO;
import iih.bl.cg.dto.d.BlRefundApplyBillDTO;
import iih.bl.cg.dto.d.BlRefundApplyQueryDTO;
import iih.bl.cg.dto.d.BlRefundSrvItemDTO;
import iih.bl.cg.dto.d.EntPatInfoDTO;
import iih.bl.cg.dto.d.EntRecrodDTO;
import iih.bl.cg.dto.d.NoTfCostItmDTO;
import iih.bl.cg.dto.d.NurseCompFeeItmDTO;
import iih.bl.cg.dto.d.NurseFeeTemplateDTO;
import iih.bl.cg.i.IBlCgQryService;
import iih.bl.cg.s.bp.BlCgOepSellAccountBp;
import iih.bl.cg.s.bp.GetBlIpFeeDTOINfoBp;
import iih.bl.cg.s.bp.GetFeeTplItmBp;
import iih.bl.cg.s.bp.GetFundeDTOBP;
import iih.bl.cg.s.bp.GetInitFeeTplBp;
import iih.bl.cg.s.bp.GetIpAuditFeeDetailsBp;
import iih.bl.cg.s.bp.GetIpAuditFeesBp;
import iih.bl.cg.s.bp.GetIpHpAuditInccasBp;
import iih.bl.cg.s.bp.GetOepSuspInfoBP;
import iih.bl.cg.s.bp.GetPatInfoByQry;
import iih.bl.cg.s.bp.GetPatiEntFeeSrvsBp;
import iih.bl.cg.s.bp.GetPatiEntRecrodInfoBp;
import iih.bl.cg.s.bp.GetPreIpBP;
import iih.bl.cg.s.bp.GetPrinterSetInfoNewBP;
import iih.bl.cg.s.bp.GetSettleInccasBp;
import iih.bl.cg.s.bp.GetSrvCgDetailsBp;
import iih.bl.cg.s.bp.GetUnsettledEnInfoBP;
import iih.bl.cg.s.bp.et.GetETorderValuationDetailedBp;
import iih.bl.cg.s.bp.ip.BlIPFindOutPatLIstInHosBp;
import iih.bl.cg.s.bp.ip.GetConsEntFeeSrvsDepBP;
import iih.bl.cg.s.bp.ip.GetDepPatListInHosBP;
import iih.bl.cg.s.bp.ip.GetIpCgListBySrvTotalBP;
import iih.bl.cg.s.bp.ip.GetIpCgPatDetailsBySrvBp;
import iih.bl.cg.s.bp.ip.GetNurConPatListInHosBP;
import iih.bl.cg.s.bp.ip.GetPatiEntFeeSrvsDepNewBp;
import iih.bl.cg.s.bp.ip.GetorderValuationDetailedBp;
import iih.bl.cg.s.bp.ip.GetprojectDetailedBP;
import iih.bl.cg.s.bp.newrfd.GetFeeRefundAbleBP;
import iih.bl.cg.s.bp.newrfd.GetIpFefundAppDetailListBP;
import iih.bl.cg.s.bp.newrfd.GetIpFefundAppPatListBP;
import iih.bl.cg.s.bp.newrfd.GetOrdRefundListBP;
import iih.bl.cg.s.bp.newrfd.GetRefundApOrdListBP;
import iih.bl.cg.s.bp.newrfd.GetRefundApplysBP;
import iih.bl.cg.s.bp.newrfd.GetRefundSrvItemsBP;
import iih.bl.cg.s.bp.newrfd.GetRfdApQueryBP;
import iih.bl.cg.s.bp.op.OepChargeQryBP;
import iih.bl.cg.s.bp.op.GetAlreadyTfCostBP;
import iih.bl.cg.s.bp.op.GetCgOepItmIdsByOrsrvBP;
import iih.bl.cg.s.bp.op.GetNoTfCostBP;
import iih.bl.st.dto.d.BlIpAuditFeeDTO;
import iih.bl.st.dto.d.BlPrinterSetDTO;
import iih.bl.st.dto.d.BlStIpInccaInfoDTO;
import iih.bl.st.dto.d.BlStReFundBillDTO;
import iih.ci.ord.dto.recipedto.d.RecipeDTO;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.sys.jdbc.facade.DAException;

/**
 * 记账命令服务
 * 
 * @author yankan
 *
 */
@Service(serviceInterfaces = { IBlCgQryService.class }, binding = Binding.JSONRPC)
public class BlCgQryServiceImpl implements IBlCgQryService {

	/**
	 * 根据患者id_pat 查询门诊记账明细表bl_cg_itm_oep 是否 含有挂起的数据
	 * 
	 * @param id_pat
	 * @author liwq 2017年6月30日11:26:24
	 */
	@Override
	public BlRecgOepDTO[] getOepSuspInfos(String id_pat) throws BizException {
		GetOepSuspInfoBP bp = new GetOepSuspInfoBP();
		return bp.exec(id_pat);
	}

	/**
	 * 根据患者id_pat查询门诊未结算Fg_st='N'就诊信息
	 * 
	 * @param id_pat
	 *            病人ID
	 * @return
	 * @author liwq
	 * @throws BizException
	 */
	@Override
	public BlRecgOepDTO[] getOepUnsettledEnInfos(String id_pat) throws BizException {
		GetUnsettledEnInfoBP bp = new GetUnsettledEnInfoBP();
		return bp.exec(id_pat);
	}

	/**
	 * 获取在院患者列表
	 * 
	 * @param depId
	 *            科室id
	 * @param fuzzyCond
	 *            模糊查询条件
	 * @return 住院患者列表
	 * @throws BizException
	 * @author liming
	 */
	@Override
	public BlIpPatDTO[] getIpPatListInHos(String depId, String fuzzyCond) throws BizException {
		GetIpPatListInHosBP getIpListBP = new GetIpPatListInHosBP();
		return getIpListBP.exec(depId, fuzzyCond);
	}
	
	/**
	 * 获取出院患者列表
	 */
	@Override
	public BlIpPatDTO[] getIpPatListOutHos(String depId, String fuzzyCond,String dt_b,String dt_e) throws BizException {
		GetIpPatListOutHosBP getIpListBP = new GetIpPatListOutHosBP();
		return getIpListBP.exec(depId, fuzzyCond,dt_b,dt_e);
	}

	/**
	 * 获取会诊患者列表
	 * 
	 * @param depId
	 *            科室id
	 * @param fuzzyCond
	 *            模糊查询条件
	 * @return 住院患者列表
	 * @throws BizException
	 * @author liming
	 */
	public BlIpPatDTO[] getIpPatConListInHos(String depId, String fuzzyCond) throws BizException {
		GetIpPatConListInHosBP getIpConListBP = new GetIpPatConListInHosBP();
		return getIpConListBP.exec(depId, fuzzyCond);
	}

	/**
	 * 获取转科患者
	 * 
	 * @author xy.zhou
	 */
	@Override
	public BlIpPatDTO[] getIpOutPatListInHos(String idOldNur) throws BizException {
		BlIPFindOutPatLIstInHosBp bp = new BlIPFindOutPatLIstInHosBp();
		return bp.exec(idOldNur);
	}

	/**
	 * 查询住院记账按服务的分组汇总信息
	 * 
	 * @param entId
	 *            就诊id
	 * @param qryNode
	 *            查询模板
	 * @return 住院记账汇总信息集合
	 * @throws BizException
	 * @author liwenqiang
	 */
	@Override
	public BlIpOrdCgDTO[] getIpCgSumInfoByOrd(String entId, FBoolean isCiOrder, QryRootNodeDTO qryNode)
			throws BizException {
		GetIpCgSumInfoByOrdBP getIpCgSumBP = new GetIpCgSumInfoByOrdBP();
		return getIpCgSumBP.exec(entId, isCiOrder, qryNode);
	}

	/**
	 * 获取住院医嘱的记账信息
	 * 
	 * @param pageInfo
	 *            分页信息
	 * @param orId
	 *            医嘱id
	 * @return
	 * @throws BizException
	 */
	@Override
	public PagingRtnData<BlIpCgDTO> getIpCgListByOrId(PaginationInfo pageInfo, String orId, String entId, String srvId)
			throws BizException {
		GetIpCgListByOrIdBP getIpCgBP = new GetIpCgListByOrIdBP();
		return getIpCgBP.exec(pageInfo, orId, entId, srvId);
	}

	/**
	 * 查询住院记账按服务的分组汇总信息
	 * 
	 * @param entId
	 *            就诊id
	 * @param qryNode
	 *            查询模板
	 * @return 住院记账汇总信息集合
	 * @throws BizException
	 * @author lpy
	 */
	@Override
	public BlIpCgSrvSumDTO[] getIpCgSrvSumList(String entId, BlAnalysisQueryNodeDTO blAnalysisQuery)
			throws BizException {
		GetIpCgSrvSumListBP getIpCgSumBP = new GetIpCgSrvSumListBP();
		return getIpCgSumBP.exec(entId, blAnalysisQuery);
	}

	/**
	 * 查询住院记账集合
	 * 
	 * @param entId
	 *            就诊id
	 * @param srvId
	 *            服务id
	 * @param qryNode
	 *            查询模板
	 * @return 住院记账信息集合
	 * @throws BizException
	 */
	@Override
	public BlIpCgDTO[] getIpCgListBySrvSum(String entId, BlIpCgSrvSumDTO inIpCgSrvSumDto, QryRootNodeDTO qryNode)
			throws BizException {
		GetIpCgListBySrvSumBP getIpCgListBP = new GetIpCgListBySrvSumBP();
		return getIpCgListBP.exec(entId, inIpCgSrvSumDto, qryNode);
	}

	/**
	 * 获取住院结算信息
	 * 
	 * @param entId
	 *            就诊id
	 * @return 住院结算信息集合
	 * @throws BizException
	 * @author liwenqiang
	 */
	@Override
	public BlIpStDTO[] getIpStList(String entId) throws BizException {
		GetIpStListBP getIpStBP = new GetIpStListBP();
		return getIpStBP.exec(entId);
	}

	/**
	 * 获取住院账单项汇总信息
	 * 
	 * @param entId
	 *            就诊id
	 * @param fgSt
	 *            是否结算
	 * @param stId
	 *            结算id
	 * @return 账单项集合
	 * @throws BizException
	 * @author liwenqiang
	 */
	@Override
	public BlInccaItmDTO[] getIpInccaItmSum(String entId, FBoolean fgSt, String stId) throws BizException {
		GetIpInccaItmSumBP getInccaItmSumBP = new GetIpInccaItmSumBP();
		return getInccaItmSumBP.exec(entId, fgSt, stId);
	}

	/**
	 * 获取住院账单项集合
	 * 
	 * @param entId
	 *            就诊id
	 * @param inccaItmCode
	 *            账单项编码
	 * @return 账单项集合
	 * @throws BizException
	 * @author liwenqiang
	 */
	@Override
	public BlInccaItmDTO[] getIpInccaItmList(String entId, String inccaItmCode) throws BizException {
		GetIpInccaItmListBP getBillItmListBP = new GetIpInccaItmListBP();
		return getBillItmListBP.exec(entId, inccaItmCode);
	}

	/**
	 * 获取账单项的记账信息
	 * 
	 * @param entId
	 *            就诊id
	 * @param inccaItmCode
	 *            账单项编码
	 * @param cgDate
	 *            记账日期
	 * @return
	 * @throws BizException
	 * @author liwenqiang
	 */
	@Override
	public BlIpCgDTO[] getIpCgListByInccaItm(String entId, BlInccaItmDTO inccaItmDto) throws BizException {
		GetIpCgListByInccaItmBP getIpCgListBP = new GetIpCgListByInccaItmBP();
		return getIpCgListBP.exec(entId, inccaItmDto);
	}

	/**
	 * 获取可退的记账信息集合
	 * 
	 * @param patId
	 *            患者编码
	 * @param st_b
	 *            开始时间
	 * @param st_e
	 *            结束时间
	 * @return
	 * @throws BizException
	 * @author liwenqiang 2017.11.28
	 */
	@Override
	public BlStReFundBillDTO[] getOepCanCancelCgList(String patId, FDateTime st_b, FDateTime st_e) throws BizException {
		GetOepCanCancelCgListBP getBP = new GetOepCanCancelCgListBP();
		return getBP.exec(patId, st_b, st_e);
	}

	/**
	 * 获取收费处方信息集合
	 * 
	 * @param entIds
	 *            就诊id集合
	 * @return 处方信息集合
	 * @throws BizException
	 * @author yanglu
	 * @throws IOException
	 * @throws DocumentException
	 */
	@Override
	public RecipeDTO[] getOpCgRecipeList(String[] entIds) throws BizException {
		GetOpCgRecipeListBP getRecipeListBP = new GetOpCgRecipeListBP();
		return getRecipeListBP.exec(entIds);
	}

	/**
	 * 获取患者已记账的收费项目(只获取name_srv和id_srv)
	 * 
	 * @param entId
	 * @param condition
	 *            名称拼音过滤条件
	 * @return NurseCompFeeItmDTO
	 * @author liwq
	 * @since 2018年3月28日8:50:07
	 * @throws BizException
	 */
	public NurseCompFeeItmDTO[] getPatiEntFeeSrvs(String entId, String condition) throws BizException {
		GetPatiEntFeeSrvsBp bp = new GetPatiEntFeeSrvsBp();
		return bp.exec(entId, condition);
	}

	/**
	 * 
	 * @Description: 获取某科室的项目明细集合 @author: xy.zhou @throws
	 */
	@Override
	public NurseCompFeeItmDTO[] getPatiEntFeeSrvsDep(String entId, String id_dep, String condition)
			throws BizException {
		GetPatiEntFeeSrvsDepNewBp bp = new GetPatiEntFeeSrvsDepNewBp();
		return bp.exec(entId, id_dep, condition);
	}

	/**
	 * 获取就诊单个收费项目已记账明细
	 * 
	 * @param entId
	 *            就诊id
	 * @param srvIds
	 *            服务ids
	 * @return
	 * @author liwq
	 * @since 2018年3月28日10:24:21
	 * @throws BizException
	 */
	public NurseCompFeeItmDTO[] getSrvCgDetails(String entId, String[] srvIds) throws BizException {
		GetSrvCgDetailsBp bp = new GetSrvCgDetailsBp();
		return bp.exec(entId, srvIds);
	}

	/**
	 * 
	 * @Description: 获取某个项目下的医嘱明细集合 @author: xy.zhou @throws
	 */
	@Override
	public NurseCompFeeItmDTO[] assembleMedicalAdviceRefund(NurseCompFeeItmDTO nurseCompFee) throws BizException {
		GetprojectDetailedBP bp = new GetprojectDetailedBP();
		return bp.exec(nurseCompFee);
	}

	/**
	 * 根据就诊号获取可补费数据
	 * 
	 * @param id_ent
	 * @return
	 * @author liwenqiang
	 * @throws BizException
	 */
	@Override
	public BlIpFeeDTO[] getBlIpFeeDTOINfoByIdEnt(QryRootNodeDTO query, String id_ent) throws BizException {
		GetBlIpFeeDTOINfoBp bp = new GetBlIpFeeDTOINfoBp();
		return bp.exec(query, id_ent);
	}

	/**
	 * 门诊通用补费 获取患者就诊记录 参数：BLCG0006
	 * 
	 * @author liwq
	 */
	public EntRecrodDTO[] getPatiEntRecrodInfo(String id_pat) throws BizException {
		GetPatiEntRecrodInfoBp bp = new GetPatiEntRecrodInfoBp();
		return bp.exec(id_pat);
	}

	/**
	 * 通过医嘱服务id查询门诊记账明细id
	 * 
	 * @param orsrvIds
	 *            医嘱服务ids
	 * @return
	 * @throws BizException
	 * @author ly 2018/07/28
	 */
	@Override
	public String[] getCgOepItmIdsByOrsrv(String[] orsrvIds) throws BizException {
		GetCgOepItmIdsByOrsrvBP bp = new GetCgOepItmIdsByOrsrvBP();
		return bp.exec(orsrvIds);
	}

	/**
	 * 根据科室id获取补费费用模板
	 */
	@Override
	public NurseFeeTemplateDTO[] InitGetFeeTpl(String id_dep) throws BizException {
		GetInitFeeTplBp bp = new GetInitFeeTplBp();
		return bp.exec(id_dep);
	}

	/**
	 * 根据费用模板id获取费用模板明细
	 */
	@Override
	public NurseCompFeeItmDTO[] GetFeeTplItmByIdBlTpl(String id_bltpl) throws BizException {
		GetFeeTplItmBp bp = new GetFeeTplItmBp();
		return bp.exec(id_bltpl);
	}

	/**
	 * 查询退费时显示明细
	 * 
	 * @param feeDto
	 * @return
	 * @date 2018年8月19日
	 * @author wq.li
	 */
	public BlIpFeeDTO getFundeDTO(BlIpFeeDTO feeDto) throws BizException {
		GetFundeDTOBP bp = new GetFundeDTOBP();
		return bp.exec(feeDto);
	}

	/**
	 * 
	 * @Description: 获取医嘱计价明细 @author: xy.zhou @throws
	 */
	@Override
	public BlIpOrdCgDTO[] GetorderValuationDetailed(BlOrderValuationQueryParamDTO bQueryParamDTO) throws BizException {
		GetorderValuationDetailedBp bp = new GetorderValuationDetailedBp();
		return bp.exec(bQueryParamDTO);
	}

	/**
	 * 获取门诊待销账信息列表
	 * 
	 * @param id_pat
	 *            患者id
	 * @param dt_b
	 *            开始时间
	 * @param dt_e
	 *            结束时间
	 * @return 销账明细
	 * @throws BizException
	 * @author zhangxin06 2018-9-29
	 */
	@Override
	public BlOepDeLCostDTO[] findDelOepCg(String id_pat, FDateTime dt_b, FDateTime dt_e) throws BizException {
		BlCgOepSellAccountBp bp = new BlCgOepSellAccountBp();
		return bp.exec(id_pat, dt_b, dt_e);
	}

	/**
	 * 获取科室在院患者列表
	 * 
	 * @param fuzzyCond
	 *            模糊查询条件
	 * @return 住院患者列表
	 * @throws BizException
	 * @author liwenqiang
	 */
	@Override
	public BlIpPatDTO[] getDepPatListInHos(String fuzzyCond) throws BizException {
		GetDepPatListInHosBP bp = new GetDepPatListInHosBP();
		return bp.exec(fuzzyCond);
	}

	/**
	 * 获取住院费用汇总
	 * 
	 * @param BlFeeSrvConQryDTO
	 *            费用查询dto
	 * @return 住院费用项目列表
	 * @throws BizException
	 * @author zhangxin
	 */
	@Override
	public BlFeeSrvTotalQryDTO[] getFeeSrvTotalQryDtos(BlFeeSrvConQryDTO qryDto) throws BizException {
		GetIpCgListBySrvTotalBP bp = new GetIpCgListBySrvTotalBP();
		return bp.exec(qryDto);
	}

	/**
	 * 住院费用项目明细患者信息查询
	 * 
	 * @param blFeeSrvTotalQryDto
	 * @return 费用项目明细 DTO数据
	 * @throws BizException
	 * @author zhangxin
	 */
	@Override
	public PagingRtnData<BlFeeSrvDetailQryDTO> getFeeSrvDetailQryDtos(BlFeeSrvTotalQryDTO blFeeSrvTotalQryDto,
			BlFeeSrvConQryDTO blFeeSrvConQryDto,PaginationInfo pg) throws BizException {
		GetIpCgPatDetailsBySrvBp bp = new GetIpCgPatDetailsBySrvBp();
		return bp.exec(blFeeSrvTotalQryDto, blFeeSrvConQryDto,pg);
	}

	/**
	 * 查询病区的会诊患者
	 * @param fuzzyCond
	 * @return
	 * @throws BizException
	 */
	public BlIpPatDTO[] getNurConPatListInHos(String fuzzyCond) throws BizException{
		GetNurConPatListInHosBP bp=new GetNurConPatListInHosBP();
		return bp.exec(fuzzyCond);
	}


	/**
	 * 查询会诊患者执行科室为当前科室的费用
	 * @param entId
	 * @param condition
	 * @return
	 */
	public  NurseCompFeeItmDTO[] getConsEntFeeSrvsDep(String entId,String condition)throws BizException{
		GetConsEntFeeSrvsDepBP bp=new GetConsEntFeeSrvsDepBP();
		return bp.exec(entId, condition);
	}
	
	/**
	 * 通过查询方案查询出患者信息（一日费用清单（住院处））
	 */
	@Override
	public EntPatInfoDTO[] getPatInfoByQry(QryRootNodeDTO queryNode) throws BizException {
		GetPatInfoByQry bp = new GetPatInfoByQry();
		return bp.exec(queryNode);
	}

	/**
	 * 查询门诊待转入费用明细（门诊费用转住院报销）
	 */
	@Override
	public NoTfCostItmDTO[] getNoTfCost(String patId) throws BizException {
		GetNoTfCostBP bp = new GetNoTfCostBP();
		return bp.exec(patId);
	}

	/**
	 * 查询门诊已转入费用明细（门诊费用转住院费用）
	 */
	@Override
	public NoTfCostItmDTO[] getAlreadyTfCost(String patId) throws BizException {
		GetAlreadyTfCostBP bp = new GetAlreadyTfCostBP();
		return bp.exec(patId);
	}
	
	/************住院退费新模式************************/
	
	/**
	 * 获取可以退费的数据
	 * @param nFeeItmDTO
	 * @return
	 */
	@Override
	public NurseCompFeeItmDTO[] getFeeRefundAble(NurseCompFeeItmDTO nFeeItmDTO) throws BizException{
		GetFeeRefundAbleBP bp=new GetFeeRefundAbleBP();
		return bp.exec(nFeeItmDTO);
	}

	/**
	 * 获取申请单
	 * @return
	 * @throws BizException
	 */
	@Override
	public BlRefundApplyBillDTO[] getRefundApplys(String id_dep, String[] rdfitmIds) throws BizException {
		GetRefundApplysBP bp= new GetRefundApplysBP();
		return bp.exec(id_dep, rdfitmIds);
	}

	/**
	 * 获取申请单下的明细项目
	 * @return
	 * @throws BizException
	 */
	@Override
	public BlRefundSrvItemDTO[] getRefundSrvItems(String[] id_rdfaps) throws BizException {
		GetRefundSrvItemsBP bp=new GetRefundSrvItemsBP();
		return bp.exec(id_rdfaps);
	}

	/**
	 * 根据查询条件获取未撤销的申请单
	 * @return
	 * @throws BizException
	 */
	@Override
	public BlRefundApplyBillDTO[] getRfdApQuery(BlRefundApplyQueryDTO blQueryDTO) throws BizException {
		GetRfdApQueryBP bp=new GetRfdApQueryBP();
		return bp.exec(blQueryDTO);
	} 
	
	/**
     *  查询待退费审核患者信息
     *  
     */
	@Override
	public BlIpPatDTO[] getFefundAppPatQry(String fuzzyCond) throws BizException {
		GetIpFefundAppPatListBP bp = new GetIpFefundAppPatListBP();
		return bp.exec(fuzzyCond);
	}
    /**
     * *
	 * 根据就诊id 查询待退费审核明细
	 * @param id_ent
	 * @return
	 * @throws BizException
	 *
     */
	@Override
	public BlRefundSrvItemDTO[] getFefundAppDetailsQry(String id_ent,String sd_rfdaptp) throws BizException {
		GetIpFefundAppDetailListBP bp = new GetIpFefundAppDetailListBP();
		return bp.exec(id_ent,sd_rfdaptp);
	}

	/**
	 * 查询患者可退费的医嘱集合
	 */
	@Override
	public BlOrderRefundListDTO[] getOrdRefundList(String id_ent) throws BizException {
		GetOrdRefundListBP bp=new GetOrdRefundListBP();
		return bp.exec(id_ent);
	}

	/**
	 * 根据申请单查询关联医嘱集合
	 */
	@Override
	public BlOrderRefundListDTO[] getRefundApOrdList(String[] id_rfdaps) throws BizException {
		GetRefundApOrdListBP bp=new GetRefundApOrdListBP();
		return bp.exec(id_rfdaps);
	}
	
	/*************end**********************/
	
	/**
	 * 查询费用域打印配置(新)
	 * @return
	 * @throws BizException
	 * @author ly 2019/09/03
	 */
	@Override
	public BlPrinterSetDTO getPrinterSetInfoNew()throws BizException{
		GetPrinterSetInfoNewBP bp = new GetPrinterSetInfoNewBP();
		return bp.exec();
	}

	/**
	 * 
	 * @Description: 获取医嘱计价明细 _急诊   
	 * @author: xb     
	 * @throws
	 */
	@Override
	public BlIpOrdCgDTO[] GetorderValuationDetailedET(BlOrderValuationQueryParamDTO bQueryParamDTO) throws BizException {
		GetETorderValuationDetailedBp bp=new GetETorderValuationDetailedBp(bQueryParamDTO);
		return bp.exec();
	}

	/**
	 * 获取住院医保审核账单项目
	 */
	@Override
	public BlStIpInccaInfoDTO[] GetIpHpAuditInccas(String wherePart) throws BizException {
		GetIpHpAuditInccasBp bp = new GetIpHpAuditInccasBp();
		return bp.exec(wherePart);




	}

	/**
	 * 获取费用明细-分组
	 */
	@Override
	public PagingRtnData<BlIpAuditFeeDTO> GetIpAuditFees(PaginationInfo pageInfo, String idEnt, String wherePart)
			throws BizException {
		GetIpAuditFeesBp bp = new GetIpAuditFeesBp();
		return bp.exec(pageInfo,idEnt,wherePart);
	}

	/**
	 * 获取已经结算的住院医保审核账单项目
	 */
	@Override
	public BlStIpInccaInfoDTO[] GetSettledInccas(String idStip, String idIncIp, String wherePart) throws BizException {
		GetSettleInccasBp bp = new GetSettleInccasBp();
		return bp.exec(idStip,idIncIp,wherePart);
	}

	/**
	 * 查询住院医保审核费用明细信息-不分组
	 */
	@Override
	public PagingRtnData<BlIpAuditFeeDTO> GetIpAuditFeeDetails(PaginationInfo pageInfo, String idEnt, String wherePart)
			throws BizException {
		GetIpAuditFeeDetailsBp bp = new GetIpAuditFeeDetailsBp();
		return bp.exec(pageInfo,idEnt,wherePart);
	}
	/**
	 * 获取预住院汇总信息
	 * @param blPreIpParamDto
	 * @return
	 * @throws BizException
	 */
	@Override
	public BlPreIpSummayDTO getPreIpCgTotalInfo(BlPreIpParamDTO paramDto) throws BizException {
		GetPreIpBP bp = new GetPreIpBP();
		return bp.exec(paramDto);
	}

	/**
	 * 获取预住院记账信息
	 * @param pgInfo
	 * @param blPreIpParamDto
	 * @return
	 * @throws BizException 
	 */
	@Override
	public PagingRtnData<BlIpCgDTO> getPreIpCgs(PaginationInfo pgInfo, BlPreIpParamDTO paramDto) throws BizException {
		GetPreIpBP bp = new GetPreIpBP();
		return bp.exec(pgInfo,paramDto);
	}

	/**
	 * 查询门诊记账明细账单项信息
	 * @description:
	 * @author:hanjq  2020年7月3日
	 * @param idPat
	 * @param idStOep
	 * @return
	 * @throws BizException
	 */
	@Override
	public BlStIpInccaInfoDTO[] findCgOepIncca(String wherePart) throws BizException {
		OepChargeQryBP bp = new OepChargeQryBP();
		return bp.findCgOepIncca(wherePart);
	}

	/**
	 * 查询门诊记账明细(分组)
	 */
	@Override
	public BlIpAuditFeeDTO[] findCgItmOepforGroup(String wherePart) throws DAException {
		OepChargeQryBP bp = new OepChargeQryBP();
		return bp.findCgItmOepforGroup(wherePart);
	}

	/**
	 * 查询门诊记账明细
	 */
	@Override
	public BlIpAuditFeeDTO[] findCgItmOep(String wherePart) throws DAException {
		OepChargeQryBP bp = new OepChargeQryBP();
		return bp.findCgItmOep(wherePart);
	}

}
