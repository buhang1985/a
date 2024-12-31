package iih.en.pv.vt.i;

import xap.mw.core.data.BizException;
import iih.en.pv.vt.d.EnVtDO;
import iih.en.pv.vt.d.EnvtAggDO;

/**
* 就诊_体征数据维护服务
*/
public interface IEnvtCudService {
	/**
	*  就诊_体征数据真删除
	*/
    public abstract void delete(EnvtAggDO[] aggdos) throws BizException;
    
    /**
	*  就诊_体征数据插入保存
	*/
	public abstract EnvtAggDO[] insert(EnvtAggDO[] aggdos) throws BizException;
	
    /**
	*  就诊_体征数据保存
	*/
	public abstract EnvtAggDO[] save(EnvtAggDO[] aggdos) throws BizException;
	
    /**
	*  就诊_体征数据更新
	*/
	public abstract EnvtAggDO[] update(EnvtAggDO[] aggdos) throws BizException;
	
	/**
	*  就诊_体征数据逻辑删除
	*/
	public abstract void logicDelete(EnvtAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对就诊_体征数据真删除
	 */
	public abstract void deleteByParentDO(EnVtDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对就诊_体征数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(EnVtDO[] mainDos) throws BizException;
}
