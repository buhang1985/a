package iih.ei.std.s.v1;

import iih.ei.std.d.v1.bd.comm.d.EiBdQryWsParamDTO;
import iih.ei.std.d.v1.bd.depdoc.d.DepDocDTO;
import iih.ei.std.d.v1.bd.depdoc.d.DepDocListDTO;
import iih.ei.std.d.v1.bd.didoc.d.DiDocDTO;
import iih.ei.std.d.v1.bd.didoc.d.DiDocListDTO;
import iih.ei.std.d.v1.bd.drugdoc.d.DrugDocDTO;
import iih.ei.std.d.v1.bd.drugdoc.d.DrugDocListDTO;
import iih.ei.std.d.v1.bd.paytp.d.PayTpDTO;
import iih.ei.std.d.v1.bd.paytp.d.PayTpListDTO;
import iih.ei.std.d.v1.bd.picatedoc.d.PiCateDocDTO;
import iih.ei.std.d.v1.bd.picatedoc.d.PiCateDocListDTO;
import iih.ei.std.d.v1.bd.psndoc.d.PsnDocDTO;
import iih.ei.std.d.v1.bd.psndoc.d.PsnDocListDTO;
import iih.ei.std.d.v1.bd.sugdoc.d.SugDocDTO;
import iih.ei.std.d.v1.bd.sugdoc.d.SugDocListDTO;
import iih.ei.std.d.v1.bd.svrtpdoc.d.SvrTpDocDTO;
import iih.ei.std.d.v1.bd.svrtpdoc.d.SvrTpDocListDTO;
import iih.ei.std.d.v1.bd.sync.prisrvdoc.d.PriceSrvListDTO;
import iih.ei.std.d.v1.bd.treatdoc.d.TreatDocDTO;
import iih.ei.std.d.v1.bd.treatdoc.d.TreatDocListDTO;
import iih.ei.std.i.v1.IBdApiService;
import iih.ei.std.s.v1.bp.bd.FindDataListByViewCodeBp2;
import iih.ei.std.s.v1.bp.bd.SyncPriSrvDocBp;
import iih.ei.std.s.v1.bp.bd.SyncPsnDocBp;
import xap.mw.core.data.BizException;

/***
 * IIH基础数据域标准对外接口（XML格式）
 * 
 * @author hao_wu
 * @date: 2019-9-6
 */
public class BdApiServiceImpl implements IBdApiService {

	@Override
	public PsnDocListDTO findPsnDoc(EiBdQryWsParamDTO paramDto) throws BizException {
		FindDataListByViewCodeBp2<PsnDocListDTO, PsnDocDTO> bp = new FindDataListByViewCodeBp2<>(PsnDocListDTO.class,
				PsnDocDTO.class, "Psndoc");
		PsnDocListDTO resultDto = bp.exec("V_BD_PSN_V1", paramDto);
		return resultDto;
	}

	@Override
	public DepDocListDTO findDepDoc(EiBdQryWsParamDTO paramDto) throws BizException {
		FindDataListByViewCodeBp2<DepDocListDTO, DepDocDTO> bp = new FindDataListByViewCodeBp2<>(DepDocListDTO.class,
				DepDocDTO.class, "Depdoc");
		DepDocListDTO resultDto = bp.exec("V_BD_DEP_V1", paramDto);
		return resultDto;
	}

	@Override
	public DrugDocListDTO findDrugDoc(EiBdQryWsParamDTO paramDto) throws BizException {
		FindDataListByViewCodeBp2<DrugDocListDTO, DrugDocDTO> bp = new FindDataListByViewCodeBp2<>(DrugDocListDTO.class,
				DrugDocDTO.class, "Drugdoc");
		DrugDocListDTO resultDto = bp.exec("V_BD_DRUG_V1", paramDto);
		return resultDto;
	}

	@Override
	public PayTpListDTO findPayTpDoc(EiBdQryWsParamDTO paramDto) throws BizException {
		FindDataListByViewCodeBp2<PayTpListDTO, PayTpDTO> bp = new FindDataListByViewCodeBp2<>(PayTpListDTO.class,
				PayTpDTO.class, "Paytpdoc");
		PayTpListDTO resultDto = bp.exec("V_BD_PAYTP_V1", paramDto);
		return resultDto;
	}

	@Override
	public SvrTpDocListDTO findSvrTpDoc(EiBdQryWsParamDTO paramDto) throws BizException {
		FindDataListByViewCodeBp2<SvrTpDocListDTO, SvrTpDocDTO> bp = new FindDataListByViewCodeBp2<>(
				SvrTpDocListDTO.class, SvrTpDocDTO.class, "Svrtpdoc");
		SvrTpDocListDTO resultDto = bp.exec("V_BD_SVRTP_V1", paramDto);
		return resultDto;
	}

	@Override
	public PiCateDocListDTO findPiCateDoc(EiBdQryWsParamDTO paramDto) throws BizException {
		FindDataListByViewCodeBp2<PiCateDocListDTO, PiCateDocDTO> bp = new FindDataListByViewCodeBp2<>(
				PiCateDocListDTO.class, PiCateDocDTO.class, "Picatedoc");
		PiCateDocListDTO resultDto = bp.exec("V_BD_PICATE_V1", paramDto);
		return resultDto;
	}

	@Override
	public TreatDocListDTO findTreatDoc(EiBdQryWsParamDTO paramDto) throws BizException {
		FindDataListByViewCodeBp2<TreatDocListDTO, TreatDocDTO> bp = new FindDataListByViewCodeBp2<>(
				TreatDocListDTO.class, TreatDocDTO.class, "Treatdoc");
		TreatDocListDTO resultDto = bp.exec("V_BD_TREAT_V1", paramDto);
		return resultDto;
	}

	@Override
	public SugDocListDTO findSugDoc(EiBdQryWsParamDTO paramDto) throws BizException {
		FindDataListByViewCodeBp2<SugDocListDTO, SugDocDTO> bp = new FindDataListByViewCodeBp2<>(SugDocListDTO.class,
				SugDocDTO.class, "Sugdoc");
		SugDocListDTO resultDto = bp.exec("V_BD_SUG_V1", paramDto);
		return resultDto;
	}

	@Override
	public DiDocListDTO findDiDoc(EiBdQryWsParamDTO paramDto) throws BizException {
		FindDataListByViewCodeBp2<DiDocListDTO, DiDocDTO> bp = new FindDataListByViewCodeBp2<>(DiDocListDTO.class,
				DiDocDTO.class, "Didoc");
		DiDocListDTO resultDto = bp.exec("V_BD_DI_V1", paramDto);
		return resultDto;
	}

	@Override
	public void syncPriSrvDoc(PriceSrvListDTO priceSrvListDTO) throws BizException {
		SyncPriSrvDocBp bp = new SyncPriSrvDocBp();
		bp.exec(priceSrvListDTO);
	}

	@Override
	public void syncPsnDoc(iih.ei.std.d.v1.bd.sync.psndoc.d.PsnDocListDTO psnDocListDTO) throws BizException {
		SyncPsnDocBp bp = new SyncPsnDocBp();
		bp.exec(psnDocListDTO);
	}
}
