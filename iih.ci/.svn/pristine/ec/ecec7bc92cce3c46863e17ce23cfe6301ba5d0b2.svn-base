package iih.ci.event.ord.bps.sign.ip.logicbp;

import iih.ci.event.ord.bps.sign.ip.query.IpDrugSignHerbElementInfoQuery;
import iih.ci.event.ord.utils.OrdEventUtil;
import iih.ci.ord.iemsg.d.IEPharmOrMmDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;
/**
 * 住院签署 用药 草药明细逻辑处理BS311
 * @author F
 *
 * @date 2019年8月29日下午5:05:01
 *
 * @classpath iih.ci.event.ord.bps.sign.ip.logicbp.IpDrugSignHerbElementLogicDealWithBP
 */
public class IpDrugSignHerbElementLogicDealWithBP {

	/**
	 * 生成集成平台草药医嘱物品数据信息
	 * @param id_ors  医嘱id串
	 * @return
	 * @throws BizException
	 */
	public IEPharmOrMmDTO[] exec(String id_ors) throws BizException{
		//有效性校验
		if(OrdEventUtil.isEmpty(id_ors))return null;
		
		//查询并获得返回值
		IpDrugSignHerbElementInfoQuery qry=new IpDrugSignHerbElementInfoQuery(id_ors);
		IEPharmOrMmDTO[] rtn = (IEPharmOrMmDTO[])AppFwUtil.getDORstWithDao(qry, IEPharmOrMmDTO.class);

		return rtn;
	}
}
