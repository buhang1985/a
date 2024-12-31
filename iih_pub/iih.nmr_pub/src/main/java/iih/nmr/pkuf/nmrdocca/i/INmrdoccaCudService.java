package iih.nmr.pkuf.nmrdocca.i;

import xap.mw.core.data.BizException;
import iih.nmr.pkuf.nmrdocca.d.NmrDocCaDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 护理文书分类数据维护服务
*/
public interface INmrdoccaCudService {
	/**
	*  护理文书分类数据真删除
	*/
    public abstract void delete(NmrDocCaDO[] aggdos) throws BizException;
    
    /**
	*  护理文书分类数据插入保存
	*/
	public abstract NmrDocCaDO[] insert(NmrDocCaDO[] aggdos) throws BizException;
	
    /**
	*  护理文书分类数据保存
	*/
	public abstract NmrDocCaDO[] save(NmrDocCaDO[] aggdos) throws BizException;
	
    /**
	*  护理文书分类数据更新
	*/
	public abstract NmrDocCaDO[] update(NmrDocCaDO[] aggdos) throws BizException;
	
	/**
	*  护理文书分类数据逻辑删除
	*/
	public abstract void logicDelete(NmrDocCaDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public NmrDocCaDO[] enableWithoutFilter(NmrDocCaDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(NmrDocCaDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public NmrDocCaDO[] disableVOWithoutFilter(NmrDocCaDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(NmrDocCaDO[] dos) throws BizException ;
}
