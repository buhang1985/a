package iih.bl.inc.s.bp.ipinc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgquery.d.BlCgIpDO;
import iih.bl.inc.blreinccgitmdto.d.BlReIncCgItmDTO;
import iih.bl.inc.blreinccgitmdto.d.BlReIncPageDTO;
import xap.mw.core.data.BizException;

public class IpIncRePreSplitBP {
	public Map<String, List<BlCgIpDO>> exec(List<BlCgIpDO> itmList, BlReIncPageDTO[] incPages) throws BizException
	{
		if(itmList == null || incPages == null)
			return null;
				
		Map<String, List<BlCgIpDO>> splitMap = new HashMap<String, List<BlCgIpDO>>();
		
		for(int i= 0; i< incPages.length; i++)
		{
			List<BlCgIpDO> cgList = new ArrayList<BlCgIpDO>();
			 for (int j = 0; j < incPages[i].getReincitms().size(); j++)
			 {
				 BlReIncCgItmDTO temp = (BlReIncCgItmDTO)incPages[i].getReincitms().get(j);
				 for(int k = 0; k < itmList.size(); k++)
				 {
					 String strCgItmId = itmList.get(k).getId_cgip();
					 String strCgItmIdPar = itmList.get(k).getId_par();
					 if(strCgItmIdPar != null)
					 {
						 if(strCgItmIdPar.equals(temp.getId_cg_itm()))
						 {
							 cgList.add(itmList.get(k));
						 } 
					 }
					 else
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
