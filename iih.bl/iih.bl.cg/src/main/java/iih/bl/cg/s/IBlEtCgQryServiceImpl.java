package iih.bl.cg.s;

import iih.bl.cg.dto.d.BlAnalysisQueryNodeDTO;
import iih.bl.cg.dto.d.BlInccaItmDTO;
import iih.bl.cg.dto.d.BlIpCgDTO;
import iih.bl.cg.dto.d.BlIpCgSrvSumDTO;
import iih.bl.cg.dto.d.BlIpOrdCgDTO;
import iih.bl.cg.dto.d.BlIpPatDTO;
import iih.bl.cg.dto.d.BlIpStDTO;
import iih.bl.cg.dto.d.BlOrderValuationQueryParamDTO;
import iih.bl.cg.dto.d.NurseCompFeeItmDTO;
import iih.bl.cg.i.IBlEtCgQryService;
import iih.bl.cg.s.bp.et.GetEtCgListBySrvSumBP;
import iih.bl.cg.s.bp.et.GetEtCgSrvSumListBP;
import iih.bl.cg.s.bp.et.GetEtEntFeeSrvsDepBp;
import iih.bl.cg.s.bp.et.GetEtInccaItmListBP;
import iih.bl.cg.s.bp.et.GetEtInccaItmSumBP;
import iih.bl.cg.s.bp.et.GetEtPatListInHosBP;
import iih.bl.cg.s.bp.et.GetEtPatStDataBP;
import iih.bl.cg.s.bp.et.GetEtSrvCgDetailsBP;
import iih.bl.cg.s.bp.et.GetOepCgListByInccaItmBP;
import iih.bl.cg.s.bp.et.GetETorderValuationDetailedBp;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;

/**
* @author xy.zhou
* @date 2019年3月14日
 */
@Service(serviceInterfaces = { IBlEtCgQryService.class }, binding = Binding.JSONRPC)
public class IBlEtCgQryServiceImpl implements IBlEtCgQryService{

	/**
	 * 获取（某科室下）急诊留观患者列表
	 */
	@Override
	public BlIpPatDTO[] getRtPatListInHos(String code_entp,String depId, FBoolean fg_ip,FBoolean fg_st,String fuzzyCond) throws BizException {
		GetEtPatListInHosBP bp=new GetEtPatListInHosBP();
		return bp.exec(code_entp, depId, fg_ip, fg_st, fuzzyCond);
	}

	/**
	 * 获取急诊患者可退费数据项目汇总 
	 */
	@Override
	public NurseCompFeeItmDTO[] getEtEntFeeSrvsDep(String entId, String dep_id, String condition) throws BizException{
		GetEtEntFeeSrvsDepBp bp=new GetEtEntFeeSrvsDepBp();
		return bp.exec(entId, dep_id, condition);
	}
	
	/**
	 * 获取该患者某个项目下的可退费数据
	 */
	public NurseCompFeeItmDTO[] getEtSrvCgDetails(NurseCompFeeItmDTO nFeeItmDTO) throws BizException{
		GetEtSrvCgDetailsBP bp=new GetEtSrvCgDetailsBP();
		return bp.exec(nFeeItmDTO);
	}
	
	/**
	 * 查询急诊留观记账按服务的分组汇总信息
	 */
	@Override
	public BlIpCgSrvSumDTO[] getEtCgSrvSumList(String entId, BlAnalysisQueryNodeDTO blAnalysisQuery)
			throws BizException {
		GetEtCgSrvSumListBP bp=new GetEtCgSrvSumListBP();
		return bp.exec(entId, blAnalysisQuery);
	}
	
	/**
	 * 留观费用明细查询，根据就诊id，服务id以及查询面板
	 */
	@Override
	public BlIpCgDTO[] getEtCgListBySrvSum(String entId, BlIpCgSrvSumDTO inIpCgSrvSumDto,
			BlAnalysisQueryNodeDTO blAnalysisQuery) throws BizException {
		GetEtCgListBySrvSumBP bp= new GetEtCgListBySrvSumBP();
		return bp.exec(entId, inIpCgSrvSumDto, blAnalysisQuery);
	}
	
	/**
	 * 留观患者结算信息
	 */
	@Override
	public BlIpStDTO[] getEtPatStData(String entId) throws BizException {
		GetEtPatStDataBP bp= new GetEtPatStDataBP();
		return bp.exec(entId);
	}
	
	/**
	 * 获取门诊\住院账单项集合
	 */
	@Override
	public BlInccaItmDTO[] getEtInccaItmList(String entId, String inccaItmCode, String id_stoep) throws BizException {
		GetEtInccaItmListBP bp=new GetEtInccaItmListBP();
		return bp.exec(entId, inccaItmCode, id_stoep);
	}
	
	/**
	 * 获取门诊\住院账单项汇总信息
	 */
	@Override
	public BlInccaItmDTO[] getEtInccaItmSum(String entId, FBoolean fgSt, String stId) throws BizException {
		GetEtInccaItmSumBP bp=new GetEtInccaItmSumBP();
		return bp.exec(entId, fgSt, stId);
	}

	/**
	 * 获取留观账单项的记账信息 
	 */
	@Override
	public BlIpCgDTO[] getEtCgListByInccaItm(String entId, BlInccaItmDTO inccaItmDto) throws BizException {
		GetOepCgListByInccaItmBP bp=new GetOepCgListByInccaItmBP();
		return bp.exec(entId, inccaItmDto);
	}
	
	/**
	 * 获取急诊医嘱计价明细
	 */
	@Override
	public BlIpOrdCgDTO[] GetEtOrderValuationDetailed(BlOrderValuationQueryParamDTO bQueryParamDTO)
			throws BizException {
		GetETorderValuationDetailedBp bp=new GetETorderValuationDetailedBp(bQueryParamDTO);
		return bp.exec();
	}
}
