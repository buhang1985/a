package iih.bd.srv.medsrv.s.rule.updatesrvpricetable;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedsrvAggDO;
import iih.bd.srv.srvpricetable.i.IBdSrvPriceTableUpdateService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.bizrule.IRule;

/**
 * 
 * 
 * @author hao_wu
 * @date 2020年4月28日
 *
 */
public class UpdateSrvPriceTableByAggRule implements IRule<MedsrvAggDO> {

	@Override
	public void process(MedsrvAggDO... medsrvAggDOs) throws BizException {
		if (ArrayUtils.isEmpty(medsrvAggDOs)) {
			return;
		}
		String[] srvIds = getSrvIds(medsrvAggDOs);
		if (ArrayUtils.isNotEmpty(srvIds)) {
			IBdSrvPriceTableUpdateService service = ServiceFinder.find(IBdSrvPriceTableUpdateService.class);
			service.updateSrvPriceTable(IBdSrvPriceTableUpdateService.SrvPriceUpdateCondType_Srv, srvIds);
		}
	}

	private String[] getSrvIds(MedsrvAggDO[] medsrvAggDOs) {
		List<String> srvIdList = new ArrayList<>();
		for (MedsrvAggDO aggDO : medsrvAggDOs) {
			MedSrvDO medSrvDO = aggDO.getParentDO();
			if (StringUtils.isNotBlank(medSrvDO.getId_srv())) {
				srvIdList.add(medSrvDO.getId_srv());
			}
		}
		return srvIdList.toArray(new String[0]);
	}
}
