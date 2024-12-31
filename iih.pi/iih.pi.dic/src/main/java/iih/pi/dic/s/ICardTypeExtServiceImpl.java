package iih.pi.dic.s;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import iih.pi.dic.cardtype.d.CardDTO;
import iih.pi.dic.i.ICardTypeExtService;
import iih.pi.reg.pat.i.IPatiMDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FDate;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

@SuppressWarnings("deprecation")
@Service(serviceInterfaces = { ICardTypeExtService.class }, binding = Binding.JSONRPC)
public class ICardTypeExtServiceImpl implements ICardTypeExtService {

	@Override
	public String QueryId_pat(String CardNum) throws BizException {

		String CardType = "0001AA1000000006JWF4";

		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(CardType);
		sqlParam.addParam(CardNum);

		String SqlStr = "select "
				+ " patcard.id_patcard,"
				+ " patcard.id_pat,"
				+ " cardtype.id_cardtp as Id_patcardtp,"
				+ " cardtype.name as patcardtpname,"
				+ " cardtype.code as patcardtpcode,"
				+ " cardtnature.id_udidoc as id_cardtp,"
				+ " cardtnature.name as cardtpname,"
				+ " patcard.code,"
				+ " patcard.fg_def,"
				+ " patcard.dt_b,"
				+ " patcard.dt_e,"
				+ " patcard.fg_act,"
				+ " card.eu_cardsu as cardsuname"
				+ " from PI_PAT_CARD patcard"
				+ " inner join PI_PAT_CARDTP cardtype on patcard.id_patcardtp=cardtype.id_cardtp"
				+ " left join bd_udidoc cardtnature on cardtype.id_patcardtp=cardtnature.id_udidoc"
				+ " left join pi_card card on card.id_card=patcard.id_card "
				+ " where cardtype.id_cardtp=? and patcard.code=? ";
		List<CardDTO> reDTO = (List<CardDTO>) new DAFacade().execQuery(SqlStr,
				sqlParam, new BeanListHandler(CardDTO.class));

		if (reDTO != null && reDTO.size() > 0) {
			CardDTO CardInfo = reDTO.get(0);

			switch (CardInfo.getCardsuname()) {
			case "0":// 已挂失
				throw new BizException("该卡为无效空白卡！");
			case "2":// 已退回
				throw new BizException("该卡片已挂失！");
			case "3":// 已退回
					throw new BizException("该卡片已注销！");
			default:
				break;
			}

			if (CardInfo.getDt_b() != null) {
				if (CardInfo.getDt_e() == null) {
					/* 有效结束日期为空时设置临时有效日期为明天：结束日期永远有效 */
					Calendar rightNow = Calendar.getInstance();
					rightNow.setTime(new Date());
					rightNow.add(Calendar.DAY_OF_YEAR, 1);
					CardInfo.setDt_e(new FDate(rightNow.getTime()));
				}

				if (new FDate().compareTo(CardInfo.getDt_b()) > 0
						&& CardInfo.getDt_e().compareTo(new FDate()) > 0) {
					IPatiMDORService PatService = ServiceFinder
							.find(IPatiMDORService.class);
					return CardInfo.getId_pat();
				} else {
					throw new BizException("该卡片不在有效使用期内(" + CardInfo.getDt_b()
							+ "~" + CardInfo.getDt_e() + ")！");
				}
			}
			return "";
			// else
			// {
			// throw new BizException("该卡片未指定有效开始日期！");
			// }

		} else {
			throw new BizException("在系统中未找到该卡片的注册信息！");
		}
	}
}
