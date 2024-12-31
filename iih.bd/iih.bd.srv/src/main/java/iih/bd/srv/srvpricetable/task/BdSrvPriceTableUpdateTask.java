package iih.bd.srv.srvpricetable.task;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSON;

import iih.bd.srv.srvpricetable.i.IBdSrvPriceTableUpdateService;
import iih.bd.utils.log.BdSrvPriceTableUpdateLogUtils;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.devcfg.alert.PreAlertObject;
import xap.sys.devcfg.alert.taskcenter.BgWorkingContext;
import xap.sys.devcfg.alert.taskcenter.IBackgroundWorkPlugin;

/**
 * 
 * 医疗服务价格表更新后台任务</br>
 * 当BD_PRICE_RP或者VIEW_PRICE_RP中价格不正确时，执行此任务更新基础数据医疗服务价格表</br>
 * 1.医疗服务不为空时，根据医疗服务更新</br>
 * 2.医疗物品不为空时，根据医疗物品更新</br>
 * 3.患者价格分类不为空时，根据患者价格分类更新</br>
 * 4.全为空时更新所有数据（慎用）</br>
 * 
 * @author hao_wu
 * @date 2020年4月27日
 *
 */
public class BdSrvPriceTableUpdateTask implements IBackgroundWorkPlugin {

	private String srvId;
	private String mmId;
	private String priPatId;

	@Override
	public PreAlertObject executeTask(BgWorkingContext context) throws BizException {

		BdSrvPriceTableUpdateLogUtils.info("开始执行医疗服务价格表更新后台任务,参数:%s。", JSON.toJSONString(context.getKeyMap()));

		try {
			initParams(context);

			IBdSrvPriceTableUpdateService updateService = ServiceFinder.find(IBdSrvPriceTableUpdateService.class);

			if (StringUtils.isNotBlank(srvId)) {
				updateService.updateSrvPriceTable(IBdSrvPriceTableUpdateService.SrvPriceUpdateCondType_Srv,
						new String[] { srvId });
			} else if (StringUtils.isNotBlank(mmId)) {
				updateService.updateSrvPriceTable(IBdSrvPriceTableUpdateService.SrvPriceUpdateCondType_Mm,
						new String[] { mmId });
			} else if (StringUtils.isNotBlank(priPatId)) {
				updateService.updateSrvPriceTable(IBdSrvPriceTableUpdateService.SrvPriceUpdateCondType_PriPat,
						new String[] { priPatId });
			} else {
				updateService.updateSrvPriceTable(IBdSrvPriceTableUpdateService.SrvPriceUpdateCondType_ReBuild, null);
			}
		} catch (Exception e) {
			BdSrvPriceTableUpdateLogUtils.logExAndTitle(e, "执行医疗服务价格表更新后台任务结束,参数:%s。",
					JSON.toJSONString(context.getKeyMap()));
		}

		BdSrvPriceTableUpdateLogUtils.info("执行医疗服务价格表更新后台任务结束,参数:%s。", JSON.toJSONString(context.getKeyMap()));

		return new PreAlertObject();
	}

	private void initParams(BgWorkingContext context) {
		Map<String, Object> paramMap = context.getKeyMap();
		if (paramMap == null) {
			return;
		}

		if (paramMap.containsKey(BdSrvPriceTableUpdateTaskCodeConst.PARAM_SRVID)) {
			this.srvId = (String) paramMap.get(BdSrvPriceTableUpdateTaskCodeConst.PARAM_SRVID);
		}

		if (paramMap.containsKey(BdSrvPriceTableUpdateTaskCodeConst.PARAM_MMID)) {
			this.mmId = (String) paramMap.get(BdSrvPriceTableUpdateTaskCodeConst.PARAM_MMID);
		}

		if (paramMap.containsKey(BdSrvPriceTableUpdateTaskCodeConst.PARAM_PRIPATID)) {
			this.priPatId = (String) paramMap.get(BdSrvPriceTableUpdateTaskCodeConst.PARAM_PRIPATID);
		}
	}
}
