package iih.ci.ord.s.ems.defsave;

import iih.ci.ord.cior.d.OrdApTransDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.s.ems.meta.DefaultCreateParam;
import iih.ci.ord.s.ems.meta.ObjectList;
import iih.ci.ord.s.ems.meta.OrderPackageInfo;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;

public class DefaultTransDeptCreateOrderInfo extends DefaultSingleSrvCreateOrderInfo {
	@Override
	public OrderPackageInfo[] createOrderPakageInfo(CiEnContextDTO ctx, DefaultCreateParam[] szParam) throws BizException {
		// TODO Auto-generated method stub
		OrderPackageInfo[] szOrderPakageInfo = super.createOrderPakageInfo(ctx, szParam);
		for(OrderPackageInfo info : szOrderPakageInfo){
			ObjectList agglist = new ObjectList();
			agglist.add(assembleOrdApTansDOInfo(ctx));
			info.setOrderAppSheetList(agglist);
		}
		return szOrderPakageInfo;
	}
	
	private OrdApTransDO assembleOrdApTansDOInfo(CiEnContextDTO ctx){
		OrdApTransDO ordApTansDO =new OrdApTransDO();
		ordApTansDO.setId_dep_from(ctx.getId_dep_en());
		ordApTansDO.setId_dep_nur_from(ctx.getId_dep_ns());
		ordApTansDO.setStatus(DOStatus.NEW);
		return ordApTansDO;
	}
}
