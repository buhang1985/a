package iih.bd.pp.bdbltpl.s.bp;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.ArrayUtils;

import iih.bd.pp.bdbltpl.s.bp.qry.GetTplPriceMapQry;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDouble;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.MapListHandler;

/**
 * 获取费用模板价格字典
 * 
 * @author hao_wu 2019-12-11
 *
 */
public class GetTplPriceMapBp {

	@SuppressWarnings("unchecked")
	public Map<String, FDouble> exec(String[] tplIds) throws BizException {
		Map<String, FDouble> priceMap = new HashMap<String, FDouble>();
		if (ArrayUtils.isEmpty(tplIds)) {
			return priceMap;
		}
		GetTplPriceMapQry qry = new GetTplPriceMapQry(tplIds);

		DAFacade daFacade = new DAFacade();
		List<Map<String, Object>> dataList = (List<Map<String, Object>>) daFacade.execQuery(qry.getQrySQLStr(),
				qry.getQryParameter(null), new MapListHandler());

		if (dataList == null || dataList.size() <= 0) {
			return priceMap;
		}

		for (Map<String, Object> data : dataList) {
			String tplId = (String) data.get("id_bltpl");
			Object priceObj = data.get("price");
			FDouble price = null;
			if (priceObj instanceof BigDecimal) {
				price = new FDouble((BigDecimal) priceObj);
			} else if (priceObj instanceof Integer) {
				price = new FDouble((Integer) priceObj);
			} else {
				String msg = String.format("不支持的数据类型:%s", priceObj.getClass().getName());
				throw new BizException(msg);
			}
			priceMap.put(tplId, price);
		}

		return priceMap;
	}

}
