package iih.bd.pp.bp.pri;

import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.ArrayUtils;

import iih.bd.base.utils.AppUtils;
import iih.bd.base.utils.PrecisionUtils;
import iih.bd.pp.dto.d.PriceRateDTO;
import iih.bd.pp.dto.d.PriceResultDTO;
import iih.bd.pp.i.IBdPpMsgConst;
import iih.bd.pp.pripat.d.PripatAggDO;
import iih.bd.pp.pripat.i.IPripatRService;
import iih.bd.srv.medsrv.d.MedSrvDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 计算患者价格
 * 
 * @author yankan
 * @since 2017-08-15
 * @version ly 2018/05/11 修改价格系数获取
 * 
 */
public class BatchCalcPatPriBP {
	/**
	 * 计算服务价格
	 * 
	 * @param srvIds
	 * @param pripatId
	 * @return 服务价格对象集合
	 * @throws BizException
	 */
	public Map<String, PriceResultDTO> exec(String[] srvIds, String pripatId) throws BizException {
		if (ArrayUtils.isEmpty(srvIds)) {
			return null;
		}

		// 1、计算标准价格
		BatchCalcStdPriBP calcPriBP = new BatchCalcStdPriBP();
		Map<String, PriceResultDTO> priRstMap = calcPriBP.exec(srvIds);

		// 2、获取价格分类
		PripatAggDO priPatAggDO = getPriPat(pripatId);
		if (priPatAggDO == null) {
			throw new BizException(IBdPpMsgConst.ERROR_PRI_PAT_NOT_EXIST);
		}
		
		// 3、加载服务类型
		this.loadSrvTp(priRstMap);
		
		// 4、乘以价格比例
		FDateTime currentTime = AppUtils.getServerDateTime();
		
		CalcSrvPriRateBP calcRateBP = new CalcSrvPriRateBP();
		for (PriceResultDTO resultDTO : priRstMap.values()) {
			PriceRateDTO rateDto = calcRateBP.exec(priPatAggDO, resultDTO.getId_srv(), resultDTO.getSd_srvtp(), currentTime);
			resultDTO.setRate(PrecisionUtils.formatPresion(rateDto.getRate(),2));
			if(rateDto.getPrice_ratio() == null){
				resultDTO.setPrice_ratio(resultDTO.getPrice_std().multiply(resultDTO.getRate()));
			}else{
				resultDTO.setPrice_ratio(rateDto.getPrice_ratio());
			}
			
			//修改精度
			resultDTO.setPrice_std(PrecisionUtils.formatPrice(resultDTO.getPrice_std()));
			resultDTO.setPrice_ratio(PrecisionUtils.formatPrice(resultDTO.getPrice_ratio()));
		}

		return priRstMap;
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
	 * 加载服务类型
	 * @param priRstMap
	 * @throws BizException
	 */
	private void loadSrvTp(Map<String, PriceResultDTO> priRstMap) throws BizException{
		GetSrvListBP getSrvListBP = new GetSrvListBP();
		Map<String,MedSrvDO> srvMap = getSrvListBP.exec(priRstMap.keySet().toArray(new String[0]));
		if(srvMap==null || srvMap.size()<=0){
			return;
		}
		
		for(Entry<String,PriceResultDTO> item : priRstMap.entrySet()){
			item.getValue().setSd_srvtp(srvMap.get(item.getKey()).getSd_srvtp());
		}
	}
}
