package iih.en.pv.s.bp.ip.ws;

import iih.en.comm.util.EnSqlUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.out.ws.bean.EntContBean;
import iih.en.pv.out.ws.bean.IpDetailInfoBean;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 查找住院联系人信息
 * 
 * @author tang.ht
 *
 */
public class GetIpEntContInfoBP extends AbstractGetIpDetailInfoBP<EntContBean> {

	@Override
	protected Set<IpDetailInfoBean<EntContBean>> assemlyDetail(String[] entIds)
			throws BizException {
		List<IpDetailInfoBean<EntContBean>> entBaseInfo = super.getIpDetailInfoBeanInfo(entIds);
		List<EntContBean> entContInfo = this.getEntContInfo(entIds);
		Set<IpDetailInfoBean<EntContBean>> set = this.getSet(entBaseInfo, entContInfo);
		return set;
	}

	/**
	 * 查询就诊床位详细信息
	 * 
	 * @param list
	 * @param entIds
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private List<EntContBean> getEntContInfo(String[] entIds) throws BizException {
		if(EnValidator.isEmpty(entIds))
    		return null;
    	StringBuilder entcontsql = new StringBuilder();
    	SqlParam param = new SqlParam();
    	entcontsql.append(" SELECT ");
    	entcontsql.append(" CONT.ID_ENT,");//就诊id
    	entcontsql.append(" CONT.SORTNO AS SORTNO,");//编号
    	entcontsql.append(" CONT.EU_ENTCONTTP AS EU_ENTCONTTP,");//就诊联系人类型
    	entcontsql.append(" CONT.SD_CONTTP AS SD_CONTTP,");//联系人类型编码
    	entcontsql.append(" DOC.NAME AS NAME_CONTTP,");//联系人类型名称
    	entcontsql.append(" CONT.NAME AS NAME,");//联系人名称
    	entcontsql.append(" CONT.CONTTEL AS CONTTEL,");//联系人电话
    	entcontsql.append(" CONT.CONTADDR AS CONTADDR,");//联系人地址
    	entcontsql.append(" CONT.ZIP AS ZIP,");//联系人邮编
    	entcontsql.append(" CONT.SD_IDTP AS SD_IDTP,");//证件类型
    	entcontsql.append(" DOC.NAME AS NAME_IDTP,");//证件类型名称
    	entcontsql.append(" CONT.IDCODE AS IDCODE,");//证件号
    	entcontsql.append(" CONT.PYCODE AS PYCODE,");//拼音码
    	entcontsql.append(" CONT.WBCODE AS WBCODE");//五笔码
    	entcontsql.append(" FROM EN_ENT_CONT CONT ");
    	entcontsql.append(" LEFT JOIN BD_UDIDOC DOC ON CONT.ID_CONTTP = DOC.ID_UDIDOC ");
    	entcontsql.append(" AND CONT.ID_IDTP = DOC.ID_UDIDOC");
    	entcontsql.append(" WHERE ").append(EnSqlUtils.getInSqlByIds("CONT.ID_ENT", entIds));
		List<EntContBean> results = (List<EntContBean>) new DAFacade().execQuery(entcontsql.toString(), param, new BeanListHandler(EntContBean.class));
        return results;

	}
	
	/**
     * 组装返回值数据
     * 
     * @param 
     * @return
     * @throws BizException
     */
	private Set<IpDetailInfoBean<EntContBean>> getSet(List<IpDetailInfoBean<EntContBean>> ipDetailInfoBean, List<EntContBean> t) throws BizException {
		Set<IpDetailInfoBean<EntContBean>> sBeans = new HashSet<>();
		if(!EnValidator.isEmpty(ipDetailInfoBean)){
			for (IpDetailInfoBean<EntContBean> ipDetailInfoBean2 : ipDetailInfoBean) {
				Set<EntContBean> sEntContBeans = new HashSet<>();
				if(!EnValidator.isEmpty(t)){
					for (EntContBean entContBean:t) {
						if(ipDetailInfoBean2.getId_ent().equals(entContBean.getId_ent())){
							sEntContBeans.add(entContBean);
						}
					}
				}
				ipDetailInfoBean2.setItem(sEntContBeans);
				sBeans.add(ipDetailInfoBean2);
			}
		}
		return sBeans;

	}
}
