package iih.en.er.bp.pre;

import iih.en.comm.validator.EnValidator;
import iih.en.er.pre.d.EnErPreScoreDO;
import iih.en.er.pre.i.IEnerprescoredoRService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 *获取急诊预检评分
 * 
 *
 */
public class GetErPreScoreBP {
    /**
     * 获取急诊预检评分
     * 
     * @param erpreId
     * @param scotp
     * @return
     */
	public EnErPreScoreDO exec(String id_erpre,String scotp) throws BizException {
		IEnerprescoredoRService serv = ServiceFinder.find(IEnerprescoredoRService.class);
		 EnErPreScoreDO[] scoredos = serv.find(String.format(" ID_ERPRE = '%s' and sd_scotp = '%s' ",id_erpre, scotp), null, FBoolean.FALSE);
		 return EnValidator.isEmpty(scoredos) ? null : scoredos[0];
	}
}
