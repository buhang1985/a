package iih.ci.ord.s.ems.op.orderv1.bp.copy;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ci.ord.cior.d.OrdAppBtUseDO;
import iih.ci.ord.cior.d.desc.OrdAppBtUseDODesc;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;

import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;

/**
 * 复制用血
 * @author Young
 *
 */
public class OrderApbuCopyBP extends OrderBaseCopyBP {

	/**
	 * 复制用血申请单
	 * 
	 * @param id_ors
	 */
	@Override
	protected Boolean copyCiorderAppInfo(Map<String, String> mapIdors, FDateTime dt) throws BizException {
		if (CiOrdUtils.isEmpty(mapIdors))
			return false;
		OrdAppBtUseDO[] ordAppBtUseDOs = getOrdAppBtUseDOs(mapIdors.keySet().toArray(new String[] {}));
		if (CiOrdUtils.isEmpty(ordAppBtUseDOs))
			return false;
		setOrdAppBtUseDOs(ordAppBtUseDOs, mapIdors);
		return saveOrdAppBtUseDOs(ordAppBtUseDOs);
	}
	
	/**
	 * 查询OrdAppBtUseDO
	 * @param idors
	 * @return
	 * @throws BizException
	 */
	private OrdAppBtUseDO[] getOrdAppBtUseDOs(String[] idors) throws BizException {
		if (CiOrdUtils.isEmpty(idors))
			return null;
		String strIdors = "";
		for (String id_or : idors) {
			strIdors += ",'" + id_or + "'";
		}
		return CiOrdAppUtils.getOrappbuQryService().find(
				OrdAppBtUseDODesc.TABLE_ALIAS_NAME + ".id_or in (" + strIdors.substring(1) + ")", "", FBoolean.FALSE);
	}
	
	/**
	 * 设置OrdAppBtUseDO
	 * @param ordAppBtUseDOs
	 * @param mapIdors
	 * @throws BizException
	 */
	private void setOrdAppBtUseDOs(OrdAppBtUseDO[] ordAppBtUseDOs, Map<String, String> mapIdors) throws BizException {
		if (CiOrdUtils.isEmpty(ordAppBtUseDOs))
			return;
		for (OrdAppBtUseDO ordAppBtUseDO : ordAppBtUseDOs) {
			ordAppBtUseDO.setId_apbu(null);
			ordAppBtUseDO.setId_or(mapIdors.get(ordAppBtUseDO.getId_or()));
			ordAppBtUseDO.setNo_applyform(CiOrdUtils.getApplyNo(IBdSrvDictCodeConst.SD_SRVTP_BLOODPROD_USE));
			ordAppBtUseDO.setFg_prn(FBoolean.FALSE);
			ordAppBtUseDO.setCnt_prn(0);
			ordAppBtUseDO.setStatus(DOStatus.NEW);
		}
	}
	
	/**
	 * 保存OrdAppBtUseDO
	 * @param ordAppBtUseDOs
	 * @return
	 * @throws BizException
	 */
	private Boolean saveOrdAppBtUseDOs(OrdAppBtUseDO[] ordAppBtUseDOs) throws BizException {
		if (CiOrdUtils.isEmpty(ordAppBtUseDOs))
			return false;
		ordAppBtUseDOs = CiOrdAppUtils.getOrappbuService().save(ordAppBtUseDOs);
		return !CiOrdUtils.isEmpty(ordAppBtUseDOs);
	}
}
