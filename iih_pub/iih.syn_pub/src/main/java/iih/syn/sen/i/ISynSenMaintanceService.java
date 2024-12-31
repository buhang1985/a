package iih.syn.sen.i;

import java.util.HashMap;

import iih.syn.sen.entin.d.EntKeyDTO;
import iih.syn.sen.entin.d.IpEntInfoDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;

public interface ISynSenMaintanceService {

	/**
	 * 同步患者就诊
	 * 
	 * @throws BizException
	 */
	public IpEntInfoDTO synEntInfo(String code_pat, String times_ip, String code_unit) throws BizException;

	/**
	 * 业务数据保存之前，同步就诊信息
	 * 
	 * @param params
	 * @throws BizException
	 */
	public HashMap<String, IpEntInfoDTO> synEntInfoByEnt(EntKeyDTO[] params, Integer synTp) throws BizException;

	/**
	 * 通过患者就诊逻辑主键同步患者就诊信息
	 * @param keys
	 * @return
	 * @throws BizException
	 */
	public FMap synEntInfoByLogicKey(String[] keys, Integer synTp) throws BizException;
}
