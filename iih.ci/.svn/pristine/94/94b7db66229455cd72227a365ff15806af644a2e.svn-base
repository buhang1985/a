package iih.ci.ord.s.bp.validate.skintest;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.OrderOperateDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.order.sign.tl.CiOrderSignBP;
import iih.ci.ord.s.bp.validate.skintest.ip.IpSaveDrugSkinBP;
import iih.ci.ord.s.bp.validate.skintest.ip.IpSaveTreatSkinBP;
import xap.mw.core.data.BizException;
/**
 * 住院皮试签署
 * @author F
 *
 * @date 2019年12月17日上午10:46:44
 *
 * @classpath iih.ci.ord.s.bp.validate.skintest.IpSkinTestOrSignBP
 */
public class IpSkinTestOrSignBP extends OpSkinTestOrSignBP{
	
	@Override
	public void skinSign(CiEnContextDTO ciEnContextDTO,CiOrderDO skinOrder)throws BizException{
		if (skinOrder != null && !CiOrdUtils.isEmpty(skinOrder.getId_or())) {
			CiOrderSignBP signBP = new CiOrderSignBP();
			String[] idStrings=new String[]{skinOrder.getId_or()};
			signBP.execSimple(idStrings,ciEnContextDTO,false,new OrderOperateDTO());
		}
	}

	@Override
	protected SaveDrugSkinBP getSaveDrugBP() {
		return new IpSaveDrugSkinBP();
	}

	@Override
	protected SaveTreatSkinBP getSaveTreatBP() {
		return new IpSaveTreatSkinBP();
	}
	
}
