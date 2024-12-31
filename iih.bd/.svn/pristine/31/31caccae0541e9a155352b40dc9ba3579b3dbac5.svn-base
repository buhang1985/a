package iih.bd.srv.srvreact.s;

import java.util.HashMap;

import iih.bd.bc.udi.pub.IBdSrvDictCodeTypeConst;
import iih.bd.srv.srvreact.d.SrvReactItemDO;
import iih.bd.srv.srvreact.d.SrvreactAggDO;
import iih.bd.srv.srvreact.i.ISrvreactExtService;
import iih.bd.srv.srvreact.i.ISrvreactRService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.xbd.udi.d.UdidocDO;
import xap.sys.xbd.udi.i.IUdidocServiceExt;

/**
 * 服务互斥数据扩展服务
 * 
 * @author hao_wu
 *
 */
public class SrvreactExtServiceImpl implements ISrvreactExtService {

	@Override
	public SrvreactAggDO findById(String id) throws BizException {
		ISrvreactRService srvreactRService = ServiceFinder.find(ISrvreactRService.class);
		SrvreactAggDO result = srvreactRService.findById(id);

		SetSrvTpName(result);

		return result;
	}

	@Override
	public SrvReactItemDO[] changedItem(SrvReactItemDO[] rqChange) throws BizException {
		ISrvreactRService srvreactRService = ServiceFinder.find(ISrvreactRService.class);
		SetSrvTpName(rqChange);
		return rqChange;
	}
	/**
	 * 设置服务类型
	 * 
	 * @param result
	 * @throws BizException
	 */
	private void SetSrvTpName(SrvreactAggDO result) throws BizException {
		HashMap<String, UdidocDO> srvTpMap = GetSrvTpMap();
		SrvReactItemDO[] itemArray = result.getSrvReactItemDO();
		SetSrvTpName(itemArray, srvTpMap);
	}

	/**
	 * 设置服务类型
	 * 
	 * @param result
	 * @throws BizException
	 */
	private void SetSrvTpName(SrvReactItemDO[] result) throws BizException {
		HashMap<String, UdidocDO> srvTpMap = GetSrvTpMap();
		SrvReactItemDO[] itemArray = result;
		SetSrvTpName(itemArray, srvTpMap);
	}
	/**
	 * 设置服务类型
	 * 
	 * @param itemArray
	 * @param srvTpMap
	 * @throws BizException
	 */
	private void SetSrvTpName(SrvReactItemDO[] itemArray, HashMap<String, UdidocDO> srvTpMap) throws BizException {
		for (SrvReactItemDO srvReactItemDO : itemArray) {
			String idSrvTp = srvReactItemDO.getId_srvtp();
			UdidocDO udidocDO = srvTpMap.get(idSrvTp);
			if (udidocDO == null) {
				String msg = String.format("服务类型获取失败，服务类型id:\"%s\"。", idSrvTp);
				throw new BizException(msg);
			}
			srvReactItemDO.setName_srvtp(udidocDO.getName());
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

		HashMap<String, UdidocDO> map = new HashMap<String, UdidocDO>();
		for (UdidocDO udidocDO : result) {
			map.put(udidocDO.getId_udidoc(), udidocDO);
		}
		return map;
	}

}
