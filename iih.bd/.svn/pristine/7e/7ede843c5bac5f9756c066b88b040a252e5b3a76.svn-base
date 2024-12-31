package iih.bd.pp.modifypriplan.s.bp;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import iih.bd.bc.udi.pub.IBdPpDictCodeConst;
import iih.bd.pp.dto.priview.d.BdPriViewDTO;
import iih.bd.pp.i.IBdPriCalService;
import iih.bd.pp.modifypriplan.d.ModifyPriPlanItmDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 根据服务获取获取医保限价值和现价格
 * 
 * @author guoyang
 *
 */
public class UpdatePriMaxAndNowPriceBp {

	public void exec(ModifyPriPlanItmDO[] planItms, String id_pripat) throws BizException {

		String[] srvIds = getSrvIds(planItms);
		if (ArrayUtils.isEmpty(srvIds)) {
			return;
		}

		HashMap<String, FDouble> priMap = getPriMap(srvIds, id_pripat);

		for (ModifyPriPlanItmDO modifyPriPlanItmDO : planItms) {
			String srvId = modifyPriPlanItmDO.getId_srv();
			if (!priMap.containsKey(srvId)) {
				continue;
			}

			FDouble price = priMap.get(srvId);
			modifyPriPlanItmDO.setNow_price(price);
		}

		// TODO:铜陵获取最高限价的方案后期使用实体参数解决
		// PriMaxAndNowPriceQry qry = new PriMaxAndNowPriceQry(id_srv);
		// ModifyPriPlanItmDO[] modifyPriPlanItmDOs = (ModifyPriPlanItmDO[])
		// AppFwUtil.getDORstWithDao(qry, ModifyPriPlanItmDO.class);
		// if(modifyPriPlanItmDOs != null && modifyPriPlanItmDOs.length > 0){
		// return modifyPriPlanItmDOs[0];
		// }
		// return null;
	}

	/**
	 * 获取价格字典
	 * 
	 * @param srvIds
	 * @param id_pripat
	 * @return
	 * @throws BizException
	 */
	private HashMap<String, FDouble> getPriMap(String[] srvIds, String id_pripat) throws BizException {
		if (StringUtils.isBlank(id_pripat)) {
			// 标准价格调价
			id_pripat = IBdPpDictCodeConst.ID_PRI_PAT_NORMAL;
		}

		IBdPriCalService priCalService = ServiceFinder.find(IBdPriCalService.class);
		BdPriViewDTO[] priViewDTOs = priCalService.calSrvPrice(srvIds, new String[] { id_pripat });

		HashMap<String, FDouble> priMap = new HashMap<String, FDouble>();
		for (BdPriViewDTO bdPriViewDTO : priViewDTOs) {
			FDouble price = bdPriViewDTO.getPrice_ratio();
			priMap.put(bdPriViewDTO.getId_srv(), price);
		}
		return priMap;
	}

	/**
	 * 获取服务主键集合
	 * 
	 * @param modifyPriPlanItmDOs
	 * @return
	 */
	private String[] getSrvIds(ModifyPriPlanItmDO[] modifyPriPlanItmDOs) {
		ArrayList<String> srvIdList = new ArrayList<String>();
		for (ModifyPriPlanItmDO itmDo : modifyPriPlanItmDOs) {
			srvIdList.add(itmDo.getId_srv());
		}
		return srvIdList.toArray(new String[0]);
	}
}
