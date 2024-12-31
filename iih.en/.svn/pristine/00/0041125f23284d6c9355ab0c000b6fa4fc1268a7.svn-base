package iih.en.pv.s.bp.ip.ws;

import iih.en.comm.util.EnSqlUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.out.ws.bean.EntHpBean;
import iih.en.pv.out.ws.bean.IpDetailInfoBean;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 查找住院医保信息
 * 
 * @author liubin
 *
 */
public class GetIpEntHpInfoBP extends AbstractGetIpDetailInfoBP<EntHpBean> {

	@Override
	protected Set<IpDetailInfoBean<EntHpBean>> assemlyDetail(String[] entIds)
			throws BizException {
		List<IpDetailInfoBean<EntHpBean>> list = this.getIpDetailInfoBeanInfo(entIds);
		List<EntHpBean> entHpBeans = this.getEntHpBeanSql(entIds);
		return this.getSet(list, entHpBeans);
	}
	
	/**
     * 查询医保详细信息
     * 
     * @param list
     * @param entIds
     * @throws BizException
     */
    @SuppressWarnings("unchecked")
	private List<EntHpBean> getEntHpBeanSql(String[] entIds) throws BizException {
    	if(EnValidator.isEmpty(entIds))
    		return null;
    	StringBuilder sqlSBuilder = new StringBuilder();
    	SqlParam param = new SqlParam();
        sqlSBuilder.append(" SELECT ENTHP.ID_ENT AS ID_ENT,");//就诊iD
        sqlSBuilder.append(" ENTHP.SORTNO AS SORTNO,");//医保编号
        sqlSBuilder.append(" UDIDOC.CODE AS SD_HPTP ,");//医保类型
        sqlSBuilder.append(" HP.CODE AS CODE_HP ,");//医保计划编码
        sqlSBuilder.append(" HP.NAME AS NAME_HP ,");//医保计划名称
        sqlSBuilder.append(" ENTHP.NO_HP,");//医保号
        sqlSBuilder.append(" ENTHP.PERSONNO,");//个人编码
        sqlSBuilder.append(" ENTHP.FG_MAJ,");//主医保标识
        sqlSBuilder.append(" ENTHP.FG_HP_CARD,");//持卡结算标识
        sqlSBuilder.append(" ENTHP.FG_FUNDPAY,");//医保基金支付标识
        sqlSBuilder.append(" ENTHP.FG_HPSPCL,");//特病标识
        sqlSBuilder.append(" ENTHP.CODE_HPKIND ,");//险种编码
        sqlSBuilder.append(" ENTHP.CODE_HPPATCA,");//医保身份编码
        sqlSBuilder.append(" ENTHP.CODE_HPAREA,");//医保统筹区
        sqlSBuilder.append(" ENT.CODE_HPMEDKIND AS CODE_HPMEDKIND");//疑似医疗类别编码
        
        sqlSBuilder.append(" FROM EN_ENT_HP ENTHP");
        sqlSBuilder.append(" INNER JOIN BD_HP HP ON HP.ID_HP = ENTHP.ID_HP ");
        sqlSBuilder.append(" LEFT JOIN BD_UDIDOC UDIDOC ON UDIDOC.ID_UDIDOC = HP.ID_HPTP  ");
        sqlSBuilder.append(" LEFT JOIN EN_ENT ENT  ON ENT.ID_ENT = ENTHP.ID_ENT  ");
        sqlSBuilder.append(" WHERE ").append(EnSqlUtils.getInSqlByIds(" ENTHP.ID_ENT ", entIds));
        List<EntHpBean> results = (List<EntHpBean>) new DAFacade().execQuery(sqlSBuilder.toString(), param, new BeanListHandler(EntHpBean.class));
        return results;
    }


	
	private Set<IpDetailInfoBean<EntHpBean>> getSet(List<IpDetailInfoBean<EntHpBean>> ipDetailInfoBean, List<EntHpBean> t) {
		Set<IpDetailInfoBean<EntHpBean>> sBeans = new HashSet<>();
		if(!EnValidator.isEmpty(ipDetailInfoBean)){
			for (IpDetailInfoBean<EntHpBean> ipDetailInfoBean2 : ipDetailInfoBean) {
				Set<EntHpBean> sEntDiBeans = new HashSet<>();
				if(!EnValidator.isEmpty(t)){
					for (EntHpBean entdiBean:t) {
						if(ipDetailInfoBean2.getId_ent().equals(entdiBean.getId_ent())){
							sEntDiBeans.add(entdiBean);
						}
					}
				}
				ipDetailInfoBean2.setItem(sEntDiBeans);
				sBeans.add(ipDetailInfoBean2);
			}
		}

		return sBeans;
	}

	

}
