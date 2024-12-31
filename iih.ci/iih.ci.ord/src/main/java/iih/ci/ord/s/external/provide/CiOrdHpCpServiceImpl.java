package iih.ci.ord.s.external.provide;

import java.util.List;
import java.util.Map;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.ci.ord.dto.ordsrvchangeddto.d.OrdSrvChangedInfoDTO;
import iih.ci.ord.i.external.common.ICIOrdRService;
import iih.ci.ord.i.external.provide.ICiOrdHpCpService;
import iih.ci.ord.s.bp.ordsrvchangedval.OrdChangedSrvValidateBP;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 临床提供给临床路径的对外接口
 * @author HUMS
 *
 */
public class CiOrdHpCpServiceImpl implements ICiOrdHpCpService {

	/**
	 * 根据就诊号获取医嘱最大排序号
	 */
	@Override
	public Integer getOrdMaxSortno(String id_en) throws BizException {
		
		ICIOrdRService ciOrdRService = (ICIOrdRService)ServiceFinder.find(ICIOrdRService.class);
		return ciOrdRService.getOrdMaxSortno(id_en);
	}
	
	@Override
	public Map<String, String> validateHpcpEleAvailableBP(List<OrdSrvChangedInfoDTO> ordSrvInfos) throws BizException {
		OrdChangedSrvValidateBP bp = new OrdChangedSrvValidateBP();
		return bp.exec(IBdFcDictCodeConst.SD_CODE_ENTP_IP, ordSrvInfos);
	}

}
