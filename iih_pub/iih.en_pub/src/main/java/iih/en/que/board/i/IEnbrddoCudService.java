package iih.en.que.board.i;

import xap.mw.core.data.BizException;
import iih.en.que.board.d.EnBrdDO;
import iih.en.que.board.d.EnbrddoAggDO;

/**
* 患者就诊_大屏数据维护服务
*/
public interface IEnbrddoCudService {
	/**
	*  患者就诊_大屏数据真删除
	*/
    public abstract void delete(EnbrddoAggDO[] aggdos) throws BizException;
    
    /**
	*  患者就诊_大屏数据插入保存
	*/
	public abstract EnbrddoAggDO[] insert(EnbrddoAggDO[] aggdos) throws BizException;
	
    /**
	*  患者就诊_大屏数据保存
	*/
	public abstract EnbrddoAggDO[] save(EnbrddoAggDO[] aggdos) throws BizException;
	
    /**
	*  患者就诊_大屏数据更新
	*/
	public abstract EnbrddoAggDO[] update(EnbrddoAggDO[] aggdos) throws BizException;
	
	/**
	*  患者就诊_大屏数据逻辑删除
	*/
	public abstract void logicDelete(EnbrddoAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对患者就诊_大屏数据真删除
	 */
	public abstract void deleteByParentDO(EnBrdDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对患者就诊_大屏数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(EnBrdDO[] mainDos) throws BizException;
}
