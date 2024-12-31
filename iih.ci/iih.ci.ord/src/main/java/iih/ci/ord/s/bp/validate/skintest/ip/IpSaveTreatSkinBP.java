package iih.ci.ord.s.bp.validate.skintest.ip;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.ICiOrdMaintainService;
import iih.ci.ord.s.bp.validate.skintest.SaveTreatSkinBP;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
/**
 * 诊疗皮试医嘱保存逻辑
 * @author zhangwq
 *
 */
public class IpSaveTreatSkinBP extends SaveTreatSkinBP{
	@Override
	public CiOrderDO[] saveOrder(CiEmsDTO skinems, CiEnContextDTO ciEnContextDTO) throws BizException {
		ICiOrdMaintainService ordMaintainService = ServiceFinder.find(ICiOrdMaintainService.class);
		CiOrderDO[] skinTestOrders = ordMaintainService.SaveCiEmsDTO_TL(skinems, ciEnContextDTO);
		return skinTestOrders;
	}
	
}
