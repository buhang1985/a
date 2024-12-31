package iih.ci.ord.s.listener;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.utils.ParamUtils;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.i.ICiOrdCustomSysParamConst;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.skintest.d.CiSkinTestRstDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.appfw.businessevent.bd.BDCommonEvent;
import xap.sys.devcfg.alert.taskcenter.itf.ISchedulerServiceAPI;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanHandler;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 皮试结果监听
 * 
 * @author LiYue
 *
 */
public class SkinTestResultsOfListener implements IBusinessListener {

	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		// TODO Auto-generated method stub

		// 事件源及事件类型判断
		if (!(event.getSourceID().equals(IBizPlugInSourecIDConst.CISKINTESTRSTDO_FULLCLASSNAME)
				&& event.getEventType().equals(IEventType.TYPE_UPDATE_AFTER)))
			return;

		// 皮试结果改变的数据及空判断逻辑
		BDCommonEvent dbevent = (BDCommonEvent) event;
		Object[] newObjs = dbevent.getNewObjs();
		if (ArrayUtils.isEmpty(newObjs))
			return;
		FMap2 map = new FMap2();
		for (Object object : newObjs) {
			CiSkinTestRstDO ciSkinTestRstDO = (CiSkinTestRstDO) object;
			String id_or =getId_or(ciSkinTestRstDO.getId_skintest());// 皮试对应医嘱主键
			// 皮试结果为阴性，挂上定时签署任务
			if (StringUtils.isNotEmpty(id_or)&&StringUtils.isNotEmpty(ciSkinTestRstDO.getSd_rst_skintest())&&(ICiDictCodeConst.SD_RST_SKINTEST_L1_MINUS).equals(ciSkinTestRstDO.getSd_rst_skintest())) {
				map.put("idor", id_or);

				// 定时任务执行时间
				FDateTime afterDate = getDt();
				ISchedulerServiceAPI api = ServiceFinder.find(ISchedulerServiceAPI.class);
				api.submitTask0("SkinTest", afterDate, map);
			}
		}

	}

	/**
	 * 通过皮试对应医嘱主键 ID_OR
	 * 
	 * @param newObj
	 * @return
	 */
	private String getId_or(String id_skintest) {
		if (CiOrdUtils.isEmpty(id_skintest))
			return null;
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT srv.id_or FROM ci_or_srv srv LEFT JOIN ci_skin_test skin ON srv.ID_OR_REL = skin.id_or ");
		sql.append("  WHERE skin.id_skintest = ?");
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(id_skintest);
		String id_or = null;
		try {
			id_or = (String) new DAFacade().execQuery(sql.toString(), sqlParam, new ColumnHandler());
		} catch (DAException e) {

			throw new RuntimeException("获取皮试对应医嘱主键失败！");
		}
		return StringUtils.isEmpty(id_or) ? null : id_or;
	}

	/**
	 * 获取轻量级配置定时时间
	 */
	public FDateTime getDt() {
		try {
			/**
			 * 定时时间，单位是秒（s）,默认3分钟
			 */
			int dt = 180;
			dt = ParamUtils.GetOrgParamIntegerValue(ICiOrdCustomSysParamConst.LL_DT_SKINTEST);
			FDateTime nowDate = CiOrdAppUtils.getServerDateTime();
			return nowDate.addSeconds(dt);
		} catch (BizException e) {
			e.printStackTrace();
			return null;
		}
	}
}
