package iih.ci.ord.s.ems.op.order.copy;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ci.ord.cior.d.CiorappbtAggDO;
import iih.ci.ord.cior.d.OrdApBtDO;
import iih.ci.ord.cior.d.OrdApBtViewItemDO;
import iih.ci.ord.cior.d.desc.OrdApBtDODesc;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;

public class OrderApbtCopyBP extends OrderBaseCopyBP {
	/**
	 * 复制备血申请单
	 * 
	 * @param id_ors
	 */
	@Override
	protected Boolean copyCiorderAppInfo(Map<String, String> mapIdors, FDateTime dt) throws BizException {
		if (CiOrdUtils.isEmpty(mapIdors))
			return false;
		CiorappbtAggDO[] apppathgyAggDOs = getCiorappbtAggDOs(mapIdors.keySet().toArray(new String[] {}));
		if (CiOrdUtils.isEmpty(apppathgyAggDOs))
			return false;
		setCiorappbtAggDOs(apppathgyAggDOs,mapIdors);
		return saveCiorappbtAggDOs(apppathgyAggDOs);
	}
	
	/**
	 * 查询CiorappbtAggDO
	 * 
	 * @param idors
	 * @return
	 * @throws BizException
	 */
	private CiorappbtAggDO[] getCiorappbtAggDOs(String[] idors) throws BizException {
		if (CiOrdUtils.isEmpty(idors))
			return null;
		String strIdors = "";
		for (String id_or : idors) {
			strIdors += ",'" + id_or + "'";
		}
		return CiOrdAppUtils.getOrappbtQryService().find(
				OrdApBtDODesc.TABLE_ALIAS_NAME + ".id_or in (" + strIdors.substring(1) + ")", "", FBoolean.FALSE);
	}

	/**
	 * 设置CiorappbtAggDO
	 * 
	 * @param appbtAggDOs
	 * @param mapIdors
	 * @throws BizException 
	 */
	private void setCiorappbtAggDOs(CiorappbtAggDO[] appbtAggDOs, Map<String, String> mapIdors) throws BizException {
		if (CiOrdUtils.isEmpty(appbtAggDOs))
			return;
		for (CiorappbtAggDO apppathgyAggDO : appbtAggDOs) {
			OrdApBtDO ordApBtDO = apppathgyAggDO.getParentDO();
			ordApBtDO.setId_apbt(null);
			ordApBtDO.setId_or(mapIdors.get(ordApBtDO.getId_or()));
			ordApBtDO.setNo_applyform(this.getApplyNo(ordApBtDO.getId_or()));
			ordApBtDO.setFg_rpt("N");
			ordApBtDO.setFg_prn(FBoolean.FALSE);
			ordApBtDO.setCnt_prn(0);
			ordApBtDO.setStatus(DOStatus.NEW);

			OrdApBtViewItemDO[] btViewItemDOs = apppathgyAggDO.getOrdApBtViewItemDO();
			if (CiOrdUtils.isEmpty(btViewItemDOs))
				continue;
			for (OrdApBtViewItemDO btViewItemDO : btViewItemDOs) {
				btViewItemDO.setId_apbtobsindex(null);
				btViewItemDO.setStatus(DOStatus.NEW);
			}
		}
	}

	/**
	 * 保存CiorappbtAggDO
	 * 
	 * @param appbtAggDOs
	 * @return
	 * @throws BizException
	 */
	private Boolean saveCiorappbtAggDOs(CiorappbtAggDO[] appbtAggDOs) throws BizException {
		if (CiOrdUtils.isEmpty(appbtAggDOs))
			return false;
		appbtAggDOs = CiOrdAppUtils.getOrappbtService().save(appbtAggDOs);
		return !CiOrdUtils.isEmpty(appbtAggDOs);
	}

	@Override
	protected String getApplyNo() throws BizException {
		return CiOrdUtils.getApplyNo(IBdSrvDictCodeConst.SD_SRVTP_BLOODPROD_PREPARE);
	}
	
}
