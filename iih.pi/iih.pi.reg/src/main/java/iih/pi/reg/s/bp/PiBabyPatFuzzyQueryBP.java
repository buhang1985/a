package iih.pi.reg.s.bp;

import iih.pi.reg.dto.d.PiBabyPatFuzyyQueryCondDTO;
import iih.pi.reg.pat.d.PatiAggDO;
import iih.pi.reg.pat.i.IPatiRService;
import iih.pi.reg.s.bp.qry.PiGetBabyPatIdsByFuzzyQueryCondQry;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 新生儿患者模糊查询
 * @author ly
 *
 */
public class PiBabyPatFuzzyQueryBP {
	
	/**
	 * 新生儿患者模糊查询
	 * @param cond 模糊查询条件
	 * @return 患者aggdo
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public PatiAggDO[] exec(PiBabyPatFuzyyQueryCondDTO cond) throws BizException{
		
		if(cond == null)
			return null;
		
		IPatiRService patiService = ServiceFinder.find(IPatiRService.class);
		
		//如果患者id不为空,直接用患者id检索数据
		if(!StringUtil.isEmpty(cond.getId_pat())){
			
			PatiAggDO aggDo = patiService.findById(cond.getId_pat());
			if(aggDo == null){
				throw new BizException("该患者不存在 患者id:" + cond.getId_pat());
			}
			return new PatiAggDO[] { aggDo };
		}
		
		this.validate(cond);
		
		//患者模糊查询
		PiGetBabyPatIdsByFuzzyQueryCondQry qry = new PiGetBabyPatIdsByFuzzyQueryCondQry(cond);
		
		String mySql = qry.getQrySQLStr();
		StringBuffer sqlSb = new StringBuffer();
		SqlParam para = qry.getQryParameter(sqlSb);
		mySql += sqlSb.toString();
		
		List<String> patidList = (List<String>)new DAFacade().
				execQuery(mySql, para, new ColumnListHandler());
		
		if(ListUtil.isEmpty(patidList))
			return null;
		
		return patiService.findByIds(patidList.toArray(
				new String[patidList.size()]), FBoolean.FALSE);
	}
	
	/**
	 * 简单校验
	 * @param cond
	 * @throws BizException
	 */
	private void validate(PiBabyPatFuzyyQueryCondDTO cond) throws BizException{
		
		if(cond.getDt_birth() == null && 
				StringUtil.isEmpty(cond.getMum_id()) &&
				StringUtil.isEmpty(cond.getMum_tel())){
			throw new BizException("至少输入一个模糊查询条件！");
		}
	}
}
