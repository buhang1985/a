package iih.bd.pp.prisrvcomp.s.bp;

import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;

import iih.bd.mm.meterial.i.IMeterialMDOExtRService;
import iih.bd.pp.medsrvrealpriceqry.i.IMedSrvRealPriceQryService;
import iih.bd.pp.prisrvcomp.d.PriSrvCompDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 设置组合定价医疗服务子服务单价</br>
 * 调用真实价格获取接口获取单价
 * 
 * @author hao_wu
 *
 */
public class SetMedSrvCompItemPriceBp {

	public void exec(PriSrvCompDO[] priSrvComps) throws BizException {
		if (priSrvComps == null || priSrvComps.length <= 0) {
			return;
		}

		// 设置服务价格
		SetMedSrvCompItemPrice(priSrvComps);
		// 设置药品价格
		setMmPrice(priSrvComps);
	}

	private void setMmPrice(PriSrvCompDO[] priSrvComps) throws BizException {

		ArrayList<String> mmIdList = new ArrayList<String>();
		ArrayList<String> unitIdList = new ArrayList<String>();
		for (PriSrvCompDO priSrvCompDO : priSrvComps) {
			String mmId = priSrvCompDO.getId_mm();
			String unitId = priSrvCompDO.getId_unit();
			if (StringUtils.isNotBlank(mmId) && StringUtils.isNotBlank(unitId)) {
				priSrvCompDO.setPrice(null);
				mmIdList.add(mmId);
				unitIdList.add(unitId);
			}
		}

		if (mmIdList.size() <= 0) {
			return;
		}

		IMeterialMDOExtRService meterialMDOExtRService = ServiceFinder.find(IMeterialMDOExtRService.class);
		FMap refPriceMap = meterialMDOExtRService.getRefPrice(mmIdList.toArray(new String[0]),
				unitIdList.toArray(new String[0]));

		for (PriSrvCompDO priSrvCompDO : priSrvComps) {
			String mmId = priSrvCompDO.getId_mm();
			String unitId = priSrvCompDO.getId_unit();
			String mapKey = String.format("%s_%s", mmId, unitId);
			if (refPriceMap.containsKey(mapKey)) {
				priSrvCompDO.setPrice((FDouble) refPriceMap.get(mapKey));
			}
		}
	}

	/**
	 * 设置组合定价子服务价格
	 * 
	 * @param priSrvComps
	 * @throws BizException
	 */
	private void SetMedSrvCompItemPrice(PriSrvCompDO[] priSrvComps) throws BizException {
		FMap2 realPriceMap = GetRealPriceMap(priSrvComps);
		if (realPriceMap == null) {
			return;
		}

		for (PriSrvCompDO priSrvCompDO : priSrvComps) {
			String medSrvId = priSrvCompDO.getId_srv_bl();
			if (StringUtils.isNotEmpty(medSrvId) && realPriceMap.containsKey(medSrvId)) {
				FDouble price = (FDouble) realPriceMap.get(medSrvId);
				priSrvCompDO.setPrice(price);
			}
		}
	}

	/**
	 * 获取真实价格字典
	 * 
	 * @param priSrvComps
	 * @return
	 * @throws BizException
	 */
	private FMap2 GetRealPriceMap(PriSrvCompDO[] priSrvComps) throws BizException {
		String[] medSrvIds = GetMedSrvIds(priSrvComps);
		if (medSrvIds == null || medSrvIds.length <= 0) {
			return null;
		}

		IMedSrvRealPriceQryService realPriceQryService = ServiceFinder.find(IMedSrvRealPriceQryService.class);
		FMap2 realPriceMap = realPriceQryService.FindMedSrvRealPriMapByIds(medSrvIds);
		return realPriceMap;
	}

	/**
	 * 获取医疗服务主键集合
	 * 
	 * @param priSrvComps
	 * @return
	 */
	private String[] GetMedSrvIds(PriSrvCompDO[] priSrvComps) {
		ArrayList<String> medSrvIdList = new ArrayList<String>();
		for (PriSrvCompDO priSrvCompDO : priSrvComps) {
			if (priSrvCompDO != null && StringUtils.isNotEmpty(priSrvCompDO.getId_srv_bl())) {
				medSrvIdList.add(priSrvCompDO.getId_srv_bl());
			}
		}
		return medSrvIdList.toArray(new String[0]);
	}

}
