package iih.bd.base.ext.s.bp;

import java.util.ArrayList;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import iih.bd.srv.srvrtctl.d.SrvRtCtlDO;
import iih.bd.srv.srvrtctl.i.ISrvRtCtlExtRService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 根据人员主键查询服务开立权限列表业务逻辑
 * 
 * @author hao_wu 2019-4-25
 *
 */
public class FindSrvRtCtlByEmpIdBp {

	public String[] exec(String psnDocId) throws BizException {
		if (StringUtils.isBlank(psnDocId)) {
			return null;
		}

		String[] srvRtCtlNames = findSrvRtCtlNames(psnDocId);
		return srvRtCtlNames;
	}

	/**
	 * 查询服务开立权限名称集合
	 * 
	 * @param psnDocId
	 * @return
	 * @throws BizException
	 */
	private String[] findSrvRtCtlNames(String psnDocId) throws BizException {
		ISrvRtCtlExtRService srvRtCtlExtRService = ServiceFinder.find(ISrvRtCtlExtRService.class);
		SrvRtCtlDO[] srvRtCtlDos = srvRtCtlExtRService.findSrvRtCtlByEmpId(psnDocId);
		if (ArrayUtils.isEmpty(srvRtCtlDos)) {
			return null;
		}
		ArrayList<String> srvRtCtlNameList = new ArrayList<String>();
		for (SrvRtCtlDO srvRtCtlDO : srvRtCtlDos) {
			srvRtCtlNameList.add(srvRtCtlDO.getName());
		}
		return srvRtCtlNameList.toArray(new String[0]);
	}

}
