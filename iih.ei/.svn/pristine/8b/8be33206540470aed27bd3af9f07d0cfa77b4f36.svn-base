package iih.ei.std.s.v1.bp.pe.lisrpt;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.cior.d.OrdApLabDO;
import iih.ci.ord.cior.i.ICiorapplisCudService;
import iih.ci.ord.cior.i.ICiorapplisRService;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.i.ICiorderMDOCudService;
import iih.ci.ord.ciorder.i.ICiorderMDORService;
import iih.ci.ord.cirptlab.d.CiRptLabDO;
import iih.ci.ord.cirptlab.d.CirptlabAggDO;
import iih.ci.ord.cirptlab.i.ICirptlabCudService;
import iih.ci.ord.cirptlab.i.ICirptlabRService;
import iih.ei.std.d.v1.commdto.d.NoParamDTO;
import iih.ei.std.d.v1.mp.lisreport.d.CancRptDTO;
import iih.ei.std.d.v1.mp.lisreport.d.CancRptSDTO;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 取消报告接口
 * 
 * @author hjh
 *
 */
public class CancPeRptBp extends IIHServiceBaseBP<CancRptSDTO, NoParamDTO> {

	@Override
	protected void checkParam(CancRptSDTO param) throws BizException {
		if (param == null) {
			throw new BizException("参数为空！");
		}
		if (param.getRpt().size() < 0) {
			throw new BizException("报告为空！");
		}
	}

	@Override
	protected NoParamDTO process(CancRptSDTO param) throws BizException {
		@SuppressWarnings("unchecked")
		CancRptDTO[] rpts = (CancRptDTO[]) param.getRpt().toArray(new CancRptDTO[0]);
		// 获取报告号集合
		List<String> rptNoList = getRptNoList(rpts);

		// 根据报告号获取相关报告信息
		CirptlabAggDO[] labAgg = ServiceFinder.find(ICirptlabRService.class).findByAttrValStrings(CiRptLabDO.NO_RPTLAB, rptNoList.toArray(new String[0]));

		// 获取医嘱ID集合
		List<String> applyno = new ArrayList<String>();
		String[] idors = getIdors(labAgg, applyno);

		// 获取检验申请信息
		OrdApLabDO[] apLabDOs = ServiceFinder.find(ICiorapplisRService.class).findByAttrValStrings(OrdApLabDO.NO_APPLYFORM, applyno.toArray(new String[0]));
		updateAp(apLabDOs);

		// 获取医嘱信息
		CiOrderDO[] orderDOs = ServiceFinder.find(ICiorderMDORService.class).findByBIds(idors, FBoolean.FALSE);
		updateOrders(orderDOs);
		// 保存数据
		savedata(apLabDOs, orderDOs, labAgg);

		return new NoParamDTO();
	}

	/**
	 * 保存数据
	 * @param apLabDOs
	 * @param orderDOs
	 * @param labAgg
	 * @throws BizException
	 */
	private void savedata(OrdApLabDO[] apLabDOs, CiOrderDO[] orderDOs, CirptlabAggDO[] labAgg) throws BizException {
		if (apLabDOs != null && apLabDOs.length > 0) {
			ServiceFinder.find(ICiorapplisCudService.class).save(apLabDOs);
		}
		if (orderDOs != null && orderDOs.length > 0) {
			ServiceFinder.find(ICiorderMDOCudService.class).save(orderDOs);
		}
		if (labAgg != null && labAgg.length > 0) {
			ServiceFinder.find(ICirptlabCudService.class).delete(labAgg);
		}

	}

	/**
	 * 
	 * @param orderDOs
	 */
	private void updateOrders(CiOrderDO[] ciOrderDOs) {
		if (ciOrderDOs == null || ciOrderDOs.length < 1) {
			return;
		}

		for (CiOrderDO ciOrderDO : ciOrderDOs) {
			ciOrderDO.setStatus(DOStatus.UPDATED);
			ciOrderDO.setId_orrsttp(ICiDictCodeConst.ID_CI_RPT_LAB_ZH);
			ciOrderDO.setSd_orrsttp(ICiDictCodeConst.SD_CI_RPT_LAB_ZH);
		}
	}

	/**
	 * 更新申请单报告状态
	 * 
	 * @param apLabDOs
	 * @throws BizException
	 */
	private void updateAp(OrdApLabDO[] apLabDOs) throws BizException {
		if (apLabDOs == null || apLabDOs.length < 1) {
			return;
		}

		for (OrdApLabDO apLabDO : apLabDOs) {
			apLabDO.setStatus(DOStatus.UPDATED);
			apLabDO.setSd_su_lab(ICiDictCodeConst.SD_CI_RPT_LAB_ZH);
			apLabDO.setId_su_lab(ICiDictCodeConst.ID_CI_RPT_LAB_ZH);
		}

	}

	/**
	 * 获取医嘱ID
	 * 
	 * @param labAgg
	 * @return
	 */
	private String[] getIdors(CirptlabAggDO[] labAgg, List<String> applyno) {

		List<String> list = new ArrayList<String>();
		for (CirptlabAggDO cirptlabAggDO : labAgg) {
			CiRptLabDO parDo = cirptlabAggDO.getParentDO();
			if (list.contains(parDo.getId_or())) {
				continue;
			}
			applyno.add(parDo.getNo_applyform());
			list.add(parDo.getId_or());
		}

		return list.toArray(new String[list.size()]);
	}

	/**
	 * 获取报告号集合
	 * 
	 * @param rpts
	 * @return
	 */
	private List<String> getRptNoList(CancRptDTO[] rpts) {
		List<String> rptNoList = new ArrayList<String>();
		for (CancRptDTO rpt : rpts) {
			if (rptNoList.contains(rpt.getNo_rptlab())) {
				continue;
			}
			rptNoList.add(rpt.getNo_rptlab());
		}
		return rptNoList;
	}

}
