package iih.bd.mm.wahouseunittype.i;

import java.util.Map;

import iih.bd.mm.wahouseunittype.d.WahouseUnitTypeDO;
import xap.mw.core.data.BizException;

public interface IWahouseunittypeService {
    /**
	 * 仓库包装单位类型界面初始化数据
	 * @return
	 * @throws BizException
	 */
	public WahouseUnitTypeDO[] initWhUnitTypeDate() throws BizException;
	
    /**
	 * 仓库包装单位类型保存前验证
	 * @return
	 * @throws BizException
	 */
	public void checkBeforeSave(WahouseUnitTypeDO[] whUnitTypeList) throws BizException;
	
	
	public Map<String, WahouseUnitTypeDO> getWhDefPkgUnitTp(String[] id_whs) throws BizException;
}
