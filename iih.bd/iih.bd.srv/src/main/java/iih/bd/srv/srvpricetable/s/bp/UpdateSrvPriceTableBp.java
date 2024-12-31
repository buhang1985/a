package iih.bd.srv.srvpricetable.s.bp;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.StopWatch;

import com.alibaba.fastjson.JSON;

import iih.bd.srv.srvpricetable.i.IBdSrvPriceTableUpdateService;
import iih.bd.srv.srvpricetable.s.bp.a_bd_srv_pripat_cross.RefreshBdSrvPriPatCrossBp;
import iih.bd.utils.log.BdSrvPriceTableUpdateLogUtils;
import xap.mw.core.data.BizException;

/**
 * 
 * 
 * @author hao_wu
 * @date 2020年4月23日
 *
 */
public class UpdateSrvPriceTableBp {

	public void exec(String condType, String[] condValues) throws BizException {

		BdSrvPriceTableUpdateLogUtils.info("开始更新服务价格表,condType:%s,condValues:%s。", condType,
				JSON.toJSONString(condValues));
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();

		try {
			if (StringUtils.isBlank(condType)) {
				throw new BizException("条件类型不允许为空。");
			}
			if (!IBdSrvPriceTableUpdateService.SrvPriceUpdateCondType_ReBuild.equals(condType)
					&& org.apache.commons.lang.ArrayUtils.isEmpty(condValues)) {
				throw new BizException("条件值不允许为空。");
			}

			RefreshBdSrvPriPatCrossBp bp = new RefreshBdSrvPriPatCrossBp();
			bp.exec(condType, condValues);
		} catch (Exception e) {
			stopWatch.split();
			BdSrvPriceTableUpdateLogUtils.logExAndTitle(e, "更新服务价格表异常,condType:%s,condValues:%s,耗时:%sms。", condType,
					JSON.toJSONString(condValues), stopWatch.getSplitTime());
			throw e;
		}

		stopWatch.stop();
		BdSrvPriceTableUpdateLogUtils.info("更新服务价格表完成,condType:%s,condValues:%s,耗时:%sms。", condType,
				JSON.toJSONString(condValues), stopWatch.toString());
	}
}
