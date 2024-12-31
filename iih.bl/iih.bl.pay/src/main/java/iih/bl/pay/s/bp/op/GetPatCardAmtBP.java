package iih.bl.pay.s.bp.op;

import java.util.ArrayList;
import java.util.List;

import iih.bd.base.utils.SqlUtils;
import iih.bl.pay.dto.blspclpatamt.d.BlSpclPatAmtDTO;
import iih.pi.dic.cardtype.d.CardCgMdEnum;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 患者卡押金缴费查询
 * @author ly 2018/05/21
 *
 */
public class GetPatCardAmtBP {
	
	/**
	 * 患者卡押金缴费查询
	 * @param patcardIds 患者卡id
	 * @param euCardCgMod 卡计费类型
	 * @return
	 * @throws BizException
	 */
	public BlSpclPatAmtDTO[] exec(String[] patcardIds,String euCardCgMod) throws BizException{
		
		if(ArrayUtil.isEmpty(patcardIds) || StringUtil.isEmpty(euCardCgMod))
			return null;
		
		switch (euCardCgMod) {
		case  CardCgMdEnum.COST:
			return this.getCardSrvCgInfo(patcardIds);
		case  CardCgMdEnum.DEPOSIT:
			return new GetSpclPatAmtBP().exec(patcardIds);
		default:
			return null;
		}
	}
	
	/**
	 * 查询患者卡费用记录
	 * @param patcardIds
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private BlSpclPatAmtDTO[] getCardSrvCgInfo(String[] patcardIds)throws BizException{

		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("select card.id_patcard id_src,itmoep.amt_ratio amt from ");
		sqlSb.append("pi_pat_card card ");
		//sqlSb.append("inner join pi_pat_cardtp cardtp ");
		//sqlSb.append("on card.id_patcardtp = cardtp.id_cardtp ");
		sqlSb.append("inner join bl_cg_itm_oep itmoep ");
		sqlSb.append("on card.id_pat = itmoep.id_pat ");
		//sqlSb.append("and cardtp.id_srv = itmoep.id_srv ");
		sqlSb.append("and itmoep.fg_refund = 'N' ");
		sqlSb.append("and card.id_patcard = itmoep.note ");//备注字段存id
		sqlSb.append("inner join bl_cg_oep oep ");
		sqlSb.append("on itmoep.id_cgoep = oep.id_cgoep ");
		sqlSb.append("and oep.eu_direct = 1 ");
		sqlSb.append("where " + SqlUtils.getInSqlByIds("card.id_patcard", patcardIds));

		DAFacade daf = new DAFacade();
		List<BlSpclPatAmtDTO> cardCgList = (List<BlSpclPatAmtDTO>) daf.execQuery(sqlSb.toString(), 
				new BeanListHandler(BlSpclPatAmtDTO.class));

		List<BlSpclPatAmtDTO> rltList = new ArrayList<BlSpclPatAmtDTO>();
		for (String srcId : patcardIds) {

			BlSpclPatAmtDTO dto = new BlSpclPatAmtDTO();
			dto.setId_src(srcId);
			dto.setFg_pay(FBoolean.FALSE);
			rltList.add(dto);
			if (ListUtil.isEmpty(cardCgList)) {
				continue;
			}

			for (BlSpclPatAmtDTO cardCgRlt : cardCgList) {
				if (srcId.equals(cardCgRlt.getId_src())) {
					dto.setAmt(cardCgRlt.getAmt());
					dto.setFg_pay(FBoolean.TRUE);
					break;
				}
			}
		}

		return rltList.toArray(new BlSpclPatAmtDTO[0]);
	}
}
