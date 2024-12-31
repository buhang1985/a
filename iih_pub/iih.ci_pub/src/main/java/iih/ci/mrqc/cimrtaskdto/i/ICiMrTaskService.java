package iih.ci.mrqc.cimrtaskdto.i;

import iih.ci.mrqc.cimrtaskdto.d.CiMrTaskDTO;
import xap.mw.core.data.BizException;

public interface ICiMrTaskService {
	
	/**
	 * 病历任务查询
	 * @param sqlWhere
	 * @return
	 * @throws BizException
	 */
	public abstract CiMrTaskDTO[] getCiMrTaskDTOResult(String sqlWhere) throws BizException;
	
}
