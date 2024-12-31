package iih.bl.prop.s;

import org.apache.commons.lang.ArrayUtils;

import iih.bd.base.utils.AppUtils;
import iih.bl.prop.blproparip.d.BlproparipAggDO;
import iih.bl.prop.blproparip.i.IBlproparipCudService;
import iih.bl.prop.blpropip.d.BlPropIpDO;
import iih.bl.prop.blpropip.i.IBlpropipCudService;
import iih.bl.prop.i.IBlPropCmdService;
import iih.mi.biz.dto.d.HisPropertyRefHpDTO;
import iih.mi.biz.dto.d.InpPayRtnValDTO;
import iih.mi.itf.context.InsureContext;
import iih.mi.itf.facade.InsureFacade;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap2;
import xap.mw.core.service.constant.Binding;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 分摊命令服务
 * @author yankan
 * @since 2017-06-15
 *
 */
@Service(serviceInterfaces={IBlPropCmdService.class}, binding=Binding.JSONRPC)
public class BlPropCmdServiceImpl implements IBlPropCmdService	{

	/**
	 * 保存住院分摊数据Bl_prop_ip和 分摊Agg
	 * @param ipPropDO
	 * @param ipPropArAggDO
	 * @throws BizException
	 */
	public FMap2 saveIpPropData(BlPropIpDO ipPropDO,BlproparipAggDO ipPropArAggDO) throws BizException {
		ipPropDO.setDt_prop(AppUtils.getServerDateTime());
		//1. 保存分摊结算关系表
		IBlpropipCudService ipPropService = ServiceFinder.find(IBlpropipCudService.class);
		BlPropIpDO[] rtnIpPropDOs =ipPropService.save(new BlPropIpDO[]{ ipPropDO });
		if(ArrayUtils.isEmpty(rtnIpPropDOs)) {
			throw new BizException("医保结算付款时，分摊结算关系表信息保存失败！");
		}
		//2. 保存分摊数据主子表
		IBlproparipCudService ipPropArService = ServiceFinder.find(IBlproparipCudService.class);
		ipPropArAggDO.getParentDO().setId_propip(rtnIpPropDOs[0].getId_propip());
		BlproparipAggDO[] rtnIpPropArAggDOs = ipPropArService.save(new BlproparipAggDO[]{ ipPropArAggDO });
		if(ArrayUtils.isEmpty(rtnIpPropArAggDOs)) {
			throw new BizException("医保结算付款时，分摊结算关系表信息保存失败！");
		}		
		FMap2 map=new FMap2();
		map.put("propip", rtnIpPropDOs);
		map.put("proparip", rtnIpPropArAggDOs);
		return map;
	}
}
