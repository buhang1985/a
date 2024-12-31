package iih.bd.pp.bp.pri;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import iih.bd.base.utils.SqlUtils;
import iih.bd.pp.dto.d.BlTplPriceDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 计算费用模板价格-带价格系数
 * @author hanjq
 */
public class BatchCalcBlTplPriceByPripatBP {
	
	public Map<String, BlTplPriceDTO> exec(String[] tplIds,String pripatId) throws BizException {
		if (ArrayUtil.isEmpty(tplIds) || StringUtils.isBlank(pripatId)) {
			return null;
		}
		//1.获取带价格系数的集合
		List<BlTplPriceDTO> list = getPriceByPripatId(tplIds, pripatId);
		if (list == null || list.size() == 0) {
			return null;
		}
		// 2、获取费用模板Agg集合
		Map<String, BlTplPriceDTO> oldMap = new BatchCalcBlTplPriceBP().exec(tplIds);

		// 3、计算模板价格
		return this.calcTplPrice(oldMap,list);
	}
	
	private Map<String, BlTplPriceDTO> calcTplPrice(Map<String, BlTplPriceDTO> oldMap, List<BlTplPriceDTO> list) {
		Map<String, BlTplPriceDTO> map = new HashMap<String, BlTplPriceDTO>();
		for(BlTplPriceDTO itm:list){
			BlTplPriceDTO tplDto = oldMap.get(itm.getId_bltpl());			
			tplDto.setPrice_ratio(itm.getPrice_ratio());
			tplDto.setRate(itm.getRate());
			map.put(itm.getId_bltpl(), tplDto);
		}
		return map;
	}

	/**
	 * 获取带价格系数的
	 * @param tplIds
	 * @param pripatId
	 * @return
	 * @throws BizException
	 */
	private List<BlTplPriceDTO> getPriceByPripatId(String[] tplIds,String pripatId) throws BizException{
		StringBuilder sql = new StringBuilder();
		sql.append("select	");
		sql.append("	bltp.id_bltpl,vprice.rate,sum(itm.quan_medu * vprice.price_ratio) Price_ratio	");
		sql.append("from bd_bltpl bltp	");
		sql.append("inner join bd_bltpl_itm itm  on bltp.id_bltpl = itm.id_bltpl	");
		sql.append("inner join view_price_rp vprice  on itm.id_srv = vprice.id_srv	");
		sql.append("where vprice.ID_PRIPAT = ?	");
		sql.append("	and bltp.id_bltpl in(	").append(SqlUtils.arrayToStr(tplIds)).append(")	");
		sql.append("group by bltp.id_bltpl ,vprice.rate	");
		SqlParam param = new SqlParam();
		param.addParam(pripatId);
		DAFacade daf = new DAFacade();
		@SuppressWarnings("unchecked")
		List<BlTplPriceDTO> list = (List<BlTplPriceDTO>) daf.execQuery(sql.toString(), param, new BeanListHandler(BlTplPriceDTO.class));
		return list;
	}
}
