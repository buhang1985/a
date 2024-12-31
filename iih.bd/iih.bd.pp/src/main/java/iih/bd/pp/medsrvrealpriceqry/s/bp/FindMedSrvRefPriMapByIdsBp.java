package iih.bd.pp.medsrvrealpriceqry.s.bp;


import iih.bd.pp.medsrvrealpriceqry.s.bp.sql.FindMedSrvRealPriMapByIdsSql;
import iih.bd.srv.oth.d.BizCntDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.core.utils.ArrayUtil;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 根据医疗服务主键集合查询医疗服务参考价字典
 * 
 * @author hao_wu 2019-5-27
 *
 */
public class FindMedSrvRefPriMapByIdsBp {

	public FMap exec(String[] medSrvIds) throws BizException {
		if (ArrayUtil.isEmptyNoNull(medSrvIds)){
			throw new BizException("未维护就诊卡收费项目，请联系管理员");	
		}
		FindMedSrvRealPriMapByIdsSql sql = new FindMedSrvRealPriMapByIdsSql(medSrvIds);
		DAFacade daFacade = new DAFacade();
		FMap refPriMap = (FMap) daFacade.execQuery(sql.getQrySQLStr(), sql.getQryParameter(null),
				new MedSrvRefPriMapHandler("ID_SRV", "PRICE_STD"));
		return refPriMap;
	}
}
