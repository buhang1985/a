package iih.ci.ord.s.bp.ciprn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mysql.jdbc.StringUtils;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ci.ord.app.d.CiAppBuSheetDO;
import iih.ci.ord.cior.d.CiOrSessionDO;
import iih.ci.ord.cior.d.OrdApBtDO;
import iih.ci.ord.cior.d.OrdAppBtUseDO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;

/**
 * 取血申请单打印数据保存
 * @author Young
 *
 */
public class CiprnSaveAppBuDataBP {

	public FBoolean exec(CiEnContextDTO ctx , CiOrderDO[] ciors, CiOrSessionDO session) 
			throws BizException {
		if (ciors == null || ciors.length <= 0 || !CiOrdUtils.isOpUrgentWf(ciors[0].getCode_entp()))
			return null;
		// 取血的医嘱集合
		List<CiOrderDO> lstCiOrderDOs = new ArrayList<CiOrderDO>();
		String strIdors = "";
		String strIdorsBt = "";
		for (CiOrderDO cior : ciors) {
			if (!StringUtils.isNullOrEmpty(cior.getSd_srvtp()) 
					&& cior.getSd_srvtp().equals(IBdSrvDictCodeConst.SD_SRVTP_BLOODPROD_USE)) {
				lstCiOrderDOs.add(cior);
				strIdors += ",'" + cior.getId_or() + "'";
				strIdorsBt += ",'" + cior.getId_or_rel() + "'";
			}
		}
		if (lstCiOrderDOs == null || lstCiOrderDOs.size() <= 0)
			return null;
		OrdAppBtUseDO[] ordAppBtUseDOs = CiprnUtils.GetOrdAppBtUseDOs(strIdors.substring(1));
		Map<String, OrdAppBtUseDO> mapBu = new HashMap<String, OrdAppBtUseDO>();
		for (OrdAppBtUseDO buDO : ordAppBtUseDOs) {
			mapBu.put(buDO.getId_or(), buDO);
		}
		OrdApBtDO[] ordApBtDOs = CiprnUtils.GetOrdApBtDOs(strIdorsBt.substring(1));
		Map<String, OrdApBtDO> mapBt = new HashMap<String, OrdApBtDO>();
		for (OrdApBtDO btDO : ordApBtDOs) {
			mapBt.put(btDO.getId_or(), btDO);
		}
		
		CiAppBuSheetDO[] ciAppBuSheetDOs = this.getCiAppBuSheetDOs(
				lstCiOrderDOs.toArray(new CiOrderDO[lstCiOrderDOs.size()]),mapBu, mapBt, session);
		CiprnUtils.SaveCiAppBuSheetDOs(ciAppBuSheetDOs);
		return FBoolean.TRUE;
	}
	
	/**
	 * 构造用血打印数据对象
	 * @param ciors
	 * @param map
	 * @param session
	 * @return
	 * @throws BizException
	 */
	private CiAppBuSheetDO[] getCiAppBuSheetDOs(CiOrderDO[] ciors, Map<String, OrdAppBtUseDO> mapBu, Map<String, OrdApBtDO> mapBt, CiOrSessionDO session) 
			throws BizException{
//		CiAppBuSheetDO buSheetDO = new CiAppBuSheetDO();;
//		buSheetDO.setId_en(ciors[0].getId_en());
//		String[] btNOs = CiOrdUtils.generateNormNOs(ciors.length, buSheetDO, 1, 21);
//		int i = 0;
		List<CiAppBuSheetDO> lstBuSheetDOs = new ArrayList<CiAppBuSheetDO>();
		for (CiOrderDO cior : ciors) {
			CiAppBuSheetDO ciAppBuSheetDO =new CiAppBuSheetDO();
			ciAppBuSheetDO.setId_org(cior.getId_org());
			ciAppBuSheetDO.setId_grp(cior.getId_grp());
			ciAppBuSheetDO.setId_pat(cior.getId_pat());
			ciAppBuSheetDO.setCode_entp(cior.getCode_entp());
			ciAppBuSheetDO.setId_en(cior.getId_en());
			ciAppBuSheetDO.setId_or(cior.getId_or());
			ciAppBuSheetDO.setId_srv(cior.getId_srv());
			ciAppBuSheetDO.setId_apbu(mapBu.get(cior.getId_or()).getId_apbu());
			ciAppBuSheetDO.setId_apbt(mapBt.get(cior.getId_or_rel()).getId_apbt());
			ciAppBuSheetDO.setCode_app_bt(mapBt.get(cior.getId_or_rel()).getNo_applyform());
			ciAppBuSheetDO.setCode_app_bu(mapBu.get(cior.getId_or()).getNo_applyform());
			ciAppBuSheetDO.setId_app_bloodtype(mapBt.get(cior.getId_or_rel()).getId_bloodtype_ap());
			ciAppBuSheetDO.setSd_app_bloodtype(mapBt.get(cior.getId_or_rel()).getSd_bloodtype_ap());
			ciAppBuSheetDO.setId_app_rhd(mapBt.get(cior.getId_or_rel()).getId_rhd_ap());
			ciAppBuSheetDO.setSd_app_rhd(mapBt.get(cior.getId_or_rel()).getSd_rhd_ap());
//			ciAppBuSheetDO.setQuan_medu_bu(cior.getQuan_medu());
//			ciAppBuSheetDO.setId_medu_unit(cior.getId_unit_med());
			ciAppBuSheetDO.setDt_pl_bu(mapBu.get(cior.getId_or()).getDt_bu_plan());
			ciAppBuSheetDO.setId_dep_mp(cior.getId_dep_mp());
			ciAppBuSheetDO.setId_emp_bu(cior.getId_emp_sign());
			ciAppBuSheetDO.setApplydoctortel(mapBu.get(cior.getId_or()).getApplydoctortel());
			ciAppBuSheetDO.setDes_or(cior.getDes_or());
			ciAppBuSheetDO.setFg_prn(FBoolean.FALSE);
			ciAppBuSheetDO.setCnt_prn(0);
			ciAppBuSheetDO.setStatus(DOStatus.NEW);
			
			lstBuSheetDOs.add(ciAppBuSheetDO);
//			i++;
		}
		return lstBuSheetDOs.toArray(new CiAppBuSheetDO[lstBuSheetDOs.size()]);
	}
}
