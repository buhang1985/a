package iih.ci.event.ord.bps.charge.op.logicbp;

import iih.ci.event.ord.bps.charge.op.query.OpTreatChargeEntInfoQuery;
import iih.ci.event.ord.bps.charge.op.query.OpTreatChargeOrdItemInfoQuery;
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
 * 门诊收费治疗BS303处理逻辑
 * @author F
 *
 * @date 2019年9月12日下午6:30:39
 *
 * @classpath iih.ci.event.ord.bps.charge.op.logicbp.OpTreatChargeLogicDealWithBP
 */
public class OpTreatChargeLogicDealWithBP extends CommonParamBP{

	/**
	 * 生成集成平台治疗服务数据信息 （门诊）
	 * 
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
		if (OrdEventUtil.isEmpty(rtn))
			return null;
		setValue(rtn);
		//查询并设置确认数据对应的  治疗医嘱数据信息集合
		IEOpTreatOrEnDTO[] trns = HandleCiTreatOpOrCItms4Confirm(firedto.getIdors(), rtn[0]);

		//返回
		return trns;
	}
	/**
	 * 设置值
	 * @param rtn
	 */
	private void setValue(IEOpTreatOrEnDTO[] rtn) {
		if(OrdEventUtil.isEmpty(rtn)) {
			return;
		}
		//年龄
		if(!OrdEventUtil.isEmpty(rtn[0].getBirthday())) {
			rtn[0].setAge(AgeCalcUtil.getAge(rtn[0].getBirthday()));
		}
		//就诊类别
		rtn[0].setVisittype(getParamCodeEntp(rtn[0].getVisittype()));
		//就诊次数
		if(OrdEventUtil.isEmpty(rtn[0].getAdmiss_times())) {
			rtn[0].setAdmiss_times("0");
		}
	}
	/**
	 * 查询并设置确认数据对应的 治疗医嘱数据信息集合
	 * 
	 * @param id_ors
	 * @param rtn
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private IEOpTreatOrEnDTO[] HandleCiTreatOpOrCItms4Confirm(String id_ors, IEOpTreatOrEnDTO rtn) throws BizException {
		OpTreatChargeOrdItemInfoQuery qry1 = new OpTreatChargeOrdItemInfoQuery(id_ors);
		IEOpTreatOrDTO[] itms = (IEOpTreatOrDTO[]) AppFwUtil.getDORstWithDao(qry1, IEOpTreatOrDTO.class);
		if (OrdEventUtil.isEmpty(itms))
			return null;

		IEOpTreatOrEnDTO[] endtos = new IEOpTreatOrEnDTO[itms.length];
		int i = 0;
		for (IEOpTreatOrDTO ieOpTreatOrDTO : itms) {
			IEOpTreatOrEnDTO endto = new IEOpTreatOrEnDTO();
			TreatOrEnDTOCopy(rtn, endto);
			FArrayList2 fa = new FArrayList2();
			fa.add(ieOpTreatOrDTO);
			endto.setIetreators(fa);
			endtos[i] = endto;
			i++;
		}
		return endtos;
	}

	/**
	 * 查询并获得就诊及确认数据信息
	 * 
	 * @param id_ors
	 * @return
	 * @throws BizException
	 */
	private IEOpTreatOrEnDTO[] getIEOpTreatOrEnDTOs(String id_ors) throws BizException {
		OpTreatChargeEntInfoQuery qry = new OpTreatChargeEntInfoQuery(getIdOr(id_ors));
		IEOpTreatOrEnDTO[] rtn = (IEOpTreatOrEnDTO[]) AppFwUtil.getDORstWithDao(qry, IEOpTreatOrEnDTO.class);
		return rtn;
	}

	/**
	 * 获得一个医嘱id
	 * 
	 * @param id_ors
	 * @return
	 */
	private String getIdOr(String id_ors) {
		return (id_ors.split(OrdEventUtil.COMMA_STR))[0];
	}

	private void TreatOrEnDTOCopy(IEOpTreatOrEnDTO treatendto, IEOpTreatOrEnDTO copytreatendto) {

		copytreatendto.setId_ietreatoren(treatendto.getId_ietreatoren());
		copytreatendto.setIetreatfees(treatendto.getIetreatfees());
		copytreatendto.setPatient_id(treatendto.getPatient_id());
		copytreatendto.setP_bar_code(treatendto.getP_bar_code());
		copytreatendto.setAdmiss_times(treatendto.getAdmiss_times());
		copytreatendto.setName(treatendto.getName());
		copytreatendto.setSex(treatendto.getSex());
		copytreatendto.setAge(treatendto.getAge());
		copytreatendto.setBirthday(treatendto.getBirthday());
		copytreatendto.setApply_unit(treatendto.getApply_unit());
		copytreatendto.setApply_unit_name(treatendto.getApply_unit_name());
		copytreatendto.setWard_code(treatendto.getWard_code());
		copytreatendto.setWard_code_name(treatendto.getWard_code_name());
		copytreatendto.setBed_no(treatendto.getBed_no());
		copytreatendto.setConfrim_date(treatendto.getConfrim_date());
		copytreatendto.setConfirm_opera(treatendto.getConfirm_opera());
		copytreatendto.setConfrim_opera_name(treatendto.getConfrim_opera_name());
		copytreatendto.setDomain_id("01");
		copytreatendto.setVisitordno(treatendto.getVisitordno());//就诊流水号
		copytreatendto.setVisittype(treatendto.getVisittype());//就诊类型编码
		copytreatendto.setVisittypename(treatendto.getVisittypename());//就诊类型名称
		copytreatendto.setOrgcode(treatendto.getOrgcode());//机构编码
		copytreatendto.setOrgname(treatendto.getOrgname());//机构名称
		copytreatendto.setExec_sn(treatendto.getExec_sn());
		copytreatendto.setApply_code(treatendto.getApply_code());
	}

}
