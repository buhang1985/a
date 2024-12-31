package iih.bl.cg.s.bp.ip;

import iih.bd.base.validator.ParamValidator;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bl.cg.s.bp.ip.backcg.ChargeBedNewBP;
import iih.bl.cg.s.bp.ip.backcg.ChargeDcgBP;
import iih.bl.cg.s.bp.ip.backcg.ChargeNurseNewBP;
import iih.bl.cg.s.bp.ip.backcg.ChargePrnOrderBP;
import iih.bl.cg.s.bp.ip.backcg.ICharge;
import iih.bl.cg.s.bp.ip.backcg.IpBackChargeBP;
import iih.ci.ord.i.external.provide.ICiOrdBlService;
import iih.ci.ord.i.meta.OrderRstDTO;

import java.util.LinkedList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 预出院记账
 * 
 * @author yankan
 * @since 2017-11-03
 *
 */
public class OutDeptChargeBP {
	/**
	 * 执行出院记费
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

		//处理持续医嘱状态
		this.handlePrnOrd(patId);
		
		// 2、计费
		List<ICharge> chargeBPList = new LinkedList<ICharge>();
		chargeBPList.add(new ChargeBedNewBP(true));// 床位费
		chargeBPList.add(new ChargeNurseNewBP(true));// 护理费
		chargeBPList.add(new ChargePrnOrderBP(true));// 持续医嘱费
		chargeBPList.add(new ChargeDcgBP(true));// 固定收费包
		IpBackChargeBP ipChargeBP = new IpBackChargeBP(chargeBPList);
		ipChargeBP.exec(patId, cgEndTime, true);
	}

	/**
	 * 执行出院记费(就诊id)
	 * @param entId 就诊id
	 * @param cgEndTime 计费时间
	 * @throws BizException
	 */
	public void exec2(String entId, FDateTime cgEndTime) throws BizException {
		
		// 参数校验
		ParamValidator.validateNotNull("就诊ID", entId);
		
		// 1、校验持续医嘱是否停掉
		this.validatePrnOrd(null, entId, cgEndTime);
		
		// 处理持续医嘱状态
		this.handlePrnOrd2(entId);
		
		// 2、计费
		List<ICharge> chargeBPList = new LinkedList<ICharge>();
		chargeBPList.add(new ChargeBedNewBP(true));// 床位费
		chargeBPList.add(new ChargeNurseNewBP(true));// 护理费
		chargeBPList.add(new ChargePrnOrderBP(true));// 持续医嘱费
		chargeBPList.add(new ChargeDcgBP(true));// 固定收费包
		IpBackChargeBP ipChargeBP = new IpBackChargeBP(chargeBPList);
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
	private void handlePrnOrd(String patId) throws BizException {
		
		// 查询有效住院就诊id
		DAFacade daf = new DAFacade();
		String sql = "select id_ent from en_ent where id_pat = ? and code_entp = '10' and fg_canc = 'N' and fg_st = 'N' ";
		SqlParam param = new SqlParam();
		param.addParam(patId);

		String entId = (String) daf.execQuery(sql, param, new ColumnHandler());
		if (StringUtil.isEmpty(entId))
			return;

		ICiOrdBlService blService = ServiceFinder.find(ICiOrdBlService.class);
		OrderRstDTO rstDto = blService.outerHosKillAlwaysOrders(new String[] { entId });
		if (!FBoolean.TRUE.equals(rstDto.getIsSuccess())) {
			throw new BizException(rstDto.getMessageInfo());
		}
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
