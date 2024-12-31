package iih.nm.nhr.nmnhrquit.i;

import xap.mw.core.data.BizException;
import iih.nm.nhr.nmnhrquit.d.NmNhrQuitDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 护理管理_人员辞职数据维护服务
*/
public interface INmnhrquitCudService {
	/**
	*  护理管理_人员辞职数据真删除
	*/
    public abstract void delete(NmNhrQuitDO[] aggdos) throws BizException;
    
    /**
	*  护理管理_人员辞职数据插入保存
	*/
	public abstract NmNhrQuitDO[] insert(NmNhrQuitDO[] aggdos) throws BizException;
	
    /**
	*  护理管理_人员辞职数据保存
	*/
	public abstract NmNhrQuitDO[] save(NmNhrQuitDO[] aggdos) throws BizException;
	
    /**
	*  护理管理_人员辞职数据更新
	*/
	public abstract NmNhrQuitDO[] update(NmNhrQuitDO[] aggdos) throws BizException;
	
	/**
	*  护理管理_人员辞职数据逻辑删除
	*/
	public abstract void logicDelete(NmNhrQuitDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public NmNhrQuitDO[] enableWithoutFilter(NmNhrQuitDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(NmNhrQuitDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public NmNhrQuitDO[] disableVOWithoutFilter(NmNhrQuitDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(NmNhrQuitDO[] dos) throws BizException ;
}
