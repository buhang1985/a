package iih.mbh.sys.i;

import java.util.List;
import xap.mw.core.data.BizException;
import javax.jws.WebParam;
import javax.jws.WebService;
import iih.mbh.sys.appdto.d.SysAppMenuPsnlDTO;
import iih.mbh.sys.terminal.d.PcRegDTO;

@WebService
public interface IMbhSysMaintanceService {
	/**
	 * 保存常用按钮
	 * 
	 * @param psnls
	 *            按钮集合
	 * @param idEmp
	 *            登录人员id
	 * @param idDep
	 *            登录科室
	 * @param positon
	 *            位置，用位置来区分删除的按钮
	 * @throws BizException
	 */
	public abstract void savePsnl(@WebParam(name = "psnls") List<SysAppMenuPsnlDTO> psnls,
			@WebParam(name = "idEmp") String idEmp, @WebParam(name = "idDep") String idDep,
			@WebParam(name = "positon") String positon) throws BizException;

	/**
	 * 终端注册
	 * @param para
	 * @throws BizException
	 */
	public abstract String regTerminal(@WebParam(name="para") PcRegDTO para) throws BizException;
}
