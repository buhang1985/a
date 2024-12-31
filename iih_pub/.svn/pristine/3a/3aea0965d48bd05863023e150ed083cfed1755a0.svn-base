package iih.pe.pitm.perstdocdidef.i;

import xap.mw.core.data.BizException;
import iih.pe.pitm.perstdocdidef.d.PeDocTmplDO;
import iih.pe.pitm.perstdocdidef.d.PerstdocdidefAggDO;

/**
* 体检医生模板数据维护服务
*/
public interface IPerstdocdidefCudService {
	/**
	*  体检医生模板数据真删除
	*/
    public abstract void delete(PerstdocdidefAggDO[] aggdos) throws BizException;
    
    /**
	*  体检医生模板数据插入保存
	*/
	public abstract PerstdocdidefAggDO[] insert(PerstdocdidefAggDO[] aggdos) throws BizException;
	
    /**
	*  体检医生模板数据保存
	*/
	public abstract PerstdocdidefAggDO[] save(PerstdocdidefAggDO[] aggdos) throws BizException;
	
    /**
	*  体检医生模板数据更新
	*/
	public abstract PerstdocdidefAggDO[] update(PerstdocdidefAggDO[] aggdos) throws BizException;
	
	/**
	*  体检医生模板数据逻辑删除
	*/
	public abstract void logicDelete(PerstdocdidefAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对体检医生模板数据真删除
	 */
	public abstract void deleteByParentDO(PeDocTmplDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对体检医生模板数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(PeDocTmplDO[] mainDos) throws BizException;
}
