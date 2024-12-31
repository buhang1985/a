package iih.ci.event.ord.bps.sign.op.logicbp;

import iih.ci.event.ord.bps.sign.op.query.OpBuSignEntAndOrdInfoQuery;
import iih.ci.event.ord.bps.zcommon.parambp.CommonParamBP;
import iih.ci.event.ord.utils.OrdEventFireDTO;
import iih.ci.event.ord.utils.OrdEventUtil;
import iih.ci.ord.iemsg.d.IEOpBtUseOrDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;
/**
 * 门诊签署 用血逻辑处理BS309
 * @author F
 *
 * @date 2019年8月27日下午3:48:16
 *
 * @classpath iih.ci.event.ord.bps.sign.op.logicbp.OpBuSignLogicDealWithBP
 */
public class OpBuSignLogicDealWithBP extends CommonParamBP{

	/**
	 * 生成集成平台用血服务数据信息
	 * （门诊）
	 * @param id_ors  医嘱id串
	 * @return
	 * @throws BizException
	 */
	public IEOpBtUseOrDTO[] exec(OrdEventFireDTO firedto) throws BizException{
		//有效性校验
		if(OrdEventUtil.isEmpty(firedto.getIdors()))return null;
		//查询并获得返回值
		OpBuSignEntAndOrdInfoQuery qry=new OpBuSignEntAndOrdInfoQuery(firedto.getIdors());
		IEOpBtUseOrDTO[] rtn = (IEOpBtUseOrDTO[])AppFwUtil.getDORstWithDao(qry, IEOpBtUseOrDTO.class);
		if(!OrdEventUtil.isEmpty(rtn)) {
			for(IEOpBtUseOrDTO ieOpBtUseOrDTO:rtn) {
				//设置值
				setValue(ieOpBtUseOrDTO);
			}
		}
		return rtn;
	}
	/**
	 * 设置值
	 * @param ieOpBtUseOrDTO
	 */
	private void setValue(IEOpBtUseOrDTO ieOpBtUseOrDTO) {
		if(OrdEventUtil.isEmpty(ieOpBtUseOrDTO)) {
			return;
		}
		//就诊次数
		if(OrdEventUtil.isEmpty(ieOpBtUseOrDTO.getTimes())) {
			ieOpBtUseOrDTO.setTimes("0");
		}
		//就诊类别
		ieOpBtUseOrDTO.setVisit_type(getParamCodeEntp(ieOpBtUseOrDTO.getVisit_type()));
	}
}
