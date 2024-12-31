package iih.bd.mm.wahouseunittype.s;

import java.util.Map;

import iih.bd.mm.wahouseunittype.d.WahouseUnitTypeDO;
import iih.bd.mm.wahouseunittype.i.IWahouseunittypeService;
import iih.bd.mm.wahouseunittype.s.bp.WhUnitTypeBp;
import xap.mw.core.data.BizException;

public class WahouseunittypeServiceImpl implements IWahouseunittypeService{
	
	@Override
	public WahouseUnitTypeDO[] initWhUnitTypeDate() throws BizException {

		WhUnitTypeBp bp = new WhUnitTypeBp();
		
		return bp.initWhUnitType();
	}

	@Override
	public void checkBeforeSave(WahouseUnitTypeDO[] whUnitTypeList)throws BizException {

		WhUnitTypeBp bp = new WhUnitTypeBp();
		
		bp.checkBeforeSave(whUnitTypeList);
	}

	@Override
	public Map<String, WahouseUnitTypeDO> getWhDefPkgUnitTp(String[] id_whs) throws BizException {
		
		WhUnitTypeBp bp = new WhUnitTypeBp();
		
		return bp.getWhDefPkgUnitTp(id_whs);
	}
}
