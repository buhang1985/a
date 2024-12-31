package iih.bd.pp.bp.pri;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.pp.bdbltpl.d.BdBlTplDO;
import iih.bd.pp.bdbltpl.d.BdBltplItmDO;
import iih.bd.pp.bdbltpl.d.BdbltplAggDO;
import iih.bd.pp.bdbltpl.i.IBdbltplRService;
import iih.bd.pp.dto.d.BlTplPriceDTO;
import iih.bd.pp.dto.d.PriceResultDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 批量计算费用模板价格
 * 
 * @author yankan
 * @since 2017-09-19
 *
 */
public class BatchCalcBlTplPriceBP {
	/**
	 * 计算费用模板价格
	 * 
	 * @param tplIds 费用模板ID
	 * @return 计价结果Map,[Key：费用模板ID,value：费用模板价格DTO]
	 * @throws BizException
	 * @author yankan
	 */
	public Map<String, BlTplPriceDTO> exec(String[] tplIds) throws BizException {
		if (ArrayUtil.isEmpty(tplIds)) {
			return null;
		}
		// 1、获取费用模板Agg集合
		BdbltplAggDO[] tplAggs = this.getBlTplList(tplIds);
		if (ArrayUtil.isEmpty(tplAggs)) {
			return null;
		}

		// 2、计算模板价格
		return this.calcTplPrice(tplAggs);
	}

	/**
	 * 获取费用模板Agg集合
	 * 
	 * @param tplIds 费用模板ID集合
	 * @return
	 * @throws BizException
	 */
	private BdbltplAggDO[] getBlTplList(String[] tplIds) throws BizException {
		IBdbltplRService tplRService = ServiceFinder.find(IBdbltplRService.class);
		BdbltplAggDO[] tplAggs = tplRService.findByIds(tplIds, FBoolean.FALSE);
		return tplAggs;
	}

	/**
	 * 计算费用模板费用
	 * 
	 * @param tplAggs
	 * @return 费用模板计价结果Map,[Key：费用模板ID,value：费用模板价格DTO]
	 * @throws BizExcepiton
	 */
	@SuppressWarnings("unchecked")
	private Map<String, BlTplPriceDTO> calcTplPrice(BdbltplAggDO[] tplAggs) throws BizException {
		if (ArrayUtil.isEmpty(tplAggs)) {
			return null;
		}
		
		// 1、获取服务ID集合
		List<String> srvIdList = this.getTplSrvIdList(tplAggs);

		// 2、计算费用模板项目明细价格
		BatchCalcStdPriBP calcStdPriBP = new BatchCalcStdPriBP();
		Map<String, PriceResultDTO> priRstMap = calcStdPriBP.exec(srvIdList.toArray(new String[0]));

		// 3、将价格结果赋值到模板
		Map<String, BlTplPriceDTO> tplPriceMap = new HashMap<String, BlTplPriceDTO>();
		for (BdbltplAggDO tplAggDO : tplAggs) {
			
			if (ArrayUtil.isEmpty(tplAggDO.getBdBltplItmDO())) {
				continue;
			}
			
			//2018/05/24 明细没有的时候，不put进返回值
			BlTplPriceDTO tplPriceDTO = this.createTplPriceDTO(tplAggDO.getParentDO());
			tplPriceMap.put(tplPriceDTO.getId_bltpl(), tplPriceDTO);
			FArrayList priRstList = new FArrayList();
			
			for (BdBltplItmDO tplItmDO : tplAggDO.getBdBltplItmDO()) {
				PriceResultDTO priRst = priRstMap.get(tplItmDO.getId_srv());
				if (priRst != null) {
					
					//2018/07/16 ly 解决赋值被冲掉问题
					//priRst.setQuan(tplItmDO.getQuan_medu());
					
					PriceResultDTO newPriRst = new PriceResultDTO();
					newPriRst.setId_srv(priRst.getId_srv());
					newPriRst.setName_srv(priRst.getName_srv());
					newPriRst.setSd_srvtp(priRst.getSd_srvtp());
					newPriRst.setPrice_std(priRst.getPrice_std());
					newPriRst.setPrice_ratio(priRst.getPrice_ratio());
					newPriRst.setRate(priRst.getRate());
					newPriRst.setQuan(tplItmDO.getQuan_medu());
					
					priRstList.add(newPriRst);
					// 金额累计
					tplPriceDTO.setPrice_std(tplPriceDTO.getPrice_std().add(newPriRst.getPrice_std().multiply(tplItmDO.getQuan_medu())));
					tplPriceDTO.setPrice_ratio(tplPriceDTO.getPrice_ratio().add(newPriRst.getPrice_ratio().multiply(tplItmDO.getQuan_medu())));
				}
			}
			tplPriceDTO.setItm_list(priRstList);
		}
		return tplPriceMap;
	}

	/**
	 * 创建模板价格DTO
	 * @param tplDO
	 * @return
	 */
	private BlTplPriceDTO createTplPriceDTO(BdBlTplDO tplDO) {
		BlTplPriceDTO tplPriceDTO = new BlTplPriceDTO();
		tplPriceDTO.setId_bltpl(tplDO.getId_bltpl());
		tplPriceDTO.setName_bltpl(tplDO.getName());
		tplPriceDTO.setSd_bltpltp(tplDO.getSd_bltpltp());
		tplPriceDTO.setSd_owtp(tplDO.getSd_owtp());
		tplPriceDTO.setPrice_std(FDouble.ZERO_DBL);
		tplPriceDTO.setRate(FDouble.ONE_DBL);// 默认为1
		tplPriceDTO.setPrice_ratio(FDouble.ZERO_DBL);
		return tplPriceDTO;
	}

	/**
	 * 获取费用模板的服务ID集合
	 * 
	 * @param tplAggs
	 * @return
	 */
	private List<String> getTplSrvIdList(BdbltplAggDO[] tplAggs) {
		List<String> srvIdList = new ArrayList<String>();
		for (BdbltplAggDO tplAggDO : tplAggs) {
			if (tplAggDO.getBdBltplItmDO() == null) {
				continue;
			}
			for (BdBltplItmDO tplItmDO : tplAggDO.getBdBltplItmDO()) {
				if (!srvIdList.contains(tplItmDO.getId_srv())) {
					srvIdList.add(tplItmDO.getId_srv());
				}
			}
		}
		return srvIdList;
	}
}
