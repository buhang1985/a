package iih.bd.pp.priceengine.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.base.utils.SqlUtils;
import iih.bd.pp.dto.d.PriceReqDTO;
import iih.bd.pp.dto.d.PriceResultDTO;
import iih.bd.pp.i.IBdPpMsgConst;
import iih.bd.pp.prisrvcomp.d.PriSrvCompDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FDouble;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 计算服务组合价 合计(单个服务价格*数量)
 * 
 * @author yankan
 * @since 2017-07-26
 *
 */
public class CalcSrvCompPriBP {
	/**
	 * 计算价格
	 * 
	 * @param priceReqDTOs 计价请求集合
	 * @return 计价结果map,[key: 服务ID，value: 服务计价结果DTO]
	 * @throws BizException
	 */
	public Map<String, PriceResultDTO> exec(PriceReqDTO[] priceReqDTOs) throws BizException {
		// 验证参数

		// 1、初始化计价结果
		Map<String, PriceResultDTO> resultMap = this.initPriResult(priceReqDTOs);
		
		// 2、获取组合定价服务集合
		List<PriSrvCompDO> priSrvCompList = this.getSrvCompList(resultMap.keySet().toArray(new String[0]));

		// 3、计算组合服务的本服务定价
		Map<String, PriceResultDTO> basicSrvPriRstMap = this.calcBasicSrvPri(priSrvCompList);

		// 4、计算服务的组合定价
		for (PriSrvCompDO srvComp : priSrvCompList) {
			PriceResultDTO basicPriRstDTO = basicSrvPriRstMap.get(srvComp.getId_srv_bl());
			if (basicPriRstDTO != null) {
				basicPriRstDTO.setQuan(srvComp.getQuan());//设置数量
				FDouble priceStd = basicPriRstDTO.getPrice_std() == null ? FDouble.ZERO_DBL : basicPriRstDTO.getPrice_std();
				FDouble price = priceStd.multiply(srvComp.getQuan());// 单价*数量
				PriceResultDTO priRst = resultMap.get(srvComp.getId_srv());
				priRst.setPrice_std(priRst.getPrice_std().add(price));
				priRst.getSrvitm_list().add(basicPriRstDTO);// 添加服务子项
			}
		}

		return resultMap;
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
			PriceResultDTO priRst = new PriceResultDTO();
			priRst.setId_srv(reqDTO.getId_srv());
			priRst.setPrice_std(FDouble.ZERO_DBL);// 默认价格为0
			priRst.setError_msg(IBdPpMsgConst.ERROR_SRV_PRICE_NOT_DEFINED);
			priRst.setSrvitm_list(new FArrayList());
			resultMap.put(priRst.getId_srv(), priRst);
		}
		return resultMap;
	}

	/**
	 * 获取组合定价集合
	 * 
	 * @param srvIds
	 * @return
	 * @throws BizException
	 */
	private List<PriSrvCompDO> getSrvCompList(String[] srvIds) throws BizException {
		String whereStr = SqlUtils.getInSqlByIds(PriSrvCompDO.ID_SRV, srvIds);
		List<PriSrvCompDO> priSrvCompList = (List<PriSrvCompDO>) new DAFacade().findByCond(PriSrvCompDO.class,
				whereStr);
		return priSrvCompList;
	}

	/**
	 * 计算标准服务价格
	 * 
	 * @param priSrvCompList
	 * @return
	 * @throws BizException
	 */
	private Map<String, PriceResultDTO> calcBasicSrvPri(List<PriSrvCompDO> priSrvCompList) throws BizException {
		List<PriceReqDTO> basicSrvList = new ArrayList<PriceReqDTO>();
		for (PriSrvCompDO srvComp : priSrvCompList) {
			PriceReqDTO priReqDTO = new PriceReqDTO();
			priReqDTO.setId_srv(srvComp.getId_srv_bl());
			basicSrvList.add(priReqDTO);
		}
		// 计算服务价格
		CalcBasicSrvPriceBP calcBasicPriceBP = new CalcBasicSrvPriceBP();
		Map<String, PriceResultDTO> basicSrvPriMap = calcBasicPriceBP.exec(basicSrvList.toArray(new PriceReqDTO[0]));
		return basicSrvPriMap;
	}
}
