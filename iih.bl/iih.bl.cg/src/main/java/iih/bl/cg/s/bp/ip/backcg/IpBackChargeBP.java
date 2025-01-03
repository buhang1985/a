package iih.bl.cg.s.bp.ip.backcg;

import iih.bd.base.utils.AppUtils;
import iih.bd.base.utils.DateTimeUtils;
import iih.bd.base.validator.ParamValidator;
import iih.bd.pp.i.IBdPpQryService;
import iih.bd.pp.pripat.d.PripatAggDO;
import iih.bl.cg.bldcevent.d.BlDcEventDO;
import iih.bl.cg.bldcevent.i.IBldceventCudService;
import iih.bl.cg.dto.d.IpCgPatDTO;
import iih.bl.comm.log.BLTaskLogger;
import iih.bl.params.BlParams;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.transaction.TransactionStatus;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.jdbc.tx.TransactionExecutor;
import xap.mw.jdbc.tx.TransactionalOperation;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 住院后台记账
 * 
 * @author yankan
 * @since 2017-09-18
 * @version ly 2018/09/05 重构
 * 
 */
public class IpBackChargeBP {
	private Map<String, PripatAggDO> pripatAggMap;//患者价格分类
	private List<ICharge> chargeBPList = null;//计费集合
	private boolean bbBedCost = false;//婴儿是否需要收取床位费
	private boolean bbFixedCost = false;//婴儿是否需要收取固定费用包
	
	
	/**
	 * 默认构造函数
	 */
	public IpBackChargeBP() {}

	/**
	 * 构造函数
	 * 
	 * @param needNewTrans 是否单起事务
	 * @param allowPartialSuccess 是否允许部分成功
	 * @param chargeBPList 计费集合
	 */
	public IpBackChargeBP(List<ICharge> chargeBPList) {
		this.chargeBPList = chargeBPList;
	}
	
	/**
	 * 住院后台记账
	 * 
	 * @param patId 患者ID
	 * @param cgEndTime 记账截止日清
	 * @throws BizException
	 */
	public void exec(String patId, FDateTime cgEndTime,boolean outDept) throws BizException {
		ParamValidator.validateNotNull("记账时间", cgEndTime);
		BLTaskLogger.info(String.format("本次计价开始：%s", AppUtils.getServerDateTime()));
		FDateTime cgBeginTime = DateTimeUtils.getDayBeginTime(cgEndTime.getDateTimeBefore(1));// 记账开始时间，当日00:00:00
		this.writeCgStartLog(cgBeginTime, cgEndTime);// 记录日志

		//获取参数
		this.bbBedCost = BlParams.BLCG0009().booleanValue();
		this.bbFixedCost = BlParams.BLCG0010().booleanValue();
		
		// 1、获取待记账患者信息
		List<IpCgPatDTO> patList = new GetNeedCgPatListBP().exec(cgEndTime, patId, null);
		if (ListUtil.isEmpty(patList)) {
			return;
		}		

		// 2、统一获取所有患者价格分类,用于计算服务的优惠价格
		this.pripatAggMap = this.getAllPripat();

		// 3、初始化记账序列
		if(ListUtil.isEmpty(this.chargeBPList)){
			this.chargeBPList = this.getDefaultChargeList();
		}

		// 4、记账
		for (IpCgPatDTO patInfo : patList) {
			this.chargeNewTrans(patInfo, cgEndTime, outDept);
		}

		// 5、记录记账事件记录
		FDateTime endTime = AppUtils.getServerDateTime();
		this.saveDcEvent(cgBeginTime, endTime, cgEndTime, patList.size());
		BLTaskLogger.info(String.format("共对 %s个病人进行计价",patList.size()));
		BLTaskLogger.info(String.format("计价结束时间:%s", endTime));
	}
	
	/**
	 * 住院后台记账(就诊id)
	 * @param entId
	 * @param cgEndTime
	 * @param outDept
	 * @throws BizException
	 */
	public void exec2(String entId, FDateTime cgEndTime, boolean outDept) throws BizException {
		ParamValidator.validateNotNull("记账时间", cgEndTime);
		BLTaskLogger.info(String.format("本次计价开始：%s", AppUtils.getServerDateTime()));
		FDateTime cgBeginTime = DateTimeUtils.getDayBeginTime(cgEndTime.getDateTimeBefore(1));// 记账开始时间，当日00:00:00
		this.writeCgStartLog(cgBeginTime, cgEndTime);// 记录日志

		//获取参数
		this.bbBedCost = BlParams.BLCG0009().booleanValue();
		this.bbFixedCost = BlParams.BLCG0010().booleanValue();
		
		// 1、获取待记账患者信息
		List<IpCgPatDTO> patList = new GetNeedCgPatListBP().exec(cgEndTime, null, entId);
		if (ListUtil.isEmpty(patList)) {
			return;
		}		

		// 2、统一获取所有患者价格分类,用于计算服务的优惠价格
		this.pripatAggMap = this.getAllPripat();

		// 3、初始化记账序列
		if(ListUtil.isEmpty(this.chargeBPList)){
			this.chargeBPList = this.getDefaultChargeList();
		}

		// 4、记账
		for (IpCgPatDTO patInfo : patList) {
			this.chargeNoTrans(patInfo, cgEndTime, outDept);
		}

		// 5、记录记账事件记录
		FDateTime endTime = AppUtils.getServerDateTime();
		this.saveDcEvent(cgBeginTime, endTime, cgEndTime, patList.size());
		BLTaskLogger.info(String.format("共对 %s个病人进行计价",patList.size()));
		BLTaskLogger.info(String.format("计价结束时间:%s", endTime));
	}
	
	/**
	 * 单个患者记账
	 * 后台任务的场合，独立事务
	 * @param patInfo
	 * @param cgEndTime
	 * @throws BizException
	 */
	private void chargeNewTrans(IpCgPatDTO patInfo,FDateTime cgEndTime, boolean outDept) throws BizException{
		
		final IpCgPatDTO patInfoF = patInfo;
		final FDateTime cgEndTimeF = cgEndTime;
		final boolean outDeptF = outDept;
		
		final PripatAggDO priPatAgg = this.pripatAggMap.get(patInfo.getId_pripat());// 患者价格分类
		if(priPatAgg==null){
			BLTaskLogger.error(String.format("患者：%s,患者价格分类为空", patInfo.getName_pat()));
			return;
		}
		// 1、记录患者记账日志
		this.writePatLog(patInfo, cgEndTime);
		
		try {
			TransactionExecutor.executeNewTransaction(new TransactionalOperation<String>() {
			@Override
			public String doInTransaction(TransactionStatus status){
				try {
					
					boolean todayOut = outDeptF && DateTimeUtils.isSameDay(patInfoF.getDt_acpt(), cgEndTimeF);
					for (ICharge chargeBP : chargeBPList) {
						//新生儿收费参数控制
						if(FBoolean.TRUE.equals(patInfoF.getFg_bb())){
							if(chargeBP instanceof ChargeBedNewBP && !bbBedCost)
								continue;
							if(chargeBP instanceof ChargeDcgBP && !bbFixedCost)
								continue;
						}
						
						if(todayOut){
							chargeBP.execTodayOut(patInfoF, priPatAgg, cgEndTimeF);
						}else{
							chargeBP.exec(patInfoF, priPatAgg, cgEndTimeF);
						}
					}
					Object trunDept =  Context.get().getAttribute("BlTurnDept");
					if(trunDept == null){
						// 3、更新就诊账户最后记账时间
						updateEnAccCgTime(patInfoF.getId_entacc(), cgEndTimeF);
					}
				} catch (BizException e) {
					BLTaskLogger.error(e.getMessage(),e);
					throw new RuntimeException(e.getMessage());
				}
				return null;
			}
		});
		} catch (Exception e) {
		}
	}
	
	/**
	 * 单个患者记账
	 * 出院转科的场合，新事务依赖父事务
	 * @param patInfo
	 * @param cgEndTime
	 * @throws BizException
	 */
	private void chargeNoTrans(IpCgPatDTO patInfo,FDateTime cgEndTime, boolean outDept) throws BizException{
		
		PripatAggDO priPatAgg = this.pripatAggMap.get(patInfo.getId_pripat());// 患者价格分类
		if (priPatAgg == null) {
			BLTaskLogger.error(String.format("患者：%s,患者价格分类为空",
					patInfo.getName_pat()));
			return;
		}
		// 1、记录患者记账日志
		this.writePatLog(patInfo, cgEndTime);

		boolean todayOut = outDept
				&& DateTimeUtils.isSameDay(patInfo.getDt_acpt(), cgEndTime);
		for (ICharge chargeBP : chargeBPList) {
			// 新生儿收费参数控制
			if (FBoolean.TRUE.equals(patInfo.getFg_bb())) {
				if (chargeBP instanceof ChargeBedNewBP && !bbBedCost)
					continue;
				if (chargeBP instanceof ChargeDcgBP && !bbFixedCost)
					continue;
			}

			if (todayOut) {
				chargeBP.execTodayOut(patInfo, priPatAgg, cgEndTime);
			} else {
				chargeBP.exec(patInfo, priPatAgg, cgEndTime);
			}
		}
		Object trunDept = Context.get().getAttribute("BlTurnDept");
		if (trunDept == null) {
			// 3、更新就诊账户最后记账时间
			updateEnAccCgTime(patInfo.getId_entacc(), cgEndTime);
		}
	}
	
	/**
	 * 记录记账时间日志
	 * 
	 * @param beginTime
	 * @param endTime
	 */
	private void writeCgStartLog(FDateTime beginTime, FDateTime endTime) {
		BLTaskLogger.info("开始时间:" + beginTime.toLocalString());
		BLTaskLogger.info("本次计价截止时间:" + DateTimeUtils.getDayBeginTime(endTime).toLocalString());
	}

	/**
	 * 记录患者日志
	 * 
	 * @param patInfo 患者信息
	 * @param cgEndTime 记账时间
	 */
	private void writePatLog(IpCgPatDTO patInfo, FDateTime cgEndTime) {
		// 记录患者日志
		StringBuilder logBuilder = new StringBuilder();
		logBuilder.append("**病人=").append(patInfo.getCode_pat());
		logBuilder.append(" 就诊=").append(patInfo.getTimes_ip());
		logBuilder.append(" 上次计价时间=" + patInfo.getDt_backcg());
		logBuilder.append(" 本次计价时间=" + cgEndTime.toLocalString());
		BLTaskLogger.info(logBuilder.toString());
	}

	/**
	 * 获取所有的患者价格分类
	 * 
	 * @return
	 * @throws BizException
	 */
	private Map<String, PripatAggDO> getAllPripat() throws BizException {
		IBdPpQryService ppQryService = ServiceFinder.find(IBdPpQryService.class);
		return ppQryService.getAllPripat();
	}

	/**
	 * 更新就诊账户最后记账时间
	 * 
	 * @param entAccId
	 * @param cgEndTime
	 * @throws BizException
	 */
	private void updateEnAccCgTime(String entAccId, FDateTime cgEndTime) throws BizException {
		// TODO:TCY 需要更新最后一次划价操作时间 2017-10-11
		String sql = "UPDATE EN_ENT_ACC SET DT_BACKCG=?,dt_backcglastact=to_char(sysdate,'yyyy-mm-dd hh24:mi:ss') WHERE ID_ENTACC=?";
		SqlParam param = new SqlParam();
		param.addParam(cgEndTime);
		param.addParam(entAccId);

		new DAFacade().execUpdate(sql, param);
	}

	/**
	 * 记录后台记账事件
	 * 
	 * @param beginTime 开始时间
	 * @param endTime 结束时间
	 * @param cgEndTime 本次记账时间
	 * @param patCn 患者总数
	 * @throws BizException
	 */
	private void saveDcEvent(FDateTime beginTime, FDateTime endTime, FDateTime cgEndTime, Integer patCn)
			throws BizException {
		// 获取上次记账时间
		FDateTime preBillTime = this.getLastBillTime();
		BlDcEventDO dcEvent = new BlDcEventDO();
		dcEvent.setDt_b(beginTime);
		dcEvent.setDt_e(endTime);
		dcEvent.setDt_e_prevbill(preBillTime);// 上次记账时间
		dcEvent.setDt_e_bill(cgEndTime);
		dcEvent.setPatcn(patCn);// 患者个数
		dcEvent.setStatus(DOStatus.NEW);
		IBldceventCudService dcEventCudService = ServiceFinder.find(IBldceventCudService.class);
		dcEventCudService.save(new BlDcEventDO[] { dcEvent });
	}

	/**
	 * 获取上一次记账时间
	 * 
	 * @return
	 * @throws BizException
	 */
	private FDateTime getLastBillTime() throws BizException {
		FDateTime preBillTime = null;
		String sql = "SELECT DT_E_BILL FROM BL_DC_EVENT WHERE ROWNUM<2 ORDER BY DT_E_BILL DESC";
		String preBillTimeStr = (String) new DAFacade().execQuery(sql, new ColumnHandler());
		if (!StringUtil.isEmpty(preBillTimeStr)) {
			preBillTime = new FDateTime(preBillTimeStr);
		}
		return preBillTime;
	}
	/**
	 * 获取默认计费集合
	 * @return
	 */
	private List<ICharge> getDefaultChargeList(){
		LinkedList<ICharge> chargeBPList = new LinkedList<ICharge>();
		chargeBPList.add(new ChargeBedNewBP(false));// 床位费
		chargeBPList.add(new ChargeNurseNewBP(false));// 护理费
		chargeBPList.add(new ChargePrnOrderBP());// 持续医嘱费
		chargeBPList.add(new ChargeDcgBP());// 固定费
		return chargeBPList;
	}
}
