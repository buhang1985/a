package iih.bd.pp.com.i;

import xap.mw.core.data.BizException;
import xap.sys.xbd.udi.d.UdidocDO;


public interface IUdidocHelperService {

	/**
	 * @param id_udidoclist基础档案集主键ID
	 * @return 基础档案
	 * @throws BizException
	 */
	public abstract UdidocDO[] findUdidocByIdlist(String id_udidoclist) throws BizException;
	
	public UdidocDO[] findByAttrValString(String key,String value)throws BizException;
}
