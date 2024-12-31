package iih.ci.ord.s.bp.iemsg;

import iih.bd.base.utils.StringUtils;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.iemsg.d.IEOpTreatOrDTO;
import iih.ci.ord.iemsg.d.IEOpTreatOrEnDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.iemsg.qry.CiTreatIpOrCItmQry;
import iih.ci.ord.s.bp.iemsg.qry.CiTreatIpOrConfirmQry;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;

/**
 * BS303：诊疗处置信息服务</br>
 * 生成集成平台治疗服务数据信息操作BP （住院）
 * @author yangzhe
 */
public class GetIEIpMsgInfo4TreatBP {
	/**
	 * 生成集成平台治疗服务数据信息 （住院）
	 * 
	 * @param id_ors 医嘱id串
	 * @return
	 * @throws BizException
	 */
	public IEOpTreatOrEnDTO[] exec(String id_ors,FBoolean payFlag) throws BizException {
		//有效性校验
		if (CiOrdUtils.isEmpty(id_ors))
			return null;

		//查询并获得就诊及确认数据信息
		IEOpTreatOrEnDTO[] rtn = getIEOpTreatOrEnDTOs(id_ors);
		if (CiOrdUtils.isEmpty(rtn))
			return null;
		//计算年龄
		rtn[0].setAge(AgeCalcUtil.getAge(rtn[0].getBirthday()));
		//查询并设置确认数据对应的  治疗医嘱数据信息集合
		IEOpTreatOrEnDTO[] trns = HandleCiTreatOpOrCItms4Confirm(id_ors, rtn[0],payFlag);

		//返回
		return trns;
	}

	/**
	 * 查询并设置确认数据对应的 治疗医嘱数据信息集合
	 * 
	 * @param id_ors
	 * @param rtn
	 * @throws BizException
	 */
	private IEOpTreatOrEnDTO[] HandleCiTreatOpOrCItms4Confirm(String id_ors, IEOpTreatOrEnDTO rtn, FBoolean payFlag) throws BizException {
		CiTreatIpOrCItmQry qry1 = new CiTreatIpOrCItmQry(id_ors);
		IEOpTreatOrDTO[] itms = (IEOpTreatOrDTO[]) AppFwUtil.getDORstWithDao(qry1, IEOpTreatOrDTO.class);
		if (CiOrdUtils.isEmpty(itms))
			return null;

		IEOpTreatOrEnDTO[] endtos = new IEOpTreatOrEnDTO[itms.length];
		int i = 0;
		for (IEOpTreatOrDTO ieOpTreatOrDTO : itms) {
			//收费状态标识
			String code_or = ieOpTreatOrDTO.getYz_no();
			if(StringUtils.isNotEmpty(code_or)) {
				OrdSrvDO[] ordSrvDOs;
				try {
					ordSrvDOs = GetPayFlagHelper.getOrdSrvDO(CiOrderDO.CODE_OR, code_or);
					if(!CiOrdUtils.isEmpty(ordSrvDOs)) {
						ieOpTreatOrDTO.setPayflag(ordSrvDOs[0].getSd_su_bl());
					}
				} catch (BizException e) {
					ieOpTreatOrDTO.setPayflag("");
					e.printStackTrace();
				}
			}
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
		CiTreatIpOrConfirmQry qry = new CiTreatIpOrConfirmQry(getIdOr(id_ors));
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
		return (id_ors.split(CiOrdUtils.COMMA_STR))[0];
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
		copytreatendto.setConfirm_opera(treatendto.getConfirm_opera());
		copytreatendto.setConfrim_opera_name(treatendto.getConfrim_opera_name());
		copytreatendto.setConfrim_date(treatendto.getConfrim_date());
		copytreatendto.setOrgcode(treatendto.getOrgcode());
		copytreatendto.setOrgname(treatendto.getOrgname());
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