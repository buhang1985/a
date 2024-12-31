package iih.mkr.std.deca.i;

import xap.mw.core.data.BizException;
import iih.mkr.std.deca.d.DataElemCateDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 	 基础编码_公共数据元分类数据维护服务
*/
public interface IDecaCudService {
	/**
	*  	 基础编码_公共数据元分类数据真删除
	*/
    public abstract void delete(DataElemCateDO[] aggdos) throws BizException;
    
    /**
	*  	 基础编码_公共数据元分类数据插入保存
	*/
	public abstract DataElemCateDO[] insert(DataElemCateDO[] aggdos) throws BizException;
	
    /**
	*  	 基础编码_公共数据元分类数据保存
	*/
	public abstract DataElemCateDO[] save(DataElemCateDO[] aggdos) throws BizException;
	
    /**
	*  	 基础编码_公共数据元分类数据更新
	*/
	public abstract DataElemCateDO[] update(DataElemCateDO[] aggdos) throws BizException;
	
	/**
	*  	 基础编码_公共数据元分类数据逻辑删除
	*/
	public abstract void logicDelete(DataElemCateDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public DataElemCateDO[] enableWithoutFilter(DataElemCateDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(DataElemCateDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public DataElemCateDO[] disableVOWithoutFilter(DataElemCateDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(DataElemCateDO[] dos) throws BizException ;
}
