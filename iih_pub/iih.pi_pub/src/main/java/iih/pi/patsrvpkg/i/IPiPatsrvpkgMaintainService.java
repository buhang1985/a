package iih.pi.patsrvpkg.i;

import iih.pi.patsrvpkg.dto.PiPatSrvPkgTotalDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;


/**
 * 患者服务包维护接口
 * @author ly
 *
 */
public interface IPiPatsrvpkgMaintainService {

	/**
	 * 保存患者服务包及服务包分组
	 * @param pkgs 服务包集合
	 * @return
	 * @throws BizException
	 */
	public abstract PiPatSrvPkgTotalDTO[] savePiPatSrvPkg(PiPatSrvPkgTotalDTO[] pkgs) throws BizException;
}
