package iih.mp.dg.i.external.provide;

import iih.mp.dg.dto.dgrtnorderdto.d.DgRtnOrderDTO;
import xap.mw.core.data.BizException;

/**
 * 药品执行域提供给基础数据域的服务实现
 * 
 * @author hou_sudan 2019年12月4日
 *
 */
public interface IMpDgCIService {
	
	/**
	 * 查询住院患者某次就诊药品的用药情况列表
	 */
	public abstract DgRtnOrderDTO[] findIpDrugUseList(String id_ent, DgRtnOrderDTO[] ordDtos) throws BizException;
}
