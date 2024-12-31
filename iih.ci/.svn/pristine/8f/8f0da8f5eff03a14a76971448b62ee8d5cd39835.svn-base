package iih.ci.mrqc.scoreitmdto.s;


import java.util.List;

import iih.ci.mrqc.qaflt.d.QaFltDTO;
import iih.ci.mrqc.scoreitmdto.d.ScoreItmDto;
import iih.ci.mrqc.scoreitmdto.i.IScoreItmDtoService;
import iih.ci.mrqc.serviceext.i.IQcServiceExt;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

@Service(serviceInterfaces={IScoreItmDtoService.class}, binding=Binding.JSONRPC)
public class IScoreItmDtoServiceImpl implements IScoreItmDtoService{

	@Override
	public ScoreItmDto[] getScoreItmDtos(String id_ent, String id_qc_type)
			throws BizException {
		// TODO Auto-generated method stub
		DAFacade daf = new DAFacade();
		
		String strSql = 
						"select\n"+
						" a.id_qa_divide,\n"+
						" a.id_ent,\n"+
						" a.id_qa_ty,\n"+
						" a.id_qa_itm,\n"+
						" b.req,\n"+
						" b.id_fst,\n"+
						" c.name fst_name,\n"+
						" c.score,\n"+
						" b.id_qa_drp_scr_tp,\n"+
						" b.once_drp_scr,\n"+
						" a.deduct_scr_times,\n"+
						" b.deduct_des,\n"+
						" a.drp_des,\n"+
						" a.id_sbmt_user,\n"+
						" d.name user_name\n"+
						" from\n" +
						" ci_qa_divide a\n"+
						" left join CI_QA_ITM b\n"+
						" 	on a.id_qa_itm = b.id_qa_itm\n"+
						" left join CI_QA_ITM_FST c\n"+
						" 	on b.id_fst = c.id_fst\n"+
						" left join sys_user d\n"+
						" 	on a.id_sbmt_user = d.id_user\n"+
						" where  a.id_ent = '" + id_ent + "' \n"+
						" and  a.ds = '0' \n"+
						" and a.id_qa_ty = '" + id_qc_type +"'  order by a.sv";// order by b.auto_sort
		List<ScoreItmDto> listScoreItmDto = (List<ScoreItmDto>) daf.execQuery(strSql, new BeanListHandler(ScoreItmDto.class));
		if(listScoreItmDto==null)
			return null;
	    return (ScoreItmDto[]) listScoreItmDto.toArray(new ScoreItmDto[listScoreItmDto.size()]);

	}

}
