package iih.pe.pds.pedsprodrel.i;

import xap.mw.core.data.BizException;
import iih.pe.pds.pedsprodrel.d.PeDsProdRelDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 体检产品项目关联关系数据维护服务
*/
public interface IPedsprodrelMDOCudService {
	/**
	*  体检产品项目关联关系数据真删除
	*/
    public abstract void delete(PeDsProdRelDO[] aggdos) throws BizException;
    
    /**
	*  体检产品项目关联关系数据插入保存
	*/
	public abstract PeDsProdRelDO[] insert(PeDsProdRelDO[] aggdos) throws BizException;
	
    /**
	*  体检产品项目关联关系数据保存
	*/
	public abstract PeDsProdRelDO[] save(PeDsProdRelDO[] aggdos) throws BizException;
	
    /**
	*  体检产品项目关联关系数据更新
	*/
	public abstract PeDsProdRelDO[] update(PeDsProdRelDO[] aggdos) throws BizException;
	
	/**
	*  体检产品项目关联关系数据逻辑删除
	*/
	public abstract void logicDelete(PeDsProdRelDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PeDsProdRelDO[] enableWithoutFilter(PeDsProdRelDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PeDsProdRelDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PeDsProdRelDO[] disableVOWithoutFilter(PeDsProdRelDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PeDsProdRelDO[] aggdos) throws BizException ;
	
}
