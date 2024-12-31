package iih.bl.cg.service.i;

import iih.bl.cg.blcgquery.d.BlCgIpDO;
import iih.bl.cg.service.d.OperatorInfoDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
/**
 * 住院重划价接口
 * @author tcy 2016-01-19
 *
 */
public interface IBLCgIpRePricingService {
	/**
	 * 对指定的住院明细重划价
	 * @param blCgIpDOarr 需要重划价的住院明细信息
	 * @param id_ent 就诊ID
	 * @param operatorInfoDTO 执行重划价的操作人员信息
	 * @return 指定的住院明细重划价明细信息
	 * @throws BizException
	 */
	public abstract BlCgIpDO[] BlCgIpRePricing(BlCgIpDO[] blCgIpDOarr,String id_ent,OperatorInfoDTO operatorInfoDTO) throws BizException;
	/**
	 * 根据就诊ID，返回不属于物品的住院就诊明细
	 * @param id_ent
	 * @return 返回不属于物品的住院就诊明细
	 * @throws BizException
	 */
	public abstract BlCgIpDO[] GetPatBlCgIpWithoutMMByIdent(String id_ent)  throws BizException;

}
