package iih.bd.srv.emrtpl.s.bp;

import iih.bd.srv.emrtpl.d.EmrTplDO;
import iih.bd.srv.emrtpl.i.IEmrtplMDOCudService;
import iih.bd.srv.emrtpl.s.bp.sql.SetMrtplNotDefaultSql;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 设置默认医疗记录模板业务逻辑
 * 
 * @author hao_wu
 *
 */
public class SetDefaultMrTplBp {

	public EmrTplDO exec(EmrTplDO emrTplDO) throws BizException {
		if (emrTplDO == null) {
			return null;
		}

		return SetDefaultMrtpl(emrTplDO);
	}

	/**
	 * 设置默认医疗记录模板
	 * 
	 * @param emrTplDO
	 * @return
	 * @throws BizException
	 */
	private EmrTplDO SetDefaultMrtpl(EmrTplDO emrTplDO) throws BizException {
		SetOtherMrtplNotDefault(emrTplDO);
		emrTplDO.setIsdefault(FBoolean.TRUE);
		emrTplDO.setStatus(DOStatus.UPDATED);
		EmrTplDO result = SaveMrtpl(emrTplDO);
		return result;
	}

	/**
	 * 设置其他医疗记录模板为非默认
	 * 
	 * @param emrTplDO
	 * @throws BizException
	 */
	private void SetOtherMrtplNotDefault(EmrTplDO emrTplDO) throws BizException {
		SetMrtplNotDefaultSql sql = new SetMrtplNotDefaultSql(emrTplDO);
		DAFacade daFacade = new DAFacade();
		daFacade.execUpdate(sql.getQrySQLStr(), sql.getQryParameter(null));
	}

	/**
	 * 保存医疗记录模板
	 * 
	 * @param emrTplDO
	 * @return
	 * @throws BizException
	 */
	private EmrTplDO SaveMrtpl(EmrTplDO emrTplDO) throws BizException {
		IEmrtplMDOCudService emrtplMDOCudService = ServiceFinder.find(IEmrtplMDOCudService.class);
		EmrTplDO[] result = emrtplMDOCudService.save(new EmrTplDO[] { emrTplDO });

		if (result != null && result.length == 1) {
			return result[0];
		}
		return null;
	}

}
