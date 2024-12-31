package iih.bd.srv.s;

import java.util.List;

import iih.bd.srv.d.MrvtmeacaitmDTO;
import iih.bd.srv.i.IMrvtitmExtService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

@Service(serviceInterfaces = { IMrvtitmExtService.class }, binding = Binding.JSONRPC)
public class IMrvtitmExtServiceImpl implements IMrvtitmExtService{

	@Override
	public MrvtmeacaitmDTO getItmDTOList(String id) throws BizException {

		List<MrvtmeacaitmDTO> ret = null;
		String sql="select tm.id_srv,tm.sortno,tm.id_freq,vt.id_de,vt.id_dedatatp,vt.id_unit,vt.devalmax,vt.devalmin,vt.fg_pos,"
				+"vt.id_vt_pos_ca,vt.id_vt_pos_def,vt.fg_aux,vt.id_vt_aux_ca,vt.valcount"
				+" from bd_mr_vt_itm tm"
				+" inner join bd_srv_vt vt on tm.id_srv=vt.id_srv"
				+" where tm.id_srv ='"+id+"'";
		ret = (List<MrvtmeacaitmDTO>)new DAFacade().execQuery(sql, new BeanListHandler(MrvtmeacaitmDTO.class));
		if(ret.size()==0)
			return null;
		else
			return ret.toArray(new MrvtmeacaitmDTO[0])[0];
	}

}
