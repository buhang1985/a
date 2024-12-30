package iih.sc.apt.s.bp.oral;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.bd.res.dayslot.d.DaysLotDO;
import iih.bd.res.dayslot.i.IDayslotMDORService;
import iih.sc.comm.ScSqlUtils;
import iih.sc.scbd.s.bp.GetDeptParamsBP;
import iih.sc.scbd.scdeptparam.d.ScDeptParamDsDO;
import iih.sc.scbd.scdeptparam.d.ScdeptparamAggDO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.xbd.udi.d.UdidocDO;
import xap.sys.xbd.udi.i.IUdidocRService;

/**
 * 获取口腔科预约加载数据BP
 * 
 * @author zhengcm
 * @date 2016-09-29 15:01:02
 *
 */
public class GetOralAptLoadDataBP {

	/**
	 * 获取口腔科预约加载数据
	 *
	 * @param id_dept 科室id
	 * @param sd_sctp 排班类型编码
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	public FMap exec(String id_dept, String sd_sctp) throws BizException {
		FMap map = new FMap();
		// 获取自定义档案数据
		this.getLoadUdidocDatas(map);
		// 获取科室日期分组的最大加号数
		this.getDeptDayslotQuanAddLimit(id_dept, sd_sctp, map);
		return map;
	}

	/**
	 * 获取口腔科预约加载所需的自定义档案数据
	 *
	 * @param map
	 * @throws BizException
	 * @author zhengcm
	 */
	@SuppressWarnings("unchecked")
	private void getLoadUdidocDatas(FMap map) throws BizException {
		// 自定义档案查询服务
		IUdidocRService qryService = ServiceFinder.find(IUdidocRService.class);
		String where = String.format("id_udidoclist in ('%s','%s')",
				IScDictCodeConst.ID_UDIDOCLIST_APT_TAG, IScDictCodeConst.ID_UDIDOCLIST_TICK_REG);
		UdidocDO[] docDOs = qryService.find(where, "code", FBoolean.FALSE);
		if (ArrayUtil.isEmpty(docDOs)) {
			return;
		}
		for (UdidocDO docDO : docDOs) {
			String key = docDO.getId_udidoclist();
			if (map.containsKey(key)) {
				((List<UdidocDO>) map.get(key)).add(docDO);
			} else {
				List<UdidocDO> temp = new ArrayList<UdidocDO>();
				temp.add(docDO);
				map.put(key, temp);
			}
		}
	}

	/**
	 * 获取科室日期分组的最大加号数
	 *
	 * @param id_dept
	 * @param sd_sctp
	 * @param map
	 * @throws BizException
	 * @author zhengcm
	 */
	private void getDeptDayslotQuanAddLimit(String id_dept, String sd_sctp, FMap map)
			throws BizException {
		// 科室参数对外查询服务
		ScdeptparamAggDO[] paramList = new GetDeptParamsBP().exec(id_dept, sd_sctp);
		if (null == paramList) {
			return;
		}
		ScdeptparamAggDO aggDO = paramList[0];
		// 科室参数时长
		map.put("srvlot", aggDO.getParentDO().getSec_period());

		ScDeptParamDsDO[] dsDOs = (ScDeptParamDsDO[]) aggDO.getChildren(ScDeptParamDsDO.class);
		if (ArrayUtil.isEmpty(dsDOs)) {
			return;
		}
		Map<String, String> lotMap = new HashMap<String, String>();
		List<String> daysIds = new ArrayList<String>();
		for (ScDeptParamDsDO dsDO : dsDOs) {
			daysIds.add(dsDO.getId_dayslot());
		}
		String where = "id_dayslot in (" + ScSqlUtils.buildIdStr(daysIds) + ")";
		// 日期分组查询服务
		IDayslotMDORService qryService = ServiceFinder.find(IDayslotMDORService.class);
		DaysLotDO[] lotDOs = qryService.find(where, null, FBoolean.FALSE);
		for (DaysLotDO lotDO : lotDOs) {
			lotMap.put(lotDO.getId_dayslot(), lotDO.getCode());
		}
		for (ScDeptParamDsDO dsDO : dsDOs) {
			map.put(lotMap.get(dsDO.getId_dayslot()), dsDO.getQuan_addlimit());
		}
	}

}
