package iih.sc.sch.s.task.bp.overduetick;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.bd.res.dayslot.d.DaysLotDO;
import iih.sc.comm.ScAppUtils;
import iih.sc.comm.ScLogUtil;
import iih.sc.comm.SchPkLockUtil;
import iih.sc.scbd.s.bp.dayslot.GetDaysLotDOBP;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.transaction.TransactionStatus;
import xap.mw.core.data.BizException;
import xap.mw.core.data.BizRuntimeException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.jdbc.tx.TransactionExecutor;
import xap.mw.jdbc.tx.TransactionalOperation;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 处理门诊过期排班号源
 * 
 * @author liubin
 *
 */
public class HandleOpOverdueTickTaskBP {
	private static final String Key_Id_Org = "id_org";
	private static final String Key_Id_Grp = "id_grp";
	/**
	 * 执行任务
	 * 
	 * @param map
	 * @throws BizException
	 */
	public void exec(Map<String, Object> map) throws BizException {
		//参数校验
		validate(map);
		//设置上下文
		setContext(map);
		//获取需要过期处理的排班
		List<String> schIdList = getNeedOverdueSch();
		//如果有跨天午别需要获取前一天跨天的排班数据
		List<String> timeCrossChkSch = new ArrayList<String>();
		FDateTime now = ScAppUtils.getServerDateTime();//当前时间
		FDate d_today = now.getBeginDate();//当前日期
		
		// 1、获取当前午别
		GetDaysLotDOBP bp = new GetDaysLotDOBP();
		DaysLotDO[] dayslots = bp.exec(IScDictCodeConst.SD_SCTP_OP);
		if(ArrayUtil.isEmpty(dayslots)) return;
		DaysLotDO crossDaysLot = null;
		boolean isContainCross = false;
		for (DaysLotDO daysLotDO : dayslots) {
			if(daysLotDO.getTime_begin().compareTo(daysLotDO.getTime_end()) > 0){
				crossDaysLot = daysLotDO;
				isContainCross = true;
			}
		}
		if(isContainCross){
			timeCrossChkSch = this.getTimeChkSch(null,now,d_today,true,crossDaysLot.getId_dayslot());
		}
		String[] schIds = ListUtil.isEmpty(schIdList) ? null : schIdList.toArray(new String[0]);
		if(ArrayUtil.isEmpty(schIds))
			return;
		for(String schId : schIds){
			//重启事务处理
			executeNewTrans(schId,false,crossDaysLot!=null?crossDaysLot.getId_dayslot():null);
		}
		// 跨天排班处理
		for (String schId : timeCrossChkSch) {
			//重启事务处理
			executeNewTrans(schId,true,crossDaysLot!=null?crossDaysLot.getId_dayslot():null);
		}
	}
	/**
	 * 参数校验
	 * 
	 * @param map
	 * @throws BizException
	 */
	private void validate(Map<String, Object> map) throws BizException {
		if(map == null)
			throw new BizException("参数不能为空！");
		if(!map.containsKey(Key_Id_Grp) || map.get(Key_Id_Grp) == null)
			throw new BizException("参数id_grp不能为空！");
		if(!map.containsKey(Key_Id_Org) || map.get(Key_Id_Org) == null)
			throw new BizException("参数id_org不能为空！");
	}
	/**
	 * 设置上下文
	 * 
	 * @param map
	 * @throws BizException
	 */
	private void setContext(Map<String, Object> map)throws BizException {
		Context.get().setGroupId((String) map.get(Key_Id_Grp));
		Context.get().setOrgId((String) map.get(Key_Id_Org));
	}
	/**
	 * 获取需要过期处理的排班
	 * 
	 * @return
	 * @throws BizException
	 */
	private List<String> getNeedOverdueSch() throws BizException {
		FDateTime now = ScAppUtils.getServerDateTime();
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append(" SELECT SCH.ID_SCH ");
		sqlBuilder.append(" FROM SC_SCH SCH ");
		sqlBuilder.append(" INNER JOIN SC_PL SCPL ON SCH.ID_SCPL = SCPL.ID_SCPL ");
		sqlBuilder.append(" WHERE SCPL.FG_ACTIVE = 'Y' ");
		sqlBuilder.append(" AND SCPL.FG_TIMECHK = 'Y' ");
		sqlBuilder.append(" AND SCH.FG_ACTIVE = 'Y' ");
		sqlBuilder.append(" AND SCH.D_SCH = ? ");
		sqlBuilder.append(" AND EXISTS ( ");
		sqlBuilder.append(" SELECT 1 FROM SC_TICK TICK ");
		sqlBuilder.append(" WHERE TICK.ID_SCH = SCH.ID_SCH ");
		sqlBuilder.append(" AND TICK.EU_USED = '0' ");
		sqlBuilder.append(" AND TICK.EU_USESCOPE = '1' ");
		sqlBuilder.append(" AND TICK.FG_ACTIVE = 'Y' ");
		sqlBuilder.append(" AND TICK.T_E <= ? ");
		sqlBuilder.append(" ) ");
		SqlParam param = new SqlParam();
		param.addParam(now.getBeginDate());
		param.addParam(now.getUFTime());
		List<String> list = (List<String>) new DAFacade().execQuery(sqlBuilder.toString(), param, new ColumnListHandler());
		return ListUtil.isEmpty(list) ? new ArrayList<String>() : list;
	}
	/**
	 * 重启事务处理
	 * 
	 * @param schId
	 * @throws BizException
	 */
	private void executeNewTrans(final String schId,final boolean isCrossDay,final String dayslotId) throws BizException {
		try {
			TransactionExecutor.executeNewTransaction(new TransactionalOperation<String>() {
						@Override
						public String doInTransaction(TransactionStatus paramTransactionStatus) {
							boolean isLock = false;
							try {
								isLock = SchPkLockUtil.acquireLock(schId);
								if (!isLock)
									throw new BizException(String.format("该排班正被他人修改，请稍后重试！[%s]", schId));
								new HandleOpOverdueTickBP().exec(schId,isCrossDay,dayslotId);
							} catch (BizException e) {
								throw new BizRuntimeException(e.getMessage(), e);
							} finally {
								if (isLock) {
									SchPkLockUtil.releaseLock(schId);
								}
							}
							return null;
						}

					});
		} catch (Exception e) {
			ScLogUtil.getInstance().logEx(e);
		}
	}
	
	
	/**
	 * 获取当前需要设置过期的排班id
	 * @return
	 * @throws DAException 
	 */
	@SuppressWarnings("unchecked")
	public List<String> getTimeChkSch(String id_dayslot,FDateTime now,FDate d_today,boolean isContainCross,String id_crossdayslot) throws DAException{
		DAFacade dafacade = new DAFacade();
		StringBuilder sql = new StringBuilder();
		SqlParam param = new SqlParam();
		sql.append(" select distinct sch.id_sch from sc_sch sch");
		sql.append(" inner join sc_pl pl on pl.id_scpl  = sch.id_scpl ");
		//sql.append(" inner join sc_tick tk on tk.id_sch = sch.id_sch");
		sql.append(" where sch.d_sch = ?");
		if(isContainCross){
			param.addParam(d_today.getDateBefore(1));
		}else{
			param.addParam(d_today);
		}
		sql.append(" and id_dayslot = ?");
		if(isContainCross){
			param.addParam(id_crossdayslot);
		}else{
			param.addParam(id_dayslot);
		}
		sql.append(" and pl.fg_timechk = 'Y' and pl.fg_active = 'Y'");
		sql.append(" and EXISTS(");
		sql.append(" SELECT 1 FROM SC_TICK tk ");
		sql.append(" WHERE tk.ID_SCH = SCH.ID_SCH ");
		sql.append(" AND tk.EU_USED = '0' ");
		sql.append(" AND tk.EU_USESCOPE = '1' ");
		sql.append(" AND tk.FG_ACTIVE = 'Y' ");
		if(!isContainCross){
			sql.append(" and tk.t_e <= ?");
			param.addParam(now.getUFTime());
		}
		sql.append(" ) ");
		List<String> scSchDOList = (List<String>)dafacade.execQuery(sql.toString(), param, new ColumnListHandler());
		return scSchDOList;
	}
}
