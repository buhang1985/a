package iih.bd.pp.accountsubject.s.bp;

import java.util.List;

import iih.bd.pp.accountsubject.d.AccountSubjectDO;
import iih.bd.pp.dto.d.UnComparSrvOnAccDTO;
import xap.mw.core.data.Context;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
/**
 * 核算分类查询未对照服务数据
 * @author shao_yuan
 *
 */
public class GetUnComparSrvOnAccDTOBp {
	/** 
	 * 查询未对照服务数据
	 * @param accountSubjectDo
	 */
	public UnComparSrvOnAccDTO[] exec(AccountSubjectDO accountSubjectDo) throws DAException {
		String sb = SetQryString(accountSubjectDo);		
		List<UnComparSrvOnAccDTO> list  = (List<UnComparSrvOnAccDTO>)new DAFacade().execQuery(sb,null, new BeanListHandler(UnComparSrvOnAccDTO.class));
		if(accountSubjectDo != null){			
			for(UnComparSrvOnAccDTO unDto :list){
				unDto.setId_account(accountSubjectDo.getId_account());
			}
		}
		return list.toArray(new UnComparSrvOnAccDTO[0]);
	}
	/** 
	 * 组装查询sql
	 * @param accountSubjectDo
	 */
	private String SetQryString(AccountSubjectDO accountSubjectDo) {
		StringBuffer sb = new StringBuffer();
		sb.append(" select ca.id_srvca,ca.name,ca.code,ca.id_parent  ");
		sb.append("  	from bd_srvca ca ");
		sb.append(" where ca.id_srvca  in ");
		sb.append("   	(select distinct id_srvca from bd_srv ");
		sb.append("   	where id_srv not in( ");
		sb.append("    select a.id_srv from bd_account_ca_vs_srv a ");
		if(accountSubjectDo != null)
			sb.append("    where a.id_account = '"+accountSubjectDo.getId_account()+"' ");
		sb.append("  	) ");
		sb.append(" and sd_primd in ('00','04') ");//本服务定价和对应物品价格
		sb.append("  	and ds = 0 ) ");
		sb.append("   and ca.id_org = '"+Context.get().getOrgId()+"' ");
		sb.append("  	order by  ca.id_srvca");
		return sb.toString();
	}

}
