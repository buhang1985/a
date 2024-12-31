package iih.bl.st.ipbaddebt.bp;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.service.time.TimeService;
import xap.mw.core.service.time.impl.TimeServiceImpl;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import iih.bl.st.blstip.d.BlStIpDO;
import iih.bl.st.blstip.i.IBlstipCudService;
import iih.bl.st.blstip.i.IBlstipRService;
import iih.bl.st.dto.d.BlStIpBadDebtDTO;

/**
 * *坏账处理
 * @author weijia
 */
public class BlStIpBadPayBp {
	
	/**
	 * 查询欠款/坏账结算记录
	 * @param fg_baddebt （True:坏账记录；False:欠款结算记录）
	 * @author weijia
	 * */
	@SuppressWarnings("unchecked")
	public BlStIpBadDebtDTO[] getBadPayBlStIpInfo(FBoolean fg_baddebt) throws BizException
	{
		StringBuffer sql = new StringBuffer();
		sql.append("select s.id_stip,p.name as name_pat,p.code_amr_ip,b.dt_pay as dt_st_pay,(s.amt_ratio - b.amt) as amt,e.fg_ip ")
			 .append("from bl_st_ip s ")
			 .append("left join en_ent e on e.id_ent = s.id_ent ")
			 .append("left join pi_pat p on p.id_pat = e.id_pat ")
			 .append("left join bl_pay_pat_ip b on b.id_stip = s.id_stip ")
			 .append("where s.sd_stresult = '1' ")
			 .append("AND s.fg_arclear = 'N' ");
		if(fg_baddebt.booleanValue())
			sql.append("and s.fg_baddebt = 'Y' ");
		else
			sql.append("and s.fg_baddebt = 'N' ")
			    .append("And s.fg_canc = 'N' ");
		List<BlStIpBadDebtDTO> list = (List<BlStIpBadDebtDTO>)new DAFacade().execQuery(sql.toString(),null, new BeanListHandler(BlStIpBadDebtDTO.class));
		return list.toArray(new BlStIpBadDebtDTO[]{});
	}
	
	/**
	 * 坏账处理
	 * @param blStIpArr 坏账处理的结算记录
	 * @author weijia
	 * */
	public FBoolean setArrearsPayToBadPay(BlStIpBadDebtDTO[] blStIpArr) throws BizException
	{
		IBlstipRService strService = ServiceFinder.find(IBlstipRService.class);
		IBlstipCudService stcService = ServiceFinder.find(IBlstipCudService.class);
		TimeService timeService = new TimeServiceImpl();
		FDateTime dt_bg = timeService.getUFDateTime();
//		List<String> idStList = new ArrayList<String>();
//		for(BlStIpBadDebtDTO blStIpBadDebtDTO : blStIpArr){
//			idStList.add(blStIpBadDebtDTO.getId_stip());
//		}
//		BlStIpDO[] blStIpDOArr = strService.findByBIds(idStList.toArray(new String[]{}), FBoolean.FALSE);
//		if(blStIpDOArr == null || blStIpDOArr.length == 0){
//			throw new BizException("");
//		}
		List<BlStIpDO> blStIpList = new ArrayList<BlStIpDO>();
		for(BlStIpBadDebtDTO blStIpBadDebtDTO : blStIpArr){
			StringBuffer sql = new StringBuffer();
			sql.append("sd_stresult = '1' and fg_arclear = 'N' and fg_baddebt = 'N' and id_stip = '").append(blStIpBadDebtDTO.getId_stip()).append("'");
			BlStIpDO[] blStIpDOArr = strService.find(sql.toString(), null, FBoolean.FALSE);
			if(blStIpDOArr == null || blStIpDOArr.length == 0){
				throw new BizException("结算"+blStIpBadDebtDTO.getId_stip()+"不存在");
			}
			BlStIpDO blStIpDO = blStIpDOArr[0];
			blStIpDO.setFg_baddebt(FBoolean.TRUE);
			blStIpDO.setDt_baddebt(dt_bg);
			blStIpDO.setId_emp_baddebt(Context.get().getStuffId());
			blStIpDO.setStatus(DOStatus.UPDATED);
			blStIpList.add(blStIpDO);
		}
		stcService.save(blStIpList.toArray(new BlStIpDO[]{}));
		return FBoolean.TRUE;
	}
}
