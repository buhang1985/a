package iih.bd.pp.modifypriplan.s.bp;

import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.transaction.TransactionStatus;

import iih.bd.base.utils.AppUtils;
import iih.bd.pp.baseprisrv.s.bp.BasePriSrvEventHandler;
import iih.bd.pp.com.d.SrvOrCaEnum;
import iih.bd.pp.listener.d.MedSrvEventDTO;
import iih.bd.pp.modifypriplan.d.EuModifyPriMd;
import iih.bd.pp.modifypriplan.d.ModifyPriPlanDO;
import iih.bd.pp.modifypriplan.d.ModifyPriPlanItmDO;
import iih.bd.pp.modifypriplan.i.IModifyPriPlanItmDOCudService;
import iih.bd.pp.pripat.d.PriPatSrvOrCaDO;
import iih.bd.pp.pripat.d.PriRateMdEnum;
import iih.bd.pp.prisrv.d.PriSrvDO;
import iih.bd.utils.BdPpParamUtils;
import iih.bd.utils.FileUtils;
import iih.bd.utils.log.BdPpLogUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.BizRuntimeException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.jdbc.tx.TransactionExecutor;
import xap.mw.jdbc.tx.TransactionalOperation;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.jdbc.lock.PKLock;

/**
 * 根据调价计划进行调价业务逻辑
 * 
 * @author hao_wu
 *
 */
public class ModifyPriceByPlanIdBp {

	public void exec(String planId) throws BizException {
		if (StringUtils.isBlank(planId)) {
			throw new BizException("调价计划主键不允许为空。");
		}

		lockModifyPricePlan(planId);

		BdPpLogUtils.info("开始调价，调价计划主键：%s.", planId);
		long time1 = System.currentTimeMillis();

		StringBuilder errorMsgBuilder = new StringBuilder();

		try {
			// 设置调价计划调价标识
			BdPpParamUtils.setPlanModifyPriFlag(Boolean.TRUE);

			ModifyPriPlanItmDO[] items = findNoCompleteItmsByPlanId(planId);
			if (ArrayUtils.isNotEmpty(items)) {
				ModifyPriPlanDO planDo = findPlanById(planId);
				String modifyPriMd = planDo.getEu_modifyprimd();

				String errorMsg;
				if (EuModifyPriMd.STANPRIADJUST.equals(modifyPriMd)) {
					// 基础价表调价
					errorMsg = modifyBasePri(items, planDo);
				} else if (EuModifyPriMd.SPEPROPRIADJUST.equals(modifyPriMd)) {
					// 特殊价格调价
					errorMsg = modifySpecPri(items, planDo);
				} else {
					// 异常
					String msg = String.format("调价计划的调价类型错误,计划主键:%s,调价类型:%s.", planId, modifyPriMd);
					throw new BizException(msg);
				}
				if (StringUtils.isNotBlank(errorMsg)) {
					errorMsgBuilder.append(errorMsg);
					errorMsgBuilder.append(FileUtils.NewLine);
				}
			}

			updatePlanCompleteFlagById(planId);
		} catch (Exception e) {
			BdPpLogUtils.logEx(e);
			errorMsgBuilder.append(e.getMessage());
			errorMsgBuilder.append(FileUtils.NewLine);
		}

		long time2 = System.currentTimeMillis();
		BdPpLogUtils.info("调价耗时：%sms", time2 - time1);

		if (errorMsgBuilder.length() > 0) {
			BdPpLogUtils.info("调价失败，调价计划主键：%s,错误信息:%s.", planId, errorMsgBuilder.toString());
			throw new BizException(errorMsgBuilder.toString());
		}

		BdPpLogUtils.info("调价成功，调价计划主键：%s.", planId);
	}

	/**
	 * 锁定调价计划
	 * 
	 * @param planId
	 * @throws BizException
	 */
	private void lockModifyPricePlan(String planId) throws BizException {
		String lockKey = String.format("IIH_BD_SRV_MODIFYPRICE_%s", planId);
		Boolean fg_lock = PKLock.getInstance().addBatchDynamicLock(new String[] { lockKey }, 0);
		if (!fg_lock) {
			String msg = String.format("调价计划正在调价，不允许再次调价，计划主键：%s。", planId);
			BdPpLogUtils.info(msg);
			throw new BizException(msg);
		}
	}

	/**
	 * 根据主键查询调价计划
	 * 
	 * @param planId
	 * @return
	 * @throws BizException
	 */
	private ModifyPriPlanDO findPlanById(String planId) throws BizException {
		DAFacade daFacade = new DAFacade();
		ModifyPriPlanDO planDo = (ModifyPriPlanDO) daFacade.findByPK(ModifyPriPlanDO.class, planId);
		return planDo;
	}

	private String modifyBasePri(ModifyPriPlanItmDO[] items, final ModifyPriPlanDO planDo) {
		StringBuilder errorMsgBuilder = new StringBuilder();
		for (final ModifyPriPlanItmDO itmDo : items) {
			try {
				TransactionExecutor.executeNewTransaction(new TransactionalOperation<String>() {
					@Override
					public String doInTransaction(TransactionStatus arg0) {
						try {
							modifyBasePriInTrans(itmDo, planDo);
							return null;
						} catch (Exception e) {
							throw new BizRuntimeException(e.getMessage(), e);
						}
					}
				});
				fireIEMsg(itmDo.getId_srv());
			} catch (Exception e) {
				BdPpLogUtils.logEx(e);
				errorMsgBuilder.append(e.getMessage());
				errorMsgBuilder.append(FileUtils.NewLine);
			}
		}
		return errorMsgBuilder.toString();
	}

	/**
	 * 根据调价计划主键查询未完成的计划明细
	 * 
	 * @param planId
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private ModifyPriPlanItmDO[] findNoCompleteItmsByPlanId(String planId) throws BizException {
		String wherePart = "Id_modifypriplan = ? and Fg_modifysucc <> 'Y'";

		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(planId);

		DAFacade daFacade = new DAFacade();
		List<ModifyPriPlanItmDO> itmDoList = (List<ModifyPriPlanItmDO>) daFacade.findByCond(ModifyPriPlanItmDO.class,
				wherePart, sqlParam);
		return itmDoList.toArray(new ModifyPriPlanItmDO[0]);
	}

	/**
	 * 事务内调价
	 * 
	 * @param itmDo
	 * @throws BizException
	 */
	private void modifyBasePriInTrans(ModifyPriPlanItmDO itmDo, ModifyPriPlanDO planDo) throws BizException {
		// 国际特殊要求，价格生效时间等于计划时间
		FDateTime nowDateTime = planDo.getDt_modifypriplan();

		PriSrvDO newPriDo = createNewPrice(itmDo, nowDateTime, planDo.getDes());

		long time3 = System.currentTimeMillis();
		disableOldPriBySrvId(itmDo.getId_srv(), nowDateTime);
		long time4 = System.currentTimeMillis();
		BdPpLogUtils.info("停用旧价格耗时：%sms", time4 - time3);

		saveNewPri(newPriDo);
		long time5 = System.currentTimeMillis();
		BdPpLogUtils.info("保存新价格耗时：%sms", time5 - time4);

		updateItemCompleteFlagById(itmDo.getId_modifyprisrvplanitm());
		long time6 = System.currentTimeMillis();
		BdPpLogUtils.info("更新调价计划明细耗时：%sms", time6 - time5);

		updateItemOldPrice(itmDo.getId_modifyprisrvplanitm(),planDo.getId_pripat());
		long time7 = System.currentTimeMillis();
		BdPpLogUtils.info("更新调价计划前价格明细耗时：%sms", time7 - time6);
		
//		fireIEMsg(itmDo.getId_srv());
//		long time8 = System.currentTimeMillis();
//		BdPpLogUtils.info("发送集成平台消息耗时：%sms", time8 - time7);
	}

	/**
	 * 根据服务主键停用价格
	 * 
	 * @param id_srv
	 * @param nowDateTime
	 * @throws BizException
	 */
	private void disableOldPriBySrvId(String id_srv, FDateTime nowDateTime) throws BizException {
		String sql = "update bd_pri_srv set dt_e = ?, fg_active = 'N' where id_srv = ? and dt_e = ?";

		SqlParam sqlParam = new SqlParam();

		sqlParam.addParam(nowDateTime);
		sqlParam.addParam(id_srv);
		sqlParam.addParam(new FDateTime("2099-12-31 23:59:59"));

		DAFacade daFacade = new DAFacade();
		int updateRowCount = daFacade.execUpdate(sql, sqlParam);
		BdPpLogUtils.info("停用旧价格成功，服务主键：%s,停用时间:%s,更新条数%s.", id_srv, nowDateTime, updateRowCount);
	}

	/**
	 * 根据调价计划明细主键更新调价完成标识
	 * 
	 * @param id_planItm
	 * @throws BizException
	 */
	private void updateItemCompleteFlagById(String id_planItm) throws BizException {
		String sql = "update BD_MODIFY_PRI_PLAN_ITM set FG_MODIFYSUCC = 'Y' where ID_MODIFYPRISRVPLANITM = ?";

		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(id_planItm);

		DAFacade daFacade = new DAFacade();
		int updateRowCount = daFacade.execUpdate(sql, sqlParam);
		BdPpLogUtils.info("更新调价计划明细调价完成标识成功，调价计划明细主键：%s,更新条数%s.", id_planItm, updateRowCount);
	}

	/**
	 * 更新调价计划后原价格
	 * 
	 * @param id_planItm
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private void updateItemOldPrice(String id_planItm,String id_pripat) throws BizException {
	
		String wherePart = "ID_MODIFYPRISRVPLANITM = ?";

		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(id_planItm);

		DAFacade daFacade = new DAFacade();
		UpdatePriMaxAndNowPriceBp bp = new UpdatePriMaxAndNowPriceBp();
		
		
		List<ModifyPriPlanItmDO> itmDoList = (List<ModifyPriPlanItmDO>) daFacade.findByCond(ModifyPriPlanItmDO.class,wherePart, sqlParam);
		for (ModifyPriPlanItmDO modifyPriPlanItmDO : itmDoList) {
			bp.exec(new ModifyPriPlanItmDO[] { modifyPriPlanItmDO }, id_pripat);
			modifyPriPlanItmDO.setPrice_old(modifyPriPlanItmDO.getNow_price());
			modifyPriPlanItmDO.setStatus(DOStatus.UPDATED);
		}
		IModifyPriPlanItmDOCudService service = ServiceFinder.find(IModifyPriPlanItmDOCudService.class);
		service.save(itmDoList.toArray(new ModifyPriPlanItmDO[itmDoList.size()]));
	//	BdPpLogUtils.info("更新调价计划明细调价完成标识成功，调价计划明细主键：%s,更新条数%s.", id_planItm, updateRowCount);
	}
	/**
	 * 发送集成平台消息
	 * 
	 * @param modifyPriPlanAggs
	 * @throws BizException
	 */
	private void fireIEMsg(String srvId) throws BizException {
		BasePriSrvEventHandler eventHandler = new BasePriSrvEventHandler();
		eventHandler.fireEvent(srvId, IEventType.TYPE_UPDATE_AFTER);
		
//		MedSrvEventDTO medSrvEventDto = findMedSrvEventDTOById(srvId);
//		if (medSrvEventDto == null) {
//			BdPpLogUtils.info("发送集成平台消息,未查询到需要发送的数据,服务主键:%s.", srvId);
//			return;
//		}
//
//		BdPpEvent bdPpEvent = new BdPpEvent();
//		bdPpEvent.invokePriSrv(medSrvEventDto, IEventType.TYPE_UPDATE_AFTER);
	}

	/**
	 * 调整特殊价格
	 * 
	 * @param items
	 * @param planDo
	 */
	private String modifySpecPri(ModifyPriPlanItmDO[] items, final ModifyPriPlanDO planDo) {
		StringBuilder errorMsgBuilder = new StringBuilder();
		for (final ModifyPriPlanItmDO itmDo : items) {
			try {
				TransactionExecutor.executeNewTransaction(new TransactionalOperation<String>() {
					@Override
					public String doInTransaction(TransactionStatus arg0) {
						try {
							modifySpecPriInTrans(itmDo, planDo);
							return null;
						} catch (Exception e) {
							throw new BizRuntimeException(e.getMessage(), e);
						}
					}
				});
			} catch (Exception e) {
				BdPpLogUtils.logEx(e);
				errorMsgBuilder.append(e.getMessage());
				errorMsgBuilder.append(FileUtils.NewLine);
			}
		}
		return errorMsgBuilder.toString();
	}

	/**
	 * 事务内调整特殊价格
	 * 
	 * @param itmDo
	 * @param planDo
	 * @throws BizException
	 */
	protected void modifySpecPriInTrans(ModifyPriPlanItmDO itmDo, ModifyPriPlanDO planDo) throws BizException {
		// 国际特殊要求，价格生效时间等于计划时间
		FDateTime nowDateTime = planDo.getDt_modifypriplan();

		PriPatSrvOrCaDO newSpecPriDo = createNewSpecPrice(planDo, itmDo, nowDateTime);

		long time3 = System.currentTimeMillis();
		disableOldSpecPriBySrvId(planDo.getId_pripat(), itmDo.getId_srv(), nowDateTime);
		long time4 = System.currentTimeMillis();
		BdPpLogUtils.info("停用旧价格耗时：%sms", time4 - time3);

		saveNewSpecPri(newSpecPriDo);
		long time5 = System.currentTimeMillis();
		BdPpLogUtils.info("保存新价格耗时：%sms", time5 - time4);

		updateItemCompleteFlagById(itmDo.getId_modifyprisrvplanitm());
		long time6 = System.currentTimeMillis();
		BdPpLogUtils.info("更新调价计划明细耗时：%sms", time6 - time5);
		
		updateItemOldPrice(itmDo.getId_modifyprisrvplanitm(),planDo.getId_pripat());
		long time7 = System.currentTimeMillis();
		BdPpLogUtils.info("更新调价计划前价格明细耗时：%sms", time7 - time6);
	}

	/**
	 * 创建新的特殊价格
	 * 
	 * @param planDo
	 * @param itmDo
	 * @param nowDateTime
	 * @return
	 */
	private PriPatSrvOrCaDO createNewSpecPrice(ModifyPriPlanDO planDo, ModifyPriPlanItmDO itmDo,
			FDateTime nowDateTime) {
		PriPatSrvOrCaDO newPriDo = new PriPatSrvOrCaDO();
		newPriDo.setId_grp(Context.get().getGroupId());
		newPriDo.setId_org(Context.get().getOrgId());
		newPriDo.setId_pripat(planDo.getId_pripat());
		newPriDo.setEu_srvorca(SrvOrCaEnum.SRV);
		newPriDo.setEu_pi_priratemd(PriRateMdEnum.PRICEMODEL);
		newPriDo.setId_srv(itmDo.getId_srv());
		newPriDo.setPri(itmDo.getPrice());// 价格设为新的价格
		newPriDo.setDt_b(nowDateTime);
		newPriDo.setDt_e(new FDateTime("2099-12-31 23:59:59"));
		newPriDo.setStatus(DOStatus.NEW);
		newPriDo.setNote(planDo.getDes());
		return newPriDo;
	}

	/**
	 * 停用旧的特殊定价
	 * 
	 * @param id_pripat   患者价格分类
	 * @param id_srv      服务主键
	 * @param endDateTime 停用时间
	 * @throws BizException
	 */
	private void disableOldSpecPriBySrvId(String id_pripat, String id_srv, FDateTime endDateTime) throws BizException {
		String sql = "update bd_pri_pat_srvorca set dt_e = ? where id_pripat = ? and id_srv = ? and dt_e = ?";

		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(endDateTime);
		sqlParam.addParam(id_pripat);
		sqlParam.addParam(id_srv);
		sqlParam.addParam(new FDateTime("2099-12-31 23:59:59"));

		DAFacade daFacade = new DAFacade();
		int updateRowCount = daFacade.execUpdate(sql, sqlParam);
		BdPpLogUtils.info("停用旧特殊价格成功，价格分类主键:%s,服务主键：%s,停用时间:%s,更新条数%s.", id_pripat, id_srv, endDateTime,
				updateRowCount);
	}

	/**
	 * 保存新特殊价格
	 * 
	 * @param newSpecPriDo
	 * @throws BizException
	 */
	private void saveNewSpecPri(PriPatSrvOrCaDO newSpecPriDo) throws BizException {
		DAFacade daFacade = new DAFacade();
		String pk = daFacade.insertDO(newSpecPriDo);
		BdPpLogUtils.info("保存新特殊价格信息成功，特殊价格主键：%s。", pk);
	}

	/**
	 * 根据医疗服务主键集合查询医疗服务事件DTO
	 * 
	 * @param srvIds
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	private MedSrvEventDTO findMedSrvEventDTOById(String srvId) throws BizException {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT srv.id_srv,");
		sqlBuilder.append("srv.id_grp,");
		sqlBuilder.append("srv.id_org,");
		sqlBuilder.append("srv.NAME,");
		sqlBuilder.append("srv.code,");
		sqlBuilder.append("srv.id_srvtp,");
		sqlBuilder.append("srv.sd_srvtp,");
		sqlBuilder.append("srvca.code AS id_srvca,");
		sqlBuilder.append("srv.pycode,");
		sqlBuilder.append("srv.id_unit_med,");
		sqlBuilder.append("srv.quan_med,");
		sqlBuilder.append("srv.id_primd,");
		sqlBuilder.append("srv.sd_primd,");
		sqlBuilder.append("inccaip.id_inccaitm AS incca_ip,");
		sqlBuilder.append("inccaop.id_inccaitm AS incca_op,");
		sqlBuilder.append("pri.price AS pri,");
		sqlBuilder.append("srv.fg_active,");
		sqlBuilder.append("srv.fg_or,");
		sqlBuilder.append("srv.fg_mm,");
		sqlBuilder.append("srv.fg_bl ");
		sqlBuilder.append("FROM bd_srv srv ");
		sqlBuilder.append("INNER JOIN bd_pri_srv pri ");
		sqlBuilder.append("ON srv.id_srv = pri.id_srv ");
		sqlBuilder.append("INNER JOIN bd_srvca srvca ");
		sqlBuilder.append("ON srvca.id_srvca = srv.id_srvca ");
		sqlBuilder.append("INNER JOIN bd_incca_itm_rel inccaip ");
		sqlBuilder.append("ON inccaip.id_srv = srv.id_srv ");
		sqlBuilder.append("INNER JOIN bd_incca_itm_rel inccaop ");
		sqlBuilder.append("ON inccaop.id_srv = srv.id_srv ");
		sqlBuilder.append("WHERE pri.dt_e = '2099-12-31 23:59:59' ");
		sqlBuilder.append("AND inccaip.sd_incca = '12' ");
		sqlBuilder.append("AND inccaop.sd_incca = '11' ");
		sqlBuilder.append("AND srv.id_srv = ? ");

		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(srvId);

		DAFacade daFacade = new DAFacade();
		List<MedSrvEventDTO> dtoList = (List<MedSrvEventDTO>) daFacade.execQuery(sqlBuilder.toString(), sqlParam,
				new BeanListHandler(MedSrvEventDTO.class));
		if (dtoList == null || dtoList.size() <= 0) {
			return null;
		}

		return dtoList.get(0);
	}

	/**
	 * 更新调价计划完成标识信息
	 * 
	 * @param modifyPriPlanDO
	 * @throws BizException
	 */
	private void updatePlanCompleteFlagById(final String planId) throws BizException {
		int noCompleteItmCount = findNoCompleteItmCountByPlanId(planId);
		if (noCompleteItmCount > 0) {
			BdPpLogUtils.info("存在未完成的调价计划明细，更新调价计划完成标识失败，调价计划主键：%s,未完成的调价计划明细个数:%s。", planId, noCompleteItmCount);
			return;
		}

		TransactionExecutor.executeNewTransaction(new TransactionalOperation<String>() {
			@Override
			public String doInTransaction(TransactionStatus arg0) {
				try {
					String sql = "update bd_modify_pri_plan set Fg_complete = 'Y', Id_emp_opr = ?, Dt_complete = ? where Id_modifypriplan = ?";
					SqlParam sqlParam = new SqlParam();
					sqlParam.addParam(Context.get().getUserId());
					sqlParam.addParam(AppUtils.getServerDateTime());
					sqlParam.addParam(planId);

					DAFacade daFacade = new DAFacade();
					int updateRowNum = daFacade.execUpdate(sql, sqlParam);
					BdPpLogUtils.info("更新调价计划完成标识成功，调价计划主键：%s,更新行数:%s。", planId, updateRowNum);
					return null;
				} catch (Exception e) {
					throw new BizRuntimeException(e.getMessage(), e);
				}
			}
		});
	}

	/**
	 * 根据调价计划查询未完成的调价明细个数
	 * 
	 * @param planId 调价计划主键
	 * @return
	 * @throws BizException
	 */
	private int findNoCompleteItmCountByPlanId(String planId) throws BizException {
		String sql = "select count(1) from BD_MODIFY_PRI_PLAN_ITM where ID_MODIFYPRIPLAN = ? and FG_MODIFYSUCC <> 'Y'";

		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(planId);

		DAFacade daFacade = new DAFacade();
		int rowCount = (int) daFacade.execQuery(sql, sqlParam, new ColumnHandler());
		return rowCount;
	}

	/**
	 * 保存调整过的价格信息
	 * 
	 * @param array
	 * @throws BizException
	 */
	private void saveNewPri(PriSrvDO newPri) throws BizException {
		DAFacade daFacade = new DAFacade();
		String pk = daFacade.insertDO(newPri);
		BdPpLogUtils.info("保存新价格信息成功，价格主键：%s。", pk);
	}

	/**
	 * 创建新价格
	 * 
	 * @param id_srv
	 * @param newPrice
	 * @param modifyPriReason 调价原因
	 * @return
	 */
	private PriSrvDO createNewPrice(ModifyPriPlanItmDO itmDo, FDateTime nowDateTime, String modifyPriReason) {
		PriSrvDO newPri = new PriSrvDO();
		newPri.setId_grp(Context.get().getGroupId());
		newPri.setId_org(Context.get().getOrgId());
		newPri.setId_srv(itmDo.getId_srv());
		newPri.setPrice(itmDo.getPrice());// 价格设为新的价格
		newPri.setDt_b(nowDateTime);
		newPri.setDt_e(new FDateTime("2099-12-31 23:59:59"));
		newPri.setStatus(DOStatus.NEW);
		newPri.setFg_active(FBoolean.TRUE);
		newPri.setDes(modifyPriReason);
		return newPri;
	}
}
