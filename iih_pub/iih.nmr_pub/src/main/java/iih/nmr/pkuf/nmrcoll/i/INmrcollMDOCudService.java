package iih.nmr.pkuf.nmrcoll.i;

import xap.mw.core.data.BizException;
import iih.nmr.pkuf.nmrcoll.d.NmrCollDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 文书采集记录数据维护服务
*/
public interface INmrcollMDOCudService {
	/**
	*  文书采集记录数据真删除
	*/
    public abstract void delete(NmrCollDO[] aggdos) throws BizException;
    
    /**
	*  文书采集记录数据插入保存
	*/
	public abstract NmrCollDO[] insert(NmrCollDO[] aggdos) throws BizException;
	
    /**
	*  文书采集记录数据保存
	*/
	public abstract NmrCollDO[] save(NmrCollDO[] aggdos) throws BizException;
	
    /**
	*  文书采集记录数据更新
	*/
	public abstract NmrCollDO[] update(NmrCollDO[] aggdos) throws BizException;
	
	/**
	*  文书采集记录数据逻辑删除
	*/
	public abstract void logicDelete(NmrCollDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public NmrCollDO[] enableWithoutFilter(NmrCollDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(NmrCollDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public NmrCollDO[] disableVOWithoutFilter(NmrCollDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(NmrCollDO[] aggdos) throws BizException ;
	
}
