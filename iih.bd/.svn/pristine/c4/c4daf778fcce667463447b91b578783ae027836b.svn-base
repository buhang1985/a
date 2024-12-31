package iih.bd.mm.meterial.s.bp;

import java.util.HashMap;
import java.util.List;

import iih.bd.mm.common.CalOperation;
import iih.bd.mm.meterial.d.MMPackageUnitDO;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.mm.meterial.i.ds.IMeterialService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 获取药品指定单位的参考价格
 * 
 * @author hao_wu 2019-4-4
 *
 */
public class GetRefPriceBp {

	public FMap exec(String[] mmIds, String[] reqUnitIds) throws BizException {

		// 1.获取参考零售价
		FMap refSalePriceMap = getRefSalePriceMap(mmIds);

		// 2.获取药品字典
		HashMap<String, MeterialDO> materialMap = findMaterialMap(mmIds);

		// 3.单位换算
		FMap refPriceMap = new FMap();
		IMeterialService mmSrv = ServiceFinder.find(IMeterialService.class);
		for (int i = 0; i < mmIds.length; i++) {
			String mmId = mmIds[i];
			String reqUnitId = reqUnitIds[i];

			if (!refSalePriceMap.containsKey(mmId)) {
				continue;
			}

			if (!materialMap.containsKey(mmId)) {
				continue;
			}

			FDouble refSalePrice = (FDouble) refSalePriceMap.get(mmId);
			String mapKey = String.format("%s_%s", mmId, reqUnitId);
			if (refSalePrice != null) {
				MMPackageUnitDO actualPkgUnitDO = mmSrv.findPackageUnitByUnitId(mmId, reqUnitId);
				if (actualPkgUnitDO == null) {
					continue;
				}

				MeterialDO materialDo = materialMap.get(mmId);
				FDouble refPrice = CalOperation.Conversion(IMeterialService.TYPE_PRICE, refSalePrice,
						materialDo.getFactor_sb(), actualPkgUnitDO.getFactor());
				refPrice = CalOperation.RoundPrice(refPrice);

				refPriceMap.put(mapKey, refPrice);
			} else {
				refPriceMap.put(mapKey, null);
			}
		}
		return refPriceMap;
	}

	/**
	 * 查询药品字典
	 * 
	 * @param mmIds
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private HashMap<String, MeterialDO> findMaterialMap(String[] mmIds) throws BizException {
		DAFacade daFacade = new DAFacade();
		List<MeterialDO> materialList = (List<MeterialDO>) daFacade.findByPKs(MeterialDO.class, mmIds);

		HashMap<String, MeterialDO> materialMap = new HashMap<String, MeterialDO>();
		for (MeterialDO meterialDO : materialList) {
			materialMap.put(meterialDO.getId_mm(), meterialDO);
		}
		return materialMap;
	}

	/**
	 * 获取参考零售价字典
	 * 
	 * @param mmIds
	 * @return
	 * @throws BizException
	 */
	private FMap getRefSalePriceMap(String[] mmIds) throws BizException {
		GetRefSalePriceBp bp = new GetRefSalePriceBp();
		FMap refSalePriceMap = bp.exec(mmIds);
		return refSalePriceMap;
	}

}
