package iih.ci.ord.s.ems.op.ems.deforder;

import java.util.ArrayList;
import java.util.List;

import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.meta.BdSrvMmInfoList;
import iih.ci.ord.s.ems.meta.StringOrdSrvListMap;

/**
 * 默认治疗医嘱创建逻辑
 * @author wangqingzhu
 *
 */
public class DefaultTreatCreateOrderInfo extends DefaultSetCreateOrderInfo {


//	@Override
//	protected OrdSrvDO[] assembleOrderSrvList(CiEnContextDTO ctx, CiOrderDO orderInfo, BdSrvMmInfoList bdSrvMmInfoList)
//			throws BizException {
//		  
//		// TODO Auto-generated method stub
//		List<OrdSrvDO> listOrdSrvDO = new ArrayList<OrdSrvDO>();
//		// 非药品医嘱服务只有一个
//		MedSrvDO mainMedSrvInfo = bdSrvMmInfoList.get(0).getBdSrvInfo();
//
//		// 套逻辑处理
//		if (CiOrdUtils.isTrue(mainMedSrvInfo.getFg_set())) {
//			// 获取费用对照出来的医嘱服务项目
//			StringOrdSrvListMap tmpOrdSrvMap = this.getPriCalOrSrvInfo(ctx, new MedSrvDO[] { mainMedSrvInfo });
//			if (tmpOrdSrvMap != null && tmpOrdSrvMap.containsKey(mainMedSrvInfo.getId_srv())) {
//				listOrdSrvDO.addAll(tmpOrdSrvMap.get(mainMedSrvInfo.getId_srv()));
//			}
//			
//		} else {
//			OrdSrvDO[] szOrdSrvDO = super.assembleOrderSrvList(ctx, orderInfo, bdSrvMmInfoList);
//			if (!CiOrdUtils.isEmpty(szOrdSrvDO)) {
//				listOrdSrvDO.addAll(Arrays.asList(szOrdSrvDO));
//			}
//
//		}
//
//		return listOrdSrvDO.toArray(new OrdSrvDO[listOrdSrvDO.size()]);
//	}


	
}
