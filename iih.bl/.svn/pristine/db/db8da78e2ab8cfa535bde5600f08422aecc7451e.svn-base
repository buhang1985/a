package iih.bl.hp.bp;

import java.util.List;

import iih.bd.base.utils.SqlUtils;
import iih.bd.srv.diagdef.d.DiagDefDO;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.hp.blhppatspec.d.BlHpPatSpecDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 判定是否医保特殊病
 * @author 
 *
 */
public class CheckIsPatDiBP {
	/**
	 * 判定是否医保特殊病	 
	 * @param hpId 医保计划ID
	 * @param patId 患者ID
	 * @param diDefIds 诊断ID集合
	 * @return fmap,[key:诊断ID,value:FBoolean]
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public FMap exec(String hpId,String patId,String[] diDefIds) throws BizException{
		FMap dimap = new FMap();
		for(String strId_didef :diDefIds)
		{
		 	dimap.put(strId_didef, FBoolean.FALSE);
		}
		StringBuffer sql2=new StringBuffer();
		sql2.append("select pihp.id_pat,pihp.id_hp,di.id_didef   ");
		sql2.append("from bl_hp_pat_spec pat                     ");
		sql2.append("inner join bl_hp_pat_spec_di specdi         ");
		sql2.append(" on pat.id_hppatspec = specdi.id_hppatspec  ");
		sql2.append("inner join pi_pat_hp pihp                   ");
		sql2.append(" on (pat.no_hp = pihp.no_hp and pat.id_hp = pihp.id_hp) ");
		sql2.append("inner join bd_di_def di on specdi.code_di=di.code ");
		sql2.append(" where pihp.id_pat = '").append(patId).append("'  ");
		sql2.append(" and pihp.id_hp='").append(hpId).append("'        ");
		sql2.append(" and  ").append(SqlUtils.getInSqlByIds("di.id_didef", diDefIds));
		List<DiagDefDO> hpSpeclist = (List<DiagDefDO>) new DAFacade().execQuery(sql2.toString(),new BeanListHandler(DiagDefDO.class));
		if(hpSpeclist!=null && hpSpeclist.size()>0)
		{
			for(DiagDefDO item :hpSpeclist)
			{
				if(dimap.containsKey(item.getId_didef()))
				{
					dimap.remove(item.getId_didef());
					dimap.put(item.getId_didef(), FBoolean.TRUE);
				}
			}
		}
		return dimap;
	}
}
