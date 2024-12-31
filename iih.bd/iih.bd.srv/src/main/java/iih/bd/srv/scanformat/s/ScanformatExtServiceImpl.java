package iih.bd.srv.scanformat.s;
import iih.bd.srv.scanformat.i.IScanformatExtService;
import iih.bd.srv.scanformat.s.bp.GetScanFormatMaxSortNoBp;
import xap.mw.core.data.BizException;

/**
 * 扫描格式扩展服务
 */

public class ScanformatExtServiceImpl implements IScanformatExtService {

	@Override
	public int getMaxNo() throws BizException {
		GetScanFormatMaxSortNoBp bp = new GetScanFormatMaxSortNoBp();
		return bp.exec();
	}
    
}
