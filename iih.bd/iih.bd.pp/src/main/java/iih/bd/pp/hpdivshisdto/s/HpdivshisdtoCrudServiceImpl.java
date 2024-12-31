package iih.bd.pp.hpdivshisdto.s;

import iih.bd.pp.hpdivshisdto.d.HpDiVsHisDTO;
import iih.bd.pp.hpdivshisdto.i.IHpdivshisdtoCudService;
import iih.bd.pp.hpdivshisdto.i.IHpdivshisdtoRService;
import iih.bd.pp.hpdivshisdto.s.bp.AutoCompInsurDiBp;
import iih.bd.pp.hpdivshisdto.s.bp.ClearDiCompBp;
import iih.bd.pp.hpdivshisdto.s.bp.CompInsurDiDataBp;
import iih.bd.pp.hpdivshisdto.s.bp.DeleteHpDiVsHisDataBp;
import iih.bd.pp.hpdivshisdto.s.bp.FindAuditedDataListBp;
import iih.bd.pp.hpdivshisdto.s.bp.FindCompDataListBp;
import iih.bd.pp.hpdivshisdto.s.bp.HpDiVsHisDtoDeleteBp;
import iih.bd.pp.hpdivshisdto.s.bp.HpDiVsHisDtoSaveBp;
import iih.bd.pp.hpdivshisdto.s.bp.HpDiVsHisPageQryBp;
import iih.bd.pp.hpdivshisdto.s.bp.HpdivshisdtoBp;
import iih.bd.pp.hpdivshisdto.s.bp.SaveHpDiVsHisDataBp;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.sys.jdbc.facade.DAException;

/**
 * 医保病种目录对照服务
 * 
 * @author hao_wu
 *
 */
public class HpdivshisdtoCrudServiceImpl implements IHpdivshisdtoCudService, IHpdivshisdtoRService {

	@Override
	public HpDiVsHisDTO[] find() throws BizException {
		HpDiVsHisPageQryBp bp = new HpDiVsHisPageQryBp();
		return bp.exec();
	}

	@Override
	public HpDiVsHisDTO[] dtoSave(HpDiVsHisDTO[] hpDiVsHisDTOs) throws BizException {
		HpDiVsHisDtoSaveBp bp = new HpDiVsHisDtoSaveBp();
		return bp.exec(hpDiVsHisDTOs);
	}

	@Override
	public void dtoDelete(HpDiVsHisDTO[] hpDiVsHisDTOs) throws DAException {
		HpDiVsHisDtoDeleteBp bp = new HpDiVsHisDtoDeleteBp();
		bp.exec(hpDiVsHisDTOs);
	}

	@Override
	public PagingRtnData<HpDiVsHisDTO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO, String orderStr,
			PaginationInfo pg) throws BizException {
		HpdivshisdtoBp hpdivshisdtoBp = new HpdivshisdtoBp();
		return hpdivshisdtoBp.exec(qryRootNodeDTO, orderStr, pg);
	}

	@Override
	public PagingRtnData<HpDiVsHisDTO> FindAuditedDataList(QryRootNodeDTO qryRootNodeDto, String idHp, PaginationInfo pg)
			throws BizException {
		FindAuditedDataListBp bp = new FindAuditedDataListBp();
		PagingRtnData<HpDiVsHisDTO> result = bp.exec(qryRootNodeDto, idHp, pg);
		return result;
	}

	@Override
	public PagingRtnData<HpDiVsHisDTO> FindCompDataList(QryRootNodeDTO qryRootNodeDto, String idHp, PaginationInfo pg)
			throws BizException {
		FindCompDataListBp bp = new FindCompDataListBp();
		PagingRtnData<HpDiVsHisDTO> result = bp.exec(qryRootNodeDto, idHp, pg);
		return result;
	}

	@Override
	public HpDiVsHisDTO[] SaveHpDiVsHisData(HpDiVsHisDTO[] hpDiVsHisDtos) throws BizException {
		SaveHpDiVsHisDataBp bp = new SaveHpDiVsHisDataBp();
		HpDiVsHisDTO[] result = bp.exec(hpDiVsHisDtos);
		return result;
	}

	@Override
	public HpDiVsHisDTO[] DeleteHpDiVsHisData(HpDiVsHisDTO[] hpDiVsHisDtos) throws BizException {
		DeleteHpDiVsHisDataBp bp = new DeleteHpDiVsHisDataBp();
		HpDiVsHisDTO[] result = bp.exec(hpDiVsHisDtos);
		return result;
	}

	@Override
	public void AutoCompInsurDi(String idHp) throws BizException {
		AutoCompInsurDiBp bp = new AutoCompInsurDiBp();
		bp.exec(idHp);
	}

	@Override
	public HpDiVsHisDTO[] CompInsurDiData(HpDiVsHisDTO[] hpDiVsHisDTOs) throws BizException {
		CompInsurDiDataBp bp = new CompInsurDiDataBp();
		HpDiVsHisDTO[] result = bp.exec(hpDiVsHisDTOs);
		return result;
	}

	@Override
	public void ClearDiComp() throws BizException {
		ClearDiCompBp bp=new ClearDiCompBp();
		bp.exec();
	}
}
