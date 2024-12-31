package iih.pe.pbd.pememcard.i;

import xap.mw.core.data.BizException;
import iih.pe.pbd.pememcard.d.PeMemCardDefDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 体检会员卡定义数据维护服务
*/
public interface IPememcardCudService {
	/**
	*  体检会员卡定义数据真删除
	*/
    public abstract void delete(PeMemCardDefDO[] aggdos) throws BizException;
    
    /**
	*  体检会员卡定义数据插入保存
	*/
	public abstract PeMemCardDefDO[] insert(PeMemCardDefDO[] aggdos) throws BizException;
	
    /**
	*  体检会员卡定义数据保存
	*/
	public abstract PeMemCardDefDO[] save(PeMemCardDefDO[] aggdos) throws BizException;
	
    /**
	*  体检会员卡定义数据更新
	*/
	public abstract PeMemCardDefDO[] update(PeMemCardDefDO[] aggdos) throws BizException;
	
	/**
	*  体检会员卡定义数据逻辑删除
	*/
	public abstract void logicDelete(PeMemCardDefDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PeMemCardDefDO[] enableWithoutFilter(PeMemCardDefDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PeMemCardDefDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PeMemCardDefDO[] disableVOWithoutFilter(PeMemCardDefDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PeMemCardDefDO[] dos) throws BizException ;
}
