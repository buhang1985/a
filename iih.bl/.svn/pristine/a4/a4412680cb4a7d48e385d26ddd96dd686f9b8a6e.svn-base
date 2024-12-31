package iih.bl.itf.std.inner.en.bp;

import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.i.IBlCgItmOepDORService;
import iih.bl.itf.dto.regincinfo.d.RegIncDTO;
import java.util.List;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.lang.ArrayUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sie.common.utils.StringUtils;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获得有效就诊挂号的发票号接口
 * @author lim
 * @since 2020-06-29
 */
public class BlOpRegIncNoBP {
	/**
	 * 获得有效就诊挂号的发票号接口
	 * @param entId 就诊id
	 * @return
	 */
	public RegIncDTO exec(String entId) throws BizException{
		RegIncDTO regIncDTO=null;
		if(StringUtils.isEmpty(entId)){
			throw new BizException("入参就诊id为空");
		}
		//1.获取就诊结算id
		String idStoep=this.bValidReg(entId);
		if(StringUtils.isEmpty(idStoep))
			return regIncDTO;
		//2.获取发票信息
		if(FBoolean.FALSE.equals(this.bExistNoRegCg(idStoep))){
			regIncDTO =this.getRegInc(idStoep);
		}
		return regIncDTO;		
	}
	
	/**
	 * 挂号费是否已付款未退费
	 * @param entId
	 * @return
	 * @throws BizException 
	 */
	@SuppressWarnings("unchecked")
	private String bValidReg(String entId) throws BizException{
		StringBuilder sb= new StringBuilder();
		sb.append("select itm.id_stoep from bl_cg_oep cg inner join bl_cg_itm_oep itm on cg.id_cgoep=itm.id_cgoep ");
		sb.append("  inner join bl_st_oep st on itm.id_stoep =st.id_stoep ");
		sb.append(" where cg.eu_direct='1' and itm.fg_refund='N' and nvl(st.id_paypatoep,'~')<>'~'");
		sb.append("  and itm.eu_srctp='1' and itm.id_ent=?");
		
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(entId);
		
		List<String> list = (List<String>) new DAFacade().execQuery(sb.toString(), sqlParam,new ColumnListHandler<String>() );
		return !ListUtil.isEmpty(list)?list.get(0):"";	
	}
	
	/**
	 * 挂号费是否和其他医嘱一起结算
	 * @param entId
	 * @return
	 * @throws BizException 
	 */
	private FBoolean bExistNoRegCg(String idStoep) throws BizException{
		String whereStr="id_stoep='"+idStoep+"' and eu_srctp='0'";
		IBlCgItmOepDORService cgService = ServiceFinder.find(IBlCgItmOepDORService.class);
		BlCgItmOepDO[] cgItms= cgService.find(whereStr, "", FBoolean.FALSE);
		return ArrayUtils.isEmpty(cgItms)?FBoolean.FALSE:FBoolean.TRUE;	
	}
	
	/**
	 * 获取发票信息
	 * @param idStoep
	 * @return
	 * @throws DAException 
	 */
	@SuppressWarnings("unchecked")
	private RegIncDTO getRegInc(String idStoep) throws DAException{
		StringBuilder sb= new StringBuilder();
		sb.append("select  case when inc.fg_ec_inc='Y' then inc.incno else '' end as Incno_ec,");
		sb.append("  case when inc.fg_ec_inc='N' then inc.incno else paper.incno end as Incno_paper");
		sb.append(" from bl_inc_oep inc ");
		sb.append("  left join bl_inc_oep_paper  paper on inc.id_incoep= paper.id_incoep");
		sb.append("  where inc.fg_canc='N'");
		sb.append("  and inc.id_stoep=?");
		
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(idStoep);
		
		List<RegIncDTO> list = (List<RegIncDTO>) new DAFacade().execQuery(sb.toString(),
				sqlParam, new BeanListHandler(RegIncDTO.class));
		return !ListUtil.isEmpty(list)?list.get(0):null;
	}
}
