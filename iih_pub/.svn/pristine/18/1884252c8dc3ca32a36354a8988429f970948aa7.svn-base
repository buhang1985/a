package iih.bd.pp.feeprojectrejectplan.i;

import xap.mw.core.data.BizException;
import iih.bd.pp.feeprojectrejectplan.d.ExclusiveMasterDO;
import iih.bd.pp.feeprojectrejectplan.d.FeeprojectrejectplanAggDO;

/**
* 收费项目排斥方案数据维护服务
*/
public interface IFeeprojectrejectplanCudService {
	/**
	*  收费项目排斥方案数据真删除
	*/
    public abstract void delete(FeeprojectrejectplanAggDO[] aggdos) throws BizException;
    
    /**
	*  收费项目排斥方案数据插入保存
	*/
	public abstract FeeprojectrejectplanAggDO[] insert(FeeprojectrejectplanAggDO[] aggdos) throws BizException;
	
    /**
	*  收费项目排斥方案数据保存
	*/
	public abstract FeeprojectrejectplanAggDO[] save(FeeprojectrejectplanAggDO[] aggdos) throws BizException;
	
    /**
	*  收费项目排斥方案数据更新
	*/
	public abstract FeeprojectrejectplanAggDO[] update(FeeprojectrejectplanAggDO[] aggdos) throws BizException;
	
	/**
	*  收费项目排斥方案数据逻辑删除
	*/
	public abstract void logicDelete(FeeprojectrejectplanAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对收费项目排斥方案数据真删除
	 */
	public abstract void deleteByParentDO(ExclusiveMasterDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对收费项目排斥方案数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(ExclusiveMasterDO[] mainDos) throws BizException;
}
