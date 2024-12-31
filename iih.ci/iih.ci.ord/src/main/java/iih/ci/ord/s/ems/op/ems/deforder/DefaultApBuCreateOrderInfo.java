package iih.ci.ord.s.ems.op.ems.deforder;

import iih.ci.ord.cior.d.OrdAppBtUseDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.s.ems.meta.DefaultCreateParam;
import iih.ci.ord.s.ems.meta.ObjectList;
import iih.ci.ord.s.ems.meta.OrderPackageInfo;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 默认用血医嘱创建逻辑
 * @author wangqingzhu
 *
 */
public class DefaultApBuCreateOrderInfo extends DefaultSetCreateOrderInfo {
	

	@Override
	public OrderPackageInfo[] createOrderPakageInfo(CiEnContextDTO ctx, DefaultCreateParam[] szParam) 
			throws BizException {
		// TODO Auto-generated method stub
		OrderPackageInfo[] szOrderPakageInfo = super.createOrderPakageInfo(ctx, szParam);
		// 放回用血申请单信息
		for (OrderPackageInfo info : szOrderPakageInfo) {
			ObjectList list = new ObjectList();
			list.add(creatOrdBuInfo(ctx));
			info.setOrderAppSheetList(list);
		}
		return szOrderPakageInfo;
	}

	public OrdAppBtUseDO creatOrdBuInfo(CiEnContextDTO ctx) {
		OrdAppBtUseDO ordbu = new OrdAppBtUseDO();
//		ordbu.setId_or();
//		ordbu.setDt_bu_plan();
//		ordbu.setNo_applyform();
//		ordbu.setOperationroom();
//		ordbu.setOperationroomtel();
//		ordbu.setApplydoctortel();
		ordbu.setFg_prn(FBoolean.FALSE);
		ordbu.setCnt_prn(0);
		return ordbu;
	}
}
