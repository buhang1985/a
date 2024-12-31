package iih.ci.ord.s.ems.op.base;

import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.meta.BdSrvInfoList;
import iih.ci.ord.s.ems.meta.OrderPackageInfo;
import iih.ci.ord.s.ems.meta.OrderSrvMmList;
import iih.ci.ord.s.ems.utils.BdSrvInfoUtils;
import xap.mw.core.data.BizException;

/**
 * 非药品服务基类
 * @author wangqingzhu
 *
 */
public class EmsSingleSaveBP extends OpBaseEmsSaveBP {
	@Override
	protected BdSrvInfoList bdSrvInfoListFrom(CiOrderDO orderInfo, OrderSrvMmList ordSrvMmInfoList)
			throws BizException {
		
			MedSrvDO[] szMedSrvInfo = BdSrvInfoUtils.QueryBdSrvInfo(new String[]{orderInfo.getId_srv()});
			return (new BdSrvInfoList(szMedSrvInfo));
		
	}

	@Override
	protected OrderPackageInfo[] mergeOrderPakageInfo(CiEnContextDTO ctx, OrderPackageInfo[] szOrderPakageInfo)
			throws BizException {
		// TODO Auto-generated method stub
		OrderPackageInfo[] szOrderPackageInfo = super.mergeOrderPakageInfo(ctx, szOrderPakageInfo);
		
		for (OrderPackageInfo pInfo : szOrderPakageInfo) {
			//合并申请单信息
			if (!CiOrdUtils.isEmpty(pInfo.getOrderAppSheetList())){
				mergeOrderAppInfo(ctx,pInfo.getOrderAppSheetList().asArray(),pInfo.getExtInfoList().asArray(), pInfo.getUiModel());
			}
		}
		
		return szOrderPackageInfo;
	}

	
	
}
