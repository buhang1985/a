package iih.mbh.sys.login.i;

import java.util.List;

import iih.mbh.sys.login.d.DepDTO;
import iih.mbh.sys.login.d.LoginRequestDTO;
import iih.mbh.sys.login.d.UserDTO;

import javax.jws.WebParam;
import javax.jws.WebService;

import xap.mw.core.data.BizException;

@WebService
public interface ILoginService {

	public abstract UserDTO login(@WebParam(name="request") LoginRequestDTO request) throws BizException;

	public abstract List<DepDTO> getDepOfUser(@WebParam(name="code_user") String code_user) throws BizException;

}
