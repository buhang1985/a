package iih.ei.een.s.bp.qry;

import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.bd.fc.que.d.QueDO;
import iih.bd.utils.BdEnvContextUtil;
import iih.ei.een.ws.bean.GetPatInfoBean;
import iih.pi.reg.pat.d.PatDO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 根据患者刷卡取患者信息
 * 
 * @author liubin
 *
 */
public class GetPatInfoBP {
	/**
	 * 身份证
	 */
	private static final String CARD_TYPE_IDCARD = "01";
	/**
	 * 医保卡
	 */
	private static final String CARD_TYPE_HPCARD = "02";
	/**
	 * 患者编码
	 */
	private static final String CARD_TYPE_PATCODE = "03";
	/**
	 * 就诊卡号
	 */
	private static final String CARD_TYPE_PATCARD = "04";
	
	
	/**
	 * 根据患者刷卡取患者信息
	 * 
	 * @param card_type
	 * @param card_no
	 * @return
	 * @throws BizException
	 */
	public GetPatInfoBean[] exec(String card_type, String card_no) throws BizException{
		//1.参数校验
		this.validate(card_type, card_no);
		//2.查询数据
		return this.geBeans(card_type, card_no);
		
	}
	/**
	 * 查询数据 
	 * 
	 * @param card_type
	 * @param card_no
	 * @return
	 * @throws BizException
	 */
	private GetPatInfoBean[] geBeans(String card_type, String card_no) throws BizException{
		SqlParam param = new SqlParam();
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append(" SELECT PAT.CODE AS CODE_PAT, ");
		sqlBuilder.append(" PAT.NAME AS NAME_PAT, ");
		sqlBuilder.append(" PAT.SD_SEX AS CODE_SEX, ");
		sqlBuilder.append(" PAT.DT_BIRTH AS DT_BIRTH, ");
		sqlBuilder.append(" (CASE WHEN PAT.SD_IDTP = '" + IPiDictCodeConst.SD_IDTP_IDENTITY +"' THEN PAT.ID_CODE ELSE '' END) AS NO_ID, ");
		sqlBuilder.append(" (SELECT TOP 1 PATHP.NO_HP FROM PI_PAT_HP PATHP WHERE PATHP.ID_PAT = PAT.ID_PAT AND PATHP.FG_ACT = 'Y' ");
		if(CARD_TYPE_HPCARD.equals(card_type)){
			sqlBuilder.append(" AND PATHP.NO_HP = ? ");
			param.addParam(card_no);
		}
		sqlBuilder.append(" ) AS NO_HP ");
		sqlBuilder.append(" FROM PI_PAT PAT ");
		sqlBuilder.append(" WHERE PAT.FG_INVD = 'N' ");
		String env = BdEnvContextUtil.processEnvContext(new PatDO(), "PAT");
		if(!StringUtil.isEmptyWithTrim(env)){
			sqlBuilder.append(" AND " + env);
		}
		if(CARD_TYPE_IDCARD.equals(card_type)){
			sqlBuilder.append(" AND PAT.SD_IDTP = ? AND PAT.ID_CODE = ? ");
			param.addParam(IPiDictCodeConst.SD_IDTP_IDENTITY);
			param.addParam(card_no);
		}
		if(CARD_TYPE_PATCODE.equals(card_type)){
			sqlBuilder.append(" AND PAT.CODE = ? ");
			param.addParam(card_no);
		}
		if(CARD_TYPE_PATCARD.equals(card_type)){
			sqlBuilder.append(" AND EXISTS (SELECT PATCARD.ID_PAT FROM PI_PAT_CARD PATCARD WHERE PATCARD.ID_PAT = PAT.ID_PAT AND PATCARD.SD_PATCARDTP = ? AND PATCARD.CODE = ? AND PATCARD.FG_ACT = 'Y') ");
			param.addParam(IPiDictCodeConst.SD_CARD_TYPE_TREATMENT);
			param.addParam(card_no);
		}
		if(CARD_TYPE_HPCARD.equals(card_type)){
			sqlBuilder.append(" AND EXISTS (SELECT HP.ID_PAT FROM PI_PAT_HP HP WHERE HP.ID_PAT = PAT.ID_PAT AND HP.NO_HP = ? AND HP.FG_ACT = 'Y') ");
			param.addParam(card_no);
		}
		
	    String sql = sqlBuilder.toString();
	    @SuppressWarnings("unchecked")
		List<GetPatInfoBean> list = (List<GetPatInfoBean>) new DAFacade().execQuery(sql, param, new BeanListHandler(GetPatInfoBean.class));
		return ListUtil.isEmpty(list)?null:list.toArray(new GetPatInfoBean[0]);
	}
	
	/**
	 * 参数校验
	 * 
	 * @param card_type
	 * @param card_no
	 * @throws BizException
	 */
	private void validate(String card_type, String card_no) throws BizException {
		if(StringUtil.isEmptyWithTrim(card_type))
			throw new BizException("卡类型不能为空！");
		if(!CARD_TYPE_IDCARD.equals(card_type)
				&& !CARD_TYPE_HPCARD.equals(card_type)
				&& !CARD_TYPE_PATCODE.equals(card_type)
				&& !CARD_TYPE_PATCARD.equals(card_type))
			throw new BizException("卡类型错误！");
		if(StringUtil.isEmptyWithTrim(card_no))
			throw new BizException("卡号不能为空！");
	}
}
