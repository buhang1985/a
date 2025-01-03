package iih.ci.ord.s.ems.op.ems.calcpri;

import iih.bd.pp.dto.d.PriStdSrvDTO;
import iih.bd.pp.primd.i.IPriCalService;
import iih.ci.ord.ciorder.d.OrSrvSourceFromEnum;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 个数定价模式费用项目查询代理
 * @author wangqingzhu
 *
 */
public class NumCalcPriModeProxy extends BaseCalcPriModeProxy {
	
	
	public NumCalcPriModeProxy(String id_srv, String name, int num) {
		super(id_srv, name, num);
		// TODO Auto-generated constructor stub
	}

	@Override
	public PriStdSrvDTO[] Calc() throws BizException {
		// TODO Auto-generated method stub
		return ServiceFinder.find(IPriCalService.class)
				.CalSrvSetFIXPrices(id_srv, num);
	}

	@Override
	public String toDesction() {
		// TODO Auto-generated method stub
		return String.format("获取服务【%s】个数定价模式费用项目", name);
	}
	@Override
	public int getEuSource() {
		// TODO Auto-generated method stub
		return OrSrvSourceFromEnum.AGENTFROMPRIMD;
	}
}
