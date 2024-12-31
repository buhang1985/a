package iih.en.que.i;

import iih.bd.fc.quesite.d.QueSiteDO;
import iih.en.que.board.d.EnBrdSiteDO;
import iih.en.que.dto.d.OpQue4DispDTO;
import iih.en.que.dto.d.OpQue4EsDTO;
import iih.en.que.dto.d.TriageEntDTO;
import iih.en.que.enqueue.d.EnQueueDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;

/**
 * 队列对外查询服务
 * @author yank
 *
 */
public interface IEnQueOutQryService {
	/**
	 * 获取发药窗口
	 * @param presId 处方id
	 * @param pharmDepId 药房科室id
	 * @return 返回Map,对应的key值：sortno、quesite
	 * @throws BizException
	 */
	FMap getDispenseSite(String presId,String pharmDepId) throws BizException;
	
	/**
	 * 获取处方状态
	 * @param presId
	 * @return
	 * @throws BizException
	 */
	String getPreQueStatus(String presId) throws BizException;
	/**
	 * 药房是否需要分诊
	 * @param pharmDepId 药房科室
	 * @return
	 * @throws BizException
	 */
	FBoolean isPharmNeedTriage(String pharmDepId) throws BizException;
	/**
	 * 获取可发药窗口
	 * @param entId 就诊id
	 * @param pharmDepId 药房科室id
	 * @param presId 处方id
	 * @param presTpId 处方类型id
	 * @return 站点集合
	 * @throws BizException
	 */
	QueSiteDO[] getCanDispenseSite(String entId,String pharmDepId,String presId,String presTpId) throws BizException;
	/**
	 * 查询窗口队列
	 * @param queSiteId 窗口id
	 * @param statusList 查询的状态列表，21-配药   22-叫号   23-叫号未到   24-发药
	 * @param qryDate 查询日期
	 * @return 就诊队列集合
	 * @throws BizException
	 */
	EnQueueDO[] getEntQueList(String queSiteId,FArrayList statusList,FDate qryDate) throws BizException;
	/**
	 * 获取门诊队列事件源DTO
	 * 
	 * @param entId 就诊ID
	 * @param queId 就诊队列ID
	 * @param queSiteId 就诊站点ID
	 * @return
	 * @throws BizException
	 */
	OpQue4EsDTO getOpQue4EsDTO(String entId, String queId, String queSiteId) throws BizException;
	/***
	 * 通过大屏地址获取需要上屏的患者队列
	 * @param addr_brd
	 * @return
	 * @throws BizException
	 */
	EnBrdSiteDO[] getDrugQueByAddr(String addr_brd) throws BizException;
	
	/**
	 * 组装上屏DTO
	 * @param es
	 * @param eventType
	 * @return
	 */
    OpQue4DispDTO getOpQueDTO4Disp(OpQue4EsDTO es, String eventType)  throws BizException;
    /**
	 * 获取TriageEntDTO
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	TriageEntDTO getTriageEnt(String entId) throws BizException;
}
