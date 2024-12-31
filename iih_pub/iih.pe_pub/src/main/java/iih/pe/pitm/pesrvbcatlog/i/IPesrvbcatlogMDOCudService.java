package iih.pe.pitm.pesrvbcatlog.i;

import xap.mw.core.data.BizException;
import iih.pe.pitm.pesrvbcatlog.d.PeSrvbCatlogDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 体检项目基本目录数据维护服务
*/
public interface IPesrvbcatlogMDOCudService {
	/**
	*  体检项目基本目录数据真删除
	*/
    public abstract void delete(PeSrvbCatlogDO[] aggdos) throws BizException;
    
    /**
	*  体检项目基本目录数据插入保存
	*/
	public abstract PeSrvbCatlogDO[] insert(PeSrvbCatlogDO[] aggdos) throws BizException;
	
    /**
	*  体检项目基本目录数据保存
	*/
	public abstract PeSrvbCatlogDO[] save(PeSrvbCatlogDO[] aggdos) throws BizException;
	
    /**
	*  体检项目基本目录数据更新
	*/
	public abstract PeSrvbCatlogDO[] update(PeSrvbCatlogDO[] aggdos) throws BizException;
	
	/**
	*  体检项目基本目录数据逻辑删除
	*/
	public abstract void logicDelete(PeSrvbCatlogDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PeSrvbCatlogDO[] enableWithoutFilter(PeSrvbCatlogDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PeSrvbCatlogDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PeSrvbCatlogDO[] disableVOWithoutFilter(PeSrvbCatlogDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PeSrvbCatlogDO[] aggdos) throws BizException ;
	
}
