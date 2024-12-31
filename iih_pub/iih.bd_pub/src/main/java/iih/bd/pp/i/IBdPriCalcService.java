package iih.bd.pp.i;

import java.util.Map;

import iih.bd.pp.dto.d.BlTplPriceDTO;
import iih.bd.pp.dto.d.PriceRateDTO;
import iih.bd.pp.dto.d.PriceReqDTO;
import iih.bd.pp.dto.d.PriceResultDTO;
import iih.bd.pp.pripat.d.PripatAggDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FDateTime;

/**
 * 计价服务
 * @author yankan
 * @since 2017-07-10
 * @version ly 2018/05/11 修改价格系数获取
 */
public interface IBdPriCalcService {
	/**
	 * 计算标准价格
	 * @param srvId 服务ID
	 * @return 计价结果DTO
	 * @throws BizException
	 * @author yankan
	 */
	public abstract PriceResultDTO calcStdPrice(String srvId) throws BizException;
	/**
	 * 获取价格系数
	 * @param pripatAgg 患者价格分类Agg
	 * @param srvId 服务ID
	 * @param srvTpCode 服务类型编码
	 * @param time 时间
	 * @return 价格系数
	 * @throws BizException
	 * @author yankan
	 */
	public abstract PriceRateDTO calcPatPriRate(PripatAggDO pripatAgg, String srvId, String srvTpCode, FDateTime time) throws BizException;
	/**
	 * 计算患者分类价格
	 * @param srvId 服务ID
	 * @param pripatId 患者价格分类ID
	 * @return 计算价格结果DTO
	 * @throws BizException
	 * @author yankan
	 */
	public abstract PriceResultDTO calcPatPrice(String srvId,String pripatId) throws BizException;
	/**
	 * 批量计算标准价格
	 * @param srvIds 服务ID集合
	 * @return 计价结果Map,[Key：服务ID,value：计算价格结果]
	 * @throws BizException
	 * @author yankan
	 */
	public abstract Map<String,PriceResultDTO> batchCalcStdPrice(String[] srvIds) throws BizException;
	/**
	 * 批量计算患者分类价格
	 * @param srvIds 服务ID集合
	 * @param pripatId 患者价格分类ID
	 * @return 计价结果Map,[Key：服务ID,value：计算价格结果]
	 * @throws BizException
	 * @author yankan
	 */
	public abstract Map<String,PriceResultDTO> batchCalcPatPrice(String[] srvIds,String pripatId) throws BizException;
	/**
	 * 批量计算患者分类价格
	 * @param srvIds 服务ID集合
	 * @param pripatId 患者价格分类ID
	 * @return 计价结果Map,[Key：服务ID,value：计算价格结果]
	 * @throws BizException
	 * @author yankan
	 */
	public abstract FMap batchCalcPatPrice4Front(String[] srvIds,String pripatId) throws BizException;
	/**
	 * 计算价格
	 * @param primdCode 定价模式编码
	 * @param priceReqList 计价请求DTO集合
	 * @return 计价结果Map,[Key：服务ID,value：计算价格结果]
	 * @throws BizException
	 * @author yankan
	 */
	public abstract Map<String, PriceResultDTO> batchCalcPriceByPrimd(String primdCode,PriceReqDTO[] priceReqList)throws BizException;
	/**
	 * 计算费用模板价格
	 * @param tplIds 费用模板ID
	 * @return 计价结果Map,[Key：费用模板ID,value：费用模板价格DTO]
	 * @throws BizException
	 * @author yankan
	 */
	public abstract Map<String,BlTplPriceDTO> batchCalcBlTplPrice(String[] tplIds) throws BizException;
	
	/**
	 * 结算费用模板价格-带价格系数
	 * @param tplIds
	 * @param priPatId
	 * @return
	 * @throws BizException
	 */
	public abstract Map<String,BlTplPriceDTO> batchCalcBlTplPriceByPripat(String[] tplIds,String pripatId) throws BizException;
}
