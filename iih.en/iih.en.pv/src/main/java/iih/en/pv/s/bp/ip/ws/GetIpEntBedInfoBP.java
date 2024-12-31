package iih.en.pv.s.bp.ip.ws;

import iih.en.comm.util.EnSqlUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.out.ws.bean.EntBedBean;
import iih.en.pv.out.ws.bean.IpDetailInfoBean;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 查找住院床位信息
 * 
 * @author tang.ht
 *
 */
public class GetIpEntBedInfoBP extends AbstractGetIpDetailInfoBP<EntBedBean> {

	@Override
	protected Set<IpDetailInfoBean<EntBedBean>> assemlyDetail(String[] entIds) throws BizException {
		List<IpDetailInfoBean<EntBedBean>> entBaseInfo = super.getIpDetailInfoBeanInfo(entIds);
		List<EntBedBean> entBedInfo = this.getEntBedInfo(entIds);
		Set<IpDetailInfoBean<EntBedBean>> set = this.getSet(entBaseInfo, entBedInfo);
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
	private List<EntBedBean> getEntBedInfo(String[] entIds) throws BizException {
		if(EnValidator.isEmpty(entIds))
    		return null;
		SqlParam param = new SqlParam();
    	StringBuilder entbedsql = new StringBuilder();
    	entbedsql.append(" SELECT ");
    	//entbedsql.append(" ");//编号
    	entbedsql.append(" BED.ID_ENT,");//就诊id
    	entbedsql.append(" BB.CODE AS CODE_BED,");//床位编码
    	entbedsql.append(" BB.NAME AS NAME_BED, ");//床位名称
    	entbedsql.append(" DEP.CODE AS CODE_DEP_NUR,");//所属病区编码
    	entbedsql.append(" DEP.NAME AS NAME_DEP_NUR,");//所属病区名称
    	entbedsql.append(" SD_USETYPE , ");//占用类型编码
    	entbedsql.append(" DOC.NAME AS NAME_USETYPE, ");//占用类型名称
    	entbedsql.append(" BED.DT_B AS DT_B, ");//开始时间
    	entbedsql.append(" BED.DT_E AS DT_E, ");//结束时间
    	entbedsql.append(" BED.DT_CHG_BILL AS DT_CHG_BILL");//最近收费时间
    	entbedsql.append(" FROM EN_ENT_BED BED ");
    	entbedsql.append(" INNER JOIN BD_DEP DEP ON DEP.ID_DEP = BED.ID_DEP_WRD ");
    	entbedsql.append(" INNER JOIN BD_BED BB ON BB.ID_BED = BED.ID_BED ");
    	entbedsql.append(" LEFT JOIN BD_UDIDOC DOC ON DOC.ID_UDIDOC = BED.ID_USETYPE ");
    	entbedsql.append(" WHERE ").append(EnSqlUtils.getInSqlByIds(" BED.ID_ENT ", entIds));
		List<EntBedBean> results = (List<EntBedBean>) new DAFacade().execQuery(entbedsql.toString(), param, new BeanListHandler(EntBedBean.class));
        return results;

	}
	
	/**
     * 组装返回值数据
     * 
     * @param 
     * @return
     * @throws BizException
     */
	private Set<IpDetailInfoBean<EntBedBean>> getSet(List<IpDetailInfoBean<EntBedBean>> ipDetailInfoBean, List<EntBedBean> t) throws BizException {
		Set<IpDetailInfoBean<EntBedBean>> sBeans = new HashSet<>();
		if(!EnValidator.isEmpty(ipDetailInfoBean)){
			for (IpDetailInfoBean<EntBedBean> ipDetailInfoBean2 : ipDetailInfoBean) {
				Set<EntBedBean> sEntBedBeans = new HashSet<>();
				if(!EnValidator.isEmpty(t)){
					for (EntBedBean entBedBean:t) {
						if(ipDetailInfoBean2.getId_ent().equals(entBedBean.getId_ent())){
							sEntBedBeans.add(entBedBean);
						}
					}
				}
				ipDetailInfoBean2.setItem(sEntBedBeans);
				sBeans.add(ipDetailInfoBean2);
			}
		}
		return sBeans;
	}

}
