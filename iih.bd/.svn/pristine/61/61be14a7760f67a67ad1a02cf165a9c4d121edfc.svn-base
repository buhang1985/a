package iih.bd.pp.bp.pri;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.base.utils.SqlUtils;
import iih.bd.srv.medsrv.d.MedSrvDO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 获取服务基本信息集合
 * 
 * @author yankan
 * @since 2017-08-21
 *
 */
public class GetSrvListBP {
	/**
	 * 获取服务基本信息集合
	 * 
	 * @param srvIds 服务ID集合
	 * @return
	 * @throws BizException
	 */
	public Map<String, MedSrvDO> exec(String[] srvIds) throws BizException {
		String whereStr = SqlUtils.getInSqlByIds(MedSrvDO.ID_SRV, srvIds);
		String[] fields = new String[] { MedSrvDO.ID_SRV, MedSrvDO.CODE, MedSrvDO.NAME, MedSrvDO.SD_PRIMD,
				MedSrvDO.SD_SRVTP,MedSrvDO.ID_UNIT_MED,MedSrvDO.QUAN_MED };
		List<MedSrvDO> srvList = (List<MedSrvDO>) new DAFacade().findByCond(MedSrvDO.class, whereStr, fields);
		if (ListUtil.isEmpty(srvList)) {
			return null;
		}
		Map<String, MedSrvDO> srvMap = new HashMap<String, MedSrvDO>();
		for (MedSrvDO srvDO : srvList) {
			srvMap.put(srvDO.getId_srv(), srvDO);
		}
		return srvMap;
	}
}
