package iih.bl.prop.s;

import iih.bl.prop.i.IBlPropQryService;
import iih.bl.prop.s.bp.GetIpHpPropDataBp;
import iih.bl.prop.s.bp.GetOepHpPropAggDOBP;
import iih.bl.prop.s.bp.GetPropArIdHpBP;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap2;
import xap.mw.core.service.constant.Binding;

/**
 * 分摊查询服务
 * @author yankan
 * @since 2017-06-15
 *
 */
@Service(serviceInterfaces={IBlPropQryService.class}, binding=Binding.JSONRPC)
public class BlPropQryServiceImpl  implements IBlPropQryService{

	/**
	 * 根据门诊结算id获取医保结算分摊数据
	 * 
	 * @author liwq
	 *
	 */
	public FMap2 getOepHpPropAggDo(String id_stoep) throws BizException {
		GetOepHpPropAggDOBP propBp =  new GetOepHpPropAggDOBP();
		return propBp.exec(id_stoep);
	}
	
	/**
	 * 根据门诊结算id获取医保结算Id_hp
	 * 
	 * @author czl
	 *
	 */
	@Override
	public String getOepHpPropArIdHp(String id_stoep) throws BizException {
		// TODO Auto-generated method stub
		GetPropArIdHpBP bp=new GetPropArIdHpBP();
		return bp.exec(id_stoep);
	}
	
	/**
	 * 获取住院分摊数据
	 * @author yangyang
	 *
	 */
	public FMap2 getIpHpPropAggDo(String strIdStIp) throws BizException{
		GetIpHpPropDataBp handlerBp=new GetIpHpPropDataBp();
		return handlerBp.exec(strIdStIp);
	}
}
