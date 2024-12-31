package iih.ci.mr.nu.antencare.i;

import xap.mw.core.data.BizException;
import iih.ci.mr.nu.antencare.d.AntenCareDO;
import iih.ci.mr.nu.antencare.d.AntencareAggDO;

/**
* 产前检查记录单数据维护服务
*/
public interface IAntencareCudService {
	/**
	*  产前检查记录单数据真删除
	*/
    public abstract void delete(AntencareAggDO[] aggdos) throws BizException;
    
    /**
	*  产前检查记录单数据插入保存
	*/
	public abstract AntencareAggDO[] insert(AntencareAggDO[] aggdos) throws BizException;
	
    /**
	*  产前检查记录单数据保存
	*/
	public abstract AntencareAggDO[] save(AntencareAggDO[] aggdos) throws BizException;
	
    /**
	*  产前检查记录单数据更新
	*/
	public abstract AntencareAggDO[] update(AntencareAggDO[] aggdos) throws BizException;
	
	/**
	*  产前检查记录单数据逻辑删除
	*/
	public abstract void logicDelete(AntencareAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对产前检查记录单数据真删除
	 */
	public abstract void deleteByParentDO(AntenCareDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对产前检查记录单数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(AntenCareDO[] mainDos) throws BizException;
}
