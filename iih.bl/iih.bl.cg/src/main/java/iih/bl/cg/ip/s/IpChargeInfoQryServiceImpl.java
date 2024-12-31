package iih.bl.cg.ip.s;

import iih.bl.cg.blcgquery.d.BlCgIpDO;
import iih.bl.cg.ip.i.IIpChargeInfoQryService;
import iih.bl.cg.ip.s.bp.IpChargeInfoDetailBp;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;

/**
 * 住院记账信息查询接口，各种维度信息查询方法集合
 * @author yangyang
 */
@Service(serviceInterfaces = { IIpChargeInfoQryService.class }, binding = Binding.JSONRPC)
public class IpChargeInfoQryServiceImpl implements IIpChargeInfoQryService {


	/** 查询接口
	 * @param strIdEnt 就诊主键
	 * @return
	 * @throws BizException
	 */
	@Override
	public BlCgIpDO[] getIpCgDoInfo(String strIdEnt) throws BizException {
		IpChargeInfoDetailBp handlerBp=new IpChargeInfoDetailBp();
		return handlerBp.exec(strIdEnt);
	}

}
