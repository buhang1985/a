package iih.sc.sch.s.bp;

import iih.sc.sch.reg.dto.d.RegResDTO;
import iih.sc.sch.reg.dto.d.ResQrySchemeDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;

/**
 * 根据科室id查询资源
 * @author yank
 *
 */
public class GetResByDepBP {
	/**
	 * 根据科室id查询资源
	 * @param depId 科室id
	 * @return
	 * @throws BizException
	 */
	public RegResDTO[] exec(String depId) throws BizException{
		ResQrySchemeDTO qryScheme = new ResQrySchemeDTO();
		FArrayList depIdList = new FArrayList();
		depIdList.add(depId);
		qryScheme.setIds_dep(depIdList);
		qryScheme.setFg_quan(FBoolean.TRUE);//加载号源
		GetResBySchmBP getBP = new GetResBySchmBP();
		return getBP.exec(qryScheme);
	}
}
