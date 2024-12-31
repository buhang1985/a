package iih.bd.srv.ems.s;

import java.lang.reflect.InvocationTargetException;

import iih.bd.base.utils.StringCodingUtils;
import iih.bd.srv.ems.bp.EmsManagementBP;
import iih.bd.srv.ems.d.SrvMatchEmsParamDTO;
import iih.bd.srv.ems.d.SrvMatchEmsRstDTO;
import iih.bd.srv.ems.i.IEmsManagementService;
import iih.bd.srv.emsqry.d.EmsFunclassKVDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;

/**
 * 医疗单管理接口
 * @author Young
 *
 */
public class EmsManagementServiceImpl implements IEmsManagementService {

	/**
	 * 医疗单匹配
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 */
	@Override
	public FMap medSrvMatchEms(SrvMatchEmsParamDTO[] params) 
			throws BizException {
		// TODO Auto-generated method stub
		try{
			EmsManagementBP bp = new EmsManagementBP();
			return bp.getEmsMatchResult(params);
		} catch (IllegalAccessException ex) {

		} catch (IllegalArgumentException ex) {

		} catch (InvocationTargetException ex) {

		} catch (NoSuchMethodException ex) {

		} catch (SecurityException ex) {

		}
		return null;
	}
	
	/**
	 * 解析医疗单匹配路径字段
	 * @throws BizException 
	 */
	@Override
	public EmsFunclassKVDTO getEmsFunclassKVDTO(String funcStr) 
			throws BizException {
			String utf8Str = StringCodingUtils.Utf8_Base64_Decode(funcStr);
			EmsFunclassKVDTO funclassDTO = new EmsFunclassKVDTO();
			funclassDTO.deSerializeJson(utf8Str);
			return funclassDTO;
    }

	/**
	 * 根据ID获取医疗单匹配对象
	 * @throws BizException 
	 */
	public SrvMatchEmsRstDTO getSrvMatchEmsRstDTO8Id(String id) throws BizException {
		EmsManagementBP bp = new EmsManagementBP();
		return bp.getSrvMatchEmsRstDTO8Id(id);
	}

	/**
	 * 根据ID获取医疗单匹配对象
	 * @throws BizException 
	 */
	public FMap getSrvMatchEmsRstDTO8Ids(String[] ids) throws BizException {
		EmsManagementBP bp = new EmsManagementBP();
		return bp.getSrvMatchEmsRstDTO8Ids(ids);
	}
}
