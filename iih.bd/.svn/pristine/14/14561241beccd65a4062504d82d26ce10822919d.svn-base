package iih.bd.pp.priceengine.bp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.base.utils.AppUtils;
import iih.bd.base.utils.SqlUtils;
import iih.bd.pp.dto.d.PriceReqDTO;
import iih.bd.pp.dto.d.PriceResultDTO;
import iih.bd.pp.i.IBdPpMsgConst;
import iih.bd.pp.prisrv.d.PriSrvDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 本服务定价计算
 * 
 * @author yankan
 * @since 2017-07-26
 *
 */
public class CalcBasicSrvPriceBP {
	/**
	 * 计算本服务价格
	 * 
	 * @param priceReqDTOs 计价请求集合
	 * @return 计价结果map,[key: 服务ID，value: 服务计价结果DTO]
	 * @throws BizException
	 */
	public Map<String, PriceResultDTO> exec(PriceReqDTO[] priceReqDTOs) throws BizException {
		// 参数校验

		// 1、获取本服务价格定义
		Map<String, PriceResultDTO> priceRstMap = new HashMap<String,PriceResultDTO>();
		for(PriceReqDTO reqDTO:priceReqDTOs){
			PriceResultDTO priRst = new PriceResultDTO();
			priRst.setId_srv(reqDTO.getId_srv());
			priRst.setError_msg(IBdPpMsgConst.ERROR_SRV_PRICE_NOT_DEFINED);
			priceRstMap.put(reqDTO.getId_srv(), priRst);
		}
		List<PriceResultDTO> srvRstList = this.getPriSrvList(priceRstMap.keySet().toArray(new String[0]));

		// 2、赋值		
		for (PriceResultDTO resultDTO : srvRstList) {
			PriceResultDTO priRst = priceRstMap.get(resultDTO.getId_srv());
			if (priRst != null) {
				priRst.setPrice_std(resultDTO.getPrice_std());
				priRst.setError_msg(null);//清空初始信息
			}
		}
		return priceRstMap;
	}

	/**
	 * 获取本服务价格
	 * 
	 * @param srvPriList
	 * @return
	 * @throws BizException
	 */
	private List<PriceResultDTO> getPriSrvList(String[] srvIds) throws BizException {
		// 获取本服务定价策略
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT ID_SRV,PRICE AS PRICE_STD ");
		sqlBuilder.append(" FROM BD_PRI_SRV");
		sqlBuilder.append(" WHERE 1=1 ");
		sqlBuilder.append(" AND ")
				.append(SqlUtils.getInSqlByIds(PriSrvDO.ID_SRV, srvIds));
		sqlBuilder.append(" AND (DT_B<=? AND ?<=DT_E)");
		sqlBuilder.append(" AND FG_ACTIVE=?");

		FDateTime currentTime = AppUtils.getServerDateTime();
		SqlParam param = new SqlParam();
		param.addParam(currentTime);
		param.addParam(currentTime);
		param.addParam(FBoolean.TRUE);

		List<PriceResultDTO> srvRstList = (List<PriceResultDTO>) new DAFacade().execQuery(sqlBuilder.toString(), param,
				new BeanListHandler(PriceResultDTO.class));
		return srvRstList;
	}
}
