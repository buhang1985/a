package iih.bl.itf.std.inner.en.bp;

import java.util.List;

import iih.bl.st.dto.d.BlClinicRetNoDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 是否允许诊间退号
 * @author shaokx 2020/06/23
 *
 */
public class BlIsClinicRetNoBP {

	
	/**
	 * 是否允许诊间退号
	 * @return
	 * @throws BizException
	 */
	public Boolean exec(String entId) throws BizException{
		
		if(StringUtil.isEmpty(entId)){
			throw new BizException("是否允许诊间退号：就诊id为空");
		}
		
		//1.根据id_ent,找到门诊记账明细中由“就诊产生”的费用，再根据id_stoep找到对应的结算，进而找到门诊收付款记录。若门诊收付款记录的终端类型为“07”，则表示本笔交易为“诊间挂号产生的收付款”。
		StringBuilder sql = new StringBuilder();
		sql.append(" select ");
		sql.append(" cgitm.id_ent,cgitm.id_pat,cgitm.fg_refund,st.id_stoep,inc.fg_print ");
		sql.append(" from bl_cg_itm_oep cgitm ");
		sql.append(" inner join bl_st_oep st on cgitm.id_stoep = st.id_stoep ");
		sql.append(" inner join bl_inc_oep inc on inc.id_stoep = st.id_stoep ");            //结算模式下的诊间挂号，结算和发票表一对一关系，所以可以直接inner join
		sql.append(" inner join bl_pay_pat_oep pay on st.id_paypatoep = pay.id_paypatoep ");
		sql.append(" where cgitm.eu_srctp = 1 ");
		sql.append(" and pay.sd_pttp = '07' ");
		sql.append(" and cgitm.id_ent = ? ");
		
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(entId);
		
		List<BlClinicRetNoDTO> list = (List<BlClinicRetNoDTO>) new DAFacade().execQuery(sql.toString(),
				sqlParam, new BeanListHandler(BlClinicRetNoDTO.class));
		
		if(ListUtil.isEmpty(list)){
			//throw new BizException("未查询到结算模式下的诊间挂号收费数据");
			return false;
		}
		
		//2.校验该笔收款是否已经退费，若退费，需要返回提示：本交易已经退费，退费失败。程序终止。
		if(list.get(0).getFg_refund().booleanValue()){
			throw new BizException("本交易已经退费，退费失败");
		}
		
		//3.校验该笔收款是否已经打印发票，若已经打印发票，需要返回提示：本交易已经打印发票，无法进行诊间退费，退费失败。程序终止。
		if(list.get(0).getFg_print().booleanValue()){
			throw new BizException("本交易已经打印发票，无法进行诊间退费，退费失败");
		}

		return true;
	}
}
