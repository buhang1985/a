package iih.ci.ord.s.bp.validate.skintest.sign;

import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.OrderOperateDTO;
import iih.ci.ord.i.meta.OrderRstDTO;
import iih.ci.ord.s.ems.log.OrdBizLogger;
import iih.ci.ord.s.ems.op.order.OrderSignBP;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap2;
/**
 * 皮试医嘱签署
 * @author zhangwq
 *
 */
public class SkinOrderSignBP {
	public OrderRstDTO exec(CiEnContextDTO ciEnContextDTO,String id_or) throws BizException{
		OrderOperateDTO orderoperatedto = new OrderOperateDTO();
		FArrayList document =new FArrayList();
		document.add(0, id_or);
		orderoperatedto.setDocument(document);
		FMap2 extension =new FMap2();
		orderoperatedto.setExtension(extension);
		//签署
		OrderSignBP sign =new OrderSignBP();
		return sign.sign(ciEnContextDTO, orderoperatedto);
	}
}
