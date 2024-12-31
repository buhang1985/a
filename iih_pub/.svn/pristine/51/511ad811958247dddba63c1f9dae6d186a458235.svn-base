package iih.nm.nom.nommeet.i;

import xap.mw.core.data.BizException;
import iih.nm.nom.nommeet.d.NomMeetDO;
import iih.nm.nom.nommeet.d.NommeetAggDO;

/**
* 会议记录数据维护服务
*/
public interface INommeetCudService {
	/**
	*  会议记录数据真删除
	*/
    public abstract void delete(NommeetAggDO[] aggdos) throws BizException;
    
    /**
	*  会议记录数据插入保存
	*/
	public abstract NommeetAggDO[] insert(NommeetAggDO[] aggdos) throws BizException;
	
    /**
	*  会议记录数据保存
	*/
	public abstract NommeetAggDO[] save(NommeetAggDO[] aggdos) throws BizException;
	
    /**
	*  会议记录数据更新
	*/
	public abstract NommeetAggDO[] update(NommeetAggDO[] aggdos) throws BizException;
	
	/**
	*  会议记录数据逻辑删除
	*/
	public abstract void logicDelete(NommeetAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对会议记录数据真删除
	 */
	public abstract void deleteByParentDO(NomMeetDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对会议记录数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(NomMeetDO[] mainDos) throws BizException;
}
