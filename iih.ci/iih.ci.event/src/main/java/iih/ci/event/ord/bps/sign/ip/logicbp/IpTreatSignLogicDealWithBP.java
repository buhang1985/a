package iih.ci.event.ord.bps.sign.ip.logicbp;

import iih.ci.event.ord.bps.sign.ip.query.IpTreatSignEntInfoQuery;
import iih.ci.event.ord.bps.sign.ip.query.IpTreatSignOrdInfoQuery;
import iih.ci.event.ord.bps.zcommon.parambp.CommonParamBP;
import iih.ci.event.ord.utils.OrdEventFireDTO;
import iih.ci.event.ord.utils.OrdEventUtil;
import iih.ci.ord.iemsg.d.IEOpTreatOrDTO;
import iih.ci.ord.iemsg.d.IEOpTreatOrEnDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;

/**
 * 住院签署 治疗逻辑处理BS303
 * @author F
 *
 * @date 2019年8月29日下午1:58:38
 *
 * @classpath iih.ci.event.ord.bps.sign.ip.logicbp.IpTreatSignLogicDealWithBP
 */
public class IpTreatSignLogicDealWithBP extends CommonParamBP{

	/**
	 * 生成集成平台治疗服务数据信息 （住院）
	 * 门诊医嘱集合ci_order加ci_or_srv信息，住院只查ci_order
	 * @param id_ors 医嘱id串
	 * @return
	 * @throws BizException
	 */
	public IEOpTreatOrEnDTO[] exec(OrdEventFireDTO firedto) throws BizException {
		//有效性校验
		if (OrdEventUtil.isEmpty(firedto.getIdors()))
			return null;

		//查询并获得就诊及确认数据信息
		IEOpTreatOrEnDTO[] rtn = getIEOpTreatOrEnDTOs(firedto.getIdors());
		//查询医嘱信息
		IEOpTreatOrDTO[] orDTOs=getIEOpTreatOrDTOs(firedto.getIdors());
		//组装数据
		rtn=assemableData(rtn,orDTOs);
		//返回
		return rtn;
	}

	/**
	 * 查询并获得就诊及确认数据信息
	 * 
	 * @param id_ors
	 * @return
	 * @throws BizException
	 */
	private IEOpTreatOrEnDTO[] getIEOpTreatOrEnDTOs(String id_ors) throws BizException {
		IpTreatSignEntInfoQuery qry = new IpTreatSignEntInfoQuery(id_ors);
		IEOpTreatOrEnDTO[] rtn = (IEOpTreatOrEnDTO[]) AppFwUtil.getDORstWithDao(qry, IEOpTreatOrEnDTO.class);
		return rtn;
	}
	
	/**
	 * 获取医嘱信息
	 * 
	 * @param id_ors
	 * @param rtn
	 * @throws BizException
	 */
	private IEOpTreatOrDTO[] getIEOpTreatOrDTOs(String id_ors) throws BizException {
		IpTreatSignOrdInfoQuery qry1 = new IpTreatSignOrdInfoQuery(id_ors);
		IEOpTreatOrDTO[] itms = (IEOpTreatOrDTO[]) AppFwUtil.getDORstWithDao(qry1, IEOpTreatOrDTO.class);
		return itms;
	}
	/**
	 * 组装就诊和医嘱信息数据
	 * @param rtn
	 * @param orDTOs
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private IEOpTreatOrEnDTO[] assemableData(IEOpTreatOrEnDTO[] rtn,IEOpTreatOrDTO[] orDTOs) throws BizException{
		if(OrdEventUtil.isEmpty(rtn)||OrdEventUtil.isEmpty(orDTOs)) {
			return null;
		}
		for(IEOpTreatOrEnDTO enDTO:rtn) {
			//设置值
			setVale(enDTO);
			//将医嘱数据赋给就诊
			FArrayList2 fArrayList2=new FArrayList2();
			for(IEOpTreatOrDTO orDTO:orDTOs) {
				if(!OrdEventUtil.isEmpty(enDTO.getId_or())&&!OrdEventUtil.isEmpty(orDTO.getId_or())&&
						enDTO.getId_or().equals(orDTO.getId_or())) {
					fArrayList2.add(orDTO);
				}
			}
			enDTO.setIetreators(fArrayList2);
		}
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
