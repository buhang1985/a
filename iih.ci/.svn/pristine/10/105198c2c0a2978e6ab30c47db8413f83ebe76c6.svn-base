package iih.ci.ord.s.ems.ip.ems.treat;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.content.d.CiOrContentDO;
import iih.ci.ord.dws.ip.ems.d.EmsTreatViewDTO;
import iih.ci.ord.dws.ip.order.d.OrderListViewDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.defsave.DefaultTreatCreateOrderInfo;
import iih.ci.ord.s.ems.ip.base.BaseIpEmsSetSaveBP;
import iih.ci.ord.s.ems.itf.IEmsValidate;
import iih.ci.ord.s.ems.meta.OrderPackageInfo;
import iih.ci.ord.s.ems.orcontent.CiOrContentUtils;
import iih.ci.ord.s.ems.orcontent.meta.TreatOrContentParam;
import xap.mw.core.data.BizException;

public class EmsTreatSaveBP extends BaseIpEmsSetSaveBP {

	public EmsTreatSaveBP() {
		// 设置有效性检查
		setEmsValidate(new EmsTreatValidate());
		// 设置医嘱默认生成逻辑
		setDefaultCreateOrderInfo(new DefaultTreatCreateOrderInfo());
	}

	public EmsTreatSaveBP(IEmsValidate emsValidate) {
		// 设置有效性检查
		setEmsValidate(emsValidate);
		// 设置医嘱默认生成逻辑
		setDefaultCreateOrderInfo(new DefaultTreatCreateOrderInfo());
	}

	/**
	 * 合并医嘱
	 * 
	 * @param orderInfo
	 * @param uiModel
	 * @throws BizException
	 */
	@Override
	protected void mergeOrderInfo(CiEnContextDTO ctx, OrderPackageInfo pInfo) throws BizException {
		super.mergeOrderInfo(ctx, pInfo);
		Object uiModel = pInfo.getOrderSrvMmList().get(0).getUiModel();
		CiOrderDO orderInfo = pInfo.getOrderInfo();
		if (uiModel instanceof EmsTreatViewDTO) {
			EmsTreatViewDTO emsTreatDto = (EmsTreatViewDTO) uiModel;
			orderInfo.setDes_or(emsTreatDto.getDes_or());
		}
	}


	@Override
	protected CiOrContentDO getOrderContent(CiEnContextDTO ctx, Object uiModel) {
		OrderListViewDTO uidto = (OrderListViewDTO) uiModel;
		TreatOrContentParam param = new TreatOrContentParam();
		param.setSd_srvtp(uidto.getSd_srvtp());
		param.setName_srv(uidto.getName_srv());
		param.setIsmuldose(uidto.getIsmuldose());
		param.setIsmulexec(uidto.getIsmulexec());
		param.setQuan_med(uidto.getQuan_med());
		param.setName_unit_med(uidto.getName_unit_med());
		param.setName_freq(uidto.getName_freq());
		// param.setDays_or(uidto.getDays_or());//出院带药需要拼接天数，暂不处理
		param.setFg_urgent(uidto.getFg_urgent());
		param.setPri(CiOrdUtils.CalculationPriRounding(2, uidto.getPri()));
		param.setSd_nodispense(uidto.getSd_nodispense());
		return CiOrContentUtils.create(param);
	}
}
