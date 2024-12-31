package iih.ci.ord.s.ems.defsave;

import iih.ci.ord.cior.d.OrdAppBtUseDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.s.ems.meta.DefaultCreateParam;
import iih.ci.ord.s.ems.meta.ObjectList;
import iih.ci.ord.s.ems.meta.OrderPackageInfo;
import xap.mw.core.data.BizException;

/**
 * 默认用血医嘱创建逻辑
 * @author wangqingzhu
 *
 */
public class DefaultApBuCreateOrderInfo extends DefaultSingleSrvCreateOrderInfo {
	
	@Override
	public OrderPackageInfo[] createOrderPakageInfo(CiEnContextDTO ctx, DefaultCreateParam[] szParam) 
			throws BizException {
		// TODO Auto-generated method stub
		OrderPackageInfo[] szOrderPakageInfo = super.createOrderPakageInfo(ctx, szParam);
		// 放回用血申请单信息
		for (OrderPackageInfo info : szOrderPakageInfo) {
			ObjectList list = new ObjectList();
			OrdAppBtUseDO buDO=creatOrdBuInfo(ctx, info.getUiModel());
			buDO.setId_or(info.getOrderInfo().getId_or());
			list.add(buDO);
			info.setOrderAppSheetList(list);
		}
		return szOrderPakageInfo;
	}

	public OrdAppBtUseDO creatOrdBuInfo(CiEnContextDTO ctx, Object objEmsBu) {
		OrdAppBtUseDO ordbu = new OrdAppBtUseDO();
//		ordbu.setId_or(emsBu.getId_or());
//		ordbu.setDt_bu_plan(emsBu.getDt_pl_bu());
//		ordbu.setNo_applyform(emsBu.getNo_applyform_bu());
//		ordbu.setOperationroom(emsBu.getOperationroom());
//		ordbu.setOperationroomtel(emsBu.getOperationroomtel());
//		ordbu.setApplydoctortel(emsBu.getApplydoctortel());
//		ordbu.setFg_prn(FBoolean.FALSE);
//		ordbu.setCnt_prn(0);
		return ordbu;
	}


}
