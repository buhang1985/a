package iih.ci.ord.copy.i;

import java.util.List;

import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.OrderOperateDTO;
import iih.ci.ord.i.meta.OrderRstDTO;
import xap.mw.core.data.BizException;
/**
 * 医嘱复制接口
 * @author zhangwq
 *
 */
public interface IOrderCopy {
	public OrderRstDTO copy(CiEnContextDTO ctx,List<CiorderAggDO> ordAggs) throws BizException ;
	public OrderOperateDTO getOrderOperateDTO();
	public void setOrderOperateDTO(OrderOperateDTO orderOperateDTO);
}
