package iih.bl.cg.i;

import iih.bl.cg.bloepdelcostdto.d.BlOepDeLCostDTO;
import iih.bl.cg.blrecgoepdto.d.BlRecgOepDTO;
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
import iih.bl.st.dto.d.BlAuditIncInfoDTO;
import iih.bl.st.dto.d.BlIpAuditFeeDTO;
import iih.bl.st.dto.d.BlPrinterSetDTO;
import iih.bl.st.dto.d.BlStIpInccaInfoDTO;
import iih.bl.st.dto.d.BlStReFundBillDTO;
import iih.ci.ord.dto.recipedto.d.RecipeDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.sys.jdbc.facade.DAException;

/**
 * 记账查询服务接口
 * 
 * @author yankan
 * @since 2017-06-13
 *
 */
public interface IBlCgQryService {

	/**
	 * 根据患者id_pat 查询门诊记账明细表bl_cg_itm_oep 是否 含有挂起的数据
	 * 
	 * @param id_pat
	 * @author liwq
	 * @since 2017-7-13 11:35:05
	 */
	public BlRecgOepDTO[] getOepSuspInfos(String id_pat) throws BizException;

	/**
	 * 根据患者id_pat查询门诊未结算Fg_st='N'就诊信息
	 * 
	 * @param id_pat
	 *            病人ID
	 * @return
	 * @author liwq
	 * @throws BizException
	 * @since 2017-7-13 11:35:05
	 */
	public BlRecgOepDTO[] getOepUnsettledEnInfos(String id_pat) throws BizException;

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
	public abstract BlIpPatDTO[] getIpPatListInHos(String depId, String fuzzyCond) throws BizException;
	
	/**
	 * 获取出院患者列表
	 * @param depId
	 * @param fuzzyCond
	 * @return
	 * @throws BizException
	 */
	public abstract BlIpPatDTO[] getIpPatListOutHos(String depId, String fuzzyCond,String dt_b,String dt_e) throws BizException;

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
	public abstract BlIpPatDTO[] getIpPatConListInHos(String depId, String fuzzyCond) throws BizException;

	/**
	 * 
	 * @Title: getIpOutPatListInHos @Description: 获取转科患者信息 @param: @param
	 * depId @param: @return @param: @throws BizException @return:
	 * BlIpPatDTO[] @author: xy.zhou @throws
	 */
	public abstract BlIpPatDTO[] getIpOutPatListInHos(String idOldNur) throws BizException;

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
	public abstract BlIpOrdCgDTO[] getIpCgSumInfoByOrd(String entId, FBoolean isCiOrder, QryRootNodeDTO qryNode)
			throws BizException;

	/**
	 * 获取住院医嘱的记账信息
	 * 
	 * @param pageInfo
	 *            分页信息
	 * @param orId
	 *            医嘱id
	 * @param orId
	 *            就诊id
	 * @return
	 * @throws BizException
	 * @author liwenqiang
	 */
	public abstract PagingRtnData<BlIpCgDTO> getIpCgListByOrId(PaginationInfo pageInfo, String orId, String entId,
			String srvId) throws BizException;

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
	public abstract BlIpCgSrvSumDTO[] getIpCgSrvSumList(String entId, BlAnalysisQueryNodeDTO blAnalysisQuery)
			throws BizException;

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
	public BlIpCgDTO[] getIpCgListBySrvSum(String entId, BlIpCgSrvSumDTO inIpCgSrvSumDto, QryRootNodeDTO qryNode)
			throws BizException;

	/**
	 * 获取住院结算信息
	 * 
	 * @param entId
	 *            就诊id
	 * @return 住院结算信息集合
	 * @throws BizException
	 * @author liwenqiang
	 */
	public abstract BlIpStDTO[] getIpStList(String entId) throws BizException;

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
	public abstract BlInccaItmDTO[] getIpInccaItmSum(String entId, FBoolean fgSt, String stId) throws BizException;

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
	public abstract BlInccaItmDTO[] getIpInccaItmList(String entId, String inccaItmCode) throws BizException;

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
	 */
	public abstract BlStReFundBillDTO[] getOepCanCancelCgList(String patId, FDateTime st_b, FDateTime st_e)
			throws BizException;

	/**
	 * 获取收费处方信息集合
	 * 
	 * @param entIds
	 *            就诊id集合
	 * @return 处方信息集合
	 * @throws BizException
	 * @author yanglu
	 */
	public abstract RecipeDTO[] getOpCgRecipeList(String[] entIds) throws BizException;

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
	public NurseCompFeeItmDTO[] getPatiEntFeeSrvs(String entId, String condition) throws BizException;

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
	public NurseCompFeeItmDTO[] getSrvCgDetails(String entId, String[] srvIds) throws BizException;

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
	public abstract BlIpCgDTO[] getIpCgListByInccaItm(String entId, BlInccaItmDTO inccaItmDto) throws BizException;

	/**
	 * 
	 * @Title: getPatiEntFeeSrvsDep @Description: 组装退费的记账数据 @param entId @param
	 * srvIds @return: NurseCompFeeItmDTO[] @author: xy.zhou @throws
	 */
	public NurseCompFeeItmDTO[] getPatiEntFeeSrvsDep(String entId, String id_dep, String condition) throws BizException;

	/**
	 * 
	 * @Description: 获取某个项目下的医嘱明细集合 @param: @param
	 * nurseCompFee @param: @return @param: @throws BizException @author:
	 * xy.zhou @throws
	 */
	public NurseCompFeeItmDTO[] assembleMedicalAdviceRefund(NurseCompFeeItmDTO nurseCompFee) throws BizException;

	/**
	 * 根据就诊号获取可补费数据
	 * 
	 * @param id_ent
	 * @return
	 * @author liwenqiang
	 * @throws BizException
	 */
	public BlIpFeeDTO[] getBlIpFeeDTOINfoByIdEnt(QryRootNodeDTO query, String id_ent) throws BizException;

	/**
	 * 门诊通用补费 获取患者就诊记录 参数：BLCG0006
	 * 
	 * @author liwq
	 */
	public EntRecrodDTO[] getPatiEntRecrodInfo(String id_pat) throws BizException;

	/**
	 * 通过医嘱服务id查询门诊记账明细id
	 * 
	 * @param orsrvIds
	 *            医嘱服务ids
	 * @return
	 * @throws BizException
	 * @author ly 2018/07/28
	 */
	public String[] getCgOepItmIdsByOrsrv(String[] orsrvIds) throws BizException;

	/**
	 * 根据科室id获取补费费用模板
	 * 
	 * @param id_dep
	 * @return
	 * @throws BizException
	 */
	public NurseFeeTemplateDTO[] InitGetFeeTpl(String id_dep) throws BizException;

	/**
	 * 根据费用模板id获取费用模板明细
	 * 
	 * @param id_dep
	 * @return
	 * @throws BizException
	 */
	public NurseCompFeeItmDTO[] GetFeeTplItmByIdBlTpl(String id_bltpl) throws BizException;

	/**
	 * 
	 * @Description: 获取医嘱计价明细信息 @param: @param bQueryParamDTO @param: @throws
	 * BizException @author: xy.zhou @throws
	 */
	public BlIpOrdCgDTO[] GetorderValuationDetailed(BlOrderValuationQueryParamDTO bQueryParamDTO) throws BizException;

	/**
	 * 查询退费时显示明细
	 * 
	 * @param feeDto
	 * @return
	 * @date 2018年8月19日
	 * @author wq.li
	 */
	public BlIpFeeDTO getFundeDTO(BlIpFeeDTO feeDto) throws BizException;

	/**
	 * 查询可退费明细 （销账）
	 * 
	 * @param id_pat
	 *            患者id
	 * @param dt_b
	 *            开始时间
	 * @param dt_e
	 *            结束时间
	 * @return BlOepDeLCostDTO 销账数据源
	 * @throws BizException
	 * @author zhangxin06
	 * @date 2018-9-29
	 */
	public BlOepDeLCostDTO[] findDelOepCg(String id_pat, FDateTime dt_b, FDateTime dt_e) throws BizException;

	/**
	 * 获取科室在院患者列表
	 * 
	 * @param depId
	 *            科室id
	 * @param fuzzyCond
	 *            模糊查询条件
	 * @return 住院患者列表
	 * @throws BizException
	 * @author liwenqiang
	 */
	public abstract BlIpPatDTO[] getDepPatListInHos(String fuzzyCond) throws BizException;

	/**
	 * 住院费用项目汇总统计查询
	 * 
	 * @param qryDto
	 * @return 费用项目汇总统计 DTO数据 
	 * @throws BizException
	 * @author zhangxin
	 */
	public abstract BlFeeSrvTotalQryDTO[] getFeeSrvTotalQryDtos(BlFeeSrvConQryDTO qryDto) throws BizException;

	/**
	 * 住院费用项目明细患者信息查询
	 * 
	 * @param blFeeSrvTotalQryDto
	 * @return 费用项目明细 DTO数据
	 * @throws BizException
	 * @author zhangxin
	 */
	public abstract PagingRtnData<BlFeeSrvDetailQryDTO>  getFeeSrvDetailQryDtos(BlFeeSrvTotalQryDTO blFeeSrvTotalQryDto,BlFeeSrvConQryDTO blFeeSrvConQryDto,PaginationInfo pg)
			throws BizException;
	/**
	 * 查询病区的会诊患者
	 * @param fuzzyCond
	 * @return
	 * @throws BizException
	 */
	public abstract BlIpPatDTO[] getNurConPatListInHos(String fuzzyCond) throws BizException;

	/**
	 * 查询会诊患者执行科室为当前科室的费用
	 * @param entId
	 * @param condition
	 * @return
	 */
	public abstract NurseCompFeeItmDTO[] getConsEntFeeSrvsDep(String entId,String condition)throws BizException;
	
	/**
	 * 通过查询方案查询出患者信息（一日费用清单（住院处））
	 * @param queryNode
	 * @return
	 * @throws BizException
	 * @author shaokx
	 */
	public abstract EntPatInfoDTO[] getPatInfoByQry(QryRootNodeDTO queryNode) throws BizException;
	
	/**
	 * 查询门诊待转入费用明细（门诊费用转住院报销）
	 * @param id_ent
	 * @return
	 * @throws BizExcaption
	 */
	public abstract NoTfCostItmDTO[] getNoTfCost(String patId) throws BizException;
	
	/**
	 * 查询门诊已转入费用明细（门诊费用转住院费用）
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	public abstract NoTfCostItmDTO[] getAlreadyTfCost(String patId) throws BizException;
	
	/************住院退费新模式************************/
	
	/**
	 * 获取可以退费的数据
	 * @param nFeeItmDTO
	 * @return
	 */
	public abstract NurseCompFeeItmDTO [] getFeeRefundAble(NurseCompFeeItmDTO nFeeItmDTO)throws BizException;
	
	/**
	 * 获取申请单
	 * @return
	 * @throws BizException
	 */
	public abstract BlRefundApplyBillDTO [] getRefundApplys(String id_dep,String [] rdfitmIds)throws BizException;
	
	/**
	 * 获取申请单下的明细项目
	 * @return
	 * @throws BizException
	 */
	public abstract BlRefundSrvItemDTO [] getRefundSrvItems(String [] id_rdfaps)throws BizException;
	/**
	 *  查询待退费审核患者信息
	 * @param fuzzyCond
	 * @return
	 * @throws BizException
	 */
	public abstract BlIpPatDTO[] getFefundAppPatQry(String fuzzyCond) throws BizException;
	/**
	 * 根据就诊id 查询待退费审核明细
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	public abstract BlRefundSrvItemDTO[] getFefundAppDetailsQry(String id_ent,String sd_rfdaptp) throws BizException;
	
	/**
	 * 根据查询条件获取未撤销的申请单
	 * @return
	 * @throws BizException
	 */
	public abstract BlRefundApplyBillDTO[] getRfdApQuery(BlRefundApplyQueryDTO blQueryDTO)throws BizException;
	
	/***
	 * 查询患者可退费的医嘱集合
	 * @return
	 * @throws BizException
	 */
	public abstract BlOrderRefundListDTO[] getOrdRefundList(String id_ent)throws BizException;
	
	/**
	 * 根据申请单查询关联医嘱集合
	 * @param id_rfdap
	 * @return
	 */
	public abstract BlOrderRefundListDTO[] getRefundApOrdList(String [] id_rfdaps)throws BizException;
	/*************end**********************/
	
	/**
	 * 查询费用域打印配置(新)
	 * @return
	 * @throws BizException
	 * @author ly 2019/09/03
	 */
	public abstract BlPrinterSetDTO getPrinterSetInfoNew()throws BizException;
	
	/**
	 * 
	 * @Description: 获取医嘱计价明细信息 _急诊
	 * @param: @param bQueryParamDTO
	 * @param: @throws BizException      
	 * @author: xuebei     
	 * @throws
	 */
	public BlIpOrdCgDTO[] GetorderValuationDetailedET(BlOrderValuationQueryParamDTO bQueryParamDTO) throws BizException;

	/**
	 * 获取住院医保审核账单项目
	 * @param wherePart
	 * @return
	 * @throws BizException
	 */
	public BlStIpInccaInfoDTO [] GetIpHpAuditInccas(String wherePart) throws BizException;
	
	/**
	 * 查询住院医保审核费用明细信息-分组
	 * @param idEnt
	 * @param wherePart
	 * @return
	 * @throws BizException
	 * @author hanjq 2019-11-19 17:48:00
	 */
	public PagingRtnData<BlIpAuditFeeDTO> GetIpAuditFees(PaginationInfo pageInfo,String idEnt,String wherePart) throws BizException;
	
	/**
	 * 查询住院医保审核费用明细信息-不分组
	 * @param pageInfo
	 * @param idEnt 就诊主键
	 * @param wherePart 其他查询条件
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<BlIpAuditFeeDTO> GetIpAuditFeeDetails(PaginationInfo pageInfo,String idEnt,String wherePart) throws BizException;
	
	/**
	 * 获取已经结算的住院医保审核账单项目
	 * @param wherePart
	 * @return
	 * @throws BizException
	 */
	public BlStIpInccaInfoDTO [] GetSettledInccas(String idStip,String idIncIp,String wherePart) throws BizException;
	
	/**
	 * 获取预住院汇总信息
	 * @param blPreIpParamDto
	 * @return
	 * @throws BizException
	 */
	public BlPreIpSummayDTO getPreIpCgTotalInfo(BlPreIpParamDTO blPreIpParamDto) throws BizException;
	
	/**
	 * 获取预住院记账信息
	 * @param pgInfo
	 * @param blPreIpParamDto
	 * @return
	 */
	public PagingRtnData<BlIpCgDTO> getPreIpCgs(PaginationInfo pgInfo, BlPreIpParamDTO blPreIpParamDto) throws BizException;
	
	/**
	 * 查询门诊记账明细账单项信息
	 * @description:
	 * @author:hanjq  2020年7月3日
	 * @param idPat
	 * @param idStOep
	 * @return
	 * @throws BizException
	 */
	public BlStIpInccaInfoDTO[] findCgOepIncca(String wherePart) throws BizException;
	
	/**
	 * 查询门诊记账明细(分组)
	 * @description:
	 * @author:hanjq  2020年7月3日
	 * @param wherePart
	 * @return
	 * @throws DAException
	 */
	public BlIpAuditFeeDTO[] findCgItmOepforGroup(String wherePart) throws DAException;
	
	/**
	 * 查询门诊记账明细
	 * @description:
	 * @author:hanjq  2020年7月3日
	 * @param wherePart
	 * @return
	 * @throws DAException
	 */
	public BlIpAuditFeeDTO[] findCgItmOep(String wherePart) throws DAException;
}
