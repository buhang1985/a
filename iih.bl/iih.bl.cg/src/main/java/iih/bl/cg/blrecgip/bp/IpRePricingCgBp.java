package iih.bl.cg.blrecgip.bp;

import iih.bd.pp.dto.d.SrvPricalRateAndPriceDTO;
import iih.bd.pp.primd.i.IPriCalService;
import iih.bd.pp.pripat.d.PriPatDO;
import iih.bl.cg.blcgquery.d.BlCgIpDO;
import iih.bl.cg.blcgquery.d.BookRtnDirectEnum;
import iih.bl.cg.blcgquery.i.IBlcgqueryCudService;
import iih.bl.cg.blcgquery.i.IBlcgqueryRService;
import iih.bl.cg.blrecgip.d.BlRecgIpDO;
import iih.bl.cg.blrecgip.i.IBlrecgipCudService;
import iih.bl.cg.service.d.OperatorInfoDTO;
import iih.en.pv.i.IEnOutCmdService;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.i.IPatiMDOCudService;
import iih.pi.reg.pat.i.IPatiMDORService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.dbutils.handlers.ColumnListHandler;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.service.time.TimeService;
import xap.mw.core.service.time.impl.TimeServiceImpl;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 住院重划价业务逻辑
 * 
 * @author 唐婵懿
 * @since 2016-07-18
 */
public class IpRePricingCgBp {
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
	public FBoolean ipRePricingCgBp(String id_ent, String id_pripat_from,
			String id_pripat_to, OperatorInfoDTO operatorInfo)
			throws BizException {
		FBoolean fRePricingSuccess = FBoolean.TRUE;
		TimeService timeService = new TimeServiceImpl();
		FDateTime strDateTime = timeService.getUFDateTime();
		// 1.查找指定就诊下未完成出院结算的费用明细
		IBlcgqueryRService cgRService = ServiceFinder
				.find(IBlcgqueryRService.class);
		BlCgIpDO[] orgin_BlCgIpDO1 = cgRService.find("id_ent='" + id_ent
				+ "' and fg_st = 'N' and code_enttp='10'",
				"  id_or,id_orsrv,id_srv ", FBoolean.TRUE);
		if (orgin_BlCgIpDO1 != null && orgin_BlCgIpDO1.length > 0) {
			// throw new BizException("没有找到该就诊下对应的未结算信息！");

			// 2.保存重划价记录
			BlRecgIpDO blRecgIpDO = new BlRecgIpDO();
			blRecgIpDO.setId_recg_ip(null);
			blRecgIpDO.setDt_recg(strDateTime);
			blRecgIpDO.setId_pripat_from(id_pripat_from);
			blRecgIpDO.setId_pripat_to(id_pripat_to);
			blRecgIpDO.setId_emp_recg(operatorInfo.getId_emp());
			blRecgIpDO.setId_org(operatorInfo.getId_org());
			blRecgIpDO.setId_grp(operatorInfo.getId_grp());
			blRecgIpDO.setStatus(DOStatus.NEW);
			IBlrecgipCudService iBlrecgipCudService = ServiceFinder
					.find(IBlrecgipCudService.class);
			BlRecgIpDO[] blRecgIpDOArr1 = new BlRecgIpDO[] { blRecgIpDO };
			BlRecgIpDO[] blRecgIpDOArr = iBlrecgipCudService
					.save(blRecgIpDOArr1);
			if (blRecgIpDOArr == null || blRecgIpDOArr.length == 0) {
				throw new BizException("保存重划价记录失败！");
			}

			// 3.按id_par=id_cgip合并记录,体现在修改数量上
			Map<String, BlCgIpDO> temp_map = new HashMap<String, BlCgIpDO>();
			String id_par = "", id_cgip = "";
			FDouble new_Quan = new FDouble(0);
			for (BlCgIpDO blCgIpDO1 : orgin_BlCgIpDO1) {
				id_par = blCgIpDO1.getId_par();
				if (id_par != null && id_par.length() > 1) {
					if (temp_map.containsKey(id_par)) {
						BlCgIpDO tempdo = temp_map.get(id_par);
						new_Quan = tempdo
								.getQuan()
								.multiply(tempdo.getEu_direct())
								.add(blCgIpDO1.getQuan().multiply(
										blCgIpDO1.getEu_direct()));
						if (new_Quan.compareTo(new FDouble()) < 0) {
							tempdo.setEu_direct(-1);
						} else if (new_Quan.compareTo(new FDouble()) > 0) {
							tempdo.setEu_direct(1);
						}
						else //如果为0，则跳过
						{
							continue;
						}
						tempdo.setQuan(new_Quan.abs());
					} else {
						temp_map.put(blCgIpDO1.getId_cgip(), blCgIpDO1);
					}
				} else {
					temp_map.put(blCgIpDO1.getId_cgip(), blCgIpDO1);
				}
				// 设置重划价主键
				blCgIpDO1.setFg_refund(FBoolean.TRUE);// 原明细数据
				blCgIpDO1.setFg_recg(FBoolean.TRUE);
				blCgIpDO1.setStatus(DOStatus.UPDATED);
			}
			// 保存更新的重划价主键
			IBlcgqueryCudService cgService = ServiceFinder
					.find(IBlcgqueryCudService.class);
			BlCgIpDO[] BlCgIpDOs1 = cgService.save(orgin_BlCgIpDO1);
			if (BlCgIpDOs1 == null || BlCgIpDOs1.length == 0) {
				fRePricingSuccess = FBoolean.FALSE;
			}

			List<BlCgIpDO> blCgIpDOLst = new ArrayList<BlCgIpDO>();
			Iterator iter_cg = temp_map.entrySet().iterator();
			while (iter_cg.hasNext()) {
				Entry e = (Entry) iter_cg.next();
				id_cgip = (String) e.getKey();
				blCgIpDOLst.add(temp_map.get(id_cgip));
			}
			BlCgIpDO[] orgin_BlCgIpDO = blCgIpDOLst.toArray(new BlCgIpDO[0]);

			// 4.获得价格分类下的特殊项目
			IPriCalService iPriCalService = ServiceFinder
					.find(IPriCalService.class);
			SrvPricalRateAndPriceDTO[] srvPricalRateAndPriceDTOArr = iPriCalService
					.GetAllSrvRatelByIdPripat(id_pripat_to);

			// 5.获得新价格分类下的默认比例
			String[] fields = { "Id_pripat", "Rate" };
			DAFacade dAFacade = new DAFacade();
			List<PriPatDO> priPatDOList = (List<PriPatDO>) dAFacade.findByCond(
					PriPatDO.class, " Id_pripat='" + id_pripat_to + "' ", "1",
					fields);
			if (ListUtil.isEmpty(priPatDOList) || priPatDOList.size() == 0) {
				throw new BizException("没有找到患者就诊对应的价格分类 ！");
			}
			FDouble new_ration = priPatDOList.toArray(new PriPatDO[0])[0]
					.getRate();

			// 5.红冲原费用明细,并生成新的费用明细
			FDouble amt_acc_orgin = new FDouble(0); // 原来消费额度
			FDouble amt_acc_new = new FDouble(0); // 新消费额度
			BlCgIpDO new_blCgIpDO = new BlCgIpDO();
			List<BlCgIpDO> save_blCgIpDOList = new ArrayList<BlCgIpDO>();

			for (BlCgIpDO blCgIpDO : orgin_BlCgIpDO) {
				// 原来消费额度
				amt_acc_orgin = amt_acc_orgin.add(blCgIpDO.getAmt_ratio()
						.multiply(blCgIpDO.getEu_direct()));
				// 红冲记录
				save_blCgIpDOList.add(getRedBlCgIpDO(blCgIpDO, operatorInfo,
						blRecgIpDOArr[0].getId_recg_ip(), strDateTime));
				// 重收记录
				new_blCgIpDO = getNewChargeBlCgIpDO(blCgIpDO, operatorInfo,
						blRecgIpDOArr[0].getId_recg_ip(), strDateTime,
						srvPricalRateAndPriceDTOArr, new_ration);
				save_blCgIpDOList.add(new_blCgIpDO);
				// 新消费额度
				amt_acc_new = amt_acc_new.add(new_blCgIpDO.getAmt_ratio()
						.multiply(new_blCgIpDO.getEu_direct()));

			}

			// 6.保存住院费用明细
			BlCgIpDO[] BlCgIpDOs = cgService.save(save_blCgIpDOList
					.toArray(new BlCgIpDO[0]));
			if (BlCgIpDOs == null || BlCgIpDOs.length == 0) {
				fRePricingSuccess = FBoolean.FALSE;
			}

			// 7.修改就诊账户的消费额度
			entAccConsume(id_ent, amt_acc_orgin, amt_acc_new);
		}
		// 8.更新就诊域的EN_ENT.id_pripat
		IEnOutCmdService iEnOutCmdService = ServiceFinder
				.find(IEnOutCmdService.class);
		iEnOutCmdService.updateEntPriPat(id_ent, id_pripat_to);
		//查询id_ent 对应的患者id_pat
		String sql = "select id_pat from en_ent where id_ent = '" + id_ent +"'";
		List<String> list = (List<String>) new DAFacade().execQuery(sql, new ColumnListHandler());
		// 9.更新PI域PI_PAT.ID_PRIPAT字段
		IPatiMDORService iPatiMDORService = ServiceFinder
				.find(IPatiMDORService.class);
		PatDO patDo = iPatiMDORService.findById(list.get(0));
		patDo.setId_patpritp(id_pripat_to);
		patDo.setStatus(DOStatus.UPDATED);
		PatDO[] patDos = new PatDO[] { patDo };
		IPatiMDOCudService iPatiMDOCudService = ServiceFinder
				.find(IPatiMDOCudService.class);
		PatDO[] patDoArr = iPatiMDOCudService.save(patDos);
		if (patDoArr == null || patDoArr.length == 0) {
			throw new BizException("更新PI领域价格分类失败！");
		}

		return fRePricingSuccess;
	}

	/**
	 * 修改就诊账户的消费额度
	 * 
	 * @param id_ent
	 *            就诊ID
	 * @param amt_acc_orgin
	 *            红冲的总金额
	 * @param amt_acc_new
	 *            重收的总金额
	 */
	private void entAccConsume(String id_ent, FDouble amt_acc_orgin,
			FDouble amt_acc_new) throws BizException {
		IEnOutCmdService enAccService = ServiceFinder
				.find(IEnOutCmdService.class);
		enAccService.consume(id_ent, amt_acc_orgin.multiply(-1)
				.add(amt_acc_new));// sql中采用的加，因此先还原以前的消费额在减去新额度
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
	private BlCgIpDO getRedBlCgIpDO(BlCgIpDO orgin_blCgIpDO,
			OperatorInfoDTO operatorInfo, String id_recg_ip,
			FDateTime strDateTime) {
		BlCgIpDO r_blCgIpDO = new BlCgIpDO();
		r_blCgIpDO = (BlCgIpDO) orgin_blCgIpDO.clone();
		r_blCgIpDO.setNote("重划价(红冲):"+r_blCgIpDO.getId_cgip());
		r_blCgIpDO.setId_cgip(null);
		if (r_blCgIpDO.getEu_direct() == BookRtnDirectEnum.REFUND) {
			r_blCgIpDO.setEu_direct(BookRtnDirectEnum.CHARGES);
		} else {
			r_blCgIpDO.setEu_direct(BookRtnDirectEnum.REFUND);
		}
		r_blCgIpDO.setPrice(orgin_blCgIpDO.getPrice());
		r_blCgIpDO.setPrice_ratio(orgin_blCgIpDO.getPrice_ratio());
		r_blCgIpDO.setQuan(orgin_blCgIpDO.getQuan());
		r_blCgIpDO.setAmt_std(orgin_blCgIpDO.getAmt_std());
		r_blCgIpDO.setAmt_ratio(orgin_blCgIpDO.getAmt_ratio());
		r_blCgIpDO.setAmt(orgin_blCgIpDO.getAmt());
		r_blCgIpDO.setAmt_pat(orgin_blCgIpDO.getAmt_pat());
		r_blCgIpDO.setAmt_hp(orgin_blCgIpDO.getAmt_hp());

		r_blCgIpDO.setId_par(null);
		r_blCgIpDO.setFg_recg(FBoolean.TRUE);
		r_blCgIpDO.setFg_refund(FBoolean.FALSE);
		r_blCgIpDO.setId_recg_ip(id_recg_ip);
		r_blCgIpDO.setDt_cg(strDateTime);
		r_blCgIpDO.setId_emp_cg(operatorInfo.getId_emp());
		r_blCgIpDO.setId_dep_cg(operatorInfo.getId_dep());
		r_blCgIpDO.setId_org_cg(operatorInfo.getId_org());
		r_blCgIpDO.setStatus(DOStatus.NEW);
		
//		r_blCgIpDO.setFg_refund(FBoolean.FALSE); // 作为项目减免过滤条件
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
	 * @param specicalSrvPricalRateAndPriceDTOArr
	 *            新价格分类下的特需项目价格比例
	 * @param new_ration
	 *            新价格分类下的默认价格比例
	 * @return 重划价的记账信息
	 */
	private BlCgIpDO getNewChargeBlCgIpDO(BlCgIpDO orgin_blCgIpDO,
			OperatorInfoDTO operatorInfo, String id_recg_ip,
			FDateTime strDateTime,
			SrvPricalRateAndPriceDTO[] specicalSrvPricalRateAndPriceDTOArr,
			FDouble new_ration) {
		FDouble amt_ratio = null;

		BlCgIpDO n_blCgIpDO = new BlCgIpDO();
		n_blCgIpDO = (BlCgIpDO) orgin_blCgIpDO.clone();
		n_blCgIpDO.setNote("重划价(重收):"+n_blCgIpDO.getId_cgip());
		n_blCgIpDO.setId_cgip(null);
		// 重收不改原记录方便
		// n_blCgIpDO.setEu_direct(BookRtnDirectEnum.CHARGES);

		// if(n_blCgIpDO.getEu_direct()==BookRtnDirectEnum.REFUND)
		// {
		// n_blCgIpDO.setEu_direct(BookRtnDirectEnum.CHARGES);
		// }
		// else
		// {
		// n_blCgIpDO.setEu_direct(BookRtnDirectEnum.REFUND);
		// }

		n_blCgIpDO.setQuan(orgin_blCgIpDO.getQuan());
		n_blCgIpDO.setAmt_std(orgin_blCgIpDO.getAmt_std());

		// 情况单价和比例
		FDouble orgin_Price = n_blCgIpDO.getPrice();

		n_blCgIpDO.setRatio_pripat(null);
		n_blCgIpDO.setAmt_ratio(null);
		n_blCgIpDO.setAmt_pat(null);
		n_blCgIpDO.setAmt(null);
		for (SrvPricalRateAndPriceDTO pri : specicalSrvPricalRateAndPriceDTOArr) {
			if (pri.getId_srv() != null) {
				if (n_blCgIpDO.getId_srv().equals(pri.getId_srv())) 
				{
					if (pri.getPrice() != null) {
						n_blCgIpDO.setPrice(pri.getPrice()); // 价格和比例同时存在时，价格优先
						n_blCgIpDO.setPrice_ratio(pri.getPrice());
						amt_ratio = n_blCgIpDO.getPrice_ratio().multiply(
								n_blCgIpDO.getQuan().setScale(-2,
										BigDecimal.ROUND_HALF_UP));
						n_blCgIpDO.setRatio_pripat(new FDouble(1));
					} else {
						n_blCgIpDO.setRatio_pripat(pri.getRate());
					}
					break;
				}
			}
		}

		if (n_blCgIpDO.getRatio_pripat() == null) // 没有特殊的就按价格分类的默认比例走
		{
			n_blCgIpDO.setRatio_pripat(new_ration);
		}
		
		n_blCgIpDO.setPrice_ratio(n_blCgIpDO.getPrice().multiply(n_blCgIpDO.getRatio_pripat()).setScale(-4,
										BigDecimal.ROUND_HALF_UP));

		if (amt_ratio == null) {
			amt_ratio = n_blCgIpDO.getPrice_ratio().multiply(n_blCgIpDO.getQuan()).setScale(-2,
							BigDecimal.ROUND_HALF_UP);
		}

		n_blCgIpDO.setAmt_ratio(amt_ratio);
		n_blCgIpDO.setAmt(amt_ratio);
		n_blCgIpDO.setAmt_pat(amt_ratio);
		n_blCgIpDO.setAmt_hp(orgin_blCgIpDO.getAmt_hp());

		n_blCgIpDO.setId_par(null);
		n_blCgIpDO.setFg_recg(FBoolean.TRUE);
		n_blCgIpDO.setFg_refund(FBoolean.FALSE);
		n_blCgIpDO.setId_recg_ip(id_recg_ip);
		n_blCgIpDO.setDt_cg(strDateTime);
		n_blCgIpDO.setId_emp_cg(operatorInfo.getId_emp());
		n_blCgIpDO.setId_dep_cg(operatorInfo.getId_dep());
		n_blCgIpDO.setId_org_cg(operatorInfo.getId_org());
		n_blCgIpDO.setStatus(DOStatus.NEW);
		
		return n_blCgIpDO;
	}

}
