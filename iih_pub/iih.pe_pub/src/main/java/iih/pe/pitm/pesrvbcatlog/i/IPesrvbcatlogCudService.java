package iih.pe.pitm.pesrvbcatlog.i;

import xap.mw.core.data.BizException;
import iih.pe.pitm.pesrvbcatlog.d.PeSrvbCatlogDO;
import iih.pe.pitm.pesrvbcatlog.d.PesrvbcatlogAggDO;

/**
* 体检项目基本目录数据维护服务
*/
public interface IPesrvbcatlogCudService {
	/**
	*  体检项目基本目录数据真删除
	*/
    public abstract void delete(PesrvbcatlogAggDO[] aggdos) throws BizException;
    
    /**
	*  体检项目基本目录数据插入保存
	*/
	public abstract PesrvbcatlogAggDO[] insert(PesrvbcatlogAggDO[] aggdos) throws BizException;
	
    /**
	*  体检项目基本目录数据保存
	*/
	public abstract PesrvbcatlogAggDO[] save(PesrvbcatlogAggDO[] aggdos) throws BizException;
	
    /**
	*  体检项目基本目录数据更新
	*/
	public abstract PesrvbcatlogAggDO[] update(PesrvbcatlogAggDO[] aggdos) throws BizException;
	
	/**
	*  体检项目基本目录数据逻辑删除
	*/
	public abstract void logicDelete(PesrvbcatlogAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对体检项目基本目录数据真删除
	 */
	public abstract void deleteByParentDO(PeSrvbCatlogDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对体检项目基本目录数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(PeSrvbCatlogDO[] mainDos) throws BizException;
}
