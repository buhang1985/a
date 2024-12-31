package iih.bd.srv.srvrtctl.s.bp;

import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;

import iih.bd.srv.srvrtctl.d.SrvRtCtlDO;
import iih.bd.srv.srvrtctl.i.ISrvrtctlMDORService;
import iih.bd.srv.srvrtempref.d.SrvRtEmpRefDO;
import iih.bd.srv.srvrtempref.i.ISrvrtemprefRService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 根据人员主键查询服务开立权限集合业务逻辑
 * 
 * @author hao_wu
 *
 */
public class FindSrvRtCtlByEmpIdBp {

	public SrvRtCtlDO[] exec(String empId) throws BizException {
		SrvRtEmpRefDO[] srvRtEmpRefs = findSrvRtEmpRefByEmpId(empId);
		String[] srvRtCtlIds = getSrvRtCtlIds(srvRtEmpRefs);
		SrvRtCtlDO[] result = findSrvRtCtlByIds(srvRtCtlIds);
		return result;
	}

	/**
	 * 
	 * 根据人员主键查询人员与服务开立权限关系
	 * 
	 * @author hao_wu
	 * @param empId
	 *            人员主键
	 * @return
	 * @throws BizException
	 */
	private SrvRtEmpRefDO[] findSrvRtEmpRefByEmpId(String empId) throws BizException {
		if (StringUtils.isEmpty(empId)) {
			return null;
		}
		ISrvrtemprefRService srvrtemprefRService = ServiceFinder.find(ISrvrtemprefRService.class);
		SrvRtEmpRefDO[] result = srvrtemprefRService.findByAttrValString(SrvRtEmpRefDO.ID_EMP_PHY, empId);
		return result;
	}

	/**
	 * 获取服务开立权限主键集合
	 * 
	 * @author hao_wu
	 * @param srvRtEmpRefs
	 * @return
	 */
	private String[] getSrvRtCtlIds(SrvRtEmpRefDO[] srvRtEmpRefs) {
		if (srvRtEmpRefs == null || srvRtEmpRefs.length <= 0) {
			return null;
		}

		ArrayList<String> srvRtCtlIdList = new ArrayList<String>();
		for (SrvRtEmpRefDO srvRtEmpRefDO : srvRtEmpRefs) {
			if (srvRtEmpRefDO != null && StringUtils.isNotEmpty(srvRtEmpRefDO.getId_srvrt())) {
				srvRtCtlIdList.add(srvRtEmpRefDO.getId_srvrt());
			}
		}

		return srvRtCtlIdList.toArray(new String[0]);
	}

	/**
	 * 根据服务开立权限主键集合查询服务开立权限
	 * 
	 * @author hao_wu
	 * @param srvRtCtlIds
	 * @return
	 * @throws BizException
	 */
	private SrvRtCtlDO[] findSrvRtCtlByIds(String[] srvRtCtlIds) throws BizException {
		if (srvRtCtlIds == null || srvRtCtlIds.length <= 0) {
			return null;
		}
		ISrvrtctlMDORService srvrtctlMDORService = ServiceFinder.find(ISrvrtctlMDORService.class);
		SrvRtCtlDO[] result = srvrtctlMDORService.findByIds(srvRtCtlIds, FBoolean.FALSE);
		return result;
	}
}
