package iih.ci.ord.s.bp.order.check.tl;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.CiOrSufInfo4ScAptApplBp;
import iih.ci.ord.s.bp.CiOrderRisInfoToScAptApplBp;
import iih.ci.ord.s.bp.ems.save.ip.CiOrValidateBP;
import iih.ci.ord.s.bp.exception.CiOrOperatorCheckException;
import iih.ci.ord.s.bp.order.check.UpdateOrdStatusInfo1BP;
import iih.ci.ord.s.bp.validate.MethodConstants;
import iih.ci.ord.s.ems.biz.ip.mqmsg.CiOrderExecDepMQBP;
import iih.ci.ord.s.ems.log.OrdBizLogger;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

/**
 *  临床医嘱的核对操作BP
 */
public class CiOrderCheckBP {
	/**
	 * 临床医嘱的核对
	 * @param id_ors
	 * @param id_emp_second_chk 医嘱确认第二核对人
	 * @return
	 * @throws BizException
	 */
	public CiOrderDO[] exec(String[] id_ors,String id_emp_second_chk) throws BizException{
		//有效性校验
		if(CiOrdUtils.isEmpty(id_ors))return null;
		
		//获得医嘱聚集数据集合
		CiorderAggDO[] aggors = CiOrdAppUtils.getOrAggQryService().findByIds(
				id_ors, FBoolean.FALSE);
		OrdBizLogger.info(null, "医嘱确认：【"+id_ors[0]+"】,需要停止的医嘱集合数量:"+aggors.length);
		CiOrderDO[] ciors=getCiOrderDOs(aggors,id_emp_second_chk);
		CiOrValidateBP validate=new CiOrValidateBP();
		if(!validate.exec(aggors, MethodConstants.CHECK_VALIDATE)){
			throw new CiOrOperatorCheckException();
		}
		//医嘱状态调整为停止
		UpdateOrdStatusInfo1BP bp1=new UpdateOrdStatusInfo1BP();

		bp1.exec(ciors, null,null, ICiDictCodeConst.SD_SU_CHECKTHROUGH);
		String cfgParam = ParamsetQryUtil.getParaString(Context.get().getOrgId(), "CIOR0821");
		if("0".equals(cfgParam)){
			OrdBizLogger.info(null, "调用预约接口向预约发送手术申请数据");
			//调用预约接口向预约发送手术申请数据
			CiOrSufInfo4ScAptApplBp bp = new CiOrSufInfo4ScAptApplBp();
			bp.sendSugInfo4ScAptAppl(ciors);
			//调用接口向手术执行科室发送消息
			CiEnContextDTO ctx = (CiEnContextDTO) Context.get().getAttribute("CiEnContextDTO");
			CiOrderExecDepMQBP ordExecDepMQBP = new CiOrderExecDepMQBP();
			ordExecDepMQBP.broadcastOrderListViewMsg(ctx, ciors);
			//医技预约
			CiOrderRisInfoToScAptApplBp risScBp = new CiOrderRisInfoToScAptApplBp();
			risScBp.sendCiOrderRisInfoToScAptAppl(ciors,null);
		}
		if(ciors==null||ciors.length==0){
			OrdBizLogger.info(null, "医嘱确认发送手术申请后医嘱状态：数量0");
		}else{
			OrdBizLogger.info(null, "医嘱确认发送手术申请后医嘱状态：数量"+ciors.length+","+ciors[0].getStatus()+","+ciors[0].getId_or()+","+ciors[0].getFg_chk());
		}
		return ciors;
	}
	/**
	 * 获得医嘱主DO数组,并给赋值第二核对人
	 * @param aggors
	 * @param id_emp_second_chk 医嘱确认第二核对人
	 * @return
	 */
	private CiOrderDO[] getCiOrderDOs(CiorderAggDO[] aggors,String id_emp_second_chk){
		CiOrderDO[] rtns=new CiOrderDO[aggors.length];
		for(int i=0;i<aggors.length;i++){
			rtns[i]=aggors[i].getParentDO();
			rtns[i].setId_emp_second_chk(id_emp_second_chk);
		}
		return  rtns;
	}

}
