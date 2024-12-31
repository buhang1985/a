package iih.bd.pp.external.provide.en.s.bp;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;

import iih.bd.pp.external.provide.en.d.DrugMaxPriceDTO;
import iih.bd.pp.external.provide.en.s.bp.qry.FindDrugMaxPriListByPycodeQry;
import iih.mm.itf.material.d.GetStockReqDTO;
import iih.mm.itf.material.d.MaterialStockDTO;
import iih.mm.itf.material.i.IMaterialStockService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 根据拼音码查询药品最高价格列表业务逻辑
 * 
 * @author hao_wu 2018-11-27
 *
 */
public class FindDrugMaxPriListByPyCodeBp {

	@SuppressWarnings("unchecked")
	public DrugMaxPriceDTO[] exec(String pyCode) throws BizException {
		if (StringUtils.isEmpty(pyCode)) {
			return null;
		}
		FindDrugMaxPriListByPycodeQry qry = new FindDrugMaxPriListByPycodeQry(pyCode);
		DAFacade daFacade = new DAFacade();
		ArrayList<DrugMaxPriceDTO> maxPriDtoList = (ArrayList<DrugMaxPriceDTO>) daFacade.execQuery(qry.getQrySQLStr(),
				qry.getQryParameter(null), new BeanListHandler(DrugMaxPriceDTO.class));

		if (maxPriDtoList == null || maxPriDtoList.size() <= 0) {
			return null;
		}

		DrugMaxPriceDTO[] drugMaxPriDtos = maxPriDtoList.toArray(new DrugMaxPriceDTO[0]);
		updateMaxPri(drugMaxPriDtos);

		return drugMaxPriDtos;
	}

	/**
	 * 更新最高价格
	 * 
	 * @param drugMaxPris
	 * @throws BizException
	 */
	private void updateMaxPri(DrugMaxPriceDTO[] drugMaxPris) throws BizException {

		HashMap<String, MaterialStockDTO> maxPriMap = findMaxPriMap(drugMaxPris);
		if (maxPriMap == null || maxPriMap.size() <= 0) {
			return;
		}

		for (DrugMaxPriceDTO DrugMaxPriceDTO : drugMaxPris) {
			String id_mm = DrugMaxPriceDTO.getId_mm();
			if (!maxPriMap.containsKey(id_mm)) {
				continue;
			}
			MaterialStockDTO stockDto = maxPriMap.get(id_mm);
			if (stockDto == null) {
				continue;
			}
			DrugMaxPriceDTO.setMaxprice(stockDto.getPrice_act());
		}
	}

	/**
	 * 查询最高价格字典
	 * 
	 * @param drugMaxPris
	 * @return
	 * @throws BizException
	 */
	private HashMap<String, MaterialStockDTO> findMaxPriMap(DrugMaxPriceDTO[] drugMaxPris) throws BizException {
		ArrayList<GetStockReqDTO> reqList = new ArrayList<GetStockReqDTO>();
		for (DrugMaxPriceDTO DrugMaxPriceDTO : drugMaxPris) {
			if (StringUtils.isEmpty(DrugMaxPriceDTO.getId_mm()) || StringUtils.isEmpty(DrugMaxPriceDTO.getId_unit())) {
				continue;
			}
			GetStockReqDTO reqDto = new GetStockReqDTO();
			reqDto.setId_mm(DrugMaxPriceDTO.getId_mm());
			reqDto.setReq_unit_id(DrugMaxPriceDTO.getId_unit());
			reqList.add(reqDto);
		}

		if (reqList == null || reqList.size() <= 0) {
			return null;
		}

		IMaterialStockService stockService = ServiceFinder.find(IMaterialStockService.class);
		MaterialStockDTO[] drugStockDtos = stockService.getMaterialHighPri(reqList.toArray(new GetStockReqDTO[0]));

		HashMap<String, MaterialStockDTO> maxPriMap = new HashMap<String, MaterialStockDTO>();
		for (MaterialStockDTO materialStockDTO : drugStockDtos) {
			maxPriMap.put(materialStockDTO.getId_mm(), materialStockDTO);
		}
		return maxPriMap;
	}
}
