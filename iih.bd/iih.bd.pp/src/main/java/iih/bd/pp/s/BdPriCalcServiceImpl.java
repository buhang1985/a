package iih.bd.pp.s;

import java.util.Map;

import iih.bd.base.utils.CollectionUtils;
import iih.bd.pp.bp.pri.BatchCalcBlTplPriceBP;
import iih.bd.pp.bp.pri.BatchCalcBlTplPriceByPripatBP;
import iih.bd.pp.bp.pri.BatchCalcPatPriBP;
import iih.bd.pp.bp.pri.BatchCalcStdPriBP;
import iih.bd.pp.bp.pri.CalcPatPriBP;
import iih.bd.pp.bp.pri.CalcSrvPriRateBP;
import iih.bd.pp.bp.pri.CalcStdPriBP;
import iih.bd.pp.dto.d.BlTplPriceDTO;
import iih.bd.pp.dto.d.PriceRateDTO;
import iih.bd.pp.dto.d.PriceReqDTO;
import iih.bd.pp.dto.d.PriceResultDTO;
import iih.bd.pp.i.IBdPriCalcService;
import iih.bd.pp.priceengine.PriceEngine;
import iih.bd.pp.pripat.d.PripatAggDO;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FDateTime;

/**
 * 计价服务
 * @author yankan
 * @since 2017-07-10
 * @version ly 2018/05/11 修改价格系数获取
 */
@Service(serviceInterfaces={IBdPriCalcService.class}, binding=Binding.JSONRPC)
public class BdPriCalcServiceImpl implements IBdPriCalcService{
	/**
	 * 计算标准价格
	 * @param srvId 服务ID
	 * @return 计价结果DTO
	 * @throws BizException
	 * @author yankan
	 */
	@Override
	public PriceResultDTO calcStdPrice(String srvId) throws BizException{
		CalcStdPriBP calcBP = new CalcStdPriBP();
		return calcBP.exec(srvId);
	}
	/**
	 * 获取价格系数
	 * @param pripatAgg 患者价格分类Agg
	 * @param srvId 服务ID
	 * @param srvTpCode 服务类型编码
	 * @param time 时间
	 * @return 价格系数
	 * @throws BizException
	 */
	@Override
	public PriceRateDTO calcPatPriRate(PripatAggDO pripatAgg, String srvId, String srvTpCode, FDateTime time) throws BizException{
		CalcSrvPriRateBP calcRateBP = new CalcSrvPriRateBP();
		return calcRateBP.exec(pripatAgg, srvId, srvTpCode, time);
	}
	/**
	 * 计算患者分类价格
	 * @param srvId 服务ID
	 * @param pripatId 患者价格分类ID
	 * @return 计算价格结果DTO
	 * @throws BizException
	 * @author yankan
	 */
	@Override
	public PriceResultDTO calcPatPrice(String srvId,String pripatId) throws BizException{
		CalcPatPriBP calcPriBP = new CalcPatPriBP();
		return calcPriBP.exec(srvId, pripatId);
	}
	/**
	 * 批量计算标准服务
	 * @param srvIds 服务ID集合
	 * @return 计价结果Map,[Key：服务ID,value：计算价格结果]
	 * @throws BizException
	 * @author yankan
	 */
	@Override
	public Map<String, PriceResultDTO> batchCalcStdPrice(String[] srvIds) throws BizException {
		BatchCalcStdPriBP calPriBP = new BatchCalcStdPriBP();
		return calPriBP.exec(srvIds);
	}
	/**
	 * 批量计价患者价格
	 * @param srvIds 服务ID集合
	 * @param pripatId 患者价格分类ID
	 * @return 计价结果Map,[Key：服务ID,value：计算价格结果]
	 * @throws BizException
	 * @author yankan
	 */
	@Override
	public Map<String, PriceResultDTO> batchCalcPatPrice(String[] srvIds, String pripatId) throws BizException {
		BatchCalcPatPriBP calPriBP = new BatchCalcPatPriBP();
		return calPriBP.exec(srvIds, pripatId);
	}
	/**
	 * 批量计算患者分类价格
	 * @param srvIds 服务ID集合
	 * @param pripatId 患者价格分类ID
	 * @return 计价结果Map,[Key：服务ID,value：计算价格结果]
	 * @throws BizException
	 * @author yankan
	 */
	@Override
	public FMap batchCalcPatPrice4Front(String[] srvIds,String pripatId) throws BizException{
		BatchCalcPatPriBP calPriBP = new BatchCalcPatPriBP();
		Map resultMap = calPriBP.exec(srvIds, pripatId);
		FMap fmap = CollectionUtils.convertToFMap(resultMap);
		return fmap;
	}
	/**
	 * 计算价格
	 * @param primdCode
	 * @param priceReqList
	 * @return
	 * @throws BizException
	 * @author yankan
	 */
	@Override
	public Map<String, PriceResultDTO> batchCalcPriceByPrimd(String primdCode,PriceReqDTO[] priceReqList) throws BizException {
		PriceEngine engine = new PriceEngine();
		return engine.calcPrice(primdCode, priceReqList);
	}
	/**
	 * 计算费用模板价格
	 * @param tplIds 费用模板ID
	 * @return 计价结果Map,[Key：费用模板ID,value：费用模板价格DTO]
	 * @throws BizException
	 * @author yankan
	 */
	@Override
	public Map<String,BlTplPriceDTO> batchCalcBlTplPrice(String[] tplIds) throws BizException{
		BatchCalcBlTplPriceBP calcPriceBP = new BatchCalcBlTplPriceBP();
		return calcPriceBP.exec(tplIds);
	}
	
	/**
	 * 结算费用模板价格-带价格系数
	 * @param tplIds
	 * @param priPatId
	 * @return
	 * @throws BizException
	 */
	@Override
	public Map<String, BlTplPriceDTO> batchCalcBlTplPriceByPripat(String[] tplIds, String pripatId)
			throws BizException {
		BatchCalcBlTplPriceByPripatBP bp = new BatchCalcBlTplPriceByPripatBP();
		return bp.exec(tplIds, pripatId);
	}
}
