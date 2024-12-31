package iih.pe.pds.pedsprodrel.i;

import xap.mw.core.data.BizException;
import iih.pe.pds.pedsprodrel.d.PeDsProdRelDtlDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 体检产品项目关联关系数据维护服务
*/
public interface IPeDsProdRelDtlDOCudService {
	/**
	*  体检产品项目关联关系数据真删除
	*/
    public abstract void delete(PeDsProdRelDtlDO[] aggdos) throws BizException;
    
    /**
	*  体检产品项目关联关系数据插入保存
	*/
	public abstract PeDsProdRelDtlDO[] insert(PeDsProdRelDtlDO[] aggdos) throws BizException;
	
    /**
	*  体检产品项目关联关系数据保存
	*/
	public abstract PeDsProdRelDtlDO[] save(PeDsProdRelDtlDO[] aggdos) throws BizException;
	
    /**
	*  体检产品项目关联关系数据更新
	*/
	public abstract PeDsProdRelDtlDO[] update(PeDsProdRelDtlDO[] aggdos) throws BizException;
	
	/**
	*  体检产品项目关联关系数据逻辑删除
	*/
	public abstract void logicDelete(PeDsProdRelDtlDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PeDsProdRelDtlDO[] enableWithoutFilter(PeDsProdRelDtlDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PeDsProdRelDtlDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PeDsProdRelDtlDO[] disableVOWithoutFilter(PeDsProdRelDtlDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PeDsProdRelDtlDO[] aggdos) throws BizException ;
	
}
