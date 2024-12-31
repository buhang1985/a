package iih.bd.pp.singlediamt.i;

import xap.mw.core.data.BizException;
import iih.bd.pp.singlediamt.d.SingleDiDepAmtDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 医保计划单病种控费数据维护服务
*/
public interface ISingleDiDepAmtDOCudService {
	/**
	*  医保计划单病种控费数据真删除
	*/
    public abstract void delete(SingleDiDepAmtDO[] aggdos) throws BizException;
    
    /**
	*  医保计划单病种控费数据插入保存
	*/
	public abstract SingleDiDepAmtDO[] insert(SingleDiDepAmtDO[] aggdos) throws BizException;
	
    /**
	*  医保计划单病种控费数据保存
	*/
	public abstract SingleDiDepAmtDO[] save(SingleDiDepAmtDO[] aggdos) throws BizException;
	
    /**
	*  医保计划单病种控费数据更新
	*/
	public abstract SingleDiDepAmtDO[] update(SingleDiDepAmtDO[] aggdos) throws BizException;
	
	/**
	*  医保计划单病种控费数据逻辑删除
	*/
	public abstract void logicDelete(SingleDiDepAmtDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public SingleDiDepAmtDO[] enableWithoutFilter(SingleDiDepAmtDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(SingleDiDepAmtDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public SingleDiDepAmtDO[] disableVOWithoutFilter(SingleDiDepAmtDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(SingleDiDepAmtDO[] aggdos) throws BizException ;
	
}
