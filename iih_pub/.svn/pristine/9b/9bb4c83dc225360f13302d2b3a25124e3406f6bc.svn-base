package iih.bd.srv.emrtpl.i;

import iih.bd.srv.dto.d.PhySignDTO;
import iih.bd.srv.emrtpl.d.EmrTplDO;
import xap.mw.core.data.BizException;

/**
 * 预检模板服务
 * @author yankan
 *
 */
public interface IMrtplForPreService {
	/**
	 * 获取预检模板
	 * @param depId 部门id
	 * @param mrtpCode 模板类型编码
	 * @return
	 * @throws BizException
	 */
	EmrTplDO[] getPreMrtpl(String depId,String mrtpCode) throws BizException;
	/**
	 * 获取体征采集项目列表
	 * @param mrtplId 模板id
	 * @return
	 * @throws BizException
	 */
	PhySignDTO[] getPhySignDTOList(String mrtplId) throws BizException;
	/**
	 * 获取体征采集项目列表
	 * @param depId 部门id
	 * @param mrtpCode 模板类型编码
	 * @return
	 * @throws BizException
	 */
	PhySignDTO[] getPrePhySignDTOList(String depId,String mrtpCode) throws BizException;
}
