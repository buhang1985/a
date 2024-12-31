package iih.bd.srv.s.bp;

import iih.bd.pp.dto.d.PriStdSrvDTO;
import iih.bd.pp.primd.i.IPriCalService;
import iih.ci.ord.srvpri.d.BdSrvPriCalParamDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDouble;

/**
 * 临床医嘱选择服务，服务价格计算操作BP基类
 */
public class BaseSrvPriceCalBP {
	/**
	 * 临床医嘱选择服务，服务价格计算
	 * @param id_srv  医疗服务id
	 * @param id_primd 付款策略
	 * @param num      套时，的个数定价 或个数加收的个数数量
	 * @param srvsetitms      套合计价时，套内项目信息 BdSrvPriCalParamDTO
	 * @return
	 * @throws BizException 
	 */
	public FDouble exec(BdSrvPriCalParamDTO param)  throws BizException{
		//有效性判断处理
		if(!validateCheck(param))return null;
		if(BdSrvUtils.isEmpty(param.getId_primd()))
		{
			param.setId_primd(BdAppUtils.getMedsrvMDORService().findById(param.getId_srv()).getId_primd());
		}
		String id_primd=param.getId_primd(),id_srv=param.getId_srv();
		Integer num=param.getNum();
		
		IPriCalService ipricalsrv=BdAppUtils.getPriCalService();
		if(BdSrvPriHelper.isSrvSelfPrimd(id_primd)){//本服务定价
			return ipricalsrv.CalSingleSrvStdPrice(id_srv);
		}else if(BdSrvPriHelper.isSrvsetMemberSumPrimd(id_primd)){//合计价
			//传入的主要参数应为 srvsetitms
			return getSrvSetSumPri(param);
		}else if(BdSrvPriHelper.isSrvsetMemCntAdditionalPrimd(id_primd)){//个数加收
			return getPriceSum(ipricalsrv.CalSrvSetMUPrices(id_srv, num));
		}else if(BdSrvPriHelper.isSrvsetMemberCntPrimd(id_primd)){//个数定价
			return getPriceSum(ipricalsrv.CalSrvSetFIXPrices(id_srv, num));
		}else if(BdSrvPriHelper.isSrvRelMmPrimd(id_primd)){//对应物品价格
			//return getPriceSum(ipricalsrv.CalSrvSetFIXPrices(id_srv, num));
			//调用对应药品价格计算接口
		}else if(BdSrvPriHelper.isSrvCompPrimd(id_primd)){//组合定价
			return getPriceSum(ipricalsrv.CalSrvCompPrice(id_srv));
		}else if(BdSrvPriHelper.isSrvFreePrimd(id_primd)){//不收费
			return new FDouble(0);
		}else if(BdSrvPriHelper.isSrvPluginPrimd(id_primd)){//外挂插件
		}
		
		return null;
		
	}
	
	/**
	 * 有效性校验
	 * @param id_srv
	 * @param id_primd
	 * @return
	 */
	private boolean validateCheck(BdSrvPriCalParamDTO param){
		if(BdSrvUtils.isEmpty(param))return false;
		if(BdSrvUtils.isEmpty(param.getId_srv()) || 
		   BdSrvUtils.isEmpty(param.getId_primd()))return false;
		return true;
	}
	
	/**
	 * 获得总价
	 * @param pridtos
	 * @return
	 */
	private FDouble getPriceSum(PriStdSrvDTO[] pridtos){
		return BdSrvPriHelper.getPriceSum(pridtos);
	}
	
	/**
	 * 获得套合计价模式总价
	 * @param param
	 * @return
	 * @throws BizException
	 */
	private FDouble getSrvSetSumPri(BdSrvPriCalParamDTO param) throws BizException{
		BdSrvSetSumPriMdCalBP bp=new BdSrvSetSumPriMdCalBP();
		return bp.exec(param);
	}
}
