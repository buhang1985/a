package iih.bl.cg.ep;

import iih.bd.base.utils.AppUtils;
import iih.bd.base.utils.SqlUtils;
import iih.bd.pp.dto.d.SrvPricalRateAndPriceDTO;
import iih.bd.pp.pripat.d.PriPatDO;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.d.BlCgOepDO;
import iih.bl.cg.blcgoep.d.BlcgoepAggDO;
import iih.bl.cg.blcgoep.d.desc.BlCgItmOepDODesc;
import iih.bl.cg.blcgoep.i.IBlcgoepCudService;
import iih.bl.cg.blcgoep.i.IBlcgoepMDORService;
import iih.bl.cg.blcgoep.i.IBlcgoepRService;
import iih.bl.cg.blcgquery.d.BookRtnDirectEnum;
import iih.bl.cg.blrecgoep.d.BlRecgOepDO;
import iih.bl.cg.blrecgoep.i.IBlrecgoepCudService;
import iih.bl.cg.service.d.OperatorInfoDTO;
import iih.bl.comm.GetCodeByCustomization;
import iih.pi.acc.account.d.PiPatAccDO;
import iih.pi.acc.account.i.IPatAccServiceExt;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.DataCloneUtils;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 门急诊重划价EP
 * 
 * @author yankan
 * @since 2017-06-19
 *
 */
public class OepReCgEP {

	/**
	 * 根据就诊id查询未结算记账明细
	 * 
	 * @author liwq
	 */
	public BlcgoepAggDO[] getAggCgOepDOs(String id_ent) throws BizException {
		IBlcgoepRService aggService = ServiceFinder.find(IBlcgoepRService.class);
		String whereCond = "ID_CGOEP IN (SELECT ID_CGOEP FROM BL_CG_ITM_OEP WHERE fg_st = 'N' ";
		whereCond += " AND fg_pricinginsertcg = 'N'";
		whereCond += " AND Fg_refund = 'N'";
		whereCond += " AND id_ent='" + id_ent + "')";		
		BlcgoepAggDO[] aggDos = aggService.find(whereCond, "", FBoolean.FALSE);
		return aggDos;
	}

	/**
	 * 保存门诊重划价记录
	 * 
	 * @param from
	 *            原价格分类
	 * @param to
	 *            新价格分类
	 * @param operatorInfo
	 *            操作人信息
	 * @author liwq
	 * @throws BizException
	 */
	public BlRecgOepDO saveRecgOepRecord(String from, String to,
			OperatorInfoDTO operatorInfo) throws BizException {
		FDateTime strDateTime = AppUtils.getServerDateTime();
		BlRecgOepDO blRecgOepDO = new BlRecgOepDO();
		blRecgOepDO.setId_recg_oep(null);
		blRecgOepDO.setDt_recg(strDateTime);
		blRecgOepDO.setId_pripat_from(from);
		blRecgOepDO.setId_pripat_to(to);
		blRecgOepDO.setId_emp_recg(operatorInfo.getId_emp());
		blRecgOepDO.setId_org(operatorInfo.getId_org());
		blRecgOepDO.setId_grp(operatorInfo.getId_grp());
		blRecgOepDO.setStatus(DOStatus.NEW);

		IBlrecgoepCudService iRecgOepService = ServiceFinder.find(IBlrecgoepCudService.class);
		BlRecgOepDO[] blRecgOepDOs = new BlRecgOepDO[] { blRecgOepDO };
		BlRecgOepDO[] blRecgOepDOArr = iRecgOepService.save(blRecgOepDOs);
		if (ArrayUtil.isEmpty(blRecgOepDOArr)) {
			throw new BizException("保存重划价记录失败！");
		}
		return blRecgOepDOArr[0];
	}

	/**
	 * 获取原记账明细 (过滤已经退费红冲的数据即只对已记账的项目进行重划价)
	 */

	public List<BlcgoepAggDO> getOrignAggDOs(BlcgoepAggDO[] cgAggDos)
			throws BizException {
		// 1.拆分AGG
		List<BlCgItmOepDO> cgItmList = this.getCgItmOepDOs(cgAggDos);
		List<BlCgOepDO> cgList = this.getCgOepDOs(cgAggDos);

		// 2.主表DO list 转 Map
		Map<String, BlCgOepDO> cgOepMap = new HashMap<String, BlCgOepDO>();
		for (BlCgOepDO oepDO : cgList) {
			if (!cgOepMap.containsKey(oepDO.getId_cgoep())) {
				cgOepMap.put(oepDO.getId_cgoep(), oepDO);
			}
		}
		// 3.过滤记账明细中的数据（即排除退费和红冲数据）
		List<BlCgItmOepDO> cgItmDoList = this.getFilteredCgItms(cgItmList,cgOepMap);
		// 4.通过子表中的外键过滤主表数据 组装AGG
		List<BlcgoepAggDO> aggDOs = getFilteredAggDo(cgList, cgItmDoList);

		return aggDOs;
	}

	/**
	 * 拆分记账AGG 获取主表记录
	 */
	public List<BlCgOepDO> getCgOepDOs(BlcgoepAggDO[] cgAggDos) {
		List<BlCgOepDO> cgList = new ArrayList<BlCgOepDO>();
		for (BlcgoepAggDO aggDO : cgAggDos) {
			cgList.add(aggDO.getParentDO());
		}
		return cgList;
	}

	/**
	 * 拆分记账AGG 获取子表记录
	 */
	public List<BlCgItmOepDO> getCgItmOepDOs(BlcgoepAggDO[] cgAggDos) {
		List<BlCgItmOepDO> cgItmList = new ArrayList<BlCgItmOepDO>();
		for (BlcgoepAggDO aggDO : cgAggDos) {
			for (BlCgItmOepDO itmDo : aggDO.getBlCgItmOepDO()) {
				cgItmList.add(itmDo);
			}
		}
		return cgItmList;
	}

	/**
	 * 获取原记账主表记录
	 */
	public BlCgOepDO[] getOrginCgDos(String field, String[] ids)
			throws BizException {
		String whereCgCond = SqlUtils.getInSqlByIds(field, ids);		
		IBlcgoepMDORService iCgService = ServiceFinder.find(IBlcgoepMDORService.class);		
		BlCgOepDO[] cgOepDOArr = iCgService.find(whereCgCond, "", FBoolean.TRUE);
		if (ArrayUtil.isEmptyNoNull(cgOepDOArr)) {
			throw new BizException("重划价主表数据不能为空！");
		}
		return cgOepDOArr;
	}

	/**
	 * 修改患者账户的消费额度
	 * 
	 * @param id_ent
	 *            就诊ID
	 * @param amt_acc_orgin
	 *            红冲的总金额
	 * @param amt_acc_new
	 *            重收的总金额
	 * @author liwq
	 */
	public void updateAccConsume(String id_pat, FDouble orginAmt,FDouble newAmt) throws BizException {		
		IPatAccServiceExt patAccImpls = ServiceFinder.find(IPatAccServiceExt.class);
		PiPatAccDO piPatAccDO1 = patAccImpls.PatiAccPreAuthor(id_pat,orginAmt.multiply(-1).add(newAmt));
		if (null == piPatAccDO1) {
			throw new BizException("修改患者预交金预授权失败");
		}
	}

	/**
	 * 保存红冲和重收的记账主表
	 * 
	 * @param orginCgItmDoArr
	 *            原过滤后的子表记账明细
	 * @param orginCgOepDoArr
	 *            原过滤后的主表记账明细
	 * @param operatorInfo
	 *            操作人
	 * @param recgOepDo
	 *            重划价记录
	 * @return List<BlcgoepAggDO> 重收记账AGG
	 * @throws BizException
	 */
	public List<BlcgoepAggDO> saveRedandRechargeCg(	BlCgItmOepDO[] orginCgItmDoArr, BlCgOepDO[] orginCgOepDoArr,
			OperatorInfoDTO operatorInfo, BlRecgOepDO recgOepDo)
			throws BizException {
		List<BlcgoepAggDO> aggDOs = new ArrayList<BlcgoepAggDO>();
		IBlcgoepCudService iCgService = ServiceFinder.find(IBlcgoepCudService.class);
		List<BlCgItmOepDO> red_CgItmList = null;
		List<BlCgItmOepDO> recharge_CgItmList = null;
		RecgEP recgEP = new RecgEP();
		FDateTime recgDateTime = recgOepDo.getDt_recg();
		String newPriPat = recgOepDo.getId_pripat_to();
		// 1. 获取新价格分类对应价格比例
		PriPatDO priPatDO = recgEP.getPriPatDO(newPriPat);
		FDouble newRate = priPatDO.getRate();
		// 2. 获取新价格分类下特殊服务项目的价格比例
		SrvPricalRateAndPriceDTO[] srvPriceRateDTOArr = recgEP.getSrvPriceRate(newPriPat);

		// 因此门诊记账是主子表，因此对应的红冲和重收也按照主子表处理
		for (BlCgOepDO orginCgOepDo : orginCgOepDoArr) {
			red_CgItmList = new ArrayList<BlCgItmOepDO>();
			recharge_CgItmList = new ArrayList<BlCgItmOepDO>();
			BlcgoepAggDO[] blcgoepAggDOArr = new BlcgoepAggDO[2];
			// 2. 生成红冲主表记录
			BlCgOepDO red_blCgOepDO = this.getRedCgDO(orginCgOepDo,	operatorInfo, recgDateTime);
			// 3. 生成重收主记录
			BlCgOepDO recharge_blCgOepDO = this.getReChargeCgDO(orginCgOepDo,operatorInfo, recgDateTime);

			// 4. 生成子表中红冲记账明细和重收明细记录
			for (BlCgItmOepDO itmDO : orginCgItmDoArr) {
				if (orginCgOepDo.getId_cgoep().equals(itmDO.getId_cgoep())) {
					// 4.1 生成子表中红冲记账明细
					BlCgItmOepDO redItmOepDO = this.getRedCgItmDO(itmDO,recgOepDo);
					redItmOepDO.setId_cgoep(null);
					red_CgItmList.add(redItmOepDO);
					// 4.2 生成子表中重收记账明细
					BlCgItmOepDO rechargeItmOepDO = this.getReChargeCgItmDO(itmDO, recgOepDo, srvPriceRateDTOArr, newRate);
					rechargeItmOepDO.setId_cgoep(null);
					recharge_CgItmList.add(rechargeItmOepDO);
				}
			}

			// 5. 生成红冲AGG
			BlcgoepAggDO redBlcgoepAggDO = new BlcgoepAggDO();
			redBlcgoepAggDO.setParentDO(red_blCgOepDO);
			redBlcgoepAggDO.setBlCgItmOepDO(red_CgItmList.toArray(new BlCgItmOepDO[0]));
			blcgoepAggDOArr[0] = redBlcgoepAggDO;

			// 6. 生成重收AGG
			BlcgoepAggDO rechargeBlcgoepAggDO = new BlcgoepAggDO();
			rechargeBlcgoepAggDO.setParentDO(recharge_blCgOepDO);
			rechargeBlcgoepAggDO.setBlCgItmOepDO(recharge_CgItmList.toArray(new BlCgItmOepDO[0]));
			blcgoepAggDOArr[1] = rechargeBlcgoepAggDO;

			// 7.保存红冲和重收AGG
			BlcgoepAggDO[] blcgoepAggDOArr1 = iCgService.save(blcgoepAggDOArr);
			if (ArrayUtil.isEmpty(blcgoepAggDOArr1)) {
				throw new BizException("保存红冲和重收AGG失败！");
			}
			aggDOs.add(rechargeBlcgoepAggDO);
		}
		return aggDOs;
	}

	/**
	 * 生成红冲的记账主信息
	 * 
	 * @param orgin_blCgOepDO
	 *            原记账主信息
	 * @param operatorInfo
	 *            操作员信息
	 * @param strDateTime
	 *            重划价日期
	 * @return 红冲的记账信息
	 */
	private BlCgOepDO getRedCgDO(BlCgOepDO orgin_blCgOepDO,	OperatorInfoDTO operatorInfo, FDateTime recgDateTime) 
			throws BizException {
		BlCgOepDO red_blCgOepDO = new BlCgOepDO();
		red_blCgOepDO = DataCloneUtils.clone(orgin_blCgOepDO);
		red_blCgOepDO.setId_cgoep(null);
		red_blCgOepDO.setId_org(operatorInfo.getId_org());
		GetCodeByCustomization getCode = new GetCodeByCustomization();
		red_blCgOepDO.setCode_cg(getCode.GetCodeBlCgOep());
		red_blCgOepDO.setEu_direct(BookRtnDirectEnum.REFUND);
		red_blCgOepDO.setDt_cg(recgDateTime);
		red_blCgOepDO.setId_org_cg(operatorInfo.getId_org_emp());
		red_blCgOepDO.setId_emp_cg(operatorInfo.getId_emp());
		red_blCgOepDO.setId_dep_cg(operatorInfo.getId_dep());
		red_blCgOepDO.setStatus(DOStatus.NEW);
		return red_blCgOepDO;
	}

	/**
	 * 生成重收的记账主信息
	 * 
	 * @param orgin_blCgOepDO
	 *            原记账主信息
	 * @param operatorInfo
	 *            操作员信息
	 * @param strDateTime
	 *            重划价日期
	 * @return 红冲的记账信息
	 */
	private BlCgOepDO getReChargeCgDO(BlCgOepDO orgin_blCgOepDO,OperatorInfoDTO operatorInfo, FDateTime recgDateTime)
			throws BizException {
		BlCgOepDO recharge_blCgOepDO = new BlCgOepDO();
		recharge_blCgOepDO.setId_cgoep(null);
		recharge_blCgOepDO.setId_org(operatorInfo.getId_org());
		GetCodeByCustomization getCode = new GetCodeByCustomization();
		recharge_blCgOepDO.setCode_cg(getCode.GetCodeBlCgOep());
		recharge_blCgOepDO.setEu_direct(orgin_blCgOepDO.getEu_direct()); // 重收方向与原来的方向一致
		recharge_blCgOepDO.setDt_cg(recgDateTime);
		recharge_blCgOepDO.setId_org_cg(operatorInfo.getId_org_emp());
		recharge_blCgOepDO.setId_emp_cg(operatorInfo.getId_emp());
		recharge_blCgOepDO.setId_dep_cg(operatorInfo.getId_dep());
		recharge_blCgOepDO.setStatus(DOStatus.NEW);
		return recharge_blCgOepDO;
	}

	/**
	 * 获得红冲的记账明细信息
	 * 
	 * @param orgin_CgItmOepDO
	 *            原记账明细
	 * @param id_recg_op
	 *            重划价记录主键
	 * @param strDateTime
	 *            重划价日期
	 * @return 红冲的记账信息
	 */
	private BlCgItmOepDO getRedCgItmDO(BlCgItmOepDO orgin_CgItmOepDO,BlRecgOepDO recgOepDO) {
		BlCgItmOepDO r_blCgItmOepDO = new BlCgItmOepDO();
		r_blCgItmOepDO = DataCloneUtils.clone(orgin_CgItmOepDO);
		r_blCgItmOepDO.setId_cgitmoep(null);
		r_blCgItmOepDO.setEu_direct(BookRtnDirectEnum.REFUND);
		r_blCgItmOepDO.setQuan(orgin_CgItmOepDO.getQuan());
		r_blCgItmOepDO.setAmt_std(orgin_CgItmOepDO.getAmt_std());
		r_blCgItmOepDO.setAmt_ratio(orgin_CgItmOepDO.getAmt_ratio());
		r_blCgItmOepDO.setAmt(orgin_CgItmOepDO.getAmt());
		r_blCgItmOepDO.setAmt_pat(orgin_CgItmOepDO.getAmt_pat());
		r_blCgItmOepDO.setAmt_hp(orgin_CgItmOepDO.getAmt_hp());

		r_blCgItmOepDO.setId_par(r_blCgItmOepDO.getId_cgitmoep());
		r_blCgItmOepDO.setFg_recg(FBoolean.TRUE);
		r_blCgItmOepDO.setFg_refund(FBoolean.FALSE);
		r_blCgItmOepDO.setId_recg_oep(recgOepDO.getId_recg_oep());
		r_blCgItmOepDO.setDt_srv(recgOepDO.getDt_recg());
		r_blCgItmOepDO.setStatus(DOStatus.NEW);
		r_blCgItmOepDO.setNote("重划价：红冲");
		return r_blCgItmOepDO;
	}

	/**
	 * 记账子表重收明细
	 * @param orginCgItmOepDO 子表原记账明细
	 * @param recgOepDO 重划价记录
	 * @param specSrvPriceRateDto 价格分类下特殊服务项目的价格比例
	 * @param newRate 新价格分类的价格比例
	 * @return
	 */
	private BlCgItmOepDO getReChargeCgItmDO(BlCgItmOepDO orginCgItmOepDO,BlRecgOepDO recgOepDO,
			SrvPricalRateAndPriceDTO[] specSrvPriceRateDto, FDouble newRate) {
		FDouble amt_ratio = null;

		BlCgItmOepDO n_blCgItmOepDO = new BlCgItmOepDO();
		n_blCgItmOepDO = DataCloneUtils.clone(orginCgItmOepDO);
		n_blCgItmOepDO.setId_cgitmoep(null);
		n_blCgItmOepDO.setQuan(orginCgItmOepDO.getQuan());
		n_blCgItmOepDO.setAmt_std(orginCgItmOepDO.getAmt_std());
		n_blCgItmOepDO.setRatio_pripat(null);
		n_blCgItmOepDO.setAmt_ratio(null);
		n_blCgItmOepDO.setAmt_pat(null);
		n_blCgItmOepDO.setAmt(null);
		if (!ArrayUtil.isEmptyNoNull(specSrvPriceRateDto)) {
			for (SrvPricalRateAndPriceDTO pri : specSrvPriceRateDto) {
				if (pri.getId_srv() != null && n_blCgItmOepDO.getId_srv().equals(pri.getId_srv())) {
					//后期可能会增加服务项目定价模式的
					n_blCgItmOepDO.setRatio_pripat(pri.getRate());	
					break;
				}
			}
		} else {// 没有特殊的就按价格分类的默认比例走
			n_blCgItmOepDO.setRatio_pripat(newRate);
		}
		n_blCgItmOepDO.setPrice_ratio(n_blCgItmOepDO.getPrice().multiply(n_blCgItmOepDO.getRatio_pripat()).setScale(-2, BigDecimal.ROUND_HALF_UP));

		if (amt_ratio == null) {
			amt_ratio = n_blCgItmOepDO.getPrice_ratio().multiply(n_blCgItmOepDO.getQuan()).setScale(-2, BigDecimal.ROUND_HALF_UP);
		}

		n_blCgItmOepDO.setAmt_ratio(amt_ratio);
		n_blCgItmOepDO.setAmt(amt_ratio);
		n_blCgItmOepDO.setAmt_pat(amt_ratio);
		n_blCgItmOepDO.setAmt_hp(orginCgItmOepDO.getAmt_hp());

		n_blCgItmOepDO.setId_par(n_blCgItmOepDO.getId_cgitmoep());
		n_blCgItmOepDO.setFg_recg(FBoolean.TRUE);
		n_blCgItmOepDO.setFg_refund(FBoolean.FALSE);
		n_blCgItmOepDO.setId_recg_oep(recgOepDO.getId_recg_oep());
		n_blCgItmOepDO.setDt_srv(recgOepDO.getDt_recg());
		n_blCgItmOepDO.setStatus(DOStatus.NEW);
		n_blCgItmOepDO.setNote("重划价：重收");
		return n_blCgItmOepDO;
	}
	
	/**
	 * 通过子表中的外键过滤主表数据 组装AGG
	 */
	private List<BlcgoepAggDO> getFilteredAggDo(List<BlCgOepDO> cgList,	List<BlCgItmOepDO> cgItmDoList) {
		List<BlcgoepAggDO> aggDOs = new ArrayList<BlcgoepAggDO>();
		for (BlCgOepDO oepDo : cgList) {
			BlcgoepAggDO aggDo = new BlcgoepAggDO();
			List<BlCgItmOepDO> tmpItmDos = new ArrayList<BlCgItmOepDO>();
			for (BlCgItmOepDO itmDo : cgItmDoList) {
				if (itmDo.getId_cgoep().equals(oepDo.getId_cgoep())) {
					tmpItmDos.add(itmDo);
				}
			}
			if (!ListUtil.isEmpty(tmpItmDos)) {
				aggDo.setParent(oepDo);
				aggDo.setBlCgItmOepDO(tmpItmDos.toArray(new BlCgItmOepDO[] {}));
				aggDOs.add(aggDo);
			}
		}
		return aggDOs;
	}

	/**
	 * 过滤退费和红冲数据 (过滤子表中fg_refund='Y' or 主表中eu_direct=-1)
	 */
	@SuppressWarnings("unused")
	private List<BlCgItmOepDO> getFilteredCgItms(List<BlCgItmOepDO> cgItmList,	Map<String, BlCgOepDO> cgOepMap) {
		List<BlCgItmOepDO> cgItmDos = new ArrayList<BlCgItmOepDO>();
		for (BlCgItmOepDO cgItmOepDO : cgItmList) {
			if (cgItmOepDO.getFg_refund().booleanValue()) {
				continue;
			}
			if (!StringUtil.isEmpty(cgItmOepDO.getId_par())) {
				// 二次重划价的过滤
				if (cgOepMap.containsKey(cgItmOepDO.getId_cgoep())
						&& cgOepMap.get(cgItmOepDO.getId_cgoep()).getEu_direct() == 1) {
					cgItmDos.add(cgItmOepDO);
				}
			} else {
				cgItmDos.add(cgItmOepDO);
			}
		}
		return cgItmDos;
	}

}
