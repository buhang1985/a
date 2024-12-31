package iih.bd.pp.baseprisrv.s.bp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.ArrayUtils;

import iih.bd.base.utils.SqlUtils;
import iih.bd.pp.baseprisrv.d.PriSrvDO;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.MapListHandler;

/**
 * 设置收费依据
 * 
 * @author hao_wu 2019-10-8
 *
 */
public class SetChargeBasisBp {

	@SuppressWarnings("unchecked")
	public void exec(PriSrvDO[] priSrvDOs) throws BizException {
		if (ArrayUtils.isEmpty(priSrvDOs)) {
			return;
		}

		String[] priSrvIds = new String[priSrvDOs.length];
		for (int i = 0; i < priSrvDOs.length; i++) {
			priSrvIds[i] = priSrvDOs[i].getId_srv();
		}

		String sql = String.format("select id_Srv,des from bd_pri_srv where dt_e = '2099-12-31 23:59:59' and %s",
				SqlUtils.getInSqlByIds("Id_srv", priSrvIds));
		DAFacade daFacade = new DAFacade();
		List<Map<String, Object>> dataList = (List<Map<String, Object>>) daFacade.execQuery(sql, new MapListHandler());

		Map<String, String> chargeBasisMap = new HashMap<String, String>();
		for (Map<String, Object> data : dataList) {
			String srvId = (String) data.get("id_srv");
			String chargeBasis = (String) data.get("des");
			chargeBasisMap.put(srvId, chargeBasis);
		}

		for (PriSrvDO priSrvDO : priSrvDOs) {
			String srvId = priSrvDO.getId_srv();
			if (chargeBasisMap.containsKey(srvId)) {
				priSrvDO.setCharge_basis(chargeBasisMap.get(srvId));
			}
		}
	}
}
