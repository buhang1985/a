package iih.bl.inc.s.bp.opinc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.d.BlcgoepAggDO;
import iih.bl.comm.util.OpInccaJudgeUtil;
import iih.bl.inc.blincoep.d.BlincoepAggDO;
import iih.bl.inc.blreinccgitmdto.d.BlReIncCgItmDTO;
import iih.bl.inc.blreinccgitmdto.d.BlReIncPageDTO;
import iih.bl.inc.s.bp.opinc.util.OpIncAssembleUtil;
import iih.bl.st.blstoep.d.BlStOepDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;

public class OpIncRePreSplitBP {
	
	public Map<String, List<BlCgItmOepDO>> exec(List<BlCgItmOepDO> itmList, BlReIncPageDTO[] incPages) throws BizException
	{
		if(itmList == null || incPages == null)
			return null;
				
		Map<String, List<BlCgItmOepDO>> splitMap = new HashMap<String, List<BlCgItmOepDO>>();
		
		for(int i= 0; i< incPages.length; i++)
		{
			List<BlCgItmOepDO> cgList = new ArrayList<BlCgItmOepDO>();
			 for (int j = 0; j < incPages[i].getReincitms().size(); j++)
			 {
				 BlReIncCgItmDTO temp = (BlReIncCgItmDTO)incPages[i].getReincitms().get(j);
				 for(int k = 0; k < itmList.size(); k++)
				 {
					 String strCgItmId = itmList.get(k).getId_cgitmoep();
					 String strCgItmIdPar = itmList.get(k).getId_par();
					 if(strCgItmIdPar != null)
					 {
						 if(strCgItmIdPar.equals(temp.getId_cg_itm()))
						 {
							 cgList.add(itmList.get(k));
						 } 
					 }
					 
					 if(strCgItmId != null)
					 {
						 if(strCgItmId.equals(temp.getId_cg_itm()))
						 {
							 cgList.add(itmList.get(k));
						 } 
					 }
					 
				 }
			 }
			 splitMap.put(incPages[i].getIncno(), cgList);
		}
		
		return splitMap;

	}
}
