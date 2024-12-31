package iih.bl.cg.i;

import iih.bl.cg.dto.d.BlAnalysisQueryNodeDTO;
import iih.bl.cg.dto.d.BlInccaItmDTO;
import iih.bl.cg.dto.d.BlIpCgDTO;
import iih.bl.cg.dto.d.BlIpCgSrvSumDTO;
import iih.bl.cg.dto.d.BlIpOrdCgDTO;
import iih.bl.cg.dto.d.BlIpPatDTO;
import iih.bl.cg.dto.d.BlIpStDTO;
import iih.bl.cg.dto.d.BlOrderValuationQueryParamDTO;
import iih.bl.cg.dto.d.NurseCompFeeItmDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 
* @ClassName: BlEtCgQryService  
* @Description: 费用急诊记账查询服务
* @author xy.zhou
* @date 2019年3月14日
 */
public interface IBlEtCgQryService {

	/**
	* @Title: getRtPatListInHos  
	* @Description: 获取（某科室下）急诊留观患者列表
	* @param depId 为空时查询所有
	* @param fuzzyCond 模糊查询条件
	* @param fg_ip 是否在院
	* @param fg_st 是否结算
	* @throws BizException  
	* @return BlIpPatDTO 
	 */
	public abstract BlIpPatDTO [] getRtPatListInHos(String code_entp,String depId, 
			FBoolean fg_ip,FBoolean fg_st,String fuzzyCond)throws BizException;
	
	/**
	* @Title: getEtEntFeeSrvsDep  
	* @Description: 获取急诊患者可退费数据项目汇总 
	* @param entId
	* @param dep_id
	* @param condition 模糊查询条件  
	* @return NurseCompFeeItmDTO[] 
	 */
	public abstract NurseCompFeeItmDTO[] getEtEntFeeSrvsDep(String entId,String dep_id,
			String condition)throws BizException;
	
	/**
	 * 
	* @Title: getEtSrvCgDetails  
	* @Description: 获取该患者某个项目下的可退费数据
	* @param  nFeeItmDTO
	* @throws BizException  
	* @return NurseCompFeeItmDTO[] 
	 */
	public abstract NurseCompFeeItmDTO[] getEtSrvCgDetails(NurseCompFeeItmDTO nFeeItmDTO) throws BizException;
	
	/**
	* @Title: getEtCgSrvSumList  
	* @Description: 查询急诊留观记账按服务的分组汇总信息
	* @param entId
	* @param blAnalysisQuery
	* @throws BizException  
	* @return BlIpCgSrvSumDTO[] 
	* @author xy.zhou
	 */
	public abstract BlIpCgSrvSumDTO[] getEtCgSrvSumList(String entId, BlAnalysisQueryNodeDTO blAnalysisQuery) throws BizException;
	/**
	* @Title: getEtCgListBySrvSum  
	* @Description: 留观费用明细查询，根据就诊id，服务id以及查询面板
	* @param entId
	* @param inIpCgSrvSumDto
	* @param  blAnalysisQuery
	* @throws BizException  
	* @return BlIpCgDTO[] 
	* @author xy.zhou
	 */
	public abstract BlIpCgDTO[] getEtCgListBySrvSum(String entId,BlIpCgSrvSumDTO inIpCgSrvSumDto, BlAnalysisQueryNodeDTO blAnalysisQuery) throws BizException;
	/**
	* @Title: getEtPatStData  
	* @Description: 留观患者结算信息 
	* @param @param entId
	* @return BlIpStDTO[] 
	* @author xy.zhou
	* @throws  BizException  
	 */
	public abstract BlIpStDTO[] getEtPatStData(String entId)throws BizException;
	/**
	 * 
	* @Title: getEtInccaItmList  
	* @Description: 获取门诊\住院账单项集合
	* @param entId
	* @param inccaItmCode
	* @param id_stoep
	* @throws BizException  
	* @return BlInccaItmDTO[] 
	* @author xy.zhou
	 */
	public abstract BlInccaItmDTO[] getEtInccaItmList(String entId,String inccaItmCode, String id_stoep) throws BizException;
	/**
	 * 
	* @Title: getEtInccaItmSum  
	* @Description: 获取门诊\住院账单项汇总信息 
	* @param entId
	* @param fgSt
	* @param stId
	* @throws BizException  
	* @return BlInccaItmDTO[]
	* @author xy.zhou
	 */
	public abstract BlInccaItmDTO[] getEtInccaItmSum(String entId,FBoolean fgSt,String stId) throws BizException;
	/**
	 * 
	* @Title: getEtCgListByInccaItm  
	* @Description: 获取留观账单项的记账信息 
	* @param entId
	* @param  inccaItmDto
	* @throws BizException  
	* @return BlIpCgDTO[] 
	* @author xy.zhou
	 */
	public abstract BlIpCgDTO[] getEtCgListByInccaItm(String entId,BlInccaItmDTO inccaItmDto) throws BizException;
	/**
	 * 
	* @Title: GetEtOrderValuationDetailedET  
	* @Description: 获取急诊医嘱计价明细
	* @param bQueryParamDTO
	* @throws BizException  
	* @return BlIpOrdCgDTO[] 
	* @author xy.zhou
	 */
	public BlIpOrdCgDTO[] GetEtOrderValuationDetailed(BlOrderValuationQueryParamDTO bQueryParamDTO)throws BizException;
}
