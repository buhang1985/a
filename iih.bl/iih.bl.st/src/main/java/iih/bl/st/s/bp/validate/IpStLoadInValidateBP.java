package iih.bl.st.s.bp.validate;

import iih.bd.base.exception.ArgumentNullException;
import iih.bl.params.BlParams;
import iih.en.pv.i.IEnOutQryService;
import iih.en.pv.inpatient.d.NewbornDO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;

/**
 * 住院结算调入前校验
 * @author ly 2018/10/03
 *
 */
public class IpStLoadInValidateBP {

	/**
	 * 住院结算调入前校验
	 * @param entId 就诊id
	 * @return 校验错误信息，为空时表示校验成功
	 * @throws BizException
	 */
	public String exec(String entId) throws BizException {
		
		if (StringUtil.isEmpty(entId)) {
			throw new ArgumentNullException("住院结算调入前校验", "就诊id");
		}
		
		//目前只校验母婴结算,之后把前端所有的校验挪到后台 TODO
		String msg = null;
		DAFacade daf = new DAFacade();
		PatiVisitDO enDO = (PatiVisitDO)daf.findByPK(PatiVisitDO.class, entId);
		if(enDO == null){
			throw new BizException("未查询到就诊信息，就诊id:" + entId);
		}
		
		// 母婴结算校验
		if(FBoolean.FALSE.equals(enDO.getFg_ip())){
			msg = this.checkBabySt(entId);
			if(!StringUtil.isEmpty(msg))
				return msg;
		}
		
		return null;
	}
	
	/**
	 * 母婴结算校验
	 * 母婴分开结算时，需要先结算婴儿
	 * @param entId
	 * @return
	 */
	private String checkBabySt(String entId) throws BizException{
	
		if(FBoolean.TRUE.equals(BlParams.BLSTIP0005()))
			return null;
		
		IEnOutQryService enService = ServiceFinder.find(IEnOutQryService.class);
		NewbornDO[] nbDos = enService.getNewbornsByMomEntId(entId);
		if(ArrayUtil.isEmpty(nbDos))
			return null;
		
		DAFacade daf = new DAFacade();
		
		//费用校验
		String sql = "select count(1) from bl_cg_ip where id_ent = '%s'";
		//是否做过出院收付款
		String sql2 = "select count(1) from bl_st_ip where id_ent = '%s' and fg_canc = 'N' and eu_sttp = '10' and eu_direct = 1 and fg_pay = 'Y' ";
		
		
		for (NewbornDO newbornDO : nbDos) {
			
			Integer feeCount = (Integer)daf.execQuery(String.format(sql, newbornDO.getId_ent_bb()), new ColumnHandler());
			if(feeCount == 0)
				continue;
			
			Integer count = (Integer) daf.execQuery(String.format(
					sql2, newbornDO.getId_ent_bb()), new ColumnHandler());
			
			if(count == 0){
				return String.format("婴儿%s未做出院结算收付款，不能对母亲进行出院结算操作", newbornDO.getName_bb());
			}
		}
		
		return null;
	}
}
