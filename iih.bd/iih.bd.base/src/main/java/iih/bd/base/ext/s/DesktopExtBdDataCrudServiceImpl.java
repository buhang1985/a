package iih.bd.base.ext.s;

import iih.bd.base.ext.s.bp.FindSrvRtCtlByEmpIdBp;
import xap.mw.core.data.BizException;
import xap.rui.control.desktop.i.IDesktopExtBdDataCudService;
import xap.rui.control.desktop.i.IDesktopExtBdDataRService;

/**
 * 桌面主程序外部基础数据服务</br>
 * 用于Desktop查询IIH基础数据
 * 
 * @author hao_wu 2019-4-25
 *
 */
public class DesktopExtBdDataCrudServiceImpl implements IDesktopExtBdDataCudService, IDesktopExtBdDataRService {

	@Override
	public String[] findSrvRtCtlByEmpId(String psnDocId) throws BizException {
		FindSrvRtCtlByEmpIdBp bp = new FindSrvRtCtlByEmpIdBp();
		String[] srvRtCtls = bp.exec(psnDocId);
		return srvRtCtls;
	}
}
