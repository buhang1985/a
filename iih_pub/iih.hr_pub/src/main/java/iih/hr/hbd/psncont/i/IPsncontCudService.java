package iih.hr.hbd.psncont.i;

import xap.mw.core.data.BizException;
import iih.hr.hbd.psncont.d.HbdPsnContDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 人员合同数据维护服务
*/
public interface IPsncontCudService {
	/**
	*  人员合同数据真删除
	*/
    public abstract void delete(HbdPsnContDO[] aggdos) throws BizException;
    
    /**
	*  人员合同数据插入保存
	*/
	public abstract HbdPsnContDO[] insert(HbdPsnContDO[] aggdos) throws BizException;
	
    /**
	*  人员合同数据保存
	*/
	public abstract HbdPsnContDO[] save(HbdPsnContDO[] aggdos) throws BizException;
	
    /**
	*  人员合同数据更新
	*/
	public abstract HbdPsnContDO[] update(HbdPsnContDO[] aggdos) throws BizException;
	
	/**
	*  人员合同数据逻辑删除
	*/
	public abstract void logicDelete(HbdPsnContDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public HbdPsnContDO[] enableWithoutFilter(HbdPsnContDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(HbdPsnContDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public HbdPsnContDO[] disableVOWithoutFilter(HbdPsnContDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(HbdPsnContDO[] dos) throws BizException ;
}
