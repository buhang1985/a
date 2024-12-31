package iih.en.pv.sco.scotp.i;

import xap.mw.core.data.BizException;
import iih.en.pv.sco.scotp.d.EnScoTpDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 就诊评分类型数据维护服务
*/
public interface IEnscotpCudService {
	/**
	*  就诊评分类型数据真删除
	*/
    public abstract void delete(EnScoTpDO[] aggdos) throws BizException;
    
    /**
	*  就诊评分类型数据插入保存
	*/
	public abstract EnScoTpDO[] insert(EnScoTpDO[] aggdos) throws BizException;
	
    /**
	*  就诊评分类型数据保存
	*/
	public abstract EnScoTpDO[] save(EnScoTpDO[] aggdos) throws BizException;
	
    /**
	*  就诊评分类型数据更新
	*/
	public abstract EnScoTpDO[] update(EnScoTpDO[] aggdos) throws BizException;
	
	/**
	*  就诊评分类型数据逻辑删除
	*/
	public abstract void logicDelete(EnScoTpDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public EnScoTpDO[] enableWithoutFilter(EnScoTpDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(EnScoTpDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public EnScoTpDO[] disableVOWithoutFilter(EnScoTpDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(EnScoTpDO[] dos) throws BizException ;
}
