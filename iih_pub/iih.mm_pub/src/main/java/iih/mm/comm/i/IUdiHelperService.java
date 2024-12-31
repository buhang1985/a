package iih.mm.comm.i;

import xap.mw.core.data.BizException;
import xap.sys.xbd.udi.d.UdidocDO;

public interface IUdiHelperService {
	/**
	 * 根据编码查询组织结构下的自定义档案
	 * @param orgId 组织机构ID
	 * @param type 自定义档案类型编码
	 * @param code 自定义档案编码
	 * @return
	 * @throws BizException
	 */
	public UdidocDO getUdidocByCode(String orgId, String type, String code) throws BizException;
	
	public UdidocDO getUdidocById(String docId) throws BizException;
}
