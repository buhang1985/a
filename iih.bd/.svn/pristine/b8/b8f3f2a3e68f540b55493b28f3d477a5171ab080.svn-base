package iih.bd.srv.medsrv.s.rule.updatesrvpricetable;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.srvpricetable.i.IBdSrvPriceTableUpdateService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.bizrule.ICompareRule;

/**
 * 
 * 
 * @author hao_wu
 * @date 2020年4月28日
 *
 */
public class UpdateSrvPriceTableAfterUpdateRule implements ICompareRule<MedSrvDO> {

	@Override
	public void process(MedSrvDO[] oldDatas, MedSrvDO[] newDatas) throws BizException {
		if (ArrayUtils.isEmpty(newDatas)) {
			return;
		}

		List<String> srvIdList = new ArrayList<>();
		for (int i = 0; i < newDatas.length; i++) {
			MedSrvDO newMedSrvDo = newDatas[i];
			MedSrvDO oldMedSrvDo = oldDatas[i];
			boolean needUpdate = isNeedUpdate(newMedSrvDo, oldMedSrvDo);
			String srvId = newMedSrvDo.getId_srv();
			if (needUpdate && StringUtils.isNotBlank(srvId)) {
				srvIdList.add(srvId);
			}
		}

		if (srvIdList.size() > 0) {
			IBdSrvPriceTableUpdateService service = ServiceFinder.find(IBdSrvPriceTableUpdateService.class);
			service.updateSrvPriceTable(IBdSrvPriceTableUpdateService.SrvPriceUpdateCondType_Srv,
					srvIdList.toArray(new String[0]));
		}
	}

	private boolean isNeedUpdate(MedSrvDO newMedSrvDo, MedSrvDO oldMedSrvDo) {
		if (isNotEquals(newMedSrvDo.getFg_bl(), oldMedSrvDo.getFg_bl())) {
			return true;
		}
		if (isNotEquals(newMedSrvDo.getFg_mm(), oldMedSrvDo.getFg_mm())) {
			return true;
		}
		if (isNotEquals(newMedSrvDo.getSd_primd(), oldMedSrvDo.getSd_primd())) {
			return true;
		}
		if (isNotEquals(newMedSrvDo.getSetitmchknum(), oldMedSrvDo.getSetitmchknum())) {
			return true;
		}
		return false;
	}

	private boolean isNotEquals(Object value1, Object value2) {
		if (value1 == null && value2 == null) {
			return false;
		}
		if (value1 != null) {
			return !value1.equals(value2);
		}

		if (value2 != null) {
			return !value2.equals(value1);
		}

		return false;
	}
}
