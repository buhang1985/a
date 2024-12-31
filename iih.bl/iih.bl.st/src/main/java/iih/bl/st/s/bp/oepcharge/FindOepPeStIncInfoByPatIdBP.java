package iih.bl.st.s.bp.oepcharge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.base.utils.SqlUtils;
import iih.bl.st.dto.d.BlStOepVsIncDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 查询患者发票结算信息
 * 
 * @author wq.li
 *
 */
public class FindOepPeStIncInfoByPatIdBP {

	/**
	 * 查询患者的发票结算信息
	 * @param patId
	 * @param dtB
	 * @param dtE
	 * @return
	 * @throws BizException 
	 */
	public BlStOepVsIncDTO[] exec(String patId,FDateTime dtB,FDateTime dtE) throws BizException{
		
		//入参校验
		if(StringUtil.isEmpty(patId)){
			throw new BizException("patId不能为空");
		}
		
		if(dtB==null||dtE==null){
			throw new BizException("开始结束时间不能为空");
		}
			
		//1.查询发票及结算信息
		BlStOepVsIncDTO[] incDtoArr=this.getStInc(patId, dtB, dtE);
		if(ArrayUtil.isEmpty(incDtoArr)){
			return null;
		}
		
		List<String> stIdList=new ArrayList<>();
		for (BlStOepVsIncDTO blStOepVsIncDTO : incDtoArr) {
			stIdList.add(blStOepVsIncDTO.getId_stoep());
		}
		
		//2.查询支付信息
		BlStOepVsIncDTO[] payInfo=this.getPayItm(stIdList.toArray(new String[0]));
		
		Map<String,List<String>> payMap=new HashMap<>();
		
		for (BlStOepVsIncDTO blStOepVsIncDTO : payInfo) {
			if(payMap.containsKey(blStOepVsIncDTO.getId_stoep())){
				List<String> pmList = payMap.get(blStOepVsIncDTO.getId_stoep());
				if(!pmList.contains(blStOepVsIncDTO.getName_pm())){
					pmList.add(blStOepVsIncDTO.getName_pm());
				}
			}else{
				List<String> pmList =new ArrayList<>();
				pmList.add(blStOepVsIncDTO.getName_pm());
				payMap.put(blStOepVsIncDTO.getId_stoep(), pmList);
			}
		}
		
		//3.组装支付信息
		
		for (BlStOepVsIncDTO blStOepVsIncDTO : incDtoArr) {
			List<String> pmList = payMap.get(blStOepVsIncDTO.getId_stoep());
			StringBuilder pmStr=new StringBuilder();
			for (String pm : pmList) {
				pmStr.append(pm);
				pmStr.append(" ");
			}
			blStOepVsIncDTO.setName_pm(pmStr.toString());
		}
		
		return incDtoArr;
	}

	/**
	 * 查询支付信息
	 * 
	 * @param stIdArr
	 * @return
	 * @throws BizException 
	 */
	private BlStOepVsIncDTO[] getPayItm(String[] stIdArr) throws BizException {

		if (ArrayUtil.isEmpty(stIdArr)) {
			return null;
		}

		StringBuilder sql = new StringBuilder();

		sql.append(" select ");
		sql.append(" st.id_stoep,");
		sql.append(" itmoep.id_pm,");
		sql.append(" itmoep.sd_pm,");
		sql.append(" pm.name name_pm");
		sql.append("  from bl_pay_pat_oep pay");
		sql.append("  inner join bl_pay_itm_pat_oep itmoep on itmoep.id_paypatoep=pay.id_paypatoep");
		sql.append("  inner join bl_st_oep st on st.id_paypatoep=pay.id_paypatoep");
		sql.append("  inner join bd_pri_pm pm on pm.id_pm=itmoep.id_pm");
		String wheStr = SqlUtils.getInSqlByIds("st.id_stoep", stIdArr);
		sql.append(" where ");
		sql.append(wheStr);

		List<BlStOepVsIncDTO> list = (List<BlStOepVsIncDTO>) new DAFacade().execQuery(sql.toString(),
				new BeanListHandler(BlStOepVsIncDTO.class));

		return list.toArray(new BlStOepVsIncDTO[0]);
	}

	/**
	 * 查询发票信息
	 * 
	 * @param patId
	 * @param dtB
	 * @param dtE
	 * @return
	 * @throws BizException
	 */
	private BlStOepVsIncDTO[] getStInc(String patId, FDateTime dtB, FDateTime dtE) throws BizException {
		StringBuilder sql = new StringBuilder();

		sql.append(" select");
		sql.append(" st.id_stoep,");
		sql.append(" st.code_st,");
		sql.append(" inc.id_incoep,");
		sql.append(" inc.incno,");
		sql.append(" st.dt_st,");
		sql.append(" inc.amt");
		sql.append(" from bl_st_oep st");
		sql.append(" inner join bl_inc_oep inc on st.id_stoep=inc.id_stoep ");
		sql.append(" inner join bl_pay_pat_oep pay on pay.id_paypatoep=st.id_paypatoep ");
		sql.append(" and st.pecode is not null");
		sql.append(" where dt_inc between ? and ?");
		sql.append(" and st.id_pat = ?");
		sql.append(" and st.fg_canc='N' and st.eu_direct=1 ");
		sql.append(" order by st.dt_st desc ");

		SqlParam param = new SqlParam();
		param.addParam(dtB);
		param.addParam(dtE);
		param.addParam(patId);

		List<BlStOepVsIncDTO> list = (List<BlStOepVsIncDTO>) new DAFacade().execQuery(sql.toString(), param,
				new BeanListHandler(BlStOepVsIncDTO.class));

		return list.toArray(new BlStOepVsIncDTO[0]);
	}
}
