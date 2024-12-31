package iih.en.pv.s.bp.ip.ws;

import iih.en.comm.util.EnSqlUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.out.ws.bean.EntStateBean;
import iih.en.pv.out.ws.bean.IpDetailInfoBean;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 查找住院就诊状况信息
 * 
 * @author tang.ht
 *
 */
public class GetIpEntStateInfoBP extends AbstractGetIpDetailInfoBP<EntStateBean> {

	@Override
	protected Set<IpDetailInfoBean<EntStateBean>> assemlyDetail(String[] entIds) throws BizException {
		if (EnValidator.isEmpty(entIds))
			return null;
		List<IpDetailInfoBean<EntStateBean>> entBaseInfo = super.getIpDetailInfoBeanInfo(entIds);
		List<EntStateBean> stateInfo = this.getStateInfo(entIds);
		
		Set<IpDetailInfoBean<EntStateBean>> set = this.getSet(entBaseInfo, stateInfo);
		
		
		return set;
	}

	/**
	 * 查询就诊状况详细信息
	 * 
	 * @param list
	 * @param entIds
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private List<EntStateBean> getStateInfo(String[] entIds) throws BizException {
		if (EnValidator.isEmpty(entIds))
			return null;
		SqlParam param = new SqlParam();
		StringBuilder statesql = new StringBuilder();		
		statesql.append(" SELECT ");
		statesql.append(" STATE.ID_ENT,");//患者就诊id
		statesql.append(" STATE.SD_ENSTATETP AS SD_ENSTATETP ,");// 就诊状况类型编码
		statesql.append(" DOC.NAME AS NAME_ENSTATETP ,");// 就诊状况类型名称
		statesql.append(" STATE.VAL AS VAL ,");// 就诊状况值
		statesql.append(" BE_STATE.NAME AS NAME,");//就诊状况值名称
		statesql.append(" STATE.DT_OCC AS DT_OCC ");// 发生时间
		statesql.append(" FROM EN_ENT_STATE STATE ");//
		statesql.append(" INNER JOIN BD_UDIDOC DOC ON DOC.ID_UDIDOC = STATE.ID_ENSTATETP ");
		statesql.append("  INNER JOIN BD_EN_STATE BE_STATE ON STATE.ID_ENSTATETP = BE_STATE.ID_ENSTATETP AND BE_STATE.VAL = STATE.VAL" );
		statesql.append(" WHERE ").append(EnSqlUtils.getInSqlByIds("STATE.ID_ENT", entIds));
		List<EntStateBean> results = (List<EntStateBean>) new DAFacade().execQuery(statesql.toString(), param, new BeanListHandler(EntStateBean.class));
		return results;
	}
	
	/**
     * 组装返回值数据
     * 
     * @param 
     * @return
     * @throws BizException
     */
	private Set<IpDetailInfoBean<EntStateBean>> getSet(List<IpDetailInfoBean<EntStateBean>> ipDetailInfoBean, List<EntStateBean> t) throws BizException {
		Set<IpDetailInfoBean<EntStateBean>> sBeans = new HashSet<>();
		if(!EnValidator.isEmpty(ipDetailInfoBean)){
			for (IpDetailInfoBean<EntStateBean> ipDetailInfoBean2 : ipDetailInfoBean) {
				Set<EntStateBean> sEntStateBeans = new HashSet<>();
				if(!EnValidator.isEmpty(t)){
					for (EntStateBean entStateBean:t) {
						if(ipDetailInfoBean2.getId_ent().equals(entStateBean.getId_ent())){
							sEntStateBeans.add(entStateBean);
						}
					}
				}
				ipDetailInfoBean2.setItem(sEntStateBeans);
				sBeans.add(ipDetailInfoBean2);
			}
		}
		return sBeans;
	}

}
