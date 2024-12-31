package iih.mi.inst.bizgrp.tonglingcity;

import iih.bd.pp.exportdrugsrvdto.d.ExportDrugSrvDTO;
import iih.bd.pp.hpsrvorca.d.HPSrvorcaDO;
import iih.mi.bd.d.HpDTO;
import iih.mi.inst.bizbase.HpInnerServiceBaseImpl;
import iih.mi.inst.bizbase.bp.FindExportPagingByQCondBp;
import iih.mi.inst.bizbase.bp.FindPagingByQCondBp;
import iih.mi.inst.bizgrp.tonglingcity.bp.ImportMedInsurBp;
import iih.mi.inst.bizgrp.tonglingcity.bp.MiDirAutoCompBp;
import iih.mi.inst.bizgrp.tonglingcity.bp.RefreshMiDirCompBp;
import iih.mi.itf.bizgrpitf.HpInnerService;
import iih.mi.itf.bizgrpitf.param.ResultOutParamDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 铜陵医保内部服务实现类
 * 
 * @author hao_wu
 *
 */
public class TLHpInnerServiceImpl extends HpInnerServiceBaseImpl implements HpInnerService {

	@Override
	public ResultOutParamDTO<String> saveMedInsurDir(String miSrvTp, String fileKey) {
		ResultOutParamDTO<String> reOutParamDTO = new ResultOutParamDTO<String>();

		HpDTO hpDTO = this.getHpDTO();
		ImportMedInsurBp bp = new ImportMedInsurBp();
		try {
			bp.exec(fileKey, hpDTO.getCode(), miSrvTp);
		} catch (BizException e) {
			reOutParamDTO.setFg_HisSuccess(FBoolean.FALSE);
			reOutParamDTO.setErrorMsg(e.getMessage());

		}
		return reOutParamDTO;
	}

	@Override
	public ResultOutParamDTO<String> miDirAutoComp(String miSrvTp) {
		ResultOutParamDTO<String> reOutParamDTO = new ResultOutParamDTO<String>();

		HpDTO hpDTO = this.getHpDTO();
		MiDirAutoCompBp bp = new MiDirAutoCompBp();
		try {
			bp.exec(hpDTO, miSrvTp);
		} catch (BizException e) {
			reOutParamDTO.setFg_HisSuccess(FBoolean.FALSE);
			reOutParamDTO.setErrorMsg(e.getMessage());

		}
		return reOutParamDTO;
	}

	@Override
	public ResultOutParamDTO<String> refreshMiDirComp(String miSrvTp) {
		ResultOutParamDTO<String> reOutParamDTO = new ResultOutParamDTO<String>();

		HpDTO hpDTO = this.getHpDTO();
		RefreshMiDirCompBp bp = new RefreshMiDirCompBp();
		try {
			bp.exec(hpDTO, miSrvTp);
		} catch (BizException e) {
			reOutParamDTO.setFg_HisSuccess(FBoolean.FALSE);
			reOutParamDTO.setErrorMsg(e.getMessage());

		}
		return reOutParamDTO;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ResultOutParamDTO<PagingRtnData<HPSrvorcaDO>> findByQCondAndPageInfo(String id_hp,
			QryRootNodeDTO qryRootNodeDto, String orderStr, PaginationInfo pg) {
		ResultOutParamDTO<PagingRtnData<HPSrvorcaDO>> reOutParamDTO = new ResultOutParamDTO<PagingRtnData<HPSrvorcaDO>>();

		FindPagingByQCondBp bp = new FindPagingByQCondBp();
		try {
			PagingRtnData<HPSrvorcaDO> result = bp.exec(id_hp, qryRootNodeDto, orderStr, pg);
			//FArrayList fArrayList = new FArrayList();
			//fArrayList.add(result);
			//reOutParamDTO.setData(fArrayList);
			reOutParamDTO.setData(result);
		} catch (BizException e) {
			reOutParamDTO.setFg_HisSuccess(FBoolean.FALSE);
			reOutParamDTO.setErrorMsg(e.getMessage());

		}
		return reOutParamDTO;
	}
	
}
