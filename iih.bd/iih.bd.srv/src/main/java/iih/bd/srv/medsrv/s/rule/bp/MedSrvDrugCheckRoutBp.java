package iih.bd.srv.medsrv.s.rule.bp;

import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvDrugDO;
import iih.bd.srv.medsrv.i.IMedSrvDrugDORService;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.bd.srv.routedosage.d.RouteDosageRefDO;
import iih.bd.srv.routedosage.i.IRoutedosageRService;
import iih.bd.utils.BdSrvParamUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 检查用法是否符合剂型业务逻辑
 * 
 * @author hao_wu
 *
 */
public class MedSrvDrugCheckRoutBp {

	public void exec(MedSrvDrugDO[] medsrvDrugDos, MedSrvDO medsrvDo) throws BizException {
		if (false == BdSrvParamUtils.getCheckRouteFlag()) {
			return;
		}
		if (medsrvDrugDos == null) {
			medsrvDrugDos = tryGetMedSrvDrug(medsrvDo);
			if (medsrvDrugDos == null) {
				return;
			}
		}
		for (MedSrvDrugDO medSrvDrugDO : medsrvDrugDos) {
			checkRout(medSrvDrugDO, medsrvDo);
		}
	}

	/**
	 * 获取药品属性信息
	 * 
	 * @param medSrvDO
	 * @return
	 * @throws BizException
	 */
	private MedSrvDrugDO[] tryGetMedSrvDrug(MedSrvDO medSrvDO) throws BizException {
		if (medSrvDO == null || StringUtil.isEmptyWithTrim(medSrvDO.getId_srv())) {
			return null;
		}
		IMedSrvDrugDORService medSrvDrugDORService = ServiceFinder.find(IMedSrvDrugDORService.class);
		return medSrvDrugDORService.findByAttrValString(MedSrvDrugDO.ID_SRV, medSrvDO.getId_srv());
	}

	/**
	 * 检查用法是否符合剂型
	 * 
	 * @param medSrvDrugDO
	 * @param medsrvDo
	 * @throws BizException
	 */
	private void checkRout(MedSrvDrugDO medSrvDrugDO, MedSrvDO medsrvDo) throws BizException {
		if (medsrvDo == null) {
			medsrvDo = getMedSrvDo(medSrvDrugDO);
		}
		if (medSrvDrugDO == null || medsrvDo == null) {
			return;
		}
		String idDosage = medSrvDrugDO.getId_dosage();
		String idRoute = medsrvDo.getId_route();
		if (StringUtil.isEmptyWithTrim(idDosage) || StringUtil.isEmptyWithTrim(idRoute)) {
			return;
		}
		RouteDosageRefDO[] result = getRouteDosageRef(idDosage, idRoute);
		if (result == null || result.length <= 0) {
			String msg = String.format("医疗服务\"%s\"中\"%s\"剂型下不可维护\"%s\"用法。", medsrvDo.getName(),
					medSrvDrugDO.getDs_name(), medsrvDo.getRoute_name());
			throw new BizException(msg);
		}
	}

	/**
	 * 获取剂型与用法关系
	 * 
	 * @param idDosage 剂型id
	 * @param idRoute  用法id
	 * @return
	 * @throws BizException
	 */
	private RouteDosageRefDO[] getRouteDosageRef(String idDosage, String idRoute) throws BizException {
		IRoutedosageRService routedosageRService = ServiceFinder.find(IRoutedosageRService.class);
		String whereStr = String.format("id_dosage = '%s' and id_route = '%s'", idDosage, idRoute);
		RouteDosageRefDO[] result = routedosageRService.find(whereStr, "", new FBoolean(false));
		return result;
	}

	/**
	 * 根据剂型获取服务信息
	 * 
	 * @param medSrvDrugDO
	 * @return
	 * @throws BizException
	 */
	private MedSrvDO getMedSrvDo(MedSrvDrugDO medSrvDrugDO) throws BizException {
		String srvId = medSrvDrugDO.getId_srv();
		IMedsrvMDORService medsrvMDORService = ServiceFinder.find(IMedsrvMDORService.class);
		MedSrvDO medSrvDO = medsrvMDORService.findById(srvId);
		return medSrvDO;
	}

}
