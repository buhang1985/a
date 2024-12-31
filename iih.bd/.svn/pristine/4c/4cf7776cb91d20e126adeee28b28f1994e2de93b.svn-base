package iih.bd.srv.srvrtctl.s.bp;

import java.util.ArrayList;
import java.util.HashMap;

import iih.bd.srv.srvrtctl.d.SrvRtCtlDO;
import iih.bd.srv.srvrtempref.d.SrvRtEmpRefDO;
import iih.bd.srv.srvrtempref.i.ISrvrtemprefCudService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.bdfw.bbd.i.IPsndocMDORService;

/**
 * 服务开立权限注册业务逻辑
 * 
 * @author hao_wu
 *
 */
public class SrvRtCtlAuthorizeBp {

	public void exec(SrvRtCtlDO srvRtCtlDo, String[] psnIdArr) throws BizException {
		if (srvRtCtlDo == null) {
			throw new BizException("服务开立权限信息为空。");
		}
		if (psnIdArr == null || psnIdArr.length <= 0) {
			throw new BizException("授权人员信息为空。");
		}

		authorize(srvRtCtlDo, psnIdArr);
	}

	/**
	 * 授权
	 * 
	 * @param srvRtCtlDo
	 * @param psnIdArr
	 * @throws BizException
	 */
	private void authorize(SrvRtCtlDO srvRtCtlDo, String[] psnIdArr) throws BizException {
		SrvRtEmpRefDO[] srvRtEmpRefArr = getSrvRtEmpRefArray(srvRtCtlDo, psnIdArr);
		insertSrvRtEmpRef(srvRtEmpRefArr);
	}

	/**
	 * 获取服务开立权限与医生关系数据列表
	 * 
	 * @param srvRtCtlDo
	 * @param psnIdArr
	 * @return
	 * @throws BizException
	 */
	private SrvRtEmpRefDO[] getSrvRtEmpRefArray(SrvRtCtlDO srvRtCtlDo, String[] psnIdArr) throws BizException {
		HashMap<String, PsnDocDO> psnMap = getPsnDocMap(psnIdArr);
		ArrayList<SrvRtEmpRefDO> srvRtEmpRefList = new ArrayList<SrvRtEmpRefDO>();
		for (String psnId : psnIdArr) {
			if (!psnMap.containsKey(psnId)) {
				String msg = String.format("人员信息获取失败，人员id：%s。", psnId);
				throw new BizException(msg);
			}
			PsnDocDO psnDocDO = psnMap.get(psnId);
			SrvRtEmpRefDO newSrvRtEmpRef = getSrvRtEmpRef(srvRtCtlDo, psnDocDO);
			srvRtEmpRefList.add(newSrvRtEmpRef);
		}
		return srvRtEmpRefList.toArray(new SrvRtEmpRefDO[srvRtEmpRefList.size()]);
	}

	/**
	 * 
	 * 创建服务开立权限与医生关系
	 * 
	 * @param srvRtCtlDo
	 * @param psnDocDO
	 * @return
	 */
	private SrvRtEmpRefDO getSrvRtEmpRef(SrvRtCtlDO srvRtCtlDo, PsnDocDO psnDocDO) {
		SrvRtEmpRefDO srvRtEmpRefDO = new SrvRtEmpRefDO();
		srvRtEmpRefDO.setId_grp(Context.get().getGroupId());
		srvRtEmpRefDO.setId_org(Context.get().getOrgId());
		srvRtEmpRefDO.setId_srvrt(srvRtCtlDo.getId_srvrt());

		srvRtEmpRefDO.setId_emp_phy(psnDocDO.getId_psndoc());
		srvRtEmpRefDO.setId_emptitle(psnDocDO.getId_emptitle());
		srvRtEmpRefDO.setSd_emptitle(psnDocDO.getSd_emptitle());
		srvRtEmpRefDO.setId_humantype(psnDocDO.getHumantype());
		srvRtEmpRefDO.setSd_humantype(psnDocDO.getSd_humantype());
		srvRtEmpRefDO.setCode(psnDocDO.getCode());

		return srvRtEmpRefDO;
	}

	/**
	 * 获取授权人员信息列表
	 * 
	 * @param psnIdArr
	 * @return
	 * @throws BizException
	 */
	private HashMap<String, PsnDocDO> getPsnDocMap(String[] psnIdArr) throws BizException {
		IPsndocMDORService psndocMDORService = ServiceFinder.find(IPsndocMDORService.class);
		PsnDocDO[] result = psndocMDORService.findByIds(psnIdArr, new FBoolean(false));
		if (result == null) {
			throw new BizException("人员信息获取失败，返回值为空。");
		}
		return getPsnDocMap(result);
	}

	/**
	 * 获取授权人员信息Hash字典
	 * 
	 * @param psnArr
	 * @return
	 * @throws BizException
	 */
	private HashMap<String, PsnDocDO> getPsnDocMap(PsnDocDO[] psnArr) throws BizException {
		HashMap<String, PsnDocDO> hashMap = new HashMap<String, PsnDocDO>();
		for (PsnDocDO psnDocDO : psnArr) {
			hashMap.put(psnDocDO.getId_psndoc(), psnDocDO);
		}
		return hashMap;
	}

	/**
	 * 插入授权信息
	 * 
	 * @param srvRtEmpRefArr
	 * @throws BizException
	 */
	private void insertSrvRtEmpRef(SrvRtEmpRefDO[] srvRtEmpRefArr) throws BizException {
		ISrvrtemprefCudService service = ServiceFinder.find(ISrvrtemprefCudService.class);
		service.insert(srvRtEmpRefArr);
	}

}
