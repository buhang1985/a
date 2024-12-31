package iih.ci.ord.s.external.thirdws.base;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.i.external.thirdws.base.EmsCommonOrdDTO;
import iih.ci.ord.i.external.thirdws.base.EmsRstDTO;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;

public interface IEmsAssemble {
	/**
	 * 组装医嘱
	 * @param srvdto
	 * @return
	 */
	CiOrderDO assembleOrder(EmsCommonOrdDTO orddto) throws BizException;
	/**
	 * 组装服务
	 * @param srvdto
	 * @return
	 */
	OrdSrvDO assembleSrv(BaseDTO srvdto) throws BizException;
}
