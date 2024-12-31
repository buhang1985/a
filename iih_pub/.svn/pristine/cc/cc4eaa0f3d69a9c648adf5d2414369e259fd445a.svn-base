package iih.pe.pitm.pesrvitemdep.i;

import xap.mw.core.data.BizException;
import iih.pe.pitm.pesrvitemdep.d.PeSrvItemDepDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 体检科室关注项目设定数据维护服务
*/
public interface IPesrvitemdepCudService {
	/**
	*  体检科室关注项目设定数据真删除
	*/
    public abstract void delete(PeSrvItemDepDO[] aggdos) throws BizException;
    
    /**
	*  体检科室关注项目设定数据插入保存
	*/
	public abstract PeSrvItemDepDO[] insert(PeSrvItemDepDO[] aggdos) throws BizException;
	
    /**
	*  体检科室关注项目设定数据保存
	*/
	public abstract PeSrvItemDepDO[] save(PeSrvItemDepDO[] aggdos) throws BizException;
	
    /**
	*  体检科室关注项目设定数据更新
	*/
	public abstract PeSrvItemDepDO[] update(PeSrvItemDepDO[] aggdos) throws BizException;
	
	/**
	*  体检科室关注项目设定数据逻辑删除
	*/
	public abstract void logicDelete(PeSrvItemDepDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PeSrvItemDepDO[] enableWithoutFilter(PeSrvItemDepDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PeSrvItemDepDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PeSrvItemDepDO[] disableVOWithoutFilter(PeSrvItemDepDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PeSrvItemDepDO[] dos) throws BizException ;
}
