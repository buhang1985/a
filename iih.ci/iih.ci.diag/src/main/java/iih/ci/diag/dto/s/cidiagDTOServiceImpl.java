package iih.ci.diag.dto.s;
import iih.ci.diag.dto.d.DIDTO;
import iih.ci.diag.dto.i.IcidiagDtoService;
import iih.ci.diag.dto.s.bp.CiDiagCurrentQry;
import iih.ci.diag.dto.s.bp.CiDiagQueryService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 
 * @author li_zh
 *
 */
@Service(serviceInterfaces = {IcidiagDtoService.class}, binding = Binding.JSONRPC)
public class cidiagDTOServiceImpl implements IcidiagDtoService{

	@Override
	public void getCiDiagDTO(DIDTO[] aggdos) throws BizException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public DIDTO[] QueryCiDiagDTO(String id,String type) throws BizException {
		// TODO Auto-generated method stub
		CiDiagQueryService cidiagQry = new CiDiagQueryService(id);
		CiDiagCurrentQry  Current = new CiDiagCurrentQry(id);
		DIDTO[] rtn;
		if(type.equals("current")){
			  rtn=(DIDTO[])AppFwUtil.getDORstWithDao(Current, DIDTO.class);
		}else{
			 rtn=(DIDTO[])AppFwUtil.getDORstWithDao(cidiagQry, DIDTO.class);
		}
		
		return rtn;
		
	}

}
