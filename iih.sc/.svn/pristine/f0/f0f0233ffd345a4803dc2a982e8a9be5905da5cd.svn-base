package iih.sc.sch.s.bp;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.comm.ScAppUtils;
import iih.sc.comm.ScParamUtils;
import iih.sc.sch.reg.dto.d.RegResDTO;
import iih.sc.sch.reg.dto.d.ResQrySchemeDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 根据排班计划获取推荐号源
 * @author wjy
 *
 */
public class GetSuggestResByPlBP {
	/**
	 * 根据排班计划获取推荐号源
	 * @param plId 排班计划ID
	 * @return
	 * @throws BizException
	 */
	public RegResDTO[] exec(String plId) throws BizException{
		GetResBySchmBP getResBySchmBP = new GetResBySchmBP();
		ResQrySchemeDTO qryScheme = new ResQrySchemeDTO();
		qryScheme.setSd_scchltp(IScDictCodeConst.SD_SCCHLTP_HOSPITAL_WINDOW);
		qryScheme.setId_pl(plId);//排班计划ID		
		qryScheme.setD_begin(ScAppUtils.getServerDateTime().getDate());//开始日期，为今天
		qryScheme.setD_end(new GetMaxAvlRegDateBP().exec(IScDictCodeConst.SD_SCCHLTP_HOSPITAL_WINDOW));//结束日期，最大挂号日期
		qryScheme.setFg_remain(FBoolean.TRUE);//过滤无剩余号源资源		
		qryScheme.setRows(ScParamUtils.getSuggestNum());//推荐号源数
		qryScheme.setOrderstr("D_SCH, LOT.SORTNO");//按日期排序，午别进行排序
		qryScheme.setFg_quan(FBoolean.TRUE);//加载号源
		qryScheme.setFg_suggest(FBoolean.TRUE);
		return getResBySchmBP.exec(qryScheme);
	}
}
