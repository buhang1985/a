package iih.bd.srv.diagcate.bp;

import java.util.List;

import iih.bd.srv.d.DiagDicaDTO;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

public class DiagcateCrudBp {
	@SuppressWarnings("unchecked")
	public DiagDicaDTO[] getDiagDicaDOList(String Id_di) throws BizException {
		String sql = "select distinct d.id_dica, d.name,case  r.id_didef when '" + Id_di + "' then 'true' else 'false' end active " +
					 "from bd_dica d left join  bd_dica_itm_rel r " +
					 "on  d.id_dica = r.id_dica and r.id_didef = '" + Id_di +"'";
		List<DiagDicaDTO> list = (List<DiagDicaDTO>)new DAFacade().execQuery(sql, new BeanListHandler(DiagDicaDTO.class));
		return list.toArray(new DiagDicaDTO[0]);
	}
	
	@SuppressWarnings("unchecked")
	public DiagDicaDTO[] getDistinctDicaList() throws BizException{
		String sql = "select distinct id_dica, name,'false' as active from bd_dica";
		List<DiagDicaDTO> list = (List<DiagDicaDTO>)new DAFacade().execQuery(sql, new BeanListHandler(DiagDicaDTO.class));
		return list.toArray(new DiagDicaDTO[0]);
	}
}
