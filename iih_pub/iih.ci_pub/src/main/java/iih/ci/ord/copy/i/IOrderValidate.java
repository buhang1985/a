package iih.ci.ord.copy.i;

import java.util.List;

import iih.ci.ord.copy.dto.OrderCopyDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.OrderRstDTO;

/**
 * 医嘱复制后的校验接口
 * @author zhangwq
 *
 */
public interface IOrderValidate {
	OrderRstDTO validate(CiEnContextDTO ctx,List<OrderCopyDTO> orderCopyDtos);
}
