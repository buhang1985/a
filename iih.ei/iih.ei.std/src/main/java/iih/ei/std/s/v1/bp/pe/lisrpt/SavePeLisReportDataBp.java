package iih.ei.std.s.v1.bp.pe.lisrpt;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.bdfw.bbd.i.IPsndocMDORService;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.orgfw.dept.i.IDeptRService;
import xap.sys.xbd.udi.d.UdidocDO;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.ci.ord.cior.d.OrdApLabDO;
import iih.ci.ord.cior.i.ICiorapplisCudService;
import iih.ci.ord.cior.i.ICiorapplisRService;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.i.ICiorderMDOCudService;
import iih.ci.ord.ciorder.i.ICiorderMDORService;
import iih.ci.ord.cirptlab.d.CiRptLabDO;
import iih.ci.ord.cirptlab.d.CiRptLabItmDO;
import iih.ci.ord.cirptlab.d.CirptlabAggDO;
import iih.ci.ord.cirptlab.i.ICirptlabCudService;
import iih.ci.ord.cirptlab.i.ICirptlabRService;
import iih.ei.std.d.v1.mp.lisreport.d.LisRptInfoDTO;
import iih.ei.std.d.v1.mp.lisreport.d.LisRptItmInfoDTO;
import iih.ei.std.s.v1.bp.mp.common.Commonbp;

public class SavePeLisReportDataBp {
	public BaseDO exec(LisRptInfoDTO param) throws BizException {

		// 1.获取申请单号
		FArrayList applynoList = getApplynos(param);

		// 2.处理重复请求，如果有申请单号对应的报告，先删除处理
		deleteHisData(applynoList);

		// 3.查询申请单号对应的医嘱信息
		Map<String, CiOrderDO> orderMap = getOrderMap(applynoList);

		// 4.查询申请单号对应的申请单信息
		Map<String, OrdApLabDO> apLabMap = getApLabMap(applynoList);

		// 5.通过申请单查询医嘱以及申请单信息，实例化检验报告主表数据
		List<CirptlabAggDO> aggDOList = initMDO(param, applynoList, orderMap, apLabMap);

		// 6.实例化子表数据
		CiRptLabItmDO[] labItms = initItemDTO(param);

		// 7.设置子表数据到aggdo
		CirptlabAggDO[] aggDOs = selectItemData(labItms, aggDOList);

		// 8.保存数据
		saveData(aggDOs, orderMap.values(), apLabMap.values());

		return null;
	}

	/**
	 * 获取申请单号
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private FArrayList getApplynos(LisRptInfoDTO param) throws BizException {
		FArrayList applynoList = new FArrayList();
		String[] no_applyForms = param.getNo_applyform().split(",");
		if (no_applyForms == null || no_applyForms.length == 0) {
			throw new BizException("报告回传：无有效的申请单号！");
		}
		for (String applyNo : no_applyForms) {
			if (!applynoList.contains(applyNo)) {
				applynoList.add(applyNo);
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

		CirptlabAggDO[] aggDOs = ServiceFinder.find(ICirptlabRService.class).findByAttrValList(CiRptLabDO.NO_APPLYFORM, applynoList);
		if (aggDOs != null && aggDOs.length > 0) {
			ServiceFinder.find(ICirptlabCudService.class).delete(aggDOs);
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
		CiOrderDO[] ciOrderDOs = ServiceFinder.find(ICiorderMDORService.class).findByAttrValList(CiOrderDO.APPLYNO, applynoList);
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
	private Map<String, OrdApLabDO> getApLabMap(FArrayList applynoList) throws BizException {

		Map<String, OrdApLabDO> map = new HashMap<String, OrdApLabDO>();
		OrdApLabDO[] apLabDOs = ServiceFinder.find(ICiorapplisRService.class).findByAttrValList(OrdApLabDO.NO_APPLYFORM, applynoList);
		if (apLabDOs == null || apLabDOs.length < 1) {
			throw new BizException("报告回传：申请单不存在！");
		}

		for (OrdApLabDO apLabDO : apLabDOs) {
			apLabDO.setStatus(DOStatus.UPDATED);
			apLabDO.setSd_su_lab(ICiDictCodeConst.SD_CI_RPT_LAB_FBBG);
			apLabDO.setId_su_lab(ICiDictCodeConst.ID_CI_RPT_LAB_FBBG);
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
	 * @return
	 * @throws BizException
	 */
	private List<CirptlabAggDO> initMDO(LisRptInfoDTO param, FArrayList applynoList, Map<String, CiOrderDO> orderMap, Map<String, OrdApLabDO> apLabMap) throws BizException {

		List<CirptlabAggDO> aggDOList = new ArrayList<CirptlabAggDO>();

		DeptDO[] deptDOs = ServiceFinder.find(IDeptRService.class).findByAttrValString(DeptDO.CODE, param.getCode_dep_report());
		PsnDocDO[] psnDocDOs = ServiceFinder.find(IPsndocMDORService.class).findByAttrValString(PsnDocDO.CODE, param.getCode_emp_report());

		Context context = Context.get();
		String groupId = context.getGroupId();
		String orgId = context.getOrgId();
		
		for (Object object : applynoList) {
			String applyno = (String) object;
			OrdApLabDO apLabDO = apLabMap.get(applyno);
			CiOrderDO ciOrderDO = orderMap.get(applyno);
			CirptlabAggDO aggDO = new CirptlabAggDO();
			CiRptLabDO rptLabDO = new CiRptLabDO();
			aggDO.setParentDO(rptLabDO);
			rptLabDO.setStatus(DOStatus.NEW);
			rptLabDO.setId_grp(groupId);
			rptLabDO.setId_org(orgId);
			rptLabDO.setNo_applyform(apLabDO.getNo_applyform());
			rptLabDO.setId_orlab(apLabDO.getId_orlab());
			rptLabDO.setId_or(ciOrderDO.getId_or());
			rptLabDO.setId_ent(ciOrderDO.getId_en());
			rptLabDO.setNo_rptlab(param.getNo_report());
			rptLabDO.setName_rpt(param.getReport_name());
			FDateTime dt = new FDateTime(param.getDt_report());
			if (dt != null) {

				rptLabDO.setDt_rptlab(dt);
			}
			if (deptDOs != null && deptDOs.length > 0) {

				rptLabDO.setId_dep(deptDOs[0].getId_dep());
			}
			if (psnDocDOs != null && psnDocDOs.length > 0) {
				rptLabDO.setId_emp(psnDocDOs[0].getId_psndoc());
			}

			aggDOList.add(aggDO);
		}

		return aggDOList;
	}

	/**
	 * 实例化子表数据
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private CiRptLabItmDO[] initItemDTO(LisRptInfoDTO param) throws BizException {

		Commonbp bp = new Commonbp();
		IMedsrvMDORService srvRService = ServiceFinder.find(IMedsrvMDORService.class);
		List<CiRptLabItmDO> rptLabItmDOs = new ArrayList<CiRptLabItmDO>();
		List<LisRptItmInfoDTO> itemList = param.getItm();

		if (itemList != null && itemList.size() > 0) {
			for (LisRptItmInfoDTO detail : itemList) {
				if (detail != null) {
					CiRptLabItmDO itmDO = new CiRptLabItmDO();
					itmDO.setStatus(DOStatus.NEW);
					MedSrvDO[] medSrvDOs = srvRService.findByAttrValString(MedSrvDO.CODE, detail.getCode_srv_itm());
					if (medSrvDOs != null && medSrvDOs.length > 0) {
						itmDO.setId_srv(medSrvDOs[0].getId_srv());
					}
					if(!StringUtil.isEmptyWithTrim(detail.getSta_report()) ){
						UdidocDO udidocDO=bp.getUdidocByCode(ICiDictCodeConst.CODE_LIS_VAL_STATE, detail.getSta_report() ); 
						itmDO.setId_val_state(udidocDO.getId_udidoc());
						itmDO.setSd_val_state(detail.getSta_report());
					}
					if(!StringUtil.isEmptyWithTrim(detail.getSortno())){
						itmDO.setSortno(Integer.parseInt(detail.getSortno()));
					}
					itmDO.setLis_code_srv(detail.getCode_srv_itm());//lis报告项目编码
					itmDO.setFg_crisis(new FBoolean("Y".equals(detail.getFg_crisis())));//危机值标志
					itmDO.setName_srv(detail.getName_srv_itm());//LIS报告项目
					itmDO.setName_unit(detail.getUnit_value());//项目值单位
					itmDO.setVal_rstrptlab(detail.getValue());//项目结果值
					itmDO.setVal_range(detail.getReference());//结果值范围
					itmDO.setReference_ranges(detail.getReference());//结果值范围
					rptLabItmDOs.add(itmDO);
				}
			}
		}

		return rptLabItmDOs.toArray(new CiRptLabItmDO[rptLabItmDOs.size()]);
	}

	/**
	 * 设置子表数据到aggdo
	 * 
	 * @param labItms
	 * @param aggDOList
	 * @return
	 */
	private CirptlabAggDO[] selectItemData(CiRptLabItmDO[] labItms, List<CirptlabAggDO> aggDOList) {

		for (CirptlabAggDO cirptlabAggDO : aggDOList) {
			List<CiRptLabItmDO> labitmDOs = new ArrayList<CiRptLabItmDO>();
			
			for (CiRptLabItmDO itmDO : labItms) {
				labitmDOs.add((CiRptLabItmDO)itmDO.clone());
			}
			cirptlabAggDO.setCiRptLabItmDO(labitmDOs.toArray(new CiRptLabItmDO[labitmDOs.size()]));
		}

		return aggDOList.toArray(new CirptlabAggDO[aggDOList.size()]);
	}

	/**
	 * 保存数据
	 * 
	 * @param aggDOs
	 * @param values
	 * @param values2
	 * @throws BizException
	 */
	private void saveData(CirptlabAggDO[] aggDOs, Collection<CiOrderDO> values, Collection<OrdApLabDO> values2) throws BizException {
		CiOrderDO[] orderDOs = values.toArray(new CiOrderDO[values.size()]);
		OrdApLabDO[] apLabDOs = values2.toArray(new OrdApLabDO[values2.size()]);
		ServiceFinder.find(ICiorderMDOCudService.class).save(orderDOs);
		ServiceFinder.find(ICiorapplisCudService.class).save(apLabDOs);
		ServiceFinder.find(ICirptlabCudService.class).save(aggDOs);
	}
}
