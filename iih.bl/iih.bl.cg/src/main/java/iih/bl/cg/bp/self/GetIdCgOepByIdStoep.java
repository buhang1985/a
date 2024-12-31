package iih.bl.cg.bp.self;

import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.i.IBlCgItmOepDORService;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
/**
 * 根据结算id查找记账id
 * @param id_stoep
 * @return
 * @throws BizException
 */
public class GetIdCgOepByIdStoep {
	public String[] exec(String id_stoep) throws BizException{
		List<String> arrID= new ArrayList<String>();
		IBlCgItmOepDORService blcgSer=ServiceFinder.find(IBlCgItmOepDORService.class);
		BlCgItmOepDO[] blItmIdArr=blcgSer.find(" id_stoep='"+ id_stoep +"'", "", FBoolean.FALSE);
		if(!ArrayUtils.isEmpty(blItmIdArr)){
			for(BlCgItmOepDO itm:blItmIdArr){
				if(!arrID.contains(itm.getId_cgoep())){
					arrID.add(itm.getId_cgoep());
				}			
			}
		}
		return arrID.toArray(new String[0]);
	}
}
