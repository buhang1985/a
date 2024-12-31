package iih.sfda.adbd.i;

import iih.sfda.adbd.dto.evfuncdto.d.EvFuncDTO;
import xap.mw.core.data.BizException;

public interface IAdbdQueryService {

	/**
	 * 根据全类名和科室获取流程配置项事件处理责任人
	 * 
	 * @param fullname
	 * @return
	 * @throws BizException
	 * @author lijm
	 */
	public String[] getConfigItmPsnByClassAndDep(String className, String id_dep) throws BizException;

	/**
	 * 根据全类名和事件类型编码获取流程配置项事件处理责任人
	 * 
	 * @param fullname
	 * @return
	 * @throws BizException
	 * @author lijm
	 */
	public String[] getConfigItmPsnByClassAndEvCa(String className, String code_evca) throws BizException;

	/**
	 * 获取事件对应功能节点列表
	 * 
	 * @return
	 * @throws BizException
	 */
	public EvFuncDTO[] getEvFuncList() throws BizException;

}
