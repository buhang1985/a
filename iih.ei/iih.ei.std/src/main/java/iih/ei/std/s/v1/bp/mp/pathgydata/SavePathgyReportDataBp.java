package iih.ei.std.s.v1.bp.mp.pathgydata;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.cior.d.OrdApPathgyDO;
import iih.ci.ord.cior.i.ICiorapppathgyMDOCudService;
import iih.ci.ord.cior.i.ICiorapppathgyMDORService;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.i.ICiorderMDOCudService;
import iih.ci.ord.ciorder.i.ICiorderMDORService;
import iih.ci.ord.cirptpathgy.d.CiRptPathgyDO;
import iih.ci.ord.cirptpathgy.i.ICirptpathgyCudService;
import iih.ci.ord.cirptpathgy.i.ICirptpathgyRService;
import iih.ei.std.d.v1.mp.pathgydata.d.RptPathgyDTO;
import iih.ei.std.d.v1.mp.pathgydata.d.RptPathgyParamDTO;
import iih.ei.std.s.v1.bp.mp.common.MpnrUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.bdfw.bbd.i.IPsndocMDORService;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.orgfw.dept.i.IDeptRService;
/**
 * 
* @ClassName: SavePathgyReportDataBp
* @Description: 回写病理报告
* @author zhy
* @date 2019年9月30日
*
 */
public class SavePathgyReportDataBp {

	private List<String> depcodeList;
	private List<String> psncodeList;
	
	/**
	 * 程序主入口
	 * @param param
	 * @throws BizException 
	 */
	public void exec(RptPathgyParamDTO param) throws BizException {
		@SuppressWarnings("unchecked")
		RptPathgyDTO[] params =  (RptPathgyDTO[]) param.getRptpathgy().toArray(new RptPathgyDTO[0]);
		
		// 1.获取申请单号
		FArrayList applynoList = getApplynos(params);
		
		// 2.处理重复请求，如果有申请单号对应的报告，先删除处理
		deleteHisData(applynoList);
		
		// 3.查询申请单号对应的医嘱信息
		Map<String, CiOrderDO> orderMap = getOrderMap(applynoList);
		
		// 4.查询申请单号对应的申请单信息
		Map<String, OrdApPathgyDO> apLabMap = getApLabMap(applynoList);
		
		// 5.实例化人员部门信息
		DeptDO[] deptDOs = ServiceFinder.find(IDeptRService.class).findByAttrValStrings(DeptDO.CODE, depcodeList.toArray(new String[depcodeList.size()]));
		PsnDocDO[] psnDocDOs = ServiceFinder.find(IPsndocMDORService.class).findByAttrValStrings(PsnDocDO.CODE, psncodeList.toArray(new String[psncodeList.size()]));
		Map<String, DeptDO> depMap = MpnrUtils.mapBaseDO(deptDOs, DeptDO.CODE);
		Map<String, PsnDocDO> psnMap = MpnrUtils.mapBaseDO(psnDocDOs, PsnDocDO.CODE);
		
		// 6.通过申请单查询医嘱以及申请单信息，实例化检验报告主表数据
		List<CiRptPathgyDO> pathgyDOs = initMDO(params, orderMap, apLabMap, psnMap, depMap);
		
		// 7.保存数据
		saveData(pathgyDOs, orderMap.values(), apLabMap.values());
		
	}


	/**
	 * 获取申请单号
	 * @param params
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private FArrayList getApplynos(RptPathgyDTO[] params) {
		depcodeList = new ArrayList<String>();
		psncodeList = new ArrayList<String>();
		FArrayList applynoList = new FArrayList();
		for (RptPathgyDTO rptObsItemDTO : params) {
			if (!depcodeList.contains(rptObsItemDTO.getCode_dep_rpt()) && null != rptObsItemDTO.getCode_dep_rpt()) {
				depcodeList.add(rptObsItemDTO.getCode_dep_rpt());
			}
			if (!psncodeList.contains(rptObsItemDTO.getCode_emp_rpt()) && null != rptObsItemDTO.getCode_emp_rpt()) {
				psncodeList.add(rptObsItemDTO.getCode_emp_rpt());
			}
			if(!StringUtil.isEmptyWithTrim(rptObsItemDTO.getCode_reporter()) && !psncodeList.contains(rptObsItemDTO.getCode_reporter())){
				psncodeList.add(rptObsItemDTO.getCode_reporter());
			}
			if(!StringUtil.isEmptyWithTrim(rptObsItemDTO.getCode_technician()) && !psncodeList.contains(rptObsItemDTO.getCode_technician())){
				psncodeList.add(rptObsItemDTO.getCode_technician());
			}
			if (!applynoList.contains(rptObsItemDTO.getNo_applyform())) {
				applynoList.add(rptObsItemDTO.getNo_applyform());
			}
		}
		return applynoList;
	}
	
	/**
	 * 处理重复请求，如果有申请单号对应的报告，先删除处理
	 * @param applynoList
	 * @throws BizException 
	 */
	private void deleteHisData(FArrayList applynoList) throws BizException {
		CiRptPathgyDO[] obsDOs = ServiceFinder.find(ICirptpathgyRService.class).findByAttrValList(CiRptPathgyDO.NO_APPLYFORM, applynoList);
		if (obsDOs != null && obsDOs.length > 0) {
			ServiceFinder.find(ICirptpathgyCudService.class).delete(obsDOs);
		}
	}

	/**
	 * 查询申请单号对应的医嘱信息
	 * @param applynoList
	 * @return
	 * @throws BizException 
	 */
	private Map<String, CiOrderDO> getOrderMap(FArrayList applynoList) throws BizException {
		Map<String, CiOrderDO> map = new HashMap<String, CiOrderDO>();
		CiOrderDO[] ciOrderDOs = ServiceFinder.find(ICiorderMDORService.class).findByAttrValList(CiOrderDO.APPLYNO, applynoList);
		if (ciOrderDOs == null || ciOrderDOs.length < 0) {
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
	

	private Map<String, OrdApPathgyDO> getApLabMap(FArrayList applynoList) throws BizException {
		Map<String, OrdApPathgyDO> map = new HashMap<String, OrdApPathgyDO>();
		OrdApPathgyDO[] pathgyDOS = ServiceFinder.find(ICiorapppathgyMDORService.class).findByAttrValList(OrdApPathgyDO.NO_APPLYFORM, applynoList);
		if (pathgyDOS == null || pathgyDOS.length < 0) {
			throw new BizException("报告回传：申请单不存在！");
		}

		for (OrdApPathgyDO apLabDO : pathgyDOS) {
			apLabDO.setStatus(DOStatus.UPDATED);
			apLabDO.setSd_su_pathgy(ICiDictCodeConst.SD_CI_OBS_BG);
			apLabDO.setId_su_pathgy(ICiDictCodeConst.ID_CI_OBS_BG);
			map.put(apLabDO.getNo_applyform(), apLabDO);
		}
		return map;
	}
	
	/**
	 * 实例化主DO信息
	 * @param params
	 * @param orderMap
	 * @param apLabMap
	 * @param psnMap
	 * @param depMap
	 * @return
	 */
	private List<CiRptPathgyDO> initMDO(RptPathgyDTO[] params, Map<String, CiOrderDO> orderMap,
			Map<String, OrdApPathgyDO> apLabMap, Map<String, PsnDocDO> psnMap, Map<String, DeptDO> depMap) {
		List<CiRptPathgyDO> ciRptPathgyDOs = new ArrayList<CiRptPathgyDO>();

		for (RptPathgyDTO obsItemDTO : params) {
			String applyno = obsItemDTO.getNo_applyform();
			OrdApPathgyDO apPathgyDO = apLabMap.get(applyno);
			CiOrderDO ciOrderDO = orderMap.get(applyno);
			CiRptPathgyDO ciRptPathgyDO = new CiRptPathgyDO();
			ciRptPathgyDO.setStatus(DOStatus.NEW);
			ciRptPathgyDO.setNo_applyform(apPathgyDO.getNo_applyform());
			ciRptPathgyDO.setId_appathgy(apPathgyDO.getId_appathgy());
			ciRptPathgyDO.setId_or(ciOrderDO.getId_or());
			ciRptPathgyDO.setId_ent(ciOrderDO.getId_en());
			ciRptPathgyDO.setNo_rptpathgy(obsItemDTO.getNo_rptpathgy());
			ciRptPathgyDO.setDes_advice(obsItemDTO.getDes_advice());
			ciRptPathgyDO.setDes_pathgy(obsItemDTO.getDes_pathgy());
			ciRptPathgyDO.setDescription(obsItemDTO.getDescription());
			ciRptPathgyDO.setExam_para(obsItemDTO.getExam_para());
			ciRptPathgyDO.setImpression(obsItemDTO.getImpression());
			ciRptPathgyDO.setId_technician("");
			if (null != obsItemDTO.getDt_rptpathgy()) {
				FDateTime dt = new FDateTime();
				ciRptPathgyDO.setDt_rptpathgy(dt);
			}
			if (depMap.get(obsItemDTO.getCode_dep_rpt()) != null) {
				ciRptPathgyDO.setId_dep_rpt(depMap.get(obsItemDTO.getCode_dep_rpt()).getId_dep());
			}
			if (psnMap.get(obsItemDTO.getCode_emp_rpt()) != null) {
				ciRptPathgyDO.setId_emp_rpt(psnMap.get(obsItemDTO.getCode_emp_rpt()).getId_psndoc());
			}

			if (psnMap.get(obsItemDTO.getCode_reporter()) != null) {
				ciRptPathgyDO.setCode_reporter(obsItemDTO.getCode_reporter());
				ciRptPathgyDO.setId_reporter(psnMap.get(obsItemDTO.getCode_reporter()).getId_psndoc());
			}
			
			if (psnMap.get(obsItemDTO.getCode_technician()) != null) {
				ciRptPathgyDO.setCode_technician(obsItemDTO.getCode_technician());
				ciRptPathgyDO.setId_technician(psnMap.get(obsItemDTO.getCode_technician()).getId_psndoc());
			}
			
			ciRptPathgyDOs.add(ciRptPathgyDO);
		}

		return ciRptPathgyDOs;
	}
	
	/**
	 * 保存数据
	 * @param pathgyDOs
	 * @param values
	 * @param values2
	 * @throws BizException 
	 */
	private void saveData(List<CiRptPathgyDO> pathgyDOs, Collection<CiOrderDO> values,
			Collection<OrdApPathgyDO> values2) throws BizException {
		CiOrderDO[] orderDOs = values.toArray(new CiOrderDO[values.size()]);
		OrdApPathgyDO[] apObsDOs = values2.toArray(new OrdApPathgyDO[values2.size()]);
		ServiceFinder.find(ICiorderMDOCudService.class).save(orderDOs);
		ServiceFinder.find(ICiorapppathgyMDOCudService.class).save(apObsDOs);
		ServiceFinder.find(ICirptpathgyCudService.class).save(pathgyDOs.toArray(new CiRptPathgyDO[pathgyDOs.size()]));
	}
	
}
