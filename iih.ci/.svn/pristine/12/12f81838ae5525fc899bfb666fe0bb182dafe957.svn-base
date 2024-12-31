package iih.ci.sdk.price;

import java.util.Map;

import iih.bd.pp.dto.d.SrvPricalRateAndPriceDTO;
import iih.bd.pp.primd.i.IBdPrimdCodeConst;
import iih.bd.pp.primd.i.IPriCalService;
import iih.bd.srv.medsrv.d.MedSrvPriceDO;
import iih.ci.ord.srvpri.d.BdSrvPriCalParamDTO;
import iih.ci.sdk.utils.CiDwsUtils;
import iih.ci.sdk.utils.CiOrSrvPriHelper;
import iih.ci.sdk.utils.CiOrdAppUtils;
import iih.ci.sdk.utils.ObjectUtils;
import iih.mm.itf.material.d.GetStockReqDTO;
import iih.mm.itf.material.d.MaterialStockDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDouble;

/**
 * 临床医嘱选择服务，服务价格计算操作BP (有待优化）
 * @author wangqingzhu
 *
 */
public class CiOrBdSrvPriceCalBP {
	
	/**
	 * 获得物品对应总量单位下的单价
	 * 
	 * @param id_mm
	 * @param Id_pgku_cur
	 * @return
	 */
	public FDouble getMmPriceByPkgu(String id_mm, String Id_pgku_cur) {
		if (ObjectUtils.isEmpty(id_mm) || ObjectUtils.isEmpty(Id_pgku_cur))
			return null;
		GetStockReqDTO reqDto = new GetStockReqDTO();
		reqDto.setId_mm(id_mm);
		reqDto.setReq_unit_id(Id_pgku_cur);
		GetStockReqDTO[] reqDtoArr = new GetStockReqDTO[1];
		reqDtoArr[0] = reqDto;
		MaterialStockDTO[] materials = null;
		try {
			materials = CiOrdAppUtils.getMaterialStockQryService()
					.getMaterialStocks(reqDtoArr);
		} catch (BizException e) {
			e.printStackTrace();
		}
		if (materials != null && materials.length > 0) {
			return materials[0].getPrice_act();
		} else {
			return null;
		}
	}
	
	/**
	 * 获得医嘱项目对应的价格 门诊、非物品、本服务定价  (是否需要患者价格分类参与？）
	 * 
	 * @param code_entp
	 * @param id_srv
	 * @param pri
	 * @param id_primd
	 * @return
	 * @throws BizException
	 */
	public FDouble getOrSrvPrice(String code_entp, String id_srv,
			FDouble pri, String id_primd) throws BizException {
		if (!ObjectUtils.isEmpty(pri))
			return pri; // 不空则返回
		if (!CiDwsUtils.isOpWf(code_entp)&&!CiDwsUtils.isUrgentWf(code_entp))
			return pri; // 不是门急诊则返回
		if (!IBdPrimdCodeConst.ID_PRI_SRV.equals(id_primd))
			return pri; // 不是本服务定价则返回
		// 
		return CiOrdAppUtils.getPriCalService().CalSingleSrvStdPrice(id_srv);
	}

	/**
	 * 折扣价计算方法
	 * 
	 * @param param
	 * @param id_pripat
	 * @return
	 * @throws BizException
	 */
	public MedSrvPriceDO exec(BdSrvPriCalParamDTO param, String id_pripat) throws BizException {
		// 有效性判断处理
		if (!validateCheck(param))
			return null;
		String id_primd = param.getId_primd(), id_srv = param.getId_srv();
		Integer num = param.getNum();

		MedSrvPriceDO medSrvPriceDO = new MedSrvPriceDO();
		medSrvPriceDO.setId_srv(id_srv);
		medSrvPriceDO.setId_pripat(id_pripat);
		medSrvPriceDO.setDes_pri("");

		IPriCalService ipricalsrv = CiOrdAppUtils.getPriCalService();
		CiOrSrvSetNotClinicalItemsBP itemsBp = new CiOrSrvSetNotClinicalItemsBP();
		if (CiOrSrvPriHelper.isSrvSelfPrimd(id_primd)) {
			// 本服务定价模式
			SrvPricalRateAndPriceDTO o = ipricalsrv.CalSingleSrvPriceByIdPripat_NameTip(id_srv, param.getName_srv(),
					id_pripat);
			medSrvPriceDO.setPrice_ratio(o.getPrice_ratio());
			medSrvPriceDO.setPrice_std(o.getPrice());
			medSrvPriceDO.setRatio(o.getRate());
		} else if (CiOrSrvPriHelper.isSrvsetMemberSumPrimd(id_primd)) {
			// 套成员合计计价模式
			// 传入的主要参数应为 srvsetitms
			if (ObjectUtils.isEmpty(param.getSrvsetitms())) {
				// 前台只传入id_srv,需要计算出所有临床和非临床的价格
				Map<String, FDouble> setquanmap = itemsBp.exec(param);
				FDouble szPrice[] = getSrvSetSumPri(param, id_pripat, setquanmap);
				if (!ObjectUtils.isEmpty(szPrice)) {
					medSrvPriceDO.setPrice_ratio(szPrice[0]);
					medSrvPriceDO.setPrice_std(szPrice[1]);
				}
			} else {
				// 前台传入了临床项目，还要计算非临床的服务项目
				FDouble[] szPrice = getSrvSetSumPri(param, id_pripat, null);
				Map<String, FDouble> srvsetquan = itemsBp.notClinicalItems(param);
				FDouble szNotClinicalPrice[] = getSrvSetSumPri(param, id_pripat, srvsetquan);
				if (!ObjectUtils.isEmpty(szNotClinicalPrice)) {
					szPrice[0] = szPrice[0].add(szNotClinicalPrice[0]);
					szPrice[1] = szPrice[1].add(szNotClinicalPrice[1]);
				}
				medSrvPriceDO.setPrice_ratio(szPrice[0]);
				medSrvPriceDO.setPrice_std(szPrice[1]);
			}
		} else if (CiOrSrvPriHelper.isSrvsetMemCntAdditionalPrimd(id_primd)) {
			// 套成员个数加收计价模式
			Map<String, Map<String, SrvPricalRateAndPriceDTO>> rstMap = ipricalsrv
					.CalSrvSetMUPricesByIdPripat_map(id_srv, num, id_pripat);
			if (null == rstMap || rstMap.values().size() == 0) {
				throw new BizException("个数加收计算总价失败，请检查费用对照配置是否正确！");
			}
			Map<String, SrvPricalRateAndPriceDTO> srvPricalRateAndPriceMap = rstMap.get(id_srv);
			if (null == srvPricalRateAndPriceMap) {
				throw new BizException("个数加收计算总价失败，请检查费用对照配置是否正确！");
			}
			FDouble[] sumPrice = getPriceSum(
					srvPricalRateAndPriceMap.values().toArray(new SrvPricalRateAndPriceDTO[] {}));
			if (sumPrice == null) {
				throw new BizException("个数加收计算总价失败，请检查费用对照配置是否正确！");
			}
			medSrvPriceDO.setPrice_ratio(sumPrice[0]);
			medSrvPriceDO.setPrice_std(sumPrice[1]);
			Map<String, FDouble> srvsetquan = itemsBp.notClinicalItems(param);
			FDouble[] szNotClinicalPrice = getSrvSetSumPri(param, id_pripat, srvsetquan);
			if (!ObjectUtils.isEmpty(szNotClinicalPrice) && szNotClinicalPrice.length == 2) {
				FDouble price_ratio = new FDouble(num).multiply(sumPrice[0]);// 折扣价
				FDouble price_std = new FDouble(num).multiply(sumPrice[1]);// 标准价
				medSrvPriceDO.setPrice_ratio(price_ratio.add(szNotClinicalPrice[0]));
				medSrvPriceDO.setPrice_std(price_std.add(szNotClinicalPrice[1]));
			}
		} else if (CiOrSrvPriHelper.isSrvsetMemberCntPrimd(id_primd)) {
			// 套成员个数定价计价模式
			Map<String, Map<String, SrvPricalRateAndPriceDTO>> rstMap = ipricalsrv
					.CalSrvSetFIXPricesByIdPripat_map(id_srv, num, id_pripat);
			if (null == rstMap || rstMap.values().size() == 0) {
				throw new BizException("个数定价计算总价失败，请检查费用对照配置是否正确！");
			}
			Map<String, SrvPricalRateAndPriceDTO> srvPricalRateAndPriceMap = rstMap.get(id_srv);
			if (null == srvPricalRateAndPriceMap) {
				throw new BizException("个数定价计算总价失败，请检查费用对照配置是否正确！");
			}
			FDouble[] sumPrice = getPriceSum(
					srvPricalRateAndPriceMap.values().toArray(new SrvPricalRateAndPriceDTO[] {}));
			sumPrice = sumPrice == null ? new FDouble[] { new FDouble(0), new FDouble(0) } : sumPrice;
			Map<String, FDouble> srvsetquan = itemsBp.notClinicalItems(param);
			FDouble[] szNotClinicalPrice = getSrvSetSumPri(param, id_pripat, srvsetquan);
			szNotClinicalPrice = szNotClinicalPrice == null ? new FDouble[] { new FDouble(0), new FDouble(0) }
					: szNotClinicalPrice;
			if (szNotClinicalPrice.length == 2) {
				medSrvPriceDO.setPrice_ratio(sumPrice[0].add(szNotClinicalPrice[0]));
				medSrvPriceDO.setPrice_std(sumPrice[1].add(szNotClinicalPrice[1]));
			}
		} else if (CiOrSrvPriHelper.isSrvRelMmPrimd(id_primd)) {
			// 物品价格
			// return getPriceSum(ipricalsrv.CalSrvSetFIXPrices(id_srv, num));
			// 调用对应药品价格计算接口
		} else if (CiOrSrvPriHelper.isSrvCompPrimd(id_primd)) {
			// 服务组合定价模式
			Map<String, SrvPricalRateAndPriceDTO> srvPricalRateAndPriceMap = ipricalsrv
					.CalSrvCompPriceByIdPripat_map(id_srv, id_pripat);
			if (null == srvPricalRateAndPriceMap) {
				throw new BizException("组合定价计算总价失败，请检查费用对照配置是否正确！");
			}
			SrvPricalRateAndPriceDTO[] szSrvPricalRateAndPriceInfo = srvPricalRateAndPriceMap.values()
					.toArray(new SrvPricalRateAndPriceDTO[] {});
			FDouble[] sumPrice = getPriceSum(szSrvPricalRateAndPriceInfo);
			if (!ObjectUtils.isEmpty(sumPrice)) {
				medSrvPriceDO.setPrice_ratio(sumPrice[0]);
				medSrvPriceDO.setPrice_std(sumPrice[1]);
			}
			medSrvPriceDO.setRatio(szSrvPricalRateAndPriceInfo[0].getRate());
		} else if (CiOrSrvPriHelper.isSrvFreePrimd(id_primd)) {
			// 服务不付费模式
			medSrvPriceDO.setPrice_ratio(FDouble.ZERO_DBL);
			medSrvPriceDO.setPrice_std(FDouble.ZERO_DBL);
			medSrvPriceDO.setRatio(FDouble.ONE_DBL);
		} else if (CiOrSrvPriHelper.isSrvPluginPrimd(id_primd)) {
			// 服务外挂插件计价模式
			throw new BizException("服务价格计算时，外挂插件价格计算模式尚未支持错误异常！");
		}

		return medSrvPriceDO;
	}

	/**
	 * 有效性校验
	 * 
	 * @param id_srv
	 * @param id_primd
	 * @return
	 */
	private boolean validateCheck(BdSrvPriCalParamDTO param) {
		return !ObjectUtils.isEmpty(param) && !ObjectUtils.isEmpty(param.getId_srv())
				&& !ObjectUtils.isEmpty(param.getId_primd());
	}

	

	private FDouble[] getPriceSum(SrvPricalRateAndPriceDTO[] pridtos) {
		return CiOrSrvPriHelper.getPriceSum(pridtos);
	}


	/**
	 * 
	 * @param param
	 * @param id_pripat
	 * @return
	 * @throws BizException
	 */
	private FDouble[] getSrvSetSumPri(BdSrvPriCalParamDTO param, String id_pripat, Map<String, FDouble> setquanmap)
			throws BizException {
		CiOrSrvSetSumPriMdCalBP bp = new CiOrSrvSetSumPriMdCalBP();
		return bp.exec(param, id_pripat, setquanmap);
	}
}
