package iih.bl.cc.service.i;

import iih.bl.cc.dto.d.BlccDRdetailDTO;
import xap.mw.core.data.BizException;

//TODO delete 
@Deprecated
public interface IBlccDailyReportService {
	public abstract BlccDRdetailDTO[] findDetail(String begin,String end) throws BizException;
	public abstract String getSysTime() throws BizException;
}
