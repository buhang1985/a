package iih.bd.mm.meterial.s.rule;

import java.util.ArrayList;

import iih.bd.base.utils.StringUtils;
import iih.bd.mm.meterial.d.MeterialAggDO;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.mm.st.task.paramcode.MmStTaskCode;
import iih.mm.st.task.paramcode.VirtualStockInTaskParamCode;
import iih.mm.utils.MmStParamUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.bizrule.IRule;
import xap.sys.devcfg.alert.taskcenter.itf.ISchedulerServiceAPI;

/**
 * 虚拟入库规则
 * 
 * @author hao_wu
 *
 */
public class VirtualStockInRule implements IRule<MeterialAggDO> {

	@Override
	public void process(MeterialAggDO... meterialAggDOs) throws BizException {
		
		FBoolean openVirtualStock = MmStParamUtils.GetOpenVirtualStock();
		if(!openVirtualStock.booleanValue()) {
			return;
		}
		
		String[] materialIds = getMaterialIds(meterialAggDOs);
		if (materialIds == null || materialIds.length <= 0) {
			return;
		}

		FMap2 paramMap = new FMap2();
		paramMap.put(VirtualStockInTaskParamCode.OPERATORID, Context.get().getStuffId());
		paramMap.put(VirtualStockInTaskParamCode.MATERIALIDS, StringUtils.join(",", materialIds));
		paramMap.put(VirtualStockInTaskParamCode.ISBACKGROUND, FBoolean.TRUE);

		ISchedulerServiceAPI api = ServiceFinder.find(ISchedulerServiceAPI.class);
		api.submitTask1(MmStTaskCode.VIRTUALSTOCKIN, paramMap);
	}

	/**
	 * 获取物品主键集合
	 * 
	 * @param meterialAggDOs
	 * @return
	 */
	private String[] getMaterialIds(MeterialAggDO[] meterialAggDOs) {
		ArrayList<String> materialIdList = new ArrayList<String>();
		if (meterialAggDOs != null) {
			for (MeterialAggDO meterialAggDO : meterialAggDOs) {
				MeterialDO materialDO = meterialAggDO.getParentDO();
				if (FBoolean.TRUE.equals(materialDO.getFg_active())) {
					materialIdList.add(materialDO.getId_mm());
				}
			}
		}
		return materialIdList.toArray(new String[0]);
	}
}
