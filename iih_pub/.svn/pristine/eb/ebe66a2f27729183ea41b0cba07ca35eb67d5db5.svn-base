package iih.mp.mpbd.docmemo.i;

import xap.mw.core.data.BizException;
import iih.mp.mpbd.docmemo.d.DocrMemoDO;
import iih.mp.mpbd.docmemo.d.DocmemoAggDO;

/**
* 医生备忘录数据维护服务
*/
public interface IDocmemoCudService {
	/**
	*  医生备忘录数据真删除
	*/
    public abstract void delete(DocmemoAggDO[] aggdos) throws BizException;
    
    /**
	*  医生备忘录数据插入保存
	*/
	public abstract DocmemoAggDO[] insert(DocmemoAggDO[] aggdos) throws BizException;
	
    /**
	*  医生备忘录数据保存
	*/
	public abstract DocmemoAggDO[] save(DocmemoAggDO[] aggdos) throws BizException;
	
    /**
	*  医生备忘录数据更新
	*/
	public abstract DocmemoAggDO[] update(DocmemoAggDO[] aggdos) throws BizException;
	
	/**
	*  医生备忘录数据逻辑删除
	*/
	public abstract void logicDelete(DocmemoAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对医生备忘录数据真删除
	 */
	public abstract void deleteByParentDO(DocrMemoDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对医生备忘录数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(DocrMemoDO[] mainDos) throws BizException;
}
