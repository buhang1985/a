package iih.ci.ord.s.ems.op.orderv1.bp;

import java.util.ArrayList;
import java.util.List;

import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.OrderOperateDTO;
import iih.ci.ord.i.meta.OrderRstDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.itf.bp.IOrderCopyBP;
import iih.ci.ord.s.ems.itf.bp.IOrderOperateBP;
import iih.ci.ord.s.ems.op.orderv1.bp.ope.OrderCopyOperateBP;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;

/**
 * 医嘱复制操作
 * 
 * @author Young
 *
 */
public class OrderCopyBP implements IOrderCopyBP {

	private IOrderOperateBP copyBP = new OrderCopyOperateBP();
	@Override
	public OrderRstDTO copy(CiEnContextDTO ctx, OrderOperateDTO arg) throws BizException {
		// TODO Auto-generated method stub
		FArrayList paramList = arg.getDocument();//获取医嘱ID集合
		if (paramList != null && paramList.size() > 0) {
			List<String> lstIdors = new ArrayList<String>();
			for (Object obj : paramList) {
				if (CiOrdUtils.isEmpty(obj))
					continue;
				lstIdors.add(obj.toString());
			}
			
			return copyBP.exec(lstIdors.toArray(new String[] {}),
					ctx, arg.getExtension());
		}
		
		OrderRstDTO rstDTO = new OrderRstDTO();
		rstDTO.setIsSuccess(FBoolean.FALSE);
		return rstDTO;
	}
	@Override
	public OrderRstDTO addExtra(CiEnContextDTO ctx, OrderOperateDTO arg) throws BizException {
		// TODO Auto-generated method stub
		FArrayList paramList = arg.getDocument();//获取医嘱ID集合
		if (paramList != null && paramList.size() > 0) {
			List<String> lstIdors = new ArrayList<String>();
			for (Object obj : paramList) {
				if (CiOrdUtils.isEmpty(obj))
					continue;
				lstIdors.add(obj.toString());
			}
			
			return copyBP.exec(lstIdors.toArray(new String[] {}),
					ctx, arg.getExtension());
		}
		
		OrderRstDTO rstDTO = new OrderRstDTO();
		rstDTO.setIsSuccess(FBoolean.FALSE);
		return rstDTO;
	}
}
