package iih.pe.pitm.peexercisetp.i;

import xap.mw.core.data.BizException;
import iih.pe.pitm.peexercisetp.d.PeExerciseTpDO;
import iih.pe.pitm.peexercisetp.d.PeexercisetpAggDO;

/**
* 体检运动类别数据维护服务
*/
public interface IPeexercisetpCudService {
	/**
	*  体检运动类别数据真删除
	*/
    public abstract void delete(PeexercisetpAggDO[] aggdos) throws BizException;
    
    /**
	*  体检运动类别数据插入保存
	*/
	public abstract PeexercisetpAggDO[] insert(PeexercisetpAggDO[] aggdos) throws BizException;
	
    /**
	*  体检运动类别数据保存
	*/
	public abstract PeexercisetpAggDO[] save(PeexercisetpAggDO[] aggdos) throws BizException;
	
    /**
	*  体检运动类别数据更新
	*/
	public abstract PeexercisetpAggDO[] update(PeexercisetpAggDO[] aggdos) throws BizException;
	
	/**
	*  体检运动类别数据逻辑删除
	*/
	public abstract void logicDelete(PeexercisetpAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对体检运动类别数据真删除
	 */
	public abstract void deleteByParentDO(PeExerciseTpDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对体检运动类别数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(PeExerciseTpDO[] mainDos) throws BizException;
}
