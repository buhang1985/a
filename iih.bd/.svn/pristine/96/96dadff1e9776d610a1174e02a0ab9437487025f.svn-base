package iih.bd.pp.s;

import iih.bd.pp.i.IBdPpMantainService;
import iih.bd.pp.s.samppri.bp.SaveSamppriBp;
import iih.bd.pp.s.samppricnst.bp.SaveSamppricnstBP;
import iih.bd.pp.samppri.d.BdSampPriItmDO;
import iih.bd.pp.samppri.d.SampPriDO;
import iih.bd.pp.samppricnstdto.d.SampPricnstDTO;
import xap.mw.core.data.BizException;

public class BdPpMantainServiceImpl implements IBdPpMantainService {

	@Override
	public void saveSamppri(SampPriDO sampPriDO, BdSampPriItmDO bdSampPriItmDO) throws BizException {
		SaveSamppriBp bp = new SaveSamppriBp();
		bp.exec(sampPriDO, bdSampPriItmDO);
	}

	/**
	 * 儿童标本费用对照保存
	 */
	@Override
	public void saveSamppricnst(SampPricnstDTO[] inParams) throws BizException {
		SaveSamppricnstBP bp  = new SaveSamppricnstBP();
		bp.exec(inParams);
	}
}
