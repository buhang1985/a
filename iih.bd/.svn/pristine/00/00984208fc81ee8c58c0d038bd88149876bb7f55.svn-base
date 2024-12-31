package iih.bd.srv.s;

import iih.bd.srv.d.MrtplItmDTO;
import iih.bd.srv.d.MrtplvtDTO;
import iih.bd.srv.i.IMrtplvtExtService;
import iih.bd.srv.s.bp.GetItmDTObp;
import iih.bd.srv.s.bp.GetMrtplItmDTOListbp;
import iih.bd.srv.s.bp.GetMrtplvtDTObp;
import iih.bd.srv.s.bp.SetItmDeInfobp;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;

@Service(serviceInterfaces = { IMrtplvtExtService.class }, binding = Binding.JSONRPC)
public class MrtplvtExtServiceImpl implements IMrtplvtExtService {

	/*
	 * 根据测量ID获取单个测量DTO
	 */
	@Override
	public MrtplvtDTO GetMrtplvtDTO(String Id_mtplvt) throws BizException {

		GetMrtplvtDTObp bp = new GetMrtplvtDTObp();

		MrtplvtDTO[] DTOS = bp.exec(Id_mtplvt);

		if (DTOS != null && DTOS.length == 0)
			return null;
		else
			return DTOS[0];
	}

	/*
	 * 根据测量项目ID获取单个项目DTO
	 */
	@Override
	public MrtplItmDTO GetItmDTO(String Id_mrtplvtitm) throws BizException {

		GetItmDTObp bp = new GetItmDTObp();

		MrtplItmDTO[] DTOS = bp.exec(Id_mrtplvtitm);

		if (DTOS != null && DTOS.length == 0)

			return null;
		else
			return DTOS[0];
	}

	/*
	 * 根据测量ID获取全部项目
	 */
	@Override
	public MrtplItmDTO[] GetMrtplItmDTOList(String Id_mrtplvt) throws BizException {

		GetMrtplItmDTOListbp bp = new GetMrtplItmDTOListbp();

		MrtplItmDTO[] DTOS = bp.exec(Id_mrtplvt);

		if (DTOS != null && DTOS.length == 0)
			return null;
		else
			return DTOS;
	}
	
	/*
	 * 设置MrtplItmDTO的数据元信息
	 */
	@Override
	public MrtplItmDTO SetItmDeInfo(MrtplItmDTO DTO) throws BizException {

		SetItmDeInfobp bp=new SetItmDeInfobp();
		
		return bp.exec(DTO);
	}

}
