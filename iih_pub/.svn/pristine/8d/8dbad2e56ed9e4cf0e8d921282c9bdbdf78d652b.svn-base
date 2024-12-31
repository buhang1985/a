package iih.mp.nr.nurhdv.i;

import xap.mw.core.data.BizException;
import iih.mp.nr.nurhdv.d.HdvEntDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 护士交接班数据维护服务
*/
public interface INurhdvMDOCudService {
	/**
	*  护士交接班数据真删除
	*/
    public abstract void delete(HdvEntDO[] aggdos) throws BizException;
    
    /**
	*  护士交接班数据插入保存
	*/
	public abstract HdvEntDO[] insert(HdvEntDO[] aggdos) throws BizException;
	
    /**
	*  护士交接班数据保存
	*/
	public abstract HdvEntDO[] save(HdvEntDO[] aggdos) throws BizException;
	
    /**
	*  护士交接班数据更新
	*/
	public abstract HdvEntDO[] update(HdvEntDO[] aggdos) throws BizException;
	
	/**
	*  护士交接班数据逻辑删除
	*/
	public abstract void logicDelete(HdvEntDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public HdvEntDO[] enableWithoutFilter(HdvEntDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(HdvEntDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public HdvEntDO[] disableVOWithoutFilter(HdvEntDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(HdvEntDO[] aggdos) throws BizException ;
	
}
