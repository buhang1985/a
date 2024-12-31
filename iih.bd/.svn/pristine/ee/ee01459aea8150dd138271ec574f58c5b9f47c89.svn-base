package iih.bd.fc.que.bp;

import java.util.List;

import iih.bd.fc.que.d.QueDO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 队列查询BP
 * @author yankan
 *
 */
public class QueQryBP {
	/**
	 * 获取排班队列
	 * @param scResId 排班资源id
	 * @param depId 出诊科室id
	 * @param quebenId 分诊台id
	 * @param queTp 队列类型
	 * @return
	 * @throws BizException
	 */
	public QueDO getQue(String scResId,String depId, String quebenId, String queTp) throws BizException{
		StringBuilder whereBuilder = new StringBuilder();
		SqlParam param = new SqlParam();
		whereBuilder.append(" fg_active = 'Y' and id_scres = ? and id_dep = ? ");
		param.addParam(scResId);
		param.addParam(depId);
		if(!StringUtil.isEmptyWithTrim(quebenId)){
			whereBuilder.append(" and id_queben = ? ");
			param.addParam(quebenId);
		}
		if(!StringUtil.isEmptyWithTrim(queTp)){
			whereBuilder.append(" and sd_quetp = ? ");
			param.addParam(queTp);
		}
		List<QueDO> list = (List<QueDO>) new DAFacade().findByCond(QueDO.class, whereBuilder.toString(), param);
		QueDO queDO = null;
		if(!ListUtil.isEmpty(list)){
			for (QueDO que : list) {
				//如果有二级队列，取父队列
				if(StringUtil.isEmptyWithTrim(que.getId_parent())){
					queDO=que;
					break;
				}
			}
		}
		return queDO;
	}
}
