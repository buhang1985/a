package iih.pe.phm.pehmgroup.i;

import xap.mw.core.data.BizException;
import iih.pe.phm.pehmgroup.d.PeHmGroupDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 体检健康群体管理数据维护服务
*/
public interface IPehmgroupMDOCudService {
	/**
	*  体检健康群体管理数据真删除
	*/
    public abstract void delete(PeHmGroupDO[] aggdos) throws BizException;
    
    /**
	*  体检健康群体管理数据插入保存
	*/
	public abstract PeHmGroupDO[] insert(PeHmGroupDO[] aggdos) throws BizException;
	
    /**
	*  体检健康群体管理数据保存
	*/
	public abstract PeHmGroupDO[] save(PeHmGroupDO[] aggdos) throws BizException;
	
    /**
	*  体检健康群体管理数据更新
	*/
	public abstract PeHmGroupDO[] update(PeHmGroupDO[] aggdos) throws BizException;
	
	/**
	*  体检健康群体管理数据逻辑删除
	*/
	public abstract void logicDelete(PeHmGroupDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PeHmGroupDO[] enableWithoutFilter(PeHmGroupDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PeHmGroupDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PeHmGroupDO[] disableVOWithoutFilter(PeHmGroupDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PeHmGroupDO[] aggdos) throws BizException ;
	
}
