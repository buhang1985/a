package iih.mbh.sys.i;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import iih.mbh.sys.login.d.LoginRequestDTO;
import iih.mbh.sys.login.d.UserDTO;
import iih.mbh.sys.terminal.d.PcUseDTO;
import xap.mw.core.data.BizException;

@WebService
public interface IMbhSysQueryService {

	public abstract UserDTO login(@WebParam(name="request") LoginRequestDTO request) throws BizException;
	// 获取服务器毫秒值
	public abstract long getCurrentMillis() throws BizException;
	
	/**
	 * 终端信息获取
	 * @param id_obj
	 * @param eu_obj
	 * @return
	 * @throws BizException
	 */
	public abstract List<PcUseDTO> getTerninalInfo(@WebParam(name="id_obj") List<String> id_obj, @WebParam(name="eu_obj") int eu_obj) throws BizException;
	
	/**
	 * 根据groupName随机获取任一Storage下载地址
	 * 
	 * @param groupName
	 * @return
	 * @throws BizException
	 */
	public String getStorageDownloadAddr(String groupName) throws BizException;
}
