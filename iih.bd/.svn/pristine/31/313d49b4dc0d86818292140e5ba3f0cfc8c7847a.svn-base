package iih.bd.pp.priceengine.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.base.utils.SqlUtils;
import iih.bd.pp.dto.d.PriceReqDTO;
import iih.bd.pp.dto.d.PriceResultDTO;
import iih.bd.pp.prisrvsetmu.d.PriSrvSetMuDO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FDouble;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 计算服务套成员项目个数加收
 * @author yankan
 * @since 2017-07-26
 *
 */
public class CalcSrvsetMuPriBP {
	/**
	 * 计算价格
	 * 
	 * @param priceReqDTOs 计价请求集合
	 * @return 计价结果map,[key: 服务ID，value: 服务计价结果DTO]
	 * @throws BizException
	 */
	public Map<String, PriceResultDTO> exec(PriceReqDTO[] priceReqDTOs) throws BizException {
		//参数校验
		
		//获取
		List<String> srvIdList = new ArrayList<String>();
		for(PriceReqDTO reqDTO:priceReqDTOs){
			srvIdList.add(reqDTO.getId_srv());
		}
		Map<String,PriceResultDTO> resultMap = new HashMap<String,PriceResultDTO>();
		Map<String,List<PriSrvSetMuDO>> priSrvSetMuMap = getPriSrvSetMuList(srvIdList.toArray(new String[0]));
		for(PriceReqDTO item : priceReqDTOs){
			List<PriSrvSetMuDO> priSrvSetMuList = priSrvSetMuMap.get(item.getId_srv());
			for(PriSrvSetMuDO srvSetMuDO : priSrvSetMuList){
//				if(isBetween(quan, srvSetMuDO.getQuan_min(), srvSetMuDO.getQuan_max())){
//					item.getValue().setPrice(srvSetMuDO.getPrice());
//					break;
//				}
			}
		}		
		
		return resultMap;
	}
	/**
	 * 
	 * @param srvSetId
	 * @return
	 * @throws BizException
	 */
	private Map<String,List<PriSrvSetMuDO>> getPriSrvSetMuList(String[] srvSetId) throws BizException{
		String whereStr = SqlUtils.getInSqlByIds(PriSrvSetMuDO.ID_SRVSET, srvSetId);
		String orderStr = PriSrvSetMuDO.QUAN_MIN;
		
		List<PriSrvSetMuDO> priSrvSetMuList = (List<PriSrvSetMuDO>)new DAFacade().findByCond(PriSrvSetMuDO.class, whereStr, orderStr);
		if(ListUtil.isEmpty(priSrvSetMuList)){
			return null;
		}
		
		Map<String,List<PriSrvSetMuDO>> priSrvSetMuMap = new HashMap<String,List<PriSrvSetMuDO>>();
		for(PriSrvSetMuDO srvSetMuDO:priSrvSetMuList){
			List<PriSrvSetMuDO> tempList = priSrvSetMuMap.get(srvSetMuDO.getId_srvset());
			if(tempList==null){
				tempList = new ArrayList<PriSrvSetMuDO>();
				priSrvSetMuMap.put(srvSetMuDO.getId_srvset(), tempList);
			}
			tempList.add(srvSetMuDO);
		}
		return priSrvSetMuMap;
	}
	/**
	 * 是否介于
	 * @param quan 数量
	 * @param min 最小值
	 * @param max 最大值
	 * @return
	 */
	private boolean isBetween(FDouble quan,FDouble min,FDouble max){
		return (min!=null && min.compareTo(quan)<=0) && (max==null || max.compareTo(quan)>=0);
	}
}
