package iih.bd.srv.srvrtctl.s.bp;

import java.util.HashMap;

import iih.bd.bc.udi.pub.IBdSrvDictCodeTypeConst;
import iih.bd.srv.srvrtctl.d.SrvRtItmDO;
import iih.bd.srv.srvrtctl.d.SrvrtctlAggDO;
import org.apache.commons.lang.StringUtils;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.xbd.udi.d.UdidocDO;
import xap.sys.xbd.udi.i.IUdidocServiceExt;

/**
 * 更新服务类型业务逻辑
 * 
 * @author hao_wu
 *
 */
public class SrvrtctlUpdateSrvTpBp {

	public void exec(SrvrtctlAggDO srvrtctlAggDO) throws BizException {
		if (srvrtctlAggDO == null) {
			return;
		}

		SrvRtItmDO[] srvRtItems = srvrtctlAggDO.getSrvRtItmDO();
		updateSrvTp(srvRtItems);
	}

	/**
	 * 更新子表服务类型
	 * 
	 * @param srvRtItems
	 * @throws BizException
	 */
	private void updateSrvTp(SrvRtItmDO[] srvRtItems) throws BizException {
		if (srvRtItems == null) {
			return;
		}

		HashMap<String, UdidocDO> srvTpDic = GetSrvTpMap();

		for (SrvRtItmDO srvRtItmDO : srvRtItems) {
			if (srvRtItmDO == null || StringUtils.isEmpty(srvRtItmDO.getId_srvtp())) {
				continue;
			}
			String srvTpId = srvRtItmDO.getId_srvtp();
			UdidocDO srvTp = srvTpDic.get(srvTpId);
			if (srvTp == null) {
				String msg = String.format("服务类型获取失败，服务类型主键：%s。", srvTpId);
				throw new BizException(msg);
			}
			srvRtItmDO.setName_srvtp(srvTp.getName());
		}
	}

	/**
	 * 获取服务类型字典
	 * 
	 * @return
	 * @throws BizException
	 */
	private HashMap<String, UdidocDO> GetSrvTpMap() throws BizException {
		IUdidocServiceExt udidocServiceExt = ServiceFinder.find(IUdidocServiceExt.class);
		UdidocDO[] result = udidocServiceExt.findByUdidoclistCode(IBdSrvDictCodeTypeConst.SD_SRVTP);
		if (result == null) {
			throw new BizException("服务类型列表获取失败。");
		}

		HashMap<String, UdidocDO> dic = new HashMap<String, UdidocDO>();
		for (UdidocDO udidocDO : result) {
			dic.put(udidocDO.getId_udidoc(), udidocDO);
		}
		return dic;
	}
}
