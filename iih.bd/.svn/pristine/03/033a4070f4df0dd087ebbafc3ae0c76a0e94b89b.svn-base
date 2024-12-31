package iih.bd.srv.medsrv.s.rule.updatesrvpricetable;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvSetItemDO;
import iih.bd.srv.medsrv.d.MedsrvAggDO;
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
public class UpdateSrvPriceTableByAggAfterUpdateRule implements ICompareRule<MedsrvAggDO> {

	@Override
	public void process(MedsrvAggDO[] oldDatas, MedsrvAggDO[] newDatas) throws BizException {
		if (ArrayUtils.isEmpty(newDatas)) {
			return;
		}

		List<String> srvIdList = new ArrayList<>();
		for (int i = 0; i < newDatas.length; i++) {
			MedsrvAggDO newMedSrvAggDo = newDatas[i];
			MedsrvAggDO oldMedSrvAggDo = oldDatas[i];
			boolean needUpdate = isNeedUpdate(newMedSrvAggDo, oldMedSrvAggDo);
			String srvId = newMedSrvAggDo.getParentDO().getId_srv();
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

	private boolean isNeedUpdate(MedsrvAggDO newMedSrvAggDo, MedsrvAggDO oldMedSrvAggDo) {
		MedSrvDO newMedSrvDo = newMedSrvAggDo.getParentDO();
		MedSrvDO oldMedSrvDo = oldMedSrvAggDo.getParentDO();
		if (isNeedUpdate(newMedSrvDo, oldMedSrvDo)) {
			return true;
		}

		MedSrvSetItemDO[] newSetItemDos = newMedSrvAggDo.getMedSrvSetItemDO();
		MedSrvSetItemDO[] oldSetItemDos = oldMedSrvAggDo.getMedSrvSetItemDO();
		if (newSetItemDos == null && oldSetItemDos == null)
		{
			return false;
		}
		if ((newSetItemDos == null && oldSetItemDos != null) || (newSetItemDos != null && oldSetItemDos == null) || newSetItemDos.length != oldSetItemDos.length) {
			return true;
		}

		for (int i = 0; i < newSetItemDos.length; i++) {
			MedSrvSetItemDO newSetItemDo = newSetItemDos[i];
			MedSrvSetItemDO oldSetItemDo = oldSetItemDos[i];
			if (isNeedUpdate(newSetItemDo, oldSetItemDo)) {
				return true;
			}
		}
		return false;
	}

	private boolean isNeedUpdate(MedSrvSetItemDO newSetItemDo, MedSrvSetItemDO oldSetItemDo) {
		if (isNotEquals(newSetItemDo.getId_srv_itm(), oldSetItemDo.getId_srv_itm())) {
			return true;
		}
		if (isNotEquals(newSetItemDo.getQuan_medu(), oldSetItemDo.getQuan_medu())) {
			return true;
		}
		if (isNotEquals(newSetItemDo.getFg_clinical(), oldSetItemDo.getFg_clinical())) {
			return true;
		}
		if (isNotEquals(newSetItemDo.getFg_edit(), oldSetItemDo.getFg_edit())) {
			return true;
		}
		if (isNotEquals(newSetItemDo.getDs(), oldSetItemDo.getDs())) {
			return true;
		}
		return false;
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
