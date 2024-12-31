package iih.ci.preop.imp.bp.convert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvPriceDO;
import iih.bd.srv.medsrv.d.MedSrvSetItemDO;
import iih.bd.srv.medsrv.d.MedsrvAggDO;
import iih.bd.srv.medsrv.i.IMedSrvSetItemDORService;
import iih.bd.srv.medsrv.i.IMedsrvRService;
import iih.ci.ord.ciordems.d.EmsObsLap;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.sdk.utils.OrderEmsPriceUtils;
import iih.ci.tsip.d.CiTsOrDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 计算价格
 * 
 * @author mkp
 *
 */
public class PreIpApplyOrderPriceInfoConvertor {
	// 上下文
	CiEnContextDTO ctx;

	public PreIpApplyOrderPriceInfoConvertor(CiEnContextDTO ctx) {
		this.ctx = ctx;
	}

	public void transfer(CiTsOrDO tsOrder, CiEmsDTO ciEmsDTO) throws BizException {
		FArrayList ordSrvs = ciEmsDTO.getEmssrvs();
		if (ordSrvs == null || ordSrvs.size() == 0) {
			return;
		}
		
		for (Object item : ordSrvs) {
			CiEmsSrvDTO emsSrvDTO = (CiEmsSrvDTO) item;
			MedSrvPriceDO medSrvPriceDO = null;
			try {
				// 治疗
				if (tsOrder.getSd_srvtp().startsWith("05")) {
					medSrvPriceDO = OrderEmsPriceUtils.calculatePrice(emsSrvDTO.getId_srv(), emsSrvDTO.getId_primd(), emsSrvDTO.getId_pripat());					
				} 
				// 检查、检验
				else if (tsOrder.getSd_srvtp().startsWith("02") || tsOrder.getSd_srvtp().startsWith("03")) {
					// 获取主服务信息
					MedsrvAggDO aggDO = ServiceFinder.find(IMedsrvRService.class).findById(emsSrvDTO.getId_srv());
					if (aggDO == null) {
						throw new BizException("查询主服务信息失败！");
					}
					
					FArrayList setItemList = new FArrayList();
					setItemList = getSetItems(aggDO);
					
					medSrvPriceDO = OrderEmsPriceUtils.calculatePrice(aggDO.getParentDO(), ctx.getId_pripat(), setItemList);
				}
			} catch (Exception e) {
				throw new BizException("获取服务价格失败：" + e.getMessage());
			}
			
			if (medSrvPriceDO != null) {
				emsSrvDTO.setPri_std(medSrvPriceDO.getPrice_std());
				emsSrvDTO.setPri_ratio(medSrvPriceDO.getRatio());				
				emsSrvDTO.setPrice(medSrvPriceDO.getPrice_ratio());
			}
		}
		
	}

	/**
	 * 以下代码取自医疗单创建逻辑，由于很多代码用不到，所以已经删减了不少了。
	 * 
	 * 出处：iih.ci.ord.s.ems.op.ems.ris.EmsRisCreateBP.emsModelFrom(MedSrvDO)
	 * 
	 * date：2020-4-17
	 */
	private FArrayList getSetItems(MedsrvAggDO aggDO) throws BizException {
		FArrayList setItemList = new FArrayList();
		MedSrvDO med = aggDO.getParentDO();
		MedsrvAggDO[] srvSetItemAggDOs = null;
		MedSrvSetItemDO[] szMedSrvSetItem = null;
		Map<String, MedSrvSetItemDO> tmpSetItemCacheMap = new HashMap<String, MedSrvSetItemDO>();
		if (med.getFg_set().booleanValue()) {
			// 服务套
			szMedSrvSetItem = GetItemInSet(med.getId_srv(), true);
			if (null != szMedSrvSetItem && szMedSrvSetItem.length > 0) {
				List<String> listSrvId = new ArrayList<String>();
				for (MedSrvSetItemDO setItem : szMedSrvSetItem) {
					listSrvId.add(setItem.getId_srv_itm());
					tmpSetItemCacheMap.put(setItem.getId_srv_itm(), setItem);
				}
				// 获取套内项目的基础服务定义信息
				srvSetItemAggDOs = ServiceFinder.find(IMedsrvRService.class)
						.findByIds(listSrvId.toArray(new String[listSrvId.size()]), FBoolean.FALSE);
			}
		} else {
			srvSetItemAggDOs = new MedsrvAggDO[] { ServiceFinder.find(IMedsrvRService.class).findById(med.getId_srv()) };
		}

		if (srvSetItemAggDOs != null) {
			for (MedsrvAggDO agg : srvSetItemAggDOs) {
				EmsObsLap obs = new EmsObsLap();
				if (szMedSrvSetItem != null && szMedSrvSetItem.length > 0) {
					if (tmpSetItemCacheMap.containsKey(agg.getParentDO().getId_srv())) {
						MedSrvSetItemDO setItem = tmpSetItemCacheMap.get(agg.getParentDO().getId_srv());
						obs.setQuan_medu(setItem.getQuan_medu());
						obs.setEu_blmd(med.getEu_blmd());
						// 临床项目可选标志 = false, 选中标志 = true, 否则，全部 = false
						obs.setFg_chk(setItem.getFg_clinical().booleanValue() && setItem.getFg_edit().booleanValue()
								? FBoolean.TRUE : FBoolean.FALSE);
					}
				} else {
					obs.setFg_or(agg.getParentDO().getFg_or());
					obs.setQuan_medu(agg.getParentDO().getQuan_med());
					obs.setFg_chk(FBoolean.TRUE);
				}
				obs.setId_primd(agg.getParentDO().getId_primd());
				obs.setFg_bl(agg.getParentDO().getFg_bl());
				obs.setId_medu(agg.getParentDO().getId_unit_med());
				obs.setId_freq(agg.getParentDO().getId_freq());
				setItemList.append(obs);
			}
		}
		return setItemList;
	}
	
	/**
	 * 获取套内项目集合
	 * 
	 * @param id_srv
	 * @param is_clinical
	 * @return
	 * @throws BizException
	 */
	protected MedSrvSetItemDO[] GetItemInSet(String id_srv, boolean is_clinical) throws BizException {
		return ServiceFinder.find(IMedSrvSetItemDORService.class).find(String
				.format("a8.fg_clinical='%s' and a8.id_srv='%s' and a8.fg_active='Y'", is_clinical ? "Y" : "N", id_srv),
				"", FBoolean.FALSE);
	}

}
