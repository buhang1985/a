package iih.bd.srv.srvpkggrpitm.i;

import xap.mw.core.data.BizException;
import  iih.bd.srv.srvpkggrpitm.d.SrvpkggrpitmAggDO;

/**
* 医疗服务包分组项目数据维护服务
*/
public interface ISrvpkggrpitmCudService {
	/**
	*  医疗服务包分组项目数据真删除
	*/
    public abstract void delete(SrvpkggrpitmAggDO[] aggdos) throws BizException;
    
    /**
	*  医疗服务包分组项目数据插入保存
	*/
	public abstract SrvpkggrpitmAggDO[] insert(SrvpkggrpitmAggDO[] aggdos) throws BizException;
	
    /**
	*  医疗服务包分组项目数据保存
	*/
	public abstract SrvpkggrpitmAggDO[] save(SrvpkggrpitmAggDO[] aggdos) throws BizException;
	
    /**
	*  医疗服务包分组项目数据更新
	*/
	public abstract SrvpkggrpitmAggDO[] update(SrvpkggrpitmAggDO[] aggdos) throws BizException;
	
	/**
	*  医疗服务包分组项目数据逻辑删除
	*/
	public abstract void logicDelete(SrvpkggrpitmAggDO[] aggdos) throws BizException;
}
