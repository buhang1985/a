package iih.ci.mr.mrpsndto.s;

import java.util.List;

import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import iih.ci.mr.mrpsndto.d.MrPsnDTO;
import iih.ci.mr.mrpsndto.i.IMrPsnDtoService;

@Service(serviceInterfaces={IMrPsnDtoService.class}, binding=Binding.JSONRPC)
public class IMrPsnDtoServiceImpl implements IMrPsnDtoService {

	@Override
	public MrPsnDTO[] getMrPsnDtos(String id_dep) throws DAException {
		DAFacade daf = new DAFacade();
		String strSql = "select t.id_user,t.id_psn ,t.name,udi.name as Psndocname "
				+ "from sys_user t left join bd_psndoc psn on psn.id_psndoc = t.id_psn "
				+ "left join bd_udidoc udi on psn.id_emptitle = udi.id_udidoc and udi.id_udidoclist = '0001ZZ2000000000003V' "
				+ "where psn.id_dep = '" + id_dep + "'";
		@SuppressWarnings("unchecked")
		List<MrPsnDTO> listmrpsndtos = (List<MrPsnDTO>) daf.execQuery(strSql, new BeanListHandler(MrPsnDTO.class));
		if(listmrpsndtos==null)
			return null;
	    return (MrPsnDTO[]) listmrpsndtos.toArray(new MrPsnDTO[listmrpsndtos.size()]);

	}
	
	@Override
	public MrPsnDTO[] getMrPsnDtosWhere(String strWhere) throws DAException {
		DAFacade daf = new DAFacade();
		String strSql = "select t.id_user,t.id_psn ,t.name,udi.name as Psndocname "
				+ "from sys_user t left join bd_psndoc psn on psn.id_psndoc = t.id_psn "
				+ "left join bd_udidoc udi on psn.id_emptitle = udi.id_udidoc and udi.id_udidoclist = '0001ZZ2000000000003V' "
				+ "where psn.id_psndoc in ("+strWhere+")";
		@SuppressWarnings("unchecked")
		List<MrPsnDTO> listmrpsndtos = (List<MrPsnDTO>) daf.execQuery(strSql, new BeanListHandler(MrPsnDTO.class));
		if(listmrpsndtos==null)
			return null;
	    return (MrPsnDTO[]) listmrpsndtos.toArray(new MrPsnDTO[listmrpsndtos.size()]);

	}

	@Override
	public MrPsnDTO[] getMrPsnDtosSup(String id_ent) throws DAException {
		DAFacade daf = new DAFacade();
		String strSql ="select t.id_user,t.id_psn ,t.name,udi.name as Psndocname"
				+" from sys_user t "
				+" left join bd_emp_wg on t.id_psn = bd_emp_wg.id_emp"
				+" left join bd_psndoc on bd_psndoc.id_psndoc = t.id_psn"
				+" left join en_ent_wg on en_ent_wg.id_wg = bd_emp_wg.id_wg"
				+" left join bd_udidoc udi on bd_psndoc.id_emptitle = udi.id_udidoc and udi.id_udidoclist = '@@@@ZZ2000000000003V'" 
				+" where en_ent_wg.id_ent ='"+id_ent+"'";
		@SuppressWarnings("unchecked")
		List<MrPsnDTO> listmrpsndtos = (List<MrPsnDTO>) daf.execQuery(strSql, new BeanListHandler(MrPsnDTO.class));
		if(listmrpsndtos==null)
			return null;
	    return (MrPsnDTO[]) listmrpsndtos.toArray(new MrPsnDTO[listmrpsndtos.size()]);
	}

}
