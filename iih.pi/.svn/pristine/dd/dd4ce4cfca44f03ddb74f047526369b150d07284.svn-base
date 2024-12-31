package iih.pi.reg.s.task;

import iih.pi.reg.pat.d.PatiAggDO;
import iih.pi.reg.s.bp.PiInfoSendEmpiBP;
import iih.pi.reg.s.bp.listener.PiPatEventListener;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FTime;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.appfw.businessevent.bd.BDCommonEvent;
import xap.sys.devcfg.alert.PreAlertObject;
import xap.sys.devcfg.alert.taskcenter.BgWorkingContext;
import xap.sys.devcfg.alert.taskcenter.IBackgroundWorkPlugin;

/***
 * 给empi发送建档之前的所有信息任务
 * 
 * @author houll
 *
 */
public class PiInfoSendEmpiTask implements IBackgroundWorkPlugin {

	@Override
	public PreAlertObject executeTask(BgWorkingContext arg0) throws BizException {

		// 1、构建返回值
		PreAlertObject rlt = new PreAlertObject();

		// 2、设置上下文
		initContext(arg0);

		// 3、获取患者建档时间区间
		FDateTime dt_date = new FDateTime(getDate(arg0), new FTime(" 23:59:59 "));
		
		// 4、查询并发送患者信息
		getSendPatInfo(dt_date);

		return rlt;
	}

	/**
	 * 初始化上 下文信息
	 * 
	 * @param args
	 */
	private boolean initContext(BgWorkingContext args) {
		if (args.getKeyMap() == null || args.getKeyMap().size() < 1)
			return false;
		if (!args.getKeyMap().containsKey("id_org") || args.getKeyMap().get("id_org") == null)
			return false;
		if (!args.getKeyMap().containsKey("id_grp") || args.getKeyMap().get("id_grp") == null)
			return false;
		Context.get().setOrgId(args.getKeyMap().get("id_org").toString());
		Context.get().setGroupId(args.getKeyMap().get("id_grp").toString());
		return true;
	}

	/**
	 * 获取建档日期参数
	 * 
	 * @param args
	 * @return
	 */
	private FDate getDate(BgWorkingContext args) {
		if (args.getKeyMap() == null || args.getKeyMap().size() < 1)
			return null;
		if (!args.getKeyMap().containsKey("date") || args.getKeyMap().get("date") == null)
			return null;
		FDate rtn = new FDate();
		rtn = new FDate(args.getKeyMap().get("date").toString());
		return rtn;
	}

	/**
	 * 获取指定建档日期的患者信息
	 * 
	 * @param dt_dates
	 * @return
	 * @throws BizException
	 */
	private void getSendPatInfo(FDateTime dt_date) throws BizException {
		PiInfoSendEmpiBP bp = new PiInfoSendEmpiBP();
		// 数据总条数
		int count = bp.getCount(dt_date);
		// 每页查询多少条
		int pageSize = 100;
		// 页数
		int size = count/pageSize + 1;
		
		for(int i=0 ; i< size; i++){
			//
			int min = i * pageSize;
			int max = (i + 1) * pageSize;
			
			//分页获取患者信息
			PatiAggDO[] aggs = bp.exec(min, max,dt_date);
			
			// 发送患者信息
			sendPatInfo(aggs);
		}

	}

	/**
	 * 发送患者信息
	 * 
	 * @param pats
	 * @throws BizException
	 */
	private void sendPatInfo(PatiAggDO[] pats) throws BizException {
		if (pats == null || pats.length < 1)
			return;

		PiPatEventListener PiPatEventListener = new PiPatEventListener();
		for (int i = 0; i < pats.length; i++) {
			PatiAggDO newPatAgg = pats[i];
			PatiAggDO oldPatAgg = pats[i];

			BDCommonEvent bdcEvent = new BDCommonEvent(PatiAggDO.class.getName(), IEventType.TYPE_INSERT_AFTER, pats);
			PiPatEventListener.invokeIEEvent(newPatAgg, oldPatAgg, bdcEvent);

			bdcEvent = new BDCommonEvent(PatiAggDO.class.getName(), IEventType.TYPE_UPDATE_AFTER, pats);
			PiPatEventListener.invokeIEEvent(newPatAgg, oldPatAgg, bdcEvent);
		}
	}

}
