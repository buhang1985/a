package iih.ci.ord.s.ems.ip.ems.herbs;

import java.util.ArrayList;
import java.util.List;

import iih.ci.ord.ciorder.d.OrSrvSourceFromEnum;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.dws.ip.ems.d.EmsHerbsViewDTO;
import iih.ci.ord.dws.ip.order.d.OrderListViewDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.common.EmsDriverInfo;
import iih.ci.ord.i.meta.EmsLoadDTO;
import iih.ci.ord.i.meta.EmsRstDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.ip.ems.commondrugs.EmsCommonDrugsLoadBP;
import iih.ci.ord.s.ems.meta.OrderPackageInfo;
import iih.ci.ord.s.ems.meta.OrderSrvMmInfo;
import xap.mw.core.data.BizException;

/**
 * 加载草药医疗单
 * @author wangqingzhu
 *
 */
public class EmsHerbsLoadBP extends EmsCommonDrugsLoadBP {
	@Override
	public EmsRstDTO[] load(CiEnContextDTO ctx,EmsLoadDTO[] args) throws BizException {
		EmsRstDTO[] rsts = super.load(ctx,args);
		return rsts;
	}
	
	@Override
	protected List<OrderListViewDTO> emsViewModelFrom(CiEnContextDTO ctx, OrderPackageInfo opInfo,EmsDriverInfo driverInfo) 
			throws BizException {
		List<OrderListViewDTO> emsdruglist = new ArrayList<OrderListViewDTO>();
		if (!CiOrdUtils.isEmpty(opInfo.getOrderSrvMmList())) {
			for (Object obj : opInfo.getOrderSrvMmList()) {
				OrdSrvDO ordSrvDO = ((OrderSrvMmInfo) obj).getOrderSrvInfo();
				// 临床项目
				if (CiOrdUtils.isTrue(ordSrvDO.getFg_or()) && OrSrvSourceFromEnum.PHYSIAN.equals(ordSrvDO.getEu_sourcemd())) {
					EmsHerbsViewDTO emsherbsviewdto = new EmsHerbsViewDTO();
					this.emsViewInfoFrom(emsherbsviewdto, ctx, opInfo, (OrderSrvMmInfo) obj, driverInfo);
					emsherbsviewdto.setId_boil(opInfo.getOrderInfo().getId_boil());
					emsherbsviewdto.setName_boil(opInfo.getOrderInfo().getBoil_name());
					emsherbsviewdto.setId_boildes(ordSrvDO.getId_boildes());
					emsherbsviewdto.setName_boildes(ordSrvDO.getBoildes_name());
					emsherbsviewdto.setOrders(opInfo.getOrderInfo().getOrders());
					emsherbsviewdto.setFg_boil(opInfo.getOrderInfo().getFg_boil());
					emsherbsviewdto.setOrders_boil(opInfo.getOrderInfo().getOrders_boil());
					emsherbsviewdto.setFg_nothingwithorders(ordSrvDO.getFg_nothingwithorders());
					emsdruglist.add(emsherbsviewdto);
				}
			}
		}
		
		return emsdruglist;
	}

}
