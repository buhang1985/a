package iih.en.pv.s.bp.ip.qry;

import iih.en.comm.validator.EnValidator;
import iih.en.pv.inpatient.d.NewbornDO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 获取新生儿信息
 * 
 * @author liubin
 * @version ly 2018/10/09 添加母亲id判断
 *
 */
public class GetMomEntInfoBP {
	/**
	 * 获取新生儿信息
	 * 
	 * @param entId 就诊id
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public NewbornDO getNewbornDO(String entId) throws BizException {
		if (EnValidator.isEmpty(entId))
			return null;
		List<NewbornDO> list = (List<NewbornDO>) new DAFacade()
				.findByAttrValString(NewbornDO.class, NewbornDO.ID_ENT_BB,
						entId, null);
		if (!EnValidator.isEmpty(list)){
			
			if(!EnValidator.isEmpty(list.get(0).getId_ent_mom())){
				return list.get(0);
			}
		}
		return null;
	}
}
