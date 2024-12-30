package iih.sc.sch.s.bp;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.comm.IScMsgConst;
import iih.sc.comm.ScValidator;
import iih.sc.sch.s.ep.SchEP;
import iih.sc.sch.s.ep.TickEP;
import iih.sc.sch.s.ep.TicksEP;
import iih.sc.sch.scsch.d.ScSchDO;
import iih.sc.sch.scsch.i.IScschMDORService;
import iih.sc.sch.sctick.d.ScSchTickDO;
import iih.sc.scp.scplan.d.ScPlanDO;
import iih.sc.scp.scplan.i.IScplanRService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 根据排班和服务占用票号
 * 
 * @author yank
 *
 */
public class OccupyTickBySchAndSrvBP {
	/**
	 * 占用排班号位最小号,如果没有可用资源抛异常
	 * 
	 * @param schId 排班id
	 * @param polcn 号源池编号，0-9，默认为0
	 * @param ticks 号段id
	 * @param srvId 服务id
	 * @return 号位
	 * @throws BizException 异常
	 */
	public ScSchTickDO exec(String schId, Integer polcn, String ticksId, String srvId) throws BizException {
		// 校验参数
		this.validateParam(schId, polcn, ticksId);

		// 获取票号模式
		String tickMd = this.getTickMode(schId);

		String sql = "select * from sc_sch where id_sch = ? for update";
		SqlParam param = new SqlParam();
		param.addParam(schId);
		new DAFacade().execQuery(sql, param, new BeanListHandler(ScSchDO.class));

		// 1、占用号位和号段
		TickEP tickBP = new TickEP();
		ScSchTickDO tickDO = null;
		if (IScDictCodeConst.SD_TICKMD_TICKS.equals(tickMd)) {
			if (!StringUtil.isEmpty(ticksId)) {
				tickDO = tickBP.occupyByTicksAndSrv(ticksId, polcn, srvId);// 根据号段占用号位
			} else {
				tickDO = tickBP.occpuyBySchAndSrv(schId, polcn, srvId);// 根据排班号位
			}
			// 占用号段
			TicksEP ticksBP = new TicksEP();
			ticksBP.occupy(tickDO.getId_ticks());
		} else {
			tickDO = tickBP.occpuyBySchAndSrv(schId, polcn, srvId);// 号位
		}

		// 2、占用排班号源
		SchEP schBP = new SchEP();
		schBP.occupyTick(schId, polcn);

		return tickDO;
	}

	/**
	 * 校验参数
	 * 
	 * @param schId
	 * @param polcn
	 * @param ticksId
	 * @throws BizException
	 */
	private void validateParam(String schId, Integer polcn, String ticksId) throws BizException {
		// 参数校验
		ScValidator.validateParam("schId", schId);
		if (polcn == null || polcn < 0 || polcn > 10) {
			throw new BizException(IScMsgConst.ERROR_SC_SCH_POLCN_OUT_OF_RANGE);
		}
	}

	/**
	 * 获取票号模式 TODO 后续从sch中获取
	 * 
	 * @param schId
	 * @return
	 * @throws BizException
	 */
	private String getTickMode(String schId) throws BizException {
		IScschMDORService schRService = ServiceFinder.find(IScschMDORService.class);
		ScSchDO schDO = schRService.findById(schId);
		if (schDO == null) {
			throw new BizException(IScMsgConst.ERROR_SC_SCH_NOT_EXISTS);
		}
		if (!FBoolean.TRUE.equals(schDO.getFg_active())) {
			throw new BizException(IScMsgConst.SC_SCH_CLOSE);// 停诊不能挂号
		}
		if (StringUtil.isEmpty(schDO.getSd_tickmd())) {
			// TODO 最新排班会冗余 票号模式 现在这样也兼容老排班 后续可移除判断
			IScplanRService planService = ServiceFinder.find(IScplanRService.class);
			ScPlanDO planDO = planService.findById(schDO.getId_scpl());
			if (planDO == null) {
				throw new BizException(IScMsgConst.ERROR_SCH_SCHS_PLAN_NOT_EXISTS);
			}
			return planDO.getSd_tickmd();
		} else {
			return schDO.getSd_tickmd();
		}
	}
}
