package iih.bd.fc.i;

import iih.bd.fc.orpltp.d.OrpltpDO;
import iih.bd.fc.orpltp.d.OrpltpStaDO;
import iih.bd.fc.orpltpconfig.d.OrpltpDTO;
import iih.bd.fc.orpltpconfig.d.OrpltpStaDTO;
import iih.bd.fc.orpltpmatch.d.OrpltpMatchDO;
import iih.bd.fc.orpltpstafunc.d.OrpltpStaFuncDO;
import iih.bd.fc.orpltpstamsp.d.OrpltpStaMapDO;
import iih.bd.fc.orpltpstasdto.d.OrpltpStasDTO;
import iih.bd.fc.orwf.d.OrwfAggDO;
import xap.mw.core.data.BizException;

public interface IBdFcMaintainService {

	/**
	 * 医嘱闭环配置保存
	 * 
	 * @param orpltpDTO
	 * @param orpltpStaDTO
	 * @return
	 * @throws BizException
	 */
	public void orpltpConfigSave(OrpltpDTO orpltpDTO, OrpltpStaDTO[] orpltpStaDTOS, OrpltpStaDO[] staDOs) throws BizException;

	/**
	 * 医嘱闭环类型保存
	 * 
	 * @param para
	 * @param param
	 * @throws BizException
	 */
	public void saveOrpltp(OrpltpDO para) throws BizException;

	/**
	 * 医嘱闭环类型状态保存
	 * 
	 * @param para
	 * @param param
	 * @param paramo
	 * @throws BizException
	 */
	public OrpltpStasDTO saveOrpltpRec(OrpltpStaDO para, OrpltpStaFuncDO[] param, OrpltpStaMapDO[] paramo) throws BizException;

	/**
	 * 医嘱闭环流程配置保存
	 * 
	 * @param staDOs
	 * @throws BizException
	 */
	public OrpltpStaDO[] saveOrpltpConfig(String id_orpltp, OrpltpStaDO[] params) throws BizException;

	/**
	 * 医嘱闭环匹配保存
	 * 
	 * @param params
	 * @return
	 * @throws BizException
	 */
	public OrpltpMatchDO[] saveOrpltpMatch(OrpltpMatchDO[] params) throws BizException;

	/**
	 * 医嘱流向升级
	 * 
	 * @param id_wf
	 */
	public void orWfUpGrade() throws BizException;

	/**
	 * 医嘱流向配置保存
	 * 
	 * @throws BizException
	 */
	public OrwfAggDO[] orWfCfgSave(OrwfAggDO[] params) throws BizException;

	/**
	 * 医嘱流向配置删除
	 * 
	 * @throws BizException
	 */
	public void orWfCfgDelete(String[] id_wfs) throws BizException;
	
	/**
	 * 医嘱闭环匹配数据升级
	 * 
	 */
	public void orpltpMatchGrade() throws BizException;
}
