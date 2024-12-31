package iih.en.doc.pregdoc.i;

import xap.mw.core.data.BizException;
import iih.en.doc.pregdoc.d.PregDocDO;
import iih.en.doc.pregdoc.d.PregdocAggDO;

/**
* 产科建档数据维护服务
*/
public interface IPregdocCudService {
	/**
	*  产科建档数据真删除
	*/
    public abstract void delete(PregdocAggDO[] aggdos) throws BizException;
    
    /**
	*  产科建档数据插入保存
	*/
	public abstract PregdocAggDO[] insert(PregdocAggDO[] aggdos) throws BizException;
	
    /**
	*  产科建档数据保存
	*/
	public abstract PregdocAggDO[] save(PregdocAggDO[] aggdos) throws BizException;
	
    /**
	*  产科建档数据更新
	*/
	public abstract PregdocAggDO[] update(PregdocAggDO[] aggdos) throws BizException;
	
	/**
	*  产科建档数据逻辑删除
	*/
	public abstract void logicDelete(PregdocAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对产科建档数据真删除
	 */
	public abstract void deleteByParentDO(PregDocDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对产科建档数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(PregDocDO[] mainDos) throws BizException;
}
