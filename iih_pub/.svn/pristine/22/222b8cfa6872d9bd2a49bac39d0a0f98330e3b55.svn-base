package iih.bl.inc.blecinccomp.i;

import iih.bl.inc.blecinccomp.d.BlEcIncCompDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
import xap.sys.xbd.udi.d.UdidocDO;

/**
* 电子票据对照数据维护服务
*/
public interface IBlecinccompCudService {
	/**
	*  电子票据对照数据真删除
	*/
    public abstract void delete(BlEcIncCompDO[] aggdos) throws BizException;
    
    /**
	*  电子票据对照数据插入保存
	*/
	public abstract BlEcIncCompDO[] insert(BlEcIncCompDO[] aggdos) throws BizException;
	
    /**
	*  电子票据对照数据保存
	*/
	public abstract BlEcIncCompDO[] save(BlEcIncCompDO[] aggdos) throws BizException;
	
    /**
	*  电子票据对照数据更新
	*/
	public abstract BlEcIncCompDO[] update(BlEcIncCompDO[] aggdos) throws BizException;
	
	/**
	*  电子票据对照数据逻辑删除
	*/
	public abstract void logicDelete(BlEcIncCompDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public BlEcIncCompDO[] enableWithoutFilter(BlEcIncCompDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(BlEcIncCompDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public BlEcIncCompDO[] disableVOWithoutFilter(BlEcIncCompDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(BlEcIncCompDO[] dos) throws BizException ;
	
	/**
	 * 刷新对照
	 * @author zhang.hw
	 * @date 2020年2月12日
	 * @param udidocDO
	 * @return
	 * @throws BizException
	 */
	public FBoolean refreshComp(UdidocDO udidocDO) throws BizException;
}
