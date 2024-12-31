package iih.ci.ord.s.ems.ip.ems.herbs;

import java.util.List;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.content.d.CiOrContentDO;
import iih.ci.ord.dws.ip.ems.d.EmsHerbsViewDTO;
import iih.ci.ord.dws.ip.order.d.OrderListViewDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.defsave.DefaultDrugsCreateOrderInfo;
import iih.ci.ord.s.ems.ip.ems.commondrugs.EmsCommonDrugsSaveBP;
import iih.ci.ord.s.ems.itf.IEmsValidate;
import iih.ci.ord.s.ems.meta.OrderPackageInfo;
import iih.ci.ord.s.ems.orcontent.CiOrContentUtils;
import iih.ci.ord.s.ems.orcontent.meta.CommonDrugItemOrContentParam;
import iih.ci.ord.s.ems.orcontent.meta.HerbOrContentParam;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;

/**
 * 住院草药医疗单保存逻辑
 * 
 * @author wangqingzhu
 *
 */
public class EmsHerbsSaveBP extends EmsCommonDrugsSaveBP {

	public EmsHerbsSaveBP() {
		this.setEmsValidate(new EmsHerbsValidate());
		this.setDefaultCreateOrderInfo(new DefaultDrugsCreateOrderInfo());
	}

	public EmsHerbsSaveBP(IEmsValidate emsValidate) {
		this.setEmsValidate(emsValidate);
		this.setDefaultCreateOrderInfo(new DefaultDrugsCreateOrderInfo());
	}
	
	@Override
	protected void afterMergeOrderSrvInfo(CiEnContextDTO ctx, CiOrderDO orderInfo, OrdSrvDO srvInfo, Object uiModel)
			throws BizException {
		srvInfo.setId_boil(orderInfo.getId_boil());
		srvInfo.setDt_last_bl(orderInfo.getDt_last_bl());
	}


	@Override
	protected void mergeOrderSrvInfo(CiEnContextDTO ctx, OrdSrvDO srvInfo, Object uiModel) throws BizException {
		// TODO Auto-generated method stub
		super.mergeOrderSrvInfo(ctx, srvInfo, uiModel);

		if (uiModel instanceof EmsHerbsViewDTO) {
			EmsHerbsViewDTO curDrug = (EmsHerbsViewDTO) uiModel;
			srvInfo.setId_boil(curDrug.getId_boil());
			srvInfo.setId_boildes(curDrug.getId_boildes());
			srvInfo.setBoildes_name(curDrug.getName_boildes());
			srvInfo.setFg_nothingwithorders(curDrug.getFg_nothingwithorders());
		}
	}

	@Override
	protected void mergeOrderInfo(CiEnContextDTO ctx, OrderPackageInfo pInfo) throws BizException {
		super.mergeOrderInfo(ctx, pInfo);

		OrderListViewDTO orderlistviewdto = super.getMainOrderListViewDTO8UI(pInfo);
		CiOrderDO orderInfo = pInfo.getOrderInfo();
		orderInfo.setId_wg_or(ctx.getId_wg_or());

		HerbOrContentParam content = new HerbOrContentParam();
		if (orderlistviewdto instanceof EmsHerbsViewDTO) {
			EmsHerbsViewDTO herb = (EmsHerbsViewDTO) orderlistviewdto;
			orderInfo.setNote_or(herb.getDes_or());
			orderInfo.setQuan_firday_mp(herb.getQuan_firday_mp());// 首日执行次数
			orderInfo.setOrders(herb.getOrders());
			orderInfo.setFg_boil(herb.getFg_boil());
			if(CiOrdUtils.isTrue(herb.getFg_boil())){
				orderInfo.setOrders_boil(herb.getOrders());
			}
			orderInfo.setId_boil(herb.getId_boil());
			orderInfo.setId_boildes(herb.getId_boildes());
			
			//草药停止逻辑(一天一付)
			//orderInfo.setFg_stop(FBoolean.TRUE);
			//orderInfo.setDt_stop(orderlistviewdto.getDt_effe());
			//orderInfo.setId_emp_stop(ctx.getId_emp_or());
			//orderInfo.setId_dep_stop(ctx.getId_dep_or());
			//orderInfo.setDt_end(orderlistviewdto.getDt_effe().addSeconds(herb.getOrders()*3600*24));
			orderInfo.setTimes_cur(orderlistviewdto.getTimes_cur());
			
			content.setNote(herb.getDes_or());
		}

		content.setFg_urgent(orderlistviewdto.getFg_urgent());
		content.setIsmuldose(orderlistviewdto.getIsmuldose());
		content.setIsmulexec(orderlistviewdto.getIsmulexec());
		content.setName_freq(orderlistviewdto.getName_freq());
		content.setName_route(orderlistviewdto.getName_route());
		content.setName_srv(orderlistviewdto.getName_srv());
		content.setName_unit_med(orderlistviewdto.getName_unit_med());
		content.setPri(orderlistviewdto.getPri());
		// content.setQuan_med(drug.getQuan_med());
		content.setSd_srvtp(orderlistviewdto.getSd_srvtp());
		content.setTotal_pri(orderlistviewdto.getTotalprice());
	}
	
	@Override
	protected void mergeOrderMmInfo(CiEnContextDTO ctx, OrdSrvMmDO srvMmInfo, Object uiModel) 
			throws BizException {
		super.mergeOrderMmInfo(ctx, srvMmInfo, uiModel);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void afterMergeOrderPakageInfo(CiEnContextDTO ctx, CiOrderDO orderInfo, OrdSrvDO[] srvInfos,
			Object uiModel) throws BizException {
		// TODO Auto-generated method stub
		super.afterMergeOrderPakageInfo(ctx, orderInfo, srvInfos, uiModel);

		List<OrderListViewDTO> uiList = (List<OrderListViewDTO>) uiModel;

		HerbOrContentParam content = new HerbOrContentParam();
		OrderListViewDTO orderlistviewdto = uiList.get(0);
		if (orderlistviewdto instanceof EmsHerbsViewDTO) {
			content.setNote(((EmsHerbsViewDTO) orderlistviewdto).getDes_or());
			content.setOrders(((EmsHerbsViewDTO) orderlistviewdto).getOrders());
			content.setTotal_pri(((EmsHerbsViewDTO) orderlistviewdto).getAmt_total());
		}
		content.setDays_or(orderlistviewdto.getDays_or());
		content.setFg_urgent(orderlistviewdto.getFg_urgent());
		content.setIsmuldose(orderlistviewdto.getIsmuldose());
		content.setIsmulexec(orderlistviewdto.getIsmulexec());
		content.setName_freq(orderlistviewdto.getName_freq());
		content.setName_route(orderlistviewdto.getName_route());
		content.setName_srv(orderlistviewdto.getName_srv());
		content.setPri(orderlistviewdto.getPri());
		content.setSd_srvtp(orderlistviewdto.getSd_srvtp());
		content.setName_unit_med(orderlistviewdto.getName_unit_med());
		FArrayList items = new FArrayList();
		for (int i = 0; i < uiList.size(); i++) {
			EmsHerbsViewDTO ui = (EmsHerbsViewDTO) uiList.get(i);
			if (DOStatus.DELETED != ui.getStatus()) {
				CommonDrugItemOrContentParam item = new CommonDrugItemOrContentParam();
				item.setName_mm(ui.getName_mm());
				item.setName_srv(ui.getName_srv());
				item.setName_unit_sale(ui.getName_unit_cur());
				item.setQuan_total_medu(ui.getQuan_total_medu());
				item.setFg_self(ui.getFg_self());
				item.setFg_selfsrv(ui.getFg_selfsrv());
				item.setQuan_med(ui.getQuan_med());
				item.setFg_or(ui.getFg_or());
				item.setSd_nodispense(ui.getSd_nodispense());
				item.setFg_nothingwithorders(ui.getFg_nothingwithorders());
				item.setName_unit_med(ui.getName_unit_med());
				items.add(item);
			}
		}
		content.setItems(items);
		CiOrContentDO ciOrContentDO = CiOrContentUtils.create(content);
		ciOrContentDO.setTitle(orderInfo.getOrders() == null ? "" : orderInfo.getOrders() + "");
		orderInfo.setContent_or(ciOrContentDO.toString());
	}

}
