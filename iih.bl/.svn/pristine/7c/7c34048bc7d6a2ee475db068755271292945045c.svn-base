package iih.bl.cg.bp;

import iih.bd.pp.incca.d.IncCaItmDO;
import iih.bd.pp.service.i.IBdInccaQueService;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.d.BlCgOepDO;
import iih.bl.cg.blcgoep.d.BlcgoepAggDO;
import iih.bl.cg.blcgoep.d.FeeOriginEnum;
import iih.bl.cg.blcgquery.d.BlCgIpDO;
import iih.bl.cg.blcgquery.d.BookRtnDirectEnum;
import iih.bl.cg.blorderappendbillparamdto.d.BlOrderAppendBillParamDTO;
import iih.bl.cg.service.d.BlOrderRefundBillParamDTO;
import iih.bl.comm.GetCodeByCustomization;
import iih.en.pv.entplan.d.EntHpDO;
import iih.en.pv.entplan.i.IEnthpRService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 通用补退费DTO与CG表的转换
 * 
 * @author tcy
 *
 */
public class GetBlCgDO {
	// FDouble acc_lock; //授权的预交金额
	/**
	 * 返回产生的住院记账信息
	 * 
	 * @param appendBillParamDTO
	 * @param strDateTime
	 * @return
	 */
	public BlCgIpDO GetBlCgIpDO(BlOrderAppendBillParamDTO appendBillParamDTO, String strDateTime) throws BizException {
		BlCgIpDO blCgIpDO = new BlCgIpDO();
		blCgIpDO.setCode_apply(appendBillParamDTO.getCode_apply());
		blCgIpDO.setFg_free(appendBillParamDTO.getFg_free());
		blCgIpDO.setId_grp(appendBillParamDTO.getId_grp());
		blCgIpDO.setId_org(appendBillParamDTO.getId_org());
		blCgIpDO.setId_pat(appendBillParamDTO.getId_pat());
		blCgIpDO.setId_ent(appendBillParamDTO.getId_ent());
		blCgIpDO.setId_enttp(appendBillParamDTO.getId_enttp());
		blCgIpDO.setCode_enttp(appendBillParamDTO.getCode_enttp());
		// 账单码
		if (appendBillParamDTO.getCode_inccaitm() == null || appendBillParamDTO.getName_inccaitm() == null) {
			IncCaItmDO incCaItmDO = getInccaitmCodeAndName(appendBillParamDTO.getCode_enttp(), appendBillParamDTO.getId_srv());
			if (incCaItmDO != null) {
				blCgIpDO.setName_inccaitm(incCaItmDO.getName());
				blCgIpDO.setCode_inccaitm(incCaItmDO.getCode());
			} else {
				throw new BizException("未查询到【" + appendBillParamDTO.getName_srv() + "】所对应的发票分类！");
			}
		} else {
			blCgIpDO.setName_inccaitm(appendBillParamDTO.getName_inccaitm());
			blCgIpDO.setCode_inccaitm(appendBillParamDTO.getCode_inccaitm());
		}
		blCgIpDO.setFg_additm(appendBillParamDTO.getFg_additm());// 是否补费标志
		blCgIpDO.setNote(appendBillParamDTO.getNote());
		// 兼容
		if (String.valueOf(appendBillParamDTO.getEu_direct()) == null || ("").equals(String.valueOf(appendBillParamDTO.getEu_direct()).trim())) {
			// blCgIpDO.setEu_direct(BookRtnDirectEnum.CHARGES);//记退费方向
			throw new BizException("请设置记、退费方向！");
		} else {
			blCgIpDO.setEu_direct(appendBillParamDTO.getEu_direct());// 记退费方向
		}
		blCgIpDO.setId_srvtp(appendBillParamDTO.getId_srvtp());
		blCgIpDO.setSd_srvtp(appendBillParamDTO.getSd_srvtp());
		blCgIpDO.setId_srvca(appendBillParamDTO.getId_srvca());
		blCgIpDO.setId_srv(appendBillParamDTO.getId_srv());
		blCgIpDO.setCode_srv(appendBillParamDTO.getCode_srv());
		blCgIpDO.setName_srv(appendBillParamDTO.getName_srv());
		blCgIpDO.setSrvu(appendBillParamDTO.getSrvu());
		blCgIpDO.setPrice(appendBillParamDTO.getPrice());
		blCgIpDO.setPrice_ratio(appendBillParamDTO.getPrice_ratio());
		blCgIpDO.setQuan(appendBillParamDTO.getQuan());
		blCgIpDO.setAmt(appendBillParamDTO.getAmt());
		blCgIpDO.setAmt_ratio(appendBillParamDTO.getAmt_ratio());
		if (appendBillParamDTO.getRatio_pripat() != null) {
			blCgIpDO.setRatio_pripat(appendBillParamDTO.getRatio_pripat());
		} else {
			blCgIpDO.setRatio_pripat(new FDouble(1));
		}
		blCgIpDO.setAmt_std(appendBillParamDTO.getAmt_std());
		IPativisitRService service = ServiceFinder.find(IPativisitRService.class);
		PatiVisitDO patiVisitDO = service.findById(appendBillParamDTO.getId_ent());
		if (appendBillParamDTO.getId_org_or() != null) {
			blCgIpDO.setId_org_or(appendBillParamDTO.getId_org_or());
		} else {
			blCgIpDO.setId_org_or(patiVisitDO.getId_org());
		}

		if (appendBillParamDTO.getId_dep_or() != null) {
			blCgIpDO.setId_dep_or(appendBillParamDTO.getId_dep_or());
		} else {
			blCgIpDO.setId_dep_or(patiVisitDO.getId_dep_phy());
		}

		if (appendBillParamDTO.getId_emp_or() != null) {
			blCgIpDO.setId_emp_or(appendBillParamDTO.getId_emp_or());
			;
		} else {
			blCgIpDO.setId_emp_or(patiVisitDO.getId_emp_phy());
		}

		if (appendBillParamDTO.getDt_or() != null) {
			blCgIpDO.setDt_or(appendBillParamDTO.getDt_or());
		} else {
			blCgIpDO.setDt_or(new FDateTime(strDateTime));
		}

		if (appendBillParamDTO.getInpBillDTO() != null && appendBillParamDTO.getInpBillDTO().getId_wg_or() != null) {
			blCgIpDO.setId_wg_or(appendBillParamDTO.getInpBillDTO().getId_wg_or());// 医疗组
		} else {
			blCgIpDO.setId_wg_or(patiVisitDO.getId_wg_phy());
		}

		if (appendBillParamDTO.getInpBillDTO() != null && appendBillParamDTO.getInpBillDTO().getId_dep_nur() != null) {
			blCgIpDO.setId_dep_nur(appendBillParamDTO.getInpBillDTO().getId_dep_nur());// 病区
		} else {
			blCgIpDO.setId_dep_nur(patiVisitDO.getId_dep_nur());
		}
		blCgIpDO.setId_org_mp(appendBillParamDTO.getId_org_mp());
		blCgIpDO.setId_dep_mp(appendBillParamDTO.getId_dep_mp());
		if (appendBillParamDTO.getId_dep_wh() != null) {
			blCgIpDO.setId_dep_wh(appendBillParamDTO.getId_dep_wh());
		} else {
			blCgIpDO.setId_dep_wh(patiVisitDO.getId_dep_phy());
		}
		if (null != appendBillParamDTO.getDt_srv()) // 服务发生时间
		{
			blCgIpDO.setDt_srv(appendBillParamDTO.getDt_srv());
		} else {
			blCgIpDO.setDt_srv(new FDateTime(strDateTime));
		}
		blCgIpDO.setId_pripat(appendBillParamDTO.getId_pripat());
		blCgIpDO.setAmt_pat(appendBillParamDTO.getAmt_pat());
		blCgIpDO.setId_hp(appendBillParamDTO.getId_hp());
		blCgIpDO.setRatio_hp(appendBillParamDTO.getRatio_hp());
		blCgIpDO.setAmt_hp(new FDouble(0));
		// if(appendBillParamDTO.getInpBillDTO()==null)
		// {
		// blCgIpDO.setFg_bb(FBoolean.FALSE);
		// blCgIpDO.setNo_bb(null);
		// }
		// else
		// {
		// blCgIpDO.setFg_bb(appendBillParamDTO.getInpBillDTO().getFg_bb());
		// blCgIpDO.setNo_bb(appendBillParamDTO.getInpBillDTO().getNo_bb());
		// }
		blCgIpDO.setFg_mm(appendBillParamDTO.getFg_mm());
		blCgIpDO.setId_mm(appendBillParamDTO.getId_mm());
		blCgIpDO.setId_mmtp(appendBillParamDTO.getId_mmtp());
		blCgIpDO.setSd_mmtp(appendBillParamDTO.getSd_mmtp());
		blCgIpDO.setCode_mm(appendBillParamDTO.getCode_mm());
		blCgIpDO.setOnlycode(appendBillParamDTO.getOnlycode());
		blCgIpDO.setName_mm(appendBillParamDTO.getName_mm());
		blCgIpDO.setCd_batch(appendBillParamDTO.getCd_batch());
		blCgIpDO.setPgku_base(appendBillParamDTO.getPgku_base());
		blCgIpDO.setPgku_cur(appendBillParamDTO.getPgku_cur());
		blCgIpDO.setFactor(appendBillParamDTO.getFactor());
		blCgIpDO.setQuan_base(appendBillParamDTO.getQuan_base());
		blCgIpDO.setId_or(appendBillParamDTO.getId_or());
		blCgIpDO.setId_orsrv(appendBillParamDTO.getId_orsrv());
		blCgIpDO.setId_or_pr(appendBillParamDTO.getId_or_pr());
		blCgIpDO.setId_or_pr_srv(appendBillParamDTO.getId_or_pr_srv());
		blCgIpDO.setId_pres(appendBillParamDTO.getId_pres());

		if (appendBillParamDTO.getInpBillDTO() == null) {
			blCgIpDO.setFg_pddisc(FBoolean.FALSE);
		} else {
			blCgIpDO.setFg_pddisc(appendBillParamDTO.getInpBillDTO().getFg_pddisc());
		}
		blCgIpDO.setFg_st(FBoolean.FALSE);
		blCgIpDO.setId_stip(null);
		blCgIpDO.setDt_st(null);
		if (appendBillParamDTO.getFg_hp() == null || ("").equals(String.valueOf(appendBillParamDTO.getFg_hp()).trim())) {
			blCgIpDO.setFg_hp(FBoolean.FALSE);
		} else {
			blCgIpDO.setFg_hp(appendBillParamDTO.getFg_hp());
		}
		blCgIpDO.setFg_susp(FBoolean.FALSE);
		blCgIpDO.setId_par(null);
		blCgIpDO.setCode_cg(null);
		blCgIpDO.setId_org_cg(appendBillParamDTO.getId_org_cg());
		blCgIpDO.setId_dep_cg(appendBillParamDTO.getId_dep_cg());
		blCgIpDO.setId_emp_cg(appendBillParamDTO.getId_emp_cg());
		blCgIpDO.setDt_cg(appendBillParamDTO.getDt_cg() == null ? new FDateTime(strDateTime) : appendBillParamDTO.getDt_cg());

		if (null == appendBillParamDTO.getEu_srctp()) {
			blCgIpDO.setEu_srctp(FeeOriginEnum.ORDERS_FEE);// 医嘱产生
		} else {
			blCgIpDO.setEu_srctp(appendBillParamDTO.getEu_srctp());// 医嘱产生
		}
		blCgIpDO.setNote(null);

		blCgIpDO.setSrcfunc_des(appendBillParamDTO.getSrcfunc_des());
		blCgIpDO.setSpec(appendBillParamDTO.getSpec());
		blCgIpDO.setFg_refund(appendBillParamDTO.getFg_refund());// 已退款标志
		blCgIpDO.setId_par(appendBillParamDTO.getId_par());// 退费关联记账主键

		blCgIpDO.setStatus(DOStatus.NEW);
		return blCgIpDO;
	}

	/**
	 * 返回产生的住院记账信息数组
	 * 
	 * @param appendBillParamDTO
	 * @param strDateTime
	 * @return
	 */
	public BlCgIpDO[] GetBlCgIpDOs(BlOrderAppendBillParamDTO[] appendBillParamDTO, String strDateTime) throws BizException {

		List<BlCgIpDO> listBlCgIpDO = new ArrayList<BlCgIpDO>();
		for (int i = 0; i < appendBillParamDTO.length; i++) {
			BlCgIpDO blCgIpDO = new BlCgIpDO();
			blCgIpDO = GetBlCgIpDO(appendBillParamDTO[i], strDateTime);
			listBlCgIpDO.add(blCgIpDO);
		}
		return listBlCgIpDO.toArray(new BlCgIpDO[] {});
	}

	/**
	 * 返回产生的门急诊记账主表DO
	 * 
	 * @param appendBillParamDTO
	 * @return
	 * @throws BizException 
	 */
	public BlCgOepDO GetBlCgOepDO(BlOrderAppendBillParamDTO appendBillParamDTO, String strDateTime) throws BizException {
		BlCgOepDO blCgOepDO = new BlCgOepDO();

		blCgOepDO.setId_grp(appendBillParamDTO.getId_grp());
		blCgOepDO.setId_org(appendBillParamDTO.getId_org());
		blCgOepDO.setCode_cg(this.getCodeCg());// 记账单号
		blCgOepDO.setId_pat(appendBillParamDTO.getId_pat());

		if (String.valueOf(appendBillParamDTO.getEu_direct()) == null || ("").equals(String.valueOf(appendBillParamDTO.getEu_direct()).trim())) {
			blCgOepDO.setEu_direct(BookRtnDirectEnum.CHARGES);
		} else {
			blCgOepDO.setEu_direct(appendBillParamDTO.getEu_direct());
		}
		blCgOepDO.setDt_cg(new FDateTime(strDateTime));
		// 执行科室作为记帐机构
		blCgOepDO.setId_org_cg(appendBillParamDTO.getId_org_cg());
		blCgOepDO.setId_dep_cg(appendBillParamDTO.getId_dep_cg());
		blCgOepDO.setId_emp_cg(appendBillParamDTO.getId_emp_cg());

		if (appendBillParamDTO.getOutpBillDTO() == null) {
			blCgOepDO.setStatus(DOStatus.NEW);
		} else {
			// 来源于补费的数据
			if (appendBillParamDTO.getOutpBillDTO().getId_cgoep() != null) {
				blCgOepDO.setId_cgoep(appendBillParamDTO.getOutpBillDTO().getId_cgoep());
				blCgOepDO.setStatus(DOStatus.UPDATED);
			} else {
				blCgOepDO.setId_cgoep(null);
				blCgOepDO.setStatus(DOStatus.NEW);
			}
		}

		// blCgOepDO.setStatus(DOStatus.NEW);

		return blCgOepDO;
	}
	
	/**
	 * 获得记账码
	 * @return
	 * @throws BizException
	 */
	private String getCodeCg() throws BizException
	{
		GetCodeByCustomization code_ins=new GetCodeByCustomization();
	    return code_ins.GetCodeBlCgOep();
	}
	/**
	 * 返回产生的门急诊记账主表DO数组
	 * 
	 * @param appendBillParamDTO
	 * @return
	 */
	public BlCgOepDO[] GetBlCgOepDOs(BlOrderAppendBillParamDTO[] appendBillParamDTO, String strDateTime)  throws BizException{
		// BlCgOepDO blCgOepDO=new BlCgOepDO();
		List<BlCgOepDO> listBlCgOepDO = new ArrayList<BlCgOepDO>();
		for (int i = 0; i < appendBillParamDTO.length; i++) {
			BlCgOepDO blCgOepDO = new BlCgOepDO();
			blCgOepDO = GetBlCgOepDO(appendBillParamDTO[i], strDateTime);
			listBlCgOepDO.add(blCgOepDO);
		}
		return listBlCgOepDO.toArray(new BlCgOepDO[] {});
	}

	/**
	 * 返回产生的门急诊记账明细表DO
	 * 
	 * @param appendBillParamDTO
	 * @param strDateTime
	 *            记账日期
	 * @param fg_susp
	 *            挂起状态还是补费状态
	 * @return
	 * @throws BizException
	 */
	public BlCgItmOepDO GetBlCgItmOepDO(BlOrderAppendBillParamDTO appendBillParamDTO, String strDateTime, FBoolean fg_susp) throws BizException {
		BlCgItmOepDO blCgItmOepDO = new BlCgItmOepDO();
		blCgItmOepDO.setCode_apply(appendBillParamDTO.getCode_apply());
		blCgItmOepDO.setCode_applytp(appendBillParamDTO.getCode_applytp());
		blCgItmOepDO.setFg_free(appendBillParamDTO.getFg_free());
		blCgItmOepDO.setId_grp(appendBillParamDTO.getId_grp());
		blCgItmOepDO.setId_org(appendBillParamDTO.getId_org());
		blCgItmOepDO.setId_pat(appendBillParamDTO.getId_pat());
		blCgItmOepDO.setId_ent(appendBillParamDTO.getId_ent());
		blCgItmOepDO.setId_enttp(appendBillParamDTO.getId_enttp());
		blCgItmOepDO.setCode_enttp(appendBillParamDTO.getCode_enttp());
		// 账单码  ly 2018/12/20 没啥用
		/*if (appendBillParamDTO.getCode_inccaitm() == null || appendBillParamDTO.getName_inccaitm() == null) {
			IncCaItmDO incCaItmDO = getInccaitmCodeAndName(appendBillParamDTO.getCode_enttp(), appendBillParamDTO.getId_srv());
			if (incCaItmDO != null) {
				blCgItmOepDO.setName_inccaitm(incCaItmDO.getName());
				blCgItmOepDO.setCode_inccaitm(incCaItmDO.getCode());
			} else {
				throw new BizException("未查询到【" + appendBillParamDTO.getName_srv() + "】所对应的发票分类！");
			}
		} else {
			blCgItmOepDO.setName_inccaitm(appendBillParamDTO.getName_inccaitm());
			blCgItmOepDO.setCode_inccaitm(appendBillParamDTO.getCode_inccaitm());
		}*/
		blCgItmOepDO.setSd_abrd(appendBillParamDTO.getSd_abrd());
		if (appendBillParamDTO.getOutpBillDTO() != null && appendBillParamDTO.getOutpBillDTO().getFg_hpcg() != null) {
			blCgItmOepDO.setFg_hpcg(appendBillParamDTO.getOutpBillDTO().getFg_hpcg());
			if (FBoolean.TRUE.equals(blCgItmOepDO.getFg_hpcg())) {
				blCgItmOepDO.setAmt_acc(null);
			}
		} else {
			blCgItmOepDO.setFg_hpcg(FBoolean.FALSE);
		}
		// //只有药品有处方号
		// if(appendBillParamDTO.getFg_mm().booleanValue())
		// {
		// blCgItmOepDO.setId_pres(appendBillParamDTO.getId_pres());
		// }
		// else
		// {
		// blCgItmOepDO.setId_pres(null);//就诊产生（挂号）的数据没有id_pres
		// }
		// TODO modified by yangyang
		// 虽然只有药品有处方号，但是为了医保传递方便等因素，对于非药品项目，构造了一个处方，该虚构处方的Id_pres为服务对应医嘱的code_or
		blCgItmOepDO.setId_pres(appendBillParamDTO.getId_pres());
		blCgItmOepDO.setId_or(appendBillParamDTO.getId_or());
		blCgItmOepDO.setId_orsrv(appendBillParamDTO.getId_orsrv());
		blCgItmOepDO.setId_srvtp(appendBillParamDTO.getId_srvtp());
		blCgItmOepDO.setSd_srvtp(appendBillParamDTO.getSd_srvtp());
		blCgItmOepDO.setId_srvca(appendBillParamDTO.getId_srvca());
		blCgItmOepDO.setId_srv(appendBillParamDTO.getId_srv());
		blCgItmOepDO.setCode_srv(appendBillParamDTO.getCode_srv());
		blCgItmOepDO.setName_srv(appendBillParamDTO.getName_srv());
		blCgItmOepDO.setSrvu(appendBillParamDTO.getSrvu());
		blCgItmOepDO.setSrvu_name(appendBillParamDTO.getSrvu_name());
		blCgItmOepDO.setPrice(appendBillParamDTO.getPrice());
		blCgItmOepDO.setPrice_ratio(appendBillParamDTO.getPrice_ratio());
		blCgItmOepDO.setQuan(appendBillParamDTO.getQuan());
		blCgItmOepDO.setAmt(appendBillParamDTO.getAmt());
		if (appendBillParamDTO.getRatio_pripat() != null) {
			blCgItmOepDO.setRatio_pripat(appendBillParamDTO.getRatio_pripat());
		} else {
			blCgItmOepDO.setRatio_pripat(new FDouble(1));
		}
		
		blCgItmOepDO.setAmt_std(appendBillParamDTO.getAmt_std());
		blCgItmOepDO.setAmt_ratio(appendBillParamDTO.getAmt_ratio());
		blCgItmOepDO.setId_pripat(appendBillParamDTO.getId_pripat());
		blCgItmOepDO.setAmt_pat(appendBillParamDTO.getAmt_pat());
		
		if(!StringUtil.isEmpty(appendBillParamDTO.getId_ent())){
			IEnthpRService entHpService = ServiceFinder.find(IEnthpRService.class);
			EntHpDO[] entHpDos = entHpService.findByAttrValString(EntHpDO.ID_ENT, appendBillParamDTO.getId_ent());
			if(!ArrayUtil.isEmpty(entHpDos)){
				blCgItmOepDO.setId_hp(entHpDos[0].getId_hp());
			}
		}
		//blCgItmOepDO.setId_hp(appendBillParamDTO.getId_hp());
		
		blCgItmOepDO.setRatio_hp(appendBillParamDTO.getRatio_hp());
		blCgItmOepDO.setAmt_hp(appendBillParamDTO.getAmt_hp());
		
		if (appendBillParamDTO.getOutpBillDTO() == null) {
			blCgItmOepDO.setFg_acc(FBoolean.FALSE);
			blCgItmOepDO.setStatus(DOStatus.NEW);
		} else {

			blCgItmOepDO.setFg_acc(appendBillParamDTO.getOutpBillDTO().getFg_acc());
			if (FBoolean.TRUE.equals(blCgItmOepDO.getFg_acc()))
				blCgItmOepDO.setAmt_acc(appendBillParamDTO.getOutpBillDTO().getAmt_acc());
			if (appendBillParamDTO.getOutpBillDTO().getId_cgoep() != null)// 来源于补费的数据
			{
				blCgItmOepDO.setId_cgoep(appendBillParamDTO.getOutpBillDTO().getId_cgoep());
				blCgItmOepDO.setId_cgitmoep(appendBillParamDTO.getOutpBillDTO().getId_cgitmoep());
				blCgItmOepDO.setStatus(DOStatus.UPDATED);
			} else {
				blCgItmOepDO.setStatus(DOStatus.NEW);
			}
		}

		blCgItmOepDO.setDt_or(appendBillParamDTO.getDt_or());
		blCgItmOepDO.setId_org_or(appendBillParamDTO.getId_org_or());
		blCgItmOepDO.setId_dep_or(appendBillParamDTO.getId_dep_or());
		blCgItmOepDO.setId_emp_or(appendBillParamDTO.getId_emp_or());
		blCgItmOepDO.setId_org_mp(appendBillParamDTO.getId_org_mp());
		blCgItmOepDO.setId_dep_mp(appendBillParamDTO.getId_dep_mp());
		blCgItmOepDO.setId_dep_wh(appendBillParamDTO.getId_dep_wh());
		if (appendBillParamDTO.getDt_srv() != null) {
			blCgItmOepDO.setDt_srv(appendBillParamDTO.getDt_srv());
		} else {
			blCgItmOepDO.setDt_srv(new FDateTime(strDateTime));
		}
		blCgItmOepDO.setFg_mm(appendBillParamDTO.getFg_mm());
		blCgItmOepDO.setId_mm(appendBillParamDTO.getId_mm());
		blCgItmOepDO.setId_mmtp(appendBillParamDTO.getId_mmtp());
		blCgItmOepDO.setSd_mmtp(appendBillParamDTO.getSd_mmtp());
		blCgItmOepDO.setCode_mm(appendBillParamDTO.getCode_mm());
		blCgItmOepDO.setOnlycode(appendBillParamDTO.getOnlycode());
		blCgItmOepDO.setName_mm(appendBillParamDTO.getName_mm());
		blCgItmOepDO.setCd_batch(appendBillParamDTO.getCd_batch());
		// 增加批准文号字段，医保需要相关字段
		blCgItmOepDO.setApprno(appendBillParamDTO.getApprno());
		blCgItmOepDO.setPgku_base(appendBillParamDTO.getPgku_base());
		blCgItmOepDO.setPgku_cur(appendBillParamDTO.getPgku_cur());
		blCgItmOepDO.setFactor(appendBillParamDTO.getFactor());
		blCgItmOepDO.setQuan_base(appendBillParamDTO.getQuan_base());
		blCgItmOepDO.setPri_ss(appendBillParamDTO.getPri_ss());
		blCgItmOepDO.setEu_direct(appendBillParamDTO.getEu_direct());
		blCgItmOepDO.setFg_st(FBoolean.FALSE);
		blCgItmOepDO.setId_stoep(null);
		blCgItmOepDO.setDt_st(null);
		blCgItmOepDO.setFg_additm(appendBillParamDTO.getFg_additm());// 是否补费标志
		if (null != (Object) appendBillParamDTO.getFg_hp())// 记账上传医保标志
		{
			blCgItmOepDO.setFg_hp(appendBillParamDTO.getFg_hp());
		} else {
			blCgItmOepDO.setFg_hp(FBoolean.FALSE);
		}
		// blCgItmOepDO.setFg_susp(FBoolean.TRUE);//划价是挂起状态，结算后才去除挂起状态
		blCgItmOepDO.setFg_susp(fg_susp);// 划价是挂起状态，但补费非挂起状态
		blCgItmOepDO.setId_par(appendBillParamDTO.getId_par());
		if (null != appendBillParamDTO.getEu_srctp())// 费用来源
		{
			blCgItmOepDO.setEu_srctp(appendBillParamDTO.getEu_srctp());
		} else {
			blCgItmOepDO.setEu_srctp(FeeOriginEnum.ORDERS_FEE);// 医嘱产生
		}

		blCgItmOepDO.setSrcfunc_des(appendBillParamDTO.getSrcfunc_des());
		// 服务项目医保计划类型编码
		blCgItmOepDO.setSd_hpsrvtp(appendBillParamDTO.getSd_hpsrvtp());
		// 医保计划
		blCgItmOepDO.setId_hp(appendBillParamDTO.getId_hp());
		// 服务项目医保计划类型主键ID
		blCgItmOepDO.setId_hpsrvtp(appendBillParamDTO.getId_hpsrvtp());
		// ci_or_srv.sv 计算列
		blCgItmOepDO.setCi_sv(appendBillParamDTO.getCi_sv());
		//设置医保支付比例对应字段编号2017年11月29日 yang.lu
		blCgItmOepDO.setId_hpsrvmpayratio(appendBillParamDTO.getIndicitemid());
		
		// ly 2018/08/27记账添加对零挂赋值
		blCgItmOepDO.setFg_zeroreg(appendBillParamDTO.getFg_zeroreg() == null ? 
				FBoolean.FALSE : appendBillParamDTO.getFg_zeroreg());
		
		blCgItmOepDO.setNote(appendBillParamDTO.getNote());
		if (appendBillParamDTO.getSpec() != null) {
			blCgItmOepDO.setSpec(appendBillParamDTO.getSpec());
		}
		blCgItmOepDO.setFg_pricinginsertcg(appendBillParamDTO.getFg_pricinginsertcg());
		return blCgItmOepDO;
	}

	private IncCaItmDO getInccaitmCodeAndName(String code_enttp, String id_srv) throws BizException {
		IBdInccaQueService iBdInccaQueService = ServiceFinder.find(IBdInccaQueService.class);
		return iBdInccaQueService.getInccaitmCodeAndName(code_enttp, id_srv);
	}

	/**
	 * 返回产生的门急诊记账明细表DO数组
	 * 
	 * @param appendBillParamDTO
	 * @param strDateTime
	 * @param fg_susp
	 *            是否挂起标志
	 * @return
	 */
	public BlCgItmOepDO[] GetBlCgItmOepDOs(BlOrderAppendBillParamDTO[] appendBillParamDTO, String strDateTime, FBoolean fg_susp) throws BizException {

		List<BlCgItmOepDO> listBlCgItmOepDO = new ArrayList<BlCgItmOepDO>();
		for (int i = 0; i < appendBillParamDTO.length; i++) {
			BlCgItmOepDO blCgItmOepDO = new BlCgItmOepDO();
			// 账单码 -- ly 2018/12/20 没啥用
			/*IncCaItmDO incCaItmDO = getInccaitmCodeAndName(appendBillParamDTO[i].getCode_enttp(), appendBillParamDTO[i].getId_srv());
			if (incCaItmDO != null) {
				appendBillParamDTO[i].setName_inccaitm(incCaItmDO.getName());
				appendBillParamDTO[i].setCode_inccaitm(incCaItmDO.getCode());
			}*/
			blCgItmOepDO = GetBlCgItmOepDO(appendBillParamDTO[i], strDateTime, fg_susp);
			listBlCgItmOepDO.add(blCgItmOepDO);
		}
		return listBlCgItmOepDO.toArray(new BlCgItmOepDO[] {});
	}

	/**
	 * 生成红冲的门诊记账主表和明细表信息,且修改原始数据
	 * 
	 * @param orginAggDO
	 *            被红冲的门诊记账主表和明细表数据
	 * @param id_org_cg
	 *            当前机构
	 * @param id_dep_cg
	 *            操作员所在科室
	 * @param id_emp_cg
	 *            操作员
	 * @return
	 */
	public BlcgoepAggDO[] GetDashedBackBlcgoepAggDO(BlcgoepAggDO[] orginAggDO, String id_org_cg, String id_dep_cg, String id_emp_cg, String strDateTime) {
		// acc_lock=new FDouble(0);

		int i = 0;

		List<BlcgoepAggDO> blcgoepAggDO_arr = new ArrayList<BlcgoepAggDO>();
		for (BlcgoepAggDO item : orginAggDO) {
			BlCgOepDO orginBlCgOepDO = item.getParentDO();

			BlCgItmOepDO[] orginBlCgItmOepDO = item.getBlCgItmOepDO();
			List<BlCgItmOepDO> BlCgItmOepDO_arr = new ArrayList<BlCgItmOepDO>();
			List<BlCgItmOepDO> BlCgItmOepDO_arr_orgin = new ArrayList<BlCgItmOepDO>();
			BlcgoepAggDO blcgoepAggDO_red = new BlcgoepAggDO();
			BlcgoepAggDO blcgoepAggDO_orgin = new BlcgoepAggDO();
			// 主表
			BlCgOepDO dashedBack = new BlCgOepDO();
			dashedBack.setId_cgoep(null);
			dashedBack.setId_grp(orginBlCgOepDO.getId_grp());
			dashedBack.setId_org(orginBlCgOepDO.getId_org());
			dashedBack.setCode_cg(orginBlCgOepDO.getCode_cg());
			dashedBack.setId_pat(orginBlCgOepDO.getId_pat());
			if (item.getParentDO().getEu_direct() == BookRtnDirectEnum.CHARGES) {
				dashedBack.setEu_direct(BookRtnDirectEnum.REFUND);
			} else {
				dashedBack.setEu_direct(BookRtnDirectEnum.CHARGES);
			}
			dashedBack.setDt_cg(new FDateTime(strDateTime));
			dashedBack.setId_org_cg(id_org_cg);
			dashedBack.setId_dep_cg(id_dep_cg);
			dashedBack.setId_emp_cg(id_emp_cg);
			dashedBack.setStatus(DOStatus.NEW);
			blcgoepAggDO_red.setParentDO(dashedBack);

			// blcgoepAggDO_orgin.setParentDO(item.getParentDO());
			// item.getParentDO().setStatus(DOStatus.UPDATED);
			// 明细表
			for (BlCgItmOepDO details : orginBlCgItmOepDO) {
				BlCgItmOepDO orginBlCgItmOepDO1 = new BlCgItmOepDO();
				// 红冲对象主键Id_cgitmoep
				orginBlCgItmOepDO1.setId_cgitmoep(null);
				orginBlCgItmOepDO1.setId_cgoep(null);
				orginBlCgItmOepDO1.setFg_hpcg(details.getFg_hpcg());
				orginBlCgItmOepDO1.setSd_abrd(details.getSd_abrd());
				orginBlCgItmOepDO1.setCode_apply(details.getCode_apply());
				orginBlCgItmOepDO1.setCode_applytp(details.getCode_applytp());
				orginBlCgItmOepDO1.setFg_free(details.getFg_free());
				orginBlCgItmOepDO1.setId_grp(details.getId_grp());
				orginBlCgItmOepDO1.setId_org(details.getId_org());
				orginBlCgItmOepDO1.setId_pat(details.getId_pat());
				orginBlCgItmOepDO1.setId_ent(details.getId_ent());
				orginBlCgItmOepDO1.setCode_enttp(details.getCode_enttp());
				orginBlCgItmOepDO1.setId_enttp(details.getId_enttp());
				orginBlCgItmOepDO1.setId_pres(details.getId_pres());
				orginBlCgItmOepDO1.setId_or(details.getId_or());
				orginBlCgItmOepDO1.setId_orsrv(details.getId_orsrv());
				orginBlCgItmOepDO1.setId_srvtp(details.getId_srvtp());
				orginBlCgItmOepDO1.setSd_srvtp(details.getSd_srvtp());
				orginBlCgItmOepDO1.setId_srvca(details.getId_srvca());
				orginBlCgItmOepDO1.setId_srv(details.getId_srv());
				orginBlCgItmOepDO1.setCode_srv(details.getCode_srv());
				orginBlCgItmOepDO1.setName_srv(details.getName_srv());
				orginBlCgItmOepDO1.setSrvu(details.getSrvu());
				orginBlCgItmOepDO1.setPrice(details.getPrice());
				orginBlCgItmOepDO1.setPrice_ratio(details.getPrice_ratio());
				orginBlCgItmOepDO1.setQuan(details.getQuan());
				orginBlCgItmOepDO1.setAmt(details.getAmt());
				orginBlCgItmOepDO1.setAmt_acc(details.getAmt_acc());
				orginBlCgItmOepDO1.setAmt_ratio(details.getAmt_ratio());
				orginBlCgItmOepDO1.setRatio_pripat(details.getRatio_pripat());
				orginBlCgItmOepDO1.setAmt_std(details.getAmt_std());
				orginBlCgItmOepDO1.setId_pripat(details.getId_pripat());
				orginBlCgItmOepDO1.setAmt_pat(details.getAmt_pat());
				orginBlCgItmOepDO1.setId_hp(details.getId_hp());
				orginBlCgItmOepDO1.setRatio_hp(details.getRatio_hp());
				orginBlCgItmOepDO1.setAmt_hp(details.getAmt_hp());
				orginBlCgItmOepDO1.setFg_acc(details.getFg_acc());
				orginBlCgItmOepDO1.setDt_or(details.getDt_or());
				orginBlCgItmOepDO1.setId_org_or(details.getId_org_or());
				orginBlCgItmOepDO1.setId_dep_or(details.getId_dep_or());
				orginBlCgItmOepDO1.setId_emp_or(details.getId_emp_or());
				orginBlCgItmOepDO1.setId_org_mp(details.getId_org_mp());
				orginBlCgItmOepDO1.setId_dep_mp(details.getId_dep_mp());
				orginBlCgItmOepDO1.setId_dep_wh(details.getId_dep_wh());
				orginBlCgItmOepDO1.setDt_srv(details.getDt_srv());
				orginBlCgItmOepDO1.setFg_mm(details.getFg_mm());
				orginBlCgItmOepDO1.setId_mm(details.getId_mm());
				orginBlCgItmOepDO1.setId_mmtp(details.getId_mmtp());
				orginBlCgItmOepDO1.setSd_mmtp(details.getSd_mmtp());
				orginBlCgItmOepDO1.setCode_mm(details.getCode_mm());
				orginBlCgItmOepDO1.setOnlycode(details.getOnlycode());
				orginBlCgItmOepDO1.setName_mm(details.getName_mm());
				orginBlCgItmOepDO1.setCd_batch(details.getCd_batch());
				orginBlCgItmOepDO1.setPgku_base(details.getPgku_base());
				orginBlCgItmOepDO1.setPgku_cur(details.getPgku_cur());
				orginBlCgItmOepDO1.setFactor(details.getFactor());
				orginBlCgItmOepDO1.setQuan_base(details.getQuan_base());
				orginBlCgItmOepDO1.setSrcfunc_des(details.getSrcfunc_des());
				orginBlCgItmOepDO1.setPri_ss(details.getPri_ss());
				orginBlCgItmOepDO1.setFg_st(FBoolean.FALSE);
				orginBlCgItmOepDO1.setId_cgoep(null);
				orginBlCgItmOepDO1.setDt_st(null);
				orginBlCgItmOepDO1.setDt_srv(new FDateTime(strDateTime));
				// orginBlCgItmOepDO1.setId_org_st(null);
				// orginBlCgItmOepDO1.setId_dep_st(null);
				// orginBlCgItmOepDO1.setId_emp_st(null);
				orginBlCgItmOepDO1.setFg_hp(FBoolean.FALSE);
				orginBlCgItmOepDO1.setFg_susp(FBoolean.FALSE);
				orginBlCgItmOepDO1.setId_par(details.getId_cgitmoep());
				orginBlCgItmOepDO1.setFg_additm(FBoolean.TRUE);// 红冲记账属于补录
				orginBlCgItmOepDO1.setFg_refund(FBoolean.FALSE);
				orginBlCgItmOepDO1.setEu_srctp(details.getEu_srctp());
				orginBlCgItmOepDO1.setCode_inccaitm(details.getCode_inccaitm());
				orginBlCgItmOepDO1.setName_inccaitm(details.getName_inccaitm());
				orginBlCgItmOepDO1.setNote("退费，对象：【" + details.getId_cgitmoep() + "】");
				orginBlCgItmOepDO1.setStatus(DOStatus.NEW);
				BlCgItmOepDO_arr.add(orginBlCgItmOepDO1);

				details.setFg_refund(FBoolean.TRUE);
				details.setStatus(DOStatus.UPDATED);
				BlCgItmOepDO_arr_orgin.add(details);
			}
			blcgoepAggDO_red.setBlCgItmOepDO(BlCgItmOepDO_arr.toArray(new BlCgItmOepDO[] {}));
			blcgoepAggDO_arr.add(blcgoepAggDO_red);
			blcgoepAggDO_orgin.setBlCgItmOepDO(BlCgItmOepDO_arr_orgin.toArray(new BlCgItmOepDO[] {}));
			// blcgoepAggDO_arr.add(blcgoepAggDO_orgin);
			i = i + 1;

		}
		return blcgoepAggDO_arr.toArray(new BlcgoepAggDO[] {});
	}

	/**
	 * 红冲的门诊记账主表和明细表信息后，需要调整的用户账户金额，在调用GetDashedBackBlcgoepAggDO（）后再调用本方法
	 * 
	 * @return需要调整的用户账户金额
	 */
	public FDouble GetDashedBackAcc_oep_Lock(BlcgoepAggDO[] dashedBackBlcgoepAggDOs) {
		FDouble sum_amt_ratio = new FDouble(0);
		for (int i = 0; i < dashedBackBlcgoepAggDOs.length; i++) {
			BlCgItmOepDO[] blCgItmOepDOs = dashedBackBlcgoepAggDOs[i].getBlCgItmOepDO();
			for (int j = 0; j < blCgItmOepDOs.length; j++) {
				if (blCgItmOepDOs[j].getFg_acc().booleanValue()) // 采用了预交金授权
				{
					sum_amt_ratio = sum_amt_ratio.add(blCgItmOepDOs[j].getAmt_ratio().multiply(dashedBackBlcgoepAggDOs[i].getParentDO().getEu_direct()));
				}
			}
		}
		return sum_amt_ratio;
	}

	/**
	 * 红冲的住院记账主表和明细表信息后，需要调整的用户账户金额，在调用GetDashedBackBlcgqueryAggDO（）后再调用本方法
	 * 
	 * @return需要调整的用户账户金额
	 */
	public FDouble GetDashedBackAcc_ip_Lock(BlCgIpDO[] dashedBackBlcgqueryAggDOs) {
		FDouble sum_amt_ratio = new FDouble(0);
		for (int i = 0; i < dashedBackBlcgqueryAggDOs.length; i++) {
			BlCgIpDO blCgIpDO = dashedBackBlcgqueryAggDOs[i];
			sum_amt_ratio = sum_amt_ratio.add(blCgIpDO.getAmt_ratio().multiply(blCgIpDO.getEu_direct()));
		}
		return sum_amt_ratio;
	}

	/**
	 * 生成结账红冲的Agg(仅供通用退费使用)
	 * 
	 * @param orginAggDO
	 * @param id_org_cg
	 * @param id_dep_cg
	 * @param id_emp_cg
	 * @param strDateTime
	 * @return
	 */
	public BlCgIpDO[] GetDashedBackBlcgqueryAggDO(BlCgIpDO[] orginAggDO, String id_org_cg, String id_dep_cg, String id_emp_cg, String strDateTime) throws BizException {

		List<BlCgIpDO> blcgqueryAggDOList = new ArrayList<BlCgIpDO>();
		for (BlCgIpDO aggdo : orginAggDO) {
			BlCgIpDO blCgIpDO = (BlCgIpDO)aggdo.clone();
			// 修改必要字段
			blCgIpDO.setNote("红冲：" + blCgIpDO.getId_cgip());
			blCgIpDO.setFg_free(blCgIpDO.getFg_free());
			blCgIpDO.setId_par(blCgIpDO.getId_cgip());
			blCgIpDO.setId_cgip(null);
			blCgIpDO.setFg_refund(FBoolean.FALSE);
			// 对查出来的数据进行红冲：原收款方向的红冲为退款方向，原退款方向的红冲为收款方向
			if (blCgIpDO.getEu_direct() == BookRtnDirectEnum.CHARGES) {
				blCgIpDO.setEu_direct(BookRtnDirectEnum.REFUND);
			} else {
				blCgIpDO.setEu_direct(BookRtnDirectEnum.CHARGES);
			}
			blCgIpDO.setFg_st(FBoolean.FALSE);
			blCgIpDO.setId_stip(null);
			blCgIpDO.setDt_st(null);
			blCgIpDO.setFg_hp(FBoolean.FALSE);
			blCgIpDO.setFg_susp(FBoolean.FALSE);
			blCgIpDO.setId_org_cg(id_org_cg);
			blCgIpDO.setId_dep_cg(id_dep_cg);
			blCgIpDO.setId_emp_cg(id_emp_cg);
			blCgIpDO.setDt_srv(new FDateTime(strDateTime));
			blCgIpDO.setDt_cg(new FDateTime(strDateTime));

			blCgIpDO.setStatus(DOStatus.NEW);
			/*BlCgResIp[] blCgResIps = aggdo.getBlCgResIp();
			for (int j = 0; j < blCgResIps.length; j++) {
				blCgResIps[j].setId_cgip(null);
				blCgResIps[j].setId_cgresip(null);
			}*/

			//redAgg.setParentDO(blCgIpDO);
			//redAgg.setBlCgResIp(blCgResIps);
			blcgqueryAggDOList.add(blCgIpDO);
			// //更改原有的数据
			// aggdo.getParentDO().setFg_refund(FBoolean.TRUE);
			// aggdo.getParentDO().setStatus(DOStatus.UPDATED);
			// blcgqueryAggDOList.add(aggdo);
		}
		return blcgqueryAggDOList.toArray(new BlCgIpDO[] {});
	}

	public BlCgIpDO[] GetDashedBackBlCgIpDO_mm(BlCgIpDO[] orginBlCgIpDO, BlOrderRefundBillParamDTO refundBillParamDTOString, String strDateTime) throws BizException {
		BlCgIpDO[] dashedBackAggDO = new BlCgIpDO[orginBlCgIpDO.length];
		int i = 0;
		for (BlCgIpDO blCgIpDO : orginBlCgIpDO) {
			//BlcgqueryAggDO blcgqueryAggDO = new BlcgqueryAggDO();
			//blcgqueryAggDO.setParentDO(blCgIpDO);
			dashedBackAggDO[i] = blCgIpDO;
			i++;
		}
		return GetDashedBackBlcgqueryAggDO_mm(dashedBackAggDO, refundBillParamDTOString, strDateTime);
	}

	/**
	 * 生成结账红冲的Agg(仅供物品退费使用)
	 * 
	 * @param orginAggDO
	 * @param BlOrderRefundBillParamDTO
	 * @param strDateTime
	 * @return
	 */
	public BlCgIpDO[] GetDashedBackBlcgqueryAggDO_mm(BlCgIpDO[] orginAggDO, BlOrderRefundBillParamDTO refundBillParamDTOString, String strDateTime) throws BizException {
		BlCgIpDO[] dashedBackAggDO = new BlCgIpDO[orginAggDO.length];
		List<BlCgIpDO> blcgqueryAggDOList = new ArrayList<BlCgIpDO>();
		FDouble price = new FDouble(0);
		FDouble amt_std = new FDouble(0);
		FDouble amt = new FDouble(0);
		for (BlCgIpDO aggdo : orginAggDO) {
			//BlcgqueryAggDO redAgg = new BlcgqueryAggDO();
			BlCgIpDO blCgIpDO = aggdo;
			// 修改必要字段
			blCgIpDO.setNote("红冲：" + blCgIpDO.getId_cgip());
			blCgIpDO.setId_par(blCgIpDO.getId_cgip());
			blCgIpDO.setFg_refund(FBoolean.FALSE);
			blCgIpDO.setFg_st(FBoolean.FALSE);
			blCgIpDO.setId_stip(null);
			blCgIpDO.setId_cgip(null);
			blCgIpDO.setDt_st(null);
			// 对查出来的数据进行红冲：原收款方向的红冲为退款方向，原退款方向的红冲为收款方向
			if (blCgIpDO.getEu_direct() == BookRtnDirectEnum.CHARGES) {
				blCgIpDO.setEu_direct(BookRtnDirectEnum.REFUND);
			} else {
				blCgIpDO.setEu_direct(BookRtnDirectEnum.CHARGES);
			}
			blCgIpDO.setFg_hp(FBoolean.FALSE);
			blCgIpDO.setFg_susp(FBoolean.FALSE);
			blCgIpDO.setId_org_cg(refundBillParamDTOString.getId_org_cg());
			blCgIpDO.setId_dep_cg(refundBillParamDTOString.getId_dep_cg());
			blCgIpDO.setId_emp_cg(refundBillParamDTOString.getId_emp_cg());
			blCgIpDO.setDt_cg(new FDateTime(strDateTime));
			price = blCgIpDO.getPrice();
			if (refundBillParamDTOString.getReturn_num().compareTo(new FDouble(0)) < 0) {
				throw new BizException("退费数据传入后台不能为负数");
			}
			blCgIpDO.setQuan(refundBillParamDTOString.getReturn_num()); // 数量为退费数据

			amt_std = price.multiply(refundBillParamDTOString.getReturn_num()).setScale(-2, BigDecimal.ROUND_HALF_UP);
			if (blCgIpDO.getFg_mm() != null && blCgIpDO.getFg_mm().booleanValue()) {
				amt = amt_std; // 目前，物品不乘以标准比例
			} else {
				// amt=amt_std.multiply(blCgIpDO.getRatio_pripat()).setScale(-2,
				// BigDecimal.ROUND_HALF_UP); //非物品要乘以标准比例
				// 折扣金额=折扣价格*数量
				amt = blCgIpDO.getPrice_ratio().multiply(refundBillParamDTOString.getReturn_num()).setScale(-2, BigDecimal.ROUND_HALF_UP);
			}
			blCgIpDO.setAmt(amt);
			blCgIpDO.setAmt_ratio(amt);
			blCgIpDO.setAmt_std(amt_std);
			blCgIpDO.setAmt_pat(amt);
			blCgIpDO.setAmt_hp(new FDouble(0));
			blCgIpDO.setStatus(DOStatus.NEW);
			/*BlCgResIp[] blCgResIps = aggdo.getBlCgResIp();
			redAgg.setParentDO(blCgIpDO);
			if (blCgResIps != null) {
				for (int j = 0; j < blCgResIps.length; j++) {
					blCgResIps[j].setId_cgip(null);
					blCgResIps[j].setId_cgresip(null);
				}
				redAgg.setBlCgResIp(blCgResIps);
			}*/

			blcgqueryAggDOList.add(blCgIpDO);
			// //更改原有的数据
			// aggdo.getParentDO().setFg_refund(FBoolean.TRUE);
			// aggdo.getParentDO().setStatus(DOStatus.UPDATED);
			// blcgqueryAggDOList.add(aggdo);
		}
		return blcgqueryAggDOList.toArray(new BlCgIpDO[] {});
	}
}
