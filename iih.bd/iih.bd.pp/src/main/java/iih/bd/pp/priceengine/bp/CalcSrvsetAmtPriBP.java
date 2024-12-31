package iih.bd.pp.priceengine.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.base.utils.PrecisionUtils;
import iih.bd.base.utils.SqlUtils;
import iih.bd.pp.dto.d.PriceReqDTO;
import iih.bd.pp.dto.d.PriceResultDTO;
import iih.bd.pp.i.IBdPpMsgConst;
import iih.bd.pp.primd.i.IBdPrimdCodeConst;
import iih.bd.srv.dto.d.SrvSetItemDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FDouble;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 计算服务套合计价
 * 
 * @author yankan
 * @since 2017-07-26
 *
 */
public class CalcSrvsetAmtPriBP {
	/**
	 * 计算价格
	 * 
	 * @param priceReqDTOs 计价请求集合
	 * @return 计价结果map,[key: 服务ID，value: 服务计价结果DTO]
	 * @throws BizException
	 */
	public Map<String, PriceResultDTO> exec(PriceReqDTO[] priceReqDTOs) throws BizException {
		// 参数校验
		if(ArrayUtil.isEmpty(priceReqDTOs)){
			return null;
		}

		// 1、初始化计价结果
		Map<String, PriceResultDTO> priRstMap = this.initPriResult(priceReqDTOs);

		// 2、获取套内项目
		List<SrvSetItemDTO> setItemList = this.getSetItmList(priRstMap.keySet().toArray(new String[0]));

		// 3、根据定价模式分组
		Map<String, List<PriceReqDTO>> priReqMap = this.groupByPrimd(setItemList);

		// 4、计算服务套成员价格
		Map<String, PriceResultDTO> setItmPriRstMap = this.calcSetItmPrice(priReqMap);

		// 5、服务套成员合计价
		this.calcSetAmtPrice(priRstMap, setItmPriRstMap, setItemList);

		// 5、修改精度
		this.updatePrecesion(priRstMap);

		return priRstMap;
	}

	/**
	 * 初始化结果map
	 * 
	 * @param priceReqDTOs
	 * @return
	 */
	private Map<String, PriceResultDTO> initPriResult(PriceReqDTO[] priceReqDTOs) {
		Map<String, PriceResultDTO> resultMap = new HashMap<String, PriceResultDTO>();
		for (PriceReqDTO reqDTO : priceReqDTOs) {
			PriceResultDTO priRst = this.createDefPriceRst(reqDTO.getId_srv());
			resultMap.put(priRst.getId_srv(), priRst);
		}
		return resultMap;
	}

	/**
	 * 创建默认的计价结果
	 * 
	 * @param srvId
	 * @return
	 */
	private PriceResultDTO createDefPriceRst(String srvId) {
		PriceResultDTO priRst = new PriceResultDTO();
		priRst.setId_srv(srvId);
		priRst.setPrice_std(FDouble.ZERO_DBL);// 默认价格为0
		priRst.setError_msg(IBdPpMsgConst.ERROR_SRV_PRICE_NOT_DEFINED);
		priRst.setSrvitm_list(new FArrayList());
		return priRst;
	}

	/**
	 * 获取服务套项目集合
	 * 
	 * @param srvIds 服务ID集合
	 * @return
	 * @throws BizException
	 */
	private List<SrvSetItemDTO> getSetItmList(String[] srvIds) throws BizException {
		if (ArrayUtil.isEmpty(srvIds)) {
			return null;
		}

		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT SRV.ID_SRV,SRV.CODE,SRV.NAME,");
		sqlBuilder.append("SRVSET.ID_MEDU AS ID_UNIT_MED,SRVSET.QUAN_MEDU AS QUAN_MED,");
		sqlBuilder.append("SRV.SD_PRIMD,SRVSET.ID_SRV AS ID_SRV_SET ");
		sqlBuilder.append("FROM BD_SRVSET_DEF SRVSET ");
		sqlBuilder.append("LEFT JOIN BD_SRV SRV ON SRV.ID_SRV=SRVSET.ID_SRV_ITM ");
		sqlBuilder.append("WHERE SRVSET.FG_ACTIVE='Y' AND ");
		sqlBuilder.append(SqlUtils.getInSqlByIds("SRVSET.ID_SRV", srvIds));
		List<SrvSetItemDTO> srvSetItemList = (List<SrvSetItemDTO>) new DAFacade().execQuery(sqlBuilder.toString(),
				new BeanListHandler(SrvSetItemDTO.class));
		return srvSetItemList;
	}

	/**
	 * 根据定价模式分组
	 * 
	 * @param srvSetItemList
	 * @return
	 */
	private Map<String, List<PriceReqDTO>> groupByPrimd(List<SrvSetItemDTO> srvSetItemList) {
		Map<String, List<PriceReqDTO>> priReqMap = new HashMap<String, List<PriceReqDTO>>();
		for (SrvSetItemDTO srvItem : srvSetItemList) {
			List<PriceReqDTO> priReqList = priReqMap.get(srvItem.getSd_primd());
			if (priReqList == null) {
				priReqList = new ArrayList<PriceReqDTO>();
				priReqMap.put(srvItem.getSd_primd(), priReqList);
			}
			PriceReqDTO priReq = new PriceReqDTO();
			priReq.setId_srv(srvItem.getId_srv());
			priReqList.add(priReq);
		}
		return priReqMap;
	}

	/**
	 * 计算服务套内项目合计价 包含本服务定价和组合定价
	 * 
	 * @param priReqMap
	 * @return
	 * @throws BizException
	 */
	private Map<String, PriceResultDTO> calcSetItmPrice(Map<String, List<PriceReqDTO>> priReqMap) throws BizException {
		Map<String, PriceResultDTO> priRstMap = new HashMap<String, PriceResultDTO>();
		// 1、计算本服务定价
		if (priReqMap.containsKey(IBdPrimdCodeConst.CODE_PRI_SRV)) {
			List<PriceReqDTO> reqList = priReqMap.get(IBdPrimdCodeConst.CODE_PRI_SRV);
			if (!ListUtil.isEmpty(reqList)) {
				CalcBasicSrvPriceBP calcBasicPriBP = new CalcBasicSrvPriceBP();
				Map<String, PriceResultDTO> tempResult = calcBasicPriBP.exec(reqList.toArray(new PriceReqDTO[0]));
				priRstMap.putAll(tempResult);
			}
		}

		// 2、计算组合计价
		if (priReqMap.containsKey(IBdPrimdCodeConst.CODE_PRI_SRV_COMP)) {
			List<PriceReqDTO> reqList = priReqMap.get(IBdPrimdCodeConst.CODE_PRI_SRV_COMP);
			if (!ListUtil.isEmpty(reqList)) {
				CalcSrvCompPriBP calcCompPriBP = new CalcSrvCompPriBP();
				Map<String, PriceResultDTO> tempResult = calcCompPriBP.exec(reqList.toArray(new PriceReqDTO[0]));
				priRstMap.putAll(tempResult);
			}
		}
		
		//3、免费服务
		if (priReqMap.containsKey(IBdPrimdCodeConst.CODE_PRI_FREE)) {
			List<PriceReqDTO> reqList = priReqMap.get(IBdPrimdCodeConst.CODE_PRI_FREE);
			if (!ListUtil.isEmpty(reqList)) {
				CalcFreePriceBP calcFreeBP = new CalcFreePriceBP();
				Map<String, PriceResultDTO> tempResult = calcFreeBP.exec(reqList.toArray(new PriceReqDTO[0]));
				priRstMap.putAll(tempResult);
			}
		}
		
		//4、物品价格,需要单独调用
		if (priReqMap.containsKey(IBdPrimdCodeConst.CODE_PRI_RES)) {
			List<PriceReqDTO> reqList = priReqMap.get(IBdPrimdCodeConst.CODE_PRI_RES);
			if (!ListUtil.isEmpty(reqList)) {
				Map<String, PriceResultDTO> priceRstMap = new HashMap<String, PriceResultDTO>();
				for(PriceReqDTO reqDTO : reqList){
					PriceResultDTO resultDTO = new PriceResultDTO();
					resultDTO.setId_srv(reqDTO.getId_srv());
					resultDTO.setPrice_std(null);//
				}
				priRstMap.putAll(priceRstMap);
			}
		}
		
		return priRstMap;
	}

	/**
	 * 计算合计价
	 * 
	 * @param priRstMap
	 * @param setItmPriRstMap
	 * @param setItemList
	 */
	private void calcSetAmtPrice(Map<String, PriceResultDTO> priRstMap, Map<String, PriceResultDTO> setItmPriRstMap,
			List<SrvSetItemDTO> setItemList) {
		for (SrvSetItemDTO srvItm : setItemList) {
			PriceResultDTO srvPriRst = setItmPriRstMap.get(srvItm.getId_srv());
			if (srvPriRst != null) {
				PriceResultDTO setPriRst = priRstMap.get(srvItm.getId_srv_set());
				setPriRst.setPrice_std(srvPriRst.getPrice_std().multiply(srvItm.getQuan_med()));
				setPriRst.getSrvitm_list().add(srvPriRst);// 添加子项目
			}
		}
	}

	/**
	 * 修改精度
	 * 
	 * @param resultMap
	 */
	private void updatePrecesion(Map<String, PriceResultDTO> resultMap) {
		for (PriceResultDTO resultDTO : resultMap.values()) {
			resultDTO.setPrice_std(PrecisionUtils.formatPrice(resultDTO.getPrice_std()));
			resultDTO.setPrice_ratio(PrecisionUtils.formatPrice(resultDTO.getPrice_ratio()));
		}
	}
}
