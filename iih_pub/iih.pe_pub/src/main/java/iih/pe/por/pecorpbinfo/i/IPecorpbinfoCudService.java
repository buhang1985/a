package iih.pe.por.pecorpbinfo.i;

import xap.mw.core.data.BizException;
import iih.pe.por.pecorpbinfo.d.PeCorpbInfoDO;
import iih.pe.por.pecorpbinfo.d.PecorpbinfoAggDO;

/**
* 体检团体信息数据维护服务
*/
public interface IPecorpbinfoCudService {
	/**
	*  体检团体信息数据真删除
	*/
    public abstract void delete(PecorpbinfoAggDO[] aggdos) throws BizException;
    
    /**
	*  体检团体信息数据插入保存
	*/
	public abstract PecorpbinfoAggDO[] insert(PecorpbinfoAggDO[] aggdos) throws BizException;
	
    /**
	*  体检团体信息数据保存
	*/
	public abstract PecorpbinfoAggDO[] save(PecorpbinfoAggDO[] aggdos) throws BizException;
	
    /**
	*  体检团体信息数据更新
	*/
	public abstract PecorpbinfoAggDO[] update(PecorpbinfoAggDO[] aggdos) throws BizException;
	
	/**
	*  体检团体信息数据逻辑删除
	*/
	public abstract void logicDelete(PecorpbinfoAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对体检团体信息数据真删除
	 */
	public abstract void deleteByParentDO(PeCorpbInfoDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对体检团体信息数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(PeCorpbInfoDO[] mainDos) throws BizException;
}
