package iih.pe.por.pepsnbinfo.i;

import xap.mw.core.data.BizException;
import iih.pe.por.pepsnbinfo.d.PePsnBInfoDO;
import iih.pe.por.pepsnbinfo.d.PepsnbinfoAggDO;

/**
* 体检客户基本资料数据维护服务
*/
public interface IPepsnbinfoCudService {
	/**
	*  体检客户基本资料数据真删除
	*/
    public abstract void delete(PepsnbinfoAggDO[] aggdos) throws BizException;
    
    /**
	*  体检客户基本资料数据插入保存
	*/
	public abstract PepsnbinfoAggDO[] insert(PepsnbinfoAggDO[] aggdos) throws BizException;
	
    /**
	*  体检客户基本资料数据保存
	*/
	public abstract PepsnbinfoAggDO[] save(PepsnbinfoAggDO[] aggdos) throws BizException;
	
    /**
	*  体检客户基本资料数据更新
	*/
	public abstract PepsnbinfoAggDO[] update(PepsnbinfoAggDO[] aggdos) throws BizException;
	
	/**
	*  体检客户基本资料数据逻辑删除
	*/
	public abstract void logicDelete(PepsnbinfoAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对体检客户基本资料数据真删除
	 */
	public abstract void deleteByParentDO(PePsnBInfoDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对体检客户基本资料数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(PePsnBInfoDO[] mainDos) throws BizException;
}
