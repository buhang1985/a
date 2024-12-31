package iih.bd.pp.bp.pri;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.lang.ArrayUtils;

import iih.bd.base.utils.PrecisionUtils;
import iih.bd.pp.dto.d.PriceReqDTO;
import iih.bd.pp.dto.d.PriceResultDTO;
import iih.bd.pp.priceengine.PriceEngine;
import iih.bd.srv.medsrv.d.MedSrvDO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;

/**
 * 计算价格
 * @author yankan
 * @since 2017-08-01
 * @version 2019/05/22 ly 补充sd_srvtp赋值
 *
 */
public class BatchCalcStdPriBP {
	/**
	 * 计价服务
	 * @param srvIds 服务ID集合
	 * @return 服务Map,[Key：服务ID,value：计算价格结果]
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public Map<String,PriceResultDTO> exec(String[] srvIds) throws BizException{
		//参数校验
		if(ArrayUtils.isEmpty(srvIds)){
			return null;
		}
		
		//1、查询服务
		GetSrvListBP getSrvListBP = new GetSrvListBP();
		Map<String,MedSrvDO> srvMap = getSrvListBP.exec(srvIds);
		
		//2、按定价模式分组
		Map<String,List<PriceReqDTO>> priReqMap = this.groupByPrimd(srvMap.values());
		
		//3、计算价格		
		Map<String, PriceResultDTO> resultMap = new HashMap<String, PriceResultDTO>();
		PriceEngine priceEngine = new PriceEngine();
		for(Entry<String,List<PriceReqDTO>> item : priReqMap.entrySet()){
			Map<String, PriceResultDTO> tempResult = priceEngine.calcPrice(item.getKey(), item.getValue().toArray(new PriceReqDTO[0]));
			if(tempResult!=null && tempResult.size()>0){
				resultMap.putAll(tempResult);
			}
		}
		
		//补充子里的数据
		Set<String> srvIdSet = new HashSet<String>();
		for (PriceResultDTO rltDto : resultMap.values()) {
			if(ListUtil.isEmpty(rltDto.getSrvitm_list()))
				continue;
			
			for (int i = 0; i < rltDto.getSrvitm_list().size(); i++) {
				PriceResultDTO itmRltDto = (PriceResultDTO)rltDto.getSrvitm_list().get(i);
				srvIdSet.add(itmRltDto.getId_srv());
			}
		}
		
		if(srvIdSet.size() > 0){
			Map<String,MedSrvDO> itmMap = getSrvListBP.exec(srvIdSet.toArray(new String[0]));
			if(itmMap != null && itmMap.size() > 0){
				srvMap.putAll(itmMap);
			}
		}
		
		//赋值sd_srvtp
		for (PriceResultDTO rltDto : resultMap.values()) {
			
			MedSrvDO srvDO = srvMap.get(rltDto.getId_srv());
			if(srvDO != null){
				rltDto.setSd_srvtp(srvDO.getSd_srvtp());
			}
			
			if(ListUtil.isEmpty(rltDto.getSrvitm_list()))
				continue;
			for (int i = 0; i < rltDto.getSrvitm_list().size(); i++) {
				PriceResultDTO itmRltDto = (PriceResultDTO)rltDto.getSrvitm_list().get(i);
				MedSrvDO srvDO2 = srvMap.get(itmRltDto.getId_srv());
				if(srvDO2 != null){
					itmRltDto.setSd_srvtp(srvDO2.getSd_srvtp());
				}
			}
			
		}
		
		//4、修改精度
		this.updatePrecesion(resultMap);
		
		return resultMap;
	}	

	/**
	 * 根据定价模式分组
	 * @param srvList 医疗服务集合
	 * @return
	 */
	private Map<String,List<PriceReqDTO>> groupByPrimd(Collection<MedSrvDO> srvList){
		Map<String,List<PriceReqDTO>> srvMap = new HashMap<String,List<PriceReqDTO>>();
		for(MedSrvDO srvDO : srvList){
			String primdCode = srvDO.getSd_primd();
			if(StringUtil.isEmptyWithTrim(primdCode)){
				continue;
			}
			List<PriceReqDTO> srvTempList = srvMap.get(primdCode);
			if(srvTempList==null){
				srvTempList = new ArrayList<PriceReqDTO>();
				srvMap.put(primdCode, srvTempList);
			}
			PriceReqDTO priReqDTO = new PriceReqDTO();
			priReqDTO.setId_srv(srvDO.getId_srv());
			srvTempList.add(priReqDTO);
		}
		return srvMap;
	}
	/**
	 * 修改精度
	 * @param resultMap
	 */
	private void updatePrecesion(Map<String, PriceResultDTO> resultMap){
		for(PriceResultDTO resultDTO : resultMap.values()){
			resultDTO.setPrice_std(PrecisionUtils.formatPrice(resultDTO.getPrice_std()));
			resultDTO.setPrice_ratio(PrecisionUtils.formatPrice(resultDTO.getPrice_ratio()));
		}
	}
}
