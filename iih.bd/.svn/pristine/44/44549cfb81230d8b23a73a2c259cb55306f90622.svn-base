package iih.bd.srv.emrtpl.s;

import iih.bd.srv.emrtpl.d.EmrTplDO;
import iih.bd.srv.emrtpl.i.IEmrtplExtCudService;
import iih.bd.srv.emrtpl.i.IEmrtplExtRService;
import iih.bd.srv.emrtpl.s.bp.CopyEmrTplStreamBp;
import iih.bd.srv.emrtpl.s.bp.FindPagingByQcondAndMrCtmCaBp;
import iih.bd.srv.emrtpl.s.bp.GetNewOrderIdBp;
import iih.bd.srv.emrtpl.s.bp.ReplaceBaseMrtplBp;
import iih.bd.srv.emrtpl.s.bp.SaveEmrTplAndStreamBp;
import iih.bd.srv.emrtpl.s.bp.SetDefaultMrTplBp;
import iih.bd.srv.mrbasetpl.d.EmrBaseTplDO;
import iih.bd.srv.mrctmca.d.MrCaCtmItmDO;
import iih.bd.srv.mrctmca.d.MrCtmCaDO;
import iih.bd.srv.mrtplstream.d.EmrTplStreamDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 医疗模板扩展服务实现
 * 
 * @author hao_wu
 *
 */
public class EmrtplExtCrudServiceImpl implements IEmrtplExtCudService, IEmrtplExtRService {

	@Override
	public EmrTplDO ReplaceBaseMrtpl(EmrTplDO emrTplDo, EmrBaseTplDO emrBaseTplDo) throws BizException {
		ReplaceBaseMrtplBp bp = new ReplaceBaseMrtplBp();
		EmrTplDO result = bp.exec(emrTplDo, emrBaseTplDo);
		return result;
	}

	@Override
	public int GetNewOrderId(EmrTplDO emrTplDo) throws BizException {
		GetNewOrderIdBp bp = new GetNewOrderIdBp();
		return bp.exec(emrTplDo);
	}

	@Override
	public void Save(EmrTplDO emrTplDo, EmrTplStreamDO streamDO) throws BizException {
		SaveEmrTplAndStreamBp bp = new SaveEmrTplAndStreamBp();
		bp.exec(emrTplDo, streamDO);
	}

	@Override
	public EmrTplDO SetDefaultMrTpl(EmrTplDO emrTplDO) throws BizException {
		SetDefaultMrTplBp bp = new SetDefaultMrTplBp();
		return bp.exec(emrTplDO);
	}

	@Override
	public PagingRtnData<EmrTplDO> FindPagingByQcondAndMrCtmCa(String sdOwtp, MrCtmCaDO mrCtmCaDo,
			MrCaCtmItmDO mrCaCtmItmDo, QryRootNodeDTO qryRootNodeDto, PaginationInfo pg) throws BizException {
		FindPagingByQcondAndMrCtmCaBp bp = new FindPagingByQcondAndMrCtmCaBp();
		PagingRtnData<EmrTplDO> result = bp.exec(sdOwtp, mrCtmCaDo, mrCaCtmItmDo, qryRootNodeDto, pg);
		return result;
	}

	@Override
	public void CopyEmrTplStream(String oldOrderid, String newOrderid) throws BizException {
		// TODO Auto-generated method stub
		CopyEmrTplStreamBp Bp = new CopyEmrTplStreamBp();
		Bp.exec(oldOrderid, newOrderid);
	}
	
}
