package iih.bd.pp.bp.pri;

import java.util.List;

import iih.bd.base.validator.ParamValidator;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.pp.dto.d.PriceRateDTO;
import iih.bd.pp.i.IBdPpMsgConst;
import iih.bd.pp.pripat.d.PriPatDO;
import iih.bd.pp.pripat.d.PriPatSrvOrCaDO;
import iih.bd.pp.pripat.d.PriRateMdEnum;
import iih.bd.pp.pripat.d.PripatAggDO;
import iih.bd.pp.pripat.d.SrvOrCaEnum;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取服务的价格系数
 * 
 * @author yankan
 * @since 2017-07-26
 * @version ly 2018/05/11 返回值中添加折扣单价，价格模式时直接返回折扣价（系数无效）
 */
public class CalcSrvPriRateBP {
	/**
	 * 获取价格系数
	 * 
	 * @param pripatAgg 患者价格分类agg
	 * @param srvId 服务ID
	 * @param srvTpCode 服务类型编码
	 * @param time 时间
	 * @return
	 * @throws BizException
	 */
	public PriceRateDTO exec(PripatAggDO pripatAgg, String srvId, String srvTpCode, FDateTime time) throws BizException {
		// 参数校验
		this.validateParam(pripatAgg, srvId, srvTpCode, time);

		// 药品不参与价格折扣
		if (srvTpCode.startsWith(IBdSrvDictCodeConst.SD_SRVTP_DRUG)) {
			PriceRateDTO dto = new PriceRateDTO();
			dto.setRate(FDouble.ONE_DBL);
			return dto;
		}
		// 计算比例系数
		PriPatDO priPatDO = pripatAgg.getParentDO();
		
		//获取患者价格分类的折扣价格，这里采用view_price_rp视图的形式获取
		PriceRateDTO dto=this.getSrvRatePrice(pripatAgg, srvId);// 服务模式
		
		return dto;
	}

	/**
	 * 校验参数
	 * 
	 * @param pripatAgg
	 * @param srvId
	 * @param srvTpCode
	 * @param time
	 * @throws BizException
	 */
	private void validateParam(PripatAggDO pripatAgg, String srvId, String srvTpCode, FDateTime time)
			throws BizException {
		ParamValidator.validateNotNull("患者价格分类", pripatAgg);
		ParamValidator.validateNotNull("医疗服务ID", srvId);
//		ParamValidator.validateNotNull("服务类型", srvTpCode);
		ParamValidator.validateNotNull("时间", time);
	}

	/**
	 * 获取患者价格分类--项目系数
	 * 
	 * @param pripatAgg
	 * @param srvId
	 * @param currentTime
	 * @return review by yangyang 2018-06-27 新版获取折扣价格采用从视图获取的方式
	 */
	@Deprecated
	private PriceRateDTO getSrvPriRate(PripatAggDO pripatAgg, String srvId, FDateTime currentTime) {
		PriPatSrvOrCaDO[] srvOrCaDOs = pripatAgg.getPriPatSrvOrCaDO();
		int length = srvOrCaDOs == null ? 0 : srvOrCaDOs.length;
		
		PriceRateDTO dto = new PriceRateDTO();
		for (int i = 0; i < length; i++) {
			PriPatSrvOrCaDO srvOrCaDO = srvOrCaDOs[i];
			if (SrvOrCaEnum.SRV.equals(srvOrCaDO.getEu_srvorca())) {
				// 服务项目
				if (srvOrCaDO.getId_srv().equals(srvId)
						&& this.isValid(currentTime, srvOrCaDO.getDt_b(), srvOrCaDO.getDt_e())) {
					
					if(PriRateMdEnum.PRICEMODEL.equals(srvOrCaDO.getEu_pi_priratemd())){
						dto.setPrice_ratio(srvOrCaDO.getPri());
						dto.setRate(FDouble.ONE_DBL);
					}else{
						dto.setRate(srvOrCaDO.getRate());
					}
					return dto;
				}
			} else if (SrvOrCaEnum.SRVCA.equals(srvOrCaDO.getEu_srvorca())) {
				// 服务分类暂不支持
			}
		}
		dto.setRate(pripatAgg.getParentDO().getRate());// 默认价格分类比例
		return dto;
	}
	
	/**
	 * 获取患者价格分类--项目系数
	 * 
	 * @param pripatAgg
	 * @param srvId
	 * @param currentTime
	 * @return
	 */
	private PriceRateDTO getSrvRatePrice(PripatAggDO pripatAgg, String srvId) throws BizException
	{
		StringBuilder sb=new StringBuilder();
		sb.append("SELECT RATE,PRICE_RATIO FROM VIEW_PRICE_RP WHERE ID_PRIPAT=? AND ID_SRV=?");
		DAFacade facade=new DAFacade();
		SqlParam param=new SqlParam();
		param.addParam(pripatAgg.getParentDO().getId_pripat());
		param.addParam(srvId);
		List<PriceRateDTO> lst=(List<PriceRateDTO>)facade.execQuery(sb.toString(), param,new BeanListHandler(PriceRateDTO.class));
		if(ListUtil.isEmpty(lst))
			throw new BizException(IBdPpMsgConst.ERROR_SRV_PRICERATE_NOT_DEFINED);
		return lst.get(0);
	}
	/**
	 * 是否可用
	 * 
	 * @param time 时间
	 * @param beginTime 开始时间
	 * @param endTime 结束时间
	 * @return
	 */
	private boolean isValid(FDateTime time, FDateTime beginTime, FDateTime endTime) {
		return (beginTime != null && time.after(beginTime)) && (endTime == null || time.before(endTime));
	}
}
