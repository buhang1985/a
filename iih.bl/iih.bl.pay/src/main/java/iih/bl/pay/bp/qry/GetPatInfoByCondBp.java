package iih.bl.pay.bp.qry;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import iih.bl.pay.dto.d.PatInfoQryDTO;

public class GetPatInfoByCondBp {
   
	 /**
     * 铜陵住院预交金节点的患者信息弹窗窗用  查询患者信息接口，参数为从前台界面传过来的查询条件
     * @param strcond 从前台界面传过来的查询条件取值
     * @return
     * @throws BizException
     */
	public PatInfoQryDTO[]   exec(String conds) throws BizException
    {
		StringBuffer sql1=new StringBuffer();
		sql1.append("select ent.id_ent,entip.id_bed,entip.name_bed, ");
	    sql1.append("ent.id_dep_nur,dep.name as Name_dep_nur,       ");
		sql1.append("pat.id_pat,pat.code as code_pat, pat.name as name_pat, ");
		sql1.append("pat.id_code certificate_no,");
		sql1.append("pat.id_sex,udi.name as sex_name,pat.mob  as telno ");
		sql1.append("from  en_ent  ent                                  ");
	    sql1.append("inner join en_ent_ip entip on entip.id_ent = ent.id_ent  ");
		sql1.append("inner join pi_pat pat      on  ent.id_pat    = pat.id_pat ");
		sql1.append("inner join  bd_dep  dep    on  ent.id_dep_nur = dep.id_dep ");
		sql1.append("join bd_udidoc  udi  on pat.id_sex = udi.id_udidoc   ");
		sql1.append("and udi.id_udidoclist='@@@@ZZ20000000000035'         ");
	    sql1.append("where ent.fg_ip = 'Y'  and ent.fg_st='N'             ");
	    
	    sql1.append(conds);
	  	List<PatInfoQryDTO> list  = (List<PatInfoQryDTO>)new DAFacade().execQuery(sql1.toString(), new BeanListHandler(PatInfoQryDTO.class));
		 return list.toArray(new PatInfoQryDTO[0]);
	 }
}
