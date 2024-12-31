package iih.mkr.ms.comm.i;

import xap.mw.core.data.BizException;
import xap.sys.bdfw.bbd.d.PsndocAggDO;
import xap.sys.permfw.user.d.UserDO;
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
	
	/**
	 * 根据自定义档案id查询组织结构下的自定义档案
	 * @param docId 自定义档案id
	 * @return
	 * @throws BizException
	 */
	public UdidocDO getUdidocById(String docId) throws BizException;
	
	/**
	 * 根据自定义档案类型编码查询组织结构下的自定义档案列表
	 * @param type 自定义档案类型编码
	 * @return
	 * @throws BizException
	 */
	public UdidocDO[] getUdidocListByType(String type) throws  BizException;
	
	/**
	 * 根据用户ID获取用户信息
	 * @param userId 用户ID
	 * @return
	 * @throws BizException
	 */
	public UserDO getUserInfoByUserId(String userId) throws BizException;
	
	/**
	 * 根据用户ID获取用户人员信息
	 * @param userId 用户ID
	 * @return
	 * @throws BizException
	 */
	public PsndocAggDO getEmployeeInfoByUserId(String userId) throws BizException;
}
