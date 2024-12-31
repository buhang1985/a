package iih.pi.reg.s.bp;

import iih.pi.reg.dto.d.PiPatFuzyyQueryCondDTO;
import iih.pi.reg.pat.d.PatiAggDO;
import iih.pi.reg.pat.i.IPatiRService;
import iih.pi.reg.s.bp.qry.PiGetPatIdsByFuzzyQueryCondQry;

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
 * 患者模糊查询
 * @author ly
 *
 */
public class PiPatFuzzyQueryBP {
	
	private final Integer MAX_QRY = 20;
	
	/**
	 * 患者模糊查询
	 * @param cond 模糊查询条件
	 * @return 患者aggdo
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public PatiAggDO[] exec(PiPatFuzyyQueryCondDTO cond) throws BizException{
		
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
		PiGetPatIdsByFuzzyQueryCondQry qry = new PiGetPatIdsByFuzzyQueryCondQry(cond);
		
		String mySql = qry.getQrySQLStr();
		StringBuffer sqlSb = new StringBuffer();
		SqlParam para = qry.getQryParameter(sqlSb);
		mySql += sqlSb.toString();
		
		mySql = this.wrapSql(mySql);
		
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
	private void validate(PiPatFuzyyQueryCondDTO cond) throws BizException{
		
		if(StringUtil.isEmpty(cond.getPat_code()) && 
				StringUtil.isEmpty(cond.getPat_name()) && 
				StringUtil.isEmpty(cond.getSd_patcardtp()) &&
				StringUtil.isEmpty(cond.getCard_code()) &&
				StringUtil.isEmpty(cond.getCode_amr_oep()) && 
				StringUtil.isEmpty(cond.getCode_amr_ip()) &&
				StringUtil.isEmpty(cond.getId_code()) && 
				StringUtil.isEmpty(cond.getTel_pat()) &&
				StringUtil.isEmpty(cond.getTel_connect()) &&
				StringUtil.isEmpty(cond.getBarcode_chis())){
			throw new BizException("至少输入一个模糊查询条件！");
		}
	}

	/**
	 * 包装sql，最大条数做限制
	 * @param sql
	 * @return
	 */
	private String wrapSql(String sql){
		String wrapSql = "select * from ( " +sql+ ")  where rownum <= " + MAX_QRY;
		return wrapSql;
	}
}
