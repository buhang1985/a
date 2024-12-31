package iih.bd.pp.bdbltpl.s.bp;

import java.util.ArrayList;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import iih.bd.mm.meterial.i.IMeterialMDOExtRService;
import iih.bd.pp.bdbltpl.d.BdBltplItmDO;
import iih.bd.pp.medsrvrealpriceqry.i.IMedSrvRealPriceQryService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 更新自定义费用模板明细集合</br>
 * 更新参考价,更新金额
 * 
 * @author hao_wu 2019-5-27
 *
 */
public class UpdateBlTplItmsBp {

	public void exec(BdBltplItmDO[] itms) throws BizException {
		if (ArrayUtils.isEmpty(itms)) {
			return;
		}

		// 1.设置服务价格
		this.setSrvPri(itms);

		// 2.设置物品价格
		this.setMmPri(itms);
	}

	/**
	 * 设置医疗服务参考价格
	 * 
	 * @param itmDos
	 * @throws BizException
	 */
	private void setSrvPri(BdBltplItmDO[] itmDos) throws BizException {
		ArrayList<String> srvIdList = new ArrayList<String>();
		for (BdBltplItmDO itmDo : itmDos) {
			if (FBoolean.FALSE.equals(itmDo.getFg_mm())) {
				srvIdList.add(itmDo.getId_srv());
			}
		}

		if (srvIdList.size() <= 0) {
			return;
		}

		IMedSrvRealPriceQryService priQryService = ServiceFinder.find(IMedSrvRealPriceQryService.class);
		FMap priMap = priQryService.findMedSrvRefPriMapByIds(srvIdList.toArray(new String[0]));
		if (priMap == null || priMap.size() <= 0) {
			return;
		}

		for (BdBltplItmDO itmDo : itmDos) {
			if (FBoolean.FALSE.equals(itmDo.getFg_mm()) && priMap.containsKey(itmDo.getId_srv())) {
				itmDo.setPri((FDouble) priMap.get(itmDo.getId_srv()));
				this.setAmt(itmDo);
			}
		}
	}

	/**
	 * 设置医疗物品价格
	 * 
	 * @param itmDos
	 * @throws BizException
	 */
	private void setMmPri(BdBltplItmDO[] itmDos) throws BizException {
		ArrayList<String> mmIdList = new ArrayList<String>();
		ArrayList<String> unitIdList = new ArrayList<String>();
		for (BdBltplItmDO itmDo : itmDos) {
			if (FBoolean.TRUE.equals(itmDo.getFg_mm()) && StringUtils.isNotBlank(itmDo.getId_mm())
					&& StringUtils.isNotBlank(itmDo.getId_unit())) {
				mmIdList.add(itmDo.getId_mm());
				unitIdList.add(itmDo.getId_unit());
			}
		}

		if (mmIdList.size() <= 0) {
			return;
		}

		IMeterialMDOExtRService meterialMDOExtRService = ServiceFinder.find(IMeterialMDOExtRService.class);
		FMap refPriMap = meterialMDOExtRService.getRefPrice(mmIdList.toArray(new String[0]),
				unitIdList.toArray(new String[0]));
		if (refPriMap == null || refPriMap.size() <= 0) {
			return;
		}

		for (BdBltplItmDO itmDo : itmDos) {
			if (FBoolean.TRUE.equals(itmDo.getFg_mm()) && StringUtils.isNotBlank(itmDo.getId_mm())
					&& StringUtils.isNotBlank(itmDo.getId_unit())) {
				String key = String.format("%s_%s", itmDo.getId_mm(), itmDo.getId_unit());
				if (refPriMap.containsKey(key)) {
					itmDo.setPri((FDouble) refPriMap.get(key));
					this.setAmt(itmDo);
				}
			}
		}

	}

	/**
	 * 设置价格
	 * 
	 * @param itmDo
	 */
	private void setAmt(BdBltplItmDO itmDo) {
		if (itmDo.getPri() != null && itmDo.getQuan_medu() != null) {
			itmDo.setAmt(itmDo.getPri().multiply(itmDo.getQuan_medu(), 2, FDouble.ROUND_HALF_UP));
		}
	}
}
