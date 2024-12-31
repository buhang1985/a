package iih.pi.patsrvpkg.s;

import iih.pi.patsrvpkg.dto.PiPatSrvPkgTotalDTO;
import iih.pi.patsrvpkg.i.IPiPatsrvpkgMaintainService;
import iih.pi.patsrvpkg.s.bp.SavePiPatSrvPkgBP;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;

/**
 * 患者服务包维护类
 * @author ly
 *
 */
@Service(serviceInterfaces={IPiPatsrvpkgMaintainService.class}, binding=Binding.JSONRPC)
public class PiPatsrvpkgMaintainServiceImpl implements IPiPatsrvpkgMaintainService {

	/**
	 * 保存患者服务包及服务包分组
	 * @param pkgDO 患者服务包
	 * @param pkggrAggDO 患者服务包分组
	 * @return
	 * @throws BizException
	 */
	@Override
	public PiPatSrvPkgTotalDTO[] savePiPatSrvPkg(PiPatSrvPkgTotalDTO[] pkgs) throws BizException {
		SavePiPatSrvPkgBP bp = new SavePiPatSrvPkgBP();
		return bp.exec(pkgs);
	}

}
