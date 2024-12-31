package iih.pi.reg.s.bp;

import iih.pi.reg.pat.d.PatDO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 判断是否是社会保险患者
 * @author ly
 *
 */
public class PiPatJudgeIfSocialMedInsBP {

	/**
	 * 判断是否是社会保险患者
	 * @param patId 患者id
	 * @return
	 * @throws BizException
	 */
	public FBoolean exec(String patId) throws BizException{
		
		//校验
		this.validate(patId);
		
		//社会医疗保险存在判断
		DAFacade daf = new DAFacade();
		SqlParam param = new SqlParam();
		param.addParam(patId);
		int count = (int) daf.execQuery(this.insJudgeSql(), param, new ColumnHandler());
		
		return count> 0 ? FBoolean.TRUE : FBoolean.FALSE;
	}
	
	/**
	 * 校验
	 * @param patId
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private void validate(String patId) throws BizException{
		
		//参数校验
		if(StringUtil.isEmpty(patId)){
			throw new BizException("传入的患者id为空");
		}
		
		//存在校验
		DAFacade daf = new DAFacade();
		String cond = PatDO.ID_PAT + " = '" +patId+ "'";
		List<PatDO> pats = (List<PatDO>)daf.findByCond(
				PatDO.class, cond, new String[]{PatDO.ID_PAT,PatDO.FG_INVD});
	
		if(ListUtil.isEmpty(pats)){
			throw new BizException("该患者不存在,患者id:" + patId);
		}
		
		//患者有效校验
		/*if(FBoolean.TRUE.equals(pats.get(0).getFg_invd())){
			throw new BizException("该患者已失效,患者id:" + patId);
		}*/
	}
	
	/**
	 * 拥有社会医疗保险信息判断sql
	 * @return
	 */
	private String insJudgeSql(){
		
		String sql = "select count(pi_pat_hp.id_pathp) "
				+ "from pi_pat_hp "
				+ "inner join bd_hp "
				+ "on pi_pat_hp.id_hp = bd_hp.id_hp "
				+ "and bd_hp.sd_hptp like '1%' "
				+ "where pi_pat_hp.id_pat = ? ";
				
		return sql;
	}
}
