package iih.mi.verify.bp;

import java.util.List;

import iih.mi.biz.dto.d.DiInfoRegInParamDTO;
import xap.mw.core.data.FArrayList;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 
 * @author hanjq 2019年4月3日
 *
 */
public class GetVerifyDiBp {
	
	/**
	 * 获取审核诊断信息
	 * @param inputDTO
	 * @param id_ent
	 * @return
	 * @throws DAException
	 * @author F 2019年4月3日
	 */
	public FArrayList exce(String id_ent) throws DAException{
		DAFacade daf = new DAFacade();
		StringBuffer bf = new StringBuffer();
		bf.append("SELECT ");
		bf.append(" DISTINCT hpdi.code Di_code,hpdi.name Di_name , doc.code Didoctor_code , doc.name Doctor_name ");
		bf.append(" FROM CI_DI cyzd ");
		bf.append(" INNER JOIN ci_di_itm itm ON itm.id_di = cyzd.id_di ");
		bf.append(" INNER JOIN BD_PSNDOC doc ON doc.id_psndoc = cyzd.id_emp_sign ");
		bf.append(" INNER JOIN bd_hp_di_vs_his hpdi on hpdi.id_didef = itm.id_didef ");
		bf.append(" WHERE cyzd.id_en = ? ");
		SqlParam sp = new SqlParam();
		sp.addParam(id_ent);
		List<DiInfoRegInParamDTO> diInfos = (List<DiInfoRegInParamDTO>) daf.execQuery(bf.toString(), sp,new BeanListHandler(DiInfoRegInParamDTO.class));
		if(diInfos != null && diInfos.size() >0){
			FArrayList diarray = new FArrayList();
			for(DiInfoRegInParamDTO di : diInfos){
				diarray.add(di);
			}
			return diarray;
		}
		return null;
	}

}
