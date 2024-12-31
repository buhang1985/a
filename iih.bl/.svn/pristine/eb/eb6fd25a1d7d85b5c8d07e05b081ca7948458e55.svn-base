package iih.bl.cg.s.bp.ip;

import iih.bd.base.validator.ParamValidator;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bl.cg.dto.d.IpCgPatDTO;
import iih.bl.cg.s.bp.ip.backcg.ChargeBedNewBP;
import iih.bl.cg.s.bp.ip.backcg.ChargeDcgBP;
import iih.bl.cg.s.bp.ip.backcg.ChargeNurseNewBP;
import iih.bl.cg.s.bp.ip.backcg.ChargePrnOrderBP;
import iih.bl.cg.s.bp.ip.backcg.GetNeedCgPatListBP;
import iih.bl.cg.s.bp.ip.backcg.ICharge;
import iih.bl.cg.s.bp.ip.backcg.IpBackChargeBP;
import iih.ci.ord.i.external.provide.ICiOrdBlService;
import iih.ci.ord.i.meta.OrderRstDTO;

import java.util.LinkedList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class BlTurnDeptChargeBP {
	
	/**
	 * 执行转科记费
	 * 
	 * @param patId 患者ID
	 * @param cgEndTime 计费时间
	 * @throws BizException
	 */
	public void exec(String patId, FDateTime cgEndTime) throws BizException {
		// 参数校验
		ParamValidator.validateNotNull("患者ID", patId);

		// 1、校验持续医嘱是否停掉
		this.validatePrnOrd(patId, null, cgEndTime);

		// 2、获取待记账患者信息
		List<IpCgPatDTO> patList = new GetNeedCgPatListBP().exec(cgEndTime, patId, null);
		if (ListUtil.isEmpty(patList)) {
			return;
		}
		
		// 2、计费
		List<ICharge> chargeBPList = new LinkedList<ICharge>();
		chargeBPList.add(new ChargePrnOrderBP(true));// 持续医嘱费
		IpBackChargeBP ipChargeBP = new IpBackChargeBP(chargeBPList);
		
		Context.get().setAttribute("BlTurnDept", true);
		ipChargeBP.exec(patId, cgEndTime, false);
	}
	
	/**
	 * 执行转科记费
	 * @param entId 
	 * @param cgEndTime
	 * @throws BizException
	 */
	public void exec2(String entId, FDateTime cgEndTime) throws BizException{
		
		// 参数校验
		ParamValidator.validateNotNull("就诊ID", entId);
		
		// 1、校验持续医嘱是否停掉
		this.validatePrnOrd(null, entId, cgEndTime);
		
		// 处理持续医嘱状态
		this.handlePrnOrd2(entId);
		
		// 2、计费
		List<ICharge> chargeBPList = new LinkedList<ICharge>();
		chargeBPList.add(new ChargePrnOrderBP(true));// 持续医嘱费
		IpBackChargeBP ipChargeBP = new IpBackChargeBP(chargeBPList);
		
		Context.get().setAttribute("BlTurnDept", true);
		ipChargeBP.exec2(entId, cgEndTime, true);
	}
	
	/**
	 * 校验持续医嘱是否停掉
	 * 
	 * @param patId
	 * @throws BizException
	 */
	private void validatePrnOrd(String patId, String entId, FDateTime cgEndTime) throws BizException {
		Integer count = this.getUnstopPrnOrd(patId, entId, cgEndTime);
		if (count > 0) {
			throw new BizException("存在未停止的持续医嘱，请先停止后再进行出院计费操作！");
		}
	}
	
	/**
	 * 获取未停止的持续医嘱数量
	 * 
	 * @param patId
	 * @param cgEndTime
	 * @return
	 * @throws BizException
	 */
	private Integer getUnstopPrnOrd(String patId, String entId, FDateTime cgEndTime) throws BizException {
		StringBuilder sqlBuilder = new StringBuilder();
		SqlParam param = new SqlParam();
		
		sqlBuilder.append("SELECT  COUNT(ORD.ID_OR)");
		sqlBuilder.append(" FROM CI_ORDER ORD");
		sqlBuilder.append(" INNER JOIN BD_FREQ FREQ ON FREQ.ID_FREQ = ORD.ID_FREQ");
		sqlBuilder.append(" WHERE 1=1 ");
		
		if(!StringUtil.isEmpty(patId)){
			sqlBuilder.append(" AND ORD.ID_PAT=?");
			param.addParam(patId);
		}
		
		if(!StringUtil.isEmpty(entId)){
			sqlBuilder.append(" AND ORD.ID_EN=?");
			param.addParam(entId);
		}
		
		sqlBuilder.append(" AND ORD.CODE_ENTP=?");
		sqlBuilder.append(" AND FREQ.ID_FREQUNITCT=?");
		sqlBuilder.append(" AND ORD.FG_STOP = 'N' ");
		sqlBuilder.append(" AND ORD.FG_CANC= 'N' ");
		param.addParam(IBdFcDictCodeConst.SD_CODE_ENTP_IP);
		param.addParam(IBdSrvDictCodeConst.ID_FREQNUNITCT_ALWAYS);// 持续

		Integer count = (Integer) new DAFacade().execQuery(sqlBuilder.toString(), param, new ColumnHandler());
		return count;
	}
	
	/**
	 * 处理持续医嘱状态
	 * @param patId
	 * @throws BizException
	 */
	private void handlePrnOrd2(String entId) throws BizException {
		
		ICiOrdBlService blService = ServiceFinder.find(ICiOrdBlService.class);
		OrderRstDTO rstDto = blService.outerHosKillAlwaysOrders(new String[] { entId });
		if (!FBoolean.TRUE.equals(rstDto.getIsSuccess())) {
			throw new BizException(rstDto.getMessageInfo());
		}
	}
}
