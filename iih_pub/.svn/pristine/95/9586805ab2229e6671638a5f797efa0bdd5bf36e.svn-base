package iih.mp.nr.api.i;

import iih.mp.nr.api.d.PerformParam;
import iih.mp.nr.api.d.PlanParamDTO;
import xap.mw.core.data.BizException;

/**
 * 外部接口
 * 
 * @author xuxing_2017-05-10
 *
 */
public interface IExternalService {

	/**
	 * 通用医嘱执行状态更新(JavaBean)
	 * 
	 * @param params
	 * @return
	 * @throws BizException
	 */
	public abstract String updateOrdersPStatusByJavaBean(PerformParam[] params) throws BizException;

	/**
	 * 通用医嘱执行状态更新(Xml)
	 * 
	 * @param xmlParam
	 * @return
	 * @throws BizException
	 */
	public abstract String updateOrdersPStatusByXml(String msg_head, String xmlParam) throws BizException;

	/**
	 * 通用医嘱执行状态更新(DTO)
	 * 
	 * @param planParams
	 * @return
	 * @throws BizException
	 */
	public abstract String updateOrdersPStatusByDTO(PlanParamDTO[] planParams) throws BizException;

}
