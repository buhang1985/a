package iih.bl.st.s.bp;

import iih.bl.st.dto.d.BlDiDefInfoDTO;
import iih.ci.ord.i.ICiOrdQryService;
import iih.en.pv.entdi.d.EntDiDO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;
import iih.mi.bd.didefcompinfo.d.DiDefCompInfoDTO;
import iih.mi.bd.i.IMiBdDirCompQryService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 查询患者诊断信息
 * @author liwenqiang 2018.10.29
 *
 */
public class FindDiDefInfoBP {

	/**
	 * 查询患者诊断信息
	 * @param entId
	 * @return
	 * @throws BizException 
	 */
	public BlDiDefInfoDTO[] exec(String entId) throws BizException{
		
		if(StringUtil.isEmpty(entId)){
			return null;
		}
		
		//1.查询患者就诊信息
		IPativisitRService enRService=ServiceFinder.find(IPativisitRService.class);
		PatiVisitDO entDo=enRService.findById(entId);
		if(entDo==null){
			return null;
		}
		
		//2.调用接口查询患者诊断信息
		ICiOrdQryService ciOrderService=ServiceFinder.find(ICiOrdQryService.class);
		EntDiDO[] diArr = ciOrderService.getEntDiDOList(entId);
		if(ArrayUtil.isEmpty(diArr)){
			return null;
		}
		
		//3.进行诊断对照
		
		List<String> diCodeList=new ArrayList<String>();
		//获取诊断编码集合
		for (EntDiDO entDiDO : diArr) {
			//诊断编码集合
			diCodeList.add(entDiDO.getCode_didef_dis());
		}
		
		IMiBdDirCompQryService compQryService=ServiceFinder.find(IMiBdDirCompQryService.class);
		DiDefCompInfoDTO[] compArr =  compQryService.findDiDefCompInfo(entDo.getId_hp(), diCodeList.toArray(new String[]{}));
		if(ArrayUtil.isEmpty(compArr)){
			return null;
		}
		
		
		Map<String,DiDefCompInfoDTO> compMap=new HashMap<String,DiDefCompInfoDTO>();
		for (DiDefCompInfoDTO diDefCompInfoDTO : compArr) {
			if(!compMap.containsKey(diDefCompInfoDTO.getCode_di_his())){
				compMap.put(diDefCompInfoDTO.getCode_di_his(), diDefCompInfoDTO);
			}
		}

		List<BlDiDefInfoDTO> defInfoList=new ArrayList<>();
		for (EntDiDO entDiDO : diArr) {
			DiDefCompInfoDTO compInfo = compMap.get(entDiDO.getCode_didef_dis());
			if(compInfo==null){
				continue;
			}
			//组装出参
			BlDiDefInfoDTO defDto=new BlDiDefInfoDTO();
			defDto.setFg_maj(entDiDO.getFg_maj());
			defDto.setHis_di_code(entDiDO.getCode_didef_dis());
			defDto.setHis_di_name(entDiDO.getName_didef_dis());
			defDto.setHp_di_code(compInfo.getCode_di_hp());
			defDto.setHp_di_name(compInfo.getName_di_hp());
			defDto.setSd_ditp(entDiDO.getSd_ditp());
			defInfoList.add(defDto);
		}
		
		return defInfoList.toArray(new BlDiDefInfoDTO[]{});
	}
	
}
