package iih.bl.cg.s.bp;

import iih.bd.pp.dto.d.SrvPricalRateAndPriceDTO;
import iih.bd.pp.pripat.d.PriPatDO;
import iih.bl.cg.blcgquery.d.BlCgIpDO;
import iih.bl.cg.blcgquery.d.BookRtnDirectEnum;
import iih.bl.cg.blcgquery.d.desc.BlCgIpDODesc;
import iih.bl.cg.blcgquery.i.IBlcgqueryCudService;
import iih.bl.cg.blcgquery.i.IBlcgqueryRService;
import iih.bl.cg.blrecgip.d.BlRecgIpDO;
import iih.bl.cg.ep.IpReCgEP;
import iih.bl.cg.ep.RecgEP;
import iih.bl.cg.service.d.OperatorInfoDTO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

public class IpRepricingBP {

	/**
	 * 对指定就诊进行住院重划价
	 * 
	 * @param id_ent
	 *            就诊ID
	 * @param id_pripat_from
	 *            原价格分类
	 * @param id_pripat_to
	 *            新价格分类
	 * @param operatorInfo
	 *            操作员人员信息
	 * @return 重划价成功返回FBoolean.true ,重划价失败返回FBoolean.false
	 * @throws BizException
	 */
	public FBoolean exec(String id_pat, String id_ent, String id_pripat_from, String id_pripat_to, OperatorInfoDTO operatorInfo) throws BizException {
		FBoolean fRePricingSuccess = FBoolean.TRUE;
		RecgEP recgEp = new RecgEP();
		IpReCgEP ipReCgEP = new IpReCgEP();
		// 1.查找指定就诊下未完成出院结算的费用明细
		BlCgIpDO[] orginCgIpDOArr =  this.getBlCgIpDOs(id_ent);
		if (ArrayUtil.isEmptyNoNull(orginCgIpDOArr)) {
			//1.1  更新就诊域和PI域中的价格分类id			
			recgEp.updatePirPat(id_pat, id_ent, id_pripat_to);
			//1.2 保存重划价记录
			BlRecgIpDO recgIpDO = ipReCgEP.saveRecgIpRecrod(id_pripat_from,id_pripat_to,operatorInfo);
			return fRePricingSuccess;
		}
		// 2.保存重划价记录
		BlRecgIpDO recgIpDO = ipReCgEP.saveRecgIpRecrod(id_pripat_from,	id_pripat_to, operatorInfo);
		// 3.过滤记账表中无效数据
		List<BlCgIpDO> filteredCgIpDOs = getFilteredCgIpDOs(orginCgIpDOArr);		
		// 4.保存更新原记录中fg_refund标志为Y
		for(BlCgIpDO cgIpDO: filteredCgIpDOs){
			cgIpDO.setFg_refund(FBoolean.TRUE);
			cgIpDO.setStatus(DOStatus.UPDATED);
		}
		IBlcgqueryCudService cgService = ServiceFinder.find(IBlcgqueryCudService.class);
		BlCgIpDO[] orginCgIpDOs = cgService.save(filteredCgIpDOs.toArray(new BlCgIpDO[]{}));
		if (ArrayUtil.isEmpty(orginCgIpDOs)) {		
			throw new BizException("更新重划主键id失败！");
		}
		
		//5 获取红冲数据 和 重收数据
		//5.1红冲数据
		List<BlCgIpDO> redCgIpDos = this.getRedCgIpDos(orginCgIpDOs,operatorInfo,recgIpDO);
		//5.2重收数据
		List<BlCgIpDO> reChargeCgIpDOs =  this.getReChargeCgIpDos(orginCgIpDOs, operatorInfo, recgIpDO);
		
		// 6.保存住院费用明细
		List<BlCgIpDO> saveCgIpDOs = this.mergeCgIpDOs(redCgIpDos,reChargeCgIpDOs);
		BlCgIpDO[] BlCgIpDOArr = cgService.save(saveCgIpDOs.toArray(new BlCgIpDO[]{}));
		if (ArrayUtil.isEmptyNoNull(BlCgIpDOArr)) {
			throw new BizException("保存重划价记账明细失败！");
		}

		// 7.修改就诊账户的消费额度
		FDouble orginAmt = this.getConsumeAmt(filteredCgIpDOs.toArray(new BlCgIpDO[]{}));
		FDouble newAMt = this.getConsumeAmt(reChargeCgIpDOs.toArray(new BlCgIpDO[]{}));
		ipReCgEP.updateEntAccAmt(id_ent, orginAmt, newAMt);
		// 8.更新就诊域和PI域中的价格分类id
		recgEp.updatePirPat(id_pat, id_ent, id_pripat_to);

		return fRePricingSuccess;
	}
	
	/**
	 * 合并红冲和重收数据
	 * @param redIpDos
	 * @param reChargeIpDOs
	 * @return
	 */
	private List<BlCgIpDO> mergeCgIpDOs(List<BlCgIpDO> redIpDos, List<BlCgIpDO> reChargeIpDOs) {
		List<BlCgIpDO> mergeDOs = new ArrayList<BlCgIpDO>();
		for(BlCgIpDO ipdo : redIpDos) {
			mergeDOs.add(ipdo);
		}
		for(BlCgIpDO ipdo : reChargeIpDOs) {
			mergeDOs.add(ipdo);
		}
		return mergeDOs;
	}
	/**
	 * 获取重收记账数据
	 * @param orginCgIpDOs
	 * @param operatorInfo
	 * @param recgIpDO
	 * @return
	 * @throws BizException
	 */
	private List<BlCgIpDO> getReChargeCgIpDos(BlCgIpDO[] orginCgIpDOs,OperatorInfoDTO operatorInfo,BlRecgIpDO recgIpDO) throws BizException {
		List<BlCgIpDO> reChargeCgIpDOs = new ArrayList<BlCgIpDO>();
		 //1.获得价格分类下的特殊项目
		RecgEP recgEp = new RecgEP();
		SrvPricalRateAndPriceDTO[] srvRatePriceDTOArr = recgEp.getSrvPriceRate(recgIpDO.getId_pripat_to());
		// 2.获得新价格分类下的默认比例
		PriPatDO priPatDO = recgEp.getPriPatDO(recgIpDO.getId_pripat_to());
		FDouble new_ration = priPatDO.getRate();
		for (BlCgIpDO blCgIpDO : orginCgIpDOs) {			
			// 重收记录
			BlCgIpDO new_blCgIpDO = getNewChargeBlCgIpDO(blCgIpDO, operatorInfo, recgIpDO, srvRatePriceDTOArr, new_ration);
			reChargeCgIpDOs.add(new_blCgIpDO);	
		}
		return reChargeCgIpDOs;
	}
	/**
	 * 获取红冲数据
	 * @param orginCgIpDOs
	 * @param operatorInfo
	 * @param recgIpDO
	 * @return
	 * @throws BizException
	 */
	private List<BlCgIpDO> getRedCgIpDos(BlCgIpDO[] orginCgIpDOs,OperatorInfoDTO operatorInfo,BlRecgIpDO recgIpDO) throws BizException {
		List<BlCgIpDO> redCgIpDOs = new ArrayList<BlCgIpDO>();		
		for (BlCgIpDO blCgIpDO : orginCgIpDOs) {		
			// 红冲记录
			redCgIpDOs.add(getRedBlCgIpDO(blCgIpDO, operatorInfo, recgIpDO));			
		}
		return redCgIpDOs;
	}
	/**
	 * 获取消费金额
	 * @param cgIpDoArr
	 * @return
	 */
	@SuppressWarnings("unused")
	private FDouble getConsumeAmt(BlCgIpDO[] cgIpDoArr) {
		FDouble amt = FDouble.ZERO_DBL;
		for(BlCgIpDO itmDo : cgIpDoArr) {
			amt = amt.add(itmDo.getAmt_ratio().multiply(itmDo.getEu_direct()));
		}
		return amt;
	}
	/**
	 * 过滤重划价之前的无效数据
	 * @param orginCgIpDOArr
	 * @return
	 */
	private List<BlCgIpDO> getFilteredCgIpDOs (BlCgIpDO[] orginCgIpDOArr) {
		List<BlCgIpDO> orginDos = new ArrayList<BlCgIpDO>();
		for (BlCgIpDO cgIpDO : orginCgIpDOArr) {
			if (cgIpDO.getFg_refund().booleanValue())
				continue;
			if (!StringUtil.isEmptyWithTrim(cgIpDO.getId_par())) {
				if (cgIpDO.getEu_direct() == 1)
					orginDos.add(cgIpDO);
			} else {
				if(cgIpDO.getEu_direct() == 1 && !cgIpDO.getFg_recg().booleanValue())
				orginDos.add(cgIpDO);
			}
		}
		return orginDos;
	}
	/**
	 * 获取所有未结算记账数据
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	private BlCgIpDO[] getBlCgIpDOs(String id_ent) throws BizException {
		IBlcgqueryRService cgRService = ServiceFinder.find(IBlcgqueryRService.class);
		String cgIpTableName = BlCgIpDODesc.TABLE_ALIAS_NAME;
		String whereCond = cgIpTableName	+ ".fg_st = 'N' and ";
		whereCond += cgIpTableName + ".id_ent='" + id_ent + "'";		
		BlCgIpDO[] cgIpDOArr = cgRService.find(whereCond,cgIpTableName+".id_or ", FBoolean.TRUE);
		return cgIpDOArr;
	}
	/**
	 * 获得红冲的记账信息
	 * 
	 * @param orgin_blCgIpDO
	 *            原记账信息
	 * @param operatorInfo
	 *            操作员信息
	 * @param id_recg_ip
	 *            重划价操作员记录主键
	 * @param strDateTime
	 *            重划价日期
	 * @return 红冲的记账信息
	 */
	private BlCgIpDO getRedBlCgIpDO(BlCgIpDO orgin_blCgIpDO, OperatorInfoDTO operatorInfo, BlRecgIpDO recgIpDO) {
		BlCgIpDO r_blCgIpDO = new BlCgIpDO();
		r_blCgIpDO = (BlCgIpDO) orgin_blCgIpDO.clone();
		r_blCgIpDO.setNote("重划价(红冲):" + r_blCgIpDO.getId_cgip());
		r_blCgIpDO.setId_cgip(null);
		r_blCgIpDO.setEu_direct(BookRtnDirectEnum.REFUND);
		
		r_blCgIpDO.setPrice(orgin_blCgIpDO.getPrice());
		r_blCgIpDO.setPrice_ratio(orgin_blCgIpDO.getPrice_ratio());
		r_blCgIpDO.setQuan(orgin_blCgIpDO.getQuan());
		r_blCgIpDO.setAmt_std(orgin_blCgIpDO.getAmt_std());
		r_blCgIpDO.setAmt_ratio(orgin_blCgIpDO.getAmt_ratio());
		r_blCgIpDO.setAmt(orgin_blCgIpDO.getAmt());
		r_blCgIpDO.setAmt_pat(orgin_blCgIpDO.getAmt_pat());
		r_blCgIpDO.setAmt_hp(orgin_blCgIpDO.getAmt_hp());

		r_blCgIpDO.setId_par(orgin_blCgIpDO.getId_cgip());
		r_blCgIpDO.setFg_recg(FBoolean.TRUE);
		r_blCgIpDO.setFg_refund(FBoolean.FALSE);
		r_blCgIpDO.setId_recg_ip(recgIpDO.getId_recg_ip());
		r_blCgIpDO.setDt_cg(recgIpDO.getDt_recg());
		r_blCgIpDO.setId_emp_cg(operatorInfo.getId_emp());
		r_blCgIpDO.setId_dep_cg(operatorInfo.getId_dep());
		r_blCgIpDO.setId_org_cg(operatorInfo.getId_org());
		r_blCgIpDO.setStatus(DOStatus.NEW);

		return r_blCgIpDO;
	}

	/**
	 * 获得重划价的记账信息
	 * 
	 * @param orgin_blCgIpDO
	 *            原记账信息
	 * @param operatorInfo
	 *            操作员信息
	 * @param id_recg_ip
	 *            重划价操作员记录主键
	 * @param strDateTime
	 *            重划价日期
	 * @param srvPriceRateDtos
	 *            新价格分类下的特需项目价格比例
	 * @param new_ration
	 *            新价格分类下的默认价格比例
	 * @return 重划价的记账信息
	 */
	private BlCgIpDO getNewChargeBlCgIpDO(BlCgIpDO orgin_blCgIpDO, OperatorInfoDTO operatorInfo, BlRecgIpDO recgIpDO,			SrvPricalRateAndPriceDTO[] srvPriceRateDtos,
			FDouble new_ration) {
		FDouble amt_ratio = null;

		BlCgIpDO n_blCgIpDO = new BlCgIpDO();
		n_blCgIpDO = (BlCgIpDO) orgin_blCgIpDO.clone();
		n_blCgIpDO.setNote("重划价(重收):" + n_blCgIpDO.getId_cgip());
		n_blCgIpDO.setId_cgip(null);
		// 重收不改变原记录方向
		n_blCgIpDO.setQuan(orgin_blCgIpDO.getQuan());
		n_blCgIpDO.setAmt_std(orgin_blCgIpDO.getAmt_std());
	

		n_blCgIpDO.setRatio_pripat(null);
		n_blCgIpDO.setAmt_ratio(null);
		n_blCgIpDO.setAmt_pat(null);
		n_blCgIpDO.setAmt(null);
		if(!ArrayUtil.isEmpty(srvPriceRateDtos)) {
			for (SrvPricalRateAndPriceDTO pri : srvPriceRateDtos) {
				if (pri.getId_srv() != null && n_blCgIpDO.getId_srv().equals(pri.getId_srv())) {					
					n_blCgIpDO.setRatio_pripat(pri.getRate());
					break;					
				}
			}
		} else {
			n_blCgIpDO.setRatio_pripat(new_ration);
		}
		// 没有特殊的就按价格分类的默认比例走
		if (n_blCgIpDO.getRatio_pripat() == null) {
			n_blCgIpDO.setRatio_pripat(new_ration);
		}

		n_blCgIpDO.setPrice_ratio(n_blCgIpDO.getPrice().multiply(n_blCgIpDO.getRatio_pripat())
				.setScale(-4, BigDecimal.ROUND_HALF_UP));

		if (amt_ratio == null) {
			amt_ratio = n_blCgIpDO.getPrice_ratio().multiply(n_blCgIpDO.getQuan())
					.setScale(-2, BigDecimal.ROUND_HALF_UP);
		}

		n_blCgIpDO.setAmt_ratio(amt_ratio);
		n_blCgIpDO.setAmt(amt_ratio);
		n_blCgIpDO.setAmt_pat(amt_ratio);
		n_blCgIpDO.setAmt_hp(orgin_blCgIpDO.getAmt_hp());

		n_blCgIpDO.setId_par(null);
		n_blCgIpDO.setFg_recg(FBoolean.TRUE);
		n_blCgIpDO.setFg_refund(FBoolean.FALSE);
		n_blCgIpDO.setId_recg_ip(recgIpDO.getId_recg_ip());
		n_blCgIpDO.setDt_cg(recgIpDO.getDt_recg());
		n_blCgIpDO.setId_emp_cg(operatorInfo.getId_emp());
		n_blCgIpDO.setId_dep_cg(operatorInfo.getId_dep());
		n_blCgIpDO.setId_org_cg(operatorInfo.getId_org());
		n_blCgIpDO.setStatus(DOStatus.NEW);

		return n_blCgIpDO;
	}
}
