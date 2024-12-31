package iih.ci.ord.i.external.provide;

import java.util.List;
import java.util.Map;

import iih.ci.ord.dto.ordsrvchangeddto.d.OrdSrvChangedInfoDTO;
import xap.mw.core.data.BizException;

/**
 * 临床提供给临床路径的对外接口
 * @author HUMS
 *
 */
public interface ICiOrdHpCpService {

	/**
	 * 根据就诊号获取医嘱最大排序号
	 * @param id_en
	 * @return
	 * @throws BizException 
	 */
	public Integer getOrdMaxSortno(String id_en) throws BizException;
	
	/**
	 * 临床路径校验元素的有效性
	 * @param ordSrvInfos
	 * @return
	 * @throws BizException
	 */
	public abstract Map<String, String> validateHpcpEleAvailableBP(List<OrdSrvChangedInfoDTO> ordSrvInfos) throws BizException;
}
