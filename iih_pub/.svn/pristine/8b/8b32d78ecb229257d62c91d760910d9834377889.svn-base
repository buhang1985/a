package iih.pis.ivx.pisivxmat.i;

import xap.mw.core.data.BizException;
import iih.pis.ivx.pisivxmat.d.PisivxMatDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 微信患者材料数据维护服务
*/
public interface IPisivxmatCudService {
	/**
	*  微信患者材料数据真删除
	*/
    public abstract void delete(PisivxMatDO[] aggdos) throws BizException;
    
    /**
	*  微信患者材料数据插入保存
	*/
	public abstract PisivxMatDO[] insert(PisivxMatDO[] aggdos) throws BizException;
	
    /**
	*  微信患者材料数据保存
	*/
	public abstract PisivxMatDO[] save(PisivxMatDO[] aggdos) throws BizException;
	
    /**
	*  微信患者材料数据更新
	*/
	public abstract PisivxMatDO[] update(PisivxMatDO[] aggdos) throws BizException;
	
	/**
	*  微信患者材料数据逻辑删除
	*/
	public abstract void logicDelete(PisivxMatDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PisivxMatDO[] enableWithoutFilter(PisivxMatDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PisivxMatDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PisivxMatDO[] disableVOWithoutFilter(PisivxMatDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PisivxMatDO[] dos) throws BizException ;
}
