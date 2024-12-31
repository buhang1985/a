package iih.en.que.s;

import iih.bd.fc.quesite.d.QueSiteDO;
import iih.en.comm.ep.EnQueEP;
import iih.en.que.board.d.EnBrdSiteDO;
import iih.en.que.dto.d.OpQue4DispDTO;
import iih.en.que.dto.d.OpQue4EsDTO;
import iih.en.que.dto.d.TriageEntDTO;
import iih.en.que.enqueue.d.EnQueueDO;
import iih.en.que.i.IEnQueOutQryService;
import iih.en.que.i.IEnQueQryService;
import iih.en.que.s.bp.op.GetDrugQueByAddrBP;
import iih.en.que.s.bp.pharm.CheckPharmNeedTriageBP;
import iih.en.que.s.bp.pharm.GetCanDispenseSiteBP;
import iih.en.que.s.bp.pharm.GetDispenseSiteBP;
import iih.en.que.s.bp.pharm.GetEntQueListBP;
import iih.en.que.s.event.bp.WrapObj2OpQue4DispBP;
import iih.en.que.s.event.bp.WrapObj2OpQue4EsBP;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 队列对外查询服务
 * @author yank
 *
 */
@Service(serviceInterfaces={IEnQueOutQryService.class}, binding=Binding.JSONRPC)
public class EnQueOutQryServiceImpl implements IEnQueOutQryService {
	/**
	 * 获取发药窗口
	 * @param presId 处方id
	 * @param pharmDepId 药房科室id
	 * @return 返回Map,对应的key值：sortno、quesite
	 * @throws BizException
	 */
	@Override
	public FMap getDispenseSite(String presId,String pharmDepId) throws BizException{
		GetDispenseSiteBP getBP = new GetDispenseSiteBP();
		return getBP.exec(presId, pharmDepId);
	}
	
	/**
	 * 获取处方状态
	 * 药房:   2x  20-签到   21-配药   22-叫号   23-叫号未到   24-发药
	 * @param presId
	 * @return
	 * @throws BizException
	 */
	@Override
	public String getPreQueStatus(String presId) throws BizException{
		EnQueEP enqueEP = new EnQueEP();
		EnQueueDO[] enques = enqueEP.getEnQueueByDAFacade("Id_pres = '"+presId+"'","");
		if(enques == null){
			return null;
		}
		return enques[0].getSd_status_acpt();
	}
	/**
	 * 是否队列分诊
	 * @param pharmDepId 药房科室
	 * @return
	 * @throws BizException
	 */
	@Override
	public FBoolean isPharmNeedTriage(String pharmDepId) throws BizException{
		CheckPharmNeedTriageBP checkBP = new CheckPharmNeedTriageBP();
		return checkBP.exec(pharmDepId);
	}
	/**
	 * 获取可发药窗口
	 * @param entId 就诊id
	 * @param pharmDepId 药房科室id
	 * @param presId 处方id
	 * @param presTpId 处方类型id
	 * @return 站点集合
	 * @throws BizException
	 */
	@Override
	public QueSiteDO[] getCanDispenseSite(String entId,String pharmDepId,String presId,String presTpId) throws BizException{
		GetCanDispenseSiteBP getSiteBP = new GetCanDispenseSiteBP();
		return getSiteBP.exec(entId, pharmDepId, presId,presTpId);
	}
	/**
	 * 查询窗口队列
	 * @param queSiteId 窗口id
	 * @param statusList 查询的状态列表，21-配药   22-叫号   23-叫号未到   24-发药
	 * @param qryDate 查询日期
	 * @return 就诊队列集合
	 * @throws BizException
	 */
	@Override
	public EnQueueDO[] getEntQueList(String queSiteId,FArrayList statusList,FDate qryDate) throws BizException{
		GetEntQueListBP getBP = new GetEntQueListBP();
		return getBP.exec(queSiteId, statusList, qryDate);
	}
	/**
	 * 获取门诊队列事件源DTO
	 * 
	 * @param entId 就诊ID
	 * @param queId 就诊队列ID
	 * @param queSiteId 就诊站点ID
	 * @return
	 * @throws BizException
	 */
	@Override
	public OpQue4EsDTO getOpQue4EsDTO(String entId, String queId, String queSiteId) throws BizException {
		WrapObj2OpQue4EsBP bp = new WrapObj2OpQue4EsBP();
		return bp.wrap(queId, queSiteId, null, entId);
	}
	/***
	 * 通过大屏地址获取需要上屏的患者队列
	 * @param addr_brd
	 * @return
	 * @throws BizException
	 */
	@Override
	public EnBrdSiteDO[] getDrugQueByAddr(String addr_brd) throws BizException{
		GetDrugQueByAddrBP bp = new GetDrugQueByAddrBP();
		return bp.exec(addr_brd);
	}
	/**
	 * 组装上屏DTO
	 * @param es
	 * @param eventType
	 * @return
	 */
	@Override
	public  OpQue4DispDTO getOpQueDTO4Disp(OpQue4EsDTO es, String eventType)  throws BizException{
		WrapObj2OpQue4DispBP wrapBp = new WrapObj2OpQue4DispBP();
		return wrapBp.wrap(es, eventType);
	}
    /**
	 * 获取TriageEntDTO
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	@Override
	public TriageEntDTO getTriageEnt(String entId) throws BizException{
		return ServiceFinder.find(IEnQueQryService.class).getTriageEnt(entId);
	}
}
