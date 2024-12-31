package iih.bd.pp.bp.pri;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.base.utils.AppUtils;
import iih.bd.base.validator.ParamValidator;
import iih.bd.pp.dto.d.PriceRateDTO;
import iih.bd.pp.pripat.d.PripatAggDO;
import iih.bd.pp.pripat.i.IPripatRService;
import iih.bd.srv.medsrv.d.MedSrvDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 获取医疗服务的价格系数
 * @author yankan
 * @since 2017-08-14
 * @version ly 2018/05/11 修改价格系数获取
 * 
 */
public class BatchCalcSrvPriRateBP {
	/**
	 * 获取医疗服务的价格系数
	 * @param priPatId 患者价格分类ID
	 * @param srvIds 医疗服务ID集合
	 * @return map，[Key: 服务ID，Value:系数]
	 * @throws BizException
	 */
	public Map<String,PriceRateDTO> exec(String priPatId, String[] srvIds) throws BizException {
		// 参数校验
		ParamValidator.validateNotNull("患者价格分类ID", priPatId);
		ParamValidator.validateNotNull("医疗服务ID", srvIds);

		// 1、获取价格分类
		PripatAggDO priPatAggDO = getPriPat(priPatId);
		if (priPatAggDO == null) {
			throw new BizException("患者价格分类不存在！");
		}

		// 2、获取医疗服务集合
		List<MedSrvDO> srvList = this.getSrvList(srvIds);

		// 3、计算价格系数
		FDateTime currentTime = AppUtils.getServerDateTime();
		Map<String, PriceRateDTO> srvRateMap = new HashMap<String,PriceRateDTO>();
		for (MedSrvDO srvDO : srvList) {
			
			CalcSrvPriRateBP calRateBP = new CalcSrvPriRateBP();
			PriceRateDTO rateDto = calRateBP.exec(priPatAggDO, srvDO.getId_srv(),srvDO.getSd_srvtp(), currentTime);
			
			srvRateMap.put(srvDO.getId_srv(), rateDto);
		}
		return srvRateMap;
	}

	/**
	 * 获取患者价格分类Agg
	 * 
	 * @param priPatId 患者价格分类ID
	 * @return
	 * @throws BizException
	 */
	private PripatAggDO getPriPat(String priPatId) throws BizException {
		IPripatRService priPatRService = ServiceFinder.find(IPripatRService.class);
		PripatAggDO priPatAggDO = priPatRService.findById(priPatId);
		return priPatAggDO;
	}

	/**
	 * 获取医疗服务集合
	 * 
	 * @param srvIds 医疗服务ID
	 * @return 医疗服务DO集合
	 * @throws BizException
	 */
	private List<MedSrvDO> getSrvList(String[] srvIds) throws BizException {
		String[] fields = new String[] { MedSrvDO.ID_SRV, MedSrvDO.NAME, MedSrvDO.SD_SRVTP };
		List<MedSrvDO> srvList = (List<MedSrvDO>) new DAFacade().findByPKs(MedSrvDO.class, srvIds, fields);
		return srvList;
	}
}
