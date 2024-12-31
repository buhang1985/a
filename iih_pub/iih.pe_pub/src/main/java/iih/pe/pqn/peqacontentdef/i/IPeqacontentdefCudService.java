package iih.pe.pqn.peqacontentdef.i;

import xap.mw.core.data.BizException;
import iih.pe.pqn.peqacontentdef.d.PeQacontentDefDO;
import iih.pe.pqn.peqacontentdef.d.PeqacontentdefAggDO;

/**
* 体检问卷问题库数据维护服务
*/
public interface IPeqacontentdefCudService {
	/**
	*  体检问卷问题库数据真删除
	*/
    public abstract void delete(PeqacontentdefAggDO[] aggdos) throws BizException;
    
    /**
	*  体检问卷问题库数据插入保存
	*/
	public abstract PeqacontentdefAggDO[] insert(PeqacontentdefAggDO[] aggdos) throws BizException;
	
    /**
	*  体检问卷问题库数据保存
	*/
	public abstract PeqacontentdefAggDO[] save(PeqacontentdefAggDO[] aggdos) throws BizException;
	
    /**
	*  体检问卷问题库数据更新
	*/
	public abstract PeqacontentdefAggDO[] update(PeqacontentdefAggDO[] aggdos) throws BizException;
	
	/**
	*  体检问卷问题库数据逻辑删除
	*/
	public abstract void logicDelete(PeqacontentdefAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对体检问卷问题库数据真删除
	 */
	public abstract void deleteByParentDO(PeQacontentDefDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对体检问卷问题库数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(PeQacontentDefDO[] mainDos) throws BizException;
}
