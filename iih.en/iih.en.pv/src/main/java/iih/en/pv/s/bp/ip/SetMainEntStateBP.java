package iih.en.pv.s.bp.ip;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.en.comm.IEnMsgConst;
import iih.en.comm.ep.EntStateEP;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.EntStateDTO;
import iih.en.pv.dto.d.MainStateDTO;
import iih.en.pv.enclin.d.EntStateDO;
import iih.en.pv.s.bp.SetEntStateBP;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDateTime;

/**
 * 设置患者主要就诊状况
 * 包括：病情、护理、营养
 * @author renying
 *
 */
public class SetMainEntStateBP {
	/**
	 * 设置患者主要就诊状况
	 * 包括：病情、护理、营养
	 * @param mainStateDTO 主要就诊状况DTO
	 * @throws BizException
	 * @author renying
	 */
	public void exec(MainStateDTO mainStateDTO) throws BizException{
		if(mainStateDTO == null)
			return;
		if (EnValidator.isEmpty(mainStateDTO.getId_ent())) {
			throw new BizException(IEnMsgConst.ERROR_ENTID_NOT_EXIST);
		}
		String[] entstatetps = new String[]{IBdFcDictCodeConst.SD_ENSTSTATETP_FOOD, IBdFcDictCodeConst.SD_ENSTSTATETP_DISE, IBdFcDictCodeConst.SD_ENSTSTATETP_NUR};
		//获取就诊状况
		EntStateEP entStateEP = new EntStateEP();
		Map<String,Map<String, EntStateDO>> entstatesMap = entStateEP.getEntStateDOMap(new String[] { mainStateDTO.getId_ent() }, entstatetps);
		//组装就诊状况数据
		EntStateDTO[] entStateDTOs = this.assemly(mainStateDTO, entstatesMap);
		
		SetEntStateBP entStateBP = new SetEntStateBP();
		entStateBP.exec(entStateDTOs);
	}	
	/**
	 * 组装就诊状况数据
	 * 
	 * @param enStateDOs
	 * @param mainStateDTO
	 * @param list
	 * @throws BizException 
	 */
	private EntStateDTO[] assemly(MainStateDTO mainStateDTO, Map<String,Map<String, EntStateDO>> statesMap) throws BizException{		
		FDateTime dateTime = EnAppUtils.getServerDateTime();
		List<EntStateDTO> list = new ArrayList<>();
		//1.饮食
		EntStateDO entState = getEntStateDO(mainStateDTO.getId_ent(), IBdFcDictCodeConst.SD_ENSTSTATETP_FOOD, statesMap);
		EntStateDTO foodEntState = assemly(entState, mainStateDTO.getId_ent(), IBdFcDictCodeConst.SD_ENSTSTATETP_FOOD, mainStateDTO.getVal_level_nutr(), dateTime);
		if(foodEntState != null)
			list.add(foodEntState);
		//2.病情
		entState = getEntStateDO(mainStateDTO.getId_ent(), IBdFcDictCodeConst.SD_ENSTSTATETP_DISE, statesMap);
		EntStateDTO diseEntState = assemly(entState, mainStateDTO.getId_ent(), IBdFcDictCodeConst.SD_ENSTSTATETP_DISE, mainStateDTO.getVal_level_dise(), dateTime);
		if(diseEntState != null)
			list.add(diseEntState);
		//3.护理登记
		entState = getEntStateDO(mainStateDTO.getId_ent(), IBdFcDictCodeConst.SD_ENSTSTATETP_NUR, statesMap);
		EntStateDTO nurEntState = assemly(entState, mainStateDTO.getId_ent(), IBdFcDictCodeConst.SD_ENSTSTATETP_NUR, mainStateDTO.getVal_level_nur(), dateTime);
		if(nurEntState != null)
			list.add(nurEntState);
		return list.isEmpty()? null : list.toArray(new EntStateDTO[0]);
    }
	/**
	 * 
	 * 
	 * @param entState
	 * @param entId
	 * @param entstatetp
	 * @param val
	 * @param dateTime
	 * @return
	 * @throws BizException
	 */
	private EntStateDTO assemly(EntStateDO entState, String entId, String entstatetp, String val, FDateTime dateTime) throws BizException{
		EntStateDTO entStateDTO = new EntStateDTO();
		if(entState == null){
			entStateDTO.setId_ent(entId);
			entStateDTO.setSd_enstatetp(entstatetp);
			entStateDTO.setVal(val);
			entStateDTO.setDt_occ(dateTime);
		}else{
			if(entState.getSd_enstatetp().equals(entstatetp) && entState.getVal().equals(val))
				return null;
			else{
				entStateDTO.setId_ent(entId);
				entStateDTO.setSd_enstatetp(entstatetp);
				entStateDTO.setVal(val);
				entStateDTO.setDt_occ(dateTime);
			}
		}
		return entStateDTO;
	}
	
	/**
	 * 获取就诊状况数据
	 * 
	 * @param entId
	 * @param entstatetp
	 * @param statesMap
	 * @return
	 */
	private EntStateDO getEntStateDO(String entId, String entstatetp, Map<String,Map<String, EntStateDO>> statesMap){
		if(statesMap == null)
			return null;
		if(!statesMap.containsKey(entId))
			return null;
		Map<String, EntStateDO> map = statesMap.get(entId);
		if(map == null)
			return null;
		if(!map.containsKey(entstatetp))
			return null;
		return map.get(entstatetp);
	}
}


