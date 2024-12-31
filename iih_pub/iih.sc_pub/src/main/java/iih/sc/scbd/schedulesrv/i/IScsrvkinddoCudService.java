package iih.sc.scbd.schedulesrv.i;

import xap.mw.core.data.BizException;
import iih.sc.scbd.schedulesrv.d.ScSrvKindDO;
import iih.sc.scbd.schedulesrv.d.ScsrvkinddoAggDO;

/**
* 排班服务类别数据维护服务
*/
public interface IScsrvkinddoCudService {
	/**
	*  排班服务类别数据真删除
	*/
    public abstract void delete(ScsrvkinddoAggDO[] aggdos) throws BizException;
    
    /**
	*  排班服务类别数据插入保存
	*/
	public abstract ScsrvkinddoAggDO[] insert(ScsrvkinddoAggDO[] aggdos) throws BizException;
	
    /**
	*  排班服务类别数据保存
	*/
	public abstract ScsrvkinddoAggDO[] save(ScsrvkinddoAggDO[] aggdos) throws BizException;
	
    /**
	*  排班服务类别数据更新
	*/
	public abstract ScsrvkinddoAggDO[] update(ScsrvkinddoAggDO[] aggdos) throws BizException;
	
	/**
	*  排班服务类别数据逻辑删除
	*/
	public abstract void logicDelete(ScsrvkinddoAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对排班服务类别数据真删除
	 */
	public abstract void deleteByParentDO(ScSrvKindDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对排班服务类别数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(ScSrvKindDO[] mainDos) throws BizException;
}
