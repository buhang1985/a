package iih.ei.std.s.v1.bp.pe.updatastatus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import iih.bd.bc.event.pub.IMpEventConst;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciorder.i.ICiorderMDOCudService;
import iih.ci.ord.ciorder.i.ICiorderMDORService;
import iih.ci.ord.ciorder.i.IOrdSrvDOCudService;
import iih.ci.ord.ciorder.i.IOrdSrvDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

public class ConfirmPeFeeBp {
	/**
	 * 主入口
	 * 
	 * @param param
	 * @return
	 */
	public void exec(String[] no_applyForm, String status_bl) throws BizException {

		// 1、基础校验
		validation(no_applyForm, status_bl);

		// 2、获取医嘱信息
		CiOrderDO[] orders = getOrderInfo(no_applyForm);

		// 3、获取医嘱项目
		OrdSrvDO[] orsrvs = getOrsrvs(orders);

		// 4、更新费用状态
		updateFeeRtnable(orders, orsrvs, status_bl);
	}

	/**
	 * 基础校验
	 * 
	 * @param no_applyForm
	 * @param status_bl
	 * @throws BizException
	 */
	private void validation(String[] no_applyForm, String status_bl) throws BizException {
		if (no_applyForm == null || no_applyForm.length < 1) {
			throw new BizException("门诊确费：申请单号空异常");
		}

		if (StringUtil.isEmptyWithTrim(status_bl)) {
			throw new BizException("门诊确费：费用状态空异常");
		}

		if (!IMpEventConst.SD_FEE_COMFIRM.equals(status_bl) && !IMpEventConst.SD_FEE_UNCOMFIRM.equals(status_bl)) {
			throw new BizException("门诊确费：费用状态不可识别");
		}
	}
	
	/**
	 * 获取医嘱信息
	 * @param no_applyForm
	 * @return
	 * @throws BizException 
	 */
	private CiOrderDO[] getOrderInfo(String[] no_applyForm) throws BizException {
		CiOrderDO[] orders = ServiceFinder.find(ICiorderMDORService.class).findByAttrValStrings(CiOrderDO.APPLYNO, no_applyForm);
		if (orders == null || orders.length < 1) {
			
			throw new BizException("门诊确费：无法找到申请单【" + Arrays.toString(no_applyForm) + "】");
		}

		List<CiOrderDO> listOrders = new ArrayList<CiOrderDO>();
		for (CiOrderDO order : orders) {
			if (IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(order.getCode_entp())) {
				listOrders.add(order);
			}
		}
		if (listOrders.size() < 1) {
			throw new BizException("门诊确费：无法找到申请单【" + Arrays.toString(no_applyForm) + "】");
		}
		return listOrders.toArray(new CiOrderDO[listOrders.size()]);
	}
	
	/**
	 * 获取医嘱项目信息
	 * @param orders
	 * @return
	 * @throws BizException 
	 */
	private OrdSrvDO[] getOrsrvs(CiOrderDO[] orders) throws BizException {
		List<String> listOrs=new ArrayList<String>();
		for (CiOrderDO order : orders) {
			listOrs.add(order.getId_or());
		}
		OrdSrvDO[] orsrvs = ServiceFinder.find(IOrdSrvDORService.class).findByAttrValStrings(OrdSrvDO.ID_OR, listOrs.toArray(new String[listOrs.size()]));
		if (orsrvs == null || orsrvs.length < 1) {
			throw new BizException("门诊确费：无法找到申请单对应的项目信息");
		}
		return orsrvs;
	}
	
	/**
	 * 更新费用状态
	 * 
	 * @param order
	 * @param orsrvs
	 * @param status_bl
	 * @throws BizException
	 */
	private void updateFeeRtnable(CiOrderDO[] orders, OrdSrvDO[] orsrvs, String status_bl) throws BizException {

		ICiorderMDOCudService orSaveService = ServiceFinder.find(ICiorderMDOCudService.class);
		IOrdSrvDOCudService orSrvSaveService = ServiceFinder.find(IOrdSrvDOCudService.class);

		// 转换可退费标记
		FBoolean fg_feerntable = new FBoolean(IMpEventConst.SD_FEE_UNCOMFIRM.equals(status_bl));

		// 设置医嘱可退费标记
		for (CiOrderDO order : orders) {
			order.setFg_feertnable(fg_feerntable);
			order.setStatus(DOStatus.UPDATED);
		}

		// 设置服务项目可退费标记
		for (OrdSrvDO ordSrvDO : orsrvs) {
			ordSrvDO.setFg_feertnable(fg_feerntable);
			ordSrvDO.setStatus(DOStatus.UPDATED);
		}

		// 更新费用状态
		orSaveService.save(orders);
		orSrvSaveService.save(orsrvs);
	}
}
