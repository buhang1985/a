package iih.sc.sch.s.bp.qry;

import iih.sc.sch.dto.d.MtSchDTO;
import iih.sc.scp.scplan.d.ScPlanDO;
import iih.sc.scp.scplan.i.IScplanRService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
/**
 * 查询排班选中计划的名称
 * @author renying
 *
 */
public class GetMtSchPlNameBP {

	 /**
	  * 查询计划名称
	  * @return
	  * @throws BizException
	  */
	public MtSchDTO[]  exec( MtSchDTO[] mtschDTOs) throws BizException{
		List<String> idList = new ArrayList<String>();
		for(MtSchDTO mtschDTO :mtschDTOs){
			if(StringUtil.isEmpty(mtschDTO.getId_scpl())||idList.contains(mtschDTO.getId_scpl())){
				continue;
			}
			idList.add(mtschDTO.getId_scpl());
		}
		IScplanRService rservice = ServiceFinder.find(IScplanRService.class);
		ScPlanDO[] planDOs =  rservice.findByIds(idList.toArray(new String[0]), FBoolean.FALSE);
		Map<String,String > map = new HashMap<String,String >();
		for(ScPlanDO pldo :planDOs){
			map.put(pldo.getId_scpl(), pldo.getName());
		}
	    
		for(MtSchDTO mtschDTO :mtschDTOs){
			if(StringUtil.isEmpty(mtschDTO.getId_scpl())){
				continue;
			}
			mtschDTO.setName_pl(map.get(mtschDTO.getId_scpl()));
		}
		return  mtschDTOs;
	}
	

	
}
