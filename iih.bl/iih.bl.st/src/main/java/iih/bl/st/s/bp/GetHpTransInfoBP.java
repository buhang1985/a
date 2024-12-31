package iih.bl.st.s.bp;

import java.util.List;

import iih.bl.hp.hptransactah.d.HpTransActAhDO;
import iih.bl.hp.hptransactah.d.HptransactahAggDO;
import iih.bl.hp.hptransactah.i.IHptransactahRService;
import iih.bl.st.dto.d.BlStOepVsIncDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 医保退费时查询对应的医保结算交易信息
 * 
 * @author liwq
 * @since 2017-8-1 16:04:09
 */
public class GetHpTransInfoBP {
	
	public HpTransActAhDO exec(String id_stoep) throws BizException {
		if(StringUtil.isEmptyWithTrim(id_stoep) ){
			throw new BizException("结算id不能为空！");
		}
		StringBuilder sqlb = new StringBuilder();
		sqlb.append(" select distinct cg.id_ent, st.code_st from bl_cg_itm_oep cg ");
		sqlb.append(" left join bl_st_oep st on st.id_stoep = cg.id_stoep ");
		sqlb.append(" where st.id_stoep = '").append(id_stoep).append("' ");
		List<BlStOepVsIncDTO> list = (List<BlStOepVsIncDTO>)new DAFacade().execQuery(sqlb.toString(), new BeanListHandler(BlStOepVsIncDTO.class));
		
		IHptransactahRService  actService = ServiceFinder.find(IHptransactahRService.class);
		String whereStr = " id_ent = '" + list.get(0).getId_ent() +"' and hp_ent_serial_no = '" + list.get(0).getCode_st() +"' ";
		HptransactahAggDO[] actAggDos = actService.find(whereStr, " dt_transact desc", FBoolean.FALSE);
		
		if(ArrayUtil.isEmptyNoNull(actAggDos)){
			return null;
		}
		HpTransActAhDO actAhDOs  = actAggDos[0].getParentDO();
		return actAhDOs;
		
	}
}
