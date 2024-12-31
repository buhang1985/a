package iih.bl.cg.ip.i;

import iih.bd.pp.priusg.d.PriUsgDO;
import iih.bl.cg.dto.d.BoilDesReferBillDTO;
import iih.bl.cg.dto.d.SrvBoilDesInfoDTO;
import xap.mw.core.data.BizException;

/**
 * 相关用法、煎法关联费用实现
 * @author yangyang
 * @Date 2017-10-10
 * @Note 该业务模块主要是处理用法、煎法关联费用相关业务，医嘱域从此接口获取各种用用法或煎法关联的费用信息
 */
public interface IUsageWithBillService {

	/** 用法关联费用策略使用
	 * @param strIdRoute
	 * @param StrIdOrg
	 * @param strIdDept
	 * @return
	 * @throws BizException
	 */
	PriUsgDO[] judgeUsageWithBillitm(String strIdRoute,String strIdOrg,String strIdDept) throws BizException;

	/**煎法要求关联费用
	 * @param srvBoildesDtoArr 煎法要求
	 * @return
	 * @throws BizException
	 */
	BoilDesReferBillDTO[] getBoilDesRefbill(SrvBoilDesInfoDTO[] srvBoildesDtoArr) throws BizException;
}
