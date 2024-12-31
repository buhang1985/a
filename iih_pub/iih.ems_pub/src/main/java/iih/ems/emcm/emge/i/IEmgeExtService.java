package iih.ems.emcm.emge.i;


import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.*;
import iih.ems.eass.emcardbycon.d.EmCardByConDTO;

/**
* 设备计量记录数据维护服务
*/
public interface IEmgeExtService {
	
    /**
	*  根据计量分类  组建资产树 集合
	*/	
	public abstract EmCardByConDTO[] findByGeca(String whereStr,String orderStr,FBoolean isLazy) throws BizException;
	/**
	*  根据部门  组建资产树 集合
	*/	
	public abstract EmCardByConDTO[] findByDept(String whereStr,String orderStr,FBoolean isLazy) throws BizException;
	
}