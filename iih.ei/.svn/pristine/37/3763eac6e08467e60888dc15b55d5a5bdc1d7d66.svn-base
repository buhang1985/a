package iih.ei.std.s.v1.bp.pe.pacsdata;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.cior.d.OrdApLabDO;
import iih.ci.ord.cior.d.OrdApObsDO;
import iih.ci.ord.cior.i.ICiorapprisCudService;
import iih.ci.ord.cior.i.ICiorapprisRService;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.i.ICiorderMDOCudService;
import iih.ci.ord.ciorder.i.ICiorderMDORService;
import iih.ci.ord.cirptobs.d.CiRptObsDO;
import iih.ci.ord.cirptobs.i.ICirptobsCudService;
import iih.ci.ord.cirptobs.i.ICirptobsRService;
import iih.ei.std.d.v1.mp.pacedata.d.RptObsItemDTO;
import iih.ei.std.s.v1.bp.mp.common.MpnrUtils;
import iih.ei.std.s.v1.bp.pe.pacsdata.qry.GetPeObsApOrInfoSql;
import iih.pe.papt.dto.peitfchargedto.d.PeItfChargeDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.bdfw.bbd.i.IPsndocMDORService;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.orgfw.dept.i.IDeptRService;

public class SavePeReportDataBp {
	private List<String> depcodeList = new ArrayList<>();
	private List<String> psncodeList = new ArrayList<>();

	public void exec(RptObsItemDTO[] params) throws BizException {
		// 1.获取申请单号
		FArrayList applynoList = getApplynos(params);

		// 2.处理重复请求，如果有申请单号对应的报告，先删除处理
		deleteHisData(applynoList);

		// 3.查询申请单号对应的医嘱信息
		Map<String, CiOrderDO> orderMap = getOrderMap(applynoList);

		// 4.查询申请单号对应的申请单信息
		Map<String, OrdApObsDO> apLabMap = null; //getApLabMap(applynoList);

		// 5.实例化人员部门信息
		DeptDO[] deptDOs = ServiceFinder.find(IDeptRService.class).findByAttrValStrings(DeptDO.CODE, depcodeList.toArray(new String[0]));
		Map<String, DeptDO> depMap = MpnrUtils.mapBaseDO(deptDOs, DeptDO.CODE);
		PsnDocDO[] psnDocDOs = ServiceFinder.find(IPsndocMDORService.class).findByAttrValStrings(PsnDocDO.CODE, psncodeList.toArray(new String[0]));
		Map<String, PsnDocDO> psnMap = MpnrUtils.mapBaseDO(psnDocDOs, PsnDocDO.CODE);

		// 6.通过申请单查询医嘱以及申请单信息，实例化检验报告主表数据
		List<CiRptObsDO> obsDOs = initMDO(params, orderMap, apLabMap, psnMap, depMap);

		// 7.保存数据
		//saveData(obsDOs, orderMap.values(), apLabMap.values());
		saveData(obsDOs, null, null);
	}

	/**
	 * 获取申请单号
	 * 
	 * @param params
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private FArrayList getApplynos(RptObsItemDTO[] params) throws BizException {
		FArrayList applynoList = new FArrayList();
		for (RptObsItemDTO rptObsItemDTO : params) {
			if (!depcodeList.contains(rptObsItemDTO.getCode_dep()) && null != rptObsItemDTO.getCode_dep()) {
				depcodeList.add(rptObsItemDTO.getCode_dep());
			}
			if (!psncodeList.contains(rptObsItemDTO.getCode_emp()) && null != rptObsItemDTO.getCode_emp()) {
				psncodeList.add(rptObsItemDTO.getCode_emp());
			}
			if (!applynoList.contains(rptObsItemDTO.getNo_applyform())) {
				applynoList.add(rptObsItemDTO.getNo_applyform());
			}
		}
		return applynoList;
	}

	/**
	 * 处理重复请求，如果有申请单号对应的报告，先删除处理
	 * 
	 * @param applynoList
	 * @throws BizException
	 */
	private void deleteHisData(FArrayList applynoList) throws BizException {

		CiRptObsDO[] obsDOs = ServiceFinder.find(ICirptobsRService.class).findByAttrValList(CiRptObsDO.NO_APPLYFORM, applynoList);
		if (obsDOs != null && obsDOs.length > 0) {
			ServiceFinder.find(ICirptobsCudService.class).delete(obsDOs);
		}
	}

	/**
	 * 查询申请单号对应的医嘱信息
	 * 
	 * @param applynoList
	 * @return
	 * @throws BizException
	 */
	private Map<String, CiOrderDO> getOrderMap(FArrayList applynoList) throws BizException {

		Map<String, CiOrderDO> map = new HashMap<String, CiOrderDO>();
		CiOrderDO[] ciOrderDOs = new CiOrderDO[applynoList.size()];
		for(int i = 0; i < applynoList.size(); i++) {
            String no_apply = applynoList.get(i).toString();
    		GetPeObsApOrInfoSql qry = new GetPeObsApOrInfoSql(no_apply);
    		CiOrderDO[] ords = (CiOrderDO[]) AppFwUtil.getDORstWithDao(qry, CiOrderDO.class);
    		if(ords.length > 0) {
        		ciOrderDOs[i] = ords[0];
    		}
        }
		if (ciOrderDOs == null || ciOrderDOs.length < 1) {
			throw new BizException("报告回传：无申请单号对应的医嘱！");
		}

		if (ciOrderDOs.length != applynoList.size()) {
			throw new BizException("报告回传：申请单数量与医嘱数量不一致！");
		}

		for (CiOrderDO ciOrderDO : ciOrderDOs) {
			ciOrderDO.setStatus(DOStatus.UPDATED);
			ciOrderDO.setId_orrsttp(ICiDictCodeConst.ID_CI_RPT_LAB_FBBG);
			ciOrderDO.setSd_orrsttp(ICiDictCodeConst.SD_CI_RPT_LAB_FBBG);
			map.put(ciOrderDO.getApplyno(), ciOrderDO);
		}
		return map;
	}

	/**
	 * 
	 * @param applynoList
	 * @return
	 * @throws BizException
	 */
	private Map<String, OrdApObsDO> getApLabMap(FArrayList applynoList) throws BizException {

		Map<String, OrdApObsDO> map = new HashMap<String, OrdApObsDO>();
		OrdApObsDO[] apobsDOs = ServiceFinder.find(ICiorapprisRService.class).findByAttrValList(OrdApLabDO.NO_APPLYFORM, applynoList);
		if (apobsDOs == null || apobsDOs.length < 1) {
			throw new BizException("报告回传：申请单不存在！");
		}

		for (OrdApObsDO apLabDO : apobsDOs) {
			apLabDO.setStatus(DOStatus.UPDATED);
			apLabDO.setSd_su_obs(ICiDictCodeConst.SD_CI_OBS_BG);
			apLabDO.setId_su_obs(ICiDictCodeConst.ID_CI_OBS_BG);
			map.put(apLabDO.getNo_applyform(), apLabDO);
		}
		return map;
	}

	/**
	 * 实例化主DO信息
	 * 
	 * @param param
	 * @param apLabMap
	 * @param orderMap
	 * @param applynoList
	 * @param depMap
	 * @param psnMap
	 * @return
	 * @throws BizException
	 */
	private List<CiRptObsDO> initMDO(RptObsItemDTO[] params, Map<String, CiOrderDO> orderMap, Map<String, OrdApObsDO> apLabMap, Map<String, PsnDocDO> psnMap, Map<String, DeptDO> depMap) throws BizException {

		List<CiRptObsDO> ciRptObsDOs = new ArrayList<CiRptObsDO>();
		
		Context context = Context.get();
		String groupId = context.getGroupId();
		String orgId = context.getOrgId();
		
		for (RptObsItemDTO obsItemDTO : params) {
			String applyno = obsItemDTO.getNo_applyform();
			//OrdApObsDO apLabDO = apLabMap.get(applyno);
			CiOrderDO ciOrderDO = orderMap.get(applyno);
			CiRptObsDO ciRptObsDO = new CiRptObsDO();
			ciRptObsDO.setStatus(DOStatus.NEW);
			ciRptObsDO.setId_grp(groupId);
			ciRptObsDO.setId_org(orgId);
			ciRptObsDO.setNo_applyform(applyno);
			//ciRptObsDO.setId_orobs(apLabDO.getId_orobs());
			ciRptObsDO.setId_or(ciOrderDO.getId_or());
			ciRptObsDO.setId_ent(ciOrderDO.getId_en());
			ciRptObsDO.setNo_rptobs(obsItemDTO.getNo_rptobs());
			ciRptObsDO.setDes_advice(obsItemDTO.getDes_advice());
			ciRptObsDO.setDes_obs(obsItemDTO.getDes_obs());
			ciRptObsDO.setDes_rptobs(obsItemDTO.getDes_rptobs());

			if (null != obsItemDTO.getDt_rptobs()) {
				FDateTime dt = new FDateTime(obsItemDTO.getDt_rptobs());
				ciRptObsDO.setDt_rptobs(dt);
			}
			if (depMap.get(obsItemDTO.getCode_dep()) != null) {
				ciRptObsDO.setId_dep(depMap.get(obsItemDTO.getCode_dep()).getId_dep());
			}
			if (psnMap.get(obsItemDTO.getCode_emp()) != null) {
				ciRptObsDO.setId_emp(psnMap.get(obsItemDTO.getCode_emp()).getId_psndoc());
			}

			ciRptObsDOs.add(ciRptObsDO);
		}

		return ciRptObsDOs;
	}

	/**
	 * 保存数据
	 * 
	 * @param aggDOs
	 * @param values
	 * @param values2
	 * @throws BizException
	 */
	private void saveData(List<CiRptObsDO> obsDOs, Collection<CiOrderDO> values, Collection<OrdApObsDO> values2) throws BizException {
		//CiOrderDO[] orderDOs = values.toArray(new CiOrderDO[values.size()]);
		//OrdApObsDO[] apObsDOs = values2.toArray(new OrdApObsDO[values2.size()]);
		//ServiceFinder.find(ICiorderMDOCudService.class).save(orderDOs);
		//ServiceFinder.find(ICiorapprisCudService.class).save(apObsDOs);
		ServiceFinder.find(ICirptobsCudService.class).save(obsDOs.toArray(new CiRptObsDO[obsDOs.size()]));
	}
}
