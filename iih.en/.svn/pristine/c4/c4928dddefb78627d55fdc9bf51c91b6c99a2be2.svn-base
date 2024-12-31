package iih.en.pv.s.bp.ippre.qry;

import iih.en.pv.dto.d.IppreQryDTO;
import iih.en.pv.inpatient.dto.d.EnIppreInfoDTO;

import java.util.Set;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;

/**
 * 查询预住院患者列表信息
 * 
 */
public class GetIpprePatientsBP {
	// 准备中心
	private final static String PRECENTERPATS = "PRECENTERPATS";
	// 入科患者
	private final static String PREENDEPPATS = "PREENDEPPATS";
	// 入院登记患者
	private final static String PREREGISTPATS = "PREREGISTPATS";
	// 中止住院患者
	private final static String PRESUSPENDPATS = "PRESUSPENDPATS";
	// 出院患者
	private final static String PRELVHOSPATS = "PRELVHOSPATS";
	
	/**
	 * 查询预住院患者列表信息
	 * 
	 * @param map
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<EnIppreInfoDTO>  exec(FMap qryMap,PaginationInfo pageInfo) throws BizException {

		PagingRtnData<EnIppreInfoDTO> page = new PagingRtnData<EnIppreInfoDTO>();
		Set<String> keySet = qryMap.keySet();
		for (String key : keySet) {
			IppreQryDTO entQryDto = (IppreQryDTO) qryMap.get(key);
			if(null == entQryDto ){
				return null;
			}
			switch (key) {
			case PRECENTERPATS:// 准备中心
				page = new GetIppreConterPageListBP().exec(entQryDto,pageInfo);
				break;
			case PREENDEPPATS:// 入科患者
				page = new GetEnDepBP().exec(entQryDto.getId_dep(),pageInfo);
				break;
			case PREREGISTPATS:// 入院登记患者
				page = new GetIpPrePatListBP().exec(entQryDto.getId_dep(),pageInfo);
				break;
			case PRESUSPENDPATS:// 中止入院患者
				page = new GetSuspendHosPatListBP().exec(entQryDto.getId_dep(),pageInfo);
				break;
			case PRELVHOSPATS:// 出院患者
				page = new GetIpLvHosBP().exec(entQryDto.getId_dep(),pageInfo);
				break;
		}
	}
		return page;
	}	
}
