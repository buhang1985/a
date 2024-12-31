package iih.sfda.aer.sfdaaerevpbpg.i;

import xap.mw.core.data.BizException;
import iih.sfda.aer.sfdaaerevpbpg.d.SfdaAerEvPbpgDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 护理安全_静脉炎事件数据维护服务
*/
public interface ISfdaaerevpbpgCudService {
	/**
	*  护理安全_静脉炎事件数据真删除
	*/
    public abstract void delete(SfdaAerEvPbpgDO[] aggdos) throws BizException;
    
    /**
	*  护理安全_静脉炎事件数据插入保存
	*/
	public abstract SfdaAerEvPbpgDO[] insert(SfdaAerEvPbpgDO[] aggdos) throws BizException;
	
    /**
	*  护理安全_静脉炎事件数据保存
	*/
	public abstract SfdaAerEvPbpgDO[] save(SfdaAerEvPbpgDO[] aggdos) throws BizException;
	
    /**
	*  护理安全_静脉炎事件数据更新
	*/
	public abstract SfdaAerEvPbpgDO[] update(SfdaAerEvPbpgDO[] aggdos) throws BizException;
	
	/**
	*  护理安全_静脉炎事件数据逻辑删除
	*/
	public abstract void logicDelete(SfdaAerEvPbpgDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public SfdaAerEvPbpgDO[] enableWithoutFilter(SfdaAerEvPbpgDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(SfdaAerEvPbpgDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public SfdaAerEvPbpgDO[] disableVOWithoutFilter(SfdaAerEvPbpgDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(SfdaAerEvPbpgDO[] dos) throws BizException ;
}