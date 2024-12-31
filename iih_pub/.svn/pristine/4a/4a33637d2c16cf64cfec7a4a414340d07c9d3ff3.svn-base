package iih.pi.dic.phyind.i;

import xap.mw.core.data.BizException;
import iih.pi.dic.phyind.d.PiPatPhyIndDO;
import iih.pi.dic.phyind.d.PhyindAggDO;

/**
* 患者生理指标数据维护服务
*/
public interface IPhyindCudService {
	/**
	*  患者生理指标数据真删除
	*/
    public abstract void delete(PhyindAggDO[] aggdos) throws BizException;
    
    /**
	*  患者生理指标数据插入保存
	*/
	public abstract PhyindAggDO[] insert(PhyindAggDO[] aggdos) throws BizException;
	
    /**
	*  患者生理指标数据保存
	*/
	public abstract PhyindAggDO[] save(PhyindAggDO[] aggdos) throws BizException;
	
    /**
	*  患者生理指标数据更新
	*/
	public abstract PhyindAggDO[] update(PhyindAggDO[] aggdos) throws BizException;
	
	/**
	*  患者生理指标数据逻辑删除
	*/
	public abstract void logicDelete(PhyindAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对患者生理指标数据真删除
	 */
	public abstract void deleteByParentDO(PiPatPhyIndDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对患者生理指标数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(PiPatPhyIndDO[] mainDos) throws BizException;
}
