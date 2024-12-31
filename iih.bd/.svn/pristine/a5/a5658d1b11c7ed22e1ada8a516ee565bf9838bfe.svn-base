package iih.bd.pp.baseprisrv.s.bp;

import iih.bd.pp.baseprisrv.d.BaseprisrvAggDO;
import iih.bd.pp.baseprisrv.d.PriSrvDO;
import iih.bd.pp.baseprisrv.d.SrvPriDO;
import xap.mw.core.data.BizException;

/**
 * 根据服务主键查询基础价格服务
 * 
 * @author hao_wu 2019-8-20
 *
 */
public class FindBasePriSrvAggByIdBp {

	public BaseprisrvAggDO exec(String srvId) throws BizException {

		BaseprisrvAggDO basePriSrvAggDo = new BaseprisrvAggDO();

		String wherePart = String.format("bd_srv.id_srv = '%s'", srvId);
		FindPriSrvBp bp = new FindPriSrvBp();
		PriSrvDO[] srvDos = bp.exec(wherePart, "");
		if (srvDos.length == 1) {
			basePriSrvAggDo.setParentDO(srvDos[0]);
		}

		wherePart = String.format("id_srv = '%s'", srvId);
		FindBaseSrvPriBp findPriBp = new FindBaseSrvPriBp();
		SrvPriDO[] priDos = findPriBp.exec(wherePart, null);
		basePriSrvAggDo.setSrvPriDO(priDos);

		return basePriSrvAggDo;
	}

}
