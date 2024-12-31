package iih.bl.st.s.bp.op;

import iih.bd.pp.hp.d.HPDO;
import java.util.List;

import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 根据患者分类查询是否为高端商保患者
 * @author liming06
 * @since 2019-11-22
 *
 */
public class CheckBHpCgPatBP {
	/**
	 * 根据患者分类查询该患者是否为高端商保患者
	 * @param id_patca 患者分类id
	 * @return
	 * @throws DAException
	 */
	public FBoolean exec(String id_patca) throws DAException{
		FBoolean bHpCgPat=FBoolean.FALSE;
		if(StringUtil.isEmpty(id_patca))
			return bHpCgPat;
		
		String sql= this.getSql();
		SqlParam param = new SqlParam();
		param.addParam(id_patca);
		@SuppressWarnings("unchecked")
		List<HPDO>  bdHpDoList=(List<HPDO>) new DAFacade().execQuery(sql.toString(), param,new BeanListHandler(HPDO.class));
		if(!ListUtil.isEmpty(bdHpDoList)){
			HPDO hpDO=  bdHpDoList.get(0);
			//支持医保记账标志为true，并且医保计划类型为商业保险
			if(FBoolean.TRUE.equals(hpDO.getFg_hpcg())
					&& !StringUtil.isEmpty(hpDO.getSd_hptp())&&hpDO.getSd_hptp().startsWith("2")){
				bHpCgPat=FBoolean.TRUE;
			}
		}	
		return bHpCgPat;
	}
	
	/**
	 * 组织查询语句
	 * @return
	 */
	private String getSql(){
		StringBuilder sql=new StringBuilder();
		sql.append(" select hp.Fg_hpcg,hp.id_hptp,hp.sd_hptp");
		sql.append(" from pi_pat_ca_hp ca inner join bd_hp hp on ca.id_hp=hp.id_hp ");
		sql.append(" where ca.id_patca=?");
		return sql.toString();
	}
}
