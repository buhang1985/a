package iih.bd.pp.bdbltpl.s.bp;

import org.apache.commons.lang.ArrayUtils;

import iih.bd.pp.bdbltpl.d.BdBltplItmDO;
import iih.bd.pp.bdbltpl.d.BdbltplAggDO;
import iih.bd.pp.bdbltpl.i.IBdbltplRService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 根据主键查询自定义费用模板AggDo
 * 
 * @author hao_wu 2019-5-27
 *
 */
public class FindBltplAggDoByIdBp {

	public BdbltplAggDO exec(String tplId) throws BizException {
		IBdbltplRService service = ServiceFinder.find(IBdbltplRService.class);
		BdbltplAggDO bltplAggDo = service.findById(tplId);

		BdBltplItmDO[] itmDos = bltplAggDo.getBdBltplItmDO();
		if (ArrayUtils.isNotEmpty(itmDos)) {
			UpdateBlTplItmsBp bp = new UpdateBlTplItmsBp();
			bp.exec(itmDos);
		}
		return bltplAggDo;
	}
}
