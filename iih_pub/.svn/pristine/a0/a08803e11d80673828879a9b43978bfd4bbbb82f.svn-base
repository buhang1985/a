package iih.ci.mr.nu.pipeslip.i;

import xap.mw.core.data.BizException;
import iih.ci.mr.nu.pipeslip.d.PipeSlipDO;
import iih.ci.mr.nu.pipeslip.d.PipeslipAggDO;

/**
* 管道滑脱危险因素评估数据维护服务
*/
public interface IPipeslipCudService {
	/**
	*  管道滑脱危险因素评估数据真删除
	*/
    public abstract void delete(PipeslipAggDO[] aggdos) throws BizException;
    
    /**
	*  管道滑脱危险因素评估数据插入保存
	*/
	public abstract PipeslipAggDO[] insert(PipeslipAggDO[] aggdos) throws BizException;
	
    /**
	*  管道滑脱危险因素评估数据保存
	*/
	public abstract PipeslipAggDO[] save(PipeslipAggDO[] aggdos) throws BizException;
	
    /**
	*  管道滑脱危险因素评估数据更新
	*/
	public abstract PipeslipAggDO[] update(PipeslipAggDO[] aggdos) throws BizException;
	
	/**
	*  管道滑脱危险因素评估数据逻辑删除
	*/
	public abstract void logicDelete(PipeslipAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对管道滑脱危险因素评估数据真删除
	 */
	public abstract void deleteByParentDO(PipeSlipDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对管道滑脱危险因素评估数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(PipeSlipDO[] mainDos) throws BizException;
}
