package iih.ci.ord.s.ems.ip.order.copy;

import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.xbd.udi.d.UdidocDO;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ci.ord.cior.d.CiorapppathgyAggDO;
import iih.ci.ord.cior.d.OrdApLabDO;
import iih.ci.ord.cior.d.OrdApObsDO;
import iih.ci.ord.cior.d.OrdApPathgyDO;
import iih.ci.ord.cior.d.OrdApPathgySampDO;
import iih.ci.ord.cior.d.desc.OrdApPathgyDODesc;
import iih.ci.ord.cior.i.ICiorapplisRService;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.i.ICiorderMDORService;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.orcontent.meta.RisOrContentParam;
import iih.ci.ord.s.ems.utils.CiOrContentUtils;
import iih.ci.ord.s.ems.utils.meta.LisOrContentParam;
import iih.ci.ord.s.external.thirdws.utils.UdidocUtils;

/**
 * 复制病理
 * @author Young
 *
 */
public class OrderPathgyCopyBP extends iih.ci.ord.s.ems.op.order.copy.OrderPathgyCopyBP {
	
	/**
	 * 复制病理申请单
	 * 
	 * @param id_ors
	 */
	@Override
	protected Boolean copyCiorderAppInfo(Map<String, String> mapIdors, FDateTime dt) throws BizException {
		if (CiOrdUtils.isEmpty(mapIdors))
			return false;
		CiorapppathgyAggDO[] apppathgyAggDOs = getCiorapppathgyAggDOs(mapIdors.keySet().toArray(new String[] {}));
		if (CiOrdUtils.isEmpty(apppathgyAggDOs))
			return false;
		setCiorapppathgyAggDOs(apppathgyAggDOs,mapIdors);
		return saveCiorapppathgyAggDOs(apppathgyAggDOs);
	}

	/**
	 * 查询CiorapppathgyAggDO
	 * 
	 * @param idors
	 * @return
	 * @throws BizException
	 */
	private CiorapppathgyAggDO[] getCiorapppathgyAggDOs(String[] idors) throws BizException {
		if (CiOrdUtils.isEmpty(idors))
			return null;
		String strIdors = "";
		for (String id_or : idors) {
			strIdors += ",'" + id_or + "'";
		}
		return CiOrdAppUtils.getOrapppathgyQryService().find(
				OrdApPathgyDODesc.TABLE_ALIAS_NAME + ".id_or in (" + strIdors.substring(1) + ")", "", FBoolean.FALSE);
	}

	/**
	 * 设置CiorapppathgyAggDO
	 * 
	 * @param apppathgyAggDOs
	 * @param mapIdors
	 * @throws BizException 
	 */
	private void setCiorapppathgyAggDOs(CiorapppathgyAggDO[] apppathgyAggDOs, Map<String, String> mapIdors) throws BizException {
		if (CiOrdUtils.isEmpty(apppathgyAggDOs))
			return;
		for (CiorapppathgyAggDO apppathgyAggDO : apppathgyAggDOs) {
			OrdApPathgyDO ordApPathgyDO = apppathgyAggDO.getParentDO();
			ordApPathgyDO.setId_appathgy(null);
			ordApPathgyDO.setId_or(mapIdors.get(ordApPathgyDO.getId_or()));
			ordApPathgyDO.setNo_applyform(CiOrdUtils.getApplyNo(IBdSrvDictCodeConst.SD_SRVTP_RIS_BINGLI));
			ordApPathgyDO.setStatus(DOStatus.NEW);

			OrdApPathgySampDO[] pathgySampDOs = apppathgyAggDO.getOrdApPathgySampDO();
			if (CiOrdUtils.isEmpty(pathgySampDOs))
				continue;
			for (OrdApPathgySampDO pathgySampDO : pathgySampDOs) {
				pathgySampDO.setId_appathgysamp(null);
				pathgySampDO.setStatus(DOStatus.NEW);
			}
			if(this.getTeampAggs()!=null && this.getTeampAggs().containsKey(ordApPathgyDO.getId_or())){
				ordApPathgyDO.setFg_urgent(this.getTeampAggs().get(ordApPathgyDO.getId_or()).getParentDO().getFg_urgent());
			}
		}
	}

	/**
	 * 保存CiorapppathgyAggDO
	 * 
	 * @param apppathgyAggDOs
	 * @return
	 * @throws BizException
	 */
	private Boolean saveCiorapppathgyAggDOs(CiorapppathgyAggDO[] apppathgyAggDOs) throws BizException {
		if (CiOrdUtils.isEmpty(apppathgyAggDOs))
			return false;
		apppathgyAggDOs = CiOrdAppUtils.getOrapppathgyService().save(apppathgyAggDOs);
		return !CiOrdUtils.isEmpty(apppathgyAggDOs);
	}
}
