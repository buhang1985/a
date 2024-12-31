package iih.bd.pp.service.s;

import iih.bd.pp.bdcpnca.bp.BdCpnCaBp;
import iih.bd.pp.bdcpnca.d.BdCpncaDO;
import iih.bd.pp.bdprisamp.bp.BdPriSampBp;
import iih.bd.pp.dto.d.BdPriSampDTO;
import iih.bd.pp.hpsrvorca.bp.ExportDrugsInfoBp;
import iih.bd.pp.hpsrvorca.bp.ExportMedicalInfoBp;
import iih.bd.pp.hpsrvorca.bp.HpSrvOrCaBp;
import iih.bd.pp.hpsrvorca.d.HPSrvorcaDO;
import iih.bd.pp.hpsrvorca.d.ImportDTO;
import iih.bd.pp.incca.bp.InccaBp;
import iih.bd.pp.incca.d.IncCaItmRelDO;
import iih.bd.pp.incca.d.UnComparisonedSrvDTO;
import iih.bd.pp.prisrv.d.PriSrvDO;
import iih.bd.pp.prisrv.dp.MedSrvPriceDp;
import iih.bd.pp.service.i.IPriMaintainService;
import iih.bd.srv.medsrv.d.MedSrvDO;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;

@Service(serviceInterfaces = { IPriMaintainService.class }, binding = Binding.JSONRPC)
public class PriMaintainServiceImpl implements IPriMaintainService {

	@Override
	public MedSrvDO saveMedSrvPrice(MedSrvDO medSrvDO, PriSrvDO[] priSrvDOArr) throws BizException {
		MedSrvPriceDp medSrvPriDp = new MedSrvPriceDp();
		return medSrvPriDp.saveMedSrvPrice(medSrvDO, priSrvDOArr);
	}

	@Override
	public HPSrvorcaDO[] findHpSrvOrCaInfo() throws BizException {
		HpSrvOrCaBp hpSrvOrCaBp = new HpSrvOrCaBp();
		return hpSrvOrCaBp.getHpSrvOrCaInfo();
	}

	@Override
	public HPSrvorcaDO[] exportDrugsInfo() throws BizException {
		ExportDrugsInfoBp bp = new ExportDrugsInfoBp();
		return bp.exec();
	}

	@Override
	public HPSrvorcaDO[] exportMedicalInfo() throws BizException {
		ExportMedicalInfoBp bp = new ExportMedicalInfoBp();
		return bp.exec();
	}

	@Override
	public FBoolean saveHpSrvOrCaInfo(HPSrvorcaDO[] hpSrvOrCaDOArr) throws BizException {
		HpSrvOrCaBp hpSrvOrCaBp = new HpSrvOrCaBp();
		return hpSrvOrCaBp.saveHpSrvOrCaInfo(hpSrvOrCaDOArr);
	}

	@Override
	public UnComparisonedSrvDTO[] getUnComparisonedSrvDTOByIdincca(String id_incca) throws BizException {

		InccaBp inccaBp = new InccaBp();
		return inccaBp.findUnComparisonedSrvDTOByIdincca(id_incca);
	}

	@Override
	public MedSrvDO[] getUnComparisonedSrvsList(String id_incca, String id_srvca) throws BizException {
		InccaBp inccaBp = new InccaBp();
		return inccaBp.findUnComparisonedSrvsByIds(id_incca, id_srvca);
	}

	@Override
	public FBoolean saveComparisonedSrv(IncCaItmRelDO[] inccaitmRelDOArr) throws BizException {
		InccaBp inccaBp = new InccaBp();
		return inccaBp.saveComparisonedSrv(inccaitmRelDOArr);
	}

	@Override
	public IncCaItmRelDO[] findInccaItmRelDtoById(String id_inccaitm, String id_incca, String id_srv, String id_srvca)
			throws BizException {
		InccaBp inccaBp = new InccaBp();
		return inccaBp.findInccaItmRelDtoById(id_inccaitm, id_incca, id_srv, id_srvca);
	}

	@Override
	public IncCaItmRelDO[] findInccaitmRelDOByIdsrvca(String id_incca, String id_inccaitm, String id_srvca)
			throws BizException {
		InccaBp inccaBp = new InccaBp();
		return inccaBp.getInccaitmRelDOByIdsrvca(id_incca, id_inccaitm, id_srvca);
	}

	@Override
	public FBoolean deleteBdcpnCaAndDOs(BdCpncaDO bdcpncaDO) throws BizException {
		BdCpnCaBp inccaBp = new BdCpnCaBp();
		return inccaBp.deleteBdcpnCaAndDOs(bdcpncaDO);
	}

	@Override
	public PriSrvDO[] saveMedSrvPriInfo(PriSrvDO[] dos) throws BizException {
		MedSrvPriceDp medSrvPriDp = new MedSrvPriceDp();
		return medSrvPriDp.saveSrvPriInfo(dos);
	}

	@Override
	public FBoolean deleteMedSrvAndPrice(MedSrvDO medSrvDO) throws BizException {
		MedSrvPriceDp medSrvPriDp = new MedSrvPriceDp();
		return medSrvPriDp.deleteMedSrvAndPrice(medSrvDO);
	}

	@Override
	public MedSrvDO saveMedSrvSetPriInfo(MedSrvDO medSrvDO, FArrayList list) throws BizException {
		MedSrvPriceDp medSrvPriDp = new MedSrvPriceDp();
		return medSrvPriDp.saveMedSrvPriSetInfo(medSrvDO, list);
	}

	@Override
	public BdPriSampDTO[] getSampTypeGrid() throws BizException {
		BdPriSampBp bp = new BdPriSampBp();
		return bp.findAllSampTypesByQuery();
	}

	@Override
	public IncCaItmRelDO[] findInccaItmNameByIdsrv(String id_srv, String id_incca) throws BizException {
		MedSrvPriceDp medSrvPriDp = new MedSrvPriceDp();
		return medSrvPriDp.findInccaItmNameByIdsrv(id_srv, id_incca);
	}

	@Override
	public ImportDTO[] importHPSrvorca(String id_hp, String importData, Boolean fg_drug) throws BizException {
		HpSrvOrCaBp hpSrvOrCaBp = new HpSrvOrCaBp();
		return hpSrvOrCaBp.ImportHPSrvorca(id_hp, importData, fg_drug);
	}

	@Override
	public String exportHPSrvorca(Boolean fg_drug) throws BizException {
		HpSrvOrCaBp hpSrvOrCaBp = new HpSrvOrCaBp();
		return hpSrvOrCaBp.ExportHPSrvorca(fg_drug);
	}

	@Override
	public FBoolean saveHPSrvorca(HPSrvorcaDO[] hpSrvOrCaDOArr, Boolean fg_drug) throws BizException {
		HpSrvOrCaBp hpSrvOrCaBp = new HpSrvOrCaBp();
		return hpSrvOrCaBp.SaveHPSrvorca(hpSrvOrCaDOArr, fg_drug);
	}

	@Override
	public FBoolean deleteHPSrvorcasDataAndHpSrvctrsData(HPSrvorcaDO[] selectedDOArr) throws BizException {
		HpSrvOrCaBp hpSrvOrCaBp = new HpSrvOrCaBp();
		return hpSrvOrCaBp.deleteHPSrvorcasDataAndHpSrvctrsData(selectedDOArr);
	}

}
