package iih.bd.srv.ortpl.i;

import iih.bd.srv.ortpl.d.OrTmplCaDO;
import iih.bd.srv.ortpl.d.OrTmplCaRelDO;
import iih.bd.srv.ortpl.d.OrTmplDO;
import iih.bd.srv.ortpl.d.OrTplNItmDO;
import iih.bd.srv.ortpl.d.OrtmplAggDO;
import iih.bd.srv.ortpl.dto.OrTmplDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

public interface IOrtmplcarelExtService {

	/**
	 * 保存医嘱模板
	 * @param ortmplAggDO
	 * @param orTmplCaRelDO
	 * @param ortmplAggDOsRef
	 * @param orTmplDOsRefDel
	 * @throws BizException
	 */
	public abstract void Save(OrtmplAggDO ortmplAggDO, OrTmplCaRelDO orTmplCaRelDO, OrtmplAggDO[] ortmplAggDOsRef, OrTmplDO[] orTmplDOsRefDel) throws BizException;

	public abstract void Delete(OrTmplDTO[] orTmplDTOs) throws BizException;
	
	public abstract OrtmplAggDO[] SaveAs(OrtmplAggDO[] ortmplAggDOs,OrTmplCaRelDO[] orTmplCaRelDOs,OrTmplCaDO orTmplCaDO) throws BizException;
	
	/**
	 * 医嘱模板明细中，当频次周期类型为持续时，计量单位量纲为非时间类型的服务明细
	 * @param orTplNItms 模板明细集合
	 * @return 判断结果
	 * @throws BizException 
	 */
	public abstract String getOrTplNItmAvailableVaidate(OrTplNItmDO[] orTplNItms) throws BizException;
	
	/**
	 * 根据用法关联剂型判断服务是否可成组
	 * @param id_srv
	 * @param id_route
	 * @return
	 * @throws BizException
	 */
	public abstract FBoolean checkSrvEnable8Dosage(String id_srv, String id_route) throws BizException;

}
