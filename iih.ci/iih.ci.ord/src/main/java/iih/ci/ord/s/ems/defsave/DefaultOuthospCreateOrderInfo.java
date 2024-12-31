package iih.ci.ord.s.ems.defsave;

import iih.ci.ord.cior.d.OrdApOutDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.s.ems.meta.DefaultCreateParam;
import iih.ci.ord.s.ems.meta.ObjectList;
import iih.ci.ord.s.ems.meta.OrderPackageInfo;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;

public class DefaultOuthospCreateOrderInfo extends DefaultSingleSrvCreateOrderInfo {
	@Override
	public OrderPackageInfo[] createOrderPakageInfo(CiEnContextDTO ctx, DefaultCreateParam[] szParam) throws BizException {
		// TODO Auto-generated method stub
		OrderPackageInfo[] szOrderPakageInfo = super.createOrderPakageInfo(ctx, szParam);
		for(OrderPackageInfo info : szOrderPakageInfo){
			ObjectList agglist = new ObjectList();
			agglist.add(assembleOrdApOutDOInfo());
			info.setOrderAppSheetList(agglist);
		}
		return szOrderPakageInfo;
	}
	
	private OrdApOutDO assembleOrdApOutDOInfo(){
		OrdApOutDO ordApOutDO =new OrdApOutDO();
		ordApOutDO.setStatus(DOStatus.NEW);
		return ordApOutDO;
	}
}
