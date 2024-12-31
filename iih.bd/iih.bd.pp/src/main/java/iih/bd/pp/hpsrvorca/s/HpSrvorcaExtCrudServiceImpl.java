package iih.bd.pp.hpsrvorca.s;

import iih.bd.pp.hp.d.HPDO;
import iih.bd.pp.hpsrvorca.d.HPSrvorcaDO;
import iih.bd.pp.hpsrvorca.i.IHpSrvorcaExtCudService;
import iih.bd.pp.hpsrvorca.i.IHpSrvorcaExtRService;
import iih.bd.pp.hpsrvorca.s.bp.DeleteAllHpSrvorcaBp;
import iih.bd.pp.hpsrvorca.s.bp.DeleteDrugHpSrvorcaBp;
import iih.bd.pp.hpsrvorca.s.bp.DeleteTreatHpSrvorcaBp;
import iih.bd.pp.hpsrvorca.s.bp.FindPagingByQCondBp;
import iih.bd.pp.hpsrvorca.s.bp.FindSrvOrCaByIdBp;
import iih.bd.pp.hpsrvorcadto.d.HpsrvorcaDTO;
import iih.mi.itf.bizgrpitf.param.ResultOutParamDTO;
import iih.mi.itf.context.InsureContext;
import iih.mi.itf.facade.InsureServiceFacade;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/***
 * 医保目录对照扩展服务
 * 
 * @author hao_wu
 *
 */
public class HpSrvorcaExtCrudServiceImpl implements IHpSrvorcaExtCudService, IHpSrvorcaExtRService {

	@Override
	public void DeleteAll() throws BizException {
		DeleteAllHpSrvorcaBp bp = new DeleteAllHpSrvorcaBp();
		bp.exec();
	}

	@Override
	public void DeleteTreat() throws BizException {
		DeleteTreatHpSrvorcaBp bp = new DeleteTreatHpSrvorcaBp();
		bp.exec();

	}

	@Override
	public void DeleteDrug() throws BizException {
		DeleteDrugHpSrvorcaBp bp = new DeleteDrugHpSrvorcaBp();
		bp.exec();
	}

	@Override
	public PagingRtnData<HPSrvorcaDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO, String orderStr,
			PaginationInfo pg) throws BizException {
		FindPagingByQCondBp bp = new FindPagingByQCondBp();
		PagingRtnData<HPSrvorcaDO> result = bp.exec(qryRootNodeDTO, orderStr, pg);
		return result;
	}
	
	@Override
	public PagingRtnData<HPSrvorcaDO> findByHpQCondAndPageInfo(HPDO hpdo, QryRootNodeDTO qryRootNodeDTO, String orderStr,
			PaginationInfo pg) throws BizException {
		FindPagingByQCondBp bp = new FindPagingByQCondBp();
		PagingRtnData<HPSrvorcaDO> result = bp.exec(hpdo,qryRootNodeDTO, orderStr, pg);
		return result;
	}

	@Override
	public HPSrvorcaDO findById(String srvOrCaId) throws BizException {
		FindSrvOrCaByIdBp bp = new FindSrvOrCaByIdBp();
		HPSrvorcaDO result = bp.exec(srvOrCaId);
		return result;
	}

	@Override
	public PagingRtnData<HPSrvorcaDO> findPagingByHpIdQCond(HPDO Hpdo, QryRootNodeDTO qryRootNodeDTO, String orderStr,
			PaginationInfo pg) throws BizException {
		InsureContext insureContext = new InsureContext();
		insureContext.setIdHp(Hpdo.getId_hp());

		InsureServiceFacade insureServiceFacade = new InsureServiceFacade(insureContext);
		ResultOutParamDTO<PagingRtnData<HPSrvorcaDO>> result = insureServiceFacade
				.findByQCondAndPageInfo(qryRootNodeDTO, orderStr, pg);
		return (PagingRtnData<HPSrvorcaDO>) result.getData();
	}

	@Override
	public PagingRtnData<HpsrvorcaDTO> findPagingDataByQCondAndMisrvTp(HPDO hpDo, QryRootNodeDTO qryRootNodeDTO,
			String orderStr, PaginationInfo pg, String miSrvTp) throws BizException {

		InsureContext insureContext = new InsureContext();
		insureContext.setIdHp(hpDo.getId_hp());

		InsureServiceFacade insureServiceFacade = new InsureServiceFacade(insureContext);
		ResultOutParamDTO<PagingRtnData<HpsrvorcaDTO>> result = insureServiceFacade
				.findPagingDataByQCondAndMisrvTp(qryRootNodeDTO, orderStr, pg, miSrvTp);
		return (PagingRtnData<HpsrvorcaDTO>) result.getData();
	}

	

}
