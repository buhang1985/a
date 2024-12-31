package iih.ci.ord.s.bp.ciprn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mysql.jdbc.StringUtils;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ci.ord.app.d.CiAppBtItemSheetDO;
import iih.ci.ord.app.d.CiAppBtSheetDO;
import iih.ci.ord.app.d.CiappbtsheetAggDO;
import iih.ci.ord.cior.d.CiOrSessionDO;
import iih.ci.ord.cior.d.CiorappbtAggDO;
import iih.ci.ord.cior.d.OrdApBtViewItemDO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;

/**
 * 备血申请单打印数据保存
 * @author Young
 *
 */
public class CiprnSaveAppBtDataBP {

	public FBoolean exec(CiEnContextDTO ctx, CiOrderDO[] ciors, CiOrSessionDO session) 
			throws BizException {
		if (ciors == null || ciors.length <= 0 )
			return null;
		// 备血的医嘱集合
		List<CiOrderDO> lstCiOrderDOs = new ArrayList<CiOrderDO>();
		Map<String,String> mapIdsrvs = new HashMap<String,String>();
		String strIdors = "";
		for (CiOrderDO cior : ciors) {
			if (!StringUtils.isNullOrEmpty(cior.getSd_srvtp()) 
					&& cior.getSd_srvtp().equals(IBdSrvDictCodeConst.SD_SRVTP_BLOODPROD_PREPARE)) {
				lstCiOrderDOs.add(cior);
				strIdors += ",'" + cior.getId_or() + "'";
				mapIdsrvs.put(cior.getId_or(), cior.getId_srv());
			}
		}
		if (lstCiOrderDOs == null || lstCiOrderDOs.size() <= 0)
			return null;
		
		OrdSrvDO[] ordSrvDOs = CiprnUtils.GetOrdSrvDOByIdor(strIdors.substring(1));
		Map<String, OrdSrvDO> mapOrdSrvDOs = new HashMap<String, OrdSrvDO>();
		for (OrdSrvDO srv : ordSrvDOs) {
			if (mapIdsrvs.get(srv.getId_or()).equals(srv.getId_srv())) {
				mapOrdSrvDOs.put(srv.getId_or(), srv);
			}
		}
		
		CiorappbtAggDO[] appbtAggDOs = CiprnUtils.GetCiorappbtAggDOs(strIdors.substring(1));
		Map<String, CiorappbtAggDO> map = new HashMap<String, CiorappbtAggDO>();
		for (CiorappbtAggDO aggDO : appbtAggDOs) {
			map.put(aggDO.getParentDO().getId_or(), aggDO);
		}
		CiappbtsheetAggDO[] aggDOs = this.getCiappbtsheetAggDOs(lstCiOrderDOs.toArray(new CiOrderDO[lstCiOrderDOs.size()]), map, mapOrdSrvDOs, session);
		CiprnUtils.SaveCiappbtsheetAggDOs(aggDOs);
		return FBoolean.TRUE;
	}
	
	/**
	 * 构造备血打印数据对象
	 * @param ciors
	 * @param map
	 * @param session
	 * @return
	 * @throws BizException
	 */
	private CiappbtsheetAggDO[] getCiappbtsheetAggDOs(CiOrderDO[] ciors, Map<String, CiorappbtAggDO> map, Map<String, OrdSrvDO> mapOrdSrvDOs, CiOrSessionDO session) 
			throws BizException{
//		CiAppBtSheetDO btSheetDO = new CiAppBtSheetDO();;
//		btSheetDO.setId_en(ciors[0].getId_en());
//		String[] btNOs = CiOrdUtils.generateNormNOs(ciors.length, btSheetDO, 1, 21);
//		int i = 0;
		List<CiappbtsheetAggDO> lstAggDOs = new ArrayList<CiappbtsheetAggDO>();
		for (CiOrderDO cior : ciors) {
			CiAppBtSheetDO ciAppBtSheetDO =new CiAppBtSheetDO();
			ciAppBtSheetDO.setId_org(cior.getId_org());
			ciAppBtSheetDO.setId_grp(cior.getId_grp());
			ciAppBtSheetDO.setId_pat(cior.getId_pat());
			ciAppBtSheetDO.setCode_entp(cior.getCode_entp());
			ciAppBtSheetDO.setId_en(cior.getId_en());
			ciAppBtSheetDO.setStr_name_di(map.get(cior.getId_or()).getParentDO().getStr_name_di());
			ciAppBtSheetDO.setId_or(cior.getId_or());
			ciAppBtSheetDO.setId_srv(cior.getId_srv());
			ciAppBtSheetDO.setId_apbt(map.get(cior.getId_or()).getParentDO().getId_apbt());
			ciAppBtSheetDO.setCode_app_bt(map.get(cior.getId_or()).getParentDO().getNo_applyform());
			ciAppBtSheetDO.setId_app_bloodtype(map.get(cior.getId_or()).getParentDO().getId_bloodtype_ap());
			ciAppBtSheetDO.setSd_app_bloodtype(map.get(cior.getId_or()).getParentDO().getSd_bloodtype_ap());
			ciAppBtSheetDO.setId_app_rhd(map.get(cior.getId_or()).getParentDO().getId_rhd_ap());
			ciAppBtSheetDO.setSd_app_rhd(map.get(cior.getId_or()).getParentDO().getSd_rhd_ap());
			ciAppBtSheetDO.setId_his_bt(map.get(cior.getId_or()).getParentDO().getId_his_bt());
			ciAppBtSheetDO.setSd_his_bt(map.get(cior.getId_or()).getParentDO().getSd_his_bt());
			ciAppBtSheetDO.setQuan_medu_bt(mapOrdSrvDOs.get(cior.getId_or()).getQuan_medu());
			ciAppBtSheetDO.setId_medu_unit(mapOrdSrvDOs.get(cior.getId_or()).getId_medu());
			ciAppBtSheetDO.setPregnant_num(map.get(cior.getId_or()).getParentDO().getPregnant_num());
			ciAppBtSheetDO.setParturition_cnt(map.get(cior.getId_or()).getParentDO().getParturition_cnt());
			ciAppBtSheetDO.setId_pps_bt(map.get(cior.getId_or()).getParentDO().getId_pps_bt());
			ciAppBtSheetDO.setSd_pps_bt(map.get(cior.getId_or()).getParentDO().getSd_pps_bt());
			ciAppBtSheetDO.setDes_pps_bt(map.get(cior.getId_or()).getParentDO().getDes_pps_bt());
			ciAppBtSheetDO.setId_mode_bt(map.get(cior.getId_or()).getParentDO().getId_mode_bt());
			ciAppBtSheetDO.setSd_mode_bt(map.get(cior.getId_or()).getParentDO().getSd_mode_bt());
			ciAppBtSheetDO.setDes_or(cior.getDes_or());
			ciAppBtSheetDO.setDt_pl_bt(new FDateTime(map.get(cior.getId_or()).getParentDO().getDt_bt_pl()));
			ciAppBtSheetDO.setStr_rpt(map.get(cior.getId_or()).getParentDO().getFg_rpt());
			ciAppBtSheetDO.setId_emp_bt(cior.getId_emp_or());
//			ciAppBtSheetDO.setId_emp_chief(Id_emp_chief);
			ciAppBtSheetDO.setId_dep_mp(cior.getId_dep_mp());
			ciAppBtSheetDO.setDt_app_bt(cior.getDt_sign().toString());
			ciAppBtSheetDO.setFg_prn(FBoolean.FALSE);
			ciAppBtSheetDO.setCnt_prn(0);
			ciAppBtSheetDO.setStatus(DOStatus.NEW);
			
			CiappbtsheetAggDO aggDO=new CiappbtsheetAggDO();
			aggDO.setParentDO(ciAppBtSheetDO);
			
			OrdApBtViewItemDO[] ordApBtViewItemDOs = map.get(cior.getId_or()).getOrdApBtViewItemDO();
			if (ordApBtViewItemDOs != null && ordApBtViewItemDOs.length > 0) {
				List<CiAppBtItemSheetDO> lstItemDOs = new ArrayList<CiAppBtItemSheetDO>();
				for (OrdApBtViewItemDO itemDO : ordApBtViewItemDOs) {
					CiAppBtItemSheetDO itemSheetDO = new CiAppBtItemSheetDO();
					itemSheetDO.setId_apbtobsindex(itemDO.getId_apbtobsindex());
					itemSheetDO.setId_srv(itemDO.getId_srv());
					itemSheetDO.setCode_srv(itemDO.getCode_srv());
					itemSheetDO.setName_srv(itemDO.getName_srv());
					itemSheetDO.setVal_rstrptla(itemDO.getVal_rstrptla());
					itemSheetDO.setId_unit(itemDO.getId_unit());
					itemSheetDO.setName_unit(itemDO.getName_unit());
					itemSheetDO.setVal_restrptlab(itemDO.getVal_restrptlab());
					itemSheetDO.setId_restrptlabtp(itemDO.getId_restrptlabtp());
					itemSheetDO.setSd_restrptlabtp(itemDO.getSd_restrptlabtp());
					itemSheetDO.setReporttime(itemDO.getReporttime());
					itemSheetDO.setBarcode(itemDO.getBarcode());
					itemSheetDO.setFg_allowempty(itemDO.getFg_allowempty());
					itemSheetDO.setSortno(itemDO.getSortno());
					itemSheetDO.setStatus(DOStatus.NEW);
					lstItemDOs.add(itemSheetDO);
				}
				aggDO.setCiAppBtItemSheetDO(lstItemDOs.toArray(new CiAppBtItemSheetDO[lstItemDOs.size()]));
			}

			lstAggDOs.add(aggDO);
//			i++;
		}

		return lstAggDOs.toArray(new CiappbtsheetAggDO[lstAggDOs.size()]);
	}
}
