package iih.bd.mm.meterial.s.bp;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.ArrayUtils;

import iih.bd.base.utils.SqlUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FDouble;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.MapListHandler;

/**
 * 获取药品指定单位的参考零售价格
 * 
 * @author hao_wu 2019-4-4
 *
 */
public class GetRefSalePriceBp {

	@SuppressWarnings("unchecked")
	public FMap exec(String[] mmIds) throws BizException {
		if (ArrayUtils.isEmpty(mmIds)) {
			return null;
		}

		String sql = String.format("select id_mm,price from bd_mm where %s",
				SqlUtils.getInSqlByIds("id_mm", mmIds));

		DAFacade daFacade = new DAFacade();
		List<Map<String, Object>> mapList = (List<Map<String, Object>>) daFacade.execQuery(sql, new MapListHandler());

		FMap refSalePriceMap = new FMap();
		for (Map<String, Object> map : mapList) {
			String mmId = (String) map.get("id_mm");
			Object priceStdObj = map.get("price");
			FDouble priceStd = this.convertToFDouble(priceStdObj);
			refSalePriceMap.put(mmId, priceStd);
		}
		return refSalePriceMap;
	}

	/**
	 * 转换到FDouble
	 * 
	 * @param priceStdObj
	 * @return
	 */
	private FDouble convertToFDouble(Object priceStdObj) {
		if (priceStdObj instanceof BigDecimal) {
			return new FDouble((BigDecimal) priceStdObj);
		} else if (priceStdObj instanceof Integer) {
			return new FDouble((Integer) priceStdObj);
		}
		return (FDouble) priceStdObj;
	}

}
