package iih.pe.pwf.i;

import iih.pe.pitm.pesrvbcatlog.d.PeSrvbCatlogItmDO;
import iih.pe.pwf.dto.perstdto.d.PeRstDTO;
import xap.mw.core.data.BizException;

public interface IPeRstDTOQueryService {
	public PeRstDTO[] findById(String id_pepsnappt, String id_pedeptset) throws BizException;
	//体检异常结果
	public PeRstDTO[] findAbnById(String id_pepsnappt) throws BizException;
	//体检结果导出
	public PeRstDTO[] findByCondition(PeSrvbCatlogItmDO[] peSrvbCatlogItmDo, String inputAge, String dt_begin, String dt_end,
			String sex_name, String marriage, String filterpetp, String questionnaire) throws BizException;
}
