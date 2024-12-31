package iih.mp.mpbd.mprscarditm.i;

import xap.mw.core.data.BizException;
import iih.mp.mpbd.mprscarditm.d.MpRsCardItmDO;
import iih.mp.mpbd.mprscarditm.d.MprscarditmAggDO;

/**
* 护士站滚屏卡信息明细数据维护服务
*/
public interface IMprscarditmCudService {
	/**
	*  护士站滚屏卡信息明细数据真删除
	*/
    public abstract void delete(MprscarditmAggDO[] aggdos) throws BizException;
    
    /**
	*  护士站滚屏卡信息明细数据插入保存
	*/
	public abstract MprscarditmAggDO[] insert(MprscarditmAggDO[] aggdos) throws BizException;
	
    /**
	*  护士站滚屏卡信息明细数据保存
	*/
	public abstract MprscarditmAggDO[] save(MprscarditmAggDO[] aggdos) throws BizException;
	
    /**
	*  护士站滚屏卡信息明细数据更新
	*/
	public abstract MprscarditmAggDO[] update(MprscarditmAggDO[] aggdos) throws BizException;
	
	/**
	*  护士站滚屏卡信息明细数据逻辑删除
	*/
	public abstract void logicDelete(MprscarditmAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对护士站滚屏卡信息明细数据真删除
	 */
	public abstract void deleteByParentDO(MpRsCardItmDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对护士站滚屏卡信息明细数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(MpRsCardItmDO[] mainDos) throws BizException;
}
