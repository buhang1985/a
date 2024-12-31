package iih.ci.event.ord.bps.refund.logicbp;

import java.util.ArrayList;
import java.util.List;

import iih.bl.cg.dto.d.OpRefund4IpEsDTO;
import iih.ci.event.ord.bps.refund.logicbp.common.OpRefundCommonLogicDealWithBP;
import iih.ci.event.ord.bps.refund.query.OpTreatRefundEntInfoQuery;
import iih.ci.event.ord.bps.refund.query.OpTreatRefundOrdInfoQuery;
import iih.ci.event.ord.utils.OrdEventUtil;
import iih.ci.ord.iemsg.d.IEOpTreatFeeDTO;
import iih.ci.ord.iemsg.d.IEOpTreatOrDTO;
import iih.ci.ord.iemsg.d.IEOpTreatOrEnDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;
/**
 * 门诊诊疗退费逻辑处理BS303
 * @author F
 *
 * @date 2019年9月18日下午5:40:31
 *
 * @classpath iih.ci.event.ord.bps.refund.logicbp.OpTreatRefundLogicDealWithBP
 */
public class OpTreatRefundLogicDealWithBP extends OpRefundCommonLogicDealWithBP{

	/**
	 * 生成集成平台治疗服务数据信息 （门诊）
	 * 该处理逻辑在退费时退哪个医嘱就发哪条医嘱对应的消息，部分退也好还是全退也好，只要有退的就发，，分为A区（就诊），B区（未退费sd_su_bl=1），C区（本次退费sd_su_bl=2）
	 * 但签署和撤回时还是签署或者撤回哪条医嘱，就发哪条医嘱的信息，C区无数据
	 * @param id_ors 医嘱id串
	 * @return
	 * @throws BizException
	 */
	public IEOpTreatOrEnDTO[] exec(OpRefund4IpEsDTO[] refund4IpEsDTOs) throws BizException {
		//有效性校验
		if (OrdEventUtil.isEmpty(refund4IpEsDTOs))
			return null;
		String id_ors = getIdOrs(refund4IpEsDTOs);
		String id_orsrvs=getIdOrSrvs(refund4IpEsDTOs);
		//查询并获得就诊及确认数据信息
		IEOpTreatOrEnDTO[] rtn = getIEOpTreatOrEnDTOs(id_ors,id_orsrvs);
		if (OrdEventUtil.isEmpty(rtn))
			return null;
		//查询医嘱信息
		IEOpTreatOrDTO[] orDTOs=getIEOpTreatOrDTOs(id_ors,id_orsrvs);
		//组合数据
		dealWithIEOpTreatOrDTOs(rtn,orDTOs);
		//将没有退费的医嘱信息去除掉
		rtn=filterDatas(rtn);
		//返回
		return rtn;
	}
	/**
	 * 过滤
	 * @param rtn
	 * @return
	 * @throws BizException
	 */
	private IEOpTreatOrEnDTO[] filterDatas(IEOpTreatOrEnDTO[] rtn)throws BizException{
		if(OrdEventUtil.isEmpty(rtn)) {
			return null;	
		}
		List<IEOpTreatOrEnDTO> newList=new ArrayList<IEOpTreatOrEnDTO>();
		for(IEOpTreatOrEnDTO enDTO:rtn) {
			//查询到的数据都是从退费列表传进来的，都是没有退费或者没有退完的医嘱，若C区(本次退费区域)没有值，说明该医嘱就没有退费，
			//就过滤到该医嘱，只发退了的医嘱消息
			FArrayList2 refundList=enDTO.getIetreatfees();
			if(!OrdEventUtil.isEmpty(refundList)) {
				newList.add(enDTO);
			}
		}
		return newList.toArray(new IEOpTreatOrEnDTO[0] );
	}
	/**
	 * 获取子表医嘱集合
	 * @param id_ors
	 * @return
	 * @throws BizException
	 */
	private IEOpTreatOrDTO[] getIEOpTreatOrDTOs(String id_ors,String id_orsrvs)throws BizException{
		if(OrdEventUtil.isEmpty(id_ors)||OrdEventUtil.isEmpty(id_orsrvs)) {
			return null;
		}
		OpTreatRefundOrdInfoQuery qry1 = new OpTreatRefundOrdInfoQuery(id_ors,id_orsrvs);
		IEOpTreatOrDTO[] itms = (IEOpTreatOrDTO[]) AppFwUtil.getDORstWithDao(qry1, IEOpTreatOrDTO.class);
		return itms;
	}
	/**
	 * 组合主子表数据
	 * @param rtn
	 * @param orDTOs
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private void dealWithIEOpTreatOrDTOs(IEOpTreatOrEnDTO[] rtn,IEOpTreatOrDTO[] orDTOs)throws BizException{
		if(OrdEventUtil.isEmpty(rtn)||OrdEventUtil.isEmpty(orDTOs)) {
			return;
		}
		for(IEOpTreatOrEnDTO enDTO:rtn) {
			//设置某些字段值
			setVale(enDTO);
			//1.设置未退费数据B区
			FArrayList2 unRefundList=new FArrayList2();
			for(IEOpTreatOrDTO ordDto:orDTOs) {
				if(!OrdEventUtil.isEmpty(enDTO)&&!OrdEventUtil.isEmpty(ordDto)&&!OrdEventUtil.isEmpty(enDTO.getId_or())&&!OrdEventUtil.isEmpty(ordDto.getId_or())
						&&enDTO.getId_or().equals(ordDto.getId_or())&&OrdEventUtil.PAYFLAG_C.equals(ordDto.getPayflag())) {
					unRefundList.add(ordDto);
				}
			}
			enDTO.setIetreators(unRefundList);
			//2.设置本次退费，c区
			FArrayList2 allChargeList=new FArrayList2();
			for(IEOpTreatOrDTO ordDto:orDTOs) {
				if(!OrdEventUtil.isEmpty(enDTO)&&!OrdEventUtil.isEmpty(ordDto)&&!OrdEventUtil.isEmpty(enDTO.getId_or())&&!OrdEventUtil.isEmpty(ordDto.getId_or())
						&&enDTO.getId_or().equals(ordDto.getId_or())&&OrdEventUtil.PAYFLAG_R.equals(ordDto.getPayflag())) {
					IEOpTreatFeeDTO newOrdDto=new IEOpTreatFeeDTO();
					newOrdDto.setPres_no(ordDto.getYz_no());//诊疗处方号===【与 门诊签署，门诊收费 消息中所属诊疗处方号保持一致】bug号：0192472
					newOrdDto.setPres_item_no(ordDto.getYz_no());//医嘱号
					newOrdDto.setOrderSeqnum(ordDto.getOrderseqnum());//医嘱序号
					allChargeList.add(newOrdDto);
				}
			}
			enDTO.setIetreatfees(allChargeList);
		}
	}
	/**
	 * 查询并获得就诊及确认数据信息
	 * 
	 * @param id_ors
	 * @return
	 * @throws BizException
	 */
	private IEOpTreatOrEnDTO[] getIEOpTreatOrEnDTOs(String id_ors,String id_orsrvs) throws BizException {
		if(OrdEventUtil.isEmpty(id_ors)||OrdEventUtil.isEmpty(id_orsrvs)) {
			return null;
		}
		OpTreatRefundEntInfoQuery qry = new OpTreatRefundEntInfoQuery(id_ors,id_orsrvs);
		IEOpTreatOrEnDTO[] rtn = (IEOpTreatOrEnDTO[]) AppFwUtil.getDORstWithDao(qry, IEOpTreatOrEnDTO.class);
		return rtn;
	}
	/**
	 * 设置值 子集按道理也是值 但此处只处理非集合的字段值
	 */
	private void setVale(IEOpTreatOrEnDTO enDTO) {
		if(OrdEventUtil.isEmpty(enDTO)) {
			return;
		}
		//设置就诊内的年龄
		if(!OrdEventUtil.isEmpty(enDTO.getBirthday())) {
			enDTO.setAge(AgeCalcUtil.getAge(enDTO.getBirthday()));
		}
		//就诊次数
		if(OrdEventUtil.isEmpty(enDTO.getAdmiss_times())) {
			enDTO.setAdmiss_times("0");
		}
		//就诊类别
		enDTO.setVisittype(getParamCodeEntp(enDTO.getVisittype()));
	}
	
}
