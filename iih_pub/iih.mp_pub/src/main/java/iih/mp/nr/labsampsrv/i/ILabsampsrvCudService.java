package iih.mp.nr.labsampsrv.i;

import xap.mw.core.data.BizException;
import iih.mp.nr.labsampsrv.d.LabSampSrvDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 标本费用数据维护服务
*/
public interface ILabsampsrvCudService {
	/**
	*  标本费用数据真删除
	*/
    public abstract void delete(LabSampSrvDO[] aggdos) throws BizException;
    
    /**
	*  标本费用数据插入保存
	*/
	public abstract LabSampSrvDO[] insert(LabSampSrvDO[] aggdos) throws BizException;
	
    /**
	*  标本费用数据保存
	*/
	public abstract LabSampSrvDO[] save(LabSampSrvDO[] aggdos) throws BizException;
	
    /**
	*  标本费用数据更新
	*/
	public abstract LabSampSrvDO[] update(LabSampSrvDO[] aggdos) throws BizException;
	
	/**
	*  标本费用数据逻辑删除
	*/
	public abstract void logicDelete(LabSampSrvDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public LabSampSrvDO[] enableWithoutFilter(LabSampSrvDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(LabSampSrvDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public LabSampSrvDO[] disableVOWithoutFilter(LabSampSrvDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(LabSampSrvDO[] dos) throws BizException ;
}