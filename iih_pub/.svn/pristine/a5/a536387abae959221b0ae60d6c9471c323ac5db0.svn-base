package iih.pe.pbd.pemembercardca.i;

import xap.mw.core.data.BizException;
import iih.pe.pbd.pemembercardca.d.PeMemCardCaDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 体检会员卡类别定义数据维护服务
*/
public interface IPemembercardcaCudService {
	/**
	*  体检会员卡类别定义数据真删除
	*/
    public abstract void delete(PeMemCardCaDO[] aggdos) throws BizException;
    
    /**
	*  体检会员卡类别定义数据插入保存
	*/
	public abstract PeMemCardCaDO[] insert(PeMemCardCaDO[] aggdos) throws BizException;
	
    /**
	*  体检会员卡类别定义数据保存
	*/
	public abstract PeMemCardCaDO[] save(PeMemCardCaDO[] aggdos) throws BizException;
	
    /**
	*  体检会员卡类别定义数据更新
	*/
	public abstract PeMemCardCaDO[] update(PeMemCardCaDO[] aggdos) throws BizException;
	
	/**
	*  体检会员卡类别定义数据逻辑删除
	*/
	public abstract void logicDelete(PeMemCardCaDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PeMemCardCaDO[] enableWithoutFilter(PeMemCardCaDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PeMemCardCaDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PeMemCardCaDO[] disableVOWithoutFilter(PeMemCardCaDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PeMemCardCaDO[] dos) throws BizException ;
}
