package iih.ci.event.ord.bps.sign.ip.logicbp;

import iih.ci.event.ord.bps.sign.ip.query.IpBuSignEntAndOrdInfoQuery;
import iih.ci.event.ord.bps.zcommon.parambp.CommonParamBP;
import iih.ci.event.ord.utils.OrdEventFireDTO;
import iih.ci.event.ord.utils.OrdEventUtil;
import iih.ci.ord.iemsg.d.IEOpBtUseOrDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;

/**
 * 住院签署 用血逻辑处理BS309
 * @author F
 *
 * @date 2019年8月28日下午1:38:15
 *
 * @classpath iih.ci.event.ord.bps.sign.ip.logicbp.IpBuSignLogicDealWithBP
 */
public class IpBuSignLogicDealWithBP extends CommonParamBP{

	/**
	 * 生成集成平台用血服务数据信息
	 * （住院）
	 * @param id_ors  医嘱id串
	 * @return
	 * @throws BizException
	 */
	public IEOpBtUseOrDTO[] exec(OrdEventFireDTO firedto) throws BizException{
		//有效性校验
		if(OrdEventUtil.isEmpty(firedto.getIdors()))return null;
		//查询并获得返回值
		IpBuSignEntAndOrdInfoQuery qry=new IpBuSignEntAndOrdInfoQuery(firedto.getIdors());
		IEOpBtUseOrDTO[] rtn = (IEOpBtUseOrDTO[])AppFwUtil.getDORstWithDao(qry, IEOpBtUseOrDTO.class);
		//设置值
		setValue(rtn);
		return rtn;
	}
	/**
	 * 设置值
	 * @param rtn
	 */
	private void setValue(IEOpBtUseOrDTO[] rtn) {
		if (OrdEventUtil.isEmpty(rtn))return;
		for (IEOpBtUseOrDTO ieOpBtUseOrDTO : rtn) {
			//年龄
			if(!OrdEventUtil.isEmpty(ieOpBtUseOrDTO.getBrithday())) {
				ieOpBtUseOrDTO.setAge(AgeCalcUtil.getAge(ieOpBtUseOrDTO.getBrithday()));
			}
			//就诊次数
			if(OrdEventUtil.isEmpty(ieOpBtUseOrDTO.getTimes())) {
				ieOpBtUseOrDTO.setTimes("0");
			}
			//就诊类别
			ieOpBtUseOrDTO.setVisit_type(getParamCodeEntp(ieOpBtUseOrDTO.getVisit_type()));
		}
	}
}
