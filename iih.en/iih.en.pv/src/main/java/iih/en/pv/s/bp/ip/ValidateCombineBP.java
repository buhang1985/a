package iih.en.pv.s.bp.ip;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.en.pv.dto.d.ResultDTO;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.i.IPatiMDORService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 校验合并患者能否入院登记
 * 
 * @author zhangpp
 *
 */
public class ValidateCombineBP {

	/**
	 * 执行校验合并患者能否入院登记，返回处理结果
	 * @param idPat
	 * @return
	 * @throws BizException
	 */
	public ResultDTO exec(String idPat) throws BizException{
	
		//查询为不在院的合并患者的患者id
		Integer count = this.getCombinePatid(idPat);
		//结果处理
		ResultDTO rst = this.DealResult(count);
		
		return rst;
	}
	
	/**
	 * 查询是否是不在院的合并患者的患者id
	 * @param idPat
	 * @throws BizException 
	 */
	private Integer getCombinePatid(String idPat) throws BizException{
		
		IPatiMDORService iService = ServiceFinder.find(IPatiMDORService.class);
		PatDO patDo = iService.findById(idPat);
		if (FBoolean.FALSE.equals(patDo.getFg_active())) {

			StringBuffer sqlSb = new StringBuffer();
			SqlParam param = new SqlParam();
			sqlSb.append(" select ");
			sqlSb.append(" count(distinct ent.id_pat) ");
			sqlSb.append(" from ");
			sqlSb.append(" en_ent ent ");
			sqlSb.append(" inner join en_ent_ip ip on ent.id_ent = ip.id_ent ");
			sqlSb.append(" where ");
			sqlSb.append(" ip.sd_status in ('" + IEnDictCodeConst.SD_ENSTATUS_IN_DEPTIN + "','" + 
					IEnDictCodeConst.SD_ENSTATUS_IN_HOSPITALIN + "')");
			sqlSb.append(" and ent.id_pat = ? ");
			param.addParam(idPat);
			return (Integer) new DAFacade().execQuery(sqlSb.toString(), param, new ColumnHandler());
		}else{
			return 1;
		}
	}
	
	/**
	 * 结果处理
	 * @param list
	 * @return
	 */
	private ResultDTO DealResult(Integer count){
		
		ResultDTO rst = new ResultDTO();
		if (count != null && count >= 1) {
			rst.setFlag(FBoolean.TRUE);
		}else{
			rst.setFlag(FBoolean.FALSE);
			rst.setMsg("患者已经被合并，不能登记入院！");
		}
		
		return rst;
	}
}
