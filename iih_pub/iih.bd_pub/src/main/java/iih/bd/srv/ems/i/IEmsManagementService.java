package iih.bd.srv.ems.i;

import java.lang.reflect.InvocationTargetException;

import iih.bd.srv.ems.d.SrvMatchEmsParamDTO;
import iih.bd.srv.ems.d.SrvMatchEmsRstDTO;
import iih.bd.srv.emsqry.d.EmsFunclassKVDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;

/**
 * 医疗单管理接口
 * @author Young
 *
 */
public interface IEmsManagementService {

	/**
	 * 医疗单匹配方法
	 * @param params
	 * @return FMap:key,Id_srv;value,SrvMatchEmsRstDTO
	 * @throws BizException
	 */
	public abstract FMap medSrvMatchEms(SrvMatchEmsParamDTO[] params) throws BizException;
	
	/**
	 * 解析医疗单匹配路径字段
	 * @param funcStr
	 * @return
	 */
	public abstract EmsFunclassKVDTO getEmsFunclassKVDTO(String funcStr) throws BizException;
	
	/**
	 * 根据ID获取医疗单匹配对象
	 * @param id
	 * @return
	 * @throws BizException
	 */
	public abstract SrvMatchEmsRstDTO getSrvMatchEmsRstDTO8Id(String id) throws BizException;
	
	/**
	 * 根据ID获取医疗单匹配对象
	 * @param ids
	 * @return
	 * @throws BizException
	 */
	public abstract FMap getSrvMatchEmsRstDTO8Ids(String[] ids) throws BizException;
}
