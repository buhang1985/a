package iih.bd.srv.medsrv.s.rule.updatesrvpricetable;

import org.apache.commons.lang.ArrayUtils;

import iih.bd.base.utils.DoUtils;
import iih.bd.srv.medsrv.d.MedSrvDO;
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
public class UpdateSrvPriceTableRule implements IRule<MedSrvDO> {

	@Override
	public void process(MedSrvDO... medSrvDOs) throws BizException {
		if (ArrayUtils.isEmpty(medSrvDOs)) {
			return;
		}
		String[] srvIds = DoUtils.getAttrValArrNotNull(medSrvDOs, MedSrvDO.ID_SRV, String.class);
		if (ArrayUtils.isNotEmpty(srvIds)) {
			IBdSrvPriceTableUpdateService service = ServiceFinder.find(IBdSrvPriceTableUpdateService.class);
			service.updateSrvPriceTable(IBdSrvPriceTableUpdateService.SrvPriceUpdateCondType_Srv, srvIds);
		}
	}
}
