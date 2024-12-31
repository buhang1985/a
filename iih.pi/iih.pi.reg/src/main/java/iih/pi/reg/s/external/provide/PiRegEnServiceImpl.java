package iih.pi.reg.s.external.provide;

import iih.pi.reg.i.external.provide.IPiRegEnService;
import iih.pi.reg.s.external.provide.bp.FindMomIdByNameAndIdNum4RegChildBp;
import xap.mw.core.data.BizException;

/**
 * 患者提供给就诊服务
 * 
 * @author hao_wu 2018-8-5
 *
 */
public class PiRegEnServiceImpl implements IPiRegEnService {

	@Override
	public String findMomIdByNameAndIdNum4RegChild(String patName, String idTpCode, String idNum) throws BizException {
		FindMomIdByNameAndIdNum4RegChildBp bp = new FindMomIdByNameAndIdNum4RegChildBp();
		String patId = bp.exec(patName, idTpCode, idNum);
		return patId;
	}
}
