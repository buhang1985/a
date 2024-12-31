/*
 * 扼要描述
     * 详细描述：门诊病历打印（批量）
 * author：张静波
 * reviewer：xxx
 */
package iih.ci.mr.cimrbatchprintdto.i;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import iih.ci.mr.cimrbatchprintdto.d.CiMrBatchPrintDTO;
import iih.pi.reg.pat.d.PatDO;

import java.math.BigDecimal;

/**
 * 门诊病历打印(批量) DTO数据 
 * 
 */
public interface ICiMrBatchPrintCrudService {
	
	/**
	 * 查询方案获取病历列表
	 * @param qryRootNodeDTO
	 * @param orderStr
	 * @param isLazy
	 * @return
	 */
	public abstract CiMrBatchPrintDTO[] findByQCond(QryRootNodeDTO qryRootNodeDTO, String orderStr, FBoolean isLazy) throws BizException ;
	
	/**
	 * 根据就诊卡号查询病历列表
	 * @param barCode
	 * @return
	 * @throws BizException
	 */
	public abstract CiMrBatchPrintDTO[]  getMrListByBarCode(String barCode) throws BizException;
	/**
	 * 根据就诊卡号查询患者信息
	 * @param barCode
	 * @return
	 * @throws BizException
	 */
	public abstract PatDO  getPatDOByBarCode(String barCode) throws BizException;
}