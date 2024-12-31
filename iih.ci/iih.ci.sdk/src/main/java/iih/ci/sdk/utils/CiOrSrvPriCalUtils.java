package iih.ci.sdk.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import iih.bd.pp.dto.d.PriStdSrvDTO;
import iih.bd.pp.dto.d.SrvPricalRateAndPriceDTO;
import iih.bd.pp.primd.i.IBdPrimdCodeConst;
import iih.bd.srv.medsrv.d.MedSrvPriceDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.srvpri.d.BdSrvPriCalParamDTO;
import iih.ci.sdk.price.CiOrBdSrvPriceCalBP;
import xap.mw.core.data.BizException;
import xap.mw.core.data.BizRuntimeException;
import xap.mw.core.data.Context;
import xap.mw.coreitf.d.FDouble;

/**
 * 折扣价
 * @author wangqingzhu
 *
 */
public class CiOrSrvPriCalUtils {

	/**
	 * 折扣价，为srv中赋折扣价相关参数（折扣价，标准价，折扣系数，患者的价格分类）
	 * 
	 * @param code_entp
	 * @param srvdto
	 * @param srvdo
	 * @throws BizException
	 */
	public static void mappingPriceRateFromEmsToSrv(String code_entp, String id_srv, String id_primd, OrdSrvDO srvdo)
			throws BizException {
		if (CiDwsUtils.isIpWf(code_entp)) {// 住院
			if (IBdPrimdCodeConst.ID_PRI_SRV.equals(id_primd)) {// 本服务定价
				FDouble price = CiOrdAppUtils.getPriCalService().CalSingleSrvStdPrice(id_srv);
				srvdo.setPri(price);
				srvdo.setPri_std(price);
			}
		} else {
			CiOrBdSrvPriceCalBP bp = new CiOrBdSrvPriceCalBP();
			BdSrvPriCalParamDTO param = new BdSrvPriCalParamDTO();
			CiEnContextDTO cienContext = Context.get().getAttribute("CiEnContextDTO", CiEnContextDTO.class);
			String id_pripat = cienContext.getId_pripat();
			param.setId_srv(id_srv);
			param.setId_primd(id_primd);
			MedSrvPriceDO srvprice = bp.exec(param, id_pripat);
			if (!ObjectUtils.isEmpty(srvprice)) {
				srvdo.setPri(srvprice.getPrice_ratio());
				srvdo.setPri_std(srvprice.getPrice_std());
			}
			srvdo.setId_pripat(cienContext.getId_pripat());
			/**
			 * update GH update date 2018-5-14 reason : 原方法代码中判断不准确
			 */
			// if (!ObjectUtils.isEmpty(srvdo.getPri_std()) && srvdo.getPri_std() !=
			// FDouble.ZERO_DBL) {
			if (!ObjectUtils.isEmpty(srvdo.getPri_std()) && srvdo.getPri_std().compareTo(FDouble.ZERO_DBL) != 0) {
				srvdo.setPri_ratio(srvdo.getPri().div(srvdo.getPri_std()));// 折扣系数
			}
		}
	}

	/**
	 * 折扣价，为srv中赋折扣价相关参数（折扣价，标准价，折扣系数，患者的价格分类）
	 * 
	 * @param code_entp
	 * @param srvdto
	 * @param srvdo
	 * @throws BizException
	 */
	public static void mappingPriceRateFromEmsToSrv(String id_pripat, String code_entp, String id_srv, String id_primd,
			OrdSrvDO srvdo) throws BizException {
		if (CiDwsUtils.isIpWf(code_entp)) {// 住院
			if (IBdPrimdCodeConst.ID_PRI_SRV.equals(id_primd)) {// 本服务定价
				FDouble price = CiOrdAppUtils.getPriCalService().CalSingleSrvStdPrice(id_srv);
				srvdo.setPri(price);
				srvdo.setPri_std(price);
			}
		} else {
			CiOrBdSrvPriceCalBP bp = new CiOrBdSrvPriceCalBP();
			BdSrvPriCalParamDTO param = new BdSrvPriCalParamDTO();

			param.setId_srv(id_srv);
			param.setId_primd(id_primd);
			MedSrvPriceDO srvprice = bp.exec(param, id_pripat);
			if (!ObjectUtils.isEmpty(srvprice)) {
				srvdo.setPri(srvprice.getPrice_ratio());
				srvdo.setPri_std(srvprice.getPrice_std());
			}
			srvdo.setId_pripat(id_pripat);
			/**
			 * update GH update date 2018-5-14 reason : 原方法代码中判断不准确
			 */
			// if (!ObjectUtils.isEmpty(srvdo.getPri_std()) && srvdo.getPri_std() !=
			// FDouble.ZERO_DBL) {
			if (!ObjectUtils.isEmpty(srvdo.getPri_std()) && srvdo.getPri_std().compareTo(FDouble.ZERO_DBL) != 0) {
				srvdo.setPri_ratio(srvdo.getPri().div(srvdo.getPri_std()));// 折扣系数
			}
		}
	}

	/**
	 * 折扣价，成员个数定价，返回价格服务
	 * 
	 * @param Id_srv_set
	 * @param num
	 * @return
	 * @throws BizException
	 */
	public static PriStdSrvDTO[] CalSrvSetFIXPrices(String Id_srv_set, int num) throws BizException {
		CiEnContextDTO cienContext = Context.get().getAttribute("CiEnContextDTO", CiEnContextDTO.class);
		String code_entp = cienContext.getCode_entp();
		if (CiDwsUtils.isIpWf(code_entp)) {// 住院
			return CiOrdAppUtils.getPriCalService().CalSrvSetFIXPrices(Id_srv_set, num);
		} else {
			String id_pripat = cienContext.getId_pripat();
			Map<String, Map<String, SrvPricalRateAndPriceDTO>> priMap = CiOrdAppUtils.getPriCalService()
					.CalSrvSetFIXPricesByIdPripat_map(Id_srv_set, num, id_pripat);
			Map<String, SrvPricalRateAndPriceDTO> srvPricalRateAndPriceDTOMap = priMap.get(Id_srv_set);
			return getPriStdSrvDTOs(srvPricalRateAndPriceDTOMap, Id_srv_set, id_pripat);
		}
	}

	/**
	 * 折扣价，个数加收，返回价格服务
	 * 
	 * @param Id_srv_set
	 * @param num
	 * @return
	 * @throws BizException
	 */
	public static PriStdSrvDTO[] CalSrvSetMUPrices(String Id_srv_set, int num) throws BizException {
		CiEnContextDTO cienContext = Context.get().getAttribute("CiEnContextDTO", CiEnContextDTO.class);
		String code_entp = cienContext.getCode_entp();
		if (CiDwsUtils.isIpWf(code_entp)) {// 住院
			return CiOrdAppUtils.getPriCalService().CalSrvSetMUPrices(Id_srv_set, num);
		} else {
			String id_pripat = cienContext.getId_pripat();
			Map<String, Map<String, SrvPricalRateAndPriceDTO>> priMap = CiOrdAppUtils.getPriCalService()
					.CalSrvSetMUPricesByIdPripat_map(Id_srv_set, num, id_pripat);
			Map<String, SrvPricalRateAndPriceDTO> srvPricalRateAndPriceDTOMap = priMap.get(Id_srv_set);
			return getPriStdSrvDTOs(srvPricalRateAndPriceDTOMap, Id_srv_set, id_pripat);
		}
	}

	/**
	 * 折扣价，组合定价的服务
	 * 
	 * @param Id_srv
	 * @return
	 * @throws BizException
	 */
	public static PriStdSrvDTO[] CalSrvCompPrice(String Id_srv) throws BizException {
		CiEnContextDTO cienContext = Context.get().getAttribute("CiEnContextDTO", CiEnContextDTO.class);
		String code_entp = cienContext.getCode_entp();
		if (CiDwsUtils.isIpWf(code_entp)) {// 住院
			return CiOrdAppUtils.getPriCalService().CalSrvCompPrice(Id_srv);
		} else {
			String id_pripat = cienContext.getId_pripat();
			Map<String, SrvPricalRateAndPriceDTO> priMap = CiOrdAppUtils.getPriCalService()
					.CalSrvCompPriceByIdPripat_map(Id_srv, id_pripat);
			return getPriStdSrvDTOs(priMap, Id_srv, id_pripat);
		}
	}

	/**
	 * 
	 * @param srvPricalRateAndPriceDTOMap
	 * @param Id_srv_set
	 * @param id_pripat
	 * @return
	 */
	private static PriStdSrvDTO[] getPriStdSrvDTOs(Map<String, SrvPricalRateAndPriceDTO> srvPricalRateAndPriceDTOMap,
			String Id_srv_set, String id_pripat) {
		List<PriStdSrvDTO> listPriStdSrvDTO = new ArrayList<PriStdSrvDTO>();
		for (SrvPricalRateAndPriceDTO srvPricalRat : srvPricalRateAndPriceDTOMap.values()) {

			if (StringUtils.isNotBlank(srvPricalRat.getError_msg())) {
				throw new BizRuntimeException(srvPricalRat.getError_msg());
			}
			PriStdSrvDTO priStdSrv = new PriStdSrvDTO();
			priStdSrv.setId_srv(srvPricalRat.getId_srv());
			priStdSrv.setId_pripat(id_pripat);
			priStdSrv.setPrice(srvPricalRat.getPrice_ratio());// 折扣价
			priStdSrv.setQuan(srvPricalRat.getQuan());
			priStdSrv.setAttrVal("Pri_std", srvPricalRat.getPrice());// 标准价
			priStdSrv.setAttrVal("Pri_ratio", srvPricalRat.getRate());// 价格系数
			listPriStdSrvDTO.add(priStdSrv);
		}
		PriStdSrvDTO[] prisrvs = listPriStdSrvDTO.toArray(new PriStdSrvDTO[listPriStdSrvDTO.size()]);
		return prisrvs;
	}

}
