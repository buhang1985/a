package iih.en.que.board.i;

import xap.mw.core.data.BizException;
import iih.en.que.board.d.EnBrdSiteDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 患者就诊_大屏_大屏站点数据维护服务
*/
public interface IEnbrdsitedoCudService {
	/**
	*  患者就诊_大屏_大屏站点数据真删除
	*/
    public abstract void delete(EnBrdSiteDO[] aggdos) throws BizException;
    
    /**
	*  患者就诊_大屏_大屏站点数据插入保存
	*/
	public abstract EnBrdSiteDO[] insert(EnBrdSiteDO[] aggdos) throws BizException;
	
    /**
	*  患者就诊_大屏_大屏站点数据保存
	*/
	public abstract EnBrdSiteDO[] save(EnBrdSiteDO[] aggdos) throws BizException;
	
    /**
	*  患者就诊_大屏_大屏站点数据更新
	*/
	public abstract EnBrdSiteDO[] update(EnBrdSiteDO[] aggdos) throws BizException;
	
	/**
	*  患者就诊_大屏_大屏站点数据逻辑删除
	*/
	public abstract void logicDelete(EnBrdSiteDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public EnBrdSiteDO[] enableWithoutFilter(EnBrdSiteDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(EnBrdSiteDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public EnBrdSiteDO[] disableVOWithoutFilter(EnBrdSiteDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(EnBrdSiteDO[] dos) throws BizException ;
}
